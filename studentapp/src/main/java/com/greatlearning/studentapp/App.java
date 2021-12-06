package com.greatlearning.studentapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass( Student.class );
	    SessionFactory sessionFactory = con.buildSessionFactory();
        
	    StudentService ss = new StudentServiceImpl( sessionFactory );
        
        Student student = new Student();
        
        student.setName( "Rahul" );
        student.setDepartment( "Mathematics" );
        student.setCountry( "India" );
        
        ss.save( student );
        
        List<Student> students = ss.findAll();
		
		for( Student s : students ) {
			System.out.println( s );
		}
    }
}