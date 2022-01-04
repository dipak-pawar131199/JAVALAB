	//importing  packages
	import java.sql.*;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
	class productOperation implements ActionListener
	{
		  JFrame f;
		  JTextField t1,t2,t3,t4;
		  JPanel p,p1;
		  JLabel pid,pname,pprice,pquantity;
		  JButton add,update,search,exit;
	   	  productOperation()
	   	  {
	   	     f=new JFrame("Product Information");
	   	     pid=new JLabel("Product ID");
	   	     p1=new JPanel();
	   	     p1.setLayout(new GridLayout(4,2));
	   	     p1.add(pid);
	   	     t1=new JTextField();
	   	     p1.add(t1);
	   	     pname=new JLabel("Name");
	   	     p1.add(pname);
	   	     t2=new JTextField();
	   	     p1.add(t2);
	   	     pprice=new JLabel("Price");
	   	     p1.add(pprice);
	   	     t3=new JTextField();
	   	     p1.add(t3);
	   	     pquantity=new JLabel("Quantity");
	   	     p1.add(pquantity);
	   	     t4=new JTextField();
	   	     p1.add(t4);
	   	     f.add(p1);
	   	     p=new JPanel();
	   	     p.setLayout(new GridLayout(1,4));
	   	     f.add(p);
	   	     add=new JButton("Add");
	   	     p.add(add);
	   	     add.addActionListener(this);
	   	     update=new JButton("Update");
	   	     p.add(update);
	   	     update.addActionListener(this);
	   	     search=new JButton("Search");
	   	     p.add(search);
	   	     search.addActionListener(this);
	   	     exit=new JButton("Exit");
	   	     p.add(exit);
	   	     exit.addActionListener(this);
	   	     
	   	     f.setLayout(new GridLayout(2,1));
	   	     f.setSize(600,500);
	   	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	     f.setVisible(true);
	   	  }
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	     Connection con=null;
	   	     try{
		   	  
		   	     Class.forName("com.mysql.cj.jdbc.Driver");
		   	     con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Emp","root","redhat"); 
		   	     String action=ae.getActionCommand();
		   	     if(action.equals("Add"))
		   	     {
		   	            int count=0,flag=1;
		   	            Statement st=con.createStatement();
		   	            ResultSet rs=st.executeQuery("select * from product");
		   	            while(rs.next())
		   	            {
		   	              count=rs.getInt("ProdId");
		   	            }   
		   	            t1.setEditable(false);
		   	            if(t2.getText().equals("") && t3.getText().equals("") && t4.getText().equals(""))
		   	            {
		   	                 JOptionPane.showMessageDialog(null,"Empty Field Not Allowed");
		   	                 flag=0;
		   	            }
		   	            if(flag==1)
		   	            {
		   	                PreparedStatement ps=con.prepareStatement("Insert into product values(?,?,?,?)");
		   	                ps.setInt(1,count+1);
		   	            
		   	                ps.setString(2,t2.getText());
		   	                ps.setInt(3,Integer.parseInt(t3.getText()));
		   	                ps.setInt(4,Integer.parseInt(t4.getText()));
		   	                int r=ps.executeUpdate();
		   	                if(r==1)
		   	                {
		   	                  JOptionPane.showMessageDialog(null,"record added successfully");
							t1.setEditable(true);   
		   	                                 t1.setText("");
		   	                                 t2.setText("");
		   	                                 t3.setText("");
		   	                                 t4.setText("");
		   	                }
		   	               else
		   	               {
		   	                  flag=0; 
		   	                  JOptionPane.showMessageDialog(null,"Someting is wrong!!!!!!");
		   	                                 t1.setEditable(true);   
		   	                                 t1.setText("");
		   	                                 t2.setText("");
		   	                                 t3.setText("");
		   	                                 t4.setText(""); 
		   	                }    
		   	            
		   	           }
		   	     }
		   	     else if(action.equals("Update"))
		   	     {
		   	           try{
		   	                
		   	                 int flag=1;
					  
					  if(t2.getText().equals("")&&t2.getText().equals("") && t3.getText().equals("") && t4.getText().equals(""))
		   	                  {
		   	                       JOptionPane.showMessageDialog(null,"Empty Field Not Allowed");
		   	                       flag=0;
		   	                  }
					  if(flag==1)
					  {
				             String sql="Update product set Name=?, Price=?, Quantity=? where ProdId=?";
		   	                     PreparedStatement ps=con.prepareStatement(sql);
							  
		   	                     ps.setString(1,t2.getText());
					     int price=Integer.parseInt(t3.getText());	
							//    System.out.println(price);  
		   	                      ps.setInt(2,price)  ;
					      ps.setInt(3,Integer.parseInt(t4.getText()));  
                                               ps.setInt(4,Integer.parseInt(t1.getText()))  ; 
					  
						  int r=ps.executeUpdate();
				              
							if(r==1)
		   	                      		{
		   	                           		JOptionPane.showMessageDialog(null,"record Updated");
		   	              			         t1.setText("");
		   	                                          t2.setText("");
		   	                                          t3.setText("");
		   	                                          t4.setText(""); 
		   	              			}
		   	            	        	else
		   	            	        	{
         	   	                			JOptionPane.showMessageDialog(null,"Record does not found!!!!!!");                                                    
		   	                			t1.setText("");
			   	                                 t2.setText("");
			   	                                 t3.setText("");
			   	                                 t4.setText("");  
		   	                         	}  
		   	                  
		   	                    }   
					}
						catch(Exception e){System.out.println(e);}		      
		   	     }
				else if(action.equals("Search"))
				{
				     
                                        String pname=JOptionPane.showInputDialog("Enter Product name to search?");
 					
						 Statement st=con.createStatement();
				         ResultSet rs=st.executeQuery("select * from product where Name='"+pname+"'");
						 if(rs.next())
						{
							JOptionPane.showMessageDialog(null,"Product Found");
							int pid=rs.getInt(1);
							 t1.setText(String.valueOf(pid));
					                  t2.setText(rs.getString(2));
					                  t3.setText(String.valueOf(rs.getInt(3)));
					                  t4.setText(String.valueOf(rs.getInt(4)));
					         
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Product Not Found");
							t1.setText("");
			   	                         t2.setText("");
			   	                         t3.setText("");
			   	                         t4.setText("");  
						}
					
					
				}
		   	     else if(action.equals("Exit"))
		   	     {
		   	       System.exit(0);
		   	     }
		   	 } 
		   	 catch(Exception e)
		   	 {
		   	    System.out.println(e);
		   	 }   
	   	  }
		  public static void main(String args[])
		  {
		    new productOperation();
		  }
	}
