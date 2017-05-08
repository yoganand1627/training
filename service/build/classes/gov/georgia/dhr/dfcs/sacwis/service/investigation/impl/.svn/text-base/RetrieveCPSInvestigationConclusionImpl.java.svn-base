package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cdispstn;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cevnttyp;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cevtstat;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseWatchFactorHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveCPSInvestigationConclusion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/12/08  VVO       STGAP00009662 - created RetrieveCpsInvstDetail() to hold 
 *                      the combined RetrieveCpsInvstDetailByIdEvent and IdStage so 
 *                      Maltreatment Finding can reflect overall disposition database
 *                      field value only.
 *  05/24/10  bgehlot   SMS#51977 MR-066 Changes
 *  06/14/10  bgehlot   SMS#51977 New Requirement: Special Investigation Question should default to Yes if there was
 *                      Special Investigation Call Type Selected during Intake
 *  06/30/10  bgehlot   SMS 59300 Special Investigation question defaulting to Yes or no or Blank properly.
 *  06/22/11  charden   Capta 4.3 - adding new logic for fields "Is this a Special Investigation?", "Is this a Policy Violation?" 
 *                                  and "Is this a Maltreatment in Care?" 
 *  01/16/12  vcollooru STGAP00017781 - modified to fix the response date field issue.
 *  01/26/12  habraham  STGAP00017829 - MR-097 - Modified the code to change add UnsubstantiatedMICindicator -
 *                      while retrieving the allegations if any of the allegations has UnsubstantiatedMICindicator as 'Y', the cpsInvestigation 
 *                      will have the value as 'Y' for UnsubstantiatedMICindicator
 * 03/09/2012 arege     STGAP00017955: Set the "Is this special Investigation" indicator to Y even if it is UnSubMIC
 * 03/09/12   vcollooru STGAP00017941: Added a new comment field for foster parent notification.
 * 03/12/2012 arege     STGAP00017955: Set the "Is this special Investigation" indicator to Y when there is SP INV call type on Intake
 * </pre>
 */

