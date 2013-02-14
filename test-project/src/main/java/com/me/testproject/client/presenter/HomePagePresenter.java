package com.me.testproject.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.TabContentProxy;
import com.me.testproject.client.mvp.NameTokens;
import com.me.testproject.client.mvp.TestProjectGinInjector;
import com.me.testproject.client.presenter.HomePagePresenter.HomePageProxy;
import com.me.testproject.client.view.HomePageView;

public class HomePagePresenter extends SubContainerPresenterBase<HomePageView, HomePageProxy> {

	@Inject
	public HomePagePresenter(EventBus eventBus, HomePageView view, HomePageProxy proxy) {
		super(eventBus, view, proxy, TYPE_SetTabContent, TYPE_RequestTabs);
	}

	@ProxyCodeSplit
	public interface HomePageProxy extends TabContentProxy<HomePagePresenter> {

	}

	@TabInfo(container = MainPagePresenter.class, priority = 0, nameToken = NameTokens.HOME)
	static String getTabLabel(TestProjectGinInjector ginjector) {
		return ginjector.getTestProjectConstants().home();
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetMainContent, this);

	}

	@RequestTabs
	public static final Type<RequestTabsHandler> TYPE_RequestTabs = new Type<RequestTabsHandler>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SetTabContent = new Type<RevealContentHandler<?>>();
}
