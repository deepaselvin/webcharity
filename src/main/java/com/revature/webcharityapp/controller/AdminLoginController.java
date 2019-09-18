package com.revature.webcharityapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.adminreg;
import com.revature.webcharityapp.service.AdminService;

public class AdminLoginController {
	public static String login(String enter_name, long enter_phn_no) {
        
        String errorMessage = null;
       
        adminreg user  = null;
        try {
        	user =AdminService.loginProcess(enter_name, enter_phn_no);
        	//user = UserDAODetails.adminLogin( enter_name, enter_phn_no);
             if(user == null) {
            	 throw new Exception("invalid");
             }
        } catch (Exception e) {
            //e.printStackTrace();
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
        adminreg user = new adminreg();
        user  = null;
        try {
        	user.setAdminName(donorName);
    		user.setPhnoneno((phone_no));
    		AdminService.registerProcess(user);
    		//UserDAODetails.adminRegister(user);
    		Message="sucess";
    		 }
         catch (Exception e) {
            e.printStackTrace();
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

	public static String Addrequest (String RequestName) {
        
        String errorMessage = null;
        String Message = null;
        adminreg user = new adminreg();
        
        try {
        	user.setRequestName(RequestName);
        
    	UserDAODetails.adminRequest(RequestName);
    		Message="sucess";
    		 }
         catch (Exception e) {
            e.printStackTrace();
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
         
    	//TestLogin();
    	//Testregister();
    	TestAddrequest() ;
         
    }
    private static void TestLogin() {
    	 System.out.println("Test Case 1: Valid User");
         String validUserJson = AdminLoginController.login("pradeepa",9488544846l);
         System.out.println(validUserJson);
          
         System.out.println("Test Case 2: Invalid User");
         String invalidUserJson = AdminLoginController.login("invalid",56548);
         System.out.println(invalidUserJson);
    }
    private static void Testregister() {
		System.out.println("Test Case 1: Valid User Register");
        String validUserJson = AdminLoginController.Register("gayu",1236547898l);
        System.out.println(validUserJson);
         
        System.out.println("Test Case 2: Invalid User");
        String invalidUserJson = AdminLoginController.Register("invalid",56548);
        System.out.println(invalidUserJson);
         
	}
    private static void TestAddrequest() {
		System.out.println("Test Case 1: Valid User Register");
        String validUserJson = AdminLoginController.Addrequest("food");
        System.out.println(validUserJson);
         
        
	}


}
