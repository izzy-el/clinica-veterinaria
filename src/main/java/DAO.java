import java.io.File;
import java.sql.*;

public abstract class DAO {
    private static Connection conn = null;
    protected static final File dbFile = new File("clinica.sqlite");
    protected static final String database = "jdbc:sqlite:" + dbFile.getAbsolutePath();

    //Establish a connection to SQLite
    protected static Connection connect() {
        try {
            conn = DriverManager.getConnection(database);
        } catch(SQLException e) {
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
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }
    }

    protected ResultSet getResultSet(String query) {
        Statement statement;
        ResultSet rs = null;
        try  {
            statement = (Statement) conn.createStatement();
            rs = statement.executeQuery(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    //Create tables if they do not exist
    protected static void createTable() {
        PreparedStatement query;
        try {
            //Animal
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Animal(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Age INTEGER, Gender VARCHAR(255), ClientId INTEGER)");
            query.executeUpdate();

            //Client
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Client(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Address VARCHAR(255), Phone VARCHAR(255), CEP VARCHAR(8), Email VARCHAR(255))");
            query.executeUpdate();

            //Species
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Species(ID INTEGER PRIMARY KEY, Species VARCHAR(255))");
            query.executeUpdate();

            //Treatment
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Treatment(ID INTEGER PRIMARY KEY, IDAnimal INTEGER, Name VARCHAR(255), InitialDate DATE, EndDate DATE, Done VARCHAR(255))");
            query.executeUpdate();

            //Veterinarian
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Veterinarian(ID INTEGER PRIMARY KEY, Name VARCHAR(255), Address VARCHAR(255), Phone VARCHAR(255), Email VARCHAR(255))");
            query.executeUpdate();

            //Exam
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Exam(ID INTEGER PRIMARY KEY, Name VARCHAR(255), ConsultID INTEGER)");
            query.executeUpdate();

            //Appointment
            query = DAO.connect().prepareStatement("CREATE TABLE IF NOT EXISTS Appointment(ID INTEGER PRIMARY KEY, Data TEXT, Horario VARCHAR(255), Comentario VARCHAR(255), IDAnimal INTEGER, IDVet INTEGER, IDTreatment INTEGER, Done INTEGER)");
            query.executeUpdate();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
