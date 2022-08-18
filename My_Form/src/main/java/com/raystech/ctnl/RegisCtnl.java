package com.raystech.ctnl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raystech.bean.RegisBean;
import com.raystech.model.RegisModel;

//@WebServlet("/RegisCtnl")
public class RegisCtnl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String number = request.getParameter("number");
		String date = request.getParameter("date");

		String fnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String lnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String pwdreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		String numberreg = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

		RegisBean bean = new RegisBean();

		RegisModel model = new RegisModel();

		bean.setFname(fname);
		bean.setLname(lname);
		bean.setEmail(email);
		bean.setPwd(pwd);
		bean.setGender(gender);
		bean.setNumber(number);
		bean.setDate(date);

		if (fname.equals("") && lname.equals("") && email.equals("") && pwd.equals("") 
				&& number.equals("") && date.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("fname", "Enter your First Name");
			request.setAttribute("lname", "Enter your Last Name ");
			request.setAttribute("email", "Enter LoginId");
			request.setAttribute("pwd", "Enter Password");
			request.setAttribute("gender", "Enter your Gender");
			request.setAttribute("number", "Enter your Mobile Number ");
			rd.forward(request, response);
		} else if (fname.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("fname", "Please enter your First Name");
			rd.forward(request, response);
		} else if (!fname.matches(fnamereg)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("fname", "Please enter name in correct format");
			rd.forward(request, response);
		} else if (lname.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("lname", "Please enter your Last Name");
			rd.forward(request, response);
		} else if (!lname.matches(lnamereg)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("lname", "Please enter your last name in correct format");
			rd.forward(request, response);
		} else if (email.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("email", "Please enter your email as your LoginId");
			rd.forward(request, response);
		} else if (!email.matches(emailreg)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("userid", "Please enter your Email in correct format");
			rd.forward(request, response);
		} else if (pwd.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("pwd", "Please enter your Password");
			rd.forward(request, response);
		} else if (!pwd.matches(pwdreg)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("pwd", "Please enter your Password in correct format");
			rd.forward(request, response);
		} else if (number.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("number", "Please enter your Mobile Number");
			rd.forward(request, response);
		} else if (!number.matches(numberreg)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
			request.setAttribute("number", "Please enter your Mobile Number in correct format");
			rd.forward(request, response);
		} else {

			try {
				model.add(bean);

			} catch (Exception e1) {

				e1.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			request.setAttribute("smsg", "Registered Successfully! Please login");
			rd.forward(request, response);
		}
	}

}
