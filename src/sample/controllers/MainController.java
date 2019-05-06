package sample.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import sample.data.DBController;

import sample.helpers.StateManger;
import javafx.scene.control.*;
import sample.models.Game;

public class MainController {

    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;

    public void initialize() {
        System.out.println("Lets get the bread");
    }

    public void setScore(Label score, Label balls) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
                score.setText("Score: "+ returnPunten());
                balls.setText("Ballen: " + returnBallen());
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
    }

    private int returnPunten(){
        Game game = controller.getGame();
        gat1 = game.getSensor1();
        gat2 = game.getSensor2();
        gat3 = game.getSensor3();
        gat4 = game.getSensor4();
        gat5 = game.getSensor5();

        int punten = (gat1 * 100) + (gat2 * 100) + (gat3 * 50) + (gat4 * 25) + (gat5 * 0);
        return punten;
    }

    private int returnBallen(){
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
            StateManger.schakelScherm("VIEW_LOGIN_SCHERM");
            controller.deleteGame();
        });
    }

}
