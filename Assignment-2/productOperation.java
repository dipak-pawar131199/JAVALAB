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
		   	            int count=0;
		   	            Statement st=con.createStatement();
		   	            ResultSet rs=st.executeQuery("select * from product");
		   	            while(rs.next())
		   	            {
		   	              count=rs.getInt("ProdId");
		   	            }   
		   	            t1.setEditable(false);
		   	            PreparedStatement ps=con.prepareStatement("Insert into product values(?,?,?,?)");
		   	            ps.setInt(1,count+1);
		   	            ps.setString(2,t2.getText());
		   	            ps.setInt(3,Integer.parseInt(t3.getText()));
		   	            ps.setInt(4,Integer.parseInt(t4.getText()));
		   	            int r=ps.executeUpdate();
		   	            if(r==1)
		   	             {
		   	                JOptionPane.showMessageDialog(null,"record added successfully");
		   	             }
		   	            else
		   	            {
		   	              JOptionPane.showMessageDialog(null,"Someting is wrong!!!!!!");
		   	              t1.setEditable(true);
		   	            }    
		   	            
		   	     
		   	     }
		   	     else if(action.equals("Update"))
		   	     {
		   	            
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
