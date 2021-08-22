<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    


<div class="panel panel-default">
    <div class="panel-heading">
       All Messages
    </div>
 <div class="panel-body">


        <table style="margin-top: 60px;" width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr style="color: white;
    background-color: #30A5FF;">
                   
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Phone Number</th>
                    <th style="width: 20px;color : white;font-weight: normal;" >ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contact}">
                    <tr>
                       
                        <td>${contact.full_name} </td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                        <td>${contact.phone_number}</td>
                        <td>
                            <a style=" margin-top: -20px;    margin-left: 21px;" href="/nensinensi/all_messages?action=delete_message&email=${contact.email}">
                                <i class="fa fa-trash-o-o  fa-2x" style="color : red"></i> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>