package it.objectmethod.worldDb.dao;

import java.util.List;

import it.objectmethod.worldDb.model.Country;

public interface ICountryDao {
	
	public List<Country> getCountryByNationOrContinent(String nationName, String continent);

	public List<Country> getNationByContinent(String continent);
	
}
