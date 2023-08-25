<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight-Ticket-Booking</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
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
</style>
</head>
<body>
<nav class="nav-bar">
        <div class="logo"><a href="home.jsp"></a></div>
        <div><a href="user-login.jsp">User Login</a></div>
        <div><a href="admin-login.jsp">Admin Login</a></div>
        <div><a href="home.jsp">Home</a></div>
        
</nav>     
</body>
</html>