package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveProfessionalAssessment;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY;

public class RetrieveProfessionalAssessmentImpl extends BaseServiceImpl implements RetrieveProfessionalAssessment {

  public static final String TXT_NARR_TABLENAME = "PROF_ASSMT_NARR";

  public static final String TXT_NARR_EXISTS = "NARRATIVE";

  private EventDAO eventDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private ProfessionalAssmtDAO professionalAssmtDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private StageDAO stageDAO = null;

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CINV29SO retrieveProfessionalAssessment(CINV29SI cinv29si) throws ServiceException {

    CINV29SO cinv29so = new CINV29SO();
    cinv29so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    int idEvent = cinv29si.getUlIdEvent();
    String cdStage = new String();
    int idStage = cinv29si.getUlIdStage();

    // CallCINT21D
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cdStage = stage.getCdStage();

    // WINDOW_MODE_INQUIRE
    if (PageModeConstants.INQUIRE.equals(cinv29si.getSzSysCdWinMode())) {
      if (idEvent != 0) {
        // CallCCMN45D
        cinv29so.setROWCCMN45DO(processEventDAO(idEvent));
      }
      // CallCINV45D
      // Retrieve prof assmt table
      processProfessionalAssmtDAO(idEvent, cinv29so);

      // CallCSYS13D
      // Calls the DAM to check the existence of a narrative on the
      cinv29so.setSzScrTxtNarrStatus(processCommonDAO(idEvent));
    }
    // WINDOW_MODE_MODIFY
    else if (PageModeConstants.MODIFY.equals(cinv29si.getSzSysCdWinMode()) && idEvent != 0) {
      // CallCCMN45D
      cinv29so.setROWCCMN45DO(processEventDAO(idEvent));

      // CallCINV45D
      processProfessionalAssmtDAO(idEvent, cinv29so);

      // CallCCMN87D
      cinv29so.setUlIdEvent(callDynamicEventDAO(idStage, cdStage));

      // CallCINV47D
      cinv29so.setROWCINV29SOG01_ARRAY(processStagePersonLinkDAO(idStage));

      // CallCSYS13D
      cinv29so.setSzScrTxtNarrStatus(processCommonDAO(idEvent));
    } else {
      // CallCINV47D
      cinv29so.setROWCINV29SOG01_ARRAY(processStagePersonLinkDAO(idStage));

      // CallCCMN87D(cinv29si, cinv29so, szCdStage3, pServiceStatus);
      // retrieve a row from the Event table given ID_STAGE.
      cinv29so.setUlIdEvent(callDynamicEventDAO(idStage, cdStage));
    }

    return cinv29so;
  }

