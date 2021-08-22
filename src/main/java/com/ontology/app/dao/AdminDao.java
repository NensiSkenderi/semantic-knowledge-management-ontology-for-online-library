package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.Admin;
import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;

public class AdminDao {

	public Admin getEmailPass(String email , String password) {
		Admin adm = new Admin();
		String query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?x a nensi:Admin; \r\n" + 
				"  nensi:hasAdminEmail ?admin_email ;\r\n" + 
				"  nensi:hasAdminPassword ?admin_password  ;\r\n" +
				" FILTER (?admin_email  = \"" + email + "\" && ?admin_password = \"" + password + "\") " +
				"}\r\n" + 
				"";
		query_user_emailpass(query, adm);
		return adm;
	}
	
	public void query_user_emailpass(String query1 , Admin adm) {
		ResultSet rs = fuseki.query_data(query1);
		while(rs.hasNext()) {
			QuerySolution sol = rs.nextSolution();
			adm.setAdmin_email(sol.getLiteral("admin_email").getString());
			adm.setAdmin_password(sol.getLiteral("admin_password").getString());
		}
	}

	public List<Admin> getAllAdmin() {
		List<Admin> admins = new ArrayList<Admin>();
		
		String admins_query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?admins a nensi:Admin. \r\n" + 
				"  ?admins nensi:hasAdminEmail ?admin_email .\r\n" +
				"  ?admins nensi:hasAdminId ?admin_id .\r\n" +
				"  ?admins nensi:hasAdminPassword ?admin_password  .\r\n" +
				"  ?admins nensi:hasAdminFirstName ?admin_first_name  .\r\n" +
				"  ?admins nensi:hasAdminLastName ?admin_last_name  .\r\n" +
					"}\r\n" + 
				"";
		
		query_admins(admins_query, admins);
		return admins;
	}
	
	public void query_admins(String query , List<Admin> admins){
		ResultSet res = fuseki.query_data(query);
		
		while(res.hasNext()){
			Admin adm = new Admin();
			QuerySolution solution = res.next();
			
			adm.setAdmin_email(solution.getLiteral("admin_email").getString());
			adm.setAdmin_first_name(solution.getLiteral("admin_first_name").getString());
			adm.setAdmin_last_name(solution.getLiteral("admin_last_name").getString());
			adm.setAdmin_id(solution.getLiteral("admin_id").getString());
			adm.setAdmin_password(solution.getLiteral("admin_password").getString());
			
			admins.add(adm);
		}
	}

	public Admin get_admin_by_email(String admin_email) {
		Admin adm = new Admin();
		
		String admin_query = fuseki.PREFIX + "SELECT * \r\n" + 
				"WHERE {\r\n" + 
				"  ?x a nensi:Admin; \r\n" + 
				"  nensi:hasAdminEmail ?admin_email ;\r\n" + 
				"  nensi:hasAdminPassword ?admin_password  ;\r\n" +
				"  nensi:hasAdminId ?admin_id  ;\r\n" +
				"  nensi:hasAdminFirstName ?admin_first_name  ;\r\n" +
				"  nensi:hasAdminLastName ?admin_last_name  ;\r\n" +
				" FILTER (?admin_email  = \"" + admin_email + "\" ) " +
				"}\r\n" + 
				"";
		
		query_admins_email(admin_query, adm);
		return adm;
	}
	 
	
	public void query_admins_email(String query , Admin admins){
		ResultSet res = fuseki.query_data(query);
		while(res.hasNext()){
			QuerySolution solution = res.next();
			
			admins.setAdmin_email(solution.getLiteral("admin_email").getString());
			admins.setAdmin_first_name(solution.getLiteral("admin_first_name").getString());
			admins.setAdmin_last_name(solution.getLiteral("admin_last_name").getString());
			admins.setAdmin_id(solution.getLiteral("admin_id").getString());
			admins.setAdmin_password(solution.getLiteral("admin_password").getString());
			
		}
	}
	
