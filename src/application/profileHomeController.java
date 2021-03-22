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

public class profileHomeController implements Initializable{
	public static int profileNumber;

    @FXML
    public Button button_profile0;
	
    @FXML
    public static Button button_profile1;
    
    @FXML
    public Button button_profile2;

    @FXML
    public Button button_profile3;

    @FXML
    public Button button_profile4;

    @FXML
    public Button button_profile5;

    @FXML
    public Button button_profile6;

    @FXML
    public Button button_profile7;
    
    @FXML
    private Button button_pLogin0;
    
    public static Button button_profile0Create;
    
    public static Button button_pLogin0change;

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
    void showLoginProfile0(ActionEvent event) throws IOException{
    	profileNumber = 0;

    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("profileLogin.fxml"));
    	Scene profileLoginScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileLoginScene);
    	window.show();
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	button_profile0Create = button_profile0;
		button_pLogin0change = button_pLogin0;
	}

}
