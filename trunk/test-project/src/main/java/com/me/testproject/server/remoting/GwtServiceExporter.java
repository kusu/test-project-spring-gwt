package com.me.testproject.server.remoting;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GwtServiceExporter implements Controller {
	private final Map<String, GwtServletWrapper> wrapper = new HashMap<String, GwtServletWrapper>();

	// --------------------- Interface Controller ---------------------

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getServletPath();
		int i = path.lastIndexOf('/');
		if (i >= 0)
			path = path.substring(i + 1);

		GwtServletWrapper servlet = wrapper.get(path);

		servlet.doPost(request, response);

		return null;
	}

	public void registerGwtServlet(String name, GwtServletWrapper servletWrapper) {
		wrapper.put(name, servletWrapper);
	}
}
