package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approval;
import gov.georgia.dhr.dfcs.sacwis.db.ApprovalEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.OfficePhone;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.document.ServiceAuth;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SERVICEAUTHSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SERVICEAUTHSO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
  This is the Service class Used to populate the Service Authorization From
  
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 07/28/2008 Courtney Wells    STGAP00008253: Request made to change the design to    
 *                              display Units requested intead of units used.
 * </pre>
 *
 * @author Courtney Wells
 */


public class ServiceAuthImpl extends BaseDocumentServiceImpl implements ServiceAuth {

  private CapsCaseDAO capsCaseDAO;

  private PersonDAO personDAO;

  private PersonPhoneDAO personPhoneDAO;

  private ServiceAuthorizationDAO serviceAuthorizationDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private NameDAO nameDAO;

  private PersonIdDAO personIdDAO;

  private EventDAO eventDAO;

  private StageDAO stageDAO;

  private ApprovalRejectionDAO approvalRejectionDAO;

  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public SERVICEAUTHSO retrieveServiceAuth(SERVICEAUTHSI serviceAuthsi) {
    SERVICEAUTHSO serviceAuthso = new SERVICEAUTHSO();
    int idEvent = serviceAuthsi.getUlIdEvent();

    Event event = eventDAO.findEventByIdEvent(idEvent);

    int idStage = serviceAuthsi.getUlIdStage();

    int idSvcAuth = serviceAuthsi.getUlIdSvcAuth();

    Stage stage = stageDAO.findStageByIdStage(idStage);

    int idCase = stage.getCapsCase().getIdCase();

    ServiceAuthorization serviceAuthorization = serviceAuthorizationDAO.findServiceAuth(idSvcAuth);

    PreFillData preFillData = getHeadings(serviceAuthorization);
    getSectionA(idCase, preFillData, serviceAuthorization);
    getSectionB(preFillData, serviceAuthorization);
    getSectionC(idStage, idCase, preFillData);
    getSectionD(preFillData, idStage, idCase, event);
    serviceAuthso.setPreFillData(preFillData);
    return serviceAuthso;
  }

  private PreFillData getHeadings(ServiceAuthorization serviceAuthorization) {
    PreFillData preFillData = new PreFillData();

    java.util.Date date = new java.util.Date();

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String currentDate = dateFormat.format(date);

    preFillData.addBookmark(createBookmark(CURRENT_DATE, currentDate));
    preFillData.addBookmark(createBookmark(REFERRAL_DATE, serviceAuthorization.getDtRefSent()));

    return preFillData;
  }

  /**
   *  Gets all of the Clients Identification 
   * @param idCase
   * @param preFillData
   * @param serviceAuthorization
   * @return
   */
  private PreFillData getSectionA(int idCase, PreFillData preFillData, ServiceAuthorization serviceAuthorization) {
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    // gets the primary Client 
    Person primaryPerson = serviceAuthorization.getPersonByIdPrimaryClient();
    int idPerson = primaryPerson.getIdPerson();
    String faxPerson = personPhoneDAO.findNbrPersonPhoneByIdPersonAndPhoneType(idPerson, "BF");

    preFillData.addBookmark(createBookmark(CASE_NAME, primaryPerson.getNmPersonFull()));
    preFillData.addBookmark(createBookmark(CASE_NUM, capsCase.getIdCase()));
    preFillData.addBookmark(createBookmark(CASE_TYPE, Lookup.simpleDecodeSafe(CodesTables.CPGRMSFM,
                                                                              capsCase.getCdCaseProgram())));
    preFillData.addBookmark(createBookmark(CLIENT_CITY, primaryPerson.getAddrPersonCity()));
    preFillData.addBookmark(createBookmark(CLIENT_ADDRESS, primaryPerson.getAddrPersonStLn1()));
    preFillData.addBookmark(createBookmark(CLIENT_STATE, primaryPerson.getCdPersonState()));
    preFillData.addBookmark(createBookmark(CLIENT_ZIP, primaryPerson.getAddrPersonZip()));

    if (faxPerson != null) {

      preFillData.addBookmark(createBookmark(CLIENT_FAX, FormattingHelper.formatPhone(faxPerson)));

    } // end if 
    preFillData
               .addBookmark(createBookmark(CLIENT_TELE, FormattingHelper.formatPhone(primaryPerson.getNbrPersonPhone())));

    preFillData.addBookmark(createBookmark(REFERRAL_REASON, serviceAuthorization.getTxtSvcAuthComments()));
    createServiceAuthDetailLists(preFillData, serviceAuthorization);
 
    return preFillData;
  }  // end getSectionA

  /**
   *  Gets Authorization to Provide Services 
   * @param preFillData
   * @param serviceAuthorization
   * @return
   */
  
