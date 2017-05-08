package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveTCMClaim;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimSaveSO;

import java.util.Date;

/**
 * 
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 03/26/09  Van Vo      MR-026 STGAP00013024: call updateTcmClaimStatus when a claim is marked Non Re-billable to update  
 *                       its status only. 
 * 07/28/09  arege       STGAP00014858 Modified code so that TCM contact with TCMclaim in NBL status
 *                       can be modified for 7 days.
 *                      
 * </pre>
 *
 */
public class SaveTCMClaimImpl extends BaseServiceImpl implements SaveTCMClaim {
  
  private TCMClaimDAO tcmClaimDAO;

  public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
    this.tcmClaimDAO = tcmClaimDAO;
  }
  
  private int updateTcmClaimStatus(int idTcmClaim, String noRebillStatus) {
    return tcmClaimDAO.updateTcmClaimStatus(idTcmClaim, noRebillStatus);
  }
  
  public TCMClaimSaveSO saveTCMClaim(TCMClaimSaveSI si) {
    TCMClaimSaveSO so = new TCMClaimSaveSO();
    
    String nbrTCN = null;
    int idTcmClaimResubmitted = si.getIdTcmClaimResubmitted();
    // MR-026 STGAP00013024
    if (si.isNoRebill()) {
      updateTcmClaimStatus(idTcmClaimResubmitted, CodesTables.CTCMSTAT_NRB);
      return so;
    }
    // END MR-026 STGAP00013024 
    if(idTcmClaimResubmitted > 0) {
      TcmClaim resubmitted = getPersistentObject(TcmClaim.class, idTcmClaimResubmitted);
      resubmitted.setCdStatus(CodesTables.CTCMSTAT_RSU); //-- Resubmitted
      tcmClaimDAO.saveTCMClaim(resubmitted);
      nbrTCN = si.getNbrTCN();
    }
    
    TcmClaim tcmClaim = new TcmClaim();
    tcmClaim.setIdTcmClaim(0);
    tcmClaim.setCdStatus(CodesTables.CTCMSTAT_NBL); //-- Not Billed
    tcmClaim.setDtStatus(new Date());
    tcmClaim.setNbrMedicaid(si.getNbrMedicaid());
    tcmClaim.setNbrTcn(nbrTCN);
    
    int idEvent = si.getIdEvent();
    if(idEvent > 0) {
      Event contactEvent = getPersistentObject(Event.class, idEvent);
      tcmClaim.setEvent(contactEvent);
    }
    
    int idPerson = si.getIdPerson();
    if(idPerson > 0) {
      Person client = getPersistentObject(Person.class, idPerson);
      tcmClaim.setPersonByIdPerson(client);
      tcmClaim.setNmClient(client.getNmPersonFull());
    }
    
    int idStaff = si.getIdStaff();
    if(idStaff > 0) {
      Person staff = getPersistentObject(Person.class, idStaff);
      tcmClaim.setPersonByIdStaff(staff);
    }
    
    int idStage = si.getIdStage();
    if(idStage > 0) {
      Stage stage = getPersistentObject(Stage.class, idStage);
      tcmClaim.setStage(stage);
    }
    
    Date dtService = si.getDtService();
    if(!DateHelper.isNull(dtService)) {
      tcmClaim.setDtService(dtService);
    }
    
    if(!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(si.getCdReqFuncCd())){
    tcmClaimDAO.saveTCMClaim(tcmClaim);
    }
    
    return so;
  }

}
