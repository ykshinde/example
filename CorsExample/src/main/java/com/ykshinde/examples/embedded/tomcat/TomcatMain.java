package com.ykshinde.examples.embedded.tomcat;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.ykshinde.examples.servlet.SimpleServlet;

public class TomcatMain {

	/**
	 * @param args
	 */
	public static void main(final String[] args) throws IOException,
			LifecycleException, ServletException {
		
		System.out.println("STARTING EMBEDDED TOMCAT WEB CONTAINER\n");
		new TomcatMain().startServer();

	}
	
	public void startServer() throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		File base = new File("./staticContent");
		
		Context rootCtx = tomcat.addWebapp("/app", base.getAbsolutePath());
		
		/*
		 * Comment following filter declaration, if you want to disable the cross-site support, 
		 * OR you want to try out TOMCAT embedded code sample
		 * 
		 * /
		
		/*FilterDef filterDef = new FilterDef();
		filterDef.setFilterName(CorsFilter.class.getSimpleName());
		filterDef.setFilterClass(CorsFilter.class.getName());
		filterDef.addInitParameter("cors.allowed.origins", "http://wpuys00770l:8080/, http://127.0.0.1:8080");
		filterDef.addInitParameter("cors.allowed.methods", "GET,POST,HEAD,OPTIONS,PUT");
		
		rootCtx.addFilterDef(filterDef);
		
		FilterMap filterMap = new FilterMap();
		filterMap.setFilterName(CorsFilter.class.getSimpleName());
		filterMap.addURLPattern("/*");
		rootCtx.addFilterMap(filterMap);*/
		
		/*END OF COMMENT*/
		
		Tomcat.addServlet(rootCtx, "home", new SimpleServlet());
		rootCtx.addServletMapping("/home", "home");
				
		tomcat.start();
		tomcat.getServer().await();
	}

}
