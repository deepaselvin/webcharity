package com.revature.webcharityapp.projectdept2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;
import com.revature.webcharityapp.projectdept2.model.requestlist;
import com.revature.webcharityapp.projectdept2.services.Fundinfo;
import com.revature.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharityapp.projectdept2.model.adminreg;

public class UserDAODetails {

	public static int register(RegUserDetails User) throws SQLException, DBException {

		String sql = "insert into Users(name,phone_no) values (?,?)";
		Connection con = ConncetionUtil.getconnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, User.getName());
		pst.setLong(2, User.getPhoneno());
		
		int rows = pst.executeUpdate();
		return rows;
	}

	public static RegUserDetails login(String name, long phnno)
			throws SQLException, ClassNotFoundException, DBException {

		String sql = "select * from Users where name=? and phone_no=? ";
		RegUserDetails rg=null;
		
		try {
			Connection con = ConncetionUtil.getconnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setLong(2, phnno);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				rg=new RegUserDetails();
				rg.setName(name);
				rg.setPhoneno(phnno);
				System.out.println("Register Login sucessfully");
			}
		} catch (SQLException e) {
		
			
			throw new DBException("unable to select");
		}
		return rg;
	}
	public static int adminRegister(adminreg User) throws SQLException, DBException {

		String sql = "insert into AdminUsers(name,phone_no) values (?,?)";
		Connection con = ConncetionUtil.getconnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, User.getAdminName());
		pst.setLong(2, User.getPhnoneno());
		
		int rows = pst.executeUpdate();
		return rows;
	}

	
	public static adminreg adminLogin(String adminName, long Phnoneno)
			throws Exception {

		String sql = "select * from AdminUsers where name=? and phone_no=? ";
		adminreg user = null;
		try {
			Connection con = ConncetionUtil.getconnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, adminName);
			pst.setLong(2, Phnoneno);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user = new adminreg();
				user.setAdminName(rs.getString("name"));
				System.out.println("ADMIN Login sucessfully");
			}
			else {
				System.out.println("ADMIN Login failed");
				
			}
		} catch (SQLException e) {
		
			
			throw new DBException("unable to select");
		}
		return user;
	}

	
	public static int depinfo(int accno) throws SQLException {

		Connection con = ConncetionUtil.getconnection();
		String sql1 = "select Amount_Donated from employees where Request_no=?";
		PreparedStatement pst11 = con.prepareStatement(sql1);
		pst11.setInt(1, accno);
		ResultSet rs = pst11.executeQuery();

	
		if (rs.next()) {
			Fundinfo.balance = rs.getInt(1);
		}

		return Fundinfo.balance;

	}

	public static int requestInsert(String Request_need, int Deposit, int Request_no) throws SQLException {

		Connection con = ConncetionUtil.getconnection();
		String sql = "insert into employees(Request_name,Amount_Donated,Request_no) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, Request_need);
		pst.setInt(2, Deposit);
		pst.setInt(3, Request_no);

		int rows = pst.executeUpdate();
		return rows;

	}

	public static void requestUpdate(int totalBalance, String Request_need) throws SQLException {

		Connection con = ConncetionUtil.getconnection();
		String sql1 = "update employees set Amount_Donated=? where Request_need=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setInt(1, totalBalance);
		pst1.setString(2, Request_need);
		pst1.executeUpdate();

	}

	public static int fundinfo(int Fund_needed) throws SQLException {

		Connection con = ConncetionUtil.getconnection();
		String sql = "insert into employees(Fund_needed) values (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, Fund_needed);

		int rows = pst.executeUpdate();
		return rows;
	}

	public static void adFundinfo(int Fund_needed, int Request_no) throws SQLException {

		Connection con = ConncetionUtil.getconnection();
		String sql1 = "update employees set Fund_needed=? where Request_no=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setInt(1, Fund_needed);
		pst1.setInt(2, Request_no);
		pst1.executeUpdate();

	}

	public static void fundUpdate(int fund_needed, int category_id) throws SQLException {
		
		Connection con = ConncetionUtil.getconnection();
		String sql1 = "update employees set Fund_needed=? where category_id=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setInt(1, fund_needed);
		pst1.setInt(2, category_id);
		pst1.executeUpdate();
	}

	public static List<RegUserDetails> userRequest() throws SQLException {
		
		Connection con = ConncetionUtil.getconnection();
		String sql1 = "select name,phone_no from Users ";
		PreparedStatement pst11 = con.prepareStatement(sql1);
		ResultSet rs = pst11.executeQuery();
		List<RegUserDetails> list = new ArrayList<RegUserDetails>();
		while (rs.next()) {
			RegUserDetails us = toRow(rs);

			list.add(us);
		}
		return list;
	}


	private static RegUserDetails toRow(ResultSet rs) throws SQLException {
		
		String name = rs.getString("name");
		long phnoneno = rs.getLong("phone_no");
		
		RegUserDetails user = new RegUserDetails();
		user.setName(name);
		user.setPhoneno(phnoneno);
		return user;
	}

	public static int fundUpdateAdmin(int totalBalance, String request_need) throws SQLException {
		Connection con = ConncetionUtil.getconnection();
		String sql1 = "insert into employees (Fund_needed,Request_name) values(?,?)";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setInt(1, totalBalance);
		pst1.setString(2, request_need);
		ResultSet rs = pst1.executeQuery();

		if (rs.next()) {
			Fundinfo.balance = rs.getInt(1);
		}

		return Fundinfo.balance;

	}
	public static int adminRequest(String request) throws SQLException, DBException {

		String sql = "insert into category(name) values (?)";
		Connection con = ConncetionUtil.getconnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,request );	
		int rows = pst.executeUpdate();
		return rows;
	}

	public static List<requestlist> Requestlist() throws SQLException {
		
		Connection con = ConncetionUtil.getconnection();
		String sql1 = "select * from category ";
		PreparedStatement pst11 = con.prepareStatement(sql1);
		ResultSet rs = pst11.executeQuery();
		List<requestlist> list = new ArrayList<requestlist>();
		while (rs.next()) {
			requestlist us = toRow1(rs);

			list.add(us);
		}
		return list;

	}
private static requestlist toRow1(ResultSet rs) throws SQLException {
		
		String name = rs.getString("name");
	
		
		requestlist user = new requestlist();
		user.setName(name);
		
		return user;
	}

	

}
