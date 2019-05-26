package sample.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.data.DBController;
import sample.views.GameView;

public class EndGameController {

    private GameController gameController;
    private DBController dbController;

    public void initialize() {
        gameController = new GameController();
        dbController = new DBController();
    }

    public void setLabel(Label label) {
        label.setText("Dit is jouw score: " + gameController.returnPunten());
    }

    public void restartGame(Button button) {
        button.setOnAction(E -> {
            GameController gameController = new GameController();
            GameView gameView = new GameView(gameController);
            gameView.show();
            dbController.deleteGame();
            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
        });

    }
}
