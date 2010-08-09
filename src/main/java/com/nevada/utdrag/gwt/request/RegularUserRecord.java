package com.nevada.utdrag.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdrag.RegularUser;
import com.google.gwt.requestfactory.shared.DataTransferObject;

@RooGwtMirroredFrom(RegularUser.class)
@DataTransferObject(RegularUser.class)
public interface RegularUserRecord extends Record {

    public String TOKEN = "RegularUserRecord";
}
