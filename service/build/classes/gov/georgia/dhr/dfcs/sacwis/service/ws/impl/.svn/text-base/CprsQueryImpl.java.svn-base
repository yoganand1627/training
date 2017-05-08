package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cedtype;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CprsOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanSecGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharAdultDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VisitPlanNarrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.CprsOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.MailCode;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomesDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;
import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CprsQuery;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsCaseListQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQueryCaseListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQueryCaseListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQuerySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscase.CprsQueryWO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscase.CprsQueryWO.Case;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscaseidlist.CprsQueryCaseListWO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

/*Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------

08/20/08  mxpatel           STGAP00009839: added the following logic to display the tpr/vs achieved date:
                            Choose the most recent of the two dates below for legal actions in COMP or APRV status.

                            1) Court/Action Date
                               Select the Court/Action Date where the Action Type equals any of the following list of values: "Voluntary Surrender by Adoptive Mother", "Voluntary Surrender by Adoptive Father", "Voluntary Surrender - Mother",  "Voluntary Surrender - Father".

                            2) Court Order Date
                               Select the Court Order Date where the Hearing Type/Court Order values are either "TPR-Father" or "TPR-Mother" and one of the Outcomes below are selected: "TPR Granted - Perm Custody to DHR", "TPR Granted - Perm Custody to Specified Relative for Adoption", "TPR Granted - Perm Custody to a 3rd Party"

                            Wrote the method "findTprVsAchievedDate(idCase, idPerson))" in legalActionDAOImpl.java to satisfy the above logic.
                 
12/19/08   charden          STGAP00010358: calling exscapeXml method on txt columns and address columns returned from the database to 
                            get rid of carriage returns and special characters
                            
04/16/09   bgehlot          STGAP00012856: Set two new fields (nbrPostReqCred and nbrPostReqEar) in outWtlpPlan, Added dtDecision in 
                            outPlacement, added flgDate in ccfAmdt, Wrapped Comment fileds with escapeXML method.
                            
04/15/09   cwells           STGAP00013155 setting the correct variables for in global data and pagemode so after save
                            to allow is dirty and checkForNew to work correctly.       
08/14/09   mchillman        STGAP00015114: Add selected indicator to output for Plans Goal Steps items    
09/09/09   vdevarak         STGAP00015341: Modified code to combine sqls to fix the session time out issue        
10/30/09   arege            SMS#38671 Modified method buldDiligentSearches to get correct name of the 
                            person who made the contact for diligent search.
12/08/09   hjbaptiste       SMS# 41275: Added new fields to the outPlacement object in buildPlacement() - adultChildConnectedTo, 
                            childConnectedToAnAdult, dtLTFCAgreementSigned and isLTFCPlacement for APPLA. Additionally added these new fields 
                            to the outPlacement object - isTempPlacement and tempPlacementType. Added the field dtStatusEffective to the child
                            object in buildPrimaryChild()                    
12/23/2009 mchillman        SMS#42212 Changed mapping for OngoingMedPsychTreatment
02/11/2010 hnguyen			SMS#43248 Fixing NullPointerException when build caretakers with incorrect FSU stage, 
							pulling correct FSU stage from current family plan event retrieved
08/03/2010 bgehlot          SMS# 65400 MR-068  Send the old value and new Code and Decode of the Assigned Judge on FCCP Case Plan detail page to the CPRS           
08/18/2010 wjcochran        SMS#58831: Changed retrieveSubStagesCases method to only retrieve the latest FCC Stage per child.
09/02/2010 wjcochran        SMS#58831: Made further modifications to retrieveSubStagesCases. Removed TreeSet and relegated
                            the sorting to the DAO method call.
10/01/2010 wjcochran        SMS#65873: Updated getStagePersonLinkForAPersonAndIdCaseAndCdStage to receive the latest FCF Stage information
11/22/2010 arege            SMS#82989/65873: Updated retrieveFCCPFamilyPlan to get latest FCF stage person link
12/01/2010 arege            SMS#82989/65873: Removed filter that returned only certain legal actions based on the hearingtype/courtorder
12/09/2010 htvo             SMS#81140 MR-074 AFCARS: remove code: caretaker's and child's characteristics moved into removal reasons
                            Add removal type
03/18/2011 schoi            SMS #97845: MR-074-2 Updated the code to retrieve the following three dates per new logic per AFCARS Phase 2;
                            Date TPR Filed, Date TPR/VS Achieved and TPR Appealed
03/31/2011 htvo             SMS #97845: MR-074-2 Modified TPR Filed as the most recent action date; removed Permanent custody outcome from 
                            TPR/VS Achieved as this date is not a final/achieved date as the name may suggest
0/07/2011  htvo             SMS #97845: MR-074-2 Per peer review: correct the sort option for TPR Filed to sort by court action date
07/07/2011 htvo             SMS#109405: MR-083 - updated with the new field 'Actively Recruiting?' on Exchange Child page; corrected to send 
                            Adoption data when stage is open instead of closed          
10/14/2011 hnguyen          STGAP00017012: MR-094 Update CPRS to send only the current visitation plans           
*/

public class CprsQueryImpl extends BaseServiceImpl implements CprsQuery{
  
  private StageDAO stageDAO = null;

  private EventDAO eventDAO = null;

  private FCCPFamilyDAO fccpFamilyDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private FccpChildDAO fccpChildDAO = null;

  private PersonDAO personDAO = null;

  private EducationalHistoryDAO educationalHistoryDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private MedicationDAO medicationDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PlacementDAO placementDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private ProfessionalAssmtDAO professionalAssmtDAO = null;

  private EmpJobHistoryDAO empJobHistoryDAO = null;

  private EmployeeDAO employeeDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private RemovalReasonDAO removalReasonDAO = null;

  private NeedsOutcomesDAO needsOutcomesDAO = null;

  private WtlpPlanDAO wtlpPlanDAO = null;

  private PlanGoalDAO planGoalDAO = null;

  private ResourcePhoneDAO resourcePhoneDAO = null;

  private YouthDetailDAO youthDetailDAO = null;

  private DiligentSearchDAO diligentSearchDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private RelativeCareAssmtDAO relativeCareAssmtDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private AdoInfoDAO adoInfoDAO = null;

  private PlanSecGoalDAO planSecGoalDAO = null;

  private PlanParticipantDAO planParticipantDAO = null;

  private ContactDAO contactDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private NeedsOutcomesDetailDAO needsOutcomesDetailDAO = null;

  private VisitPlanNarrDAO visitPlanNarrDAO = null;

  private TribalDAO tribalDAO = null;

  private ApproversDAO approversDAO = null;

  private CprsOutboundDAO cprsOutboundDAO = null;
  
  private ExchangeChildDAO exchangeChildDAO = null;
  
  private AdoInfoCbxSentDAO adoInfoCbxSentDAO = null;
  
  private PptDAO pptDAO = null;
  
  private ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO;
  
  private OutputLaunchEventLinkDAO outputLaunchEventLinkDAO = null;

  public static final String CHILD_DRUG_ABUSE = "CHILD DRUG ABUSE";

  public static final String CHILD_ALCOHOL_ABUSE = "CHILD ALCOHOL ABUSE";

  public static final String CHILD_BEHAVIOR_PROBLEM = "CHILD BEHAVIOR PROBLEM";

  public static final String CHILD_DISABILITY = "CHILD DISABILITY";

  public final static String CSTAGES_SUB = "SUB";

  public final static String RELATIVES = "RELATIVES";

  public final static String HEALTHCAREPROVIDERS = "HEALTHCAREPROVIDERS";

  public final static String INTERFACE_STATUS_NEW = "NEW";

  public final static String INTERFACE_STATUS_INP = "INP";

  public final static String INTERFACE_STATUS_SENT = "SNT";

  public final static String INTERFACE_STATUS_ERROR = "ERR";

  public final static String STATE_GA = "GA";

  public final static String FAIL_TO_DECOMPRESS = "Failed to decompress data.";

  public final static String EMPTY_STRING = "";

  public final static String DELIMITER = " | ";
  
  public static final int    EIGHTEEN = 18;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setRemovalReasonDAO(RemovalReasonDAO removalReasonDAO) {
    this.removalReasonDAO = removalReasonDAO;
  }

