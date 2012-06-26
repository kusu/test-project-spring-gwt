package com.f1soft.testproject.client.ui.tab;

import com.google.gwt.uibinder.client.UiField;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.ViewImpl;

public abstract class BaseTabContainer extends ViewImpl implements TabView {

	@UiField
	public BaseTabPanel tabPanel;

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
