package com.ontology.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ontology.app.dao.BooksDao;
import com.ontology.app.model.Cart;
import com.ontology.app.model.Cart_Items;
import org.apache.commons.lang3.StringUtils;

import com.ontology.app.model.Book;

@WebServlet(name = "SaleController" , urlPatterns = {"/delete_cart", "/add_to_cart", "/update_cart", "/view_cart"}) 
public class SaleController extends HttpServlet {

	private static String EDIT_CART_PAGE = "/view/sale_cart.jsp";
	private static String LIST_BOOKS = "/view/home.jsp";
	
	private BooksDao book_dao;
	
	public SaleController(){
		super();
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String user_path = req.getServletPath();
		String forward = "";
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String action = req.getParameter("action");
		
		if(user_path.equals("/view_cart")){
			forward = EDIT_CART_PAGE;
		}
		
		else {
			if(StringUtils.isNotBlank(action)){
				if (action.equalsIgnoreCase("clear")) {
                    if (cart != null) {
                        forward = EDIT_CART_PAGE;
                        cart.removeAllItems();
                        cart = null;
                        session.removeAttribute("cart");
                    } else {
                        forward = EDIT_CART_PAGE;
                    }

                }
			}
		}
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_path = req.getServletPath();
		String forward = EDIT_CART_PAGE;
		HttpSession session = req.getSession();
		String action = req.getParameter("action");
		
		Cart cart = (Cart) session.getAttribute("cart");
		String book_id = req.getParameter("book_id");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String category = req.getParameter("category");
        req.setAttribute("category", category);
		
		
		Book b = null;
		BooksDao books_dao = new BooksDao();
		
		
        b = books_dao.get_book_by_id(book_id);
       

        if (user_path.equals("/add_to_cart")) {
        	
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            Cart_Items item = new Cart_Items(b, quantity);
            cart.addItem(item);

        } else if (user_path.equals("/update_cart")) {
            if (cart == null) {
               forward = EDIT_CART_PAGE;
            }
            Cart_Items item = new Cart_Items(b, quantity);
            cart.update_cart(item);
        } else {

        }
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
}