  private PreFillData getSectionB(PreFillData preFillData, ServiceAuthorization serviceAuthorization) {

    CapsResource capsResource = serviceAuthorization.getCapsResource();
    preFillData.addBookmark(createBookmark(SERVICE_PROVIDER, capsResource.getNmResource()));
    preFillData.addBookmark(createBookmark(SERVICE_ID_NUM, capsResource.getIdResource().toString()));
    preFillData.addBookmark(createBookmark(SERVICE_ADDRESS, capsResource.getAddrRsrcStLn1()));
    preFillData.addBookmark(createBookmark(SERVICE_ADDRESS2, capsResource.getAddrRsrcStLn2()));
    preFillData.addBookmark(createBookmark(SERVICE_CITY, capsResource.getAddrRsrcCity()));
    preFillData.addBookmark(createBookmark(SERVICE_STATE, capsResource.getCdRsrcState()));
    preFillData.addBookmark(createBookmark(SERVICE_ZIP, capsResource.getAddrRsrcZip()));
    getResourcePhoneNumbers(capsResource, preFillData);
    preFillData.addBookmark(createBookmark(PERFERRED_SUB, serviceAuthorization.getTxtSvcAuthSecProvdr()));

    return preFillData;
  } // end getSectionB
  
/**
 * Gets HouseHold Members Information
 * @param idStage
 * @param idCase
 * @param preFillData
 */
  private void getSectionC(int idStage, int idCase, PreFillData preFillData) {
    List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO
                                                               .findHouseMembersLinkedToStage(idStage);
    if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {

      for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        determineHouseHoldStatus(stagePersonLink, preFillData);

      } // end of StagePersonLink List
    } // end of Stage Person link search
  }// end of createHouseholdMembers

  /**
   * Determines Household Members Status 
   * @param stagePersonLink
   * @param preFillData
   */
  private void determineHouseHoldStatus(StagePersonLink stagePersonLink, PreFillData preFillData) {
      preFillData.addFormDataGroup(displayHouseHoldStatus( stagePersonLink));
  } // end determineHouseHoldStatus

  private void createServiceAuthDetailLists(PreFillData preFillData, ServiceAuthorization serviceAuthorization) {

    Collection<SvcAuthDetail> svcAuthDetails = serviceAuthorization.getSvcAuthDetails();
    if (svcAuthDetails != null && !svcAuthDetails.isEmpty()) {
      for (Iterator<SvcAuthDetail> it = svcAuthDetails.iterator(); it.hasNext();) {
        SvcAuthDetail svcAuthDetail = it.next();
        preFillData.addFormDataGroup(getsvcAuthDetail(svcAuthDetail));

      }// end for 
    }// end if 
  }// end createServiceAuthDetailLists

  private FormDataGroup getsvcAuthDetail(SvcAuthDetail svcAuthDetail) {

    FormDataGroup group = createFormDataGroup(TMPLAT_SERVICE, FCM06O00);

    group.addBookmark(createBookmark(SERVICE_NAMES, svcAuthDetail.getPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(SERVICE, Lookup.simpleDecodeSafe(CodesTables.CSVCCODE,
                                                                      svcAuthDetail.getCdSvcAuthDtlSvc())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_BEGIN, FormattingHelper.formatDate(svcAuthDetail.getDtSvcAuthDtlBegin())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_TERM, FormattingHelper.formatDate(svcAuthDetail.getDtSvcAuthDtlTerm())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_END, FormattingHelper.formatDate(svcAuthDetail.getDtSvcAuthDtlEnd())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_UNIT_TYPE, svcAuthDetail.getCdSvcAuthDtlUnitType()));
    // STGAP00008253 Changed to display units requested instead of units used
    group.addBookmark(createBookmark(NBR_SVC_AUTH_DTL_UNIT_REQ, svcAuthDetail.getNbrSvcAuthDtlUnitsReq()));
    group.addBookmark(createBookmark(CD_SVC_AUTH_DTL_AUTH_TYPE, svcAuthDetail.getCdSvcAuthDtlAuthType()));
    group
         .addBookmark(createBookmark(SERVICE_AUTH_ID, svcAuthDetail.getServiceAuthorization().getIdSvcAuth().toString()));
    return group;
  }// end getsvcAuthDetail

  private FormDataGroup displayHouseHoldStatus(StagePersonLink stagePersonLink) {

    FormDataGroup group = createFormDataGroup(TMPLAT_OTHER_MEMBERS, FCM06O00);
   String membersName = stagePersonLink.getPerson().getNmPersonFull();
   Person person = stagePersonLink.getPerson();
   
   int idPerson = stagePersonLink.getPerson().getIdPerson().intValue();
    PersonId personIdMed = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "CRS ID#",
                                                                                                           "N",
                                                                                                           DateHelper
                                                                                                                     .toJavaDate(DateHelper.MAX_CASTOR_DATE));

    PersonId personIdMhn = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "Medicaid/MHN #",
                                                                                                           "N",
                                                                                                           DateHelper
                                                                                                                     .toJavaDate(DateHelper.MAX_CASTOR_DATE));

    PersonId personIdSsn = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "SSN",
                                                                                                           "N",
                                                                                                           DateHelper
                                                                                                                     .toJavaDate(DateHelper.MAX_CASTOR_DATE));
