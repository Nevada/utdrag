package com.nevada.utdrag.gwt.scaffold.generated;

import com.google.gwt.app.client.DoubleBox;
import com.google.gwt.app.client.EditorSupport;
import com.google.gwt.app.client.IntegerBox;
import com.google.gwt.app.client.LongBox;
import com.google.gwt.app.place.RecordEditView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.valuestore.shared.DeltaValueStore;
import com.google.gwt.valuestore.shared.Property;

import com.nevada.utdrag.gwt.request.RegularUserRecord;
import java.util.Map;
import java.util.Set;

/**
 * Edit view for RegularUser records.
 */
public class RegularUserEditView extends Composite implements RecordEditView<RegularUserRecord> {
	interface Binder extends UiBinder<HTMLPanel, RegularUserEditView> {
	}

	interface DataBinder extends EditorSupport<RegularUserRecord, RegularUserEditView> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private static final DataBinder DATA_BINDER = GWT.create(DataBinder.class);

	@UiField TextBox email;
	@UiField TextBox name;
	@UiField TextBox pw;
	@UiField Button cancel;
	@UiField Button save;
	@UiField InlineLabel id;
	@UiField InlineLabel version;
	@UiField DivElement errors;

	@UiField Element editTitle;
	@UiField Element createTitle;

	private Delegate delegate;
	private DeltaValueStore deltas;

	private RegularUserRecord record;

	public RegularUserEditView() {
		initWidget(BINDER.createAndBindUi(this));
		DATA_BINDER.init(this);
	}

	public RegularUserEditView asWidget() {
		return this;
	}	

	public DeltaValueStore getDeltaValueStore() {
		return deltas;
	}

	public Set<Property<?>> getProperties() {
		return DATA_BINDER.getProperties();
	}

	public RegularUserRecord getValue() {
		return record;
	}

	public boolean isChanged() {
		return DATA_BINDER.isChanged(this);
	}

	public void setCreating(boolean creating) {
		if (creating) {
			editTitle.getStyle().setDisplay(Display.NONE);
			createTitle.getStyle().clearDisplay();
		} else {
			editTitle.getStyle().clearDisplay();
			createTitle.getStyle().setDisplay(Display.NONE);
		}
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	public void setDeltaValueStore(DeltaValueStore deltas) {
		this.deltas = deltas;
	}

	public void setEnabled(boolean enabled) {
		DATA_BINDER.setEnabled(this, enabled);
		save.setEnabled(enabled);
	}

	public void setValue(RegularUserRecord value) {
		this.record = value;
		DATA_BINDER.setValue(this, value);
	}

	public void showErrors(Map<String, String> errorMap) {
		DATA_BINDER.showErrors(this, errorMap);
	}

	@UiHandler("cancel")
	void onCancel(@SuppressWarnings("unused") ClickEvent event) {
		delegate.cancelClicked();
	}

	@UiHandler("save")
	void onSave(@SuppressWarnings("unused") ClickEvent event) {
		delegate.saveClicked();
	}
}
