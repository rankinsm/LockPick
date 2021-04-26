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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginsEditController implements Initializable{
	private int aID = accounts.accountsLoginController.accountIDNum;
	private int pID = application.profileLoginController.profileID;
	static String[] names = new String[8];
	String[] unloadedNames = new String[8];
	String isShared;
	String prof0, prof1, prof2, prof3, prof4, prof5, prof6, prof7;
	Boolean changed = false;
	
    @FXML
    private Button btn_back;

    @FXML
    private Button btn_delete;
    
    @FXML
    private Text txt_deleteError;

    @FXML
    private TextField txt_user;

    @FXML
    private TextField txt_pass;

    @FXML
    private CheckBox cb_isShared;

    @FXML
    private Button btn_editLogin;

    @FXML
    private TextField txt_newName;

    @FXML
    private ComboBox<String> cmb_name;
    
    @FXML
    private Text txt_editError;

    @FXML
    private CheckBox cb_shared0;

    @FXML
    private CheckBox cb_shared1;

    @FXML
    private CheckBox cb_shared2;

    @FXML
    private CheckBox cb_shared3;

    @FXML
    private CheckBox cb_shared4;

    @FXML
    private CheckBox cb_shared5;

    @FXML
    private CheckBox cb_shared6;

    @FXML
    private CheckBox cb_shared7;

    @FXML
    private Text txt_name0;

    @FXML
    private Text txt_name1;

    @FXML
    private Text txt_name2;

    @FXML
    private Text txt_name3;

    @FXML
    private Text txt_name4;

    @FXML
    private Text txt_name5;

    @FXML
    private Text txt_name6;

    @FXML
    private Text txt_name7;

    @FXML
    void deleteLogin(ActionEvent event) throws IOException {
    	txt_deleteError.setText("");
    	String lName = cmb_name.getValue();
    	if(lName != null) {
        	deleteInfo(lName);
        	Parent loginProfileView = FXMLLoader.load(getClass().getResource("loginsHome.fxml"));
        	Scene loginProfileScene = new Scene(loginProfileView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(loginProfileScene);
        	window.show();
    	}
    	else {
    		txt_deleteError.setText("Error - Please select a login name to delete");
    	}
    }

    @FXML
    void editLogin(ActionEvent event) throws IOException {
    	txt_editError.setText("");
    	if(cmb_name.getValue() != null) {
    		if(txt_user.getLength() != 0) {
    			changeUser(cmb_name.getValue(), txt_user.getText());
    		}
    		if(txt_pass.getLength() != 0) {
    			changePass(cmb_name.getValue(), txt_pass.getText());
    		}

    		if(txt_newName.getLength() != 0) {
    			changeName(cmb_name.getValue(), txt_newName.getText());
    		}
    		changeShared(cmb_name.getValue());
    		Parent loginProfileView = FXMLLoader.load(getClass().getResource("loginsHome.fxml"));
    		Scene loginProfileScene = new Scene(loginProfileView);

    		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		window.setScene(loginProfileScene);
    		window.show();
    	}
    	else {
    		txt_editError.setText("Error - Please select a login name to edit");
    	}
    }

    @FXML
    void showLoginsBack(ActionEvent event) throws IOException {
    	Parent loginProfileView = FXMLLoader.load(getClass().getResource("loginsHome.fxml"));
    	Scene loginProfileScene = new Scene(loginProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(loginProfileScene);
    	window.show();
    }
    
    private void deleteInfo(String loginName) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String deleteLogin = "DELETE FROM tablelogins " 
    			+ "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"' AND loginName = '"+loginName+"';";
    	lpcon.MySQLCon.sqlInsert(deleteLogin);
    }
    
    private void changeName(String loginName, String newName) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String updateName = "UPDATE tablelogins SET "
    			+ "loginName = '"+newName+"' "
    			+  "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"' AND loginName = '"+loginName+"';";
    	lpcon.MySQLCon.sqlInsert(updateName);
    }
    
    private void changeUser(String loginName, String newUser) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String updateUser = "UPDATE tablelogins SET "
    			+ "loginUser = '"+newUser+"' "
    			+  "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"' AND loginName = '"+loginName+"';";
    	lpcon.MySQLCon.sqlInsert(updateUser);	
    }
    
    private void changePass(String loginName, String newPass) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String updateUser = "UPDATE tablelogins SET "
    			+ "loginPassword = '"+newPass+"' "
    			+  "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"' AND loginName = '"+loginName+"';";
    	lpcon.MySQLCon.sqlInsert(updateUser);	
    }
    
    private void changeShared(String loginName) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	setNotShared();
    	setIfShared();
    	String updateShared = "UPDATE tableLogins SET "
    			+ "isSharable = '"+isShared+"',"
    			+ "sharedProf0 = '"+prof0+"'," 
    			+ "sharedProf1 = '"+prof1+"'," 
    			+ "sharedProf2 = '"+prof2+"',"
    			+ "sharedProf3 = '"+prof3+"',"
    			+ "sharedProf4 = '"+prof4+"',"
    			+ "sharedProf5 = '"+prof5+"',"
    			+ "sharedProf6 = '"+prof6+"',"
    			+ "sharedProf7 = '"+prof7+"' "
    			+  "WHERE accountID ='"+accountID+"' AND profileID ='"+profileID+"' AND loginName = '"+loginName+"';";
    			lpcon.MySQLCon.sqlInsert(updateShared);
    }
    
    void setNotShared() {
    	isShared = "No";
    	prof0  = "NO";
    	prof1  = "No";
    	prof2  = "No";
    	prof3  = "No";
    	prof4  = "No";
    	prof5  = "No";
    	prof6  = "No";
    	prof7  = "No";
    }
    
    void setIfShared() {
    	isShared = isTrue(cb_isShared.isSelected());
    	prof0  = isTrue(cb_shared0.isSelected());
    	prof1  = isTrue(cb_shared1.isSelected());
    	prof2  = isTrue(cb_shared2.isSelected());
    	prof3  = isTrue(cb_shared3.isSelected());
    	prof4  = isTrue(cb_shared4.isSelected());
    	prof5  = isTrue(cb_shared5.isSelected());
    	prof6  = isTrue(cb_shared6.isSelected());
    	prof7  = isTrue(cb_shared7.isSelected());
    }
    
    String isTrue(Boolean bool) {
    	if(bool) {
    		return "Yes";
    	}
    	return "No";
    }
    
    private void getNames() {
    	unloadedNames = getProfiles();
    	for(int i = 0; i < 8; i++) {
    		names[i] = unloadedNames[i];
    	}    	
    }
    
    private String[] getProfiles() {
    	return lpcon.MySQLCon.accountOrderedProfiles(accounts.accountsLoginController.accountIDNum);
    }
    
    private void setName(Text txt, String name) {
    	txt.setText(name);
    }
    
    private void disableCB(CheckBox cb) {
    	cb.setDisable(true);
    	cb.setText("No Profile");
    }
    
    private void nameCB(CheckBox cb) {
    	cb.setText("You");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getNames();
    	for(int i = 0; i < 8; i++) {
    		switch(i){
    		case 0:
    			if(names[0] != null && pID != 0) {
    				setName(txt_name0, names[0]);
    			}
    			else {
    				disableCB(cb_shared0);
    			}
    			break;
    		case 1:
    			if(names[1] != null && pID != 1) {
    				setName(txt_name1, names[1]);
    			}
    			else {
    				disableCB(cb_shared1);
    			}
    			break;
    		case 2:
    			if(names[2] != null && pID != 2) {
    				setName(txt_name2, names[2]);
    			}
    			else {
    				disableCB(cb_shared2);
    			}
    			break;
    		case 3:
    			if(names[3] != null && pID != 3) {
    				setName(txt_name3, names[3]);
    			}
    			else {
    				disableCB(cb_shared3);
    			}
    			break;
    		case 4:
    			if(names[4] != null && pID != 4) {
    				setName(txt_name4, names[4]);
    			}
    			else {
    				disableCB(cb_shared4);
    			}
    			break;
    		case 5:
    			if(names[5] != null && pID != 5) {
    				setName(txt_name5, names[5]);
    			}
    			else {
    				disableCB(cb_shared5);
    			}
    			break;
    		case 6:
    			if(names[6] != null && pID != 6) {
    				setName(txt_name6, names[6]);
    			}
    			else {
    				disableCB(cb_shared6);
    			}
    			break;
    		case 7:
    			if(names[7] != null && pID != 7) {
    				setName(txt_name7, names[7]);
    			}
    			else {
    				disableCB(cb_shared7);
    			}
    			break;
    		}
    	}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lockpick","root","rootPass");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select loginName FROM tablelogins WHERE accountID = '"+aID+"' AND profileID = '"+pID+"';");
			while(rs.next()) {
				cmb_name.getItems().addAll(rs.getString("loginName"));
			}

		} 
		catch (Exception e) {
			System.out.println(e);
		}	
	}

}
