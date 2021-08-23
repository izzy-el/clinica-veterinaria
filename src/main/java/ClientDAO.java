import java.sql.PreparedStatement;

//TODO: on delete method, change it to delete based on the ID, not the name;
//TODO: create the retrieve and update methods;
//TODO: check if everything is good with the Constructor of this class;

public class ClientDAO extends DAO {
    private ClientDAO() {
        ClientDAO.connect();
        ClientDAO.createTable();
    }

    //CRUD starts here
    private void create(String name, String address, String phone, String cep, String email) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("INSERT INTO Client (name, address, phone, cep, email) VALUES (?,?,?,?,?)");
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

    private void delete(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.connect().prepareStatement("DELETE FROM Client WHERE Name = ?");
            statement.setString(1, client.getName());
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
