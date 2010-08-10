package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Policy extends Composite {

	private static PolicyUiBinder uiBinder = GWT.create(PolicyUiBinder.class);

	interface PolicyUiBinder extends UiBinder<Widget, Policy> {
	}

	public Policy() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
