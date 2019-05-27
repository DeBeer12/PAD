package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.GameController;

import javafx.scene.control.*;


public class GameView {

    private Parent root;
    private GameController gameController;
    private Stage stage;

    Label score;
    Label balls;
    Button knop;

    public GameView(GameController gameController){
        root = createRoot();
        stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./sample/css/game.css");
        stage.setScene(scene);

        this.gameController = gameController;
        setupController();
    }

    public Parent createRoot(){
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        box.getStyleClass().add("box");

        score = new Label();
        score.getStyleClass().add("label-score");

        balls = new Label();
        balls.getStyleClass().add("label-balls");

        knop = new Button("Stop");
        knop.getStyleClass().add("button-knop");

        box.getChildren().addAll(score, balls, knop);

        return box;
    }

    public void setupController(){
        gameController.initialize();
        gameController.resetGame(knop);
        gameController.setScore(score, balls);

    }

    public void show(){
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("TITLESCREEN");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

    public Parent getRoot(){
        return root;
    }

}
