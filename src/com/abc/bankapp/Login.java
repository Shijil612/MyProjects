package com.abc.bankapp;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusid=request.getParameter("cusid");
		String pwd=request.getParameter("pwd");
		Model model;
		try {
			model = new Model();
	
		model.setCusid(cusid);
		model.setPwd(pwd);
		boolean result=model.Login();
		if(result)
		{
			int accno=model.getAccno();
			HttpSession session=request.getSession(true);
			session.setAttribute("accno",accno);
			response.sendRedirect("/BankAPP/home.jsp");
		}
		else
		{
			response.sendRedirect("/BankAPP/error.html");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}