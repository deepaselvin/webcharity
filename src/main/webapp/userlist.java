package com.revature.webcharityapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;

public class userlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//to call dao
				UserDAODetails UserDAO= new UserDAODetails();
				List<RegUserDetails> list = null;
				try {
					list = UserDAO.userRequest();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("list is not found");
				}
				
				//convert list to json
				Gson gson = new Gson();
				String json = gson.toJson(list);
				
				//write the json as response
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
	}

}
