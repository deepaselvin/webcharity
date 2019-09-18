package com.revature.webcharityapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharityapp.projectdept2.model.adminreg;
import com.revature.webcharityapp.projectdept2.model.requestlist;
import com.revature.webcharityapp.service.UserService;

public class LoginController {
	@SuppressWarnings("unused")
	public static String login(String name, long phnno) {
        
        String errorMessage = null;
        RegUserDetails user  = new  RegUserDetails();
           
        try {
        	UserService.loginProcess(name, phnno);
        	//user = UserDAODetails.login( name, phnno);
             if(user == null) {
            	 throw new Exception("invalid");
             }
        } catch (Exception e) {
          //  e.printStackTrace();
            errorMessage = e.getMessage();
        }       
         
        // Prepare JSON Object
        String json = null;
        Gson gson = new Gson();
        if( user != null) {
             json = gson.toJson(user);
        }
        else if ( user == null ) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
            json = obj.toString();
        }
		return json;
               
        
         
    }
	public static String Register(String donorName, long phone_no) {
        
        String errorMessage = null;
        String Message = null;
        RegUserDetails user  = new RegUserDetails();
        try {
        	user.setName(donorName);
    		user.setPhoneno((phone_no));
    		UserService.registerProcess(user);
    		//UserDAODetails.register(user);
    		Message="sucess";
    		 }
         catch (Exception e) {
          //  e.printStackTrace();
            errorMessage = e.getMessage();
        }       
         
        // Prepare JSON Object
       
        JsonObject obj = new JsonObject();
        if (Message != null) {
            obj.addProperty("MESSAGE:", Message);
        } else if (errorMessage != null) {
            obj.addProperty("errorMessage", errorMessage);
        }
        return obj.toString();        
        
        
         
    }
	
	public static String listRequest1() throws SQLException, DBException {
        String json = null;
        List<requestlist> list = null;
        String errorMessage = null;
        list=UserDAODetails.Requestlist();
        if (list != null) {
            Gson gson = new Gson();
            json = gson.toJson(list);
        }
        if (errorMessage != null) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
        }
        return json;
    }
	public static String listRequest() throws SQLException {
        String json = null;
        List<requestlist> list = null;
        String errorMessage = null;
       
            list = UserService.Requestlist();
         
        if (list != null) {
            Gson gson = new Gson();
            json = gson.toJson(list);
        }
        if (errorMessage != null) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
        }
        return json;
    }
    
	public static String contributereq(String amountDonated) throws SQLException, DBException {
		
		 String errorMessage = null;
	        String Message = null;
	        adminreg user  = new adminreg();
	        try {
	        	user.setAmountDonated(amountDonated);
	    
	    		//UserDAODetails.fundinfo(user);
	    		Message="sucess";
	    		 }
	         catch (Exception e) {
	          //  e.printStackTrace();
	            errorMessage = e.getMessage();
	        }       
	         
	        // Prepare JSON Object
	       
	        JsonObject obj = new JsonObject();
	        if (Message != null) {
	            obj.addProperty("MESSAGE:", Message);
	        } else if (errorMessage != null) {
	            obj.addProperty("errorMessage", errorMessage);
	        }
	        return obj.toString();        
	       
		
	
		
	}
	
	public static void main(String[] args) {
    	Testlogin();
    	//Testregister();
    }
    
    
    
    
	private static void Testlogin() {
		System.out.println("Test Case 1: Valid User Login");
        String validUserJson = LoginController.login("deepa",4863);
        System.out.println(validUserJson);
         
        System.out.println("Test Case 2: Invalid User");
        String invalidUserJson = LoginController.login("invalchid",565849615548l);
        System.out.println(invalidUserJson);
         }
	private static void Testregister() {
		System.out.println("Test Case 1: Valid User Register");
        String validUserJson = LoginController.Register("de",1000000l);
        System.out.println(validUserJson);
         
        System.out.println("Test Case 2: Invalid User");
        String invalidUserJson = LoginController.Register("invalid",56548);
        System.out.println(invalidUserJson);
         
	}
}
