

import application.profileCreateController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lpcon.MySQLCon;

public class accountsMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("accountsHome.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("LockPick.exe");
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
		
	public static void main(String[] args) {
		MySQLCon.connect();
		if(MySQLCon.isConnected) {
			launch(args);
		}
		else {
			System.out.println("Couldn't connect to LockPick Database");
		}
	}
		

}
