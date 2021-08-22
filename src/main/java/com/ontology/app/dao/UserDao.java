package com.ontology.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import com.ontology.app.model.User;
import com.ontology.app.utils.fuseki;
import com.ontology.app.utils.methods;

public class UserDao {


    public UserDao() {

    }

    String select_query = "";

    public List<User> getAllUser() {
        List<User> data = new ArrayList<User>();
//		String user_query = fuseki.PREFIX + "SELECT * \r\n" + 
//				"WHERE {\r\n" + 
//				"  ?x a nensi:Client; \r\n" + 
//				"  nensi:hasEmail ?email ;\r\n" + 
//				"  nensi:hasPassword ?password  \r\n" + 
//				"}\r\n" + 
//				"";

        String user_query = fuseki.PREFIX + "SELECT * \r\n" +
                "WHERE {\r\n" +
                "  ?user a nensi:Client. \r\n" +
                "  ?user nensi:hasEmail ?email .\r\n" +
                "  ?user nensi:hasId ?user_id .\r\n" +
                "  ?user nensi:hasPassword ?password  .\r\n" +
                "  ?user nensi:hasFirstName ?first_name  .\r\n" +
                "  ?user nensi:hasLastName ?last_name  .\r\n" +
                "  ?user nensi:hasPhoneNumber ?phone_number  .\r\n" +
                "  ?user nensi:hasAddress ?address  .\r\n" +
                "  ?user nensi:hasCity ?city  .\r\n" +
                "  ?user nensi:hasCountry ?country  .\r\n" +
                "}\r\n" +
                "";

        query_user(user_query, data);
        return data;
    }

    public void query_user(String query, List<User> user) {
        ResultSet res = fuseki.query_data(query);
        while (res.hasNext()) {
            QuerySolution solution = res.nextSolution();
            User u = new User();
            ;

            u.setCountry(solution.getLiteral("country").getString());
            u.setCity(solution.getLiteral("city").getString());
            u.setAddress(solution.getLiteral("address").getString());

            u.setUser_id(solution.getLiteral("user_id").getString());
            u.setFirst_name(solution.getLiteral("first_name").getString());
            u.setLast_name(solution.getLiteral("last_name").getString());
            u.setEmail(solution.getLiteral("email").getString());
            u.setPassword(solution.getLiteral("password").getString());
            u.setPhone_number(solution.getLiteral("phone_number").getString());
            user.add(u);

        }
    }

    public User getEmailPass(String email, String password) {
        User u = new User();
        String query = fuseki.PREFIX + "SELECT * \r\n" +
                "WHERE {\r\n" +
                "  ?user a nensi:Client. \r\n" +
                "  ?user nensi:hasEmail ?email .\r\n" +
                "  ?user nensi:hasPassword ?password  .\r\n" +
                "  ?user nensi:hasId ?user_id  .\r\n" +
                "  ?user nensi:hasFirstName ?first_name  .\r\n" +
                "  ?user nensi:hasLastName ?last_name  .\r\n" +
                "  ?user nensi:hasPhoneNumber ?phone_number  .\r\n" +
                "  ?user nensi:hasAddress ?address  .\r\n" +
                "  ?user nensi:hasCity ?city  .\r\n" +
                "  ?user nensi:hasCountry ?country  .\r\n" +
                " FILTER (?email  = \"" + email + "\" && ?password = \"" + password + "\") " +
                "}\r\n" +
                "";
        query_user_emailpass(query, u);
        return u;
    }

    public void query_user_emailpass(String query1, User u) {


        ResultSet rs = fuseki.query_data(query1);
        while (rs.hasNext()) {
            QuerySolution sol = rs.nextSolution();
            u.setUser_id(sol.getLiteral("user_id").getString());
            u.setFirst_name(sol.getLiteral("first_name").getString());
            u.setLast_name(sol.getLiteral("last_name").getString());
            u.setEmail(sol.getLiteral("email").getString());
            u.setPassword(sol.getLiteral("password").getString());
            u.setPhone_number(sol.getLiteral("phone_number").getString());
            u.setAddress(sol.getLiteral("address").getString());
            u.setCity(sol.getLiteral("city").getString());
            u.setCountry(sol.getLiteral("country").getString());

            //System.out.println(u.getEmail() + "loc = " + loc.getAddress());
        }
    }


