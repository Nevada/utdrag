package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.nevada.utdrag.gwt.out.Top.Listener;

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

		top.setListener(new Top.Listener() {
			public void onLogoClicked() {
				main.showWidget(VIDEO);
			}
			public void onHowClicked() {
				main.showWidget(HOW);
			}
			public void onBloggClicked() {
				main.showWidget(BLOGG);
			}
			public void onPolicyClicked() {
				main.showWidget(POLICY);
			}
			public void onAboutClicked() {
				main.showWidget(ABOUT);
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
