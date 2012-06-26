package com.f1soft.testproject.client;

import com.f1soft.testproject.client.mvp.TestProjectGinInjector;
import com.f1soft.testproject.client.resources.TestProjectResources;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class TestEntryPoint implements EntryPoint {

	private final TestProjectGinInjector ginInjector = GWT.create(TestProjectGinInjector.class);

	@Override
	public void onModuleLoad() {
		TestProjectResources.INSTANCE.testProjectCss().ensureInjected();
		RootPanel loader = RootPanel.get("loader");
		loader.setStyleName("in-loader");
		DelayedBindRegistry.bind(ginInjector);
		ginInjector.getPlaceManager().revealCurrentPlace();
	}
}
