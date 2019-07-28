package com.fleet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fleet.dao.StarShipDaoImpl;
import com.fleet.model.StarShips;


@Repository
public class StarShipService {
	
	@Autowired
	 private StarShipDaoImpl starshipimpl;
	
	public List<String> getAllShipNames() {
		  return starshipimpl.getAllShipNames();
		 }

	public List<String> updatStarShipName(String shipName, String newShipName) throws Exception {
		return starshipimpl.updateShipName(shipName, newShipName);
		
	}

}
