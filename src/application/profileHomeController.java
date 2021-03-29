package application;

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
import javafx.stage.Stage;
import accounts.accountsLoginController;
import application.profileCreateController;

public class profileHomeController implements Initializable{
	public static int profileNumber;


    @FXML
    public static Button button_createProfile0;
	
    @FXML
    public static Button button_createProfile1;
    
    @FXML
    public static Button button_createProfile2;

    @FXML
    public static Button button_createProfile3;

    @FXML
    public static Button button_createProfile4;

    @FXML
    public static Button button_createProfile5;

    @FXML
    public static Button button_createProfile6;

    @FXML
    public static Button button_createProfile7;
    
    @FXML
    private Button button_loginProfile0;
    
    @FXML
    private Button button_loginProfile1;
    
    @FXML
    private Button button_loginProfile2;
    
    @FXML
    private Button button_loginProfile3;
    
    @FXML
    private Button button_loginProfile4;
    
    @FXML
    private Button button_loginProfile5;
    
    @FXML
    private Button button_loginProfile6;
    
    @FXML
    private Button button_loginProfile7;
    
    public static Button button_pCreateChange0;
    
    public static Button button_pLoginChange0;
    
    public static Button button_pCreateChange1;
    
    public static Button button_pLoginChange1;
    
    public static Button button_pCreateChange2;
    
    public static Button button_pLoginChange2;
    
    public static Button button_pCreateChange3;
    
    public static Button button_pLoginChange3;
    
    public static Button button_pCreateChange4;
    
    public static Button button_pLoginChange4;
    
    public static Button button_pCreateChange5;
    
    public static Button button_pLoginChange5;
    
    public static Button button_pCreateChange6;
    
    public static Button button_pLoginChange6;
    
    public static Button button_pCreateChange7;
    
    public static Button button_pLoginChange7;



    @FXML
    void showCreateProfile0(ActionEvent event) throws IOException {
    	profileNumber = 0;
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile1(ActionEvent event) throws IOException {
    	profileNumber = 1;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }
    
    @FXML
    void showCreateProfile2(ActionEvent event) throws IOException {
    	profileNumber = 2;
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile3(ActionEvent event) throws IOException {
    	profileNumber = 3;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile4(ActionEvent event) throws IOException {
    	profileNumber = 4;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile5(ActionEvent event) throws IOException {
    	profileNumber = 5;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile6(ActionEvent event) throws IOException {
    	profileNumber = 6;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    @FXML
    void showCreateProfile7(ActionEvent event) throws IOException {
    	profileNumber = 7;

    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileCreate.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }

    
    @FXML
    void showLoginProfile0(ActionEvent event) throws IOException{
    	profileNumber = 0;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile1(ActionEvent event) throws IOException{
    	profileNumber = 1;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile2(ActionEvent event) throws IOException{
    	profileNumber = 2;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile3(ActionEvent event) throws IOException{
    	profileNumber = 3;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile4(ActionEvent event) throws IOException{
    	profileNumber = 4;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile5(ActionEvent event) throws IOException{
    	profileNumber = 5;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile6(ActionEvent event) throws IOException{
    	profileNumber = 6;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    @FXML
    void showLoginProfile7(ActionEvent event) throws IOException{
    	profileNumber = 7;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    public static void setButtons() {
    	for(int i = 0; i < 8; i++) {
    		System.out.println(accounts.accountsLoginController.localProfiles[i]);
    		if(accounts.accountsLoginController.localProfiles[i].equals("-1")) {
//    			application.profileCreateController.removeCreateButton(application.profileCreateController.selectCreateBtn(i));
    			//application.profileCreateController.setLoginButton(application.profileCreateController.selectLoginButton(i));
    		}
    	}
    }
    
    public static Button selectCreateBtn(int profileNumber) {
    	switch(profileNumber) {
    	case 0:
    		return button_createProfile0;
    	case 1:
    		return button_createProfile1;
    	case 2:
    		return button_createProfile2;
    	case 3:
    		return button_createProfile3;
    	case 4:
    		return button_createProfile4;
    	case 5:
    		return button_createProfile5;
    	case 6:
    		return button_createProfile6;
    	case 7:
    		return button_createProfile7;
    	}
    	return null;
    }
    
    public static Button selectProfileBtn(int profileNumber) {
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
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	button_pCreateChange0 = button_createProfile0;
		button_pLoginChange0 = button_loginProfile0;
    	button_pCreateChange1 = button_createProfile1;
		button_pLoginChange1 = button_loginProfile1;
    	button_pCreateChange2 = button_createProfile2;
		button_pLoginChange2 = button_loginProfile2;
    	button_pCreateChange3 = button_createProfile3;
		button_pLoginChange3 = button_loginProfile3;
    	button_pCreateChange4 = button_createProfile4;
		button_pLoginChange4 = button_loginProfile4;
    	button_pCreateChange5 = button_createProfile5;
		button_pLoginChange5 = button_loginProfile5;
    	button_pCreateChange6 = button_createProfile6;
		button_pLoginChange6 = button_loginProfile6;
    	button_pCreateChange7 = button_createProfile7;
		button_pLoginChange6 = button_loginProfile7;
	}


}
