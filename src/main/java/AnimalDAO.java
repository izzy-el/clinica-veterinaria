import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDAO extends DAO {
    private AnimalDAO() {
        connect();
        createTable();
    }

    private static AnimalDAO instance;

    //Singleton
    public static AnimalDAO getInstance() {
        return (instance == null ? (instance = new AnimalDAO()) : instance);
    }

    //CRUD starts here
    public void create(String name, int age, String gender, Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Animal (Name, Age, Gender, ClientId) VALUES (?,?,?,?)");
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setInt(4, client.getID());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Animal buildObject(ResultSet rs) throws SQLException {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getInt("ClientId")); //rs.getObject("ClientId"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return animal;
    }

    public ArrayList<Animal> retrieve(String query) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                animals.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return animals;
    }

    public ArrayList<Animal> retrieveAll() {
        return this.retrieve("SELECT * FROM Animal");
    }

    public ArrayList<Animal> retrieveById(int id) {
        return this.retrieve("SELECT * FROM Animal WHERE ID = " + id);
    }

    public ArrayList<Animal> retrieveByClientId(int id) {
        return this.retrieve("SELECT * FROM Animal WHERE ClientId = " + id);
    }

    public ArrayList<Animal> retrieveByClientId(Client client) {
        return this.retrieve("SELECT * FROM Animal WHERE ClientId = " + client.getID());
    }

    public void update(Animal animal, Client client) {
        try {
            PreparedStatement statement;
            //Animal (Name, Age, Gender, ClientId) VALUES (?,?,?,?)
            statement = DAO.connect().prepareStatement("UPDATE Animal SET Name = ?, Age = ?, Gender = ?, ClientId = ?");
            statement.setString(1, animal.getName());
            statement.setString(2, String.valueOf(animal.getAge()));
            statement.setString(3, animal.getGender());
            statement.setString(4, String.valueOf(client.getID()));
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Animal animal) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Animal WHERE ID = ?");
            statement.setString(1, String.valueOf(animal.getId()));
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Animal WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
