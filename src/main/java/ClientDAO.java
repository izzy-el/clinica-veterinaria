import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//TODO: create the retrieve and update methods;
//TODO: check if everything is good with the Constructor of this class;

public class ClientDAO extends DAO {
    private ClientDAO() {
        ClientDAO.connect();
        ClientDAO.createTable();
    }

    private static ClientDAO instance;

    //Singleton
    public static ClientDAO getInstance() {
        return (instance == null ? (instance = new ClientDAO()) : instance);
    }

    //CRUD starts here
    protected void create(String name, String address, String phone, String cep, String email) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Client (Name, Address, Phone, CEP, Email) VALUES (?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phone);
            statement.setString(4, cep);
            statement.setString(5, email);
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private Client buildObject(ResultSet rs) throws SQLException {
        Client client = null;
        try {
            client = new Client(rs.getString("Name"), rs.getString("Address"), rs.getString("Phone"), rs.getString("CEP"), rs.getString("Email"));
        } catch(Exception e) {
            System.out.println(e);
        }

        return client;
    }

    protected ArrayList retrieve(String query) {
        ArrayList<Client> clients = new ArrayList<Client>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                clients.add(buildObject(rs));
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        return clients;
    }

    protected ArrayList retrieveAll() {
        return this.retrieve("SELECT * FROM Client");
    }

    protected void update(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Client SET Name = ?, Address = ?, Phone = ?, CEP = ?, Email = ?");
            statement.setString(1, client.getName());
            statement.setString(2, client.getAddress());
            statement.setString(3, client.getPhone());
            statement.setString(4, client.getCep());
            statement.setString(5, client.getEmail());
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    protected void delete(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Client WHERE ID = ?");
            statement.setString(1, String.valueOf(client.getID()));
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Client WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
