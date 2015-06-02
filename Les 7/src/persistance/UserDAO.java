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
    private void insertUsers(String username, String email, String password, String realname, String address, String country){
          final String SQL_INSERT = "INSERT INTO blogsite_db.user"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1,username);
            statement.setString(1,email);
            statement.setString(1,password);
            statement.setString(1,realname);
            statement.setString(1,address);
            statement.setString(1,country);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // READ
    public List<User> selectSingleUser(String userName, String password) {
        return selectUsers("SELECT * FROM blogsite_db.user WHERE username = '"+userName+"' AND password = '"+password+"'");
    }
    public List<User> selectAllUsers() {
        return selectUsers("SELECT * FROM blogsite_db.user");
    }

    public void addUser(String username, String email, String password, String realname, String address, String country) {
                insertUsers(username,email,password,realname,address,country);
        //INSERT INTO `user` VALUES ('admin','admin@admin.nl','admin','admin','admin\'s address 1','admin land');
    }
}
