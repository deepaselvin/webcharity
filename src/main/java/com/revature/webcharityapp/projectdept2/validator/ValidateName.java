package com.revature.webcharityapp.projectdept2.validator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.revature.webcharityapp.projectdept2.services.Registration;

public class ValidateName {
	static Scanner scanner = new Scanner(System.in);
	 /*public static void name(String donorName) {
	        String regex = "^[a-zA-Z]+$";
	        String status = null;
	        boolean loop = true;
	        Pattern pattern = Pattern.compile(regex);
	        
	        String name = donorName;
	        do {
	            if (status != null && !status.equals("")) {
	                System.out.println("Enter your Name:");
	                name = scanner.next();
	            }
	            Matcher matcher = pattern.matcher(name);
	            // System.out.println("Hello"+matcher);
	            if (!matcher.matches()) {
	                System.out.println("Name is not specified in its correct way...please enter any key to continue ");
	                status = scanner.next();
	            } else {
	                loop = false;
	            }
	            pattern = Pattern.compile(regex);
	        } while (loop);
	    }*/
	public static void name(String donorName) throws Exception {
		 String regex = "^[a-zA-Z]+$";
	        String status = null;
	        boolean loop = true;
	        Pattern pattern = Pattern.compile(regex);
	        
	        String name = donorName;
	        do {
	            if (status != null && !status.equals("")) {
	                System.out.println("Enter your Name:");
	                name = scanner.next();
	            }
	            Matcher matcher = pattern.matcher(name);
	            // System.out.println("Hello"+matcher);
	            if (!matcher.matches()) {
	                System.out.println("Name is not specified in its correct way...");
	                Registration.register();
	            } else {
	                loop = false;
	            }
	            pattern = Pattern.compile(regex);
	        } while (loop);
	   
		
	}
	
	public static void RequestName(String Request_need) throws Exception {
		 String regex = "^[a-zA-Z]+$";
	        String status = null;
	        boolean loop = true;
	        Pattern pattern = Pattern.compile(regex);
	        
	        String name = Request_need;
	        do {
	            if (status != null && !status.equals("")) {
	                System.out.println("Enter your Request:");
	                name = scanner.next();
	            }
	            Matcher matcher = pattern.matcher(name);
	            // System.out.println("Hello"+matcher);
	            if (!matcher.matches()) {
	                System.out.println("Request is not specified in its correct way...");
	                Registration.register();
	            } else {
	                loop = false;
	            }
	            pattern = Pattern.compile(regex);
	        } while (loop);
	   
		
	}
	
}
