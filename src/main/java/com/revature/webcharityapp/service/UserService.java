package com.revature.webcharityapp.service;

import com.revature.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharityapp.projectdept2.model.requestlist;

import java.sql.SQLException;
import java.util.List;

public class UserService {
	

	public static RegUserDetails loginProcess( String name,long phnno)throws SQLException, DBException, ClassNotFoundException {
		
		RegUserDetails rd=null;
		
		rd=UserDAODetails.login(name, phnno);
		return rd;
	    }
	public static void registerProcess( RegUserDetails rd)throws SQLException, DBException, ClassNotFoundException {
		
		UserDAODetails.register(rd);
		}	
	public static  List<requestlist> Requestlist(){
		 List<requestlist> list=null;
			try {
				list = UserDAODetails .Requestlist();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		 
		}	
	
	
}

	

