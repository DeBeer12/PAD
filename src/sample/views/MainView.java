package sample.views;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sample.controllers.MainController;

import javafx.scene.control.*;


public class MainView {

    private Parent root;
    private MainController mainController;

    public MainView(MainController mainController){
        root = createRoot();
        this.mainController = mainController;
        setupController();
    }

    public Parent createRoot(){
        VBox box = new VBox(10);

        int scorePoints = 0;
        int ballsAmount = 0;

        Label score = new Label("Score: " + scorePoints);
        Label balls = new Label("Ballen: " + ballsAmount);

        box.getChildren().addAll(score, balls);

        box.setMinHeight(300);
        box.setMinWidth(300);

        return box;
    }

    public void setupController(){
        mainController.initialize();
    }

    public Parent getRoot(){
        return root;
    }

}
