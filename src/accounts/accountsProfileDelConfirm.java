package accounts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class accountsProfileDelConfirm extends accountsCreateController implements Initializable{

    @FXML
    private Button btn_back;

    @FXML
    private PasswordField txt_accountPassword;

    @FXML
    private TextField txt_accountEmail;

    @FXML
    private Button btn_deleteProfile;

    @FXML
    private Text txt_errorM;

    @FXML
    private Text txt_profileName;

    @FXML
    private Text txt_errorM1;

    @FXML
    void deleteProfile(ActionEvent event) throws Exception {
    	if(checkEmail() && checkPassword()) {
    		deleteInfo();
        	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsEdit.fxml"));
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
    void showProfileDelSelection(ActionEvent event) throws IOException {
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDel.fxml"));
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
    
    private boolean checkPassword() throws Exception {
       	String loginEmail = accounts.accountsLoginController.accountEmail;
       	String loginPass = txt_accountPassword.getText().toString();
       	
       	//loginPass = encode(loginPass); //Encrypt to match DB
       	
        if(lpcon.MySQLCon.verifyAccount(loginEmail, loginPass)) {
        	return true;
        }
       
        return false;
    }
    
    private void deleteInfo() {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = accounts.accountsProfileDel.profileID;
    	String deleteLogins = "DELETE FROM tablelogins " 
    			+ "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteLogins);
    	String deleteProfile = "DELETE FROM tableprofile "
    			+ "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteProfile);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txt_profileName.setText(accounts.accountsProfileDel.pNameCheck);
	}

}
