package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.document.ChildLifeHistoryCheckList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildLifeHistoryCheckListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLifeHistoryCheckListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
/**
 * Child Life History Checklist service Implementation 
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/24/2008  ssubram STGAP00009509: Child life History check list has been added
 * </pre>
 *
 */
public class ChildLifeHistoryCheckListImpl extends BaseDocumentServiceImpl implements ChildLifeHistoryCheckList {
  
  FccpChildDAO fccpChildDAO;
  
  PersonDAO personDAO;
  
  StageDAO stageDAO;
  
  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public ChildLifeHistoryCheckListSO retrieveChildLifeHistoryCheckList(ChildLifeHistoryCheckListSI childLifeHistoryCheckListSI) {
    ChildLifeHistoryCheckListSO childLifeHistoryCheckListSO = new ChildLifeHistoryCheckListSO();
    PreFillData preFillData = new PreFillData();
    int idStage = childLifeHistoryCheckListSI.getUlIdStage();
    
    // Generate pre-fill data
    // Find the Primary Child for the given Stage ID 
    int idPerson = fccpChildDAO.findPrimaryChildForStage(idStage);
    
    // Get the DOB, Full Name and County Code
    Person person = personDAO.findPersonByIdPerson(idPerson);
    
    //Get the Stage
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (person == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }else {
      preFillData.addBookmark(createBookmark(ChildLifeHistoryCheckList.CHILD_NAME, person.getNmPersonFull()));
      preFillData.addBookmark(createBookmark(ChildLifeHistoryCheckList.DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));
      preFillData.addBookmark(createBookmarkWithCodesTable(ChildLifeHistoryCheckList.COUNTY, stage.getCdStageCnty(),
                                                           CodesTables.CCOUNT));
    }
    childLifeHistoryCheckListSO.setPreFillData(preFillData);
    return childLifeHistoryCheckListSO;
  }








}
