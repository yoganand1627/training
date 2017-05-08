package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceSaveSO;

public interface SaveSafetyResource {
  /**
   * Saves information on the Safety Resource Detail page to the SAFETY_RESOURCE, EVENT,
   * EVENT_PERSON_LINK, and SR_HOUSEHOLD_MEMBERS table as appropriate.
   *
   * @param safetyResourceSaveSI bean
   * @return SafetyResourceSaveSO bean
   * @author Patrick Coogan
   * @throws ServiceException
   */  
  public static final String SUBMIT = "submit";
  public static final String SAFETY_RSRC_ASMNT_NARR = "SAFETY_RSRC_ASMNT_NARR";
  public SafetyResourceSaveSO saveSafetyResource(SafetyResourceSaveSI safetyResourceSaveSI);
}
