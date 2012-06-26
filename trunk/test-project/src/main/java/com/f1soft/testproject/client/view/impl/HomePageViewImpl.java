package com.f1soft.testproject.client.view.impl;

import com.f1soft.testproject.client.presenter.HomePagePresenter;
import com.f1soft.testproject.client.view.HomePageView;
import com.google.gwt.user.client.ui.Widget;

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
