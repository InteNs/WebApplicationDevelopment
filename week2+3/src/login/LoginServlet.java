package login;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost( HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		boolean succes =false;
        RequestDispatcher rd;
		String email = req.getParameter("email");
        String user = "";
        String file = req.getServletContext().getRealPath("/")+"users.txt";
		String password = req.getParameter("password");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {

                String[]ar = str.split("-");
                if (email.equals(ar[0])&&password.equals(ar[1])){
                    user = ar[3]+" "+ar[2];
                    succes=true;
                    break;
                }
            }

            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        if (succes) {
            //req.setAttribute("succes","<div class=\"alert alert-success\" role=\"alert\" style=\"margin-top:20px;\">Login succesvol.</div>");
            System.out.println("succes");
            rd = req.getRequestDispatcher("welcome.jsp");
            System.out.println(user);
            req.getSession().setAttribute("loggedInRealName",user);
            Cookie c = new Cookie("cEmail", email);
            c.setMaxAge(2000);
            resp.addCookie(c);
            String loggedusers = req.getServletContext().getRealPath("/")+"loggedusers.txt";
            PrintWriter pw = new PrintWriter(new FileWriter(loggedusers));
            pw.println(email);
            pw.flush();
            pw.close();
        } else {
            req.setAttribute("succes","<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-top:20px;\">Verkeerd emailadres en/of wachtwoord.</div>");
            System.out.println("failure");
            rd = req.getRequestDispatcher("");
        }
        rd.forward(req, resp);
	}
}
