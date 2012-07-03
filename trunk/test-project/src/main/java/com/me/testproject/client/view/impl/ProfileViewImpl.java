package com.me.testproject.client.view.impl;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwtplatform.mvp.client.ViewImpl;
import com.me.testproject.client.view.ProfileView;
import com.me.testproject.client.view.components.NoDataWidget;
import com.me.testproject.shared.proxy.AddressProxy;
import com.me.testproject.shared.proxy.UserProxy;
import com.me.testproject.shared.utils.ClientFormatter;

public class ProfileViewImpl extends ViewImpl implements ProfileView {

	private final Widget widget;
	private final ProfileViewUiBinder uiBinder = GWT.create(ProfileViewUiBinder.class);
	private ProfileViewUiHandler uiHandler;

	@UiField(provided = true)
	CellTable<UserProxy> usersTable;

	@UiField
	TextBox userNameBox;
	@UiField
	TextBox passwordBox;
	@UiField
	TextBox country;
	@UiField
	TextBox city;
	@UiField
	Button update;

	final SingleSelectionModel<UserProxy> selectionModel = new SingleSelectionModel<UserProxy>();

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
				return ClientFormatter.formatDate(object.getCreated());
			}
		};
		Column<UserProxy, String> userName = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				userNameBox.setText(object.getUserName());
				return object.getUserName();
			}
		};
		Column<UserProxy, String> password = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				passwordBox.setText(object.getPassword());
				return object.getPassword();
			}
		};

		Column<UserProxy, String> address = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				city.setText(object.getAddress().getCity());
				country.setText(object.getAddress().getCountry());
				return object.getAddress().getCity() + ", " + object.getAddress().getCountry();
			}
		};

		Column<UserProxy, String> authority = new Column<UserProxy, String>(new TextCell()) {

			@Override
			public String getValue(UserProxy object) {
				return object.getAuthority();
			}
		};

		usersTable.addColumn(userId, "User Id");
		usersTable.addColumn(registerDate, "Register Date");
		usersTable.addColumn(userName, "Username");
		usersTable.addColumn(password, "Password");
		usersTable.addColumn(authority, "Authority");
		usersTable.addColumn(address, "Address");
		usersTable.setSelectionModel(selectionModel);
	}

	@UiHandler("update")
	public void onUpdateClicked(final ClickEvent e) {
		UserProxy proxy = selectionModel.getSelectedObject();
		UserProxy edit = uiHandler.getUserRequestContext().edit(proxy);
		edit.setUserName(userNameBox.getText());
		edit.setPassword(passwordBox.getText());
		edit.setAuthority("ROLE_USER");
		AddressProxy address = edit.getAddress();
		AddressProxy editAddress = uiHandler.getUserRequestContext().edit(address);
		editAddress.setCity(city.getText());
		editAddress.setCountry(country.getText());
		uiHandler.updateProfile(edit);
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
