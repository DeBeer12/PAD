package sample.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.GameController;

import javafx.scene.control.*;


public class GameView {

    private Parent root;
    private GameController gameController;

    private Label score;
    private Label balls;
    private Button knop;

    private Stage stage;

    public GameView(GameController gameController){
        root = createRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        this.gameController = gameController;
        setupController();
    }

    public Parent createRoot(){
        VBox box = new VBox(10);
        Font font = new Font("Verdana",20);

        score = new Label();
        score.setFont(font);
        score.setStyle("-fx-text-fill: orange");

        balls = new Label();
        balls.setFont(font);
        balls.setStyle("-fx-text-fill: orange");

        knop = new Button("Stoppen met spelen");
        knop.setStyle("-fx-text-fill: purple; -fx-background-color: orange");
        knop.setFont(font);
        box.getChildren().addAll(score, balls, knop);
        box.setStyle("-fx-background-color: purple");
        box.setAlignment(Pos.CENTER);

        return box;
    }

    public void setupController(){
        gameController.initialize();
        gameController.resetGame(knop);
        gameController.setScore(score, balls);

    }

    public void show(){
        //stage.setFullScreen(true);
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.setTitle("GAME!!!");
        stage.show();
    }

}
