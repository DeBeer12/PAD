package sample.views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controllers.EndController;
import sample.controllers.MainController;


public class EndView {

    private Parent root;
    private EndController endController;
    private Stage stage;

    Label title;
    Label punten;
    Label subtitle;
    Label restartGame;

    public EndView(EndController endController) {
        root = createRoot();
        stage.setScene( new Scene(createRoot()));
        this.endController = endController;
        setupController();
    }

    public Parent createRoot() {
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        box.getStyleClass().add("box");

        title = new Label("Je hebt ");
        title.getStyleClass().add("label-title");

        punten = new Label();
        punten.getStyleClass().add("label-punten");

        subtitle = new Label("Behaald");
        subtitle.getStyleClass().add("label-subtitle");

        restartGame = new Label("Om nog een keer te spelen\ndruk op de start knop");
        restartGame.getStyleClass().add("label-restartGame");


        box.getChildren().addAll(title, punten, subtitle, restartGame);

        return box;
    }

    public void setupController() {
        endController.initialize();
    }

    public Parent getRoot() {
        return root;
    }

    public void show(){
        stage.setFullScreen(true);
        stage.setTitle("TITLESCREEN");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

}

