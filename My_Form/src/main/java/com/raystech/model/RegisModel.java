package com.raystech.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.raystech.bean.RegisBean;

public class RegisModel {
	ResourceBundle rb = ResourceBundle.getBundle("com.raystech.bundle.app");

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public void add(RegisBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
		conn.setAutoCommit(false);
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getEmail());
		ps.setString(5, bean.getPwd());
		ps.setString(6, bean.getNumber());
		ps.setString(7, bean.getDate());
		ps.setString(8, bean.getGender());

		
		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();

	}

	public RegisBean Authenticate(String S, String T) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from user where email = ? and pwd = ?");
		ps.setString(1, S);
		ps.setString(2, T);

		ResultSet rs = ps.executeQuery();
		RegisBean bean = new RegisBean();
		while (rs.next()) {
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPwd(rs.getString(5));
			bean.setNumber(rs.getString(6));
			bean.setDate(rs.getString(7));
			bean.setGender(rs.getString(8));

		}
		return bean;

	}

	public RegisBean forget(String f) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from user where email = ?");
		ps.setString(1, f);

	ResultSet rs = ps.executeQuery();
		
	RegisBean bean = new RegisBean();
	
	while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPwd(rs.getString(5));
			bean.setNumber(rs.getString(6));
			bean.setDate(rs.getString(7));
			bean.setGender(rs.getString(8));
	}
		return bean;
	}
	
	
}
