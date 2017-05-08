package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveExchangeHomeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * This is the Service contains the methods to retrieve ExchangeHome records from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  08/20/08   mchillman   STGAP00010004: Initial code 
 *  11/09/08   mchillman   STGAP00010624: Changed population of days out  
 *  02/15/09   vdevarak    STGAP00012476: Modified code to populate the date applied field with the date applied
 *                         from the Foster Home Conversion record if such record exists, else populate it from Home
 *                         Applicant Info record.
 *  03/02/09   mxpatel     STGAP00012533: Modified code to retrieve and populate Permission to file date and Documents sent date. 
 *  04/20/09   mxpatel     STGAP00013144: if placement was ended with reason of "adoption disrupted", earliest placement
                           end date (only consider placements with above reason code) should be displayed as the Disruption date even if
                           there is not legal status present on the ADO stage            
 *  05/21/09   mchillman   STGAP00012438: added code to check if foster home has an approved active FH Conversion record   
 *  07/24/09   mxpatel     STGAP00014202: added code so that "Date Inquired" for Foster Homes with an approved FH Conversion 
 *                         is from the Foster Parent Notified Agency of Decision to Adopt field on the most recent Adoption Information 
 *                         page where the Decision Outcome is 'Yes'      
 *  08/27/09   cwells      STGAP00014529: When accessing the Exchange Home Detail page the Date Last Update field found on the 
 *                         page will be updated by the date the Home Re-evaluation is approved.                    
 *  10/15/09   mxpatel     STGAP00015546: Added code to update dt_last_update field and also removed old code that was incorrectly displaying date last update
 *                         on the exchange home page. 
 *  10/29/09   mxpatel     37436: modified code to put CLNCHAR2 as input values in order to populate Background Factors.      
 *  11/24/09   mchillman   SMS41085: modified code to remove spurious condition on foster home conversion check  .    
 *  12/14/09   arege       SMS#37206 Closed With Placement section should populate if the Non Availability Reason Code of the family is saved to one the 
 *                         codes out of Regular Placement, Foster Parent Placement, Foster/Adopt Placement, In Relative Placement, In Rel. Fstr-Prnt Plcmnt  
 *  12/15/09   mxpatel     SMS# 40849: modified the method populateLinkedChildren to include orderBy information (column name and direction). Also set the retrieved values
 *                         in the ExchangeHomeChildrenSO object.          
 *  12/18/09   arege       Modified the code as per code review and modified findExchangeChildFamLinksIdPersonByResourceEventId() so that it finds linked children for given eventid and 
 *                         IND_LINK_CURRENT column set to Y, i.e this will give list of children in the Family is Now Considering section.
 *                                
 * </pre>
 */

public class RetrieveExchangeHomeDetailImpl extends BaseServiceImpl implements RetrieveExchangeHomeDetail {
  
  private ApproversDAO approversDAO = null;
  private CapsResourceDAO capsResourceDAO = null;
  private ExchangeHomeDAO exchangeHomeDAO = null;
  private EventDAO eventDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonPhoneDAO personPhoneDAO = null;
  private HomeRaceDAO homeRaceDAO = null;
  private HomeEthnicityDAO homeEthnicityDAO = null;
  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;
  private DynamicExchangeChildFamLinkDAO dynamicExchangeChildFamLinkDAO = null;
  private ExchangeChildDAO exchangeChildDAO = null;
  private PersonDAO personDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private HomeApplicantInfoDAO homeApplicantInfoDAO = null;
  private ResourceChrctrDAO resourceChrctrDAO = null;
  private PlacementDAO placementDAO = null;
  private FosterHomeConvDAO fosterHomeConvDAO = null;
  private ResourceHistoryDAO resourceHistoryDAO = null;
  
  private AdoInfoDAO adoInfoDAO = null; // mxpatel 12533
  
