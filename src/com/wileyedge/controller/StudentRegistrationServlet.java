package com.wileyedge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wileyedge.model.Student;
import com.wileyedge.service.IService;
import com.wileyedge.service.StudentService;

/**
 * Servlet implementation class StudentRegistratrionServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String age =(String) request.getParameter("age");;
		String mobile =(String) request.getParameter("mobile");;
		String address =(String) request.getParameter("address");;
		Student s = new Student(name, Integer.parseInt(age), mobile, address);
		System.out.println(s);
		request.setAttribute("student", s);
		
		IService service = new StudentService();
		service.saveStudent(s);
		
		RequestDispatcher rd = request.getRequestDispatcher("./success.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
