package com.me.testproject.client.mvp;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class TestPlaceManager extends PlaceManagerImpl {

	private final PlaceRequest defaultPlaceRequest;

	@Inject
	public TestPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, @DefaultPlace String nameToken) {
		super(eventBus, tokenFormatter);
		defaultPlaceRequest = new PlaceRequest(nameToken);
	}

	@Override
	public void revealDefaultPlace() {
		revealPlace(defaultPlaceRequest);
	}
}
