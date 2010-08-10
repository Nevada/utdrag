package com.nevada.utdrag.gwt.out;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Video extends Composite {

	private static VideoUiBinder uiBinder = GWT.create(VideoUiBinder.class);

	interface VideoUiBinder extends UiBinder<Widget, Video> {
	}

	public Video() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
