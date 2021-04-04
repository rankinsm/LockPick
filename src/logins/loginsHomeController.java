package logins;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginsHomeController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btn_logOut;

    @FXML
    private Button btn_refresh;

    @FXML
    private Button btn_editProfile;

    @FXML
    private Button btn_editLogin;

    @FXML
    private Button btn_addLogin;

    @FXML
    private TableColumn<?, ?> clm_name;

    @FXML
    private TableColumn<?, ?> clm_user;

    @FXML
    private TableColumn<?, ?> clm_pass;

    @FXML
    private TableColumn<?, ?> clm_shared;

    @FXML
    private TableColumn<?, ?> clm_profile0;

    @FXML
    private TableColumn<?, ?> clm_profile1;

    @FXML
    private TableColumn<?, ?> clm_profile2;

    @FXML
    private TableColumn<?, ?> clm_profile3;

    @FXML
    private TableColumn<?, ?> clm_profile4;

    @FXML
    private TableColumn<?, ?> clm_profile5;

    @FXML
    private TableColumn<?, ?> clm_profile6;

    @FXML
    private TableColumn<?, ?> clm_profile7;
    
    @FXML
    void showAccountHome(ActionEvent event) throws IOException {
    	Parent accountsHomeView = FXMLLoader.load(getClass().getResource("../accounts/accountsHome.fxml"));
    	Scene accountsHomeScene = new Scene(accountsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountsHomeScene);
    	window.show();
    }

    @FXML
    void showLoginAdd(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("loginsAdd.fxml"));
    	Parent root = (Parent) loader.load();
    	loginsAddController controller = (loginsAddController) loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.setTitle("LockPick");
    	stage.show();
		}

    @FXML
    void showLoginEdit(ActionEvent event) {

    }

    @FXML
    void showLoginsHome(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("loginsHome.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show();
    }

    @FXML
    void showProfileEdit(ActionEvent event) {

    }

    @FXML
    void showProfileSelection(ActionEvent event) throws IOException {
    	Parent selectProfileView = FXMLLoader.load(getClass().getResource("../application/profileSelection.fxml"));
    	Scene selectProfileScene = new Scene(selectProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(selectProfileScene);
    	window.show();
    }

}
