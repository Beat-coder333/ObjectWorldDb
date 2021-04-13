package it.objectmethod.worldDb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldDb.config.ConnectionFactory;
import it.objectmethod.worldDb.dao.ICountryDao;
import it.objectmethod.worldDb.model.Country;

public class CountryDaoImpl implements ICountryDao {

	public List<Country> getCountryByNationOrContinent(String name, String continent) {
		Connection conn = ConnectionFactory.getConnection();
		List<Country> countries = new ArrayList<Country>();

		String sql = "SELECT Code, Name, Continent, SurfaceArea, Population FROM country"
				+ " WHERE (''= ? OR Name=?) AND ( Continent= ? OR ''=? )";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, name);
			stmt.setString(3, continent);
			stmt.setString(4, continent);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setSurfaceArea(rs.getFloat("SurfaceArea"));
				country.setPopulation(rs.getInt("Population"));
				countries.add(country);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return countries;

	}

	@Override
	public List<Country> getNationByContinent(String continent) {

		Connection conn = ConnectionFactory.getConnection();
		List<Country> nations = new ArrayList<Country>();

		String sql = "SELECT * FROM world.country WHERE Continent = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Country nation = new Country();
				nation.setName(rs.getString("Name"));
				nation.setPopulation(rs.getInt("Population"));
				nations.add(nation);
				
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nations;
	}
}
