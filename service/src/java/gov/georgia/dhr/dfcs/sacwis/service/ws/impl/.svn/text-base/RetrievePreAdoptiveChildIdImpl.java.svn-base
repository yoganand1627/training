package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.RetrievePreAdoptiveChildId;

/**
 * SMS #65398 MR -041 This is the Service that retrieves SHINES Person Id of the existing, pre-adoptive 
 * child when the record for the newly created post adoptive child is created <p/>
 * 
 * @author bhgehlot  August, 06, 2010
 * 
 */


public class RetrievePreAdoptiveChildIdImpl extends BaseServiceImpl implements RetrievePreAdoptiveChildId {
  private StagePersonLinkDAO stagePersonLinkDAO;
  private StageLinkDAO stageLinkDAO;
  private StageDAO stageDAO;
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public Integer retrievePreAdoptiveChildId(int idStage){
    //MR-041 Set the SHINES Person Id of the existing, pre-adoptive child when the record for the newly 
    // created post adoptive child is created.
    Integer idClientPrev = null;
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if(stage != null && stage.getCdStage() != null && CodesTables.CSTAGES_PAD.equals(stage.getCdStage())){
    	if(stageLinkDAO.findPreviousIdStagebyIdStage(idStage) != null)	
    	{
    		int idADOStage = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
    		idClientPrev = stagePersonLinkDAO.findIdPersonForChildByIdADOStage(idADOStage);
    	}
    }
    return idClientPrev;
  }
}
