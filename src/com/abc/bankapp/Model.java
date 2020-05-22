package com.abc.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	private String name;
	private String pwd;
	private int accno;
	private int balance;
	private String cusid;
	private int theRaccno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public int getTheRaccno() {
		return theRaccno;
	}
	public void setTheRaccno(int theRaccno) {
		this.theRaccno = theRaccno;
	}

	Connection con=null; 
	PreparedStatement pstmt=null;
	ResultSet res=null;
 Model() throws SQLException
 {
	
	 try {
		 //losd the driver
		Class.forName("oracle.jdbc.OracleDriver");
		//get he coonection
		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public boolean Login()
 {
	
	 try {
		 //PREPARE patform

pstmt=con.prepareStatement("select * from  MLPTMBANK where CUSID=? and PWD=?");
		//set the data
		pstmt.setString(1,cusid);
		pstmt.setString(2, pwd);
		//get result
		res=pstmt.executeQuery();
		//fetch the result
		if(res.next())
		{
			accno=res.getInt("ACCNO");
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			if(res!=null)
				res.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	return false;
}
 
 public boolean checkbalance()
 {
	
	 try {
		 //prepareplateform
		pstmt=con.prepareStatement("select * from MLPTMBANK where ACCNO=?");
		//set the data
		pstmt.setLong(1,accno);
		//get the result
		res=pstmt.executeQuery();
		//fetch thedata
		if(res.next())
		{
			balance=res.getInt("BALANCE");
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return false;
	 
 }
 public boolean changepwd()
 {
	 //prepare plateform
	 try {
		pstmt=con.prepareStatement("update MLPTMBANK set PWD=? where ACCNO=?");
		pstmt.setString(1,pwd);
		pstmt.setInt(2, accno);
		int result =pstmt.executeUpdate();
		if(result==1)
		{
		return true;	
		}
	 
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			if(res!=null)
				res.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	return false;
}
 
 public boolean transfer()
 {
	
	 try {
		 
		 
		 
		 
		 //DEBIT FROM ACC
		pstmt=con.prepareStatement("update MLPTMBANK set BALANCE=BALANCE-? where ACCNO=?");
		pstmt.setInt(1, balance);
		pstmt.setInt(2, accno);
		int r1=pstmt.executeUpdate();
		if(r1==1)
		{
			
			//crdit to recacc
			pstmt=con.prepareStatement("update MLPTMBANK set BALANCE=BALANCE+? where ACCNO=? ");
			pstmt.setInt(1, balance);
			pstmt.setInt(2, theRaccno);
			@SuppressWarnings("unused")
			int r2=pstmt.executeUpdate();
			return true;
		}
		
		} catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				if(res!=null)
					res.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return false;
 }

 
 
 
}
