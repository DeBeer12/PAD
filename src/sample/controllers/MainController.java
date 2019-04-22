package sample.controllers;

import sample.data.DBController;

import javafx.scene.control.*;

public class MainController {


    public void initialize(){
        System.out.println("Lets get the bread");
        DBController controller = new DBController();
    }

    public void setScore(Label score, Label balls){
        //Algorithm for score and balls here, change the magic numbers to the valeus in the algorithm
        score.setText("Score: " + 50);
        balls.setText("Ballen: " + 500);
    }
}