public class RetrieveCPSInvestigationConclusionImpl extends BaseServiceImpl implements
                                                                           RetrieveCPSInvestigationConclusion {

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private StageDAO stageDAO = null;

  private EventDAO eventDAO = null;

  private ContactDAO contactDAO = null;

  private RiskAssessmentDAO riskAssessmentDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private CaseMergeDAO caseMergeDAO = null;

  private AllegationDAO allegationDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private EmpJobHistoryDAO empJobHistoryDAO = null;
  
  private PlacementDAO placementDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;
  
  private IncomingFacilityDAO incomingFacilityDAO = null;

  private CaseWatchFactorHelpDAO caseWatchFactorHelpDAO = null;

  private final int PAGENBR = 1;

  private final int PAGESIZE = 50;

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;
  }

  public void setCaseWatchFactorHelpDAO(CaseWatchFactorHelpDAO caseWatchFactorHelpDAO) {
	    this.caseWatchFactorHelpDAO = caseWatchFactorHelpDAO;
  }

  public CINV14SO retrieveCPSInvestigationConclusion(CINV14SI cinv14si) throws ServiceException {
    CINV14SO cinv14so = new CINV14SO();
    // Set CINV14SO WCD DtSystemDate to current date
    cinv14so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    int idEvent = cinv14si.getUlIdEvent();
    int idStage = cinv14si.getUlIdStage();
    int idCase = cinv14si.getUlIdCase();

    // STGAP00009662 -
    ROWCINV10DOG00 rowcinv10dog00 = RetrieveCpsInvstDetail(idEvent, idStage);
    
    //SMS#51977 MR-066 Get the Placement/Non-Placement Provider
    ROWCINV10DOG01 rowcinv10dog01 = null;
    boolean bIndRowcinv10dog01IsSet = cinv14si.getBIndRowcinv10dog01IsSet();
    rowcinv10dog01 = RetrieveCpsInvstDetailResource(idEvent, idStage);
    //Populate the Provider Name Type and ResourceID from the Intake if provider has been specified in the Intake for the first time 
    //the CPS Investigation page loads.
    if(rowcinv10dog01 == null){
      if(!bIndRowcinv10dog01IsSet){
        rowcinv10dog01 = RetrieveCpsInvstDetailResourceFromIntake(idStage);
      }      
    }   

    cinv14so.setROWCINV10DOG01(rowcinv10dog01);


    //MR-066 Look thru all the allegations in the INV stage 
    List<Allegation> allegationsList = allegationDAO.findAllegationsByIdStageForCPS(idStage);
    
    
    // Corey 06/22/11 4.3 Capta - adding logic for special investigation, policy violation and maltreatment in care
    boolean maltreatmentInCare = false;
    boolean allSubstantiated = true;
    boolean anySubstantiated = false;
    boolean indUnSubMIC= false;
    
    boolean isThisSpInv = StringHelper.isValid(rowcinv10dog00.getCIndSpeInvstPlaceProv());
    
    if(allegationsList != null){
      if(!allegationsList.isEmpty()){
        // loop thru allegations
        for(Allegation allegation : allegationsList){
          // check to see if all allegations have been addressed
          if(!StringHelper.isValid(allegation.getCdAllegDisposition())){
            // set indicator so we will know that all allegations have not been substantiated
            allSubstantiated = false;
          }
          
          // check to see if any allegation has been substantiated
          if(Cdispstn.CDISPSTN_SUB.equals(allegation.getCdAllegDisposition()) && ArchitectureConstants.Y.equals(allegation.getIndMaltreatInCare())){
            // set indicator so we know that at least one allegation has been substantiated
            anySubstantiated = true;
          }
          //MR-097 - checking if any of the allegation has the indUnSubstantiated as 'Y'
          if(StringHelper.isValid(allegation.getIndUnSubMaltreatInCare()) && ArchitectureConstants.Y.equals(allegation.getIndUnSubMaltreatInCare())){
        	  indUnSubMIC = true;
          }
        }
        
        // if any maltreatment in care allegation has been substantiated, set indicator to yes
        if(anySubstantiated){
          // set indicator to yes
          rowcinv10dog00.setCIndInvMaltreatInCare(ArchitectureConstants.Y);
          
          // if this is a maltreatment in care, then the child was "in custody" so this should also be a special investigation
          if(!StringHelper.isValid(rowcinv10dog00.getCIndSpeInvstPlaceProv())){
            rowcinv10dog00.setCIndSpeInvstPlaceProv(ArchitectureConstants.Y);
          }
        }else{
          // set indicator to no
          rowcinv10dog00.setCIndInvMaltreatInCare(ArchitectureConstants.N);
          
          // if there is no maltreatment in care, then this is not a special investigation
          if(!StringHelper.isValid(rowcinv10dog00.getCIndSpeInvstPlaceProv())){
            rowcinv10dog00.setCIndSpeInvstPlaceProv("N");
          }
        }
	        
	        //MR-097 -setting the value for indUnSubstantiated for CPS Investigation'
	      if(indUnSubMIC)
	    	  rowcinv10dog00.setCIndUnsubMIC("Y");
	      else 
	    	  rowcinv10dog00.setCIndUnsubMIC("N");
	        
      }else{
        // default radio button to No if there are no allegations
        rowcinv10dog00.setCIndInvMaltreatInCare("N");
        rowcinv10dog00.setCIndUnsubMIC("N");
      } 
      
    }
    
    if(allegationsList != null && !allegationsList.isEmpty()){     
      //Loop thru all the Allegations and look for trial home visit placement at the time of incident.
      Iterator<Allegation> iterAllegation1 = allegationsList.iterator();
      while (iterAllegation1.hasNext()) {
        Allegation allegation1 = (Allegation) iterAllegation1.next();
        int idPerson = allegation1.getPersonByIdVictim().getIdPerson();
        Placement placement = placementDAO.findTrialHomeVisitPlacementByIdPersonDtAllegIncident(idPerson, allegation1.getDtAllegedIncident());
        if(placement != null){
          //If it is a child visit, set the Child visit parameter to Y
          rowcinv10dog00.setCIndTrialHomeVisit(ArchitectureConstants.Y);
          break;
        }
      }
    }
    
    //If a Special Investigation has been designated on the Intake Information page, the Special Investigation 
    //question should default to yes and modifiable.
    String cdSpecialInvCallType = "";
    String indPolicyViolation = "";
    int idIntakeStage  = 0;
    //Get the previous stage of the INV.
    Integer idPreviousStageObj = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
    if(idPreviousStageObj != null){
      int idPreviousStage = idPreviousStageObj;
      Stage previousStage = stageDAO.findStageByIdStage(idPreviousStage);
      if(previousStage != null){
        //If the previous stage is DIV then get the previous stage of DIV to get INT stage, else it's the INT stage
        if(CodesTables.CSTAGES_DIV.equals(previousStage.getCdStage())){
          Integer idIntakeStageObj = stageLinkDAO.findPreviousIdStagebyIdStage(idPreviousStage);
          if(idIntakeStageObj != null){
            idIntakeStage = idIntakeStageObj;            
          }
        }else{
          idIntakeStage = idPreviousStage;
        }
      }
      //Get the Incoming Detail for the INT
      IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idIntakeStage);
      if(incomingDetail != null){
        cdSpecialInvCallType = incomingDetail.getCdSpclInvstgtn();
        indPolicyViolation = incomingDetail.getIndPolicyViolation();
      }
      // set policy violation question the same as intake answer but leave field modifiable
      if(StringHelper.isValid(indPolicyViolation) && !StringHelper.isValid(rowcinv10dog00.getCIndPolicyViolation())){
        rowcinv10dog00.setCIndPolicyViolation(indPolicyViolation);
      }
      //Check to see if the Special Investigation Call Type exists in INt then default "Is this a SPecial Investigation"
      //question to 'Yes'
      //STGAP00017955: Set the "Is this special Investigation" indicator to Y when there is SP INV call type on Intake
      //Sp Inv call type is required for all MIC Intakes
      if(StringHelper.isValid(cdSpecialInvCallType)){
        //if the data is already saved in the database, do not set the indicator again.
        if(!isThisSpInv){
          rowcinv10dog00.setCIndSpeInvstPlaceProv(ArchitectureConstants.Y);
        }
      }
    }
    
    // check for special investigation for this stage
    List<Event> spiEventList = eventDAO.findEventByIdStageAndCdEventType(idStage, Cevnttyp.CEVNTTYP_SPI);
    boolean isApproved = false;
    boolean isSpi = false;
    // check for events
    if(!spiEventList.isEmpty()){
      // set indicator so we know that there is a special investigation for this stage
      isSpi = true;
      // loop thru list of events
      for(Event event : spiEventList){
        // check status of event
        if(Cevtstat.CEVTSTAT_APRV.equals(event.getCdEventStatus())){
          isApproved = true;
        }
      }
      
      // set indicator to yes if there is a special investigation that has not been approved
      if(isSpi == true && isApproved == false){
        cinv14so.setBIndActiveEvent(ArchitectureConstants.Y);
      }    
    }else{
      cinv14so.setBIndActiveEvent(ArchitectureConstants.N);
    }
    
    
    if (rowcinv10dog00 != null) {
      cinv14so.setROWCINV10DOG00(rowcinv10dog00);
      // Retrieve event status if input ID EVENT != NULL
      // Call CCMN45D
      if (idEvent != 0) {
        ROWCCMN45DO rowccmn45do = retrieveEvent(idEvent);
        cinv14so.setROWCCMN45DO(rowccmn45do);
      }
      // If the DT_CPS_INVST_DTL_BEGUN in output record is NULL,then retrieve the
      // date of the earliest contact for the idStage and set
      // DT_CPS_INVST_DTL_BEGUN equal to this date
      // Always get the Investigation Begun Date from the Date of
      // First Contact retrieved by the following DAO call
      // CallCSYS15D
      //org.exolab.castor.types.Date newDtCPSInvstDtlBegun = findEarliestContactDate(idStage,
      //                                                                             cinv14so.getROWCINV10DOG00()
      //                                                                                     .getDtDtCPSInvstDtlBegun());
      
      //STGAP00017781: Calling the newly method to get the most recent CM child visit to get response met date
      org.exolab.castor.types.Date newDtCPSInvstDtlBegun = findDateResponseMet(idStage);
      cinv14so.getROWCINV10DOG00().setDtDtCPSInvstDtlBegun(newDtCPSInvstDtlBegun);
      // CallCINV14D
      // Retrieve the Risk Assessment Finding and Recomended Action (if
      // any) form the RISK ASSESSMENT table using the ID STAGE passed
      // as input to the service
      ROWCINV14DOG00 rowcinv14dog00 = retrieveAllegationInformation(idStage);
      cinv14so.setROWCINV14DOG00(rowcinv14dog00);
      int rowcinv14dog00IdEvent = rowcinv14dog00.getUlIdEvent();
      // Retrieve narrative information if previous DAO retrieved an ID_EVENT
      if (0 != rowcinv14dog00IdEvent) {
        // CallCSYS13D
        // Note: In the original service, idEvent is extracted like
        // this: pInputMsg->ROWCINV14DOG00.ulIdEvent
        // Since cinv14si doesn't contain ROWCINV14DOG00 object , it is not
        // possible now. idEvent is extracted directly from cinv14si instead
        Date dtLastUpdate = retrieveNarrativeInfo(cinv14so.getROWCINV14DOG00().getCIndRiskAssmtIntranet(),
                                                  cinv14si.getUlIdEvent());
        if (dtLastUpdate != null) {
          cinv14so.setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
          cinv14so.setTsLastUpdate(dtLastUpdate);
        } else {
          cinv14so.setSzScrTxtNarrStatus(StringHelper.EMPTY_STRING);
        }
      }
      // CallCINT40D Retrieve stage information
      ROWCINV14SOG00 rowcinv14sog00 = retrieveStageInfo(idStage);
      cinv14so.setROWCINV14SOG00(rowcinv14sog00);

      String indCaseMergePending = checkCasePending(rowcinv14sog00.getUlIdCase());
      cinv14so.setCIndCaseMergePending(indCaseMergePending);
      // CallCLSC84D
      // Get the DT_INCOMING_CALL for the Intake Begun Date by using
      // DAM CLSC69D for a full row retrieval from the INCOMING_DETAIL
      // table.
      /**
       * STGAP00009311 - added this null check to prevent unnecessary DAO call if Intake date already exists in
       * CPS_Invst_Detail. Intake date is a fixed value at this point so it is ok to always use the one in
       * CPS_Invst_Detail once exists
       */
      if (DateHelper.isNull(rowcinv10dog00.getDtDtCPSInvstDtlIntake())) {
        retrieveEarliestIntakeDate(rowcinv14sog00.getUlIdStage(), cinv14so.getROWCINV10DOG00());
      }
    }
    // Retrieve principal information
    // CallCINT20D
    Integer rowQty = retrievePrincipalInformation(idStage);
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    if (rowQty != null) {
      archOutputStruct.setUlRowQty(rowQty);
    } else {
      archOutputStruct.setUlRowQty(0);
    }
    cinv14so.setArchOutputStruct(archOutputStruct);
    // Retrieve information for principals with unknown Gender or approximate DOB
    // CallCLSC18D
    String indPrnUk = RetrievePrincipalsWithUnknownGender(idStage);
    cinv14so.setBIndPrnUk(indPrnUk);
    // CallCINVD3D
    String IndSubstantiatedAlleg = checkAllegationForSub(idStage);
    cinv14so.setBIndSubstantiatedAlleg(IndSubstantiatedAlleg);

    String indPhabSxabAllegExist = checkAllegationForAbuse(idStage);
    cinv14so.setBIndPhabSxabAllegExist(indPhabSxabAllegExist);
    // retrieve employee's supervisor id
    cinv14so.setUlIdPersonSupervisor(retrieveEmployeeSupervisorID(cinv14si.getArchInputStruct().getSzUserId()));

    // retrieve if cps conclusion narrative already exist in DB
    String tableName = "CPS_CONCLUSION_NARR";
    Date lastUpdate = commonDAO.findDtLastUpdate(tableName, idEvent);
    if (DateHelper.isNull(lastUpdate)) {
      cinv14so.setBIndBLOBExistsInDatabase(FALSE);
    } else {
      cinv14so.setBIndBLOBExistsInDatabase(TRUE);
    }
     return cinv14so;
  }

  /**
   * This method retrieves CPS Investigation Conclusion page data when given either id event or id stage. STGAP00009662 -
   * combine outcomes from retrieve by id event and id stage since cps_invst_detail row now gets created and populated
   * when id event created. Before, each of these methods only set certain fields to output. The way SHINES works right
   * now retrieve by id event is going to get executed first and there are some fields that don't get assigned to output
   * object even when they have value. Keep 2 calls even though they retrieve identical data to be self-contained
   * regardless change in Conversation.
   * 
   * @param idEvent
   * @param idStage
   * @return
   * @throws ServiceException
   */
  private ROWCINV10DOG00 RetrieveCpsInvstDetail(int idEvent, int idStage) throws ServiceException {
    CpsInvstDetail cpsInvstDetail;
    ROWCINV10DOG00 rowcinv10dog00;
    if (idEvent != 0) {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdEvent(idEvent);
    } else {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    }

    if (cpsInvstDetail == null) {
      rowcinv10dog00 = null;
    } else {
      rowcinv10dog00 = new ROWCINV10DOG00();
      rowcinv10dog00.setTsLastUpdate(cpsInvstDetail.getDtLastUpdate());
      rowcinv10dog00.setUlIdStage(cpsInvstDetail.getStage().getIdStage() != null ? cpsInvstDetail.getStage()
                                                                                                  .getIdStage() : 0);
      rowcinv10dog00.setUlIdEvent(cpsInvstDetail.getIdEvent() != null ? cpsInvstDetail.getIdEvent() : 0);

      rowcinv10dog00.setDtDtCPSInvstDtlIntake(cpsInvstDetail.getDtCpsInvstDtlIntake());
      rowcinv10dog00.setDtDtCPSInvstDtlAssigned(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlAssigned()));
      rowcinv10dog00.setDtDtCPSInvstDtlBegun(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlBegun()));
      rowcinv10dog00.setDtDtCpsInvstDtlComplt(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlComplt()));
      rowcinv10dog00.setDtDtDetermLetterSent(DateHelper.toCastorDate(cpsInvstDetail.getDtDetermLetterSent()));

      rowcinv10dog00.setSzCdStageRiskFinding(cpsInvstDetail.getCdCnclsnRiskFnd());
      rowcinv10dog00.setSzCdStageLvlOfRisk(cpsInvstDetail.getCdCnclsnRiskLvl());

      rowcinv10dog00.setCdCpsOverallDisptn(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn());
      rowcinv10dog00.setBIndCpsInvstSafetyPln(cpsInvstDetail.getIndCpsInvstSafetyPln());
      rowcinv10dog00.setCIndCpsInvstDtlRaNa(cpsInvstDetail.getIndCpsInvstDtlRaNa());
      rowcinv10dog00.setSzCdCpsInvstDtlFamIncm(cpsInvstDetail.getCdCpsInvstDtlFamIncm());
      rowcinv10dog00.setBIndCpsInvstEaConcl(cpsInvstDetail.getIndCpsInvstDtlEaConcl());
      rowcinv10dog00.setBIndCpsInvstCpsLeJointContact(cpsInvstDetail.getIndCpsLeJntCntct());
      rowcinv10dog00.setSzCdCpsInvstCpsLeJointContact(cpsInvstDetail.getCdReasonNoJntCntct());
      rowcinv10dog00.setSzTxtCpsInvstCpsLeJointContact(cpsInvstDetail.getTxtReasonNoJntCntct());
      rowcinv10dog00.setBIndVictimTaped(cpsInvstDetail.getIndVictimTaped());
      rowcinv10dog00.setSzCdVictimTaped(cpsInvstDetail.getCdVictimTaped());
      rowcinv10dog00.setSzTxtVictimTaped(cpsInvstDetail.getTxtVictimTaped());

      rowcinv10dog00.setSzTxtOvrllCaseDisptn(cpsInvstDetail.getTxtOvrllCaseDisptn());

      // Supervisor override data
      rowcinv10dog00.setDtDtOverride(DateHelper.toCastorDate(cpsInvstDetail.getDtOverride()));
      rowcinv10dog00.setSzCdOverrideOverllFind(cpsInvstDetail.getCdOverrideOverllFind());
      rowcinv10dog00.setSzCdOverrideRiskLvl(cpsInvstDetail.getCdOverrideRiskLvl());
      rowcinv10dog00.setSzTxtOverrideComments(cpsInvstDetail.getTxtOverrideComments());
      rowcinv10dog00.setCdFamviol01(cpsInvstDetail.getCdFamviol01());
      rowcinv10dog00.setCdFamviol02(cpsInvstDetail.getCdFamviol02());
      rowcinv10dog00.setCdFamviol03(cpsInvstDetail.getCdFamviol03());
      rowcinv10dog00.setCdFamviol04(cpsInvstDetail.getCdFamviol04());
      rowcinv10dog00.setCdFamviol05(cpsInvstDetail.getCdFamviol05());
      rowcinv10dog00.setCdAbuseStatus(cpsInvstDetail.getCdAbuseStatus());
      rowcinv10dog00.setCdAbuseType01(cpsInvstDetail.getCdAbuseType01());
      rowcinv10dog00.setCdAbuseType02(cpsInvstDetail.getCdAbuseType02());
      rowcinv10dog00.setCdAbuseType03(cpsInvstDetail.getCdAbuseType03());
      rowcinv10dog00.setCdAbuseType04(cpsInvstDetail.getCdAbuseType04());
      rowcinv10dog00.setCdAbuseType05(cpsInvstDetail.getCdAbuseType05());
      rowcinv10dog00.setCdAbuseType06(cpsInvstDetail.getCdAbuseType06());
      rowcinv10dog00.setCdAbuseType07(cpsInvstDetail.getCdAbuseType07());
      rowcinv10dog00.setCdMaltreatLoc(cpsInvstDetail.getCdMaltreatLoc());
      rowcinv10dog00.setCIndSpeInvstPlaceProv(cpsInvstDetail.getIndSpeInvstPlaceProv());
      
      //SMS 51977: MR-066 Maltreatment in care
      rowcinv10dog00.setCIndInvMaltreatInCare(cpsInvstDetail.getIndInvMaltreatInCare());
      rowcinv10dog00.setCIndPolicyViolation(cpsInvstDetail.getIndPolicyViolation());
      //Setting the indicator to UnSubstantiated MIC for CPS Investigation Control
      rowcinv10dog00.setCIndUnsubMIC(cpsInvstDetail.getIndUnSubMaltreatInCare());
      
      rowcinv10dog00.setCIndFostPrntNotified(cpsInvstDetail.getIndFostPrntNotified());
      // STGAP00017941: Retrieving the new comment field text.
      rowcinv10dog00.setSzTxtFostPrntNotifyCmnts(cpsInvstDetail.getTxtFostPrntNotifyCmnts());
      rowcinv10dog00.setCIndStOffNotifyRmvChild(cpsInvstDetail.getIndStOffNotifyRmvChild());
      rowcinv10dog00.setDtDtFostPrntNotified(DateHelper.toCastorDate(cpsInvstDetail.getDtFostPrntNotified()));
      rowcinv10dog00.setDtDtStOffNotifyRmvChild(DateHelper.toCastorDate(cpsInvstDetail.getDtStOffNotifyRmvChild()));
      rowcinv10dog00.setDtDtStOffAdviceRmvChild(DateHelper.toCastorDate(cpsInvstDetail.getDtStOffAdviceRmvChild()));

    }
    return rowcinv10dog00;
  }
  
  /**
   * //SMS#51977 MR-066 This method retrieves CPS Investigation Conclusion Resource when given either id event or id stage. 
   * 
   * @param idEvent
   * @param idStage
   * @return
   * @throws ServiceException
   */
  private ROWCINV10DOG01 RetrieveCpsInvstDetailResource(int idEvent, int idStage) throws ServiceException {
    /*CpsInvstDetail cpsInvstDetail;
    
    if (idEvent != 0) {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdEvent(idEvent);
    } else {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    }

    if (cpsInvstDetail == null) {
      rowcinv10dog01 = null;
    } else {
      rowcinv10dog01 = new ROWCINV10DOG01();
      if(cpsInvstDetail.getCapsResource() != null){
        CapsResource capsResource = cpsInvstDetail.getCapsResource();
        if (capsResource != null) {
          rowcinv10dog01.setUlIdResource(capsResource.getIdResource());
          rowcinv10dog01.setSzCdRsrcType(capsResource.getCdRsrcFacilType());
          rowcinv10dog01.setSzNmResource(capsResource.getNmResource());          
          if(capsResource.getStage() != null){
            rowcinv10dog01.setUlIdHomeStage(capsResource.getStage().getIdStage());
          }
        }
        
      }
    }*/
    
    //SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
    ROWCINV10DOG01 rowcinv10dog01;
    IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(idStage);

    if (incomingFacility == null) {
      // return null;
      rowcinv10dog01 = null;
    }else{
      rowcinv10dog01 = new ROWCINV10DOG01();
      CapsResource capsResource = incomingFacility.getCapsResource();
      if (capsResource != null) {
        rowcinv10dog01.setUlIdResource(capsResource.getIdResource());
        rowcinv10dog01.setSzCdRsrcType(capsResource.getCdRsrcFacilType());
        rowcinv10dog01.setSzNmResource(capsResource.getNmResource());          
        if(capsResource.getStage() != null){
          rowcinv10dog01.setUlIdHomeStage(capsResource.getStage().getIdStage());
        }
      }
      rowcinv10dog01.setSzAddrIncmgFacilCity(incomingFacility.getAddrIncmgFacilCity());
      rowcinv10dog01.setSzCdIncFacilOperBy(incomingFacility.getCdIncmgFacilOperBy());
      rowcinv10dog01.setBIndIncmgFacilAbSupvd(incomingFacility.getIndIncmgFacilAbSupvd());
      rowcinv10dog01.setBIndIncmgFacilSearch(incomingFacility.getIndIncmgFacilSearch());
      rowcinv10dog01.setSzAddrIncmgFacilStLn1(incomingFacility.getAddrIncmgFacilStLn1());
      rowcinv10dog01.setSzAddrIncmgFacilStLn2(incomingFacility.getAddrIncmgFacilStLn2());
      rowcinv10dog01.setSzAddrIncmgFacilZip(incomingFacility.getAddrIncmgFacilZip());
      rowcinv10dog01.setSzCdIncmgFacilCnty(incomingFacility.getCdIncmgFacilCnty());
      rowcinv10dog01.setSzCdIncmgFacilState(incomingFacility.getCdIncmgFacilState());
      rowcinv10dog01.setSzCdIncmgFacilType(incomingFacility.getCdIncmgFacilType());
      rowcinv10dog01.setSzNbrIncmgFacilPhone(incomingFacility.getNbrIncmgFacilPhone());
      rowcinv10dog01.setSzNbrIncmgFacilPhoneExt(incomingFacility.getNbrIncmgFacilPhoneExt());
      rowcinv10dog01.setSzNmUnitWard(incomingFacility.getNmIncmgFacilUnitWard());
      rowcinv10dog01.setSzNmIncmgFacilAffiliated(incomingFacility.getNmIncmgFacilAffiliated());
      rowcinv10dog01.setBIndIncmgOnGrnds(incomingFacility.getIndIncmgFacilOffGrnds());
      rowcinv10dog01.setSzTxtFacilCmnts(incomingFacility.getTxtIncomingFacilCmnts());
      rowcinv10dog01.setSzNmIncmgFacilSuprtdant(incomingFacility.getNmIncmgFacilSuprtdant());
      rowcinv10dog01.setNmIncmgFacilName(incomingFacility.getNmIncmgFacilName());
    }
    return rowcinv10dog01;
  }
  
  /**
   * //SMS#51977 MR-066 This method retrieves CPS Investigation Conclusion Resource from Intake .
   * 
   * @param idStage
   * @return
   * @throws ServiceException
   */
  private ROWCINV10DOG01 RetrieveCpsInvstDetailResourceFromIntake(int idStage) throws ServiceException {
    ROWCINV10DOG01 rowcinv10dog01 = new ROWCINV10DOG01();
    int idIntakeStage = 0;
    Integer idPreviousStageObj = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
    if(idPreviousStageObj != null){
      int idPreviousStage = idPreviousStageObj;
      Stage previousStage = stageDAO.findStageByIdStage(idPreviousStage);
      if(CodesTables.CSTAGES_DIV.equals(previousStage.getCdStage())){
        Integer idIntakeStageObj = stageLinkDAO.findPreviousIdStagebyIdStage(idPreviousStage);
        if(idIntakeStageObj != null){
          idIntakeStage = idIntakeStageObj;
        }
      }else{
        idIntakeStage = idPreviousStage;
      }
      IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(idIntakeStage);
      if(incomingFacility != null){
        //SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
        rowcinv10dog01.setSzAddrIncmgFacilCity(incomingFacility.getAddrIncmgFacilCity());
        rowcinv10dog01.setSzCdIncFacilOperBy(incomingFacility.getCdIncmgFacilOperBy());
        rowcinv10dog01.setBIndIncmgFacilAbSupvd(incomingFacility.getIndIncmgFacilAbSupvd());
        rowcinv10dog01.setBIndIncmgFacilSearch(incomingFacility.getIndIncmgFacilSearch());
        rowcinv10dog01.setSzAddrIncmgFacilStLn1(incomingFacility.getAddrIncmgFacilStLn1());
        rowcinv10dog01.setSzAddrIncmgFacilStLn2(incomingFacility.getAddrIncmgFacilStLn2());
        rowcinv10dog01.setSzAddrIncmgFacilZip(incomingFacility.getAddrIncmgFacilZip());
        rowcinv10dog01.setSzCdIncmgFacilCnty(incomingFacility.getCdIncmgFacilCnty());
        rowcinv10dog01.setSzCdIncmgFacilState(incomingFacility.getCdIncmgFacilState());
        rowcinv10dog01.setSzCdIncmgFacilType(incomingFacility.getCdIncmgFacilType());
        rowcinv10dog01.setSzNbrIncmgFacilPhone(incomingFacility.getNbrIncmgFacilPhone());
        rowcinv10dog01.setSzNbrIncmgFacilPhoneExt(incomingFacility.getNbrIncmgFacilPhoneExt());
        rowcinv10dog01.setSzNmUnitWard(incomingFacility.getNmIncmgFacilUnitWard());
        rowcinv10dog01.setSzNmIncmgFacilAffiliated(incomingFacility.getNmIncmgFacilAffiliated());
        rowcinv10dog01.setBIndIncmgOnGrnds(incomingFacility.getIndIncmgFacilOffGrnds());
        rowcinv10dog01.setSzTxtFacilCmnts(incomingFacility.getTxtIncomingFacilCmnts());
        rowcinv10dog01.setSzNmIncmgFacilSuprtdant(incomingFacility.getNmIncmgFacilSuprtdant());
        rowcinv10dog01.setNmIncmgFacilName(incomingFacility.getNmIncmgFacilName());
        CapsResource capsResource = incomingFacility.getCapsResource();
        if (capsResource != null) {
          rowcinv10dog01.setUlIdResource(capsResource.getIdResource());
          rowcinv10dog01.setSzCdRsrcType(capsResource.getCdRsrcFacilType());
          rowcinv10dog01.setSzNmResource(capsResource.getNmResource());
        }
      }
    }
    return rowcinv10dog01;
  }

  public ROWCCMN45DO retrieveEvent(int idEvent) throws ServiceException {
    // CallCCMN45D
    // Given ID EVENT, query the EVENT table and obtain the CD EVENT STATUS
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Populate Output Message, this information will be returned all the way
    // back to the window that called the service
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

  private org.exolab.castor.types.Date findEarliestContactDate(int idStage,
                                                               org.exolab.castor.types.Date cinv14soDtCPSInvstDtlBegun)
                                                                                                                       throws ServiceException {
    // CallCSYS15D
    // Given ID STAGE, query the CONTACT table and obtain date of
    // the earliest contact recorded
    org.exolab.castor.types.Date newDtCPSInvstDtlBegun = cinv14soDtCPSInvstDtlBegun;
    Date dtContactOccurred = contactDAO.findEarliestDtContactOccurredByIdStage(idStage);
    if (dtContactOccurred == null) {
      if (DateHelper.isNull(cinv14soDtCPSInvstDtlBegun)) {
        throw new ServiceException(Messages.MSG_INV_NOT_BEGUN);
      }
    }
    // If the date returned from the DAM is NULL_DATE, then an initial contact
    // has not been performed to begin an investigation, so a warning message
    // should be returned to the client
    // converted cases will not have contacts. Thus, if this DAM returns
    // null_date and a DtlBegun already has a value in the output message,
    // we should NOT return an error.
    if (DateHelper.isNull(dtContactOccurred) && DateHelper.isNull(cinv14soDtCPSInvstDtlBegun)) {
      // CASE 1: A case created using CAPS & no contact is recorded
      throw new ServiceException(Messages.MSG_INV_NOT_BEGUN);
    } else if (!DateHelper.isNull(dtContactOccurred)) {
      // CASE 2: A case created using CAPS & a contact was found
      newDtCPSInvstDtlBegun = DateHelper.toCastorDate(dtContactOccurred);
    }
    // else DtInvstDtlBegun was populated from CINV10D
    return newDtCPSInvstDtlBegun;
  }

  //STGAP00017781: Added this new method to get the date response was met.
  private org.exolab.castor.types.Date findDateResponseMet(int idStage) {
	List<Integer> victims = new ArrayList<Integer>();
	IncomingDetail intake = null;
	Stage intakeStage = null;
	int idCase = 0;
	Date intakeDate = null;
	Date responseMetDate = null;
	List<String> methods = new ArrayList<String>();
	int victimsCount = 0;
	int victimsMet = 0;
	methods.add(CodesTables.CCNTMETH_ATF);
	methods.add(CodesTables.CCNTMETH_UTF);

	intake = incomingDetailDAO.findIncomingDetailFromAnyIdStage(idStage);
	if (intake != null) {
		intakeDate = intake.getDtIncomingCall();
		intakeStage = stageDAO
				.findStageByIdStage(intake.getIdStage() != null ? intake
						.getIdStage() : 0);
		if (intakeStage != null) {
			idCase = intakeStage.getCapsCase().getIdCase();
		}
	}

	victims = allegationDAO.findPersonByIdVictimByIdStage(idStage);
	if (victims != null && !victims.isEmpty()) {
		for (Iterator<Integer> It = victims.iterator(); It.hasNext();) {
			victimsCount++;
			Integer victimId = It.next();
			if (intakeDate != null) {
				Date mostRecentCMChildVisit = contactDAO
				.findMostRecentCaseManagerChildVisit(
						victimId.intValue(), idCase, methods, intakeDate);
				if(mostRecentCMChildVisit != null) victimsMet++;
				if (responseMetDate == null) {
					responseMetDate = mostRecentCMChildVisit;
				} else {
					if (mostRecentCMChildVisit != null
							&& responseMetDate.before(mostRecentCMChildVisit)) {
						responseMetDate = mostRecentCMChildVisit;
					}
				}
			}
		}
	}
	if(victimsCount == 0 && intakeDate != null) {
		return DateHelper.toCastorDate(intakeDate);
	} else if (victimsCount != 0 && victimsCount == victimsMet) {
		return DateHelper.toCastorDate(responseMetDate);
	}
	return null;
  }

  private ROWCINV14DOG00 retrieveAllegationInformation(int cinv14siIdStage) throws ServiceException {
    // CallCINV14D
    ROWCINV14DOG00 rowcinv14dog00 = new ROWCINV14DOG00();
    Object[] riskAssessment = riskAssessmentDAO.findRiskAssessmentRiskFactorByIdStage(cinv14siIdStage);
    if (riskAssessment != null) {
      // Populate Output Message, this information will be returned all the way
      // back to the window that called the service
      int idEvent = (Integer) riskAssessment[0];
      Date dtLastUpdate = (Date) riskAssessment[1];
      int idStage = (Integer) riskAssessment[2];
      String cdRiskAssmtApAccess = (String) riskAssessment[3];
      String cdRiskAssmtPurpose = (String) riskAssessment[4];
      String cdRiskAssmtRiskFind = (String) riskAssessment[5];
      String indRiskAssmtIntranet = (String) riskAssessment[6];
      String cdRiskFactorCateg = (String) riskAssessment[7];
      rowcinv14dog00.setUlIdEvent(idEvent);
      rowcinv14dog00.setUlIdStage(idStage);
      rowcinv14dog00.setTsLastUpdate(dtLastUpdate);
      rowcinv14dog00.setCdRiskAssmtPurpose(cdRiskAssmtPurpose);
      rowcinv14dog00.setSzCdRiskAssmtRiskFind(cdRiskAssmtRiskFind);
      rowcinv14dog00.setSzCdRiskAssmtApAccess(cdRiskAssmtApAccess);
      rowcinv14dog00.setCIndRiskAssmtIntranet(indRiskAssmtIntranet);
      rowcinv14dog00.setSzCdRiskFactorCateg(cdRiskFactorCateg);
      if (0 != idEvent) {
        // Null value is used for String, date, array parameters not set by the service
        // 0 value is used for int parameters not set by the service
        String[] eventTypes = { CodesTables.CEVNTTYP_ASM };
        // This call will also handle the message MSG_INSUFF_DATA_FOR_EVENT_LIST
        // Call CCMN87D
        List<Object[]> events = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, eventTypes, null, null, null,
                                                           null, null);
        if (events != null) {
          for (Iterator<Object[]> it = events.iterator(); it.hasNext();) {
            Object[] event = it.next();
            String cdEventStatus = (String) event[0];
            String cdTask = (String) event[11];
            // If event is Risk Assessment (has Task = 2290) and not COMP, PEND, or APRV return NULL
            // Need to check if the task is Risk Assessment (2290) or Intranet Risk Assessment (2295).
            if ((RISK_ASSMNT_TASK.equals(cdTask) || IRA_ASSMT_TASK.equals(cdTask))
                && !(CodesTables.CEVTSTAT_COMP.equals(cdEventStatus) || CodesTables.CEVTSTAT_PEND.equals(cdEventStatus) || CodesTables.CEVTSTAT_PEND
                                                                                                                                                    .equals(cdEventStatus))) {
              rowcinv14dog00.setSzCdRiskAssmtRiskFind(StringHelper.EMPTY_STRING);
              break;
            }
          } // End for loop
        }
      } // End if idEvent != 0
    }
    return rowcinv14dog00;
  }

  private Date retrieveNarrativeInfo(String indRiskAssmtIntranet, int idEvent) {
    // CallCSYS13D
    // Retrieves a record from the RISK_ASSMT_NARR table. If
    // a record exists, it may indicate that there is a narrative
    // already started and associated with the Risk Assessment
    // for the ID STAGE given as input to the service
    // Check the Intranet indicator. If the asmt was created via the
    // Intranet ('Y'), then we want to query the new IRA_NARRATIVE table.
    // Otherwise, it was an old Risk Asmt and we will query the old
    // RISK_ASSMT_NARR table.
    String sysTxtTablename = null;
    if (ArchitectureConstants.Y.equals(indRiskAssmtIntranet.substring(0, 1))
        || INDICATOR_IMPACT.equals(indRiskAssmtIntranet.substring(0, 1))) {
      sysTxtTablename = IRA_NARRATIVE;
    } else {
      sysTxtTablename = RISK_ASSMT_NARR;
    }
    return commonDAO.findDtLastUpdate(sysTxtTablename, idEvent);
  }

  private ROWCINV14SOG00 retrieveStageInfo(int idStage) {
    // CallCINT40D
    // This function calls the CINT40D DAM which retrieves a
    // full row from the STAGE table based on an ID_STAGE given as input
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCINV14SOG00 rowcinv14sog00 = new ROWCINV14SOG00();
    rowcinv14sog00.setUlIdStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
    rowcinv14sog00.setTmSysTmStageClose(FormattingHelper.formatTime(stage.getDtStageClose()));
    rowcinv14sog00.setTmSysTmStageStart(FormattingHelper.formatTime(stage.getDtStageStart()));
    rowcinv14sog00.setUlIdUnit(stage.getUnit() != null ? stage.getUnit().getIdUnit() : 0);
    rowcinv14sog00.setBIndStageClose(stage.getIndStageClose());
    rowcinv14sog00.setSzNmStage(stage.getNmStage());
    rowcinv14sog00.setSzCdStage(stage.getCdStage());
    rowcinv14sog00.setSzCdStageClassification(stage.getCdStageClassification());
    rowcinv14sog00.setSzCdStageCnty(stage.getCdStageCnty());
    rowcinv14sog00.setSzCdStageCurrPriority(stage.getCdStageCurrPriority());
    rowcinv14sog00.setSzCdStageInitialPriority(stage.getCdStageInitialPriority());
    rowcinv14sog00.setSzCdStageProgram(stage.getCdStageProgram());
    rowcinv14sog00.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
    rowcinv14sog00.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
    rowcinv14sog00.setDtDtStageStart(DateHelper.toCastorDate(stage.getDtStageStart()));
    rowcinv14sog00.setUlIdCase(stage.getCapsCase() != null ? stage.getCapsCase().getIdCase() : 0);
    rowcinv14sog00.setUlIdSituation(stage.getSituation() != null ? stage.getSituation().getIdSituation() : 0);
    rowcinv14sog00.setSzTxtStageClosureCmnts(stage.getTxtStageClosureCmnts());
    rowcinv14sog00.setSzTxtStagePriorityCmnts(stage.getTxtStagePriorityCmnts());
    rowcinv14sog00.setSzCdStageRegion(stage.getCdStageRegion());
    rowcinv14sog00.setSzCdStageRsnPriorityChgd(stage.getCdStageRsnPriorityChgd());
    rowcinv14sog00.setSzCdStageType(stage.getCdStageType());
    rowcinv14sog00.setTsLastUpdate(stage.getDtLastUpdate());
    return rowcinv14sog00;
  }

  /**
   * Updates ROWCINV10DOG00 object contained in the cinv14so ouput structure.
   * 
   * @param idStage
   * @param rowcinv10dog00
   * @throws ServiceException
   */
  private void retrieveEarliestIntakeDate(int idStage, ROWCINV10DOG00 rowcinv10dog00) throws ServiceException {
    // CallCLSC84D. Retrieves information for the Call Entry window. - Replaced in STGAP00009311
    /**
     * STGAP00009311 - New DAO to look for Intake stage in both cases: INT progresses directly to INV or INT to DIV and
     * then DIV to INV. Removed the setUlIdPriorStage code since this value is not being used, also to be consistent
     * with added logic in the main service that if Intake date already exists in CPS_Invst_Detail table, no need to
     * call this function. Removed Exception SQL_NOT_FOUND when no rows return. Even though it is wrong to not have an
     * Intake date at this point, rather display a blank date field than an error page. Especially, this date is just
     * for display, not to be used in any other calculation.
     */
    Date dtIncomingCall = incomingDetailDAO.findDtIncomingCallByIdInvStage(idStage);
    if (dtIncomingCall != null) {
      rowcinv10dog00.setDtDtCPSInvstDtlIntake(dtIncomingCall);
    }
  }

  private String checkAllegationForAbuse(int idStage) {
    // CallCINVD3D
    // Given Id_stage query Allegation table and check
    // if any allegation is for Physical or Sexual abuse.
    String indPhabSxabAllegExist = ArchitectureConstants.N;
    Integer idAllegation = allegationDAO.findPhSxAbIdAllegationByIdStage(idStage);
    if (idAllegation != null && 0 != idAllegation.intValue()) {
      indPhabSxabAllegExist = ArchitectureConstants.Y;
    }
    return indPhabSxabAllegExist;
  }

  private String checkAllegationForSub(int idStage) {
    // STGAP00003259 if there is a single substantiated allegation disposition for the Stage then the Maltreatment
    // Finding should be substantiated.

    String indSubstantiatedAlleg = ArchitectureConstants.N;

    List<Map> allegationsList = allegationDAO.findAllegationFacilAllegFullVictimFullAllegPerpetrator(idStage, PAGENBR,
                                                                                                     PAGESIZE);
    if (allegationsList != null && !allegationsList.isEmpty()) {
      for (Iterator<Map> it = allegationsList.iterator(); it.hasNext();) {
        Map map = it.next();
        if (CodesTables.CDISPSTN_SUB.equals(map.get("cdAllegDisposition"))) {
          indSubstantiatedAlleg = ArchitectureConstants.Y;
        }
      }
      return indSubstantiatedAlleg;
    }

    String indPhabSxabAllegExist = ArchitectureConstants.N;
    Integer idAllegation = allegationDAO.findPhSxAbIdAllegationByIdStage(idStage);
    if (idAllegation != null && 0 != idAllegation.intValue()) {
      indPhabSxabAllegExist = ArchitectureConstants.Y;
    }
    return indPhabSxabAllegExist;
  }

  // private int retrievePrincipalInformation(int idStage) {
  private Integer retrievePrincipalInformation(int idStage) {
    // CallCINT20D
    // Given Id_stage,query stage_person_link table and return
    // the number of row containing principals with role of UK.
    Integer rowQty = null;
    StagePersonLink stagePersonlink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                               idStage,
                                                                                                               CodesTables.CINTROLE_UK,
                                                                                                               CodesTables.CPRSNTYP_PRN);
    if (stagePersonlink != null) {
      // ArchOutputStruct archOutputStruct= new ArchOutputStruct();
      // Set fields in CINV14SO to fields in StagePersonLink
      if (0 != stagePersonlink.getPerson().getIdPerson()) {
        rowQty = NUMBER;
      } else {
        rowQty = 0;
      }
    }
    return rowQty;
  }

  private String RetrievePrincipalsWithUnknownGender(int idStage) {
    // CLSC18D
    // This DAO will retrieve a list of principals in the home
    // and data about these people using Id Stage from input.
    String indPrnUk = ArchitectureConstants.N;
    boolean isUnknownName = false;
    List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO
                                                               .findAllPrincipalsLinkedToStage(idStage,
                                                                                               CodesTables.CPRSNTYP_PRN);

    if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {
      for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
        // Reset isUnknownName for each person in the loop
        isUnknownName = false;
        StagePersonLink stagePersonLink = it.next();
        // Check to see if the name is unknown. Unknown names are defined
        // as system generated unknown names. System generated unknown names
        // populate the full name of a person with Unknown # (being either a
        // number from 1-9 or a person id). The first and last name fields will
        // be left blank. Therefore, if the first and last names are blank, then
        // the name is system generated, so set the unknown name flag to true.
        if (stagePersonLink.getPerson().getNmPersonFirst() == null
            && stagePersonLink.getPerson().getNmPersonLast() == null) {
          isUnknownName = true;
        }
        // check to see if the PRN has an unknown gender or an appx DOB
        // If the gender is unknown and they are not an unknown
        // person set bIndPrnUk to "Y" and break out of the function
        if ((CodesTables.CSEX_U.equals(stagePersonLink.getPerson().getCdPersonSex()) || ArchitectureConstants.Y
                                                                                                               .equals(stagePersonLink
                                                                                                                                      .getPerson()
                                                                                                                                      .getIndPersonDobApprox()))
            && !isUnknownName) {
          indPrnUk = ArchitectureConstants.Y;
          break;
        }
      }
    }
    return indPrnUk;
  }

  private String checkCasePending(int idCaseMergeFromTo) {
    // CallCheckCasePending
    // this function checks for case pending
    // get the records from case_merge table for case_merge_to id
    // CallCLSC68D
    boolean localCasePending = false;
    // CallCLSC68D
    localCasePending = retrieveCaseMergeByIdCaseMergeTo(idCaseMergeFromTo, localCasePending);
    // No need to check further if we already know that the case is pending merge
    if (!localCasePending) {
      // get the records from case_merge table as case_merge_from id
      // CallCLSC67D
      localCasePending = retrieveCaseMergeByIdCaseMergeFrom(idCaseMergeFromTo, localCasePending);
    }
    String indCaseMergePending = ArchitectureConstants.N;
    if (localCasePending) {
      indCaseMergePending = ArchitectureConstants.Y;
    }
    return indCaseMergePending;
  }

  private boolean retrieveCaseMergeByIdCaseMergeTo(int idCaseMergeTo, boolean localCasePending) {
    // CallCLSC68D
    // Retreive all rows from CASE_MERGE where ID_CASE is
    // found in the column ID_CASE_MERGE_From
    List<CaseMerge> caseMerges = caseMergeDAO.findByIdCaseMergeTo(idCaseMergeTo);
    if (caseMerges != null && caseMerges.size() > 0) {
      for (Iterator<CaseMerge> it = caseMerges.iterator(); it.hasNext();) {
        CaseMerge caseMerge = it.next();
        if (INDICATOR_IMPACT.equals(caseMerge.getIndCaseMergePending())) {
          localCasePending = true;
        }
      }
    }
    return localCasePending;
  }

  private boolean retrieveCaseMergeByIdCaseMergeFrom(int idCaseMergeFrom, boolean localCasePending) {
    // CallCLSC67D
    // Retreive all rows from CASE_MERGE where ID_CASE is
    // found in the column ID_CASE_MERGE_From
    List<CaseMerge> caseMerges = caseMergeDAO.findByIdCaseMergeFrom(idCaseMergeFrom);
    if (caseMerges != null && caseMerges.size() > 0) {
      for (Iterator<CaseMerge> it = caseMerges.iterator(); it.hasNext();) {
        CaseMerge caseMerge = it.next();
        if (INDICATOR_IMPACT.equals(caseMerge.getIndCaseMergePending())) {
          localCasePending = true;
        }
      }
    }
    return localCasePending;
  }

  /*
   * Given an employee id return the employee's supervisor's ID
   */
  private int retrieveEmployeeSupervisorID(String idPersonEmployee) {
    int idSupervisor = 0;
    if (idPersonEmployee != null && idPersonEmployee.trim().length() > 0) {
      idSupervisor = retrieveEmployeeSupervisorID(Integer.valueOf(idPersonEmployee));
    }
    return idSupervisor;
  }

  /*
   * Given an employee id return the employee's supervisor's ID
   */
  private int retrieveEmployeeSupervisorID(int idPersonEmployee) {
    Integer idSupv = 0;

    List<Map> empJobHistoryList = empJobHistoryDAO.findEmpJobHistoryByIdPerson(idPersonEmployee);
    if (empJobHistoryList == null || empJobHistoryList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // loop through employee's job history, locate the latest job, and retrieve the employee's supervisor id
    // in SHINES, there is only one row returned, so we get the supervisor from there.
    for (Iterator<Map> it = empJobHistoryList.iterator(); it.hasNext();) {

      Map empJobHistoryMap = it.next();
      idSupv = ((Integer) empJobHistoryMap.get("personByIdJobPersSupv") != null ? (Integer) empJobHistoryMap
                                                                                                            .get("personByIdJobPersSupv")
                                                                               : 0);

    }
    return idSupv.intValue();
  }
}
