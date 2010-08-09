package com.nevada.utdrag.gwt.scaffold.place;

import com.google.gwt.valuestore.shared.Record;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdrag.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdrag.gwt.request.RegularUserRecord;

/**
 * Filters an {@link ApplicationPlace} to the corresponding record type.
 */
public final class ApplicationPlaceToRecordType implements ApplicationPlaceFilter<Class<? extends Record>> {

	public Class<? extends Record> filter(RegularUserScaffoldPlace place) {
		return RegularUserRecord.class;
	}

	public Class<? extends Record> filter(ApplicationListPlace place) {
		return place.getType();
	}
}