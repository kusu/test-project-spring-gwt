package com.me.testproject.client.mvp;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.me.testproject.client.i18n.TestProjectConstants;
import com.me.testproject.client.presenter.HomePagePresenter;
import com.me.testproject.client.presenter.MainPagePresenter;
import com.me.testproject.client.presenter.ProfilePresenter;
import com.me.testproject.shared.service.TestRequestFactory;

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
