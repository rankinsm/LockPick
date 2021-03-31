package application;

import lpcon.MySQLCon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class profileHome extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("profileHome.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Profile Selection");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		profileCreateController controller = loader.getController();
		}
/*	
	public static void main(String[] args) {
		//launch(args);
		//MySQLCon.connect();
	}
*/	
}


