package sample.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.LoginController;

public class LoginView {

    private Parent root;
    private LoginController loginController;
    private Stage stage;

    private Label title;
    private Label subtitle;
    private Button knopStart;

    public LoginView(LoginController loginController) {
        root = createRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        this.loginController = loginController;
        setupController();
    }

    public Parent createRoot() {
        VBox box = new VBox(10);
        Font font = new Font("Verdana",20);

        title = new Label("Hey daar!");
        title.setFont(font);
        title.setStyle("-fx-text-fill: orange");

        subtitle = new Label("Klik op 'Start' om te\nbeginnen met spelen");
        subtitle.setFont(font);
        subtitle.setStyle("-fx-text-fill: orange");

        knopStart = new Button("Start");
        knopStart.setStyle("-fx-text-fill: purple; -fx-background-color: orange");
        knopStart.setFont(font);
        box.getChildren().addAll(title, subtitle, knopStart);
        box.setStyle("-fx-background-color: purple");
        box.setAlignment(Pos.CENTER);

        return box;
    }

    public void setupController() {
        loginController.initialize();
        loginController.startGame(knopStart);

    }

    public void show(){
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.setTitle("TITLESCREEN");
        stage.show();
    }


}