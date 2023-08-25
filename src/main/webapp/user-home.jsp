<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body{
       
        background-image: url("https://s3-ap-south-1.amazonaws.com/blogmindler/bloglive/wp-content/uploads/2021/02/26204139/How-to-become-an-Air-Hostess_blog.png");
        background-size: cover;
        background-repeat: no-repeat
       
    }
    h2{
        text-align: center;
        font-size: 30px;
        margin: 25px 0px;
        
      }
      .admin-form{
        /* background-color: rgba(94, 97, 97, 0.5); */
        background-color: #ffffff;
        display: flex;
        flex-direction: column;
        align-items: center;
        position: relative;
        border: 2px solid gainsboro;
        border-radius: 10px;
        height: 75vh;
        width: 700px;
        margin-left: 110px; 
        margin-top: 65px;
        
       
      }
      .input{
        padding: 10px;
        color: aliceblue;

      }
      input{
        text-align: center;
        font-size: 15px;
        font-family: Times New Roman;
        
        
      }
      .fill-up{
        padding: 15px 40px;
        border: 1px solid #2fa8df;
        border-radius: 5px;
        width: 450px;
        margin:10px;
         
       
      }
      .btn{
        padding: 15px 170px;
        margin: 10px 20px;
        color: white;
        background-color: #3b71ca;
        border: 1PX solid #3b71ca;
        border-radius: 5px;
        font-size: 20px;
        font-family: Times New Roman;
    }
</style>
</head>
<body>
	<jsp:include page="user-navbar.jsp"></jsp:include>
	
	<div class="admin-form">
		<form action="userSearch" method="get">
		 <h2>Book a flight</h2>
		     <div class="input">
			<input type="text" placeholder="Enter Your Source" name="source" class="fill-up"><br>
			</div>
			
			<div class="input">
			<input type="text" placeholder="Enter Your Destination" name="destination" class="fill-up"><br>
			</div>
			
			<div class="input">
			<input type="date" name="date" class="fill-up" value="<%=LocalDate.now().plusDays(1)%>"><br>
			</div>
			
			 <div class="sign-up" >
			<input type="submit" class="btn" value="Search-Flights">
			</div>
		</form>
	</div>
</body>
</html>