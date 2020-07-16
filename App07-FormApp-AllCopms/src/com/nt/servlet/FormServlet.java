package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = null, gender = null, ms = null, addrs = null, qlfy = null, crs[] = null, hb[] = null;
		int age = 0;
		PrintWriter pw = null;
		// getWriter stream
		pw = res.getWriter();
		// set contentType
		res.setContentType("text/html");

		// read form data
		name = req.getParameter("tname");
		age = Integer.parseInt(req.getParameter("tage"));
		gender = req.getParameter("gen");
		ms = req.getParameter("ms");
		addrs = req.getParameter("address");
		qlfy = req.getParameter("qlfy");
		crs = req.getParameterValues("crs");
		hb = req.getParameterValues("hb");

		// Write the business logic
		if (gender.equalsIgnoreCase("M")) {
			// logics for man
			if (age <= 5) {
				pw.println("<h3 style='color:skyblue'>Master " + name + " you are a baby boy</h3>");
			} // age-5 if
			else if (age <= 12) {
				pw.println("<h3 style='color:green'>Master " + name + " you are a small boy</h3>");
			} // age-12 else if
			else if (age <= 19) {
				pw.println("<h3 style='color:blue'>Mr. " + name + " you are a teenage boy</h3>");
			} // age-19 else if
			else if (age <= 35) {
				pw.println("<h3 style='color:greenblue'>Mr. " + name + " you are a young man</h3>");
			} // age-35 else if
			else if (age <= 50) {
				pw.println("<h3 style='color:skyblue'>Mr. " + name + " you are a middle aged man</h3>");
			} // age-50 else if
			else {
				pw.println("<h3 style='color:cyne'>master " + name + " you are a budda</h3>");
			} // else
		} else {
			// logics for woman
			if (age <= 5) {
				pw.println("<h3 style='color:skyblue'>Master " + name + " you are a baby girl</h3>");
			} // age-5 if
			else if (age <= 12) {
				pw.println("<h3 style='color:green'>Master " + name + " you are a small girl</h3>");
			} // age-12 else if
			else if (age <= 19) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h3 style='color:blue'>Mrs. " + name + " you are a teenage married girl</h3>");
				} else {
					pw.println("<h3 style='color:blue'>Miss. " + name + " you are a teenage girl</h3>");
				}
			} // age-19 else if
			else if (age <= 35) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h3 style='color:blue'>Mrs. " + name + " you are a young married woman</h3>");
				} else {
					pw.println("<h3 style='color:blue'>Miss. " + name + " you are a young woman</h3>");
				}
			} // age-35 else if
			else if (age <= 50) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h3 style='color:blue'>Mrs. " + name + " you are a middle aged married woman</h3>");
				} else {
					pw.println("<h3 style='color:blue'>Miss. " + name + " you are a middle aged woman</h3>");
				}
			} // age-50 else if
			else {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h3 style='color:blue'>Mrs. " + name + " you are a married old woman</h3>");
				} else {
					pw.println("<h3 style='color:blue'>Miss. " + name + "you are a old woman</h3>");
				}
			} // else
		} // if_else

		// show all the data
		pw.println("<br>Name : " + name);
		pw.println("<br>Age : " + age);
		pw.println("<br>Gender : " + gender);
		pw.println("<br>Address : " + addrs);
		pw.println("<br>Marrital status : " + ms);
		pw.println("<br>Qualification : " + qlfy);
		pw.println("<br>Courses : " + Arrays.toString(crs));
		pw.println("<br>Hobbies : " + Arrays.toString(hb));
		
		//close stream
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
