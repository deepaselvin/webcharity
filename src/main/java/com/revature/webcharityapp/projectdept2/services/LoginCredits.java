package com.revature.webcharityapp.projectdept2.services;

import java.sql.Connection;
import java.util.Scanner;


import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;

public class LoginCredits {
	static Scanner scanner = new Scanner(System.in);
	static Connection con = ConncetionUtil.getconnection();

	static void login() throws Exception {
		System.out.println("LOGIN PAGE");

		System.out.println("ENTER USER NAME:");
		
		String enter_name = scanner.next();
		System.out.println("ENTER PHONE NO:");
		long enter_phn_no = scanner.nextLong();
	 	

		UserDAODetails.login(enter_name, enter_phn_no);
		//MainMenuList sh = new MainMenuList();
		MainMenuList.show();

	}
}
