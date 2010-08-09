package com.nevada.utdrag.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdrag.RegularUser;
import com.nevada.utdrag.gwt.request.RegularUserRecordChanged;

@RooGwtMirroredFrom(RegularUser.class)
public interface RegularUserChangedHandler extends EventHandler {

    abstract void onRegularUserChanged(RegularUserRecordChanged event);
}
