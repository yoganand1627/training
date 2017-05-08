package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MailCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.document.ServiceAuthRef;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SERVICEAUTHREFSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Approver;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SERVICEAUTHREFSO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * This is the Service class used to populate the Service Authorization Referral Form for the revision 11-11.
 * Note, the previous revision uses a different implementation class (ServiceAuthImpl)
 * 
 * <pre>
 * Change History:
 * Date        User              Description
 * ----------  ----------------  -------------------------------------------------
 * 01/31/2012  schoi             STGAP00017831: MR-102 Initial Creation
 * 02/08/2012  htvo              STGAP00017831: MR-102 added retrieveCaseHistory section place holder
 * 02/10/2012  vcollooru         STGAP00017831: MR-102 added retrieveApprovalHistory section place holder
 * 02/13/2012  schoi             STGAP00017831: MR-102 Removed unused methods
 * 02/19/2012  schoi             STGAP00017920: MR-102 Corrected decode value of 'HRP' from 'PUP/Homestead - Immediate Reunification'
 *                               to 'PUP/Homestead - Imminent Risk of Placement' 
 * 02/21/2012  htvo              STGAP00017925: Correction - Do not disclose any prior DFCS history information if  
 *                               DFCS adopted child case (ADO->PAD). Leave the field  blank.                            
 * 02/24/2012  schoi             STGAP00017945: MR-102 Corrected the logic to populate the Case Name                              
 * 03/05/2012  schoi             STGAP00017993: MR-102 Updated the Address Field to Display Primary and Valid Only
 * 03/12/2012  schoi             STGAP00017999: MR-102 Added condition to cover both converted and merged cases 
 *                               in 'Length of time the Current Case has been opened?' field
 * 03/13/2012  schoi             STGAP00018024: MR-102 Additional logic per design change 
 *                               Separated Living Arrangement field logic if the current stage is PAD or PFC             
 * 03/13/2012  schoi             STGAP00017996: MR-102 Additional logic per design change 
 *                               Added converted cases into the consideration of the Prior DFCS History field calculation                              
 * 03/14/2012  htvo              STGAP00017996: handled merge case where the Service Auth stage belongs to the Closed case  
 *                               by considering the forward case in history find.    
 *                               STGAP00018034: only performed the next tests when there are "other cases" after previous removals                        
 * </pre>
 * @author Seung-eun (Caroline) Choi
 */

public class ServiceAuthRefImpl extends BaseDocumentServiceImpl implements ServiceAuthRef {

  private static final String FOSTER_CARE = "Foster Care";

  private static final String SAFETY_RESOURCE = "Safety Resource";
  
  private static final String POST_ADOPTION = "Post Adoption";
  
  private static final String POST_FOSTER_CARE = "Post Foster Care";

  private static final String IND_CASE_MANAGER = "Ind Case Manager";

  private static final String IND_SUPERVISOR = "Ind Supervisor";

  private static final String PRINCIPAL = CodesTables.CPRSNALL_PRN;

  private static final List<String> NON_GA_COUNTY_LIST = new ArrayList<String>(Arrays.asList(CodesTables.CCOUNT_999,
                                                                                             CodesTables.CCOUNT_XXX));

  private AllegationDAO allegationDAO;
  
  private CapsCaseDAO capsCaseDAO;
  
  private CaseMergeDAO caseMergeDAO;
  
  private MailCodeDAO mailCodeDAO;

  private PersonDAO personDAO;

  private PersonPhoneDAO personPhoneDAO;

  private SafetyResourceChildDAO safetyResourceChildDAO;

  private ServiceAuthorizationDAO serviceAuthorizationDAO;

  private SvcAuthDetailDAO svcAuthDetailDAO;
  
  private StageLinkDAO stageLinkDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PersonIdDAO personIdDAO;

  private PersonEthnicityDAO personEthnicityDAO;
  
  private PersonRaceDAO personRaceDAO;

  private PlacementDAO placementDAO;

  private ResourceAddressDAO resourceAddressDAO;
  
  private ResourcePhoneDAO resourcePhoneDAO;

  private EventDAO eventDAO;

  private StageDAO stageDAO;
  
  private UnitEmpLinkDAO unitEmpLinkDAO;

