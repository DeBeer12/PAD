package sample.controllers;

import javafx.application.Platform;
import sample.data.DBController;

import javafx.scene.control.*;
import sample.models.Game;

public class MainController {

    DBController controller = new DBController();
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


        if (ballen == 0){
            System.out.println("Finished");
        }

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
