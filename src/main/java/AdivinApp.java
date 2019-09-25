import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdivinApp extends Application {

		private Label primeraLabel;
		private TextField intNum;
		private Button boton;
		private int intentos=0;
		private int num =(int)(Math.random()*100)+1;
		Alert alert;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primeraLabel = new Label ("Introduce un número del 1 al 100");
		
		intNum = new TextField();
		intNum.setPromptText("Introduce un número");
		intNum.setMaxWidth(150);
		
		boton= new Button("Comprobar");
		boton.setDefaultButton(true);
		boton.setOnAction(e -> onbotonAction(e));
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(primeraLabel,intNum,boton);
		
		Scene scene = new Scene(root,320,200);
		
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onbotonAction(ActionEvent e) {
		try {
			int aux=Integer.parseInt(intNum.getText());
			if(aux==num) {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado "+intentos+" intentos. \n Vuelve a jugar y hazlo mejor.");
				num =(int)(Math.random()*100)+1;
				intentos=0;
				alert.showAndWait();
			}
			else if(aux<num && aux<100 && aux > 0) {
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es mayor que "+aux+".\n Vuelve a intentarlo");
				intentos++;
				alert.showAndWait();
			}
			else if(aux>num && aux<100 && aux > 0) {
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es menor que "+aux+".\n Vuelve a intentarlo");
				intentos++;
				alert.showAndWait();
			}
			else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Error");
				alert.setContentText("El número introducido no es válido.");

				alert.showAndWait();
			}
		} catch (NumberFormatException e1) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("No introduzcas texto o dejes el cuadro vacío");

			alert.showAndWait();	
		}
	
	}

	public static void main(String[] args) {
		launch(args);
	}

}
