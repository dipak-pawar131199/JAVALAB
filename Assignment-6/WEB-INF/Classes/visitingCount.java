	import java.io.*;
	import javax.servlet.*;
	import javax.servlet.http.*;
	
	public class visitingCount extends HttpServlet
	{
	    static int i=0;
	    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	    {
	       res.setContentType("text/html");
	       
	       PrintWriter pw=res.getWriter();
	       //convert i to String because Cookies (String name,String value)
	       String count=String.valueOf(i);
	       //create cookes object
	       Cookie c=new Cookie("Visit",count);
	       res.addCookie(c);
	       
	       //accept cookie value
	       int cval=Integer.parseInt(c.getValue());
	       pw.println("<html></body>");
	       if(cval==1)
	       {
	         pw.println("<h1>Welcome "+req.getRemoteAddr()+"</h1>");
	       }
	       else
	       {
	         pw.println("<h1>Welcome Back "+req.getRemoteAddr()+"</h1>");
	       }
	       pw.println("</body></html>");
               i++;
	    }
	}
