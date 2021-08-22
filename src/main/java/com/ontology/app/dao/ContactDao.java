package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.Contact;
import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;

public class ContactDao {

	public void add_contact_message(Contact contact) {
		
		String insert_contact_message = fuseki.PREFIX+"INSERT DATA {\r\n" + 
				"	nensi:contact-"+methods.create_string()+" a nensi:Contact;\r\n" +
				"  		nensi:hasEmail \"" +contact.getEmail()+ "\" ;\r\n" + 
				"  		nensi:hasFullName \"" +contact.getFull_name()+ "\" ;\r\n" + 
				"  		nensi:hasPhoneNumber \"" +contact.getPhone_number()+ "\" ;\r\n" + 
				"  		nensi:hasMessage \"" +contact.getMessage()+ "\";\r\n" +
				"}";
		
		fuseki.insert_query(insert_contact_message);
		
	}
	
	
	public List<Contact> get_all_messages(){
		List<Contact> data = new ArrayList<Contact>();
		
		String contact_query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?contact a nensi:Contact. \r\n" + 
				"  ?contact nensi:hasEmail ?email .\r\n" +
				"  ?contact nensi:hasFullName ?full_name .\r\n" +
				"  ?contact nensi:hasMessage ?message  .\r\n" +
				"  ?contact nensi:hasPhoneNumber ?phone_number  .\r\n" +
					"}\r\n" + 
				"";
		
		query_messages(contact_query, data);
		return data;
	}
	
	public void query_messages(String query,List<Contact> c) {
		ResultSet res1 = fuseki.query_data(query);
		
		while(res1.hasNext()) {
			QuerySolution sol = res1.nextSolution();
			Contact contact = new Contact();
			contact.setEmail(sol.getLiteral("email").getString());
			contact.setFull_name(sol.getLiteral("full_name").getString());
			contact.setMessage(sol.getLiteral("message").toString());
			contact.setPhone_number(sol.getLiteral("phone_number").toString());
			c.add(contact);
		}
	}
	
	
	 public String get_message_name(String email) {
	        String message_name = null;
	        try {
	            String selectQuery = null;

	            selectQuery = fuseki.PREFIX;
	            selectQuery += "SELECT  ?c "
	                    + "WHERE { \n"
	                    + " ?c rdf:type nensi:Contact .\n"
	                    + " ?c nensi:hasEmail ?email.\n"
	                    + "  FILTER (?email = \"" + email + "\" ) \n"
	                    + "}"
	                    + "";

	            ResultSet results = fuseki.query_data(selectQuery);
	            while (results.hasNext()) {
	                QuerySolution row = results.next();
	                message_name = row.getResource("c").getLocalName();
	            }

	        } catch (Exception ex) {
	        	
	        }
	        return message_name;
	    }
	
	
	public void delete_message(String email) throws Exception {

        String message = this.get_message_name(email);
        String delete_message = fuseki.PREFIX + "DELETE"
                + "{"
                + "  nensi:" + message + " ?p ?o.\n"
                + "} WHERE { \n"
                + "  nensi:" + message + " ?p ?o.\n"
                + "}";

       fuseki.insert_query(delete_message);

    }
	
}