  private ROWCCMN45DO processEventDAO(int idEvent) throws ServiceException {

    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

  private void processProfessionalAssmtDAO(int idEvent, CINV29SO cinv29so) {

    // Callign cinv45d
    ProfessionalAssmt professionalAssmt = professionalAssmtDAO.findProfessionalAssmtByIdEvent(idEvent);

    if (professionalAssmt != null) {
      cinv29so
              .setUlIdPersonPrincipal(professionalAssmt.getPersonByIdPersonPrincipal() != null ? professionalAssmt
                                                                                                                  .getPersonByIdPersonPrincipal()
                                                                                                                  .getIdPerson()
                                                                                              : 0);
      cinv29so
              .setUlIdPersonProfessional(professionalAssmt.getPersonByIdPersonProfessional() != null ? professionalAssmt
                                                                                                                        .getPersonByIdPersonProfessional()
                                                                                                                        .getIdPerson()
                                                                                                    : 0);
      cinv29so.setDtProfAssmtAppt(DateHelper.toCastorDate(professionalAssmt.getDtProfAssmtAppt()));
      cinv29so.setSzNmProfAssmtName(professionalAssmt.getNmProfAssmtName());
      cinv29so.setSzNmProfAssmtPrincipal(professionalAssmt.getNmProfAssmtPrincipal());
      cinv29so.setSzTxtProfAssmtOther(professionalAssmt.getTxtProfAssmtOther());
      cinv29so.setCdProfAssmtApptRsn(professionalAssmt.getCdProfAssmtApptRsn());
      cinv29so.setTsLastUpdate(professionalAssmt.getDtLastUpdate());
      cinv29so.setCIndOutNetworkAuth(professionalAssmt.getIndOutNetworkAuth());
      cinv29so.setSzTxtProfAssmtFindings(professionalAssmt.getTxtProfAssmtFindings());
      cinv29so
              .setSzAddrProfAssmtCity(professionalAssmt.getAddrProfAssmtCity() != null ? professionalAssmt
                                                                                                          .getAddrProfAssmtCity()
                                                                                      : "");
      cinv29so
              .setSzAddrProfAssmtStLn1(professionalAssmt.getAddrProfAssmtStLn1() != null ? professionalAssmt
                                                                                                            .getAddrProfAssmtStLn1()
                                                                                        : "");
      cinv29so
              .setSzAddrProfAssmtStLn2(professionalAssmt.getAddrProfAssmtStLn2() != null ? professionalAssmt
                                                                                                            .getAddrProfAssmtStLn2()
                                                                                        : "");
      cinv29so
              .setSzAddrProfAssmtZip(professionalAssmt.getAddrProfAssmtZip() != null ? professionalAssmt
                                                                                                        .getAddrProfAssmtZip()
                                                                                    : "");
      cinv29so.setSzCdProfAssmtCounty(professionalAssmt.getCdProfAssmtCounty());
      cinv29so
              .setSzAddrProfAssmtState(professionalAssmt.getCdProfAssmtState() != null ? professionalAssmt
                                                                                                          .getCdProfAssmtState()
                                                                                      : "");
      cinv29so.setLNbrProfAssmtPhone(professionalAssmt.getNbrProfAssmtPhone());
      cinv29so
              .setLNbrPhoneExtension(professionalAssmt.getNbrProfAssmtPhoneExt() != null ? professionalAssmt
                                                                                                            .getNbrProfAssmtPhoneExt()
                                                                                        : "");
      cinv29so.setSzTxtProfAssmtCmnts(professionalAssmt.getTxtProfAssmtCmnts());
    }
  }

  private String processCommonDAO(int idEvent) {
    // CallCSYS13D
    Date dtLastUpdateByIdEvent = commonDAO.findDtLastUpdate(TXT_NARR_TABLENAME, idEvent);
    if (dtLastUpdateByIdEvent != null) {
      return TXT_NARR_EXISTS;
    } else {
      return "";
    }
  }

  private int callDynamicEventDAO(int idStage, String cdStage) throws ServiceException {

    String[] cdEventTypes = new String[1];

    if (CodesTables.CSTAGES_SVC.equals(cdStage) || CodesTables.CSTAGES_FPR.equals(cdStage)) {
      cdEventTypes[0] = CodesTables.CEVNTTYP_CCL;
    } else {
      cdEventTypes[0] = CodesTables.CEVNTTYP_STG;
    }

    boolean extraTables = false;
    int idCase = 0;
    int idPerson = 0;
    int idSituation = 0;
    int idEventPerson = 0;
    int idEventDynamic = 0;
    String[] cdStages = null;
    String cdTask = null;
    Date dtScrDtStartDt = null;
    Date dtScrDtEventEn = null;

    // ccmn87dQUERYdam
    List<Object[]> dynamicEventList = dynamicEventDAO.findEvents(extraTables, idCase, idStage, idPerson, idSituation,
                                                                 idEventPerson, cdEventTypes, cdStages, cdTask,
                                                                 dtScrDtStartDt, dtScrDtEventEn, null);

    if (dynamicEventList == null || dynamicEventList.size() <= 0) {
      return 0;
    }
    Object[] firstElement = dynamicEventList.get(0);
    if ( firstElement != null && firstElement.length > 0){
      if (CodesTables.CEVTSTAT_PEND.equals((String) firstElement[0])) {
        idEventDynamic = (Integer) firstElement[6];
      } 
    }
    
    return idEventDynamic;
  }

  private ROWCINV29SOG01_ARRAY processStagePersonLinkDAO(int idStage) {
    ROWCINV29SOG01_ARRAY rowcinv29sog01_array = new ROWCINV29SOG01_ARRAY();
    List<Map> stagePersonLinkList =
            stagePersonLinkDAO.findPersonByIdStageIdPersonCdStagePersType(idStage,
                                                                          CodesTables.CSRCRPTR_DR,
                                                                          CodesTables.CSRCRPTR_MF,
                                                                          CodesTables.CSRCRPTR_PY,
                                                                          CodesTables.CSRCRPTR_TP,
                                                                          CodesTables.CSRCRPTR_EM,
                                                                          CodesTables.CSRCRPTR_MH,
                                                                          CodesTables.CSRCRPTR_DN,
                                                                          CodesTables.CSRCRPTR_NR);

    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
      for (Iterator<Map> stagePersonLinkIt = stagePersonLinkList.iterator(); stagePersonLinkIt.hasNext();) {
        ROWCINV29SOG01 rowcinv29sog01 = new ROWCINV29SOG01();
        Map stagePersonLinkMap = stagePersonLinkIt.next();

        rowcinv29sog01.setSzScrNmGenericFullName((String) stagePersonLinkMap.get("nmPersonFull"));
        rowcinv29sog01.setUlIdPerson(stagePersonLinkMap.get("idPerson") != null ?
                                     (Integer) stagePersonLinkMap.get("idPerson") : 0);
        rowcinv29sog01_array.addROWCINV29SOG01(rowcinv29sog01);
      }
    }
    return rowcinv29sog01_array;
  }

}
