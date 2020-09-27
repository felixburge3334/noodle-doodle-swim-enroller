/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.asd.model.AccountTracker;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.DBManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.asd.model.CustomerBean;
import uts.asd.model.CustomerAccessLogBean;
import uts.asd.model.Student;

@WebServlet(
  name = "LoginServlet", 
  urlPatterns = "/loginauth")
public class LoginController  extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
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

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
       try {
           db.closeConnection();
       } catch (SQLException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object logindt = req.getSession().getAttribute("login");
        if(logindt!=null){
            if(logindt instanceof CustomerBean){
                 CustomerBean current = (CustomerBean)req.getSession().getAttribute("login");
                if(AccountTracker.isValidLogin(manager,current.getEmail(), current.getPassword())){
                    AccountTracker.logout(current);
                    req.getSession().removeAttribute("login");
                    System.out.println("valid account, session removed");
                    try{
                        CustomerAccessLogBean accesslog = (CustomerAccessLogBean)req.getSession().getAttribute("sessionLog");
                        manager.endCustomerLoginRecord(accesslog);
                        req.getSession().setAttribute("sessionLog", null);
                    }catch(Exception e){

                    }

                }
                RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                req.setAttribute("response",  "OK");
                dispatch.include(req, resp);
                dispatch.forward(req, resp);
                System.out.println("CMON"+req.getSession().getAttribute("login"));
            }else{
                Student current = (Student)logindt;
                req.getSession().setAttribute("login", null);
                RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                req.setAttribute("response",  "OK");
                dispatch.forward(req, resp);
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        String email="",pass="";
        while(paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            switch(paramName){
                case "email":
                    email = (req.getParameter(paramName));
                    break;
                case "password":
                    pass = (req.getParameter(paramName));
                    break;    
            }
        }
        System.out.println("Login");
        try {
        Object logindt = req.getSession().getAttribute("login");
        if(logindt!=null){
            if(logindt instanceof CustomerBean){
                CustomerBean current = (CustomerBean)req.getSession().getAttribute("login");
                if(AccountTracker.isLoggedIn(email)&&AccountTracker.isValidLogin(manager,current.getEmail(), current.getPassword())){

                    CustomerAccessLogBean accesslog = (CustomerAccessLogBean)req.getSession().getAttribute("sessionLog");
                    manager.endCustomerLoginRecord(accesslog);
                    req.getSession().setAttribute("sessionLog", null);
                    AccountTracker.logout(current);
                    req.getSession().setAttribute("login", null);

                    RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                    req.setAttribute("response",  "OK");
                    dispatch.forward(req, resp);
                    return;
                }
            }else{
                Student current = (Student)logindt;
                req.getSession().setAttribute("login", null);
                RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                req.setAttribute("response",  "OK");
                dispatch.forward(req, resp);

            }
        }
        CustomerBean cbdb = null;
        Student st = null;
            cbdb = manager.findCustomer(email, pass);
            st = manager.findStudent(email, pass);
            System.out.println("Student PLESASE: "+st);
            if(st!=null){
                req.getSession().setAttribute("login",st );
                RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                req.setAttribute("response",  "OK");
                dispatch.forward(req, resp);
                return;
            }
            if(!AccountTracker.isValidLogin(manager,email, pass) && cbdb==null){
                RequestDispatcher dispatch = req.getRequestDispatcher("login.jsp");
                req.setAttribute("response",  "Invalid email or password");
                dispatch.forward(req, resp);
            }else{
                if(cbdb!=null){
                    System.out.println(cbdb.toString());
                    AccountTracker.login(cbdb);
                }else{
                    AccountTracker.login((CustomerBean)logindt);
                }
                CustomerBean cb2 = AccountTracker.getCustomerByEmail(manager,email);
                req.getSession().setAttribute("login",cb2 );
                req.getSession().setAttribute("sessionLog",manager.addCustomerLoginRecord(cb2) );
                RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
                req.setAttribute("response",  "OK");
                dispatch.forward(req, resp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
