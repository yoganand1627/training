//*  Service Class  Name:     RetrieveAfcarsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 11/16/2009
//*
//*  Description:Service Implementation for retrieving Adoption Information.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  11/16/09  Patrick Coogan     Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCaseWatch;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveAfcars;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsElementBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.db.Afcars;
import gov.georgia.dhr.dfcs.sacwis.db.AfcarsId;
import gov.georgia.dhr.dfcs.sacwis.db.AfcarsElementHelp;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsElementHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareChildrenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class RetrieveAfcarsImpl extends BaseServiceImpl implements RetrieveAfcars {

  private AfcarsDAO afcarsDAO = null;

  private AfcarsElementHelpDAO afcarsElementHelpDAO = null;

  private StageDAO stageDAO = null;

  private FosterCareChildrenDAO fosterCareChildrenDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private PlacementDAO placementDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private FCCPFamilyDAO fccpFamilyDAO = null;

  // March and September - i.e. end of AFCARS periods
  private static int PERIOD_A = 3;

  private static int PERIOD_B = 9;

  // We record the index within the afcars element array of each item here; while we do not use
  // each one, these references are needed when we update individual elements in the array for error
  // warning indicators and to override the default source hyperlink pulled in from AFCARS_ELEMENT_HELP.
  // Note that we use sorted queries to load the array so that these indexes will always be known.
  private static int STATE_INDEX = 0;

  private static int REPORT_DATE_INDEX = 1;

  private static int LOCAL_AGENCY_FIPS_CODE_INDEX = 2;

  private static int DATE_OF_PERIODIC_REVIEW_INDEX = 3;

  private static int CHILDS_DATE_OF_BIRTH_INDEX = 4;

  private static int SEX_INDEX = 5;

  private static int RACE_A_INDEX = 6;

  private static int RACE_B_INDEX = 7;

  private static int RACE_C_INDEX = 8;

  private static int RACE_D_INDEX = 9;

  private static int RACE_E_INDEX = 10;

  private static int RACE_F_INDEX = 11;

  private static int HISPANIC_OR_LATINO_ORIGIN_INDEX = 12;

  private static int CHILD_DISABILITY_INDEX = 13;

  private static int MENTAL_RETARDATION_INDEX = 14;

  private static int VISUALLY_OR_HEARING_IMPAIRED_INDEX = 15;

  private static int PHYSICALLY_DISABLED_INDEX = 16;

  private static int EMOTIONALLY_DISTURBED_INDEX = 17;

  private static int OTHER_DIAGNOSED_CONDITION_INDEX = 18;

  private static int EVER_ADOPTED_INDEX = 19;

  private static int AGE_ADOPTED_INDEX = 20;

  private static int DATE_OF_FIRST_REMOVAL_INDEX = 21;

  private static int TOTAL_NUMBER_OF_REMOVALS_INDEX = 22;

  private static int LAST_FOSTER_CARE_DISCHARGE_INDEX = 23;

  private static int LATEST_REMOVAL_FROM_HOME_INDEX = 24;

  private static int REMOVAL_TRANSACTION_DATE_INDEX = 25;

  private static int DATE_OF_CURRENT_PLACEMENT_INDEX = 26;

  private static int NUMBER_PLACEMENT_SETTINGS_INDEX = 27;

  private static int MANNER_OF_REMOVAL_INDEX = 28;

  private static int PHYSICAL_ABUSE_INDEX = 29;

  private static int SEXUAL_ABUSE_INDEX = 30;

  private static int NEGLECT_INDEX = 31;

  private static int ALCOHOL_ABUSE_PARENT_INDEX = 32;

  private static int DRUG_ABUSE_PARENT_INDEX = 33;

  private static int ALCOHOL_ABUSE_CHILD_INDEX = 34;

  private static int DRUG_ABUSE_CHILD_INDEX = 35;

  private static int CHILDS_DISABILITY_INDEX = 36;

  private static int CHILDS_BEHAVIOR_PROBLEM_INDEX = 37;

  private static int DEATH_OF_PARENTS_INDEX = 38;

  private static int INCARCERATION_OF_PARENTS_INDEX = 39;

  private static int INABILITY_TO_COPE_INDEX = 40;

  private static int ABANDONMENT_INDEX = 41;

  private static int RELINQUISHMENT_INDEX = 42;

  private static int INADEQUATE_HOUSING_INDEX = 43;

  private static int CURRENT_PLACEMENT_SETTING_INDEX = 44;

  private static int OUT_OF_STATE_INDEX = 45;

  private static int MOST_RECENT_CASE_PLAN_GOAL_INDEX = 46;

  private static int CARETAKER_FAMILY_STRUCTURE_INDEX = 47;

  private static int YOB_1ST_PRIN_CARETAKER_INDEX = 48;

  private static int YOB_2ND_PRIN_CARETAKER_INDEX = 49;

  private static int RIGHTS_TERMINATION_MOTHER_INDEX = 50;

  private static int RIGHTS_TERMINATION_FATHER_INDEX = 51;

  private static int FOSTER_FAMILY_STRUCTURE_INDEX = 52;

  private static int YOB_1ST_FOSTER_CARETAKER_INDEX = 53;

  private static int YOB_2ND_FOSTER_CARETAKER_INDEX = 54;

  private static int RACE_1ST_FOSTER_CARETAKER_A_INDEX = 55;

  private static int RACE_1ST_FOSTER_CARETAKER_B_INDEX = 56;

  private static int RACE_1ST_FOSTER_CARETAKER_C_INDEX = 57;

  private static int RACE_1ST_FOSTER_CARETAKER_D_INDEX = 58;

  private static int RACE_1ST_FOSTER_CARETAKER_E_INDEX = 59;

  private static int RACE_1ST_FOSTER_CARETAKER_F_INDEX = 60;

  private static int HL_ORIGIN_1ST_FOS_CARETAKER_INDEX = 61;

  private static int RACE_2ND_FOSTER_CARETAKER_A_INDEX = 62;

  private static int RACE_2ND_FOSTER_CARETAKER_B_INDEX = 63;

  private static int RACE_2ND_FOSTER_CARETAKER_C_INDEX = 64;

  private static int RACE_2ND_FOSTER_CARETAKER_D_INDEX = 65;

  private static int RACE_2ND_FOSTER_CARETAKER_E_INDEX = 66;

  private static int RACE_2ND_FOSTER_CARETAKER_F_INDEX = 67;

  private static int HL_ORIGIN_2ND_FOS_CARETAKER_INDEX = 68;

  private static int DATE_OF_DISCHARGE_INDEX = 69;

  private static int DISCHARGE_TRANSACTION_DATE_INDEX = 70;

  private static int REASON_FOR_DISCHARGE_INDEX = 71;

  private static int TITLE_IV_E_FOSTER_CARE_INDEX = 72;

  private static int TITLE_IV_E_ADOPTION_INDEX = 73;

  private static int TITLE_IV_A_INDEX = 74;

  private static int TITLE_IV_D_INDEX = 75;

  private static int TITLE_XIX_INDEX = 76;

  private static int SSI_INDEX = 77;

  private static int NO_FED_INDEX = 78;

  private static int AMT_OF_FOSTER_CARE_PAYMENT_INDEX = 79;

  public void setAfcarsDAO(AfcarsDAO afcarsDAO) {
    this.afcarsDAO = afcarsDAO;
  }

  public void setAfcarsElementHelpDAO(AfcarsElementHelpDAO afcarsElementHelpDAO) {
    this.afcarsElementHelpDAO = afcarsElementHelpDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setFosterCareChildrenDAO(FosterCareChildrenDAO fosterCareChildrenDAO) {
    this.fosterCareChildrenDAO = fosterCareChildrenDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveAfcars retrieves all information necessary for displaying AFCARS data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns AfcarsSO object.
   */
  public AfcarsSO retrieveAfcars(CaseWatchSI caseWatchSI) {

    AfcarsSO afcarsSO = new AfcarsSO();

    int idPerson = caseWatchSI.getIdPerson();
    int idStage = caseWatchSI.getIdStage();
    int idCase = caseWatchSI.getIdCase();

    // Set all of these to zero since int, program logic will only use when not equal to zero
    afcarsSO.setIdAdoStage(0);
    afcarsSO.setIdCustodyEvent(0);
    afcarsSO.setIdCustodyEventStage(0);
    afcarsSO.setIdFadHomeStage(0);
    afcarsSO.setIdFamilyPlanEvent(0);
    afcarsSO.setIdFamilyPlanEventStage(0);
    afcarsSO.setIdLegalStatusEvent(0);
    afcarsSO.setIdLegalStatusEventStage(0);
    afcarsSO.setIdResource(0);
    afcarsSO.setIdPlcmtEvent(0);
    afcarsSO.setIdPlcmtEventStage(0);
    afcarsSO.setIndOverallError("");

    // First try to get discharge information from Foster Care Children View

    Date dtCustodyStart = null;
    Date dtDischarge = null;

    FosterCareChildren fosterCareChild = new FosterCareChildren();

    // There should always be one row per child per case, but stage ID may be FCC or ADO depending on most recently
    // opened
    fosterCareChild = fosterCareChildrenDAO.findFosterCareChildByPersonAndCaseId(idPerson, idCase);

    if (fosterCareChild != null) {

      dtCustodyStart = fosterCareChild.getCustodyRemovalDate();
      dtDischarge = fosterCareChild.getDischargeDate();
      
      if (!DateHelper.isNull(dtDischarge)){
        
        LegalStatus legalStatus = legalStatusDAO.findLegalStatusByIdPersonByDtLegalStatStatusDt(idPerson, dtDischarge);
        //If we can find it, we are going to change discharge date to the transaction date
        //in case this was a late update
        if (legalStatus != null){
          dtDischarge = legalStatus.getEvent().getDtEventOccurred();   
        }
      }
    }

    // Get stage start and close as a backup if Foster Care Children data cannot be found.
    Stage stage = stageDAO.findStageByIdStage(idStage);
    Date dtStageStart = stage.getDtStageStart();
    Date dtStageEnd = stage.getDtStageClose();

    Date dtStart;
    Date dtEnd;

    if (!DateHelper.isNull(dtCustodyStart)) {
      dtStart = dtCustodyStart;
    } else {
      dtStart = dtStageStart;
    }

    boolean open = false;

    if ((fosterCareChild != null)
        && (DateHelper.isNull(dtDischarge) || DateHelper.isEqual(dtDischarge, DateHelper.MAX_JAVA_DATE))) {
      dtEnd = new Date();
      open = true;
    } else if ((fosterCareChild != null) && !(DateHelper.isNull(dtDischarge))) {
      dtEnd = dtDischarge;
    } else if ((fosterCareChild == null)
               && (DateHelper.isNull(dtStageEnd) || DateHelper.isEqual(dtStageEnd, DateHelper.MAX_JAVA_DATE))) {
      dtEnd = new Date();
      open = true;
    } else {
      dtEnd = dtStageEnd;
    }

    int endYear;
    int endMonth;

    if (open) {

      endYear = DateHelper.getYear(dtEnd);
      endMonth = DateHelper.getMonth(dtEnd)+1;

    } else {
      // Perform logic to find the last AFCARS reporting date for the closed case
      int tempYear = DateHelper.getYear(dtEnd);
      int tempMonth = DateHelper.getMonth(dtEnd)+1;

      if (tempMonth <= PERIOD_A) {
        endMonth = 3;
        endYear = tempYear;
      } else if ((tempMonth > PERIOD_A) && (tempMonth <= PERIOD_B)) {
        endMonth = 9;
        endYear = tempYear;
      } else if (tempMonth > PERIOD_B) {
        endMonth = 3;
        endYear = tempYear + 1;
      } else {
        endMonth = DateHelper.getMonth(new Date());
        endYear = DateHelper.getYear(new Date());
      }
    }

    int strtYear = DateHelper.getYear(dtStart);
    int startMonth = DateHelper.getMonth(dtStart);

    String stringStrtYear = Integer.toString(strtYear);
    String stringStartMonth = Integer.toString(startMonth);
    if (stringStartMonth.length() == 1) {
      stringStartMonth = "0" + stringStartMonth;
    }
    String stringEndYear = Integer.toString(endYear);
    String stringEndMonth = Integer.toString(endMonth);
    if (stringEndMonth.length() == 1) {
      stringEndMonth = "0" + stringEndMonth;
    }
    String startReport = stringStrtYear + stringStartMonth;
    String endReport = stringEndYear + stringEndMonth;

    Date reportDate = DateHelper
                                .getLastDayOfTheMonth(DateHelper
                                                                .toJavaDateSafe(stringEndMonth + "/01/" + stringEndYear));

    // Get the afcars DB object, as we will use this for setting errors and performing other logic
    Afcars afcars = afcarsDAO.findAfcarsByPersonAndReportDate(idPerson, startReport, endReport);

    if (afcars != null) {
      // Load additional information which we will need for navigations off of the Case Watch page

      // Set identifier needed to show Adoption Assistance list (if one exists)
      // Defined as most recently opened adoption stage in the case for the primary child, unless we are in an
      // Adoption stage, in which case it is just the current stage
      if (CodesTables.CSTAGES_ADO.equals(caseWatchSI.getSzStageCd())) {
        afcarsSO.setIdAdoStage(idStage);
      } else {
        Integer adoptionStage;
        // First try to find any open adoption stage for the child in the current case
        adoptionStage = stageDAO.findIdStageForOpenAdoStageByIdPersonIdCase(idPerson, idCase);
        // Otherwise find if there was an ADO stage that came off of the selected stage
        if (adoptionStage == null) {
          adoptionStage = stageDAO.findStageByStageByIdPriorStage(CodesTables.CSTAGES_ADO, idStage, idPerson,
                                                                  CodesTables.CROLES_PC);
        }
        if (adoptionStage != null) {
          afcarsSO.setIdAdoStage(adoptionStage);
        }
      }

      // Set identifiers needed to show custody page.
      // Find all removal events in the case for the child; then find the one that matches the removal
      // date being reported on the AFCARS file displayed.
      List removals = new ArrayList<CnsrvtrshpRemoval>();

      removals = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(idCase, idPerson);

      if ((removals != null) && !(removals.isEmpty())) {

        String afcarsReportedRemoval = afcars.getLatestRemovalFromHome() != null ? afcars.getLatestRemovalFromHome()
                                                                                : "";

        if (!"".equals(afcarsReportedRemoval)) {

          Date reportedRemoval = DateHelper.toJavaDateSafe(afcars.getLatestRemovalFromHome().substring(4, 6) + "/"
                                                           + afcars.getLatestRemovalFromHome().substring(6) + "/"
                                                           + afcars.getLatestRemovalFromHome().substring(0, 4));

          for (Iterator<CnsrvtrshpRemoval> It = removals.iterator(); It.hasNext();) {

            CnsrvtrshpRemoval removal = It.next();

            if (DateHelper.isEqual(reportedRemoval, removal.getDtRemoval())) {

              afcarsSO.setIdCustodyEvent(removal.getEvent().getIdEvent());
              afcarsSO.setIdCustodyEventStage(removal.getEvent().getStage().getIdStage());
            }
          }
        }
      }

      // Set identifiers needed to load the placement and placement resource

      String afcarsReportedPlacementDate = afcars.getDateOfCurrentPlacement() != null ? afcars
                                                                                              .getDateOfCurrentPlacement()
                                                                                     : "";

      if (!"".equals(afcarsReportedPlacementDate)) {

        Date PlacementDate = DateHelper.toJavaDateSafe(afcarsReportedPlacementDate.substring(4, 6) + "/"
                                                       + afcarsReportedPlacementDate.substring(6) + "/"
                                                       + afcarsReportedPlacementDate.substring(0, 4));

        // Add one day so midnight of the next day, we will find <= in the query
        PlacementDate = DateHelper.addToDate(PlacementDate, 0, 0, 1);

        Placement placement = new Placement();

        placement = placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndCase(idPerson, PlacementDate, idCase);

        if (placement != null) {

          afcarsSO.setIdPlcmtEvent(placement.getEvent().getIdEvent());
          afcarsSO.setIdPlcmtEventStage(placement.getEvent().getStage().getIdStage());

          if (placement.getCapsResourceByIdRsrcFacil() != null) {

            Integer idPlacementFacil = placement.getCapsResourceByIdRsrcFacil().getIdResource();
            Integer idFadHomeStage = placement.getCapsResourceByIdRsrcFacil().getStage() != null ? placement
                                                                                                            .getCapsResourceByIdRsrcFacil()
                                                                                                            .getStage()
                                                                                                            .getIdStage()
                                                                                                : null;

            if (idPlacementFacil != null) {
              afcarsSO.setIdResource(idPlacementFacil);
            }
            if (idFadHomeStage != null) {
              afcarsSO.setIdFadHomeStage(idFadHomeStage);
            }
          }
        }
      }

      if (afcars.getMostRecentCasePlanGoal() != null) {

        List casePlans = new ArrayList<FccpFamily>();
        List<String> cdEventStatuses = new ArrayList<String>();

        cdEventStatuses.add(CodesTables.CEVTSTAT_APRV);
        String cdEventType = CodesTables.CEVNTTYP_PLN;

        Integer idFSUstage = stageDAO.findIdStageByIdCaseAndCdStage(idCase,CodesTables.CSTAGES_FSU);
        
        if (idFSUstage!=null){
        
        casePlans = fccpFamilyDAO.findFCCPFamilyByIdPersonByEventStatusByIdStage(idPerson, idFSUstage, cdEventType,
                                                                                 cdEventStatuses);
        }
        
        boolean found = false;
        if ((casePlans != null) && !(casePlans.isEmpty())) {

          for (Iterator<FccpFamily> It = casePlans.iterator(); (It.hasNext() && !found);) {

            FccpFamily casePlan = It.next();
            Date planEffective = casePlan.getDtCurrRev();
            if (planEffective == null) {
              planEffective = casePlan.getDtOrigSub();
            }

            if (planEffective != null) {
              found = DateHelper.isBefore(planEffective, reportDate);
              afcarsSO.setIdFamilyPlanEvent(casePlan.getEvent().getIdEvent());
              afcarsSO.setIdFamilyPlanEventStage(casePlan.getEvent().getStage().getIdStage());
            }
          }
        }
      }

        LegalStatus legalStatus = new LegalStatus();

        legalStatus = legalStatusDAO.findLegalStatusByIdPersonByDtLegalStatStatusDt(idPerson, reportDate);

        if (legalStatus != null) {

          afcarsSO.setIdLegalStatusEvent(legalStatus.getEvent().getIdEvent());
          afcarsSO.setIdLegalStatusEventStage(legalStatus.getEvent().getStage().getIdStage());

        }

        afcarsSO.setDtLastUpdate(afcars.getId().getDtLastUpdate());
      }

      // Get the result as a map; we have defined the map carefully to allow us to cross reference
      // against the database table for factor information and help
      Map resultMap = afcarsDAO.findAfcarsMapByPersonAndReportDate(idPerson, startReport, endReport);

      List<AfcarsElementBean> elementList = new ArrayList<AfcarsElementBean>();
      List<AfcarsElementHelp> elementDbList = afcarsElementHelpDAO.findAfcarsElements();

      int index = 0;
      for (Iterator<AfcarsElementHelp> It = elementDbList.iterator(); It.hasNext();) {

        AfcarsElementBean element = new AfcarsElementBean();
        AfcarsElementHelp elementDb = It.next();

        element.setSzFieldLabel(elementDb.getTxtAfcarsElementLabel());
        element.setSzHelpText(elementDb.getTxtAfcarsElementHelpText());
        element.setSzSource(elementDb.getTxtAfcarsSourceText());  
        element.setIndError("");

        if (resultMap != null) {

          String data = resultMap.get(elementDb.getTxtAfcarsElement()) != null ? (String) resultMap
                                                                                                   .get(elementDb
                                                                                                                 .getTxtAfcarsElement())
                                                                              : "";
          String dataType = elementDb.getCdAfcarsDataType();

          if ("C".equals(dataType)) {
            element.setSzData(Lookup.simpleDecodeSafe(elementDb.getTxtAfcarsCodesTable(), data));
          } else if ("D".equals(dataType) && !"".equals(data)) {
            element.setSzData(data.substring(4, 6) + "/" + data.substring(6) + "/" + data.substring(0, 4));
          } else if ("M".equals(dataType) && !"".equals(data)) {
            float dollars = Float.parseFloat(data);
            element.setSzData(FormattingHelper.formatMoney(dollars));
          } else {
            element.setSzData(data);
          }
          if (afcars!=null){
          element.setIndError(setAfcarsErrorIndicator(data, afcars, fosterCareChild, element, index));
          if ("E".equals(element.getIndError())){
            afcarsSO.setIndOverallError("E");
          } else if ("W".equals(element.getIndError())&&"".equals(afcarsSO.getIndOverallError())){
            afcarsSO.setIndOverallError("W");
          }
          
          element.setSzSource(setAfcarsSourceTxt(afcarsSO, afcars, elementDb.getTxtAfcarsSourceText(), index));
          } 
        }

        index++;
        elementList.add(element);
      }

      // Note: We load the elements above in a sorted list; this order is important for performing updates to set
      // the error/warning mode and override the default navigation based on information returned

      // Override default navigations where necessary

      afcarsSO.setElements(elementList);
    
    return afcarsSO;
  }

  /**
   * setAfcarsErrorIndicator sets whether or not error, warning, or nothing is to be displayed as an error indicator for
   * each element in the Afcars element return list
   * 
   * @param Afcars
   * @param AfcarsElementBean
   * @param index
   * 
   * Returns String error indicator of E, W or empty string.
   */
  private String setAfcarsErrorIndicator(String data, Afcars afcars, FosterCareChildren fosterCareChild,
                                         AfcarsElementBean element, int index) {

    String indErrorWarning = "";

    // Set error and warning flags. This is similar to logic done in batch to set the errors list,
    // but is replicated here to set the flag for indicators on the page.

    // Most Periodic Review
    if (index == DATE_OF_PERIODIC_REVIEW_INDEX) {
      int monthsInCare = fosterCareChild != null ? (fosterCareChild.getMonthsInCare() !=null ? fosterCareChild.getMonthsInCare(): 0):0;
      if ((monthsInCare >= 7) && "".equals(element.getSzData())) {

        indErrorWarning = "E";

      } else if ((monthsInCare >= 7)&&("".equals(afcars.getDateOfDischarge()!=null ? afcars.getDateOfDischarge():""))) {

        Date reviewDate = DateHelper.toJavaDateSafe(element.getSzData());
        Date reviewPlusSix = DateHelper.addToDate(reviewDate, 0, 6, 0);
        if (DateHelper.isBeforeToday(reviewPlusSix)) {
          indErrorWarning = "E";
        } 
      } else if (monthsInCare >= 7){
        
        Date discharge = fosterCareChild != null ? fosterCareChild.getDischargeDate():null;
        if (!DateHelper.isNull(discharge)){
          Date reviewDate = DateHelper.toJavaDateSafe(element.getSzData());
          Date reviewPlusSix = DateHelper.addToDate(reviewDate, 0, 6, 0);
          if (DateHelper.isBefore(reviewPlusSix,discharge)) {
            indErrorWarning = "E";
          } 
        }
      }
    }

    // Date of Birth
    if (index == CHILDS_DATE_OF_BIRTH_INDEX) {
      if ("".equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Gender
    if (index == SEX_INDEX) {
      if ("".equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Race
    if (index == RACE_F_INDEX) {
      if (CodesTables.CYESNOA_1.equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Ethnicity
    if (index == HISPANIC_OR_LATINO_ORIGIN_INDEX) {
      if (CodesTables.CHISORIG_3.equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Manner of Removal
    if (index == MANNER_OF_REMOVAL_INDEX) {
      if ("".equals(data) || CodesTables.CMANRMV_3.equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Placement Setting
    if (index == CURRENT_PLACEMENT_SETTING_INDEX) {
      if ("".equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Placement Out of State
    if (index == OUT_OF_STATE_INDEX) {
      if ("".equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Case Plan Goal(includes error for missing and warning on Other)
    if (index == MOST_RECENT_CASE_PLAN_GOAL_INDEX) {
      if ("".equals(data)) {
        indErrorWarning = "E";
      } else if (CodesTables.CCASPLN_7.equals(data)) {
        indErrorWarning = "W";
      }
    }

    // Caretaker Family Structure
    if (index == CARETAKER_FAMILY_STRUCTURE_INDEX) {
      if ("".equals(data) || CodesTables.CFAMSTR_5.equals(data)) {
        indErrorWarning = "E";
      }
    }

    // Foster Family Structure
    if (index == FOSTER_FAMILY_STRUCTURE_INDEX) {
      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";
      if (CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode)
          || CodesTables.CPLCMNT_3.equals(plcmtCode)) {
        if ("".equals(data)||"0".equals(data)) {
          indErrorWarning = "E";
        }
      }

    }

    // Demographic Info First Foster Parent
    if ((index == YOB_1ST_FOSTER_CARETAKER_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_A_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_B_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_C_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_D_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_E_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_F_INDEX) || (index == HL_ORIGIN_1ST_FOS_CARETAKER_INDEX)) {
      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";
      if (CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode)
          || CodesTables.CPLCMNT_3.equals(plcmtCode)) {
        if ("".equals(data)) {
          indErrorWarning = "E";
        }
      }
    }

    // Demographic Info Second Foster Parent
    if ((index == YOB_2ND_FOSTER_CARETAKER_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_A_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_B_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_C_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_D_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_E_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_F_INDEX) || (index == HL_ORIGIN_2ND_FOS_CARETAKER_INDEX)) {
      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";
      String fosterSetting = afcars.getFosterFamilyStructure() != null ? afcars.getFosterFamilyStructure() : "";
      if (CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode)
          || CodesTables.CPLCMNT_3.equals(plcmtCode)) {
        if (("".equals(data))
            && (CodesTables.CFFAMST_1.equals(fosterSetting) || CodesTables.CFFAMST_2.equals(fosterSetting))) {
          indErrorWarning = "E";
        }
      }
    }

    // Previous Adoption Status
    if (index == EVER_ADOPTED_INDEX) {
      if (CodesTables.CPREADO_3.equals(data)) {
        indErrorWarning = "W";
      }
    }

    // Previous Adoption Age
    if (index == AGE_ADOPTED_INDEX) {
      if (CodesTables.CADOAGE_5.equals(data)) {
        indErrorWarning = "W";
      }
    }

    // Child's Disability Status
    if (index == CHILD_DISABILITY_INDEX) {
      if (CodesTables.CDISABLT_3.equals(data)) {
        indErrorWarning = "W";
      }
    }
    return indErrorWarning;
  }

  /**
   * setAfcarsSourceTxt sets the source and navigation text for the page. This will normally come from the
   * AFCARS_ELEMENT_HELP table, but may be overriden for certain indexes
   * 
   * @param Afcars
   * @param AfcarsSO
   * @param String
   *                default string
   * @param index
   * 
   * Returns String error indicator of E, W or empty string.
   */
  private String setAfcarsSourceTxt(AfcarsSO afcarsSO, Afcars afcars, String defaulttxt, int index) {

    // Normally we will take exactly what was returned unless an exception scenario happens
    String sourceText = defaulttxt;

    // Foster Family Structure
    if (index == FOSTER_FAMILY_STRUCTURE_INDEX) {

      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";

      if (!(CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode) || CodesTables.CPLCMNT_3
                                                                                                                       .equals(plcmtCode))) {

        sourceText = "Foster family structure not reported for current placement type.";

      } else {
        if ((afcarsSO.getIdResource() > 0) && (afcarsSO.getIdFadHomeStage() > 0)) {

          sourceText = "<a href=\"javascript:caseWatchNavigation('navHomeInfo')\">Home Information</a>";

        } else if ((afcarsSO.getIdResource() > 0)) {

          sourceText = "<a href=\"javascript:caseWatchNavigation('navCaretakerInfo')\">Caretaker Information</a>";

        }
      }
    }

    // Demographic Info First Foster Parent
    if ((index == YOB_1ST_FOSTER_CARETAKER_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_A_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_B_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_C_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_D_INDEX) || (index == RACE_1ST_FOSTER_CARETAKER_E_INDEX)
        || (index == RACE_1ST_FOSTER_CARETAKER_F_INDEX) || (index == HL_ORIGIN_1ST_FOS_CARETAKER_INDEX)) {

      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";

      if (!(CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode) || CodesTables.CPLCMNT_3
                                                                                                                       .equals(plcmtCode))) {
        sourceText = "Foster caretaker info not reported for current placement type.";
      } else {
        if ((afcarsSO.getIdResource() > 0) && (afcarsSO.getIdFadHomeStage() > 0)) {

          sourceText = "<a href=\"javascript:caseWatchNavigation('navFadHomePersonList')\">FAD Stage Person Info</a>";

        } else if ((afcarsSO.getIdResource() > 0)) {

          sourceText = "<a href=\"javascript:caseWatchNavigation('navCaretakerInfo')\">Caretaker Information</a>";

        } 
      }
    }

    // Demographic Info Second Foster Parent
    if ((index == YOB_2ND_FOSTER_CARETAKER_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_A_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_B_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_C_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_D_INDEX) || (index == RACE_2ND_FOSTER_CARETAKER_E_INDEX)
        || (index == RACE_2ND_FOSTER_CARETAKER_F_INDEX) || (index == HL_ORIGIN_2ND_FOS_CARETAKER_INDEX)) {

      String plcmtCode = afcars.getCurrentPlacementSetting() != null ? afcars.getCurrentPlacementSetting() : "";

      if (!(CodesTables.CPLCMNT_1.equals(plcmtCode) || CodesTables.CPLCMNT_2.equals(plcmtCode) || CodesTables.CPLCMNT_3
                                                                                                                       .equals(plcmtCode))) {
        sourceText = "Foster caretaker info not reported for current placement type.";
      } else {

        String fosterFamStructure = afcars.getFosterFamilyStructure() != null ? afcars.getFosterFamilyStructure() : "";

        if (!(CodesTables.CFFAMST_1.equals(fosterFamStructure) || CodesTables.CFFAMST_2.equals(fosterFamStructure)||"".equals(fosterFamStructure))) {

          sourceText = "2nd Foster caretaker info not reported for foster family structure.";

        } else {

          if ((afcarsSO.getIdResource() > 0) && (afcarsSO.getIdFadHomeStage() > 0)) {

            sourceText = "<a href=\"javascript:caseWatchNavigation('navFadHomePersonList')\">FAD Stage Person Info</a>";

          } else if ((afcarsSO.getIdResource() > 0)) {

            sourceText = "<a href=\"javascript:caseWatchNavigation('navCaretakerInfo')\">Caretaker Information</a>";
          }
        }
      }
    }

    // Previous Adoption Status
    if (index == TITLE_IV_E_ADOPTION_INDEX) {
     
      if (!(afcarsSO.getIdAdoStage() > 0)) {
      
      sourceText = "No Adoption Stage";
      }
      
    }

    return sourceText;
  }

}
