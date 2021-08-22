package com.ontology.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.ontology.app.dao.ComicsDao;
import com.ontology.app.dao.HistoryDao;
import com.ontology.app.dao.PoetryDao;
import com.ontology.app.dao.ReligionDao;
import com.ontology.app.dao.RomanceDao;

@WebServlet(name = "BookController", urlPatterns = {"/book"})
public class BookController extends HttpServlet {

	private RomanceDao romance_dao;
	private HistoryDao history_dao;
	private ComicsDao comics_dao;
	private PoetryDao poetry_dao;
	private ReligionDao religion_dao;
	
	private static String LIST_Books = "/view/home.jsp";
	
	public BookController() {
		super();
		
		romance_dao = new RomanceDao();
		history_dao = new HistoryDao();
		comics_dao = new ComicsDao();
		poetry_dao = new PoetryDao();
		religion_dao = new ReligionDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		
		
		if(StringUtils.isEmpty(action)) {
			forward = LIST_Books;
		}
		else {
			if(action.equalsIgnoreCase("listBooks")) {
				forward = LIST_Books;
				String category = null;
				
				if(StringUtils.isNotEmpty(req.getParameter("category"))){
                    category = (req.getParameter("category").trim());
                }
				
				req.setAttribute("category", category);
             
             if(category != null) {
            	 if(category.equals("Romance")) {
            		 req.setAttribute("data", romance_dao.getAllRomance());
            	 }
            	 
            	 else if(category.equals("History")) {
            		 req.setAttribute("data", history_dao.getAllHistory());
            	 }
            	 else if(category.equals("Comics")) {
            		 req.setAttribute("data", comics_dao.getAllRomance());
            	 }
            	 else if(category.equals("Poetry")) {
            		 req.setAttribute("data", poetry_dao.getAllRomance());
            	 }
            	 else if(category.equals("Religion")) {
            		 req.setAttribute("data", religion_dao.getAllRomance());
            	 }
            		 
             }
		
		   }
			
		}
		
		 RequestDispatcher view = req.getRequestDispatcher(forward);
	     view.forward(req,resp);
	}
}
