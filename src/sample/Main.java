package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.controllers.MainController;
import sample.views.LoginView;
import sample.views.MainView;

public class Main extends Application {

    Scene scene1,scene2;

    @Override
    public void start(Stage primaryStage){
        MainController mainController;
        LoginController loginController;

            mainController = new MainController();
            MainView mainView = new MainView(mainController);
        loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);

        Button buttonSwitch = new Button("Go to scene 2");
        buttonSwitch.setOnAction(e -> primaryStage.setScene(scene2));

        //layout
         scene1 = new Scene(mainView.getRoot());

        //layout 2
        scene2 = new Scene (loginView.getRoot());

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Awesome skeeball");
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);



    }
}
