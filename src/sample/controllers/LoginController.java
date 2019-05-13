package sample.controllers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
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


    public void resetGame(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
            controller.deleteGame();
        });
    }

    public void startGame(Button button) throws IOException {
        button.setOnAction  (e -> {
            Parent game_View_Parent = FXMLLoader.load(getClass().getResource("MainView.java"));
            Scene game_View_Scene = new Scene(game_View_Parent);
            Stage app_Stage = (Stage) ((Node) event.getSource().getScene().getWindow());
            app_Stage.setScene(game_View_Scene);
            app_Stage.show();


//            MainController mainController;
//
//            mainController = new MainController();
//            MainView mainView = new MainView(mainController);
//
//            Stage stage = new Stage();
//
//            Scene scene = new Scene(mainView.createRoot());
//            stage.setScene(scene);
//            stage.show();
            controller.deleteGame();
        });
    }

}
