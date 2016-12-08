import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //conn = DriverManager.getConnection("jdbc:mysql://78.47.23.83:3306/tourismb_financer", "tourismb", "093jWqZng5");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/financer?autoReconnect=true&useSSL=false", "root", "");
            st = conn.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void getData() {

    }

}
