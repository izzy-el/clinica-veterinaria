package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpeciesDAO extends DAO{
    private SpeciesDAO() {
        connect();
        createTable();
    }

    private static SpeciesDAO instance;

    //Singleton
    public static SpeciesDAO getInstance() {
        return (instance == null ? (instance = new SpeciesDAO()) : instance);
    }

    //CRUD starts here
    public void create(String species) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Species (Species) VALUES (?)");
            statement.setString(1, species);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Species buildObject(ResultSet rs) throws SQLException {
        Species specie = null;
        try {
            specie = new Species(rs.getString("model.Species"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return specie;
    }

    public ArrayList<Species> retrieve(String query) {
        ArrayList<Species> species = new ArrayList<Species>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                species.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return species;
    }

    public ArrayList<Species> retrieveAll() {
        return this.retrieve("SELECT * FROM model.Species");
    }

    public Species retrieveById(int id) {
        ArrayList<Species> species = this.retrieve("SELECT * FROM model.Species WHERE ID = " + id);
        return (species.isEmpty() ? null : species.get(0));
    }

    public void update(Species specie) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Species SET Species = ?");
            statement.setString(1, specie.getNameSpecies());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Species WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
