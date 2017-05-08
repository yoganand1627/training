package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/**Change History:
Date          User              Description
----------    ----------------  --------------------------------------------------
03/22/2011    hjbaptiste        SMS#97850: MR-75 Foster Home Batch To Dos. Fixed an NPE (Null Pointer Exception)
                                event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0.
                                whenever the Person object was returned null. Removed the (.getIdPerson()) in the 
                                test for null. Did the same for event.getStage().getIdStage()

*/

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeEthnicityDAO;
//import gov.georgia.dhr.dfcs.sacwis.dao.FaHomeIntEthnicDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;
//import gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveHomeDemographics;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY;

public class RetrieveHomeDemographicsImpl extends BaseServiceImpl implements RetrieveHomeDemographics {
  private CapsResourceDAO capsResourceDAO = null;
  private ContractDAO contractDAO = null;
  private ContractPeriodDAO contractPeriodDAO = null;
  private ContractServiceDAO contractServiceDAO = null;
  private ContractVersionDAO contractVersionDAO = null;
  private EventDAO eventDAO = null;
  private HomeRaceDAO homeRaceDAO = null;
  private HomeEthnicityDAO homeEthnicityDAO = null;
  private HomeApplicantCbxDAO homeApplicantCbxDAO = null;
  private ResourceAddressDAO resourceAddressDAO = null;
  private ResourceHistoryDAO resourceHistoryDAO = null;
  private ResourceChrctrDAO resourceChrctrDAO = null;
  private ResourcePhoneDAO resourcePhoneDAO = null;
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
 
  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) throws ServiceException {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setHomeEthnicityDAO(HomeEthnicityDAO homeEthnicityDAO) {
    this.homeEthnicityDAO = homeEthnicityDAO;
  }
  
  public void setHomeRaceDAO(HomeRaceDAO homeRaceDAO) {
	  this.homeRaceDAO = homeRaceDAO;
  }
	  
  public void setHomeApplicantCbxDAO(HomeApplicantCbxDAO homeApplicantCbxDAO) {
    this.homeApplicantCbxDAO = homeApplicantCbxDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }


  public CFAD07SO retrieveHomeDemographics(CFAD07SI cfad07si) throws ServiceException {
    CFAD07SO cfad07so;
    String cReqFuncCd = cfad07si.getArchInputStruct().getCReqFuncCd();
    if (RETRIEVE_RESOURCE.equals(cReqFuncCd)) {
      cfad07so = retrieveResource(cfad07si);
    } else if (RETRIEVE_HISTORY.equals(cReqFuncCd)) {
      cfad07so = retrieveResourceHistory(cfad07si);
    } else {
      // Need a default value, as a bad value for cReqFuncCd is not an error in the C (though should be???).
      cfad07so = new CFAD07SO();
    }
    
    if (approvalEventLinkDAO.findApprovalEventLinkByIdEvent(cfad07si.getUlIdEvent()) != null) {
      cfad07so.setSzApprovalStatus(ArchitectureConstants.TRUE);
    } else {
      cfad07so.setSzApprovalStatus(ArchitectureConstants.FALSE);
    }
    
    int idResource = cfad07so.getUlIdResource();
    //retrieve programs of interest; new in SHINES
    cfad07so.setROWCFAD07SOG07_ARRAY(retrievePrgrmsOfInterest( idResource ) );
    
    // Retrieve resource characteristics with clss48d
    cfad07so.setROWCFAD07SOG02_ARRAY(retrieveResourceCharacteristics(idResource));

    // Retrieve home interest ethnicities with clss04d
    cfad07so.setROWCFAD07SOG03_ARRAY(retrieveHomeInterestEthnicities(idResource));

    // Retrieve home interest race 
    cfad07so.setHomeRaceSO_ARRAY(retrieveHomeInterestRaces(idResource));

    // Retrieve resource address with cres13d and cres08d
    // The results of cres13d populate ROWCFAD07SOG01_ARRAY.
    // The result of cres08d is used to poulate the szTxtSchDistName field of cfad07so; nothing else is modified.
    cfad07so.setROWCFAD07SOG01_ARRAY(retrieveResourceAddress(idResource, cfad07so));

    // Retrieve resource phone with cres14d
    cfad07so.setROWCFAD07SOG00_ARRAY(retrieveResourcePhone(idResource));

    // Get the current date and set it into the output object (Moved from the top to allow for breaking into methods).
    org.exolab.castor.types.Date dtSysDtGenericSysdate = DateHelper.getTodayCastorDate();
    cfad07so.setDtSysDtGenericSysdate(dtSysDtGenericSysdate);

    // Determine contracts existance: is there an open foster and adoptive contract for this home?
    cfad07so.setBIndEndDateMod(ArchitectureConstants.N);
    return cfad07so;
  }

  private CFAD07SO retrieveResourceHistory(CFAD07SI cfad07si) throws ServiceException {
    CFAD07SO cfad07so;
    cfad07so = new CFAD07SO();
    ROWCFAD07SOG04 rowcfad07sog04 = new ROWCFAD07SOG04();
    ROWCFAD07SOG05 rowcfad07sog05 = new ROWCFAD07SOG05();
    ROWCFAD07SOG06 rowcfad07sog06 = new ROWCFAD07SOG06();
    // cses02d
    ResourceHistory resourceHistory = resourceHistoryDAO.findResourceHistoryByIdEvent(cfad07si.getUlIdEvent());
    if (resourceHistory == null) {
      throw new ServiceException(Messages.MSG_FAD_HISTORY_DELETED);
    }
    // Set fields in CFAD07SOG04 and CFAD07SOG05 to fields in ResourceHistory
    rowcfad07sog04.setSzCdRshsClosureRsn(resourceHistory.getCdRshsClosureRsn());
    rowcfad07sog04.setSzCdRshsEthnicity(resourceHistory.getCdRshsEthnicity());
    rowcfad07sog04.setSzCdRshsLanguage(resourceHistory.getCdRshsLanguage());
    rowcfad07sog04.setSzCdRshsMaritalStatus(resourceHistory.getCdRshsMaritalStatus());
    rowcfad07sog04.setSzCdRshsRegion(resourceHistory.getCdRshsRegion());
    rowcfad07sog04.setSzCdRshsReligion(resourceHistory.getCdRshsReligion());
    rowcfad07sog04.setSzCdRshsRespite(resourceHistory.getCdRshsRespite());
    rowcfad07sog04.setSzCdRshsSourceInquiry(resourceHistory.getCdRshsSourceInquiry());
    rowcfad07sog04.setSzNmRshsResource(resourceHistory.getNmRshsResource());
    rowcfad07sog04.setSzCdRshsState(resourceHistory.getCdRshsState());
    rowcfad07sog04.setSzCdRshsCnty(resourceHistory.getCdRshsCnty());
    // STGAP00005199 - idResource was incorrectly assigned. Also, 
    // Conversation was looking for idResource at SO top level so set it here for cfad07so too
    int idResource = resourceHistory.getCapsResource().getIdResource();
    rowcfad07sog04.setUlIdResource(idResource);
    cfad07so.setUlIdResource(idResource); // keep this assingment here just to make changes regarding this defect easy to find
    /*rowcfad07sog04.setUlIdResource(
            resourceHistory.getIdResourceHistory() != null ? resourceHistory.getIdResourceHistory() : 0);*/
    // end STGAP00005199
    rowcfad07sog04.setDtDtRshsMarriage(DateHelper.toCastorDate(resourceHistory.getDtRshsMarriage()));
    rowcfad07sog04.setCIndRshsCareProv(resourceHistory.getIndRshsCareProv());
    rowcfad07sog04.setCIndCurrHomeStudyExists(resourceHistory.getIndCurrHmStdyExsts());
    rowcfad07sog04.setCIndRshsNonDFCSHome(resourceHistory.getIndRsrcNondfcs());
    rowcfad07sog04.setSzTxtNdfcsCertEntity(resourceHistory.getNdfcsCertEntity());
    rowcfad07sog04.setDNbrRshsAnnualIncome(resourceHistory.getNbrRshsAnnualIncome());
    rowcfad07sog04.setSzNmLegal(resourceHistory.getNmLegal());

    // If the Historical Record is being retrieved, then pass the Resource Table's
    // stage out to the Event Group.  This is needed to create the Report.
    rowcfad07sog06.setUlIdStage(
            resourceHistory.getStage().getIdStage() != null ? resourceHistory.getStage().getIdStage() : 0);

    // Group 5 population
    rowcfad07sog05.setUNbrRsrcIntChildren(
            resourceHistory.getNbrRshsIntChildren() != null ? resourceHistory.getNbrRshsIntChildren() : 0);
    rowcfad07sog05.setUNbrRsrcIntFeAgeMax(
            resourceHistory.getNbrRshsIntFeAgeMax() != null ? resourceHistory.getNbrRshsIntFeAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcIntFeAgeMin(
            resourceHistory.getNbrRshsIntFeAgeMin() != null ? resourceHistory.getNbrRshsIntFeAgeMin() : 0);
    rowcfad07sog05.setUNbrRsrcIntMaAgeMax(
            resourceHistory.getNbrRshsIntMaAgeMax() != null ? resourceHistory.getNbrRshsIntMaAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcIntMaAgeMin(
            resourceHistory.getNbrRshsIntMaAgeMin() != null ? resourceHistory.getNbrRshsIntMaAgeMin() : 0);
    rowcfad07sog05.setCIndRsrcEmergPlace(resourceHistory.getIndRshsEmergPlace());
    rowcfad07sog05.setCIndRsrcTransport(resourceHistory.getIndRshsTransport());
    rowcfad07sog05.setUNbrRsrcFMAgeMax(
            resourceHistory.getNbrRshsFmAgeMax() != null ? resourceHistory.getNbrRshsFmAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcFMAgeMin(
            resourceHistory.getNbrRshsFmAgeMin() != null ? resourceHistory.getNbrRshsFmAgeMin() : 0);
    rowcfad07sog05.setUNbrRsrcMlAgeMax(
            resourceHistory.getNbrRshsMaAgeMax() != null ? resourceHistory.getNbrRshsMaAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcMlAgeMin(
            resourceHistory.getNbrRshsMaAgeMin() != null ? resourceHistory.getNbrRshsMaAgeMin() : 0);
    rowcfad07sog05.setSzTxtRsrcComments(resourceHistory.getTxtRshsComments());
    rowcfad07sog05.setTxtHmPrgInterest(resourceHistory.getCapsResource().getTxtHmPrgInterest());

    // Add the row objects to the output.
    cfad07so.setROWCFAD07SOG04(rowcfad07sog04);
    cfad07so.setROWCFAD07SOG05(rowcfad07sog05);
    cfad07so.setROWCFAD07SOG06(rowcfad07sog06);
    return cfad07so;
  }

  private CFAD07SO retrieveResource(CFAD07SI cfad07si) throws ServiceException {
    CFAD07SO cfad07so;
    cfad07so = new CFAD07SO();
    ROWCFAD07SOG04 rowcfad07sog04 = new ROWCFAD07SOG04();
    ROWCFAD07SOG05 rowcfad07sog05 = new ROWCFAD07SOG05();
    ROWCFAD07SOG06 rowcfad07sog06 = new ROWCFAD07SOG06();
    // cses41d
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(cfad07si.getUlIdStage());
    if (capsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Set fields in CFAD07SOG04 and CFAD07SOG05 to fields in CapsResource if the event status is
    //   New Group 4 population.
    cfad07so.setUlIdResource(capsResource.getIdResource() != null ? capsResource.getIdResource() : 0);
    rowcfad07sog04.setSzCdRshsCategory(capsResource.getCdRsrcCategory());
    rowcfad07sog04.setSzCdRshsClosureRsn(capsResource.getCdRsrcClosureRsn());
    rowcfad07sog04.setSzCdRshsEthnicity(capsResource.getCdRsrcEthnicity());
    rowcfad07sog04.setSzCdRshsFaHomeStatus(capsResource.getCdRsrcFaHomeStatus());
    rowcfad07sog04.setSzCdRshsLanguage(capsResource.getCdRsrcLanguage());
    // Vendor ID passed back to client to test for the existance of a VID when saving a non-prs home
    rowcfad07sog04.setSzNbrRshsVid(capsResource.getNbrRsrcVid());
    rowcfad07sog04.setSzCdRshsMaritalStatus(capsResource.getCdRsrcMaritalStatus());
    rowcfad07sog04.setSzCdRshsRegion(capsResource.getCdRsrcRegion());
    rowcfad07sog04.setSzCdRshsReligion(capsResource.getCdRsrcReligion());
    rowcfad07sog04.setSzCdRshsRespite(capsResource.getCdRsrcRespite());
    rowcfad07sog04.setSzNmRshsResource(capsResource.getNmResource());
    rowcfad07sog04.setSzCdRshsState(capsResource.getCdRsrcState());
    rowcfad07sog04.setSzCdRshsCnty(capsResource.getCdRsrcCnty());
    rowcfad07sog04.setTsLastUpdate(capsResource.getDtLastUpdate());
    rowcfad07sog04.setUlIdResource(capsResource.getIdResource() != null ? capsResource.getIdResource() : 0);
    rowcfad07sog04.setDtDtRshsMarriage(DateHelper.toCastorDate(capsResource.getDtRsrcMarriage()));
    rowcfad07sog04.setCIndRshsCareProv(capsResource.getIndRsrcCareProv());
    rowcfad07sog04.setCIndCurrHomeStudyExists(capsResource.getIndCurrHmStdyExsts());
    rowcfad07sog04.setCIndRshsNonDFCSHome(capsResource.getIndRsrcNonDfcs());
    rowcfad07sog04.setSzTxtNdfcsCertEntity(capsResource.getNdfcsCertEntity());
    rowcfad07sog04.setDNbrRshsAnnualIncome(capsResource.getNbrRsrcAnnualIncome());
    // retrieving new SHINES related fields
    rowcfad07sog04.setCIndPrevFamilyStudyReq( capsResource.getIndPrevFamStdyRqstd() );
    rowcfad07sog04.setSzCdAdExchangeStatus( capsResource.getCdExchangeStat() );
    rowcfad07sog04.setCIndWaiver( capsResource.getIndWaiver() );
    rowcfad07sog04.setSzCdSchoolDistrict( capsResource.getCdSchDist() );
    rowcfad07sog04.setSzCdElementary( capsResource.getCdElem() );
    rowcfad07sog04.setSzCdMiddle( capsResource.getCdMiddle() );
    rowcfad07sog04.setSzCdHigh( capsResource.getCdHigh() );
    rowcfad07sog04.setSzNmLegal( capsResource.getNmLegal());

    // Group 5 population
    rowcfad07sog05.setUNbrRsrcIntFeAgeMax(
            capsResource.getNbrRsrcIntFeAgeMax() != null ? capsResource.getNbrRsrcIntFeAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcIntFeAgeMin(
            capsResource.getNbrRsrcIntFeAgeMin() != null ? capsResource.getNbrRsrcIntFeAgeMin() : 0);
    rowcfad07sog05.setUNbrRsrcIntMaAgeMax(
            capsResource.getNbrRsrcIntMaAgeMax() != null ? capsResource.getNbrRsrcIntMaAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcIntMaAgeMin(
            capsResource.getNbrRsrcIntMaAgeMin() != null ? capsResource.getNbrRsrcIntMaAgeMin() : 0);
    rowcfad07sog05.setCIndRsrcEmergPlace(capsResource.getIndRsrcEmergPlace());
    rowcfad07sog05.setCIndRsrcTransport(capsResource.getIndRsrcTransport());
    rowcfad07sog05.setCIndSpecificChild(capsResource.getIndSpecificChild());
    rowcfad07sog05.setUNbrRsrcFMAgeMax(
            capsResource.getNbrRsrcFmAgeMax() != null ? capsResource.getNbrRsrcFmAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcFMAgeMin(
            capsResource.getNbrRsrcFmAgeMin() != null ? capsResource.getNbrRsrcFmAgeMin() : 0);
    rowcfad07sog05.setUNbrRsrcMlAgeMax(
            capsResource.getNbrRsrcMaAgeMax() != null ? capsResource.getNbrRsrcMaAgeMax() : 0);
    rowcfad07sog05.setUNbrRsrcMlAgeMin(
            capsResource.getNbrRsrcMaAgeMin() != null ? capsResource.getNbrRsrcMaAgeMin() : 0);
    rowcfad07sog05.setSzTxtRsrcComments(capsResource.getTxtRsrcComments());
    rowcfad07sog05.setTxtHmPrgInterest(capsResource.getTxtHmPrgInterest());

    // Retrieve Event Record
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(capsResource.getEvent().getIdEvent());
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    rowcfad07sog06.setSzCdEventStatus(event.getCdEventStatus());
    rowcfad07sog06.setSzCdEventType(event.getCdEventType());
    rowcfad07sog06.setSzTxtEventDescr(event.getTxtEventDescr());
    rowcfad07sog06.setSzCdTask(event.getCdTask());
    rowcfad07sog06.setTsLastUpdate(event.getDtLastUpdate());
    rowcfad07sog06.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowcfad07sog06.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowcfad07sog06.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowcfad07sog06.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    // Add the row objects to the output.
    cfad07so.setROWCFAD07SOG04(rowcfad07sog04);
    cfad07so.setROWCFAD07SOG05(rowcfad07sog05);
    cfad07so.setROWCFAD07SOG06(rowcfad07sog06);
    return cfad07so;
  }


  private ROWCFAD07SOG00_ARRAY retrieveResourcePhone(int idResource) {
    ROWCFAD07SOG00_ARRAY rowcfad07spg00_array = new ROWCFAD07SOG00_ARRAY();
    // cres14d
    List<ResourcePhone> resourcePhones = resourcePhoneDAO.findResourcePhoneByIdResource(idResource);
    if (resourcePhones != null && !resourcePhones.isEmpty()) {
      for (Iterator<ResourcePhone> it = resourcePhones.iterator(); it.hasNext();) {
        ResourcePhone resourcePhone = it.next();
        // Set fields in CFAD07SOG00 to fields in ResourcePhone
        ROWCFAD07SOG00 rowcfad07sog00 = new ROWCFAD07SOG00();
        rowcfad07sog00.setSzCdFacilPhoneType(resourcePhone.getCdRsrcPhoneType());
        rowcfad07sog00.setLNbrFacilPhoneNumber(resourcePhone.getNbrRsrcPhone());
        rowcfad07sog00.setLNbrFacilPhoneExtension(resourcePhone.getNbrRsrcPhoneExt());
        rowcfad07sog00.setSzTxtRsrcPhoneComments(resourcePhone.getTxtRsrcPhoneComments());
        rowcfad07sog00.setTsLastUpdate(resourcePhone.getDtLastUpdate());
        rowcfad07sog00.setUlIdRsrcPhone(resourcePhone.getIdRsrcPhone() != null ? resourcePhone.getIdRsrcPhone() : 0);
        rowcfad07spg00_array.addROWCFAD07SOG00(rowcfad07sog00);
      }
    }
    return rowcfad07spg00_array;
  }

  /**
   * Note that {@code cfad07so} is included be included as a paramter ONLY to allow szTxtSchDistName to be updated by
   * the results of cres08d.
   *
   * @param idResource
   * @param cfad07so   Maintainers of this method should not update anything except szTxtSchDistName in {@code
   *                   cfad07so}.
   * @return
   * @throws ServiceException
   */
  private ROWCFAD07SOG01_ARRAY retrieveResourceAddress(int idResource, CFAD07SO cfad07so) throws ServiceException {
    ROWCFAD07SOG01_ARRAY rowcfad07spg01_array = new ROWCFAD07SOG01_ARRAY();
    // cres13d
    //Removed reference to school district from the resource address table
    List<ResourceAddress> resourceAddresses = resourceAddressDAO.findResourceAddressByIdResource(idResource);
    if (resourceAddresses != null && !resourceAddresses.isEmpty()) {
      for (Iterator<ResourceAddress> it = resourceAddresses.iterator(); it.hasNext();) {
        ResourceAddress resourceAddress = it.next();
        // Set fields in CFAD07SOG01 to fields in ResourceAddress
        ROWCFAD07SOG01 rowcfad07sog01 = new ROWCFAD07SOG01();
        rowcfad07sog01.setSzAddrRsrcAddrAttn(resourceAddress.getAddrRsrcAddrAttn());
        rowcfad07sog01.setSzAddrRsrcAddrCity(resourceAddress.getAddrRsrcAddrCity());
        rowcfad07sog01.setSzAddrRsrcAddrStLn1(resourceAddress.getAddrRsrcAddrStLn1());
        rowcfad07sog01.setSzAddrRsrcAddrStLn2(resourceAddress.getAddrRsrcAddrStLn2());
        rowcfad07sog01.setSzAddrRsrcAddrZip(resourceAddress.getAddrRsrcAddrZip());
        rowcfad07sog01.setSzCdFacilityCounty(resourceAddress.getCdRsrcAddrCounty());
        rowcfad07sog01.setSzCdFacilityState(resourceAddress.getCdRsrcAddrState());
        rowcfad07sog01.setSzCdRsrcAddrType(resourceAddress.getCdRsrcAddrType());
        rowcfad07sog01.setSzNbrRsrcAddrVid(resourceAddress.getNbrRsrcAddrVid());
        rowcfad07sog01.setSzTxtRsrcAddrComments(resourceAddress.getTxtRsrcAddrComments());
        rowcfad07sog01.setTsLastUpdate(resourceAddress.getDtLastUpdate());
        rowcfad07sog01.setUlIdRsrcAddress(
                resourceAddress.getIdRsrcAddress() != null ? resourceAddress.getIdRsrcAddress() : 0);
        rowcfad07spg01_array.addROWCFAD07SOG01(rowcfad07sog01);

      }
    }
    return rowcfad07spg01_array;
  }

  private ROWCFAD07SOG03_ARRAY retrieveHomeInterestEthnicities(int idResource) {
    ROWCFAD07SOG03_ARRAY rowcfad07spg03_array = new ROWCFAD07SOG03_ARRAY();
    // clss04d
    List<HomeEthnicity> homeEthnicityList = homeEthnicityDAO.findHomeEthnicitiesByResourceId(idResource);
    if (homeEthnicityList != null && !homeEthnicityList.isEmpty()) {
      for (Iterator<HomeEthnicity> it = homeEthnicityList.iterator(); it.hasNext();) {
        HomeEthnicity homeEthnicity = it.next();
        // Set fields in CFAD07SOG03 to fields in HomeEthnicity
        ROWCFAD07SOG03 rowcfad07sog03 = new ROWCFAD07SOG03();
        rowcfad07sog03.setSzCdFaHomeIntEthnicity(homeEthnicity.getId().getCdEthnicity());
        rowcfad07sog03.setTsLastUpdate(homeEthnicity.getDtLastUpdate());
        rowcfad07sog03.setDtScrDtFaHomeEthnicAdd(DateHelper.toCastorDate(homeEthnicity.getDtLastUpdate()));
        rowcfad07spg03_array.addROWCFAD07SOG03(rowcfad07sog03);
      }
    }
    return rowcfad07spg03_array;
  }
  private HomeRaceSO_ARRAY retrieveHomeInterestRaces(int idResource) {
	    HomeRaceSO_ARRAY home_race_array = new HomeRaceSO_ARRAY();
	    
	    List<HomeRace> homeRaceList = homeRaceDAO.findHomeRacesByResourceId(idResource);
	    if (homeRaceList != null && !homeRaceList.isEmpty()) {
	      for (Iterator<HomeRace> it = homeRaceList.iterator(); it.hasNext();) {
	        HomeRace homeRace = it.next();
	        // Set fields in CFAD07SOG03 to fields in HomeRace
	        HomeRaceSO home_Race = new HomeRaceSO();
	        home_Race.setSzCdFaHomeIntRace(homeRace.getId().getCdRace());
	        home_Race.setTsLastUpdate(homeRace.getDtLastUpdate());
	        home_Race.setDtScrDtFaHomeDtRaceAdd(DateHelper.toCastorDate(homeRace.getDtLastUpdate()));
	        home_race_array.addHomeRaceSO(home_Race);
	      }
	    }
	    return home_race_array;
  }

  private ROWCFAD07SOG02_ARRAY retrieveResourceCharacteristics(int idResource) {
    ROWCFAD07SOG02_ARRAY rowcfad07spg02_array = new ROWCFAD07SOG02_ARRAY();
    // clss48d -- Ignores SQL_NOT_FOUND.
    List<Map> resourceChrctrs = resourceChrctrDAO.findResourceChrctrByIdResource(idResource);
    if (resourceChrctrs != null && !resourceChrctrs.isEmpty()) {
      for (Iterator<Map> it = resourceChrctrs.iterator(); it.hasNext();) {
        Map resourceChrctr = it.next();
        // Set fields in CFAD07SOG02 to fields in ResourceChrctr
        ROWCFAD07SOG02 rowcfad07sog02 = new ROWCFAD07SOG02();
        rowcfad07sog02.setSzCdRsrcCharChrctr((String) resourceChrctr.get("cdRsrcCharChrctr"));
        rowcfad07sog02.setDtDtRsrcCharDateAdded(DateHelper.toCastorDate((Date) resourceChrctr.get(
                "dtRsrcCharDtAdded")));
        rowcfad07spg02_array.addROWCFAD07SOG02(rowcfad07sog02);
      }
    }
    return rowcfad07spg02_array;
  }
  
  private ROWCFAD07SOG07_ARRAY retrievePrgrmsOfInterest( int idHomeApplicant ){
    ROWCFAD07SOG07_ARRAY rowcfad07sog07_array = new ROWCFAD07SOG07_ARRAY();
    String type = CodesTables.CPRGMINT;
    //get save programs of interest
    List<HomeApplicantCbx> listPrgmsOfInterest = homeApplicantCbxDAO.findHomeApplicantCbxByIdHomeApplicantCbxType( idHomeApplicant, type );
    if( listPrgmsOfInterest != null && !listPrgmsOfInterest.isEmpty() ){
      for( Iterator<HomeApplicantCbx> iter = listPrgmsOfInterest.iterator(); iter.hasNext();){
        HomeApplicantCbx cbx = iter.next();
        //set fields
        ROWCFAD07SOG07 rowcfad07sog07 = new ROWCFAD07SOG07();
        rowcfad07sog07.setSzCdHmApplcntCbx( cbx.getCdHomeApplicantCbx() );
        rowcfad07sog07.setTsLastUpdate( cbx.getDtLastUpdate() );
        rowcfad07sog07_array.addROWCFAD07SOG07( rowcfad07sog07 );
      }
    }
    return rowcfad07sog07_array;
  }
}
