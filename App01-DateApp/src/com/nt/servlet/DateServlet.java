package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		Date d = null;
		//get PrintWriter object
		pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write response
		d = new Date();
		pw.println("<b><i><center>Date and time is : "+d+"<center></i></b>");
		//close stream
		pw.close();
	}//service(-,-)

}//class
