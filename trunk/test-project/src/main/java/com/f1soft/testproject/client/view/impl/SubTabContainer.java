package com.f1soft.testproject.client.view.impl;

import com.f1soft.testproject.client.ui.tab.SubTabPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.ViewImpl;

public class SubTabContainer extends ViewImpl implements TabView {

	private static SubTabContainerUiBinder uiBinder = GWT.create(SubTabContainerUiBinder.class);

	interface SubTabContainerUiBinder extends UiBinder<Widget, SubTabContainer> {
	}

	@UiField
	public SubTabPanel tabPanel;

	private final Widget widget;

	public SubTabContainer() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
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

}
