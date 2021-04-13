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

@WebServlet("/country-list")
public class CountryListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nationReq = req.getParameter("findNation");
		String continentReq = req.getParameter("findContinent");

		List<Country> listCountries = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		
		try {
			String nation=nationReq;
			String continent=continentReq;
			
			listCountries = countryDao.getCountryByNationOrContinent(nation, continent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("countryList", listCountries );
		req.getRequestDispatcher("pages/country-list.jsp").forward(req, resp);
		

	}

}
