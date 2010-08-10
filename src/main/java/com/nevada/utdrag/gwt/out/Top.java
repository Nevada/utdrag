package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class Top extends Composite {

	private static TopUiBinder uiBinder = GWT.create(TopUiBinder.class);

	private Listener listener;

	public interface Listener {
		void onHowClicked();
		void onBloggClicked();
		void onPolicyClicked();
		void onAboutClicked();
		void onLogoClicked();
	}

	interface TopUiBinder extends UiBinder<Widget, Top> {
	}

	@UiField Anchor logo;
	@UiField Anchor how;
	@UiField Anchor blogg;
	@UiField Anchor policy;
	@UiField Anchor about;

	public Top() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}
	@UiHandler("logo")
	void onLogoClicked(ClickEvent event) {
		if (listener != null) {
			listener.onLogoClicked();
		}
	}
	@UiHandler("how")
	void onHowClicked(ClickEvent event) {
		if (listener != null) {
			listener.onHowClicked();
		}
	}
	@UiHandler("blogg")
	void onBloggClicked(ClickEvent event) {
		if (listener != null) {
			listener.onBloggClicked();
		}
	}
	@UiHandler("policy")
	void onPolicyClicked(ClickEvent event) {
		if (listener != null) {
			listener.onPolicyClicked();
		}
	}
	@UiHandler("about")
	void onAboutClicked(ClickEvent event) {
		if (listener != null) {
			listener.onAboutClicked();
		}
	}



}
