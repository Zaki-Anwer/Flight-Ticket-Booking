<%@page import="com.flight.flight_ticket_booking.dto.AdminAddFlight"%>
<%@page import="java.util.List"%>
<%@page import="com.flight.flight_ticket_booking.dao.AdminAddFlightDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <style>
        * {
            margin: 0px;
            padding: 0px;
            /* outline: 0px; */
            box-sizing: border-box;
        }
        

        /* tr:hover{
            background-color: #eeeeee;
        }  */

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
            width: 60%;
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

        .update {
            text-decoration: none;
            color: white;
            border: 2px solid white;
            background-color: #01749d;
            padding: 10px 15px;
            border-radius: 8px;
        }

        .delete {
            text-decoration: none;
            color: white;
            border: 2px solid white;
            background-color: #d71921;
            padding: 10px 15px;
            border-radius: 8px;
        }
    </style>

<body  >
 

		<%
		    String source=request.getParameter("source");
		    String destination=request.getParameter("destination");
			AdminAddFlightDao addFlightDao = new AdminAddFlightDao();
		
			List<AdminAddFlight> addFlights = addFlightDao.getFlightSourceToDestination(source, destination);
		%>
		 <div class="filter">

      </div>
      <div class="table-box">
			<table>
			
            <tr>
                <th colspan="11" class="heading">Flight Details</th>
            </tr>
            <tr class="table-row">
					<th>Logo</th>
					<th>FlightNumber</th>
					<th>FlightName</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Departure</th>
					<th>Arrival</th>
					<th>EconomyPrice</th>
					<th>BusinessPrice</th>
					<th>BookYourTicket</th>
					
				</tr>
					<%
					for(AdminAddFlight addFlight:addFlights){
				   %>
						<%if(addFlight.getFlightName().equalsIgnoreCase("indigo")){%>
						<tr class="table-row">
							<td><img src="data:image/png;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>	
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					<%if(addFlight.getFlightName().equalsIgnoreCase("vistra")){%>
						<tr class="table-row">
							<td><img src="data:image/jpeg;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>	
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					
					<%if(addFlight.getFlightName().equalsIgnoreCase("SpaceJet")){%>
						<tr class="table-row">
							<td><img src="data:image/png;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>		
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					
					<%if(addFlight.getFlightName().equalsIgnoreCase("Air Aysha")){%>
						<tr class="table-row">
							<td><img src="data:image/png;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>	
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					
					<%if(addFlight.getFlightName().equalsIgnoreCase("Akasha Air")){%>
						<tr class="table-row">
							<td><img src="data:image/png;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>	
								
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					
					<%if(addFlight.getFlightName().equalsIgnoreCase("Air India")){%>
						<tr class="table-row">
							<td><img src="data:image/png;base64,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" style="border-radius:50%;" width="80px" height="60px" alt="indigo"/></td>
							<td><%=addFlight.getFlightNumber()%></td>	
							<td><%=addFlight.getFlightName() %></td>	
							<td><%=addFlight.getFlightSource() %></td>	
							<td><%=addFlight.getFlightDestination() %></td>	
							<td><%=addFlight.getDepartureTime() %></td>	
							<td><%=addFlight.getArrivalTime() %></td>	
							<td><%=addFlight.getFlightEconomyPrice() %></td>	
							<td><%=addFlight.getFlightBusinessPrice() %></td>	
								
							<td><a href="user-flight-book.jsp?flightNumber=<%=addFlight.getFlightNumber()%>" class="update">BookNow</a></td>	
						</tr>
					<%}%>
					
				<%} %>
			</table>
		</div>
</body>
</html>