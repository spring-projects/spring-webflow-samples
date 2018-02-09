package org.springframework.webflow.samples.booking.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SecurityConfig.class, AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/spring/*" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new CharacterEncodingFilter() };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Use JSF view templates saved as *.xhtml, for use with Facelets
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		// Enable special Facelets debug output during development
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		// Causes Facelets to refresh templates during development
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		// Declare Spring Security Facelets tag library
		servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/springsecurity.taglib.xml");

		// Comment out if not using Mojarra
		servletContext.addListener(com.sun.faces.config.ConfigureListener.class);

		// Let the DispatcherServlet be registered
		super.onStartup(servletContext);
	}

}
