package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.nevada.utdrag.gwt.in.In;
import com.nevada.utdrag.gwt.in.InTop;
import com.nevada.utdrag.gwt.out.Login;
import com.nevada.utdrag.gwt.out.Out;

public class App extends Composite {

	private static AppUiBinder uiBinder = GWT.create(AppUiBinder.class);

	interface AppUiBinder extends UiBinder<Widget, App> {
	}

	@UiField Button showData;
	@UiField DeckPanel main;
	Out out = new Out();
	In in = new In();
	
	private Listener listener;
	
	public interface Listener {
		void onDataClicked();
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	
	final int OUT = 0;
	final int IN = 1;
	
	public App() {
		initWidget(uiBinder.createAndBindUi(this));

		out.login.setListener(new Login.Listener() {
			public void onLoginClicked(String user) {
				main.showWidget(IN);
				in.setUser(user);
			}
		});
		
		in.top.setListener(new InTop.Listener() {
			public void onLogoutClicked() {
				main.showWidget(OUT);
			}
			public void onGraphClicked() {
			}
			public void onInputClicked() {				
			}
		});

		main.add(out);
		main.add(in);
		main.setAnimationEnabled(false);
		main.showWidget(OUT);
	}

	@UiHandler("showData")
	void onShowDataClicked(ClickEvent event) {
		listener.onDataClicked();
	}
}
