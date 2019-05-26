package sample.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.util.Duration;
import sample.data.DBController;
import javafx.stage.Stage;


import javafx.scene.control.*;
import sample.models.Game;
import sample.views.EndGameView;
import sample.views.LoginView;
import sample.views.MainView;

public class MainController {

    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;

    private Timeline timeline;


    public void initialize() {
        System.out.println("Lets get the bread");

    }

    public void setScore(Label score, Label balls) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            score.setText("Score: " + returnPunten());
            balls.setText("Ballen: " + returnBallen());
            if (returnBallen() == 0){
                EndGameController endGameController = new EndGameController();
                EndGameView endGameView = new EndGameView(endGameController);

                Stage stage = new Stage();
                Scene scene = new Scene(endGameView.getRoot());
                stage.setScene(scene);
                stage.show();
                stage.setMinHeight(250);
                stage.setMinWidth(250);
                //stage.setFullScreen(true);
                stage.setTitle("GAME!!!");
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

    public int returnBallen() {
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
            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();

            Stage stage = new Stage();
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            Scene scene = new Scene(loginView.getRoot());
            stage.setScene(scene);
            stage.show();
            //stage.setFullScreen(true);
            stage.setTitle("TITLESCREEN");
            controller.deleteGame();
        });
    }
}


