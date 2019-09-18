package com.revature.webcharityapp.projectdept2.services;

import java.sql.SQLException;
import java.util.Scanner;



public class  Start {
 
	static Scanner scanner = new Scanner(System.in);	

	public static void welcome() throws Exception {	
		
		System.out.println("****** WELCOME TO THE CHARITY  ****** \n "
				+ "1 DONOR REGISTER  \n"
				+ " 2 DONOR LOGIN     \n"
				+ " 3 ADMIN REGISTER   \n"
				+ "4 ADMIN LOGIN   \n"
				+ "5 LOG OUT");
		int a = scanner.nextInt();
		
		switch(a) {
		case 1:{
		
		try {
			Registration.register();
		} 
		catch (Exception e)
		{
		e.printStackTrace();
			throw new Exception("Invalid Registration Details");
		}
		
		}
		welcome();
		break;
		
		case 2:{
		try {
			LoginCredits.login();
		} 
		catch(SQLException e) 
        { 
			e.printStackTrace();
            System.out.println("Exception in Login");}    
        finally
        {    System.out.println("INVALID USERNAME");        } 
		welcome();
		break;}
		case 3:{
			
			AdminLogin.adlogin();
			MainMenuList.show();
		}
		
		
		}
	}

	
}


