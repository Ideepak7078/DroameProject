package com.droame.customer_delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
				PrintWriter pw = response.getWriter();
				String id= request.getParameter("customerid");


		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","");
//			Statement obj=con.createStatement();
	        PreparedStatement ps = con.prepareStatement("delete from customer_details where customerid=?");
	        ps.setString(1, id);

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            pw.println("User successfully removed...");
	        }
  
		}catch(Exception e){ pw.println(e);}  }

	}


