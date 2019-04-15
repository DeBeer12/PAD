package sample.controllers;

import sample.data.DBController;

public class MainController {

    public void initialize(){
        DBController conn = new DBController();
        System.out.println("Lets get the bread");
    }
}
