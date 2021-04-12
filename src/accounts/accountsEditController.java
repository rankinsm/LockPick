package accounts;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class accountsEditController {

	//Form Elements
    @FXML
    private Button btn_back;

    @FXML
    private Button btn_deleteProfile;

    @FXML
    private Button btn_deleteAccount;

    @FXML
    private PasswordField txt_oldPassword;

    @FXML
    private PasswordField txt_newPassword;

    @FXML
    private PasswordField txt_checkPassword;

    @FXML
    private Button btn_changePassword;
    
    @FXML
    private Text txt_errorM;

    @FXML
    void showDeleteAccount(ActionEvent event) throws IOException {
    	Parent profileWelcomeView = FXMLLoader.load(getClass().getResource("accountsDelete.fxml"));
    	Scene profileWelcomeScene = new Scene(profileWelcomeView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileWelcomeScene);
    	window.show(); 
    }

    @FXML
    void showDeleteProfile(ActionEvent event) throws IOException {
    	Parent profileWelcomeView = FXMLLoader.load(getClass().getResource("accountsProfileDel.fxml"));
    	Scene profileWelcomeScene = new Scene(profileWelcomeView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileWelcomeScene);
    	window.show(); 
    }

    @FXML
    void showProfileSelection(ActionEvent event) throws IOException {
    	Parent profileWelcomeView = FXMLLoader.load(getClass().getResource("../application/profileSelection.fxml"));
    	Scene profileWelcomeScene = new Scene(profileWelcomeView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileWelcomeScene);
    	window.show(); 
    }
    

    @FXML
    void changePassword(ActionEvent event) throws IOException {
    	txt_errorM.setText("");
    	if(loginVerified() && passwordIsValid(txt_newPassword) && matchCheck(txt_newPassword, txt_checkPassword)) {
    		changePasswordInfo();
        	Parent profileWelcomeView = FXMLLoader.load(getClass().getResource("../application/profileSelection.fxml"));
        	Scene profileWelcomeScene = new Scene(profileWelcomeView);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(profileWelcomeScene);
        	window.show();
        	}
    	else if (!loginVerified()) {
    		txt_errorM.setText("Old password incorrect");
    	}
    	else if(!passwordIsValid(txt_newPassword)) {
    		txt_errorM.setText("New password is not valid");
    	}
    	else if(!matchCheck(txt_newPassword, txt_checkPassword)) {
    		txt_errorM.setText("Passwords do not match");
    	}
    	else {
    		txt_errorM.setText("Something went wrong");
    	}
    }
    
    //Check if login exists in DB
    public boolean loginVerified() {
    	String loginEmail = accounts.accountsLoginController.accountEmail;
    	String loginPass = txt_oldPassword.getText().toString(); //Needs encrpyt/decryption to match DB
    	if(lpcon.MySQLCon.verifyAccount(loginEmail, loginPass)) {
    		return true;
    	}
    
    	return false;
    }
    
    //Password Validation
    public boolean passwordIsValid (PasswordField pass) {
    	String e = pass.getText().toString();
        boolean result = false;
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;
        char[] charChecker = e.toCharArray();
        if (e.length() >= 8) {
            for (int i = 0; i < charChecker.length; i++) {
                if (Character.isDigit(charChecker[i])) {
                hasNumber = true;
                }
                else if (Character.isLetter(charChecker[i])) {
                hasLetter = true;
                }
                else {
                hasSymbol = true;
                }
            }
            result = hasLetter && hasNumber && hasSymbol;
        }
        return result;
    }
    
    //Password Confirmation
    public boolean matchCheck(PasswordField tb_pass, PasswordField tb_passcheck) {
		String pass1 = tb_pass.getText().toString();
		String pass2 = tb_passcheck.getText().toString();
		int len = pass1.length();
		int check = 0;
		for(int i = 0; i < pass1.length(); i++) {
			if(pass1.charAt(i) == (pass2.charAt(i))) {
				check++;
			}
		}
		if(check == len) {
			return true;
		}
		return false;
    }
    
    //Insert updated password into the DB
    private void changePasswordInfo() {
    	int aID = accounts.accountsLoginController.accountIDNum;
    	String password = txt_newPassword.getText().toString(); //---Needs Encryption
    	String insert = "UPDATE tableaccount SET "
    			+ "accountPassword = '"+password+"' "
    			+ "WHERE accountID = '"+aID+"';";
    	lpcon.MySQLCon.sqlInsert(insert);
    }

}
