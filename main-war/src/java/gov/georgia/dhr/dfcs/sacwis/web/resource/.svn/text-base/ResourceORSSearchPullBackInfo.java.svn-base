package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- grnds classes --

import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.PullBackInfo;

/**
 * This is the interface class used to populate the search bean and set the return URL for resourlce search pull back
 * functionlity.
 *
 * @author Sanjay Rana, November 26, 2002
 */
public class ResourceORSSearchPullBackInfo extends ResourceORSSearchValueBean implements PullBackInfo {

  /** Null Constructor */
  public ResourceORSSearchPullBackInfo() {
    super();
  }

  /**
   * Set the Destination Url
   *
   * @ param String The URL String
   */
  public void setDestinationUrl(String url) {
    this.CALLING_URL = url;
  }

  /**
   * Get the Destination Url
   *
   * @ return String The URL String
   */
  public String getDestinationUrl() {
    return CALLING_URL;
  }

  // static constants
  private static String CALLING_URL = null;
  public static final String TRACE_TAG = "ResourceORSSearchPullBackInfo";
  public static final String RESOURCE_PULLBACK_REQUEST = "resourceORSPullBackAttribute";
  public static final String PULLBACK_URL = "/resource/ResourceORSSearch/pullBackResource";
}