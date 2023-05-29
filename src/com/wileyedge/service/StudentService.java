package com.wileyedge.service;

import com.wileyedge.dao.IDao;
import com.wileyedge.dao.StudentDao;
import com.wileyedge.model.Student;

public class StudentService implements IService {

	IDao dao = new StudentDao();
	
	@Override
	public void saveStudent(Student s) {
		dao.persistStudent(s);

	}

	@Override
	public Student getStudent(String name) {
		return dao.retrieveStudent(name);
	}

}