  private ApproversDAO approversDAO;

  
  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
	this.approversDAO = approversDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setMailCodeDAO(MailCodeDAO mailCodeDAO) {
    this.mailCodeDAO = mailCodeDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }
  
  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }
  
  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public SERVICEAUTHREFSO retrieveServiceAuthRef(SERVICEAUTHREFSI serviceAuthRefsi) {
    SERVICEAUTHREFSO serviceAuthRefso = new SERVICEAUTHREFSO();
    int idEvent = serviceAuthRefsi.getUlIdEvent();
    Event event = eventDAO.findEventByIdEvent(idEvent);
    int idStage = serviceAuthRefsi.getUlIdStage();
    int idSvcAuth = serviceAuthRefsi.getUlIdSvcAuth();
    Stage stage = stageDAO.findStageByIdStage(idStage);
    ServiceAuthorization serviceAuthorization = serviceAuthorizationDAO.findServiceAuth(idSvcAuth);

    PreFillData preFillData = new PreFillData();
    getFirstSection(stage, preFillData, serviceAuthorization);
    getProviderSection(preFillData, serviceAuthorization);
    List<Integer> peronsRefForService = createPersonsReferredForServiceLists(preFillData, serviceAuthorization, stage);
    getSectionOtherPrincipals(stage, preFillData, peronsRefForService);
    getCaseManagerSection(preFillData, stage, event);
    retrieveCaseHistory(preFillData, stage, peronsRefForService);
    retrieveApprovalHistory(preFillData, event);
    serviceAuthRefso.setPreFillData(preFillData);
    return serviceAuthRefso;
  }

  /**
   * Gets the first section information
   * 
   * @param stage
   * @param preFillData
   * @param serviceAuthorization
   * @return
   */
  private PreFillData getFirstSection(Stage stage, PreFillData preFillData, ServiceAuthorization serviceAuthorization) {
    int idStage = stage.getIdStage();
    int idCase = stage.getCapsCase().getIdCase();
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);

    // Gets Contract information
    Contract contract = serviceAuthorization.getContract();

    // Gets the name of the case; check for null for the bad data without case name
    if (capsCase.getNmCase() != null) {
      preFillData.addBookmark(createBookmark(CASE_NAME, capsCase.getNmCase()));
    }
    preFillData.addBookmark(createBookmark(CASE_NUM, capsCase.getIdCase()));
    preFillData.addBookmark(createBookmark(STAGE_NUM, idStage));
    preFillData.addBookmark(createBookmark(CD_STAGE_SHORT,
                                           Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, stage.getCdStage())));
    preFillData.addBookmark(createBookmark(CD_STAGE_LONG,
                                           Lookup.simpleDecodeSafe(CodesTables.CSTAGES, stage.getCdStage())));

    preFillData.addBookmark(createBookmark(SERVICE_AUTH_ID, serviceAuthorization.getIdSvcAuth()));
    preFillData.addBookmark(createBookmark(CONTRACT_ID, contract.getIdContract()));

    // Retrieves office address based on stage County and through a filter list of offices that handle
    // Service Authorization form, identified by the SMEs of MR-102    
    // Gets Payment County information
    String cdCountyPmtCounty = "";
    String pmtCountyAddress = "";
    cdCountyPmtCounty = serviceAuthorization.getCdPayCnty();    

    Object[] mailCodePmtCounty = mailCodeDAO.findMailCodeByCdCountyForSvcAuthFormPmtCntyField(cdCountyPmtCounty);
    if (NON_GA_COUNTY_LIST.contains(cdCountyPmtCounty)) {
      // do nothing; if for some reason the county is out-of-state or -none- do not retrieve address and phone.
    } else {
      if (mailCodePmtCounty != null) {
        StringBuffer addrPmt = new StringBuffer();
        // Concatenate address line 1, line 2, city, and zip
        formatAddress((String) mailCodePmtCounty[1], (String) mailCodePmtCounty[2], (String) mailCodePmtCounty[3],
                      "GA", (String) mailCodePmtCounty[4], addrPmt);
        pmtCountyAddress = addrPmt.toString();
      }
    }
    preFillData.addBookmark(createBookmark(PAYMENT_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, cdCountyPmtCounty)));
    preFillData.addBookmark(createBookmark(PAYMENT_COUNTY_ADDRESS, pmtCountyAddress));

    // Gets Legal County information
    String cdCountyLegalCounty = "";
    String legalCountyAddress = "";
    cdCountyLegalCounty = serviceAuthorization.getCdSvcAuthCounty();

    Object[] mailCodeLegCounty = mailCodeDAO.findMailCodeByCdCountyForSvcAuthFormLegalCntyField(cdCountyLegalCounty);
    if (NON_GA_COUNTY_LIST.contains(cdCountyLegalCounty)) {
      // do nothing; if for some reason the county is out-of-state or -none- do not retrieve address and phone.
    } else {
      if (mailCodeLegCounty != null) {
        StringBuffer addrLegal = new StringBuffer();
        // Concatenate address line 1, line 2, city, and zip
        formatAddress((String) mailCodeLegCounty[1], (String) mailCodeLegCounty[2], (String) mailCodeLegCounty[3],
                      "GA", (String) mailCodeLegCounty[4], addrLegal);
        legalCountyAddress = addrLegal.toString();
      }
    }
    preFillData.addBookmark(createBookmark(LEGAL_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, cdCountyLegalCounty)));
    preFillData.addBookmark(createBookmark(LEGAL_COUNTY_ADDRESS, legalCountyAddress));

    createServiceAuthDetailLists(preFillData, serviceAuthorization);

    return preFillData;
  }

  /**
   * Gets Authorization to Provide Services
   * 
   * @param preFillData
   * @param serviceAuthorization
   * @return
   */

  private PreFillData getProviderSection(PreFillData preFillData, ServiceAuthorization serviceAuthorization) {
    CapsResource capsResource = serviceAuthorization.getCapsResource();
    String address = "";
    preFillData.addBookmark(createBookmark(SERVICE_PROVIDER, capsResource.getNmResource()));
    preFillData.addBookmark(createBookmark(SERVICE_ID_NUM, capsResource.getIdResource().toString()));
    
    // Find the Resource Address having Type as Primary (01)
    ResourceAddress rsrcAddress = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(capsResource.getIdResource());
    if (rsrcAddress != null) {
      StringBuffer addr = new StringBuffer();
      formatAddress(rsrcAddress.getAddrRsrcAddrStLn1(), rsrcAddress.getAddrRsrcAddrStLn2(),
                    rsrcAddress.getAddrRsrcAddrCity(), rsrcAddress.getCdRsrcAddrState(),
                    rsrcAddress.getAddrRsrcAddrZip(), addr);
      address = addr.toString();
    }
    preFillData.addBookmark(createBookmark(SERVICE_PROVIDER_ADDRESS, FormattingHelper.formatString(address)));

    // Find Business phone and fax numbers for the Resource
    getResourcePhoneNumbers(capsResource, preFillData);

    return preFillData;
  }

  /**
   * Gets Other Principals in the Stage Information
   * 
   * @param stage
   * @param preFillData
   */
  private void getSectionOtherPrincipals(Stage stage, PreFillData preFillData, List<Integer> peronsRefForService) {
    int idStage = stage.getIdStage();
    List<Integer> idPersonListAllPrns = stagePersonLinkDAO.findIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(idStage,
                                                                                                                      PRINCIPAL);
    if (idPersonListAllPrns != null && !idPersonListAllPrns.isEmpty()) {
      for (Iterator<Integer> it = idPersonListAllPrns.iterator(); it.hasNext();) {
        Integer idOtherPrn = it.next();
        if (!peronsRefForService.contains(idOtherPrn)) {
          StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idOtherPrn,
                                                                                                       idStage);
          determineOtherPrincipalStatus(stagePersonLink, preFillData);
        }
      }
    }
  }

  /**
   * Determines Household Members Status
   * 
   * @param stagePersonLink
   * @param preFillData
   */
  private void determineOtherPrincipalStatus(StagePersonLink stagePersonLink, PreFillData preFillData) {
    preFillData.addFormDataGroup(displayOtherPrincipalStatus(stagePersonLink));
  }

  private void createServiceAuthDetailLists(PreFillData preFillData, ServiceAuthorization serviceAuthorization) {
    Collection<SvcAuthDetail> svcAuthDetails = serviceAuthorization.getSvcAuthDetails();
    Double totalAmount = 0.00;
    String amount = "";
    String uasProgramDescriptionLong = "";
    String uasProgramDescriptionShort = "";
    String pupEligibilityCriteria = "";
    if (svcAuthDetails != null && !svcAuthDetails.isEmpty()) {
      for (Iterator<SvcAuthDetail> it = svcAuthDetails.iterator(); it.hasNext();) {
        SvcAuthDetail svcAuthDetail = it.next();
        preFillData.addFormDataGroup(getsvcAuthDetail(svcAuthDetail));
        totalAmount = totalAmount + svcAuthDetail.getAmtSvcAuthDtlAmtReq();        
      }
      amount = FormattingHelper.formatMoney(totalAmount);
      uasProgramDescriptionLong = Lookup.simpleDecodeSafe(CodesTables.CPRGCOD1, serviceAuthorization.getCdSvcAuthCategory());
      uasProgramDescriptionShort = uasProgramDescriptionLong.substring(6);
      // Per ServiceAuthHeader.jsp, the PUP Outcome Type radio button values are mapped 
      // to the following codes and there is no corresponding codes_tables mapping:
      // PUP/Homestead - Imminent Risk of Placement : HRP
      // PUP/Homestead - Immediate Reunification : HRU
      if ("HRP".equals(serviceAuthorization.getCdPupTyp())) {
        pupEligibilityCriteria = "PUP/Homestead - Imminent Risk of Placement";
      } else if ("HRU".equals(serviceAuthorization.getCdPupTyp())) {
        pupEligibilityCriteria = "PUP/Homestead - Immediate Reunification";
      }      
      
      preFillData.addBookmark(createBookmark(TOTAL_AMT_AUTHORIZED, amount));
      preFillData.addBookmark(createBookmark(CD_SVC_AUTH_CATEGORY, serviceAuthorization.getCdSvcAuthCategory()));
      preFillData.addBookmark(createBookmark(UAS_PROGRAM_DESCRIPTION, uasProgramDescriptionShort));    
      preFillData.addBookmark(createBookmark(PUP_ELIGIBILITY_CRITERIA, pupEligibilityCriteria));      
    }
  }

  private List<Integer> createPersonsReferredForServiceLists(PreFillData preFillData, ServiceAuthorization serviceAuthorization, Stage stage) {
    List<Integer> peronsRefForService = svcAuthDetailDAO.findDistinctPersonByIdSvcAuth(serviceAuthorization.getIdSvcAuth());
    if (peronsRefForService != null && !peronsRefForService.isEmpty()) {
      for (Iterator<Integer> it = peronsRefForService.iterator(); it.hasNext();) {
        Integer idPersonRefForService = it.next();
        preFillData.addFormDataGroup(getPersonsRefForService(idPersonRefForService, serviceAuthorization, stage));
      }
    }
    return peronsRefForService;
  }

  private FormDataGroup getPersonsRefForService(int idPersonRefForService, ServiceAuthorization serviceAuthorization, Stage stage) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PERSON_FOR_SERVICE, FCM06O00V2);
    
    int idStage = stage.getIdStage();
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPersonRefForService,
                                                                                                 idStage);

    Person personForService = personDAO.findPersonByIdPerson(idPersonRefForService);
    if (personForService != null) {
      group.addBookmark(createBookmark(PERSON_FOR_SERVICE_NAME, personForService.getNmPersonFull()));
      group.addBookmark(createBookmark(PERSON_FOR_SERVICE_ID, personForService.getIdPerson()));
      group.addBookmark(createBookmark(DOB, FormattingHelper.formatDate(personForService.getDtPersonBirth())));

      // Gets the Relationship of the person in the stage
      group.addBookmark(createBookmark(CD_STAGE_PERS_REL_INT,
                                       Lookup.simpleDecodeSafe(CodesTables.CRPTRINT,
                                                               stagePersonLink.getCdStagePersRelInt())));

      PersonEthnicity personEthnicity = null;
      personEthnicity = retrievePersonEthnicityData(idPersonRefForService);
      if (personEthnicity != null) {
        group.addBookmark(createBookmark(PERSON_ETHNICITY, Lookup.simpleDecodeSafe(CodesTables.CINDETHN,
                                                                                   personEthnicity.getCdEthnicity())));
      }
      group.addBookmark(createBookmark(MARITAL_STATUS,
                                       Lookup.simpleDecodeSafe(CodesTables.CMARSTAT,
                                                               personForService.getCdPersonMaritalStatus())));
      group.addBookmark(createBookmark(PERSON_RACE, FormattingHelper.formatString(getPersonRace(idPersonRefForService))));
    }

    // Find Medicaid Number
    PersonId personIdMhn = personIdDAO.findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(idPersonRefForService,
                                                                                                           "Medicaid/MHN #",
                                                                                                           "N",
                                                                                                           DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE));
    if (personIdMhn != null) {
      group.addBookmark(createBookmark(MEDICAID_NBR, personIdMhn.getNbrPersonIdNumber()));
    }
    
    // Look for idPerson in Foster Care Placement type
    Date earliestBeginDate = null;
    earliestBeginDate = svcAuthDetailDAO.findEarliestBeiginDateOfSvcAuthDetailByPersonByIdSvcAuth(idPersonRefForService,
                                                                                                  serviceAuthorization.getIdSvcAuth());
    String livingArrangement = "";
    Placement placement = placementDAO.findLatestApprovedPlacementByIdPersonBySvcAuthDetail(idPersonRefForService,
                                                                                            earliestBeginDate);

    // Look for idPerson in Safety Resource Placement type
    SafetyResourceChild safetyResourceChild = safetyResourceChildDAO.findActiveApprovedSafetyResourceByIdPersonByDate(idPersonRefForService,
                                                                                                                      earliestBeginDate);

    String contactName = "";
    String address = "";
    String phoneNbr = "";
    if (placement != null) {
      livingArrangement = FOSTER_CARE;
      // Find Contact Name for Foster Care Placement found from Resource name for Facility field on the Placement page
      if (placement.getCapsResourceByIdRsrcFacil() != null) {
        contactName = placement.getNmPlcmtFacil();
      } 
      // If the Resource is Person, find Contact Name as the name of the Person
      else if (placement.getNmPlcmtPersonFull() != null) {
        contactName = placement.getNmPlcmtPersonFull();
      }
      // If Foster Care Placement:
      // Find Address and Phone information of the Contact Name above      
      // from the Address/Phone Detail section on the Placement
      // NOTE: If the Address/Phone information on this section is incorrect
      // the user needs to correct this per form design
      StringBuffer addr = new StringBuffer();
      formatAddress(placement.getAddrPlcmtLn1(), placement.getAddrPlcmtLn2(), placement.getAddrPlcmtCity(),
                    placement.getAddrPlcmtSt(), placement.getAddrPlcmtZip(), addr);
      address = addr.toString();
      
      if (placement.getNbrPlcmtTelephone() != null) {
        if (placement.getNbrPlcmtPhoneExt() != null) {
          // Display extension after the phone number if it exists
          phoneNbr = FormattingHelper.formatPhone(placement.getNbrPlcmtTelephone()) + " Ext. "
                     + placement.getNbrPlcmtPhoneExt();
        } else {
          phoneNbr = FormattingHelper.formatPhone(placement.getNbrPlcmtTelephone());
        }
      }      
    } else if (safetyResourceChild != null) {
      livingArrangement = SAFETY_RESOURCE;
      // Find Contact Name for Safety Resource Placement found from Primary Safety Resource name 
      // on the Safety Resource Detail page
      int idPrimarySafetyResource = safetyResourceChild.getSafetyResource().getIdPrimary();
      contactName = personDAO.findNmFullByIdPerson(idPrimarySafetyResource);
      // If Safety Resource Placement:
      // Find Address and Phone information of the Contact Name above      
      // from the Address and Phone Detail sections on the Person Detail page
      Person personSR = personDAO.findPersonByIdPerson(idPrimarySafetyResource);
      if (personSR != null) {
        PersonAddress primaryPersonAddress = getPrimaryPersonAddress(personSR);
        if (primaryPersonAddress != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(personSR.getAddrPersonStLn1(), null, personSR.getAddrPersonCity(), personSR.getCdPersonState(),
                        personSR.getAddrPersonZip(), addr);
          address = addr.toString();
        }
        
        // Gets the Phone field
        phoneNbr = retrievePrimaryPersonPhoneData(idPrimarySafetyResource);
      }
    } else {
      // If the Person Referred for Service is not in any Placement based on the definition of Living Arrangement
      // find Address and Phone information from the Address and Phone sections found in the Person Detail page
      // of the Person Referred for Service
      if (personForService != null) {
        PersonAddress primaryPersonAddress = getPrimaryPersonAddress(personForService);
        if (primaryPersonAddress != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(personForService.getAddrPersonStLn1(), null, personForService.getAddrPersonCity(),
                        personForService.getCdPersonState(), personForService.getAddrPersonZip(), addr);
          address = addr.toString();
        }

        // Gets the Phone field
        phoneNbr = retrievePrimaryPersonPhoneData(idPersonRefForService);
      }
    }
    
    // STGAP00018024: MR-102 Additional logic per design change 
    // Separated Living Arrangement field logic if the current stage is PAD or PFC
    // All other condition to display the Contact Name, Address and Phone Number stays the same
    // as the Foster Care Living Arrangement except the Living Arrangement Value
    // If the current stage is PAD then display 'Post Adoption' as Living Arrangement value
    // If the current stage is PFC then display 'Post Foster Care' as Living Arrangement value
    if (livingArrangement != null && FOSTER_CARE.equals(livingArrangement)) {
      String stageType = "";
      stageType = stage.getCdStage();
      if (CodesTables.CSTAGES_PAD.equals(stageType)) {
        livingArrangement = POST_ADOPTION;
      }
      if (CodesTables.CSTAGES_PFC.equals(stageType)) {
        livingArrangement = POST_FOSTER_CARE;
      }
    }
    group.addBookmark(createBookmark(LIVING_ARRANGEMENT, FormattingHelper.formatString(livingArrangement)));
    group.addBookmark(createBookmark(CONTACT_NAME, FormattingHelper.formatString(contactName)));
    group.addBookmark(createBookmark(PERSON_FOR_SERVICE_ADDRESS, FormattingHelper.formatString(address)));
    group.addBookmark(createBookmark(PERSON_FOR_SERVICE_PHONE, FormattingHelper.formatString(phoneNbr)));

    return group;
  }

  private PersonAddress getPrimaryPersonAddress(Person person) {
    PersonAddress personAddress = null;
    if (person != null) {
      Collection<AddressPersonLink> personAddresses = person.getAddressPersonLinks();
      if (personAddresses != null && !personAddresses.isEmpty()) {
        for (Iterator<AddressPersonLink> it = personAddresses.iterator(); it.hasNext();) {
          AddressPersonLink addressPersonLink = it.next();
          if (addressPersonLink.getIndPersAddrLinkPrimary().equals("Y")
              && DateHelper.isNull(addressPersonLink.getDtPersAddrLinkEnd())) {
            personAddress = addressPersonLink.getPersonAddress();
            break;
          }
        } 
      } 
    } 
    return personAddress;
  }
  
  private String getPersonRace(Integer idPerson){
    StringBuffer strPersonRace = new StringBuffer();
    //Get the Person Race
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
    for(int i = 0; i < personRaceList.size(); i++){
      PersonRace personRace = personRaceList.get(i);
      if (personRace.getCdRace() != null){
        if (i+1 < personRaceList.size()){
          strPersonRace.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace())+", ");
        }else if (i+1 == personRaceList.size()){
          strPersonRace.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace()));
        }
      }
    }    
    return strPersonRace.toString();
  }
  
  private PersonEthnicity retrievePersonEthnicityData(int idPerson) {
    PersonEthnicity personEthnicity = null;
    personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);

    return personEthnicity;
  }

  private FormDataGroup getsvcAuthDetail(SvcAuthDetail svcAuthDetail) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SERVICE, FCM06O00V2);

    String entitlementCodeLong = "";
    String entitlementCodeShort = "";
    entitlementCodeLong = Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, svcAuthDetail.getCdSvcAuthDtlSvc());
    entitlementCodeShort = entitlementCodeLong.substring(3);
    
    // Replace the line separator from the form to line break
    String reasonForRefCommentsRaw = "";
    reasonForRefCommentsRaw = FormattingHelper.formatString(svcAuthDetail.getTxtCmmtsAdditional());
    String reasonForRefComments = "";
    reasonForRefComments = reasonForRefCommentsRaw.replaceAll("\r\n", "<br />");

    group.addBookmark(createBookmark(SERVICE_NAMES, svcAuthDetail.getPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(ENTITLEMENT_CODE, entitlementCodeShort));
    group.addBookmark(createBookmark(REASON_FOR_REF_COMMENTS, reasonForRefComments));
    group.addBookmark(createBookmark(NBR_SVC_AUTH_DTL_UNIT_RATE,
                                     FormattingHelper.formatMoney(svcAuthDetail.getNbrSvcAuthDtlUnitRate())));
    group.addBookmark(createBookmark(NBR_SVC_AUTH_DTL_UNIT_REQ, svcAuthDetail.getNbrSvcAuthDtlUnitsReq()));
    group.addBookmark(createBookmark(ID_SVC_AUTH_DTL, svcAuthDetail.getIdSvcAuthDtl()));
    group.addBookmark(createBookmark(AMT_SVC_AUTH_DTL_AMT_REQ,
                                     FormattingHelper.formatMoney(svcAuthDetail.getAmtSvcAuthDtlAmtReq())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_BEGIN,
                                     FormattingHelper.formatDate(svcAuthDetail.getDtSvcAuthDtlBegin())));
    group.addBookmark(createBookmark(DT_SVC_AUTH_DTL_END,
                                     FormattingHelper.formatDate(svcAuthDetail.getDtSvcAuthDtlEnd())));
    return group;
  }

  private FormDataGroup displayOtherPrincipalStatus(StagePersonLink stagePersonLink) {
    FormDataGroup group = createFormDataGroup(TMPLAT_OTHER_MEMBERS, FCM06O00V2);
    String membersName = stagePersonLink.getPerson().getNmPersonFull();
    Person person = stagePersonLink.getPerson();
    int idPerson = stagePersonLink.getPerson().getIdPerson().intValue();
    // Gets name of the Other Principal in the stage
    if (membersName != null) {
      group.addBookmark(createBookmark(OTHER_NM, membersName));
    }
    if (person != null) {
      group.addBookmark(createBookmark(OTHER_PRN_DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));
      String address = "";
      PersonAddress primaryPersonAddress = getPrimaryPersonAddress(person);
      if (primaryPersonAddress != null) {
        StringBuffer addr = new StringBuffer();
        formatAddress(person.getAddrPersonStLn1(), null, person.getAddrPersonCity(), person.getCdPersonState(),
                      person.getAddrPersonZip(), addr);
        address = addr.toString();
      }
      group.addBookmark(createBookmark(OTHER_PRN_ADDRESS, FormattingHelper.formatString(address)));
    }
    // Gets the Relationship of the person in the stage
    group.addBookmark(createBookmark(OTHER_PRN_RELATIONSHIP,
                                     Lookup.simpleDecodeSafe(CodesTables.CRPTRINT,
                                                             stagePersonLink.getCdStagePersRelInt())));
    // Gets the Address and Phone fields
    String otherPrnPhone = null;
    otherPrnPhone = retrievePrimaryPersonPhoneData(idPerson);
    group.addBookmark(createBookmark(OTHER_PRN_PHONE, otherPrnPhone));

    return group;
  }

  /**
   * Gets the Case Manager / Supervisor information
   * 
   * @param preFillData
   * @param stage
   * @param event
   */
  private void getCaseManagerSection(PreFillData preFillData, Stage stage, Event event) {
    int idStage = stage.getIdStage();
    // Find Case Manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRole(idStage);
    Integer idCaseManager = 0;
    if (stagePersonLink != null) {
      idCaseManager = stagePersonLink.getPerson().getIdPerson();
    }
    if (idCaseManager > 0) {
      Person manager = personDAO.findPersonByIdPerson(idCaseManager);
      
      // Find the Supervisor of the Case Manager
      int idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
      Person supervisor = personDAO.findPersonByIdPerson(idSupervisor);
      String caseManagerPhone = null;
      caseManagerPhone = retrievePrimaryPersonPhoneData(idCaseManager);      
      String supervisorPhone = "";
      supervisorPhone = retrievePrimaryPersonPhoneData(idSupervisor);

      preFillData.addBookmark(createBookmark(MANAGER_NM, manager.getNmPersonFull()));
      preFillData.addBookmark(createBookmark(MANAGER_PHONE, caseManagerPhone));
      getBusinessFaxNum(idCaseManager, preFillData, IND_CASE_MANAGER);
      
      preFillData.addBookmark(createBookmark(SUPERVISOR_NM, supervisor.getNmPersonFull()));
      preFillData.addBookmark(createBookmark(SUPERVISOR_PHONE, supervisorPhone));
      getBusinessFaxNum(idSupervisor, preFillData, IND_SUPERVISOR);
    }
  }

  private String retrievePrimaryPersonPhoneData(int idPerson) {
    String phoneNbr = null;
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    PersonPhone personPhone = null;
    if (idPerson != 0) {
      personPhone = personPhoneDAO.findPersonPhoneByIdPersonAndMaxDate(idPerson, maxDate);
    }

    if (personPhone != null) {
      if (personPhone.getNbrPersonPhoneExtension() != null) {
        // Display extension after the phone number if it exists
        phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()) + " Ext. "
                   + personPhone.getNbrPersonPhoneExtension();
      } else {
        phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
      }
    }
    return phoneNbr;
  }
  
  private void getBusinessFaxNum(int idPerson, PreFillData preFillData, String indCmOrSup) {
    String faxNbr = null;
    String personFax = null;
    if (idPerson != 0) {
      // Find fax number with Type 'Business Fax(BF)'
      personFax = personPhoneDAO.findNbrPersonPhoneByIdPersonAndPhoneType(idPerson, "BF");
    }
    if (personFax != null) {
      faxNbr = FormattingHelper.formatPhone(personFax);
    }
    if (IND_CASE_MANAGER.equals(indCmOrSup)) {
      preFillData.addBookmark(createBookmark(MANAGER_FAX, faxNbr));
    } else if (IND_SUPERVISOR.equals(indCmOrSup)) {
      preFillData.addBookmark(createBookmark(SUPERVISOR_FAX, faxNbr));
    }
  }       

  /*
   * Gets Business phone and fax numbers for the Resource
   */
  private void getResourcePhoneNumbers(CapsResource capsResource, PreFillData preFillData) {
    Collection<ResourcePhone> resourcePhones = capsResource.getResourcePhones();
    if (resourcePhones != null && !resourcePhones.isEmpty()) {
      for (Iterator<ResourcePhone> it = resourcePhones.iterator(); it.hasNext();) {
        ResourcePhone resourcePhone = it.next();
        String resourcePhoneType = resourcePhone.getCdRsrcPhoneType();
        // Resource Phone Type as 01 - Primary; only one phone number can be Primary
        if ("01".equals(resourcePhoneType)) { // 01 - Primary
          displayResourcePhone(resourcePhone, preFillData, resourcePhoneType);
        }
      } 
      // Find the most recently entered Resource phone number having Phone Type as 03 - Bus-Fax
      // Phone Type 03 - Bus-Fax can be multiple
      String resourceFax = null;
      int idResource = capsResource.getIdResource();
      resourceFax = resourcePhoneDAO.findLatestNbrResourcePhoneByIdResourceByCdPhoneType(idResource, "03");
      if (resourceFax != null) {
        preFillData.addBookmark(createBookmark(SERVICE_FAX_NUM,
                                               FormattingHelper.formatPhone(resourceFax)));
      }
    }
  }

  private PreFillData displayResourcePhone(ResourcePhone resourcePhone, PreFillData preFillData,
                                           String resourcePhoneType) {
    if ("01".equals(resourcePhoneType)) {
      preFillData.addBookmark(createBookmark(SERVICE_TELEPHONE_NUM,
                                             FormattingHelper.formatPhone(resourcePhone.getNbrRsrcPhone())));
    } 
    
    return preFillData;
  }

  private void formatAddress(String stLn1, String stLn2, String city, String state, String zip, StringBuffer addr) {
    if (stLn1 != null) {
      addr = addr.append(stLn1);
    }
    if (stLn2 != null) {
      addr = addr.append(", " + stLn2);
    }
    if (city != null) {
      addr = addr.append(", " + city);
    }
    if (state != null) {
      addr = addr.append(", " + state);
    }
    if (zip != null) {
      addr = addr.append(", " + zip);
    }
  }

  // STGAP00017831: Method to retrieve all the approvers who approved the service auth
  private void retrieveApprovalHistory(PreFillData preFillData, Event event) {
    if (event != null) {
      DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
      List<Approvers> approversList = approversDAO.findApproversByIdEventReverseChronology(event.getIdEvent());
      if (approversList != null && !approversList.isEmpty()) {
        List<Approver> historicals = new ArrayList<Approver>();
        boolean first = true;
        Date saRequestedDate = null;
        for (Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
          Approvers approvers = it.next();
          // The Approvers section should display all those who have approved the service auth, hence
          // filtering the approvers records based upon the APPROVERS.CD_APPROVERS_STATUS value.
          if (CodesTables.CAPPDESG_APRV.equals(approvers.getCdApproversStatus())) {
            if (saRequestedDate == null || saRequestedDate.after(approvers.getDtApproversRequested())) {
              saRequestedDate = approvers.getDtApproversRequested();
            }
            preFillData.addFormDataGroup(getApproversInfo(approvers, dateFormat));
          }
        }
        preFillData.addBookmark(createBookmark(SA_REQUESTED_BY, event.getPerson().getNmPersonFull()));
        String saRequestedDateStr = dateFormat.format(saRequestedDate);
        preFillData.addBookmark(createBookmark(DT_SA_REQUESTED, saRequestedDateStr));
      }
    }
  }

  /**
   * This method populates the List of Approvers who approved the Service Authorization
   * @param approvers
   * @param dateFormat
   * @return
   */
  private FormDataGroup getApproversInfo(Approvers approvers, DateFormat dateFormat) {
    FormDataGroup group = createFormDataGroup(TMPLAT_APPROVER, FCM06O00V2);
    if (approvers.getPerson() != null) {
      group.addBookmark(createBookmark(SA_APPAROVED_BY, approvers.getPerson().getNmPersonFull()));
    }
    String dtApproverDetermination = dateFormat.format(approvers.getDtApproversDetermination());
    group.addBookmark(createBookmark(DT_SA_APPROVED, dtApproverDetermination));
    return group;
  }
  
  /**
   * Retrieve and set pre-fill data for 
   * 1. Prior DFCS History
   * 2. Length of time the Current Case has been opened (months)
   * 2. Current and Historical CPS Reasons
   * @param preFillData
   * @param currStage
   * @param peronsRefForService
   */
  private void retrieveCaseHistory(PreFillData preFillData, Stage currStage, List<Integer> peronsRefForService) {
    CapsCase currCase = currStage.getCapsCase();
    boolean isAdoToPad = hasLinkToCdStage(currStage.getIdStage(), CodesTables.CSTAGES_ADO);

    
    if (isNotEmptyList(peronsRefForService)) {
      Date dtCurrCaseOpened = currCase.getDtCaseOpened();
      List<Integer> idCaseMergeFromList = findCaseMerge(currCase.getIdCase());      
      /*
       * Prior DFCS History?
       */
      // Do not disclose any information if DFCS adopted child case (ADO->PAD). Leave the field blank.
      if (!isAdoToPad) {
        boolean hasPriorDfcsHistory = hasPriorDfcsHistory(peronsRefForService, currStage, idCaseMergeFromList);
        if (hasPriorDfcsHistory) {
          preFillData.addBookmark(createBookmark(DFCS_HISTORY_YES, CBX_X));
          preFillData.addBookmark(createBookmark(DFCS_HISTORY_NO, CBX_NO_X));
        } else {
          preFillData.addBookmark(createBookmark(DFCS_HISTORY_NO, CBX_X));
          preFillData.addBookmark(createBookmark(DFCS_HISTORY_YES, CBX_NO_X));
        }
      }
      /*
       * Length of time the Current Case has been opened?
       */
      // STGAP00017999 Added converted cases into the consideration of the field calculation
      // if merged or converted case, the start date should be of the current episode, not the entire case history.
      // Find the start date of the current episode: should be the start date of the Intake that led to the current
      // stage, if INT exists, or that of the first stage
      Stage firstStageCurr = findFirstProgressionStage(currStage.getIdStage());
      Date firstStageCurrStart = firstStageCurr.getDtStageStart();
      // If the current episode starts after the case start, this is a merged/consolidate case,
      // length is calculated based on the current episode
      if (DateHelper.isAfter(firstStageCurrStart, dtCurrCaseOpened)) {
        dtCurrCaseOpened = firstStageCurr.getDtStageStart();
      }
      int monsCaseOpened = DateUtility.getAgeInMonths(dtCurrCaseOpened, new Date());
      preFillData.addBookmark(createBookmark(LENGTH_OF_CASE_OPEN, ""+monsCaseOpened));
    }
    // CPS reason
    List<String> maltreatmentTypes = findCpsReason(currCase.getIdCase());
    if (maltreatmentTypes.contains("E")) {
      preFillData.addBookmark(createBookmark(CPS_EMOTIONAL, CBX_X));
    } else {
      preFillData.addBookmark(createBookmark(CPS_EMOTIONAL, CBX_NO_X));
    }
    if (maltreatmentTypes.contains("P")) {
      preFillData.addBookmark(createBookmark(CPS_PHYSICAL, CBX_X));
    } else {
      preFillData.addBookmark(createBookmark(CPS_PHYSICAL, CBX_NO_X));
    }
    if (maltreatmentTypes.contains("S")) {
      preFillData.addBookmark(createBookmark(CPS_SEXUAL, CBX_X));
    } else {
      preFillData.addBookmark(createBookmark(CPS_SEXUAL, CBX_NO_X));
    }
    if (maltreatmentTypes.contains("N")) {
      preFillData.addBookmark(createBookmark(CPS_NEGLECT, CBX_X));
    } else {
      preFillData.addBookmark(createBookmark(CPS_NEGLECT, CBX_NO_X));
    }
  }
    
  /**
   * This determines whether prior involvement exists for any of the person referred for services.
   * If a person is a principal in another case that opened before the current episode, it constitutes
   * prior history.
   * @param peronsRefForService
   * @param currStage
   * @param idCaseMergeFromList
   * @return
   */
  private boolean hasPriorDfcsHistory(List<Integer> peronsRefForService, Stage currStage, List<Integer> idCaseMergeFromList) {
    boolean hasPriorDfcsHistory = false;
    CapsCase currCase = currStage.getCapsCase();
    Date dtCurrCaseOpened = currCase.getDtCaseOpened();
    int idStage = currStage.getIdStage();
    int idCase = currCase.getIdCase();

    List<String> cdPrnStagePersTypes = Arrays.asList(new String[] { CodesTables.CPRSNTYP_PRN });
    List<String> cdInvStages = Arrays.asList(new String[] { CodesTables.CSTAGES_INV });
    List<String> cdIntStages = Arrays.asList(new String[] { CodesTables.CSTAGES_INT });
    List<String> cdStageReasonClosedInt = Arrays.asList(new String[] { CodesTables.CDISP_SCO, CodesTables.CDISP_OIE });
    List<String> cdStageReasonClosedInv = Arrays.asList(new String[] { CodesTables.CCRSKFND_06 });
    // Compare date
    // Apply peeling and elimination  
    for (Integer idPerson : peronsRefForService) {
      // Check whether the person is principal in an incomplete intake which id case has not been assigned.
      long cntOpenIntake = stagePersonLinkDAO.countStagePersonLinkByIdPersonCdPersTypeCdStageDtStageStart(idPerson,
                                                                                                   cdPrnStagePersTypes,
                                                                                                   cdIntStages,
                                                                                                   dtCurrCaseOpened);
      if (cntOpenIntake > 0l) {
        hasPriorDfcsHistory = true;
        break;
      }
      // Find whether the person is involved in any other cases: find all cases that the person is PRN, excluding the
      // current case, TODO - its best to filter cases opened prior to current case here
      List<Integer> idCaseOtherList = stagePersonLinkDAO.findOtherIdCaseByIdCaseIdPersonCdStagePersType(idCase,
                                                                                                        idPerson,
                                                                                                        cdPrnStagePersTypes);
      // Remove invalid cases. Invalid cases are INT cases whose disposition is Screen Out or Opened in Error
      // or INV cases concluded opened in error.
      // INT closed with SCO or OIE has stage closed reason as SCO or OIE respectively
      // INV cases closed with risk finding Opened in Error (06) has stage close reason 06
      if (isNotEmptyList(idCaseOtherList)) {
        List<Integer> idCaseOtherInvalidIntList = stageDAO.findIdCasesByIdCaseCdStageCdStageReasonClosed(idCaseOtherList,
                                                                                                         cdIntStages,
                                                                                                         cdStageReasonClosedInt);
        if (isNotEmptyList(idCaseOtherInvalidIntList)) {
          idCaseOtherList.removeAll(idCaseOtherInvalidIntList);
        }
        if (isNotEmptyList(idCaseOtherList)) {
          List<Integer> idCaseOtherInvalidInvList = stageDAO.findIdCasesByIdCaseCdStageCdStageReasonClosed(idCaseOtherList,
                                                                                                           cdInvStages,
                                                                                                           cdStageReasonClosedInv);
          if (isNotEmptyList(idCaseOtherInvalidInvList)) {
            idCaseOtherList.removeAll(idCaseOtherInvalidInvList);
          }
        } else { // there is no more "other" cases, this person is not principal in prior case, move to the next person
          continue;
        }
      }
      // This person is not involved in other valid cases, Move on to the next person
      else {
        continue;
      }
      // If the person was added as principal to other case before the current case open, the other case must have been
      // open before the current case, hence, prior history exists.
      // STGAP00018034: only performed the next tests when there are "other cases" after previous removals
      if (isNotEmptyList(idCaseOtherList)) {
        long cntPriorCase = stagePersonLinkDAO.countStagePersonLinkByIdCaseIdPersonCdPersTypeDtPersAdded(idCaseOtherList,
                                                                                                         idPerson,
                                                                                                         cdPrnStagePersTypes,
                                                                                                         dtCurrCaseOpened);
        if (cntPriorCase > 0l) {
          hasPriorDfcsHistory = true;
          break;
        }
        // Otherwise, next scenario:
        // The person can be added to the other case after the current case opened but if added to INV,
        // it is still prior history.
        // Find if person is part of INV in the other case where the case starts before the current case
        long cntPriorInv = stagePersonLinkDAO.countStagePersonLinkByIdCaseIdPersonCdStageCdPersTypeDtCaseOpened(idCaseOtherList,
                                                                                                                idPerson,
                                                                                                                cdInvStages,
                                                                                                                cdPrnStagePersTypes,
                                                                                                                dtCurrCaseOpened);
        if (cntPriorInv > 0l) {
          hasPriorDfcsHistory = true;
          break;
        }
      }
    } // end searching for involvement in other cases for the peronsRefForService list

    // If history still not found, look if the case is a merge case then look within the case to see if
    // history exists. For merged case, if there are other episodes opened prior to the current episode, history exists.
    if (!hasPriorDfcsHistory && isNotEmptyList(idCaseMergeFromList)) {
      // STGAP00017996: whether the current stage belong to the Closed case of the merge
      List<Integer> idStageMergeFromList = caseMergeDAO.findStageMergeFromByIdCaseMergeFrom(idCaseMergeFromList);
      boolean isIdStageInClosedMerge = isNotEmptyList(idStageMergeFromList) && idStageMergeFromList.contains(idStage);
      // Exclude merged-from cases where INV conclusion is Opened in Error.
      // Find INV opened in error (invalid) from the merge-from case list
      List<Integer> idCaseMergeFromInvalidInvList = caseMergeDAO.findIdCaseMergeFromByIdCaseCdStageCdStageReasonClosed(idCaseMergeFromList,
                                                                                                                       cdInvStages,
                                                                                                                       cdStageReasonClosedInv);
      // Remove invalid merge-from cases
      if (isNotEmptyList(idCaseMergeFromInvalidInvList)) {
        idCaseMergeFromList.removeAll(idCaseMergeFromInvalidInvList);
        // Find the start date of the current episode: should be the start date of the Intake that led to the current
        // stage, if INT exists, or that of the first stage
      }
      if (isNotEmptyList(idCaseMergeFromList)) {
        Stage firstStageCurr = findFirstProgressionStage(idStage);
        Date firstStageCurrStart = firstStageCurr.getDtStageStart();
        // dtCurrCaseOpened = firstStageCurr.getDtStageStart(); STGAP00017996: retain the current case open for next
        // check
        // If any of the valid merged-from cases opened before the current episode, prior history exists.
        long cntPriorCase = capsCaseDAO.countByIdCaseDtCaseOpened(idCaseMergeFromList, firstStageCurrStart);
        if (cntPriorCase > 0l) {
          hasPriorDfcsHistory = true;
        }
        // STGAP00017996: to cover the case merge where a newer case is merged (closed) to the old case and the
        // Service Auth stage belongs to the Closed case of the merge.
        // Find if the Service Auth stage belongs to the Closed case
        // Consider the current case in prior history because it could be the older case
        if (isIdStageInClosedMerge && DateHelper.isAfter(firstStageCurrStart, dtCurrCaseOpened)) {
          hasPriorDfcsHistory = true;
        }
      }
    }
    
    // STGAP00017996: MR-102
    // Additional logic per design change -
    // Added converted cases into the consideration of the Prior DFCS History field calculation
    // The logic will look at the start of the current episode and the case start date
    // If the current episode starts after the case start, the case is a converted case and the history exists
    if (!hasPriorDfcsHistory && !isNotEmptyList(idCaseMergeFromList)) {
      Stage firstStageCurr = findFirstProgressionStage(currStage.getIdStage());
      Date firstStageCurrStart = firstStageCurr.getDtStageStart();
      // If the current episode starts after the case start, this is a merged/consolidate case,
      // length is calculated based on the current episode
      if (DateHelper.isAfter(firstStageCurrStart, dtCurrCaseOpened)) {
        hasPriorDfcsHistory = true;
      }
    }
    return hasPriorDfcsHistory;
  }
  
  /**
   * Helper method to check whether a list of object is not empty.
   * @param aList
   * @return true if the passed in list is not empty, false if it is empty or null.
   */
  private boolean isNotEmptyList(List<?> aList) {
    return (aList != null && aList.size() > 0);
  }
  
  /**
   * Helper method to find merge-to case id of an active merge (not pending, not invalid, and not split)
   * @param idCase
   * @return
   */
  private List<Integer> findCaseMerge(Integer idCase) {
    return caseMergeDAO.findActiveIdCaseMergeFromByIdCaseMergeTo(idCase);
  }
  
  /**
   * Helper method to find the first stage of the progression of the given stage within the same case.
   * @param idCurrStage
   * @return
   */
  private Stage findFirstProgressionStage(int idCurrStage) {
    int idTargetStage = idCurrStage;
    while (true) {
      // Find prior stage from within the same case 
      // For adoption finalized PAD, ADO is not considered as prior stage because they are in different case
      // The foster care episode is not part of the post adoption episode.
      Stage priorStage = stageLinkDAO.findPriorStageByIdCurrStage(idCurrStage);
      // if there is prior stage, continue the look up
      if (priorStage != null) {
          // reset the idCurrSstage to the prior stage id for further lookup.
          idCurrStage = priorStage.getIdStage();
      } 
      // There is no prior stage, return the current stage
      else {
        if (idTargetStage == idCurrStage) {
          // there is no history, return the current Stage object in memory 
          return getPersistentObject(Stage.class, idCurrStage);
        } else {
          // progression history exists, return the earliest stage
          return stageDAO.findStageByIdStage(idCurrStage);
        }
      }
    }
  }
  
  /**
   * Find the type of maltreatment from the maltreatment codes. Applying the same logic with the investigation allegation page.
   * All Neglect codes starts with "N"; Same rule for [E]motion Abuse, [P]hysical Abuse, and [S]exual Abuse
   * @param idCase
   * @return list of string N, P, S, E.
   */
  private List<String> findCpsReason(int idCase) {
    String cdDisposition = CodesTables.CDISPSTN_SUB;
    List<String> cdMalTypeSet = Arrays.asList(new String[] { "N","S","P","E" }); // Neglect, Sexual Abuse, Physical Abuse, Emotional Abuse
    
    return allegationDAO.findByIdCaseCdDispositionCdMalType(idCase, cdDisposition, cdMalTypeSet);
  }
  
  /**
   * Helper method to determine whether a given stage type preceded the current stage by means of stage progression
   * @param idStage
   * @param cdStage
   * @return
   */
  private boolean hasLinkToCdStage(int idStage, String cdStage) {
    List<String> cdStages = new ArrayList<String>();
    cdStages.add(cdStage);
    Integer result = stageLinkDAO.findStageLinkByIdStageAndCdStage(idStage, cdStages);

    return (result != null);
  }
}