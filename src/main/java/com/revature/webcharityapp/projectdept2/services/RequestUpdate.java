package com.revature.webcharityapp.projectdept2.services;

import java.sql.Connection;

import java.util.Scanner;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;
import com.revature.webcharityapp.projectdept2.validator.ValidateName;

public class RequestUpdate {
	static Scanner scanner = new Scanner(System.in);
	static Connection con = ConncetionUtil.getconnection();

	public static void reqinfo() throws Exception {

		System.out.println("Enter the Request Number");
		int Request_no = scanner.nextInt();

		System.out.println("Enter Request ");
		String Request_need = scanner.next();
		ValidateName.RequestName(Request_need);

		System.out.println("Enter Amount to be Deposited:");

		int Deposit = scanner.nextInt();

		UserDAODetails.requestInsert(Request_need, Deposit, Request_no);

		CharityDeposit depo = new CharityDeposit();
		int bal = depo.depinfo(Deposit);

		int totalBalance = bal - Deposit;
		System.out.println("DONATED AMOUNT::" + Deposit);

		System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
		System.out.println("FUND STILL NEEDED:" + totalBalance);

		//UserDAODetails.fundUpdateAdmin(totalBalance, Request_need);
		if (totalBalance == 0) {
			System.out.println("**** REQUEST WAS FULLFILLED ****");
		}
		UserDAODetails.adFundinfo(totalBalance, Request_no);
		RequestList.req();

	}
}