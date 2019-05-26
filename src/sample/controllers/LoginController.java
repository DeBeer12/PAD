package sample.controllers;


import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.views.GameView;


public class LoginController {

    public void initialize() {
        System.out.println("Lets get the bread Login");
    }


    public void startGame(Button button) {
        button.setOnAction(E -> {
            GameController gameController = new GameController();
            GameView gameView = new GameView(gameController);
            gameView.show();
            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
        });
    }

}



