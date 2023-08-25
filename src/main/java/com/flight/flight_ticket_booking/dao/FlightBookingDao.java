package com.flight.flight_ticket_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flight.flight_ticket_booking.connection.FlightConnection;
import com.flight.flight_ticket_booking.dto.AdminAddFlight;
import com.flight.flight_ticket_booking.dto.FlightBookingDetails;

public class FlightBookingDao {

	Connection connection = FlightConnection.getFlightConnection();
	
	public FlightBookingDetails saveBookingDetails(FlightBookingDetails bookingDetails) {
		
		String insertQuery = "insert into tickets values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		
			preparedStatement.setLong(1, bookingDetails.getPnr());
			preparedStatement.setString(2, bookingDetails.getName());
			preparedStatement.setString(3, bookingDetails.getEmail());
			preparedStatement.setLong(4, bookingDetails.getPhone());
			preparedStatement.setInt(5,   bookingDetails.getAge());
			preparedStatement.setString(6, bookingDetails.getGender());
			preparedStatement.setDouble(7, bookingDetails.getPrice());
			preparedStatement.setString(8, bookingDetails.getFlightSource());
			preparedStatement.setString(9, bookingDetails.getFlightDestination());
			preparedStatement.setTime(10, bookingDetails.getDepartureTime());
			preparedStatement.setTime(11, bookingDetails.getArrivalTime());
			preparedStatement.setString(12,bookingDetails.getFlightName());
			preparedStatement.setInt(13, bookingDetails.getFlightNumber());
			preparedStatement.setString(14, bookingDetails.getUserid());
			preparedStatement.execute();
			
			return bookingDetails;
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return null;
	}
	
     public List<FlightBookingDetails> getAllTickets(){
		
		String displayAllTickets = "SELECT * FROM tickets";
		
		List<FlightBookingDetails> bookingDetails = new ArrayList<FlightBookingDetails>();
		
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement(displayAllTickets);
			ResultSet resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				FlightBookingDetails details = new FlightBookingDetails();
				
				details.setPnr(resultSet.getLong("pnr"));
				details.setName(resultSet.getString("name"));
				details.setEmail(resultSet.getString("email"));
				details.setPhone(resultSet.getLong("phone"));
				details.setAge(resultSet.getInt("age"));
				details.setGender(resultSet.getString("gender"));
				details.setPrice(resultSet.getDouble("price"));
				details.setFlightSource(resultSet.getString("source"));
				details.setFlightDestination(resultSet.getString("destination"));
				details.setDepartureTime(resultSet.getTime("departure"));
				details.setArrivalTime(resultSet.getTime("arrival"));
				details.setFlightName(resultSet.getString("flightname"));
				details.setFlightNumber(resultSet.getInt("flightnumber"));
				
			    bookingDetails.add(details);
			}
			
			return bookingDetails;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
     
     /*
      * getTicktByPnr
      */
    	
    	public FlightBookingDetails getTicket(Long Pnr) {
    	
    		try {
    			String getTicket="select * from tickets where pnr=?";
    			PreparedStatement preparedStatement = connection.prepareStatement(getTicket);
    			preparedStatement.setLong(1, Pnr);
    			ResultSet resultSet=preparedStatement.executeQuery();
    			resultSet.next();
    			FlightBookingDetails details = new FlightBookingDetails();
    			
    			details.setPnr(resultSet.getLong("pnr"));
				details.setName(resultSet.getString("name"));
				details.setEmail(resultSet.getString("email"));
				details.setPhone(resultSet.getLong("phone"));
				details.setAge(resultSet.getInt("age"));
				details.setGender(resultSet.getString("gender"));
				details.setPrice(resultSet.getDouble("price"));
				details.setFlightSource(resultSet.getString("source"));
				details.setFlightDestination(resultSet.getString("destination"));
				details.setDepartureTime(resultSet.getTime("departure"));
				details.setArrivalTime(resultSet.getTime("arrival"));
				details.setFlightName(resultSet.getString("flightname"));
				details.setFlightNumber(resultSet.getInt("flightnumber"));
    			
    			return details;
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return null;
    	}
    	
    	 /*
         * getTicketByEmail
         */
    	 public List<FlightBookingDetails> getTicketByEmail(String email){
    	
    		
     			String getTicket="select * from tickets where userid=?";
     			List<FlightBookingDetails> bookingDetails = new ArrayList<FlightBookingDetails>();
     			
     			PreparedStatement preparedStatement=null;
     			try {
     				preparedStatement = connection.prepareStatement(getTicket);
     				preparedStatement.setString(1, email);
     				ResultSet resultSet  = preparedStatement.executeQuery();
     				
     		    while(resultSet.next()) {
     			FlightBookingDetails details = new FlightBookingDetails();
     			
     			details.setPnr(resultSet.getLong("pnr"));
 				details.setName(resultSet.getString("name"));
 				details.setEmail(resultSet.getString("email"));
 				details.setPhone(resultSet.getLong("phone"));
 				details.setAge(resultSet.getInt("age"));
 				details.setGender(resultSet.getString("gender"));
 				details.setPrice(resultSet.getDouble("price"));
 				details.setFlightSource(resultSet.getString("source"));
 				details.setFlightDestination(resultSet.getString("destination"));
 				details.setDepartureTime(resultSet.getTime("departure"));
 				details.setArrivalTime(resultSet.getTime("arrival"));
 				details.setFlightName(resultSet.getString("flightname"));
 				details.setFlightNumber(resultSet.getInt("flightnumber"));
     			
 				bookingDetails.add(details);
     		    }
     		    
     		    return bookingDetails;
     		    
     			}
     		    catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		return null;
     	}
     	
    	
    	
}
