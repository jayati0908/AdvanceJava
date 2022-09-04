package com.raystech.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.raysetch.bean.Registration_Bean;

public class Registration_Model {

	ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rbundle.app");

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public void Add(Registration_Bean bean) throws Exception {

		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("insert user values(?,?,?,?,?,?,?,?)");
		conn.setAutoCommit(false);
			ps.setInt(1, nextPk());
			ps.setString(2, bean.getfName());
			ps.setString(3, bean.getlName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getPwd());
			ps.setString(6, bean.getContact());
			ps.setString(7, bean.getDob());
			ps.setString(8, bean.getGender());

			ps.executeUpdate();
			System.out.println("inserted...");
			conn.commit();
			ps.close();
			conn.close();
		}
	

	public Registration_Bean authenticate(String em, String pw) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from user where email = ? and pwd = ?");
		ps.setString(1, em);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		Registration_Bean bean1 = new Registration_Bean();
		while (rs.next()) {
			bean1.setfName(rs.getString(2));
			bean1.setlName(rs.getString(3));
			bean1.setEmail(rs.getString(4));
			bean1.setPwd(rs.getString(5));
			bean1.setContact(rs.getString(6));
			bean1.setDob(rs.getString(7));
			bean1.setGender(rs.getString(8));

		}
		return bean1;

	}

	public Registration_Bean forget(String f) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from user where email = ?");
		ps.setString(1, f);
		ResultSet rs = ps.executeQuery();
		Registration_Bean bean1 = new Registration_Bean();
		while (rs.next()) {
			bean1.setId(rs.getInt(1));
			bean1.setfName(rs.getString(2));
			bean1.setlName(rs.getString(3));
			bean1.setEmail(rs.getString(4));
			bean1.setPwd(rs.getString(5));
			bean1.setContact(rs.getString(6));
			bean1.setDob(rs.getString(7));
			bean1.setGender(rs.getString(8));
		}
		return bean1;
	}
}
