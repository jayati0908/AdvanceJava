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

@WebServlet("/getpwd")
public class Forgotctnl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String email = request.getParameter("email");
		
		RegisBean bean = new RegisBean();
		RegisModel model = new RegisModel();
		
		try {
			bean = model.forget(email);
			RequestDispatcher rd = request.getRequestDispatcher("Forget.jsp");
			request.setAttribute("passw", bean.getPwd());
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
