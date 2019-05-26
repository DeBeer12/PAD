package sample.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.EndGameController;


public class EndGameView {
    private Parent root;
    private Stage stage;
    private EndGameController endGameController;

    private Label title;
    private Label subtitle;

    private Button restartKnop;

    public EndGameView(EndGameController endGameController) {
        root = createRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        this.endGameController = endGameController;
        setupController();
    }

    public Parent createRoot() {
        VBox box = new VBox(10);
        Font font = new Font("Verdana",20);
        title = new Label("Goed gespeeld!");
        title.setStyle("-fx-text-fill: orange");
        title.setFont(font);

        restartKnop = new Button("Nog een potje?");
        restartKnop.setStyle("-fx-text-fill: purple; -fx-background-color: orange");
        restartKnop.setFont(font);

        subtitle = new Label();
        subtitle.setStyle("-fx-text-fill: orange");
        subtitle.setFont(font);

        box.getChildren().addAll(title, subtitle,restartKnop);
        box.setStyle("-fx-background-color: purple");
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public void setupController() {
        endGameController.initialize();
        endGameController.setLabel(subtitle);
        endGameController.restartGame(restartKnop);
    }

    public void show(){
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.setTitle("GAME!!!");
        stage.show();
    }

}
