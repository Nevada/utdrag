package com.nevada.utdrag.gwt.scaffold.place;

/**
 * Implemented by objects that filter {@link ApplicationPlace subtypes to other objects.
 * 
 * @param <T> the type to filter to 
 */
public interface ApplicationPlaceFilter<T> {
	T filter(ApplicationListPlace place);
	T filter(RegularUserScaffoldPlace place);
}
