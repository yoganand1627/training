//*  Service Class  Name:     RetrieveAfcarsImpl
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
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveNcandsChildren;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenBean;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.dao.NcandsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class RetrieveNcandsChildrenImpl extends BaseServiceImpl implements RetrieveNcandsChildren {
  
  private NcandsDAO ncandsDAO = null;
  private StageDAO stageDAO = null;
  private StageLinkDAO stageLinkDAO = null;
  
  
  public void setNcandsDAO(NcandsDAO ncandsDAO) {
    this.ncandsDAO = ncandsDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
   
  @SuppressWarnings("unchecked")
  /**
   * retrieveNcands retrieves all information necessary for displaying children with 
   * NCANDS data for a stage on the Case Watch page.
   * 
   * @param context
   *          The CaseWatchSI object.
   * 
   * Returns NcandsChildrenSO object.
   */
  public NcandsChildrenSO retrieveNcandsChildren(CaseWatchSI caseWatchSI) {
    
    NcandsChildrenSO ncandsChildrenSO = new NcandsChildrenSO();
    
    int idStage = caseWatchSI.getIdStage();
    
    Stage stage = stageDAO.findStageByIdStage(idStage);
    
    if (CodesTables.CSTAGES_FPR.equals(stage.getCdStage())){
      
      int idInvStage = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
      idStage = idInvStage;
      
    }  
    
    List<Map> resultList= new ArrayList<Map>();
    
    resultList = ncandsDAO.findNcandsChildrenByStage(idStage);
    
    List<NcandsChildrenBean> children = new ArrayList<NcandsChildrenBean>();
    
    
    for (Iterator<Map> It = resultList.iterator(); It.hasNext();) {
    
      NcandsChildrenBean child = new NcandsChildrenBean();
      Map ncandsChild = It.next();
      
      child.setIdPerson((Integer) ncandsChild.get("personId"));
      child.setNmPersonFull((String) ncandsChild.get("nmPersonFull"));
      
      children.add(child);
    }
    
    ncandsChildrenSO.setChildren(children);
    
    return ncandsChildrenSO;
 }
}
