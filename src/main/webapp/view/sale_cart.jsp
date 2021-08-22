<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
      <meta name="description" content="Alb Library">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="/nensinensi/css/style.css" rel="stylesheet" type="text/css">
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <section>
         <div class="box-container">
            <div id="container">
               <div  class="container">
                  <div class="row">
                     <div class="col-sm-12 col-sm-12 right" id="content" style="width: 100%;">
                        <div class="breadcrumb">
                           <c:url var="url" value="/delete_cart?action=clear">
                           </c:url>
                           <c:if test="${!empty cart && cart.numberOfItems != 0}">
                              <a href="${url}" class="bubble hMargin"><b>CLEAR CART</b></a>
                           </c:if>
                           <span style="margin-right: 300px;
                              margin-left: 350px;">
                           <a href="/nensinensi/Hello" class="bubble hMargin"><b>CONTINUE SHOPPING</b></a>
                           </span>
                           <c:if test="${empty User}">
                              <span style="margin-left:0px;font-weight: bold;
                                 color: red;">
                              You should Log in to checkout !
                              </span>
                           </c:if>
                           <c:if test="${!empty User}">
                              <span style="margin-left:150px ">
                                 <c:url var="uyrl" value="/order?action=checkout">
                                 </c:url>
                                 <a href="${uyrl}"><b>CHECKOUT</b> </a>
                              </span>
                           </c:if>
                        </div>
                        <%-- clear cart widget --%>
                        <div class="clear"></div>
                        <div class="clear"></div>
                        <c:if test="${empty cart}">
                           <p>Your shopping cart is Empty! Start buying.
                        </c:if>
                        <c:if test="${!empty cart}">
                           <p>
                              Your shopping cart contains 
                              <c:out value="${cart.numberOfItems}" />
                              items. and total price => 
                              <c:out value="${cart.total}" />
                           </p>
                        </c:if>
                        <div class="content">
                           <table border="1" class="form" style="width :  100%;margin-top: 50px;">
                              <thead>
                                 <tr>
                                    <th style="text-align: center;height: 43px;">Book Name</th>
                                    <th style="text-align: center;height: 43px;">Book Price</th>
                                    <th style="text-align: center;height: 43px;">Book Quantity</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                                    <c:set var="product" value="${cartItem.b}"/>
                                    <tr  style="background-color: ${((iter.index % 2) == 0) ? '#7ed321' : 'white'}; color :${((iter.index % 2) == 0) ? 'white' : 'black'} ">
                                       <td>${product.titulli}</td>
                                       <td>${cartItem.total}$<br/> ${product.price} /unit</td>
                                       <td>
                                          <form  action="update_cart" method="post">
                                             <div class="cart-top-padd form-inline">
                                                <label>Quantity: <input class="q-mini" style="color :black ;" type="text" name="quantity" size="2" value="${cartItem.quantity}">  </label>
                                                <input type="hidden" type="text" name="book_id" size="2" value="${product.book_id}">
                                                <input type="hidden" name="category" value="
                                                <c:out value="${category}"/>
                                                " />
                                                <button style="border: 1px;background: white;position: absolute;right: 10%;"
                                                   ><span style="color : black">Update</span>
                                                <i class="fa fa-shopping-cart" style="color : red;"></i>
                                                </button>
                                             </div>
                                          </form>
                                       </td>
                                    </tr>
                               
                                 
                                 
                              
        </c:forEach>               
         </tbody>
                           </table>
                           
                          <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                          <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                                    <c:set var="product" value="${cartItem.b}"/>
<p>
<input type="hidden" name="cmd" value="_cart">
<input type="hidden" name="add" value="1">
<input type="hidden" name="business" value="nensiskenderi_test@gmail.com">
<input type="hidden" name="currency_code" value="USD">
</p>



 
 <input type="hidden" name="item_number" value="${product.book_id}"> 
<input type="hidden" name="item_name" value="${product.titulli}">
<input type="hidden" name="amount" value="${product.price}"> 
<input type="hidden" name="quantity" value="${cartItem.quantity}">

  </c:forEach>  

 <input type="submit" name="submit" value="Paguaj" > 
 
</form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="clear"></div>
      </section>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>