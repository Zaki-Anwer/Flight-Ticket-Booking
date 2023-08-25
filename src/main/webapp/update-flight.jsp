<%@page import="com.flight.flight_ticket_booking.dao.AdminAddFlightDao"%>
<%@page import="com.flight.flight_ticket_booking.dto.AdminAddFlight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
	
	.common{
		width: 200px;
		height: 30px;
	}
	
	body {
	display: flex;
	flex-direction:column;
	justify-content: center;
	align-items: center;
	   }

</style>

<body>
<%
   int  flightNumber=Integer.parseInt(request.getParameter("flightNumber"));
   AdminAddFlightDao addFlightDao=new AdminAddFlightDao();
   AdminAddFlight addFlight=  addFlightDao.getFlightByNumber(flightNumber);
%>

<div style="color:back;">
		<form action="updateFlight" method="post">

		<!-- 	<label id="myflight">Flight-Number</label><br> -->
			<input type="number" placeholder="enter flight number" name="flightNumber" class="common" hidden="true" value="<%=addFlight.getFlightNumber() %>" ><br>
			
			<label id="Name">Flight-Name</label><br>
			<input type="text" placeholder="enter flight name" name="flightName" class="common" value="<%=addFlight.getFlightName() %>" ><br>
			
			<label id="Source">Flight-Source</label><br>
			<input type="text" placeholder="enter flight source" name="flightSource" class="common" value="<%=addFlight.getFlightSource()%>" ><br>
			
			<label id="Destination">Flight-Destination</label><br>
			<input type="text" placeholder="enter flight destination" name="flightDestination" class="common" value="<%=addFlight.getFlightDestination()%>" ><br>
			
			<label id="departure">Flight-Departure-Time</label><br>
			<input type="time" placeholder="enter flight departure time" name="flightDeparture" class="common" value="<%=addFlight.getDepartureTime()%>" ><br>
			
			<label id="arrival">Flight-Arrival-Time</label><br>
			<input type="time" placeholder="enter flight arrival time" name="flightArrival" class="common" value="<%=addFlight.getArrivalTime()%>" ><br>
			
			<label id="myEconomyPrice">Flight-Economy-Ticket-Price</label><br>
			<input type="decimal" placeholder="enter-flight-economy-ticket-price" name="flightEconomyPrice" class="common" value="<%=addFlight.getFlightEconomyPrice()%>"  ><br>
			
			<label id="myBusinessPrice">Flight-Business-Ticket-Price</label><br>
			<input type="number" placeholder="enter-flight-Business-ticket-price" name="flightBusinessPrice" class="common" value="<%=addFlight.getFlightBusinessPrice()%>" ><br>
			
			
			<!-- <br>
			<select name="ticketType" class="common">
					<option value="">Select Your Class</option>
					<option value="Economy">Economy</option>
					<option value="Business">Business</option>
			</select><br> -->
			<br>
			<input type="submit" value="Update" style="width: 60px; height: 30px; background-color:yellow;" >

		</form>

		</div>
	

</body>
</html>