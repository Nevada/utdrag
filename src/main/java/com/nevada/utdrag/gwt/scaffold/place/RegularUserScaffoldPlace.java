package com.nevada.utdrag.gwt.scaffold.place;

import com.nevada.utdrag.gwt.request.RegularUserRecord;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationPlaceProcessor;
import com.nevada.utdrag.gwt.scaffold.place.ApplicationRecordPlace;

/**
 * A place in the scaffold app for working with an RegularUserRecord.
 */
public class RegularUserScaffoldPlace extends ApplicationRecordPlace {

	public RegularUserScaffoldPlace(RegularUserRecord record, Operation operation) {
		super(record.getId(), operation);
	}

	public RegularUserScaffoldPlace(String id, Operation operation) {
		super(id, operation);
	}

	@Override
	public void accept(ApplicationPlaceProcessor visitor) {
		visitor.process(this);
	}

	@Override
	public <T> T acceptFilter(ApplicationPlaceFilter<T> filter) {
		return filter.filter(this);
	}
}
