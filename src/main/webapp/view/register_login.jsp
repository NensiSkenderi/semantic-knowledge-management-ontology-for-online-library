<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
      <meta name="description" content="Alb Library">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="/nensinensi/css/style.css" rel="stylesheet" type="text/css">
      <link href="/nensinensi/css/register.css" rel="stylesheet" type="text/css">
      <link href="/nensinensi/css/font-awesome.css" rel="stylesheet" type="text/css">
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      <title>Welcome</title>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <style>
         .login-content {
         width: 100%;
         overflow: hidden;
         }
         .login-content .right, .login-content .left {
         background: #fff;
         padding: 30px;
         margin-bottom: 30px;
         }
         .login-content .heading {
         overflow: hidden;
         border-bottom: 1px solid #d7d7d7;
         padding-bottom: 10px;
         margin-bottom: 20px;
         }
         .login-content .heading i {
         font-size: 56px;
         color: #f36c4f;
         float: left;
         margin-right: 14px;
         }
         .extra-wrap {
         overflow: hidden;
         }
         a.button-return-left, a.button-return-right, a.button-order-right, a.button-cont-right, a.button-back-left, a.button-inf-left {
         display: inline-block;
         text-decoration: none;
         cursor: pointer;
         padding-right: 0px;
         color: #2a2a2a;
         font-weight: normal;
         vertical-align: top;
         font-size: 14px;
         line-height: 30px;
         font-family: 'Cabin',sans-serif;
         text-transform: uppercase;
         }
         i.fa.fa-arrow-circle-right {
         margin-right: 0!important;
         }
         #content1{width:70%; float:inherit;margin-left:5%; padding:50px 0px 0px 0px;}
      </style>
      <div class="col-sm-9 col-sm-12  right" id="content1">
         <h1 style="margin-left: 28px;">Register for an Account or Login to your Existing Account</h1>
         <div class="box-container">
            <div class="login-content row">
               <div class="col-sm-6">
                  <div class="left">
                     <div class="heading">
                        <i class="fa fa-user" style="color: #7ed321;"></i>
                        <div class="extra-wrap">
                           <h2 style="margin-top: 14px;">New User</h2>
                        </div>
                     </div>
                     <div class="content">
                        <p style="margin-bottom: 30px;">Create an account and start placing orders.</p>
                        <a style="    padding: 15px;
    color: white;
    background: red;" href="/nensinensi/account?action=register" class="buttons">Register Here<i class="fa fa-arrow-circle-right" style="font-size: 17px;
    margin-left: 10px;
    margin-top: 2px;"></i></a>
                     </div>
                  </div>
               </div>
               <div class="col-sm-6">
                  <div class="right">
                     <div class="heading">
                        <i class="fa fa-key" style="color: #7ed321;"></i>
                        <div class="extra-wrap">
                          <h2 style="margin-top: 10px;">Existing User</h2>
                        </div>
                     </div>
                     <form class="form-horizontal" action="<c:url value='login'/>" method="post"  id="login">
                        <div class="content">
                           <div class="input-group input-group-icon">
                              <input type="email" required="required" name="email" placeholder="Email"/>
                              <div class="input-icon"><i class="fa fa-envelope"></i></div>
                           </div>
                           <div class="input-group input-group-icon">
                              <input type="password" required="required" name="password" placeholder="Password"/>
                              <div class="input-icon"><i class="fa fa-key"></i></div>
                           </div>
                        </div>
                        <div class="login-buttons">
                           <input type="submit" style="background: #7ed321;color: white;" value="LOGIN" class="buttons"/>
                           <p style="color: red;margin-top: 16px;    text-align: center;">${message}</p>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>