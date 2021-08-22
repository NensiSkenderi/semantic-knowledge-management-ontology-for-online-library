package com.ontology.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ontology.app.dao.UserDao;

@WebServlet(name = "UserController", urlPatterns = {"/register_login"})
public class UserController extends HttpServlet{

	private UserDao user_dao;
	
	public UserController() {
		super();
		
		user_dao = new UserDao();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setAttribute("data", user_dao.getUser());
		RequestDispatcher view = req.getRequestDispatcher("/view/usertest.jsp");
	    view.forward(req,resp);
	}
}
