
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

@WebServlet("/RegistrationCtnl")
public class RegistrationCtnl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Registration_Bean bean = new Registration_Bean();
		Registration_Model model = new Registration_Model();

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String number = req.getParameter("contact");
		String date = req.getParameter("date");

		bean.setfName(fname);
		bean.setlName(lname);
		bean.setEmail(email);
		bean.setPwd(pwd);
		bean.setGender(gender);
		bean.setContact(number);
		bean.setDob(date);

		String fnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String lnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String pwdreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		String numberreg = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

		if (fname.equals("") && lname.equals("") && email.equals("") && pwd.equals("") && number.equals("")
				&& date.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("Registration.jsp");
			req.setAttribute("fname", "Enter your First Name");
			req.setAttribute("lname", "Enter your Last Name ");
			req.setAttribute("email", "Enter LoginId");
			req.setAttribute("pwd", "Enter Password");
			req.setAttribute("gender", "Select your Gender");
			req.setAttribute("dob", "Enter your Date of birth");
			req.setAttribute("contact", "Enter your Mobile Number ");
			rd.forward(req, resp);
		} else if (fname.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("fname", "Please enter your First Name");
			rd.forward(req, resp);
		} else if (!fname.matches(fnamereg)) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("fname", "Please enter name in correct format");
			rd.forward(req, resp);
		} else if (lname.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("lname", "Please enter your Last Name");
			rd.forward(req, resp);
		} else if (!lname.matches(lnamereg)) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("lname", "Please enter your last name in correct format");
			rd.forward(req, resp);
		} else if (email.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("email", "Please enter your email as your LoginId");
			rd.forward(req, resp);
		} else if (!email.matches(emailreg)) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("email", "Please enter your Email in correct format");
			rd.forward(req, resp);
		} else if (pwd.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("pwd", "Please enter your Password");
			rd.forward(req, resp);
		} else if (!pwd.matches(pwdreg)) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("pwd", "Please enter your Password in correct format");
			rd.forward(req, resp);
		} else if (number.equals("")) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("contact", "Please enter your Mobile Number");
			rd.forward(req, resp);
		} else if (!number.matches(numberreg)) {
			RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
			req.setAttribute("contact", "Please enter your Mobile Number in correct format");
			rd.forward(req, resp);
		} else {
			try {

				model.Add(bean);
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
