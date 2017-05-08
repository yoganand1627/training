package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.CheckIfHomeHasActivePlacements;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * This Service is used to see if the Home has active Placements. 
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  10/29/09    Cwells    initial Creation
 *  04/21/10    wcochran  SMS #49517 - if a child has a legal status of "Not in DFCS 
 *                        Custody - Adoption Finalized" the home should be allowed to close. 
 * </pre>
 */
public class CheckIfHomeHasActivePlacementsImpl extends BaseServiceImpl implements CheckIfHomeHasActivePlacements{

  private LegalStatusDAO legalStatusDAO = null;
  
  private PlacementDAO placementDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public boolean checkIfHomeHasActivePlacements(int idResource, String cdClosureRsn){
    

    //STGAP00013771 - If the home has open placements then make sure the child does not have an open
    // PAD Stage. If there is a placement and
    // the child has an open PAD stage then the user can close the home if they have Adoption finalized..... 
    // as the closure reason.  If there is another closure reason or other types of placements then the message
    //"There are still children placed in the home. Remove them before closing." will display.
    Date systemDate = new Date();
    int idPadStage = 0;
    boolean hasActivePlacements = false;
    List<Integer> placements = placementDAO.findApprovedCompIdPlcmtChildByIdRsrcFacil(systemDate, idResource);
    if (placements != null && !placements.isEmpty()) {
      for (Iterator<Integer> it = placements.iterator(); it.hasNext();) {
        Integer idChild = it.next();
        // STGAP00013771 Given the idChild we can look for the PAD stage 
        idPadStage = stagePersonLinkDAO.findIdStageByIdPersonCdStage(idChild) != null ? stagePersonLinkDAO.findIdStageByIdPersonCdStage(idChild) : 0;
        if (idPadStage != 0) {
          if (!ADOPTION_SUB_FINAL.equals(cdClosureRsn)
              && !ADOPTION_SUB_NOT_FINAL.equals(cdClosureRsn)) {
            hasActivePlacements = true;
          }
          /* SMS #49517 - if a child has a legal status of "Not in DFCS Custody - Adoption Finalized"
           * the home should be allowed to close. First we check to see if the PAD child
           * has the correct legal status, if not we move back to the pre-PAD child ID
           * and look for the legal status using that ID.
           */
          if (checkHasLegalStatusAdoptionFinalized(idChild)) {
            hasActivePlacements = false;
          } else { // we need to check for ADO & FCC Legal Actions
        	  
        	if(stageLinkDAO.findPreviousIdStageByIdStageByCdStage(idPadStage) != null)
        	{
        		int idAdoStage = stageLinkDAO.findPreviousIdStageByIdStageByCdStage(idPadStage);
        		Map map = stagePersonLinkDAO.findIdChildNmStageByIdStage(idAdoStage);
        		Integer idAdoChild = (Integer) map.get("idPerson"); 
        		if (checkHasLegalStatusAdoptionFinalized(idAdoChild)) {
        			hasActivePlacements = false;
        		}
        	}
          }
        } else { // There was no PAD stage ID found. We are dealing with a pre-PAD Child ID
          if (checkHasLegalStatusAdoptionFinalized(idChild)) {
            hasActivePlacements = false;
          } else {
            hasActivePlacements = true;
          }
        }
      }
    }
    
    return hasActivePlacements;
  }
  
  /* SMS #49517 - if a child has a legal status of "Not in DFCS Custody - Adoption Finalized"
   * the home should be allowed to close.
   */
  private boolean checkHasLegalStatusAdoptionFinalized(int idChild) {
    boolean hasLegalStatus = false;
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idChild, 
                                                                                                   LGL_STAT_NOT_IN_DFCS_CSTDY_ADO_FINAL);
    if (legalStatus != null) {
      hasLegalStatus = true;
    }
    
    return hasLegalStatus;
  }
  
}
