package logins;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class loginsAddController implements Initializable{
	int isShared;
	int prof0;
	int prof1;
	int prof2;
	int prof3;
	int prof4;
	int prof5;
	int prof6;
	int prof7;
	static String[] names = new String[8];
	String[] unloadedNames = new String[8];

	int profID = application.profileSelectionController.profileID;

    @FXML
    private TextField txt_loginName;

    @FXML
    private TextField txt_loginUser;

    @FXML
    private TextField txt_loginPass;

    @FXML
    private CheckBox cb_isShared;

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
    private Button btn_addLogin;

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
    void addLoginInfo(ActionEvent event) {
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	int profileID = application.profileLoginController.profileID;
    	String name = txt_loginName.getText();
    	String user = txt_loginUser.getText();
    	String pass = txt_loginPass.getText();
    	setNotShared();
    	setIfShared();
    	String query = "INSERT INTO tableLogins(accountID, profileID, loginName, loginUser, loginPassword, isSharable, sharedProf0, sharedProf1, sharedProf2, sharedProf3, sharedProf4, sharedProf5, sharedProf6, sharedProf7)"
    			+ "VALUES ('"+accountID+"','"+profileID+"','"+name+"','"+user+"','"+pass+"','"+isShared+"','"+prof0+"','"+prof1+"','"+prof2+"','"+prof3+"','"+prof4+"','"+prof5+"','"+prof6+"','"+prof7+"');";
    	lpcon.MySQLCon.sqlInsert(query);
    	btn_addLogin.getScene().getWindow().hide();
    }
    
    void setNotShared() {
    	isShared = 0;
    	prof0  = 0;
    	prof1  = 0;
    	prof2  = 0;
    	prof3  = 0;
    	prof4  = 0;
    	prof5  = 0;
    	prof6  = 0;
    	prof7  = 0;
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
    
    int isTrue(Boolean bool) {
    	if(bool) {
    		return 1;
    	}
    	return 0;
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
    
    public void initialize(URL url, ResourceBundle bd) {
    	getNames();
    	for(int i = 0; i < 8; i++) {
    		switch(i){
    		case 0:
    			if(names[0] != null && profID != 0) {
    				setName(txt_name0, names[0]);
    			}
    			else {
    				disableCB(cb_shared0);
    			}
    			break;
    		case 1:
    			if(names[1] != null && profID != 1) {
    				setName(txt_name1, names[1]);
    			}
    			else {
    				disableCB(cb_shared1);
    			}
    			break;
    		case 2:
    			if(names[2] != null && profID != 2) {
    				setName(txt_name2, names[2]);
    			}
    			else {
    				disableCB(cb_shared2);
    			}
    			break;
    		case 3:
    			if(names[3] != null && profID != 3) {
    				setName(txt_name3, names[3]);
    			}
    			else {
    				disableCB(cb_shared3);
    			}
    			break;
    		case 4:
    			if(names[4] != null && profID != 4) {
    				setName(txt_name4, names[4]);
    			}
    			else {
    				disableCB(cb_shared4);
    			}
    			break;
    		case 5:
    			if(names[5] != null && profID != 5) {
    				setName(txt_name5, names[5]);
    			}
    			else {
    				disableCB(cb_shared5);
    			}
    			break;
    		case 6:
    			if(names[6] != null && profID != 6) {
    				setName(txt_name6, names[6]);
    			}
    			else {
    				disableCB(cb_shared6);
    			}
    			break;
    		case 7:
    			if(names[7] != null && profID != 7) {
    				setName(txt_name7, names[7]);
    			}
    			else {
    				disableCB(cb_shared7);
    			}
    			break;
    		}
    	}

    }

}
