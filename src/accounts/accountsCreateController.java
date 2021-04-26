package accounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.security.*;
import java.security.cert.CertificateException;

import javax.crypto.SecretKey;

public class accountsCreateController extends EnKey {

	//Form Elements
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

    //KeyStore & Key Creation + Storage
    public KeyStore keyMake() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
    	
    	KeyStore keyStore = KeyStore.getInstance("JKS");
    	
    	char[] pass = null;
    	String path = "C:/Program Files/Java/LockPick/Sec/key.jks";
    	keyStore.load(null, pass);
    	
    	java.io.FileOutputStream output = new FileOutputStream(path);
    	keyStore.store(output, pass);
    	
    	keyStore.load(new FileInputStream(path), pass);
    	
    	KeyStore.SecretKeyEntry secret = new KeyStore.SecretKeyEntry(EnKey.keygen());
    	KeyStore.ProtectionParameter pParam = new KeyStore.PasswordProtection(pass);
    	
    	keyStore.setEntry("secretkey", secret, pParam);
    	
    	return keyStore;

    }
    
    //SecretKey Retrieval from KeyStore
    public SecretKey getKey(KeyStore keyStore) throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyStoreException {
    	
    	String path = "C:/Program Files/Java/LockPick/Sec/key.jks";
    	char[] pass = null;
    	
    	keyStore.load(new FileInputStream(path), pass);
    	SecretKey key = (SecretKey) keyStore.getKey("secretkey", pass);
    	return key;
    }
    
    //Universal Encryption Method
    public String encode(String string) throws Exception {
    	
    	SecretKey secret = getKey(keyMake());
    	String Enc = encrypt(string, secret);		//Encrypt to match DB
    	
    	return Enc;
    }
    
    //Error Checking & Form Submission
    @FXML
    void showAccountLogin(ActionEvent event) throws Exception {
		txt_emailNotValid.setText("");
		txt_passRequirements.setText("");

    	if(emailIsValid(tb_email.getText().toString()) && passwordIsValid(tb_accountPassword) && matchCheck(tb_accountPassword, tb_accountPasswordCheck) && fieldsFilled()){
    		Parent accountLoginView = FXMLLoader.load(getClass().getResource("accountsLogin.fxml"));
    		Scene accountLoginScene = new Scene(accountLoginView);
    		inputAccountInfo(); 										//Sends data to DB
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
    
    //Retrieve and insert text box data to DB
    public void inputAccountInfo() throws Exception {
    	String fname = tb_fName.getText().toString();	//First Name
    	String lname = tb_lName.getText().toString();	//Last Name
    	String email = tb_email.getText().toString();	//Email
    	String pass = tb_accountPassword.getText().toString();
    	
    	pass = encode(pass); //Encrypts Password
    	
    	String insert = "insert into tableaccount "
    			+ "(accountFName, accountLName, accountEmail, accountPassword)"
    			+ " VALUES ('"+fname+"','"+lname+"','"+email+"','"+pass+"');";
    	lpcon.MySQLCon.sqlInsert(insert);
    }
    

    
    //Empty Field Check
    public boolean fieldsFilled() {
    	if((tb_fName.getText().length() > 0) && (tb_lName.getText().length() > 0)) {
    		return true;
    	}
		return false;
    }
    
    //Email Validation
    public boolean emailIsValid (String e) {
        return e.contains("@") &&( e.contains(".com") || e.contains(".org") || e.contains(".net") || e.contains(".edu"));
    }
    
    //Password Validation
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
    
    //Password Confirmation
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
