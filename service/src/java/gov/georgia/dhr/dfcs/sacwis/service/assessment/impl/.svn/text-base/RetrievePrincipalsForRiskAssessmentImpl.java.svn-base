package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHistory;
import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrievePrincipalsForRiskAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY;

public class RetrievePrincipalsForRiskAssessmentImpl extends BaseServiceImpl
        implements RetrievePrincipalsForRiskAssessment {

  /* Event Variables */
  private static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;
  private static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  /* Narrative Related variables */
  private static final String RISK_ASSMT_NARR = "RISK_ASSMT_NARR";
  private static final String TXT_NARR_EXISTS = "NARRATIVE";

  private static final String PRINCIPAL = CodesTables.CPRSNALL_PRN;
  private static final String NULL_STRING = "";
  private static final String FOSTER_ADOPTIVE_HOME = CodesTables.CPSNDTCT_FAH;
  private static final String ACTIVE = "A";
  private static final String NO_AP_FAH_FOUND = ArchitectureConstants.N;
  private static final String AP_FAH_FOUND = ArchitectureConstants.Y;
  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  private EventDAO eventDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private RiskAssessmentDAO riskAssessmentDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDAO personDAO = null;
  private PersonHistoryDAO personHistoryDAO = null;
  private AllegationDAO allegationDAO = null;

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonHistoryDAO(PersonHistoryDAO personHistoryDAO) {
    this.personHistoryDAO = personHistoryDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public CINV36SO retrievePrincipalsForRiskAssessment(CINV36SI cinv36si)
          throws ServiceException {
    CINV36SO cinv36so = new CINV36SO();

    int idStage = cinv36si.getUlIdStage();
    int idEvent = cinv36si.getUlIdEvent();

    // replace CallCINV80D
    ROWCINV36SOG01_ARRAY idPersonArrayList = findIdPersonByIdStageAndCdStagePersType(idStage);
    if (idPersonArrayList.getUlRowQty() > 0) {
      cinv36so.setROWCINV36SOG01_ARRAY(idPersonArrayList);
      cinv36so.getLSysNbrRow_ARRAY().setLSysNbrRow(0,
                                                   idPersonArrayList.getUlRowQty());

    } else {
      /*
          * The assumption is that there must be at least one person involved
          * with the Risk Assessment. If no Principals were found then
          * exception thrown.
          */
      cinv36so.getLSysNbrRow_ARRAY().setLSysNbrRow(0, 0);
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // replace CallCSES87D
    int numIdPerson = cinv36so.getLSysNbrRow_ARRAY().getLSysNbrRow(0);
    int i356 = 0;
    for (i356 = 0; i356 < numIdPerson; i356++) {
      int idPerson = cinv36so.getROWCINV36SOG01_ARRAY()
              .getROWCINV36SOG01(i356).getUlIdPerson();
      // cses87d
      long countAllegations = allegationDAO.countAllegationsByPersonStatusCategoryStage(idPerson, ACTIVE,
                                                                                        FOSTER_ADOPTIVE_HOME, idStage);
      if (countAllegations == 0) {
        cinv36so.setBSysIndNoDataFound(NO_AP_FAH_FOUND);
      } else {
        // subcare stage exists, need to alert user so stop search
        cinv36so.setBSysIndNoDataFound(AP_FAH_FOUND);
        i356 = numIdPerson;
      }
    }

    // replace CallCINV81D
    for (int i352 = 0; i352 < numIdPerson; i352++) {
      // re-declare idPerson serves only pupose to make it easier to see
      // what value idPerson currently holds
      int idPerson = cinv36so.getROWCINV36SOG01_ARRAY()
              .getROWCINV36SOG01(i352).getUlIdPerson();
      // cinv81d
      Person person = personDAO.findPersonByIdPerson(idPerson);
      if (person == null || person.equals(null)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // subsequent update to ROWCINV36SOG01_ARRAY
      cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352)
              .setSzNmPersonFull(person.getNmPersonFull());
      cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352)
              .setDtDtPersonBirth(
                      DateHelper.toCastorDate(person.getDtPersonBirth()));
    }

    // replace CallCCMN45D
    if (idEvent != 0) {
      // first call to ROWCCMN01UIG00 so can use set
      cinv36so.setROWCCMN01UIG00(findEvent(idEvent));
    }

    // replace CallCCMND2D
    String eventStatus = cinv36so.getROWCCMN01UIG00().getSzCdEventStatus();
    if (idEvent != 0 && !(EVENT_STATUS_NEW.equals(eventStatus))) {
      cinv36so.setROWCINV36SOG02_ARRAY(findEventPersonLinkAndPerson(
              idEvent, eventStatus));
      cinv36so.getLSysNbrRow_ARRAY().setLSysNbrRow(1,
                                                   cinv36so.getROWCINV36SOG02_ARRAY().getUlRowQty());
    }

    // replace CallCINV64D
    cinv36so.setCINV36SOG04(findRiskAssessment(idEvent));

    // replace CallCSYS13D
    if (idEvent != 0) {
      CINV36SOG05 cinv36sog05 = new CINV36SOG05();
      Date lastUpdate3 = commonDAO.findDtLastUpdate(RISK_ASSMT_NARR, idEvent);
      if (lastUpdate3 == null || lastUpdate3.toString().length() == 0) {
        cinv36sog05.setSzScrTxtNarrStatus("");
      } else {
        cinv36sog05.setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
      }
      cinv36so.setCINV36SOG05(cinv36sog05);
    }

    // replace CallCINV95D
    if (cinv36si.getSzCdStage().equals(INVESTIGATION)) {
      CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
      if (cpsInvstDetail == null) {
        cinv36so.setCdCpsOverallDisptn(NULL_STRING);
      } else {
        cinv36so.setCdCpsOverallDisptn(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn());
      }
    }
    return cinv36so;
  }

  private CINV36SOG04 findRiskAssessment(int idEvent) {
    CINV36SOG04 cin36sog04 = new CINV36SOG04();
    // cinv64d
    RiskAssessment riskAssessment = riskAssessmentDAO
            .findRiskAssessmentByIdEvent(idEvent);
    if (riskAssessment != null) {
      cin36sog04.setCdRiskAssmtPurpose(riskAssessment
              .getCdRiskAssmtPurpose());
      cin36sog04.setSzCdRiskAssmtRiskFind(riskAssessment
              .getCdRiskAssmtRiskFind());
      cin36sog04.setSzCdRiskAssmtApAccess(riskAssessment
              .getIndRiskAssmtApAccess());
      cin36sog04.setTsLastUpdate(riskAssessment.getDtLastUpdate());
    }
    return cin36sog04;
  }

  private ROWCCMN01UIG00 findEvent(int idEvent) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    if (event == null || event.equals(null)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event
            .getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn01uig00.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());

    return rowccmn01uig00;
  }

  /*
  * @return: rowcinv36sog01_array containing idPerson value, if no data found
  * UlRowQty = 0
  */
  private ROWCINV36SOG01_ARRAY findIdPersonByIdStageAndCdStagePersType(
          int idStage) {
    ROWCINV36SOG01_ARRAY rowcinv36sog01_array = new ROWCINV36SOG01_ARRAY();
    // cinv80d
    List<Integer> idPersonList = stagePersonLinkDAO
            .findIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(
                    idStage, PRINCIPAL);
    if (idPersonList == null || idPersonList.isEmpty()) {
      rowcinv36sog01_array.setUlRowQty(0);
    } else {
      for (Iterator<Integer> it = idPersonList.iterator(); it.hasNext();) {
        ROWCINV36SOG01 rowcinv36sog01 = new ROWCINV36SOG01();
        rowcinv36sog01.setUlIdPerson(it.next());
        rowcinv36sog01_array.addROWCINV36SOG01(rowcinv36sog01);
      }

    }
    return rowcinv36sog01_array;
  }

  /*
  * @return: rowcinv36sog02_array; the size (UlRowQty) of the array shows
  * whether it has data
  */
  private ROWCINV36SOG02_ARRAY findEventPersonLinkAndPerson(int idEvent,
                                                            String eventStatus) {
    ROWCINV36SOG02_ARRAY rowcinv36sog02_array = new ROWCINV36SOG02_ARRAY();
    // ccmnd2d
    List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO
            .findEventPersonLinkAndPersonByIdEvent(idEvent);
    if (eventPersonLinkList != null || !(eventPersonLinkList.isEmpty())) {
      for (Iterator<EventPersonLink> it = eventPersonLinkList.iterator(); it
              .hasNext();) {
        EventPersonLink row = it.next();
        int idPerson2 = row.getPerson().getIdPerson();
        Date lastUpdate2 = row.getDtLastUpdate();
        ROWCINV36SOG02 rowcinv36sog02 = new ROWCINV36SOG02();

        rowcinv36sog02.setUlIdPerson(idPerson2);
        rowcinv36sog02.setSzNmPersonFull(row.getPerson()
                .getNmPersonFull());
        rowcinv36sog02.setTsLastUpdate(row.getDtLastUpdate());

        if (EVENT_STATUS_APPROVED.equals(eventStatus)) {
          // cinv55d
          PersonHistory personHistory = personHistoryDAO
                  .findPersonHistoryByIdPersonAndLastUpdate(
                          idPerson2, lastUpdate2);
          if (personHistory != null || !(personHistory.equals(null))) {
            rowcinv36sog02.setSzNmPersonFull(personHistory
                    .getNmPersHistFull());
          }
        }
        rowcinv36sog02_array.addROWCINV36SOG02(rowcinv36sog02);
      }
    } else {
      rowcinv36sog02_array.setUlRowQty(0);
    }
    return rowcinv36sog02_array;
  }

}
