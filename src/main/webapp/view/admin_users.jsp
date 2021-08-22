<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    


<div class="panel panel-default">
    <div class="panel-heading">
       All Users <span class="btn-block"> <a  class="btn btn-success" href="/nensinensi/users?action=create_user" style="margin-top: 30px;">Add New User</a></span>
    </div>
 <div class="panel-body">


        <table style="margin-top: 60px;" width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr style="color: white;
    background-color: #30A5FF;">
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>City</th>
                    <th>Country</th>
                    <th>Address</th>
                    <th style="width: 20px;color : white;font-weight: normal;" >ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.user_id}</td>
                        <td>${customer.first_name} </td>
                        <td>${customer.last_name}</td>
                        <td>${customer.phone_number}</td>
                        <td>${customer.password}</td>
                        <td>${customer.email}</td>
                        <td>${customer.city}</td>
                        <td>${customer.country}</td>
                        <td>${customer.address}</td>
                        <td>
                            <a style="float: left;" href="/nensinensi/users?action=edit_user&user_id=${customer.user_id}">
                                <i class="fa fa-edit fa-2x" ></i> </a>
                            <br>
                            <a style="float: right; margin-top: -20px;" href="/nensinensi/users?action=delete_user&user_id=${customer.user_id}">
                                <i class="fa fa-trash-o-o  fa-2x" style="color : red"></i> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>