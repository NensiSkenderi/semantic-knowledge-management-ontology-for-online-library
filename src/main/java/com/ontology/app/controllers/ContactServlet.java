package com.ontology.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ontology.app.dao.ContactDao;
import com.ontology.app.model.Contact;

@WebServlet(name = "ContactServlet", urlPatterns = {"/kontakto","/contact_us"})
public class ContactServlet extends HttpServlet{
	
	private ContactDao contact_dao;

	private static String Register_Page = "/view/register.jsp";
	private static String Contact_Page = "/view/contact_page.jsp";
	
	public ContactServlet() {
		super();
		
		contact_dao = new ContactDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String forward = Contact_Page;
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String user_path = req.getServletPath();
		if(user_path.equals("/contact_us")) {
			
			forward = Register_Page; 
			
			Contact contact = new Contact();
			
			contact.setFull_name(req.getParameter("full_name"));
			contact.setEmail(req.getParameter("email"));
			contact.setPhone_number(req.getParameter("phone_number"));
			contact.setMessage(req.getParameter("message"));
			
			contact_dao.add_contact_message(contact);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
}
