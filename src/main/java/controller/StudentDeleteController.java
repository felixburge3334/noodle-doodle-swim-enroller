
package controller;
import uts.asd.model.dao.DBManager;
import uts.asd.model.dao.DBConnector;
import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
import java.util.ArrayList;
   import java.util.Scanner;
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

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "StudentDelete", 
  urlPatterns = "/deleteStudent")

public class StudentDeleteController extends HttpServlet{
      private DBConnector db; // db 
       private DBManager manager; // 
       private Connection conn;
       
       @Override
    public void init() {
        try {
            db = new DBConnector();
            conn = db.openConnection();
            manager = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
       
    @Override
    public void destroy() {
       try {
           db.closeConnection();
       } catch (SQLException ex) {
           Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Student stf = null;
        int Id = Integer.parseInt(request.getParameter("Id"));
               try {
                   stf = manager.getStudent(Id);
               } catch (SQLException ex) {
                   Logger.getLogger(StudentEditController.class.getName()).log(Level.SEVERE, null, ex);
               }
        String name = stf.getFullName();
        System.out.println("id:" +Id + "name: " +name);
           try {
               manager.deleteStudent(stf);
           } catch (SQLException ex) {
               Logger.getLogger(StudentDeleteController.class.getName()).log(Level.SEVERE, null, ex);
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
