package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.views.LoginView;

public class Main extends Application {

    @Override
//    public void start(Stage primaryStage){
//        GameController mainController;
//
//            mainController = new GameController();
//            GameView mainView = new GameView(mainController);
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
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);
        loginView.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
