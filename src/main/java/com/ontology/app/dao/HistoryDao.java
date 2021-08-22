package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.ontology.app.model.HistoryBook;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;


public class HistoryDao {
	String select_query = "";

	public List<HistoryBook> getAllHistory(){
		List<HistoryBook> data = new ArrayList<HistoryBook>();
		String history_books_query = fuseki.PREFIX + "SELECT  * \n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a nensi:History; \n"
                + "    nensi:hasTitle ?title ; \n"
                + "    nensi:hasAuthor ?author_name ; \n"
                + "    nensi:hasImage ?image_path ; \n"  
                + "    nensi:hasPrice ?price ; \n"
                + "    nensi:hasBookId ?book_id ; \n" 
                + "    nensi:hasQuantity ?quantity ; \n"
                + "    nensi:hasDescription ?pershkrimi"
                + "} ";
		query_all_romance_book(history_books_query, data);
		return data;
	}
	
	
	public void add_history_book(HistoryBook history) {
		BooksDao books_dao = new BooksDao();
		history.setBook_id(""+books_dao.get_book_id_number() + 1);
		
		String insert_history = fuseki.PREFIX + "INSERT DATA\n"
                + "{\n"
                + " nensi:" + methods.create_string() + " a owl:Thing , nensi:History;\n"
                + "    nensi:hasAuthor \"" + history.getAuthor_name() + "\";\n"
                + "    nensi:hasCategory \"" + history.getCategory() + "\";\n"
                + "    nensi:hasDescription \"" + history.getPershkrimi() + "\";\n"
                + "    nensi:hasImage \"" + history.getImage_path() + "\";\n"  
                + "    nensi:hasPrice \"" + history.getPrice() + "\";\n"
                + "    nensi:hasQuantity \"" + history.getQuantity() + "\";\n"
                + "    nensi:hasPublishedYear \"" + history.getPublished_year() + "\";\n"
                + "    nensi:hasTitle \"" + history.getTitulli() + "\";\n"
                + "    nensi:hasBookId \"" + history.getBook_id() + "\" .\n"
                + "}";
		fuseki.insert_query(insert_history);
	}
	
	public void query_all_romance_book(String query , List<HistoryBook> data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			HistoryBook hb = new HistoryBook();
			hb.setTitulli(solution.getLiteral("title").getString());
			hb.setAuthor_name(solution.getLiteral("author_name").getString());
			hb.setImage_path(solution.getLiteral("image_path").getString());
			hb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			hb.setPrice(solution.getLiteral("price").getString());
			hb.setBook_id(solution.getLiteral("book_id").getString());
			hb.setQuantity(solution.getLiteral("quantity").getString());
		
			data.add(hb);
			//System.out.println(solution.getResource("title").getLocalName());
		}
	}
	
	
public void edit_history_book(HistoryBook history,String category, String id,String author_name,String desc, String titulli,String quantity,String price,String year) {
		
		String qry = null;
		
			qry = fuseki.PREFIX + "delete { " + 
					"	?book nensi:hasAuthor ?author_name; \r\n" + 
					"	nensi:hasCategory ?category; \r\n" + 
	    			"	nensi:hasImage ?image_path ; \r\n" + 
					"	nensi:hasDescription ?pershkrimi ; \r\n" +
					"	nensi:hasTitle ?titulli ; \r\n" +
					"	nensi:hasQuantity ?quantity ; \r\n" +
					"	nensi:hasPrice ?price ; \r\n" +
					"	nensi:hasPublishedYear ?published_year. \r\n" +
					"}" 
					+ "INSERT "
	                + "{" +
					"	?book a owl:Thing , nensi:History; \n"
					+"	nensi:hasAuthor \"" +author_name+ "\" ; \n"
					+"	nensi:hasCategory \"" +category+ "\" ; \n"
					+"	nensi:hasImage ?image_path ; \n"
					+"	nensi:hasDescription \"" +desc+ "\" ; \n"
					+"	nensi:hasTitle \"" +titulli+ "\" ; \n"
					+"	nensi:hasQuantity \"" +quantity+ "\" ; \n"
					+"	nensi:hasPrice \"" +price+ "\" ; \n"
					+"	nensi:hasPublishedYear \"" +year+ "\" ; \n" +
					"" +
	                "} WHERE { \n" +
					"	?book rdf:type owl:Thing , nensi:History . \n" +
					"	?book nensi:hasBookId ?book_id . \n" +
					 "   ?book nensi:hasAuthor ?author_name . \n" +
					 "   ?book nensi:hasCategory ?category . \n" +
					"    ?book nensi:hasImage ?image_path . \n" +
					"    ?book nensi:hasDescription ?pershkrimi . \n" +
					"    ?book  nensi:hasTitle ?titulli . \n" +
					"    ?book nensi:hasQuantity ?quantity. \n" +
					"    ?book nensi:hasPrice ?price . \n" +
					"    ?book nensi:hasPublishedYear ?published_year . \n" +

							"  FILTER (?book_id = \"" +id+ "\" ) \r\n"
		                    + "}";
			
			
			fuseki.insert_query(qry);
		
		
		
		
	}
}
