package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.RomanceBook;
import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;


public class RomanceDao {
	String select_query = "";

	public List<RomanceBook> getAllRomance(){
		List<RomanceBook> data = new ArrayList<RomanceBook>();
		String romance_books_query = fuseki.PREFIX + "SELECT  * \n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a nensi:Romance; \n"
                + "    nensi:hasTitle ?title ; \n"
                + "    nensi:hasAuthor ?author_name ; \n"
                + "    nensi:hasImage ?image_path ; \n" 
                + "    nensi:hasPrice ?price ; \n"
                + "    nensi:hasBookId ?book_id ; \n" 
                + "    nensi:hasQuantity ?quantity ; \n"
                + "    nensi:hasDescription ?pershkrimi"
                + "} ";
		query_all_romance_book(romance_books_query, data);
		return data;
	}
	
	public void query_all_romance_book(String query , List<RomanceBook> data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			RomanceBook rb = new RomanceBook();
			rb.setTitulli(solution.getLiteral("title").getString());
			rb.setAuthor_name(solution.getLiteral("author_name").getString());
			rb.setImage_path(solution.getLiteral("image_path").getString());
			rb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			rb.setPrice(solution.getLiteral("price").getString());
			rb.setBook_id(solution.getLiteral("book_id").getString());
			rb.setQuantity(solution.getLiteral("quantity").getString());
			data.add(rb);
		}
	}
	
	
	public void query_all_book(String query , RomanceBook data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			RomanceBook rb = new RomanceBook();
			rb.setTitulli(solution.getLiteral("title").getString());
			rb.setAuthor_name(solution.getLiteral("author_name").getString());
			rb.setImage_path(solution.getLiteral("image_path").getString());
			rb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			rb.setBook_id(solution.getLiteral("book_id").getString());
			rb.setPrice(solution.getLiteral("price").getString());
			rb.setQuantity(solution.getLiteral("quantity").getString());
		}
	}
	
	

	public void add_romance_book(RomanceBook romance) {
		BooksDao books_dao = new BooksDao();
		int id = books_dao.get_book_id_number() + 1;
		romance.setBook_id(id+"");
		
		String insert_romance = fuseki.PREFIX + "INSERT DATA{\r\n"
                + " nensi:" + methods.create_string() + " a owl:Thing , nensi:Romance;\n"
                + "    nensi:hasAuthor \"" + romance.getAuthor_name() + "\";\r\n"
                + "    nensi:hasTitle \"" + romance.getTitulli() + "\";\r\n"
                + "    nensi:hasQuantity \"" + romance.getQuantity() + "\";\r\n"
                + "    nensi:hasDescription   \"" + romance.getPershkrimi() + "\";\r\n"
                + "    nensi:hasCategory  \"" + romance.getCategory() + "\";\r\n"
                + "    nensi:hasBookId  \"" + romance.getBook_id() + "\";\r\n"
                + "    nensi:hasImage  \"" + romance.getImage_path() + "\";\r\n"
                + "    nensi:hasPublishedYear  \"" + romance.getPublished_year() + "\";\r\n"
                + "    nensi:hasPrice \"" + romance.getPrice() + "\".\r\n"
                + "}";
		fuseki.insert_query(insert_romance);
	}

	public void edit_romance_book(RomanceBook romance,String category, String id,String author_name,String desc, String titulli,String quantity,String price,String year) {
		
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
					"	?book a owl:Thing , nensi:Romance; \n"
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
					"	?book rdf:type owl:Thing , nensi:Romance . \n" +
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
