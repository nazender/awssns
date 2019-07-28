package com.fleet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fleet.model.StarShips;
import com.fleet.service.StarShipService;

@RestController
public class GenericController {
	
	@Autowired  private StarShipService starshipservice ;
//	@Autowired   private StarShips StarShips ;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String sayHello(){
		
		
		return "Hello from StarFleet";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getallstarships")
	public ResponseEntity GetStatShipList(){		
		
		return new ResponseEntity(starshipservice.getAllShipNames(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updatestarshipname")
	public ResponseEntity UpdateStatShipname(	@RequestBody JsonNode requestBody){	
		
		
		try {
			return new ResponseEntity(starshipservice.updatStarShipName(requestBody.get("shipName").asText(), requestBody.get("newShipName").asText()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
