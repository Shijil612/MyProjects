package com.abc.bankapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NumberFormatException {
		HttpSession session=request.getSession();
		
		
		
		
		
		
		
		
		
		
		int accno=(int) session.getAttribute("accno");
		
		String raccno= request.getParameter("raccno");
		String bal=request.getParameter("amt");
		
		int theRaccno=Integer.parseInt(raccno);
		int theBalance=Integer.parseInt(bal);
		
		                                                                              
		
		try {
			
			Model model=new Model();
			model.setAccno(accno);
			model.setBalance(theBalance);
			model.setTheRaccno(theRaccno);
			boolean result=model.transfer();
			if(result)
			{
				response.sendRedirect("/BankAPP/successtransfer.jsp");
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
