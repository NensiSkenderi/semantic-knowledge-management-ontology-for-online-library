package com.ontology.app.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.Book;
import com.ontology.app.model.HistoryBook;
import com.ontology.app.model.PoetryBook;
import com.ontology.app.model.ReligionBook;
import com.ontology.app.model.RomanceBook;
import com.ontology.app.utils.fuseki;

public class BooksDao {

	private RomanceDao romance_dao;
	private HistoryDao history_dao;
	private PoetryDao poetry_dao;
	private ReligionDao religion_dao;
	private static final String UPLOAD_DIRECTORY = "img";
	
	public BooksDao() {
		romance_dao = new RomanceDao();
		history_dao = new HistoryDao();
		poetry_dao = new PoetryDao();
		religion_dao = new ReligionDao();
	}
	
	public int get_all_books() {
		int nr = 0;
		//jan dhe comics
		String get_all_books = fuseki.PREFIX + "select (count(?books) as ?book )\r\n" + 
				"  where {\r\n" + 
				"	?books a owl:Thing ;\r\n" + 
				"}";
		ResultSet res = fuseki.query_data(get_all_books);
		while(res.hasNext()) {
			QuerySolution sol = res.nextSolution();
			nr = sol.getLiteral("book").getInt();
		}
		return nr;
	}
	
	//beji per tgjitha kategorine, mos harro comics
	public int get_count_category(String kategoria) {
		int nr = 0;
		String get_all_books = fuseki.PREFIX + "select (count(?books) as ?book )\r\n" + 
				"  where {\r\n" + 
				"	?books a nensi:"+kategoria+" ;\r\n" + 
				"}";
		ResultSet res = fuseki.query_data(get_all_books);
		while(res.hasNext()) {
			QuerySolution sol = res.nextSolution();
			nr = sol.getLiteral("book").getInt();
		}
		
		return nr;
	}
	
	public List<Book> getAllBooks(){
		List<Book> data = new ArrayList<Book>();
		String book_query = fuseki.PREFIX + "SELECT * \r\n" + 
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
		query_books(book_query, data);
		return data;
		
	}
	
	public Book get_book_by_id(String book_id){
		Book b = new Book();
		String book_query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?book a owl:Thing . \r\n" + 
				"  ?book nensi:hasTitle ?titulli .\r\n" +
				"  ?book nensi:hasAuthor ?author_name . \r\n" +
				"  ?book nensi:hasImage ?image_path  . \r\n" +
				"  ?book nensi:hasBookId ?book_id  . \r\n" +
				"  ?book nensi:hasPrice ?price  . \r\n" +
				"  ?book nensi:hasQuantity ?quantity  . \r\n" +
				"  ?book nensi:hasPublishedYear ?published_year  .\r\n" +
				"  ?book nensi:hasCategory ?category  .\r\n" +
				"  ?book nensi:hasDescription ?pershkrimi  . \r\n" 
				 + "   FILTER (?book_id  = \"" + book_id + "\" ) \n" +
				 "}";
		
		query_books_per_id(book_query, b);
		return b;
	}
	
	public void query_books_per_id(String book_query, Book b) {
		ResultSet rs = fuseki.query_data(book_query);
		while (rs.hasNext()) {
			QuerySolution solution = rs.nextSolution();
			b.setTitulli(solution.getLiteral("titulli").getString());
			b.setAuthor_name(solution.getLiteral("author_name").getString());
			b.setImage_path(solution.getLiteral("image_path").getString());
			b.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			b.setBook_id(solution.getLiteral("book_id").getString());
			b.setPrice(solution.getLiteral("price").getString());
			b.setQuantity(solution.getLiteral("quantity").getString());
			b.setPublished_year(solution.getLiteral("published_year").getString());
			b.setCategory(solution.getLiteral("category").getString());
		}
	}

