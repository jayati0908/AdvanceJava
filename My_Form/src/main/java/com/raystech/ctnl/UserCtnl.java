package com.raystech.ctnl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raystech.bean.RegisBean;
import com.raystech.model.RegisModel;

@WebServlet(urlPatterns = { "/User" })

public class UserCtnl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("jsessionid");

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String pwdreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

		RegisBean bean = new RegisBean();
		RegisModel model = new RegisModel();

		if (email.equals("") && pwd.equals("")) {

			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");

			request.setAttribute("email", "Enter Your EmailId ");
			request.setAttribute("pwd", "Enter Your Password");

			rd.forward(request, response);

		} else if (email.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			request.setAttribute("email", "enter email id");

			rd.forward(request, response);
		} else if (!email.matches(emailreg)) {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			request.setAttribute("email", "enter correct email id");

			rd.forward(request, response);
		} else if (pwd.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");

			request.setAttribute("pwd", "enter password ");
			rd.forward(request, response);
		} else if (!pwd.matches(pwdreg)) {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");

			request.setAttribute("pwd", "enter correct password ");
			rd.forward(request, response);
		} else {

			System.out.println("do post");
			try {
				bean = model.Authenticate(email, pwd);
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				session.setAttribute("password", pwd);

				if (bean.getEmail() != null) {
					RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
					request.setAttribute("myname", bean.getFname());
					session.setAttribute("sess", id);
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
					request.setAttribute("msg", "you are not registered please signup");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in Authenticate ");

			}
		}
	}

}
