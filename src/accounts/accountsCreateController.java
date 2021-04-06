package accounts;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lpcon.MySQLCon;

public class accountsCreateController {

    @FXML
    private Button btn_accountCreateBack;

    @FXML
    private TextField tb_email;

    @FXML
    private TextField tb_lName;

    @FXML
    private TextField tb_fName;

    @FXML
    private PasswordField tb_accountPassword;

    @FXML
    private PasswordField tb_accountPasswordCheck;

    @FXML
    private Button btn_createAccount;
    
    @FXML
    private Text txt_emailNotValid;

    @FXML
    private Text txt_passRequirements;

    @FXML
    void showAccountLogin(ActionEvent event) throws IOException {
		txt_emailNotValid.setText("");
		txt_passRequirements.setText("");

    	if(emailIsValid(tb_email.getText().toString()) && passwordIsValid(tb_accountPassword) && matchCheck(tb_accountPassword, tb_accountPasswordCheck) && fieldsFilled()){
    		Parent accountLoginView = FXMLLoader.load(getClass().getResource("accountsLogin.fxml"));
    		Scene accountLoginScene = new Scene(accountLoginView);
    		inputAccountInfo();
    		System.out.println("Account Created");
    		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		window.setScene(accountLoginScene);
    		window.show();
    	}
    	else if(!emailIsValid(tb_email.getText().toString())) {
    		txt_emailNotValid.setText("*Email is not valid");
    	}
    	else if(!passwordIsValid(tb_accountPassword)) {
    		txt_passRequirements.setText("*Password does not meet requirements. Passwords must contain a letter, a number and a symbol and must be atleast 8 characters");
    	}
    	else if(!matchCheck(tb_accountPassword, tb_accountPasswordCheck)) {
    		txt_passRequirements.setText("*Passwords do not match");
    	}
    	else if(!fieldsFilled()) {
    		txt_passRequirements.setText("Please fill out all fields to create an account");
    	}
    	else{
    		txt_passRequirements.setText("Error making account, please try again later");
    	}
    }

    @FXML
    void showBackAHome(ActionEvent event) throws IOException {
    	Parent accountHomeView = FXMLLoader.load(getClass().getResource("accountsHome.fxml"));
    	Scene accountHomeScene = new Scene(accountHomeView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountHomeScene);
    	window.show();
    }
    
    public void inputAccountInfo() {
    	String fname = tb_fName.getText().toString();
    	String lname = tb_lName.getText().toString();
    	String email = tb_email.getText().toString();
    	String pass = tb_accountPassword.getText().toString();
    	String insert = "insert into tableaccount "
    			+ "(accountFName, accountLName, accountEmail, accountPassword)"
    			+ " VALUES ('"+fname+"','"+lname+"','"+email+"','"+pass+"');";
    	lpcon.MySQLCon.sqlInsert(insert);
    }
    
    public boolean fieldsFilled() {
    	if((tb_fName.getText().length() > 0) && (tb_lName.getText().length() > 0)) {
    		return true;
    	}
		return false;
    }
    
    public boolean emailIsValid (String e) {
        return e.contains("@") &&( e.contains(".com") || e.contains(".org") || e.contains(".net") || e.contains(".edu"));
    }
    
    public boolean passwordIsValid (PasswordField pass) {
    	String e = pass.getText().toString();
        boolean result = false;
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;
        char[] charChecker = e.toCharArray();
        if (e.length() >= 8) {
            for (int i = 0; i < charChecker.length; i++) {
                if (Character.isDigit(charChecker[i])) {
                hasNumber = true;
                }
                else if (Character.isLetter(charChecker[i])) {
                hasLetter = true;
                }
                else {
                hasSymbol = true;
                }
            }
            result = hasLetter && hasNumber && hasSymbol;
        }
        return result;
    }
    
    public boolean matchCheck(PasswordField tb_pass, PasswordField tb_passcheck) {
		String pass1 = tb_pass.getText().toString();
		String pass2 = tb_passcheck.getText().toString();
		int len = pass1.length();
		int check = 0;
		for(int i = 0; i < pass1.length(); i++) {
			if(pass1.charAt(i) == (pass2.charAt(i))) {
				check++;
			}
		}
		if(check == len) {
			return true;
		}
		return false;
    }

}
