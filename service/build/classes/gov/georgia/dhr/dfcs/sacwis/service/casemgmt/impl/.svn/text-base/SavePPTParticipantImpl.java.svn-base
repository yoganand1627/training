package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PptParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PptParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePPTParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB28SO;

import java.text.DateFormat;
import java.util.Enumeration;
import java.util.Locale;

public class SavePPTParticipantImpl extends BaseServiceImpl implements SavePPTParticipant {

  private static final String TODO_INFO_27_CODE = "SUB027";
  
  private static final String START_LINE = "A Team Meeting/Review is scheduled on ";
  private static final String MIDDLE_LINE = " at ";
  private static final String LAST_LINE = ".";

  private PptParticipantDAO pptParticipantDAO = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  private TodoCommonFunction todoCommonFunction = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkEventStageStatus) {
    this.checkStageEventStatus = checkEventStageStatus;
  }

  public void setPptParticipantDAO(PptParticipantDAO pptParticipantDAO) {
    this.pptParticipantDAO = pptParticipantDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public CSUB28SO savePPTParticipant(CSUB28SI csub28si)
          throws ServiceException {

    CSUB28SO csub28so = new CSUB28SO();
    String date_string = "";

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();
    
    ccmn06ui.setArchInputStruct(input);
    
    
    ccmn06ui.getArchInputStruct().setCReqFuncCd(csub28si.getArchInputStruct().getCReqFuncCd());
    ccmn06ui.setUlIdStage(csub28si.getUlIdStage());
    ccmn06ui.setSzCdTask(csub28si.getSzCdTask());
    checkStageEventStatus.status(ccmn06ui);

    ROWCSUB28SIG00_ARRAY rowcsub28sig00_array = csub28si.getROWCSUB28SIG00_ARRAY();
    Enumeration rowcsub28sig00_enum = rowcsub28sig00_array.enumerateROWCSUB28SIG00();

    while (rowcsub28sig00_enum.hasMoreElements()) {
      ROWCSUB28SIG00 rowcsub28sig00 = (ROWCSUB28SIG00) rowcsub28sig00_enum.nextElement();
      String cdAction = rowcsub28sig00.getSzCdScrDataAction();
      PptParticipant pptParticipant = new PptParticipant();
      Event event = getPersistentObject(Event.class, rowcsub28sig00.getUlIdPptEvent());
      if(!(CodesTables.CPARTYPE_OTH.equals(rowcsub28sig00.getSzCdPptPartType()))){
        Person person = getPersistentObject(Person.class, rowcsub28sig00.getUlIdPerson());
        pptParticipant.setPerson(person);
      }
      pptParticipant.setEvent(event);
      
      pptParticipant.setCdPptPartType(rowcsub28sig00.getSzCdPptPartType());
      pptParticipant.setNmPptPartFull(rowcsub28sig00.getSzNmPptPartFull());
      pptParticipant.setSdsPptPartRelationship(rowcsub28sig00
              .getSzSdsPptPartRelationship());
      pptParticipant.setCdPptNotifType(rowcsub28sig00.getSzCdPptNotifType());
      pptParticipant.setDtPptPartDateNotif(DateHelper.toJavaDate(rowcsub28sig00
              .getDtDtPptPartDateNotif()));
      pptParticipant.setDtPptPart(DateHelper.toJavaDate(rowcsub28sig00
              .getDtDtPptPart()));
      pptParticipant.setDtLastUpdate(rowcsub28sig00.getTsLastUpdate());
      pptParticipant.setIdPptPart(rowcsub28sig00.getUlIdPptPart());
      pptParticipant.setIndAccptdChanges(rowcsub28sig00.getIndAccptdChnges());
      pptParticipant.setIndReqAh(rowcsub28sig00.getIndReqAh());
      pptParticipant.setIndSignedWvrAh(rowcsub28sig00.getIndSignedWvrAh());
      pptParticipant.setNmPptPartAgency(rowcsub28sig00.getTxtAgency());
      pptParticipant.setCdPptPartTitle(rowcsub28sig00.getTxtTitle());
      
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdAction)
          || cdAction.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
        // caud10d
        pptParticipantDAO.savePptParticipant(pptParticipant);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdAction)) {
        pptParticipantDAO.deletePptParticipant(pptParticipant);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      if (rowcsub28sig00.getSzCdPptPartType() != null && rowcsub28sig00.getSzCdPptNotifType()!= null) {
        if (CodesTables.CPARTYPE_STA.equals(rowcsub28sig00.getSzCdPptPartType()) && 
                        CodesTables.CPPTNOST_ONL.equals(rowcsub28sig00.getSzCdPptNotifType())) {
          CSUB40UI csub40ui = new CSUB40UI();
          CSUB40UIG00 csub40uig00 = new CSUB40UIG00();

          csub40uig00.setSzSysCdTodoCf(TODO_INFO_27_CODE);
          csub40uig00.setDtSysDtTodoCfDueFrom(
                DateHelper.getTodayCastorDate());
           csub40uig00.setUlSysIdTodoCfPersAssgn(
                rowcsub28sig00.getUlIdPerson());
           csub40uig00.setUlSysIdTodoCfPersCrea(
                csub28si.getUlSysIdTodoCfPersCrea());
           csub40uig00.setUlSysIdTodoCfEvent(0);
           csub40uig00.setUlSysIdTodoCfStage(
                csub28si.getUlIdStage());
           csub40uig00.setSzSysTxtTodoCfDesc(START_LINE);
           DateFormat dateFormatter;
           Locale currentLocale = new Locale("en", "US");
           dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
          
           date_string = dateFormatter.format(DateHelper.toJavaDate(csub28si.getDtDtPptDate()));
           String sysTxtTodoCfDesc = START_LINE;
           sysTxtTodoCfDesc += date_string + MIDDLE_LINE + csub28si.getTmScrTmPptTime() + LAST_LINE;

           csub40uig00.setSzSysTxtTodoCfDesc(sysTxtTodoCfDesc);
           csub40ui.setCSUB40UIG00(csub40uig00);
           todoCommonFunction.audTodo(csub40ui);
        }
      }
    }
    return csub28so;
  }
}
