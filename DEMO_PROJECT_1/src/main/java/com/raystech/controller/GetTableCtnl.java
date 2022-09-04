package com.raystech.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raysetch.bean.Student_MarksheetBean;
import com.raystech.model.StudentMark_Model;
@WebServlet("/GetTableCtnl")
public class GetTableCtnl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("Record.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student_MarksheetBean bean = new Student_MarksheetBean();
		StudentMark_Model model = new StudentMark_Model();
		
		ArrayList<Student_MarksheetBean> list = new ArrayList<Student_MarksheetBean>();
		
		try {
			list=(ArrayList<Student_MarksheetBean>) model.SearchStudent(bean);
			RequestDispatcher rd = req.getRequestDispatcher("Record.jsp");
			req.setAttribute("get", list);
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
