package com.f1soft.testproject.client.view.impl;

import com.f1soft.testproject.client.view.ProfileView;
import com.f1soft.testproject.client.view.components.NoDataWidget;
import com.f1soft.testproject.shared.proxy.UserProxy;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.gwtplatform.mvp.client.ViewImpl;

public class ProfileViewImpl extends ViewImpl implements ProfileView {

	private final Widget widget;
	private final ProfileViewUiBinder uiBinder = GWT.create(ProfileViewUiBinder.class);
	private ProfileViewUiHandler uiHandler;

	@UiField(provided = true)
	CellTable<UserProxy> usersTable;

	interface ProfileViewUiBinder extends UiBinder<Widget, ProfileViewImpl> {

	}

	public ProfileViewImpl() {
		usersTable = new CellTable<UserProxy>();
		NoDataWidget noData = new NoDataWidget();
		noData.setNoDataLabel("There are no active users.");
		usersTable.setEmptyTableWidget(noData);
		widget = uiBinder.createAndBindUi(this);
		initUsersTable();
	}

	private void initUsersTable() {
		Column<UserProxy, String> userId = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				return String.valueOf(object.getId());
			}
		};
		Column<UserProxy, String> registerDate = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				return object.getCreated().toString();
			}
		};
		Column<UserProxy, String> userName = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				return object.getUserName();
			}
		};
		Column<UserProxy, String> password = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				return object.getPassword();
			}
		};

		usersTable.addColumn(userId, "User Id");
		usersTable.addColumn(registerDate, "Register Date");
		usersTable.addColumn(userName, "Username");
		usersTable.addColumn(password, "Password");
	}

	@Override
	public Widget asWidget() {
		return this.widget;
	}

	@Override
	public void setUiHandlers(ProfileViewUiHandler uiHandlers) {
		this.uiHandler = uiHandlers;

	}

	@Override
	public HasData<UserProxy> getDisplay() {
		return this.usersTable;
	}

}
