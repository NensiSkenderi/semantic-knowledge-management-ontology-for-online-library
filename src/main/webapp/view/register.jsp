<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>

   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
    
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="/nensinensi/css/register.css" rel="stylesheet" type="text/css">
		<link href="/nensinensi/css/style.css" rel="stylesheet" type="text/css">
	
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>








	<div class="container" style=" margin-top: 3%;">
 <c:if  test="${empty User}">
    <p>If you already have an account with us, please login at the <a href="/nensinensi/account?action=login">login page</a>.</p>
    <b style="color: red">${message_register}</b> <h1><b style="color: coral;font-size:20px">${registered}</b></h1>
    <form style="text-align: center;" action="account" method="post"  id="register">
</c:if>
<c:if  test="${!empty User}">
    <form style="text-align: center;"  action="updateAccount" method="post"  id="register">  
</c:if>  

 <div class="container-register">
      <h4 class="green-color">Account</h4>
  
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="first_name" value="${User.first_name}" placeholder="First Name"/>
        <div class="input-icon"><i class="fa fa-user"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="last_name" value="${User.last_name}" placeholder="Last Name"/>
        <div class="input-icon"><i class="fa fa-user"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="email" required="required" name="email" value="${User.email}" placeholder="Email Adress"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="password" required="required" name="password" value="${User.password}" placeholder="Password"/>
        <div class="input-icon"><i class="fa fa-key"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="phone_number" value="${User.phone_number}" placeholder="Phone Number"/>
        <div class="input-icon"><i class="fa fa-phone"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="address" value="${User.address}" placeholder="Address"/>
        <div class="input-icon"><i class="fa fa-home"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="city" value="${User.city}" placeholder="City"/>
        <div class="input-icon"><i class="fa fa-map-marker"></i></div>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" required="required" name="country" value="${User.country}" placeholder="Country"/>
        <div class="input-icon"><i class="fa fa-location-arrow"></i></div>
      </div>
     
    </div>
    
    
 
         <c:if  test="${empty User}">
              
          <div class="">
      
      <div class="input-group">
        <input type="checkbox" id="terms" name="agree"/>
        <label style="color : red;float : left;" for="terms">I accept the terms and conditions for signing up to this service, and hereby confirm I have read the privacy policy.</label>
      </div>
    </div>     
          </c:if> 
    <c:if  test="${empty User}">
    <input type="submit" style="background: #7ED321; color: white; "value="Sign Up"></input>
     </c:if> 
    
    <c:if  test="${!empty User}">
    <input type="submit" style="background: #7ED321; color: white; "value="Update Data"></input>
     </c:if> 
    
  </form>
</div> 
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>