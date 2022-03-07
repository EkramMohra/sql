package sql;

import java.sql.*;

public class main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mohra\\OneDrive\\Desktop\\DB.db");
                System.out.println("DB opened successfully");
                Statement stm = conn.createStatement();
                ResultSet result = stm.executeQuery("select * from Movies");
                System.out.println("id " + "title      " + "len " + "year  " + "cost   ");
                while (result.next()) {

                    int id = result.getInt("id");
                    String title = result.getString("title");
                    int len = result.getInt("len");
                    int year = result.getInt("year");
                    int cost = result.getInt("cost");
                    System.out.println(id + " " + title + " " + len + " " + year + " " + cost);
                }
                try {
                    conn.close();
                    stm.close();
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
