package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.MainController;
import sample.views.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        MainController mainController;

            mainController = new MainController();
            MainView mainView = new MainView(mainController);

            Scene scene = new Scene(mainView.getRoot());
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
