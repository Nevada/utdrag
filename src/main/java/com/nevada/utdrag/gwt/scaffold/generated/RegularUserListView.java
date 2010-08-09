package com.nevada.utdrag.gwt.scaffold.generated;

import com.google.gwt.app.place.AbstractRecordListView;
import com.google.gwt.app.place.PropertyColumn;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.nevada.utdrag.gwt.request.RegularUserRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link AbstractRecordListView} specialized to {@link RegularUserKey}} values.
 */
public class RegularUserListView extends AbstractRecordListView<RegularUserRecord> {
	interface Binder extends UiBinder<HTMLPanel, RegularUserListView> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);

	@UiField CellTable<RegularUserRecord> table;
	@UiField Button newButton;
  
	public RegularUserListView() {
		init(BINDER.createAndBindUi(this), table, newButton, getColumns());
	}

	protected List<PropertyColumn<RegularUserRecord, ?>> getColumns() {
		// TODO These should be <g:col> elements in a <g:table> in the ui.xml file

		List<PropertyColumn<RegularUserRecord, ?>> columns = new ArrayList<PropertyColumn<RegularUserRecord, ?>>();
		return columns;
	}
}
