package com.ontology.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.Book;
import com.ontology.app.utils.fuseki;



/**
 * Servlet implementation class Hello
 */
@WebServlet(name = "Hello", urlPatterns = {"/"})
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 List<Book> users = new ArrayList<Book>();
    	 String selectQuery = null;
    	 selectQuery  = fuseki.PREFIX + "SELECT * \r\n" + 
 				"WHERE {\r\n" + 
 				"  ?book a owl:Thing. \r\n" + 
 				"  ?book nensi:hasTitle ?titulli .\r\n" +
 				"  ?book nensi:hasAuthor ?author_name .\r\n" +
 				"  ?book nensi:hasImage ?image_path  .\r\n" +
 				"  ?book nensi:hasBookId ?book_id  .\r\n" +
 				"  ?book nensi:hasPrice ?price  .\r\n" +
 				"  ?book nensi:hasQuantity ?quantity  .\r\n" +
 				"  ?book nensi:hasPublishedYear ?published_year  .\r\n" +
 				"  ?book nensi:hasCategory ?category  .\r\n" +
 				"  ?book nensi:hasDescription ?pershkrimi  .\r\n" +
 					"}\r\n" + 
 				"";
    	 
   
    	//per tbe query vtm ato te romances
    	 ResultSet results = fuseki.query_data(selectQuery);
    	 String nensi = "";
         while (results.hasNext()) {
             QuerySolution solution = results.nextSolution(); //shife mir kte
           
             Book book = new Book();
             book.setTitulli(solution.getLiteral("titulli").getString());
 			book.setAuthor_name(solution.getLiteral("author_name").getString());
 			book.setImage_path(solution.getLiteral("image_path").getString());
 			book.setPershkrimi(solution.getLiteral("pershkrimi").getString());
 			book.setBook_id(solution.getLiteral("book_id").getString());
 			book.setPrice(solution.getLiteral("price").getString());
 			book.setQuantity(solution.getLiteral("quantity").getString());
 			book.setPublished_year(solution.getLiteral("published_year").getString());
 			book.setCategory(solution.getLiteral("category").getString());
 			users.add(book);
         }
         request.setAttribute("data", users);
		
		
		request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
