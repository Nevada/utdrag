package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class How extends Composite {

	private static HowUiBinder uiBinder = GWT.create(HowUiBinder.class);

	interface HowUiBinder extends UiBinder<Widget, How> {
	}

	public How() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
