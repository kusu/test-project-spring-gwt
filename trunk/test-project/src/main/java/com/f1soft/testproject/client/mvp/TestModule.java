package com.f1soft.testproject.client.mvp;

import com.f1soft.testproject.client.presenter.HomePagePresenter;
import com.f1soft.testproject.client.presenter.MainPagePresenter;
import com.f1soft.testproject.client.presenter.ProfilePresenter;
import com.f1soft.testproject.client.presenter.TestRootPresenter;
import com.f1soft.testproject.client.view.HomePageView;
import com.f1soft.testproject.client.view.MainPageView;
import com.f1soft.testproject.client.view.ProfileView;
import com.f1soft.testproject.client.view.impl.HomePageViewImpl;
import com.f1soft.testproject.client.view.impl.MainPageViewImpl;
import com.f1soft.testproject.client.view.impl.ProfileViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class TestModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
		bind(RootPresenter.class).to(TestRootPresenter.class).asEagerSingleton();
		bind(PlaceManager.class).to(TestPlaceManager.class).in(Singleton.class);
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
		bindPresenter(MainPagePresenter.class, MainPageView.class, MainPageViewImpl.class, MainPagePresenter.MainProxy.class);
		bindPresenter(HomePagePresenter.class, HomePageView.class, HomePageViewImpl.class, HomePagePresenter.HomePageProxy.class);
		bindPresenter(ProfilePresenter.class, ProfileView.class, ProfileViewImpl.class, ProfilePresenter.ProfileProxy.class);
	}

}
