import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
    public void create(int idAnimal, String name, Calendar initialDate, Calendar endDate, boolean done) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Treatment (IDAnimal, Name, InitialDate, EndDate, Done) VALUES (?,?,?,?,?)");
            statement.setInt(1, idAnimal);
            statement.setString(2, name);
            statement.setString(3, String.valueOf(initialDate));
            statement.setString(4, String.valueOf(endDate));
            statement.setBoolean(5, done);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    private Treatment buildObject(ResultSet rs) throws SQLException {
        Treatment treatment = null;
        try {
            Calendar calendar = Calendar.getInstance();
            treatment = new Treatment(rs.getInt("IDAnimal"), rs.getString("Name"), dateToCalendar(rs.getDate("InitialDate")), dateToCalendar(rs.getDate("EndDate")), rs.getBoolean("Done"));
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
        return this.retrieve("SELECT * FROM Treatment WHERE ID = " + id).get(0);
    }

    public void update(Treatment treatment) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Treatment SET IDAnimal = ?, Name = ?, InitialDate = ?, EndDate = ?, Done = ?");
            statement.setInt(1, treatment.getIdAnimal());
            statement.setString(2, treatment.getName());
            statement.setDate(3, (java.sql.Date) calendarToDate(treatment.getInitialDate()));
            statement.setDate(4, (java.sql.Date) calendarToDate(treatment.getEndDate()));
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
