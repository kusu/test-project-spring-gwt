package com.f1soft.testproject.client.ui.tab;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.TabData;

public class MainTab extends BaseTab {

	private static MainTabUiBinder uiBinder = GWT.create(MainTabUiBinder.class);

	interface MainTabUiBinder extends UiBinder<Widget, MainTab> {
	}

	@UiConstructor
	public MainTab(TabData tabData) {
		super(tabData);
		initWidget(uiBinder.createAndBindUi(this));
		setText(tabData.getLabel());
	}
}
