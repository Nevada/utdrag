package com.nevada.utdrag.gwt.ui;

import com.google.gwt.app.place.AbstractRecordListActivity;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.app.place.RecordListView;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.view.client.Range;

import com.nevada.utdrag.gwt.request.RegularUserRecord;
import com.nevada.utdrag.gwt.request.ApplicationRequestFactory;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.utdrag.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdrag.gwt.scaffold.generated.RegularUserListView;
import com.nevada.utdrag.gwt.request.RegularUserRecordChanged;
import com.nevada.utdrag.gwt.request.RegularUserChangedHandler;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace.Operation;

/**
 * Activity that requests and displays all {RegularUserRecord}
 * records.
 */
public class RegularUserListActivity extends AbstractRecordListActivity<RegularUserRecord> {
	private static RecordListView<RegularUserRecord> defaultView;

	private static RecordListView<RegularUserRecord> getDefaultView() {
		if (defaultView == null) {
			defaultView = new RegularUserListView();
		}
		return defaultView;
	}

	private final ApplicationRequestFactory requests;
	private final PlaceController<ApplicationPlace> placeController;
	private final HandlerManager eventBus;
	private HandlerRegistration registration;

	/**
	 * Creates an activity that uses the default singleton view instance.
 	 */
	public RegularUserListActivity(HandlerManager eventBus, ApplicationRequestFactory requests, PlaceController<ApplicationPlace> placeController) {
		this(eventBus, requests, getDefaultView(), placeController);
	}

	/**
	 * Creates an activity that uses its own view instance.
	 */
	public RegularUserListActivity(HandlerManager eventBus, ApplicationRequestFactory requests, RecordListView<RegularUserRecord> view, PlaceController<ApplicationPlace> placeController) {
		super(view);
		this.eventBus = eventBus;
		this.requests = requests;
		this.placeController = placeController;
	}

	public void createClicked() {
		placeController.goTo(new RegularUserScaffoldPlace("", Operation.EDIT));
	}

	public void onStop() {
		registration.removeHandler();
	}

	public void showDetails(RegularUserRecord record) {
		placeController.goTo(new RegularUserScaffoldPlace(record, Operation.DETAILS));
	}

	public void start(Display display) {
		this.registration = eventBus.addHandler(RegularUserRecordChanged.TYPE, new RegularUserChangedHandler() {
			public void onRegularUserChanged(RegularUserRecordChanged event) {
				update(event.getWriteOperation(), event.getRecord());
			}
		});
		super.start(display);
	}

	protected RecordListRequest<RegularUserRecord> createRangeRequest(Range range) {
		return requests.regularUserRequest().findRegularUserEntries(range.getStart(), range.getLength());
	}

	protected void fireCountRequest(Receiver<Long> callback) {
		requests.regularUserRequest().countRegularUsers().to(callback).fire();
	}
}
