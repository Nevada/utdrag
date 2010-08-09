package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Application for browsing the entities of the Expenses app.
 */
public class Scaffold implements EntryPoint {

	public void onModuleLoad() {

		/* Hide the loading message */
		Element loading = Document.get().getElementById("loading");
		loading.getParentElement().removeChild(loading);

		/* And show the user the shell */
	    Shell kjell = new Shell();
	    RootLayoutPanel.get().add(kjell);
		
	}

}
