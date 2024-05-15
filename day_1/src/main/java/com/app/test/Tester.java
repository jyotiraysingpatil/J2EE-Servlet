package com.app.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tester
 */
@WebServlet("/Hello")
public class Tester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	
	public void init() throws ServletException {
		System.out.println("in init method");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy Method");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		//1. set resp content type
		response.setContentType("text/html");
		//2. Get PW from HttpServletResponse , 
				//to send buffered text contents --> to the clnt 
				try(PrintWriter pw=response.getWriter()) {
					//add dyn contents to PW's buffer
					pw.print("<h4>Hello from servlets..."+LocalDateTime.now()+"</h4>");
				}
	}

}
