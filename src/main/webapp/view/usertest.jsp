<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	 <div class="container-fluid" style="margin-top: 5%;">
         <c:forEach var="rr" items="${data}">
            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
               <div class="">
                  <center><h4 class="book_title">${rr.email}</h4></center>
         			
         			<center><h4 class="book_desc">${rr.password}</h4></center>
               </div>
            </div>
         </c:forEach>
      </div>

</body>
</html>