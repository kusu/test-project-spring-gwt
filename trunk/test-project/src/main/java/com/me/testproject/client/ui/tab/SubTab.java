package com.me.testproject.client.ui.tab;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.TabData;

public class SubTab extends BaseTab {

	private static SubTabUiBinder uiBinder = GWT.create(SubTabUiBinder.class);

	interface SubTabUiBinder extends UiBinder<Widget, SubTab> {
	}

	@UiConstructor
	public SubTab(TabData tabData) {
		super(tabData);
		initWidget(uiBinder.createAndBindUi(this));
		setText(tabData.getLabel());
	}

}
