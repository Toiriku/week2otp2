package com.example.localdemoenkoin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ResourceBundle;

public class BMIApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
    loader.setResources(ResourceBundle.getBundle("com.example.localdemoenkoin.bundle1"));
        Parent root = loader.load();
        stage.setTitle("BMI Calculator - Internationalization Demo");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
