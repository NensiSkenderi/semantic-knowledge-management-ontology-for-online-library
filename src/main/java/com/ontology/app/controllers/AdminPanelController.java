package com.ontology.app.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.ontology.app.dao.AdminDao;
import com.ontology.app.dao.BooksDao;
import com.ontology.app.dao.ContactDao;
import com.ontology.app.dao.HistoryDao;
import com.ontology.app.dao.PoetryDao;
import com.ontology.app.dao.ReligionDao;
import com.ontology.app.dao.RomanceDao;
import com.ontology.app.dao.UserDao;
import com.ontology.app.model.Admin;
import com.ontology.app.model.Book;
import com.ontology.app.model.Contact;
import com.ontology.app.model.HistoryBook;
import com.ontology.app.model.PoetryBook;
import com.ontology.app.model.ReligionBook;
import com.ontology.app.model.RomanceBook;
import com.ontology.app.model.User;

@WebServlet(name = "AdminPanelController", urlPatterns = {"/admin_dashboard","/users","/all_books","/add_user", "/edit_user","/add_book","/edit_book","/all_messages", "/admins" , "/edit_admin","/add_admin"})
public class AdminPanelController extends HttpServlet {

	private static String Admin_Panel_Page = "/view/admin_panel.jsp";
	
	
	private UserDao user_dao;
	private BooksDao book_dao;
	private RomanceDao romance_dao;
	private ReligionDao religion_dao;
	private PoetryDao poetry_dao;
	private HistoryDao history_dao;
	private AdminDao admin_dao;
	private ContactDao contact_dao;
	
    private static final String UPLOAD_DIRECTORY = "img";
   
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; 	// 3MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private String filePath;
	
