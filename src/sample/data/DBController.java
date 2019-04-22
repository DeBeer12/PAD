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
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/zoosterr4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,username, password);
            if (conn != null) {
                System.out.println("connection succesfull");
            }
        } catch (SQLException e) {
            System.out.println("failed to connect");
            e.printStackTrace();
        }
    }

    //Query methods below, note that the algorithm of score can be done in here as well
    public void getGame(){
        String sql = "SELECT * FROM Game";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Result set contains all the records from Game
            //Need a model for game
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}