package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.Student;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.DBManager;

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "UpdateStudent", 
  urlPatterns = "/StudentEdit")
public class StudentEditController extends HttpServlet
{
       private DBConnector db; // db 
       private DBManager manager; // 
       private Connection conn;
    
       @Override
        public void init() 
    {
        try {
            db = new DBConnector();
            conn = db.openConnection();
            manager = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
           @Override
    public void destroy()
    {
        try 
        { 
            db.closeConnection();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Student stf = null;
        int Id = Integer.parseInt(request.getParameter("Id"));
      
        try
        {
            stf = manager.getStudent(Id);
        } catch (SQLException ex)
        {
            Logger.getLogger(StudentEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Id:" + Id);
        request.setAttribute("StudentInfo", stf);
        request.getRequestDispatcher("StudentUpdate.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> paramNames = request.getParameterNames();
        Student stf = new Student();
        while(paramNames.hasMoreElements()){
            String paraNames = paramNames.nextElement();
            System.out.println(paraNames);
            switch(paraNames){
                    case "Id":
                        stf.setId(Integer.parseInt(request.getParameter(paraNames)));
                        break;
                    case "Name":
                        stf.setFullName(request.getParameter(paraNames));
                        break;
                    case "Date":
                        stf.setDOB(java.sql.Date.valueOf(request.getParameter(paraNames)));
                        break;
                    case "Email":
                        stf.setEmail(request.getParameter(paraNames));
                        break;
                    case "Address":
                        stf.setAddress(request.getParameter(paraNames));
                        break;    
                    case "Phone":
                        stf.setPhone(Integer.parseInt(request.getParameter(paraNames)));
                        break;
                    case "Title":
                        stf.setTitle(request.getParameter(paraNames));
                        break;
                    case "Password":
                        stf.setPassword(request.getParameter(paraNames));
                        break;
            }
        }
        try {
                manager.updateStudent(stf);
                System.out.println("test: " +stf);
            } catch (SQLException ex) {
                Logger.getLogger(StudentEditController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        ArrayList<Student> queryresult = null;
           try {
               queryresult = manager.fetchStudentList();
           } catch (SQLException ex) {
               Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
           }
        request.setAttribute("StudentInfo",  queryresult);
        RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
        rd.forward(request, response);
    }
}
