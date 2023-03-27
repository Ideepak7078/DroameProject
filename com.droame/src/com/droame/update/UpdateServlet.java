package com.droame.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		
	//Getting Data from the customer details form
//		String s=(String) request.getAttribute("customerid");
		
		PrintWriter obj=response.getWriter();
		String customername=request.getParameter("customername");
		String customerid=request.getParameter("customerid");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");

		String adress=request.getParameter("adress");
		String Nationality=request.getParameter("Nationality");
		String Bookingid=request.getParameter("Bookingid");

		String location=request.getParameter("location");
		String locationid=request.getParameter("locationid");
		String droneshotid=request.getParameter("droneshotid");
		
		
		
//		sending data to database

		
		obj.println(customername);
		obj.println(customerid);
		obj.println(phone);
		obj.println(email);
		obj.println(location);
		obj.println(locationid);
		obj.println(droneshotid);
		obj.println(email);
		obj.println(gender);
//		obj.println(age);
		
		 try{

		    	Class.forName("com.mysql.cj.jdbc.Driver");  
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","");  

		    	PreparedStatement pst=con.prepareStatement("update customer_details set customername=?, customerid=?,phone=?,email=?,gender=?,adress=?,Nationality=?,Bookingid=?,location=?,locationid=?,droneshotid=? where customerid=?");

	pst.setString(1,customername);  
	pst.setString(2,customerid);  
	pst.setString(3,phone);
	pst.setString(4,email);
	pst.setString(5,gender);

	pst.setString(6,adress);
	pst.setString(7,Nationality);

	pst.setString(8,Bookingid);


	pst.setString(9,location);
	pst.setString(10,locationid);
	pst.setString(11,droneshotid);
	pst.setString(12,customerid);
//	obj.print(s);


	int cout=pst.executeUpdate();
	if(cout==0) {
	obj.print("updated");
	}
	else {
		obj.print("not updated");
	}
	   
		    	}
		    catch(Exception e) {
		    	obj.print(e);
		    }
			obj.close();

	}


}
