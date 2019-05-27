package sample.controllers;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.data.DBController;
import sample.models.Game;
import sample.views.EndView;
import sample.views.LoginView;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class EndController {
    private GameController gameController = new GameController();
    private EndView endView;
    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;
    private int totalePunten;


    public void initialize() {
        System.out.println("Let's get the bread end-screen");
        switchToTitle();
    }

    public void showEndScore(Label punten) {
        punten.setText("" + gameController.returnPunten());
    }

    public void switchToTitle() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline = new Timeline(new KeyFrame(Duration.seconds(60), ev -> {
            //if(database var =0){
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            loginView.show();
        }));
        timeline.play();
    }

}
