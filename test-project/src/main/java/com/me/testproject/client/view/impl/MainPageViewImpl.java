package com.me.testproject.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.ViewImpl;
import com.me.testproject.client.presenter.MainPagePresenter;
import com.me.testproject.client.ui.tab.MainTabPanel;
import com.me.testproject.client.view.MainPageView;

public class MainPageViewImpl extends ViewImpl implements MainPageView {

	private static MainPageViewUiBinder uiBinder = GWT.create(MainPageViewUiBinder.class);

	private final Widget widget;

	@UiField
	MainTabPanel tabPanel;

	interface MainPageViewUiBinder extends UiBinder<Widget, MainPageViewImpl> {
	}

	@Inject
	public MainPageViewImpl() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return this.widget;
	}

	@Override
	public void showLoading(boolean shouldLock) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		return tabPanel.addTab(tabData, historyToken);
	}

	@Override
	public void removeTab(Tab tab) {
		tabPanel.removeTab(tab);
	}

	@Override
	public void removeTabs() {
		tabPanel.removeTabs();

	}

	@Override
	public void setActiveTab(Tab tab) {
		tabPanel.setActiveTab(tab);

	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetMainContent) {
			tabPanel.setPanelContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

}
