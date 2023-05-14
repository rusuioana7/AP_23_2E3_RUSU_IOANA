package bonus;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("student");
        config.setPassword("STUDENT");
        config.setMaximumPoolSize(20);
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void rollback() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            System.err.println("Error rolling back transaction: " + e.getMessage());
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}