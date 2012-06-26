package com.f1soft.testproject.server;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

/**
 * Guice module used to bind guice-injected servlets and filters with their URL.
 */
public class TestServletModule extends ServletModule {
	@Override
	public void configureServlets() {

		// AppStats filter and servlet
		// bind(AppstatsFilter.class).in(Singleton.class);
		// bind(AppstatsServlet.class).in(Singleton.class);

		// Map<String, String> appstatsFilterParams = new HashMap<String,
		// String>();
		// appstatsFilterParams.put("logMessage",
		// "Appstats available: /appstats/details?time={ID}");
		// filter("/*").through(AppstatsFilter.class, appstatsFilterParams);
		// serve("/appstats/*").with(AppstatsServlet.class);

		// RequestFactory servlet
		bind(RequestFactoryServlet.class).in(Singleton.class);
		serve("/gwtRequest").with(RequestFactoryServlet.class);

		// GWT-platform commands servlet
		// serve("/" + ActionImpl.DEFAULT_SERVICE_NAME +
		// "*").with(DispatchServiceImpl.class);

	}
}
