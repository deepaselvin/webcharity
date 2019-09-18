package com.revature.webcharityapp.projectdept2.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.requestlist;

public class ListRequest {

	public static void list() throws SQLException {
		List<requestlist> list = UserDAODetails.Requestlist();
		for (requestlist user : list) {

			// System.out.println(us.getName()+" "+us.getPhone_no()+" "+us.getRole());

			System.out.println(user);
}
}
}