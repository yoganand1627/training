package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveReopenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49SO;

public class SaveReopenStageImpl extends BaseServiceImpl implements SaveReopenStage {

  private CapsCaseDAO capsCaseDAO = null;

  private ComplexEventDAO complexEventDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventDAO eventDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private PlacementDAO placementDAO = null;

  private RecordsRetentionDAO recordsRetentionDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private SituationDAO situationDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  public static final String SUBCARE = CodesTables.CSTAGES_SUB;

  public static final String POST_ADOPT = CodesTables.CSTAGES_PAD;

  public static final String ADOPTION = CodesTables.CSTAGES_ADO;

  public static final String SUB_EVENT_TXT_DESCRIPTION = "Subcare stage has been reopened";

  public static final String PAD_EVENT_TXT_DESCRIPTION = "PostAdoption stage has been reopened";

  public static final String FSU_EVENT_TXT_DESCRIPTION = "Family Subcare stage has been reopened";

  public static final String FRE_EVENT_TXT_DESCRIPTION = "Family Reunification stage has been reopened";

  public static final String STATUS_ACTIVE = "A";

  public static final String PRIMARY_WORKER = CodesTables.CROLEALL_PR;

  public static final String PRIMARY_CHILD = CodesTables.CROLEALL_PC;

  public static final String STAFF = "STF";

  public static final String ADOPTION_DISRUPT = "500";

  public static final String STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String SUB_SVC_AUTH = "3020";

  public static final String ADO_SVC_AUTH = "8530";

  public static final String SERVICE_AUTH_TYPE = CodesTables.CEVNTTYP_AUT;

  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_TYPE_STG = CodesTables.CEVNTTYP_ROP;

  public static final String SUB_CLOSURE = "3270";

  public static final String PAD_CLOSURE = "9260";

  public static final String FSU_CLOSURE = "4110";

  public static final String FRE_CLOSURE = "5560";

  public static final String FAM_SUBCARE_STAGE = CodesTables.CSTAGES_FSU;

  public static final String FAM_REUNIF_STAGE = CodesTables.CSTAGES_FRE;

  public static final String SUB_TODO_1 = "SUB001";

  public static final String SUB_TODO_2 = "SUB046";

  public static final String SUB_TODO_3 = "SUB047";

