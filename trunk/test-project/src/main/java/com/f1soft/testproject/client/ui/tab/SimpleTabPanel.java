package com.f1soft.testproject.client.ui.tab;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.TabData;

public class SimpleTabPanel extends BaseTabPanel implements HasWidgets {

	private static SimpleTabPanelUiBinder uiBinder = GWT.create(SimpleTabPanelUiBinder.class);

	interface SimpleTabPanelUiBinder extends UiBinder<Widget, SimpleTabPanel> {
	}

	@UiField
	FlowPanel childContainer;

	public SimpleTabPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	protected BaseTab createNewTab(TabData tabData) {
		return new SubTab(tabData);
	}

	@Override
	public void add(Widget w) {
		childContainer.add(w);

	}

	@Override
	public void clear() {
		childContainer.clear();

	}

	@Override
	public Iterator<Widget> iterator() {
		return childContainer.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return childContainer.remove(w);
	}

}
