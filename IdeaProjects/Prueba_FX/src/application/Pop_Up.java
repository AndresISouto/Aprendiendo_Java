package application;

import java.awt.desktop.OpenFilesEvent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pop_Up extends Application
{
	
	 protected static int counter = 0;
     protected Stage lastOpenStage;
	
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		
		try 
		{
			
			VBox root = new VBox();
			
			Button btnopen = new Button("Open");
			
			btnopen.setOnAction(e -> open(++counter));
			
			 root.getChildren().add(btnopen);
             Scene scene = new Scene(root, 400, 400);
             stage.setScene(scene);
             stage.setTitle("The Primary Stage");
             stage.show();
             this.lastOpenStage = stage;
			
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void open(int stageNUmber) {
		Stage stage = new Stage();
		
		stage.setTitle("# "+stageNUmber);
		
		Button btnHola = new Button("Di hola");
		
		btnHola.setOnAction(e -> System.out.println("Hola desde # "+stageNUmber));
		
		 Button openButton = new Button("Open");
         openButton.setOnAction(e -> open(++counter));
         
         VBox root = new VBox();
         root.getChildren().addAll(btnHola, openButton);
         Scene scene = new Scene(root, 200, 200);
         stage.setScene(scene);
         stage.setX(this.lastOpenStage.getX() + 50);
         stage.setY(this.lastOpenStage.getY() + 50);
         this.lastOpenStage = stage;
		
         System.out.println("Before stage.showAndWait(): " + stageNUmber);
         // Show the stage and wait for it to close
         stage.showAndWait();
         System.out.println("After stage.showAndWait(): " + stageNUmber);
	}

}
