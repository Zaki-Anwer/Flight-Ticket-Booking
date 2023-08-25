package com.flight.flight_ticket_booking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.security.auth.login.LoginContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight.flight_ticket_booking.dao.FlightBookingDao;
import com.flight.flight_ticket_booking.dto.FlightBookingDetails;

@WebServlet(value = "/flightBooking")
public class FlightBookingController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FlightBookingDetails bookingDetails = new FlightBookingDetails();
		
		FlightBookingDao bookingDao = new FlightBookingDao();
		
		String departureTime = req.getParameter("flightDeparture");
		String arrivalTime = req.getParameter("flightArrival");
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Time atime=null;
		Time dtime=null;
		try {
			atime = new Time(dateFormat.parse(arrivalTime).getTime());
			dtime = new Time(dateFormat.parse(departureTime).getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long pnr = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		
		bookingDetails.setPnr(pnr);
		bookingDetails.setName(req.getParameter("name"));
		bookingDetails.setEmail(req.getParameter("email"));
		bookingDetails.setPhone(Long.parseLong(req.getParameter("phone")));
		bookingDetails.setAge(Integer.parseInt(req.getParameter("age")));
		bookingDetails.setGender(req.getParameter("gender"));
		bookingDetails.setPrice(Double.parseDouble(req.getParameter("price")));
		bookingDetails.setFlightSource(req.getParameter("flightSource"));
		bookingDetails.setFlightDestination(req.getParameter("flightDestination"));
		bookingDetails.setDepartureTime(dtime);
		bookingDetails.setArrivalTime(atime);
		bookingDetails.setFlightName(req.getParameter("flightName"));
		bookingDetails.setFlightNumber(Integer.parseInt(req.getParameter("number")));
		
		HttpSession session = req.getSession();
	    String userID = (String) session.getAttribute("userEmail");
		bookingDetails.setUserid(userID);
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("<html><boby>");
		bookingDao.saveBookingDetails(bookingDetails);
		printWriter.write("<h style='color:green'>Your Ticket Booked successfully</h>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("user-flight-book.jsp");
		dispatcher.include(req, resp);
		printWriter.write("</html></boby>");
	}
}
