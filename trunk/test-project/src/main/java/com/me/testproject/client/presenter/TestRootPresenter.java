package com.me.testproject.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.RootPresenter;

public class TestRootPresenter extends RootPresenter {

	@Inject
	public TestRootPresenter(EventBus eventBus, TestRootView view) {
		super(eventBus, view);
	}

	public static final class TestRootView extends RootView {
		@Override
		public void setInSlot(Object slot, Widget content) {
			RootPanel.get("gwt").add(content);

		}
	}
}
