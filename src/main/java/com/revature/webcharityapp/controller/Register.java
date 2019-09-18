package com.revature.webcharityapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//Get Inputs
        String donorName = request.getParameter("UserName"); 
        long phone_no=Long.parseLong(request.getParameter("PhoneNo")); 
        PrintWriter out = response.getWriter();
    
	
		// Convert list to json
        
        String json = LoginController.Register(donorName, phone_no);
        out.write(json);
        out.flush();
	
	
	}
	}
