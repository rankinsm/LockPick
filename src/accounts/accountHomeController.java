package accounts;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class accountHomeController {

    @FXML
    private Button btn_createAccount;

    @FXML
    private Button btn_signIn;

    //Open create account page
    @FXML
    void showCreateAccount(ActionEvent event) throws IOException {
    	Parent createProfileView = FXMLLoader.load(getClass().getResource("accountsCreate.fxml"));
    	Scene accountCreateScene = new Scene(createProfileView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountCreateScene);
    	window.show();
    }

    //Open sign in page
    @FXML
    void showSignIn(ActionEvent event) throws IOException {
    	Parent accountLoginView = FXMLLoader.load(getClass().getResource("accountsLogin.fxml"));
    	Scene accountLoginScene = new Scene(accountLoginView);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(accountLoginScene);
    	window.show();
    }

}

