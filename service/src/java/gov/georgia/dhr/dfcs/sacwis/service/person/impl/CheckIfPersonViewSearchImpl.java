package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.CheckIfPersonViewSearch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfPersonViewSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckIfPersonViewSearchSO;

/**
 * 
 * * <pre>
 *  Change History:
 *  Date        User            Description
 *  --------   --------         --------------------------------------------------
 *  08/23/2010 bgehlot          MR-072 Initial Creation
 *  09/15/2010 hjbaptiste       SMS#70974: If a person has been related, also return VIEW_SEARCH since the view search
 *                              button was clicked in order to relate the person 
 *  02/06/2012 aavila           STGAP00017872: MR-072 Added findNmLastFirstByIdPerson.
 *  
 * </pre>
 */
public class CheckIfPersonViewSearchImpl extends BaseServiceImpl implements CheckIfPersonViewSearch {
  private static final String NO_STAGE = "No Stage";
  private static final String NOT_INT_STAGE = "Not INT Stage";
  private static final String VIEW_SEARCH = "View Search";
  private static final String NOT_VIEW_SEARCHED = "Not View Searched";
  
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDAO personDAO = null;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public CheckIfPersonViewSearchSO checkIfPersonViewSearch(CheckIfPersonViewSearchSI checkIfPersonViewSearchSI) throws ServiceException {
    CheckIfPersonViewSearchSO checkIfPersonViewSearchSO = new CheckIfPersonViewSearchSO();
    //Get the person's name
    String nmPerson = personDAO.findNmLastFirstByIdPerson(checkIfPersonViewSearchSI.getIdPerson());
    checkIfPersonViewSearchSO.setNmPerson(nmPerson);
    
    //If the Records Check page is accessed in context of the stage.
    if(checkIfPersonViewSearchSI.getIdStage() != 0){
      String cdStage = stageDAO.findCdStageByIdStage(checkIfPersonViewSearchSI.getIdStage());
      //If the stage is INT
      if(CodesTables.CSTAGES_INT.equals(cdStage)){
        //Get the stagepersonlink for idPerson and idStage
        StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(checkIfPersonViewSearchSI.getIdPerson(), checkIfPersonViewSearchSI.getIdStage());
        //If Person is view searched or related (which means the view search was clicked)then return VIEW_SEARCH.
        if(CodesTables.CSRCHSTA_V.equals(stagePersonLink.getCdStagePersSearchInd()) || CodesTables.CSRCHSTA_R.equals(stagePersonLink.getCdStagePersSearchInd())){
          checkIfPersonViewSearchSO.setIsPersonViewSearched(VIEW_SEARCH);
        }else{
          checkIfPersonViewSearchSO.setIsPersonViewSearched(NOT_VIEW_SEARCHED); //else return NOT_VIEW_SEARCHED
        }
      }else{
        checkIfPersonViewSearchSO.setIsPersonViewSearched(NOT_INT_STAGE); //if not INT stage return NOT_INT_STAGE
      }      
    }else{
      checkIfPersonViewSearchSO.setIsPersonViewSearched(NO_STAGE); //if records check accessed without the context of the stage return NO_STAGE
    }
    
    return checkIfPersonViewSearchSO;
  }
}
