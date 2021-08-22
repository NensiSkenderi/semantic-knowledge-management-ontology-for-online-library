<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        Add New Book    <center><h4><b style="color: red">${message}</b></h4></center> <center><h4 style="    margin-top: 18px;
    font-size: 25px;"><b style="color: #8AD919;">${book_updated}</b></h4></center>

    </div>

    <!-- /.panel-heading -->
    <div class="panel-body">
        <div class="col-lg-6">
           <c:if  test="${update == false  }">
   
    <form class="form-horizontal" action="add_book" method="post" enctype="multipart/form-data" id="register" role="form">
    </c:if>
    
    <c:if  test="${update == true}">
        <form class="form-horizontal" action="edit_book"  method="post"  id="register" role="form">  
        </c:if>
                <div class="form-group">
                    <label>Title:</label>
                    <input class="form-control" name="titulli" type="text" value="${book.titulli}">
                    <c:if test="${update == true }">
                        <input type="hidden" name="book_id" value="${book.book_id}">

                    </c:if>
                        <c:if test="${update == false }">
                        <input type="hidden" name="book_id" value="0">

                    </c:if>
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Price:</label>
                    <input class="form-control" name="price" type="text" value="${book.price}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
               
                
                <div class="form-group">
                    <label>Quantity</label>
                    <input class="form-control" name="quantity" type="number" value="${book.quantity}" >
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Author Name :</label>
                    <input class="form-control" name="author_name" type="text" value="${book.author_name}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Published Year:</label> 
                    <input class="form-control" name="published_year" value="${book.published_year}"/>
                    <p class="help-block">example 20-01-1995</p>
                </div>

               
                <div class="form-group">
                    <label>Image:</label>
                    <input type="file" name="imagePath">
                    <c:if test="${update == true }">
                        <input style="text-align: center;
    color: red;" type="text" name="image_path" disabled="disabled" value="Image path for this book is :  ${book.image_path}" size="70" > 
                        <input type="hidden" name="image_path"  value="${book.image_path}" >                         
                        
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Book Description</label>
                    <textarea class="form-control" rows="3" name="pershkrimi">${book.pershkrimi}</textarea>
                </div>

                <div class="form-group">
                    <label>Book Category</label>
                    <select class="form-control" name="category" id="category">
                    
                   <c:if  test="${update == true  }">
                    <option value="${book.category}" selected="selected">${book.category}</option>
             	 </c:if>
             	 
             	 <c:if  test="${update == false  }">
                     <option value="Romance">Romance</option>
                        <option value="Poetry">Poetry</option>
                        <option value="History">History</option>
                        <option value="Religion">Religion</option>
                        </c:if>
                    </select>
                </div>
                
               
                <button type="submit" class="btn btn-default">Submit</button>
                <button type="reset" class="btn btn-default">Reset</button>
            </form>
        </div>

    </div>
</div>
