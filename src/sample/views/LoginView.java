package sample.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.controllers.MainController;

public class LoginView {

        private Parent root;
        private LoginController loginController;

        Label title;
        Label subtitle;
        Button knop;
        Button knopStart;

        public LoginView(LoginController loginController){
            root = createRoot();
            this.loginController = loginController;
            setupController();
        }

        public Parent createRoot(){
            //View needs to get modified
            //Add a start game button as well
            VBox box = new VBox(10);

            Font font = new Font("Arial",35);
            Font font2 = new Font("Arial",20);

            title = new Label("Hey daar!");
            title.setTextFill(Color.web("#fff"));
            subtitle = new Label("Klik op 'Start' om te beginnen met spelen");
            subtitle.setTextFill(Color.web("#fff"));
            knopStart = new Button("Start");
            knopStart.setPadding(new Insets(10,50,10,50));
            knop = new Button("Stop");
            knop.setPadding(new Insets(10,50,10,50));


            title.setMinSize(20,20);
            title.setFont(font);

            subtitle.setMinSize(15,15);
            subtitle.setFont(font2);

            box.getChildren().addAll(title, subtitle, knop, knopStart);

            box.setMinHeight(500);
            box.setMinWidth(500);
            box.setPadding(new Insets(10,10,10,10));
            box.setStyle("-fx-background-color: purple;");
            return box;
        }

        public void setupController(){

        }

        public Parent getRoot(){
            return root;
        }

    }