package application;

import java.io.IOException;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lpcon.MySQLCon;
import accounts.accountsCreateController;
import accounts.accountsLoginController;


public class profileCreateController extends accountsCreateController {
	public int newProfileID = getNewID();

	@FXML
	private Button btn_pcBack;
	
    @FXML
    private TextField tb_profileName;

    @FXML
    private Button button_createProfile;

    @FXML
    private Text lb_errorMessage;
    
    @FXML
    private PasswordField tb_profilePIN;

    @FXML
    private PasswordField tb_profilePINcheck;

    public static boolean charCheck(PasswordField tb_profilePIN) {
    	String _pin;
    	int check = 0;
    	_pin = tb_profilePIN.getText().toString();
    	for(int i = 0; i < _pin.length(); i++) {
    		if(Character.isDigit(_pin.charAt(i))) {
    			check++;
    		}
    	}
    	if(check == 6) {
    		return true;
    	}
    	return false;
    }    
    
    public static boolean matchCheckPIN(PasswordField tb_profilePIN, PasswordField tb_profilePINcheck) {
		String pass1 = tb_profilePIN.getText().toString();
		String pass2 = tb_profilePINcheck.getText().toString();
		int check = 0;
		for(int i = 0; i < pass1.length(); i++) {
			if(pass1.charAt(i) == (pass2.charAt(i))) {
				check++;
			}
		}
		if(check == 6) {
			return true;
		}
		return false;
    	}  	
    
    @FXML
    void createProfile(ActionEvent event) throws Exception {
    	if(tb_profilePIN.getLength() == 6 && matchCheckPIN(tb_profilePIN, tb_profilePINcheck) && charCheck(tb_profilePIN) && newProfileID != -1) {
        	inputProfileInfo(newProfileID);
        	accounts.accountsLoginController.localProfiles = accounts.accountsLoginController.loadProfiles();

        	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileSelection.fxml"));
        	Scene profileCreateScene = new Scene(createProfileView);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        	window.setScene(profileCreateScene);
        	window.show();
    	}
    	else if (tb_profilePIN.getLength() != 6){
    		lb_errorMessage.setText("PIN must be 6 digits.");
    	}
    	else if(!matchCheck(tb_profilePIN, tb_profilePINcheck)) {
    		lb_errorMessage.setText("PINs do not match.");

    	}
    	else if (!charCheck(tb_profilePIN)) {
    		lb_errorMessage.setText("PIN can only contain numbers.");
    	}
    	else {
    		lb_errorMessage.setText("There was an error. Please try again later.");
    	}
    }
    
    
    
    @FXML
    void pageBack(ActionEvent event) throws IOException {
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileSelection.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }
    
    
    private static void removeCreateButton(Button btn) {
    	btn.setDisable(true);
    	btn.setText("Disabled");
    }
    
    private static void setLoginButton(Button btn) {
    	btn.setOpacity(100.0);
    	btn.setDisable(false);
    	btn.setText("login");
    }
    
 
    
    public void inputProfileInfo(int newProfileID) throws Exception {
    	int pID = newProfileID;
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String name = tb_profileName.getText().toString();
    	String pass = tb_profilePIN.getText().toString();
    	
    	pass = encode(pass); //Encryption for DB Security
    	
    	String insert = "insert into tableprofile "
    			+ "(accountID, profileID, profileName, profilePIN)"
    			+ " VALUES ('"+aID+"','"+pID+"','"+name+"','"+pass+"');";
    	lpcon.MySQLCon.sqlInsert(insert);
    }
    
    public int getNewID() {
    	String[] localP = lpcon.MySQLCon.accountOrderedProfiles(accounts.accountsLoginController.accountIDNum);
    	int newID = -1;
    	for(int i = 0; i < 8; i++) {
    		if(localP[i] == null) {
    			newID = i;
    			return newID;
    		}
    	}
    	return newID;
    }

}