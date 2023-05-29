package com.wileyedge.dao;

import com.wileyedge.model.Student;

public interface IDao {
	
	void persistStudent(Student s);
	Student retrieveStudent(String name);
	

}
