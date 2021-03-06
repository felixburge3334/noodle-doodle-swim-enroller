package controller;

import uts.asd.model.dao.DBManager;
import uts.asd.model.dao.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
   import java.sql.Connection;
import java.sql.DriverManager;
   import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
   import java.util.logging.Level;
   import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
   import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import uts.asd.model.Event;

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "EventView", 
  urlPatterns = "/EventInfo")
 public class EventController extends HttpServlet 
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Event> queryResult = null;
        try
        {
            queryResult = manager.fetchEventList();
        } catch (SQLException ex)
        {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("inside doGet" + queryResult);
        RequestDispatcher rd = request.getRequestDispatcher("EventView.jsp");
        request.setAttribute("EventInfo", queryResult);
        rd.forward(request, response);
    }

}

