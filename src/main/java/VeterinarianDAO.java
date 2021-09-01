import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeterinarianDAO extends DAO {
    private VeterinarianDAO() {
        connect();
        createTable();
    }

    private static VeterinarianDAO instance;

    //Singleton
    public static VeterinarianDAO getInstance() {
        return (instance == null ? (instance = new VeterinarianDAO()) : instance);
    }

    //CRUD starts here
    public void create(String vetName, String vetAddress, String vetPhone, String vetEmail) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Veterinarian (Name, Address, Phone, Email) VALUES (?,?,?,?)");
            statement.setString(1, vetName);
            statement.setString(2, vetAddress);
            statement.setString(3, vetPhone);
            statement.setString(4, vetEmail);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Veterinarian buildObject(ResultSet rs) throws SQLException {
        Veterinarian veterinarian = null;
        try {
            veterinarian = new Veterinarian(rs.getString("Name"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Email"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return veterinarian;
    }

    public ArrayList<Veterinarian> retrieve(String query) {
        ArrayList<Veterinarian> veterinarian = new ArrayList<Veterinarian>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                veterinarian.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return veterinarian;
    }

    public ArrayList<Veterinarian> retrieveAll() {
        return this.retrieve("SELECT * FROM Veterinarian");
    }

    public Veterinarian retrieveById(int id) {
        return this.retrieve("SELECT * FROM Veterinarian WHERE ID = " + id).get(0);
    }

    public void update(Veterinarian veterinarian) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Veterinarian SET Name = ?, Address = ?, Phone = ?, Email = ?");
            statement.setString(1, veterinarian.getVetName());
            statement.setString(2, veterinarian.getVetAddress());
            statement.setString(3, veterinarian.getVetPhone());
            statement.setString(4, veterinarian.getVetEmail());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Veterinarian WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

