package sample.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.controllers.GameController;

public class LoginView {

    private Parent root;
    private LoginController loginController;
    private Stage stage;

    Label title;
    Label subtitle;
    Button knopStart;

    public LoginView(LoginController loginController) {
        root = createRoot();
        stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./sample/css/login.css");
        stage.setScene(scene);

        this.loginController = loginController;
        setupController();
    }

    public Parent createRoot() {
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        box.getStyleClass().add("box");

        title = new Label("Awesome Skeeball!");
        title.getStyleClass().add("label-title");

        subtitle = new Label("Klik op 'Start' om te beginnen met spelen");
        subtitle.getStyleClass().add("label-subtitle");

        knopStart = new Button("Start");
        knopStart.getStyleClass().add("button-knopStart");

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

    public void show(){
        //stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("TITLESCREEN");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

}