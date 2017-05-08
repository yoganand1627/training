package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   03/27/2008  Corey Harden       STGAP00006457: Set SNbrRsrcOpenSlots in cfad37so object with info
 *                                 from capsResource record and retrieved capacity and openSlots from
 *                                 cfad37so object to calculate placement
 *   05/19/2008  Corey Harden      STGAP00006457: Pulled placments from the placement table to calculate
 *                                 the number of placements a resource has and save into CFAD37SO
 *   8/12/2008   cjgerry           STGAP00007160 - Added code FA (decode Foster Parent (CCI/CPA)) to the check of foster
 *                                 parent principals in the home.   
 *   08/13/08    charden           STGAP00006989: Wrote code to check homeStudNarr table for conversion documents if
 *                                 user is attempting to reopen a closed home. If the conversion document exists, it will
 *                                 be deleted.
 *   12/19/08    hjbaptiste        STGAP00006457: Removed the status field when retrieving actual placements in order to
 *                                 retrieve all placements and not just approved ones to keep the number of open slots correct
 *                                 since saving the HomeInformation page updates the open slots                           
 *   06/17/2009  hjbaptiste        STGAP00014257: Modified retrieveForModification() sot that when counting the number of placements 
 *                                 for the home, do not increment the counter if the child placed in the home has a Legal Status 
 *                                 of Adoption Finalized                               
 *   02/28/2011  hnguyen           SMS#97850: MR-075 Modified retrieveForModification() to retrieve current IVE Reimbursable status
 *   03/21/2011  hnguyen           SMS#97850: MR-075 Modified retrieveForInquiry() to correctly retrieve idResource and IVE Reimbursable status
 *   03/22/2011  hjbaptiste        SMS#97850: MR-75 Foster Home Batch To Dos. Fixed an NPE (Null Pointer Exception)
 *                                 event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0.
 *                                 whenever the Person object was returned null. Removed the (.getIdPerson()) in the 
 *                                 test for null. Did the same for event.getStage().getIdStage()
 *   03/26/2011  hnguyen           SMS#97850: MR-75 Added hold placement and updated name change for SO element.
 **/

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeStudNarrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveHomeLicense;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class RetrieveHomeLicenseImpl extends BaseServiceImpl implements RetrieveHomeLicense {
  static final String HOME_STUDY_VIEW = "HOME_STUD_NARR_VIEW";
  
  public static final String CODE_STATUS_CLOSED = CodesTables.CFAHMSTA_CSD;
  
  public static final String APP = "APP";

  public static final String INQ = "INQ";

  public static final Integer FOURTEEN = 14;

  private CapsResourceDAO capsResourceDAO = null;
  private EventDAO eventDAO = null;
  private HomeStudNarrDAO homeStudNarrDAO = null;
  private PlacementDAO placementDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private ResourceAddressDAO resourceAddressDAO = null;
  private ResourceHistoryDAO resourceHistoryDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private StageDAO stageDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setHomeStudNarrDAO(HomeStudNarrDAO homeStudNarrDAO) {
    this.homeStudNarrDAO = homeStudNarrDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  
  public CFAD37SO retrieveHomeLicenseInformation(CFAD37SI cfad37si) throws ServiceException {
    ArchInputStruct archInputStruct = cfad37si.getArchInputStruct();
    int idStage = cfad37si.getUlIdStage();
    CFAD37SO cfad37so = null;
    if (LIC_MODIFY.equals(archInputStruct.getCReqFuncCd())) {
      cfad37so = retrieveForModification(idStage);
    } else if (LIC_HISTORY.equals(archInputStruct.getCReqFuncCd())) {
      cfad37so = retrieveForInquire(cfad37si.getUlIdEvent());
    } else {
      cfad37so = new CFAD37SO();
    }
    
   //STGAP00006989 - get idDocumentTemplate from HomeStudNarr table and call CheckForConvertedTemplate() method to delete
    //converted document from table if home is being reopened
    Integer idDocTemp = homeStudNarrDAO.retrieveHomeStudNarr(idStage);
    
    String homeStat = cfad37so.getSzCdRsrcFaHomeStatus();

    if (!CODE_STATUS_CLOSED.equals(homeStat)) {
      CheckForConvertedTemplate(homeStat, idDocTemp, idStage);
    } 

    // Note that this is not fully implemented; only the dtLastUpdate is retreived,  not the associated narrative blob.
    //   This is ok for non-forms services because they do not deal with the blob
    // csys06d
    Date dtLastUpdate = commonDAO.findDtLastUpdate(HOME_STUDY_VIEW, idStage);
    if (dtLastUpdate == null) {
      cfad37so.setBIndBLOBExistsInDatabase(ArchitectureConstants.N);
    }else
      cfad37so.setBIndBLOBExistsInDatabase(ArchitectureConstants.Y);
    
    String bPrincipalsAP = ArchitectureConstants.N;
    String bPrincipalsAPMale = ArchitectureConstants.N;
    String bPrincipalsMale = ArchitectureConstants.N;
    String bPrincipalsAPFemale = ArchitectureConstants.N;
    String bPrincipalsFemale = ArchitectureConstants.N;
    String bPrincipalsFP = ArchitectureConstants.N;
    String bPrincipalsFPFemale = ArchitectureConstants.N;
    String bPrincipalsFPMale = ArchitectureConstants.N;
    String bPrincipalsAF = ArchitectureConstants.N;
    // This DAO will retrieve a list of principals in the home and data about these people using Id Stage from input.
    // clsc18d
    List<StagePersonLink> links = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(idStage, CodesTables.CPRSNALL_PRN);
    // Loop list of principals and set boolean indicators
    for (Iterator<StagePersonLink> it = links.iterator(); it.hasNext();) {
      StagePersonLink link = it.next();
      if (CodesTables.CRPTRINT_PT.equals(link.getCdStagePersRelInt())) {
        bPrincipalsAP = ArchitectureConstants.Y;
        // Check the gender of the adoptive parent principals
        if (CodesTables.CSEX_M.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsAPMale = ArchitectureConstants.Y;
          bPrincipalsMale = ArchitectureConstants.Y;
        } else if (CodesTables.CSEX_F.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsAPFemale = ArchitectureConstants.Y;
          bPrincipalsFemale = ArchitectureConstants.Y;
        }
      } else if (CodesTables.CRPTRINT_FP.equals(link.getCdStagePersRelInt())||
                 CodesTables.CRPTRINT_FA.equals(link.getCdStagePersRelInt())) {
        bPrincipalsFP = ArchitectureConstants.Y;
        // Check the gender of the foster parent principals
        if (CodesTables.CSEX_M.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsFPMale = ArchitectureConstants.Y;
          bPrincipalsMale = ArchitectureConstants.Y;
        } else if (CodesTables.CSEX_F.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsFPFemale = ArchitectureConstants.Y;
          bPrincipalsFemale = ArchitectureConstants.Y;
        }
      } else if (CodesTables.CRPTRINT_AF.equals(link.getCdStagePersRelInt())) {
        bPrincipalsAF = ArchitectureConstants.Y;
        // Check the gender of the adoptive/foster parent principals
        if (CodesTables.CSEX_M.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsMale = ArchitectureConstants.Y;
        } else if (CodesTables.CSEX_F.equals(link.getPerson().getCdPersonSex())) {
          bPrincipalsFemale = ArchitectureConstants.Y;
        }
      }
    }
    // set these booleans in the output message to be used in the custom 
    // validation file when saving.
    cfad37so.setBIndFosterParent(bPrincipalsFP);
    cfad37so.setBIndAdoptiveParent(bPrincipalsAP);
    cfad37so.setBIndFostAdoptParent(bPrincipalsAF);
    if (StringHelper.isTrue(bPrincipalsFPMale) && StringHelper.isTrue(bPrincipalsFPFemale)) {
      cfad37so.setBIndMarriedFP(ArchitectureConstants.Y);
    }
    if (StringHelper.isTrue(bPrincipalsAPMale) && StringHelper.isTrue(bPrincipalsAPFemale)) {
      cfad37so.setBIndMarriedAP(ArchitectureConstants.Y);
    }
    if (StringHelper.isTrue(bPrincipalsMale) && StringHelper.isTrue(bPrincipalsFemale)) {
      cfad37so.setBIndMarriedAorF(ArchitectureConstants.Y);
    }
    return cfad37so;
  }

  private CFAD37SO retrieveForModification(int idStage) throws ServiceException {
    // Retrieve CAPS RESOURCE row for a given Id Stage if LIC_MODIFY
    CFAD37SO cfad37so = new CFAD37SO();
    // cses41d
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    if (capsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cfad37so.setSzCdRsrcMaritalStatus(capsResource.getCdRsrcMaritalStatus());
    cfad37so.setSzCdRsrcCategory(capsResource.getCdRsrcCategory());
    cfad37so.setSzCdRsrcFaHomeStatus(capsResource.getCdRsrcFaHomeStatus());
    cfad37so.setSzCdRsrcStatus(capsResource.getCdRsrcStatus());
    cfad37so.setTsLastUpdate(capsResource.getDtLastUpdate());
    cfad37so.setDtDtRsrcMarriage(DateHelper.toCastorDate(capsResource.getDtRsrcMarriage()));
    cfad37so.setSzTxtNdfcsCertEntity(capsResource.getNdfcsCertEntity());
    cfad37so.setSzCdAdExchangeStat(capsResource.getCdExchangeStat());
    cfad37so.setBIndWaiver(capsResource.getIndWaiver());
    Integer idResource = capsResource.getIdResource();
    cfad37so.setUlIdResource(idResource != null ? idResource : 0);
    cfad37so.setBIndRsrcNonPrs(capsResource.getIndRsrcNonDfcs());
    cfad37so.setSzTxtNdfcsCertEntity(capsResource.getNdfcsCertEntity());    
    cfad37so.setUNbrRsrcMlAgeMin(capsResource.getNbrRsrcMaAgeMin() != null ? capsResource.getNbrRsrcMaAgeMin() : 0);
    cfad37so.setUNbrRsrcFMAgeMax(capsResource.getNbrRsrcFmAgeMax() != null ? capsResource.getNbrRsrcFmAgeMax() : 0);
    cfad37so.setUNbrRsrcFMAgeMin(capsResource.getNbrRsrcFmAgeMin() != null ? capsResource.getNbrRsrcFmAgeMin() : 0);

    cfad37so.setUNbrRsrcMlAgeMax(capsResource.getNbrRsrcMaAgeMax() != null ? capsResource.getNbrRsrcMaAgeMax() : 0);
    cfad37so.setUNbrRsrcFacilCapacity(
            capsResource.getNbrRsrcFacilCapacity() != null ? capsResource.getNbrRsrcFacilCapacity() : 0);
    cfad37so.setSNbrRsrcOpenSlots(capsResource.getNbrRsrcOpenSlots() != null ? capsResource.getNbrRsrcOpenSlots() : 0);
    cfad37so.setUNbrRsrcIntMaAgeMin(
            capsResource.getNbrRsrcIntMaAgeMin() != null ? capsResource.getNbrRsrcIntMaAgeMin() : 0);
    cfad37so.setUNbrRsrcIntMaAgeMax(
            capsResource.getNbrRsrcIntMaAgeMax() != null ? capsResource.getNbrRsrcIntMaAgeMax() : 0);
    cfad37so.setUNbrRsrcIntFeAgeMin(
            capsResource.getNbrRsrcIntFeAgeMin() != null ? capsResource.getNbrRsrcIntFeAgeMin() : 0);
    cfad37so.setUNbrRsrcIntFeAgeMax(
            capsResource.getNbrRsrcIntFeAgeMax() != null ? capsResource.getNbrRsrcIntFeAgeMax() : 0);
    cfad37so.setSzCdRsrcCnty(capsResource.getCdRsrcCnty());
    // Populate all Rsrc Fa Home Types
    //TODO change all these to seperate values since they are no longer 1 char code but
    //3 char codes
    String cdRsrcFaHomeType1 = StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType1() )+
                               StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType2() )+
                               StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType3() )+
                               StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType4() )+
                               StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType5() )+
                               StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType6() );
    cfad37so.setCCdRsrcFaHomeType1_CFAD37SO(cdRsrcFaHomeType1);
    //TODO replacing above code with the code below because of the change in the 
    //length of home types used in SHINES
    cfad37so.setCCdRsrcFaHomeType1( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType1() ) );
    cfad37so.setCCdRsrcFaHomeType2( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType2() ) );
    cfad37so.setCCdRsrcFaHomeType3( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType3() ) );
    cfad37so.setCCdRsrcFaHomeType4( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType4() ) );
    cfad37so.setCCdRsrcFaHomeType5( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType5() ) );
    cfad37so.setCCdRsrcFaHomeType6( StringHelper.getNonNullString( capsResource.getCdRsrcFaHomeType6() ) );

    //get approval period informaiton
    cfad37so.setDtDtApprvlBegin( capsResource.getDtLicBegin() );
    cfad37so.setDtDtApprvlEnd( capsResource.getDtLicEnd());
    
    //get home study information
    cfad37so.setDtFosterParentManual(capsResource.getDtFostManual());
    cfad37so.setDtFosterParentBill(capsResource.getDtFostBill());
    
    // Get Event associated with current CAPS_RESOURCE record
    // ccmn45d
    cfad37so.setROWCCMN01UIG00(retrieveEvent(capsResource.getEvent().getIdEvent()));
    // cmsc39d
    int openSlots = cfad37so.getSNbrRsrcOpenSlots();
    int capacity = cfad37so.getUNbrRsrcFacilCapacity();
    //int placement = capacity - openSlots;
    List<Map> placements = placementDAO.findAprvPlacementsByCapsResourceByIdRsrcFacil(new Date(), idResource);
    int placementCounter = 0;
    cfad37so.setUlSysNbrGenericCntr(placementCounter);
    if (placements != null && !placements.isEmpty()) {
      for (Iterator<Map> it = placements.iterator(); it.hasNext();) {
        Map placement = it.next();
        // If placements are returned by the DAO, then we need to call CLSS64D in order
        // to determine if the child placed has the most recent legal status of Adoption Finalized.
        // If so, then the placement should not get counted. If the placement is not of this type, then count it automatically.
        if (CodesTables.CPLMNTYP_ADH.equals(placement.get("cdPlcmtType"))) {
          Event placementEvent = eventDAO.findEventByIdEvent((Integer) placement.get("idPlcmtEvent"));
          String cdStage = stageDAO.findCdStageByIdStage(placementEvent.getStage().getIdStage());
          if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
            // Is Placement Adoption Finalized
            int idPlcmtChild = (Integer) placement.get("personByIdPlcmtChild");
            LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idPlcmtChild, CodesTables.CLEGSTAT_NAF);
            // If the Adoption Finalized legal status record was not found, then the placement needs to count. Do increment the Counter
            if (legalStatus == null) {
              placementCounter++;
            }
          }
        } else {
          // This placement is not an Adoptive Placement and it needs to count. Do increment the Counter
          placementCounter++;
        }
      }
    }
    cfad37so.setUlSysNbrGenericCntr(placementCounter);

    // Retreive resource address row(s) cres13d
    //      CRES13D
    List<ResourceAddress> resourceAddresses = resourceAddressDAO.findResourceAddressByIdResource(idResource);
    if (resourceAddresses == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Check VID.  If business address, then populate output message with NbrRsrcVid
    // to determine whether user can save and submit on Home License window.
    // If NbrRsrcVid is NULL, user cannot Save and Submit
    for (Iterator<ResourceAddress> it = resourceAddresses.iterator(); it.hasNext();) {
      ResourceAddress resourceAddress = it.next();
      if (CodesTables.CRSCADDR_02.equals(resourceAddress.getCdRsrcAddrType()) &&
          StringHelper.isValid(resourceAddress.getNbrRsrcAddrVid())) {
        cfad37so.setSzNbrRsrcVid(resourceAddress.getNbrRsrcAddrVid());
        break;
      }
    }
    
    // SMS#97850: MR-075 set resource current IVE Reimbursable status indicator and Hold Placement Indicator
    cfad37so.setBIndHomeIveReimbursable(resourceHistoryDAO.findResourceCurrentIveReimbursableStatus(idResource != null ? idResource : 0));
    cfad37so.setBIndHoldPlacements(capsResource.getIndHoldPlacements());

    return cfad37so;
  }

  private CFAD37SO retrieveForInquire(int idEvent) throws ServiceException {
    CFAD37SO cfad37so = new CFAD37SO();
    // CSES02D
    ResourceHistory resourceHistory = resourceHistoryDAO.findResourceHistoryByIdEvent(idEvent);
    if (resourceHistory == null) {
      throw new ServiceException(Messages.MSG_FAD_HISTORY_DELETED);
    }
    cfad37so.setSzCdRsrcMaritalStatus(resourceHistory.getCdRshsMaritalStatus());
    cfad37so.setSzCdRsrcCategory(resourceHistory.getCdRshsCategory());
    cfad37so.setSzCdRsrcFaHomeStatus(resourceHistory.getCdRshsFaHomeStatus());
    cfad37so.setSzCdRsrcStatus(resourceHistory.getCdRshsStatus());
    cfad37so.setTsLastUpdate(resourceHistory.getDtLastUpdate());
    cfad37so.setDtDtRsrcMarriage(DateHelper.toCastorDate(resourceHistory.getDtRshsMarriage()));
    cfad37so.setUlIdResource(
            resourceHistory.getCapsResource() != null ? resourceHistory.getCapsResource().getIdResource() : 0);
    cfad37so.setBIndRsrcNonPrs(resourceHistory.getIndRsrcNondfcs());
    cfad37so.setSzTxtNdfcsCertEntity(resourceHistory.getNdfcsCertEntity());
    //get approval period informaiton
    cfad37so.setDtDtApprvlBegin( resourceHistory.getDtLicBegin() );
    cfad37so.setDtDtApprvlEnd( resourceHistory.getDtLicEnd());
    cfad37so.setUNbrRsrcMlAgeMin(
            resourceHistory.getNbrRshsMaAgeMin() != null ? resourceHistory.getNbrRshsMaAgeMin() : 0);
    cfad37so.setUNbrRsrcFMAgeMax(
            resourceHistory.getNbrRshsFmAgeMax() != null ? resourceHistory.getNbrRshsFmAgeMax() : 0);
    cfad37so.setUNbrRsrcFMAgeMin(
            resourceHistory.getNbrRshsFmAgeMin() != null ? resourceHistory.getNbrRshsFmAgeMin() : 0);
    cfad37so.setUNbrRsrcMlAgeMax(
            resourceHistory.getNbrRshsMaAgeMax() != null ? resourceHistory.getNbrRshsMaAgeMax() : 0);
    cfad37so.setUNbrRsrcFacilCapacity(
            resourceHistory.getNbrRshsFacilCapacity() != null ? resourceHistory.getNbrRshsFacilCapacity() : 0);
    cfad37so.setUNbrRsrcIntMaAgeMin(
            resourceHistory.getNbrRshsIntMaAgeMin() != null ? resourceHistory.getNbrRshsIntMaAgeMin() : 0);
    cfad37so.setUNbrRsrcIntMaAgeMax(
            resourceHistory.getNbrRshsIntMaAgeMax() != null ? resourceHistory.getNbrRshsIntMaAgeMax() : 0);
    cfad37so.setUNbrRsrcIntFeAgeMin(
            resourceHistory.getNbrRshsIntFeAgeMin() != null ? resourceHistory.getNbrRshsIntFeAgeMin() : 0);
    cfad37so.setUNbrRsrcIntFeAgeMax(
            resourceHistory.getNbrRshsIntFeAgeMax() != null ? resourceHistory.getNbrRshsIntFeAgeMax() : 0);
    // Populate all Rsrc Fa Home Types
    String cdRshsFaHomeType1 = StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType1()) +
                               StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType2()) +
                               StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType3()) +
                               StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType4()) +
                               StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType5()) +
                               StringHelper.getNonNullString(resourceHistory.getCdRshsFaHomeType6());
    cfad37so.setCCdRsrcFaHomeType1_CFAD37SO(cdRshsFaHomeType1);
    
    // SMS#97850: MR-075 set resource history IVE Reimbursable status at time of event and Hold Placement Indicator
    cfad37so.setBIndHoldPlacements(resourceHistory.getIndHoldPlacements());
    cfad37so.setBIndHomeIveReimbursable(
            resourceHistoryDAO.findResourceIveReimbursableStatusByDate(
                               (resourceHistory.getCapsResource() != null ? resourceHistory.getCapsResource().getIdResource() : 0),
                               (resourceHistory.getDtRshsEffective() != null ? resourceHistory.getDtRshsEffective() : new Date())));

    return cfad37so;
  }
  
  private void CheckForConvertedTemplate(String homeStat, Integer idDocTemp, int idStage) {
    if (homeStat != null || !"".equals(homeStat)) {
      if ((APP.equals(homeStat) || INQ.equals(homeStat)) && FOURTEEN.equals(idDocTemp)) {
        int count = homeStudNarrDAO.deleteHomeStudNarr(idStage);
        if (count == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    }
  }

  private ROWCCMN01UIG00 retrieveEvent(int idEvent) throws ServiceException {
    // ccmn45d
    // Get Event associated with current CAPS_RESOURCE record
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn01uig00.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    return rowccmn01uig00;
  }
}
