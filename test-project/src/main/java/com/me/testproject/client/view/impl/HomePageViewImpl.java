package com.me.testproject.client.view.impl;

import com.google.gwt.user.client.ui.Widget;
import com.me.testproject.client.presenter.HomePagePresenter;
import com.me.testproject.client.view.HomePageView;

public class HomePageViewImpl extends SubTabContainer implements HomePageView {

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == HomePagePresenter.TYPE_SetTabContent) {
			tabPanel.setPanelContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

}
