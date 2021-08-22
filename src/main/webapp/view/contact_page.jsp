<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
     <meta name="description" content="Alb Library">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="/nensinensi/css/style.css" rel="stylesheet" type="text/css">
      <link href="/nensinensi/css/register.css" rel="stylesheet" type="text/css">
      <link href="/nensinensi/css/font-awesome.css" rel="stylesheet" type="text/css">
	  <link href="/nensinensi/css/contact_page.css" rel="stylesheet" type="text/css">
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      
<title>Kontakto</title>
</head>
<body style="background-image: url(/nensinensi/img/tirana_map.svg);    background-size: 100%;">
 <jsp:include page="header.jsp"></jsp:include>

<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>

		<div class="wrap-contact100" style="background-color : rgba(255,255,255,0.9)">
			<div class="contact100-form-title" style="background-image: url(/nensinensi/img/bg-01.jpg);">
				<span class="contact100-form-title-1">
					Contact Us
				</span>

				<span class="contact100-form-title-2">
					Feel free to drop us a line below!
				</span>
			</div>

			<form class="contact100-form validate-form"  action="contact_us" method="post"  id="register">
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Full Name:</span>
					<input class="input100" type="text" name="full_name" placeholder="Enter full name">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					<span class="label-input100">Email:</span>
					<input class="input100" type="text" name="email" placeholder="Enter email addess">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Phone is required">
					<span class="label-input100">Phone Number:</span>
					<input class="input100" type="text" name="phone_number" placeholder="Enter phone number">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Message is required">
					<span class="label-input100">Message:</span>
					<textarea class="input100" name="message" placeholder="Your Comment..."></textarea>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>