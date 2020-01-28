package com.fsimone.hibernate;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Here we use 100% pure Java configuration using AnnotationConfigWebApplicationContext
		// No XML file are used
//		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.setConfigLocation("com.fsimone.config");
//        context.scan("com.fsimone");
//        servletContext.addListener(new ContextLoaderListener(context));

        // use XmlWebApplicationContext to configure via XML file
        // the dispatcher Servlet 3.0
        //XmlWebApplicationContext context = new XmlWebApplicationContext();
        //context.setConfigLocation("dispatcher-config.xml");


        // Here we start a Servlet 3.0
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");

	}

}
