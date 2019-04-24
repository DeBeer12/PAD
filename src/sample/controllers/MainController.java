package sample.controllers;

import javafx.application.Platform;
import sample.data.DBController;
import java.util.Timer;
import java.util.TimerTask;


import javafx.scene.control.*;
import sample.models.Game;

public class MainController {

    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;
    private int ballen = 10;



    public void initialize() {
        System.out.println("Lets get the bread");
        //controller = new DBController();
    }

    public void setScore(Label score, Label balls) {
        Game game = controller.getGame();
        gat1 = game.getSensor1();
        gat2 = game.getSensor2();
        gat3 = game.getSensor3();
        gat4 = game.getSensor4();
        gat5 = game.getSensor5();

        int punten = (gat1 * 100) + (gat2 * 100) + (gat3 * 50) + (gat4 * 25) + (gat5 * 0);
        ballen -= (gat1 + gat2 + gat3 + gat4 + gat5);

        score.setText("Score: " + punten);
        balls.setText("Ballen: " + ballen);

        if (ballen == 0) {
            System.out.println("Finished");
        return;
        }


    }

    public static int returnPunten(){
        Timer labelUpdate = new Timer();
        final int[] punten = new int[1];
        labelUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                Game game = new DBController().getGame();
                int gat1 = game.getSensor1();
                int gat2 = game.getSensor2();
                int gat3 = game.getSensor3();
                int gat4 = game.getSensor4();
                int gat5 = game.getSensor5();

                punten[0] = (gat1 * 100) + (gat2 * 100) + (gat3 * 50) + (gat4 * 25) + (gat5 * 0);
            }
        }, 10);

        return punten[0];
    }

    public void resetGame(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
            controller.deleteGame();
        });
    }

    public int getBallen() {
        return ballen;
    }
}
