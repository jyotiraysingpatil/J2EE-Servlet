package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;


@WebServlet("/voter_register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException(" error in init phase : "+getClass(),e);
		}
	}

	
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in destory : "+getClass());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//prinWtrite
     try(PrintWriter pw= response.getWriter() ){
    	 // getting data from request header
    	 
    	 String firstName= request.getParameter("fn");
    	 String lastName = request.getParameter("ln");
    	 String email=request.getParameter("em");
    	 String password =request.getParameter("pass");
    	 String Dob=request.getParameter("dob");//html returns string so we have to convert it into date
    	 Date birthDate= Date.valueOf(Dob);
    	 //userId, String firstName, String lastName, String email, String password, Date dob, boolean status,
			//String role
    	System.out.println(userDao.voterRegistration(new User(9,firstName,lastName,email,password,birthDate,false,"voter")));
     } catch (Exception e) {
			throw new ServletException(" error in doPost phase : "+getClass(),e);
	}
	}

}
