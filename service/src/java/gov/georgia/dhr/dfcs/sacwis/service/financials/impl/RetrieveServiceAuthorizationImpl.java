package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY;
/**
 * Change History
 * 
 * <PRE>
 * 
 * Date        Updated by     Description
 * ---------   ------------   -------------------------------------
 * 04/08/2009   arege         STGAP00010887 Used new method to find contractcounty within the date rangeSvAuth and by idContract
 *                            to resolve an error message being displayed after clicking the ServiceAuthDetail id on Service
 *                            Authorization and Referral Header page.
 * 02/01/2012   vcollooru	  STGAP00017831: MR-102- Modified to add a new parameter bIndBLOBExistsInDatabase to CCON18SO object
 * 							  to hold the value Y or N based upon the document exists in or not, in service_authorization_narr table,
 * 							  for the given service authorization.
 * 
 * </PRE>
 */

public class RetrieveServiceAuthorizationImpl extends BaseServiceImpl implements RetrieveServiceAuthorization {

  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;

  private static final String SUBCARE = CodesTables.CSTAGES_SUB;

  private static final String FAMILY_SUBCARE = CodesTables.CSTAGES_FSU;

  private static final String FAMILY_REUNIF = CodesTables.CSTAGES_FRE;

  private static final String ADOPTION = CodesTables.CSTAGES_ADO;

  private static final String FAMILY_PRES = CodesTables.CSTAGES_FPR;

  private static final String POST_ADOPTION = CodesTables.CSTAGES_PAD;

  private static final String SERVICE_DELIVERY = CodesTables.CSTAGES_SVC;

  private static final String PAL = CodesTables.CSTAGES_PAL;

  private static final String AGING_OUT = CodesTables.CSTAGES_AOC;

  private static final String PRINCIPAL = CodesTables.CPRSNTYP_PRN;

  private static final String PRIMARY_CHILD = CodesTables.CROLEALL_PC;

  private static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  private static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  private static final String EVENT_TYPE_CCL = CodesTables.CEVNTTYP_CCL;

  private static final String EVENT_TYPE_STG = CodesTables.CEVNTTYP_STG;

  private static final String SERVICE_AUTHORIZATION_NARRATIVE = "service_authorization_narr";

  private CheckStageEventStatus checkStageEventStatus = null;

  private CapsResourceDAO capsResourceDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventDAO eventDAO = null;

