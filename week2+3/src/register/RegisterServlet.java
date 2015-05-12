package register;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String email = req.getParameter("emailreg");
		String password = req.getParameter("passwordreg");
		String lastName = req.getParameter("lastname");
		String surName = req.getParameter("surname");
		String address = req.getParameter("address");
		String country = req.getParameter("country"); 
		System.out.println(email+password+lastName+surName+address+country);
		if(		email!=null
				&& password  != null
				&& lastName  != null
				&& surName   != null
				&& address   != null
				&& country   != null){
			User user = new User(null, email,password,lastName,surName,address,country);
			FileOutputStream fout = new FileOutputStream("../test.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			System.out.println("test.obj word nu geschreven");
			oos.writeObject(user);
			oos.close();
			req.setAttribute("succesReg","<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-top:20px;\">Registratie gelukt.</div>");
		}
		else {
			req.setAttribute("succesReg","<div class=\"alert alert-success\" role=\"alert\" style=\"margin-top:20px;\">Registratie mislukt.</div>");
		}
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}