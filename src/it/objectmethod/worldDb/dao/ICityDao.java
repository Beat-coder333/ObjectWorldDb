package it.objectmethod.worldDb.dao;

import java.util.List;

import it.objectmethod.worldDb.model.City;



public interface ICityDao {
	
	public City getCityByName(String cityName);
	
	public List<City> getAllCitiesByNation(String nation);

}
