package com.abc.bankapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class changepasssword extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		String cnpwd=request.getParameter("cnpwd");
		
		try {
			Model model=new Model();
			model.setAccno(accno);
			model.setPwd(cnpwd);
			boolean result=model.changepwd();
			if(result)
			{
				response.sendRedirect("/BankAPP/successpwd.html");
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
