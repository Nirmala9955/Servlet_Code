package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null, tage = null;
		int age = 0;
		//get PrintWriter object
		pw = res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//get request parameter value
		name = req.getParameter("name");
		tage = req.getParameter("age");
		age = Integer.parseInt(tage);
		//write request processing logic
		if (age>=18) {
			pw.println("<h1 style='color:green'>"+name+"you are eligible for vote<h1>");
		} else {
			pw.println("<h1 style='color:red'>"+name+"you are not eligible for vote<h1>");
		}
		//add hyperlink
		pw.println("<a href='input.html'>Home</a>");
		//close stream
		pw.close();
	} //doPost(-,-)
	
} //class
