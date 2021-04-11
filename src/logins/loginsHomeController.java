package logins;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginsHomeController implements Initializable {

	public static String[] profileNames = new String[8];
	private int aID = accounts.accountsLoginController.accountIDNum;
	private int pID = application.profileLoginController.profileID;
	
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
    private TableView<ModelTable> table_logins;

    @FXML
    private TableColumn<ModelTable, String> clm_name;

    @FXML
    private TableColumn<ModelTable, String> clm_user;

    @FXML
    private TableColumn<ModelTable, String> clm_pass;

    @FXML
    private TableColumn<ModelTable, Integer> clm_shared;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile0;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile1;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile2;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile3;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile4;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile5;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile6;

    @FXML
    private TableColumn<ModelTable, Integer> clm_profile7;
    
    @FXML
    private TableColumn<ModelTable, Button> clm_button;
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    
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
    	clm_profile0.setText("Dan");
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
    void showProfileEdit(ActionEvent event) throws IOException {
    	Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../application/profileEdit.fxml"));
    	Scene loginsHomeScene = new Scene(loginsHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginsHomeScene);
    	window.show(); 
    }

    @FXML
    void showProfileSelection(ActionEvent event) throws IOException {
    	Parent selectProfileView = FXMLLoader.load(getClass().getResource("../application/profileSelection.fxml"));
    	Scene selectProfileScene = new Scene(selectProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(selectProfileScene);
    	window.show();
    }

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
    
    private void setColumnNames() {
		clm_profile0.setText(profileNames[0]);
		clm_profile1.setText(profileNames[1]);
		clm_profile2.setText(profileNames[2]);
		clm_profile3.setText(profileNames[3]);
		clm_profile4.setText(profileNames[4]);
		clm_profile5.setText(profileNames[5]);
		clm_profile6.setText(profileNames[6]);
		clm_profile7.setText(profileNames[7]);
		
		switch(pID) {
		case 0:
			clm_profile0.setText("You");
		case 1:
			clm_profile1.setText("You");
		case 2:
			clm_profile2.setText("You");
		case 3:
			clm_profile3.setText("You");
		case 4:
			clm_profile4.setText("You");
		case 5:
			clm_profile5.setText("You");
		case 6:
			clm_profile6.setText("You");
		case 7:
			clm_profile7.setText("You");
		}
    }
    
    private String getUser() {
    	if(pID == 0) {
    		return "sharedProf0 ";
    	}
    	else if(pID == 1) {
    		return "sharedProf1 ";
    	}
    	else if(pID == 2) {
    		return "sharedProf2 ";
    	}
    	else if(pID == 3) {
    		return "sharedProf3 ";
    	}
    	else if(pID == 4) {
    		return "sharedProf4 ";
    	}
    	else if(pID == 5) {
    		return "sharedProf5 ";
    	}
    	else if(pID == 6) {
    		return "sharedProf6 ";
    	}
    	else if(pID == 7) {
    		return "sharedProf7 ";
    	}
    	return null;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setNames();
		setColumnNames();
		
		String sharedProf = getUser();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * FROM tablelogins WHERE accountID = '"+aID+"' AND profileID = '"+pID+"' OR "+sharedProf+" = '1';");
			while(rs.next()) {
				oblist.add(new ModelTable(rs.getString("loginName"), rs.getString("loginUser"), rs.getString("loginPassword"), 
						rs.getInt("isSharable"), rs.getInt("sharedProf0"), rs.getInt("sharedProf1"), rs.getInt("sharedProf2"),
						rs.getInt("sharedProf3"), rs.getInt("sharedProf4"), rs.getInt("sharedProf5"), rs.getInt("sharedProf6"), rs.getInt("sharedProf7")));
			}

		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		clm_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		clm_user.setCellValueFactory(new PropertyValueFactory<>("account"));
		clm_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
		clm_shared.setCellValueFactory(new PropertyValueFactory<>("isShared"));
		clm_profile0.setCellValueFactory(new PropertyValueFactory<>("sharedW0"));
		clm_profile1.setCellValueFactory(new PropertyValueFactory<>("sharedW1"));
		clm_profile2.setCellValueFactory(new PropertyValueFactory<>("sharedW2"));
		clm_profile3.setCellValueFactory(new PropertyValueFactory<>("sharedW3"));
		clm_profile4.setCellValueFactory(new PropertyValueFactory<>("sharedW4"));
		clm_profile5.setCellValueFactory(new PropertyValueFactory<>("sharedW5"));
		clm_profile6.setCellValueFactory(new PropertyValueFactory<>("sharedW6"));
		clm_profile7.setCellValueFactory(new PropertyValueFactory<>("sharedW7"));
		
		table_logins.setItems(oblist);
	}

}
