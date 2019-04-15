package sample.views;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import sample.controllers.MainController;

public class MainView {

    private Parent root;
    private MainController mainController;

    public MainView(MainController mainController){
        root = createRoot();
        this.mainController = mainController;
        setupController();
    }

    public Parent createRoot(){
        return new StackPane();
    }

    public void setupController(){
        mainController.initialize();
    }

    public Parent getRoot(){
        return root;
    }

}
