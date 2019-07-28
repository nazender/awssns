package com.fleet.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fleet.model.StarShips;

@Repository
public class StarShipDaoImpl {
	
	List<String> shipNameList =  Arrays.asList("Akira","Ambassador","Andromeda","Antares","Apollo","Archer");

	public List<String> getAllShipNames() {

		StarShips starships = new StarShips();

		starships.setStarShipNames(shipNameList);

		return starships.getStarShipNames();
	}
	
	public List<String> updateShipName(String shipName,String newShipname) throws Exception{
		StarShips starships = new StarShips();
		if(!shipNameList.contains(shipName)){
			
			throw new Exception("No ship name found with given name") ;
		}else{	
		
		
		shipNameList.set(shipNameList.indexOf(shipName),newShipname);

		starships.setStarShipNames(shipNameList);
		}
		
		return starships.getStarShipNames();
	}
	
}
