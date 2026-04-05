package Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        try {
            EnvLoader.readFileEnv(".env");
            String url = EnvLoader.get("DB_URL");
            String user = EnvLoader.get("DB_USER");
            String password = EnvLoader.get("DB_PASSWORD");

            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
