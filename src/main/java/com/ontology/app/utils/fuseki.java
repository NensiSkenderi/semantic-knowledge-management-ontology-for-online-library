package com.ontology.app.utils;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.Syntax;
import org.apache.jena.update.UpdateExecutionFactory;

public class fuseki {

	public static String PREFIX =" prefix nensi: <http://localhost:8080/nensinensi/views/books.owl/>\r\n" + 
	 		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
	 		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
	 		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
	 		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
	 		"PREFIX ne: <http://umbel.org/umbel/ne/>\r\n"  ;
	
	public static final String sparql_qry = "http://localhost:3030/nensi/query";
	public static final String update_sparql_qry = "http://localhost:3030/nensi/update";
	
	
	public static ResultSet query_data(String query) {
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.sparqlService(sparql_qry, query);
		
		ResultSet res = qe.execSelect();
		return res;
	}
	
	public static void insert_query(String update_query) {
		ParameterizedSparqlString param = new ParameterizedSparqlString();
		param.setCommandText(update_query);
		org.apache.jena.update.UpdateRequest update = param.asUpdate();
        org.apache.jena.update.UpdateProcessor proc =  UpdateExecutionFactory.createRemote(update,update_sparql_qry);
        proc.execute();
	}
	
	public static boolean ask_query(String query) {
		Query q = QueryFactory.create(query, Syntax.syntaxARQ);
		QueryExecution query_exe = QueryExecutionFactory.sparqlService(sparql_qry, query);
		boolean results = query_exe.execAsk();
		System.out.println(results);
		return results;
	}
}
