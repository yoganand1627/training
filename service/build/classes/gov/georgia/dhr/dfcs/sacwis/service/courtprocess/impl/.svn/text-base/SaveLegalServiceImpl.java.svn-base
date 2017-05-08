package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsAdoptionHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveCsupChildleftcare;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.DeleteLegalService;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.SaveLegalService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.UpdateClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB46SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupChildleftcareSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB46SO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*** Change History:
  **  Date        User              Description
  **  --------    ----------------  --------------------------------------------------
  **  4/4/2008  Corey Harden        STGAP00007558: Changed code so that the case Id was being used to search for
  *                                 the date of the legal status instead of the person Id and also 
  *                                 called a new method created in legalStatusDAOImpl
  *   6/3/2008  Stephen Roberts     STGAP00004587:  Modified callLegalStatus() so that it handles updates.  Specifically,
  *                                 CapsCase was set into the legalStatus object to prevent the ID_CASE column from nulling out
  *                                 on update.
  *  7/25/2008  Stephen Roberts     STGAP00009650: Modified callLegalStatus() so that duplicate persistent objects are not created 
  *                                 on SMILE validation.  Additionally changed logic so that the most recent legal status will
  *                                 trigger the SMILE interface.
  *  10/16/2008 ssubram             STGAP00010693: Added Alert when new legal status entered for a Child in ADO stage
  *  
  *  01/19/2009 ssubram             STGAP00012034: alert needs to be sent even in the SUB case if there is an open ADO stage.
  *   1/22/2009 charden             STGAP00010294: wrote code to to keep multiple legal statuses from being generated on the same day
  *                                 for child who is in two different cases
  *  03/04/2009 bgehlot             STGAP00012734: Added two new methods updateStageCounty() and isGACounty() for MR-019. 
  *  06/01/2009 bgehlot             STGAP00013991:  The FCF stage county should only be updated when the legal county 
  *                                 change is made within an FCC (SUB) or ADO stage.  
  *  06/17/09   hjbaptiste          STGAP00014257: Modified callLegalStatus() so that once the Legal Status is saved in ADO or PAD, 
  *                                 there's a check to see if it's Adoption Finalized. If it is, free up an open slot for the 
  *                                 home where this child is placed
  *  07/22/09   hjbaptiste          STGAP00014781: Send alert to Regional Adoption Exchange consultants and RACs when legal status is
  *                                 changed to Not in DFCS Custody - Adoption Finalized      
  *  08/30/09   arege               STGAP00014993: When a legal status is changed to a particular legal status a row should be inserted in the
  *                                 CSUP_CHILDLEFTCARE_OUTBOUND table.  
  *  09/04/09   arege               STGAP00014993: Modified findOpenOrClosedPlacementLatestApprovedByIdPerson function call.                       
  *  10/29/09   vdevarak            SMS#39011: Modified code to avoid system error on update of legal status record   
  *  04/14/10   arege               SMS#49744  unable to delete invalid court order, custody expiration dates and Petition/Motion Due Date   
  *  08/05/10   bgehlot             SMS #65398 MR-041 Also send alert to Regional Accounting, Rev Max, Adoption Assistance Specialists when adoption
  *                                 is Finalized.  Set the stage to clientOutboundSaveSI object.    
  *  11/09/10   htvo                SMS#81140 - MR-074 AFCARS: added validations
  *                                 a) LS for child back in care after being discharged must be recorded in a new case by prevent user from recording in-DFCS LS 
  *                                 in the same case that the child was discharged from
  *                                 b) AFCARS discharge date to be on the same day or after removal date
  *                                 c) Cannot save an in-DFCS custody LS for child already discharged in the same FC episode
  *                                 d) Ensure parental right(s) is terminated/surrender or parent(s) deceased when recording a Permanent 
  *                                 Custody or Adoption Finalized (not ICPC) legal status.
  *  12/08/10   htvo                SMS#86006: Fix TPR/VS/DOD in performValidationForPermanentCustodyAndNAF() to treat no DOD as false and fail validation 
  *                                 New requirement: Include JCP - Join Commitment With DJJ - Permanent Court in performValidationForPermanentCustodyAndNAF
  *  1/5/11     htvo                SMS#89237: allow new in-DFCS to be entered in the same case if it is a new FC episode, except for children
  *                                 18+ signing themselves back into care (temporary voluntary LS) it can be in the same FC episode
  *                                 SMS#90085: modified the AFCARS discharge LS logic to not require an in-DFCS before a not-in-DFCS
  *                                 in the validation 'discharge date cannot be before removal date'
  *  1/20/11    htvo                SMS92672#: additional exceptions for SMS#90085: not validate for ICPC children b/c they don't have removal page
  *  3/15/11    htvo                SMS#87845 MR-074-2 AFCARS: 
  *                                 - require proper agreement before allowing Adoption Finalized;
  *                                 - update TPR validation for Permanent Custody and Adoption Finalized
  *                                 - send alert to Permanency Unit when an Adoption Finalized LS for child previously reported to 
  *                                 AFCARS was modified.      
  *  4/4/11     htvo                SMS#104219: find PEND AA Application in the case    
  *  4/7/11     htvo                SMS#104523: use the indicator of rate type radio selection since the monthly amount is not always persisted in DB for AA app
  *  4/11/11    htvo                SMS#87845 MR-074-2 AFCARS: client request: it is ok to finalize non-incident PAD if there is no active monthly agreement
  *                                 if there is no approved or deferred app. Simplified and made similar logic between non-incident and incident consistent.
  *  04/21/11   schoi               SMS #106480: MR-074-2 Replaced rowcsub46sig00.getUlIdEvent() to rowcsub46sig00.getUlIdLegalStatEvent() 
  *                                 to generate the alert to the Permanency Unit correctly; 
  *                                 rowcsub46sig00.setUlIdEvent() never been set in the LegalStatusConversation.java
  *                                                                                                                        
  *                                                                       
  */

public class SaveLegalServiceImpl extends BaseServiceImpl implements SaveLegalService {

  public static final String TODO_INFO_CODE = "SUB026";

  public static final String CONSERV_STATUS = CodesTables.CSRCHSTA_C;

  public static final int STAGE_CLOSURE = 1;

  public static final String CARE_CUST_CNTL = CodesTables.CSRCKLST_010;

  public static final String TMC = CodesTables.CSRCKLST_020;

  public static final String PMC_RTS_NOT_TERM = CodesTables.CSRCKLST_030;

  public static final String PMC_RTS_TERM = CodesTables.CSRCKLST_040;

  public static final String PMC_RTS_TERM_BIO = CodesTables.CSRCKLST_050;

  public static final String PMC_RTS_TERM_LEG = CodesTables.CSRCKLST_060;

  public static final String PMC_RTS_TERM_MOTHER = CodesTables.CSRCKLST_070;

  public static final String OTHER_LEGAL = CodesTables.CSRCKLST_080;

  public static final String POSS_CONSERVATOR = CodesTables.CSRCKLST_130;

  public static final String ADOPT_CONSUMM = CodesTables.CSRCKLST_090;

  public static final String CHILD_EMAN = CodesTables.CSRCKLST_100;

  public static final String PRS_RESP_TERM = CodesTables.CSRCKLST_120;

  public static final String CVS_NOT_OBT = CodesTables.CSRCKLST_150;

  public static final String PRIV_AGENCY_ADPT_HOME1 = CodesTables.CPLLAFRM_71;

  public static final String FPS_FA_HOME1 = CodesTables.CPLLAFRM_70;

  public static final String PERS_ROLE_PR = CodesTables.CSTFROLS_PR;

  // When a PERS_ROLE_ILP_C staff is created replace the value of "PERS_ROLE_ILP_C" with the value in the CodesTable
  public static final String PERS_ROLE_ILP_C = "ILP_COORDINATOR";

  public static final String LS_TVL = CodesTables.CLEGSTAT_TVL;

  public static final String LS_ILP = CodesTables.CLEGSTAT_ILP;

  public static final String LS_PCT = CodesTables.CLEGSTAT_PCT;

  public static final String LS_PVL = CodesTables.CLEGSTAT_PVL;
  
  private static final String LEGAL_STATUS = "Legal Status";
  
  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;
    
  private CheckStageEventStatus checkStageEventStatus = null;
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  private EventDAO eventDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private LegalStatusDAO legalStatusDAO = null;
  
  private LegalActionDAO legalActionDAO = null;

  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private StageDAO stageDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private TodoDAO todoDAO = null;

  private FccpChildDAO fccpChildDAO = null;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EmployeeDAO employeeDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private UpdateClientOutbound updateClientOutbound = null;
  
  private PlacementDAO placementDAO = null;
  
  private CapsResourceDAO capsResourceDAO = null;
  
  private SaveCsupChildleftcare saveCsupChildleftcare = null;
  
  private EligibilityDAO eligibilityDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
	this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  
  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
	this.legalActionDAO = legalActionDAO;
}

