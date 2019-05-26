package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sample.controllers.MainController;

import javafx.scene.control.*;


public class MainView {

    private Parent root;
    private MainController mainController;

    private Label score;
    private Label balls;
    private Button knop;

    public MainView(MainController mainController){
        root = createRoot();
        this.mainController = mainController;
        setupController();
    }

    public Parent createRoot(){
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        score = new Label();

        balls = new Label();

        knop = new Button("Stoppen met spelen");

        box.getChildren().addAll(score, balls, knop);

        return box;
    }

    public void setupController(){
        mainController.initialize();
        mainController.resetGame(knop);
        mainController.setScore(score, balls);

    }

    public Parent getRoot(){
        return root;
    }


}
