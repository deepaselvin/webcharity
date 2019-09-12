package com.revature.webcharityapp.projectdept2.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;

public class ListUser {

	public static void list() throws SQLException {
		List<RegUserDetails> list = UserDAODetails.userRequest();
		for (RegUserDetails user : list) {

			// System.out.println(us.getName()+" "+us.getPhone_no()+" "+us.getRole());

			System.out.println(user);
		}

	}
}
