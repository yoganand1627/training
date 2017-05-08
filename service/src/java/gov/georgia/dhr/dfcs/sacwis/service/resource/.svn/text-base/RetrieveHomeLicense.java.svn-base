package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;

public interface RetrieveHomeLicense {
  // added LIC_NEW and changed LIC_MODIFY to MODIFY from NEW 
  static final String LIC_NEW = PageModeConstants.NEW;
  static final String LIC_MODIFY = PageModeConstants.MODIFY;
  static final String LIC_HISTORY = PageModeConstants.INQUIRE;

  /**
   * This service will retrieve Home License Information. It will either retrieve information from CAPS_RESOURCE (the
   * current event) or from RESOURCE_HISTORY (historical record).  It will also check for a BLOB.
   *
   * @param cfad37si {@link CFAD37SI} object
   * @return {@link CFAD37SO} object
   */
  public CFAD37SO retrieveHomeLicenseInformation(CFAD37SI cfad37si);
}
