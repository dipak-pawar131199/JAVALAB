	import java.sql.*;
	import java.io.*;
	
	class InvalidTelephoneNumberException extends Exception
	{
	     public String toString()
	     {
	        return "Invalid Telephone Number is given";
	     }
	}
	
	class TelephoneOperationDemo
	{
	    public static void main(String args[])throws IOException
	    {
	       
	       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	       Connection con=null;
	       
	       try
	        {
	          	Class.forName("com.mysql.cj.jdbc.Driver");
	          	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproject","root","redhat");
	       		int ch=0;
	       		do
	       		{
	       		 	System.out.println("1) Insert Records Into Telephone");
	       		        System.out.println("2) Delete Records From Telephone");
	       		        System.out.println("3) Search Records Into Telephone");
	       		        System.out.println("4) Display All Records From Telephone");
	       		        System.out.println("5) Exit");
	       		        ch=Integer.parseInt(br.readLine());
	       		        
	       		        switch(ch)
	       		        {
	       		        	case 1: //Insert
	       		        	
                                                
                                                 try
                                                 { 
	       		        	        	
	       		        	        	    
	       		        	        	   	        	        	    
	       		        	        
	       		        	        	PreparedStatement ps=con.prepareStatement("Insert into telephone values(?,?,?)");
	       		        	        	System.out.println("Enter your 10 digit telephone Number:");
	       		        	        	String  tno=br.readLine();
	       		        	        	String tno1=tno;
	       		        	        	long tno2=Long.parseLong(tno1);
	       		        	        	if(tno2<0)
	       		        	        	    throw new InvalidTelephoneNumberException();
	       		        	        	System.out.println("Enter your Name:");
	       		        	        	String name=br.readLine();
	       		        	        	System.out.println("Enter your Address:");
		       		        	        String add=br.readLine();
		       		        	        ps.setString(1,tno);
		       		        	        ps.setString(2,name);
		       		        	        ps.setString(3,add);
		       		        	        ps.executeUpdate();
		       		        	        System.out.println("Record Inserted!!!!!!");
		       		        	        
		       		        	        
		       		                }	
		       		                catch(Exception e)
		       		                {
		       		                   System.out.println(e);
		       		                }
		       		                break;
		       		     case 2://delete
		       		               try
		       		               {
		       		                   System.out.println("Enter 10 digit Telephone Number to Delete Record");
		       		                   String tno=br.readLine();
		       		                   String tno1=tno;
	       		        	           long tno2=Long.parseLong(tno1);
	       		        	           if(tno2<0)
	       		        	        	    throw new InvalidTelephoneNumberException();
		       		                   String sql="delete from telephone where TelNo=?";
		       		                   PreparedStatement ps=con.prepareStatement(sql);
		       		                   ps.setString(1,tno);
		       		                   ps.executeUpdate();
		       		                   System.out.println("Record deleted!!!!!!");
		       		                   
		       		               }
		       		               catch(Exception e)
		       		               {
		       		                 System.out.println(e);
		       		               }
		       		               break; 
		       		    case 3: //Search
		       		                   System.out.println("Enter 10 digit Telephone Number to Search");
		       		                   String tno=br.readLine();  
		       		                                  
		       		                   try
		       		                   {
		       		                        String tno1=tno;
	       		        	                long tno2=Long.parseLong(tno1);
	       		        	        	if(tno2<0)
	       		        	        	    throw new InvalidTelephoneNumberException();
		       		                        Statement st=con.createStatement();
		       		                        ResultSet rs=st.executeQuery("select * from telephone where TelNo="+tno);	
		       		                        if(rs.next())
		       		                        {
		       		                           System.out.println("Record Found!!!!!!!!");
		       		                           
		       		                        }
		       		                        else
		       		                        {
		       		                           System.out.println("Record not found!!!!!!!"); 
		       		                        }
		       		                   }
		       		                   catch(Exception e)
		       		                   {
		       		                        System.out.println(e);
		       		                   }
		       		                   break;
		       		    case 4://display
		       		             try
		       		             {
		       		                        Statement st=con.createStatement();
		       		                        ResultSet rs=st.executeQuery("select * from telephone");
		       		                        while(rs.next())
		       		                        {
		       		                           System.out.println("Telephone No:"+rs.getString("TelNo")+" Name:"+rs.getString("Name")+" Address:"+rs.getString("Address"));
		       		                        }	
		       		             }
		       		             catch(Exception e)
		       		             {
		       		                 System.out.println(e); 
		       		             }		       		                   
		       		             break;      
		       	            case 5:System.out.println("Buy");
		       	                    System.exit(0);
		       	            
	       		        }
	       		 	  
	       		   
	       		}while(ch!=5);
	         }
	       catch(Exception e)
	       {
	          System.out.println(e);
	       }
	       
	    }
	}
