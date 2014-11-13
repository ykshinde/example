package com.ykshinde.examples.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse res) throws ServletException, IOException {
		
		res.getWriter().append(String.format("Serving from embedded Tomcat Instance",
						new Date()));
	}
}