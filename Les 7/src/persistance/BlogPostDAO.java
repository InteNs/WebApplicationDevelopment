package persistance;

import domain.BlogPost;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class BlogPostDAO extends BaseDAO {
    private List<BlogPost> selectBlogPosts(String query){
        List<BlogPost> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                results.add(new BlogPost(
                        resultSet.getString("message"),
                        resultSet.getInt("ID")
                        ));

        }catch (SQLException sqle){sqle.printStackTrace();}
        return results;
    }
    public List<BlogPost> getAllBlogPosts() {
        return selectBlogPosts("SELECT * FROM blogsite_db.blogpost");
    }

    public void addBlogPost() {

    }
}
