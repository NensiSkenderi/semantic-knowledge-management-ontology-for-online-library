<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    


<div class="panel panel-default">
    <div class="panel-heading">
       All Books  <i style="color : red;">${cat}</i> <span class="btn-block"> <a  class="btn btn-success" href="/nensinensi/all_books?action=add_book" style="margin-top: 30px;">Add New Book</a></span>
    </div>
 <div class="panel-body">


        <table style="margin-top: 60px;" width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr style="color: white;
    background-color: #30A5FF;">
                	<th>Book Id</th>
                    <th>Title</th>
                    <th style="width: 33%;">Description</th>
                    <th>Image</th>
                    <th>Emer Autori</th>
                    <th>Published Year</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    
                    <th style="width: 20px;color : white;font-weight: normal;" >ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${book}">
                    <tr>
                    	<td>${book.book_id}</td>
                        <td>${book.titulli}</td>
                        <td>${book.pershkrimi} </td>
                        <td><img style="width: 120px;height: 165px;" src="${book.image_path}" alt="${book.image_path}"/></td>
                        
                        <td>${book.author_name}</td>
                        <td>${book.published_year}</td>
                        <td>${book.price}</td>
                        <td>${book.quantity}</td>
                        <td>
                            <a style="float: left;" href="/nensinensi/all_books?action=edit_book&book_id=${book.book_id}">
                                <i class="fa fa-edit fa-2x" ></i> </a>
                            <br>
                            <a style="float: right; margin-top: -20px;" href="/nensinensi/all_books?action=delete_book&book_id=${book.book_id}">
                                <i class="fa fa-trash-o-o  fa-2x" style="color : red"></i> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>