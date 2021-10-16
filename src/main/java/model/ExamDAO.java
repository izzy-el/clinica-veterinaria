package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamDAO extends DAO {
    private ExamDAO() {
        connect();
        createTable();
    }

    private static ExamDAO instance;

    //Singleton
    public static ExamDAO getInstance() {
        return (instance == null ? (instance = new ExamDAO()) : instance);
    }

    //CRUD starts here
    public void create(String name, int appointmentID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Exam (Name, AppointmentID) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, appointmentID);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Exam buildObject(ResultSet rs) throws SQLException {
        Exam exam = null;
        try {
            exam = new Exam(rs.getString("Name"), rs.getInt("AppointmentID"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return exam;
    }

    public ArrayList<Exam> retrieve(String query) {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                exams.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return exams;
    }

    public ArrayList<Exam> retrieveAll() {
        return this.retrieve("SELECT * FROM Exam");
    }

    public Exam retrieveById(int id) {
        ArrayList<Exam> exams = this.retrieve("SELECT * FROM Exam WHERE ID = " + id);
        return (exams.isEmpty() ? null : exams.get(0));
    }

    public void update(Exam exam) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Exam SET Name = ?, AppointmentID = ?");
            statement.setString(1, exam.getExamName());
            statement.setInt(2, exam.getAppointmentID());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Exam WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}