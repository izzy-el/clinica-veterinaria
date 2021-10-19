package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentDAO extends DAO {
    private AppointmentDAO() {
        connect();
        createTable();
    }

    private static AppointmentDAO instance;

    //Singleton
    public static AppointmentDAO getInstance() {
        return (instance == null ? (instance = new AppointmentDAO()) : instance);
    }

    //CRUD starts here
    public void create(Date date, String time, String comments, int idAnimal, int idVet, int idTreatment, boolean done) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Appointment (Data, Horario, Comentario, IDAnimal, IDVet, IDTreatment, Done) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setDate(1, new java.sql.Date(date.getTime()));
            statement.setString(2, time);
            statement.setString(3, comments);
            statement.setInt(4, idAnimal);
            statement.setInt(5, idVet);
            statement.setInt(6, idTreatment);
            statement.setBoolean(7, done);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Appointment buildObject(ResultSet rs) throws SQLException {
        Appointment appointment = null;
        try {
            appointment = new Appointment(rs.getInt("ID"), rs.getDate("Data"), rs.getString("Horario"), rs.getString("Comentario"), rs.getInt("IDAnimal"), rs.getInt("IDVet"), rs.getInt("IDTreatment"), rs.getBoolean("Done"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return appointment;
    }

    public ArrayList<Appointment> retrieve(String query) {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                appointments.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return appointments;
    }

    public ArrayList<Appointment> retrieveAll() {
        return this.retrieve("SELECT * FROM Appointment");
    }

    public Appointment retrieveById(int id) {
        ArrayList<Appointment> appointments = this.retrieve("SELECT * FROM Appointment WHERE ID = " + id);
        return (appointments.isEmpty() ? null : appointments.get(0));
    }
    
    public ArrayList<Appointment> retrieveByGivenInfo(int idAnimal, int idVet, int idTreatment) {
        return this.retrieve("SELECT * FROM Appointment WHERE IDAnimal = " + idAnimal + " AND IDVet = " + idVet + " AND IDTreatment = " + idTreatment);
    }

    public void update(Appointment appointment) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Appointment SET Data = ?, Horario = ?, Comentario = ?, IDAnimal = ?, IDVet = ?, IDTreatment = ?, Done = ?");
            statement.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
            statement.setString(2, appointment.getTime());
            statement.setString(3, appointment.getComments());
            statement.setInt(4, appointment.getIdAnimal());
            statement.setInt(5, appointment.getIdVet());
            statement.setInt(6, appointment.getIdTreatment());
            statement.setBoolean(7, appointment.isDone());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Appointment WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}