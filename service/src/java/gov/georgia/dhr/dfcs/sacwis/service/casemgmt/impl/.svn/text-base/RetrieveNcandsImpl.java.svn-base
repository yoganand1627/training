//*  Service Class  Name:     RetrieveNcandsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 11/16/2009
//*
//*  Description:Service Implementation for retrieving Adoption Information.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  11/16/09  Patrick Coogan     Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveNcands;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsElementBean;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Ncands;
import gov.georgia.dhr.dfcs.sacwis.db.NcandsElementHelp;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NcandsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NcandsElementHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class RetrieveNcandsImpl extends BaseServiceImpl implements RetrieveNcands {
  
  private NcandsDAO ncandsDAO = null;
  private NcandsElementHelpDAO ncandsElementHelpDAO = null;
  private StageDAO stageDAO = null;
  private StageLinkDAO stageLinkDAO = null;
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  
  public void setNcandsDAO(NcandsDAO ncandsDAO) {
    this.ncandsDAO = ncandsDAO;
  }
  
  public void setNcandsElementHelpDAO(NcandsElementHelpDAO ncandsElementHelpDAO) {
    this.ncandsElementHelpDAO = ncandsElementHelpDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
   
  @SuppressWarnings("unchecked")
  /**
   * retrieveNcands retrieves all information necessary for displaying NCANDS data
   * for a specfic child on the Case Watch page.
   * 
   * @param context
   *          The CaseWatchSI object.
   * 
   * Returns NcandsSO object.
   */
  public NcandsSO retrieveNcands(CaseWatchSI caseWatchSI) {
    
    NcandsSO ncandsSO = new NcandsSO();
    
    int idPerson = caseWatchSI.getIdPerson();
    int idStage = caseWatchSI.getIdStage();
    int idCase = caseWatchSI.getIdCase();
    
    ncandsSO.setIdCustodyEvent(0);
    ncandsSO.setIdCustodyEventStage(0);
    
    Stage stage = stageDAO.findStageByIdStage(idStage);
    
    if (CodesTables.CSTAGES_FPR.equals(stage.getCdStage())){
      
      int idInvStage = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
      idStage = idInvStage;
      
    }  
    
    Ncands ncands = ncandsDAO.findNcandsByPersonAndStage(idPerson, idStage);
    
    if (ncands!=null) { 
    ncandsSO.setDtLastUpdate(ncands.getDtLastUpdate());   
    
      List removals = new ArrayList<CnsrvtrshpRemoval>();

      removals = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(idCase, idPerson);

      if ((removals != null) && !(removals.isEmpty())) {

        String ncandsReportedRemoval = ncands.getRmvdate() != null ? ncands.getRmvdate()
                                                                                : "";

        if (!"".equals(ncandsReportedRemoval)) {

          Date reportedRemoval = DateHelper.toJavaDateSafe(ncandsReportedRemoval.substring(0, 2) + "/"
                                                           + ncandsReportedRemoval.substring(2,4) + "/"
                                                           + ncandsReportedRemoval.substring(4));

          for (Iterator<CnsrvtrshpRemoval> It = removals.iterator(); It.hasNext();) {

            CnsrvtrshpRemoval removal = It.next();

            if (DateHelper.isEqual(reportedRemoval, removal.getDtRemoval())) {

              ncandsSO.setIdCustodyEvent(removal.getEvent().getIdEvent());
              ncandsSO.setIdCustodyEventStage(removal.getEvent().getStage().getIdStage());
            }
          }
        }
      }
    
    
    }
    
    Map resultMap = ncandsDAO.findNcandsMapByPersonAndStage(idPerson, idStage);
    
    List<NcandsElementBean> elementList = new ArrayList<NcandsElementBean>();
    List<NcandsElementHelp> elementDbList = ncandsElementHelpDAO.findNcandsElements();
    
    for (Iterator<NcandsElementHelp> It = elementDbList.iterator(); It.hasNext();) {
    
      NcandsElementBean element = new NcandsElementBean();
      NcandsElementHelp elementDb = It.next();
      
      element.setSzFieldLabel(elementDb.getTxtNcandsElementLabel());
      element.setSzHelpText(elementDb.getTxtNcandsElementHelpText());
      element.setSzSource(elementDb.getTxtNcandsSourceText());
      
      
      if (resultMap != null) {
      
      String data = (String) resultMap.get(elementDb.getTxtNcandsElement()) != null ? (String) resultMap.get(elementDb.getTxtNcandsElement()) :"";
      String dataType = elementDb.getCdNcandsDataType();
      
      if ("C".equals(dataType)){
        element.setSzData(Lookup.simpleDecodeSafe(elementDb.getTxtNcandsCodesTable(),data));
      } else if ("D".equals(dataType)&& !"".equals(data)) {
        element.setSzData(data.substring(0, 2) + "/" + data.substring(2,4) + "/" + data.substring(4));
      } else {
        element.setSzData(data);
      }
      }
      elementList.add(element);
    }
    
    ncandsSO.setElements(elementList);
    
    return ncandsSO;
 }
}
