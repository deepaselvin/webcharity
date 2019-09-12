package com.revature.webcharityapp.projectdept2.services;

import java.sql.Connection;

import java.util.Scanner;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;



public class Fundinfo {
	public static int balance = 0;
	static Scanner scanner = new Scanner(System.in);
	static Connection con =ConncetionUtil.getconnection();
	public static void fund() throws Exception {
		try {
			
			System.out.println("Enter Request ");
			String Request_need = scanner.next();
			
			System.out.println("FUND NEEDED");
			int Fund_needed = scanner.nextInt();
			balance = Fund_needed;
			
			
			UserDAODetails.fundUpdate(Fund_needed, Request_need);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("FUND WAS NOT UPDATED");
		}
	}
}
