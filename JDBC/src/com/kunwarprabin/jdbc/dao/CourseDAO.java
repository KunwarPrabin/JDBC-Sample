/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunwarprabin.jdbc.dao;

import com.kunwarprabin.jdbc.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author OWNER
 */
public interface CourseDAO {
    int insert(Course c)throws ClassNotFoundException,SQLException;
    List<Course> getAll()throws ClassNotFoundException,SQLException; 
    int delete(int id)throws ClassNotFoundException,SQLException;
    int update(Course c)throws ClassNotFoundException,SQLException;
}
