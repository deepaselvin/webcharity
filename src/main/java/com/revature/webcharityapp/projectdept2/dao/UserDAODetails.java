package com.revature.webcharityapp.projectdept2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.webcharityapp.projectdept2.services.Fundinfo;
import com.revature.webcharityapp.projectdept2.util.ConncetionUtil;
import com.revature.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;

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

	public static void login(String enter_name, long enter_phn_no)
			throws SQLException, ClassNotFoundException, DBException {

		String sql = "select * from Users where name=? and phone_no=? ";
		try {
			Connection con = ConncetionUtil.getconnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, enter_name);
			pst.setLong(2, enter_phn_no);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("Login sucessfully");
			}
		} catch (SQLException e) {
		
			
			throw new DBException("unable to select");
		}
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

	public static void fundUpdate(int fund_needed, String request_need) throws SQLException {
		
		Connection con = ConncetionUtil.getconnection();
		String sql1 = "update employees set Fund_needed=? where Request_name=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setInt(1, fund_needed);
		pst1.setString(2, request_need);
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

}
