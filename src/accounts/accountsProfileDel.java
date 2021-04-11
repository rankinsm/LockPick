package accounts;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class accountsProfileDel {
	public String[] unloadedProfiles = new String[8];
	public String[] loadedProfiles = new String[8];
	public static int numberOfProfiles = 0;
	public static int profileID;
	public static String pNameCheck;

    @FXML
    private Button btn_back;

    @FXML
    private Text txt_ErrorProfiles;

    @FXML
    private Button btn_profile0;

    @FXML
    private Button btn_profile1;

    @FXML
    private Button btn_profile2;

    @FXML
    private Button btn_profile3;

    @FXML
    private Button btn_profile4;

    @FXML
    private Button btn_profile5;

    @FXML
    private Button btn_profile6;

    @FXML
    private Button btn_profile7;

    @FXML
    private Button btn_selectProfile;

    @FXML
    void showAccountEdit(ActionEvent event) throws IOException {
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsEdit.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile0(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile0.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile1(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile1.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile2(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile2.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile3(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile3.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile4(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile4.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile5(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile5.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile6(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile6.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showLoginProfile7(ActionEvent event) throws IOException {
    	pNameCheck = btn_profile7.getText();
    	profileID = idSet(pNameCheck);
    	
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsProfileDelConfirm.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }

    @FXML
    void showSelectProfile(ActionEvent event) {
    	hideButton(btn_selectProfile);
    	getProfiles();
    	loadProfiles();
    	showButton(btn_back, "Back");
    	for(int i = 0; i < numberOfProfiles; i++) {
    		switch(i) {
    		case 0:
    			showButton(btn_profile0, loadedProfiles[i]);
    			break;
    		case 1:
    			showButton(btn_profile1, loadedProfiles[i]);
    			break;
    		case 2:
    			showButton(btn_profile2, loadedProfiles[i]);
    			break;
    		case 3:
    			showButton(btn_profile3, loadedProfiles[i]);
    			break;
    		case 4:
    			showButton(btn_profile4, loadedProfiles[i]);
    			break;
    		case 5:
    			showButton(btn_profile5, loadedProfiles[i]);
    			break;
    		case 6:
    			showButton(btn_profile6, loadedProfiles[i]);
    			break;
    		case 7:
    			showButton(btn_profile7, loadedProfiles[i]);
    			break;
    		}
    	}
    }
    
    void getProfiles() {
    	numberOfProfiles = 0;
    	for(int i = 0; i < 8; i++) {
    		unloadedProfiles[i] = lpcon.MySQLCon.accountProfiles(accounts.accountsLoginController.accountIDNum)[i];
    		if(unloadedProfiles[i] != null) {
    			numberOfProfiles++;
    		}
    	}
    }
    
    void loadProfiles() {
    	int num = 0;
    	for(int i = 0; i < numberOfProfiles; i++) {
    		if(unloadedProfiles[i] != null) {
    			loadedProfiles[num] = unloadedProfiles[i];
    			num++;
    		}
    	}
    }
        
    void showButton(Button btn, String profileName) {
        	btn.setText(profileName);
        	btn.setOpacity(100.0);
        	btn.setDisable(false);
    }
        
      
    void hideButton(Button btn) {
        	btn.setText("Disabled");
        	btn.setOpacity(0.0);
        	btn.setDisable(true);
    }
    
    int idSet(String name) {
    	return lpcon.MySQLCon.profileIDCheck(accounts.accountsLoginController.accountIDNum, name); 	
    }

}
