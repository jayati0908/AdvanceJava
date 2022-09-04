package com.raystech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raysetch.bean.Registration_Bean;
import com.raystech.model.Registration_Model;
@WebServlet("/ForgotCtnl")
public class ForgotCtnl extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 Registration_Bean bean = new Registration_Bean();
		 Registration_Model model = new Registration_Model();
		 
		 String email = req.getParameter("email");
		 
		 try {
			bean = model.forget(email);
			RequestDispatcher rd = req.getRequestDispatcher("Forgot.jsp");
			req.setAttribute("pass", bean.getPwd());
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
