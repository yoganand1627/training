package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;


import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrChildrenConsideredPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyRsrcAsmntNarrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.DeleteSafetyResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceDeleteSI;

/**
 *This class implements the deleteSafetyResource service to delete records
 *from the SAFETY_RESOURCE, EVENT, EVENT_PERSON_LINK, and SR_HOUSEHOLD_MEMBERS tables
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * 06/23/2009  bgehlot         STGAP00014329: MR-20 updates  
 * </pre>
 */


public class DeleteSafetyResourceImpl extends BaseServiceImpl implements DeleteSafetyResource {

  private EventDAO eventDAO = null;

  private SafetyResourceDAO safetyResourceDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;
  
  private SafetyRsrcAsmntNarrDAO safetyRsrcAsmntNarrDAO = null;
  
  private SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO = null;  

  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
  
  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }
  
  public void setSafetyRsrcAsmntNarrDAO(SafetyRsrcAsmntNarrDAO safetyRsrcAsmntNarrDAO) {
    this.safetyRsrcAsmntNarrDAO = safetyRsrcAsmntNarrDAO;
  }
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setSrChildrenConsideredPlacementDAO(SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO) {
    this.srChildrenConsideredPlacementDAO = srChildrenConsideredPlacementDAO;
  }

  /*Implements public method declared in interface file */
  
  public void deleteSafetyResource(SafetyResourceDeleteSI safetyResourceDeleteSI ) 
        throws ServiceException {

    int ulIdEvent = safetyResourceDeleteSI.getUlIdEvent();
    
    //STGAP00014329: Delete all rows from SR_CHILD_CONSIDER_PLCMNT
    srChildrenConsideredPlacementDAO.deleteSrChildrenConsiderByEvent(ulIdEvent);
    srHouseholdMembersDAO.deleteSrHouseholdMembersByEvent(ulIdEvent);
    safetyResourceDAO.deleteSafetyResource(ulIdEvent);
    safetyRsrcAsmntNarrDAO.deleteSafetyRsrcAsmntNarr(ulIdEvent);
    eventPersonLinkDAO.deleteEventPersonLinkByIdEvent(ulIdEvent);
    eventDAO.deleteEventByIdEvent(ulIdEvent);
    
  }
  
}
