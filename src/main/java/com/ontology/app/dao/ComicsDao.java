package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.ontology.app.model.ComicsBook;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.utils.fuseki;


public class ComicsDao {
	String select_query = "";

	public List<ComicsBook> getAllRomance(){
		List<ComicsBook> data = new ArrayList<ComicsBook>();
		String romance_books_query = fuseki.PREFIX + "SELECT  * \n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a nensi:Comics; \n"
                + "    nensi:hasTitle ?title ; \n"
                + "    nensi:hasAuthor ?author_name ; \n"
                + "    nensi:hasImage ?image_path ; \n" 
                + "    nensi:hasDescription ?pershkrimi"
                + "} ";
		query_all_romance_book(romance_books_query, data);
		return data;
	}
	
	public void query_all_romance_book(String query , List<ComicsBook> data) {
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()) {
			QuerySolution solution = res.nextSolution();
			ComicsBook pb = new ComicsBook();
			pb.setTitulli(solution.getLiteral("title").getString());
			pb.setAuthor_name(solution.getLiteral("author_name").getString());
			pb.setImage_path(solution.getLiteral("image_path").getString());
			pb.setPershkrimi(solution.getLiteral("pershkrimi").getString());
			data.add(pb);
			//System.out.println(solution.getResource("title").getLocalName());
		}
	}
}
