package com.nevada.utdrag.gwt.in;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class In extends Composite {

	private static VerticalShellUiBinder uiBinder = GWT
	.create(VerticalShellUiBinder.class);

	interface VerticalShellUiBinder extends UiBinder<Widget, In> {
	}

	public @UiField InTop top;
	@UiField Label userLabel;
	
	String user;
	
	public In() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
		this.userLabel.setText("Välkommen, "+user+".");
	}
	
	
	
}
