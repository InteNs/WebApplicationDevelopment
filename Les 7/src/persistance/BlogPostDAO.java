package persistance;

import domain.BlogPost;
import domain.service.ServiceProvider;
import domain.service.UserService;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class BlogPostDAO extends BaseDAO {
    private List<BlogPost> selectBlogPosts(String query){
        List<BlogPost> results = new ArrayList<>();
        UserService userService = ServiceProvider.getUserService();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                results.add(new BlogPost(
                        resultSet.getString("message"),
                        userService.getUser(resultSet.getString("username")),
                        resultSet.getTimestamp("timestamp").toLocalDateTime()
                ));


        }catch (SQLException sqle){sqle.printStackTrace();}
        return results;
    }

    public List<BlogPost> getAllBlogPosts() {
        return selectBlogPosts("SELECT * FROM blogsite_db.blogpost ORDER BY timestamp DESC ");
    }

    public void addBlogPost(String message, String userName,LocalDateTime localDateTime) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            final String SQL_INSERT = "INSERT INTO blogsite_db.blogpost (message, username,timestamp)   VALUES(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString     (1,message);
            statement.setString     (2,userName);
            statement.setTimestamp  (3,Timestamp.valueOf(localDateTime));
            if(statement.execute()) System.out.println("blogpost added");
        } catch (SQLException sqle) {sqle.printStackTrace();}
    }
}
