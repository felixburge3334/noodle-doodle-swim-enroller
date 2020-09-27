/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
  name = "AddStudent", 
  urlPatterns = "/AddNewStudent")
public class StudentAddController extends HttpServlet
{
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
       
    @Override
        public void destroy() {
       try {
           db.closeConnection();
       } catch (SQLException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            Enumeration<String> paraNames = request.getParameterNames();
            Student st = new Student();
            while(paraNames.hasMoreElements())
            {
                String parNames = paraNames.nextElement();
                System.out.println(parNames);
                switch(parNames)
                {
                    case "Id":
                        st.setId(Integer.parseInt(request.getParameter(parNames)));
                        break;
                    case "FullName":
                        st.setFullName(request.getParameter(parNames));
                        break;
                    case "Date":
                        st.setDOB(java.sql.Date.valueOf(request.getParameter(parNames)));
                        break;
                    case "Email":
                        st.setEmail(request.getParameter(parNames));
                        break;
                    case "Address":
                        st.setAddress(request.getParameter(parNames));
                        break;    
                    case "Phone":
                        st.setPhone(Integer.parseInt(request.getParameter(parNames)));
                        break;
                    case "Title":
                        st.setTitle(request.getParameter(parNames));
                        break;
                    case "Password":
                        st.setPassword(request.getParameter(parNames));
                        break;
                }
            }
            try
            {
                manager.addStudent(st);
                System.out.println("test: " + st);
            }catch(SQLException ex)
            {
                Logger.getLogger(StudentAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ArrayList<Student> queryResult = null;
           try {
               queryResult = manager.fetchStudentList();
           } catch (SQLException ex) {
               Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
           }
        request.setAttribute("StudentInfo",  queryResult);
        RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
        rd.forward(request, response);
        }
}
