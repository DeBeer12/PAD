package sample.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controllers.EndController;


public class EndView {

    private Parent root;
    private EndController endController;
    private Stage stage;

    private Label title;
    private Label punten;
    private Label subtitle;
    private Label restartGame;

    private Button yes;
    private Button no;
    private TextField naam;


    public EndView(EndController endController) {
        root = createRoot();
        stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./sample/css/end.css");
        stage.setScene(scene);
        this.endController = endController;
        setupController();
    }

    public Parent createRoot() {
        //View needs to get modified
        //Add a start game button as well
        VBox box = new VBox(10);
        box.getStyleClass().add("box");
        Label titel = new Label("Awesome Skeeball!");
        titel.getStyleClass().add("label-title");

        title = new Label("Je hebt ");
        title.getStyleClass().add("label-title");

        punten = new Label();
        punten.getStyleClass().add("label-punten");

        subtitle = new Label("Punten behaald");
        subtitle.getStyleClass().add("label-subtitle");

        restartGame = new Label("Voer hier je naam in om te kijek hoe hoog je bent geeindigt!");
        restartGame.getStyleClass().add("label-restartGame");

        naam = new TextField();

        HBox hBox = new HBox(20);

        yes = new Button("Ja verstuur!");
        no = new Button("Nee liever niet");

        hBox.getChildren().addAll(yes,no);

        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(titel, title, punten, subtitle,restartGame, naam, hBox);

        return box;
    }

    public void setupController() {
        endController.initialize();
        endController.showEndScore(punten);
        endController.sendScore(yes,no,punten, naam);
    }

    public Parent getRoot() {
        return root;
    }

    public void show(){
        //stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("TITLESCREEN");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

}

