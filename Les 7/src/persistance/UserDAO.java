package persistance;

import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO {

    private List<User> selectUsers(String query){
        List<User> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                results.add(new User(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)

                ));

        }catch (SQLException sqle){sqle.printStackTrace();}
        return results;
    }
    public void insertUsers(String username, String email, String password, String realname, String address, String country){
          final String SQL_INSERT = "INSERT INTO blogsite_db.user (username, email, password, realname, adress, country)  VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1,username);
            statement.setString(2,email);
            statement.setString(3,password);
            statement.setString(4,realname);
            statement.setString(5,address);
            statement.setString(6,country);
            if(statement.execute()) System.out.println("user added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // READ
    public User selectSingleUser(String userName) {
        return selectUsers("SELECT * FROM blogsite_db.user WHERE username = '"+userName+"'").get(0);
    }
    public List<User> selectAllUsers() {
        return selectUsers("SELECT * FROM blogsite_db.user");
    }
}
