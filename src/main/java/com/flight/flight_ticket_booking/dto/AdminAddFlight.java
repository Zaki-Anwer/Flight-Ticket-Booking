package com.flight.flight_ticket_booking.dto;

import java.sql.Time;

public class AdminAddFlight {

	private int flightNumber;
	private String flightName;
	private String flightSource;
	private String flightDestination ;
	private Time departureTime; 
	private Time arrivalTime;
	private double flightEconomyPrice;
	private double flightBusinessPrice;
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightSource() {
		return flightSource;
	}
	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getFlightEconomyPrice() {
		return flightEconomyPrice;
	}
	public void setFlightEconomyPrice(double flightEconomyPrice) {
		this.flightEconomyPrice = flightEconomyPrice;
	}
	public double getFlightBusinessPrice() {
		return flightBusinessPrice;
	}
	public void setFlightBusinessPrice(double flightBusinessPrice) {
		this.flightBusinessPrice = flightBusinessPrice;
	}
	
	
	
}
