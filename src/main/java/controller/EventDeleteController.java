
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
   import uts.asd.model.Event;

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "EventDelete", 
  urlPatterns = "/deleteEvent")

public class EventDeleteController extends HttpServlet{
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
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
       
    @Override
    public void destroy() {
       try {
           db.closeConnection();
       } catch (SQLException ex) {
           Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Event evf = null;
        int Id = Integer.parseInt(request.getParameter("Id"));
               try {
                   evf = manager.getEvent(Id);
               } catch (SQLException ex) {
                   Logger.getLogger(EventEditController.class.getName()).log(Level.SEVERE, null, ex);
               }
        String name = evf.getName();
        System.out.println("id:" +Id + "name: " +name);
           try {
               manager.deleteEvent(evf);
           } catch (SQLException ex) {
               Logger.getLogger(EventDeleteController.class.getName()).log(Level.SEVERE, null, ex);
           }
        ArrayList<Event> queryresult = null;
           try {
               queryresult = manager.fetchEventList();
           } catch (SQLException ex) {
               Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
           }
        request.setAttribute("EventInfo",  queryresult);
        RequestDispatcher rd = request.getRequestDispatcher("EventView.jsp");
        rd.forward(request, response);
    }
}
