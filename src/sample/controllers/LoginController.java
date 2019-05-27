package sample.controllers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.data.DBController;
import sample.views.LoginView;
import sample.views.MainView;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    private DBController controller = new DBController();

    public void initialize() {
        System.out.println("Lets get the bread Login");
    }


    public void startGame(Button button) {
        button.setOnAction(E -> {
            MainController mainController = new MainController();
            MainView mainView = new MainView(mainController);
            mainView.show();

            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
        });
    }

}



