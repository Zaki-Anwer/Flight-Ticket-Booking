<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <style>   * {
          box-sizing: border-box;
          margin: 0;
          padding: 0;
        }
      
        .nav-bar {
          background-color: white;
          height: 8vh;
          display: flex;
          justify-content: space-around;
          align-items: center;
        }
      
        .nav-bar div a {
          text-decoration: none;
          font-size: 2vw;
          color: #021992;
      
        }
      
      
        .logo {
            width: 170px;
            height: 37px;
           float: right;
          background-image: url("https://www.boeing.com/assets/images/logo.png");
          background-repeat: no-repeat;
          background-size: cover;
        }
         body{
	        background-image:url("https://c.ndtvimg.com/2019-04/ec4fnt5o_indigo-a320neo-ndtv_625x300_17_April_19.jpg?im=Resize=(1230,900)");
            background-size: cover;
            background-repeat: no-repeat;
            height: 100%;
        }
</style>
</head>
<body>
<nav class="nav-bar">
        <div class="logo"></div>
         <div><a href="admin-add-flights.jsp">Admin Add Flight</a></div>
        <div><a href="admin-flight-details.jsp">Flight Details</a></div>
        <div><a href="all-tickets.jsp">Customer Ticket-Details</a></div>
        <div><a href="admin-login.jsp">Logout</a></div>
        
</nav>
</body>
</html>