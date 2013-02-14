package com.me.testproject.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabPanel;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.TabContentProxy;

public class SubContainerPresenterBase<V extends View & TabPanel, P extends TabContentProxy<?>> extends TabContainerPresenter<V, P> {

	@Inject
	public SubContainerPresenterBase(EventBus eventBus, V view, P proxy, Type<RevealContentHandler<?>> setTabContent, Type<RequestTabsHandler> requestTabs) {
		super(eventBus, view, proxy, setTabContent, requestTabs);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetMainContent, this);

	}

	@Override
	protected void onReset() {
		super.onReset();
		setHeaderText();
	}

	protected void setHeaderText() {
	}
}
