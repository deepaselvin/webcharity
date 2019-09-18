package com.revature.webcharityapp.projectdept2.services;


import java.util.Scanner;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;

public class AdminLogin {
	static Scanner scanner = new Scanner(System.in);

	static void adlogin() throws Exception {
		System.out.println("hiihih");
		System.out.println("ENTER USER NAME:");
		String name = scanner.next();
		System.out.println("ENTER PHONE NO:");
		long phnno = scanner.nextLong();
		UserDAODetails.adminLogin(name, phnno);
		//ListUser.list();
			
		}
	}

