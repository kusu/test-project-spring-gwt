package com.f1soft.testproject.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class AbstractMainPagePresenter<V extends AbstractMainPagePresenter.MainView, Proxy_ extends Proxy<?>> extends TabContainerPresenter<V, Proxy_> {

	public AbstractMainPagePresenter(EventBus eventBus, V view, Proxy_ proxy) {
		super(eventBus, view, proxy, TYPE_SetMainContent, TYPE_RequestTabs);		
	}

	public interface MainView extends TabView {
		void showLoading(boolean shouldLock);

	}
	
	@RequestTabs
	public static final Type<RequestTabsHandler> TYPE_RequestTabs = new Type<RequestTabsHandler>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SetMainContent = new Type<RevealContentHandler<?>>();

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
		
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();		
	}
}
