<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default">
  <div class="panel-heading">
    Here you can edit or add Admin data.
  </div>
  <!-- /.panel-heading -->
  <div class="panel-body">
<div class="col-lg-6">
<c:if  test="${update == false  }">

    <center><h4><b style="color: red">${admin_error}</b></h4></center> <center><h4><b style="color: #8AD919;">${admin_added}</b></h4></center>
    <form class="form-horizontal" action="add_admin" method="post"  id="register" role="form">
    </c:if>
    <c:if  test="${update == true  }">
   <center> <h4 style="    color: #8ad919;
    font-weight: bold;">Edit Admin</h4></center>
        <form class="form-horizontal" action="edit_admin" method="post"  id="register" role="form">  
        </c:if>
        
        
            <div class="form-group">
                <label>* First Name:</label>
                <input class="form-control" type="text" name="admin_first_name" value="${admins.admin_first_name}">
            </div>

            <div class="form-group">
                <label>* Last Name:</label>
                <input class="form-control" type="text" name="admin_last_name" value="${admins.admin_last_name}">
            </div>

           


            <div class="form-group">
                <label>* E-Mail:</label>
                <input class="form-control" type="email" name="admin_email" value="${admins.admin_email}">
            	 <input class="form-control" type="hidden" name="admin_id" value="${admins.admin_id}">
                                
            </div>

            <div class="form-group">
                <label>*Password:</label>
                <input class="form-control" type="password" name="admin_password" value="${admins.admin_password}">
            </div>


            <div class="buttons">
                <div class="right">
<input style="margin-bottom: 30px;background-color:#8ad919;color:white;width: 50%;" type="submit" value="Submit" class="buttons"/>
               
                </div>
            </div>
    </form>
</div>
</div>
</div>
            