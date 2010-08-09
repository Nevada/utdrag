package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.utdrag.gwt.request.ApplicationRequestFactory;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.utdrag.gwt.ui.RegularUserActivitiesMapper;
import com.nevada.utdrag.gwt.scaffold.place.RegularUserScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace}.
 */
public final class ScaffoldMobileActivities implements ActivityMapper<ApplicationPlace> {
	private final ActivityMapper<ApplicationListPlace> listActivitiesBuilder;
	private final ActivityMapper<RegularUserScaffoldPlace> regularUserActivitiesBuilder;

	/**
	 * @param listActivitiesBuilder
	 * @param requestFactory
	 * @param placeController
	 */
	public ScaffoldMobileActivities(ActivityMapper<ApplicationListPlace> listActivitiesBuilder, ApplicationRequestFactory requestFactory, PlaceController<ApplicationPlace> placeController) {
    	this.listActivitiesBuilder = listActivitiesBuilder;
		this.regularUserActivitiesBuilder = new RegularUserActivitiesMapper(
		requestFactory, placeController); 
	}

	public Activity getActivity(ApplicationPlace place) {
		return place.acceptFilter(new ApplicationPlaceFilter<Activity>() {
			public Activity filter(RegularUserScaffoldPlace place) {
				return regularUserActivitiesBuilder.getActivity(place);
			}
			public Activity filter(ApplicationListPlace place) {
				return listActivitiesBuilder.getActivity(place);
			}
		});
	}
}
