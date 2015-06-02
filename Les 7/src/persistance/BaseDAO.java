package persistance;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class BaseDAO {
     static final String
            DB_URL = "jdbc:mysql://localhost:3306/blogsite_db",
            DB_DRIVER = "com.mysql.jdbc.Driver",
            DB_USERNAME = "root",
            DB_PASSWORD = "root";
    static {
        try {
            Class.forName(DB_DRIVER).newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
