package org.springframework.webflow.samples.booking.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
			SecurityConfig.class,
			DataAccessConfig.class,
			WebMvcConfig.class,
			WebFlowConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter() };
	}

}
