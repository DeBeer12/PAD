package sample.views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controllers.EndGameController;
import sample.controllers.LoginController;

public class EndGameView {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private EndGameController endGameController;

    private Label title;
    private Label subtitle;

    public EndGameView(EndGameController endGameController) {
        root = createRoot();
        this.endGameController = endGameController;
        setupController();
    }

    public Parent createRoot() {
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);

        title = new Label("Goed gespeeld!");

        subtitle = new Label("Score: ");
        box.getChildren().addAll(title, subtitle);
        return box;
    }

    public void setupController() {
        endGameController.initialize();

    }

    public Parent getRoot() {
        return root;
    }

}
