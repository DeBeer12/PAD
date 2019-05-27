package sample.controllers;

import java.awt.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.data.DBController;
import sample.models.Game;
import sample.views.LoginView;

public class EndController {
    private MainController mainController = new MainController();
    private DBController controller = new DBController();
    private int gat1;
    private int gat2;
    private int gat3;
    private int gat4;
    private int gat5;
    private int totalePunten;


    public void initialize() {
        System.out.println("Let's get the bread end-screen");
    }

    private void showEndScore(Label punten) {
        /**
         * MOET UIT GAMERECORDS TABEL KOMEN
         */
        punten.setText("" + mainController.returnPunten());
    }

    public void switchToTitle() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(60), ev -> {
            LoginController loginController = new LoginController();
            LoginView loginView = new LoginView(loginController);
            loginView.show();





        }));
    }

}