public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setUpdateClientOutbound(UpdateClientOutbound updateClientOutbound) {
    this.updateClientOutbound = updateClientOutbound;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setSaveCsupChildleftcare(SaveCsupChildleftcare saveCsupChildleftcare) {
    this.saveCsupChildleftcare = saveCsupChildleftcare;
  }
  
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  
  public CSUB46SO saveLegalService(CSUB46SI csub46si) throws ServiceException {

    boolean bIndEvent = true;
    CSUB46SO csub46so = new CSUB46SO();

    ROWCSUB46SIG00 rowcsub46sig00 = csub46si.getROWCSUB46SIG00();
    ROWCCMN01UIG00 rowccmn01uig00 = csub46si.getROWCCMN01UIG00();

    int idPerson = rowcsub46sig00.getUlIdPerson();
    int idStage = csub46si.getUlIdStage();
    int idEvent_ccmn01 = rowccmn01uig00.getUlIdEvent();
    int idEvent_csub46 = rowcsub46sig00.getUlIdEvent();
    int idCase = csub46si.getUlIdCase();
    String cdTask_ccmn01 = rowccmn01uig00.getSzCdTask();

    Date dtLegalStatStatus = DateHelper.toJavaDate(rowcsub46sig00.getDtDtLegalStatStatusDt());

    ArchInputStruct archInputStruct = csub46si.getArchInputStruct();
    String reqFuncCd = archInputStruct.getCReqFuncCd();

    String sysNbrReserved1 = archInputStruct.getUlSysNbrReserved1();

    //STGAP00010294 - do not allow multiple legal statuses to be created for a child on the same day 
    long countByStage = legalStatusDAO.countLegalStatusByDtLegalStatStatusDtByIdCaseIdPerson(idCase, idPerson, dtLegalStatStatus);
    long countByCase = legalStatusDAO.countLegalStatusByDtLegalStatStatusDt(idPerson, dtLegalStatStatus);
    
    if (((0 != (int) countByCase) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)))
        || ((0 < (int) countByCase) && ArchitectureConstants.Y.equals(csub46si.getIndDateModified()) && (ServiceConstants.REQ_FUNC_CD_UPDATE
                                                                                                                                      .equals(reqFuncCd)))) {
      throw new ServiceException(Messages.MSG_DUP_LEG_STAT_DATE);

    } 
    if (((0 != (int) countByStage) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)))
        || ((0 < (int) countByStage) && ArchitectureConstants.Y.equals(csub46si.getIndDateModified()) && (ServiceConstants.REQ_FUNC_CD_UPDATE
                                                                                                                                      .equals(reqFuncCd)))) {
      throw new ServiceException(Messages.MSG_DUP_LEG_STAT_DATE);

    }
    
    // MR-074 AFCARS: various validation to ensure saving/adding a LS does not violate AFCARS business logic 
    // Borrow this up to get stage data
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String cdStage = stage.getCdStage();
    Date dtStageClose = stage.getDtStageClose();
    Person personChild = personDAO.findPersonByIdPerson(idPerson);
    if (personChild == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND); 
    }
    Date personChildDob = personChild.getDtPersonBirth();
    String nmPersonChild = personChild.getNmPersonFull();
    String cdLegalStatusToSave = rowcsub46sig00.getSzCdLegalStatStatus();
    
    if (isFCStage(cdStage) && DateHelper.isNull(dtStageClose)) {
    	// List of in-DFCS custody legal status, a.k.a. 'Y' LS. Any LS not in this list is not-in-DFCS or 'N' LS
	    List<String> inDFCSLegalStatusList = new ArrayList<String>();
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_PCT);// permanent court
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_PVL);// permanent voluntary
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_TCT);// temporary court
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_TVL);// temporary voluntary
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_JCP);// Joint Commitment With DJJ - Permanent Court
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_JCT);// Joint Commitment With DJJ - Temporary Court
	    inDFCSLegalStatusList.add(CodesTables.CLEGSTAT_JCD);// endated - just to be safe: Joint Commitment With DJJ
	    //String cdLegalStatusToSave = rowcsub46sig00.getSzCdLegalStatStatus();
	    LegalStatus currentLegalStatusFromDB; // LS prior to the LS-to-save
	    LegalStatus nextlegalStatusfromDB;    // LS after the LS-to-save
	    boolean inDFCSLegalStatusToSave = inDFCSLegalStatusList.contains(cdLegalStatusToSave) ? true : false;
	    boolean dischargedErrOverride = false;
	    // find the LS prior to the LS-to-save
	    currentLegalStatusFromDB = legalStatusDAO.findPriorLegalStatusByIdPersonIdCaseByDate(idPerson, idCase, dtLegalStatStatus, idEvent_ccmn01);
	    String currentCdLegalStatus = currentLegalStatusFromDB == null ? StringHelper.EMPTY_STRING : currentLegalStatusFromDB.getCdLegalStatStatus();
	    String nextCdLegalStatus = StringHelper.EMPTY_STRING;
	    
	    // If the LS prior to the LS-to-save exists, find the prior to the prior of the LS-to-save 
	    // and perform validation when saving a LS which is not the only LS for the child
	    // 1. Disallow Y-N-Y: 2 scenarios: saving a Y or an N: Y-(N)-Y or Y-N-(Y)
	    // 2. Error when saving a N and effective date < removal date
	    // 3. Error when saving an N and it is NAF-N or N-NAF
	    
	    // SMS#90085: remove the condition that child must be already in care to make the not-in-DFCS LS an AFCARS discharge LS
	    // 2. Find the most recent removal (based off of removal date) prior to 
	    // or on the same day of the LS-to-save effective date
	    Date dtRemoval = cnsrvtrshpRemovalDAO.findDtRemovalByIdPersonIdCaseByDate(idPerson, idCase, dtLegalStatStatus);
	    // SMS#92672: ICPC children will not have custody removal page. Exclude them by 2 below LS: 
	    boolean icpcChild = CodesTables.CLEGSTAT_NOT.equals(cdLegalStatusToSave) || CodesTables.CLEGSTAT_NCS.equals(cdLegalStatusToSave) ? true : false;
	    if (!inDFCSLegalStatusToSave && DateHelper.isNull(dtRemoval) 
	    		&& !icpcChild) 
			throw new ServiceException(Messages.MSG_DISCHARGE_BEFORE_REMOVAL_ERR);
	    
	    if (DateHelper.getAge(personChildDob, dtLegalStatStatus) >= 18 && LS_TVL.equals(cdLegalStatusToSave)) {
	    	dischargedErrOverride = true;
	    }

	    if (StringHelper.isValid(currentCdLegalStatus)) {
		    // 1. [Disallow Y-N-(Y)] Disallow N-(Y) pattern: LS to save is in parenthesis 
		    // saving an in-DFCS custody LS and the LS prior to the to-save-LS is a not-in-DFCS followed by an in-DFCS,
		    // then the child was already discharged, throw error 
		    if (inDFCSLegalStatusToSave && 
		    		(!inDFCSLegalStatusList.contains(currentCdLegalStatus)) &&
		    		// SMS#89237: allow new in-DFCS to be entered in the same case when it was entered in another FC episode, i.e. if there was another removal.
		    		// the most recent removal is before the previous not-in-DFCS custody LS effective date, i.e.
		    		// attempting to record an in-DFCS LS in the same FC episode from which the child was discharged 
		    		(DateHelper.isBefore(dtRemoval, currentLegalStatusFromDB.getDtLegalStatStatusDt())) &&
		    		(!dischargedErrOverride) // child over 18 signing themselves back into care exempted
		    		) {
		    	throw new ServiceException(Messages.MSG_CHILD_WAS_DISCHARGED_ERR);    
		    }
		
		    // Disallow a discharge where the effective date is before removal date
		    // find a removal event for this foster care episode where removal date is prior to 
		    // or on the same day of the LS-to-save effective date
		    //Date dtRemoval = cnsrvtrshpRemovalDAO.findDtRemovalByIdPersonIdCaseByDate(idPerson, idCase, dtLegalStatStatus);
		    // if LS-to-save is a not-in-DFCS and 
		    if (!inDFCSLegalStatusToSave) {
		        nextlegalStatusfromDB = legalStatusDAO.findNextLegalStatusByIdPersonIdCaseByDate(idPerson, idCase, dtLegalStatStatus, idEvent_ccmn01);
		        nextCdLegalStatus = nextlegalStatusfromDB == null ? StringHelper.EMPTY_STRING : nextlegalStatusfromDB.getCdLegalStatStatus();
	    		// 1. ensure that saving this not-in-DFCS would not fall under Y-(N)-Y pattern    		
		    	if (inDFCSLegalStatusList.contains(currentCdLegalStatus) && 
		    			// SMS#89237: the most recent removal is before the to-save not-in-DFCS custody LS effective date, 
		    			// causing the following in-DFCS to be
			    		//  in the same FC episode from which the child was discharged
		    			(DateHelper.isAfter(dtRemoval, currentLegalStatusFromDB.getDtLegalStatStatusDt()))) {
			        // if there is a in-DFCS before and after LS-to-save, it is Y-(N)-Y pattern, throw error
			        if (StringHelper.isValid(nextCdLegalStatus) && inDFCSLegalStatusList.contains(nextCdLegalStatus) &&
			        		(!dischargedErrOverride)) // child over 18 signing themselves back into care exempted
			        	throw new ServiceException(Messages.MSG_CHILD_WAS_DISCHARGED_ERR);   
		    	}
		        // Disallow removing a child from care when the child is not in care. Split the condition for easy reading.
		        // Note, if the N LS is the only one, no validation as of current business.
		        // Disallow N-(NAF) or (NAF)-N when saving a NAF 
		        if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatusToSave) && 
		        		(!inDFCSLegalStatusList.contains(currentCdLegalStatus) || 
		        				(StringHelper.isValid(nextCdLegalStatus) && !inDFCSLegalStatusList.contains(nextCdLegalStatus)))) {
		        	throw new ServiceException(Messages.MSG_DUP_NOT_IN_DFCS_ERR);
		        }
		        // Disallow (N)-NAF or NAF-(N) when saving a N
		        else if (!inDFCSLegalStatusList.contains(cdLegalStatusToSave) && 
		        		(CodesTables.CLEGSTAT_NAF.equals(currentCdLegalStatus) || 
		        		 CodesTables.CLEGSTAT_NAF.equals(nextCdLegalStatus))) {
		        	throw new ServiceException(Messages.MSG_DUP_NOT_IN_DFCS_ERR);
		        }
		    } // end if (!inDFCSLegalStatusToSave): the LS-to-save is a N
	    } // end if (StringHelper.isValid(currentCdLegalStatus)): the LS to save is not the only LS
	    
	    // after all, if saving Permanent Custody or NAF LS, make sure the child is free
	    if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatusToSave) || 
	    		CodesTables.CLEGSTAT_PCT.equals(cdLegalStatusToSave) ||
	    		CodesTables.CLEGSTAT_PVL.equals(cdLegalStatusToSave) || 
	    		CodesTables.CLEGSTAT_JCP.equals(cdLegalStatusToSave)) {
	    	// Exception thrown from the validation method if failed
	    	performValidationForPermanentCustodyAndNAF(csub46si);
	    }
    } // end FC stage and stage open
    
    // SMS#87845 MR-074-2 AFCARS: additional validation when saving Adoption Finalized
    // if Adoption Finalized entered in any of the stages ADO, FCC, or PAD 
    if ((CodesTables.CSTAGES_ADO.equals(stage.getCdStage()) 
                    || CodesTables.CSTAGES_SUB.equals(stage.getCdStage()) || 
                    CodesTables.CSTAGES_PAD.equals(stage.getCdStage())) && 
                    CodesTables.CLEGSTAT_NAF.equals(cdLegalStatusToSave)) {
      performAdoptionAssistanceValidationForNAF(csub46si);
    }

  

