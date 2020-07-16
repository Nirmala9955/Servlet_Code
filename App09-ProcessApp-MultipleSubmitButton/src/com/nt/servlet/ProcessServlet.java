package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String comp = null;
		int val1 = 0, val2 = 0;
		// get PrintWriter Stream
		pw = res.getWriter();
		// set contentType
		res.setContentType("text/html");
		// read s1 request parameter value to know the component that is used to send
		// the request
		comp = req.getParameter("s1");
		// write logic
		if (comp.equals("link1")) { // sys date
			pw.println("Date and time : " + new Date());
		} else if (comp.equals("link2")) {
			pw.println("System properties : " + System.getProperties());
		} else if (comp.equals("add")) {
			// read form data
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("Addition : " + (val1 + val2));
		} else if (comp.equals("sub")) {
			// read form data
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("Subtraction : " + (val1 + val2));
		} else {
			// read form data
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("Multiplication : " + (val1 * val2));
		}

		// add hyperlinks
		pw.println("<br><br><a href='form.html'>home</a>");

		//close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}
}
