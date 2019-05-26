package sample.controllers;


import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.DBController;
import sample.views.MainView;


public class LoginController {
    private DBController controller = new DBController();

    public void initialize() {
        System.out.println("Lets get the bread Login");
    }


    public void startGame(Button button) {
        button.setOnAction(E -> {
            MainController mainController = new MainController();
            MainView mainView = new MainView(mainController);

            Stage stage = new Stage();
            Scene scene = new Scene(mainView.getRoot());
            stage.setScene(scene);
            stage.show();
            stage.setMinHeight(250);
            stage.setMinWidth(250);
            //stage.setFullScreen(true);
            stage.setTitle("GAME!!!");

            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
        });
    }

}



