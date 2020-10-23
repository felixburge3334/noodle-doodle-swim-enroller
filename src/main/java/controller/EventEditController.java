package controller;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
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
import uts.asd.model.Event;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.DBManager;

/**
 *
 * @author Fuxin Bi
 */

@WebServlet(
  name = "UpdateEvent", 
  urlPatterns = "/EventEdit")
public class EventEditController extends HttpServlet
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
        Event evf = null;
        int Id = Integer.parseInt(request.getParameter("Id"));
      
        try
        {
            evf = manager.getEvent(Id);
        } catch (SQLException ex)
        {
            Logger.getLogger(EventEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Id:" + Id);
        request.setAttribute("EventInfo", evf);
        request.getRequestDispatcher("EventUpdate.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> paramNames = request.getParameterNames();
        Event evf = new Event();
        while(paramNames.hasMoreElements()){
            String paraNames = paramNames.nextElement();
            System.out.println(paraNames);
            switch(paraNames){
                    case "Id":
                        evf.setId(Integer.parseInt(request.getParameter(paraNames)));
                        break;
                    case "Name":
                        evf.setName(request.getParameter(paraNames));
                        break;
                    case "Date":
                        evf.setDate(java.sql.Date.valueOf(request.getParameter(paraNames)));
                        break;
                    case "Description":
                        evf.setDescription(request.getParameter(paraNames));
                        break;
                    case "Visibility":
                        evf.setVisibility(parseBoolean(request.getParameter(paraNames)));
                        break;    
            }
        }
        try {
                manager.updateEvent(evf);
                System.out.println("test: " +evf);
            } catch (SQLException ex) {
                Logger.getLogger(EventEditController.class.getName()).log(Level.SEVERE, null, ex);
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
