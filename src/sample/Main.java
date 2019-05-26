package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.controllers.MainController;
import sample.views.LoginView;
import sample.views.MainView;

public class Main extends Application {

    @Override
//    public void start(Stage primaryStage){
//        MainController mainController;
//
//            mainController = new MainController();
//            MainView mainView = new MainView(mainController);
//
//            Scene scene = new Scene(mainView.getRoot());
//            primaryStage.setScene(scene);
//            scene.getStylesheets().add("./sample/css/game.css");
//            scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Baloo+Bhai");
//            primaryStage.setTitle("GAME!!!");
//
//        primaryStage.show();
//
//    }

    public void start(Stage secondaryStage) {
        LoginController loginController;

        loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);

        Scene scene = new Scene(loginView.getRoot());
        secondaryStage.setScene(scene);
//        scene.getStylesheets().add("./sample/css/login.css");
//        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Baloo+Bhai");
        //secondaryStage.setFullScreenExitHint("");
        secondaryStage.show();
        //secondaryStage.setFullScreen(true);
        secondaryStage.setMinHeight(250);
        secondaryStage.setMinWidth(250);
        secondaryStage.setTitle("TITLESCREEN");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
