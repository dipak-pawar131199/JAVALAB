	import java.io.*;
	import java.util.*;
	
	class ListMenuDemo
	{
	 	static void displayReverse(LinkedList list1)
	 	{
	 	    for(int i=list1.size()-1;i>=0;i--)
	 	    {
	 	       System.out.print(list1.get(i)+"  ");
	 	    }
	 	}      
		public static void main(String args[])throws IOException
		{
		    LinkedList list1=new LinkedList();
		    LinkedList list2=new LinkedList();
		    
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    
		    System.out.println("How many list1 element you want to insert?");
		    int n1=Integer.parseInt(br.readLine());
                     
                     for(int i=0;i<n1;i++)
                      {  
                         int ele=Integer.parseInt(br.readLine());
                         if(!list1.contains(ele))
                             list1.add(ele);		    
		     }
		    System.out.println("How many list2 element you want to insert?");
		    int n2=Integer.parseInt(br.readLine());
                     
                     for(int i=0;i<n2;i++)
                      {  
                         int ele=Integer.parseInt(br.readLine());
                         if(!list2.contains(ele))
                             list2.add(ele);		    
		     }
		     System.out.println("List1"+list1);
		     System.out.println("List2"+list2);
		     int ch=0;
		     System.out.println("Enter your choice");
		     do
		     {
		        System.out.println("1) Display List in reverse order");
		        System.out.println("2) Display Intersection of both lists");
		        System.out.println("3) Add element to first position of list1");
		        System.out.println("4) Remove Last element from list");
		        System.out.println("5)Exit");
		        ch=Integer.parseInt(br.readLine());
		        
		        switch(ch)
		        {
		        	case 1://display in reverse order
		        	       System.out.println("Reverse List1");
		        	       displayReverse(list1);
		        	       System.out.println("\nReverse List2");
		        	       displayReverse(list2);
		        	       System.out.println();
		        	       break;
		        	case 2://Display intersection
		        	
		        	       LinkedList l3=new LinkedList();
		        	       
		        	       for(int i=0;i<list1.size();i++)
		        	          l3.add(list1.get(i));
		        	       l3.retainAll(list2);
		        	       System.out.println(l3);     
		        	       break;
		        	case 3://add first
		        	       System.out.println("Enter element to add first to list1");
		        	       list1.addFirst(Integer.parseInt(br.readLine()));
		        	       System.out.println("List1"+list1); 
		        	       break;
		        	case 4://Remove last
		        	       System.out.println("before remove last element");
		        	       System.out.println("List1"+list2);
		        	       list2.removeLast();
		        	       System.out.println("After remove last element");
		        	       System.out.println("List1"+list2);
		        	         
		        	       break;
		        	case 5://exit
		        		 System.out.println("Buy");
		        	         System.exit(0);                                  
		        }
		        
		        
		     
		     }while(ch!=5);
		}
	}
