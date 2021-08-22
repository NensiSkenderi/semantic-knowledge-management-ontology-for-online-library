<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <div id="header">
         <div id="top_bar">
            <div class="content_wrap">
               <ul id="top_bar_menu" class="top_bar_menu">
               <c:if  test="${empty User}">
               <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-381">
                     <a href="/nensinensi/account?action=register">Regjistrohu</a>
                  </li>
                  <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-381">
                     <a href="/nensinensi/account?action=login">Login</a>
                  </li>
                    </c:if>
               
               <c:if  test="${!empty User}">
                          <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-381">
                     <a href="/nensinensi/account?action=logout">Logout <i>${User.first_name}</i></a>
                     <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-41"><a href="https://www.sandbox.paypal.com/webapps/shoppingcart?mfid=1538270801036_5091d2fdd2b76&flowlogging_id=5091d2fdd2b76#/checkout/shoppingCart"><i style="margin-right:10px;font-size : 18px;" class="fa fa-shopping-cart" aria-hidden="true"></i> View Cart</a></li>
                  
                  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-41"><a href="/nensinensi/account?action=register">Profili</a></li>
                </c:if>
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-41"><a href="/nensinensi/kontakto">Kontakt</a></li>
             
               
               
               
               </ul>
            </div>
         </div>
         <div class="content_wrap">
            <div id="logo">
               
               <img src="/nensinensi/img/logo.jpg"/>
               
            </div>
            <div id="nav">
               <ul id="menu" class="menu">
                  <li class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-14"><a href="http://localhost:8080/nensinensi/Hello">Home</a></li>
                  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-210">
                     <a href="/nensinensi/book?action=listBooks&category=Romance">Romance</a>
                    
                  </li>
                  
                  
                  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-226">
                     <a href="/nensinensi/book?action=listBooks&category=History">History</a>
                     
                  </li>
                  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-227"><a href="/nensinensi/book?action=listBooks&category=Poetry">Poetry</a>
                  </li>
                  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-227"><a href="/nensinensi/book?action=listBooks&category=Religion">Religion</a>
                  </li>
               </ul>
            </div>
         </div>
      </div>