package com.nevada.utdrag.gwt.scaffold.place;

/**
 * A convenient base implementation of {@link ApplicationPlaceFilter}. Just
 * override the methods for the types of places that you actually care about.
 * <p>
 * <strong>NB</strong>It is a bad idea to use this class if your code needs to
 * be extended when new subclasses of {@link ApplicationPlace} are added. If that's
 * the case, implement {@link ApplicationPlaceFilter} yourself, so that the
 * compiler will let you know to update your code.
 * 
 * @param <T> the type of the default value
 */
public class BasePlaceFilter<T> implements ApplicationPlaceFilter<T> {
	private final T defaultValue;
  
	public BasePlaceFilter(T defaultValue) {
		this.defaultValue = defaultValue;
	}
	public T filter(RegularUserScaffoldPlace place) {
		return defaultValue;
	}
	public T filter(ApplicationListPlace place) {
		return defaultValue;
	}
}
