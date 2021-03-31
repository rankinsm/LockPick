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
import accounts.accountsLoginController;


public class profileCreateController extends profileHomeController{

	public static int pNum = profileNumber;

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
    
    public static boolean matchCheck(PasswordField tb_profilePIN, PasswordField tb_profilePINcheck) {
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
    void createProfile(ActionEvent event) throws IOException {
    	if(tb_profilePIN.getLength() == 6 && matchCheck(tb_profilePIN, tb_profilePINcheck) && charCheck(tb_profilePIN)) {
        	inputProfileInfo();

        	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileHome.fxml"));
        	Scene profileCreateScene = new Scene(createProfileView);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	removeCreateButton(selectCreateButton(profileNumber));
        	setLoginButton(selectLoginButton(profileNumber));
/*	        	button_pCreateChange0.setDisable(true);
	        	button_pCreateChange0.setText("Disabled");
	        	button_pLoginChange0.setOpacity(100.0);
	        	button_pLoginChange0.setDisable(false);
	        	button_pLoginChange0.setText(pNames[0]);
*/        	//renameButton(profileNumber);
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
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileHome.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }
    
    
    public static void removeCreateButton(Button btn) {
    	btn.setDisable(true);
    	btn.setText("Disabled");
    }
    
    public static void setLoginButton(Button btn) {
    	btn.setOpacity(100.0);
    	btn.setDisable(false);
    	btn.setText("login");
    }
    
    public static Button selectCreateButton(int profileNumber) {
    	switch(profileNumber) {
    	case 0:
    		return button_pCreateChange0;
    	case 1:
    		return button_pCreateChange1;
    	case 2:
    		return button_pCreateChange2;
    	case 3:
    		return button_pCreateChange3;
    	case 4:
    		return button_pCreateChange4;
    	case 5:
    		return button_pCreateChange5;
    	case 6:
    		return button_pCreateChange6;
    	case 7:
    		return button_pCreateChange7;
    	}
    	return null;
    }
    
    public static Button selectLoginButton(int profileNumber) {
    	switch(profileNumber) {
    	case 0:
    		return button_pLoginChange0;
    	case 1:
    		return button_pLoginChange1;
    	case 2:
    		return button_pLoginChange2;
    	case 3:
    		return button_pLoginChange3;
    	case 4:
    		return button_pLoginChange4;
    	case 5:
    		return button_pLoginChange5;
    	case 6:
    		return button_pLoginChange6;
    	case 7:
    		return button_pLoginChange7;
    	}
    	return null;
    }
    
    public void inputProfileInfo() {
    	int pID = profileNumber;
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String name = tb_profileName.getText().toString();
    	String pass = tb_profilePIN.getText().toString();
    	String insert = "insert into tableprofile "
    			+ "(accountID, profileID, profileName, profilePIN)"
    			+ " VALUES ('"+aID+"','"+pID+"','"+name+"','"+pass+"');";
    	lpcon.MySQLCon.sqlInsert(insert);
    }

}