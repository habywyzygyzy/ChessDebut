import database.DBConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import singletons.DatabaseConfigSingleton;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseConnectionTest {
    Connection conn;

    @BeforeAll
    void setUp() {
        DBConnection.openConnection();
        conn = DatabaseConfigSingleton.getConn();
    }

    @AfterAll
    void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void closeStateMentShouldCloseStatement() {
        try {
            Statement statement = conn.createStatement();
            statement.close();
            assertTrue(statement.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectTopTenShouldReturnTenRecords() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT TOP 10 * FROM METADATA");
            ResultSet rs = statement.executeQuery();
            int i = 1;
            while (rs.next()) {
                assertEquals(rs.getInt(1), i);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}