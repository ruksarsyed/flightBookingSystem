package com.capg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.CheckinRecord;
import com.capg.model.FlightData;
import com.capg.service.CheckinService;

@RestController
@RequestMapping("/checkin")
public class CheckInController {
	
	@Autowired
	CheckinService service;
	
	@PostMapping("/hello")
	public String print() {
		return "Welcome to checkin";
	}
	
	@GetMapping("/CheckinByPnr/{pnr}")
	public String Checkin(@RequestBody FlightData f,@PathVariable int pnr) {
		return service.Checkinflight(f,pnr);
	}	
	
	@GetMapping("/CheckinById/{checkinId}")
	public Optional<CheckinRecord> checkinbyid(@PathVariable int checkinId){
		return service.getById(checkinId);
	}
	
	
}
