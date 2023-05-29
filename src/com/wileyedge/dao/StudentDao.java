package com.wileyedge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.wileyedge.model.Student;

public class StudentDao implements IDao {

	private Connection openConnection() {
		// Class.forName("com.mysql.cj.jdbc.Driver"); //Type 4 driver // Does not work
		// for MySQL 5

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// Type 4 driver is registered with DriverManager // works for MySQL
													// version 5
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentAssignment", "root", "root");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL suitable driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	private void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void persistStudent(Student s) {
		// TODO Auto-generated method stub
		
		Connection con = openConnection();
		
		String mobile = s.getMobile();
		String name = s.getName();
		int age = s.getAge();
		String address = s.getAddress();
		
		String sql1 = "insert into student values(?,?,?,?);";
		PreparedStatement pstat;
		try {
			pstat = con.prepareStatement(sql1);
			pstat.setString(1, mobile);
			pstat.setString(2, name);
			pstat.setInt(3, age);
			pstat.setString(4, address);
			
			int a = pstat.executeUpdate();
		}
		catch (MySQLIntegrityConstraintViolationException err) {
			// Already In DB

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
	
		System.out.println("Student Saved\n");

	}

	@Override
	public Student retrieveStudent(String searchName) {


		Student student = null;
		Connection con = openConnection();

		String sql = "select * from student where name = ?";
		PreparedStatement pstat;

		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, searchName);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				String mobile = rs.getString(0);
				String name =  rs.getString(1);
				int age =  rs.getInt(2);
				String address =  rs.getString(3);

				student = new Student(name, age, mobile, address);

			}

			if (student == null) {
//				throw new CustomerNotFoundException("No customer found that matches input name");
				System.out.println("No student found that matches input name");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(con);

		return student;
		
	}

}
