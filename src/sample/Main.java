package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controllers.EndController;
import sample.views.EndView;

public class Main extends Application {

    @Override
//    public void start(Stage primaryStage){
//        MainController mainController;
//
//            mainController = new MainController();
//            GameView mainView = new GameView(mainController);
//            mainview.show();
//        primaryStage.show();
//
//    }

//    public void start(Stage secondaryStage) {
//        LoginController loginController = new LoginController();
//        LoginView loginView = new LoginView(loginController);
//        loginView.show();
//    }

    public void start(Stage thirdStage){
        EndController endController = new EndController();
        EndView endView = new EndView(endController);
        endView.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
