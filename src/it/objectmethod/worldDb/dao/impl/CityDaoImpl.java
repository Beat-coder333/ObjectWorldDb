package it.objectmethod.worldDb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldDb.config.ConnectionFactory;
import it.objectmethod.worldDb.dao.ICityDao;
import it.objectmethod.worldDb.model.City;


public class CityDaoImpl implements ICityDao {

	@Override
	public City getCityByName(String cityName) {

		Connection conn = ConnectionFactory.getConnection();
		City city = null;

		String sql = "SELECT * FROM city WHERE name=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cityName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
				city.setDistrict(rs.getString("District"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;

	}

	@Override
	public List<City> getAllCitiesByNation(String nation) {
		Connection conn = ConnectionFactory.getConnection();
		List<City> cities = new ArrayList<City>();

		String sql = "SELECT * FROM world.city c INNER JOIN world.country c2  ON c.CountryCode = c2.Code \r\n"
				+ "WHERE c2.Name = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nation);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				City city = new City();
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
				cities.add(city);
			}
			rs.close();
			stmt.close();
			conn.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}

}
