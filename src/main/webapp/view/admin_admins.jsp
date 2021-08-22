<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    


<div class="panel panel-default">
    <div class="panel-heading">
       All Admins <span class="btn-block"> <a  class="btn btn-success" href="/nensinensi/admins?action=add_admin" style="margin-top: 30px;">Add New Admin Account</a></span>
    </div>
 <div class="panel-body">


        <table style="margin-top: 60px;" width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr style="color: white;
    background-color: #30A5FF;">
                    <th>Admin ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th style="width: 20px;color : white;font-weight: normal;" >ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="admin" items="${admin}">
                    <tr>
                        <td>${admin.admin_id}</td>
                        <td>${admin.admin_first_name} </td>
                        <td>${admin.admin_last_name}</td>
                        <td>${admin.admin_password}</td>
                        <td>${admin.admin_email}</td>
                        <td>
                            <a style="float: left;" href="/nensinensi/admins?action=edit_admin&admin_email=${admin.admin_email}">
                                <i class="fa fa-edit fa-2x" ></i> </a>
                            <br>
                            <a style="float: right; margin-top: -20px;" href="/nensinensi/admins?action=delete_admin&admin_email=${admin.admin_email}">
                                <i class="fa fa-trash-o-o  fa-2x" style="color : red"></i> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>