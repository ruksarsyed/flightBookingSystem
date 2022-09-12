package com.capg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.model.CheckinRecord;
import com.capg.model.EmailDetails;
import com.capg.model.FlightData;
import com.capg.repository.checkinrepo;

@Service
public class CheckinService {
	
	@Autowired
	checkinrepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	EmailSenderService email;
	
	//Sender sender;

	private static final String EMAIL_URL="http://localhost:8080/email/send-mail";

	public String Checkinflight(FlightData f, int pnr) {
		CheckinRecord c=new CheckinRecord();
		FlightData f1=restTemplate.getForObject("http://localhost:8003/booking/getbypnr/"+pnr,FlightData.class);
		f1.setCheckin(true);
		c.setFirstName(f1.getP().getFirstname());
		c.setLastName(f1.getP().getLastname());
		c.setFlightNumber(f1.getFlightNumber());
		c.setFlightDate(f1.getBookingDate());
		c.setSeatNumber(f1.getP().getSeatNumber());
		c.setPnr(pnr);
		repo.save(c);
		//int id=repo.save(c).getPnr();
		//sender.send(id);
		String emailBody="Checked In,"+" Seat Number is "+c.getSeatNumber()+", CheckinId is "+c.getCheckinId();
		String emailSubject = "Checkin Confirmation";
		String email="keerthikorrapati01@gmail.com";
		EmailDetails mail = new EmailDetails(email,emailBody,emailSubject);
		restTemplate.postForObject(EMAIL_URL, mail, String.class);
		return "Checked In,"+" Seat Number is "+c.getSeatNumber()+", CheckinId is "+c.getCheckinId();
	}

	public Optional<CheckinRecord> getById(int id) {
		return repo.findById(id);
	}
	
	

}