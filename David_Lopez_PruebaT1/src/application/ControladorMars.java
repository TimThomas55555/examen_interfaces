package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControladorMars {//controlado del login, es el que pide nombre de usuario y contraseña y pasa las imagenes. Este solo se encarga de pasar las imagenes.

	@FXML
	private Pane pane1;//Cargo los paneles que luego voy a utilizar para ir pasandolos

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;
	
	@FXML
	AnchorPane rootPane;//Este es el id de mi rootpane Principal

	public void initialize() {//Aqui cargo las imágenes para que luego salgan 1 tras otra, todo lo que este en el initialize es lo que se carga primero

		pane1.setStyle("-fx-background-image: url('application/1.jpg')");
		pane2.setStyle("-fx-background-image: url('application/2.jpg')");
		pane3.setStyle("-fx-background-image: url('application/3.jpg')");
		pane4.setStyle("-fx-background-image: url('application/4.jpg')");

		backgroundAnimation();//Es lo que hace la animacion para que pase una imagen tras otra, el carrusel. Esta creada mas abajo

	}
	
	
	@FXML
	public void abrirHomepage() {//el @FXML es que está referenciado en el Scenne Builder y eso significa que esta en el boton On Action para que al pulsar el boton login, vaya a Homepage
		
		cerrarVentana();//Es un metodo que tenemos debajo referenciado.
		
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Urano.fxml"));//carga la vista que deseo, en este caso homepage
            AnchorPane page = (AnchorPane) loader.load();//Cargame otro AnchorPane
            Stage sendStage = new Stage();    
            Scene scene = new Scene(page);            
            sendStage.setScene(scene);          
            sendStage.show();		

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	

	private void backgroundAnimation() {//ESTO ES EL CARRUSEL DE IMAGENES

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pane4);//Fade transition juega con la opacidad
		fadeTransition.setFromValue(1);//1 ES LA OPACIDAD COMPLETA
		fadeTransition.setToValue(0);//0 ES SIN OPACIDAD
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {
					FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition0.setFromValue(0);
					fadeTransition0.setToValue(1);
					fadeTransition0.play();

					fadeTransition0.setOnFinished(event3 -> {
						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);
						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {
							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);
							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {

								backgroundAnimation();//Al final llamamos a la funcion para que vuelva a iniciarse de nuevo
							});

						});

					});

				});
			});

		});

	}
	
	@FXML
	public void cerrarVentana() {//Cierra la ventana en la que estas actualmente
		Stage thisStage = (Stage) rootPane.getScene().getWindow();//Le indico que quiero cerrar en este caso rootPane, que es el de arriba, para indicarle cual es el que quiero cerrar
		thisStage.close();//Cierro, tambien valdría para cerrar cualquier ventana con un boton o con lo que quiera
		
	}
}