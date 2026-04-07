import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bus_reservation?useSSL=false&serverTimezone=UTC",
                "root",
                "2007"   
            );

            System.out.println(" DB Connected");
            return con;

        } catch (Exception e) {
            System.out.println(" DB Error:");
            e.printStackTrace();
            return null;
        }
    }
}