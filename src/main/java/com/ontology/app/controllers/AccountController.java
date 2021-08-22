package com.ontology.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ontology.app.dao.AdminDao;
import com.ontology.app.dao.BooksDao;
import com.ontology.app.dao.UserDao;
import com.ontology.app.model.Admin;
import com.ontology.app.model.User;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "AccountController", urlPatterns = {"/updateAccount","/account", "/login", "/Admin" , "/admin_panel"})
public class AccountController extends HttpServlet{

	private UserDao user_dao;
	private AdminDao admin_dao;
	private BooksDao books_dao;
	
	private static String Login_Page = "/view/register_login.jsp";
	private static String Register_Page = "/view/register.jsp";
	private static String Admin_Panel = "/view/admin_panel.jsp";

	private static String Admin_Login = "/view/admin_login.jsp";
	
	public AccountController() {
		super();
		
		admin_dao = new AdminDao();
		user_dao = new UserDao();
		books_dao = new BooksDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String userPath = req.getServletPath();
		
		if(userPath.equals("/account")) {
			if(action.equalsIgnoreCase("login")) {
				forward = Login_Page;
			}
			
			else if(action.equalsIgnoreCase("register")) {
				forward = Register_Page;
			}
			
			else if(action.equalsIgnoreCase("logout")) {
				User u = (User) session.getAttribute("User");
				u = null;
				session.removeAttribute("User");
				forward = Login_Page;
			}
			
			else if(action.equalsIgnoreCase("register")) {
				forward = Register_Page;
				
			}
			
			
			else if(StringUtils.isEmpty("action")) {
				forward = Login_Page;
			}
		}
		
		else if(userPath.equals("/Admin")) {
	    	
	    	
	    	if(action.equalsIgnoreCase("logout_admin")) {
				Admin adm = (Admin) session.getAttribute("Admin");
				adm = null;
				session.removeAttribute("Admin");
				forward = Admin_Login;
			}
	    	
	    	else if(action.equals("login_admin")){
	    		forward = Admin_Login;
	    	}
	    }
		
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String forward = "";
		String userPath = req.getServletPath();
		
		if(userPath.equals("/login")) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			String message = "";
			
			User u = user_dao.getEmailPass(email, password);
			
			if(u.getFirst_name() == null) {
				message = "Password or Email is not correct!";
				req.setAttribute("message", message);
				forward = Login_Page;
			}
			
			else {
				HttpSession session = req.getSession();
				session.setAttribute("User", u);
				forward = Login_Page;
			}
			
		}	
			
			else if(userPath.equals("/updateAccount")) {
				HttpSession session = req.getSession();
				User u = new User();

			
				u.setAddress(req.getParameter("address"));
				u.setCity(req.getParameter("city"));
				u.setCountry(req.getParameter("country"));
				
			
				
				u.setEmail(req.getParameter("email"));
				u.setFirst_name(req.getParameter("first_name"));
				u.setLast_name(req.getParameter("last_name"));
				u.setPassword(req.getParameter("password"));
				u.setPhone_number(req.getParameter("phone_number"));
				
				
				User old_user = (User) session.getAttribute("User");
				u.setUser_id(old_user.getUser_id());
				//ket shife
				boolean updated = user_dao.updateUser(u, old_user);
				
				if(updated) {
					old_user.copy(u);
				} else {
					req.setAttribute("message", "unable to update account please check all the values");
					req.setAttribute("message_register", "unable to update account please check all the values");
				}
				forward = Register_Page;
			}
			
			else if(userPath.equals("/admin_panel")){
		    	String email = req.getParameter("email");
		    	String password = req.getParameter("password");
		    	
		    	Admin adm = admin_dao.getEmailPass(email, password);
		    	String message = "";
		    	
		    	if(adm.getAdmin_password() == null) {
		    		message = "Password or Email is not correct!";
					req.setAttribute("message", message);
					forward = Admin_Login;
		    	}
		    	
		    	else {
		    		HttpSession session = req.getSession();
					session.setAttribute("Admin", adm);
					forward = Admin_Panel;
		    	}
		    	
		    	
		    	req.setAttribute("all_books", books_dao.get_all_books());
		    	req.setAttribute("all_users",user_dao.get_count_users());
		    	req.setAttribute("all_messages",user_dao.get_count_messages());
		    	
		    	//per kategorite e librave posht grafikut
		    	req.setAttribute("poetry", books_dao.get_count_category("Poetry"));
		    	req.setAttribute("romance", books_dao.get_count_category("Romance"));
		    	req.setAttribute("history", books_dao.get_count_category("History"));
		    	req.setAttribute("religion", books_dao.get_count_category("Religion"));
		    	
			}
		
			else if(userPath.equals("/account")) {
				String agree_terms = req.getParameter("agree");
				forward = Register_Page;
				
				if(agree_terms != null) {
					User u = new User();
					u.setEmail(req.getParameter("email"));
					u.setFirst_name(req.getParameter("first_name"));
					u.setLast_name(req.getParameter("last_name"));
					u.setPassword(req.getParameter("password"));
					u.setPhone_number(req.getParameter("phone_number"));
					
					u.setAddress(req.getParameter("address"));
					u.setCity(req.getParameter("city"));
					u.setCountry(req.getParameter("country"));
					
					boolean check = user_dao.add_user(u);
					
					if(check) {
						req.setAttribute("message_register", "Email  registered. Please use different Email !");
					}
					
					else {
						req.setAttribute("registered", "Success! You are now a member of ALB-Library!");
					}
				}
				
				
				
				else {
					 req.setAttribute("message_register", "Unable to register. Please agree to the Terms and Conditions!");
				}
			}
			RequestDispatcher view = req.getRequestDispatcher(forward);
	        view.forward(req, resp);
		}
		
}
