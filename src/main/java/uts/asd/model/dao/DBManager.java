/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

/**
 *
 * @author Fuxin Bi
 */
import uts.asd.model.Student;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import javax.swing.text.DateFormatter;
import uts.asd.model.CustomerAccessLogBean;
import uts.asd.model.CustomerBean;
import uts.asd.model.Supplier;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }


    
    //Student INFO
        //find student from db
    
    public Student findStudent(String email, String password) throws SQLException {   
        String query = "SELECT * FROM ASDUSER.STUDENT WHERE Email='"+email+"'"+ (password.length()>0? " AND Password = '"+password+"'":"");
        ResultSet rs = st.executeQuery(query);
        Student student = null;
        while(rs.next()){
            int Id = rs.getInt(1);
            System.out.println(Id);
            String Name = rs.getString(2);
            Date DOB = rs.getDate(3);
            String Email = rs.getString(4);
            String Address = rs.getString(5);
            int Phone = rs.getInt(6);
            String Title = rs.getString(7);
            String Password = rs.getString(8);
            student = new Student (Id, Name, DOB, Email, Address, Phone, Title, Password); 
            student.setPassword(rs.getString(8));
            return student;   
        }       
       return null;   
    } 
     public ArrayList<Student> findStudent(String name) throws SQLException 
     {   
        String query = "SELECT * FROM ASDUSER.STUDENT WHERE FULLNAME='"+name+"'";
        ResultSet rs = st.executeQuery(query);
        ArrayList<Student> result = new ArrayList();
        while(rs.next())
        {
            int Id = rs.getInt(1);
            System.out.println(Id);
            String Name = rs.getString(2);
            Date DOB = rs.getDate(3);
            String Email = rs.getString(4);
            String Address = rs.getString(5);
            int Phone = rs.getInt(6);
            String Title = rs.getString(7);
            String Password = rs.getString(8);
            if(Name.equals(name))
            {
                result.add(new Student(Id, Name, DOB, Email, Address, Phone, Title, Password));
            }
        }
        return result;
     }
     
     public Student getStudent(int Student_id) throws SQLException {   
        Student student = null;
        //(Id, Name, DOB, Email, Address, Phone, Title, Password) 
            String query = "SELECT * FROM ASDUSER.STUDENT WHERE Student_ID="+Student_id+"";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int Id = rs.getInt(1);
                System.out.println(Id);
                String Name = rs.getString(2);
                Date DOB = rs.getDate(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                int Phone = rs.getInt(6);
                String Title = rs.getString(7);
                String Password = rs.getString(8);
                System.out.println("Student Name: " +Name);
                student = new Student (Id, Name, DOB, Email, Address, Phone, Title, Password); 
                student.setPassword(rs.getString(8));
            } return student;     
    }
     
     public void deleteStudent(Student stf) throws SQLException{
        st.executeUpdate("DELETE FROM ASDUSER.STUDENT WHERE Student_ID =" +stf.getId());
  
    }

     public void updateStudent(Student stf) throws SQLException {
        String values=
              
              "Full_Name = '"+stf.getFullName()+"',"+
              "DOB = '"+stf.getDOB()+"',"+
              "Email = '"+stf.getEmail()+"',"+
              "Address = '"+stf.getAddress()+"',"+
              "Phone = "+stf.getPhone()+","+
              "Title = '"+stf.getTitle()+"',"+
              "Password = '"+stf.getPassword()+"'"
              ;
        System.out.println(values);
        st.executeUpdate("UPDATE ASDUSER.STUDENT SET "+values+" WHERE Student_ID ="+stf.getId());   
        System.out.println("UPDATE ASDUSER.STUDENT SET "+values+" WHERE Student_ID ="+stf.getId());

    }  
     
       //Add a student into the db
    public void addStudent (Student stf) throws SQLException {
       String values = 
               
               "'"+stf.getFullName() + "',"+
              "'"+stf.getDOB() + "',"+
               "'"+stf.getEmail() + "',"+
              "'"+stf.getAddress() + "',"+
               ""+stf.getPhone() + ","+
              "'"+stf.getTitle() + "',"+
               "'"+stf.getPassword() + "'";


       st.executeUpdate("INSERT INTO ASDUSER.STUDENT(Full_Name,DOB,Email,Address,Phone,Title,Password) VALUES("+values+")");
       System.out.println("INSERT INTO ASDUSER.STUDENT(Full_Name,DOB,Email,Address,Phone,Title,Password) VALUES("+values+")");

    }
    
    public ArrayList<Student> fetchStudentList() throws SQLException
        {


            String fetch = "SELECT * FROM ASDUSER.STUDENT";

            ResultSet rs = st.executeQuery(fetch);
            ArrayList<Student> temp1 = new ArrayList();
            while(rs.next()){
            int Id = rs.getInt(1);
                System.out.println(Id);
                String Name = rs.getString(2);
                Date DOB = rs.getDate(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                int Phone = rs.getInt(6);
                String Title = rs.getString(7);
                String Password = rs.getString(8);
            temp1.add(new Student(Id, Name, DOB, Email, Address, Phone, Title, Password));
        } 
            return temp1;
        }
    
    
    //Find user by email and password in the database   
    public CustomerBean findCustomer(String emaild) throws SQLException {  
        return findCustomer(emaild, "");
    }
    public CustomerBean findCustomer(String email, String password) throws SQLException {   
        String query = "SELECT * FROM sql12346043.CUSTOMERDB WHERE  Email='"+email+"'"+ (password.length()>0? " AND Password = '"+password+"'":"");
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String cust_email = rs.getString(2);
            String cust_password = rs.getString(3);
            System.out.println(cust_email+","+cust_password);
            if(cust_email.equals(email)&& cust_password.equals(password)){
                CustomerBean cb = new CustomerBean();
                cb.setEmail(cust_email);
                cb.setPassword(cust_password);
                cb.setName(rs.getString(4));
                cb.setId(rs.getInt(1));
                String[] dt = rs.getString(5).split("/");
                System.out.println(Arrays.toString(dt));
                
                cb.setDOB(Date.valueOf(rs.getString(5)));
                cb.setAddress(rs.getString(6));
                cb.setPhone(rs.getString(7));
                cb.setTitle(rs.getString(8));
                return cb;
            }
        }             
       return null;   
    } 
    
    
    

    //Add a user-data into the database   
    public void addCustomer(CustomerBean cb) throws SQLException {                   
//code for add-operation       
//VALUES(0,'pepe@gmail.com','password','Pai pei','12/17/1947','123 Hujianyan St, HongDoui, Singapore',35702572,'Mr');
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String values=
              "'"
              +cb.getEmail()+"','"
              +cb.getPassword()+"','"
              +cb.getName()+"','"
              +format.format(cb.getDOB())+"','"+
              cb.getAddress()+"','"
              +cb.getPhone()+"','"
              +cb.getTitle()+"'"
              ;
      System.out.println(values);
      st.executeUpdate("INSERT INTO sql12346043.CUSTOMERDB(Email, Password,FullName,DOB,Address,Phone,Title)  VALUES("+values+")");   
      cb.setId(findCustomer(cb.getEmail(),cb.getPassword()).getId());

    }
    public CustomerAccessLogBean addCustomerLoginRecord(CustomerBean cb) throws SQLException {                   
//code for add-operation       
//VALUES(0,'pepe@gmail.com','password','Pai pei','12/17/1947','123 Hujianyan St, HongDoui, Singapore',35702572,'Mr');
      SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
      java.util.Date d =  new java.util.Date();
      String values=
              ""
              +cb.getId()+",'"
              +dateformat.format(d)+"','"
              +timeformat.format(d)+"'"
              ;
      System.out.println(values);
      st.executeUpdate("INSERT INTO sql12346043.CUSTOMER_SESSION(Customer_ID, LOGGEDIN_DATE,LOGGEDIN_TIME)  VALUES("+values+")");   
      CustomerAccessLogBean cab = new CustomerAccessLogBean();
      cab.setCustomer(cb);
      cab.setLoggedin(d);
      return cab;
    }
    
    public void endCustomerLoginRecord(CustomerAccessLogBean cb) throws SQLException {                   
//code for add-operation       
//VALUES(0,'pepe@gmail.com','password','Pai pei','12/17/1947','123 Hujianyan St, HongDoui, Singapore',35702572,'Mr');
      SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat timeformat = new SimpleDateFormat("H:m:s");
      java.util.Date d =  new java.util.Date();
      
      
      String values=
              "LOGGEDOUT_DATE = '"+dateformat.format(d)+"',"+
              "LOGGEDOUT_TIME = '"+timeformat.format(d)+"'"
              ;
      System.out.println(values);
      st.executeUpdate(
                "UPDATE sql12346043.CUSTOMER_SESSION SET "+values+" "
                        + "WHERE"
                        + " Customer_ID = "+cb.getCustomerid()+
                          " AND LOGGEDIN_TIME = '"+timeformat.format(cb.getLoggedin())+"'"+
                          " AND LOGGEDIN_DATE = '"+dateformat.format(cb.getLoggedin())+"'" );   
      cb.setLoggedout(d);
    }
    
    public ArrayList<CustomerAccessLogBean> listCustomerLoginRecord(int cid) throws SQLException, ParseException {                   
        ArrayList<CustomerAccessLogBean> result = new ArrayList<>();
      String query = "SELECT * FROM sql12346043.CUSTOMER_SESSION WHERE  Customer_ID="+cid;
        ResultSet rs = st.executeQuery(query);
        
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        while(rs.next()){
             CustomerAccessLogBean cb = new CustomerAccessLogBean();
                cb.setCustomerid(cid);
                cb.setLoggedin(timeformat.parse(rs.getString(2)+" "+rs.getString(3)));
                cb.setLoggedout(rs.getString(4)==null?cb.getLoggedin():(timeformat.parse(rs.getString(4)+" "+rs.getString(5))));
                //apply time here.
                //add search and delete and ur done yey
                result.add(cb);
        }
        return result;
    }

    //update a user details in the database   
    public void updateCustomer(CustomerBean cb) throws SQLException {       
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String values=
              "Email = '"+cb.getEmail()+"',"+
              "Password = '"+cb.getPassword()+"',"+
              "FullName = '"+cb.getName()+"',"+
              "DOB = '"+format.format(cb.getDOB())+"',"+
              "Address = '"+cb.getAddress()+"',"+
              "Phone = '"+cb.getPhone()+"',"+
              "Title = '"+cb.getTitle()+"'"
              ;
        System.out.println(values);
        st.executeUpdate("UPDATE sql12346043.CUSTOMERDB SET "+values+" WHERE Customer_ID ="+cb.getId());   

    }       

    //delete a user from the database   
    public void deleteCustomer(String email) throws SQLException{       
       st.executeUpdate("DELETE FROM sql12346043.CUSTOMERDB WHERE Email='"+email+"'");
    }
    
    
    
    
    
    
    
    //SUPPLIER INFORMATION
    //can view supplier info
     public void showSupplier(String ContactName, String CompanyAddress,int ConNumber, String CompanyType, String CompanyEmail, int Status) throws SQLException{
        String query = "SELECT FROM * ASDUSER.TSDB";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            ContactName = rs.getString(2);
            CompanyAddress = rs.getString(3);
            ConNumber = rs.getInt(4);
            CompanyType = rs.getString(5);
            CompanyEmail = rs.getString(6);
            Status = rs.getInt(7);
        } 
     }
    
           //find supplier from db using supplier id
     public Supplier findSupplier(String CompanyName, String CompanyType) throws SQLException {   
        String query = "SELECT * FROM ASDUSER.TSDB WHERE  SupName='"+CompanyName+"' AND Password = '"+CompanyType+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            String C_Name = rs.getString(2);
            String C_Type = rs.getString(4);
            

            if(C_Name.equals(CompanyName) && C_Type.equals(CompanyType) ){ 
                int S_ID = rs.getInt(1);               
                String C_Address = rs.getString(3);
                String C_Email = rs.getString(5);
                int C_Status = rs.getInt(6);

                System.out.println("Company Name: " +C_Name);
                return new Supplier (S_ID, C_Name, C_Address, C_Type, C_Email, C_Status); 
            }
        }         
       return null;   
    }
     
        public Supplier getSupplier(int Supplier_id) throws SQLException {   
        Supplier supplier = null;
            String query = "SELECT * FROM ASDUSER.TSDB WHERE  TSID="+Supplier_id+"";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int S_ID = rs.getInt(1);
                System.out.println(S_ID);
                String C_Name = rs.getString(2);
                String C_Address = rs.getString(3);
                String C_Type = rs.getString(4);
                String C_Email = rs.getString(5);
                int C_Status = rs.getInt(6);
                System.out.println("Company Name: " +C_Name);
                supplier = new Supplier (S_ID, C_Name, C_Address, C_Type, C_Email, C_Status); 
            } return supplier;     
    }
        
    //Add a supplier into the db
    public void addSupplier(Supplier sb) throws SQLException {
        String values=
              //"SupplierID = '"+sb.getSupplierID()+"',"+
              "'"+sb.getCompanyName()+"',"+
              "'"+sb.getCompanyAddress()+"',"+
              "'"+sb.getCompanyType()+"',"+
              "'"+sb.getCompanyEmail()+"',"+
              ""+sb.getCompanyStatus()+""
              ;
        System.out.println(values);
        st.executeUpdate("INSERT INTO ASDUSER.TSDB(TSName,TSAddress,TSType,TSEmail,TSStatus)  VALUES("+values+")");   

    }  
    /*public void addSupplier (String CompanyName, String CompanyAddress, String CompanyType, String CompanyEmail, int CompanyStatus) throws SQLException {
        st.executeUpdate("INSERT INTO APP.SUPPLIERDB" + "VALUES ("+CompanyName+", "+CompanyAddress+", "+CompanyType+", "+CompanyEmail+", "+CompanyStatus+")");
    }*/
    //Update a Suppliers information
    public void updateSupplier(Supplier sb) throws SQLException {
        String values=
              //"SupplierID = '"+sb.getSupplierID()+"',"+
              "TSName = '"+sb.getCompanyName()+"',"+
              "TSAddress = '"+sb.getCompanyAddress()+"',"+
              "TSType = '"+sb.getCompanyType()+"',"+
              "TSEmail = '"+sb.getCompanyEmail()+"'"
              ;
        System.out.println(+sb.getSupplierID());
        st.executeUpdate("UPDATE ASDUSER.TSDB SET "+values+" WHERE TSID ="+sb.getSupplierID());   

    }  
    
    /*public void updateSupplier (int SupplierID, String CompanyName, String CompanyAddress, String CompanyType, String CompanyEmail, int Status) throws SQLException {
        st.executeUpdate("UPDATE APP.SUPPLIERDB SET SupName ="+CompanyName+", SET SupAddress  "+CompanyAddress+", SET SupType "+CompanyType+",SET SupEmail "+CompanyEmail+", SET SupStatus "+Status+" WHERE SupplierID ='"+SupplierID+"'");
    }*/
    
    
    //delete a supplier from db
    public void deleteSupplier(Supplier sd) throws SQLException{
        st.executeUpdate("DELETE FROM ASDUSER.TSDB WHERE TSID =" +sd.getSupplierID());
  
    }

    public ArrayList<Supplier> fetchSupplierList() throws SQLException{
           
        String fetch = "SELECT * FROM ASDUSER.TSDB";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Supplier> listSupplier = new ArrayList(); 
       
        while(rs.next()){
            int S_ID = rs.getInt(1);
            String C_NAME = rs.getString(2);
            String C_ADDRESS = rs.getString(3);
            String C_TYPE = rs.getString(4);
            String C_EMAIL = rs.getString(5);
            int C_STATUS = rs.getInt(6);
            
            Supplier SupplierFromDB = new Supplier(S_ID, C_NAME, C_ADDRESS, C_TYPE, C_EMAIL, C_STATUS);
            listSupplier.add(SupplierFromDB);
            
        }     
        return listSupplier;
    }
    
     public ArrayList<Supplier> Oneline(int Supplier_id) throws SQLException{
           
        String fetch = "SELECT * FROM ASDUSER.TSDB WHERE  TSID='"+Supplier_id+"'";;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Supplier> oneline = new ArrayList(); 
       
        while(rs.next()){
            int S_ID = rs.getInt(1);
            String C_NAME = rs.getString(2);
            String C_ADDRESS = rs.getString(3);
            String C_TYPE = rs.getString(4);
            String C_EMAIL = rs.getString(5);
            int C_STATUS = rs.getInt(6);
            
            Supplier SupplierFromDB = new Supplier(S_ID, C_NAME, C_ADDRESS, C_TYPE, C_EMAIL, C_STATUS);
            oneline.add(SupplierFromDB);
            
            
        }     
        return oneline;
    }
}