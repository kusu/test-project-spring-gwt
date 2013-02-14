package com.me.testproject.server.remoting;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.ServletContextAware;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public class GwtBeanPostProcessor implements BeanPostProcessor, ServletContextAware {
	private final GwtServiceExporter serviceExporter;
	private ServletContext servletContext;

	public GwtBeanPostProcessor(GwtServiceExporter serviceExporter) {
		this.serviceExporter = serviceExporter;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	// --------------------- Interface BeanPostProcessor ---------------------

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		RemoteServiceRelativePath path = AnnotationUtils.findAnnotation(bean.getClass(), RemoteServiceRelativePath.class);
		if (path != null) {
			GwtServletWrapper wrapper = new GwtServletWrapper(bean);

			wrapper.setServletContext(servletContext);

			serviceExporter.registerGwtServlet(path.value(), wrapper);
		}

		return bean;
	}
}
