package org.springframework.webflow.samples.booking.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {
	
	@Bean
	public FlowDefinitionRegistry flowRegistry(FlowBuilderServices flowBuilderServices) {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices)
				.setBasePath("/WEB-INF")
				.addFlowLocationPattern("/**/*-flow.xml").build();
	}
	
	@Bean
	public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowRegistry) {
		FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
		handlerMapping.setOrder(-1);
		handlerMapping.setFlowRegistry(flowRegistry);
		return handlerMapping;
	}
	
	@Bean
	public FlowExecutor flowExecutor(FlowDefinitionRegistry flowRegistry) {
		return getFlowExecutorBuilder(flowRegistry)
				.addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
				.build();
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
		FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
		handlerAdapter.setFlowExecutor(flowExecutor);
		handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
		return handlerAdapter;
	}

	@Bean
	public FlowBuilderServices flowBuilderServices(LocalValidatorFactoryBean validator) {
		return getFlowBuilderServicesBuilder()
				.setValidator(validator)
				.setDevelopmentMode(true)
				.build();
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

}
