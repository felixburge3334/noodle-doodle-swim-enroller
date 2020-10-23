/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import static java.lang.Boolean.parseBoolean;
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
import uts.asd.model.Event;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.DBManager;

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "AddEvent", 
  urlPatterns = "/AddNewEvent")
public class EventAddController extends HttpServlet
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
            Event ev = new Event();
            while(paraNames.hasMoreElements())
            {
                String parNames = paraNames.nextElement();
                System.out.println(parNames);
                switch(parNames)
                {
                    case "Id":
                        ev.setId(Integer.parseInt(request.getParameter(parNames)));
                        break;
                    case "Name":
                        ev.setName(request.getParameter(parNames));
                        break;
                    case "Date":
                        ev.setDate(java.sql.Date.valueOf(request.getParameter(parNames)));
                        break;
                    case "Description":
                        ev.setDescription(request.getParameter(parNames));
                        break;
                    case "Visibility":
                        ev.setVisibility(parseBoolean(request.getParameter(parNames)));
                        break;    
                }
            }
            try
            {
                manager.addEvent(ev);
                System.out.println("test: " + ev);
            }catch(SQLException ex)
            {
                Logger.getLogger(EventAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ArrayList<Event> queryResult = null;
           try {
               queryResult = manager.fetchEventList();
           } catch (SQLException ex) {
               Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
           }
        request.setAttribute("EventInfo",  queryResult);
        RequestDispatcher rd = request.getRequestDispatcher("EventView.jsp");
        rd.forward(request, response);
        }
}
