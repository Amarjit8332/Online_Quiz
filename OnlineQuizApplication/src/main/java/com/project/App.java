package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/view.fxml"));

        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Online Quiz Application");
        primaryStage.show();
		
	}
}
