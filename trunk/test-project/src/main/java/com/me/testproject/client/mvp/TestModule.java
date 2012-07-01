package com.me.testproject.client.mvp;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.impl.SchedulerImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
import com.me.testproject.client.presenter.HomePagePresenter;
import com.me.testproject.client.presenter.MainPagePresenter;
import com.me.testproject.client.presenter.ProfilePresenter;
import com.me.testproject.client.view.HomePageView;
import com.me.testproject.client.view.MainPageView;
import com.me.testproject.client.view.ProfileView;
import com.me.testproject.client.view.impl.HomePageViewImpl;
import com.me.testproject.client.view.impl.MainPageViewImpl;
import com.me.testproject.client.view.impl.ProfileViewImpl;
import com.me.testproject.shared.request.UserRequestContext;
import com.me.testproject.shared.service.TestRequestFactory;

public class TestModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
		bind(RootPresenter.class).asEagerSingleton();
		bind(PlaceManager.class).to(TestPlaceManager.class).in(Singleton.class);
		bind(TestRequestFactory.class).in(Singleton.class);
		bind(Scheduler.class).to(SchedulerImpl.class).in(Singleton.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
		bindPresenter(MainPagePresenter.class, MainPageView.class, MainPageViewImpl.class, MainPagePresenter.MainProxy.class);
		bindPresenter(HomePagePresenter.class, HomePageView.class, HomePageViewImpl.class, HomePagePresenter.HomePageProxy.class);
		bindPresenter(ProfilePresenter.class, ProfileView.class, ProfileViewImpl.class, ProfilePresenter.ProfileProxy.class);
	}

	@Provides
	UserRequestContext provideUserRequest(TestRequestFactory requestFactory) {
		requestFactory.initialize(new com.google.web.bindery.event.shared.SimpleEventBus());
		return requestFactory.userRequestContext();
	}
}
