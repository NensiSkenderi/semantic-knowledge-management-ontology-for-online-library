<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
      <meta name="description" content="RealBooks online store">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="/nensinensi/css/font-awesome.css" rel="stylesheet" type="text/css">
	  <link href="/nensinensi/css/admin_login.css" rel="stylesheet" type="text/css">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      
<title>Admin Login</title>
</head>
<body style="background-image:url('/nensinensi/img/bg_admin.jpg');">

	<div class="container" style="margin-top: 3%;">
<center><h1 class="form-heading">Welcome to ALB-Library</h1></center>
<div class="login-form" style="margin-top: 5%;">
<div class="main-div">
    <div class="panel">
   <h2>Admin Login</h2>
   <p>Please enter your email and password</p>
   </div>
    <form action="<c:url value='admin_panel'/>" method="post"  id="loginn" >

        <div class="form-group">


            <input type="email" required="required"  class="form-control" name="email" placeholder="Email Address">

        </div>

        <div class="form-group">

            <input type="password" required="required" class="form-control" name="password" placeholder="Password">

        </div>
        <div class="forgot">
       
</div>
        <button type="submit" style="margin-bottom: 20px;" class="btn btn-primary">Login</button>
		<i style="color: red">${message}</i>
    </form>
    </div>

</div></div></div>

</body>
</html>