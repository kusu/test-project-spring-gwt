package com.f1soft.testproject.client;

import com.f1soft.testproject.client.mvp.TestProjectGinInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class TestEntryPoint implements EntryPoint{

	private final TestProjectGinInjector ginInjector=GWT.create(TestProjectGinInjector.class);
	
	@Override
	public void onModuleLoad() {
		DelayedBindRegistry.bind(ginInjector);
		ginInjector.getPlaceManager().revealCurrentPlace();
	}

}
