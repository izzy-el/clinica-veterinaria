import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TreatmentDAO extends DAO {
    private TreatmentDAO() {
        connect();
        createTable();
    }

    private static TreatmentDAO instance;

    //Singleton
    public static TreatmentDAO getInstance() {
        return (instance == null ? (instance = new TreatmentDAO()) : instance);
    }

    //CRUD starts here
    public void create(int idAnimal, String name, Date initialDate, Date endDate, boolean done) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Treatment (IDAnimal, Name, InitialDate, EndDate, Done) VALUES (?,?,?,?,?)");
            statement.setInt(1, idAnimal);
            statement.setString(2, name);
            statement.setDate(3, new java.sql.Date(initialDate.getTime()));
            statement.setDate(4, new java.sql.Date(endDate.getTime()));
            statement.setBoolean(5, done);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Treatment buildObject(ResultSet rs) throws SQLException {
        Treatment treatment = null;
        try {
            treatment = new Treatment(rs.getInt("IDAnimal"), rs.getString("Name"), rs.getDate("InitialDate"), rs.getDate("EndDate"), rs.getBoolean("Done"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return treatment;
    }

    public ArrayList<Treatment> retrieve(String query) {
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                treatments.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return treatments;
    }

    public ArrayList<Treatment> retrieveAll() {
        return this.retrieve("SELECT * FROM Treatment");
    }

    public Treatment retrieveById(int id) {
        ArrayList<Treatment> treatments = this.retrieve("SELECT * FROM Treatment WHERE ID = " + id);
        return (treatments.isEmpty() ? null : treatments.get(0));
    }

    public void update(Treatment treatment) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Treatment SET IDAnimal = ?, Name = ?, InitialDate = ?, EndDate = ?, Done = ?");
            statement.setInt(1, treatment.getIdAnimal());
            statement.setString(2, treatment.getName());
            statement.setDate(3, treatment.getInitialDate());
            statement.setDate(4, treatment.getInitialDate());
            statement.setBoolean(5, treatment.isDone());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Treatment WHERE ID = ?");
            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
