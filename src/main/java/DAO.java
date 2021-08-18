import java.io.File;
import java.sql.*;

public class DAO {
    //Establish a connection to SQLite
    public static Connection connect() {
        Connection conn = null;
        File dbFile = new File("src/clinica.sqlite");
        String database = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        try {
            conn = DriverManager.getConnection(database);
            System.out.println("It does work!");
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

        return conn;
    }
}
