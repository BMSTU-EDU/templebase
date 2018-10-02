import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/test";
    private final String login = "root";
    private final String password = "password";
    public void run() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
        Connection connection;
        connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
            connection.createStatement().executeQuery("select * from test");
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
            return;
        }
    }
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
