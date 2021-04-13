package it.objectmethod.worldDb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user-name")
public class UserNameServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("insertName");
		
		HttpSession session= req.getSession();
		
		session.setAttribute("logged_user", username);
	
		req.getRequestDispatcher("pages/city-info.jsp").forward(req, resp);
		
		
	}
	
}
