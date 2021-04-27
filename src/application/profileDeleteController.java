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

public class profileDeleteController extends accountsCreateController implements Initializable{
	
	String name = application.profileEditController.pName;

	//Form Elements
    @FXML
    private Button btn_back;

    @FXML
    private TextField txt_profileName;

    @FXML
    private PasswordField txt_profilePIN;

    @FXML
    private Button btn_delete;

    @FXML
    private Text txt_error;

    //Launch Edit Profile page
    @FXML
    void showEditProfile(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("profileEdit.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show();
    }

    //Launch Profile Selection Page
    @FXML
    void showProfileSelection(ActionEvent event) throws Exception {
		txt_error.setText("Something went wrong");
    	if(nameCheck() && pinCheck()) {
    		deleteInfo();
    		application.profileSelectionController.profileID = -1;
        	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("profileSelection.fxml"));
        	Scene loginsHomeScene = new Scene(loginsHomeView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(loginsHomeScene);
        	window.show();    	}
    	else if(!nameCheck()) {
    		txt_error.setText("Profile name is not correct");
    	}
    	else if(!pinCheck()) {
    		txt_error.setText("PIN is not correct");
    	}
    	else {
    		txt_error.setText("Something went wrong");
    	}
    }

    //Verifies name with DB
    private boolean nameCheck(){
    	if(txt_profileName.getText().equals(name)) {
    		return true;
    	}
    	return false;
    }
    
    //Verifies PIN with DB
    public boolean pinCheck() throws Exception {
    	String inputPIN = txt_profilePIN.getText().toString();
    	int profileID = application.profileSelectionController.profileID;
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	
    	//inputPIN = encode(inputPIN); //Encrypt to match with DB
    	
    	if(lpcon.MySQLCon.verifyProfile(accountID, profileID, inputPIN)) {
    		return true;
    	}
    	
    	return false;
    }
    
    //Delete Profile from Account in DB
    private void deleteInfo() {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String deleteLogins = "DELETE FROM tablelogins " 
    			+ "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteLogins);
    	String deleteProfile = "DELETE FROM tableprofile "
    			+ "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"';";
    	lpcon.MySQLCon.sqlInsert(deleteProfile);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txt_profileName.setPromptText(name);
	}

}
