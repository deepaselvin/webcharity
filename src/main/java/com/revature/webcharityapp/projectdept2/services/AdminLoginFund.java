package com.revature.webcharityapp.projectdept2.services;


import java.util.Scanner;

public class AdminLoginFund {

	static Scanner scanner = new Scanner(System.in);

	static void adlogin() throws Exception {
		
		System.out.println("ENTER USER NAME:");
		String name = scanner.next();
		System.out.println("ENTER PHONE NO:");
		int phnno = scanner.nextInt();
		System.out.println("Enter the role");
		String role = scanner.next();
		if(name.equalsIgnoreCase("deepa") && phnno==4863 && role.equals("a")) {

			System.out.println("MAIN MENU \n  01 : CHILDRENS EDUCTAION \n  02 : HEALTH & NUTRITION \n  03 : LOG OUT");
			System.out.println("Enter Request Number");
			int Reqno = scanner.nextInt();

			Fundinfo.fund();

		}
}
}
