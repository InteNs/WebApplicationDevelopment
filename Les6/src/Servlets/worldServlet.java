package Servlets;

import DAO.WorldDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class worldServlet extends HttpServlet {
    private WorldDAO worldDAO;
    @Override
    public void init() throws ServletException {
        try {
            worldDAO = new WorldDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortTable = req.getParameter("button");
        String typeTable = "Country";

        switch (sortTable) {
            case "All Countries": req.setAttribute("list", worldDAO.getAllCountries());
                break;
            case "West European": req.setAttribute("list", worldDAO.getAllWestEuropeanCountries());
                break;
            case "Largest Surface": req.setAttribute("list", worldDAO.getCountryWithLargestSurface());
                break;
            case "Republics":req.setAttribute("list",worldDAO.gatAllRepublics());
                break;
            case "10 Largest Populations": req.setAttribute("list",worldDAO.get10LargestPopulations());
                break;
            case "10 Largest Cities":   req.setAttribute("list",worldDAO.get10LargestCities());
                                        typeTable = "City";
                break;
            default:
        }
        req.setAttribute("typeTable", typeTable);

        RequestDispatcher rd;
        rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }


}
