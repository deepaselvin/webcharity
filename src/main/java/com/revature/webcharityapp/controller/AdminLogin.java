package com.revature.webcharityapp.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.adminreg;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Inputs
		String donorName = request.getParameter("UserName");
		String phone_no = request.getParameter("PhoneNo");
		PrintWriter out = response.getWriter();
		System.out.println("UserName:" + donorName);
		System.out.println("PhoneNo:" + phone_no);
		
		UserDAODetails dao = new UserDAODetails();
		
		adminreg usr = null;
		try {
			usr = dao.adminLogin(donorName, Long.parseLong(phone_no));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Convert list to json
		Gson gson = new Gson();
		String json = gson.toJson(usr);

		out.print(json);
		out.flush();

	}

}
