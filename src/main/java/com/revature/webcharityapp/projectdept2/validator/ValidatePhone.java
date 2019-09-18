package com.revature.webcharityapp.projectdept2.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.webcharityapp.projectdept2.exception.ValidatorException;


public class ValidatePhone {
	
	   

	public static boolean validateBeforeRegistration(long phoneno) throws ValidatorException
  
    { 
        
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        String str6  = new StringBuffer().append(phoneno).toString(); 
        Matcher m = p.matcher(str6); 
      
//        if (validateBeforeRegistration(str6))  
//        	{
//        	System.out.println("Registered Successfully");
//        	}
//        else 
//        	
//            System.out.println("Invalid Number");  
        return (m.find() && m.group().equals(m)); 
    }

	public static boolean adminvalidateBeforeRegistration(long phnoneno) {
		// TODO Auto-generated method stub
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        String str6  = new StringBuffer().append(phnoneno).toString(); 
        Matcher m = p.matcher(str6); 
      
//        if (validateBeforeRegistration(str6))  
//        	{
//        	System.out.println("Registered Successfully");
//        	}
//        else 
//        	
//            System.out.println("Invalid Number");  
        return (m.find() && m.group().equals(m)); 
	} 
  
	/* public static void main(String[] args) throws ValidatorException 
    {  
    int phoneno = scanner.nextInt();
    	String str6 = new StringBuffer().append(phoneno).toString(); 
        if (validateBeforeRegistration(str6))  
        	{
        	System.out.println("Registered Successfully");
        	}
        else 
        	
            System.out.println("Invalid Number");         
    } */
} 