  public ExchangeHomeDetailSO retrieveExchangeHomeDetail(ExchangeHomeDetailSI exchangeHomeDetail) {
    ExchangeHomeDetailSO exchangeHomeDetailSO = new ExchangeHomeDetailSO();
    int idEvent = exchangeHomeDetail.getEvent().getUlIdEvent();
    
    //get any event info
    exchangeHomeDetailSO.setEvent(populateEventInfo(idEvent));
    
    //get any exchange home info
    exchangeHomeDetailSO = populateExchangeHomeInfo(idEvent, exchangeHomeDetailSO);
    
    //get any caps resource info
    exchangeHomeDetailSO = populateResourceInformation(exchangeHomeDetail.getIdCase(), exchangeHomeDetail.getEvent().getUlIdStage(), exchangeHomeDetail.isPrefill(), exchangeHomeDetailSO);
    
    //get the case worker info
    exchangeHomeDetailSO.setCaseWorkerName(populateCaseWorkerInfo(exchangeHomeDetail.getEvent().getUlIdStage()));
    
    //get the family demo info
    exchangeHomeDetailSO = populateFamilyDemoInfo(exchangeHomeDetail.getEvent().getUlIdStage(), exchangeHomeDetailSO);
       
    //get the home information
    exchangeHomeDetailSO = populateHomeInfo(exchangeHomeDetailSO);
    
    //get the home children race preferences info
    exchangeHomeDetailSO.setChildRacePref(populateChildRacePreferences(exchangeHomeDetailSO.getIdResource()));
    
    //get the home children ethnicities preferences info
    exchangeHomeDetailSO.setChildEthnicityPerf(populateChildEthnicitiesPreferences(exchangeHomeDetailSO.getIdResource()));
    
    if(exchangeHomeDetail.isPrefill() == true) {
      
      //prepopulate some fields with from Home Info page
      exchangeHomeDetailSO = prepopulateHomeInfo(exchangeHomeDetailSO);
    
      
   
    } else {
                  
      //get the linked children
      exchangeHomeDetailSO.setChildrenConsideringList(populateLinkedChildren(idEvent, ArchitectureConstants.Y,exchangeHomeDetail.getOrderBy(), exchangeHomeDetail.getSortDir()));
      
      //populate the date out
      exchangeHomeDetailSO.setDateOutHA(populateDateOut(exchangeHomeDetailSO));
     
      String daysOut = "";
      Date dtOut = exchangeHomeDetailSO.getDateOutHA();
      if(dtOut != null) {
        Date currentTime = new Date();
        if(currentTime.getTime() > dtOut.getTime()) {
          Double minDiff = new Double(DateHelper.minutesDifference(currentTime, dtOut) / 1440);
          Integer intMinDiff = minDiff.intValue();
          daysOut = intMinDiff.toString();
        }
      } 
      exchangeHomeDetailSO.setNumDaysOutHA(daysOut);
      
      //get the unlinked children
      exchangeHomeDetailSO.setChildrenNonSelectedList(populateLinkedChildren(idEvent, ArchitectureConstants.N,exchangeHomeDetail.getOrderBy(), exchangeHomeDetail.getSortDir()));
      
     //get the placement info
      exchangeHomeDetailSO = populatePlacemantInfo(exchangeHomeDetailSO, idEvent);
    }
        
    return exchangeHomeDetailSO;
  }
  
  private ROWCCMN01UIG00 populateEventInfo(int idEvent) {
    ROWCCMN01UIG00 eventStruct = new ROWCCMN01UIG00();
    Event eventDB = eventDAO.findEventByIdEvent(idEvent);
    if(eventDB != null) {
      eventStruct.setUlIdEvent(eventDB.getIdEvent());
      eventStruct.setTsLastUpdate(eventDB.getDtLastUpdate());
    }
    return eventStruct;
  }
  