/*    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String cdStage = stage.getCdStage();
    Date dtStageClose = stage.getDtStageClose();
*/   
    if ((!DateHelper.isNull(dtStageClose)) && (DateHelper.MAX_JAVA_DATE != dtStageClose)) {
      // Perform invalidation processing when LegalStatStatus Date is
      // after the Stage Closure Date and display message.
      if (DateHelper.isAfter(dtLegalStatStatus, dtStageClose)) {
        throw new ServiceException(Messages.MSG_NO_LS_AFTER_STG_CLOSE);
      }
    }
    CCMN06UI ccmn06ui = new CCMN06UI();

    ArchInputStruct ccmn06ui_ArchInputStruct = new ArchInputStruct();
    if (0 != idEvent_ccmn01) {
      ccmn06ui_ArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      ccmn06ui_ArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccmn06ui.setArchInputStruct(ccmn06ui_ArchInputStruct);

    ccmn06ui.setUlIdStage(rowccmn01uig00.getUlIdStage());
    ccmn06ui.setSzCdTask(cdTask_ccmn01);

    // Call CheckStageEventStatus
    checkStageEventStatus.status(ccmn06ui);

    if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd))) {
      // Look for the Contacted By Person record in the
      // EVENT_PERSON_LINK table. If it is found ( it should be )
      // save the timestamp in tsLastUpdate3 for later ( save service )
      if (ArchitectureConstants.FALSE.equals(sysNbrReserved1)) {

        // Find the match and set the indicator -- This person was a
        // Contactee.
        if (CodesTables.CEVTSTAT_PEND.equals(csub46si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(STAGE_CLOSURE))) {

          CCMN05UI ccmn05ui = new CCMN05UI();
          ArchInputStruct archInputStruct_ccmn05ui = new ArchInputStruct();
          archInputStruct_ccmn05ui.setCReqFuncCd(archInputStruct.getCReqFuncCd());
          ccmn05ui.setArchInputStruct(archInputStruct_ccmn05ui);
          ccmn05ui.setUlIdEvent(idEvent_csub46);

          invalidateApproval.invalidateApproval(ccmn05ui);
          String cdEventStatus = rowccmn01uig00.getSzCdEventStatus();
          if (bIndEvent) {
            cdEventStatus = CodesTables.CEVTSTAT_COMP;
          } else {
            cdEventStatus = rowccmn01uig00.getSzCdEventStatus();
          }

          callUpdateEventByIdEvent(idEvent_ccmn01, cdEventStatus);
          bIndEvent = false;
        }
      }

      int ulIdEvent30 = postEvent(rowccmn01uig00);

      if (0 != idEvent_ccmn01) {

        todoDAO.updateTodoByIdEvent(idEvent_ccmn01);

      } else {
        rowccmn01uig00.setUlIdEvent(ulIdEvent30);
        idEvent_ccmn01 = ulIdEvent30;
      }

    }

    callLegalStatus(stage, rowcsub46sig00, rowccmn01uig00, csub46si.getCIndCsupSend(), reqFuncCd);
    
    //STGAP00012734: Update the stage county with the legal county selected on the Legal Status Page.
    updateStageCounty(idCase, idStage, idPerson, idEvent_ccmn01, cdStage, dtStageClose);

    if (0 != csub46si.getUlSysIdTodoCfPersCrea()) {

      CSUB40UI csub40ui = new CSUB40UI();

      ArchInputStruct archInputStruct_csub40ui = new ArchInputStruct();
      archInputStruct_csub40ui.setCReqFuncCd(archInputStruct.getCReqFuncCd());
      csub40ui.setArchInputStruct(archInputStruct_csub40ui);
      csub40ui.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_CODE);

      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(idStage);
      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(idEvent_csub46);
      csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtLegalStatStatus));
      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub46si.getUlSysIdTodoCfPersCrea());

      todoCommonFunction.audTodo(csub40ui);

    }

    /* Beggining of the creation of Alerts */

    String legalStat = rowcsub46sig00.getSzCdLegalStatStatus();
    Date courtOrdEx = DateHelper.toJavaDate(rowcsub46sig00.getDtDtLegalStatCrtOrdExpDt());
    Person person = new Person();
    person = personDAO.findPersonByIdPerson(rowcsub46sig00.getUlIdPerson());
    Date birthDate = person.getDtPersonBirth();
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    // Generate "Complete Child's Life History for <Person Name> and conduct staffing with child's foster parents" alert
    if (LS_PCT.equals(legalStat) || LS_PVL.equals(legalStat)) {

      Todo todo = new Todo();
      CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      // Get the id of the person the alert should be assigned to
      int idPersonPR = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PERS_ROLE_PR);
      String cdTask = "";
      String stageName = stage.getNmStage();
      String todoDesc = "Complete Child's Life History for " + stageName;
      String todoLongDesc = "Complete Child's Life History for " + stageName
                            + " and conduct staffing with child's foster parents.";
      todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPersonPR));
      todo.setTxtTodoDesc(todoDesc);
      todo.setTxtTodoLongDesc(todoLongDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCapsCase(capsCase);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(dtToday);
      todo.setDtTodoCreated(dtToday);
      todo.setStage(getPersistentObject(Stage.class, idStage));
      todoDAO.saveTodo(todo);
    }

    // Generate "Perform Case Review" alert for Temporary Volumtary or ILP Aftercare legal statuses if the child is 18
    // and older
    if (!(DateHelper.getAge(birthDate) < 18) && (LS_TVL.equals(legalStat) || LS_ILP.equals(legalStat))) {

      Todo todo = new Todo();
      CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      // Get the most recent Child plan
      FccpChild childPlan = new FccpChild();
      childPlan = fccpChildDAO.findLatestChildPlanByIdStageByCdEventType(idStage);

      String cdTask = "";
      int idPersAssign = 0;
      Date todoDueDate = null;
      Date lastPlanDate = null;
      // If there is a child plan, Get the next review date
      if (childPlan != null) {
        lastPlanDate = childPlan.getEvent().getDtEventOccurred();
        // set the due date
        todoDueDate = DateHelper.addToDate(lastPlanDate, 0, 0, 150);

        String todoDesc = "Perform Case review"; //
        // Depending on the Legal Status, Get the id of the person the alert should be assigned to
        if (LS_TVL.equals(legalStat)) {
          idPersAssign = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PERS_ROLE_PR);

        } else {
          String cdCounty = csub46si.getROWCSUB46SIG00().getSzCdLegalStatCnty();
          // Get the ILP Coordinator for the county ID and assign it to idPersAssign
          int idILPCoordinator = retrieveIdILP(cdCounty);
          idPersAssign = idILPCoordinator;

        }
        if (idPersAssign != 0) {
          todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPersAssign));
          todo.setTxtTodoDesc(todoDesc);
          todo.setCdTodoTask(cdTask);
          todo.setCdTodoType(CodesTables.CTODOTYP_A);
          todo.setDtTodoDue(todoDueDate);
          todo.setCapsCase(capsCase);
          todo.setDtTodoCreated(dtToday);
          todo.setStage(getPersistentObject(Stage.class, idStage));
          todoDAO.saveTodo(todo);
        }
      }
    }

    // Generate "Court Order is due to expire"
    if (courtOrdEx != null) {

      Todo todo = new Todo();
      CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      int idPersonPR = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PERS_ROLE_PR);
      String cdTask = "";
      Date todoDueDate = DateHelper.addToDate(courtOrdEx, 0, 0, -60);
      String todoDesc = "Court Order is due to expire.";
      todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPersonPR));
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      todo.setCapsCase(capsCase);
      todo.setDtTodoCreated(dtToday);
      todo.setStage(getPersistentObject(Stage.class, idStage));
      todoDAO.saveTodo(todo);
    }
    
    // STGAP00010693: Generate "Child in ADO has a new legal Status of <Legal Status>"
    // STGAP00012034: This alert needs to be sent even in the SUB case if there is an open ADO stage.
    long openAdoStageCount = stageDAO.countOpenAdoStageByIdPersonIdCase(idPerson, idCase);
    if (CodesTables.CSTAGES_ADO.equals(stage.getCdStage())||
                    (CodesTables.CSTAGES_SUB.equals(stage.getCdStage()) && openAdoStageCount > 0)){
      String cdTask = "";
      String stageName = stage.getNmStage();
      CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      String cdLegalStatus = rowcsub46sig00.getSzCdLegalStatStatus();
      String legalStatus = Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT, cdLegalStatus);
      // if legal status has changed to Not in DFCS Custody - Adoption Finalized, alert the 
      // Regional Adoption Exchange Consultants and RACs
      //MR-041: Also alert Regional Accounting, Rev Max, Adoption Assistance Specialists.
      if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatus)) {
        // Get the region of the county
        String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
        List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
        List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
        //MR-041 Create list of Rev Max for region
        List<Integer> revMaxList = unitEmpLinkDAO.findMESWorkersByIdRegion(cdRegion);
        //MR-041 Create list of Regional Accounting persons for a region
        List<Integer> regionalAccountingList = unitEmpLinkDAO.findRegionalAccountingByCdRegion(cdRegion);
        //MR-041 Create list of Regional Accounting persons for a region
        List<Integer> adoptionSpecialistsList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
        
        List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
        if (listIsValid(adoExchangeConsultants)) {
          racAndAuthorizedSauList.addAll(adoExchangeConsultants);
        }
        if (listIsValid(racList)) {
          racAndAuthorizedSauList.addAll(racList);
        }
        //MR-041 Add all the lists to the main racAndAuthorizedSauList List
        if (listIsValid(revMaxList)) {
          racAndAuthorizedSauList.addAll(revMaxList);
        }
        if (listIsValid(regionalAccountingList)) {
          racAndAuthorizedSauList.addAll(regionalAccountingList);
        }
        if (listIsValid(adoptionSpecialistsList)) {
          racAndAuthorizedSauList.addAll(adoptionSpecialistsList);
        }
        
        //MR-041 Remove Duplicate persons from the list before sending them the alert.
        List<Integer> alertReceivingPersonsList = new ArrayList<Integer>();
        if (listIsValid(racAndAuthorizedSauList)) {
          Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
          while (itrRacAndAuthorizedSauList.hasNext()) {
            Integer idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
            if(!alertReceivingPersonsList.contains(idAssigned)){
              alertReceivingPersonsList.add(idAssigned);
            }
          }
        }
        
        
        if (listIsValid(alertReceivingPersonsList)) {
          Iterator<Integer> itrAlertReceivingPersonsList = alertReceivingPersonsList.iterator();
          while (itrAlertReceivingPersonsList.hasNext()) {
            int idAssigned = (Integer) itrAlertReceivingPersonsList.next();
            Todo todo = new Todo();
            String todoDesc = stageName + " Legal Status has changed to " + legalStatus;
            String todoLongDesc = stageName + " Legal Status has changed to " + legalStatus;
            todo.setPersonByIdTodoPersAssigned(personDAO.findPersonByIdPerson(idAssigned));
            todo.setTxtTodoDesc(todoDesc);
            todo.setTxtTodoLongDesc(todoLongDesc);
            todo.setCdTodoTask(cdTask);
            todo.setDtTodoDue(dtToday);
            todo.setCdTodoType(CodesTables.CTODOTYP_A);
            todo.setCapsCase(capsCase);
            todo.setDtTodoCreated(dtToday);
            todo.setStage(getPersistentObject(Stage.class, idStage));
            todoDAO.saveTodo(todo);
          }
        }
      } // end if NAF
    } // end if ADO, FCC, or openAdoStageCount > 0
    // SMS#87845 MR-074-2 AFCARS: send alert to Permanency Unit if Adoption Finalized is entered for a child who was
    // previously reported to AFCARS.
    if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatusToSave)) {
      String bIndPrevAfcars = csub46si.getBIndPrevAfcars();
      // SMS #106480: MR-074-2
      // Replaced rowcsub46sig00.getUlIdEvent() to rowcsub46sig00.getUlIdLegalStatEvent() to generate the alert 
      // to the Permanency Unit correctly; rowcsub46sig00.setUlIdEvent() never been set in the LegalStatusConversation.java
      int idEventLegStat = rowcsub46sig00.getUlIdLegalStatEvent();
      // if previously reported to Adoption AFCARS and saving an existing Adoption Finalized, send alert to Permanency Unit
      if (ArchitectureConstants.Y.equals(bIndPrevAfcars) && idEventLegStat > 0) {
        String desc = "Legal Status record has been modified for " + nmPersonChild + " previously reported to AFCARS.";  
        CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
        // Find all employees with profile permanency_unit
        List<Integer> puIdPersonList = empSecClassLinkDAO.findIdPersonsByCdSecurityClassName(DeleteLegalService.PERMANENCY_UNIT_PROFILE);
        // Send alert to all in the Permanency Unit list
        sendAlert(desc, puIdPersonList, capsCase, stage) ; 
      }
     
    }
    return csub46so;
  }

  private void callLegalStatus(Stage stage, ROWCSUB46SIG00 rowcsub46sig00, ROWCCMN01UIG00 rowccmn01uig00, String indCsupSend,
                               String reqFuncCd) throws ServiceException {

    int idEvent_ccmn01 = rowccmn01uig00.getUlIdEvent();
    int idPerson = rowcsub46sig00.getUlIdPerson();
    String oldLegalStatusCountyCd = null;
    CapsCase case1= stage.getCapsCase();
    int idCase = 0;
    if(case1 != null){
      idCase = case1.getIdCase();
    }
    boolean referredToSmile = false;
    String cdLegalStatusOld = null;
    // Find out the most recent legal status.  This will be used to compare against after saving the record.  We need to know
    // what the most recent Legal Status County is prior to saving.  If it changes the SMILE CLIENT_OUTBOUND interface
    // will need to be updated.
    if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd))) {
      // Check whether the legalStatus county has been changed. If so, then send a row to ClientOutbound
      // i.e. Send row to ClientOutbound only for a registered SMILE client
      Person personToFindSmileClient = personDAO.findPersonByIdPerson(idPerson);
      String cdSmileClient = personToFindSmileClient.getCdSmileClient();
      // Checking for SMILE Client is not null
      if (null != cdSmileClient) {
        referredToSmile = true;
        Map oldLegalStatus = legalStatusDAO.findMostRecentLegalStatusIdAndCounty(idPerson);
        if (null != oldLegalStatus) {
          oldLegalStatusCountyCd = (String) oldLegalStatus.get("cdLegalStatCnty");
        }
      }
    }
    //Check whether cdLegalStatus has been changed to one of the codes in 
    // 'AFS','NAF','NCT', NCD', 'NCO','NTT','NCE','NGP',  'NPC', 'NPR', 'CTD', 'ILP'
    // if yes insert row in to CSUP_CHILDLEFTCARE_OUTBOUND table 
    List<String> legalStatusList = new ArrayList<String>();
    legalStatusList.add(CodesTables.CLEGSTAT_AFS);
    legalStatusList.add(CodesTables.CLEGSTAT_NAF);
    legalStatusList.add(CodesTables.CLEGSTAT_NCT);
    legalStatusList.add(CodesTables.CLEGSTAT_NCD);
    legalStatusList.add(CodesTables.CLEGSTAT_NCO);
    legalStatusList.add(CodesTables.CLEGSTAT_NTT);
    legalStatusList.add(CodesTables.CLEGSTAT_NCE);
    legalStatusList.add(CodesTables.CLEGSTAT_NGP);
    legalStatusList.add(CodesTables.CLEGSTAT_NPC);
    legalStatusList.add(CodesTables.CLEGSTAT_NPR);
    legalStatusList.add(CodesTables.CLEGSTAT_CTD);
    legalStatusList.add(CodesTables.CLEGSTAT_ILP);

    LegalStatus legalStatusOld = legalStatusDAO.findCurrentLegalStatusByIdPerson(idPerson);
    if(legalStatusOld != null){
      cdLegalStatusOld = legalStatusOld.getCdLegalStatStatus();
    }
    // Starting the code to save the Legal Status page
    
    Date dtLegalStatStatus = DateHelper.toJavaDate(rowcsub46sig00.getDtDtLegalStatStatusDt());
    //SMS#39011: Getting the persistent Object to make sure update does not fail
    LegalStatus legalStatus = (LegalStatus)getPersistentObject(LegalStatus.class, rowcsub46sig00.getUlIdLegalStatEvent());
    if(rowcsub46sig00.getUlIdLegalStatEvent()<=0){
      legalStatus = new LegalStatus();
    }
    if (0 == rowcsub46sig00.getUlIdLegalStatEvent()) {
      legalStatus.setIdLegalStatEvent(idEvent_ccmn01);
    } else{
      legalStatus.setIdLegalStatEvent(rowcsub46sig00.getUlIdLegalStatEvent());
      legalStatus.setDtLastUpdate(rowcsub46sig00.getTsLastUpdate());
    }

    Event event = (Event) getPersistentObject(Event.class, idEvent_ccmn01);

    // SWR 06/03/2008 STGAP00004587 - Added call to set CapsCase so that it is not nulled out on update.
    legalStatus.setCapsCase(event.getCapsCase());
    legalStatus.setEvent(event);
    Person person = (Person) getPersistentObject(Person.class, idPerson);

    legalStatus.setPerson(person);
    legalStatus.setCdLegalStatCnty(rowcsub46sig00.getSzCdLegalStatCnty());
    legalStatus.setCdLegalStatStatus(rowcsub46sig00.getSzCdLegalStatStatus());
    legalStatus.setDtLegalStatStatusDt(dtLegalStatStatus);
    legalStatus.setIndLegalStatRisk(rowcsub46sig00.getBIndLegalStatRisk());

   // SMS#49744  unable to delete invalid court order, custody expiration dates and Petition/Motion Due Date
    org.exolab.castor.types.Date date2;
    date2 = rowcsub46sig00.getDtDtLegalStatCrtOrdExpDt();
    legalStatus.setDtLegalStatCrtOdrExpDt(DateHelper.toJavaDate(date2));

    org.exolab.castor.types.Date date;
    date = rowcsub46sig00.getDtDtLegalStatCustExpDt();
    legalStatus.setDtLegalStatCusExpDt(DateHelper.toJavaDate(date));
    
    // third date
    org.exolab.castor.types.Date date3;
    date3 = rowcsub46sig00.getDtDtLegalStatPMDueDt();
    legalStatus.setDtLegalStatPMDueDt(DateHelper.toJavaDate(date3));


    legalStatus.setIndCsupSend(indCsupSend);
    legalStatusDAO.saveLegalStatus(legalStatus);
    
    //STGAP00014257: Now that the Legal Status is saved, we need to determine if we need to free up an open slot for the home where this child is placed 
    if (CodesTables.CSTAGES_ADO.equals(stage.getCdStage())) {
      String cdLegalStatus = legalStatus.getCdLegalStatStatus();
      Placement currentPlacement = placementDAO.findCurrentAdoPlcmtByIdPersonByIdStage(idPerson, stage.getIdStage());
      // If this Legal Status is Adoption Finalized, then we do not need to count the Placement of this child against the home
      if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatus)) {
        if (currentPlacement != null) {
          if (CodesTables.CPLMNTYP_ADH.equals(currentPlacement.getCdPlcmtType())) {
            // The child currently has an Adoptive Placement so increment the Resource's number of open slots
            int updateCapsResource = capsResourceDAO.updateCapsResource(1,
                                                                        currentPlacement.getCapsResourceByIdRsrcFacil()
                                                                                        .getIdResource());
            if (updateCapsResource == 0) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
          }
        }
      }
    }
    
    // Now that the Legal Status page is saved, determine the most recent Legal Status. If the county has changed then
    // update CLIENT_OUTBOUND.
    if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd))) {
      // Check whether the legalStatus county has been changed. If so, then send a row to ClientOutbound
      // i.e. Send row to ClientOutbound only for a registered SMILE client
      if (referredToSmile) {
        Map newLegalStatus = legalStatusDAO.findMostRecentLegalStatusIdAndCounty(idPerson);
        if (null != newLegalStatus) {
          String newLegalStatusCountyCd = (String) newLegalStatus.get("cdLegalStatCnty");
          
          if (null != oldLegalStatusCountyCd && !newLegalStatusCountyCd.equals(oldLegalStatusCountyCd)) {
            ClientOutboundBean clientOutboundBean = new ClientOutboundBean();
            clientOutboundBean.setIdPerson(idPerson);
            // Set the New Legal County Cd
            clientOutboundBean.setCdLegalStatCnty(newLegalStatusCountyCd);
            clientOutboundBean.setCdOriginatingPage(LEGAL_STATUS);
            clientOutboundBean.setIdInitiator(rowccmn01uig00.getUlIdPerson());
            // ClientOutboundSaveSI has never been used but just to call the update method in updateClientOutbound
            ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
            
            //MR-041 set the idStage
            clientOutboundSaveSI.setIdStage(stage.getIdStage());
            
            clientOutboundSaveSI.setClientOutboundBean(clientOutboundBean);
            updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);
          }
        } else {// This code should be nearly impossible to hit, but leaving just in case.
          //If no legalStatus available, then send a row to ClientOutbound
          ClientOutboundBean clientOutboundBean = new ClientOutboundBean();
          clientOutboundBean.setIdPerson(idPerson);
          clientOutboundBean.setIdInitiator(rowccmn01uig00.getUlIdPerson());
          // Set the New Legal County Cd
          clientOutboundBean.setCdLegalStatCnty(rowcsub46sig00.getSzCdLegalStatCnty());
          clientOutboundBean.setCdOriginatingPage(LEGAL_STATUS);
          // ClientOutboundSaveSI has never been used but just to call the update method in updateClientOutbound
          ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
          clientOutboundSaveSI.setClientOutboundBean(clientOutboundBean);
          updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);
        }
      }
      
      LegalStatus legalStatusNew = legalStatusDAO.findCurrentLegalStatusByIdPerson(idPerson);
      String cdLegalStatusNew = StringHelper.EMPTY_STRING;
      Date dtlegalStatStatus = null;
      if(legalStatusNew != null){
        cdLegalStatusNew = legalStatusNew.getCdLegalStatStatus();
        dtlegalStatStatus = legalStatusNew.getDtLegalStatStatusDt();
      }
      if(null != cdLegalStatusOld && !cdLegalStatusNew.equals(cdLegalStatusOld)&&
                      legalStatusList.contains(cdLegalStatusNew) ){
        //Insert a row in the CSUP_CHILDLEFTCARE_OUTBOUND table
        Placement placement = placementDAO.findOpenOrClosedPlacementLatestApprovedByIdPerson(idPerson);
        Eligibility eligCsupSend = eligibilityDAO.findDistinctEligibilityByIdPersonAndIndCsupSend(idPerson);
        
        SaveCsupChildleftcareSI saveCsupChildleftcareRowSI = new SaveCsupChildleftcareSI(); 
        if (null != eligCsupSend) {
          if ("Y".equals(eligCsupSend.getIndEligCsupSend())) {
            if(null != placement){
            saveCsupChildleftcareRowSI.setIdPersonId(placement.getPersonByIdPlcmtChild().getIdPerson());
            saveCsupChildleftcareRowSI.setDtChildHomeRequested(placement.getDtPlcmtEnd());
            saveCsupChildleftcareRowSI.setIdCase(placement.getCapsCase().getIdCase());
            saveCsupChildleftcareRowSI.setIdStage(stage.getIdStage());
            saveCsupChildleftcareRowSI.setDtLeftCare(dtlegalStatStatus);
            String cdReasonCode = retrieveReasonCode(cdLegalStatusNew);
            saveCsupChildleftcareRowSI.setCdReasonCode(cdReasonCode);
        
           if(null != placement.getPersonByIdPlcmtAdult())
            {
              String nmPersonFull = StringHelper.getSafeString(placement.getPersonByIdPlcmtAdult().getNmPersonFull());
              saveCsupChildleftcareRowSI.setNmFullName(nmPersonFull);
            }
           if(null != placement.getCapsResourceByIdRsrcFacil())
            {
            String nmPersonFull = StringHelper.getSafeString(placement.getCapsResourceByIdRsrcFacil().getNmResource());
            saveCsupChildleftcareRowSI.setNmFullName(nmPersonFull);
            }
           if(null != placement.getCapsResourceByIdRsrcAgency())
            {
            String nmPersonFull = StringHelper.getSafeString( placement.getCapsResourceByIdRsrcAgency().getNmResource());
            saveCsupChildleftcareRowSI.setNmFullName(nmPersonFull);
            }          
           
            saveCsupChildleftcareRowSI.setAddrPlcmtLn1(null != placement.getAddrPlcmtLn1() ? placement.getAddrPlcmtLn1() : "");
            saveCsupChildleftcareRowSI.setAddrPlcmtLn2(null != placement.getAddrPlcmtLn2() ? placement.getAddrPlcmtLn2() : "");
            saveCsupChildleftcareRowSI.setAddrPlcmtCity(null != placement.getAddrPlcmtCity() ? placement.getAddrPlcmtCity() : "");
            saveCsupChildleftcareRowSI.setAddrPlcmtState(null != placement.getAddrPlcmtSt() ? placement.getAddrPlcmtSt() : "");
            saveCsupChildleftcareRowSI.setAddrPlcmtZip(null != placement.getAddrPlcmtZip() ? placement.getAddrPlcmtZip() : "");
            saveCsupChildleftcareRowSI.setNbrPlcmtTelephone(null != placement.getNbrPlcmtTelephone() ? placement.getNbrPlcmtTelephone() : "");
            saveCsupChildleftcare.saveCsupChildleftcare(saveCsupChildleftcareRowSI, "SavePersonPlacementDetail");
          }
          }
        }
      }
      
      
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {

      legalStatusDAO.deleteLegalStatus(legalStatus);
    } else {

      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

  }

  // this DAO will update the event status in the event table
  // without a time stamp if closure event was pending and something was
  // modified in the legal status window
  private void callUpdateEventByIdEvent(int idEvent, String cdEventStatus) throws ServiceException {

    if (0 == eventDAO.updateEventByIdEvent(idEvent, cdEventStatus)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);

    }

  }

  private int postEvent(ROWCCMN01UIG00 csub46si_rowccmn01uig00) throws ServiceException {
    // Call the PostEvent common function (CCMN01U)

    CCMN01UI ccmn01ui = new CCMN01UI();

    ccmn01ui.setROWCCMN01UIG00(csub46si_rowccmn01uig00);

    ROWCCMN01UIG00 ccmn01ui_rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();

    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui_rowccmn01uig00.setUlIdEvent(csub46si_rowccmn01uig00.getUlIdEvent());
    ccmn01ui_rowccmn01uig00.setTsLastUpdate(csub46si_rowccmn01uig00.getTsLastUpdate());
    ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(csub46si_rowccmn01uig00.getDtDtEventOccurred());
    ccmn01ui_rowccmn01uig00.setUlIdStage(csub46si_rowccmn01uig00.getUlIdStage());
    ccmn01ui_rowccmn01uig00.setUlIdPerson(csub46si_rowccmn01uig00.getUlIdPerson());
    ccmn01ui_rowccmn01uig00.setSzCdTask(csub46si_rowccmn01uig00.getSzCdTask());
    ccmn01ui_rowccmn01uig00.setSzCdEventStatus(csub46si_rowccmn01uig00.getSzCdEventStatus());
    ccmn01ui_rowccmn01uig00.setSzCdEventType(csub46si_rowccmn01uig00.getSzCdEventType());
    ccmn01ui_rowccmn01uig00.setSzTxtEventDescr(csub46si_rowccmn01uig00.getSzTxtEventDescr());

    if (0 == csub46si_rowccmn01uig00.getUlIdEvent()) {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowccmn01uig00);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

    return ccmn01uo.getUlIdEvent();

  }

  // This method retrieves the ILP Coordinator ID for the county that is passed to the method as parameter
  public int retrieveIdILP(String cdCounty) {
    int idILP = 0;
    List<Integer> idList = new ArrayList<Integer>();
    List<String> cdSecurityList = new ArrayList<String>();
    cdSecurityList.add(PERS_ROLE_ILP_C);
    idList = employeeDAO.findIdPersonByJobSecurityRole(cdCounty, cdSecurityList);
    if (!idList.isEmpty()) {
      Integer idIntILP = null;
      Iterator it = idList.iterator();
      idIntILP = (Integer) it.next();
      idILP = idIntILP.intValue();
    } else {
      idILP = 0;
    }
    return idILP;
  }
  
  @SuppressWarnings( { "unchecked" })
  //STGAP00012734: MR-019  This method updates the stage county with the Legal County selected on the Legal status Page
  //               It does that only if the stages are FCC, ADO, PAD, PFC and FCF and they are open and the county selected
  //               on the Legal Status Page is a GA County. For out of state there are no changes.
  private void updateStageCounty(int idCase, int idStage, int idPerson, int idEvent, String cdStage, Date dtStageClose){
    String legalStatCounty = StringHelper.EMPTY_STRING;
    String cutrrentLegalStatRegion = StringHelper.EMPTY_STRING;
    boolean isGACurrentCounty = false;
    
    //Get the county of the current Legal status    
    String currentLegalStatCnty = legalStatusDAO.findLegalStatCntyByIdPersonIdStage(idPerson, idEvent);
    if(currentLegalStatCnty == null){
      currentLegalStatCnty = StringHelper.EMPTY_STRING;
    }
    if(currentLegalStatCnty != null || !StringHelper.EMPTY_STRING.equals(StringHelper.EMPTY_STRING)){
     //Get the region of the county
      cutrrentLegalStatRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, currentLegalStatCnty);
      //Check if the current county is GA county
      isGACurrentCounty = isGACounty(currentLegalStatCnty);
    }
    //Get the most recent Legal Status County.
    Map mostRecentlegalStatus = legalStatusDAO.findMostRecentLegalStatusIdAndCounty(idPerson);
    if(mostRecentlegalStatus != null) {
      legalStatCounty = (String) mostRecentlegalStatus.get("cdLegalStatCnty");
    }
    //Get the region of the county
    String legalStatRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, legalStatCounty);
    boolean isGACounty = isGACounty(legalStatCounty);
    //Get the open FCF stage on the Case.
    Integer idFCFStage = stageDAO.findIdStageByIdCaseAndCdStageAndDtStageClose(idCase, CodesTables.CSTAGES_FSU);
    Date dtFCFStageClose = new Date();
    if(idFCFStage != null){
      Stage stageFCF = stageDAO.findStageByIdStage(idFCFStage);
      dtFCFStageClose = stageFCF.getDtStageClose();
    }
    if((CodesTables.CSTAGES_SUB.equals(cdStage)||
                    CodesTables.CSTAGES_ADO.equals(cdStage) ||
                    CodesTables.CSTAGES_PAD.equals(cdStage)||
                    CodesTables.CSTAGES_PFC.equals(cdStage)) && isGACurrentCounty && 
                    (DateHelper.isNull(dtStageClose) || (DateHelper.MAX_JAVA_DATE.equals(dtStageClose)))){
      stageDAO.updateStageCdStageRegioncCStageCntyByIdStage(idStage, cutrrentLegalStatRegion, currentLegalStatCnty);
      //Whenever the FCC, ADO or PFC stage is updated, the open FCF stage county is updated to match the legal county selected.
      //STGAP00013991:  The FCF stage county should only be updated when the legal county change is made within an FCC (SUB) or ADO stage.
      if(CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)){
        if(idFCFStage != null && isGACounty && (DateHelper.isNull(dtFCFStageClose) || (DateHelper.MAX_JAVA_DATE.equals(dtFCFStageClose)))){
          stageDAO.updateStageCdStageRegioncCStageCntyByIdStage(idFCFStage, legalStatRegion, legalStatCounty); 
        }
      }
    }
  }

  //STGAP00012734: This method returns true if the county is GA county.
  private boolean isGACounty(String legalStatCounty){
    boolean gaCounty = false;
    if(StringHelper.isValid(legalStatCounty)){
      if(!(CodesTables.CCOUNT_999.equals(legalStatCounty) || CodesTables.CCOUNT_XXX.equals(legalStatCounty))){
        gaCounty = true;
      }
    } 
    return gaCounty;
  }
  
  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  //STGAP00014993 Added method to retrieve Reason code depending upon the changed legal status.
  //This cdReasonCode will be used to populate the CD_REASON_CODE field of the CSUP_CHILDLEFTCARE_OUTBOUND
  //table.
  private String retrieveReasonCode(String cdLegalStatusNew){
   String cdReasonCode = StringHelper.EMPTY_STRING;
   if(CodesTables.CLEGSTAT_AFS.equals(cdLegalStatusNew) || CodesTables.CLEGSTAT_NPC.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_01;
     return cdReasonCode;
   }else if (CodesTables.CLEGSTAT_NPR.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_02;
     return cdReasonCode;
   }else if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_03;
     return cdReasonCode;
   }else if (CodesTables.CLEGSTAT_NCT.equals(cdLegalStatusNew) ||CodesTables.CLEGSTAT_NCE.equals(cdLegalStatusNew) ||
                   CodesTables.CLEGSTAT_ILP.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_04;
     return cdReasonCode;
   }else if(CodesTables.CLEGSTAT_NGP.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_05;
     return cdReasonCode;
   }else if(CodesTables.CLEGSTAT_NCO.equals(cdLegalStatusNew) ||CodesTables.CLEGSTAT_NTT.equals(cdLegalStatusNew) ||
                   CodesTables.CLEGSTAT_CTD.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_06;
     return cdReasonCode; 
   }else if(CodesTables.CLEGSTAT_NCD.equals(cdLegalStatusNew)){
     cdReasonCode = CodesTables.CAFCARS_08;
     return cdReasonCode;
   }
   return cdReasonCode;
   }
  
  private boolean isFCStage(String cdStage) {
	  return (CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage));
  }
  
  /**
   * This is called when saving a permanent custody (permanent custody or voluntary) or adoption finalized legal status
   * @param csub46si
   */
  private void performValidationForPermanentCustodyAndNAF(CSUB46SI csub46si){
	   
	  // Detail boolean needed because there are different messages
	    // These are for message that TPR/VS/DOD not exists
	    boolean laExistsFather= false; // indicator TPR/VS father exists
	    boolean laExistsMother = false; // indicator TPR/VS mother exists
	    boolean dodExistsFather = false; // indicator DOD exists on a father
	    boolean dodExistsMother = false; // indicator DOD exists on a mother
	    	    
	    // These are for message that TPR/VS/DOD exists but the dates are not correct order 
	    boolean dateExistsFather= false; // father was TPR/VS'd prior to child is removed permanently or finalized (on the same day is ok)
	    boolean dateDODExistsFather = false; // father died prior to child is removed permanently or finalized (on the same day is ok)
	    boolean dateExistsMother= false; // mother was TPR/VS'd prior to child is removed permanently or finalized (on the same day is ok)
	    boolean dateDODExistsMother = false; // mother died prior to child is removed permanently or finalized (on the same day is ok)
	    
	    int idCase = csub46si.getUlIdCase();
	    int idStage = csub46si.getUlIdStage();
	    int idChild = csub46si.getROWCSUB46SIG00().getUlIdPerson();

	    Date dtLegalStatEff = DateHelper.toJavaDate(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
    	Date dtCrtAction = DateHelper.MAX_JAVA_DATE;
    	Date dtHrTyCrtOrds = DateHelper.MAX_JAVA_DATE;
    	String laCdCrtActType = StringHelper.EMPTY_STRING;
    	String laCdHrType = StringHelper.EMPTY_STRING;
    	
	    int numTPRReq = 2;
	    List<LegalAction> legalActionList = new ArrayList<LegalAction>();
	    List<String> cdLegalActAction = new ArrayList<String>();
	    List<String> cdHrTypCrtOrds = new ArrayList<String>();
	    String[] cdOutcome = {CodesTables.CLEGLOUT_TPG};
	    	    
	    // Whether the child was previously adopted to see how many and what type of TPR/VS/DOD required
	    // before the State can take full custody of the child or finalize the adoption.
	    Person personChild = personDAO.findPersonByIdPerson(idChild);
	    if (personChild == null) 
	    	throw new ServiceException(Messages.SQL_NOT_FOUND);
	    // If record found
	    Date dobChild = personChild.getDtPersonBirth();
	    String indPrevAdopted = StringHelper.getNonNullString(personChild.getIndPrevAdopted());
	    String indPrevAdoptedSingle = StringHelper.getNonNullString(personChild.getIndSingleParAdopt());
	    String cdPrevAdoptedSingleType = StringHelper.getNonNullString(personChild.getCdSingleMotherFather());
	    // Require DOB and effective date on or after DOB
	    if (DateHelper.isNull(dobChild) || DateHelper.isBefore(dtLegalStatEff, dobChild)) 
	    	throw new ServiceException(Messages.MSG_LEG_STAT_EFF_BEFORE_DOB_ERR);
	    // Determine the number of required TPR/VS
	    if (ArchitectureConstants.Y.equals(indPrevAdopted) && ArchitectureConstants.Y.equals(indPrevAdoptedSingle)) {
	    		numTPRReq = 1;
	    }
	    
	    // Retrieve TPR/VS father list
	    cdLegalActAction.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender-Adoptive Father 
	    cdLegalActAction.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender-Biological Father
	    cdLegalActAction.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender-Legal Father
	    cdLegalActAction.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender-Legal/Biological Father
            cdLegalActAction.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender-Putative Father - SMS#87845 MR-074-2 AFCARS
	    
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Legal/Biological Father
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father - SMS#87845 MR-074-2 AFCARS

	    legalActionList = legalActionDAO.findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(idCase, idChild, cdLegalActAction, cdOutcome, cdHrTypCrtOrds);
	    for (LegalAction la : legalActionList) {
	    	laExistsFather = true;
	    	dtCrtAction = DateHelper.isNull(la.getDtCrtActDate()) ? DateHelper.MAX_JAVA_DATE : la.getDtCrtActDate();
	    	dtHrTyCrtOrds = DateHelper.isNull(la.getDtCrtOrdDate()) ? DateHelper.MAX_JAVA_DATE : la.getDtCrtOrdDate();
	    	laCdCrtActType = la.getCdLegalActAction() == null ? StringHelper.EMPTY_STRING : la.getCdLegalActAction();
	    	laCdHrType = la.getCdHrTypCrtOrd() == null ? StringHelper.EMPTY_STRING : la.getCdHrTypCrtOrd();
	    	// whether TPR or VS achieved date is after legal status effective date
	    	if ((cdLegalActAction.contains(laCdCrtActType) && DateHelper.isAfter(dtCrtAction, dtLegalStatEff)) || 
	    			(cdHrTypCrtOrds.contains(laCdHrType) && DateHelper.isAfter(dtHrTyCrtOrds, dtLegalStatEff)
	    			                && !DateHelper.isEqual(dtHrTyCrtOrds, DateHelper.MAX_JAVA_DATE))) {
	    		dateExistsFather = true;
	    		break;
	    	} 
	    }
	    // Retrieve TPR/VS mother list
	    cdLegalActAction.clear(); 
	    cdLegalActAction.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender-Adoptive Mother
	    cdLegalActAction.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrender-Mother
	    cdHrTypCrtOrds.clear();
	    cdHrTypCrtOrds = new ArrayList<String>();
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR-Mother
	    
	    legalActionList = legalActionDAO.findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(idCase, idChild, cdLegalActAction, cdOutcome, cdHrTypCrtOrds);
	    for (LegalAction la : legalActionList) {
	    	laExistsMother = true;
	    	dtCrtAction = DateHelper.isNull(la.getDtCrtActDate()) ? DateHelper.MAX_JAVA_DATE : la.getDtCrtActDate();
	    	dtHrTyCrtOrds = DateHelper.isNull(la.getDtCrtOrdDate()) ? DateHelper.MAX_JAVA_DATE : la.getDtCrtOrdDate();
	    	laCdCrtActType = la.getCdLegalActAction() == null ? StringHelper.EMPTY_STRING : la.getCdLegalActAction();
	    	laCdHrType = la.getCdHrTypCrtOrd() == null ? StringHelper.EMPTY_STRING : la.getCdHrTypCrtOrd();
	    	// whether TPR or VS achieved date is after legal status effective date
	    	if (((cdLegalActAction.contains(laCdCrtActType) && DateHelper.isAfter(dtCrtAction, dtLegalStatEff))) 
	    			|| (cdHrTypCrtOrds.contains(laCdHrType) && (DateHelper.isAfter(dtHrTyCrtOrds, dtLegalStatEff))
	    			            && !DateHelper.isEqual(dtHrTyCrtOrds, DateHelper.MAX_JAVA_DATE))) {
	    		dateExistsMother = true;
	    		break;
	    	} 
	    }

	    List<String> relationType = new ArrayList<String>();
	    relationType.add(CodesTables.CRPTRINT_LF); // Legal Father 
	    relationType.add(CodesTables.CRPTRINT_BF); // Biological Father
	    relationType.add(CodesTables.CRPTRINT_BB); // Biological and Legal Father
	    relationType.add(CodesTables.CRPTRINT_BP); // Biological Parent 
	    relationType.add(CodesTables.CSRCRPTR_PF); // Putative Father - SMS#87845 MR-074-2 AFCARS

	    // Get the DOD for Father; one date is enough; allowing DOD on or before effective date
	    List<Integer> idParents = stagePersonLinkDAO.findIdPersonParentByIdStage(idStage, relationType, CodesTables.CSEX_M);
	    if (listIsValid(idParents)) {
	      for (Iterator<Integer> it = idParents.iterator() ; it.hasNext() ;) {
	        Integer idPersonObj =  (Integer)it.next();
	        int idPers = idPersonObj != null ? idPersonObj : 0;
	        Person person = personDAO.findPersonByIdPerson(idPers);
	        if (person != null){
	          Date dod = person.getDtPersonDeath();
	          if (!DateHelper.isNull(dod)) {
	        	  dodExistsFather = true;
	        	// whether the father died after the legal status effective date
		          if (DateHelper.isAfter(dod, dtLegalStatEff)) {
		            dateDODExistsFather = true;
		            break; 
		          }
	          }
	        }
	      }
	    }
	    
	    relationType = new ArrayList<String>();
	    relationType.add(CodesTables.CRPTRINT_LM); // Legal Mother
	    relationType.add(CodesTables.CRPTRINT_BM); // Biological Mother
	    relationType.add(CodesTables.CRPTRINT_BP); // Biological Parent 
	    
	    // Get the DOD for Mother, one is enough to pass
	    idParents = stagePersonLinkDAO.findIdPersonParentByIdStage(idStage, relationType, CodesTables.CSEX_F);
	    if (listIsValid(idParents)) {  
	      for(Iterator<Integer> it = idParents.iterator() ; it.hasNext() ;){
	        Integer idPersonObj =  (Integer)it.next();
	        int idPers = idPersonObj != null ? idPersonObj : 0;
	        Person person = personDAO.findPersonByIdPerson(idPers);
	        if (person != null) {
	          Date dod = person.getDtPersonDeath();
	          if (!DateHelper.isNull(dod)) {
	        	  dodExistsMother = true;
	        	// whether the mother died after the legal status effective date
		          if (DateHelper.isAfter(dod, dtLegalStatEff)) {
		            dateDODExistsMother = true;
		            break; 
		          }
	          }
	        }
	      }
	    }
	    // previous adoption is single  adoption
	    if (numTPRReq == 1) { 
	    	// single father adoption
	    	if (CodesTables.CSPATYPE_SF.equals(cdPrevAdoptedSingleType)) {
	    		if (!laExistsFather && !dodExistsFather) {
	    			throw new ServiceException(Messages.MSG_MISSING_PARENT_TPR);
	    		}  else if (dateExistsFather || dateDODExistsFather) {
	    			throw new ServiceException(Messages.MSG_LEG_STAT_EFF_BEFORE_TPR_VS_DOD_ERR);
		    	}
	    	} else if (CodesTables.CSPATYPE_SM.equals(cdPrevAdoptedSingleType)) {
	    		if (!laExistsMother && !dodExistsMother) {
	    			throw new ServiceException(Messages.MSG_MISSING_PARENT_TPR);
	    		} else if (dateExistsMother || dateDODExistsMother) {
	    			throw new ServiceException(Messages.MSG_LEG_STAT_EFF_BEFORE_TPR_VS_DOD_ERR);
		    	}
		    } 
		   // return false; // single adoption but not specified mother or father, it is error.
	    } else { // it is not single adoption, require a TPR/VS for one mother and one father, or a mother and a father deceased
	    	if ((!laExistsFather && !dodExistsFather) || (!laExistsMother && !dodExistsMother)) {
	    		throw new ServiceException(Messages.MSG_MISSING_PARENT_TPR);
	    	} 
	    	// LA/DOD exists for both parent(s); check to see if they happen after the LS effective date, if so, error
	    	// parental right was not terminated and parents not die as of the LS effective date
	    	else if ((dateExistsFather || dateDODExistsFather) || (dateExistsMother || dateDODExistsMother)) {
	    			throw new ServiceException(Messages.MSG_LEG_STAT_EFF_BEFORE_TPR_VS_DOD_ERR);
	    	}
	    	
	    }
  }
  // SMS#87845 MR-074-2 AFCARS: helper function to send alert to a list of persons
  /**
   * Simple todo type alert for a list of assigned person
   * @param desc
   * @param idPersonAssigneds
   * @param capsCase
   * @param stage
   */
  private void sendAlert(String desc, Collection<Integer> idPersonAssigneds, CapsCase capsCase, Stage stage) {
    for (Integer idPerson : idPersonAssigneds) {
      Todo alert = new Todo();
      alert.setTxtTodoDesc(desc);
      alert.setTxtTodoLongDesc(desc);
      alert.setCdTodoType(CodesTables.CTODOTYP_A);
      alert.setDtTodoCreated(new Date());
      alert.setDtTodoDue(new Date());
      alert.setDtTodoCompleted(new Date());
      alert.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
      alert.setCapsCase(capsCase);
      alert.setStage(stage);
      todoDAO.saveTodo(alert);
    }
  }
  // SMS#87845 MR-074-2 AFCARS
  /**
   * This method performs additional validation on Adoption Finalized legal status when the primary child is in 
   * ADO or PAD stage. The objective is to ensure the child has proper adoption assistance agreement to process 
   * payment post finalization
   * @param csub46si
   */
  private void performAdoptionAssistanceValidationForNAF(CSUB46SI csub46si) {
    
    int idStage = csub46si.getUlIdStage();
    int idCase = csub46si.getUlIdCase();
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String cdStage = stage.getCdStage();
    String sndEventType = CodesTables.CEVNTTYP_SND;
    List<String> eventStatus = Arrays.asList(CodesTables.CEVTSTAT_PEND);
    int idChild = csub46si.getROWCSUB46SIG00().getUlIdPerson();
    Date dtLegalStatEff = DateHelper.toJavaDate(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
    List<Integer> idEventSpcNeedsDet = null;
    // Acceptable special needs determination status, for ADO stage
    List<String> sndApprovalTypesADO = new ArrayList<String>(Arrays.asList(CodesTables.CAPPSTS_Y, CodesTables.CAPPSTS_D));
    // Acceptable special needs determination status, for PAD stage
    List<String> sndApprovalTypesPAD = new ArrayList<String>(Arrays.asList(CodesTables.CAPPSTS_Y, CodesTables.CAPPSTS_N, CodesTables.CAPPSTS_D));
    
    // Find the number of pending approval Adoption Assistance Application (formerly known Special Needs Determination)
    // SMS#104219: find app in the case
    List<Event> pendAppList = eventDAO.findEventByIdCaseAndCdEventTypeDesc(idCase, sndEventType, eventStatus);
    if (pendAppList != null && pendAppList.size() > 0) {
      throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_PEND_ERR); 
    }  
    if (isFCStage(cdStage)) {
      // Special needs determination must exists. It can be approved or deferred
      idEventSpcNeedsDet = specialNeedsDeterminationDAO.findIdEventsByIdPersonIdCaseSpcNeedsDetType(idChild, idCase, sndApprovalTypesADO);
      if (idEventSpcNeedsDet == null || idEventSpcNeedsDet.size() == 0) {
        throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_APRV_ERR);
      }   
      // find all recurring adoption subsidies with special needs determination linked, and effective by legal status'
      // effective date, throws error if not found      
      findActiveAgreementEffectiveByDateForIncidentChild(csub46si, dtLegalStatEff);
    } else if (CodesTables.CSTAGES_PAD.equals(cdStage)) {
      // Special needs determination must exists. It can be approved, deferred, or denied (even though denied is not being considered valid selection for agreement at this point)
      idEventSpcNeedsDet = specialNeedsDeterminationDAO.findIdEventsByIdPersonIdCaseSpcNeedsDetType(idChild, idCase, sndApprovalTypesPAD);
      if (idEventSpcNeedsDet == null || idEventSpcNeedsDet.size() == 0) {
        throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_APRV_ERR_NI);
      }   
      // Whether the primary child is incident or non-incident child. If non-determined, returns null
      // Also note, all applications have either no selection or the same selection on the incident status
      SpecialNeedsDetermination snd = specialNeedsDeterminationDAO.findLatestAprvSpclDeterminationByIdStageIdPerson(idStage, idChild);

      
      if (snd == null || ArchitectureConstants.N.equals(snd.getIndIncidentChild())) {
        // when the status is not determined, use the most relaxed validation which is non-incident 
        findActiveAgreementEffectiveByDateForNonIncidentChild(csub46si, dtLegalStatEff);
      } else { 
        // incident PAD child: has the same logic with ADO
        findActiveAgreementEffectiveByDateForIncidentChild(csub46si, dtLegalStatEff);  
      }
    }
  }
  // SMS#87845 MR-074-2 AFCARS: 
  /**
   * This method is for ADO and incident PAD stage. 
   * This finds a complete MONTHLY agreement active on a specific date that is linked to a monthly application
   * If not found, throw error.
   * @param idAdptSubPerson
   * @param cdStage
   * @param dtEffBy
   */
  private void findActiveAgreementEffectiveByDateForIncidentChild(CSUB46SI csub46si, Date dtEffBy) {
    int idChild = csub46si.getROWCSUB46SIG00().getUlIdPerson();
    int idCase = csub46si.getUlIdCase();

    // Retrieve all monthly apps of approved or deferred app status; event status must be APRV
    List<SpecialNeedsDetermination> sndMonthlyList = specialNeedsDeterminationDAO.findApprovedDeferredMonthlyAppByIdCaseIdPerson(idCase, idChild);
    // Find active monthly agreement (COM adoption subsidy) at the time of LS effective date
    // One adoption subsidy can start on the day the previous one terminates so max number return is 2
    // Exclude adoption subsidy agreements start and terminate on the same day, per SSAU business validation
    List<AdoptionSubsidy> adoptSubRecurrList = adoptionSubsidyDAO
                                                                 .findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonCdAdptSubDetermAndDateEffBy(
                                                                                                                                        idCase, idChild,
                                                                                                                                        ServiceConstants.AA_AGREEMENT_RECURRING_FUNDING_TYPES,
                                                                                                                                        dtEffBy);
    // Active monthly agreement and/or approved/deferred monthly app not exist, error
    if ((sndMonthlyList == null || sndMonthlyList.isEmpty()) && (adoptSubRecurrList == null || adoptSubRecurrList.isEmpty())) {
      throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_AGMT_ERR);
    }
    // Active monthly agreement exists. It can be multiple; at least one must link to a monthly approved or deferred app
    boolean monthlyAgLinked = false; 
    for (AdoptionSubsidy ads : adoptSubRecurrList) {
      SpecialNeedsDetermination snd = ads.getSpecialNeedsDetermination();
      // If an active monthly agreement linked to monthly app, it is ok to finalize, stop checking
      if (sndMonthlyList.contains(snd)) {
        monthlyAgLinked = true;
        break;
      }
    }
    // If none of the monthly active agreements linked to a monthly app, it is error
    // Note, it may be converted cases, however still unacceptable, user is required to re-enter the agreement
    if (!monthlyAgLinked) {
      throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_AGMT_ERR);
    }
  }
  /**
   * This method is for non-incident PAD stage. 
   * This finds ANY complete agreement active on a specific date that is linked to a monthly application.
   * If not found, throw error
   * @param idAdptSubPerson
   * @param cdStage
   * @param dtEffBy
   */
  // SMS#87845 MR-074-2 AFCARS: 
  private void findActiveAgreementEffectiveByDateForNonIncidentChild(CSUB46SI csub46si, Date dtEffBy) {
    int idChild = csub46si.getROWCSUB46SIG00().getUlIdPerson();
    int idCase = csub46si.getUlIdCase();

    // Retrieve all monthly apps of approved or deferred app status; event status must be APRV
    List<SpecialNeedsDetermination> sndMonthlyList = specialNeedsDeterminationDAO.findApprovedDeferredMonthlyAppByIdCaseIdPerson(idCase, idChild);
    // Find all active monthly agreements by LS effective date, at most 2 exist (when finalized on the day one terminates and the next one begins)
    // Exclude adoption subsidy agreements start and terminate on the same day, per SSAU business validation
    List<AdoptionSubsidy> adoptSubRecurrList = adoptionSubsidyDAO
                                                           .findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonCdAdptSubDetermAndDateEffBy(
                                                                                                                   idCase, idChild,
                                                                                                                   ServiceConstants.AA_AGREEMENT_RECURRING_FUNDING_TYPES,
                                                                                                                   dtEffBy);
    // If no monthly application and no active monthly agreement, it is ok to finalize, so exit
    if ((sndMonthlyList == null || sndMonthlyList.isEmpty()) && (adoptSubRecurrList == null || adoptSubRecurrList.isEmpty())) { 
      return;
    }
    // No active agreement, checking for exception before throw error
    // It is error if approved or deferred monthly app exists without having active monthly agreement  
    if (adoptSubRecurrList == null || adoptSubRecurrList.isEmpty()) {
      if (sndMonthlyList != null && sndMonthlyList.size() > 0) {
            throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_APRV_AGMT_ERR_NI);
      }
    }
    // Active agreement exists. Can be multiple (2 at  most) because ag can terminate and start on the same day.
    // At least one must link to a monthly app
    else {
      boolean monthlyAgLinked = false;
      for (AdoptionSubsidy ads : adoptSubRecurrList) {
        SpecialNeedsDetermination snd = ads.getSpecialNeedsDetermination();
        // One active monthly agreement exists with correct linkage, stop checking 
        if (sndMonthlyList.contains(snd)) {
          monthlyAgLinked = true;
          break;
        }
      } 
      // No active monthly agreement linked to a monthly approved/deferred application. 
      // It may be converted data however still unacceptable
      if (!monthlyAgLinked) {
        throw new ServiceException(Messages.MSG_LEG_STAT_ADO_APP_AGMT_COMP_ERR_NI);
      }
    } // end active agreement exists
  }

}