  public void setNeedsOutcomesDAO(NeedsOutcomesDAO needsOutcomesDAO) {
    this.needsOutcomesDAO = needsOutcomesDAO;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setYouthDetailDAO(YouthDetailDAO youthDetailDAO) {
    this.youthDetailDAO = youthDetailDAO;
  }

  public void setDiligentSearchDAO(DiligentSearchDAO diligentSearchDAO) {
    this.diligentSearchDAO = diligentSearchDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO relativeCareAssmtDAO) {
    this.relativeCareAssmtDAO = relativeCareAssmtDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public void setPlanSecGoalDAO(PlanSecGoalDAO planSecGoalDAO) {
    this.planSecGoalDAO = planSecGoalDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) {
    this.planParticipantDAO = planParticipantDAO;
  }

  public void setNeedsOutcomesDetailDAO(NeedsOutcomesDetailDAO needsOutcomesDetailDAO) {
    this.needsOutcomesDetailDAO = needsOutcomesDetailDAO;
  }

  public void setVisitPlanNarrDAO(VisitPlanNarrDAO visitPlanNarrDAO) {
    this.visitPlanNarrDAO = visitPlanNarrDAO;
  }

  public void setTribalDAO(TribalDAO tribalDAO) {
    this.tribalDAO = tribalDAO;
  }

  public void setCprsOutboundDAO(CprsOutboundDAO cprsOutboundDAO) {
    this.cprsOutboundDAO = cprsOutboundDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }
  
  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }
  
  public CprsQuerySO performCPRSQuery(CprsQuerySI cprsQuerySI) {
    return collectCaseData(retrieveCases(cprsQuerySI));
  }
  
  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setAdoInfoCbxSentDAO(AdoInfoCbxSentDAO adoInfoCbxSentDAO) {
    this.adoInfoCbxSentDAO = adoInfoCbxSentDAO;
  }

  
  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
    this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  public void setOutputLaunchEventLinkDAO(OutputLaunchEventLinkDAO outputLaunchEventLinkDAO) {
    this.outputLaunchEventLinkDAO = outputLaunchEventLinkDAO;
  }

  public CprsQueryCaseListSO retrieveCPRSCaseList(CprsCaseListQuerySI cprsCaseListQuerySI) {
    CprsQueryCaseListSO returnList = new CprsQueryCaseListSO();
    List<CprsOutbound> cprsOutboundCaseList = retrieveCprsOutboundCases(cprsCaseListQuerySI);
    int count = 0;
    if (cprsOutboundCaseList != null && cprsOutboundCaseList.size() > 0) {
      List<CprsQueryCaseListWO.CaseData> caseList = new ArrayList<CprsQueryCaseListWO.CaseData>();
      for (Iterator<CprsOutbound> it = cprsOutboundCaseList.iterator(); it.hasNext();) {
        CprsQueryCaseListWO.CaseData outCase = new CprsQueryCaseListWO.CaseData();
        CprsOutbound cprsOutboundCase = it.next();
        try {
          Integer caseId = cprsOutboundCase.getIdCase();
          outCase.setCaseId(caseId.toString());
          outCase.setCounty(cprsOutboundCase.getCdCounty());
          outCase.setDateLastModified(cprsOutboundCase.getDtLastUpdate());
          CapsCase capsCase = getPersistentObject(CapsCase.class, caseId);
          outCase.setCaseName(capsCase.getNmCase());
          outCase.setDateGenerated(new Date());
          List<Stage> stageLst = retrieveSubStagesCases(caseId.intValue());
          if (stageLst != null && stageLst.size() > 0) {
            List<CprsQueryCaseListWO.Name> primaryChildren = new ArrayList<CprsQueryCaseListWO.Name>();
            for (Iterator<Stage> itStage = stageLst.iterator(); itStage.hasNext();) {
              Stage stage = itStage.next();
              Person primaryChildPerson = retrievePrimaryChild(stage.getIdStage());
              CprsQueryCaseListWO.Name name = new CprsQueryCaseListWO.Name();
              name.setLastName(primaryChildPerson.getNmPersonLast());
              name.setFirstName(primaryChildPerson.getNmPersonFirst());
              name.setMiddleName(primaryChildPerson.getNmPersonMiddle());
              primaryChildren.add(name);
            }
            outCase.setPrimaryChildren(primaryChildren);
            count++;
          }
        } catch (Throwable t) {
          outCase.setMessage("Error processing case: " + t.toString());     
          t.printStackTrace();
        }
        caseList.add(outCase);
      }
      returnList.setCases(caseList);
    }
    returnList.setMessage(Integer.toString(count) + " : cases have been processed out of " + Integer.toString(cprsOutboundCaseList.size()));
    return returnList;
  }
  
  public CprsQuerySO retrieveCPRSCases(CprsQueryCaseListSI cprsQueryCaseListSI) {
    return collectCaseData(cprsQueryCaseListSI.getCaseIdList());
  }
  
  @SuppressWarnings(value = "unchecked")
  public CprsQuerySO collectCaseData(List<Integer> caseLst) {
    CprsQuerySO so = new CprsQuerySO();
    if (caseLst != null && caseLst.size() > 0) {
      List<Case> outCasesLst = new ArrayList<CprsQueryWO.Case>();
      List<Integer> processedCaseList = new ArrayList<Integer>();
      for (Iterator<Integer> it = caseLst.iterator(); it.hasNext();) {
        CprsQueryWO.Case outCaseItem = new CprsQueryWO.Case();
        Integer caseId = it.next();
        int caseIdint = caseId.intValue();
        outCaseItem.setCaseId(caseId.toString());
        outCaseItem.setDateGenerated(new Date());
        try {
          CapsCase capsCase = getPersistentObject(CapsCase.class, caseId);
          outCaseItem.setCaseName(capsCase.getNmCase());
          outCaseItem.setCounty(capsCase.getCdCaseCounty());
          // get the sub stages
          List<Stage> stageLst = retrieveSubStagesCases(caseIdint);
          if (stageLst != null && stageLst.size() > 0) {
            List<CprsQueryWO.Stage> outStageLst = new ArrayList<CprsQueryWO.Stage>();
            for (Iterator<Stage> itStage = stageLst.iterator(); itStage.hasNext();) {
              Stage stage = itStage.next();
              CprsQueryWO.Stage outStageItem = new CprsQueryWO.Stage();
              outStageItem.setCounty(stage.getCdStageCnty());
              outStageItem.setStageId(stage.getIdStage());
              int stageId = stage.getIdStage().intValue();
              Stage fSUStag = null;
  
              Person primaryChildPerson = retrievePrimaryChild(stageId);
              int primaryChildId = primaryChildPerson.getIdPerson().intValue();
              FccpChild fccpChild = getFccpChildData(stageId);
              outStageItem.setChildPlanId((fccpChild != null) ? fccpChild.getIdEvent() : null);
  
              FccpFamily fccpFamily = retrieveFCCPFamilyPlan(caseIdint, primaryChildId);
              FccpFamily aftercarefccpFamily = retrieveAftercareFCCPFamilyPlan(caseIdint, primaryChildId);
              Eligibility eligibility = retrieveEligibility(stageId, primaryChildId);
  
              NeedsOutcomes needsOutcomes = getNeedsAndOutcomeData(stageId);
              CnsrvtrshpRemoval cnsrRemoval = getCnsrvtrshpRemovalData(caseIdint, primaryChildId);
              LegalStatus legalStatus = retrieveLegalStatusData(primaryChildId);
              WtlpPlan wtlpPlan = retrieveWTLPData(stageId, primaryChildId);
              YouthDetail youthDetail = retrieveYouthDetail(primaryChildId);
  
              outStageItem.setCaseTracking(buildCaseTracking(fccpFamily, fccpChild, cnsrRemoval, legalStatus, caseIdint,
                                                             primaryChildId));
              outStageItem.setRemoval(buildRemoval(fccpFamily, fccpChild, cnsrRemoval));
              outStageItem.setAsfa(buildASFA(fccpChild));
              if (fccpFamily != null) {
            	fSUStag = fccpFamily.getEvent().getStage(); // retrieve correct FSU stage from Family Plan event
                outStageItem.setFamilyPlanId(fccpFamily.getIdEvent());
                outStageItem.setFamilyPlanStatus(fccpFamily.getEvent().getCdEventStatus());
                int fccpFamilyId = fccpFamily.getIdEvent().intValue();
                outStageItem.setReunificationPlanGoals(buildReunificationPlanGoals(fccpFamilyId));
                outStageItem.setNonReunificationPlanGoals(buildNonReunificationPlanGoals(fccpFamilyId));
                outStageItem.setSecondaryGoals(buildSecondaryGoals(fccpFamilyId));
                outStageItem.setReviewMeth(fccpFamily.getCdRevTyp());
                outStageItem.setCareTakers(buildCaretakers(fccpFamilyId, fSUStag));
                
                if(fSUStag != null){
                  outStageItem.setRelatives(buildRelativesInStage(fSUStag.getIdStage(), fccpFamilyId, primaryChildId));
                }
              }
  
              if (fccpChild != null) {
                outStageItem.setChildPlanId(fccpChild.getIdEvent());
                outStageItem.setChildPlanStatus(fccpChild.getEvent().getCdEventStatus());
                outStageItem.setDcsPlanGoalsPlanGoals(buildDfcsStandardGoalsPlanGoals(fccpChild.getIdEvent()));
              }
  
              if (aftercarefccpFamily != null) {
              	fSUStag = aftercarefccpFamily.getEvent().getStage(); // retrieve correct FSU stage from Family Plan event
                outStageItem
                            .setAfterCarePlanGoalsPlanGoals(buildAfterCarePlanGoalsPlanGoals(aftercarefccpFamily
                                                                                                                .getIdEvent()
                                                                                                                .intValue()));
              }
              outStageItem.setNonreunification(buildNonreunification(fccpChild));
  
              List<Placement> placements = retrievePlacements(caseId, primaryChildId);
              Placement currentPlacemnt = retrieveCurrentPlacement(placements);
  
              outStageItem.setCurrentPlacement(buildPlacement(currentPlacemnt, caseId, stageId, fccpChild, needsOutcomes,
                                                              primaryChildPerson));
  
              outStageItem.setPriorPlacements(buildPlacementHistory(placements, caseId, stageId, primaryChildPerson));
              outStageItem.setHealthCareProviders(buildHealtCareProviders(primaryChildId, caseId, stageId));
              outStageItem.setCaseManagers(buildCaseManagersInfo(stageId));
              outStageItem.setPrimaryChild(buildPrimaryChild(primaryChildPerson, legalStatus, fccpFamily, placements));
              outStageItem.setWtlp(buildWTLPData(wtlpPlan, youthDetail, primaryChildPerson, eligibility, legalStatus, currentPlacemnt));
              outStageItem.setEducation(buildEducationalHistory(caseId, primaryChildId, needsOutcomes, stageId,
                                                                currentPlacemnt));
              outStageItem.setHealthStatus(buildHealthStatus(caseId, primaryChildId, fccpChild));
              outStageItem.setDiligentSearches(buldDiligentSearches(caseId, primaryChildId, stageId));
              outStageItem.setAdoption(buildAdoption(caseId, primaryChildId));
              outStageItem.setParticipation(buildParticipation(fccpFamily, eligibility));
              
              outStageItem.setAftercare(buildAftercare(fSUStag, primaryChildId, aftercarefccpFamily, currentPlacemnt));
              outStageItem.setCcfAmdt(buildCCFAMDT(needsOutcomes, fccpFamily));
              outStageItem.setVisitationPlans(buildVisitationPlans(primaryChildId, stageId));
              outStageLst.add(outStageItem);
            }
            outCaseItem.setStages(outStageLst);
          }
          processedCaseList.add(caseId);
        } catch (Throwable t) {
          outCaseItem.setMessage("Error processing case: " + t.toString());     
          updateCase(caseId, "PROC_ERR");
          t.printStackTrace();
        }
        outCasesLst.add(outCaseItem);
      }
      so.setCases(outCasesLst);
      if(processedCaseList.size() > 0){
        updateCases(processedCaseList);
      }
      so.setMessage(Integer.toString(processedCaseList.size()) + " : cases have been processed out of " + Integer.toString(outCasesLst.size()));
    } else {
      so.setMessage("No cases to process");
    }
    return so;
  }

  private List<Integer> retrieveCases(CprsQuerySI cprsQuerySI) {
    String county = cprsQuerySI.getCounty();
    String strDate = cprsQuerySI.getSearchDateStr();
    if ((county != null && county.length() > 0) && (strDate != null && strDate.length() > 0)) {
      Date searchDate = DateHelper.toJavaDateSafe(strDate);
      if (searchDate != null) {
        return cprsOutboundDAO.findCasesForCountyAndDate(county, searchDate);
      }
    }
    return null;
  }
  
  private List<CprsOutbound> retrieveCprsOutboundCases(CprsCaseListQuerySI cprsCaseListQuerySI) {
    String county = cprsCaseListQuerySI.getCounty();
    Date searchDate = cprsCaseListQuerySI.getSearchDate();
    if (searchDate != null) {
      return cprsOutboundDAO.findCprsOutboundCasesForCountyAndDate(county, searchDate);
    }
    return null;
  }

  private void updateCases(List<Integer> caseIds) {
    cprsOutboundDAO.updateProcessedCases(caseIds, null);
  }
  
  private void updateCase(Integer caseId, String error) {
    cprsOutboundDAO.updateProcessedCase(caseId, error);
  }

  private CprsQueryWO.Child buildPrimaryChild(Person primaryChild, LegalStatus legalStatus, FccpFamily fccpFamily,
                                              List<Placement> placements) {
    if (primaryChild != null) {
      int primaryChildId = primaryChild.getIdPerson().intValue();
      CprsQueryWO.Child child = new CprsQueryWO.Child();
      child.setIdPerson(primaryChild.getIdPerson());
      child.setLastName(primaryChild.getNmPersonLast());
      child.setFirstName(primaryChild.getNmPersonFirst());
      child.setMiddlename(primaryChild.getNmPersonMiddle());
      child.setRace(retrievePersonRaceData(primaryChildId));
      child.setHispanicOrign(retrievePersonEthnicityData(primaryChildId));
      child.setBirthdate(primaryChild.getDtPersonBirth());
      child.setGender(primaryChild.getCdPersonSex());
      child.setSsn(primaryChild.getNbrPersonIdNumber());
      if (legalStatus != null) {
        child.setLegalStatus(legalStatus.getCdLegalStatStatus());
        child.setDtStatusEffective(legalStatus.getDtLegalStatStatusDt());
      }


      if (fccpFamily != null) {
        child.setPermPlanType(fccpFamily.getCdPlanType());
        //MR-068 Still send the Old value
        child.setAssignedJudge(escapeXML(fccpFamily.getNmAssgnJudge()));
        //MR-068 Send Code and Decode to the CPRS
        String cdAssgnJudgeCode = "";
        if(fccpFamily.getCdAssgnJudge() != null){
          cdAssgnJudgeCode = fccpFamily.getCdAssgnJudge();
        }
        child.setAssignedJudgeCode(escapeXML(cdAssgnJudgeCode));
        child.setAssignedJudgeDecode(Lookup.simpleDecodeSafe(CodesTables.CJUDGES, cdAssgnJudgeCode));
        child.setInitOrReview(fccpFamily.getIndInitReview());
      }

      return child;
    }
    return null;
  }

  private List<CprsQueryWO.CareTaker> buildCaretakers(int fccpFamilyId, Stage fSUStag ) {
    List<CprsQueryWO.CareTaker> careTakers = new ArrayList<CprsQueryWO.CareTaker>();
    List<EventPersonLink> evtPeople = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(fccpFamilyId);
    if (evtPeople != null && evtPeople.size() > 0) {
      for (Iterator<EventPersonLink> it = evtPeople.iterator(); it.hasNext();) {
        EventPersonLink evtPerson = it.next();
        if ("Y".equals(evtPerson.getIndCaregiver()) == true) {
          CprsQueryWO.CareTaker outCT = new CprsQueryWO.CareTaker();
          Person inCT = personDAO.findPersonByIdPerson(evtPerson.getPerson().getIdPerson()); //evtPerson.getPerson();
          
          outCT.setIdPerson(inCT.getIdPerson());
          outCT.setLastName(inCT.getNmPersonLast());
          outCT.setFirstName(inCT.getNmPersonFirst());
          outCT.setMiddlename(inCT.getNmPersonMiddle());
          outCT.setPhoneNumber(inCT.getNbrPersonPhone());
          outCT.setBirthdate(inCT.getDtPersonBirth());
          outCT.setSsn(inCT.getNbrPersonIdNumber());
          outCT.setComment(escapeXML(inCT.getTxtPersonAddlCmnts()));
          PersonAddress personAddress = personAddressDAO.findCurrentPrimaryPersonAddressByIdPerson(inCT.getIdPerson()
                                                                                                       .intValue());
          if (personAddress != null) {
            outCT.setAddress1(escapeXML(personAddress.getAddrPersAddrStLn1()));
            outCT.setAddress2(personAddress.getAddrPersAddrStLn2());
            outCT.setCity(personAddress.getAddrPersonAddrCity());
            outCT.setCounty(personAddress.getCdPersonAddrCounty());
            outCT.setState(personAddress.getCdPersonAddrState());
            outCT.setZip(personAddress.getAddrPersonAddrZip());
          }
          if(fSUStag != null) {
            StagePersonLink spl = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(inCT.getIdPerson(), fSUStag.getIdStage().intValue());
            outCT.setRelType(spl.getCdStagePersRelInt());
          }
          careTakers.add(outCT);
        }
      }
    }

    return ((careTakers.size() > 0) ? careTakers : null);
  }

  private List<CprsQueryWO.Relative> buildRelativesInStage(int stageId, int fccpFamilyId, int primaryChildId) {
    List<StagePersonLink> stagePersonList = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(stageId, CodesTables.CPRSNTYP_PRN);
    Map<Integer, StagePersonLink> stagePersonMap = null;
    if (stagePersonList != null && stagePersonList.size() > 0) {
      stagePersonMap = new HashMap<Integer, StagePersonLink>();
      for (Iterator<StagePersonLink> it = stagePersonList.iterator(); it.hasNext();) {
        StagePersonLink spl = it.next();
        Person relPer = spl.getPerson();
        stagePersonMap.put(relPer.getIdPerson(), spl);
      }
    }
    
    List<EventPersonLink> fccpPersonLink = retrieveFFCPPrincipals(fccpFamilyId);
    
    if (fccpPersonLink != null && fccpPersonLink.size() > 0) {
      List<CprsQueryWO.Relative> relList = new ArrayList<CprsQueryWO.Relative>();
      for (Iterator<EventPersonLink> it = fccpPersonLink.iterator(); it.hasNext();) {
        EventPersonLink epl = it.next();
        StagePersonLink spl = stagePersonMap.get(epl.getPerson().getIdPerson());
        if(spl != null){
          Person relPer = spl.getPerson();
          if((relPer != null) && (relPer.getIdPerson().intValue() != primaryChildId) &&
                          (("Y".equals(epl.getIndCaregiver()) == true) || 
                           (DateHelper.getAge(relPer.getDtPersonBirth()) >= EIGHTEEN))) {
            CprsQueryWO.Relative relOut = new CprsQueryWO.Relative();
            relOut.setIdPerson(relPer.getIdPerson());
            relOut.setRelType(spl.getCdStagePersRelInt());
            relOut.setLastName(relPer.getNmPersonLast());
            relOut.setFirstName(relPer.getNmPersonFirst());
            relOut.setMiddlename(relPer.getNmPersonMiddle());
            relOut.setPhoneNumber(relPer.getNbrPersonPhone());
            relOut.setComment(escapeXML(relPer.getTxtPersonAddlCmnts()));
            PersonAddress personAddress = personAddressDAO.findCurrentPrimaryPersonAddressByIdPerson(relPer.getIdPerson()
                                                                                                           .intValue());
            if (personAddress != null) {
              relOut.setAddress1(escapeXML(personAddress.getAddrPersAddrStLn1()));
              relOut.setAddress2(personAddress.getAddrPersAddrStLn2());
              relOut.setCity(personAddress.getAddrPersonAddrCity());
              relOut.setCounty(personAddress.getCdPersonAddrCounty());
              relOut.setState(personAddress.getCdPersonAddrState());
              relOut.setZip(personAddress.getAddrPersonAddrZip());
            }
            Tribal trib = tribalDAO.findLatestTribal(relPer.getIdPerson().intValue());
            relOut.setTribalMember((trib != null) ? (trib.getIndTrblMember()) : (null));
            
            relOut.setSideOfFamily(spl.getCdPersonSideOfFamily());
  
            relList.add(relOut);
          }
        }
      }
      if (relList.size() > 0) {
        return relList;
      }
    }
    return null;
  }

  private List<CprsQueryWO.CaseManager> buildCaseManagersInfo(int stageId) {
    List<CprsQueryWO.CaseManager> caseMangers = new ArrayList<CprsQueryWO.CaseManager>();
    CprsQueryWO.CaseManager primaryCaseManager = retrieveCaseManagerInfo(stageId, CodesTables.CSTFROLS_PR);
    if (primaryCaseManager != null) {
      primaryCaseManager.setPrimary(true);
      caseMangers.add(primaryCaseManager);
    }

    CprsQueryWO.CaseManager secondaryCaseManager = retrieveCaseManagerInfo(stageId, CodesTables.CSTFROLS_SE);
    if (secondaryCaseManager != null) {
      secondaryCaseManager.setPrimary(false);
      caseMangers.add(secondaryCaseManager);
    }

    return caseMangers;
  }

  private CprsQueryWO.CaseManager retrieveCaseManagerInfo(int stageId, String role) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                               stageId,
                                                                                                               role,
                                                                                                               CodesTables.CPRSNALL_STF);
    if (stagePersonLink != null) {
      CprsQueryWO.CaseManager outCaseManger = new CprsQueryWO.CaseManager();
      Person caseMngr = stagePersonLink.getPerson();
      outCaseManger.setLastName(caseMngr.getNmPersonLast());
      outCaseManger.setFirstName(caseMngr.getNmPersonFirst());
      outCaseManger.setIdPerson(caseMngr.getIdPerson().intValue());

      int idCaseMngr = caseMngr.getIdPerson().intValue();
      Office office = getEmployeeOffice(idCaseMngr);
      String officePhone = null;
      if (office != null) {
        MailCode mailCode = office.getMailCode();
        if (mailCode != null) {
          outCaseManger.setAddress1(escapeXML(mailCode.getAddrMailCodeStLn1()));
          outCaseManger.setAddress2(mailCode.getAddrMailCodeStLn2());
          outCaseManger.setCity(mailCode.getAddrMailCodeCity());
          outCaseManger.setState(STATE_GA);
          outCaseManger.setZip(mailCode.getAddrMailCodeZip());
          outCaseManger.setCounty(mailCode.getAddrMailCodeCounty());
          officePhone = mailCode.getNbrMailCodePhone();
        }
      }

      PersonAddress personAddress = personAddressDAO.findCurrentPrimaryPersonAddressByIdPerson(idCaseMngr);
      if (personAddress != null) {
        outCaseManger.setEmailAddress(escapeXML(personAddress.getTxtPersonEmail()));
      }
      
      Map<String, String> phones = getPersonOfficePhones(idCaseMngr);
      String personWorkPhone = phones.get(CodesTables.CPHNTYP_BS);
      if(personWorkPhone != null && personWorkPhone.length() > 0){
        outCaseManger.setPhoneNumber(personWorkPhone);
      } else {
        outCaseManger.setPhoneNumber(officePhone);
      }
      
      List<Map> mapList = getEmpJobHistory(idCaseMngr);
      if(mapList != null && mapList.size() > 0) {
        Map map = mapList.get(0); // currently there is only one entry per employee in EmpJobHistory for Georgia
        if(map != null) {
          Integer intSupervisorId = (Integer) map.get("personByIdJobPersSupv");
          if(intSupervisorId != null) {
            int idSupervisor = intSupervisorId.intValue();
            Person supervisor = personDAO.findPersonByIdPerson(idSupervisor);
            if (supervisor != null) {
              outCaseManger.setSupervisorLastName(supervisor.getNmPersonLast());
              outCaseManger.setSupervisorFirstName(supervisor.getNmPersonFirst());
              outCaseManger.setSupervisorPhoneNumber(supervisor.getNbrPersonPhone());
            }
          }
        }
      }
      return outCaseManger;
    }
    return null;
  }

  private String retrievePersonRaceData(int idPerson) {
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
    StringBuffer raceList = new StringBuffer();
    if (personRaceList != null && personRaceList.size() > 0) {
      for (Iterator<PersonRace> it = personRaceList.iterator(); it.hasNext();) {
        PersonRace personRace = it.next();
        raceList.append(personRace.getCdRace());
        if (it.hasNext()) {
          raceList.append(DELIMITER);
        }
      }
    }
    return raceList.toString();
  }

  private String retrievePersonEthnicityData(int idPerson) {
    PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);
    if (personEthnicity != null) {
      return personEthnicity.getCdEthnicity();
    }
    return null;
  }

  private CprsQueryWO.WTLP buildWTLPData(WtlpPlan wtlpPlan, YouthDetail youthDetail, Person primaryChild,
                                         Eligibility eligib, LegalStatus legalStatus, Placement placement) {

    CprsQueryWO.WTLP outWtlpPlan = null;
    if (wtlpPlan != null || youthDetail != null || legalStatus != null) {
      outWtlpPlan = new CprsQueryWO.WTLP();
    }
    if (wtlpPlan != null) {
      outWtlpPlan.setMaritalStatus(primaryChild.getCdPersonMaritalStatus());
      outWtlpPlan.setType(wtlpPlan.getCdPlanType());
      outWtlpPlan.setPlacementAuth(wtlpPlan.getCdPlcmtAuth());
      outWtlpPlan.setVoluntaryCmmt(escapeXML(wtlpPlan.getTxtVoluntary()));
      outWtlpPlan.setEducation(wtlpPlan.getCdEdu());
      outWtlpPlan.setVocEduPrep(wtlpPlan.getCdVoc());
      outWtlpPlan.setBasicDailyLiving(wtlpPlan.getCdBasic());
      outWtlpPlan.setPersonalDevCouns(wtlpPlan.getCdPers());
      outWtlpPlan.setHealthEduMain(wtlpPlan.getCdHealth());
      outWtlpPlan.setWtlpDt(wtlpPlan.getDtWtlp());
      outWtlpPlan.setDurFromDt(wtlpPlan.getDtFrom());
      outWtlpPlan.setDurToDt(wtlpPlan.getDtTo());
      outWtlpPlan.setStrengths(escapeXML(wtlpPlan.getTxtStrengths()));
      outWtlpPlan.setNeeds(escapeXML(wtlpPlan.getTxtNeeds()));

      Person ydpCor = wtlpPlan.getPersonByIdYdpCoord();
      if (ydpCor != null) {
        outWtlpPlan.setYdcFirstName(ydpCor.getNmPersonFirst());
        outWtlpPlan.setYdcLastName(ydpCor.getNmPersonLast());
        outWtlpPlan.setYdcMiddleName(ydpCor.getNmPersonMiddle());
        outWtlpPlan.setYdcSuffix(ydpCor.getCdPersonSuffix());
        outWtlpPlan.setYdcPhone(ydpCor.getNbrPersonPhone());
      }

      List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(wtlpPlan.getIdEvent().intValue(), "WTL");
      if (planGoalList != null && planGoalList.size() > 0) {
        outWtlpPlan.setGoals(retrievePlanGoal(planGoalList));
      }

      if (eligib != null) {
        outWtlpPlan.setEligibilty(eligib.getCdEligActual());
      }
      
      if(placement != null) {
        outWtlpPlan.setLivingArrg(placement.getCdPlcmtType());
      }
    }

    if (youthDetail != null) {
      outWtlpPlan.setEmancipDiscComments(escapeXML(youthDetail.getTxtEmncDisc()));
      outWtlpPlan.setEmancipDiscDt(youthDetail.getDtEmncDisc());
      outWtlpPlan.setExceptedHSGradDt(youthDetail.getDtSchGrad());
      outWtlpPlan.setAcadTrack(youthDetail.getCdAcadTrack());
      outWtlpPlan.setCreditsReq((youthDetail.getNbrSchCreditReqd() != null) ? youthDetail.getNbrSchCreditReqd()
                                                                                         .toString() : null);
      outWtlpPlan.setCreditsEarned((youthDetail.getNbrSchCreditEarned() != null) ? youthDetail.getNbrSchCreditEarned()
                                                                                              .toString() : null);
      outWtlpPlan.setParentalStatus(youthDetail.getCdParStat());
      
      //STGAP00012856: Added these two fields.
      outWtlpPlan.setNbrPostReqCred(youthDetail.getNbrPostReqCred());
      outWtlpPlan.setNbrPostReqEar(youthDetail.getNbrPostReqEar());
    } 

    if (legalStatus != null) {
      outWtlpPlan.setCustodyStatus(legalStatus.getCdLegalStatStatus());
    }

    return outWtlpPlan;
  }

  private List<CprsQueryWO.PlanGoal> buildReunificationPlanGoals(int fccpFamilyPlanId) {
    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(fccpFamilyPlanId, CodesTables.CCTPLNTY_REU);
    if (planGoalList != null && planGoalList.size() > 0) {
      return retrievePlanGoal(planGoalList);
    }
    return null;
  }

  private List<CprsQueryWO.PlanGoal> buildNonReunificationPlanGoals(int fccpFamilyPlanId) {
    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(fccpFamilyPlanId, CodesTables.CCTPLNTY_NRE);
    if (planGoalList != null && planGoalList.size() > 0) {
      return retrievePlanGoal(planGoalList);
    }
    return null;
  }

  private List<CprsQueryWO.PlanGoal> buildAfterCarePlanGoalsPlanGoals(int fccpFamilyPlanId) {
    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(fccpFamilyPlanId, CodesTables.CCTPLNTY_AFC);
    if (planGoalList != null && planGoalList.size() > 0) {
      return retrievePlanGoal(planGoalList);
    }
    return null;
  }

  private List<CprsQueryWO.PlanGoal> buildDfcsStandardGoalsPlanGoals(int fccpFamilyPlanId) {
    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(fccpFamilyPlanId, "DFC");
    if (planGoalList != null && planGoalList.size() > 0) {
      return retrievePlanGoal(planGoalList);
    }
    return null;
  }
  
  private Ppt getTeamMeetingReviewData(int idStage, String cdPptType) {
    return pptDAO.findLatestPptByIdStageByCdEventTypeByCdPptType(idStage, CodesTables.CEVNTTYP_PPT,
                                                                            cdPptType);
  }

  private List<CprsQueryWO.SecondaryGoal> buildSecondaryGoals(int fccpFamilyPlanId) {
    List<PlanSecGoal> fosterCareSecGoalsList = planSecGoalDAO.findFosterCareSecGoalsList(fccpFamilyPlanId);
    if (fosterCareSecGoalsList != null && fosterCareSecGoalsList.size() > 0) {
      List<CprsQueryWO.SecondaryGoal> planSecGoalLst = new ArrayList<CprsQueryWO.SecondaryGoal>();
      for (Iterator<PlanSecGoal> it = fosterCareSecGoalsList.iterator(); it.hasNext();) {
        PlanSecGoal inPSC = it.next();
        CprsQueryWO.SecondaryGoal outPSG = new CprsQueryWO.SecondaryGoal();
        outPSG.setDesc(escapeXML(inPSC.getTxtDesc()));
        outPSG.setStatus(inPSC.getCdStat());
        outPSG.setPrntAppv(inPSC.getIndPrntAppv());
        planSecGoalLst.add(outPSG);
      }
      return planSecGoalLst;
    }
    return null;
  }

  private CprsQueryWO.CaseTracking buildCaseTracking(FccpFamily fccpFamily, FccpChild fccpChild,
                                                     CnsrvtrshpRemoval cnsrRemoval, LegalStatus legalStatus,
                                                     int idCase, int idPerson) {
    CprsQueryWO.CaseTracking caseTracking = new CprsQueryWO.CaseTracking();

    if (fccpFamily != null) {
      caseTracking.setCurrentCasePlanReviewDt(fccpFamily.getDtCurrRev());
      caseTracking.setPreviousReviewDt(fccpFamily.getDtPrevRev());
      caseTracking.setNextReviewDt(fccpFamily.getDtNextReview());
      caseTracking.setInitialCasePlanDt(fccpFamily.getDtOrigSub());
      caseTracking.setAnticaptedDateOfAchievingPermDt(fccpFamily.getDtPermAchvd());
      caseTracking.setPermPlan(fccpFamily.getCdPrimPermPlan());
      caseTracking.setPermPlanCompReason(escapeXML(fccpFamily.getTxtPrimCompRsns()));
      caseTracking.setConcurrentPermPlan(fccpFamily.getCdSecndPermPlan());
      caseTracking.setConcurrentpermPlanCompReason(escapeXML(fccpFamily.getTxtSecndCompRsns()));
    }

    if (fccpChild != null) {
      caseTracking.setDiligentSearchCompletedDt(fccpChild.getDtDilgntComp());
    }

    if (cnsrRemoval != null) {
      caseTracking.setChildRemovalDt(cnsrRemoval.getDtRemoval());
    }

    if (legalStatus != null) {
      caseTracking.setCustExpirationDt(legalStatus.getDtLegalStatCusExpDt());
    }

    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_ADJ); // Adjudicatory
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_DIS); // Dispositional
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_DTH); // Detention Hearing (72hr)
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_ETO); // Extension Order
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_NRE); // Non-Reunification
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_PRM); // Permanency
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_SHC); // Shelter Care
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_SUP); // Supplemental
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPR); // TPR
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_FDP); //Final Disposition

    List<CprsQueryWO.LegalActionItem> outLegalItemList = new ArrayList<CprsQueryWO.LegalActionItem>();
    //SMS#82989/65873:Used new method to find all legal actions for the case and the person.
    List<LegalAction> legalActionList = legalActionDAO.findLegalActionByIdCaseByIdPerson(idCase, idPerson);                                                                                                  
    List<String> cdOutcomes = new ArrayList<String>();
    cdOutcomes.add(CodesTables.CLEGLOUT_DSR); // Diligent Search Ruling Granted
    cdOutcomes.add(CodesTables.CLEGLOUT_IAP); // Initial authorization for placement
    
    
    List<LegalAction> legalActonOutComeList = legalActionDAO
                                                            .findLegalActionLatestObjectsByIdCaseByIdPersonByCdOutcomes(
                                                                                                                        idCase,
                                                                                                                        idPerson,
                                                                                                                        cdOutcomes);
    
    
    if (legalActonOutComeList != null && legalActonOutComeList.size() > 0) {
      if (legalActionList != null ) {
        legalActionList.addAll(legalActonOutComeList);
      } else {
        legalActionList = legalActonOutComeList;
      }
    }
    
    if (legalActionList != null && legalActionList.size() > 0) {
      for (Iterator<LegalAction> it = legalActionList.iterator(); it.hasNext();) {
        LegalAction legalAction = it.next();
   
        CprsQueryWO.LegalActionItem outLegalItem = new CprsQueryWO.LegalActionItem();
        outLegalItem.setActionType(legalAction.getCdLegalActAction());
        outLegalItem.setCrtType(legalAction.getCdCrtType());
        outLegalItem.setHrType(legalAction.getCdHrTypCrtOrd());

        outLegalItem.setCrtDt(legalAction.getDtCrtActDate());
        outLegalItem.setFiledDt(legalAction.getDtLegalActDateFiled());
        outLegalItem.setOutcomeDt(legalAction.getDtCrtOrdDate());

        outLegalItem.setContinDt(legalAction.getDtContinDate());
        outLegalItem.setNxtHearDt(legalAction.getDtNxtHearDate());
        outLegalItem.setPubDt(legalAction.getDtPubDate());
        outLegalItem.setShelterCareAuthDt(legalAction.getDtShelterCareAuth());

        Collection<LegalActionOutcome> outcomes = legalAction.getLegalActionOutcomes();
        if (outcomes != null && outcomes.size() > 0) {
          List<String> strOutcomes = new ArrayList<String>();
          for (Iterator<LegalActionOutcome> itOutcome = outcomes.iterator(); itOutcome.hasNext();) {
            LegalActionOutcome outcome = itOutcome.next();
            strOutcomes.add(outcome.getCdOutcome());
          }
          outLegalItem.setOutcomes(strOutcomes);
        }
        outLegalItemList.add(outLegalItem);
        if (CodesTables.CLHECOT_DIS.equals(legalAction.getCdHrTypCrtOrd()) == true) {
          caseTracking.setFinalDispositionDate(retrieveApprovalDateOfLglActionByHearingTypeCrtOrds(legalAction));
        }
      }
    }
    if (outLegalItemList.size() > 0) {
      caseTracking.setLegalActions(outLegalItemList);
    }
    
    // SMS #97845: MR-074-2
    String cdLegalActAction = CodesTables.CLEGCPS_PFD; // Petition Filed
    cdHrTypCrtOrds.clear();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Biological and Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Biological Mother
    // SMS #97845: MR-074-2
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father

    // SMS #97845: MR-074-2
    // Date TPR Filed: Retrieve the most recent Court Action Date where:
    // 1. Legal Action Type = PFD (Petition Filed) AND
    // 2. Hearing/Court Order Type is one of the TPRs (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, 
    //    TFB – TPR Biological Father, TFF – TPR Legal Father, TFL – TPR Biological and Legal Father, 
    //    TPM – TPR Biological Mother, TPP – TPR Putative Father)
    // Sort by Court Action Date Desc (using "A" parameter)
    
    LegalAction legalActionTPRFiled = legalActionDAO
                                                    .findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                                                 idCase,
                                                                                                                 idPerson,
                                                                                                                 cdHrTypCrtOrds,
                                                                                                                 cdLegalActAction,
                                                                                                                 "A");
    if (legalActionTPRFiled != null) {
      caseTracking.setTprFiledDate(legalActionTPRFiled.getDtCrtActDate());
    }

    // SMS #97845: MR-074-2
    // (NOTE: No code change made per the enhancement above in this block; only comment was updated for clarification) 
    // TPR Appealed: Retrieve the most recent Court Action Date where:
    // 1. Legal Action Type = APL (Appeal)) AND
    // 2. Hearing/Court Order Type is one of the TPRs (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, 
    //    TFB – TPR Biological Father, TFF – TPR Legal Father, TFL – TPR Biological and Legal Father, 
    //    TPM – TPR Biological Mother, TPP – TPR Putative Father)
    // Sort by Court Actoin Date Desc (using "A" parameter)
    // End of SMS #97845: MR-074-2 (Comment update only)
    cdLegalActAction = CodesTables.CLEGCPS_APL; // TPR Appeal
    LegalAction lglActTPRAppealed = legalActionDAO
                                                  .findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                                                     idCase,
                                                                                                                     idPerson,
                                                                                                                     cdLegalActAction,
                                                                                                                     cdHrTypCrtOrds,
                                                                                                                      "A");
    //STGAP00012856: Set the TPR Appealed field to Yes if the DtCrtActDate is not null
    if (lglActTPRAppealed != null) {
      Date dtTPRAppealed = lglActTPRAppealed.getDtCrtActDate();
      if (dtTPRAppealed != null) {
        caseTracking.setTprAppealedDate(dtTPRAppealed);
        caseTracking.setTprAppealed("Yes");
      }
    } 
    // SMS #97845: MR-074-2
    // Display "No" if the TPR Appealed date doesn't exist
    else {
      caseTracking.setTprAppealed("No");
    }

    // SMS #97845: MR-074-2
    // Removed unused code
    
    // SMS #97845: MR-074-2
    // Retrieve the Date TPR/VS Achieved
    Date lglActTPRAchieved = null;
    lglActTPRAchieved = retrieveLegalActionTPRAchieved(idCase, idPerson);
    caseTracking.setTprVsAchievedDate(lglActTPRAchieved);
    // End of SMS #97845: MR-074-2
            
    return caseTracking;    
  }
  
  
  private CprsQueryWO.Removal buildRemoval(FccpFamily fccpFamily, FccpChild fccpChild, CnsrvtrshpRemoval cnsrRemoval) {
    if (cnsrRemoval != null) {
      CprsQueryWO.Removal outRemoval = new CprsQueryWO.Removal();
      outRemoval.setDescriptionOfIncident(escapeXML(cnsrRemoval.getTxtDescriptionOfIncident()));
      outRemoval.setRemovalDt(cnsrRemoval.getDtRemoval());
      outRemoval.setRemovalType(cnsrRemoval.getCdRemovalType());

      if (fccpChild != null) {
        outRemoval.setEffrtsToPreventRemoval(escapeXML(fccpChild.getTxtEffrtsRem()));
      }

      if (fccpFamily != null) {
        outRemoval.setHarmIfRemains(escapeXML(fccpFamily.getTxtHarm()));
        outRemoval.setRsnsNoHomeProtection(escapeXML(fccpFamily.getTxtRsnsProt()));
      }

      List<String> removalLst = new ArrayList<String>();
      int eventId = cnsrRemoval.getIdRemovalEvent();

      List<RemovalReason> listRemovalReasons = removalReasonDAO.findListOfRemovalReasonByIdEvent(eventId);
      if (listRemovalReasons != null && listRemovalReasons.size() > 0) {
        for (Iterator<RemovalReason> it = listRemovalReasons.iterator(); it.hasNext();) {
          RemovalReason reason = it.next();
          removalLst.add(reason.getId().getCdRemovalReason());
        }
      }
      // SMS#81140 MR-074 AFCARS: caretaker's and child's characteristics moved into removal reasons
      /*List<RemovalCharAdult> listRemovalReasonsCharAdult = removalCharAdultDAO
                                                                              .findRemovalCharAdultByIdRemovalEvent(eventId);
      if (listRemovalReasonsCharAdult != null && listRemovalReasonsCharAdult.size() > 0) {
        for (Iterator<RemovalCharAdult> it = listRemovalReasonsCharAdult.iterator(); it.hasNext();) {
          RemovalCharAdult reason = it.next();
          removalLst.add(reason.getId().getCdRemovAdultChar());
        }
      }

      List<RemovalCharChild> listRemovalCharChild = removalCharChildDAO.findRemovalCharChildByIdRemovalEvent(eventId);
      if (listRemovalCharChild != null || listRemovalCharChild.size() > 0) {
        for (Iterator<RemovalCharChild> removalCharChildIt = listRemovalCharChild.iterator(); removalCharChildIt
                                                                                                                .hasNext();) {
          RemovalCharChild removalCharChild = removalCharChildIt.next();
          removalLst.add(removalCharChild.getId().getCdRemovChildChar());
        }
      }*/

      outRemoval.setRemovalReasons(removalLst);
      return outRemoval;
    }

    return null;
  }

  List<CprsQueryWO.Placement> buildPlacementHistory(List<Placement> placements, int caseId, int stageId, Person child) {
    placements = retrievePriorPlacements(placements);
    if (placements != null && placements.size() > 0) {
      List<CprsQueryWO.Placement> retList = new ArrayList<CprsQueryWO.Placement>();
      for (Iterator<Placement> it = placements.iterator(); it.hasNext();) {
        retList.add(buildPlacement(it.next(), caseId, stageId, null, null, child));
      }
      return retList;
    }
    return null;
  }

  private CprsQueryWO.Placement buildPlacement(Placement placement, int caseId, int stageId, FccpChild fccpChild,
                                               NeedsOutcomes needsOutcome, Person child) {

    if ((placement != null)) {
      CprsQueryWO.Placement outPlacement = new CprsQueryWO.Placement();

      if (placement != null) {
        outPlacement.setEventId(placement.getEvent().getIdEvent());
        outPlacement.setEventStatus(placement.getEvent().getCdEventStatus());
        outPlacement.setAddress1(escapeXML(placement.getAddrPlcmtLn1()));
        outPlacement.setAddress2(placement.getAddrPlcmtLn2());
        outPlacement.setCity(placement.getAddrPlcmtCity());
        outPlacement.setState(placement.getAddrPlcmtSt());
        outPlacement.setZip(placement.getAddrPlcmtZip());
        outPlacement.setCounty(placement.getAddrPlcmtCnty());
        outPlacement.setHomePhone(placement.getNbrPlcmtTelephone());
        if (placement.getPersonByIdPlcmtAdult() != null) {
          StagePersonLink stagePersonLink = getStagePersonLinkForAPersonAndIdCaseAndCdStage(
                                                                                            caseId,
                                                                                            CodesTables.CSTAGES_SUB,
                                                                                            placement
                                                                                                     .getPersonByIdPlcmtAdult()
                                                                                                     .getIdPerson()
                                                                                                     .intValue());
          if(stagePersonLink != null) {
            String relationship = stagePersonLink.getCdStagePersRelInt();
            outPlacement.setRelationship(relationship);
            if (isRelativeToVictim(relationship) == true) {
              outPlacement.setRelativeName(stagePersonLink.getPerson().getNmPersonFull());
            }
            Map<String, String> phones = getPersonOfficePhones(stagePersonLink.getPerson().getIdPerson().intValue());
            outPlacement.setOfficePhone(phones.get(CodesTables.CPHNTYP_BS));
            outPlacement.setMobliePhone(phones.get(CodesTables.CPHNTYP_BC));
            outPlacement.setFax(phones.get(CodesTables.CPHNTYP_BF));
          }
          
          Map relativeCareAssmtData = getRelativeCareAssmt(placement, stageId);
          if (relativeCareAssmtData != null && !relativeCareAssmtData.isEmpty()) {
            outPlacement.setDfcsHomeAssmtResults((String) relativeCareAssmtData.get("cdAssmtResults"));
            outPlacement.setDfcsHomeAssmtResultCompletedDt((Date) relativeCareAssmtData.get("dtComplete"));
            
            //STGAP00012856: Added escapeXML
            outPlacement.setDfcsHomeAssmtResultCmmts(escapeXML((String) relativeCareAssmtData.get("txtComments")));
            
            //STGAP00012856: Added dtDecision
            outPlacement.setDtDecision((Date) relativeCareAssmtData.get("dtDecision"));
          }

        } else if (placement.getCapsResourceByIdRsrcAgency() != null) {
          CapsResource capsResource = placement.getCapsResourceByIdRsrcAgency();
          if (capsResource != null) {
            Map<String, String> phones = getResourceOfficePhones(capsResource.getIdResource().intValue());
            outPlacement.setOfficePhone(phones.get(CodesTables.CRSCPHON_01));
            outPlacement.setMobliePhone(phones.get(CodesTables.CRSCPHON_02));
            outPlacement.setFax(phones.get(CodesTables.CRSCPHON_03));
          }
        } else if (placement.getCapsResourceByIdRsrcFacil() != null) {
          CapsResource capsResource = placement.getCapsResourceByIdRsrcAgency();
          if (capsResource != null) {
            Map<String, String> phones = getResourceOfficePhones(capsResource.getIdResource().intValue());
            outPlacement.setOfficePhone(phones.get(CodesTables.CRSCPHON_01));
            outPlacement.setMobliePhone(phones.get(CodesTables.CRSCPHON_02));
            outPlacement.setFax(phones.get(CodesTables.CRSCPHON_03));
          }
        }

        outPlacement.setEnteredDt(placement.getDtPlcmtStart());
        outPlacement.setExitedDt(placement.getDtPlcmtEnd());
        outPlacement.setType(placement.getCdPlcmtType());
        outPlacement.setSafeSetting(placement.getIndPlcmtSafe());
        outPlacement.setLeastRestrictive(placement.getIndPlcmtRestr());
        outPlacement.setMostFamilyLike(placement.getIndPlcmtFam());
        outPlacement.setPlcmtAppro(placement.getIndPlcmtAppr());
        outPlacement.setCloseProxToParents(placement.getIndPlcmtProx());
        outPlacement.setConsistChildBestInter(placement.getIndPlcmtCasePlan());
        outPlacement.setNotExp(escapeXML(placement.getTxtPlcmtChecklist()));

        outPlacement.setIs14Older("N");
        Date birthDate = child.getDtPersonBirth();
        if (birthDate != null && isPersonOverThisAge(birthDate, 14)) {
          outPlacement.setIs14Older("Y");
        }
        
        
        if (ArchitectureConstants.Y.equals(placement.getIndLTFCPlacement())) {
          outPlacement.setIsLTFCPlacement(ArchitectureConstants.Y);
        } else {
          outPlacement.setIsLTFCPlacement(ArchitectureConstants.N);
        }
        if (ArchitectureConstants.Y.equals(placement.getIndPlcmtEmerg())) {
          outPlacement.setIsTempPlacement(ArchitectureConstants.Y);
        } else {
          outPlacement.setIsTempPlacement(ArchitectureConstants.N);
        }
        if (ArchitectureConstants.Y.equals(placement.getIndChildConnectAdult())) {
          outPlacement.setChildConnectedToAnAdult(ArchitectureConstants.Y);
        } else {
          outPlacement.setChildConnectedToAnAdult(ArchitectureConstants.N);
        }
        outPlacement.setDtLTFCAgreementSigned(placement.getDtLTFCAgreementSigned());
        String nmPersonFull = "";
        Person connectedAdult = placement.getConnectedAdult();
        if (connectedAdult != null) {
          nmPersonFull = connectedAdult.getNmPersonFull();
        }
        outPlacement.setAdultChildConnectedTo(nmPersonFull);
        outPlacement.setTempPlacementType(placement.getCdTempType());
        
        
        outPlacement.setStayWithSiblings(placement.getIndPlcmtSibling());
        outPlacement.setStayWithSiblingsCmmt(escapeXML(placement.getTxtPlcmtSibling()));

        outPlacement.setChangeSchDist(placement.getIndPlcmtSchDist());
        outPlacement.setChangeSchDistCmmt(escapeXML(placement.getTxtPlcmtChecklist()));
        outPlacement.setParentNotifiedDate(placement.getDtPlcmtParentsNotif());
        outPlacement.setChildResponse(escapeXML(placement.getTxtPlcmtDiscussion()));
        outPlacement.setPrePlaceVisitDt(placement.getDtPlcmtPreplaceVisit());
        outPlacement.setDiscussedWithChildDate(placement.getDtPlcmtChildDiscuss());
        outPlacement.setEmergencyPlacement(placement.getIndPlcmtEmerg());
        outPlacement.setChildexpTraumaDueToPlac(placement.getIndPlcmtTrauma());
        outPlacement.setChildexpTraumaDueToPlacCmmt(escapeXML(placement.getTxtPlcmtTrauma()));
        outPlacement.setPsychInfoDt(placement.getDtPsyInfo());
        outPlacement.setMedInfoDt(placement.getDtPlcmtMeddevHistory());
        outPlacement.setEducInfoDt(placement.getDtPlcmtEducLog());
        outPlacement.setChildEduNotProvidedCmmts(escapeXML(placement.getTxtPlcmtDocuments()));
        outPlacement.setSchlRecGivenToCGDt(placement.getDtPlcmtSchoolRecords());
        outPlacement.setPlcmtCPGivenToCGDt(placement.getDtPlcmtCaregvrDiscuss());
        outPlacement.setRecNotGivenToCGCmmts(escapeXML(placement.getTxtPlcmtDocuments()));

       
        outPlacement.setRemovalReason(placement.getCdPlcmtRemovalRsn());
        outPlacement.setCCCFAPlacementMatch(placement.getIndPlcmtCcfa());
        //STGAP00012856: Added escapeXML
        outPlacement.setCCCFAPlacementComment(escapeXML(placement.getCdPlcmtCcfa()));
        if (needsOutcome != null) {
          outPlacement.setCCCFAPlacementRec(escapeXML(needsOutcome.getTxtPlcmtRec()));
        }

        if (fccpChild != null) {
          outPlacement.setExhaustiveSearchPerformed(fccpChild.getIndDilgntSrch());
          outPlacement.setAdjustingToCare(fccpChild.getIndChildAdjCare());
          outPlacement.setNotAdjustingToCareCmmt(escapeXML(fccpChild.getTxtChildAdjComm()));
        }

        if (needsOutcome != null) {
          outPlacement.setRefCCFADt(needsOutcome.getDtReferral());
        }
      }
      return outPlacement;
    }
    return null;
  }

  List<Placement> retrievePlacements(int caseId, int idPrimaryChild) {
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    maxDate = DateHelper.addToDate(maxDate, 1, 1, 1);
    return placementDAO.findPlacementHistoryByIdPersonByIdCase(caseId, idPrimaryChild, maxDate);
  }

  Placement retrieveCurrentPlacement(List<Placement> placements) {
    if (placements != null && placements.size() > 0) {
      Placement placement = placements.get(0);
      if (DateHelper.isNull(placement.getDtPlcmtEnd()) == true) {
        return placement;
      }
    }
    return null;
  }

  List<Placement> retrievePriorPlacements(List<Placement> placements) {
    if (placements != null && placements.size() > 0) {
      Placement placement = placements.get(0);
      Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
      if (DateHelper.isEqual(maxDate, placement.getDtPlcmtEnd()) == true) {
        if(placements.size() > 1) {
          return placements.subList(1, (placements.size()));
        } else {
          return null;
        }
      }
    } else {
      return null;
    }
    return placements;
  }

  private Map getRelativeCareAssmt(Placement currentPlacement, int idStageSUB) {

    Map relativeCareAssmtData = null;
    if (currentPlacement != null) {
      String cdPlacementType = currentPlacement.getCdPlcmtType();
      if (CodesTables.CPLMNTYP_REU.equals(cdPlacementType) || // non paid relative
          CodesTables.CPLMNTYP_ICR.equals(cdPlacementType) || CodesTables.CPLMNTYP_RFH.equals(cdPlacementType)) {
        relativeCareAssmtData = relativeCareAssmtDAO.findRelativeCareAssmtByIdStage(idStageSUB);
      } else if (CodesTables.CPLMNTYP_REP.equals(cdPlacementType) // paid relative
      // || CodesTables.CPLMNTYP_NRP.equals(cdPlacementType)
      ) {
        relativeCareAssmtData = relativeCareAssmtDAO
                                                    .findRelativeCareAssmtByIdStageByIdPerson(
                                                                                              idStageSUB,
                                                                                              currentPlacement
                                                                                                              .getPersonByIdPlcmtAdult()
                                                                                                              .getIdPerson()
                                                                                                              .intValue());
      }
    }
    return relativeCareAssmtData;
  }

  private CprsQueryWO.CCFAMDT buildCCFAMDT(NeedsOutcomes needsOutcome, FccpFamily fccpFamily) {
    CprsQueryWO.CCFAMDT ccfAmdt = new CprsQueryWO.CCFAMDT();
    if (needsOutcome != null) {
      ccfAmdt.setRefDt(needsOutcome.getDtReferral());

      ccfAmdt.setAgencyName(needsOutcome.getNmAgency());
      ccfAmdt.setIndName(needsOutcome.getNmAssessor());
      ccfAmdt.setIndTitle(escapeXML(needsOutcome.getTxtAssessorTitle()));

      ccfAmdt.setAssmtCmpltDt(needsOutcome.getDtAsstCmplt());
      ccfAmdt.setPlcmtRes(escapeXML(needsOutcome.getTxtPlcmtRec()));
      List<NeedsOutcomesDetail> nODLst = needsOutcomesDetailDAO
                                                               .findNeedsAndOutcomesDetailList(needsOutcome
                                                                                                           .getIdEvent()
                                                                                                           .intValue());
      if (nODLst != null && nODLst.size() > 0) {
        List<CprsQueryWO.CCFAMDTDetail> detailsLst = new ArrayList<CprsQueryWO.CCFAMDTDetail>();
        for (Iterator<NeedsOutcomesDetail> it = nODLst.iterator(); it.hasNext();) {
          NeedsOutcomesDetail nod = it.next();
          CprsQueryWO.CCFAMDTDetail outDet = new CprsQueryWO.CCFAMDTDetail();
          outDet.setComment(escapeXML(nod.getTxtComments()));
          outDet.setSerRec(escapeXML(nod.getTxtSvcRec()));
          outDet.setIdentNeed(escapeXML(nod.getTxtIdenNeed()));
          outDet.setSerPro(escapeXML(nod.getTxtSvcProv()));
          detailsLst.add(outDet);
        }
        ccfAmdt.setDetails(detailsLst);
      }
    }
    
    if (fccpFamily != null) {
      Event evt = fccpFamily.getEvent();
      if(evt != null) {
        Stage stage = evt.getStage();
        if(stage != null) {
          int idStage = stage.getIdStage().intValue();
          Ppt tmFTM = getTeamMeetingReviewData(idStage, CodesTables.CMEETTYP_FTM);
          if (tmFTM != null) {
            ccfAmdt.setPreDt(tmFTM.getDtPptDate());
          }
          
          Ppt tmMDT = getTeamMeetingReviewData(idStage, CodesTables.CMEETTYP_MDT);
          if (tmMDT != null) {
            ccfAmdt.setMdtDate(tmMDT.getDtPptDate());
          }
          
          //STGAP00012856: Set the date for CMEETTYP_FLG
          Ppt tmFLG = getTeamMeetingReviewData(idStage, CodesTables.CMEETTYP_FLG);
          if (tmFLG != null) {
            ccfAmdt.setFlgDate(tmFLG.getDtPptDate());
          }
        }
      }
    }
    
    return ccfAmdt;
  }

  private CprsQueryWO.ASFA buildASFA(FccpChild fccpChild) {
    if (fccpChild != null) {
      CprsQueryWO.ASFA outASFA = new CprsQueryWO.ASFA();
      outASFA.setDetails(escapeXML(fccpChild.getTxtAfsa()));

      int eventId = fccpChild.getEvent().getIdEvent().intValue();
      List<FccpChildCbx> childplancbxASFA1List = fccpChildDAO
                                                             .findchildcheckboxbyIdEventandCbxCodeType(
                                                                                                       eventId,
                                                                                                       CodesTables.CCPTASF1);
      List<FccpChildCbx> childplancbxASFA2List = fccpChildDAO
                                                             .findchildcheckboxbyIdEventandCbxCodeType(
                                                                                                       eventId,
                                                                                                       CodesTables.CCPTASF2);

      if (childplancbxASFA1List != null && childplancbxASFA1List.size() > 0) {
        List<CprsQueryWO.Item> itemLst = new ArrayList<CprsQueryWO.Item>();
        for (Iterator<FccpChildCbx> it = childplancbxASFA1List.iterator(); it.hasNext();) {
          FccpChildCbx cb = it.next();
          CprsQueryWO.Item item = new CprsQueryWO.Item();
          item.setName(cb.getCdCbxCodeType());
          item.setValue(cb.getCdCbx());
          itemLst.add(item);
        }
        outASFA.setItems(itemLst);
      }
      if (childplancbxASFA2List != null && childplancbxASFA2List.size() > 0) {
        List<CprsQueryWO.Item> itemLst = new ArrayList<CprsQueryWO.Item>();
        for (Iterator<FccpChildCbx> it = childplancbxASFA2List.iterator(); it.hasNext();) {
          FccpChildCbx cb = it.next();
          CprsQueryWO.Item item = new CprsQueryWO.Item();
          item.setName(cb.getCdCbxCodeType());
          item.setValue(cb.getCdCbx());
          itemLst.add(item);
        }
        List<CprsQueryWO.Item> itemLst1 = outASFA.getItems();
        if (itemLst1 != null) {
          itemLst.addAll(itemLst1);
        }
        outASFA.setItems(itemLst);
      }

      return outASFA;
    }
    return null;
  }

  private CprsQueryWO.Nonreunification buildNonreunification(FccpChild fccpChild) {
    if (fccpChild != null) {
      CprsQueryWO.Nonreunification outNonreunification = new CprsQueryWO.Nonreunification();
      outNonreunification.setWillDFCSFileTPR(fccpChild.getIndTpr());
      outNonreunification.setDCSFileTPRDt(fccpChild.getDtTpr());
      outNonreunification.setTPRExp(escapeXML(fccpChild.getTxtTpr()));
      outNonreunification.setSteps(escapeXML(fccpChild.getTxtSteps()));
      outNonreunification.setAddtlInfo(escapeXML(fccpChild.getTxtAddtlInfo()));

      int eventId = fccpChild.getEvent().getIdEvent().intValue();
      List<FccpChildCbx> childplancbxList = fccpChildDAO.findchildcheckboxbyIdEventandCbxCodeType(eventId,
                                                                                                  CodesTables.CCPTNRUN);

      if (childplancbxList != null && childplancbxList.size() > 0) {
        List<CprsQueryWO.Item> itemLst = new ArrayList<CprsQueryWO.Item>();
        for (Iterator<FccpChildCbx> it = childplancbxList.iterator(); it.hasNext();) {
          FccpChildCbx cb = it.next();
          CprsQueryWO.Item item = new CprsQueryWO.Item();
          item.setName(cb.getCdCbxCodeType());
          item.setValue(cb.getCdCbx());
          itemLst.add(item);
        }
        outNonreunification.setItems(itemLst);
      }

      return outNonreunification;
    }
    return null;
  }

  private CprsQueryWO.Participation buildParticipation(FccpFamily fccpFamily, Eligibility elig) {
    if (fccpFamily != null || elig != null) {
      CprsQueryWO.Participation part = new CprsQueryWO.Participation();
      if (fccpFamily != null) {
        part.setParentPart(fccpFamily.getIndPrntPrtcpt());
        part.setParentPartCmmt(escapeXML(fccpFamily.getTxtPrntPrtcpt()));
        part.setChildPart(fccpFamily.getIndChildPrtcpt());
        part.setChildPartCmmt(escapeXML(fccpFamily.getTxtChildPrtcpt()));
        part.setParentRefToSign(fccpFamily.getIndPrntPresent());
        part.setHearReqDt(fccpFamily.getDtHearingReqstd());
        part.setHearReqCmmt(escapeXML(fccpFamily.getTxtHearingRequestCmnts()));

        List<PlanParticipant> ppLst = planParticipantDAO.findPlanParticipantByIdEvent(fccpFamily.getIdEvent()
                                                                                                .intValue());
        if (ppLst != null && ppLst.size() > 0) {
          List<CprsQueryWO.Participant> outPartLst = new ArrayList<CprsQueryWO.Participant>();
          for (Iterator<PlanParticipant> it = ppLst.iterator(); it.hasNext();) {
            PlanParticipant pp = it.next();
            CprsQueryWO.Participant outPart = new CprsQueryWO.Participant();
            Person person = pp.getPerson();
            if (person != null) {
              outPart.setNameFirst(person.getNmPersonFirst());
              outPart.setNameMiddle(person.getNmPersonMiddle());
              outPart.setNameLast(person.getNmPersonLast());
            } else {
              outPart.setNameLast(pp.getNmPart());
            }
            outPart.setAgreedDt(pp.getDtAppv());
            outPart.setAgreed(pp.getIndAppv());
            outPart.setAgreedCmmt(escapeXML(pp.getTxtNoAppv()));
            outPart.setSignedDt(pp.getDtSign());
            outPart.setRelType(pp.getCdRel());
            outPartLst.add(outPart);
          }
          part.setParticipants(outPartLst);
        }
      }

      if (elig != null) {
        part.setCseref(elig.getIndEligCsupSend());
        part.setCserefCmmt(escapeXML(elig.getTxtChildSuppRefComment()));
      }
      return part;
    }
    return null;
  }

  private List<CprsQueryWO.PlanGoal> retrievePlanGoal(List<PlanGoal> planGoalList) {
    if (planGoalList != null && planGoalList.size() > 0) {
      List<CprsQueryWO.PlanGoal> outPlanGoalList = new ArrayList<CprsQueryWO.PlanGoal>();
      for (Iterator<PlanGoal> it = planGoalList.iterator(); it.hasNext();) {
        PlanGoal planGoal = it.next();
        CprsQueryWO.PlanGoal outPlanGoal = new CprsQueryWO.PlanGoal();
        outPlanGoal.setGoal(escapeXML(planGoal.getTxtGoal()));
        outPlanGoal.setType(planGoal.getCdGoalTyp());
        outPlanGoal.setReason(planGoal.getCdGoalRsn());
        Collection<PlanStep> planStepList = planGoal.getPlanSteps();
        if (planStepList != null && planStepList.size() > 0) {
          List<CprsQueryWO.PlanStep> outPlanStepList = new ArrayList<CprsQueryWO.PlanStep>();
          for (Iterator<PlanStep> itPS = planStepList.iterator(); itPS.hasNext();) {
            PlanStep planStep = itPS.next();
            CprsQueryWO.PlanStep outPlanStep = new CprsQueryWO.PlanStep();
            outPlanStep.setPriority(escapeXML(planStep.getTxtPriority()));
            outPlanStep.setRespParty(escapeXML(planStep.getTxtRspns()));
            outPlanStep.setToBeCompDt(planStep.getDtAntComp());
            outPlanStep.setComment(escapeXML(planStep.getTxtStepComm()));
            outPlanStep.setDescription(escapeXML(planStep.getTxtStep()));
            outPlanStep.setStatus(planStep.getCdStatus());
            outPlanStep.setIndSelected(planStep.getIndSelected());
            outPlanStepList.add(outPlanStep);
          }
          outPlanGoal.setSteps(outPlanStepList);
        }
        outPlanGoalList.add(outPlanGoal);
      }
      return outPlanGoalList;
    }
    return null;
  }

  private CprsQueryWO.HealthStatus buildHealthStatus(int caseId, int personId, FccpChild fccpChild) {
    CprsQueryWO.HealthStatus hs = new CprsQueryWO.HealthStatus();
    if (fccpChild != null) {
      hs.setImmunUTD(fccpChild.getIndImmUtd());
      hs.setReasonImmunNtUTD(escapeXML(fccpChild.getTxtImmUtd()));
      hs.setImmunOnFile(fccpChild.getIndImmOnfile());
      hs.setReasonImmunNtOnFile(escapeXML(fccpChild.getTxtImmOnfile()));
      hs.setOngoingMedPysch(fccpChild.getIndOngoingProb());
      hs.setMedPsychProblem(escapeXML(fccpChild.getTxtOngoingProb()));
      hs.setMedRecOnFile(fccpChild.getIndMedrecOnfile());
      hs.setReasonMedRecNtOnFile(escapeXML(fccpChild.getTxtMedrecOnfile()));
      hs.setPsychRecOnFile(fccpChild.getIndPsychOnfile());
      hs.setReasonPsychNtOnFile(escapeXML(fccpChild.getTxtPsychOnfile()));
      hs.setOngoingMedPsychTreatment(fccpChild.getIndPsychTreat());
      hs.setMedPsychTreatment(fccpChild.getIndPsychDoc());
      hs.setMissingEvalDates(escapeXML(fccpChild.getTxtEvalDates()));
      hs.setOtherRelNedInfo(escapeXML(fccpChild.getTxtRelevantMed()));
    }
    List<Map> medicationsList = medicationDAO.findMedicationCurrentlyOnByIdPerson(personId);
    if (medicationsList != null && medicationsList.size() > 0) {
      Iterator itr = medicationsList.iterator();
      List<CprsQueryWO.Medication> outMedList = new ArrayList<CprsQueryWO.Medication>();
      while (itr.hasNext()) {
        Map medication = (Map) (itr.next());
        CprsQueryWO.Medication med = new CprsQueryWO.Medication();
        med.setMedication(escapeXML((String) medication.get("nmMedctn")));
        med.setAdminPerson(escapeXML((String) medication.get("txtMedctnAdminPerson")));
        outMedList.add(med);
      }
      hs.setMedications(outMedList);
    }

    Collection<String> visitReasons = new ArrayList<String>();
    visitReasons.add(CodesTables.CARSAPPT_AIL); // Acute Illness
    visitReasons.add(CodesTables.CARSAPPT_CHI); // Chronic Illness
    visitReasons.add(CodesTables.CARSAPPT_PYL); // Physical Exam
    visitReasons.add(CodesTables.CARSAPPT_PYM); // Annual Medical Exam
    visitReasons.add(CodesTables.CARSAPPT_FUM); // Follow up Medical

    ProfessionalAssmt professionalAssmt = professionalAssmtDAO
                                                              .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(
                                                                                                                                caseId,
                                                                                                                                personId,
                                                                                                                                visitReasons);
    if (professionalAssmt != null) {
      hs.setLastMedExamDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_DAB);
    visitReasons.add(CodesTables.CARSAPPT_FUD);
    visitReasons.add(CodesTables.CARSAPPT_DAA);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setLastDentalExamDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_FUN);
    visitReasons.add(CodesTables.CARSAPPT_PHC);
    visitReasons.add(CodesTables.CARSAPPT_PHL);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setLastPyExamDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_MSC);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setLastMedScreenDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_DSC);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setLastDentalScreenDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_EPS);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setLastHealthCheckScreenDt(professionalAssmt.getDtProfAssmtAppt());
    }
    
    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_LLM);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      hs.setImmunDt(professionalAssmt.getDtProfAssmtAppt());
    }

    EducationalHistory edH = educationalHistoryDAO.findEducationalHistory(personId);
    if (edH != null) {
      hs.setEarlyIntervention(edH.getIndEis());
      hs.setEarlyInterventionCmmts(escapeXML(edH.getTxtEis()));
      hs.setPrevEarlyIntervention(edH.getIndPrevEis());
    }

    return hs;
  }

  private CprsQueryWO.EducationHistory buildEducationalHistory(int caseId, int personId, NeedsOutcomes needsOutcome,
                                                               int stageId, Placement currentPlacemnt) {
    EducationalHistory educationalHistory = educationalHistoryDAO.findEducationalHistory(personId);
    CprsQueryWO.EducationHistory outEducationHist = new CprsQueryWO.EducationHistory();
    if (educationalHistory != null && (Cedtype.CEDTYPE_NIS.equalsIgnoreCase(educationalHistory.getCdEdhistType()) == false)) {
      String inSchool = "Y";
      Date wdDate = educationalHistory.getDtEdhistWithdrawnDate();
      if (wdDate != null) {
        Date currentDate = new Date();
        if (wdDate.before(currentDate) == true) {
          inSchool = "N";
        }
      }
      outEducationHist.setChildInSchool(inSchool);

      outEducationHist.setChildNotInSchoolComment(escapeXML(educationalHistory.getTxtEdhistCmnts()));
      outEducationHist.setGradeLevel(educationalHistory.getCdCurrGrade());
      outEducationHist.setSchoolSystem(educationalHistory.getNmEdhistSchDist());
      outEducationHist.setSchoolName(escapeXML(educationalHistory.getNmEdhistSchool()));
      outEducationHist.setSchoolAddress1(escapeXML(educationalHistory.getAddrEdhistStreetLn1()));
      outEducationHist.setSchoolAddress2(educationalHistory.getAddrEdhistStreetLn2());
      outEducationHist.setSchoolCity(educationalHistory.getAddrEdhistCity());
      outEducationHist.setSchoolState(educationalHistory.getAddrEdhistState());
      outEducationHist.setSchoolZip(educationalHistory.getAddrEdhistZip());
      outEducationHist.setSchoolCounty(educationalHistory.getAddrEdhistCnty());
      outEducationHist
                      .setSchoolPhoneNumber(educationalHistory.getNbrEdhistPhone()
                                            + ((educationalHistory.getNbrEdhistPhoneExt() != null) ? (" " + educationalHistory
                                                                                                                              .getNbrEdhistPhoneExt())
                                                                                                  : ("")));

      CapsResource schRes = educationalHistory.getCapsResource();
      if (schRes != null) {
        Map<String, String> phones = getResourceOfficePhones(schRes.getIdResource().intValue());
        if (phones != null) {
          outEducationHist.setSchoolFaxNumber(phones.get(CodesTables.CRSCPHON_03));
        }
      }

      outEducationHist.setAttendance(educationalHistory.getCdAttendance());
      outEducationHist.setPerfAtGradeLevel(educationalHistory.getIndCurrGradeLevel());
      outEducationHist.setSpecialEdNeeds(educationalHistory.getIndSpcEduNeed());
      outEducationHist.setSpecialEdNeedsComment(escapeXML(educationalHistory.getTxtSpcEdu()));
      outEducationHist.setSchoolChanged(educationalHistory.getIndSchChg());
      outEducationHist.setSchoolRecords(educationalHistory.getIndSchRec());
      outEducationHist.setPrevSpecialEdServices(educationalHistory.getIndPrevEduNeed());
      outEducationHist.setStudentSuppTeamDt(educationalHistory.getDtSstRef());

      outEducationHist.setIndividEdPlanDt(educationalHistory.getDtEduPlan());
      outEducationHist.setIndividEdPlanSurrPrnt(escapeXML(educationalHistory.getNmSurrPrnt()));
      outEducationHist.setLegalPrntInvolved(educationalHistory.getIndLegalPrnt());
      outEducationHist.setSurrFosterPrnt(educationalHistory.getIndFstrPrnt());
      outEducationHist.setSurrLegalPrnt(educationalHistory.getIndLegalPrnt());
      outEducationHist.setSstCmmts(escapeXML(educationalHistory.getTxtSst()));
      outEducationHist.setNarrBeDispRec(escapeXML(educationalHistory.getTxtDscplComm()));
      outEducationHist.setRecBoardRec(educationalHistory.getIndRecBoard());
      outEducationHist.setRecInFileCmmt(escapeXML(educationalHistory.getTxtSchRecOnFileCmnt()));
      outEducationHist.setSchChgDuePlcmtCmmt(escapeXML(educationalHistory.getTxtSchCngCmnt()));

      String placement = null;
      String needs = educationalHistory.getCdEdhistNeeds1();

      if (needs != null) {
        placement = needs;
      }
      needs = educationalHistory.getCdEdhistNeeds2();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds3();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds4();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds5();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds6();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds7();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds8();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds9();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      needs = educationalHistory.getCdEdhistNeeds10();
      if (needs != null) {
        if (placement != null) {
          placement += (DELIMITER + needs);
        } else {
          placement = needs;
        }
      }
      outEducationHist.setClassPlac(placement);
    }

    Integer guidanceCons = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(stageId, CodesTables.CSRCRPTR_GR);
    if (guidanceCons != null) {
      Person person = personDAO.findPersonByIdPerson(guidanceCons);
      outEducationHist.setGuidConFirstName(person.getNmPersonFirst());
      outEducationHist.setGuidConLastName(person.getNmPersonLast());
    }

    Collection<String> visitReasons = new ArrayList<String>();
    visitReasons.add(CodesTables.CARSAPPT_DEA);
    ProfessionalAssmt professionalAssmt = professionalAssmtDAO
                                                              .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(
                                                                                                                                caseId,
                                                                                                                                personId,
                                                                                                                                visitReasons);
    if (professionalAssmt != null) {
      outEducationHist.setDevelAssmtCmmt(escapeXML(professionalAssmt.getTxtProfAssmtFindings()));
      outEducationHist.setDevelAssmtCompDt(professionalAssmt.getDtProfAssmtAppt());
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_DES);
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(caseId,
                                                                                                              personId,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      outEducationHist.setDevelScreenCmmt(escapeXML(professionalAssmt.getTxtProfAssmtFindings()));
      outEducationHist.setDevelScreenCmptDt(professionalAssmt.getDtProfAssmtAppt());
    }

    if (needsOutcome != null) {
      outEducationHist.setEduAssmnt(escapeXML(needsOutcome.getTxtCcfaEduAssmt()));
      outEducationHist.setEduAssmntDt(needsOutcome.getDtCcfaEduAssmt());
      outEducationHist.setEductnDevScrnCmmt(escapeXML(needsOutcome.getTxtUndSchoolageNoDevAss()));
      outEducationHist.setDevScrnAssmtCmmt(escapeXML(needsOutcome.getTxtUnder4NoDevSrcCmnt()));
    }

    if (currentPlacemnt != null) {
      outEducationHist.setSuppSpvsn(currentPlacemnt.getIndSpvsn());
      outEducationHist.setSuppSpvsnCmmt(escapeXML(currentPlacemnt.getTxtSpvsn()));
    }

    return outEducationHist;
  }

  private List<CprsQueryWO.DiligentSearch> buldDiligentSearches(int caseId, int idChildPrimary, int stageId) {

    List<DiligentSearch> diligentSearchList = diligentSearchDAO
                                                               .findDiligentSearchInfoBasedOnCaseIdStageIdByIdPersonDtl(
                                                                                                                        caseId,
                                                                                                                        stageId,
                                                                                                                        idChildPrimary);
    if (diligentSearchList != null && diligentSearchList.size() > 0) {
      List<CprsQueryWO.DiligentSearch> outDSList = new ArrayList<CprsQueryWO.DiligentSearch>();
      for (Iterator<DiligentSearch> it = diligentSearchList.iterator(); it.hasNext();) {
        DiligentSearch inDS = it.next();
        CprsQueryWO.DiligentSearch outDS = new CprsQueryWO.DiligentSearch();
        outDS.setRefType(inDS.getCdRefType());
        outDS.setRefCmmnts(escapeXML(inDS.getTxtOtherDesc()));
        outDS.setRefName(escapeXML(inDS.getTxtRefName()));
        outDS.setSuccCont(inDS.getIndSuccCont());
        outDS.setWnSuccCont(escapeXML(inDS.getTxtWhyCont()));
        outDS.setComment(escapeXML(inDS.getTxtComments()));
        outDS.setVisitRes(inDS.getIndVisitRsrc());
        outDS.setOutcomeCmmt(inDS.getCdCurrOutcome());
        outDS.setPlcmtRes(inDS.getIndPlcmtRsrc());
        outDS.setWnPlcmtRes(escapeXML(inDS.getTxtRsrc()));
        outDS.setRelCareSubsidiesDt(inDS.getDtSubsyDiscsd());
        outDS.setAnyCrtkPrior(inDS.getIndCrtkrPrior());
        outDS.setNoLongerWPCrtk(escapeXML(inDS.getTxtDescRem()));

        Person pesContacted = inDS.getPersonByIdPersonDetail();
        int perContactedId = pesContacted.getIdPerson().intValue();
        CprsQueryWO.Relative relOut = new CprsQueryWO.Relative();
        relOut.setLastName(pesContacted.getNmPersonLast());
        relOut.setFirstName(pesContacted.getNmPersonFirst());
        relOut.setMiddlename(pesContacted.getNmPersonMiddle());
        relOut.setPhoneNumber(pesContacted.getNbrPersonPhone());
        relOut.setIdPerson(perContactedId);
        PersonAddress personAddress = personAddressDAO.findCurrentPrimaryPersonAddressByIdPerson(perContactedId);
        if (personAddress != null) {
          relOut.setAddress1(escapeXML(personAddress.getAddrPersAddrStLn1()));
          relOut.setAddress2(personAddress.getAddrPersAddrStLn2());
          relOut.setCity(personAddress.getAddrPersonAddrCity());
          relOut.setCounty(personAddress.getCdPersonAddrCounty());
          relOut.setState(personAddress.getCdPersonAddrState());
          relOut.setZip(personAddress.getAddrPersonAddrZip());
        }

        StagePersonLink spl = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(perContactedId, stageId);
        if (spl != null) {
          relOut.setSideOfFamily(spl.getCdPersonSideOfFamily());
          relOut.setRelType(spl.getCdStagePersRelInt());
          outDS.setRelationshipType(spl.getCdStagePersRelInt());
          //STGAP00015341: Combined the three different sql calls 
          //1. To get the list of events of type 'CON' in the given stage
          //2. To get the event person link record for each event 
          //3. To get the contact details for each event that a event person link record
          //and defined a single sql by joining event, event person link and contact tables 
          //to get the contact details of all the contacts of type 'CON' recorded for the
          //given person in the given stage.
          List<Map> contactList = contactDAO.findContactsByPerson(perContactedId, spl.getStage().getIdStage(), CodesTables.CEVNTTYP_CON);
          if (contactList != null && contactList.size() > 0) {
            for (Iterator<Map> itMap = contactList.iterator(); itMap.hasNext();) {
              Map contactMap = itMap.next();
                if (contactMap != null) {
                  outDS.setContDt((Date) contactMap.get("dtContactOccurred"));
                  outDS.setContMeth((String) contactMap.get("cdContactMethod"));
                  //SMS#38671 Changed nmPersonFull to nmContactedBy to get the person who made the contact for diligent search.
                  outDS.setInterviewer((String) contactMap.get("nmContactedBy"));
                  break;
                }
            }
          }
        }
        outDS.setPersonContacted(relOut);
        outDSList.add(outDS);
      }
      return outDSList;
    }
    return null;
  }

  @SuppressWarnings(value = "unchecked")
  private CprsQueryWO.Adoption buildAdoption(int idCase, int idChildPrimary) {
    /* SMS#109405 Additional updates while doing MR-083 update. This is confirmed by George Li and Pat Vicknair. 
     * Adoption elements should be sent from the active ADO stage. The old method below uses an updated DAO call that looks into
     * closed stage(s) that may be done for another defect; it also orders by the most recent id_stage
     * Changes:
     * - used the updated version of the original query (open stage)and add the child is PC. No need to order by most recent b/c  
     * there is only 1 open ADO for the same child at a time. 
     * - changed the return object from stagePersonLinkSUB to stagePersonLinkADO because the ADO stage type is being passed
    */
   /* StagePersonLink stagePersonLinkSUB = getStagePersonLinkForAPersonAndIdCaseAndCdStage(idCase,
                                                                                         CodesTables.CSTAGES_ADO,
                                                                                         idChildPrimary);
  */  StagePersonLink stagePersonLinkADO = stagePersonLinkDAO.findStagePersonLinkByIdCaseByIdPersosByCdStage(idCase, idChildPrimary,
                                                                                                        CodesTables.CSTAGES_ADO,
                                                                                                        CodesTables.CROLEALL_PC);   
    if (stagePersonLinkADO != null) {
      AdoInfo adoInfo = adoInfoDAO.findLatestAdoptionInformationByStage(stagePersonLinkADO.getStage().getIdStage());
      
      if (adoInfo != null) {
        CprsQueryWO.Adoption outAdopt = new CprsQueryWO.Adoption();
        outAdopt.setIndAdoptRes(adoInfo.getIndIdenAdo());
        outAdopt.setStateAct(escapeXML(adoInfo.getTxtStateAct()));
        outAdopt.setCntyAct(escapeXML(adoInfo.getTxtCntyAct()));
        outAdopt.setNumOfFamCons(adoInfo.getNbrFamCons());
        outAdopt.setNotSelCmmts(escapeXML(adoInfo.getTxtNotSel()));
        outAdopt.setBarrToRec(escapeXML(adoInfo.getTxtRecrBarr()));
        outAdopt.setBarrToPlcmt(escapeXML(adoInfo.getTxtPlcmntBarr()));
        outAdopt.setCurSpNeeds(escapeXML(adoInfo.getTxtTypAdo()));
        outAdopt.setReasChildAvail(adoInfo.getCdChldAvail());
        outAdopt.setAdotAgreeDt(adoInfo.getDtAdoAgree());
        outAdopt.setLifeHistPresDt(adoInfo.getDtLifeHisPres());
        outAdopt.setAdotStaffDt(adoInfo.getDtAdoStaff());
        outAdopt.setIntTprDt(adoInfo.getDtIntTpr());
        outAdopt.setDecAdoptDt(adoInfo.getDtDecAdopt());
        outAdopt.setPermStaffDt(adoInfo.getDtPermStaff());
        outAdopt.setPermFileDt(adoInfo.getDtPermFile());
        outAdopt.setDocSentDt(adoInfo.getDtDocSent());
        outAdopt.setInqryOTHS(adoInfo.getIndInqry());
        outAdopt.setPrepCmnts(escapeXML(adoInfo.getTxtPrepCmnts()));
        outAdopt.setTprBarr(escapeXML(adoInfo.getTxtTprBarr()));
        outAdopt.setLetterSentDt(adoInfo.getDtLetterSent());
        outAdopt.setIndFpAdo(adoInfo.getIndFpAdo());
                  
        Event excEvent = adoInfo.getEventByIdEventChildRegistration();
        ExchangeChild exchangeChild = null;
        if(excEvent != null){
          exchangeChild = exchangeChildDAO.findExchangeChildByEventId(excEvent.getIdEvent());
          if(exchangeChild != null) {
            outAdopt.setRecruitComment(escapeXML(exchangeChild.getTxtRecruitComment()));
          }
        }
        outAdopt.setDisruptionDt(getDisruptionDate(idChildPrimary,idCase));
        
        Collection cbxs = adoInfo.getAdoInfoCbxes();
        if (cbxs != null && cbxs.size() > 0) {
          List<CprsQueryWO.RecruitmentActivities> recruitmentActivities = new ArrayList<CprsQueryWO.RecruitmentActivities>();
          for (Iterator<AdoInfoCbx> it = cbxs.iterator(); it.hasNext();) {
            AdoInfoCbx adoInfoCbx = it.next();
            CprsQueryWO.RecruitmentActivities item = new CprsQueryWO.RecruitmentActivities();
            item.setCode(adoInfoCbx.getCdAdoInfoCbx());
            item.setCodeType(adoInfoCbx.getCdCbxCodeType());
            item.setPerformedDates(adoInfoCbxSentDAO.findAdoInfoCbxSentDateByIdInfoCharIdEvent(adoInfoCbx.getIdInfoChar(), adoInfo.getIdEvent()));
            recruitmentActivities.add(item);
          }
          outAdopt.setRecruitmentActivities(recruitmentActivities);
        }
        
        if(exchangeChild != null) {
          // SMS#109405 MR-083: add new field Actively Recruiting? to outbound object to send to CPRS
          outAdopt.setCdStateActRecruiting(exchangeChild.getCdStateActivelyRecruiting());
          List<ExcChildAdoInfoCbx> lstExcChildAdoInfoCbx = excChildAdoInfoCbxDAO.retrieveExcChildAdoInfoByIdEvent(exchangeChild.getIdEvent());
          if(lstExcChildAdoInfoCbx != null && lstExcChildAdoInfoCbx.size() > 0) {
            List<CprsQueryWO.ExchangeChildRecruitmentActivities> exchangeChildRecruitmentActivities = new ArrayList<CprsQueryWO.ExchangeChildRecruitmentActivities>();
            for (Iterator<ExcChildAdoInfoCbx> it = lstExcChildAdoInfoCbx.iterator(); it.hasNext();) {
              ExcChildAdoInfoCbx excChildAdoInfoCbx = it.next();
              CprsQueryWO.ExchangeChildRecruitmentActivities item = new CprsQueryWO.ExchangeChildRecruitmentActivities();
              item.setCode(excChildAdoInfoCbx.getCdAdoInfoCbx());
              item.setCodeType(excChildAdoInfoCbx.getCdCbxCodeType());
              item.setDtPerformed(excChildAdoInfoCbx.getDtPerformed());
              exchangeChildRecruitmentActivities.add(item);
            }
            outAdopt.setExchangeChildRecruitmentActivities(exchangeChildRecruitmentActivities);
          }
        }
        return outAdopt;
      }
    }
    return null;
  }

  private List<CprsQueryWO.HealthCareProvider> buildHealtCareProviders(int idChildPrimary, int idCase, int stageId) {
    List<CprsQueryWO.HealthCareProvider> hcposList = null;

    List<ProfessionalAssmt> professionalAssmts = professionalAssmtDAO
                                                                     .findProfessionalAssmtByIdCaseByIdPersonPrincipal(
                                                                                                                       idCase,
                                                                                                                       idChildPrimary);
    if (professionalAssmts != null && professionalAssmts.size() > 0) {
      hcposList = new ArrayList<CprsQueryWO.HealthCareProvider>();
      List<Integer> hcPersonList = new ArrayList<Integer>();
      for (Iterator<ProfessionalAssmt> itr = professionalAssmts.iterator(); itr.hasNext();) {
        ProfessionalAssmt proAssmt = itr.next();
        Person person = proAssmt.getPersonByIdPersonProfessional();
        CprsQueryWO.HealthCareProvider hcp = new CprsQueryWO.HealthCareProvider();
        if (person != null) {
          Integer idPersonInt = person.getIdPerson();
          if(hcPersonList.contains(idPersonInt)) {
            continue;
          } else {
            hcPersonList.add(idPersonInt);
          }
          person = personDAO.findPersonByIdPerson(idPersonInt);
          hcp.setRelType(proAssmt.getCdProfAssmtApptRsn());
          hcp.setLastName(person.getNmPersonLast());
          hcp.setFirstName(person.getNmPersonFirst());
          hcp.setMiddlename(person.getNmPersonMiddle());
          int idPerson = idPersonInt.intValue();
          hcp.setIdPerson(idPerson);
          PersonAddress personAddress = personAddressDAO.findCurrentPrimaryPersonAddressByIdPerson(idPerson);
          if (personAddress != null) {
            hcp.setAddress1(escapeXML(personAddress.getAddrPersAddrStLn1()));
            hcp.setAddress2(personAddress.getAddrPersAddrStLn2());
            hcp.setCity(personAddress.getAddrPersonAddrCity());
            hcp.setCounty(personAddress.getCdPersonAddrCounty());
            hcp.setState(personAddress.getCdPersonAddrState());
            hcp.setZip(personAddress.getAddrPersonAddrZip());
          }
          Map<String, String> phones = getPersonOfficePhones(idPerson);
          if (phones != null && phones.size() > 0) {
            hcp.setPhoneNumber(phones.get(CodesTables.CPHNTYP_BS));
            hcp.setFaxNumber(phones.get(CodesTables.CPHNTYP_BF));
          }
          hcposList.add(hcp);
        } else {
          hcp.setRelType(proAssmt.getCdProfAssmtApptRsn());
          hcp.setLastName(escapeXML(proAssmt.getTxtProfAssmtOther()));
          hcp.setAddress1(escapeXML(proAssmt.getAddrProfAssmtStLn1()));
          hcp.setAddress2(proAssmt.getAddrProfAssmtStLn2());
          hcp.setCity(proAssmt.getAddrProfAssmtCity());
          hcp.setCounty(proAssmt.getCdProfAssmtCounty());
          hcp.setState(proAssmt.getCdProfAssmtState());
          hcp.setZip(proAssmt.getAddrProfAssmtZip());
          hcp.setPhoneNumber(proAssmt.getNbrProfAssmtPhone());
          hcposList.add(hcp);
        }
      }
    }
    return hcposList;
  }

  private CprsQueryWO.Aftercare buildAftercare(Stage fSUStag, int primaryChildID, FccpFamily fccpFamily, Placement plac) {
    if (fccpFamily != null || plac != null) {
      CprsQueryWO.Aftercare after = new CprsQueryWO.Aftercare();
      if (fccpFamily != null) {
        after.setType(fccpFamily.getCdPlanType());
        after.setReasonDisFromFC(escapeXML(fccpFamily.getTxtRsnDschrgAftercare()));
        after.setAfterCareBeginDt(fccpFamily.getDtBeginAftercare());
        after.setAfterCareEndDt(fccpFamily.getDtEndAftercare());
      }

      
      //STGAP00009810 check for null pointer
      if(fccpFamily != null){
        int fccpFamilyId = fccpFamily.getIdEvent().intValue();
        after.setCareTakers(buildCaretakers(fccpFamilyId, fSUStag));
        if(fSUStag != null) {
          after.setRelatives(buildRelativesInStage(fSUStag.getIdStage().intValue(), fccpFamilyId, primaryChildID));
        }
      }

      return after;
    }
    return null;
  }
  
  private FccpFamily retrieveFCCPFamilyPlan(int caseId, int idPrimaryChild) {
    FccpFamily fccpFamily = null;
    
    //SMS#65873: Used new method to retrieve latest SPL for FSU (FCF) stage for given caseid and idChild
    //           as the stage is FCF there is PC in this stage
    StagePersonLink spl = getStagePersonLinkForAPersonAndIdCaseAndLatestFSU(caseId, CodesTables.CSTAGES_FSU,
                                                                          idPrimaryChild);
    if (spl != null) {
      int splId = spl.getStage().getIdStage().intValue();
      //first try to retrieve latest the appr plan
      List<String> cdStatusTypes = new ArrayList<String>();
      cdStatusTypes.add(CodesTables.CEVTSTAT_APRV);
      fccpFamily = retrieveFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      
      //if null try to retrieve the latest comp plan
      if(fccpFamily == null) {
        cdStatusTypes.clear();
        cdStatusTypes.add(CodesTables.CEVTSTAT_COMP);
        fccpFamily = retrieveFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      }
      
      //else grab the latest 
      if(fccpFamily == null) {
        cdStatusTypes.clear();
        cdStatusTypes.add(CodesTables.CEVTSTAT_NEW);
        cdStatusTypes.add(CodesTables.CEVTSTAT_PEND);
        cdStatusTypes.add(CodesTables.CEVTSTAT_PROC);
        fccpFamily = retrieveFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      }
    }
    
    return fccpFamily;
  }

  private FccpFamily retrieveFCCPFamilyPlanByStatus(int stagePersonLinkId, int idPrimaryChild,
                                                    Collection<String> cdEventStatuses) {

    //STGAP00015341: Combined the three different sql calls 
    //1. To get the list of events of type 'PLN' in the given stage
    //2. To get the event person link record for each event 
    //3. To get the FccpFamily records for each event that have an event person link record
    //and defined a single sql by joining event, event person link and FccpFamily tables 
    //to get the FccpFamily records of all the family plans recorded for the
    //given person in the given stage.
    List<FccpFamily> fccpFamilyPlnList = fccpFamilyDAO
                                                      .findFCCPFamilyByIdPersonByEventStatusByIdStage(
                                                                                                      idPrimaryChild,
                                                                                                      stagePersonLinkId,
                                                                                                      CodesTables.CEVNTTYP_PLN,
                                                                                                      cdEventStatuses);
    if (fccpFamilyPlnList != null && fccpFamilyPlnList.size() > 0) {
      for (Iterator<FccpFamily> it = fccpFamilyPlnList.iterator(); it.hasNext();) {
        FccpFamily fccpFamily = it.next();
        if ((fccpFamily != null) && (CodesTables.CCTPLNTY_AFC.equals(fccpFamily.getCdPlanType()) == false)) {
          return fccpFamily;
        }
      }
    }

    return null;
  }
  
  private FccpFamily retrieveAftercareFCCPFamilyPlan(int caseId, int idPrimaryChild) {
    FccpFamily fccpFamily = null;
    
    //SMS#65873: Find latest FSU stage person link  for given caseid and idChild
    //           as the stage is FCF there is PC in this stage
    StagePersonLink spl = getStagePersonLinkForAPersonAndIdCaseAndLatestFSU(caseId, CodesTables.CSTAGES_FSU,
                                                                          idPrimaryChild);
    if (spl != null) {
      int splId = spl.getStage().getIdStage().intValue();
      //first try to retrieve latest the appr plan
      List<String> cdStatusTypes = new ArrayList<String>();
      cdStatusTypes.add(CodesTables.CEVTSTAT_APRV);
      fccpFamily = retrieveAftercareFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      
      //if null try to retrieve the latest comp plan
      if(fccpFamily == null) {
        cdStatusTypes.clear();
        cdStatusTypes.add(CodesTables.CEVTSTAT_COMP);
        fccpFamily = retrieveAftercareFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      }
      
      //else grab the latest 
      if(fccpFamily == null) {
        cdStatusTypes.clear();
        cdStatusTypes.add(CodesTables.CEVTSTAT_NEW);
        cdStatusTypes.add(CodesTables.CEVTSTAT_PEND);
        cdStatusTypes.add(CodesTables.CEVTSTAT_PROC);
        fccpFamily = retrieveAftercareFCCPFamilyPlanByStatus(splId, idPrimaryChild, cdStatusTypes);
      }
    }
    
    return fccpFamily;
  }
  private FccpFamily retrieveAftercareFCCPFamilyPlanByStatus(int stagePersonLinkId, int idPrimaryChild,
                                                             Collection<String> cdEventStatuses) {

    //STGAP00015341: Combined the three different sql calls 
    //1. To get the list of events of type 'PLN' in the given stage
    //2. To get the event person link record for each event 
    //3. To get the FccpFamily records for each event that have an event person link record
    //and defined a single sql by joining event, event person link and FccpFamily tables 
    //to get the FccpFamily records of all the family plans recorded for the
    //given person in the given stage.
    List<FccpFamily> fccpFamilyPlanLst = fccpFamilyDAO
                                                      .findFCCPFamilyByIdPersonByEventStatusByIdStage(
                                                                                                      idPrimaryChild,
                                                                                                      stagePersonLinkId,
                                                                                                      CodesTables.CEVNTTYP_PLN,
                                                                                                      cdEventStatuses);
    if (fccpFamilyPlanLst != null && fccpFamilyPlanLst.size() > 0) {
      for (Iterator<FccpFamily> it = fccpFamilyPlanLst.iterator(); it.hasNext();) {
        FccpFamily fccpFamily = it.next();
        if ((fccpFamily != null) && (CodesTables.CCTPLNTY_AFC.equals(fccpFamily.getCdPlanType()) == true)) {
          return fccpFamily;
        }
      }
    }

    return null;
  }

  private List<String> buildVisitationPlans(int personId, int stageId) {
    List<OutputLaunchEventLink> eventList = outputLaunchEventLinkDAO.findCurrentVisitationPlansByIdPersonByIdStage(personId, stageId);
    if (eventList != null && eventList.size() > 0) {
      List<Integer> idEvents = new ArrayList<Integer>(eventList.size());
      for (Iterator<OutputLaunchEventLink> it = eventList.iterator(); it.hasNext();) {
        idEvents.add(it.next().getIdEvent());
      }
      List<byte[]> rtLst = visitPlanNarrDAO.findCurrentVisitationPlansForEvent(idEvents);
      if (rtLst != null && rtLst.size() > 0) {
        List<String> vpLst = new ArrayList<String>();
        for (Iterator<byte[]> itInstr = rtLst.iterator(); itInstr.hasNext();) {
          try {
            ByteArrayOutputStream outStream = CompressionHelper.decompressData(itInstr.next());
            vpLst.add(new String(outStream.toByteArray()));
          } catch (IOException e) {
            throw new RuntimeException(FAIL_TO_DECOMPRESS, e);
          }
        }
        return vpLst;
      }
    }
    return null;
  }

  @SuppressWarnings(value = "unchecked")
  private List<Stage> retrieveSubStagesCases(int caseId) {
    List<Stage> retStages = null;

    // get all the substages for the case group them by primary child, when grouping,
    // sort stages by event id to order the stages by for each primary child
    // SMS #58831: Changed DAO call to return the Stages ordered by the newest first
    List<Stage> stageList = stageDAO.findStageByIdCaseAndCdStageDesc(caseId, CSTAGES_SUB);
    if (stageList != null && stageList.size() > 0) {
      Map<Integer, Stage> perStageMap = new HashMap<Integer, Stage>();
      for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
        Stage stage = it.next();
        Person primaryChild = retrievePrimaryChild(stage.getIdStage().intValue());
        // if a stage has no PrimaryChild it is worthless to this processing
        if (primaryChild != null) {
          Integer primaryChildId = primaryChild.getIdPerson();
          /* SMS #58831: We only want the latest FCC Stage.
           * Reworked the code to not use a TreeSet, which was causing problems
           * and not always sorting stages with the newest stage on top. Now,
           * this sorting is taken care of in the DAO call above and the stage
           * is saved to a map if it is the newest FCC Stage.
           */
          // First, look up to see if a stage has been saved for the child
          Stage tmpFccStage = perStageMap.get(primaryChildId);
          /* If the lookup returns null, then add the current stage.
           * This should be the current/latest FCC Stage as returned
           * by the DAO.
           */
          if (tmpFccStage == null) {
            perStageMap.put(primaryChildId, stage);
          }
        }
      }

      /* This collection will have all the current FCC Stages for a case.
       * These stages will be put into the list to be returned.
       */
      Collection<Stage> caseStages = perStageMap.values();
      retStages = new ArrayList<Stage>();
      for (Stage s : caseStages) {
        retStages.add(s);
      }
      
    }
    return retStages;
  }

  private List<Map> getEmpJobHistory(int idPerson) {
    List<Map> mapList = empJobHistoryDAO.findEmpJobHistoryByIdPerson(idPerson);

    return mapList;
  }

  private Office getEmployeeOffice(int idPerson) {
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    Office office = null;
    if(employee != null) {
      office = employee.getOffice();
    }
    return office;
  }

  private FccpChild getFccpChildData(int idStageSUB) {
    FccpChild fccpChild = fccpChildDAO.findLatestChildPlanByIdStageByCdEventType(idStageSUB);

    return fccpChild;
  }

  // find latest removal information for that child for that case
  private CnsrvtrshpRemoval getCnsrvtrshpRemovalData(int idCase, int idVictim) {
    List<CnsrvtrshpRemoval> cnsrvtrshpRemovals = cnsrvtrshpRemovalDAO
                                                                     .findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(
                                                                                                                     idCase,
                                                                                                                     idVictim);
    return (cnsrvtrshpRemovals != null && cnsrvtrshpRemovals.size() > 0) ? cnsrvtrshpRemovals.get(0) : null;
  }

  private LegalStatus retrieveLegalStatusData(int idPerson) {
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);

    return legalStatus;
  }

  private NeedsOutcomes getNeedsAndOutcomeData(int idStage) {
    NeedsOutcomes needsOutcomes = needsOutcomesDAO.findNeedsAndOutcomesLatestByIdStage(idStage);

    return needsOutcomes;
  }

  private WtlpPlan retrieveWTLPData(int idStage, int idChildPrimary) {
    return wtlpPlanDAO.findWtlpPlanLatestApprovedByIdStageByIdPerson(idStage, idChildPrimary);
  }

  private YouthDetail retrieveYouthDetail(int idChildPrimary) {
    return youthDetailDAO.findYouthDetail(idChildPrimary);
  }

  private Person retrievePrimaryChild(int stageId) {
    Integer primaryChildId = fccpChildDAO.findPrimaryChildForStage(stageId);
    Person primaryChild = null;
    if (primaryChildId != null) {
      primaryChild = personDAO.findPersonByIdPerson(primaryChildId.intValue());
    }

    return primaryChild;
  }

  private Eligibility retrieveEligibility(int idStage, int idChildPrimary) {
    return eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idChildPrimary);
  }

  private StagePersonLink getStagePersonLinkForAPersonAndIdCaseAndCdStage(int idCase, String cdStage, int idPerson) {
    // SMS 65873 - Updated to receive the StagePersonLink with the newest stage
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStgPersLnkClosedByIdCaseByIdPersByCdStgOrdByIdStg(
                                                                                                               idCase,
                                                                                                               idPerson,
                                                                                                               cdStage);
    return stagePersonLink;
  }
  
