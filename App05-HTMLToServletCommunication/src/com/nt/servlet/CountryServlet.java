package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String statesIndia[] = {"AP", "TS", "MH", "MP", "UP"};
		String stateUS[] = {"CA", "LA", "NY", "CR", "AZ"};
		String stateAusis[] = {"TMS", "BB", "CBR"};
		String country = null;
		//Read form data
		country = req.getParameter("country");
		//Get PrintWriter object
		pw = res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//get states based on the country that is selected
		if (country.equals("india")) {
			pw.println("States : "+Arrays.toString(statesIndia));
		} else if (country.equals("us")) {
			pw.println("State : "+Arrays.toString(stateUS));
		} else {
			pw.println("State : "+Arrays.toString(stateAusis));			
		}
		//close Stream
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
