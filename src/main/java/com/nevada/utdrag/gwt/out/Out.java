package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class Out extends Composite {

	private static VerticalShellUiBinder uiBinder = GWT
	.create(VerticalShellUiBinder.class);

	interface VerticalShellUiBinder extends UiBinder<Widget, Out> {
	}

	@UiField DeckPanel main;
	@UiField Top top;
	public @UiField Login login;
	@UiField ScrollPanel scroller;

	final int VIDEO = 0;
	final int HOW = 1;
	final int BLOGG= 2;
	final int POLICY = 3;
	final int ABOUT = 4;

	public Out() {
		initWidget(uiBinder.createAndBindUi(this));

		//scroller.setAlwaysShowScrollBars(true);

		History.newItem("home");

		top.setListener(new Top.Listener() {
			public void onLogoClicked() {
				History.newItem("home");
			}
			public void onHowClicked() {
				History.newItem("how");
			}
			public void onBloggClicked() {
				History.newItem("blogg");
			}
			public void onPolicyClicked() {
				History.newItem("policy");
			}
			public void onAboutClicked() {
				History.newItem("about");
			}
		});

		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();
				
				if(historyToken.equals("home")) {
					main.showWidget(VIDEO);
				}
				else if(historyToken.equals("how")) {
					main.showWidget(HOW);
				} 
				else if (historyToken.equals("blogg")) {
					main.showWidget(BLOGG);
				} 
				else if (historyToken.equals("policy")) {
					main.showWidget(POLICY);
				}
				else if (historyToken.equals("about")) {
					main.showWidget(ABOUT);
				}
				else {
					main.showWidget(VIDEO);
				}
			}
		});
		
		Video v = new Video();
		How h = new How();
		Blogg b = new Blogg();
		Policy p = new Policy();
		About a = new About();
		main.add(v);
		main.add(h);
		main.add(b);
		main.add(p);
		main.add(a);

		main.setAnimationEnabled(false);
		main.showWidget(VIDEO);
	}

}
