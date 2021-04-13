package it.objectmethod.worldDb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldDb.config.ConnectionFactory;
import it.objectmethod.worldDb.dao.IContinentDao;
import it.objectmethod.worldDb.model.Continent;

public class ContinentDaoImpl implements IContinentDao {

	@Override
	public List<Continent> getListContinent() {
		Connection conn = ConnectionFactory.getConnection();
		List<Continent> continentsList = new ArrayList<>();
		
		String sql = "SELECT Continent FROM world.country c\r\n" + "GROUP BY Continent";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			Continent continent = new Continent();
			continent.setName(rs.getString("Continent"));
			continentsList.add(continent);
		}
		rs.close();
		stmt.close();
		conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return continentsList;
	}

}
