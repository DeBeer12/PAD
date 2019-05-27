package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.MainController;

import javafx.scene.control.*;


public class MainView {

    private Parent root;
    private MainController mainController;
    private Stage stage;

    Label score;
    Label balls;
    Button knop;

    public MainView(MainController mainController){
        root = createRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        this.mainController = mainController;
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
        mainController.initialize();
        mainController.resetGame(knop);
        mainController.setScore(score, balls);

    }

    public void show(){
        stage.setFullScreen(true);
        stage.setTitle("TITLESCREEN");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

    public Parent getRoot(){
        return root;
    }

}
