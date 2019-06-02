package sample.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import sample.data.DBController;
import javafx.stage.Stage;


import javafx.scene.control.*;
import sample.models.Game;
import sample.views.EndView;
import sample.views.LoginView;

import java.io.File;

public class GameController {

    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;

    private String soundfile = "src/sample/resources/game.wav";
    private Media media = new Media(new File(soundfile).toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(media);

    private Timeline timeline;


    public void initialize() {
        System.out.println("Lets get the bread game-screen");
        mediaPlayer.play();

    }

    public void setScore(Label score, Label balls) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            score.setText("Score: " + returnPunten());
            balls.setText("Ballen: " + returnBallen());
            if(returnBallen() == 0){
                EndController endController = new EndController();
                EndView endView = new EndView(endController);
                endView.show();
                Stage thisStage = (Stage) score.getScene().getWindow();
                thisStage.close();
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public int returnPunten() {
        Game game = controller.getGame();
        gat1 = game.getSensor1();
        gat2 = game.getSensor2();
        gat3 = game.getSensor3();
        gat4 = game.getSensor4();
        gat5 = game.getSensor5();

        int punten = (gat1 * 100) + (gat2 * 100) + (gat3 * 50) + (gat4 * 25) + (gat5 * 0);
        return punten;
    }

    private int returnBallen() {
        Game game = controller.getGame();
        gat1 = game.getSensor1();
        gat2 = game.getSensor2();
        gat3 = game.getSensor3();
        gat4 = game.getSensor4();
        gat5 = game.getSensor5();

        int ballen = 10 - (gat1 + gat2 + gat3 + gat4 + gat5);
        return ballen;
    }

    public void resetGame(Button button) {
        button.setOnAction(e -> {
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            loginView.show();

            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
            controller.deleteGame();
        });
    }
}


