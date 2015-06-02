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
    // READ
    public List<User> selectSingleUser(String userName, String password) {
        return selectUsers("SELECT * FROM blogsite_db.user WHERE username = '"+userName+"' AND password = '"+password+"'");
    }
    public List<User> selectAllUsers() {
        return selectUsers("SELECT * FROM blogsite_db.user");
    }
}
