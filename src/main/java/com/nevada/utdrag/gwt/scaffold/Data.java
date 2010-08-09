package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.app.client.NotificationMole;
import com.google.gwt.app.place.PlacePickerView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.nevada.utdrag.gwt.scaffold.App.Listener;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationListPlace;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The outermost UI of the application.
 */
public class Data extends Composite {
	interface Binder extends UiBinder<Widget, Data> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);

	@UiField SimplePanel master;
	@UiField SimplePanel details;
	@UiField PlacePickerView<ApplicationListPlace> placesBox;
	@UiField DivElement error;
	@UiField NotificationMole mole;
	@UiField Button showApp;
	
	private Listener listener;
	
	public interface Listener {
		void onAppClicked();
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	
	public Data() {
		initWidget(BINDER.createAndBindUi(this));
	}

	/**
	 * @return the panel to hold the details
	 */
	public SimplePanel getDetailsPanel() {
		return details;
	}

	/**
	 * @return the panel to hold the master list
	 */
	public SimplePanel getMasterPanel() {
		return master;
	}

	/**
	 * @return the notification mole for loading feedback
	 */
	public NotificationMole getMole() {
		return mole;
	}

	/**
	 * @return the navigator
	 */
	public PlacePickerView<ApplicationListPlace> getPlacesBox() {
		return placesBox;
	}

	/**
	 * @param string
	 */
	public void setError(String string) {
		error.setInnerText(string);
	}
	
	@UiHandler("showApp")
	void onShowAppClicked(ClickEvent event) {
		listener.onAppClicked();
	}
}
