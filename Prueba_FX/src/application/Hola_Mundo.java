package application;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
//import javafx.scene.control.Button;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;


public class Hola_Mundo extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			
			root.setSpacing(5);
			
			Text msg = new Text("Hola mundo");
			
			Button exitButton = new Button("Exit");
			
			Label lbl1 = new Label("cosas que pasan");
			
			lbl1.setStyle("-fx-text-fill: blue");
			
			exitButton.setOnAction(e -> Platform.exit());
			
			Button btnHolaButton = new Button("di hola");
			
			btnHolaButton.setEffect(new DropShadow());
			btnHolaButton.setRotate(30);
			
			
			TextField tField = new TextField();
			
			btnHolaButton.setOnAction(e -> tField.setText("adios"));
			 
			root.getChildren().addAll(msg,exitButton,lbl1,btnHolaButton,tField);

			
			Scene scene = new Scene(root,300,500);
			
			scene.getStylesheets().add("css/application.css");
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("titulo");
//			primaryStage.initStyle( StageStyle.TRANSPARENT);
//			primaryStage.setOpacity(0.5);
			primaryStage.show();
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
