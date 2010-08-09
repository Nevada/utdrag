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

public class App extends Composite {

	private static AppUiBinder uiBinder = GWT.create(AppUiBinder.class);

	interface AppUiBinder extends UiBinder<Widget, App> {
	}

//	@UiField DeckPanel main;
//	OutShell os = new OutShell(); // döp om till Out
//	InShell is = new InShell(); // döp om till In
	@UiField Button showData;
	
	private Listener listener;
	
	public interface Listener {
		void onDataClicked();
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	
//	final int OUT = 0;
//	final int IN = 1;
	
	public App() {
		initWidget(uiBinder.createAndBindUi(this));

//		os.login.setListener(new Login.Listener() {
//			public void onLoginClicked(String user) {
//				main.showWidget(IN);
//				is.setUser(user);
//			}
//		});
//		
//		is.top.setListener(new InTop.Listener() {
//			public void onLogoutClicked() {
//				main.showWidget(OUT);
//			}
//			public void onGraphClicked() {
//			}
//			public void onInputClicked() {				
//			}
//		});
//
//		main.add(os);
//		main.add(is);
//		main.setAnimationEnabled(false);
//		main.showWidget(OUT);
	}

	@UiHandler("showData")
	void onShowDataClicked(ClickEvent event) {
		listener.onDataClicked();
	}
}
