import java.io.File;
import java.sql.*;

public abstract class DAO {
    private static Connection conn = null;
    protected static final File dbFile = new File("src/clinica.sqlite");
    protected static final String database = "jdbc:sqlite:" + dbFile.getAbsolutePath();

    //Establish a connection to SQLite
    protected static Connection connect() {
        try {
            conn = DriverManager.getConnection(database);
            System.out.println("It does work!");
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
        return conn;
    }

    //Close connection to the database
    protected static void end() {
        try {
            if(conn != null) {
                conn.close();
                System.out.println("Connection was succesfully closed.");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
