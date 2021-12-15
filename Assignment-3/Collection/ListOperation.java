	import java.util.*;
	
	class  ListOperation
	{
	   	public static void main(String args[])
	   	{
	   	    //ArrayList add() and remove() trayal
	   	    ArrayList al=new ArrayList();
	   	    //add elements into ArrayList();
	   	    al.add("public");
	   	    al.add("private");
	   	    al.add("protected");
	   	    
	   	    Iterator itr=al.iterator();
	   	    System.out.println("ArrayList Elements Before Removing" );
	   	    while(itr.hasNext())
	   	    {
	   	     	System.out.println(itr.next());
	   	    } 
	   	    al.remove(1);
	   	    al.remove("protected");
	   	    System.out.println("ArrayList Elements After  Removing"+al );
                     
                     LinkedList l=new LinkedList();
	   	    //add elements into ArrayList();
	   	    l.add(1);
	   	    l.add(2);
	   	    l.add(3);
	   	    l.addFirst(10);
	   	    l.addLast(100);
	   	   
	   	    System.out.println(l);
	   	    l.remove(1);
	   	    l.removeFirst();
	   	    l.removeLast();
	   	    
	   	    System.out.println("LinkedList Elements After  Removing"+l );
	   	    
	   	       
	   	}
	}
