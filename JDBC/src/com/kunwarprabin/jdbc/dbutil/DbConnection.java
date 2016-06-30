/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunwarprabin.jdbc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OWNER
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmt = null;

    //OPEN DATABASE CONNECTION-------
    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/courseportal", "root", "");
    }

    public PreparedStatement initStatement(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }
     //INSERT/UPDATE/DELETE-------
     public int update() throws SQLException{
        return stmt.executeUpdate();
    }
    //SELECT---------
    public ResultSet query() throws SQLException{
        return stmt.executeQuery();
    }

    //CLOSE DATABASE CONNECTION---------
    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }
}
