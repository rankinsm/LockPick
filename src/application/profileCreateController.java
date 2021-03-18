package application;

import java.io.IOException;
import java.util.Arrays;

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


public class profileCreateController extends profileHomeController{
	public static String[] pNames = new String[8];
	public static String[] pPins = new String[8];
	public static int pNum = profileNumber;

	@FXML
	private Button btn_pcBack;
	
    @FXML
    private TextField tb_profileName;

    @FXML
    private Button button_createProfile;

    @FXML
    private Text lb_errorMessage;
    
    @FXML
    private PasswordField tb_profilePIN;

    @FXML
    private PasswordField tb_profilePINcheck;

    public static boolean charCheck(PasswordField tb_profilePIN) {
    	String _pin;
    	int check = 0;
    	_pin = tb_profilePIN.getText().toString();
    	for(int i = 0; i < _pin.length(); i++) {
    		if(Character.isDigit(_pin.charAt(i))) {
    			check++;
    		}
    	}
    	if(check == 6) {
    		return true;
    	}
    	return false;
    }    
    
    public static boolean matchCheck(PasswordField tb_profilePIN, PasswordField tb_profilePINcheck) {
		String pass1 = tb_profilePIN.getText().toString();
		String pass2 = tb_profilePINcheck.getText().toString();
		int check = 0;
		for(int i = 0; i < pass1.length(); i++) {
			if(pass1.charAt(i) == (pass2.charAt(i))) {
				check++;
			}
		}
		if(check == 6) {
			return true;
		}
		return false;
    	}  	
    
    @FXML
    void createProfile(ActionEvent event) throws IOException {
    	if(tb_profilePIN.getLength() == 6 && matchCheck(tb_profilePIN, tb_profilePINcheck) && charCheck(tb_profilePIN)) {
    		pNames[0] = tb_profileName.getText().toString();
        	pPins[0] = tb_profilePIN.getText().toString();
    	
        	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileHome.fxml"));
        	Scene profileCreateScene = new Scene(createProfileView);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	button_profile0Create.setDisable(true);
        	button_profile0Create.setText("Disabled");
        	button_pLogin0change.setOpacity(100.0);
        	button_pLogin0change.setDisable(false);
        	button_pLogin0change.setText(pNames[0]);
        	//renameButton(profileNumber);
        	window.setScene(profileCreateScene);
        	window.show();
    	}
    	else if (tb_profilePIN.getLength() != 6){
    		lb_errorMessage.setText("PIN must be 6 digits.");
    	}
    	else if(!matchCheck(tb_profilePIN, tb_profilePINcheck)) {
    		lb_errorMessage.setText("PINs do not match.");

    	}
    	else if (!charCheck(tb_profilePIN)) {
    		lb_errorMessage.setText("PIN can only contain numbers.");
    	}
    	else {
    		lb_errorMessage.setText("There was an error. Please try again later.");
    	}
    }
    
    @FXML
    void pageBack(ActionEvent event) throws IOException {
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("profileHome.fxml"));
    	Scene profileCreateScene = new Scene(createProfileView);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(profileCreateScene);
    	window.show();
    }
    
    
    public Button selectButton(int n) {
    	switch(n) {
    	case 0:
    		return button_profile0;
    	case 1:
    		return button_profile1;
    	case 2:
    		return button_profile2;
    	case 3:
    		return button_profile3;
    	case 4:
    		return button_profile4;
    	case 5:
    		return button_profile5;
    	case 6:
    		return button_profile6;
    	case 7:
    		return button_profile7;
    	}
    	return null;
    }
    
    public void renameButton(int profileNumber) {
    	System.out.println(profileNumber);
    	switch(profileNumber) {
    	case 0:
    		button_profile0.setDisable(true);
    	case 1:
    		button_profile1.setText("Profile2");
    	case 2:
    		button_profile2.setText("Profile3");
    	case 3:
    		button_profile3.setText("Profile4");
    	case 4:
    		button_profile4.setText("Profil5");
    	case 5:
    		button_profile5.setText("Profil6");
    	case 6:
    		button_profile6.setText("Profile7");
    	case 7:
    		button_profile7.setText("Profile8");
    	}
    }

}