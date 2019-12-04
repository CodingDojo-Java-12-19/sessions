package com.codingdojo.hellos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		PrintWriter out = response.getWriter();
		RequestDispatcher view = request.getRequestDispatcher("hello.jsp");
		
		String nameFromParam = request.getParameter("name");
		
		String[] people = {"Geroge", "Bob", "Holly"};
		
		System.out.println(nameFromParam);
		
		request.setAttribute("name", nameFromParam);
		request.setAttribute("people", people);
		
//		response.setContentType("text/html");
		
		System.out.println("In http get request");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		view.forward(request, response);
		
		
//		out.write("<h1>Hello " +  nameFromParam +"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
