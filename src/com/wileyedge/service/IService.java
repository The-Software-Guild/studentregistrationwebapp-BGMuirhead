package com.wileyedge.service;

import com.wileyedge.model.Student;

public interface IService {
	
	void saveStudent(Student s);
	Student getStudent(String name);

}