    public boolean check_user_email(String email) {
        boolean check_email = false;
        String query_check = fuseki.PREFIX + "ASK {  ?c a nensi:Client .\r\n" +
                "       ?c nensi:hasEmail ?email ;\r\n" +
                "  FILTER (?email = \"" + email + "\" ) \r\n" +
                "}\r\n" +
                "   ";
        check_email = fuseki.ask_query(query_check);
        return check_email;
    }

    public boolean add_user(User user) {
        String id = UUID.randomUUID().toString();
        boolean user_exists = false;

        try {
            boolean check_by_email = this.check_user_email(user.getEmail());

            if (check_by_email) {
                user_exists = check_by_email;
            } else {
                String insert_user = fuseki.PREFIX + "INSERT DATA {\r\n" +
                        "	nensi:" + methods.create_string() + " a nensi:Client;\r\n" +
                        "  		nensi:hasId \"" + id + "\" ;\r\n" +
                        "  		nensi:hasEmail \"" + user.getEmail() + "\" ;\r\n" +
                        "  		nensi:hasPassword \"" + user.getPassword() + "\" ;\r\n" +
                        "  		nensi:hasFirstName \"" + user.getFirst_name() + "\" ;\r\n" +
                        "  		nensi:hasLastName \"" + user.getLast_name() + "\";\r\n" +
                        "  		nensi:hasPhoneNumber \"" + user.getPhone_number() + "\" ;\r\n" +
                        "  		nensi:hasAddress \"" + user.getAddress() + "\" ;\r\n" +
                        "  		nensi:hasCity \"" + user.getCity() + "\" ;\r\n" +
                        "  		nensi:hasCountry \"" + user.getCountry() + "\" ;\r\n" +
                        "}";

                fuseki.insert_query(insert_user);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user_exists;
    }


    public boolean updateUser(User u, User user_updated) {
        String update_user_query = null;

        try {
            update_user_query = fuseki.PREFIX + "DELETE { " +
                    "	 ?user_updated  nensi:hasEmail   ?email   ;\r\n" +
                    "        nensi:hasFirstName  ?first_name   ;\r\n" +
                    "        nensi:hasLastName   ?last_name   ;\r\n" +
                    "        nensi:hasPassword   ?password  ;\r\n" +
                    "        nensi:hasPhoneNumber ?phone_number  ;\r\n" +
                    "     nensi:hasCity ?city ;\n"
                    + "     nensi:hasCountry ?country ; \n"
                    + "     nensi:hasAddress ?address. \n"
                    + "}"
                    + "INSERT "
                    + "{"
                    + "?user_updated a nensi:Client ;\r\n" +
                    " 	nensi:hasEmail \"" + u.getEmail() + "\" ;\r\n" +
                    " 	nensi:hasPassword \"" + u.getPassword() + "\" ;\r\n" +
                    " 	nensi:hasFirstName \"" + u.getFirst_name() + "\" ;\r\n" +
                    "  	nensi:hasLastName \"" + u.getLast_name() + "\";\r\n" +
                    "  nensi:hasPhoneNumber \"" + u.getPhone_number() + "\" ;\r\n" +
                    "  nensi:hasAddress \"" + u.getAddress() + "\" ;\r\n" +
                    "  nensi:hasCity \"" + u.getCity() + "\" ;\r\n" +
                    "  nensi:hasCountry \"" + u.getCountry() + "\" ;\r\n" +
                    "" +
                    "} WHERE { \n"
                    + " ?user_updated rdf:type nensi:Client. \n" +
                    "?user_updated       nensi:hasId ?id   .\r\n" +
                    "?user_updated       nensi:hasEmail  ?email   .\r\n" +
                    "  ?user_updated       nensi:hasFirstName  ?first_name   .\r\n" +
                    "   ?user_updated      nensi:hasLastName   ?last_name   .\r\n" +
                    "  ?user_updated       nensi:hasPassword   ?password  .\r\n" +
                    "  ?user_updated       nensi:hasPhoneNumber ?phone_number  .\r\n" +
                    "   ?user_updated      nensi:hasAddress   ?address   .\r\n" +
                    "  ?user_updated       nensi:hasCity   ?city  .\r\n" +
                    "  ?user_updated       nensi:hasCountry ?country  .\r\n" +


                    "  FILTER (?id = \"" + u.getUser_id() + "\" ) \r\n"
                    + "}";

            System.out.println("id e userit eshte : " + u.getUser_id());
            fuseki.insert_query(update_user_query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;

    }

    public int get_count_users() {
        int nr = 0;
        //jan dhe comics
        String get_all_books = fuseki.PREFIX + "select (count(?users) as ?user )\r\n" +
                "  where {\r\n" +
                "	?users a nensi:Client ;\r\n" +
                "}";
        ResultSet res = fuseki.query_data(get_all_books);
        while (res.hasNext()) {
            QuerySolution sol = res.nextSolution();
            nr = sol.getLiteral("user").getInt();
        }
        return nr;
    }

    public int get_count_messages() {
        int nr = 0;
        //jan dhe comics
        String get_all_books = fuseki.PREFIX + "select (count(?users) as ?user )\r\n" +
                "  where {\r\n" +
                "	?users a nensi:Contact ;\r\n" +
                "}";
        ResultSet res = fuseki.query_data(get_all_books);
        while (res.hasNext()) {
            QuerySolution sol = res.nextSolution();
            nr = sol.getLiteral("user").getInt();
        }
        return nr;
    }

    public User get_user_by_id(String user_id) {
        User u = new User();
        String query = fuseki.PREFIX + "SELECT * \r\n" +
                "WHERE {\r\n" +
                "  ?user a nensi:Client. \r\n" +
                "  ?user nensi:hasEmail ?email .\r\n" +
                "  ?user nensi:hasId ?user_id .\r\n" +
                "  ?user nensi:hasPassword ?password  .\r\n" +
                "  ?user nensi:hasFirstName ?first_name  .\r\n" +
                "  ?user nensi:hasLastName ?last_name  .\r\n" +
                "  ?user nensi:hasPhoneNumber ?phone_number  .\r\n" +

                "  ?user nensi:hasAddress ?address  .\r\n" +
                "  ?user nensi:hasCity ?city  .\r\n" +
                "  ?user nensi:hasCountry ?country  .\r\n" +
                " FILTER (?user_id  = \"" + user_id + "\") " +
                "}\r\n" +
                "";
        query_user_emailpass(query, u);
        return u;

    }

    public String getEmrin(String user_id) {
        String emri = null;
        String query = fuseki.PREFIX + "SELECT  ?c "
                + "WHERE { \n"
                + " ?c rdf:type nensi:Client.\n"
                + " ?c  nensi:hasId   ?customerId.\n"
                + "  FILTER ( ?customerId = \"" + user_id + "\") \n"
                + "}"
                + "";
        ResultSet res = fuseki.query_data(query);
        while (res.hasNext()) {

            QuerySolution sol = res.nextSolution();
            emri = sol.getResource("c").getLocalName();
        }

        return emri;
    }

    public void delete_user(String user_id) {

        User user = this.get_user_by_id(user_id);
        String emri = this.getEmrin(user_id);

        String delete_query = fuseki.PREFIX + "DELETE"
                + "{"
                + "  nensi:" + emri + " ?p ?o.\n"

                + "} WHERE { \n"
                + "  nensi:" + emri + " ?p ?o.\n"

                + "}";

        fuseki.insert_query(delete_query);

    }


}
