<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ page import="java.io.*, java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer_detais</title>
</head>
<body>

<%
// getting customer id from edit.jsp


String customerid=request.getParameter("customerid");


try {
	//connection to database
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","");
	
	// select query to fetch the customer details as per the customerid using prepared statement
    PreparedStatement ps =  con.prepareStatement ("select * from customer_details where customerid=?");
      ps.setString (1, customerid);

      out.print ("<table width=50% border=1>");
      out.print ("<caption>Employee Details:</caption>");

      ResultSet rs = ps.executeQuery ();

      /* Printing column names */
      out.print ("</br></br>");
      ResultSetMetaData rsmd = rs.getMetaData ();
      int total = rsmd.getColumnCount ();

      out.print ("<tr>");
      // code to format the result in the form of html table
      for (int i = 1; i <= total; i++)
   {
       out.print ("<th>" + rsmd.getColumnName (i) + "</th>");
   }
      out.print ("</tr>");

      /* Printing result */
      while (rs.next ())
   {
       out.print ("<tr><td>" + rs.getString (1) + "</td><td>" +  rs.getString (2) + " </td><td>" + rs.getString (3) + "</td><td>" +  rs.getString (4) + "</td><td>" +  rs.getString (5) + " </td><td>" + rs.getString (6) + "</td><td>" +  rs.getString (7) + "</td><td>" +  rs.getString (8) + " </td><td>" + rs.getString (9) +  " </td><td>" + rs.getString (10) + " </td><td>" + rs.getString (11) + "</td></tr>");
   }
      out.print ("</table>");
      out.print(rs.getString(2));
      
      if(rs.getString(2)==""){
    	  out.print("There is no customer with this customerid");
    		
      }

  }
  catch (Exception e2)
  {
      e2.printStackTrace ();
  }

  
// code if user want to update the information of the customer

%>
<form action="update.jsp" method="post">


<p> Enter Customer_id    from above table    to update   Customer Information</p>

<input type="text" name = "customerid" placeholder= "Enter customerid" Required>

<h3>Note!!  customer id should be same</h3>

<button type="submit"> update Customer details</button>

</form>

</body>
</html>