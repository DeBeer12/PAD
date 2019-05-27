package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import sample.controllers.EndController;
import sample.controllers.LoginController;
import sample.controllers.MainController;
import sample.views.EndView;
import sample.views.LoginView;
import sample.views.MainView;

public class Main extends Application {

    @Override
//    public void start(Stage primaryStage){
//        MainController mainController;
//
//            mainController = new MainController();
//            MainView mainView = new MainView(mainController);
//            mainview.show();
//        primaryStage.show();
//
//    }

    public void start(Stage secondaryStage) {
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);
        loginView.show();


    }

//    public void start(Stage thirdStage){
//        EndController endController = new EndController();
//        EndView endView = new EndView(endController);
//
//        Scene scene = new Scene(endView.getRoot());
//        thirdStage.setScene(scene);
//        scene.getStylesheets().add("./sample/css/end.css");
//        thirdStage.setFullScreenExitHint("");
//        thirdStage.show();
//        thirdStage.setFullScreen(true);
//        thirdStage.setTitle("ENDSCREEN");
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
