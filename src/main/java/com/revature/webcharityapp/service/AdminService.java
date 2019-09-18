package com.revature.webcharityapp.service;

import java.sql.SQLException;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.exception.DBException;

import com.revature.webcharityapp.projectdept2.model.adminreg;

public class AdminService {

public static adminreg loginProcess( String name,long phnno)throws SQLException, DBException, ClassNotFoundException {
		
	adminreg user=null;
		
	try {
		user=UserDAODetails.adminLogin(name, phnno);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return user;
	    }
public static void registerProcess( adminreg user)throws SQLException, DBException, ClassNotFoundException {
	
	UserDAODetails.adminRegister(user);
	}	
public static void addrequestProcess(String RequestName ) {
	try {
		UserDAODetails.adminRequest(RequestName);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
