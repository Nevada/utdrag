package com.nevada.utdrag.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdrag.RegularUser;
import com.google.gwt.requestfactory.shared.DataTransferObject;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(RegularUser.class)
@DataTransferObject(RegularUser.class)
public interface RegularUserRecord extends Record {

    public String TOKEN = "RegularUserRecord";

    Property<java.lang.String> email = new com.google.gwt.valuestore.shared.Property<java.lang.String>("email", "Email", java.lang.String.class);

    Property<java.lang.String> name = new com.google.gwt.valuestore.shared.Property<java.lang.String>("name", "Name", java.lang.String.class);

    Property<java.lang.String> pw = new com.google.gwt.valuestore.shared.Property<java.lang.String>("pw", "Pw", java.lang.String.class);

    abstract String getEmail();

    abstract String getName();

    abstract String getPw();
}
