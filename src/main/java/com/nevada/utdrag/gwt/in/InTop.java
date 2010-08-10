package com.nevada.utdrag.gwt.in;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class InTop extends Composite {

	private static TopUiBinder uiBinder = GWT.create(TopUiBinder.class);

	private Listener listener;

	public interface Listener {
		void onInputClicked();
		void onGraphClicked();
		void onLogoutClicked();
	}

	interface TopUiBinder extends UiBinder<Widget, InTop> {
	}

	@UiField Anchor input;
	@UiField Anchor graph;
	@UiField Anchor logout;

	public InTop() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}
	
	@UiHandler("graph")
	void onGraphClicked(ClickEvent event) {
		if (listener != null) {
			listener.onGraphClicked();
		}
	}
	@UiHandler("input")
	void onInputClicked(ClickEvent event) {
		if (listener != null) {
			listener.onInputClicked();
		}
	}
	@UiHandler("logout")
	void onLogoutClicked(ClickEvent event) {
		if (listener != null) {
			listener.onLogoutClicked();
		}
	}

}
