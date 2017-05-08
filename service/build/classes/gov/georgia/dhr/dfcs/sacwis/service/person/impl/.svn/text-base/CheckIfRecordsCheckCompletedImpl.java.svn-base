package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.DiversionConclusionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiversionConclusion;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.CheckIfRecordsCheckCompleted;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This service checks to see if records check are completed for all the Persons in that stage
 * * <pre>
 *  Change History:
 *  Date        User        Description
 *  --------   --------     --------------------------------------------------
 *  08/23/2010 bgehlot     MR-072 Initial Creation
 *  09/08/2010  bgehlot    SMS 69753 Pass the cdDisposition from the request.
 *  07/08/2011  arege      SMS#109422: Records check required message needs to be thrown when approving Screen Out intakes.   
 *  07/11/2011  arege      SMS#109422: Consider a person to be over 17 if no date of birth entered and thus will require all records check to be completed.                                               
 *  
 * </pre>
 */
public class CheckIfRecordsCheckCompletedImpl extends BaseServiceImpl implements CheckIfRecordsCheckCompleted {
  private static final String NO_STAGE = "No Stage";
  public static final String APPROVAL_STATUS = "Approval Status";
  public static final String INTAKE_ACTION = "Intake Action";
  public static final String DIVERSION_CNCLSN = "Diversion Conclusion";
  public static final String INTAKE_CLOSURE = "Intake Closure";
  public static final double HOURS_ADDED = 72.0;
  
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private RecordsCheckDAO recordsCheckDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private DiversionConclusionDAO diversionConclusionDAO = null;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }
  
  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }
  
  public void setDiversionConclusionDAO(DiversionConclusionDAO diversionConclusionDAO) {
    this.diversionConclusionDAO = diversionConclusionDAO;
  }
  
  public String checkIfRecordsCheckCompleted(CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI) throws ServiceException {
    String recordsCheckCompleted = "";
    //If the Records Check page is accessed in context of the stage.
    if(checkIfRecordsCheckCompletedSI.getIdStage() != 0){
      String cdStage = stageDAO.findCdStageByIdStage(checkIfRecordsCheckCompletedSI.getIdStage());
      //If the stage is INT and submitting the Intake Action page
      if(CodesTables.CSTAGES_INT.equals(cdStage) && INTAKE_ACTION.equals(checkIfRecordsCheckCompletedSI.getPageName())){
        List<String> recordsCheckCompletedList = getRecordsCheckCompletedList(checkIfRecordsCheckCompletedSI);        
        if(recordsCheckCompletedList != null && !recordsCheckCompletedList.isEmpty()){
           if(recordsCheckCompletedList.contains(ArchitectureConstants.N)){
             recordsCheckCompleted =  ArchitectureConstants.FALSE;
           }else{
             recordsCheckCompleted = ArchitectureConstants.TRUE;
           }
        }       
      }
     // SMS#109422: Records check required message needs to be thrown when approving Screen Out intakes.                                                  
       else if (CodesTables.CSTAGES_INT.equals(cdStage) && INTAKE_CLOSURE.equals(checkIfRecordsCheckCompletedSI.getPageName())) { 
        // Submitting the Intake closure page 
        List<String> recordsCheckCompletedList = getRecordsCheckCompletedList(checkIfRecordsCheckCompletedSI);
        if (recordsCheckCompletedList != null && !recordsCheckCompletedList.isEmpty()) {
          recordsCheckCompleted = ArchitectureConstants.TRUE;
          if (recordsCheckCompletedList.contains(ArchitectureConstants.N)) {
            throw new ServiceException(Messages.MSG_RECORDS_CHECK_REQ);
          }
        }
      }
      //If the stage is INT and Approving the Intake
      else if(CodesTables.CSTAGES_INT.equals(cdStage) && APPROVAL_STATUS.equals(checkIfRecordsCheckCompletedSI.getPageName())){
        IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(checkIfRecordsCheckCompletedSI.getIdStage());
        String cdDisposition = incomingDetail.getCdIncomingDisposition();
        List<String> recordsCheckCompletedList = getRecordsCheckCompletedList(checkIfRecordsCheckCompletedSI);        
        if(recordsCheckCompletedList != null && !recordsCheckCompletedList.isEmpty()){
          //If Disposition is Screen Out or Screen Out and Refferred and Records Check not completed then return False.
           if((CodesTables.CDISP_SCO.equals(cdDisposition) || CodesTables.CDISP_SCR.equals(cdDisposition)) && recordsCheckCompletedList.contains(ArchitectureConstants.N)){
             recordsCheckCompleted =  ArchitectureConstants.FALSE;
           }else{
             recordsCheckCompleted = ArchitectureConstants.TRUE;
           }
        } 
      }
      //If stage is DIV and submitting the Diversion Conclusion
      else if(CodesTables.CSTAGES_DIV.equals(cdStage) && DIVERSION_CNCLSN.equals(checkIfRecordsCheckCompletedSI.getPageName())){
        String cdDiversionDisposition = checkIfRecordsCheckCompletedSI.getCdDIVDisposition();
        List<String> recordsCheckCompletedList = getRecordsCheckCompletedListForDiversion(checkIfRecordsCheckCompletedSI);        
        if(recordsCheckCompletedList != null && !recordsCheckCompletedList.isEmpty()){
           //If Diversion Disposition is Close - Refer for Investigation or Close - No Further Involvement OR Close- Refer for Services OR Close-Opened in Error
          // then return False
           if((CodesTables.CDIVDSPN_NFI.equals(cdDiversionDisposition) || CodesTables.CDIVDSPN_RFS.equals(cdDiversionDisposition)
               || CodesTables.CDIVDSPN_OIE.equals(cdDiversionDisposition) || CodesTables.CDIVDSPN_RFI.equals(cdDiversionDisposition)) && recordsCheckCompletedList.contains(ArchitectureConstants.N)){
             recordsCheckCompleted =  ArchitectureConstants.FALSE;
           }else{
             recordsCheckCompleted = ArchitectureConstants.TRUE;
           }
        }
      }
    }else{
      recordsCheckCompleted = NO_STAGE; //if records check accessed without the context of the stage return NO_STAGE
    }
    
    return recordsCheckCompleted;
  }
  
  private List<String> getRecordsCheckCompletedList(CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI){
  //Declare a Array list to hold Y or N for Records check completed or not for the persons
    List<String> recordsCheckCompletedList = new ArrayList<String>();
    //Get the list of persons who are PRN or Member of PK household who are under the age of 17 for idStage
    List<Integer> idPersonList = stagePersonLinkDAO.findPersonsPRNOrMemberPKHshldByIdStageUnder17(checkIfRecordsCheckCompletedSI.getIdStage());
    if(idPersonList != null && !idPersonList.isEmpty()){
      Iterator<Integer> iterPerson = idPersonList.iterator();
      while (iterPerson.hasNext()) {
        int idPerson = (Integer) iterPerson.next();
        String isRecordsCheckCompleted = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPersonUnderAge17(idPerson);
        recordsCheckCompletedList.add(isRecordsCheckCompleted);
      }
    }
    
  //Get the list of persons who are PRN or Member of PK household who are equal or over the age of 17 for idStage
  //SMS#109422: findPersonsPRNOrMemberPKHshldByIdStageOver17 considers a person is over 17 if no date of birth entered 
    idPersonList = stagePersonLinkDAO.findPersonsPRNOrMemberPKHshldByIdStageOver17(checkIfRecordsCheckCompletedSI.getIdStage());
    if(idPersonList != null && !idPersonList.isEmpty()){
      Iterator<Integer> iterPerson = idPersonList.iterator();
      while (iterPerson.hasNext()) {
        int idPerson = (Integer) iterPerson.next();
        String isRecordsCheckCompleted = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPersonOverAge17(idPerson);
        recordsCheckCompletedList.add(isRecordsCheckCompleted);
      }
    }
    
    return recordsCheckCompletedList;
  }
  
  private List<String> getRecordsCheckCompletedListForDiversion(CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI){
    //Declare a Array list to hold Y or N for Records check completed or not for the persons
    List<String> recordsCheckCompletedList = new ArrayList<String>();
    //Get the list of persons who are PRN or Member of PK household who are under the age of 17 for idStage
    List<Integer> idPersonList = stagePersonLinkDAO.findPersonsPRNOrMemberPKHshldByIdStageUnder17(checkIfRecordsCheckCompletedSI.getIdStage());
    if(idPersonList != null && !idPersonList.isEmpty()){
      Iterator<Integer> iterPerson = idPersonList.iterator();
      while (iterPerson.hasNext()) {
        int idPerson = (Integer) iterPerson.next();
        StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPerson,checkIfRecordsCheckCompletedSI.getIdStage());
        double hoursAdded = 0.0;
        //If the person has been stage progressed then check for DtStagePersLink and calculate the hours from DtStagePersLink to today's date 
        if(stagePersonLink.getDtStagePersLink() != null){
          Double hoursAddedObj = stagePersonLinkDAO.findHoursBetweenPersonDtStageProgressedAndTodaysDate(idPerson);
          hoursAdded = hoursAddedObj != null ? hoursAddedObj : 0;
        }else if(stagePersonLink.getDtPersonAddedOrRelated() != null){//If the person has been added or related to the case then calculate the hours from DtPersonAddedOrRelated to today's date 
          Double hoursAddedObj = stagePersonLinkDAO.findHoursBetweenDtPersonAddedAndTodaysDate(idPerson);
          hoursAdded = hoursAddedObj != null ? hoursAddedObj : 0;
        }else{ //if person was added before adding column DT_PERSON_ADDEDOR_RELATED for MR-072. there is no way to track when they were added.
          //Make hoursAdded = 73 so that below code will always check for these persons for Records check
          hoursAdded = HOURS_ADDED + 1;
        }
        
        if(hoursAdded > HOURS_ADDED){//If hours person been added is greater than 72 hours
          //Check for Records check for the person if they are completed
          String isRecordsCheckCompleted = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPersonUnderAge17(idPerson);
          recordsCheckCompletedList.add(isRecordsCheckCompleted);
        }
      }
    }

      //Get the list of persons who are PRN or Member of PK household who are equal or over the age of 17 for idStage
      idPersonList = stagePersonLinkDAO.findPersonsPRNOrMemberPKHshldByIdStageOver17(checkIfRecordsCheckCompletedSI.getIdStage());
      if(idPersonList != null && !idPersonList.isEmpty()){
        Iterator<Integer> iterPerson = idPersonList.iterator();
        while (iterPerson.hasNext()) {
          int idPerson = (Integer) iterPerson.next();
          StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPerson,checkIfRecordsCheckCompletedSI.getIdStage());
          double hoursAdded = 0.0;
          //If the person has been stage progressed then check for DtStagePersLink and calculate the hours from DtStagePersLink to today's date
          if(stagePersonLink.getDtStagePersLink() != null){
            Double hoursAddedObj = stagePersonLinkDAO.findHoursBetweenPersonDtStageProgressedAndTodaysDate(idPerson);
            hoursAdded = hoursAddedObj != null ? hoursAddedObj : 0; 
          }else if(stagePersonLink.getDtPersonAddedOrRelated() != null){//If the person has been added or related to the case then calculate the hours from DtPersonAddedOrRelated to today's date
            Double hoursAddedObj = stagePersonLinkDAO.findHoursBetweenDtPersonAddedAndTodaysDate(idPerson);
            hoursAdded = hoursAddedObj != null ? hoursAddedObj : 0;
          }else{//if person was added before adding column DT_PERSON_ADDEDOR_RELATED for MR-072. there is no way to track when they were added.
            //Make hoursAdded = 73 so that below code will always check for these persons for Records check
            hoursAdded = HOURS_ADDED + 1;
          }
          
          if(hoursAdded > HOURS_ADDED){
          //Check for Records check for the person if they are completed
            String isRecordsCheckCompleted = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPersonOverAge17(idPerson);
            recordsCheckCompletedList.add(isRecordsCheckCompleted);
          }
        }
      }

      return recordsCheckCompletedList;
    }
}
