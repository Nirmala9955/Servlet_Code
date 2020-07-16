package com.nt.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		Calendar calendar = null;
		int hour = 0;
		//get PrintWriter object
		pw = res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//Get System Date
		calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		//generate the wish message
		if (hour<=12)
			pw.println("<h1 style='color:cyan'>Good Morning</h1>");
		else if (hour<=17)
			pw.println("<h1 style='color:cyan'>Good afternoon</h1>");
		else if (hour<=20)
			pw.println("<h1 style='color:cyan'>Good Evening</h1>");
		else
			pw.println("<h1 style='color:cyan'>Good Night</h1>");
		//Generate the hyperlink
		pw.println("<br><a href='http://localhost:2525/App03-HTMLToServletCommunication/page.html'>Home</a>");
		//close the stream
		pw.close();
	} //service(-,-)
	
} //class
