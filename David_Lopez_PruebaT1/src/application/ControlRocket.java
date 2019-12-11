package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class ControlRocket {
	
	@FXML
	ImageView logoLabel;
	
	@FXML
	AnchorPane rootPane;

	
	public void initialize() {
		
		animation();

	}

	private void animation() {		

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), logoLabel);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();

		
	}
	
	@FXML
	public void openStage() {
		
		closeApp();
		
		try {
			
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Urano.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage sendStage = new Stage();    
            Scene scene = new Scene(page);  
            sendStage.setScene(scene);          
            sendStage.show();
		

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void closeApp() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
	    thisStage.close();	
	}

}
