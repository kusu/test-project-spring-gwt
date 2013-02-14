package com.me.testproject.client.dataproviders;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.me.testproject.shared.proxy.UserProxy;
import com.me.testproject.shared.request.UserRequestContext;

public class UsersTableDataProvider extends AbstractDataProvider<UserProxy> {

	private final Provider<UserRequestContext> userRequestProvider;

	@Inject
	public UsersTableDataProvider(Provider<UserRequestContext> userRequestProvider) {
		this.userRequestProvider = userRequestProvider;
	}

	@Override
	protected void onRangeChanged(HasData<UserProxy> display) {
		UserRequestContext userRequest = userRequestProvider.get();
		userRequest.getAllUsers().with("address").fire(new Receiver<List<UserProxy>>() {

			@Override
			public void onSuccess(List<UserProxy> result) {
				updateRowCount(result.size(), true);
				updateRowData(0, result);
			}

			@Override
			public void onFailure(ServerFailure caught) {
				Window.alert(caught.getMessage());
			}

		});

	}
}
