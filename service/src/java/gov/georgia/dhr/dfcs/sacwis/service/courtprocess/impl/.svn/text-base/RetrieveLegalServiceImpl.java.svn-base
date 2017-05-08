package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsAdoptionHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.RetrieveLegalService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S;
/**
 * This is the Conversation class used to view the Legal Status Detail<p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User        Description
 *  --------  ----------  --------------------------------------------------
 *  06/02/08  SWR         STGAP00004587 - Modified retrieveLegalService method so that it set the ulIdPerson in the 
 *                        csub45so object.  That ID is later used on save to determine if changes for 
 *                        the client should be sent over the SMILE interface.
 *                      
 *  09/11/08  alwilliams  STGAP00005490 - Added method callGetPersonFullName to get the person full name. This is 
 *                        common method that is called from several places in method retrieveLegalService to replace
 *                        duplicate code.     
 *                                       
 *  06/29/09  bgehlot    STGAP00014336: Added the validation logic for the message "Selecting the Legal Status of 
 *                       Adoption Finalized requires that a TPR Date, Voluntary Surrender Date, or Date of Death 
 *                       exist for both mother and father on the stage."
 *  11/18/10  htvo       SMS#81140 - MR-074 AFCARS: move performValidationForNAF logic to Save: 
 *                       - the dates now need to be compared again the LS effective date, which is done in Save 
 *                       - to group AFCARS validations together in Save for real time validation and less overhead on Retrieve
 *  03/17/11  htvo       SMS#97845 MR-074-2 AFCARS: 
 *                       - removed code commented out from last release                     
 * 
 * @author swroberts
 */


public class RetrieveLegalServiceImpl extends BaseServiceImpl implements RetrieveLegalService {

  public static final int LEGAL_STATUS = 0;

  public static final int STAGE_CLOSURE = 1;

  private DynamicEventDAO dynamicEventDAO = null;

  private AfcarsAdoptionHistoryDAO afcarsAdoptionHistoryDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonDAO personDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private EventDAO eventDAO = null;
  
  private LegalActionDAO legalActionDAO = null;

