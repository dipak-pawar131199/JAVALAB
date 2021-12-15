	import java.sql.*;
	import java.io.*;
	
	class OpeartionOnEmpTable
	{
	   public static void main(String args[]) throws IOException
	   {
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	        Connection con=null;
	        PreparedStatement ps=null;
	       int op;
	      try{
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp","root","redhat");
	           do
	           {
                           System.out.println(" For Insert Enter 1 ");
			   System.out.println(" For delete Enter 2 ");
			   System.out.println(" For Exit Enter 3 ");
			   System.out.println("Enter your Choice:");
			   op=Integer.parseInt(br.readLine());
			   
			   
			   
			   switch(op)
			   {
			      case 1://insert
					     try{
					     System.out.println("Enter Employee Name");
					     String empname=br.readLine();
					     System.out.println("Enter Salary Of Employee");
					     int sal=Integer.parseInt(br.readLine());
					     
					     Statement st=con.createStatement();
					     ResultSet rs=st.executeQuery("select * from employee");
					     int count=0;
					     
					     while(rs.next())
					     {
					        count=rs.getInt("empid");
					     }
					     //System.out.println(count);
					     ps=con.prepareStatement("Insert into employee values(?,?,?)");
					  
					     
					     ps.setInt(1,count+1);
					     ps.setString(2,empname);
					     ps.setInt(3,sal); 
					     ps.executeUpdate(); 
					     System.out.println("Record Inserted!!!!!!!!!.......");   
					    }
					    catch(Exception e)
					    {
					      System.out.println(e);
					    }
					     
					     break; 
			      case 2:
			              System.out.println("Enter Id Of Emp To Delete");
			              int id=Integer.parseInt(br.readLine());
			              ps=con.prepareStatement("delete from employee where empid="+id);
			              int result= ps.executeUpdate();
			              if(result==1)
			                 System.out.println("Record delete sucessfully........");
			              else
			                 System.out.println("Empolyee Does't exit");
			              break;
			               	     
			      case 3:
			               
			                break ;      
			   }
                   }while(op!=3);
	        }
	       catch(ClassNotFoundException c)
	       {
	          System.out.println(c); 
	       } 
	       catch(SQLException se)
	       {
	          System.out.println(se);
	       }
	   }  
	}
