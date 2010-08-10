package com.nevada.utdrag.gwt.scaffold.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Blogg extends Composite {

	private static BloggUiBinder uiBinder = GWT.create(BloggUiBinder.class);

	interface BloggUiBinder extends UiBinder<Widget, Blogg> {
	}

	public Blogg() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
