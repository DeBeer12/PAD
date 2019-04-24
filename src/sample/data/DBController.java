package sample.data;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

//This is the database connection/controller
public class DBController {

    private Connection conn;

    private String ip = "oege.ie.hva.nl";
    private String username = "oosterr4";
    private String password = "XOxZwUxliy/8+0";

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
        String sql = "SELECT * FROM Gametest";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //Result set contains all the records from Game
            //Need a model for game
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGame(int oldGame, int newGame){
        String sql = "UPDATE Gametest SET gat1 = ?, gat2 = ?, gat3 = ?, gat 4 = ?, gat5 = ? WHERE idGame = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,newGame);
            st.setInt(2,newGame);
            st.setInt(3,newGame);
            st.setInt(4,newGame);
            st.setInt(5,newGame);
            st.setInt(6,oldGame);
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteGame(){
        String sql = "DELETE FROM Gametest";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}