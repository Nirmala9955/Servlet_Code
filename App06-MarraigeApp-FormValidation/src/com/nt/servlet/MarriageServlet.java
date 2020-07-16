package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, 
			                          HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gen=null,tage=null;
		int age=0;
		List<String> errsList=null;
		String vstatus=null;
		
		//get PrintWriter
		pw=res.getWriter();
		// set response content type
		res.setContentType("text/html");
		//read form data...
		name=req.getParameter("pname");
		gen=req.getParameter("gender");
		tage=req.getParameter("page");
		
		//read vflag value to enable or disable server side form validations
		vstatus=req.getParameter("vflag");
	if(vstatus.equalsIgnoreCase("no")) {
		//form validation logic (server side)
		  errsList=new ArrayList();
		  System.out.println("Server side form validation Errors....");
		if(name==null || name.equals("") || name.length()==0 ) {  //required rule
			 errsList.add("Person name is required");
		}//if
		if(tage==null || tage.equals("") || tage.length()==0) {  //required  rule
			 errsList.add("Person age is required");
		}//if
		else {
			try {
			age=Integer.parseInt(tage);  
			   if(age<1 || age>125) {   //age range rule
				 errsList.add("Person age must be through 1 through 125");
			   }//if
			}//try
			catch(NumberFormatException nfe) { //age must be numeric rule
				errsList.add("Person age must be number value");
			}//catch
		}//else
		 //display form validation error messages togathter
		if(errsList.size()!=0) {
			for(String msg:errsList) {
				pw.println("<h1 style='color:red;text-align:center'>"+msg+"</h1>");
			}//for
			return;
		}//if
		}//if
	else {
		 age=Integer.parseInt(tage);
	}
		
		//write b.logic or req processing logic
		if(gen.equalsIgnoreCase("M")) {
			if(age<21)
				 pw.println("<h1 style='color:red'>Mr. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Mr. "+name+" u  r elgible for Marriage .. But think Thrice becoz it is 60 years project </h1>");
		}
		else {
			if(age<18)
				 pw.println("<h1 style='color:red'>Miss. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Miss. "+name+" u  r  elgible for Marriage .. But think twice .  </h1>");
		}
		
		//add hyperlink
		pw.println("<br><br> <a href='form.html'><img src='images/home1.png'></a>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)
}//class
