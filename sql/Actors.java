package sql;

import java.sql.*;

public class Actors {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mohra\\OneDrive\\Desktop\\DB.db");
                System.out.println("connect successfully");
                Statement stm = conn.createStatement();
                ResultSet result = stm.executeQuery("select * from Actors");
                while (result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String birthDate = result.getString("birthDate");
                    String firstMovie = result.getString("firstMovieDate");
                    String cityOfBirth = result.getString("cityOfBirth");
                    String isMarried = result.getString("isMarried");
                    System.out.println("[" + id +"\t" + name + birthDate + firstMovie + cityOfBirth + isMarried + "]");
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
