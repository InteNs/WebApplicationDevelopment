package register;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
        RequestDispatcher rd;
		String email = req.getParameter("emailreg");
		String password = req.getParameter("passwordreg");
		String lastName = req.getParameter("lastname");
		String surName = req.getParameter("surname");
		String address = req.getParameter("address");
		String country = req.getParameter("country"); 
		System.out.println(email + password + lastName + surName + address + country);
		if(		email!=""
				&& !password.equals("")
				&& !lastName.equals("")
				&& !surName.equals("")
				&& !address.equals("")
				&& !country.equals("")
                && req.getParameter("emailrep").equals(email)
                && req.getParameter("passwordrep").equals(password)){
			//User user = new User(null, email,password,lastName,surName,address,country);
            String file = req.getServletContext().getRealPath("/")+"users.txt";
            BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
			out.write(email +"-"+ password +"-"+ lastName +"-"+ surName +"-"+ address +"-"+ country+ "\n");
            out.close();
            req.setAttribute("succesReg", "<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-top:20px;\">Registratie gelukt.</div>");
            rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
		}
		else {
			req.setAttribute("succesReg","<div class=\"alert alert-success\" role=\"alert\" style=\"margin-top:20px;\">Registratie mislukt.</div>");
            rd = req.getRequestDispatcher("Registration.jsp");
            rd.forward(req, resp);
		}
	}
}