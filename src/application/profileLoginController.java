
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
import accounts.accountsCreateController;

public class profileLoginController extends accountsCreateController {
	private String txtPIN;

	//Form Elements
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
    
    public static int profileID = application.profileSelectionController.profileID;
    public static int accountID = accounts.accountsLoginController.accountIDNum;
    
    //Verifies PIN with DB
    public boolean checkPIN(PasswordField _PIN) throws Exception {
    	String inputPIN = _PIN.getText().toString();
    	
    	//inputPIN = encode(inputPIN); //Encrypt to match DB
    	
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
    void btn_enter(ActionEvent event) throws Exception {
    	if(checkPIN(tb_pPIN)) {
    		Parent loginsHomeView = FXMLLoader.load(getClass().getResource("../logins/loginsHome.fxml"));
        	Scene loginsHomeScene = new Scene(loginsHomeView);
        	
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(loginsHomeScene);
        	window.show(); 

        	}
    	else {
    		lb_pLoginCheck.setText("PIN Incorrect");
    	}
    }


    @FXML
    void btn_input0(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "0";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input1(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "1";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input2(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "2";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input3(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "3";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input4(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "4";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input5(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "5";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input6(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "6";
    	tb_pPIN.setText(txtPIN);
    }
    
    @FXML
    void btn_input7(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "7";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input8(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "8";
    	tb_pPIN.setText(txtPIN);
    }

    @FXML
    void btn_input9(ActionEvent event) {
    	txtPIN = tb_pPIN.getText();
    	txtPIN = txtPIN + "9";
    	tb_pPIN.setText(txtPIN);
    }
    
    @FXML
    void pageBackHome(ActionEvent event) throws IOException {
    	Parent selectProfileView = FXMLLoader.load(getClass().getResource("profileSelection.fxml"));
    	Scene selectProfileScene = new Scene(selectProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(selectProfileScene);
    	window.show();
    }

    
}
