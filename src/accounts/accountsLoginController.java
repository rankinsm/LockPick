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
import lpcon.MySQLCon;

import application.*;

public class accountsLoginController {
	public static int accountIDNum = -1;
	public static String[] localProfiles = new String[8];
	
    @FXML
    private Button btn_accountCreateBack;

    @FXML
    private TextField tb_loginEmail;

    @FXML
    private PasswordField tb_loginPassword;

    @FXML
    private Button btn_login;
    
    @FXML
    private Text txt_accountLoginError;

    @FXML
    void showBackAHome(ActionEvent event) throws IOException {
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsHome.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showProfilles(ActionEvent event) throws IOException {
		txt_accountLoginError.setText("");
		String email = tb_loginEmail.getText().toString();
    	if(loginVerified()) {
    		accountIDNum = lpcon.MySQLCon.accountID(email);
    		localProfiles = loadProfiles();
        	for(int i = 0; i < 8; i++) {
        		System.out.println(localProfiles[i]);
        	}
    		application.profileHomeController.setButtons();
        	Parent profileHomeView = FXMLLoader.load(getClass().getResource("../application/profileHome.fxml"));
        	Scene profileHomeScene = new Scene(profileHomeView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(profileHomeScene);
        	window.show(); 
    	}
    	else {
    		txt_accountLoginError.setText("Error - Incorrect email or password");
    	}
    }
    
    public boolean loginVerified() {
    	String loginEmail = tb_loginEmail.getText().toString();
    	String loginPass = tb_loginPassword.getText().toString();
    	if(lpcon.MySQLCon.verifyAccount(loginEmail, loginPass)) {
    		return true;
    	}
    
    	return false;
    }

    
    public static String[] loadProfiles() {
    	return lpcon.MySQLCon.accountProfiles(accountIDNum);
    }
    
}
