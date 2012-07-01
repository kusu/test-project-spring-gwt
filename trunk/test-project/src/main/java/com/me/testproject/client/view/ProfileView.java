package com.me.testproject.client.view;

import com.google.gwt.view.client.HasData;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.View;
import com.me.testproject.client.view.ProfileView.ProfileViewUiHandler;
import com.me.testproject.shared.proxy.UserProxy;

public interface ProfileView extends View, HasUiHandlers<ProfileViewUiHandler> {

	public interface ProfileViewUiHandler extends UiHandlers {

	}

	HasData<UserProxy> getDisplay();
}
