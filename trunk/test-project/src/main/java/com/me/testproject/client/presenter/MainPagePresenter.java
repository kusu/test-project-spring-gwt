package com.me.testproject.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.me.testproject.client.view.MainPageView;

public class MainPagePresenter extends AbstractMainPagePresenter<MainPageView, MainPagePresenter.MainProxy> {

	@Inject
	public MainPagePresenter(EventBus eventBus, MainPageView view, MainProxy proxy) {
		super(eventBus, view, proxy);

	}

	@ProxyStandard
	public interface MainProxy extends Proxy<MainPagePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

}
