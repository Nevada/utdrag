package com.nevada.utdrag.gwt.ui;

import com.google.gwt.app.place.AbstractActivity;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.app.place.RecordDetailsView;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.valuestore.shared.DeltaValueStore;
import com.google.gwt.valuestore.shared.SyncResult;
import com.google.gwt.valuestore.shared.Value;
import com.nevada.utdrag.gwt.request.RegularUserRecord;
import com.nevada.utdrag.gwt.request.ApplicationRequestFactory;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdrag.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdrag.gwt.scaffold.generated.RegularUserDetailsView;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace.Operation;

import java.util.Set;

/**
 * An {@link com.google.gwt.app.place.Activity Activity} that requests and
 * displays detailed information on a given RegularUser.
 */
public class RegularUserDetailsActivity extends AbstractActivity implements RecordDetailsView.Delegate {
	private static RecordDetailsView<RegularUserRecord> defaultView;
	
	private static RecordDetailsView<RegularUserRecord> getDefaultView() {
		if (defaultView == null) {
			defaultView = new RegularUserDetailsView();
		}
		return defaultView;
	}

	private final ApplicationRequestFactory requests;
	private final PlaceController<ApplicationPlace> placeController;
	private final RecordDetailsView<RegularUserRecord> view;
	private String id;
	private Display display;

	/**
	 * Creates an activity that uses the default singleton view instance.
	 */
	public RegularUserDetailsActivity(String id, ApplicationRequestFactory requests, PlaceController<ApplicationPlace> placeController) {
		this(id, requests, placeController, getDefaultView());
	}

	/**
	 * Creates an activity that uses its own view instance.
 	 */
	public RegularUserDetailsActivity(String id, ApplicationRequestFactory requests, PlaceController<ApplicationPlace> placeController, RecordDetailsView<RegularUserRecord> view) {
		this.placeController = placeController;
		this.id = id;
		this.requests = requests;
		view.setDelegate(this);
		this.view = view;
	}

	public void deleteClicked() {
		if (!view.confirm("Really delete this record? You cannot undo this change.")) {
			return;
		}
    
		DeltaValueStore deltas = requests.getValueStore().spawnDeltaView();
		deltas.delete(view.getValue());
		requests.syncRequest(deltas).to(new Receiver<Set<SyncResult>>() {
			public void onSuccess(Set<SyncResult> response) {
				if (display == null) {
					// This activity is dead
					return;
				}
				display.showActivityWidget(null);
			}
		}).fire();
	}

	public void editClicked() {
		placeController.goTo(new RegularUserScaffoldPlace(view.getValue(), Operation.EDIT));
	}

	public void onCancel() {
		onStop();
	}

	public void onStop() {
		display = null;
	}

	public void start(final Display display) {
    	this.display = display;
    	Receiver<RegularUserRecord> callback = new Receiver<RegularUserRecord>() {
			public void onSuccess(RegularUserRecord record) {
				view.setValue(record);
				display.showActivityWidget(view);
			}
		};

		requests.regularUserRequest().findRegularUser(Value.of(id)).to(callback).fire();
	}
}
