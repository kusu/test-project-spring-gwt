package com.f1soft.testproject.client.view;

import com.f1soft.testproject.client.view.ProfileView.ProfileViewUiHandler;
import com.f1soft.testproject.shared.proxy.UserProxy;
import com.google.gwt.view.client.HasData;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.View;

public interface ProfileView extends View, HasUiHandlers<ProfileViewUiHandler> {

	public interface ProfileViewUiHandler extends UiHandlers {

	}

	HasData<UserProxy> getDisplay();
}
