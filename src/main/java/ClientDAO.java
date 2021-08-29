import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends DAO {
    private ClientDAO() {
        connect();
        createTable();
    }

    private static ClientDAO instance;

    //Singleton
    public static ClientDAO getInstance() {
        return (instance == null ? (instance = new ClientDAO()) : instance);
    }

    //CRUD starts here
    public void create(String name, String address, String phone, String cep, String email) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Client (Name, Address, Phone, CEP, Email) VALUES (?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phone);
            statement.setString(4, cep);
            statement.setString(5, email);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Client buildObject(ResultSet rs) throws SQLException {
        Client client = null;
        try {
            client = new Client(rs.getInt("ID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Phone"), rs.getString("CEP"), rs.getString("Email"));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return client;
    }

    public ArrayList<Client> retrieve(String query) {
        ArrayList<Client> clients = new ArrayList<Client>();
        ResultSet rs = getResultSet(query);
        try {
            while(rs.next()){
                clients.add(buildObject(rs));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return clients;
    }

    public ArrayList<Client> retrieveAll() {
        return this.retrieve("SELECT * FROM Client");
    }

    public Client retrieveById(int id) {
        return this.retrieve("SELECT * FROM Client WHERE ID = " + id).get(0);
    }

    public void update(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("UPDATE Client SET Name = ?, Address = ?, Phone = ?, CEP = ?, Email = ?");
            statement.setString(1, client.getName());
            statement.setString(2, client.getAddress());
            statement.setString(3, client.getPhone());
            statement.setString(4, client.getCep());
            statement.setString(5, client.getEmail());
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Client WHERE ID = ?");
            statement.setString(1, String.valueOf(client.getID()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int ID) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Client WHERE ID = ?");
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
