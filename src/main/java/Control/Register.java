
package Control;
import java.io.*;   
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
/**
 *
 * @author felix
 */

public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String e=request.getParameter("userEmail");   
          
     
out.close();  
}  
  
}  