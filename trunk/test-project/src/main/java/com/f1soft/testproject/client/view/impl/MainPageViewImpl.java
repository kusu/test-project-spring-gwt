package com.f1soft.testproject.client.view.impl;

import com.f1soft.testproject.client.view.MainPageView;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainPageViewImpl extends ViewImpl implements MainPageView {

	private  Widget widget;
	
	public MainPageViewImpl() {
		
	}
	
	@Override
	public Widget asWidget() {
		return this.widget;
	}

}
