package sample.controllers;

import javafx.application.Platform;
import sample.data.DBController;

import javafx.scene.control.*;

public class MainController {

    DBController controller;

    public void initialize(){
        System.out.println("Lets get the bread");
        controller = new DBController();
    }

    public void setScore(Label score, Label balls){
        //Algorithm for score and balls here, change the magic numbers to the valeus in the algorithm
        score.setText("Score: " + 50);
        balls.setText("Ballen: " + 500);
    }

    public void resetGame(Button button){
        //controller.deleteGame();
        button.setOnAction(e ->{
            Platform.exit();
        });
    }
}
