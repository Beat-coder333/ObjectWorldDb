package it.objectmethod.worldDb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldDb.dao.IContinentDao;
import it.objectmethod.worldDb.dao.impl.ContinentDaoImpl;
import it.objectmethod.worldDb.model.Continent;


@WebServlet("/continent-select")
public class GetContinentsListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IContinentDao continentDao = new ContinentDaoImpl();
		List<Continent> listContinets = new ArrayList<>();
		
		try {
			listContinets = continentDao.getListContinent();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("ContinentList", listContinets);
		req.getRequestDispatcher("pages/continent-select.jsp").forward(req, resp);
	}

}
