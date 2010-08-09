package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.utdrag.gwt.request.ApplicationRequestFactory;
import com.nevada.utdrag.gwt.scaffold.place.BasePlaceFilter;
import com.nevada.utdrag.gwt.ui.RegularUserActivitiesMapper;
import com.nevada.utdrag.gwt.scaffold.place.RegularUserScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace} in the bottom
 * half of the {@link Data}.
 */
public final class ScaffoldDetailsActivities implements ActivityMapper<ApplicationPlace> {
	private final ActivityMapper<RegularUserScaffoldPlace> regularUserActivities;
	
	public ScaffoldDetailsActivities(ApplicationRequestFactory requestFactory, PlaceController<ApplicationPlace> placeController) {
		this.regularUserActivities = new RegularUserActivitiesMapper(requestFactory, placeController); 
	}

	public Activity getActivity(ApplicationPlace place) {
		return place.acceptFilter(new BasePlaceFilter<Activity>(null) {
			public Activity filter(RegularUserScaffoldPlace place) {
				return regularUserActivities.getActivity(place);
			}
		});
	}
}
