package sample.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.controllers.MainController;

public class LoginView {

    private Parent root;
    private LoginController loginController;

    Label title;
    Label subtitle;
    Button knopStart;

    public LoginView(LoginController loginController) {
        root = createRoot();
        this.loginController = loginController;
        setupController();
    }

    public Parent createRoot() {
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        box.getStyleClass().add("box");

        title = new Label("Hey daar!");
        //title.getStyleClass().add("label-title");

        subtitle = new Label("Klik op 'Start' om te\nbeginnen met spelen");
        //subtitle.getStyleClass().add("label-subtitle");

        knopStart = new Button("Start");
        //knopStart.getStyleClass().add("button-knopStart");

        box.getChildren().addAll(title, subtitle, knopStart);

        return box;
    }

    public void setupController() {
        loginController.initialize();
        loginController.startGame(knopStart);

    }

    public Parent getRoot() {
        return root;
    }

}