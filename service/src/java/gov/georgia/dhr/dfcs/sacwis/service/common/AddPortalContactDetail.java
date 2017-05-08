package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;


public interface AddPortalContactDetail {

  /**
   * This service wraps the standard retrieve service for adding a contact with overrides
   * appropriate for the initial display of a contact added through Portal.
   *
   * @param csys09si, portalUser, idResource 
   * @return csys08so
   */

  public CSYS08SO addPortalContactDetail(CSYS08SI csys08si, Integer idPortalUser, Integer idResource);
}
