package com.revature.webcharityapp.projectdept2.services;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	static Scanner scanner = new Scanner(System.in);

	static void adlogin() throws SQLException {
		System.out.println("hiihih");
		System.out.println("ENTER USER NAME:");
		String name = scanner.next();
		System.out.println("ENTER PHONE NO:");
		int phnno = scanner.nextInt();
		System.out.println("Enter the role");
		String role = scanner.next();
		if(name.equalsIgnoreCase("deepa") && phnno==4863 && role.equalsIgnoreCase("a")) {
			ListUser.list();
			
		}
	}
}