if (membersName != null){
    group.addBookmark(createBookmark(OTHER_NM, membersName));
}
    group.addBookmark(createBookmark(ID_PERSON, idPerson));
    if (personIdMhn != null) {
      group.addBookmark(createBookmark(NBR_MEDICAID, personIdMhn.getNbrPersonIdNumber().concat("P")));
    }// end if  
    else if (personIdMed != null) {
      group.addBookmark(createBookmark(NBR_MEDICAID, personIdMed.getNbrPersonIdNumber()));
    }// end else if
    if( person != null){
    group.addBookmark(createBookmark(DT_BIRTH, FormattingHelper.formatDate(person.getDtPersonBirth())));
    group.addBookmark(createBookmark(ETHNICITY, Lookup.simpleDecodeSafe(CodesTables.CETHNIC,
                                                                        person.getCdPersonEthnicGroup())));
    }
    if (personIdSsn != null) {
      group.addBookmark(createBookmark(SSN, personIdSsn.getNbrPersonIdNumber()));
    }// end if 
    group.addBookmark(createBookmark(RELATIONSHIP, Lookup.simpleDecodeSafe(CodesTables.CRPTRINT,
                                                                           stagePersonLink.getCdStagePersRelInt())));
    return group;
  }// end displayHouseHoldStatus


  /**
   * Gets the Agency Information 
   * @param preFillData
   * @param idStage
   * @param idCase
   * @param event
   */
  private void getSectionD(PreFillData preFillData, int idStage, int idCase, Event event) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Integer idPerson = 0;
    if(stagePersonLink != null){
      idPerson = stagePersonLink.getPerson().getIdPerson();
    } 
    if(idPerson > 0){
    Name name = nameDAO.findNameByPersonPrimary(idPerson.intValue());

    preFillData.addBookmark(createBookmark(MANAGER_NM, name.getPerson().getNmPersonFull()));
    preFillData.addBookmark(createBookmark(MANAGER_ID_NUM, name.getPerson().getIdPerson()));
    preFillData.addBookmark(createBookmark(AGENCY_ADDRESS, name.getPerson().getEmployee().getMailCode()
                                                               .getAddrMailCodeStLn1()));
    preFillData.addBookmark(createBookmark(AGENCY_ADDRESS2, name.getPerson().getEmployee().getMailCode()
                                                                .getAddrMailCodeStLn2()));
    preFillData.addBookmark(createBookmark(AGENCY_CITY, name.getPerson().getEmployee().getMailCode()
                                                            .getAddrMailCodeCity()));

    preFillData.addBookmark(createBookmark(AGENCY_STATE, CodesTables.CSTATE_GA));

    preFillData.addBookmark(createBookmark(AGENCY_ZIP, name.getPerson().getEmployee().getMailCode()
                                                           .getAddrMailCodeZip()));
    preFillData.addBookmark(createBookmark(AGENCY_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                  name.getPerson().getEmployee()
                                                                                      .getMailCode()
                                                                                      .getAddrMailCodeCounty())));
    preFillData.addBookmark(createBookmark(AGENCY_TELE, FormattingHelper.formatPhone(name.getPerson().getEmployee()
                                                                                         .getMailCode()
                                                                                         .getNbrMailCodePhone())));
    getOfficeFaxNum(name, preFillData);
    }
    getDesignee(event, preFillData);
    getReferralDenied(idStage, idCase, preFillData);
  }// end getSectionD

  private void getOfficeFaxNum(Name name, PreFillData preFillData) {
    Collection<OfficePhone> officePhones = name.getPerson().getEmployee().getOffice().getOfficePhones();
    if (officePhones != null && !officePhones.isEmpty()) {
      for (Iterator<OfficePhone> it = officePhones.iterator(); it.hasNext();) {
        OfficePhone officePhone = it.next();
        if ("BF".equals(officePhone.getCdOfficePhoneType())) {
          displayOfficePhone(officePhone, preFillData);
        }// end if 

      } // end for
    }// end if 

  } // end getOfficeFaxNum

  private void getDesignee(Event event, PreFillData preFillData) {
    Collection<ApprovalEventLink> approvalEventLinks = event.getApprovalEventLinks();
    if (approvalEventLinks != null && !approvalEventLinks.isEmpty()) {
      for (Iterator<ApprovalEventLink> it = approvalEventLinks.iterator(); it.hasNext();) {
        ApprovalEventLink approvalEventLink = (ApprovalEventLink) it.next();
        if(approvalEventLink!=null){
        preFillData.addFormDataGroup(displayApprovalInformation(approvalEventLink, preFillData));
        }

      }// end for 
    } // end if 
    else {
      preFillData.addFormDataGroup(displayEmptyDesignee());
    }// end else
  } // end getDesignee

  private void getReferralDenied(int idCase, int idStage, PreFillData preFillData) {
    List<Map> approvalRejections = approvalRejectionDAO.findApprovalRejectionByIdCaseIdStage(idCase, idStage);

    if (approvalRejections != null && !approvalRejections.isEmpty()) {
      for (Iterator<Map> it = approvalRejections.iterator(); it.hasNext();) {
        Map approvalRejection = (Map) it.next();
        preFillData.addFormDataGroup(displayDenialInformation(approvalRejection, preFillData));
      } // end for
    } // end if
    else {
      preFillData.addFormDataGroup(displayEmptyDenialInformation());
    } // end else
  } // end getReferralDenied

  private PreFillData displayOfficePhone(OfficePhone officePhone, PreFillData preFillData) {
    preFillData.addBookmark(createBookmark(FAX_NUM, FormattingHelper.formatPhone(officePhone.getNbrOfficePhone())));

    return preFillData;
  } // end displayOfficePhone

  private FormDataGroup displayApprovalInformation(ApprovalEventLink approvalEventLink, PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_APPROVAL_INFORMATION, FCM06O00);
    Approval approval = approvalEventLink.getApproval();
    if (approval != null) {
      Collection<Approvers> approvers = approval.getApproverses();
      if (approvers != null && !approvers.isEmpty()) {
        for (Iterator<Approvers> it = approvers.iterator(); it.hasNext();) {
          Approvers approver = it.next();
          if (approver != null) {
            group.addBookmark(createBookmark(AGENCY_DIRECTOR, approver.getPerson().getNmPersonFull()));
          }
        }
      }
      group.addBookmark(createBookmark(DT_APPROVED, approvalEventLink.getApproval().getDtApprovalDate()));
    }
    return group;
  } // end displayApprovalInformation

  private FormDataGroup displayDenialInformation(Map approvalRejection, PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_DENIAL_INFORMATION, FCM06O00);

    group.addBookmark(createBookmark(REASON_DENIED, approvalRejection.get("txtApproversCmnts")));
    group.addBookmark(createBookmark(DT_DENIED, approvalRejection.get("dtRejection")));

    return group;
  } // end displayDenialInformation

  private FormDataGroup displayEmptyDesignee() {
    FormDataGroup group = createFormDataGroup(TMPLAT_APPROVAL_INFORMATION, FCM06O00);

    group.addBookmark(createBookmark(AGENCY_DIRECTOR, "N/A"));

    return group;
  } // end displayEmptyDesignee

  private FormDataGroup displayEmptyDenialInformation() {
    FormDataGroup group = createFormDataGroup(TMPLAT_DENIAL_INFORMATION, FCM06O00);

    group.addBookmark(createBookmark(REASON_DENIED, "N/A"));

    return group;

  } // end displayEmptyDenialInformation

  
  /*
   * gets Business numbers for the Resource 
   */
  private void getResourcePhoneNumbers(CapsResource capsResource, PreFillData preFillData) {
    Collection<ResourcePhone> resourcePhones = capsResource.getResourcePhones();
    if (resourcePhones != null && !resourcePhones.isEmpty()) {
      for (Iterator<ResourcePhone> it = resourcePhones.iterator(); it.hasNext();) {
        ResourcePhone resourcePhone = it.next();
        String resourcePhoneType = resourcePhone.getCdRsrcPhoneType();

        if ("01".equals(resourcePhoneType) || "03".equals(resourcePhoneType)) {
          displayResourcePhone(resourcePhone, preFillData, resourcePhoneType);
        }// end if

      } // end for
    }// end if 

  }// end getResourcePhoneNumbers

  private PreFillData displayResourcePhone(ResourcePhone resourcePhone, PreFillData preFillData,
                                           String resourcePhoneType) {
    if ("01".equals(resourcePhoneType)) {
      preFillData.addBookmark(createBookmark(SERVICE_TELEPHONE_NUM,
                                             FormattingHelper.formatPhone(resourcePhone.getNbrRsrcPhone())));

    } // end if
    else if ("03".equals(resourcePhoneType)) {
      preFillData.addBookmark(createBookmark(SERVICE_FAX_NUM,
                                             FormattingHelper.formatPhone(resourcePhone.getNbrRsrcPhone())));

    }// end else if

    return preFillData;
  }

}
