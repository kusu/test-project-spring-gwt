package com.f1soft.testproject.client.resources;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface TestProjectResources extends ClientBundle {
	
	public static final TestProjectResources INSTANCE = GWT.create(TestProjectResources.class);

	@NotStrict
	@Source("testproject.css")
	TestProjectCssResource testProjectCss();	
	

}
