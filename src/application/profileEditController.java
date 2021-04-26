package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import accounts.accountsCreateController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class profileEditController extends accountsCreateController implements Initializable {
	public static String pName;

	//Form Elements
    @FXML
    private Button btn_back;
    
    @FXML
    private Button btn_delete;

    @FXML
    private TextField txt_profileName;

    @FXML
    private PasswordField txt_oldPIN;

    @FXML
    private PasswordField txt_newPIN;

    @FXML
    private PasswordField txt_checkPIN;

    @FXML
    private Button btn_saveChanges;

    @FXML
    private Text txt_errorMessage;

    //Update Profile Information in DB
    @FXML
    void saveChanges(ActionEvent event) throws Exception {
    	txt_errorMessage.setText("");
    	if(nameChange() && txt_newPIN.getLength() != 0) {
        	if(txt_newPIN.getLength() == 6 && matchCheckPIN(txt_newPIN, txt_checkPIN) && charCheck(txt_newPIN) && checkPIN(txt_oldPIN)) {
            	updateProfileNameAndPass(); //Updates Profile
        		Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../logins/loginsHome.fxml"));
            	Scene loginsHomeScene = new Scene(loginsHomeView);
            	
            	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	window.setScene(loginsHomeScene);
            	window.show();
        	}
        	else if(txt_newPIN.getLength() != 6) {
        		txt_errorMessage.setText("New PIN must be 6 digits");
        	}
        	else if(!matchCheck(txt_newPIN, txt_checkPIN)) {
        		txt_errorMessage.setText("PINs do not match");
        	}
        	else if(!charCheck(txt_newPIN)) {
        		txt_errorMessage.setText("New PIN can only contain numbers");
        	}
        	else if(!checkPIN(txt_oldPIN)) {
        		txt_errorMessage.setText("Old PIN is incorrect");
        	}
        	else {
        		txt_errorMessage.setText("Can't update profile information right now. Try again later");
        	}
    	}
    	else if(nameChange() && txt_newPIN.getLength() == 0){
        	updateProfileName();
    		Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../logins/loginsHome.fxml"));
        	Scene loginsHomeScene = new Scene(loginsHomeView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(loginsHomeScene);
        	window.show();
    	}
    	else if((!nameChange()) && txt_newPIN.getLength() != 0){
        	if(txt_newPIN.getLength() == 6 && matchCheck(txt_newPIN, txt_checkPIN) && charCheck(txt_newPIN) && checkPIN(txt_oldPIN)) {
            	updateProfilePass();
        		Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../logins/loginsHome.fxml"));
            	Scene loginsHomeScene = new Scene(loginsHomeView);
            	
            	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	window.setScene(loginsHomeScene);
            	window.show();
        	}
        	else if(txt_newPIN.getLength() != 6) {
        		txt_errorMessage.setText("New PIN must be 6 digits");
        	}
        	else if(!matchCheck(txt_newPIN, txt_checkPIN)) {
        		txt_errorMessage.setText("PINs do not match");
        	}
        	else if(!charCheck(txt_newPIN)) {
        		txt_errorMessage.setText("New PIN can only contain numbers");
        	}
        	else if(!checkPIN(txt_oldPIN)) {
        		txt_errorMessage.setText("Old PIN is incorrect");
        	}
        	else {
        		txt_errorMessage.setText("Can't update profile information right now. Try again later");
        	}
    	}
    	else {
    		txt_errorMessage.setText("Something went wrong");
    	}
    }

    //Show Login Home Page
    @FXML
    void showLogins(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../logins/loginsHome.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show(); 

    }
    
    //Launch Delete Profile Page
    @FXML
    void showDeleteProfile(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("profileDelete.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show();
    }
    
    //PIN Confirmation
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
    
    //Validates PIN characters
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
    
    //Verify PIN with DB
    public boolean checkPIN(PasswordField _PIN) throws Exception {
    	String inputPIN = _PIN.getText().toString();
    	int profileID = application.profileSelectionController.profileID;
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	
    	inputPIN = encode(inputPIN); //Encrypts to match DB
    	
    	if(lpcon.MySQLCon.verifyProfile(accountID, profileID, inputPIN)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean nameChange() {
    	if(txt_profileName.getLength() != 0) {
    		return true;
    	}

    	return false;
    }
    
    //Updates Profile (User) in DB
    public void updateProfileName() {
    	int pID = application.profileLoginController.profileID;
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String name = txt_profileName.getText().toString();
    	String insert = "UPDATE tableprofile SET "
    			+ "profileName = '"+name+"' "
    			+ "WHERE accountID = '"+aID+"' AND profileID = '"+pID+"';";
    	lpcon.MySQLCon.sqlInsert(insert);
    }
    
    //Updates Profile (PIN) in DB
    public void updateProfilePass() throws Exception {
    	int pID = application.profileLoginController.profileID;
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String pass = txt_newPIN.getText().toString(); //PIN setter
    	
    	pass = encode(pass); //Encrypts to match DB
    	
    	String insert = "UPDATE tableprofile SET "
    			+ "profilePIN = '"+pass+"' "
    			+ "WHERE accountID = '"+aID+"' AND profileID = '"+pID+"';";
    	lpcon.MySQLCon.sqlInsert(insert);
    }
    
    //Updates Profile (User+PIN) in DB
    public void updateProfileNameAndPass() throws Exception {
    	int pID = application.profileLoginController.profileID;
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String name = txt_profileName.getText().toString();
    	String pass = txt_newPIN.getText().toString(); //PIN setter
    	
    	pass = encode(pass); //Encrypts to match DB
    	
    	String insert = "UPDATE tableprofile SET "
    			+ "profileName = '"+name+"', profilePIN = '"+pass+"' "
    			+ "WHERE accountID = '"+aID+"' AND profileID = '"+pID+"';";
    	lpcon.MySQLCon.sqlInsert(insert);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pName = logins.loginsHomeController.profileNames[application.profileLoginController.profileID];
		txt_profileName.setPromptText(pName);
	}

}
