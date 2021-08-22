package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.ontology.app.model.ReligionBook;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;


public class ReligionDao {
	String select_query = "";

	public List<ReligionBook> getAllRomance(){
		List<ReligionBook> data = new ArrayList<ReligionBook>();
		String romance_books_query = fuseki.PREFIX + "SELECT  * \n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a nensi:Religion; \n"
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
	
	public void query_all_romance_book(String query , List<ReligionBook> data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			ReligionBook pb = new ReligionBook();
			pb.setTitulli(solution.getLiteral("title").getString());
			pb.setAuthor_name(solution.getLiteral("author_name").getString());
			pb.setImage_path(solution.getLiteral("image_path").getString());
			pb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			pb.setPrice(solution.getLiteral("price").getString());
			pb.setBook_id(solution.getLiteral("book_id").getString());
			pb.setQuantity(solution.getLiteral("quantity").getString());
			data.add(pb);
		}
	}
	
	public void add_religion_book(ReligionBook religion) {
		BooksDao books_dao = new BooksDao();
		int id = books_dao.get_book_id_number() + 1;
		religion.setBook_id(id+"");
		
		String insert_religion = fuseki.PREFIX + "INSERT DATA{\r\n"
                + " nensi:" + methods.create_string() + " a owl:Thing , nensi:Religion;\n"
                + "    nensi:hasAuthor \"" + religion.getAuthor_name() + "\";\r\n"
                + "    nensi:hasTitle \"" + religion.getTitulli() + "\";\r\n"
                + "    nensi:hasQuantity \"" + religion.getQuantity() + "\";\r\n"
                + "    nensi:hasDescription   \"" + religion.getPershkrimi() + "\";\r\n"
                + "    nensi:hasCategory  \"" + religion.getCategory() + "\";\r\n"
                + "    nensi:hasBookId  \"" + religion.getBook_id() + "\";\r\n"
                + "    nensi:hasImage  \"" + religion.getImage_path() + "\";\r\n"
                + "    nensi:hasPublishedYear  \"" + religion.getPublished_year() + "\";\r\n"
                + "    nensi:hasPrice \"" + religion.getPrice() + "\".\r\n"
                + "}";
		fuseki.insert_query(insert_religion);
	}
	
public void edit_religion_book(ReligionBook religion,String category, String id,String author_name,String desc, String titulli,String quantity,String price,String year) {
		
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
					"	?book a owl:Thing , nensi:Religion; \n"
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
					"	?book rdf:type owl:Thing , nensi:Religion . \n" +
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
