package com.flight.flight_ticket_booking.dao;
/*
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flight.flight_ticket_booking.connection.FlightConnection;
import com.flight.flight_ticket_booking.dto.AdminAddFlight;

public class AdminAddFlightDao {

	Connection connection = FlightConnection.getFlightConnection();
	
	/*
	 * addFlight
	 */
	public AdminAddFlight addAdminFlight(AdminAddFlight addFlight) {
		
		
		try {
			String addFlightQuery = "insert into adminaddflight values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(addFlightQuery);
			
			preparedStatement.setInt(1, addFlight.getFlightNumber());
			preparedStatement.setString(2, addFlight.getFlightName());
			preparedStatement.setString(3, addFlight.getFlightSource());
			preparedStatement.setString(4, addFlight.getFlightDestination());
			preparedStatement.setTime(5, addFlight.getDepartureTime());
			preparedStatement.setTime(6, addFlight.getArrivalTime());
			preparedStatement.setDouble(7, addFlight.getFlightEconomyPrice());
			preparedStatement.setDouble(8, addFlight.getFlightBusinessPrice());
			
			preparedStatement.execute();
			
			return addFlight;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	/*
	 * getAllFlight
	 * 
	 */
	public List<AdminAddFlight> getAllFlights(){
		
		String displayAllFlight = "SELECT * FROM adminaddflight";
		
		List<AdminAddFlight> addFlights = new ArrayList<AdminAddFlight>();
		
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement(displayAllFlight);
			ResultSet resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				AdminAddFlight addFlight = new AdminAddFlight();
				
				addFlight.setFlightNumber(resultSet.getInt("number"));
				addFlight.setFlightName(resultSet.getString("flightname"));
				addFlight.setFlightSource(resultSet.getString("source"));
				addFlight.setFlightDestination(resultSet.getString("destination"));
				addFlight.setDepartureTime(resultSet.getTime("departure"));
				addFlight.setArrivalTime(resultSet.getTime("arrival"));
				addFlight.setFlightEconomyPrice(resultSet.getDouble("economyprice"));
				addFlight.setFlightBusinessPrice(resultSet.getDouble("businessprice"));
				
				addFlights.add(addFlight);
			}
			
			return addFlights;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 *delete flight 
	 */
	    public int deleteFlight(int flightNumber ) {
		
		String deleteQuery = "DELETE from adminaddflight where number=?";
		
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(deleteQuery);
			
			preparedStatement.setInt(1, flightNumber);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * update flight details 
	 */
	
	public int updateFlight(AdminAddFlight addFlight) {
		
		
		try {
			String updtate="update adminaddflight set flightname=?, source=?, destination=?, departure=?,arrival=?,economyprice=?,businessprice=? where number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updtate);
			preparedStatement.setString(1, addFlight.getFlightName());
			preparedStatement.setString(2, addFlight.getFlightSource());
			preparedStatement.setString(3, addFlight.getFlightDestination());
			preparedStatement.setTime(4, addFlight.getDepartureTime());
			preparedStatement.setTime(5, addFlight.getArrivalTime());
			preparedStatement.setDouble(6, addFlight.getFlightEconomyPrice());
			preparedStatement.setDouble(7, addFlight.getFlightBusinessPrice());
			preparedStatement.setInt(8, addFlight.getFlightNumber());
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
 /*
  * getFlightByNumber
  */
	
	public AdminAddFlight getFlightByNumber(int flightNumber) {
	
		try {
			String getFlight="select * from adminaddflight where number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(getFlight);
			preparedStatement.setInt(1, flightNumber);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			AdminAddFlight addFlight=new AdminAddFlight();
			
			addFlight.setFlightNumber(resultSet.getInt("number"));
			addFlight.setFlightName(resultSet.getString("flightname"));
			addFlight.setFlightSource(resultSet.getString("source"));
			addFlight.setFlightDestination(resultSet.getString("destination"));
			addFlight.setDepartureTime(resultSet.getTime("departure"));
			addFlight.setArrivalTime(resultSet.getTime("arrival"));
			addFlight.setFlightEconomyPrice(resultSet.getDouble("economyprice"));
			addFlight.setFlightBusinessPrice(resultSet.getDouble("businessprice"));
			
			return addFlight;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * get flight by sourceToDestinatrion
	 * 
	 */
	
	public List<AdminAddFlight> getFlightSourceToDestination(String source,String destination){
		
		List<AdminAddFlight> addFlights=getAllFlights();
		List<AdminAddFlight> filterFightDetails=new ArrayList<AdminAddFlight>();
		for (AdminAddFlight adminAddFlight : addFlights) {
			if(adminAddFlight.getFlightSource().equalsIgnoreCase(source)&&(adminAddFlight.getFlightDestination().equalsIgnoreCase(destination))){
				filterFightDetails.add(adminAddFlight);
			}
		}
		return filterFightDetails;
	}
  
}
