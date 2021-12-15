	import java.sql.*;
	public class databseTableColumnInfo
	{
	   public static void main(String args[])
	   {
	        Connection con=null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp","root","redhat");
	          Statement stmt= con.createStatement();
	          ResultSet rs=stmt.executeQuery("SELECT * FROM employee");
	          ResultSetMetaData rsmd=rs.getMetaData();
	          //find number of coloumns
	          int ncol=rsmd.getColumnCount();
	          System.out.println("-------------------------------------------------------------");
	          System.out.println("|Column Count|Column Name\t|Column Type\t|Coloumn Size|");     
	          System.out.println("-------------------------------------------------------------");
	          for(int i=1;i<=ncol;i++)
	          {
	             System.out.print("\t|"+i);
	             System.out.print("\t|"+rsmd.getColumnName(i));
	             System.out.print("\t|"+rsmd.getColumnTypeName(i));
	             System.out.println("\t|"+rsmd.getColumnDisplaySize(i)+"|");	             System.out.print("-------------------------------------------------------------");
	          }      System.out.print("-------------------------------------------------------------"); 
	          
	           con.close();
	      }
	      catch(Exception e)
	      {
	        System.out.println(e);
	      }
	      finally{
	           
	      }
	   }
	}
