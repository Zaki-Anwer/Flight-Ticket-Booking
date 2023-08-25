<%@page import="java.io.FileWriter"%>
<%@page import="com.flight.flight_ticket_booking.dto.FlightBookingDetails"%>
<%@page import="com.flight.flight_ticket_booking.dao.FlightBookingDao"%>
<%@page import="com.flight.flight_ticket_booking.dto.AdminAddFlight"%>
<%@page import="java.util.List"%>
<%@page import="com.flight.flight_ticket_booking.dao.AdminAddFlightDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <style>
        * {
            margin: 0px;
            padding: 0px;
           
            box-sizing: border-box;
        }

       

        .img {
            border: 2px solid gray;
            border-radius: 50%;
            height: 60px;
            width: 60px;
        }

        .filter {
            position: absolute;
            right: 0px;
            left: 0px;
            top: 0px;
            bottom: 0px;
            z-index: 1;
            opacity: .7;
            background: rgb(2, 0, 36);
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(0, 212, 255, 1) 100%);
        }
        
        table {
            position: absolute;
            z-index: 2;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            width: 50%;
            border-collapse: collapse;
            border-spacing: 0px;
            border-radius: 12px 12px 0 0;
            overflow: hidden;
            box-shadow: 0 5px 12px rgba(32, 32, 32, .3);
            background: #fafafa;
            text-align: center;
        }

        td {
            padding: 3px 15px;
        }

        th {
            padding: 10px 15px;
            background: #01749d;
            color: #fafafa;
            text-transform: uppercase;
            font-family: 'Roboto', 'sans-serif';
        }

        td {
            font-family: 'Open sans, ' sans-serif;
            font-size: 17px;
        }

        tr:nth-child(odd) {
            background-color: #eeeeee;
        }

        .heading {
            background-color: #024066;
            color: white;
            font-size: 20px;
        }
       .download {
            text-decoration: none;
            color: white;
            border: 2px solid white;
            background-color: #01749d;
            padding: 10px 15px;
            border-radius: 8px;
        }
       
    </style>

<body >

		<div class="table-box" >
	
			<table>
			 <tr>
                <th colspan="11" class="heading">Passenger Ticket</th>
            </tr>
				<tr class="table-row">
				   
				    <th>Pnr</th>
				    <th>Flight Number</th>	
				    <th>Passenger Name</th>
				    <th>Gender</th>
				    <th>Price</th>
					<th>From</th>
					<th>To</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Download Ticket</th>
				</tr>
				
					
						<tr  class="table-row">
<%-- 							<td><%=bookingDetails.getPnr()%></td>	 --%>
<%-- 							<td><%=bookingDetails.getFlightNumber()%></td> --%>
<%-- 							<td><%=bookingDetails.getName()%></td> --%>
<%-- 							<td><%=bookingDetails.getGender()%></td> --%>
<%-- 							<td><%=bookingDetails.getPrice()%></td>				 --%>
<%-- 		     				<td><%=bookingDetails.getFlightSource() %></td>	 --%>
<%-- 							<td><%=bookingDetails.getFlightDestination() %></td>	 --%>
<%-- 							<td><%=bookingDetails.getDepartureTime() %></td>	 --%>
<%-- 							<td><%=bookingDetails.getArrivalTime() %></td>	 --%>
							
						</tr>
					
					
				
			</table>
		</div>
</body>
</html>