package bonus;

import java.sql.SQLException;

public interface Music {
    String findById(int id) throws SQLException;
    Integer findByName(String name) throws SQLException;
}
