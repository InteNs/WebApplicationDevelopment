import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class worldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        try {
            // Register DataBase DriverManager
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Get DataBase Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogsite_db", "root", "root");
            // Query String
            String cityQuery = "SELECT * FROM world_db.city";
            // Query DataBase
            ResultSet resultSet = connection.createStatement().executeQuery(cityQuery);
            // Handle results
            ArrayList<String> cities = new ArrayList<>();
            while(resultSet.next()) {
                cities.add(resultSet.getString("Name"));
            }
            System.out.println(cities);
            req.setAttribute("cities", cities);
        } catch (Exception  e) {
            e.printStackTrace();
        }
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }


}
