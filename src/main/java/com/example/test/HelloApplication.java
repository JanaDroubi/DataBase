package com.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
     //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
      // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/test/hello-view.fxml"));
    //   Scene scene = new Scene(fxmlLoader.load(), 900, 600);


       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();


      // stage.setTitle("Pal_estinian AirLine !");
     //   stage.setResizable(false); // This line makes the window unsizable
     //  stage.setScene(scene);
     //   stage.show();


/*
        try {
             FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */







    }

    public static void main(String[] args) {
        launch();
    }
}



