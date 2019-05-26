package sample.data;

import sample.models.Game;

import java.sql.*;

//This is the database connection/controller
public class DBController {

    private Connection conn;

    private String ip = "oege.ie.hva.nl";
    private String username = "oosterr4";
    private String password = "XOxZwUxliy/8+0";

    private String connectionStatus;


    public DBController() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/zoosterr4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,username, password);
            if (conn != null) {
                connectionStatus = "connection succesfull";
                System.out.println(connectionStatus);
            }
        } catch (SQLException e) {
            connectionStatus = "failed to connect";
            System.out.println(connectionStatus);
            e.printStackTrace();
        }
    }

    public Game getGame(){
        String sql = "SELECT * FROM Gametest WHERE GAMEID <> 1 ";
        Game game = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                game = new Game(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            }else {
                game = new Game(0,0,0,0,0,0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return game;
    }
    public Game getGameDummy(){
        String sql = "SELECT * FROM Gametest WHERE GAMEID = 1 ";
        Game game = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                game = new Game(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            }else {
                game = new Game(0,0,0,0,0,0);
            }

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
        String sql = "DELETE FROM Gametest WHERE GAMEID <> 1";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }
}