package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDAO extends DAO {
    //FIXME: it is necessary to struct this class better, allowing it to get the animal's specie
    // and probably removing the ClientID reference.
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
    public void create(String name, int age, String gender, String specie, int idClient) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Animal (Name, Age, Gender, Specie, IDClient) VALUES (?,?,?,?,?)");
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, specie);
            statement.setInt(5, idClient);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Animal buildObject(ResultSet rs) throws SQLException {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("Specie"), rs.getInt("IDClient")); //rs.getObject("ClientId"));
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

    public Animal retrieveById(int id) {
        ArrayList<Animal> animals = this.retrieve("SELECT * FROM Animal WHERE ID = " + id);
        return (animals.isEmpty() ? null : animals.get(0));
    }

     public ArrayList<Animal> retrieveByClientId(int id) {
         return this.retrieve("SELECT * FROM Animal WHERE IDClient = " + id);
     }
     
     public ArrayList<Animal> retrieveByNameAndClient(String name, int idClient) {
         return this.retrieve(String.format("SELECT * FROM Animal WHERE Name = '%s' AND IDCLient = '%d'", name, idClient));
     }

    public void update(Animal animal) {
        try {
            PreparedStatement statement;
            //model.Animal (Name, Age, Gender, Specie) VALUES (?,?,?,?)
            statement = DAO.connect().prepareStatement("UPDATE Animal SET Name = ?, Age = ?, Gender = ?, Specie = ?, IDClient = ?");
            statement.setString(1, animal.getName());
            statement.setString(2, String.valueOf(animal.getAge()));
            statement.setString(3, animal.getGender());
            statement.setString(4, animal.getSpecie());
            statement.setInt(5, animal.getIdClient());
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(int id, String name, int age, String gender, String specie) {
        try {
            PreparedStatement statement;
            //model.Animal (Name, Age, Gender, Specie) VALUES (?,?,?,?)
            statement = DAO.connect().prepareStatement("UPDATE Animal SET Name = ?, Age = ?, Gender = ?, Specie = ? WHERE ID = ?");
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, specie);
            statement.setInt(5, id);
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
    
    public void deleteBasedOwner(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Animal WHERE IDClient = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}