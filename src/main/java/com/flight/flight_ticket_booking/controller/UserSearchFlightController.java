package com.flight.flight_ticket_booking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value ="/userSearch")
public class UserSearchFlightController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		RequestDispatcher dispatcher=req.getRequestDispatcher("user-search-flight.jsp");
		dispatcher.forward(req, resp);
	}
	

}
