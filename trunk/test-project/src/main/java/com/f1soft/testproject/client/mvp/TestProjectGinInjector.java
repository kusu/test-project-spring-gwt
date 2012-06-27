package com.f1soft.testproject.client.mvp;

import com.f1soft.testproject.client.i18n.TestProjectConstants;
import com.f1soft.testproject.client.presenter.HomePagePresenter;
import com.f1soft.testproject.client.presenter.MainPagePresenter;
import com.f1soft.testproject.client.presenter.ProfilePresenter;
import com.f1soft.testproject.shared.service.TestRequestFactory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ TestModule.class })
public interface TestProjectGinInjector extends Ginjector {

	PlaceManager getPlaceManager();

	EventBus getEventBus();

	TestProjectConstants getTestProjectConstants();

	TestRequestFactory getRequestFactory();

	Provider<MainPagePresenter> getMainPagePresenter();

	AsyncProvider<ProfilePresenter> getProfilePresenter();

	AsyncProvider<HomePagePresenter> getHomePagePresenter();
}
