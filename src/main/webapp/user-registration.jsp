<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
   body{
	background-color: hsla(189, 11%, 88%, 0.959);
	background-repeat: no-repeat;
	 background-size: cover;
}
label {
	width: 100px;
	display: inline-block;
	padding: 4px;
	margin: 8px;
}
input{
 background-color: white;
 height: 30px;
 
}
h2 {
	margin-left:100px;
	
}
#b{
margin-top:5px;
  background-color: lime;
  margin-left:120px;
}

</style>
<body background="https://media.istockphoto.com/id/850049898/vector/man-suffering-from-fear-of-flying.jpg?s=612x612&w=0&k=20&c=cAxpB28p-0UulA7FSy-ZtU1rHexCFpfDGIBelM8Qm-A=" >

<form action="userRegister" method="post">
<div class="" align="center">
<h2>User Registration Form</h2>
           <label id="userName">UserName</label>
           <input type="text" placeholder="enter user name" name="userName"><br>
			
            <label id="userEmail">UserEmail</label>
			<input type="email" placeholder="enter user email" name="userEmail"><br>
			
			
			<label id="userPassword">UserPassword</label>
			<input type="password" placeholder="enter user password" name="userPassword"><br>
			
			<label id="ConfirmPassword">UserPassword</label>
			<input type="password" placeholder="repeat password" name="confirmPassword"><br>
			
			<input type="submit" value="register" id="b">
</div>
</form>
</body>
</html>