  public static final String EMP_IS_NEW = "1";

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public CCMN49SO saveReopenStage(CCMN49SI ccmn49si) throws ServiceException {
    CCMN49SO ccmn49so = new CCMN49SO();
    Date dtCurrentDate = new Date();
    int ccmn49siIdStage = ccmn49si.getUlIdStage();
    int ccmn49siIdCase = ccmn49si.getUlIdCase();
    int ccmn49siIdPerson = ccmn49si.getUlIdPerson();
    String ccmn49siCdStage = ccmn49si.getSzCdStage();

    // cint40dQUERYdam
    Stage cint40dStage = stageDAO.findStageByIdStage(ccmn49siIdStage);

    if (cint40dStage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // caud47dAUDdam - reopen the stage on the stage table
    int caud47dRowsUpdated = stageDAO.updateStage(null, "", "", cint40dStage.getDtLastUpdate(), ccmn49siIdStage);

    if (caud47dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG01_ARRAY rowCcmn01UiG01Array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowCcmn01UiG01 = new ROWCCMN01UIG01();
    rowCcmn01UiG01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowCcmn01UiG01Array.addROWCCMN01UIG01(rowCcmn01UiG01);
    ROWCCMN01UIG00 rowCcmn01UiG00 = new ROWCCMN01UIG00();
    rowCcmn01UiG00.setROWCCMN01UIG01_ARRAY(rowCcmn01UiG01Array);
    rowCcmn01UiG00.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
    rowCcmn01UiG00.setSzCdEventType(EVENT_TYPE_STG);

    String txtEventDesc = "";
    if (SUBCARE.equals(ccmn49siCdStage)) {
      txtEventDesc = SUB_EVENT_TXT_DESCRIPTION;
    } else if (FAM_SUBCARE_STAGE.equals(ccmn49siCdStage)) {
      txtEventDesc = FSU_EVENT_TXT_DESCRIPTION;
    } else if (FAM_REUNIF_STAGE.equals(ccmn49siCdStage)) {
      txtEventDesc = FRE_EVENT_TXT_DESCRIPTION;
    } else {
      txtEventDesc = PAD_EVENT_TXT_DESCRIPTION;
    }
    rowCcmn01UiG00.setSzTxtEventDescr(txtEventDesc);
    rowCcmn01UiG00.setUlIdStage(ccmn49siIdStage);
    rowCcmn01UiG00.setDtDtEventOccurred(DateHelper.toCastorDate(dtCurrentDate));

    ccmn01ui.setROWCCMN01UIG00(rowCcmn01UiG00);
    try {
      postEvent.postEvent(ccmn01ui);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
        default:
          throw new ServiceException(errorCode);
      }
    }

    if (POST_ADOPT.equals(ccmn49siCdStage)) {

      // cmsc18dAUDdam
      int rowsUpdatedCapsCase = capsCaseDAO.updateCapsCaseDtCaseClosed(null, ccmn49siIdCase);

      if (rowsUpdatedCapsCase == 0) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      // cmsc17dAUDdam
      int rowsUpdatedSituation = situationDAO.updateSituation(null, cint40dStage.getSituation().getIdSituation());

      if (rowsUpdatedSituation == 0) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      // ccmnb9dQUERYdam
      List<StagePersonLink> ccmnB9dStagePersonLinkList =
              stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(ccmn49siIdStage);

      if (ccmnB9dStagePersonLinkList.isEmpty()) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      //ccmnd3d & cmsc19d
      createPrimaryWorker(ccmnB9dStagePersonLinkList, ccmn49siIdPerson,
                          ccmn49siIdStage, ccmn49siCdStage);

      //  For PostAdopt, since we reopen the case, we need to
      //  remove the records retention record and update the
      //  status of the people in the stage to active again
      //  as they were made inactive when the case was closed

      // cses56dQUERYdam CORLEYAN - Commenting this DAO out b/c 
      // the data it retrieves is never used
      // RecordsRetention recordsRetention = recordsRetentionDAO.findRecordsRetention(ccmn49siIdCase);
      // recordsRetention.getCapsCase().setIdCase(ccmn49siIdCase);

      RecordsRetention recordsRetention = new RecordsRetention();
      recordsRetention.getCapsCase().setIdCase(ccmn49siIdCase);
      // caud75dAUDdam
      recordsRetentionDAO.deleteRecordsRetention(ccmn49siIdCase, ccmn49si.getCreatedOn());

      // Retreive all non-staff persons associated with the
      // case and make them active, as they had been marked
      // inactive.

      Iterator itCcmnB9dstagePersonLink = ccmnB9dStagePersonLinkList.iterator();

      // Loop through all rows returned looking for the
      // people that are not staff. For each row retrieved
      // that is not a staff person, make that person
      // active again.

      while (itCcmnB9dstagePersonLink.hasNext()) {
        StagePersonLink ccmnB9dStagePersonLink = (StagePersonLink) itCcmnB9dstagePersonLink.next();
        if (!STAFF.equals(ccmnB9dStagePersonLink.getCdStagePersType())) {
          String cdPersonStatus = STATUS_ACTIVE;

          // caud74dAUDdam
          int caud74dRowsUpdated =
                  personDAO.updatePersonCdPersonStatus(ccmnB9dStagePersonLink.getPerson().getIdPerson(),
                                                       cdPersonStatus);

          if (caud74dRowsUpdated == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }// end if the person is not Staff
      }
    }// end if it's a PAD stage

    //  For Subcare, we must verify that the Placement Removal Reason
    //  is Adoption Disruption, if it is not, we return to the client.
    //  If the placement removal reason is correct, we find the
    //  primary worker for the Adoption stage and assign the reopened
    //  Subcare stage to that worker
    int idPrimaryChild = 0;
    if (SUBCARE.equals(ccmn49siCdStage)) {

      // Find the PC of the current SUB stage first
      // ccmnb9dQUERYdam
      List<StagePersonLink> ccmnB9dStagePersonLinkList = stagePersonLinkDAO
              .findStagePersonLinkRowsByIdStage(ccmn49siIdStage);

      if (ccmnB9dStagePersonLinkList.isEmpty()) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      Iterator itCcmnB9dStagePersonLink = ccmnB9dStagePersonLinkList.iterator();

      // Loop through all rows returned looking for the
      // people that are not staff. For each row retrieved
      // that is not a staff person, make that person
      // active again.
      while (itCcmnB9dStagePersonLink.hasNext() && 0 == idPrimaryChild) {
        StagePersonLink ccmnB9dStagePersonLink = (StagePersonLink) itCcmnB9dStagePersonLink.next();
        String ccmnB9dCdStagePersRole = ccmnB9dStagePersonLink.getCdStagePersRole();
        int ccmnB9dIdPerson = ccmnB9dStagePersonLink.getPerson().getIdPerson();

        if (PRIMARY_CHILD.equals(ccmnB9dCdStagePersRole)) {
          idPrimaryChild = ccmnB9dIdPerson;
        }
      }

      //  Now find all SUB stages associated with the case that are open
      //  and have the same the primary child of the SUB stage that is
      //  being reopened.
      // clss30dQUERYdam
      List<Stage> clss30dStageList = stageDAO.findStagesByIdCase(ccmn49siIdCase);

      if (clss30dStageList == null || clss30dStageList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      Iterator itClss30dStage = clss30dStageList.iterator();

      // Loop through all the stages returned looking for all SUB stage
      // that are not closed and not equal to the SUB stage being
      // reopened.
      while (itClss30dStage.hasNext()) {
        Stage clss30dStage = (Stage) itClss30dStage.next();
        int clss30dIdStage = clss30dStage.getIdStage();

        if (SUBCARE.equals(clss30dStage.getCdStage()) &&
            DateHelper.isNull(clss30dStage.getDtStageClose()) &&
            clss30dIdStage != ccmn49siIdStage) {
          // if an open SUB stage is found that is not the SUB stage
          // being reopened then call CCMNB9D to find the primary child
          // of that stage.
          // ccmnb9dQUERYdam
          List<StagePersonLink> clss30diStagePersonLinkList = stagePersonLinkDAO
                  .findStagePersonLinkRowsByIdStage(clss30dIdStage);

          if (clss30diStagePersonLinkList.isEmpty()) {
            throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
          }

          Iterator itClss30diStagePersonLink = clss30diStagePersonLinkList.iterator();

          // Loop through all rows returned looking for the
          // primary child. If that primary child is the same
          // as the primary child of the stage to be opened
          // display a message and return to calling window.

          while (itClss30diStagePersonLink.hasNext()) {
            StagePersonLink clss30diStagePersonLink = (StagePersonLink) itCcmnB9dStagePersonLink.next();
            int clss30diIdPerson = clss30diStagePersonLink.getPerson().getIdPerson();

            if (PRIMARY_CHILD.equals(clss30diStagePersonLink.getCdStagePersRole()) &&
                idPrimaryChild == clss30diIdPerson) {
              throw new ServiceException(Messages.MSG_ROP_SUB_OPEN);
            }
          }// end while
        }// end if the stage found is subcare, open and not the stage that is being reopened
      }// end while

      //  Now find the Adoption stage that is open that this child
      //  is the PC of
      // csec29dQUERYdam
      StagePersonLink csec29dStagePersonLink = stagePersonLinkDAO
              .findStagePersonLinkByCdStageIdPersonCdRoleIdcase(
                      ADOPTION,
                      idPrimaryChild,
                      PRIMARY_CHILD,
                      ccmn49siIdCase);

      if (csec29dStagePersonLink == null) {
        throw new ServiceException(Messages.MSG_ROP_NO_DISRUPT);
      }
      int idAdoptionStage = csec29dStagePersonLink.getStage().getIdStage();

      //  Now find the primary
      //  worker of the adoption stage.
      // ccmnb9dQUERYdam
      List<StagePersonLink> ccmnB9dStagePersonLinkASList = stagePersonLinkDAO
              .findStagePersonLinkRowsByIdStage(idAdoptionStage);

      if (ccmnB9dStagePersonLinkASList.isEmpty()) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      Iterator itCcmnB9dStagePersonLinkAS = ccmnB9dStagePersonLinkASList.iterator();

      // If the adoption stage is closed a primary worker will
      // not be returned. If a primary worker
      // is not found the worker reopening the stage will
      // be assigned as the primary worker. The primary worker
      // is set equal to the user prior to looping through the
      // the output of the dam. If a primary worker is not
      // found then the user will remain the primary worker of
      // the re-opened subcare stage.

      int idPrimWorker = ccmn49siIdPerson;

      // Loop through all rows returned looking for the
      // primary worker of the adoption stage.
      while (itCcmnB9dStagePersonLinkAS.hasNext()) {
        StagePersonLink ccmnB9dStagePersonLinkAS = (StagePersonLink) itCcmnB9dStagePersonLinkAS.next();
        String ccmnB9dCdStagePersType = ccmnB9dStagePersonLinkAS.getCdStagePersType();
        String ccmnB9dCdStagePersRole = ccmnB9dStagePersonLinkAS.getCdStagePersRole();
        int ccmnB9dIdPerson = ccmnB9dStagePersonLinkAS.getPerson().getIdPerson();

        if (STAFF.equals(ccmnB9dCdStagePersType) && PRIMARY_WORKER.equals(ccmnB9dCdStagePersRole)) {
          idPrimWorker = ccmnB9dIdPerson;
        }
      }

      //ccmnd3d & cmsc19d
      createPrimaryWorker(ccmnB9dStagePersonLinkList, idPrimWorker, ccmn49siIdStage, ccmn49siCdStage);

      //  After we have the primary child, we need to determine that the
      //  most recent placement for that child has a removal reason of
      //  Adoption Disruption, if not, we message the user that the child
      //  must have had the Adoptive Placement disrupted to reopen the
      //  Subcare stage
      // cses34dQUERYdam
      Placement cses34dPlacement = placementDAO.findPlacementByIdPlcmtChildDtPlcmtStart(idPrimaryChild);
      Date csec34dDtPlcmtEnd = cses34dPlacement.getDtPlcmtEnd();

      if (cses34dPlacement == null) {
        throw new ServiceException(Messages.MSG_ROP_NO_DISRUPT);
      }
      if (DateHelper.isNull(csec34dDtPlcmtEnd) || DateHelper.MAX_JAVA_DATE.equals(csec34dDtPlcmtEnd)
          || !ADOPTION_DISRUPT.equals(cses34dPlacement.getCdPlcmtRemovalRsn())) {
        throw new ServiceException(Messages.MSG_ROP_NO_DISRUPT);
      }

      //  If we have gotten this far with RetVal = SUCCESS, then
      //  everything has been done for reopening the Subcare
      //  stage except moving the open, approved, unduplicated
      //  service auth's to the reopened subcare stage

      String[] cdEventTypes = new String[] {SERVICE_AUTH_TYPE};
      boolean extraTables = false;
      int idCase = 0;
      int idPerson = 0;
      int idSituation = 0;
      int idEventPerson = 0;
      String[] cdStages = null;
      Date dtScrDtStartDt = null;
      Date dtScrDtEventEn = null;

      // ccmn87dQUERYdam
      List<Object[]> ccmn87DynamicEventList =
              dynamicEventDAO.findEvents(extraTables, idCase, idAdoptionStage,
                                         idPerson, idSituation, idEventPerson,
                                         cdEventTypes, cdStages, ADO_SVC_AUTH,
                                         dtScrDtStartDt, dtScrDtEventEn, null);

      if (ccmn87DynamicEventList != null) {
        Iterator itCcmn87DynamicEventList = ccmn87DynamicEventList.iterator();

        while (itCcmn87DynamicEventList.hasNext()) {
          Object[] ccmn87DynamicEvent = (Object[]) itCcmn87DynamicEventList.next();
          String ccmn87CdEventStatus = (String) ccmn87DynamicEvent[0];
          String[] ccmn87CdEventTypes = (String[]) ccmn87DynamicEvent[1];
          String ccmn87CdEventType = ccmn87CdEventTypes[0];
          Date ccmn87DtEventOccurred = (Date) ccmn87DynamicEvent[3];
          String ccmn87TxtEventDescr = (String) ccmn87DynamicEvent[10];
          int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];

          if (STATUS_APPROVED.equals(ccmn87CdEventStatus) &&
              SERVICE_AUTH_TYPE.equals(ccmn87CdEventType)) {

            // cses24dQUERYdam
            ServiceAuthorization cses24dSvcAuth =
                    serviceAuthorizationDAO.findServiceAuthEventLink(ccmn87IdEvent);
            if (cses24dSvcAuth == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            int cses24dIdSvcAuth = cses24dSvcAuth.getIdSvcAuth();

            // Use CLSC73d to make sure the Approved SvcAuth does not
            // already exist in the Subcare stage, if it does, don't
            // copy it back
            // clsc73dQUERYdam
            List<Map> clsc73dSvcAuthEventLinkListMap = svcAuthEventLinkDAO
                    .findEventStageAndIdSvcAuthByIdSvcAuth(cses24dIdSvcAuth);

            if (clsc73dSvcAuthEventLinkListMap == null || clsc73dSvcAuthEventLinkListMap.isEmpty()) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            if (clsc73dSvcAuthEventLinkListMap.size() <= 1) {

              // cses23dQUERYdam
              ServiceAuthorization cses23dSvcAuth =
                      serviceAuthorizationDAO.findServiceAuth(cses24dIdSvcAuth);

              if (cses23dSvcAuth == null) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }

              if (ArchitectureConstants.Y.equals(cses23dSvcAuth.getIndSvcAuthComplete())) {

                // clss24dQUERYdam
                List<SvcAuthDetail> clss24dSvcAuthDetailList = svcAuthDetailDAO
                        .findServiceAuthDetailPersonByIdSvcAuth(cses24dIdSvcAuth);

                if (clss24dSvcAuthDetailList == null || clss24dSvcAuthDetailList.isEmpty()) {
                  throw new ServiceException(Messages.SQL_NOT_FOUND);
                }

                Iterator itClss24dSvcAuthDetailList = clss24dSvcAuthDetailList.iterator();

                while (itClss24dSvcAuthDetailList.hasNext()) {
                  SvcAuthDetail clss24dSvcAuthDetail = (SvcAuthDetail) itClss24dSvcAuthDetailList.next();
                  if (DateHelper.isBefore(dtCurrentDate, clss24dSvcAuthDetail.getDtSvcAuthDtlTerm())) {
                    String ccmn46DiCdEventType = SERVICE_AUTH_TYPE;
                    Date ccmn46DiDtEventOccurred = ccmn87DtEventOccurred;
                    int ccmn46DiIdStage = ccmn49siIdStage;
                    String ccmn46DiTxtEventDescr = ccmn87TxtEventDescr;
                    String ccmn46DiCdEventStatus = ccmn87CdEventStatus;
                    String ccmn46DiCdTask = SUB_SVC_AUTH;
                    int ccmn46DiIdPerson = 0;

                    // ccmn46dAUDdam
                    int ccmn46DoIdEvent = complexEventDAO.insertEvent(ccmn46DiCdEventStatus,
                                                                      ccmn46DiCdEventType,
                                                                      ccmn46DiDtEventOccurred,
                                                                      ccmn46DiIdPerson,
                                                                      ccmn46DiIdStage,
                                                                      ccmn46DiTxtEventDescr,
                                                                      ccmn46DiCdTask);

                    if (ccmn46DoIdEvent == 0) {
                      throw new ServiceException(Messages.SQL_NOT_FOUND);
                    }

                    SvcAuthEventLink caud34DiSvcAuthEventLink = new SvcAuthEventLink();
                    caud34DiSvcAuthEventLink.getServiceAuthorization().setIdSvcAuth(cses24dIdSvcAuth);
                    caud34DiSvcAuthEventLink.setIdSvcAuthEvent(ccmn46DoIdEvent);

                    // caud34dAUDdam
                    svcAuthEventLinkDAO.saveSvcAuthEventLink(caud34DiSvcAuthEventLink);

                    // ccmnd2dQUERYdam
                    List<EventPersonLink> ccmnd2dEventPersonLinkList = eventPersonLinkDAO
                            .findEventPersonLinkAndPersonByIdEvent(ccmn87IdEvent);

                    if (ccmnd2dEventPersonLinkList == null || ccmnd2dEventPersonLinkList.isEmpty()) {
                      throw new ServiceException(Messages.SQL_NOT_FOUND);
                    }

                    Iterator itCcmnd2dEventPersonLink = ccmnd2dEventPersonLinkList.iterator();

                    while (itCcmnd2dEventPersonLink.hasNext()) {
                      EventPersonLink ccmnd2dEventPersonLink = (EventPersonLink) itCcmnd2dEventPersonLink.next();
                      //ccmn68dAUDdam
                      int ccmn68dRowsUpdated =
                              eventPersonLinkDAO.insertEventPersonLink(ccmn46DoIdEvent,
                                                                       ccmnd2dEventPersonLink.getPerson().getIdPerson());

                      if (ccmn68dRowsUpdated == 0) {
                        throw new ServiceException(Messages.SQL_NOT_FOUND);
                      }
                    }// end while event person link has next
                  } // end if todays date is before the term date
                } //itClss24dSvcAuthDetailList
              } // End if Service Auth is complete
            } // end if clsc73dSvcAuthEventLinkListMap <= 1
          } // end if the event is a service auth and approved
        } // end while event has next
      } // end if it's event is not equal to null

      //  The absolute last thing (this week) we should do is post the
      //  one todo when reopening the Subcare stage
      CSUB40UI csub40ui = new CSUB40UI();
      CSUB40UIG00 csub40UiG00 = new CSUB40UIG00();
      ArchInputStruct csub40uiArchInputStruct = ccmn49si.getArchInputStruct();
      csub40uiArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      csub40ui.setArchInputStruct(archInputStruct);
      csub40UiG00.setSzSysCdTodoCf(SUB_TODO_1);
      csub40UiG00.setUlSysIdTodoCfPersCrea(idPrimWorker);
      csub40UiG00.setUlSysIdTodoCfStage(ccmn49siIdStage);
      csub40UiG00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtCurrentDate));
      csub40ui.setCSUB40UIG00(csub40UiG00);

      callTodoCommonFunction(csub40ui);

      csub40UiG00.setSzSysCdTodoCf(SUB_TODO_2);
      csub40ui.setCSUB40UIG00(csub40UiG00);

      callTodoCommonFunction(csub40ui);

      csub40UiG00.setSzSysCdTodoCf(SUB_TODO_3);
      csub40ui.setCSUB40UIG00(csub40UiG00);

      callTodoCommonFunction(csub40ui);

    } // end if SUB

    if (FAM_SUBCARE_STAGE.equals(ccmn49siCdStage) ||
        FAM_REUNIF_STAGE.equals(ccmn49siCdStage)) {

      // ccmnb9dQUERYdam
      List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(ccmn49siIdStage);

      if (stagePersonLinkList.isEmpty()) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      createPrimaryWorker(stagePersonLinkList, ccmn49siIdPerson, ccmn49siIdStage, ccmn49siCdStage);
    }

    String[] cdEventTypes = null;
    boolean extraTables = false;
    int idCase = 0;
    int idPerson = 0;
    int idSituation = 0;
    int idEventPerson = 0;
    String[] cdStages = null;
    Date dtScrDtStartDt = null;
    Date dtScrDtEventEn = null;
    String ccmn87DiCdTask = "";
    if (SUBCARE.equals(ccmn49siCdStage)) {
      ccmn87DiCdTask = SUB_CLOSURE;
    } else if (FAM_SUBCARE_STAGE.equals(ccmn49siCdStage)) {
      ccmn87DiCdTask = FSU_CLOSURE;
    } else if (FAM_REUNIF_STAGE.equals(ccmn49siCdStage)) {
      ccmn87DiCdTask = FRE_CLOSURE;
    } else {
      ccmn87DiCdTask = PAD_CLOSURE;
    }

    // ccmn87dQUERYdam
    List<Object[]> ccmn87DynamicEventList =
            dynamicEventDAO.findEvents(extraTables, idCase, ccmn49siIdStage, idPerson, idSituation, idEventPerson,
                                       cdEventTypes, cdStages, ccmn87DiCdTask, dtScrDtStartDt, dtScrDtEventEn, null);

    if (ccmn87DynamicEventList.isEmpty()) {
      if (!POST_ADOPT.equals(ccmn49siCdStage)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }

    Iterator itCcmn87DynamicEventList = ccmn87DynamicEventList.iterator();

    while (itCcmn87DynamicEventList.hasNext()) {
      Object[] ccmn87DynamicEvent = (Object[]) itCcmn87DynamicEventList.next();
      int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];

      // ccmn45dQUERYdam
      Event ccmn45dEvent = eventDAO.findEventByIdEvent(ccmn87IdEvent);
      if (ccmn45dEvent == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // ccmn46dAUDdam
      eventDAO.deleteEvent(ccmn45dEvent.getIdEvent(), ccmn45dEvent.getDtLastUpdate());
    }

    return ccmn49so;
  }

  private void createPrimaryWorker(List ccmnB9dStagePersonLinkList,
                                   int idPerson, int ccmn49siIdStage, String cdStage) throws ServiceException {
    // Now assign this PostAdoption stage to the person
    // who is reopening (should be a supervisor).
    // We need to determine who the HP for the PAD case
    // is as they may be the same person reopening the
    // PAD case and we need to UPDATE, not ADD the Stage
    // Person Link row in that case
    Iterator itCcmnB9dStagePersonLink = ccmnB9dStagePersonLinkList.iterator();
    int idWorker = 0;
    int idLink = 0;
    boolean bDeleteHP = false;
    Date dtCurrentDate = new Date();
    while (itCcmnB9dStagePersonLink.hasNext()) {
      StagePersonLink ccmnB9dStagePersonLink = (StagePersonLink) itCcmnB9dStagePersonLink.next();
      String ccmnB9dCdStagePersType = ccmnB9dStagePersonLink.getCdStagePersType();
      if (STAFF.equals(ccmnB9dCdStagePersType)) {
        idLink = ccmnB9dStagePersonLink.getIdStagePersonLink();
        // For FSU and FRE stages, set the id worker to 
        // the input id, b/c the new stage is always assigned
        // to the person reopening the stage
        if (FAM_SUBCARE_STAGE.equals(cdStage) ||
            FAM_REUNIF_STAGE.equals(cdStage)) {
          idWorker = idPerson;
        } else {
          idWorker = ccmnB9dStagePersonLink.getPerson().getIdPerson();
        }
      }
    }
    int ccmnd3dRowsUpdated = 0;

    if (idWorker == idPerson) {
      //ccmnd3d
      ccmnd3dRowsUpdated =
              stagePersonLinkDAO.updateStagePersonLinkWithoutIndNmStage(idPerson, PRIMARY_WORKER,
                                                                        STAFF, null, null,
                                                                        dtCurrentDate, null, null, null,
                                                                        EMP_IS_NEW, idLink, null,null);
    } else {
      bDeleteHP = true;
      //ccmnd3d
      ccmnd3dRowsUpdated = stagePersonLinkDAO.insertStagePersonLinkWihoutIndNmStage(ccmn49siIdStage, idPerson,
                                                                                    PRIMARY_WORKER, STAFF, null,
                                                                                    null, dtCurrentDate, null, null,
                                                                                    null, EMP_IS_NEW, null,null);
    }
    if (ccmnd3dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    if (bDeleteHP == true) {

      // cmsc19dAUDdam
      int cmsc19dRowsUpdated = stagePersonLinkDAO.deleteStagePersonLinkByIdStage(ccmn49siIdStage, PRIMARY_WORKER);

      if (cmsc19dRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
  }

  private void callTodoCommonFunction(CSUB40UI csub40ui) throws ServiceException {
    try {
      todoCommonFunction.audTodo(csub40ui);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
        default:
          throw new ServiceException(errorCode);
      }
    }

  }

}
