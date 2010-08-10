package com.nevada.utdrag.gwt.images;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Images used by the entire application.
 */
public interface Resources extends ClientBundle {

  @Source("sites.png")
  ImageResource sites();
  
  @Source("front_logo.png")
  ImageResource logo();

}