  public void setAfcarsAdoptionHistoryDAO(AfcarsAdoptionHistoryDAO afcarsAdoptionHistoryDAO) {
    this.afcarsAdoptionHistoryDAO = afcarsAdoptionHistoryDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public CSUB45SO retrieveLegalService(CSUB45SI csub45si) throws ServiceException {

    CSUB45SO csub45so = new CSUB45SO();

    csub45so.setROWCSUB45SOG00(new ROWCSUB45SOG00());
    csub45so.setROWCSUB45SOG01(new ROWCSUB45SOG01());

    ROWCSUB45SOG00 rowcsub45sog00 = csub45so.getROWCSUB45SOG00();
    ROWCSUB45SOG01 rowcsub45sog01 = csub45so.getROWCSUB45SOG01();

    // STG00005490 - Added Person ID local variable
    Integer idPerson;
    
    int idStage = csub45si.getUlIdStage();

    // CallCCMN87D
    callGetDynamicEvents(idStage, rowcsub45sog00);

    int idEvent = csub45si.getUlIdEvent();

    if ((0 == idEvent)
        && (CodesTables.CSTAGES_SUB.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_ADO.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_PAD.equals(csub45si.getSzCdStage()) || CodesTables.CSTAGES_PFC
                                                                                                 .equals(csub45si
                                                                                                                 .getSzCdStage()))) {
      // Get IdPerson given IdStage & Role
      // cinv51dQUERY
      idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CINVROLE_PC);

      if (idPerson == null || idPerson == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      csub45so.setUlIdPerson(idPerson != null ? idPerson : 0);
      rowcsub45sog00.setUlIdEventPerson(idPerson != null ? idPerson : 0);

      // STGAP00005490 - Save the person full name in the structure
      csub45so.setSzNmPersonFull(callGetPersonFullName(idPerson));
      
    } else if (0 != idEvent) {

      // Event simple retrieve
      // ccmn45dQUERYdam
      callGetEvents(idEvent, rowcsub45sog00);
      String legal_EventStatus = rowcsub45sog00.getSzCdEventStatus_ARRAY().getSzCdEventStatus(LEGAL_STATUS);

      // Check the stage record because it is possible to get to this
      // point
      // cleanly with out have to check the case code
      if (legal_EventStatus.equals(CodesTables.CEVTSTAT_NEW)) {

        if (CodesTables.CSTAGES_SUB.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_ADO.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_PAD.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_PFC.equals(csub45si.getSzCdStage())) {

          // rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec,
          // pCINV51DOutputRec);

          idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                        CodesTables.CINVROLE_PC);

          if (idPerson == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          csub45so.setUlIdPerson(idPerson != null ? idPerson : 0);

          // STGAP00005490 - Save the person full name in the structure
          csub45so.setSzNmPersonFull(callGetPersonFullName(idPerson));

        }
      // STGAP00004618 - add NEW_USING page mode so when child's id is populated  
      } else if (PageModeConstants.NEW.equals(csub45si.getCSysIndDamCalled()) || PageModeConstants.NEW_USING.equals(csub45si.getCSysIndDamCalled())) {

        if (CodesTables.CSTAGES_SUB.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_ADO.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_PAD.equals(csub45si.getSzCdStage())
            || CodesTables.CSTAGES_PFC.equals(csub45si.getSzCdStage())) {

          // Legal Status simple retrieve
          // cses11ddQUERYdam
          callGetLegalStatus(idEvent, rowcsub45sog01);

          // Get IdPerson given IdStage & Role
          idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                        CodesTables.CINVROLE_PC);

          if (idPerson == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

          csub45so.setUlIdPerson(idPerson != null ? idPerson : 0);

          // STGAP00005490 - Save the person full name in the structure
          csub45so.setSzNmPersonFull(callGetPersonFullName(idPerson));
          
        }
      } else { 
        
        // CdStage is != FC or ADO

        // Legal Status simple retrieve
        // cses11dQUERYdam
        callGetLegalStatus(idEvent, rowcsub45sog01);
        
        // STGAP00005490 - get Person ID from structure.
        idPerson = rowcsub45sog01.getUlIdPerson();
        
        // SWR 6/2/2008 STGAP00004587 - Set Person ID in output struct since it is used in
        // save operation to determine if SMILE updates should be sent.
        csub45so.setUlIdPerson(idPerson);
        
        // STGAP00005490 - Save the person full name in the structure
        csub45so.setSzNmPersonFull(callGetPersonFullName(idPerson));    
        // SMS#97845 MR-074-2 AFCARS: only set bIndPrevAfcars in Modify mode
        int idChild = afcarsAdoptionHistoryDAO.findAfcarsAdoptionHistoryIdPersonByIdPerson(idPerson);
        String bIndPrevAfcars = idChild > 0 ? ArchitectureConstants.Y : ArchitectureConstants.N;
        csub45so.setBIndPrevAfcars(bIndPrevAfcars);
      }
    }
        
    return csub45so;
  }

  private void callGetDynamicEvents(int idStage, ROWCSUB45SOG00 rowcsub45sog00) throws ServiceException {

    String[] cdEventTypes = new String[2];

    boolean extraTables = false;
    int idCase = 0;
    int idPerson = 0;
    int idSituation = 0;
    int idEventPerson = 0;
    cdEventTypes[0] = CodesTables.CEVNTTYP_CCL;
    String[] cdStages = null;
    String cdTask = null;
    Date dtScrDtStartDt = null;
    Date dtScrDtEventEnd = null;

    // ccmn87dQUERYdam
    List<Object[]> dynamicEventList = dynamicEventDAO.findEvents(extraTables, idCase, idStage, idPerson, idSituation,
                                                                 idEventPerson, cdEventTypes, cdStages, cdTask,
                                                                 dtScrDtStartDt, dtScrDtEventEnd, null);

    if (dynamicEventList == null || dynamicEventList.isEmpty()) {
      if (rowcsub45sog00.getSzCdEventStatus_ARRAY() == null) {
        SzCdEventStatus_ARRAY szCdEventStatus_ARRAY = new SzCdEventStatus_ARRAY();
        szCdEventStatus_ARRAY.addSzCdEventStatus("");
        szCdEventStatus_ARRAY.addSzCdEventStatus("");
        rowcsub45sog00.setSzCdEventStatus_ARRAY(szCdEventStatus_ARRAY);
      }
      rowcsub45sog00.getSzCdEventStatus_ARRAY().setSzCdEventStatus(STAGE_CLOSURE, CodesTables.CEVTSTAT_NEW);
    } else if (!(dynamicEventList == null || dynamicEventList.isEmpty())) {
      Object[] firstRow = dynamicEventList.get(0);
      SzCdEventStatus_ARRAY szCdEventStatus_ARRAY = rowcsub45sog00.getSzCdEventStatus_ARRAY();
      if (szCdEventStatus_ARRAY == null) {
        szCdEventStatus_ARRAY = new SzCdEventStatus_ARRAY();
        szCdEventStatus_ARRAY.addSzCdEventStatus("");
        szCdEventStatus_ARRAY.addSzCdEventStatus("");
        rowcsub45sog00.setSzCdEventStatus_ARRAY(szCdEventStatus_ARRAY);
      }
      rowcsub45sog00.getSzCdEventStatus_ARRAY().setSzCdEventStatus(STAGE_CLOSURE, (String) firstRow[0]);
      UlIdEvent_ARRAY_CSUB45S idEvent_ARRAY_CSUB45S = rowcsub45sog00.getUlIdEvent_ARRAY_CSUB45S();
      if (idEvent_ARRAY_CSUB45S == null) {
        idEvent_ARRAY_CSUB45S = new UlIdEvent_ARRAY_CSUB45S();
        idEvent_ARRAY_CSUB45S.addUlIdEvent(-1);
        idEvent_ARRAY_CSUB45S.addUlIdEvent(-1);
        rowcsub45sog00.setUlIdEvent_ARRAY_CSUB45S(idEvent_ARRAY_CSUB45S);
      }
      rowcsub45sog00.getUlIdEvent_ARRAY_CSUB45S().setUlIdEvent(STAGE_CLOSURE, (Integer) firstRow[6]);
    } // end ( else if !(dynamicEventList == null
  } // end callGetDynamicEvents()

  private void callGetLegalStatus(int idEvent, ROWCSUB45SOG01 rowcsub45sog01) throws ServiceException {

    LegalStatus legalStatus = legalStatusDAO.findLegalStatus(idEvent);

    if (legalStatus == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Integer idLegalStatEvent = legalStatus.getIdLegalStatEvent();
    Integer IdPerson = legalStatus.getPerson().getIdPerson();

    rowcsub45sog01.setUlIdLegalStatEvent(idLegalStatEvent != null ? idLegalStatEvent : 0);
    rowcsub45sog01.setUlIdPerson(IdPerson != null ? IdPerson : 0);
    rowcsub45sog01.setDtDtLegalStatStatusDt(DateHelper.toCastorDate(legalStatus.getDtLegalStatStatusDt()));
    rowcsub45sog01.setTsLastUpdate(legalStatus.getDtLastUpdate());
    rowcsub45sog01.setSzCdLegalStatCnty(legalStatus.getCdLegalStatCnty());
    rowcsub45sog01.setSzCdLegalStatStatus(legalStatus.getCdLegalStatStatus());
    rowcsub45sog01.setDtDtLegalStatPMDueDt(DateHelper.toCastorDate(legalStatus.getDtLegalStatPMDueDt()));
    rowcsub45sog01.setDtDtLegalStatCrtOrdExpDt(DateHelper.toCastorDate(legalStatus.getDtLegalStatCrtOdrExpDt()));
    rowcsub45sog01.setDtDtLegalStatCustExpDt(DateHelper.toCastorDate(legalStatus.getDtLegalStatCusExpDt()));
    rowcsub45sog01.setBIndLegalStatRisk(legalStatus.getIndLegalStatRisk());
  }

  private void callGetEvents(int idEvent, ROWCSUB45SOG00 rowcsub45sog00) throws ServiceException {

    Event event = eventDAO.findEventByIdEvent(idEvent);

    if (rowcsub45sog00.getUlIdEvent_ARRAY_CSUB45S() == null) {
      UlIdEvent_ARRAY_CSUB45S ulIdEvent_ARRAY_CSUB45S = new UlIdEvent_ARRAY_CSUB45S();
      ulIdEvent_ARRAY_CSUB45S.addUlIdEvent(0);
      ulIdEvent_ARRAY_CSUB45S.addUlIdEvent(0);
      rowcsub45sog00.setUlIdEvent_ARRAY_CSUB45S(ulIdEvent_ARRAY_CSUB45S);
    }

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    String legal_EventStatus = event.getCdEventStatus();
    Person eventPerson = event.getPerson();
    rowcsub45sog00.setSzCdEventType(event.getCdEventType());
    rowcsub45sog00.setSzTxtEventDescr(event.getTxtEventDescr());
    rowcsub45sog00.setSzCdTask(event.getCdTask());
    rowcsub45sog00.getSzCdEventStatus_ARRAY().setSzCdEventStatus(LEGAL_STATUS, legal_EventStatus);
    rowcsub45sog00.getUlIdEvent_ARRAY_CSUB45S().setUlIdEvent(LEGAL_STATUS, event.getIdEvent());
    rowcsub45sog00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowcsub45sog00.setUlIdEventPerson(eventPerson.getIdPerson() != null ? eventPerson.getIdPerson() : 0);
    rowcsub45sog00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowcsub45sog00.setTsLastUpdate(event.getDtLastUpdate());

  }


  // STGAP00005490 - added the callGetPersonFullName method
  
  /**
   * 
   * This method gets the person full name based on the person ID
   * 
   * @param idPerson
   * @return szPersonFullName
   * 
   */
  private String callGetPersonFullName(Integer idPerson) {

    Person person = personDAO.findPersonByIdPerson(idPerson);

    if (person == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    String szPersonFullName = person.getNmPersonFull(); 

    if (szPersonFullName == null) {
      szPersonFullName = "";
    }
    
    return szPersonFullName;
  }
  
}
