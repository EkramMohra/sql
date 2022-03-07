package sql;

import java.sql.*;

public class ActorInMoviesRel {


    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mohra\\OneDrive\\Desktop\\DB.db");
                System.out.println("connect successfully");
                Statement stm=conn.createStatement();
                ResultSet result=stm.executeQuery("select * from ActInMovRel");
                while (result.next()) {
                    int actorId = result.getInt("actorId");
                    String movieId = result.getString("movieId");
                    System.out.println("[" + actorId +"\t" + movieId + "]");
                }
                conn.close();
                stm.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
