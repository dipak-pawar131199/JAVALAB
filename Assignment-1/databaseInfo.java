	import java.io.*;
	import java.sql.*;
	class databaseInfo 
	{
	   public static void main(String args[])throws Exception
	   {
	       Connection con=null;
	       ResultSet rs=null;
	       DatabaseMetaData dbmd=null;
	      try{
	                  Class.forName("com.mysql.cj.jdbc.Driver") ;
	                  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","redhat");
	                  dbmd=con.getMetaData();
	                  System.out.println("--------------------\n Database Information\n--------------------");
	                  System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
	                  System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
	                  System.out.println("Databse User Name: "+dbmd.getUserName());
	                  System.out.println("--------------------\n\n");
	                  System.out.println("--------------------\n Database Table\n--------------------");
                          rs=dbmd.getTables(null,null,null,new String[] {"TABLE"});
	                  while(rs.next())
	                  {
	                     System.out.println(rs.getString("TABLE_NAME"));
	                  }
	                  
	                 System.out.println("--------------------\n\n"); 
	                  
	      }
	      catch(Exception e)
	      {
	        System.out.println(e);
	      }
	   }
	}
