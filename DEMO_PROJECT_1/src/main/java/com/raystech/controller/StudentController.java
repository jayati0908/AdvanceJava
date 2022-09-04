package com.raystech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raysetch.bean.Student_MarksheetBean;
import com.raystech.model.StudentMark_Model;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Student_MarksheetBean bean = new Student_MarksheetBean();
		StudentMark_Model model = new StudentMark_Model();

		bean.setRollNo(req.getParameter("roll"));
		bean.setfName(req.getParameter("fname"));
		bean.setlName(req.getParameter("lname"));
		bean.setPhysics(req.getParameter("physics"));
		bean.setChemistry(req.getParameter("chemistry"));
		bean.setMaths(req.getParameter("mathematics"));
		bean.setSession(req.getParameter("session"));

		String optn = req.getParameter("operation");

		if (optn.equals("Add")) {
			try {
				model.Add(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (optn.equals("Modify")) {
			try {
				model.Modify(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (optn.equals("Delete")) {
			try {
				model.Delete(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
