package com.flight.flight_ticket_booking.service;

import com.flight.flight_ticket_booking.dao.FlightBookingDao;
import com.flight.flight_ticket_booking.dto.FlightBookingDetails;

public class FlightBookingService {
	
	FlightBookingDao dao=new FlightBookingDao();
	 /*
     * getFlightByPnr
     */
   	
	public FlightBookingDetails getTicket(Long Pnr) {
   		return dao.getTicket(Pnr);
   	}

}
