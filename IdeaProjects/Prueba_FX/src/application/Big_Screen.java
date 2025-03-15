package application;

import java.awt.desktop.ScreenSleepEvent;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Big_Screen extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		try 
		{
			
			stage.setScene(new Scene(new Group()));
			stage.setTitle("Maximized");
			
			 // Set the position and size of the stage equal to the position and
            // size of the screen
			
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			
			stage.setX(visualBounds.getMinX());
			stage.setY(visualBounds.getMinY());
			stage.setWidth(visualBounds.getWidth());
			stage.setHeight(visualBounds.getHeight());
			
//			stage.setFullScreen(true); esta es de la que hay que salir con esc
			
			stage.show();
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
