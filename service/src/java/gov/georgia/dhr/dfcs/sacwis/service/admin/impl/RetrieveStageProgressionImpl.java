package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStageProgression;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY;

/*Change History:
    Date        User           Description
    --------    --------       -------------------------------------------------------------------------------------
    09/23/2009  mxpatel        STGAP00013963: Added code so that the ILP aftercare value or one of the Not in DFCS Custody values, 
                               except Child Death or Turned 18-No ILP, should be required in order to progress FCC to PFC
    
*/

public class RetrieveStageProgressionImpl extends BaseServiceImpl implements RetrieveStageProgression {

  private StageProgDAO stageProgDAO = null;
  
  private LegalStatusDAO legalStatusDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCMN39SO retrieveStageProgression(CCMN39SI ccmn39si) {
    CCMN39SO ccmn39so = new CCMN39SO();
    boolean canProgressToPFC = true;
    // Calling ccmnb8d
    List<StageProg> stageProg =
            stageProgDAO.findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(ccmn39si.getSzCdStage(),
                                                                                              ccmn39si.getSzCdStageProgram(),
                                                                                              ccmn39si.getSzCdStageReasonClosed());

    ROWCCMNB8DO_ARRAY rowccmnb8do_array = new ROWCCMNB8DO_ARRAY();
    for (Iterator<StageProg> it = stageProg.iterator(); it.hasNext();) {
      StageProg stageProgInfo = it.next();
      ROWCCMNB8DO rowccmnb8do = new ROWCCMNB8DO();
      // A stage is open for progressing if it's cdStageProgOpen is not equal to null.
      if (stageProgInfo.getCdStageProgOpen() != null) {
        //STGAP00013963: If PFC is one of the options, get the idStage of the stage we are progressing 
        //and idPerson of the primary child for the stage.
        if (stageProgInfo.getCdStageProgOpen().equals(CodesTables.CSTAGES_PFC)) {
          int idStage = ccmn39si.getUlIdStage();
          String cdStagePersonRole = CodesTables.CROLES_PC;
          Integer idStagePerson = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(idStage,cdStagePersonRole);
          //STGAP00013963: find the latest legal status for the primary child
         if (idStagePerson != null) {
            LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idStagePerson);
            // STGAP00013963: if legal status is not one of the following types, do not show PFC as an option
            if (legalStatus != null) {
              String cdLegalStatus = legalStatus.getCdLegalStatStatus();
              List<String> listCdLegalStatus = new ArrayList<String>();
              listCdLegalStatus.add(CodesTables.CLEGSTAT_ILP);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NAF);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NCO);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NPR);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NTT);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NCE);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NGP);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NPC);
              listCdLegalStatus.add(CodesTables.CLEGSTAT_NCS);
              if (!listCdLegalStatus.contains(cdLegalStatus)) {
                canProgressToPFC = false;
              }
            }
          }
        } 
       if(canProgressToPFC) {
          rowccmnb8do.setSCdStageProgProgram(stageProgInfo.getCdStageProgProgram());
          rowccmnb8do.setSzCdStageProgStage(stageProgInfo.getCdStageProgStage());
          rowccmnb8do.setSCdStageProgStageType(stageProgInfo.getCdStageProgStageType());
          rowccmnb8do.setSzCdStageProgRsnClosed(stageProgInfo.getCdStageProgRsnClose());
          rowccmnb8do.setBIndStageProgClose(stageProgInfo.getIndStageProgClose());
          rowccmnb8do.setSzCdStageProgOpen(stageProgInfo.getCdStageProgOpen());
          rowccmnb8do.setSzCdStageProgEventType(stageProgInfo.getCdStageProgEventType());
          rowccmnb8do.setSzTxtStageProgEvntDesc(stageProgInfo.getTxtStageProgEvntDesc());
          rowccmnb8do_array.addROWCCMNB8DO(rowccmnb8do);
        }
      }
    }
    ccmn39so.setROWCCMNB8DO_ARRAY(rowccmnb8do_array);
    return ccmn39so;
  }
}
