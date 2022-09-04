package com.raystech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raysetch.bean.Registration_Bean;
import com.raystech.model.Registration_Model;

@WebServlet("/LoginCtnl")
public class LoginCtnl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.sendRedirect("LoginForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Registration_Bean bean = new Registration_Bean();
		Registration_Model model = new Registration_Model();

		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String pwdreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

		if (email.equals("") && pwd.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("email", "Email id is required");
			req.setAttribute("pass", "password is required");

			rd.forward(req, resp);
		} else if (email.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("email", "Email id is reqired");
			rd.forward(req, resp);
		} else if (pwd.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("pass", "password is required");
			rd.forward(req, resp);
		} else if (!email.matches(emailreg) && !pwd.matches(pwdreg)) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("email", "Valid email id is required");
			req.setAttribute("pass", "Valid password id is required");

			rd.forward(req, resp);
		} else if (!email.matches(emailreg)) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("email", "Valid email id is required");
			rd.forward(req, resp);
		} else if (!pwd.matches(pwd)) {
			RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
			req.setAttribute("pass", "Valid password id is required");
			rd.forward(req, resp);
		}
		else {
			try {
				
				bean = model.authenticate(email, pwd);
				if(bean.getfName() != null) {
					RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
					HttpSession session = req.getSession();
					session.setAttribute("get", bean);

					rd.forward(req, resp);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
