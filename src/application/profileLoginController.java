

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lpcon.MySQLCon;
import accounts.accountsLoginController;

public class profileLoginController extends profileCreateController{

    @FXML
    private Button btn_plBack;
	
    @FXML
    private Button btn_pLogin1;

    @FXML
    private Button btn_pLogin2;

    @FXML
    private Button btn_pLogin3;

    @FXML
    private Button btn_pLogin4;

    @FXML
    private Button btn_pLogin5;

    @FXML
    private Button btn_pLogin6;

    @FXML
    private Button btn_pLogin7;

    @FXML
    private Button btn_pLogin8;

    @FXML
    private Button btn_pLogin9;

    @FXML
    private Button btn_pLoginC;

    @FXML
    private Button btn_pLogin0;

    @FXML
    private Button btn_pLoginOK;

    @FXML
    private Text lb_pLoginCheck;

    @FXML
    private PasswordField tb_pPIN;

    public boolean checkPIN(PasswordField _PIN) {
    	String inputPIN = _PIN.getText().toString();
    	int profileID = profileNumber;
    	int accountID = accounts.accountsLoginController.accountIDNum;
    	if(lpcon.MySQLCon.verifyProfile(accountID, profileID, inputPIN)) {
    		return true;
    	}
    	
    	return false;
    }  	

    
    @FXML
    void btn_C(ActionEvent event) {
    	tb_pPIN.setText("");
    }

    @FXML
    void btn_enter(ActionEvent event) {
    	if(checkPIN(tb_pPIN)) {
    		lb_pLoginCheck.setText("Welcome");
    	}
    	else {
    		lb_pLoginCheck.setText("PIN Incorrect");
    	}
    }

    @FXML
    void btn_input7(ActionEvent event) {

    }

    @FXML
    void btn_input0(ActionEvent event) {

    }

    @FXML
    void btn_input1(ActionEvent event) {

    }

    @FXML
    void btn_input2(ActionEvent event) {

    }

    @FXML
    void btn_input3(ActionEvent event) {

    }

    @FXML
    void btn_input4(ActionEvent event) {

    }

    @FXML
    void btn_input5(ActionEvent event) {

    }

    @FXML
    void btn_input6(ActionEvent event) {

    }

    @FXML
    void btn_input8(ActionEvent event) {

    }

    @FXML
    void btn_input9(ActionEvent event) {

    }
    
    @FXML
    void pageBackHome(ActionEvent event) throws IOException {
    	
    }

}
