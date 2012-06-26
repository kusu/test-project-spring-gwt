package com.f1soft.testproject.client.dataproviders;

import java.util.List;

import com.f1soft.testproject.shared.proxy.UserProxy;
import com.f1soft.testproject.shared.request.UserRequest;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class UsersTableDataProvider extends AbstractDataProvider<UserProxy> {

	private final Provider<UserRequest> userRequestProvider;

	@Inject
	public UsersTableDataProvider(Provider<UserRequest> userRequestProvider) {
		this.userRequestProvider = userRequestProvider;
	}

	@Override
	protected void onRangeChanged(HasData<UserProxy> display) {
		userRequestProvider.get().getAllUsers().fire(new Receiver<List<UserProxy>>() {

			@Override
			public void onSuccess(List<UserProxy> result) {
				updateRowCount(result.size(), true);
				updateRowData(0, result);
			}
		});

	}

}
