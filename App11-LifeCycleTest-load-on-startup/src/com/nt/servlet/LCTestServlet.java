package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LCTestServlet extends HttpServlet {

	static {
		System.out.println("LCTestServlet.enclosing_method()");
	}

	public LCTestServlet() {
		System.out.println("LCTestServlet.LCTestServlet()");
	}

	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("LCTestServlet.init(ServletConfig)");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LCTestServlet.service()");
		PrintWriter pw = null;
		// get Printwriter Object
		pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// write response
		Date d = new Date();
		pw.println("<h2 style='text-align:center;'>Date and time is : " + d + "</h2>");
		// close stream
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("LCTestServlet.destroy()");
	}
}