  private ExchangeHomeDetailSO populateExchangeHomeInfo(int idEvent, ExchangeHomeDetailSO exchangeHomeDetailSO) {
    ExchangeHome exchangeHomeDB = exchangeHomeDAO.findExchangeHomeByEventId(idEvent);
    if(exchangeHomeDB != null) {
      exchangeHomeDetailSO.setAgencyContractNumber(exchangeHomeDB.getNbrAgencyContractCode());
      exchangeHomeDetailSO.setAgencyCaseWorkerName(exchangeHomeDB.getNmAgncyCaseworker());
      exchangeHomeDetailSO.setPhoneNumber(exchangeHomeDB.getNbrAgncyContactPhn());
      exchangeHomeDetailSO.setPhoneNumberExt(exchangeHomeDB.getNbrAgncyContactPhoneExt());
      exchangeHomeDetailSO.setDtRegistered(exchangeHomeDB.getDtRegistered());
      exchangeHomeDetailSO.setDtReRegistered(exchangeHomeDB.getDtReRegistered());
      exchangeHomeDetailSO.setDtApproved(exchangeHomeDB.getDtApproved());
      exchangeHomeDetailSO.setDtLastUpdate(exchangeHomeDB.getDtLastUpdate());
      //Home Preferences
      exchangeHomeDetailSO.setIndMentalRetardation(exchangeHomeDB.getIndMentalRetardation());
      exchangeHomeDetailSO.setCdLevelMentalRetardation(exchangeHomeDB.getCdSevMentalRetardation());
      exchangeHomeDetailSO.setIndVisualHearingImpairments(exchangeHomeDB.getIndVisualHearingImp());
      exchangeHomeDetailSO.setCdLevelVisualHearingImpairments(exchangeHomeDB.getCdSevVisualHearingImp());
      exchangeHomeDetailSO.setIndPhysicallyDisabled(exchangeHomeDB.getIndPhysicallyDisabled());
      exchangeHomeDetailSO.setCdLevelPhysicallyDisabled(exchangeHomeDB.getCdSevPhysicallyDisabled());
      exchangeHomeDetailSO.setIndEmotionallyDisturbed(exchangeHomeDB.getIndEmotionallyDist());
      exchangeHomeDetailSO.setCdLevelEmotionallyDisturbed(exchangeHomeDB.getCdSevEmotionallyDist());
      exchangeHomeDetailSO.setIndOtherMedicalDiagnoses(exchangeHomeDB.getIndOtherMed());
      exchangeHomeDetailSO.setCdlevelOtherMedicalDiagnoses(exchangeHomeDB.getCdSevOtherMed());   
      
      exchangeHomeDetailSO.setIndFamilyHxofDrugsAlcohol(exchangeHomeDB.getIndFamHxDrugsAlcohol());
      exchangeHomeDetailSO.setIndFamilyHxofMentalIllness(exchangeHomeDB.getIndFamHxMentalIll());
      exchangeHomeDetailSO.setIndFamilyHxofMR(exchangeHomeDB.getIndFamHxMr());
      exchangeHomeDetailSO.setIndChilsHxofSexualAbuse(exchangeHomeDB.getIndChHxSexualAbuse());
      exchangeHomeDetailSO.setNumOfChildren(exchangeHomeDB.getNbrChildInterest());
      exchangeHomeDetailSO.setHomePrefComments(exchangeHomeDB.getTxtCommentsInterest());
      
      //Home Availability 
      exchangeHomeDetailSO.setCdNonAvReasonHA(exchangeHomeDB.getCdNonAvailStatus());
      
      Date dtOut = exchangeHomeDB.getDtOut();
      exchangeHomeDetailSO.setDateOutHA(dtOut);
      
      exchangeHomeDetailSO.setCommentsHA(exchangeHomeDB.getTxtComments());
      exchangeHomeDetailSO.setFamilyIsLinkedHA(exchangeHomeDB.getTxtFamilyIsLinked());
            
      //Close Record Info
      exchangeHomeDetailSO.setDtClosedNP(exchangeHomeDB.getDtClose());
      exchangeHomeDetailSO.setCdReasonClosed(exchangeHomeDB.getCdReasonClosed());
      exchangeHomeDetailSO.setExplanationNPComments(exchangeHomeDB.getTxtExplanation());
      
      exchangeHomeDetailSO.setAFileNumCWP(exchangeHomeDB.getNbrAfile());
      exchangeHomeDetailSO.setChildrenPlacedWithCommentCWP(exchangeHomeDB.getTxtChildPlacedWith());

    }
    return exchangeHomeDetailSO;
  }
  
  
  private ExchangeHomeDetailSO populateResourceInformation(int idCase, int idStage, boolean prePopulate, ExchangeHomeDetailSO exchangeHomeDetailSO) {
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdCase(idCase);
    if(capsResource != null) {
      exchangeHomeDetailSO.setIdResource(capsResource.getIdResource());
      exchangeHomeDetailSO.setHomeName(capsResource.getNmResource());
      exchangeHomeDetailSO.setAgencyName(capsResource.getNdfcsCertEntity());
      exchangeHomeDetailSO.setCdCounty(capsResource.getCdRsrcCnty());
      exchangeHomeDetailSO.setCdRegion(Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, capsResource.getCdRsrcCnty()));
      exchangeHomeDetailSO.setMaleMaxRangeInMonths(capsResource.getNbrRsrcMaAgeMax());
      exchangeHomeDetailSO.setMaleMinRangeInMonths(capsResource.getNbrRsrcMaAgeMin());
      exchangeHomeDetailSO.setFemaleMaxRangeInMonths(capsResource.getNbrRsrcFmAgeMax());
      exchangeHomeDetailSO.setFemaleMinRangeInMonths(capsResource.getNbrRsrcFmAgeMin());
      exchangeHomeDetailSO.setDtApproved(resourceHistoryDAO.findEarliestAprvDateResourceHistoryDateByIdResource(capsResource.getIdResource()));
      
      List<String> categories  = new ArrayList<String>();
      categories.add(CodesTables.CFACATEG_O); //Relative Foster
      categories.add(CodesTables.CFACATEG_F); //Foster
      categories.add(CodesTables.CFACATEG_I); //ICPC Foster
      if(categories.contains(capsResource.getCdRsrcCategory())) {
        FosterHomeConv fosterHomeConv = fosterHomeConvDAO.findFosterHomeConvByIdResource(capsResource.getIdResource());
        //check if foster home has an approved active FH Conversion record on initial add prePopulate will determine if it the initial add
        boolean validFosterHomeConversion = !prePopulate;
        if(fosterHomeConv != null) {
            exchangeHomeDetailSO.setDtApproved(fosterHomeConv.getDtApproval());
            if(prePopulate) {
              //check if the current date is after or on the same day as the fhc
              if(DateHelper.isAfter(new Date(),fosterHomeConv.getDtApproval()) || DateHelper.isToday(fosterHomeConv.getDtApproval())) {
                validFosterHomeConversion = true;
              }   
              //check if current date is before the closure date of the of the fhc
              if((validFosterHomeConversion == true) && (fosterHomeConv.getDtClosure() == null || DateHelper.isBefore(new Date(),fosterHomeConv.getDtClosure()))) {
                validFosterHomeConversion = true;
              } else {
                validFosterHomeConversion = false;
              }
            }
          //STGAP00012476: Set the date applied with the date applied value on the Foster Home conversion record
          exchangeHomeDetailSO.setDtApplied(fosterHomeConv.getDtApplied());
          
        }
        
        //check if foster home has an approved active FH Conversion record on initial add
        if(validFosterHomeConversion == false) {
          throw new ServiceException(Messages.MSG_ADO_EXH_APRV_FH_CONV_REQ);
        }
      }
            
      if(prePopulate == true) {
        exchangeHomeDetailSO.setNumOfChildren(capsResource.getNbrRsrcFacilCapacity());
      }
      
    }
    // STGAP00014529 The Date Last Update should be populated with the approval date of the Home Re-evaluation
    Event ReEvaluationEvent =  eventDAO.findApprovedEventByIdStageAndEventTypeAndTask(idStage, FOSTER_REEVAL_TYPE, REEVALUATION_TASK);
    if(ReEvaluationEvent != null){
    Approvers approvers = approversDAO.findApproverByIdEventIfEventIsApproved(ReEvaluationEvent.getIdEvent(), APPROVED);
    exchangeHomeDetailSO.setDtLastUpdateDisplay(approvers.getDtApproversDetermination());
    }
    return exchangeHomeDetailSO;
  }
  
  private ExchangeHomeDetailSO populateHomeInfo(ExchangeHomeDetailSO exchangeHomeDetailSO) {
    HomeApplicantInfo homeApplicantInfo = homeApplicantInfoDAO.findHomeApplicantInfoByIdResource(exchangeHomeDetailSO.getIdResource());
    
    if(homeApplicantInfo != null) {            
      exchangeHomeDetailSO.setDtInquired(homeApplicantInfo.getDtInquiry());
      
    // mxpatel STGAP00014202: find if the Foster Home has a conversion event. If so, use the date from AdoInfo event
      // as the date inquired
      int idResource = exchangeHomeDetailSO.getIdResource();
      // find out if the home has a foster home conversion
      FosterHomeConv fosterHomeConv = fosterHomeConvDAO.findActiveFosterHomeConvByIdResource(idResource);
      if (fosterHomeConv != null) {
        // get the Foster Parent Notified Agency of Decision to Adopt field on the most recent Adoption Information page
        // where the Decision Outcome is 'Yes'
        Date dtDecAdopt = adoInfoDAO.findDateDecAdoptByIdResource(idResource);
        if (dtDecAdopt != null) {
          exchangeHomeDetailSO.setDtInquired(dtDecAdopt);
        }
      }
     
      //STGAP00012476: If the date applied is not set in the previous method 'populateResourceInformation' 
      //then set check if the home applicant info has non-null date applied and if it does populate the field.
      if(exchangeHomeDetailSO.getDtApplied()==null && homeApplicantInfo.getDtApplied()!=null){
        exchangeHomeDetailSO.setDtApplied(homeApplicantInfo.getDtApplied());
      }
      //get the earliest invite date
      Date dtIn1 = homeApplicantInfo.getDtInvite1();
      Date dtIn2 = homeApplicantInfo.getDtInvite2();
      Date dtIn3 = homeApplicantInfo.getDtInvite3();
      if(dtIn1 != null || dtIn2 != null || dtIn3 != null){
        SortedSet<Date> dateSet = new TreeSet<Date>();
        if(dtIn1 != null) {
          dateSet.add(dtIn1);
        }
        if(dtIn2 != null) {
          dateSet.add(dtIn2);
        }
        if(dtIn3 != null) {
          dateSet.add(dtIn3);
        }
        exchangeHomeDetailSO.setDtImpactBegin(dateSet.first());
      }
      
      //get the earliest orientation date
      Date dtOrt1 = homeApplicantInfo.getDtOrient1();
      Date dtOrt2 = homeApplicantInfo.getDtInvite2();
      Date dtOrt3 = homeApplicantInfo.getDtInvite3();
      if(dtOrt1 != null || dtOrt2 != null || dtOrt3 != null){
        SortedSet<Date> dateSet = new TreeSet<Date>();
        if(dtOrt1 != null) {
          dateSet.add(dtOrt1);
        }
        if(dtOrt2 != null) {
          dateSet.add(dtOrt2);
        }
        if(dtOrt3 != null) {
          dateSet.add(dtOrt3);
        }
        exchangeHomeDetailSO.setDtOrientation(dateSet.first());
      }
    }
    return exchangeHomeDetailSO;
  }
  
  @SuppressWarnings( { "unchecked" })
  private ExchangeHomeDetailSO populatePlacemantInfo(ExchangeHomeDetailSO exchangeHomeDetailSO, int idEvent) {
    List<Map> placementInfoList = placementDAO.findExchangeHomeInfoByCapsResourceById(exchangeHomeDetailSO.getIdResource());
    if(placementInfoList != null && placementInfoList.size() > 0) {
      String names = "";
      String county = null;
      SortedSet<Date> datePlaced = new TreeSet<Date>();
      SortedSet<Date> datePlacementEnd = new TreeSet<Date>();
      SortedSet<Date> dateDissolution = new TreeSet<Date>();
      SortedSet<Date> dateFinal = new TreeSet<Date>();
      SortedSet<Date> dateFinalEneterd = new TreeSet<Date>();
      Iterator<Map> itr = placementInfoList.iterator();
      List<Date> docSentDates = new ArrayList<Date>();// mxpatel 12533
      List<Date> permFileDates = new ArrayList<Date>();// mxpatel 12533
      
      // SMS#37206 Closed With Placement section should populate if the Non Availability Reason Code of the family is
      // saved to one the
      // codes out of Regular Placement, Foster Parent Placement, Foster/Adopt Placement, In Relative Placement, In Rel.
      // Fstr-Prnt Plcmnt
      String cdNonAvailStatus = exchangeHomeDetailSO.getCdNonAvReasonHA();
      List<String> cdNonAvailCodes = new ArrayList<String>();
      cdNonAvailCodes.add(CodesTables.CANONAV_09); // Regular Placement
      cdNonAvailCodes.add(CodesTables.CANONAV_10); // Foster Parent Placement
      cdNonAvailCodes.add(CodesTables.CANONAV_12); // Foster/Adopt Placement
      cdNonAvailCodes.add(CodesTables.CANONAV_15); // In Relative Placement
      cdNonAvailCodes.add(CodesTables.CANONAV_16); // In Rel. Fstr-Prnt Plcmnt
      
      if (cdNonAvailCodes.contains(cdNonAvailStatus)) {
        // now find the children who have been linked to the exchange home event
        // so that it can test if the child placed has been linked to the home
        
        //SMS#37206 Modified the findExchangeChildFamLinksIdPersonByResourceEventId() so that it finds linked children for given eventid and 
        // IND_LINK_CURRENT column set to Y, i.e this will give list of children in the Family is Now Considering section.
        List<Integer> linkedChildren = exchangeChildFamLinkDAO
                                                              .findExchangeChildFamLinksIdPersonByResourceEventId(idEvent , ArchitectureConstants.Y);
        if (linkedChildren == null) {
          linkedChildren = new ArrayList<Integer>();
        }

        while (itr.hasNext()) {
          Map placementInfo = itr.next();
          Integer idChild = (Integer) placementInfo.get("idChild");

          if (idChild != null && linkedChildren.contains(idChild) ){
                          //&& linkedChildrenIdList.contains(idChild)) {

            // STGAP00013144 - if placement was ended with reason of "adoption disrupted", earliest placement
            // end date (only consider placements with above reason code) should be displayed as the Disruption date
            // even if
            // there is not legal status present on the ADO stage.
            String cdPlcmtRemovalRsn = (String) placementInfo.get("cdPlcmtRemovalRsn");
            if (CodesTables.CRMRSNAC_ADI.equals(cdPlcmtRemovalRsn)) {
              Date temp = (Date) placementInfo.get("dtPlcmtEnd");
              if (DateHelper.isNull(temp) == false) {
                datePlacementEnd.add(temp);
              }
            }

            LegalStatus legalStatus = legalStatusDAO
                                                    .findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(
                                                                                                           idChild,
                                                                                                           CodesTables.CLEGSTAT_NAF);

            String name = (String) placementInfo.get("nmPersonFull");
            names += (name + (itr.hasNext() ? "; " : ""));

            // get the earliest dates
            Date temp = (Date) placementInfo.get("dtPlcmtStart");
            if (DateHelper.isNull(temp) == false) {
              datePlaced.add(temp);
            }

            temp = (Date) placementInfo.get("dtDissolution");
            if (DateHelper.isNull(temp) == false) {
              dateDissolution.add(temp);
            }

            if (legalStatus != null) {
              county = legalStatus.getCdLegalStatCnty();
              // get the earliest dates
              Date dtLegalStatus = legalStatus.getDtLegalStatStatusDt();
              if (DateHelper.isNull(dtLegalStatus) == false) {
                dateFinal.add(dtLegalStatus);
              }

              Event lsEvent = eventDAO.findEventByIdEvent(legalStatus.getIdLegalStatEvent());
              if (lsEvent != null) {
                Date dtEvent = lsEvent.getDtEventOccurred();
                if (DateHelper.isNull(dtEvent) == false) {
                  dateFinalEneterd.add(dtEvent);
                }
              }
            }
            // mxpatel #12533
            // It is possible to have multiple children who are not in a sibling group for the same Exchange Home Detail
            // Registration event. (even though this is not how it is supposed to work, there is a possibility
            // that this could happen). For this reason, we are retrieving "permission to file" and "documents sent"
            // dates for each child that is linked to the current Exchange Home Detail.
            Integer idEventExchangeChild = exchangeChildDAO.findIdEventByIdChild(idChild);
            if (idEventExchangeChild != null) {
              Date dtPermFile = adoInfoDAO.findDatePermFileByIdEventChildRegistration(idEventExchangeChild);
              if (dtPermFile != null) {
                permFileDates.add(dtPermFile);
              }
              Date dtDocSent = adoInfoDAO.findDateDocSentByIdEventChildRegistration(idEventExchangeChild);
              if (dtDocSent != null) {
                docSentDates.add(dtDocSent);
              }
            }
          }
        }
      }
    
      
      exchangeHomeDetailSO.setChildrenPlacedCWP(names);
      
      Date dtPlaced = ((datePlaced.size() > 0) ? datePlaced.first() : null);
      exchangeHomeDetailSO.setDtPlacedCWP(dtPlaced);
      
      Date dtDisruption = ((datePlacementEnd.size() > 0) ? datePlacementEnd.first() : null);
      exchangeHomeDetailSO.setDtDisruptionCWP(dtDisruption);
      
      Date dtDissolution = ((dateDissolution.size() > 0) ? dateDissolution.first() : null);
      exchangeHomeDetailSO.setDtDissolutionCWP(dtDissolution);
      
      Date dtFinal = ((dateFinal.size() > 0) ? dateFinal.first() : null);
      exchangeHomeDetailSO.setDtFinalCWP(dtFinal);
      
      Date dtFinalEneterd = ((dateFinalEneterd.size() > 0) ? dateFinalEneterd.first() : null);
      exchangeHomeDetailSO.setDtFinalEnteredCWP(dtFinalEneterd);
      
      //mxpatel 12533
      // populating the earliest "permission to File" and "document sent" dates to the Exchange Home Detail page.
      // mxpatel 12533
      if (docSentDates != null && docSentDates.size() > 0) {
        Date dtDocSent = Collections.min(docSentDates);
        exchangeHomeDetailSO.setDtDocSendDateCWP(dtDocSent);
      }
      // mxpatel 12533
      if (permFileDates != null && permFileDates.size() > 0) {
        Date dtPermFile = Collections.min(permFileDates);
        exchangeHomeDetailSO.setDtPermFile(dtPermFile);
      }
      
      exchangeHomeDetailSO.setCdCountyCWP(county);
    }
    
    return exchangeHomeDetailSO;
  }

  private String populateCaseWorkerInfo(int idStage) {
    String caseWorkerInfo = null;
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(idStage,
                                                           CodesTables.CSTFROLS_PR,
                                                           CodesTables.CPRSNALL_STF);
    if(stagePersonLink != null) {
      Person caseWorker = stagePersonLink.getPerson();
      caseWorkerInfo = caseWorker.getNmPersonFull() + "  " + getPersonOfficePhones(caseWorker.getIdPerson());
    }
    return caseWorkerInfo;
  }
   
  private ExchangeHomeDetailSO populateFamilyDemoInfo(int idStage,ExchangeHomeDetailSO exchangeHomeDetailSO){
    List<String> parentTypes = new ArrayList<String>();
    parentTypes.add(CodesTables.CRPTRINT_AF);
    parentTypes.add(CodesTables.CRPTRINT_FA);
    parentTypes.add(CodesTables.CRPTRINT_FP);
    parentTypes.add(CodesTables.CRPTRINT_PT);
    
    
    //find the mother
    StagePersonLink splMother = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelIntGender(idStage, parentTypes,
                                                                                                               CodesTables.CPRSNTYP_PRN, 
                                                                                                               CodesTables.CSEX_F);
    if(splMother != null) {
      Person mother = splMother.getPerson();
      exchangeHomeDetailSO.setDtMotherDOB(mother.getDtPersonBirth());
      exchangeHomeDetailSO.setMotherOccupation(mother.getTxtPersonOccupation());
      
      Collection<PersonRace> personRaceCollection = mother.getPersonRaces();
      if(personRaceCollection != null && personRaceCollection.size() > 0) {
        List<PersonRace> personRaceList = new ArrayList<PersonRace>(personRaceCollection);
        PersonRace personRace = personRaceList.get(0);
        if(personRace != null) {
          exchangeHomeDetailSO.setMotherRace(personRace.getCdRace());
        }
      }
      Collection<PersonEthnicity> personEthnicitiesCollection = mother.getPersonEthnicities();
      if(personEthnicitiesCollection != null && personEthnicitiesCollection.size() > 0) {
        List<PersonEthnicity> personEthnicityList = new ArrayList<PersonEthnicity>(personEthnicitiesCollection);
        PersonEthnicity personEthnicity = personEthnicityList.get(0);
        if(personEthnicity != null) {
          exchangeHomeDetailSO.setMotherEthnicity(personEthnicity.getCdEthnicity());
        }
      }
      exchangeHomeDetailSO.setMotherReligion(mother.getCdPersonReligion());
    }
    
    //find the father
    StagePersonLink splFather = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelIntGender(idStage, parentTypes,
                                                                                                               CodesTables.CPRSNTYP_PRN, 
                                                                                                               CodesTables.CSEX_M);
    if(splFather != null) {
      Person father = splFather.getPerson();
      exchangeHomeDetailSO.setDtFatherDOB(father.getDtPersonBirth());
      exchangeHomeDetailSO.setFatherOccupation(father.getTxtPersonOccupation());
      
      Collection<PersonRace> personRaceCollection = father.getPersonRaces();
      if(personRaceCollection != null && personRaceCollection.size() > 0) {
        List<PersonRace> personRaceList = new ArrayList<PersonRace>(personRaceCollection);
        PersonRace personRace = personRaceList.get(0);
        if(personRace != null) {
          exchangeHomeDetailSO.setFatherRace(personRace.getCdRace());
        }
      }
      Collection<PersonEthnicity> personEthnicitiesCollection = father.getPersonEthnicities();
      if(personEthnicitiesCollection != null && personEthnicitiesCollection.size() > 0) {
        List<PersonEthnicity> personEthnicityList = new ArrayList<PersonEthnicity>(personEthnicitiesCollection);
        PersonEthnicity personEthnicity = personEthnicityList.get(0);
        if(personEthnicity != null) {
          exchangeHomeDetailSO.setFatherEthnicity(personEthnicity.getCdEthnicity());
        }
      }
      exchangeHomeDetailSO.setFatherReligion(father.getCdPersonReligion());
    }
    
    return exchangeHomeDetailSO;    
  }
  
  private List<String> populateChildRacePreferences(int idResource) {
    List<String> raceList = new ArrayList<String>();
    
    List<HomeRace> homeRaces = homeRaceDAO.findHomeRacesByResourceId(idResource);
    if(homeRaces != null && homeRaces.size() > 0) {
      Iterator<HomeRace> homeRaceItr = homeRaces.iterator();
      while(homeRaceItr.hasNext()) {
        HomeRace homeRace = homeRaceItr.next();
        raceList.add(homeRace.getId().getCdRace());
      }
    }
    
    return raceList;
  }
  
  private List<String> populateChildEthnicitiesPreferences(int idResource) {
    List<String> ethnicitiesList = new ArrayList<String>();
    
    List<HomeEthnicity> homeEthnicities = homeEthnicityDAO.findHomeEthnicitiesByResourceId(idResource);
    if(homeEthnicities != null && homeEthnicities.size() > 0) {
      Iterator<HomeEthnicity> homeEthnicitiesItr = homeEthnicities.iterator();
      while(homeEthnicitiesItr.hasNext()) {
        HomeEthnicity homeEthnicity = homeEthnicitiesItr.next();
        ethnicitiesList.add(homeEthnicity.getId().getCdEthnicity());
      }
    }
    
    return ethnicitiesList;
  }
  
  @SuppressWarnings( { "unchecked" })
  private List<ExchangeHomeChildrenSO> populateLinkedChildren(int idEvent, String linkCurrent,String orderBy,String sortDir) {
    List<ExchangeHomeChildrenSO> linkedChildren = new ArrayList<ExchangeHomeChildrenSO>();
    
    List<Map> linkedChildrenDB = dynamicExchangeChildFamLinkDAO.findExchangeChildFamLinksByResourceEventIdAndCurrentIndByDir(idEvent, linkCurrent, orderBy, sortDir);
    if(linkedChildrenDB != null && linkedChildrenDB.size() > 0) {
      Iterator<Map> itr = linkedChildrenDB.iterator();
      while(itr.hasNext()) {
        Map excfl = itr.next();
        ExchangeHomeChildrenSO linkedChild = new ExchangeHomeChildrenSO();
        linkedChild.setIdEvent((Integer)excfl.get("ID_EXCHANGE_CHILD_FAM_LINK"));
        linkedChild.setCdNonAviReasonCode((String)excfl.get("CD_NON_AVAIL_CODE"));
        linkedChild.setCdNonSelReasonCode((String)excfl.get("CD_NON_SELECTION_RSN"));
        linkedChild.setDtLastUpdate((Date)excfl.get("DT_LAST_UPDATE"));
        linkedChild.setDtDateOut((Date)excfl.get("DT_OUT"));
        linkedChild.setLinkCurrent(linkCurrent);
        linkedChild.setIdExchangeHomeEvent(idEvent);
        Integer idEventChildRegistration = ((Integer)excfl.get("ID_EVENT_CHILD_REGISTRATION"));
        if(idEventChildRegistration != null) {
          linkedChild.setIdExchangeChildEvent(idEventChildRegistration);
          Integer idChild = exchangeChildDAO.findIdPersonByEventId(idEventChildRegistration);
          if(idChild != null) {
            Person child = personDAO.findPersonByIdPerson(idChild);
            if(child != null) {
              linkedChild.setIdChild(idChild);
              linkedChild.setLastName(child.getNmPersonLast());
              linkedChild.setFirstName(child.getNmPersonFirst());
              linkedChild.setDtDOB(child.getDtPersonBirth());
              linkedChild.setCdGender(child.getCdPersonSex());
              Map legalStatus = legalStatusDAO.findMostRecentLegalStatusIdAndCounty(idChild);
              if(legalStatus != null) {
                linkedChild.setCdCounty((String) legalStatus.get("cdLegalStatCnty"));
              }
            }
          }
        }
        linkedChildren.add(linkedChild);
      }
    }
    
    return linkedChildren;
  }
  
  private Date populateDateOut(ExchangeHomeDetailSO exchangeHomeDetailSO) {
    Date outDate = exchangeHomeDetailSO.getDateOutHA();
    List<ExchangeHomeChildrenSO> children = exchangeHomeDetailSO.getChildrenConsideringList();
    if (children != null && children.size() > 0) {
      SortedSet<Date> dateSet = new TreeSet<Date>();
      Iterator<ExchangeHomeChildrenSO> itr = children.iterator();
      while (itr.hasNext()) {
        ExchangeHomeChildrenSO child = itr.next();
        dateSet.add(child.getDtDateOut());
      }
      outDate = dateSet.first();
    } else {
      outDate = null;
    }
    return outDate;
  }
  
  @SuppressWarnings( { "unchecked" })
  private ExchangeHomeDetailSO prepopulateHomeInfo(ExchangeHomeDetailSO exchangeHomeDetailSO){
    Integer idResource = exchangeHomeDetailSO.getIdResource();
    
    try {
      List<String> inputList = new ArrayList<String>();
      
      //IndMentalRetardation
      inputList.add(CodesTables.CLNCHAR2_52);
      
      //IndVisualHearingImpairments
      inputList.add(CodesTables.CLNCHAR2_36);
      inputList.add(CodesTables.CLNCHAR2_84);
      
      //IndPhysicallyDisabled
      inputList.add(CodesTables.CLNCHAR2_75);

      //IndEmotionallyDisturbed
      inputList.addAll(Lookup.getCategoryCodesCollection(CodesTables.CADOEMD));

      //IndOtherMedicalDiagnoses
      inputList.addAll(Lookup.getCategoryCodesCollection(CodesTables.CADOOMD));
      
      //IndFamilyHxofDrugsAlcohol
      inputList.add(CodesTables.CADBKRNF_06);
      inputList.add(CodesTables.CLNCHAR2_300);
      
      //IndFamilyHxofMentalIllness
      inputList.add(CodesTables.CADBKRNF_07);
      inputList.add(CodesTables.CLNCHAR2_301);
      
      //IndFamilyHxofMR
      inputList.add(CodesTables.CADBKRNF_08);
      inputList.add(CodesTables.CLNCHAR2_302);
      
      //IndChilsHxofSexualAbuse
      inputList.add(CodesTables.CADBKRNF_09);
      inputList.add(CodesTables.CLNCHAR2_303);
      
      List<Map> returnMapList = resourceChrctrDAO.findResourceChrctrByIdResourceAndCdRsrcCharChrct(idResource, inputList);
      if(returnMapList != null && returnMapList.size() > 0){
        List<String> codesList = new ArrayList<String>();
        Iterator<Map> itr = returnMapList.iterator();
        while(itr.hasNext()) {
          Map<String, String> codeMap = (Map<String, String>)itr.next();
          codesList.addAll(codeMap.values());
        }
        
        if (codesList.contains(CodesTables.CLNCHAR2_52)) {
          exchangeHomeDetailSO.setIndMentalRetardation(ArchitectureConstants.Y);
        }
        
        if (codesList.contains(CodesTables.CLNCHAR2_36) || codesList.contains(CodesTables.CLNCHAR2_84)) {
          exchangeHomeDetailSO.setIndVisualHearingImpairments(ArchitectureConstants.Y);
        }
        
        if (codesList.contains(CodesTables.CLNCHAR2_75)) {
          exchangeHomeDetailSO.setIndPhysicallyDisabled(ArchitectureConstants.Y);
        }
        
        Collection emdCodes = Lookup.getCategoryCodesCollection(CodesTables.CADOEMD);
        if(emdCodes != null) {
          Iterator codeListItr = codesList.iterator();
          while(codeListItr.hasNext()){
            String code = (String) codeListItr.next();
            if (emdCodes.contains(code)) {
              exchangeHomeDetailSO.setIndEmotionallyDisturbed(ArchitectureConstants.Y);
              break;
            }
          }
        }
        
        Collection omdCodes = Lookup.getCategoryCodesCollection(CodesTables.CADOOMD);
        if(omdCodes != null) {
          Iterator codeListItr = codesList.iterator();
          while(codeListItr.hasNext()){
            String code = (String) codeListItr.next();
            if (omdCodes.contains(code)) {
              exchangeHomeDetailSO.setIndOtherMedicalDiagnoses(ArchitectureConstants.Y);
              break;
            }
          }
        }
                
        if (codesList.contains(CodesTables.CADBKRNF_06) || codesList.contains(CodesTables.CLNCHAR2_300) ) {
          exchangeHomeDetailSO.setIndFamilyHxofDrugsAlcohol(ArchitectureConstants.Y);
        }
        
        if (codesList.contains(CodesTables.CADBKRNF_07)|| codesList.contains(CodesTables.CLNCHAR2_301)) {
          exchangeHomeDetailSO.setIndFamilyHxofMentalIllness(ArchitectureConstants.Y);
        }
        
        if (codesList.contains(CodesTables.CADBKRNF_08) || codesList.contains(CodesTables.CLNCHAR2_302)) {
          exchangeHomeDetailSO.setIndFamilyHxofMR(ArchitectureConstants.Y);
        }
        
        if (codesList.contains(CodesTables.CADBKRNF_09)|| codesList.contains(CodesTables.CLNCHAR2_303)) {
          exchangeHomeDetailSO.setIndChilsHxofSexualAbuse(ArchitectureConstants.Y);
        } 
      }
    }
    catch (LookupException e) {
      throw new ServiceException(0, e);
    }
        
    return exchangeHomeDetailSO;
  }
  
  private String getPersonOfficePhones(int idPerson) {
    String phoneNumber = "";
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    String indPersonPhoneInValid = "N";
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);

    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);
    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {
      PersonPhone personPhone = it.next();
      phoneNumber = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()) +  ((personPhone.getNbrPersonPhoneExtension() != null) ? (" ext " + personPhone.getNbrPersonPhoneExtension()): (""));
      break;
    }
    return phoneNumber;
  }

  public void setApproversDAO(ApproversDAO approversDAO){
	  this.approversDAO = approversDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setHomeRaceDAO(HomeRaceDAO homeRaceDAO) {
    this.homeRaceDAO = homeRaceDAO;
  }
  
  public void setHomeEthnicityDAO(HomeEthnicityDAO homeEthnicityDAO) {
    this.homeEthnicityDAO = homeEthnicityDAO;
  }

  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }

  public void setDynamicExchangeChildFamLinkDAO(DynamicExchangeChildFamLinkDAO dynamicExchangeChildFamLinkDAO) {
    this.dynamicExchangeChildFamLinkDAO = dynamicExchangeChildFamLinkDAO;
  }
  
  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setHomeApplicantInfoDAO(HomeApplicantInfoDAO homeApplicantInfoDAO) {
    this.homeApplicantInfoDAO = homeApplicantInfoDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
 
  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
    this.fosterHomeConvDAO = fosterHomeConvDAO;
  }
  
  // mxpatel 12533
  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public ResourceChrctrDAO getResourceChrctrDAO() {
    return resourceChrctrDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

}
