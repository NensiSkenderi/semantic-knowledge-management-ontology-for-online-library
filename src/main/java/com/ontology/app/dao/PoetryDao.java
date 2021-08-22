package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.PoetryBook;
import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;


public class PoetryDao {
	String select_query = "";

	public List<PoetryBook> getAllRomance(){
		List<PoetryBook> data = new ArrayList<PoetryBook>();
		String romance_books_query = fuseki.PREFIX + "SELECT  * \n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a nensi:Poetry; \n"
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
	
	public void query_all_romance_book(String query , List<PoetryBook> data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			PoetryBook pb = new PoetryBook();
			pb.setTitulli(solution.getLiteral("title").getString());
			pb.setAuthor_name(solution.getLiteral("author_name").getString());
			pb.setImage_path(solution.getLiteral("image_path").getString());
			pb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			pb.setPrice(solution.getLiteral("price").getString());
			pb.setBook_id(solution.getLiteral("book_id").getString());
			pb.setQuantity(solution.getLiteral("quantity").getString());
			data.add(pb);
			//System.out.println(solution.getResource("title").getLocalName());
		}
	}
	
	public void add_poetry_book(PoetryBook poetry) {
		BooksDao books_dao = new BooksDao();
		int id = books_dao.get_book_id_number() + 1;
		poetry.setBook_id(id+"");
		
		String insert_poetry = fuseki.PREFIX + "INSERT DATA{\r\n"
                + " nensi:" + methods.create_string() + " a owl:Thing , nensi:Poetry;\n"
                + "    nensi:hasAuthor \"" + poetry.getAuthor_name() + "\";\r\n"
                + "    nensi:hasTitle \"" + poetry.getTitulli() + "\";\r\n"
                + "    nensi:hasQuantity \"" + poetry.getQuantity() + "\";\r\n"
                + "    nensi:hasDescription   \"" + poetry.getPershkrimi() + "\";\r\n"
                + "    nensi:hasCategory  \"" + poetry.getCategory() + "\";\r\n"
                + "    nensi:hasBookId  \"" + poetry.getBook_id() + "\";\r\n"
                + "    nensi:hasImage  \"" + poetry.getImage_path() + "\";\r\n"
                + "    nensi:hasPublishedYear  \"" + poetry.getPublished_year() + "\";\r\n"
                + "    nensi:hasPrice \"" + poetry.getPrice() + "\".\r\n"
                + "}";
		fuseki.insert_query(insert_poetry);
	}
	
	
	
public void edit_poetry_book(PoetryBook poetry,String category, String id,String author_name,String desc, String titulli,String quantity,String price,String year) {
		
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
					"	?book a owl:Thing , nensi:Poetry; \n"
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
					"	?book rdf:type owl:Thing , nensi:Poetry . \n" +
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
