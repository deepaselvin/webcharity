package com.revature.webcharityapp.projectdept2.services;

import java.sql.Connection;
import java.util.Scanner;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;

public class MainMenuList {
	static Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("unused")
	public static void show() throws Exception {
		Connection con = ConncetionUtil.getconnection();

		System.out.println("MAIN MENU \n 1 : REQUEST LIST \n 2 : DONOR LIST \n 3 : Admin User");

		int a = scanner.nextInt();
		Boolean isExit = true;
		do {
			switch (a) {

			case 1: {
			
					System.out.println("REQUEST LIST");
					ListRequest.list();
				
				Start.welcome();
			}
				break;

			case 2: {
				System.out.println("DONOR LIST");
				
				ListUser.list();
				UserDAODetails.userRequest();
				isExit = false;
					break;

				}
			

			case 3: {
				System.out.println("WELCOME TO THE CHARITY FUNDS");
				
				System.out.println("Enter Request ");
				String Req = scanner.next();
				UserDAODetails.adminRequest(Req);
				Fundinfo.fund();

				Start.welcome();
				break;
			}
			case 4:
			{
				isExit = false;
			}
			}

		}while(isExit);
	}
}
