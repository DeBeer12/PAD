package sample.data;

import sample.models.Game;

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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

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

    public Game getGame(){
        String sql = "SELECT * FROM Gametest";
        Game game = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            game = new Game(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return game;
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