package sample.controllers;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.data.DBController;
import sample.models.Game;
import sample.views.EndView;
import sample.views.GameView;
import sample.views.LoginView;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class EndController {
    private GameController gameController = new GameController();
    private DBController controller = new DBController();

    public void initialize() {
        System.out.println("Let's get the bread end-screen");
    }

    public void showEndScore(Label punten) {
        punten.setText("" + gameController.returnPunten());
    }


    public void sendScore(Button yes, Button no, Label punten, TextField naam){
        yes.setOnAction(e ->{
            controller.insertScore(controller.getGame().getId(), naam.getText(), Integer.parseInt(punten.getText()));
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            Stage thisStage = (Stage) yes.getScene().getWindow();
            thisStage.close();
            loginView.show();
            controller.deleteGame();
        });

        no.setOnAction(e -> {
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            Stage thisStage = (Stage) yes.getScene().getWindow();
            thisStage.close();
            loginView.show();
            controller.deleteGame();
        });
    }

}
