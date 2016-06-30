/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunwarprabin.jdbc;

import com.kunwarprabin.jdbc.dao.CourseDAO;
import com.kunwarprabin.jdbc.dao.impl.CourseDAOImpl;
import com.kunwarprabin.jdbc.entity.Course;
import java.sql.SQLException;

/**
 *
 * @author OWNER
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

           CourseDAO courseDAO = new CourseDAOImpl();
//            courseDAO.getAll().forEach(c->{
//                System.out.println(c.toString());
//            });
            //courseDAO.delete(5);
           Course cc = new Course();
           courseDAO.update(cc);
        } catch(ClassNotFoundException | SQLException ce) {
            System.out.println(ce.getMessage());
        }
    }

}
