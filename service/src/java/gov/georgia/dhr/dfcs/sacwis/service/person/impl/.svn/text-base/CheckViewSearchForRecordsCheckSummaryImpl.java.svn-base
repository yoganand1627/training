package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.CheckViewSearchForRecordsCheckSummary;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfPersonViewSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckIfPersonViewSearchSO;

import java.util.List;

/**
 * Check View Search For Records Check Summary Service 
 * Author: Corey Harden
 * Date: 06/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 * 02/03/2012  aavila		   STGAP00017872: MR-072 Added findNmLastFirstByIdPerson.                              

 *
 *
 *
*/


public class CheckViewSearchForRecordsCheckSummaryImpl extends BaseServiceImpl implements CheckViewSearchForRecordsCheckSummary {
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

  
  /**
   * This method checks to see if a view search has been performed on a person
   * @param checkIfPersonViewSearchSI - the Service In object
   * @return CheckIfPersonViewSearchSO - the Service Out object which contains the results of the service
   */
  public CheckIfPersonViewSearchSO checkViewSearchForRecordsCheckSummary(CheckIfPersonViewSearchSI checkIfPersonViewSearchSI) {
    CheckIfPersonViewSearchSO checkIfPersonViewSearchSO = new CheckIfPersonViewSearchSO();

    // if adding by Person, the idPerson attribute will be set
    if(checkIfPersonViewSearchSI.getIdPerson() != 0){
      //Get the person's name
    	
      //STGAP00017872: MR-072
      //String nmPerson = personDAO.findNmFullByIdPerson(checkIfPersonViewSearchSI.getIdPerson());
      String nmPerson = personDAO.findNmLastFirstByIdPerson(checkIfPersonViewSearchSI.getIdPerson());
      checkIfPersonViewSearchSO.setNmPerson(nmPerson);
      //If the Records Check page is accessed in context of the stage.
      if (checkIfPersonViewSearchSI.getIdStage() != 0) {
        String cdStage = stageDAO.findCdStageByIdStage(checkIfPersonViewSearchSI.getIdStage());
        //If the stage is INT
        if (CodesTables.CSTAGES_INT.equals(cdStage)) {
          //Get the stagepersonlink for idPerson and idStage
          StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                              .findStagePersonLinkByIdPersonAndIdStage(
                                                                                                       checkIfPersonViewSearchSI
                                                                                                                                .getIdPerson(),
                                                                                                       checkIfPersonViewSearchSI
                                                                                                                                .getIdStage());
          //If Person is view searched or related (which means the view search was clicked)then return VIEW_SEARCH.
          if (CodesTables.CSRCHSTA_V.equals(stagePersonLink.getCdStagePersSearchInd())
              || CodesTables.CSRCHSTA_R.equals(stagePersonLink.getCdStagePersSearchInd())) {
            checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.VIEW_SEARCH);
          } else {
            checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.NOT_VIEW_SEARCHED); //else return NOT_VIEW_SEARCHED
          }
        } else {
          checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.NOT_INT_STAGE); //if not INT stage return NOT_INT_STAGE
        }
      } else {
        checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.NO_STAGE); //if records check accessed without the context of the stage return NO_STAGE
      }
      return checkIfPersonViewSearchSO;
    }else{
      // create variable to hold concatenated name
      StringBuilder concatName = new StringBuilder();
      
      // create boolean
      boolean isViewSearchNeeded = false;
      
      //If the Records Check page is accessed in context of the stage
      if (checkIfPersonViewSearchSI.getIdStage() != 0) {
        // if adding by type, perform view search check on each principal and household member
        List<StagePersonLink> splList = stagePersonLinkDAO.findStagePersonLinkByIdStageRoleHousehold(checkIfPersonViewSearchSI.getIdStage());
        
        // loop thru list to inspect view search information for intakes
        for(StagePersonLink s : splList){
          // get the stage
          Stage stage = s.getStage();
          
          // check to see if the stage is an intake
          if (CodesTables.CSTAGES_INT.equals(stage.getCdStage())) {
            //If Person is view searched or related (which means the view search was clicked)then set boolean to false
            if (CodesTables.CSRCHSTA_V.equals(s.getCdStagePersSearchInd()) || CodesTables.CSRCHSTA_R.equals(s.getCdStagePersSearchInd())) {
              // do nothing for now... may need to come back and modify this later
            } else {
              concatName.append(s.getPerson().getNmPersonFirst());
              concatName.append(" ");
              concatName.append(s.getPerson().getNmPersonLast());
              concatName.append(", ");
              isViewSearchNeeded = true;
            }
          }
        }
        // set SO indicator only if a view search is needed
        if(isViewSearchNeeded){
          checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.NOT_VIEW_SEARCHED);
        }
        
        // set concatenated name into SO object
        checkIfPersonViewSearchSO.setNmPerson(concatName.length() > 0 ? concatName.substring(0, concatName.lastIndexOf(",")) : "");
      }else {
        // not within a stage
        checkIfPersonViewSearchSO.setIsPersonViewSearched(CheckViewSearchForRecordsCheckSummaryImpl.NO_STAGE); //if records check accessed without the context of the stage return NO_STAGE
      }
      
      return checkIfPersonViewSearchSO;
    }
  }

}
