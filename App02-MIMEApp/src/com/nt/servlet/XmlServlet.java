package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		//get PrintWriter object
		pw=res.getWriter();
		//set contentType
		res.setContentType("application/xml");
		//write logic to generate output (web page)
		pw.println("<table border='1'>");
		pw.println("<tr><th>Player</th><th>Role</th></tr>");
		pw.println("<tr><td>Dhoni</td><td>Captain</td></tr>");
		pw.println("<tr><td>Sachin</td><td>All rounder</td></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	} //service(-,-)

} //class