	public AdminPanelController() {
		super();
		
		admin_dao = new AdminDao();
		user_dao = new UserDao();
		book_dao = new BooksDao();
		romance_dao = new RomanceDao();
		religion_dao = new ReligionDao();
		poetry_dao = new PoetryDao();
		history_dao = new HistoryDao();
		contact_dao = new ContactDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String dash = "Dashboard";
		String user_path = req.getServletPath();
		if(user_path.equals("/users")) {
			forward = Admin_Panel_Page;
			
			if(action.equals("listUsers")) {
				List<User> users = user_dao.getAllUser();
				
				req.setAttribute("customers", users);
				req.setAttribute("type", "customer");
			}
			
			else if(action.equals("create_user")) {
				session.removeAttribute("User");
				req.setAttribute("type", "create_user");
			}
			else if(action.equals("edit_user")) {
				String user_id = req.getParameter("user_id");
				User u = user_dao.get_user_by_id(user_id);
				req.setAttribute("User", u);
				req.setAttribute("type", "edit_user");
				
				//vej session User
				session.setAttribute("User", u);
			}
			
			else if(action.equals("delete_user")) {
				String user_id = req.getParameter("user_id");
				
				user_dao.delete_user(user_id);
				List<User> user = user_dao.getAllUser();
				req.setAttribute("customers", user);
				req.setAttribute("type", "customer");
				
			}
		}
		
		if(user_path.equals("/all_messages")) {
			forward = Admin_Panel_Page;
			
			if(action.equals("listMessages")){
				List<Contact> contacts = contact_dao.get_all_messages();
				req.setAttribute("contact", contacts);
				req.setAttribute("type", "contact");
			}
			
			else if(action.equals("delete_message")) {
				String email = req.getParameter("email");
				
				try {
					contact_dao.delete_message(email);
				} catch (Exception e) {
					e.printStackTrace();
				}
				List<Contact> messages = contact_dao.get_all_messages();
				req.setAttribute("contact", messages);
				req.setAttribute("type", "contact");
			}
		}
		
		if(user_path.equals("/admins")){
			forward = Admin_Panel_Page;
			
			if(action.equals("listAdmin")){
				List<Admin> admins = admin_dao.getAllAdmin();
				req.setAttribute("admin", admins);
				req.setAttribute("type", "admins");
			}
			
			else if(action.equals("delete_admin")) {
				String admin_email = req.getParameter("admin_email");
				try {
					admin_dao.delete_admin(admin_email);
					List<Admin> admins = admin_dao.getAllAdmin();
					req.setAttribute("admin", admins);
					req.setAttribute("type", "admins");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(action.equals("add_admin")) {
				req.setAttribute("type", "add_admin");
				req.setAttribute("update", false);
			}
			
			else if(action.equals("edit_admin")){
				req.setAttribute("type", "edit_admin");
				String admin_email = req.getParameter("admin_email");
				Admin admin = admin_dao.get_admin_by_email(admin_email);
				
				session.setAttribute("Admin", admin);
                req.setAttribute("update", true);
                req.setAttribute("admins", admin);
                
			}
		}
		
		
		
		if(user_path.equals("/admin_dashboard")) {
			forward = Admin_Panel_Page;
			
			if(action.equals("dashboard")) {
				req.setAttribute("dashboard", dash);
				req.setAttribute("all_books", book_dao.get_all_books());
		    	req.setAttribute("all_users",user_dao.get_count_users());
		    	req.setAttribute("all_messages",user_dao.get_count_messages());
		    	
		    	//per kategorite e librave posht grafikut
		    	req.setAttribute("poetry", book_dao.get_count_category("Poetry"));
		    	req.setAttribute("romance", book_dao.get_count_category("Romance"));
		    	req.setAttribute("history", book_dao.get_count_category("History"));
		    	req.setAttribute("religion", book_dao.get_count_category("Religion"));
		  
			}
		}
		
		
		if(user_path.equals("/all_books")) {
			forward = Admin_Panel_Page;
			if(action.equals("listBooks")) {
				List<Book> books = book_dao.getAllBooks();
				req.setAttribute("book", books);
				req.setAttribute("type", "book");
			}
			
			else if(action.equals("edit_book")) {
				String book_id = req.getParameter("book_id");
				//String category = req.getParameter("category").toString();
				Book b = book_dao.get_book_by_id(book_id);
			
				req.setAttribute("type", "edit_book");
				req.setAttribute("book", b);
                req.setAttribute("update", true);
               
			}
			
			else if(action.equals("add_book")) {
			//	List<RomanceBook> romance_books = romance_dao.getAllRomance();
			//	List<HistoryBook> history_books = history_dao.getAllHistory();
			//	List<PoetryBook> poetry_books = poetry_dao.getAllRomance();
			//	List<ReligionBook> religion_books = religion_dao.getAllRomance();
				
				
				req.setAttribute("type", "add_book");
				req.setAttribute("update", false);
			}
			
			else if(action.equals("delete_book")){
				String book_id = req.getParameter("book_id");
				Book b = book_dao.get_book_by_id(book_id);
				String name  = book_dao.get_name(b);
				
				boolean res = book_dao.deleteBook(name);
				
				List<Book> books_list = book_dao.getAllBooks();
				req.setAttribute("book", books_list);
				req.setAttribute("type", "book");
				
			}
			
			else if(action.equals("listBooksByCategory")) {
				forward = Admin_Panel_Page;
				String category = null;
				String nensi = "";
				if(StringUtils.isNotEmpty(req.getParameter("category"))){
                    category = (req.getParameter("category").trim());
                }
				
				req.setAttribute("category", category);
				
				List<Book> cat = new ArrayList<Book>();
				if(category.equals("Romance")) {
					cat = book_dao.get_books_by_category("Romance");
					nensi= "in Romance";
					req.setAttribute("cat", nensi);
				}
				else if(category.equals("Poetry")) {
					cat = book_dao.get_books_by_category("Poetry");
					nensi= "in Poetry";
					req.setAttribute("cat", nensi);
				}
				else if(category.equals("Religion")) {
					 cat = book_dao.get_books_by_category("Religion");
					 nensi= "in Religion";
					 req.setAttribute("cat", nensi);
				}
				else if(category.equals("History")) {
					 cat = book_dao.get_books_by_category("History");
					 nensi= "in History";
					 req.setAttribute("cat", nensi);
				}
				
				req.setAttribute("book", cat);
				req.setAttribute("type", "book");
				
			}
		}
		
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String user_path = req.getServletPath();
		String image_path = null;
		String category = null;
		
		if(user_path.equals("/add_user")) {
			forward = Admin_Panel_Page;
			User u = new User();
			
			u.setAddress(req.getParameter("address"));
			u.setCity(req.getParameter("city"));
			u.setCountry(req.getParameter("country"));
			
			
			u.setUser_id(req.getParameter("user_id"));
			u.setEmail(req.getParameter("email"));
			u.setPassword(req.getParameter("password"));
			u.setFirst_name(req.getParameter("first_name"));
			u.setLast_name(req.getParameter("last_name"));
			u.setPhone_number(req.getParameter("phone_number"));
			
			boolean check_user = user_dao.add_user(u);
			req.setAttribute("type", "create_user");
			//tek edit veje edit_user
			
			if(check_user) {
				req.setAttribute("message_user", "Email is already registered!");
			}
			else {
				req.setAttribute("user_added", " Success! New User Added Successfully.");
			}
		}
		
		else if(user_path.equals("/edit_user")) {
			User u = new User();
			u.setAddress(req.getParameter("address"));
			u.setCity(req.getParameter("city"));
			u.setCountry(req.getParameter("country"));
			u.setUser_id(req.getParameter("user_id"));
			u.setEmail(req.getParameter("email"));
			u.setFirst_name(req.getParameter("first_name"));
			u.setLast_name(req.getParameter("last_name"));
			u.setPassword(req.getParameter("password"));
			u.setPhone_number(req.getParameter("phone_number"));
			
			User old_user = (User) session.getAttribute("User");
			
			u.setUser_id(old_user.getUser_id());
			//ket shife
			boolean updated = user_dao.updateUser(u, old_user);
			
			
			
			req.setAttribute("type", "edit_user");
			if(updated) {
				old_user.copy(u);
				
				req.setAttribute("user_updated", " Success! User Updated.");
			} else {
					
			}
			forward = Admin_Panel_Page;
			
			
		}
		
		else if(user_path.equals("/edit_admin")) {
			forward = Admin_Panel_Page;
			String email = req.getParameter("admin_email");
			String f_name = req.getParameter("admin_first_name");
			String l_name = req.getParameter("admin_last_name");
			String pass = req.getParameter("admin_password");
			String id = req.getParameter("admin_id");
			
			
			admin_dao.edit_admin(id,email, f_name,l_name,pass);
		
			List<Admin> admins = admin_dao.getAllAdmin();
			req.setAttribute("admin", admins);
			req.setAttribute("type", "admins");
			
			
			
		}
		
		else if(user_path.equals("/add_admin")){
			forward = Admin_Panel_Page;
			Admin admin = new Admin();
			
			admin.setAdmin_email(req.getParameter("admin_email"));
			admin.setAdmin_first_name(req.getParameter("admin_first_name"));
			admin.setAdmin_last_name(req.getParameter("admin_last_name"));
			admin.setAdmin_password(req.getParameter("admin_password"));
			admin.setAdmin_id(req.getParameter("admin_id"));
			
			boolean check_admin = admin_dao.add_admin(admin);
			req.setAttribute("type", "add_admin");
			
			
			
			if(check_admin) {
				req.setAttribute("admin_error", "Admin Email is already registered!");
			}
			else {
				req.setAttribute("admin_added", "New Admin Added");
			}
		}
		
		else if(user_path.equals("/add_book")) {
			forward = Admin_Panel_Page;
			String dash = "Dashboard";
			req.setAttribute("dashboard", dash);
			req.setAttribute("all_books", book_dao.get_all_books());
	    	req.setAttribute("all_users",user_dao.get_count_users());
	    	req.setAttribute("all_messages",user_dao.get_count_messages());
	    	
	    	//per kategorite e librave posht grafikut
	    	req.setAttribute("poetry", book_dao.get_count_category("Poetry"));
	    	req.setAttribute("romance", book_dao.get_count_category("Romance"));
	    	req.setAttribute("history", book_dao.get_count_category("History"));
	    	req.setAttribute("religion", book_dao.get_count_category("Religion"));
	  
			
			Book b = new Book();
			if(!ServletFileUpload.isMultipartContent(req)) {
				PrintWriter pw = resp.getWriter();
				pw.println("error here");
				pw.flush();
				return;
			}
			
			 DiskFileItemFactory factory = new DiskFileItemFactory();
	            // sets memory threshold - beyond which files are stored in disk 
	            factory.setSizeThreshold(MEMORY_THRESHOLD);
	            // sets temporary location to store files
	            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

	            ServletFileUpload upload = new ServletFileUpload(factory);

	            upload.setSizeMax(MAX_REQUEST_SIZE);

	            String uploadPath = getServletContext().getRealPath("")
	                    + File.separator + UPLOAD_DIRECTORY;

	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdir();
	            }
	            
	            
	            try {
	            	List<FileItem> formItems = upload.parseRequest(req);
	            	if(formItems != null && formItems.size() > 0) {
	            		for(FileItem item : formItems) {
	            			if(!item.isFormField()) {
	            				String fileName = new File(item.getName()).getName();
	            				
	            				if (StringUtils.isNotEmpty(fileName)) {
	                                  filePath = uploadPath + File.separator + fileName;
	                                File storeFile = new File(filePath);

	                                item.write(storeFile);
	                                req.setAttribute("goodmessage",
	                                        "Upload has been done successfully!");

	                            }
	            			}
	            			
	            			
	            			else {
	            				String fieldName = item.getFieldName();
	                            String fieldValue = item.getString();
	                            

	                            if (fieldName == null) {
	                                b.setImage_path(filePath);
	                            }
	                            
	                            if(fieldName.equals("category")){
	                            	category = fieldValue;
	                            }
	                            else {
	                            	switch (fieldName) {
                                    case "titulli":
                                        b.setTitulli(fieldValue);
                                        break;
                                    case "price":
                                        b.setPrice(fieldValue);
                                        break;
                                   
                                    case "quantity":
                                        b.setQuantity(fieldValue);
                                        break;
                                 
                                    case "published_year":
                                        b.setPublished_year(fieldValue);
                                        break;
                                    case "author_name":
                                        b.setAuthor_name(fieldValue);
                                        break;
                                    case "pershkrimi":
                                        b.setPershkrimi(fieldValue);
                                        break;
                                  
                                    case "image_path":
                                    	image_path = StringUtils.isEmpty(filePath) ? fieldValue : filePath;
                                        b.setImage_path(image_path);
                                        break;
                                    case "book_id":
                                        b.setBook_id(StringUtils.equals(fieldValue, null) ? "0" : fieldValue);
                                        break;
                                   
                                    default:
                                        b.setImage_path(filePath);
                                        break;
	                            	}
	                            	
	                            	
	                            }
	            			}
	            		}
                    	if(b.getBook_id() != "0") {
                    		book_dao.add_book(filePath, category, b);
                    	}
                    	req.setAttribute("type", "add_book");
	            	}
	            }
	            
	            catch (Exception e) {

				}
		}
		        
		
		else if(user_path.equals("/edit_book")){
			forward = Admin_Panel_Page;
			RomanceBook romance_book1 = new RomanceBook();
			PoetryBook poetry_book1 = new PoetryBook();
			ReligionBook religion_book1 = new ReligionBook();
			HistoryBook history_book1 = new HistoryBook();
			
			String book_id = req.getParameter("book_id");
			String autori = req.getParameter("author_name");
			String kategori = req.getParameter("category");
			String desc = req.getParameter("pershkrimi");
			String titulli = req.getParameter("titulli");
			String quantity = req.getParameter("quantity");
			String price = req.getParameter("price");
			String year = req.getParameter("published_year");
			
			
			
			
			if(kategori.equals("Romance")) {
				romance_dao.edit_romance_book(romance_book1,kategori,book_id,autori,desc,titulli,quantity,price,year);
				
			}
			else if(kategori.equals("Poetry")) {
				poetry_dao.edit_poetry_book(poetry_book1, category, book_id, autori, desc, titulli, quantity, price, year);
			}
			else if(kategori.equals("Religion")) {
				religion_dao.edit_religion_book(religion_book1, category, book_id, autori, desc, titulli, quantity, price, year);
			}
			else if(kategori.equals("History")) {
				System.out.println("hyre history" + " quantity : "+quantity);
				history_dao.edit_history_book(history_book1, category, book_id, autori, desc, titulli, quantity, price, year);
			}
			
			
			
				
			req.setAttribute("book_updated",
                    "Book updated!");
			 req.setAttribute("type", "edit_book");
			
		}
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	
}
