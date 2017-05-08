package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- grnds classes --

import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.PullBackInfo;

/**
 * This is the interface class used to populate the search bean and set the return URL for resourlce search pull back
 * functionlity.
 *
 * @author Sanjay Rana, November 26, 2002
 */
public class ResourceSearchPullBackInfo extends ResourceSearchValueBean implements PullBackInfo {

  /** Null Constructor */
  public ResourceSearchPullBackInfo() {
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
  
  public boolean isFullSerach() {
    return FULL_SEARCH;
  }

  public void setFullSearch(boolean full_search) {
    FULL_SEARCH = full_search;
  }

  // static constants
  private static String CALLING_URL = null;
  private static boolean FULL_SEARCH = false;
  public static final String TRACE_TAG = "ResourceSearchPullBackInfo";
  public static final String RESOURCE_PULLBACK_REQUEST = "resourcePullBackAttribute";
  public static final String PULLBACK_URL = "/resource/ResourceSearch/pullBackResource";

}





