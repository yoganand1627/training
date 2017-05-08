package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemovalId;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePersonsInHomeRemoval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB49SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB49SO;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

11/05/08    mxpatel           STGAP00009009: added statements to retrieve idRemovalEvent and idPersonHmRemoval for 
                              personHomeRemoval.                              
*/

public class SavePersonsInHomeRemovalImpl extends BaseServiceImpl implements SavePersonsInHomeRemoval {

  private CheckStageEventStatus checkStageEventStatus = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  public CSUB49SO savePersonsInHomeRemoval(CSUB49SI csub49si) throws ServiceException {

    CSUB49SO csub49so = new CSUB49SO();

    // (BEGIN): Common Function: ccmn06u Check Stage/Event common function
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csub49si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(csub49si.getArchInputStruct().getCReqFuncCd());
    ccmn06ui.setUlIdStage(csub49si.getUlIdStage());
    ccmn06ui.setSzCdTask(csub49si.getSzCdTask());

    // CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);

    for (Enumeration rowcsub49siEnum = csub49si.getROWCSUB49SIG00_ARRAY().enumerateROWCSUB49SIG00(); rowcsub49siEnum
                                                                                                                    .hasMoreElements();) {
     
      ROWCSUB49SIG00 rowcsub49si = (ROWCSUB49SIG00) rowcsub49siEnum.nextElement();
      String cdReqFuncCd = rowcsub49si.getSzCdScrDataAction();
      int idPersHmRemoval = rowcsub49si.getUlIdPerson();
      PersonHomeRemoval personHomeRemoval = new PersonHomeRemoval();
      PersonHomeRemovalId personHomeRemovalId = new PersonHomeRemovalId();
      personHomeRemovalId.setIdPersHmRemoval(idPersHmRemoval);
      int idEvent = rowcsub49si.getUlIdEvent();
      Event event = getPersistentObject(Event.class, idEvent);
      personHomeRemovalId.setIdRemovalEvent(idEvent);
      personHomeRemoval.setId(personHomeRemovalId);
      int idRemovalEvent = personHomeRemoval.getId().getIdRemovalEvent();//mxpatel added this for defect #9009
      int idPersonHmRemoval = personHomeRemoval.getId().getIdPersHmRemoval();//mxpatel added this for defect #9009
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqFuncCd)
          || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqFuncCd)) {
        Person person = getPersistentObject(Person.class, idPersHmRemoval);
        personHomeRemoval.setPerson(person);
        personHomeRemovalDAO.savePersonHomeRemoval(personHomeRemoval);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdReqFuncCd)) {
        personHomeRemoval = personHomeRemovalDAO.findPersonHmRemovByIdPersonIdCase(idPersHmRemoval, event.getCapsCase().getIdCase());
       // personHomeRemovalDAO.deletePersonHomeRemoval(personHomeRemoval);////mxpatel commented this out for defect #9009
        personHomeRemovalDAO.deletePersonHomeRemoval(idRemovalEvent,idPersonHmRemoval );////mxpatel added this for defect #9009
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return csub49so;
  }

}
