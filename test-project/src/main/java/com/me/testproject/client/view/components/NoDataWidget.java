package com.me.testproject.client.view.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;

public class NoDataWidget extends Composite {

	private static NoDataWidgetUiBinder uiBinder = GWT.create(NoDataWidgetUiBinder.class);

	interface NoDataWidgetUiBinder extends UiBinder<Widget, NoDataWidget> {
	}

	@UiField
	InlineHTML label;

	public NoDataWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setNoDataLabel(String text) {
		label.setText(text);
	}

}