// SMS#82989: Updated to receive the StagePersonLink with the newest stage  
  private StagePersonLink getStagePersonLinkForAPersonAndIdCaseAndLatestFSU(int idCase, String cdStage, int idPerson) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findLatestStagePersonLinkByIdCaseByIdPersosByCdStage(
                                                                                                               idCase,
                                                                                                               idPerson,
                                                                                                               cdStage);
    return stagePersonLink;
  }

  private Date retrieveApprovalDateOfLglActionByHearingTypeCrtOrds(LegalAction legalAction) {
    Date approvalDate = null;
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    if (legalAction != null) {
      Approvers approvers = approversDAO.findApproverByIdEventIfEventIsApproved(legalAction.getIdLegalActEvent(),
                                                                                cdEventStatus);
      if (approvers != null) {
        approvalDate = approvers.getDtApproversDetermination();
      }
    }
    return approvalDate;
  }

  private Map<String, String> getPersonOfficePhones(int idPerson) {
    Map<String, String> phoneMap = new HashMap<String, String>();
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BF); // Business Fax
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
      String phoneType = personPhone.getCdPersonPhoneType();
      if (CodesTables.CPHNTYP_BC.equals(phoneType)) {
        phoneMap.put(CodesTables.CPHNTYP_BC, personPhone.getNbrPersonPhone());
      } else if (CodesTables.CPHNTYP_BF.equals(phoneType)) {
        phoneMap.put(CodesTables.CPHNTYP_BF, personPhone.getNbrPersonPhone());
      } else if (CodesTables.CPHNTYP_BS.equals(phoneType)) {
        phoneMap
                .put(
                     CodesTables.CPHNTYP_BS,
                     personPhone.getNbrPersonPhone()
                                     + ((personPhone.getNbrPersonPhoneExtension() != null) ? (" " + personPhone
                                                                                                               .getNbrPersonPhoneExtension())
                                                                                          : ("")));
      }
    }
    return phoneMap;
  }
  
  private Date getDisruptionDate(int idChild, int idStage) {
    
    // Get the earliest, actual, non-concurrent placement for the child in the ADO stage to populate the Disruption
    // date.
    String cdStage = CodesTables.CSTAGES_ADO;
    Placement placement = placementDAO.findEndedPlcmtByIdChildByStageType(idChild, cdStage);
    
    //cdPlcmtRemovalRsn placement.getCdPlcmtRemovalRsn()
    if (placement != null && (CodesTables.CRMRSNAC_ADF.equals(placement.getCdPlcmtRemovalRsn())) == false) {
        //if removal reason is anything other then adoption finalized
        //return the disrutption dae
        return placement.getDtPlcmtEnd();
    }               
    return null;
  }

  private Map<String, String> getResourceOfficePhones(int idResource) {
    Map<String, String> phoneMap = new HashMap<String, String>();
    List<ResourcePhone> phones = resourcePhoneDAO.findResourcePhoneByIdResource(idResource);

    for (Iterator<ResourcePhone> it = phones.iterator(); it.hasNext();) {
      ResourcePhone phone = it.next();
      String phoneType = phone.getCdRsrcPhoneType();
      if (CodesTables.CRSCPHON_01.equals(phoneType)) {
        phoneMap.put(CodesTables.CRSCPHON_01,
                     phone.getNbrRsrcPhone()
                                     + ((phone.getNbrRsrcPhoneExt() != null) ? (" " + phone.getNbrRsrcPhoneExt())
                                                                            : ("")));
      } else if (CodesTables.CRSCPHON_02.equals(phoneType)) {
        phoneMap.put(CodesTables.CRSCPHON_02, phone.getNbrRsrcPhone());
      } else if (CodesTables.CRSCPHON_03.equals(phoneType)) {
        phoneMap.put(CodesTables.CRSCPHON_03, phone.getNbrRsrcPhone());
      }
    }
    return phoneMap;
  }

  private boolean isRelativeToVictim(String cdStagePersonRelInt) {
    boolean success = false;
    final HashMap<String, String> relativesCodes = new HashMap<String, String>();
    relativesCodes.put(CodesTables.CRPTRINT_AB, EMPTY_STRING); // Absent Parent
    relativesCodes.put(CodesTables.CRPTRINT_AF, EMPTY_STRING); // Adoptive/Foster Parent
    relativesCodes.put(CodesTables.CRPTRINT_AU, EMPTY_STRING); // Aunt/Uncle
    relativesCodes.put(CodesTables.CRPTRINT_BF, EMPTY_STRING); // Biological Father
    relativesCodes.put(CodesTables.CRPTRINT_BM, EMPTY_STRING); // Biological Mother
    relativesCodes.put(CodesTables.CRPTRINT_CO, EMPTY_STRING); // First Cousin
    relativesCodes.put(CodesTables.CRPTRINT_FC, EMPTY_STRING); // First Cousin Once Removed
    relativesCodes.put(CodesTables.CRPTRINT_FM, EMPTY_STRING); // Other Family Member
    relativesCodes.put(CodesTables.CRPTRINT_GC, EMPTY_STRING); // Grand Child
    relativesCodes.put(CodesTables.CRPTRINT_GN, EMPTY_STRING); // Great Niece
    relativesCodes.put(CodesTables.CRPTRINT_GP, EMPTY_STRING); // Grand Parent
    relativesCodes.put(CodesTables.CRPTRINT_GW, EMPTY_STRING); // Grand Nephew
    relativesCodes.put(CodesTables.CRPTRINT_GS, EMPTY_STRING); // Step-grandparent
    relativesCodes.put(CodesTables.CRPTRINT_G2, EMPTY_STRING); // Great Grandparent
    relativesCodes.put(CodesTables.CRPTRINT_G3, EMPTY_STRING); // Great Great Grandparent
    relativesCodes.put(CodesTables.CRPTRINT_G4, EMPTY_STRING); // Great Great Great Grandparent
    relativesCodes.put(CodesTables.CRPTRINT_HS, EMPTY_STRING); // Half Sibling
    relativesCodes.put(CodesTables.CRPTRINT_LM, EMPTY_STRING); // Legal Mother
    relativesCodes.put(CodesTables.CRPTRINT_LF, EMPTY_STRING); // Legal Father
    relativesCodes.put(CodesTables.CRPTRINT_N2, EMPTY_STRING); // Non Parent Spouse
    relativesCodes.put(CodesTables.CRPTRINT_NN, EMPTY_STRING); // Niece/Nephew
    relativesCodes.put(CodesTables.CRPTRINT_NS, EMPTY_STRING); // Great Great niece
    relativesCodes.put(CodesTables.CRPTRINT_PA, EMPTY_STRING); // Parent
    relativesCodes.put(CodesTables.CRPTRINT_PF, EMPTY_STRING); // Putative Father
    relativesCodes.put(CodesTables.CRPTRINT_SB, EMPTY_STRING); // Sibling
    relativesCodes.put(CodesTables.CRPTRINT_SO, EMPTY_STRING); // Son
    relativesCodes.put(CodesTables.CRPTRINT_SP, EMPTY_STRING); // Spouse
    relativesCodes.put(CodesTables.CRPTRINT_SS, EMPTY_STRING); // Step Sibling
    relativesCodes.put(CodesTables.CRPTRINT_ST, EMPTY_STRING); // Step Parent
    relativesCodes.put(CodesTables.CRPTRINT_W2, EMPTY_STRING); // Great Great Nephew

    if (relativesCodes.get(cdStagePersonRelInt) != null) {
      success = true;
    }
    return success;
  }

  private boolean isPersonOverThisAge(Date birthdate, int ageThreshold) {
    boolean over = false;
    int age = DateHelper.getAge(birthdate);
    if ((age - ageThreshold) > 0) {
      over = true;
    }
    return over;
  }
  
  private List<EventPersonLink> retrieveFFCPPrincipals(int idEvent) {
    List<EventPersonLink> personList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);
    return personList;
  }
  
  // wjcochran - REMOVED UNUSED private method retrieveFSUStage(int caseId)
  
  private String escapeXML(String str) {
    return (str != null) ? StringEscapeUtils.escapeJava(str) : null;
  }
  
  // SMS #97845: MR-074-2
  // Find the most recent date from Items #1, #2 and #3 (The event status of Legal Action should be approved or completed):
  // 1. Most recent Court Action Date for the Legal Action with Action type of any Voluntary Surrender 
  //    (VLM - VS Biological Mother, VAM - VS Adoptive Mother, VBF - VS Biological Father, VSF - VS Biological and Legal Father, 
  //    VLS - VS Legal Father, VAF - VS Adoptive Father, VPF - VS Putative Father)
  // 2. Most recent Court Order Date for the Legal Action with Hearing/Court Order Type of any TPR value 
  //    (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, TFB – TPR Biological Father, TFF – TPR Legal Father, 
  //    TFL – TPR Biological and Legal Father, TPM – TPR Biological Mother, TPP – TPR Putative Father) 
  //    if the Action Type is either ‘Hearing’ or ‘Received Court Order’, 
  //    and the Outcome is ‘TPR Granted (CLEGLOUT_TPG)’
  // 3. Most recent Court Order Date for Legal Action if the Action Type is either ‘Hearing’ or ‘Received Court Order’ 
  //    and the Outcome is 'Deceased Parents - Permanent Custody to DHR (CLEGLOUT_DPC)'

  private Date retrieveLegalActionTPRAchieved(int idCase, int idPerson) {
    List<String> cdLegalActActions = new ArrayList<String>();
    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrender - Biological Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VLF); // Voluntary Surrender - Father (NOTE: This has been end-dated, keep for old data)
    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender - Adoptive Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender - Adoptive Father 
    cdLegalActActions.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender - Legal/Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender - Legal Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender - Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender - Putative Father
    
    List<String> cdLegalActActionsOth = new ArrayList<String>();
    cdLegalActActionsOth.add(CodesTables.CLEGCPS_HRG); // Hearing
    cdLegalActActionsOth.add(CodesTables.CLEGCPS_RCO); // Receive Court Order
    
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF); // TPR - Father (NOTE: This has been end-dated, keep for old data)
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Biological Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Biological and Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father

    Date dtMostRecentTPRVS = null;
    dtMostRecentTPRVS = legalActionDAO.findTheMostRecentDateTprAchievedLegalActionsDateForCase(idCase,
                                                                                     idPerson,
                                                                                     cdLegalActActions,
                                                                                     cdLegalActActionsOth,
                                                                                     cdHrTypCrtOrds,
                                                                                     CodesTables.CLEGLOUT_TPG,
                                                                                     CodesTables.CLEGLOUT_DPC); 
    if (dtMostRecentTPRVS != null) {
      return dtMostRecentTPRVS;
    }
    return dtMostRecentTPRVS;
  }
  // End of SMS #97845: MR-074-2
}
  

