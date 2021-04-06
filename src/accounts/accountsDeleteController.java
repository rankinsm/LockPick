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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class accountsDeleteController {

    @FXML
    private Button btn_back;

    @FXML
    private PasswordField txt_accountPassword;

    @FXML
    private TextField txt_accountEmail;

    @FXML
    private Button btn_deleteAccount;

    @FXML
    private Text txt_errorM;

    @FXML
    void deleteAccount(ActionEvent event) throws IOException {
    	if(checkEmail() && checkPassword()) {
    		deleteInfo();
        	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsHome.fxml"));
        	Scene accountHomeScene = new Scene(accountHomeView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(accountHomeScene);
        	window.show();
    	}
    	else if(!checkEmail()) {
    		txt_errorM.setText("Error - Email is incorrect");
    	}
    	else if (!checkPassword()) {
    		txt_errorM.setText("Error - Password is incorrect");
    	}
    	else {
    		txt_errorM.setText("Error - Something went wrong");
    	}
    }

    @FXML
    void showAccountEdit(ActionEvent event) throws IOException {
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsEdit.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }
    
    private boolean checkEmail() {
    	String inputEmail = txt_accountEmail.getText();
    	String accEmail = accounts.accountsLoginController.accountEmail;
    	if(inputEmail.equals(accEmail)) {
    		return true;
    	}
    	return false;
    }
    
    private boolean checkPassword() {
       	String loginEmail = accounts.accountsLoginController.accountEmail;
       	String loginPass = txt_accountPassword.getText().toString();
        if(lpcon.MySQLCon.verifyAccount(loginEmail, loginPass)) {
        	return true;
        }
       
        return false;
    }
    
    private void deleteInfo() {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	String deleteLogins = "DELETE FROM tablelogins " 
    			+ "WHERE accountID ='"+accountID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteLogins);
    	String deleteProfile = "DELETE FROM tableprofile "
    			+ "WHERE accountID ='"+accountID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteProfile);
    	String deleteAccount = "DELETE FROM tableaccount "
    			+ "WHERE accountID ='"+accountID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteAccount);
    }

}