  private PersonMergeDAO personMergeDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
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

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public CCON18SO retrieveServiceAuthorization(CCON18SI ccon18si) throws ServiceException {
    CCON18SO ccon18so = new CCON18SO();
    ArchInputStruct archInputStruct = ccon18si.getArchInputStruct();
    String reqFuncCd = archInputStruct.getCReqFuncCd();
    String inputCdStage = ccon18si.getSzCdStage();

    int inputIdStage = ccon18si.getUlIdStage();
    if (!PageModeConstants.INQUIRE.equals(reqFuncCd)) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setUlIdStage(inputIdStage);
      ccmn06ui.setSzCdTask(ccon18si.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      try {
        checkStageEventStatus.status(ccmn06ui);
      } catch (ServiceException se) {
        int errorCode = se.getErrorCode();
        switch (errorCode) {
        // Change the message for two error codes, otherwise just throw
        // the error returned.
        case Messages.MSG_SYS_STAGE_CLOSED:
          // Issue STGAP00007313 just let the user to be see the entry
          break;
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
        default:
          throw se;
        }
      }
    }
    if (PageModeConstants.NEW.equals(reqFuncCd) || PageModeConstants.NEW_USING.equals(reqFuncCd)) {
      checkStages(ccon18si.getUlIdCase(), inputIdStage, inputCdStage);
    }

    // retrieve Principals for the Id Stage - clsc18d
    ccon18so.setROWCCON18SOG00_ARRAY(retrievePrincipals(inputIdStage));

    // Removed APS check here, APS and APS Outcome Matrix will not exist for Georgia SACWIS
    int ulIdEvent = ccon18si.getUlIdEvent();
    if (ulIdEvent != 0) {
      ccon18so.setROWCCMN01UIG00(retrieveEventInfo(ulIdEvent));
      // STGAP00017831: checking if the SA form exists in the DB
      ccon18so.setBIndBLOBExistsInDatabase(setBlobExists(ulIdEvent));
      // Removed check for APS client factors
      if (!EVENT_STATUS_NEW.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
        // cses24d
        SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId(ulIdEvent);
        if (svcAuthEventLink == null) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
        Integer idSvcAuth = svcAuthEventLink.getServiceAuthorization().getIdSvcAuth();
        ccon18so.setUlIdSvcAuth(idSvcAuth != null ? idSvcAuth : 0);
        // cses23d
        ServiceAuthorization serviceAuthorizationInfo = serviceAuthorizationDAO.findServiceAuth(idSvcAuth);
        if (serviceAuthorizationInfo == null) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
        ccon18so
                .setUlIdResource(serviceAuthorizationInfo.getCapsResource().getIdResource() != null ? serviceAuthorizationInfo
                                                                                                                              .getCapsResource()
                                                                                                                              .getIdResource()
                                                                                                   : 0);
        ccon18so
                .setUlIdContract(serviceAuthorizationInfo.getContract().getIdContract() != null ? serviceAuthorizationInfo
                                                                                                                          .getContract()
                                                                                                                          .getIdContract()
                                                                                               : 0);

        ccon18so.setSzCdSvcAuthCounty(serviceAuthorizationInfo.getCdSvcAuthCounty());

        ccon18so.setSzCdSvcAuthService(serviceAuthorizationInfo.getCdSvcAuthService());
        ccon18so.setSzCdSvcAuthCategory(serviceAuthorizationInfo.getCdSvcAuthCategory());
        ccon18so.setSzTxtSvcAuthComments(serviceAuthorizationInfo.getTxtSvcAuthComments());
        ccon18so.setSzTxtSvcAuthSecProvdr(serviceAuthorizationInfo.getTxtSvcAuthSecProvdr());

        ccon18so.setDtDtSvcAuthEff(DateHelper.toCastorDate(serviceAuthorizationInfo.getDtSvcAuthEff()));
        ccon18so.setTsLastUpdate(serviceAuthorizationInfo.getDtLastUpdate());
        ccon18so.setCIndWaiverReqd(serviceAuthorizationInfo.getIndWaiverReqd());
        ccon18so.setDtDtRefSent(DateHelper.toCastorDate(serviceAuthorizationInfo.getDtRefSent()));
        ccon18so.setSzCdPayCnty(serviceAuthorizationInfo.getCdPayCnty());
        ccon18so.setSzCdErlyCaseTyp(serviceAuthorizationInfo.getCdErlyCaseTyp());
        ccon18so.setSzCdPupOtcme(serviceAuthorizationInfo.getCdPupOtcme());
        ccon18so.setSzCdPupTyp(serviceAuthorizationInfo.getCdPupTyp());
        if (serviceAuthorizationInfo.getIdWaiver() != null) {
          ccon18so.setUlIdWaiver(serviceAuthorizationInfo.getIdWaiver());
        }
        // clss71d
        int idPrimaryClient = serviceAuthorizationInfo.getPersonByIdPrimaryClient().getIdPerson();
        List<Integer> personMergeInfo = personMergeDAO.findPersonMerge(idPrimaryClient);

        if (personMergeInfo == null || personMergeInfo.isEmpty()) {
          // throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        } else {
          for (Iterator<Integer> it = personMergeInfo.iterator(); it.hasNext();) {
            int idPersMergeForward = it.next();
            // cses86d
            long stagePersonLinkCount = stagePersonLinkDAO.countStagePersonLinkByIdStageAndIdPerson(inputIdStage,
                                                                                                    idPersMergeForward);
            if (stagePersonLinkCount > 0) {
              idPrimaryClient = idPersMergeForward;
            }
          }
        }
        ccon18so.setROWCCON18SOG00_ARRAY(resetArray(ccon18so.getROWCCON18SOG00_ARRAY(), idPrimaryClient));

        // clss24d
        List<SvcAuthDetail> svcAuthDetailInfo = svcAuthDetailDAO
                                                                .findServiceAuthDetailPersonByIdSvcAuth(ccon18so
                                                                                                                .getUlIdSvcAuth());

        if (svcAuthDetailInfo == null || svcAuthDetailInfo.isEmpty()) {
          ccon18so.setBScrIndDtlRecExist(ArchitectureConstants.N);
        } else {
          ccon18so.setBScrIndDtlRecExist(ArchitectureConstants.Y);
        }

        Date dtScrDtCurrentDate;
        if (!DateHelper.isNull(ccon18so.getDtDtSvcAuthEff())) {
          dtScrDtCurrentDate = serviceAuthorizationInfo.getDtSvcAuthEff();
        } else {
          dtScrDtCurrentDate = svcAuthEventLink.getDtLastUpdate();
        }
        String temp = serviceAuthorizationInfo.getCdSvcAuthService();
        String category = ccon18so.getSzCdSvcAuthCategory();
        // Here the entitlement code is converted into the service code
        String service = category + temp;

        // csec10d

        //STGAP00010887 Find contractcounty within the date rangeSvAuth and by idContract. 
        // This will give the correct contract county record and that will be used to find the period and version
        // and these are then used to findServicesContractedInCounty in the RetrieveServiceAuthorizationDetail service
        
               ContractCounty contractCountyInfo = contractCountyDAO
                                                                    .findContractCountyWithinDateRangeSvAuthByidContract(
                                                                                                             ccon18so
                                                                                                                     .getUlIdResource(),
                                                                                                             ccon18so
                                                                                                                     .getSzCdSvcAuthCounty(),
                                                                                                             ccon18so.getUlIdContract(),                                                                                                              
                                                                                                             service,
                                                                                                             dtScrDtCurrentDate);

        // STGAP00008763 if there is no Contract County found within the Date Range then we are not throwing the error
        // message yet.
        // The page will need to gather the rest of the information in the conversation to display the Service
        // Authorization page
        // instead of the ErrorMessage page also the period and version of the old contract is needed to display the
        // detail page.
        if (contractCountyInfo == null) {
          ccon18so.setError_message(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
          ContractCounty outDatedContractCountyInfo = contractCountyDAO
                                                                       .findContractCountyNoDateRangeSvAuth(
                                                                                                            ccon18so
                                                                                                                    .getUlIdResource(),
                                                                                                            ccon18so
                                                                                                                    .getSzCdSvcAuthCounty(),
                                                                                                            service);
          if (outDatedContractCountyInfo != null) {
            ccon18so
                    .setUlNbrCncntyVersion(outDatedContractCountyInfo.getNbrCncntyVersion() != null ? outDatedContractCountyInfo
                                                                                                                                .getNbrCncntyVersion()
                                                                                                   : 0);
            Integer nbrCncntyPeriod = outDatedContractCountyInfo.getNbrCncntyPeriod();
            ccon18so.setUlNbrCncntyPeriod(nbrCncntyPeriod != null ? nbrCncntyPeriod : 0);
          }
        } else {
          Integer nbrCncntyPeriod = contractCountyInfo.getNbrCncntyPeriod();
          ccon18so.setUlNbrCncntyPeriod(nbrCncntyPeriod != null ? nbrCncntyPeriod : 0);
          ccon18so
                  .setUlNbrCncntyVersion(contractCountyInfo.getNbrCncntyVersion() != null ? contractCountyInfo
                                                                                                              .getNbrCncntyVersion()
                                                                                         : 0);

          // csec57d
          int idContract = contractCountyInfo.getContract().getIdContract();
          ContractPeriod contractPeriodInfo = contractPeriodDAO
                                                               .findContractPeriodByIdContractAndNbrCnperPeriod(
                                                                                                                idContract,
                                                                                                                nbrCncntyPeriod);
          if (contractPeriodInfo == null) {
            ccon18so.setError_message(Messages.MSG_CON_NO_ACTIVE_CONTRACT);

          }
          ccon18so
                  .setUlIdCntrctManager(contractPeriodInfo.getContract().getPersonByIdCntrctManager().getIdPerson() != null ? contractPeriodInfo
                                                                                                                                                .getContract()
                                                                                                                                                .getPersonByIdCntrctManager()
                                                                                                                                                .getIdPerson()
                                                                                                                           : 0);
          ccon18so.setDtDtCnperClosure(DateHelper.toCastorDate(contractPeriodInfo.getDtCnperClosure()));
          ccon18so.setDtDtCnperStart(DateHelper.toCastorDate(contractPeriodInfo.getDtCnperStart()));
          ccon18so.setCIndCnperRenewal(contractPeriodInfo.getIndCnperRenewal());
          ccon18so.setSzCdCnperStatus(contractPeriodInfo.getCdCnperStatus());
          ccon18so.setSzCdCntrctRegion(contractPeriodInfo.getContract().getCdCntrctRegion());
          ccon18so.setCIndCntrctBudgLimit(contractPeriodInfo.getContract().getIndCntrctBudgLimit());
        }
        // cres04d
        CapsResource capsResourceInfo = capsResourceDAO.findCapsResourceByIdResourceOnly(ccon18so.getUlIdResource());
        if (capsResourceInfo == null) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
        ccon18so.setSzNmResource(capsResourceInfo.getNmResource());
      }
    }

    // cses26d
    Stage stageInfo = stageDAO.findStageAndSituation(inputIdStage);
    if (stageInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ccon18so.setDtDtSituationOpened(DateHelper.toCastorDate(stageInfo.getSituation().getDtSituationOpened()));

    // cint21d
    Stage stageInfo3 = stageDAO.findStageByIdStage(inputIdStage);
    if (stageInfo3 == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    Date dtDtStageClose5 = stageInfo3.getDtStageClose();

    if (!DateHelper.isNull(dtDtStageClose5) && !DateHelper.MAX_JAVA_DATE.equals(dtDtStageClose5)) {
      ccon18so.setBIndStageClose(ArchitectureConstants.Y);
      ccon18so.setDtDtStageClose(DateHelper.toCastorDate(dtDtStageClose5));
    }
    ccon18so.setUlIdEvent(retrieveEventId(inputIdStage));
    if (ccon18so.getUlIdEvent() == 0) {
      Event eventInfo = eventDAO.findEventByIdEvent(ulIdEvent);
      if (eventInfo != null) {
        ccon18so.setUlIdEvent(eventInfo.getIdEvent());
      }
    }
    return ccon18so;
  }

  private void checkStages(int idCase, int inputIdStage, String inputCdStage) throws ServiceException {
    // clsc59d
    // List<Stage> stageInfo1 = stageDAO.findStageByIdCase(idCase);
    List<Stage> stageInfo1 = stageDAO.findOpenStagesByIdCase(idCase);
    if (stageInfo1 == null || stageInfo1.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Loop through all the rows returned by the dam and see if there have been
    // any SUBcare or Family SUbcare stages opened.
    for (Iterator<Stage> it1 = stageInfo1.iterator(); it1.hasNext();) {
      Stage stage = it1.next();
      String retrievedCdStage = stage.getCdStage();
      // STGAP00002630 - Can't add new service auth in an open investigation when there is subcare open
      // No need to check if INV still open since checkStageEventStatus already handled that before this call
      if (INVESTIGATION.equals(inputCdStage)
          && (SUBCARE.equals(retrievedCdStage) || FAMILY_SUBCARE.equals(retrievedCdStage))) {
        throw new ServiceException(Messages.MSG_SVA_NOT_FROM_INVEST);
      }
      // end STGAP00002630
      else if ((INVESTIGATION.equals(inputCdStage))
               && (FAMILY_REUNIF.equals(retrievedCdStage) || ADOPTION.equals(retrievedCdStage) || FAMILY_PRES
                                                                                                             .equals(retrievedCdStage))) {
        // If the stage passed in is INV and there is an open stage of antoher type, tell the user that the service
        // auth must be completed in the newest stage.
        throw new ServiceException(Messages.MSG_SVC_AUTH_NEW_STAGE);
      } else if (SUBCARE.equals(inputCdStage) && FAMILY_REUNIF.equals(retrievedCdStage)) {
        // If the stage passed in is SUB and there is a family reunification stage that is open, tell the user that the
        // service auth must be completed in the newest stage.
        throw new ServiceException(Messages.MSG_SVC_AUTH_NEW_STAGE);
      } else if (SUBCARE.equals(inputCdStage) && ADOPTION.equals(retrievedCdStage)) {
        // If the stage passed in is a SUB and there is an Adoption stage open, check to make sure the adoption stage
        // is for the same child as the SUB stage.

        // First get the id of the primary child in the subcare stage
        // clsc18d
        List<StagePersonLink> stagePersonLinkInfo1 = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(inputIdStage,
                                                                                                       PRINCIPAL);

        if (stagePersonLinkInfo1 == null || stagePersonLinkInfo1.isEmpty()) {
          throw new ServiceException(Messages.MSG_CON_PRINCIPLE);
        }
        int idSubPerson = 0;
        for (Iterator<StagePersonLink> it2 = stagePersonLinkInfo1.iterator(); it2.hasNext();) {
          StagePersonLink stagePersonLink1 = it2.next();
          if (PRIMARY_CHILD.equals(stagePersonLink1.getCdStagePersRole())) {
            idSubPerson = stagePersonLink1.getPerson().getIdPerson();
            break;
          }
        }

        // Then get the id of the primary child from the ADO stage
        // clsc18d
        List<StagePersonLink> stagePersonLinkInfo2 = stagePersonLinkDAO
                                                                       .findAllPrincipalsLinkedToStage(
                                                                                                       stage
                                                                                                            .getIdStage(),
                                                                                                       PRINCIPAL);
        if (stagePersonLinkInfo2 == null || stagePersonLinkInfo2.isEmpty()) {
          throw new ServiceException(Messages.MSG_CON_PRINCIPLE);
        }

        int idAdoPerson = 0;
        for (Iterator<StagePersonLink> it3 = stagePersonLinkInfo2.iterator(); it3.hasNext();) {
          StagePersonLink stagePersonLink2 = it3.next();
          if (PRIMARY_CHILD.equals(stagePersonLink2.getCdStagePersRole())) {
            idAdoPerson = stagePersonLink2.getPerson().getIdPerson();
          }
        }
        // If the two ids match, tell the user to create the service authorization in the newest stage.
        if (idAdoPerson == idSubPerson) {
          throw new ServiceException(Messages.MSG_SVC_AUTH_NEW_STAGE);
        }
      }
      // STGAP00007586 Design doc has nothing in it about not being able to open a SVC auth when a FCC is open...
      // Only when in INV stage should this check be done.
      /*
       * else if (FAMILY_PRES.equals(inputCdStage) && FAMILY_SUBCARE.equals(retrievedCdStage)) { throw new
       * ServiceException(Messages.MSG_SVC_AUTH_NEW_STAGE); }
       */
      // end STGAP00007586
      else if (FAMILY_SUBCARE.equals(inputCdStage) && FAMILY_REUNIF.equals(retrievedCdStage)) {
        throw new ServiceException(Messages.MSG_SVC_AUTH_NEW_STAGE);
      }
    }
  }

  private ROWCCON18SOG00_ARRAY retrievePrincipals(int inputIdStage) throws ServiceException {
    // clsc18d
    List<StagePersonLink> stagePersonLinkInfo3 = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(inputIdStage,
                                                                                                   PRINCIPAL);
    if (stagePersonLinkInfo3 == null || stagePersonLinkInfo3.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_PRINCIPLE);
    }
    ROWCCON18SOG00_ARRAY rowccon18sog00_array = new ROWCCON18SOG00_ARRAY();
    for (Iterator<StagePersonLink> it4 = stagePersonLinkInfo3.iterator(); it4.hasNext();) {
      StagePersonLink stagePersonLink3 = it4.next();
      Person stagePersonLinkPerson = stagePersonLink3.getPerson();
      ROWCCON18SOG00 rowccon18sog00 = new ROWCCON18SOG00();
      String cdStagePersRole = stagePersonLink3.getCdStagePersRole();
      rowccon18sog00.setSzCdStagePersRole(cdStagePersRole);
      rowccon18sog00.setSzNmPersonFull(stagePersonLinkPerson.getNmPersonFull());
      rowccon18sog00.setUlIdPerson(stagePersonLinkPerson.getIdPerson() != null ? stagePersonLinkPerson.getIdPerson()
                                                                              : 0);
      rowccon18sog00.setSzCdNameSuffix(stagePersonLinkPerson.getCdPersonSuffix());
      rowccon18sog00_array.addROWCCON18SOG00(rowccon18sog00);
    }
    return rowccon18sog00_array;
  }

  private ROWCCMN01UIG00 retrieveEventInfo(int ulIdEvent) throws ServiceException {
    // ccmn45d
    Event eventInfo = eventDAO.findEventByIdEvent(ulIdEvent);
    if (eventInfo == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdEventStatus(eventInfo.getCdEventStatus());
    rowccmn01uig00.setSzCdTask(eventInfo.getCdTask());
    rowccmn01uig00.setSzCdEventType(eventInfo.getCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(eventInfo.getTxtEventDescr());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(eventInfo.getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(eventInfo.getIdEvent() != null ? eventInfo.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(eventInfo.getStage().getIdStage() != null ? eventInfo.getStage().getIdStage() : 0);
    if (eventInfo.getPerson() != null) {
      rowccmn01uig00.setUlIdPerson(eventInfo.getPerson().getIdPerson() != null ? eventInfo.getPerson().getIdPerson()
                                                                              : 0);
    }
    rowccmn01uig00.setTsLastUpdate(eventInfo.getDtLastUpdate());
    return rowccmn01uig00;
  }

  private int retrieveEventId(int inputIdStage) throws ServiceException {
    // cint21d
    Stage stageInfo4 = stageDAO.findStageByIdStage(inputIdStage);
    if (stageInfo4 == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // When we find out what the stage is, we need to determine which Event Type to pass to the event retrieval dam
    String[] cdEventTypes = null;
    if (INVESTIGATION.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (FAMILY_PRES.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_STG };
    } else if (SUBCARE.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (FAMILY_SUBCARE.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (FAMILY_REUNIF.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (ADOPTION.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (POST_ADOPTION.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (AGING_OUT.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_CCL };
    } else if (SERVICE_DELIVERY.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_STG };
    } else if (PAL.equals(stageInfo4.getCdStage())) {
      cdEventTypes = new String[] { EVENT_TYPE_STG };
    }

    // See method description information in DynamicEventDAO Interface
    // ccmn87d
    List<Object[]> dynamicEventInfo = dynamicEventDAO.findEvents(false, 0, inputIdStage, 0, 0, 0, cdEventTypes, null,
                                                                 null, null, null, null);
    if (dynamicEventInfo == null || dynamicEventInfo.isEmpty()) {
      return 0;
    } else {
      int idEvent = 0;
      Iterator<Object[]> it4 = dynamicEventInfo.iterator();
      Object[] dynamicEvent = it4.next();
      String cdEventStatus = (String) dynamicEvent[0];
      if (EVENT_STATUS_PENDING.equals(cdEventStatus)) {
        return idEvent;
      } else {
        return 0;
      }
    }
  }

  private ROWCCON18SOG00_ARRAY resetArray(ROWCCON18SOG00_ARRAY rowccon18sog00_array, int idPrimaryClient) {
    for (Enumeration rowccon18sog00Enum = rowccon18sog00_array.enumerateROWCCON18SOG00(); rowccon18sog00Enum
                                                                                                            .hasMoreElements();) {
      ROWCCON18SOG00 rowccon18sog00Temp = (ROWCCON18SOG00) rowccon18sog00Enum.nextElement();
      String cdStagePersRole = rowccon18sog00Temp.getSzCdStagePersRole();
      int idPerson = rowccon18sog00Temp.getUlIdPerson();

      if (idPerson == idPrimaryClient) {
        // When the event is not new, there is only ever ONE primary client, if the id person in the output struct
        // matches the primary client returned either from the service auth retrieve OR from the merge forward
        // retrieve copy the necessary variables into temporary holders, clear out the output array then reset the
        // array with just the one person's information

        // Copy the IdPerson and NmPersonFull to placeholder variables
        int idPersonTemp = rowccon18sog00Temp.getUlIdPerson();
        String nmPersonFullTemp = rowccon18sog00Temp.getSzNmPersonFull();
        String cdNameSuffixTemp = rowccon18sog00Temp.getSzCdNameSuffix();

        rowccon18sog00_array = new ROWCCON18SOG00_ARRAY();
        // Copy the Temp variable values back into a single-row ccon18so.ROWCCON18SOG00_ARRAY
        ROWCCON18SOG00 rowccon18sog00Replace = new ROWCCON18SOG00();
        rowccon18sog00Replace.setSzCdStagePersRole(cdStagePersRole);
        rowccon18sog00Replace.setUlIdPerson(idPersonTemp);
        rowccon18sog00Replace.setSzNmPersonFull(nmPersonFullTemp);
        rowccon18sog00Replace.setSzCdNameSuffix(cdNameSuffixTemp);
        rowccon18sog00_array.addROWCCON18SOG00(rowccon18sog00Replace);
        // Replace the orig ccon18so.setROWCCON18SOG00_ARRAY with the single-row 'temp' values
      }
    }
    return rowccon18sog00_array;
  }

  // STGAP00017831: Added the following method to check if the SA form exists in the DB.
  /**
   * Method to check if form exists
   * @param idEvent
   * @return
   */
  private String setBlobExists(int idEvent) {
		Date srvcAuthFrmLastUpdate = commonDAO.findDtLastUpdate(
				SERVICE_AUTHORIZATION_NARRATIVE, idEvent);

		if (srvcAuthFrmLastUpdate == null) {
			return ArchitectureConstants.N;
		}
		return ArchitectureConstants.Y;
  }

}
