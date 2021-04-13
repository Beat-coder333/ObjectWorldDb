package it.objectmethod.worldDb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldDb.dao.ICityDao;
import it.objectmethod.worldDb.dao.impl.CityDaoImpl;
import it.objectmethod.worldDb.model.City;

@WebServlet("/cityservlet")
public class CityInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cityNameReq = req.getParameter("findCity");
		ICityDao cityDao = new CityDaoImpl();
		City city = null;
		try {
			String cityName = cityNameReq;
			city = cityDao.getCityByName(cityName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("city", city );
		req.getRequestDispatcher("pages/city-info.jsp").forward(req, resp);
	}

}
