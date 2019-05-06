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

    Label score;
    Label balls;
    Label gespeeld;
    Button knop;


    public MainView(MainController mainController){
        root = createRoot();
        this.mainController = mainController;
        setupController();
    }

    public Parent createRoot(){
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);

        Font font = new Font("Arial",50);
        Font font2 = new Font("Arial",25);

        score = new Label();
        balls = new Label();
        gespeeld = new Label();
        knop = new Button("Stop");

        gespeeld.setFont(font2);

        score.setMinSize(50,50);
        score.setFont(font);

        balls.setMinSize(50,50);
        balls.setFont(font2);

        box.getChildren().addAll(score, balls, knop, gespeeld);


        box.setMinHeight(300);
        box.setMinWidth(300);
        box.setPadding(new Insets(10,10,10,10));

        return box;
    }

    public void setupController(){
        mainController.initialize();
        mainController.resetGame(knop);
        mainController.setScore(score, balls, gespeeld);

    }

    public Parent getRoot(){
        return root;
    }

}
