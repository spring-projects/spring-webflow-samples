package org.springframework.webflow.samples.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.mvc.JsfView;
import org.springframework.faces.webflow.JsfFlowHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;


@Configuration
public class WebMvcConfig {

	@Autowired
	private WebFlowConfig webFlowConfig;

	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping mapping = new FlowHandlerMapping();
		mapping.setOrder(1);
		mapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
		/* If no flow matches, map the path to a view, e.g. "/intro" maps to a view named "intro" */
		mapping.setDefaultHandler(new UrlFilenameViewController());
		return mapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		JsfFlowHandlerAdapter adapter = new JsfFlowHandlerAdapter();
		adapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
		return adapter;
	}

	@Bean
	public UrlBasedViewResolver faceletsViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JsfView.class);
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".xhtml");
		return resolver;
	}

	@Bean
	public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {
		return new SimpleControllerHandlerAdapter();
	}

}
