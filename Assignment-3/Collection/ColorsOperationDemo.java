	import java.util.*;
	import java.io.*;
	
	
	class ColorsOperationDemo
	{
		public static void main(String args[])throws IOException
		{
		 	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 	
		 	TreeSet t=new TreeSet();
		 	System.out.println("How many Colors?");
		 	int noc=Integer.parseInt(br.readLine());
		 	System.out.println("---------------------");
		 	System.out.println("Enter color names");
		 	System.out.println("---------------------");
		 	for(int i=0;i<noc;i++)
		 	{
		 	   t.add(br.readLine());
		 	}
		 	
		 	System.out.println("---------------------\n");
		 	System.out.println("---------------------");
		 	System.out.println("Sorted Colors list:");
		 	System.out.println("---------------------");
		 	Iterator itr=t.iterator();
		 	while(itr.hasNext())
		 	{
		 	 	System.out.println("\t"+itr.next()); 
		 	}
		 	System.out.println("---------------------");
		}
	}
