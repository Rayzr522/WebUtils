package com.rayzr522.webutils.test;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Rayzr
 *
 */
public class Login extends Application {
    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
	actiontarget.setText("Sign in button pressed");
    }

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

	Parent root = FXMLLoader.load(getClass().getResource("/fxml_example.fxml"));

	Scene scene = new Scene(root, 300, 275);

	stage.setTitle("FXML Welcome");
	stage.setScene(scene);
	stage.show();

    }
}
