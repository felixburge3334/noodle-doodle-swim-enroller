/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

import java.sql.Connection;

/**
 *
 * @author willi
 */
public class DB {
    protected String URL = "jdbc:derby://localhost:1527/asdDB";	
    protected String db = "asdDB";
    protected String dbuser=  "asduser";
    protected String dbpass = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
