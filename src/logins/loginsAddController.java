package logins;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class loginsAddController {
	int isShared;
	int prof0;
	int prof1;
	int prof2;
	int prof3;
	int prof4;
	int prof5;
	int prof6;
	int prof7;

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

}
