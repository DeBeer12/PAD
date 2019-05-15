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
    public void start(Stage primaryStage){
        MainController mainController;

            mainController = new MainController();
            MainView mainView = new MainView(mainController);

            Scene scene = new Scene(mainView.getRoot());
            primaryStage.setScene(scene);

        primaryStage.show();

    }

//    public void start(Stage secondaryStage) {
//        LoginController loginController;
//
//        loginController = new LoginController();
//        LoginView loginView = new LoginView(loginController);
//
//        Scene scene = new Scene(loginView.getRoot());
//        secondaryStage.setScene(scene);
////scene.getStylesheets().add("./sample/css/login.css");
//        secondaryStage.show();
//        secondaryStage.setFullScreen(true);
//        secondaryStage.setTitle("TITLESCREEN");
//        secondaryStage.setFullScreenExitHint("");
//        secondaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

//    }

    public static void main(String[] args) {
        launch(args);
    }
}
