package it.objectmethod.worldDb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldDb.dao.ICityDao;

import it.objectmethod.worldDb.dao.impl.CityDaoImpl;

import it.objectmethod.worldDb.model.City;

@WebServlet("/city-list")

public class GetCitiesListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nation = req.getParameter("continentValue");
		ICityDao cityDao = new CityDaoImpl();
		List<City> cityList = new ArrayList<>();

		try {
			cityList = cityDao.getAllCitiesByNation(nation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("cityList", cityList);
		req.getRequestDispatcher("pages/continent-select.jsp").forward(req, resp);

	}

}