	public boolean add_admin(Admin admin) {
		String admin_id = UUID.randomUUID().toString();
		boolean admin_exists = false;
		
		try {
			boolean check_by_email = this.check_user_email(admin.getAdmin_email());
			
			if(check_by_email) {
				admin_exists = check_by_email;
			}
			
			else {
				String insert_user = fuseki.PREFIX + "INSERT DATA {\r\n" + 
						"	nensi:"+methods.create_string()+" a nensi:Admin;\r\n" + 
						"  		nensi:hasAdminId \"" +admin_id+ "\" ;\r\n" + 
						"  		nensi:hasAdminEmail \"" +admin.getAdmin_email()+ "\" ;\r\n" + 
						"  		nensi:hasAdminPassword \"" +admin.getAdmin_password()+ "\" ;\r\n" + 
						"  		nensi:hasAdminFirstName \"" +admin.getAdmin_first_name()+ "\" ;\r\n" + 
						"  		nensi:hasAdminLastName \"" +admin.getAdmin_last_name()+ "\".\r\n" + 
						"}";
				
				fuseki.insert_query(insert_user);
			}
		}
		catch(Exception ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return admin_exists;
	}

	public boolean check_user_email(String admin_email) {
		
		boolean check_email = false;
		String query_check = fuseki.PREFIX + "ASK {  ?c a nensi:Admin .\r\n" + 
				"       ?c nensi:hasAdminEmail ?admin_email ;\r\n" + 
				"  FILTER (?admin_email = \"" +admin_email+ "\" ) \r\n" + 
				"}\r\n" + 
				"   ";
	    check_email = fuseki.ask_query(query_check);
		return check_email;
	}
	
	public void edit_admin(String id, String email, String f_name, String l_name, String pass) {
		String admin_update_query = null;
		
		try {
				admin_update_query = fuseki.PREFIX + "DELETE { " + 
						"	 ?admin_updated  nensi:hasAdminEmail   ?email   ;\r\n" + 
						"        nensi:hasAdminFirstName  ?first_name   ;\r\n" + 
						"        nensi:hasAdminLastName   ?last_name   ;\r\n" + 
						"        nensi:hasAdminPassword   ?password  .\r\n"  
		                    + "}" 
		                    + "INSERT "
		                    + "{"
		                  
						+ "?admin_updated a nensi:Admin ;\r\n" +
						" 	nensi:hasAdminEmail \"" +email+ "\" ;\r\n" + 
						" 	nensi:hasAdminPassword \"" +pass+ "\" ;\r\n" + 
						" 	nensi:hasAdminFirstName \"" +f_name+ "\" ;\r\n" + 
						"  	nensi:hasAdminLastName \"" +l_name+ "\";\r\n" +
						"" +
		                     "} WHERE { \n"
		                    + " ?admin_updated rdf:type nensi:Admin. \n" +
		                     "?admin_updated       nensi:hasAdminId ?id   .\r\n" +
		                     "?admin_updated       nensi:hasAdminEmail  ?email   .\r\n" +
							"  ?admin_updated       nensi:hasAdminFirstName  ?first_name   .\r\n" + 
							"   ?admin_updated      nensi:hasAdminLastName   ?last_name   .\r\n" + 
							"  ?admin_updated       nensi:hasAdminPassword   ?password  .\r\n" +
		                   
							"  FILTER (?id = \"" +id+ "\" ) \r\n"
		                    + "}";
				
				fuseki.insert_query(admin_update_query);
		}catch (Exception e) {
			System.out.println("Error, Admin was not updated");
			
		}
		
		
	}
	
	
	public void delete_admin(String email) throws Exception {

        String subjectCustomer = this.get_admin_name(email);
        String deleteCustomerQuery = fuseki.PREFIX + "DELETE"
                + "{"
                + "  nensi:" + subjectCustomer + " ?p ?o.\n"
                + "} WHERE { \n"
                + "  nensi:" + subjectCustomer + " ?p ?o.\n"
                + "}";

       fuseki.insert_query(deleteCustomerQuery);

    }
	
	 public String get_admin_name(String email) {
	        String admin_name = null;
	        try {
	            String selectQuery = null;

	            selectQuery = fuseki.PREFIX;
	            selectQuery += "SELECT  ?c "
	                    + "WHERE { \n"
	                    + " ?c rdf:type nensi:Admin.\n"
	                    + " ?c nensi:hasAdminEmail ?email.\n"
	                    + "  FILTER (?email = \"" + email + "\" ) \n"
	                    + "}"
	                    + "";

	            ResultSet results = fuseki.query_data(selectQuery);
	            while (results.hasNext()) {
	                QuerySolution row = results.next();
	                admin_name = row.getResource("c").getLocalName();
	            }

	        } catch (Exception ex) {
	        	
	        }
	        return admin_name;
	    }
	    
}
