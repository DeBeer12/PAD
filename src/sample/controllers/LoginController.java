package sample.controllers;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import sample.data.DBController;
import sample.helpers.StateManger;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class LoginController {
    private BorderPane borderPane;

    private DBController controller = new DBController();

    public void initialize() {
        System.out.println("Lets get the bread Login");
       // StateManger.initialize(this);
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    public void schakelScherm(Parent root) {
        borderPane.setCenter(root);
    }


    public void resetGame(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
            controller.deleteGame();
        });
    }

    public void startGame(Button button) {
        button.setOnAction(e -> {
            StateManger.schakelScherm("VIEW_SPEL_SCHERM");
            controller.deleteGame();
        });
    }

}
