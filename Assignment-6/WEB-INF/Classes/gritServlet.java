	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.util.*;
	import java.io.*;
        public class gritServlet extends HttpServlet
        {	
	   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	   {
	      res.setContentType("text/html");
	      
	      PrintWriter pw= res.getWriter();
	      String name=req.getParameter("Uname");
	      pw.println("<html><body>") ;
	      pw.println("<h1>Welecome  "+name+"   !+!+!+!+!</h1>");
	      Date d= new Date();
	      pw.println("Todays date: "+d.toString());
	      pw.println("<body></html>");     
	   }
	}
