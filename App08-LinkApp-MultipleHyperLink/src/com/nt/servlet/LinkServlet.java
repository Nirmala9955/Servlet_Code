package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String link = null;
		Locale locales[] = null;
		// get PrintWriter
		pw = res.getWriter();
		// set response contentType
		res.setContentType("text/html");
		// read "s1" req param value to know the hyperlink that is clicked
		link = req.getParameter("s1");
		if (link.equalsIgnoreCase("link1")) { // all languages
			// get all available locales
			locales = Locale.getAvailableLocales();
			for (Locale lc : locales) {
				pw.println(lc.getDisplayLanguage() + "<br>");
			} // for
		} // if
		else if (link.equalsIgnoreCase("link2")) {
			// get all available locales
			locales = Locale.getAvailableLocales();
			for (Locale lc : locales) {
				pw.println(lc.getDisplayCountry() + "<br>");
			} // for
		} // else if
		else {
			pw.println("Date and time : " + new Date());
		}

		// add hyperlink to go home
		pw.println("<br><br><a href='page.html'>home</a>");
		
		//close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