	public List<Book> get_books_by_category(String kategoria){
		List<Book> data = new ArrayList<Book>();
		String book_by_cat_query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?book a nensi:"+kategoria+". \r\n" + 
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
		
		query_books(book_by_cat_query, data);
		
		return data;
	}
	
	public void query_books(String query, List<Book> book1) {
		ResultSet res = fuseki.query_data(query);
		
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
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
			book1.add(book);
			
		}
	}
	
   private String setRelativeFilePath(String filePath) {
	        String tempName;
	        tempName = filePath.substring(filePath.lastIndexOf(File.separator + UPLOAD_DIRECTORY));
	        tempName = tempName.replace("\\", "/");
	        tempName = "/nensinensi"+tempName;
	        return tempName;
   }
	  
   public void add_book(String filePath, String category, Book b) {
		
		
		 if(category.equals("Romance")){
			RomanceBook romance = new RomanceBook();
			romance.copyBook(b);
			romance.setCategory(category);
			romance.setImage_path(setRelativeFilePath(filePath));
		    romance_dao.add_romance_book(romance);
		 }
		
		 else if(category.equals("History")){
			 HistoryBook history = new HistoryBook();
			 history.copyBook(b);
			 history.setCategory(category);
			 history.setImage_path(setRelativeFilePath(filePath));
			 history_dao.add_history_book(history);
		 }
		
		 else if(category.equals("Religion")){
			 ReligionBook religion = new ReligionBook();
			 religion.copyBook(b);
			 religion.setCategory(category);
			 religion.setImage_path(setRelativeFilePath(filePath));
			 religion_dao.add_religion_book(religion);
		 }
		 
		 else if(category.equals("Poetry")){
			 PoetryBook poetry = new PoetryBook();
			 poetry.copyBook(b);
			 poetry.setCategory(category);
			 poetry.setImage_path(setRelativeFilePath(filePath));
			 poetry_dao.add_poetry_book(poetry);
		 }
		
			//HistoryBook history = new HistoryBook();
			//history.copyBook(b);
			//history.setCategory(category);
			//history.setImage_path(setRelativeFilePath(filePath));
			//history_dao.add_history_book(history);
		
		
	}
   
   public boolean deleteBook(String subjetName) {
       boolean result = false;

       try {
           String deleteQuery = fuseki.PREFIX;
           deleteQuery += "DELETE { nensi:" + subjetName + " ?p ?o}\n"
                   + "WHERE  { \n"
                   + "       nensi:" + subjetName + " ?p ?o . \n"
                   + "\n"
                   + "\n"
                   + "}	";

           fuseki.insert_query(deleteQuery);
           result = true;

       } catch (Exception ex) {
           result = false;
           
       }
       return result;
   }
	
   
   public String get_name(Book b) {
       String subjectName = null;
       try {
           String selectQuery = null;

           selectQuery = fuseki.PREFIX;
           selectQuery += "SELECT  ?x\n"
                   + "\n"
                   + "WHERE\n"
                   + "{ \n"
                   + "  ?x a ?o;\n"
                   + "     nensi:hasBookId  \"" + b.getBook_id() + "\".\n"
                   + "\n"
                   + " }";

          

           ResultSet results = fuseki.query_data(selectQuery);
           while (results.hasNext()) {
               QuerySolution row = results.next();
               subjectName = row.getResource("x").getLocalName();
           }

       } catch (Exception ex) {
       }
       return subjectName;
   }



	public int get_book_id_number() {
		int nr = 0;
		
		String qry = fuseki.PREFIX + "SELECT ?s ?number\r\n" + 
				"WHERE { ?s nensi:hasBookId ?number }\r\n" + 
				"ORDER BY DESC((?s)) LIMIT 1";
		
		ResultSet res = fuseki.query_data(qry);
		
		while(res.hasNext()) {
			QuerySolution sol = res.next();
			nr = sol.getLiteral("number").getInt();
		}
		return nr;
	}

	
}
