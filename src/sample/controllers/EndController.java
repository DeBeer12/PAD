package sample.controllers;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.data.DBController;
import sample.models.Game;
import sample.views.EndView;
import sample.views.GameView;
import sample.views.LoginView;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class EndController {
    private GameController gameController = new GameController();
    private DBController controller = new DBController();

    private String soundfile = "src/sample/resources/victory.wav";
    private String soundfile2 = "src/sample/resources/klik.wav";
    private Media media = new Media(new File(soundfile).toURI().toString());
    private Media media2 = new Media(new File(soundfile2).toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(media);
    private MediaPlayer mediaPlayer2 = new MediaPlayer(media2);

    public void initialize() {
        System.out.println("Let's get the bread end-screen");
        mediaPlayer.play();

    }

    public void showEndScore(Label punten) {
        punten.setText("" + gameController.returnPunten());
    }


    public void sendScore(Button yes, Button no, Label punten, TextField naam){
        yes.setOnAction(e ->{
            mediaPlayer2.play();
            controller.insertScore(controller.getGame().getId(), naam.getText(), Integer.parseInt(punten.getText()));
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            Stage thisStage = (Stage) yes.getScene().getWindow();
            thisStage.close();
            loginView.show();
            controller.deleteGame();
        });

        no.setOnAction(e -> {
            mediaPlayer.play();
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            Stage thisStage = (Stage) yes.getScene().getWindow();
            thisStage.close();
            loginView.show();
            controller.deleteGame();
        });
    }

}
