package com.wileyedge.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import com.wileyedge.dao.IDao;
import com.wileyedge.dao.StudentDao;
import com.wileyedge.model.Student;

public class StudentService implements IService{

	
	private IDao dao;
	
    public StudentService(ServletContext ctx) {
    	String driverName = ctx.getInitParameter("dbDriver");
    	String dbPath = ctx.getInitParameter("dbPath");;
    	String dbUsername =ctx.getInitParameter("dbUsername");;
    	String dbPassword = ctx.getInitParameter("dbPassword");;
    	
    	dao= new StudentDao(driverName, dbPath, dbUsername, dbPassword);
	}
	
	@Override
	public void saveStudent(Student s) {
		dao.persistStudent(s);

	}

	@Override
	public Student getStudent(String name) {
		return dao.retrieveStudent(name);
	}


}
