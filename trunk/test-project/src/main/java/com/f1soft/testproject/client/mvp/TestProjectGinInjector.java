package com.f1soft.testproject.client.mvp;

import com.f1soft.testproject.client.mvp.TestModule;
import com.f1soft.testproject.client.i18n.TestProjectConstants;
import com.f1soft.testproject.client.presenter.MainPagePresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ TestModule.class })
public interface TestProjectGinInjector extends Ginjector {

	PlaceManager getPlaceManager();

	EventBus getEventBus();

	TestProjectConstants getCtbsConstants();

	Provider<MainPagePresenter> getMainPagePresenter();
	
}
