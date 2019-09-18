package com.revature.webcharityapp.projectdept2.services;

import java.sql.Connection;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;
import com.revature.webcharityapp.projectdept2.validator.ValidateName;
import com.revature.webcharityapp.projectdept2.validator.ValidatePhone;
import com.revature.webcharityapp.projectdept2.validator.ValidatorReg;

public class Registration {
	static Scanner scanner = new Scanner(System.in);
	Connection con = ConncetionUtil.getconnection();
	static ValidatorReg valid = new ValidatorReg();

	public static void register() throws Exception {

		scanner = new Scanner(System.in);
		String donorName = null;
		long Phnoneno = 0;
		try {
			System.out.println(" User Name:");
			donorName = scanner.next();
			ValidateName.name(donorName);
			

			System.out.println(" enter Phnone No:");
			Phnoneno = scanner.nextLong();
		} catch (InputMismatchException e1) {
			System.out.println("enter valid name and phone no");
			register();
		}
		

		RegUserDetails user;
		user = new RegUserDetails();
		user.setName(donorName);
		user.setPhoneno(Phnoneno);
		try {
			ValidatorReg.validateBeforeRegistration(user);
			ValidatePhone.validateBeforeRegistration(Phnoneno);
			System.out.println("Registered sucessfully");

		} catch (InputMismatchException e) {
			System.out.println("enter valid  phone no");
			register();
		}

		UserDAODetails.register(user);
		// System.out.println("Registered successfully");
		System.out.println("FUND NEEDED FOR THE REQUESTS");
		System.out.println("  01 : CHILDRENS EDUCTAION \n  02 : HEALTH & NUTRITION ");
		LoginCredits.login();
	}

}
