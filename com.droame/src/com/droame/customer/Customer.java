package com.droame.customer;

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
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Customer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter obj=response.getWriter();
			//Getting Data from the customer details form

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
		
		
		
		
		 try{
			 //code to connect to the database

		    	Class.forName("com.mysql.cj.jdbc.Driver");  
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","");  
//				 we use prepared statement to execute the delete query which automatically inject the value at place of question mark

		    	PreparedStatement pst=con.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?)");
//setting up the values at desired place
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
//	sending data to database

	int cout=pst.executeUpdate();
	if(cout==0) {
	obj.print("not stored");
	}
	else {
		obj.print("Stored"); // checking value stored or not
	}
	   
		    	}
		    catch(Exception e) {
		    	obj.print(e);
		    }
			obj.close();

	}

}
