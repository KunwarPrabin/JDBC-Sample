/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunwarprabin.jdbc.dao.impl;

import com.kunwarprabin.jdbc.dao.CourseDAO;
import com.kunwarprabin.jdbc.dbutil.DbConnection;
import com.kunwarprabin.jdbc.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OWNER
 */
public class CourseDAOImpl implements CourseDAO {

    private DbConnection db = new DbConnection();

    //Inserting Data to the DataBase-------
    @Override
    public int insert(Course c) throws ClassNotFoundException, SQLException {
        db.open();

        String sql = "INSERT INTO tbl_courses(course_name,course_description,duration,duration_type,fees,status)"
                + "VALUES(?,?,?,?,?,?)";

        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setInt(3, c.getDuration());
        stmt.setString(4, c.getDurationType());
        stmt.setInt(5, c.getFees());
        stmt.setBoolean(6, c.isStatus());

        int result = db.update();
        db.close();
        return result;
    }

    //Selecting or Browsing all data from Database--------
    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        List<Course> courselist = new ArrayList<>();
        db.open();

        String sql = "SELECT * FROM tbl_courses";
        db.initStatement(sql);
        ResultSet rs = db.query();
        while (rs.next()) {
            Course c = new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("course_name"));
            c.setDescription(rs.getString("course_description"));
            c.setDuration(rs.getInt("duration"));
            c.setDurationType(rs.getString("duration_type"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setModifiedDate(rs.getDate("modified_date"));
            c.setStatus(rs.getBoolean("status"));

            courselist.add(c);
        }
        db.close();
        return courselist;

    }

    //Deleting Data through id in Database
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "DELETE FROM tbl_courses WHERE course_id=?";

        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        int result = db.update();
        db.close();
        return result;
    }

    //Updating Data in Database-----------
    @Override
    public int update(Course c) throws ClassNotFoundException, SQLException {
        db.open();

        String sql = "UPDATE tbl_courses SET course_name = ?, course_description = ?, duration = ?, duration_type = ?, fees=? WHERE tbl_courses.course_id = 4;";

        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, "CORE JAVA");
        stmt.setString(2, "Core Java Description");
        stmt.setInt(3,6);
        stmt.setString(4,"WEEK");
        stmt.setInt(5, 12000);

        int result = db.update();
        db.close();
        return result;
    }

}
