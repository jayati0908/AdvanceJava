package com.raystech.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.raysetch.bean.Student_MarksheetBean;


public class StudentMark_Model {

	ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rbundle.app");

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select max(id) from student_marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
	public void Add(Student_MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("insert into student_marksheet values(?,?,?,?,?,?,?,?)");
		conn.setAutoCommit(false);

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getfName());
		ps.setString(4, bean.getlName());
		ps.setString(5, bean.getPhysics());
		ps.setString(6, bean.getChemistry());
		ps.setString(7, bean.getMaths());
		ps.setString(8, bean.getSession());
		
		ps.executeUpdate();
		conn.commit();
		System.out.println("inserted...");
		ps.close();
		conn.close();
	}

	public void Modify(Student_MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("update student_marksheet set fname = ? , lname = ? where roll_no = ?");
		conn.setAutoCommit(false);
		ps.setString(1, bean.getfName());
		ps.setString(2, bean.getlName());
		ps.setString(3, bean.getRollNo());
		ps.executeUpdate();
		conn.commit();
		System.out.println("updated...");
		conn.close();
		ps.close();
	}
	
	public void Delete(Student_MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url") , rb.getString("username") , rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("delete from student_marksheet where roll_no = ?");
		conn.setAutoCommit(false);
		ps.setString(1, bean.getRollNo());
		ps.executeUpdate();
		conn.commit();
		System.out.println("deleted...");
		ps.close();
		conn.close();
	}
	public List<Student_MarksheetBean> GetId(Student_MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url") , rb.getString("username") , rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from student_marksheet where roll_no = ?");
		ps.setString(1, bean.getRollNo());
		ResultSet rs = ps.executeQuery();
		ArrayList<Student_MarksheetBean> list = new ArrayList<Student_MarksheetBean>();

		while (rs.next()) {
			Student_MarksheetBean bean1 = new Student_MarksheetBean();
			
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getString(2));
			bean1.setfName(rs.getString(3));
			bean1.setlName(rs.getString(4));
			bean1.setPhysics(rs.getString(5));
			bean1.setChemistry(rs.getString(6));
			bean1.setMaths(rs.getString(7));
			bean1.setSession(rs.getString(8));
			
			 list.add(bean1);
			
		}
		return list;
		
	}
	public List<Student_MarksheetBean> SearchStudent(Student_MarksheetBean bean) throws Exception {
		
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url") , rb.getString("username") , rb.getString("pwd"));
		PreparedStatement ps = conn.prepareStatement("select * from student_marksheet");
		ResultSet rs = ps.executeQuery();
		ArrayList<Student_MarksheetBean> list = new ArrayList<Student_MarksheetBean>();
		while (rs.next()) {
			Student_MarksheetBean bean1 = new Student_MarksheetBean();
			
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getString(2));
			bean1.setfName(rs.getString(3));
			bean1.setlName(rs.getString(4));
			bean1.setPhysics(rs.getString(5));
			bean1.setChemistry(rs.getString(6));
			bean1.setMaths(rs.getString(7));
			bean1.setSession(rs.getString(8));
			
			list.add(bean1);
		}
		return list;
		
	}

}
