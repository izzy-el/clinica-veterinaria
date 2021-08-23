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
                System.out.println("Connection was successfully closed.");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

//    Execute update statement
//    Not sure what it does. Not going to use for now
//    protected int executeUpdate(PreparedStatement query) throws SQLException {
//        int update;
//        update = query.executeUpdate();
//        return update;
//    }

    //Create tables if they do not exist
    protected final static boolean createTable() {
        PreparedStatement query;
        try {
            //TODO: Create the statements for the following tables/classes: Consult and Exam.
            //Animal
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Animal(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Age INTEGER, Gender INTEGER)");
            query.executeUpdate();

            //Client
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Client(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Address VARCHAR(255), Phone VARCHAR(255), CEP VARCHAR(8), Email VARCHAR(255))");
            query.executeUpdate();

            //Species
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Species(ID INTEGER PRIMARY KEY, Species VARCHAR(255))");
            query.executeUpdate();

            //Treatment
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Treatment(ID INTEGER PRIMARY KEY, IDAnimal INTEGER, Name VARCHAR(255), InitialDate VARCHAR(255), EndDate VARCHAR(255), Done VARCHAR(255))");
            query.executeUpdate();

            //Veterinarian
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Veterinarian(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Address VARCHAR(255), Phone VARCHAR(255))");
            query.executeUpdate();

            return true;
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

        return false;
    }
}
