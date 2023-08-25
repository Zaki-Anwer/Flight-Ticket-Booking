<%@page import="com.flight.flight_ticket_booking.dto.User"%>
<%@page import="com.flight.flight_ticket_booking.dao.UserDao"%>
<%@page import="com.flight.flight_ticket_booking.dto.AdminAddFlight"%>
<%@page import="com.flight.flight_ticket_booking.dao.AdminAddFlightDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
      html{
        margin: 0px;
        height: 100%;
      }
        body{
          
            background-image: url("https://static.vecteezy.com/system/resources/previews/013/860/756/non_2x/bright-banner-on-the-theme-of-travel-and-flights-set-of-elements-luggage-tickets-plane-flight-attendant-pilot-vector.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            height: 80%;
        }
        h2{
            text-align: center;
            margin: 10px 0px; 
          }
          .passenger-form{
            /* background-color: rgba(94, 97, 97, 0.5); */
            background-color: #ffffff;
            display: flex;
            flex-direction: column;
            align-items: center;
            position: relative;
            border: 2px solid #2fa8df;
            border-radius: 10px;
            height: 90%;
            width: 800px;
            margin-left: 233px; 
            margin-top: 50px;
          }
          .input{
            padding: 5px 0px;
            color: black;
          }
          label{
            width: 150PX;
            display: inline-block;
            font-size: 19px;
          }
          input{
            text-align: center;
            
          }
          .fill-up{
            padding: 12px 40px;
            border: 1px solid #2fa8df;
            border-radius: 5px;
            width: 400px;
           
          }
          select{
            width: 400PX;
            height: 40PX;
            border: 1px solid #2fa8df;
            border-radius: 5px;
            text-align: center;
            font-size: 16px;
          }
          .btn{
            padding: 15px 120px;
            margin-top: 5dpx;
            margin-left: 155px;
            color: white;
           background-color: #3b71ca;
            border: 1PX solid #3b71ca;
            border-radius: 20px;
            font-size: 20px;
            font-family: Times New Roman;
        }
        .price{
         width: 60px;
         text-indent: inherit;
        }

    </style>
</head>

<body>
	<!-- long pnr = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L; -->
<%
	String flightNumber = request.getParameter("flightNumber");
	AdminAddFlightDao addFlightDao = new AdminAddFlightDao();
   	AdminAddFlight addFlight = addFlightDao.getFlightByNumber(Integer.parseInt(flightNumber));
	%>
	<jsp:include page="user-navbar.jsp"></jsp:include>
	 <div class="passenger-form">
	 		<form action="flightBooking" method="post" class="form">
             
            <h2>Enter Passenger Details</h2>
            
            <input type="number" name="number" value="<%=addFlight.getFlightNumber()%>" hidden="true"><br>
			<input type="decimal" placeholder="enter-flight-economy-ticket-price" name="price" class="common" value="<%=addFlight.getFlightEconomyPrice()%>" hidden="true"><br>
			<input type="text" placeholder="enter flight source" name="flightSource" class="common"           value="<%=addFlight.getFlightSource()%>" hidden="true">
			<input type="text" placeholder="enter flight destination" name="flightDestination" class="common" value="<%=addFlight.getFlightDestination()%>" hidden="true">
			<input type="time" placeholder="enter flight departure time" name="flightDeparture" class="common" value="<%=addFlight.getDepartureTime()%>" hidden="true">
			<input type="time" placeholder="enter flight arrival time" name="flightArrival" class="common"     value="<%=addFlight.getArrivalTime()%>" hidden="true">
			<input type="text" placeholder="enter flight name" name="flightName" class="common"                value="<%=addFlight.getFlightName()%>" hidden="true">
			<!-- passenger details -->
			
			<div class="input">
			<label id="PassengerName">PassengerName</label>
		    <input type="text" placeholder="enter passenger name" name="name" class="fill-up">
			</div>
			
			<div class="input">
			<label id="PassengerEmail">PassengerEmail</label>
			<input type="email" placeholder="enter passenger email" name="email" class="fill-up">
			</div>
			<div class="input">
			<label id="PassengerPhone">PassengerPhone</label>
			 <input type="number" placeholder="enter passenger phone" name="phone" class="fill-up">
			</div>
			
			<div class="input">
			<label id="PassengerAge">PassengerAge</label>
			<input type="number" placeholder="enter passenger age" name="age" class="fill-up">
			</div>
			<div class="input">
			<label id="PassengerGender">Gender</label> <input
				type="radio" name="gender" value="Male" >Male<input
				type="radio" name="gender" value="Female" >Female <input
				type="radio" name="gender" value="Other" >Other<br>
			 </div>
			 
<!-- 			  <div class="input"> -->
<!-- 			 <label id="TotalAmount">Select-Class</label> -->
<!-- 			 <input type="text" list="price"> -->
<!-- 			 <datalist id="price"> -->
			
<%-- 			  <option value="<%=addFlight.getFlightEconomyPrice()%>">Economy</option> --%>
<%-- 			  <option value="<%=addFlight.getFlightBusinessPrice()%>">Business</option> --%>
<!-- 			 </datalist> -->

		 
<!-- 			</div> -->
			 <div class="input">
			<label id="TotalAmount">TotalAmount</label>
		    <input type="text"  value="<%=addFlight.getFlightEconomyPrice()%>" class="price" >
			</div>
			
			<br>
			 <div class="sign-up" >
			<button type="submit" class="btn" >BookYourTicket</button>

            </div>
		</form>
		</div>
</body>
</html>