package sample.views;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sample.controllers.MainController;

import javafx.scene.control.*;


public class MainView {

    private Parent root;
    private MainController mainController;

    Label score;
    Label balls;

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

        box.getChildren().addAll(score, balls);

        box.setMinHeight(300);
        box.setMinWidth(300);

        return box;
    }

    public void setupController(){
        mainController.initialize();
        mainController.setScore(score, balls);
    }

    public Parent getRoot(){
        return root;
    }

}
