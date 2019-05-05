package sample.controllers;
import javafx.application.Platform;
import javafx.scene.control.*;
import sample.data.DBController;
import java.awt.event.ActionEvent;

public class LoginController {

    private DBController controller = new DBController();

    public void initialize() {
        System.out.println("Lets get the bread Login");
    }


    public void resetGame(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
            controller.deleteGame();
        });
    }

    public void startGame(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
            controller.deleteGame();
        });
    }

}
