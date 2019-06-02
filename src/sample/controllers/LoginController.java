package sample.controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.data.DBController;
import sample.views.GameView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.io.File;

public class LoginController {
    private DBController controller = new DBController();

    private String soundfile = "src//sample/resources/startup.wav";
    private String soundfile2 = "src//sample/resources/klik.wav";
    private Media media = new Media(new File(soundfile).toURI().toString());
    private Media media2 = new Media(new File(soundfile2).toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(media);
    private MediaPlayer mediaPlayer2 = new MediaPlayer(media2);

    public void initialize() {
        System.out.println("Lets get the bread Login");
        mediaPlayer.play();
    }


    public void startGame(Button button) {
        button.setOnAction(E -> {
            mediaPlayer2.play();
            GameController gameController = new GameController();
            GameView gameView = new GameView(gameController);
            gameView.show();

            Stage thisStage = (Stage) button.getScene().getWindow();
            thisStage.close();
        });
    }

}



