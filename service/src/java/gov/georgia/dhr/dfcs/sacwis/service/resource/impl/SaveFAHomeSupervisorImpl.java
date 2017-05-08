package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveFAHomeSupervisor;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveFAHomeSupervisorSI;

public class SaveFAHomeSupervisorImpl extends BaseServiceImpl implements SaveFAHomeSupervisor {

  private CapsResourceDAO capsResourceDAO = null;
  private PlacementDAO placementDAO = null;
  private LegalActionDAO legalActionDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }
 
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  @SuppressWarnings("unchecked")
  public int saveFAHomeSupervisor(SaveFAHomeSupervisorSI saveFAHomeSupervisorSI) throws ServiceException {
    int idResourcce = saveFAHomeSupervisorSI.getIdResource();
    
  //STGAP00013771 - IF the home has open placements then make sure the child does not have an adoption finalized
    // this is done by looking for legal actions with the outcome of adoption finalized. If there is a placement and
    // the child has an adoption finalized legal action then user can close the home if they have Adoption finalized..... 
    // as the closure reason.  If there is another closure reason or other types of placements then the message
    //"There are still children placed in the home. Remove them before closing." will display.
    Date systemDate = new Date();
    List<String> cdOutcomes = new ArrayList<String>();
    cdOutcomes.add(CodesTables.CLEGLOUT_ADF);
    boolean hasActivePlacements = false;
    List<Integer> placements = placementDAO.findApprovedCompIdPlcmtChildByIdRsrcFacil(systemDate, idResourcce);
    if (placements != null && !placements.isEmpty()) {
      for (Iterator<Integer> it = placements.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        List<LegalAction> legalActions = legalActionDAO.findLegalActionLatestObjectsByIdPersonByCdOutcomes(idPerson, cdOutcomes);
        if (!legalActions.isEmpty() && legalActions != null) {
          if (!ADOPTION_SUB_FINAL.equals(saveFAHomeSupervisorSI.getCdRsrcFacilType())
              && !ADOPTION_SUB_NOT_FINAL.equals(saveFAHomeSupervisorSI.getCdRsrcClosureRsn())) {
            hasActivePlacements = true;
          }
        } else {
          hasActivePlacements = true;
        }
      }
    }
          if (hasActivePlacements) {
      throw new ServiceException(Messages.MSG_FAD_HOME_WITH_PLACEMENTS);
    }

    int changeOfStatusReason = capsResourceDAO.updateCapsResource(idResourcce,
                                                                  saveFAHomeSupervisorSI.getCdRsrcClosureRsn(),
                                                                  saveFAHomeSupervisorSI.getCdRsrcInvolClosure(),
                                                                  saveFAHomeSupervisorSI.getCdRsrcRecmndReopen(),
                                                                  saveFAHomeSupervisorSI.getTxtClosureComm(),
                                                                  saveFAHomeSupervisorSI.getTxtLegalNm());
    if (changeOfStatusReason == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return changeOfStatusReason;

  }

}