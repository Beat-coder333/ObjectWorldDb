package it.objectmethod.worldDb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldDb.dao.ICountryDao;
import it.objectmethod.worldDb.dao.impl.CountryDaoImpl;
import it.objectmethod.worldDb.model.Country;




@WebServlet("/nation-list")
public class GetNationListServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String continent = req.getParameter("continentValue");
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> nationList= new ArrayList<>();
		
		try {
			nationList=countryDao.getNationByContinent(continent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("nationList", nationList);
		req.getRequestDispatcher("pages/continent-select.jsp").forward(req, resp);
		
	}
}
