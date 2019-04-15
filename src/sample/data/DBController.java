package sample.data;

import java.sql.*;

//This is the database connection/controller
public class DBController {

    private Connection conn;

    private String ip = "oege.ie.hva.nl";
    private String username = "oosterr4";
    private String password = "XOxZwUxliy/8+0";

    private ResultSet rs;
    private Statement st;

    public DBController() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/zoosterr4", username, password);
            if (conn != null) {
                System.out.println("connection succesfull");
            }
        } catch (SQLException e) {
            System.out.println("failed to connect");
            e.printStackTrace();
        }
    }

    //Query methods below or can be in a seperate class

}