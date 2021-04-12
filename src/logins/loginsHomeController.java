package logins;

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
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginsHomeController implements Initializable {

	public static String[] profileNames = new String[8];
	
	//Form Elements
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
    private TableColumn<?, ?> clm_button;
    
    //Launch Account Home Page
    @FXML
    void showAccountHome(ActionEvent event) throws IOException {
    	Parent accountsHomeView = FXMLLoader.load(getClass().getResource("../accounts/accountsHome.fxml"));
    	Scene accountsHomeScene = new Scene(accountsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountsHomeScene);
    	window.show();
    }

    //Launch Add Profile page
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
    	clm_profile0.setText("Dan");
    }

    //Launch Login Home page
    @FXML
    void showLoginsHome(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("loginsHome.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show();
    }

    //Launch Profile Edit Page
    @FXML
    void showProfileEdit(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../application/profileEdit.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show(); 
    }

    //Launch Profile Selection page
    @FXML
    void showProfileSelection(ActionEvent event) throws IOException {
    	Parent selectProfileView = FXMLLoader.load(getClass().getResource("../application/profileSelection.fxml"));
    	Scene selectProfileScene = new Scene(selectProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(selectProfileScene);
    	window.show();
    }

    //Retrieve Profile Names from DB
    private void setNames() {
    	for(int i = 0; i < 8; i++) {
    		if(lpcon.MySQLCon.accountOrderedProfiles(accounts.accountsLoginController.accountIDNum)[i] != null) {
    			profileNames[i] = lpcon.MySQLCon.accountOrderedProfiles(accounts.accountsLoginController.accountIDNum)[i];
    		}
    		else {
    			profileNames[i] = "No Profile";
    		}
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setNames();
		clm_profile0.setText(profileNames[0]);
		clm_profile1.setText(profileNames[1]);
		clm_profile2.setText(profileNames[2]);
		clm_profile3.setText(profileNames[3]);
		clm_profile4.setText(profileNames[4]);
		clm_profile5.setText(profileNames[5]);
		clm_profile6.setText(profileNames[6]);
		clm_profile7.setText(profileNames[7]);
	}

}
