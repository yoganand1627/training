package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReasonNotEligibleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingExtLnkHistory;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.financials.AAFundingReasonEligible;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Herve Jean-Baptiste September 11, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                      Description
 *   --------     -----------------------   -----------------------------------------------------------------
 *   10/17/11     hnguyen                   STGAP00017242: if reached end of legal status list and bIsInDFCSCustody is true
 *                                          calculate if 60 months is met because the last record did not calculate.                                                  
 *   10/17/2011   hjbaptiste                STGAP00017230:MR-092 Setting the Eligibility Selected on the FCC Eligibility 
 *                                          Summary page instead of the Actual Eligibility
 *   10/17/2011   hjbaptiste                STGAP00017246:MR-092 If Sibling has a PAD stage, use Person information from
 *                                          that stage to populate the Sibling information on the page
 *   10/17/2011   hjbaptiste                STGAP00017245:MR-092 Pre-populating SSI Eligible and IV-E in Prior Adoption
 *                                          indicators regardless if child doesn't have Foster Care History
 *   10/18/2011   hnguyen                   STGAP00017011:MR-092 Fixing sibling age met condition to be greater than or equal
 *                                          not less than or equal to age criteria.
 *   10/19/2011   hnguyen                   STGAP00017296:MR-092 Fixed contrary to welfare criteria where no legal action is found.
 *                                          Also to return after VS legal status is met.
 *   10/19/2011   hnguyen                   STGAP00017245:MR-092 Fixed Applicable Child IVE Criteria to continue processing 
 *                                          based on child current info regardless if no foster care history exists or if event is NEW.
 *   10/19/2011   hnguyen                   STGAP00017303:MR-092 IVE in prior adoption criteria should be populated regardless if previous
 *                                          criteria is met.  This is to prevent locking condition when user change child of a minor parent
 *                                          response to No and no response was populated for IVE in prior adoption disabled field. 
 *   10/24/2011   hnguyen                   STGAP00017237:MR-092 FCC Eligibility Reason Not Eligible not display after initial save due
 *                                          to incorrect logic that does not set idFceEligibility if idEligibilityEvent was previously saved.
 *   10/25/2011   hjbaptiste                STGAP00017387:MR-092 Fixed Constraint Violation when hyperlink is clicked for the first time after
 *                                          event is automatically created via a Stage Progression. An attempt was being made to save the Reason
 *                                          Eligible but the AA_FUNDING record was not yet created. Fixed by only creating the reason if the 
 *                                          event status is not 'NEW'
 *   10/25/2011   hjbaptiste                STGAP00017246:MR-092 when checking to see if sibling has a current PAD stage, during the call to the DAO,
 *                                          Setting the id person to the id person of the PAD id person of the sibling. It was incorrectly set to
 *                                          the id person of the main child whom the AA Funding type is being calculated
 *   11/01/2011   hjbaptiste                STGAP00017452:MR-092 Setting the Eligibility back to the actual eligibility found on the FCC Eligibility
 *                                          page. Checking to see if actual eligibility was changed by comparing whether the system had found the child
 *                                          to be 'eligible' or not.
 *   11/01/2011   hjbaptiste                STGAP00017011:MR-092 Fixed Fed Fiscal Year age criterion STGAP00017547
 *   11/10/2011   hjbaptiste                STGAP00017547:MR-092 Fixed problem with funding type not being calculated correctly when the
 *                                          IV-E in prior adoption is already determined
 *   11/17/2011   hjbaptiste                STGAP00017682:Fixed Fed Fiscal Year not adding a year to the current year in getFedFiscalYear()
 *   11/17/2011   hjbaptiste                STGAP00017452:MR-092 Using the StageLinkDAO to find prior FCC stage to the ADO instead of the ComplexStageLinkDAO
 *   11/21/2011   hjbaptiste                STGAP00017452:MR-092 Reverted back to using the ComplexStageLinkDAO to find prior FCC stage to the ADO as using 
 *                                          StageLinkDAO is throwing an NPE when a stage is not linked to a prior stage
 *   12/14/2011   vcollooru                 STGAP00017782: Modified the method applicableAgeCheck to validate the child age criteria based on the fiscal year
 * </pre>
 * 
 */
public class AAFundingReasonEligibleImpl extends BaseServiceImpl implements AAFundingReasonEligible {
  public static final String ADO_STAGE = CodesTables.CSTAGES_ADO;
  public static final String PAD_STAGE = CodesTables.CSTAGES_PAD;
  public static final String FCC_STAGE = CodesTables.CSTAGES_SUB;
  public static final String TITLE_IVE = CodesTables.CAAFDTYP_IVE;
  public static final String TITLE_IVB = CodesTables.CAAFDTYP_PST;
  public static final String TITLE_NA = CodesTables.CAAFDTYP_NRC; 
  public static final String FCC_ELIGIBILITY_IVE = CodesTables.CELIGIBI_010;
  public static final String FCC_ELIGIBILITY_REASONABLE_EFFORTS = CodesTables.CFCERNE_A09;
  public static final String FCC_IVE_ELIGIBLE_CHECK = CodesTables.CAAFRSNE_FCIVE;
  public static final String FCC_REASON_EFFORTS_LANG_CHECK = CodesTables.CAAFRSNE_RSNEF;
  public static final String APP_CHILD_IVE_CHECK = CodesTables.CAAFRSNE_ACIVE;
  public static final String NON_APP_CHILD_IVE_CHECK = CodesTables.CAAFRSNE_NCIVE;
  public static final String NON_RECURRING_ONLY_CHECK = CodesTables.CAAFRSNE_NONRC;
  public static final String APPLICABLE = "applicable";
  public static final String NON_APPLICABLE = "nonApplicable";
  public static final Integer SIXTY_MONTHS = 60;
  public static final String FISCAL_YEAR_BEGIN_MONTH_DT = "10/01";
  public static final String FISCAL_YEAR_END_MONTH_DT = "09/30";
  
  private PersonDAO personDAO = null;
  private StageDAO stageDAO = null;
  private ComplexStageLinkDAO complexStageLinkDAO = null;
  private PersonDtlDAO personDtlDAO = null; 
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private LegalActionDAO legalActionDAO = null;
  private AaFundingReasonEligDAO aaFundingReasonEligDAO = null;
  private FceEligibilityDAO fceEligibilityDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private FceReasonNotEligibleDAO fceReasonNotEligibleDAO = null;
  private AdoInfoDAO adoInfoDAO = null;
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  private LegalStatusDAO legalStatusDAO = null;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setComplexStageLinkDAO(ComplexStageLinkDAO complexStageLinkDAO) {
    this.complexStageLinkDAO = complexStageLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setFceReasonNotEligibleDAO(FceReasonNotEligibleDAO fceReasonNotEligibleDAO) {
    this.fceReasonNotEligibleDAO = fceReasonNotEligibleDAO;
  }

  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public void setAaFundingReasonEligDAO(AaFundingReasonEligDAO aaFundingReasonEligDAO) {
    this.aaFundingReasonEligDAO = aaFundingReasonEligDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  private static final Set<String> NON_VOLUNTARY_LEGAL_STATUS = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CLEGSTAT_TCT,    // Temporary Court 
                                             CodesTables.CLEGSTAT_JCT,    // Joint Commitment to DJJ - Temporary Court
                                             CodesTables.CLEGSTAT_PCT,    // Permanent Court
                                             CodesTables.CLEGSTAT_JCP})); // Joint Commitment to DJJ - Permanent Court
  
  public void determineAAFundingType(AAFundingSummarySO aAFundingSummarySO) throws ServiceException {
    int idAaFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
    int idUser = aAFundingSummarySO.getIduser();
    int idCase = aAFundingSummarySO.getIdCase();
    int idStage = aAFundingSummarySO.getIdStage();
    String cdStage = aAFundingSummarySO.getCdStage();
    String cdEventStatus = aAFundingSummarySO.getCdEventStatus();
    boolean childHasHistory = false;
    boolean childIsFCCEligible = false;
    boolean childIsApplicable = false;
    boolean childIsApplicableIVE = false;
    boolean childIsNonApplicableIVE = false;
    boolean childOnlyHasPADStage = false;
    
    // Determine if child has Foster Care history. If the stage is a ADO, the child will always have 
    // Foster Care history. ADO stage is progressed from an FCC(SUB) stage.
    if (ADO_STAGE.equals(cdStage)) {
      childHasHistory = true;
    }
    // For PAD stages, we determine if the child has Foster Care history by looking to see if the
    // PAD stage is linked to an ADO stage.  If the PAD was created from a Non-Incident Intake, the
    // child may or may not have a Foster Care stage in another case. If the PAD stage is not linked
    // to a previous stage (ex.. ADO or INT), this is a converted case and therefore we need to still
    // perform the FCC Eligible check using the most recently approved Eligibility Summary
    else if (PAD_STAGE.equals(cdStage)) {
      Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(aAFundingSummarySO.getIdChild());
      if (priorAdoptionInfo != null) {
        childHasHistory = true;
        aAFundingSummarySO.setPriorAdoptionInfo(priorAdoptionInfo);
      } else {
        int idPriorStage = complexStageLinkDAO.findPreviousIdStageByIdStage(idStage);
        if (idPriorStage == 0) {
          childOnlyHasPADStage = true;
        }
      }
    }
    aAFundingSummarySO.setPriorHistory(childHasHistory);
    // If the stage is an ADO stage or a PAD stage and the child has Foster Care history,
    // we need to pre-populate the AA Funding Summary page
    // If the stage is a PAD stage with no history, we don't do any pre-population and 
    if (childHasHistory) {
      // do all calculations
      childIsFCCEligible = determineChildIsFCCEligible(aAFundingSummarySO, false);
      if (!childIsFCCEligible) {
        childIsApplicable = determineApplicableCriteriaMet(aAFundingSummarySO, childHasHistory);
        if (childIsApplicable) {
          childIsApplicableIVE = determineApplicableIVECriteriaMet(aAFundingSummarySO, childHasHistory);
          // If child is Applicable IV-E, clear out all indicators for Non-Applicable IV-E criteria
          // This is necessary because all of the options for each Non-Applicable IV-E Criterion should be blank.
          // Also, if the user changes some data in the system that makes the child not Applicable IV-E,
          // We need to know if the options for a particular criterion is being set for the first time
          // so we can do pre-population to set it or if the user has selected an option and we would use the
          // option selected to make the determination
          if (childIsApplicableIVE) {
            aAFundingSummarySO.setIndNacAfdcMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacSsiEligMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacChildOfMinorMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacIvePriorAdoptMet(StringHelper.EMPTY_STRING);
          }
        } else {
          childIsNonApplicableIVE = determineNonApplicableIVECriteriaMet(aAFundingSummarySO, childHasHistory);
          // If child is Non-Applicable IV-E, clear out all indicators for Applicable IV-E criteria
          // This is necessary because all of the options for each Applicable IV-E Criterion should be blank.
          // Also, if the user changes some data in the system that makes the child Applicable IV-E,
          // We need to know if the options for a particular criterion is being set for the first time
          // so we can do pre-population to set it or if the user has selected an option and we would use the
          // option selected to make the determination
          if (childIsNonApplicableIVE) {
            aAFundingSummarySO.setIndAcTprCtwVsMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcSsiEligMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcChildOfMinorMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcIvePriorAdoptMet(StringHelper.EMPTY_STRING);
          }
        }
      } else {
        aAFundingSummarySO.setIndAcAgeMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcTimeInFosterMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcSiblingMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcTprCtwVsMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcSsiEligMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcChildOfMinorMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndAcIvePriorAdoptMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndNacAfdcMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndNacSsiEligMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndNacChildOfMinorMet(StringHelper.EMPTY_STRING);
        aAFundingSummarySO.setIndNacIvePriorAdoptMet(StringHelper.EMPTY_STRING);
      }
    } 
    // Child has no Foster Care history.  
    else {
      if (childOnlyHasPADStage) {
        // Look for the most recently approved Eligibility Summary in the stage
        childIsFCCEligible = determineChildIsFCCEligible(aAFundingSummarySO, true);
      }
      if (!childIsFCCEligible) {
        // If child is not FCC Eligible, continue with AA Funding determination
        // based on child current information.
        childIsApplicable = determineApplicableCriteriaMet(aAFundingSummarySO, childHasHistory);
        if (childIsApplicable) {
          childIsApplicableIVE = determineApplicableIVECriteriaMet(aAFundingSummarySO, childHasHistory);
          // If child is Applicable IV-E, clear out all indicators for Non-Applicable IV-E criteria
          // This is necessary because all of the options for each Non-Applicable IV-E Criterion should be blank.
          // Also, if the user changes some data in the system that makes the child not Applicable IV-E,
          // We need to know if the options for a particular criterion is being set for the first time
          // so we can do pre-population to set it or if the user has selected an option and we would use the
          // option selected to make the determination
          if (childIsApplicableIVE) {
            aAFundingSummarySO.setIndNacAfdcMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacSsiEligMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacChildOfMinorMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndNacIvePriorAdoptMet(StringHelper.EMPTY_STRING);
          }
        } else {
          childIsNonApplicableIVE = determineNonApplicableIVECriteriaMet(aAFundingSummarySO, childHasHistory);
          // If child is Non-Applicable IV-E, clear out all indicators for Applicable IV-E criteria
          // This is necessary because all of the options for each Applicable IV-E Criterion should be blank.
          // Also, if the user changes some data in the system that makes the child Applicable IV-E,
          // We need to know if the options for a particular criterion is being set for the first time
          // so we can do pre-population to set it or if the user has selected an option and we would use the
          // option selected to make the determination
          if (childIsNonApplicableIVE) {
            aAFundingSummarySO.setIndAcTprCtwVsMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcSsiEligMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcChildOfMinorMet(StringHelper.EMPTY_STRING);
            aAFundingSummarySO.setIndAcIvePriorAdoptMet(StringHelper.EMPTY_STRING);
          }
        }
      }
    }
  }

  private List<String> fccEligibleCheck (AAFundingSummarySO aAFundingSummarySO, boolean childOnlyHasPADStage) {
    List<String> applicationReasonsNotEligible = new ArrayList<String>();
    int idChild = aAFundingSummarySO.getIdChild();
    String cdStage = aAFundingSummarySO.getCdStage();
    int idADOStage = 0;
    int idADOCase = 0;
    if (ADO_STAGE.equals(cdStage)) {
      idADOCase = aAFundingSummarySO.getIdCase();
      idADOStage = aAFundingSummarySO.getIdStage();
    } else {
      Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(aAFundingSummarySO.getIdChild());
      if (priorAdoptionInfo != null) {
        idChild = priorAdoptionInfo.get("idPerson");
        idADOStage = priorAdoptionInfo.get("idStage");
        Stage adoStage = stageDAO.findStageByIdStage(idADOStage);
        idADOCase = adoStage.getCapsCase().getIdCase();
      }
    }
    int idEligibilityEvent = 0;
    int idFceEligibility = 0;
    Eligibility eligibility = null;
    Object[] idMap = null;
    // If the child only has a PAD stage, the child was adopted prior to SHINES and FCC Eligibility
    // is captured in an Eligibility Summary in that particular PAD stage. Else, child has FCC history
    if (!childOnlyHasPADStage) {
      int idFCCStage = complexStageLinkDAO.findPreviousIdStageByIdStage(idADOStage);
      Stage linkedStage = stageDAO.findStageByIdStage(idFCCStage);
      String cdLinkedStage = linkedStage != null ? linkedStage.getCdStage() : StringHelper.EMPTY_STRING;
      if (idFCCStage == 0 || !FCC_STAGE.equals(cdLinkedStage)) {
        aAFundingSummarySO.setIdEligibilityEvent(0);
        return applicationReasonsNotEligible;
      }

      // We need to find the latest Initial/Amended FCE Application and the Eligibility Summary page tied to it.
      // If one does not exist, It could be a converted Case. In that case, look for the most recent Eligibility
      // Summary in the FCC(SUB) stage and find the 'Actual' eligibility
      idMap = fceEligibilityDAO.findIdEligibilityForLatestInitialAmendedApplication(idFCCStage);

      if (idMap != null) {
        idEligibilityEvent = (Integer) idMap[0];
        idFceEligibility = (Integer) idMap[1];
        eligibility = eligibilityDAO.findEligibilityByIdEligEvent(idEligibilityEvent);
      } else {
        eligibility = findMostRecentEligibilitySummaryEvent(idFCCStage, idChild);
        idEligibilityEvent = eligibility != null ? eligibility.getIdEligEvent() : 0;
      }
    } 
    // Look for the most recent Eligibility Summary in this PAD stage
    else {
      eligibility = findMostRecentEligibilitySummaryEvent(aAFundingSummarySO.getIdStage(), idChild);
      idEligibilityEvent = eligibility != null ? eligibility.getIdEligEvent() : 0;
    }
    aAFundingSummarySO.setIdEligibilityEvent(idEligibilityEvent);
    
    // Get the Actual Eligibility and whether the system had deemed the child to be 'eligible' or not and compare
    // them to see if user has performed an 'Override'. 
    // NOTE: 'Overrides' will not be permitted in the near future and the compare logic will not be necessary
    if (eligibility != null) {
      String cdEligActual = eligibility.getCdEligActual();
      // Get the FCE_ELIGIBILITY record in order to know if the child was IV-E eligible or not
      FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdEligibilityEvent(idEligibilityEvent);
      if (fceEligibility != null) {
        String indEligible = fceEligibility.getIndEligible();
        if (ServiceConstants.FND_YES.equals(indEligible) && !FCC_ELIGIBILITY_IVE.equals(cdEligActual) ||
                        ServiceConstants.FND_NO.equals(indEligible) && FCC_ELIGIBILITY_IVE.equals(cdEligActual)) {
          aAFundingSummarySO.setActualEligibilityChanged(true);
        }
      }
      aAFundingSummarySO.setCdEligActual(cdEligActual);
      // If the child was not FCC IV-E Eligible, get the list of reasons the child was not eligible
      if (!FCC_ELIGIBILITY_IVE.equals(cdEligActual)) {
        // If the Selected Eligibility has changed from the System Derived(Actual) Eligibility,
        // Retrieve the reasons to display. The reason is that at the moment, if the eligibility
        // has changed, a generic reason, indicating that the Eligibility has changed, is displayed 
        // on the page instead of the actual reasons logged on the FCC Eligibility Summary
        if (!aAFundingSummarySO.isActualEligibilityChanged()) {
          if (idFceEligibility != 0) {
            applicationReasonsNotEligible = fceReasonNotEligibleDAO.findFceReasonsNotEligible(idFceEligibility);
            aAFundingSummarySO.setCdEligibilityReasonsNotEligible(applicationReasonsNotEligible);
          }
        }
      } 
    }
    
    return applicationReasonsNotEligible;
  }
  
  private void applicableAgeCheck (AAFundingSummarySO aAFundingSummarySO) {
    // Determine the Federal Fiscal Year
    int fedFiscalYear = getFedFiscalYear();
    String ffy = String.valueOf(fedFiscalYear);
    
    // Determine the child's age
    Person child = (Person) getPersistentObject(Person.class, aAFundingSummarySO.getIdChild());
    int childAge = DateHelper.getAge(child.getDtPersonBirth());
    //Compare the child's age with the age criterion and determine if the child has met the criterion
    String ageCriterion = Lookup.simpleDecodeSafe(CodesTables.CFCACCAC, ffy);
    boolean isAgeCriteriaMet = false;
    if (childAge >= Integer.valueOf(ageCriterion)) {
    	isAgeCriteriaMet = true;
    } else if(Integer.valueOf(ageCriterion) - childAge == 1){ //STGAP00017782: This compares if the child reaches eligible age during fiscal year
    		// STGAP00017782: The current date
        	GregorianCalendar currentDate = new GregorianCalendar();
        	currentDate.setTime(new Date());
        	
        	//STGAP00017782: Date of birth of child in current year.
        	GregorianCalendar childDobInFiscalYr = new GregorianCalendar();
        	childDobInFiscalYr.setTime(child.getDtPersonBirth()); 
        	childDobInFiscalYr.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));

        	//STGAP00017782: If the birth date for this year is before current date,
        	// add 1 to the year to get the birth date for the next year 
			if (DateHelper.isBefore(childDobInFiscalYr.getTime(), currentDate.getTime())) {
				childDobInFiscalYr.set(Calendar.YEAR, currentDate.get(Calendar.YEAR) + 1);
			}

			Date fiscalYrBeginDate = DateHelper.toJavaDateSafe(FISCAL_YEAR_BEGIN_MONTH_DT + "/" + (fedFiscalYear -1));
			Date fiscalYrEndDate = DateHelper.toJavaDateSafe(FISCAL_YEAR_END_MONTH_DT + "/" + (fedFiscalYear));
			//STGAP00017782: If the birth date falls between the fiscal year then the child will be eligible.
			if (childDobInFiscalYr.getTime().compareTo(fiscalYrBeginDate) >= 0
					&& childDobInFiscalYr.getTime().compareTo(fiscalYrEndDate) <= 0) {
				isAgeCriteriaMet = true;
			}
    }
    aAFundingSummarySO.setIndAcAgeMet(isAgeCriteriaMet?ServiceConstants.FND_YES:ServiceConstants.FND_NO);
    // Update the SO object
    aAFundingSummarySO.setNbrFfy(Integer.valueOf(ageCriterion));
    aAFundingSummarySO.setNbrChildAge(childAge);
    aAFundingSummarySO.setDtChildDob(child.getDtPersonBirth());
  }
  
  private int getFedFiscalYear () {
    GregorianCalendar tempCal = new GregorianCalendar();
    tempCal.setTime(new Date());  
    int year = tempCal.get(Calendar.YEAR);
    int month = tempCal.get(Calendar.MONTH);
    if (month < 9) {
      return year;
    } else {
      year++;
      return year;
    }
  }
  
  
  
  private void applicableTimeInFosterCareCheck (AAFundingSummarySO aAFundingSummarySO) {
    int idChild = aAFundingSummarySO.getIdChild();
    String cdStage = aAFundingSummarySO.getCdStage();
    int idADOStage = 0;
    int idADOCase = 0;
    if (ADO_STAGE.equals(cdStage)) {
      idADOCase = aAFundingSummarySO.getIdCase();
      idADOStage = aAFundingSummarySO.getIdStage();
    } else {
      Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(aAFundingSummarySO.getIdChild());
      if (priorAdoptionInfo != null) {
        idChild = priorAdoptionInfo.get("idPerson");
        idADOStage = priorAdoptionInfo.get("idStage");
        Stage adoStage = stageDAO.findStageByIdStage(idADOStage);
        idADOCase = adoStage.getCapsCase().getIdCase();
      }
    }
  
    int idFCCStage = complexStageLinkDAO.findPreviousIdStageByIdStage(idADOStage);
    Stage shouldBeFCCStage = stageDAO.findStageByIdStage(idFCCStage);
    // If the stage is not an FCC Stage, then child doesn't have Foster Care History
    if (idFCCStage == 0 || !FCC_STAGE.equals(shouldBeFCCStage.getCdStage())) {
      aAFundingSummarySO.setNbrChildMthsInFoster(0);
      aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_NO);
      return;
    }
    List<Object[]> adoCaseLegalStatuses = legalStatusDAO.findAllLegalStatusesForCaseUsingView(idChild, idADOCase);
    if (!listIsValid(adoCaseLegalStatuses)) {
      aAFundingSummarySO.setNbrChildMthsInFoster(0);
      aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_NO);
      return;
    }
    boolean bIsInDFCSCustody = false;
    Date startDateTracker = null;
    Date endDateTracker = null;
    for (Object[] adoCaseLegalStatus : adoCaseLegalStatuses) {
      Date startDate = (Date) adoCaseLegalStatus[0];
      Date endDate = (Date) adoCaseLegalStatus[1];
      String isInDFCSCustody = (String) adoCaseLegalStatus[2];
      if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && !bIsInDFCSCustody) {
        startDateTracker = startDate;
        endDateTracker = endDate;
        bIsInDFCSCustody = true;
      } else {
        if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && bIsInDFCSCustody) {
          startDateTracker = startDate;
        } else {
          int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
          if (consecMonths >= SIXTY_MONTHS) {
            aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_YES);
            aAFundingSummarySO.setNbrChildMthsInFoster(consecMonths);
            return;
          } else {
            startDateTracker = null;
            endDateTracker = null;
            bIsInDFCSCustody = false;
          }
        }
      }
    }
    // STGAP00017242: if reached end of legal status list and bIsInDFCSCustody is true
    // calculate if 60 months is met because the last record did not calculate.
    if (bIsInDFCSCustody) {
      int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
      if (consecMonths >= SIXTY_MONTHS) {
        aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_YES);
        aAFundingSummarySO.setNbrChildMthsInFoster(consecMonths);
        return;
      }
    }
    
    aAFundingSummarySO.setNbrChildMthsInFoster(0);
    aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_NO);
  }
  
  private void applicableSiblingOfApplicableChildCheck (AAFundingSummarySO aAFundingSummarySO) {
    int idChild = aAFundingSummarySO.getIdChild();
    String cdStage = aAFundingSummarySO.getCdStage();
    int idADOStage = 0;
    int idADOCase = 0;
    if (ADO_STAGE.equals(cdStage)) {
      idADOCase = aAFundingSummarySO.getIdCase();
      idADOStage = aAFundingSummarySO.getIdStage();
    } else {
      // Get the case id of the Adoption Case if the stage is PAD
      Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(aAFundingSummarySO.getIdChild());
      if (priorAdoptionInfo != null) {
        idChild = priorAdoptionInfo.get("idPerson");
        idADOStage = priorAdoptionInfo.get("idStage");
        Stage adoStage = stageDAO.findStageByIdStage(idADOStage);
        idADOCase = adoStage.getCapsCase().getIdCase();
      }
    }
    // Get latest ado info event id based on dt completed desc
    // If ADO Info is null then child has not met
    AdoInfo adoInfo = adoInfoDAO.findLatestCompletedAdoptionInformationByStage(idADOStage);
    // If child doesn't have a ADO Info record in COMP status than child doesn't meet this criterion
    if (adoInfo == null) {
      aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_NO);
      // Clear out sibling name, id, dob
      aAFundingSummarySO.setNmAcSiblingFullName(null);
      aAFundingSummarySO.setDtAcSiblingDob(null);
      aAFundingSummarySO.setIdApplicableSibling(0);
    } 
    // If child does have a ADO Info record, get the list Sibling history and 
    // siblings in external link history
    else {
      // Get sibling history and external link History
      Collection<AdoSiblingHistory> listOfSiblings = adoInfo.getAdoSiblingHistory(); 
      Collection<AdoSiblingExtLnkHistory> listOfExternalSiblings = adoInfo.getAdoSiblingExtLnkHistory();
        // If the child does not belong in a sibling group, child has not met the criterion
        boolean foundApplicableSibling = false;
        if (listIsValid(listOfSiblings) && listOfSiblings.size() == 1 && !listIsValid(listOfExternalSiblings)) {
          aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_NO);
        } else if (listIsValid(listOfSiblings) && listOfSiblings.size() > 1){

          // Loop thru the list and do age and time in foster care check on each sibling
          // Set the found applicable child indicator
          for (AdoSiblingHistory sibling : listOfSiblings) {
            int idSibling = sibling.getIdPerson();
            if (idSibling != idChild) {
              // Get the stage and idPerson of the Post-Adoption Case to see if sibling currently
              // has a PAD stage as we would want to display the sibling's current name, person ID and DOB
              Map<String, Integer> currentPADInfo = stagePersonLinkDAO.findPADStageByPriorAdoptionIdPersonIdAdoStage(idSibling);
              boolean siblingHasCurrentPADStage = false;
              Person padSibling = new Person();
              int idPADSibling = 0;
              int idPADSiblingStage = 0;
              if (currentPADInfo != null) {
                idPADSibling = currentPADInfo.get("idPerson");
                idPADSiblingStage = currentPADInfo.get("idStage");
                padSibling = personDAO.findPersonByIdPerson(idPADSibling);
                siblingHasCurrentPADStage = true;
              }
              // Determine the Federal Fiscal Year
              int fedFiscalYear = getFedFiscalYear();
              String ffy = String.valueOf(fedFiscalYear);
              
              // Determine the child's age
              Person siblingOfChild = (Person) getPersistentObject(Person.class, idSibling);
              int siblingDob = DateHelper.getAge(siblingOfChild.getDtPersonBirth());
              //Compare the child's age with the age criterion and determine if the child has met the criterion
              String ageCriterion = Lookup.simpleDecodeSafe(CodesTables.CFCACCAC, ffy);
              if (siblingDob >= Integer.valueOf(ageCriterion)) {
                aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_YES);
                // If the sibling has a PAD stage, use the Person information from that stage
                // to populate the sibling info on the page, else use the Person information from the ADO case
                if (siblingHasCurrentPADStage) {
                  aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                  aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                  aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                  return;
                } else {
                  aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                  aAFundingSummarySO.setIdApplicableSibling(idSibling);
                  aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                  foundApplicableSibling = true;
                  return;
                }
              } 
              // If sibling doesn't meet the applicable age criterion, check to see if he/she meets the
              // Applicable Time in Foster Care criterion
              if (!foundApplicableSibling) {
                // Start by getting the FCC(SUB) stage of the sibling
                int idFCCStage = stagePersonLinkDAO.findIdFccStageByIdPerson(idSibling);
                Stage shouldBeFCCStage = stageDAO.findStageByIdStage(idFCCStage);
                // If the stage is not an FCC Stage, then child doesn't have Foster Care History
                if (idFCCStage == 0 || !FCC_STAGE.equals(shouldBeFCCStage.getCdStage())) {
                  break;
                }
                List<Object[]> adoCaseLegalStatuses = legalStatusDAO.findAllLegalStatusesForCaseUsingView(idSibling, shouldBeFCCStage.getCapsCase().getIdCase());
                if (!listIsValid(adoCaseLegalStatuses)) {
                  aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_NO);
                  // Clear out sibling name, id, dob
                  aAFundingSummarySO.setNmAcSiblingFullName(null);
                  aAFundingSummarySO.setDtAcSiblingDob(null);
                  aAFundingSummarySO.setIdApplicableSibling(0);
                  return;
                }
                boolean bIsInDFCSCustody = false;
                Date startDateTracker = null;
                Date endDateTracker = null;
                for (Object[] adoCaseLegalStatus : adoCaseLegalStatuses) {
                  Date startDate = (Date) adoCaseLegalStatus[0];
                  Date endDate = (Date) adoCaseLegalStatus[1];
                  String isInDFCSCustody = (String) adoCaseLegalStatus[2];
                  if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && !bIsInDFCSCustody) {
                    startDateTracker = startDate;
                    endDateTracker = endDate;
                    bIsInDFCSCustody = true;
                  } else {
                    if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && bIsInDFCSCustody) {
                      startDateTracker = startDate;
                    } else {
                      int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
                      if (consecMonths >= SIXTY_MONTHS) {
                        aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_YES);
                        // If the sibling has a PAD stage, use the Person information from that stage
                        // to populate the sibling info on the page, else use the Person information from the ADO case
                        if (siblingHasCurrentPADStage) {
                          aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                          aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                          aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                          return;
                        } else {
                          aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                          aAFundingSummarySO.setIdApplicableSibling(idSibling);
                          aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                          return;
                        }
                      } else {
                        startDateTracker = null;
                        endDateTracker = null;
                        bIsInDFCSCustody = false;
                      }
                    }
                  }
                }
                // STGAP00017242: if reached end of legal status list and bIsInDFCSCustody is true
                // calculate if 60 months is met because the last record did not calculate.
                if (bIsInDFCSCustody) {
                  int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
                  if (consecMonths >= SIXTY_MONTHS) {
                    aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_YES);
                    if (siblingHasCurrentPADStage) {
                      aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                      aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                      aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                      return;
                    } else {
                      aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                      aAFundingSummarySO.setIdApplicableSibling(idSibling);
                      aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                      return;
                    }
                  }
                }                
              }
            }
          }
        }  
      if (listIsValid(listOfExternalSiblings)) {
        // if Sibling External Link list is valid and have not found applicable child
        // loop thru the list and do age and time in foster care check on each sibling
        if (!foundApplicableSibling) {
          // Loop thru the list and do age and time in foster care check on each sibling
          // Set the found applicable child indicator
          for (AdoSiblingExtLnkHistory sibling : listOfExternalSiblings) {
            int idSibling = sibling.getPerson().getIdPerson();
            if (idSibling != idChild) {
              // Get the stage and idPerson of the Post-Adoption Case to see if sibling currently
              // has a PAD stage as we would want to display the sibling's current name, person ID and DOB
              Map<String, Integer> currentPADInfo = stagePersonLinkDAO.findPADStageByPriorAdoptionIdPersonIdAdoStage(idSibling);
              boolean siblingHasCurrentPADStage = false;
              Person padSibling = new Person();
              int idPADSibling = 0;
              int idPADSiblingStage = 0;
              if (currentPADInfo != null) {
                idPADSibling = currentPADInfo.get("idPerson");
                idPADSiblingStage = currentPADInfo.get("idStage");
                padSibling = personDAO.findPersonByIdPerson(idPADSibling);
                siblingHasCurrentPADStage = true;
              }
              // Determine the Federal Fiscal Year
              int fedFiscalYear = getFedFiscalYear();
              String ffy = String.valueOf(fedFiscalYear);

              // Determine the sibling's age
              Person siblingOfChild = (Person) getPersistentObject(Person.class, idSibling);
              int siblingDob = DateHelper.getAge(siblingOfChild.getDtPersonBirth());
              // Compare the child's age with the age criterion and determine if the child has met the criterion
              String ageCriterion = Lookup.simpleDecodeSafe(CodesTables.CFCACCAC, ffy);
              if (siblingDob >= Integer.valueOf(ageCriterion)) {
                aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_YES);
                // If the sibling has a PAD stage, use the Person information from that stage
                // to populate the sibling info on the page, else use the Person information from the ADO case
                if (siblingHasCurrentPADStage) {
                  aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                  aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                  aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                  return;
                } else {
                  aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                  aAFundingSummarySO.setIdApplicableSibling(idSibling);
                  aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                  foundApplicableSibling = true;
                  return;
                }
              }
              // If sibling doesn't meet the applicable age criterion, check to see if he/she meets the
              // Applicable Time in Foster Care criterion
              if (!foundApplicableSibling) {
                // Start by getting the FCC(SUB) stage of the sibling
                int idFCCStage = stagePersonLinkDAO.findIdFccStageByIdPerson(idSibling);
                Stage shouldBeFCCStage = stageDAO.findStageByIdStage(idFCCStage);
                // If the stage is not an FCC Stage, then child doesn't have Foster Care History
                if (idFCCStage == 0 || !FCC_STAGE.equals(shouldBeFCCStage.getCdStage())) {
                  break;
                }
                List<Object[]> adoCaseLegalStatuses = legalStatusDAO.findAllLegalStatusesForCaseUsingView(idSibling,
                                                                                                          shouldBeFCCStage.getCapsCase()
                                                                                                                  .getIdCase());
                if (!listIsValid(adoCaseLegalStatuses)) {
                  aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_NO);
                  return;
                }
                boolean bIsInDFCSCustody = false;
                Date startDateTracker = null;
                Date endDateTracker = null;
                for (Object[] adoCaseLegalStatus : adoCaseLegalStatuses) {
                  Date startDate = (Date) adoCaseLegalStatus[0];
                  Date endDate = (Date) adoCaseLegalStatus[1];
                  String isInDFCSCustody = (String) adoCaseLegalStatus[2];
                  if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && !bIsInDFCSCustody) {
                    startDateTracker = startDate;
                    endDateTracker = endDate;
                    bIsInDFCSCustody = true;
                  } else {
                    if (ServiceConstants.FND_YES.equals(isInDFCSCustody) && bIsInDFCSCustody) {
                      startDateTracker = startDate;
                    } else {
                      int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
                      if (consecMonths >= SIXTY_MONTHS) {
                        aAFundingSummarySO.setIndAcTimeInFosterMet(ServiceConstants.FND_YES);
                        // If the sibling has a PAD stage, use the Person information from that stage
                        // to populate the sibling info on the page, else use the Person information from the ADO case
                        if (siblingHasCurrentPADStage) {
                          aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                          aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                          aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                          return;
                        } else {
                          aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                          aAFundingSummarySO.setIdApplicableSibling(idSibling);
                          aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                          return;
                        }
                      } else {
                        startDateTracker = null;
                        endDateTracker = null;
                        bIsInDFCSCustody = false;
                      }
                    }
                  }
                }
                // STGAP00017242: if reached end of legal status list and bIsInDFCSCustody is true
                // calculate if 60 months is met because the last record did not calculate.
                if (bIsInDFCSCustody) {
                  int consecMonths = DateUtility.getAgeInMonths(startDateTracker, endDateTracker);
                  if (consecMonths >= SIXTY_MONTHS) {
                    aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_YES);
                    if (siblingHasCurrentPADStage) {
                      aAFundingSummarySO.setNmAcSiblingFullName(padSibling.getNmPersonFull());
                      aAFundingSummarySO.setIdApplicableSibling(idPADSibling);
                      aAFundingSummarySO.setDtAcSiblingDob(padSibling.getDtPersonBirth());
                      return;
                    } else {
                      aAFundingSummarySO.setNmAcSiblingFullName(siblingOfChild.getNmPersonFull());
                      aAFundingSummarySO.setIdApplicableSibling(idSibling);
                      aAFundingSummarySO.setDtAcSiblingDob(siblingOfChild.getDtPersonBirth());
                      return;
                    }
                  }
                }                
              }
            }
          }
        }
      }
        // If an Applicable Sibling hasn't been found then the child has not met the criterion
        if (!foundApplicableSibling) {
          aAFundingSummarySO.setIndAcSiblingMet(ServiceConstants.FND_NO);
          // Clear out sibling name, id, dob
          aAFundingSummarySO.setNmAcSiblingFullName(null);
          aAFundingSummarySO.setDtAcSiblingDob(null);
          aAFundingSummarySO.setIdApplicableSibling(0);
        }
    }
    
  }
  
  private void applicableIVERemovalCToWOrVPAOrVRCheck (AAFundingSummarySO aAFundingSummarySO) {
    int idChild = aAFundingSummarySO.getIdChild();
    String cdStage = aAFundingSummarySO.getCdStage();
    int idADOStage = 0;
    int idADOCase = 0;
    if (ADO_STAGE.equals(cdStage)) {
      idADOCase = aAFundingSummarySO.getIdCase();
      idADOStage = aAFundingSummarySO.getIdStage();
      // Start by getting the child's current legal status in this case
      LegalStatus legalStatus = legalStatusDAO.findCurrentLegalStatusByIdPerson(idChild);
      String cdCurrentLegalStatus = legalStatus.getCdLegalStatStatus();
      // If the status is Temporary Voluntary or Permanent Voluntary, the child has met this criterion
      if (CodesTables.CLEGSTAT_TVL.equals(cdCurrentLegalStatus) || CodesTables.CLEGSTAT_PVL.equals(cdCurrentLegalStatus)) {
        aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_YES);
        return;
      } 
      // If the status is Temporary Court, Joint Commitment to DJJ - Temporary Court, Permanent Court or
      // Joint Commitment to DJJ - Permanent Court, check to see if check to see if exists a legal action
      // that has the Best Interest/Contrary to Welfare language
      else if (NON_VOLUNTARY_LEGAL_STATUS.contains(cdCurrentLegalStatus)) {
        // do nothing
      } else {
        // Child is not in DFCS Custody. Therefore, he/she has "Not Met" the criterion
        aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_NO);
        return;
      }
    } 
    Date removalDate = null;
    // Get the case id of the ADO case if this stage is PAD
    if (PAD_STAGE.equals(cdStage)) {
      Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(aAFundingSummarySO.getIdChild());
      if (priorAdoptionInfo != null) {
        idChild = priorAdoptionInfo.get("idPerson");
        idADOStage = priorAdoptionInfo.get("idStage");
        Stage adoStage = stageDAO.findStageByIdStage(idADOStage);
        idADOCase = adoStage.getCapsCase().getIdCase();
      }
      
    } 
    removalDate = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(idADOCase, idChild);
    if (removalDate != null) {
      // Legal Action
      List<String> cdLegalActActions = new ArrayList<String>();
      cdLegalActActions.add(CodesTables.CLEGCPS_HRG); // Hearing
      cdLegalActActions.add(CodesTables.CLEGCPS_RCO); // Receive Court Order
      // Court Order Language
      String crtOrderLangCWC = CodesTables.CCRTLANG_CWC; // Best Interest/Contrary To The Welfare Of The Child
      String crtOrderLangRPR = CodesTables.CCRTLANG_RPR; // Reasonable Efforts Were Made To Prevent Removal
      String crtOrderLangRNN = CodesTables.CCRTLANG_RNN; // Reasonable Efforts Were Not Required

      List<String> crtOrderLangs = new ArrayList<String>();
      crtOrderLangs.add(crtOrderLangRPR);
      crtOrderLangs.add(crtOrderLangRNN);
      // outcomes
      String cdOutComeTypeCyg = CodesTables.CLEGLOUT_CYG; // Custody Granted
      List<String> cdOutComeTypes = new ArrayList<String>();
      cdOutComeTypes.add(cdOutComeTypeCyg);
      // Contrary to Welfare and Best Interest language
      List<LegalAction> bestInterestLegalActions = legalActionDAO.findFirstBestIntestLegalActionsForCaseForFCE(
                                                                                                               idADOCase,
                                                                                                               idChild,
                                                                                                               cdLegalActActions,
                                                                                                               crtOrderLangCWC);
      if (bestInterestLegalActions != null && bestInterestLegalActions.size() > 0) {
        LegalAction legalAction = bestInterestLegalActions.get(bestInterestLegalActions.size() - 1);
        Date dtRemovalChildOrdered = legalAction.getDtCrtOrdDate();
        if (dtRemovalChildOrdered != null) {
          // The appropriate legal action with the Best Interest/Contrary to Welfare language was found
          aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_YES);
        }
        // The appropriate legal action with the Best Interest/Contrary to Welfare language was not found
        else {
          aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_NO);
        }
      }
      // The appropriate legal action with the Best Interest/Contrary to Welfare language was not found
      else {
        aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_NO);
      }
    }
    // Without a Removal Date being located, it's technically impossible to find the appropriate
    // legal action with the Best Interest/Contrary to Welfare language. Therefore, it should be
    // safe to indicate that the child has "Not Met" this criterion
    else {
      aAFundingSummarySO.setIndAcTprCtwVsMet(ServiceConstants.FND_NO);
    }
  }
  
  /**
   * Used for Applicable IV-E and Non-Applicable IV-E criteria
   * 
   * @param aAFundingSummarySO
   * @param indApplicableOrNonApplicableCheck
   */
  private void iVESSIEligibleCheck (AAFundingSummarySO aAFundingSummarySO, String indApplicableOrNonApplicableCheck) {
    PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(aAFundingSummarySO.getIdChild());
    String indSsiMedDisabilityReqMet = personDtl.getIndSsiMedDsbltyReqMet();
    if (ServiceConstants.FND_YES.equals(indSsiMedDisabilityReqMet)) {
      if (APPLICABLE.equals(indApplicableOrNonApplicableCheck)) {
        aAFundingSummarySO.setIndAcSsiEligMet(ServiceConstants.FND_YES);
      } else {
        aAFundingSummarySO.setIndNacSsiEligMet(ServiceConstants.FND_YES);
      }
    } else {
      if (APPLICABLE.equals(indApplicableOrNonApplicableCheck)) {
        aAFundingSummarySO.setIndAcSsiEligMet(ServiceConstants.FND_NO);
      } else {
        aAFundingSummarySO.setIndNacSsiEligMet(ServiceConstants.FND_NO);
      }
    }
  }
  
  /**
   * Used for Applicable IV-E and Non-Applicable IV-E criteria
   * 
   * @param aAFundingSummarySO
   * @param indApplicableOrNonApplicableCheck
   */
  private void iVEPriorAdoptionCheck (AAFundingSummarySO aAFundingSummarySO, String indApplicableOrNonApplicableCheck) {
    Person child = personDAO.findPersonByIdPerson(aAFundingSummarySO.getIdChild());
    String indIVEPreviousAdopt = child.getIndIvePriorAdoption();
    if (ServiceConstants.FND_YES.equals(indIVEPreviousAdopt)) {
      if (APPLICABLE.equals(indApplicableOrNonApplicableCheck)) {
        aAFundingSummarySO.setIndAcIvePriorAdoptMet(ServiceConstants.FND_YES);
      } else {
        aAFundingSummarySO.setIndNacIvePriorAdoptMet(ServiceConstants.FND_YES);
      }
    } else {
      if (APPLICABLE.equals(indApplicableOrNonApplicableCheck)) {
        aAFundingSummarySO.setIndAcIvePriorAdoptMet(ServiceConstants.FND_NO);
      } else {
        aAFundingSummarySO.setIndNacIvePriorAdoptMet(ServiceConstants.FND_NO);
      }
    }
  }

  private boolean determineChildIsFCCEligible (AAFundingSummarySO aAFundingSummarySO, boolean childOnlyHasPADStage) {
    List<String> cdAaFundingReasonEligs = new ArrayList<String>();
    int idAaFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
    boolean childIsFCCEligible = false;
    List<String> eligibilityReasonsNotEligible = fccEligibleCheck (aAFundingSummarySO, childOnlyHasPADStage);
    // Determine the AA Funding Type
    if (FCC_ELIGIBILITY_IVE.equals(aAFundingSummarySO.getCdEligActual())) {
      // If child was IV-E Eligible in Foster Care than child is Adoption Assistance IV-E
      childIsFCCEligible = true;
      // Federal Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVE);
      // Only create the Reason Eligible records if the event status is not 'NEW'. 'NEW' statuses
      // would not have an AA_FUNDING record yet to reference as a Parent record
      if (!CodesTables.CEVTSTAT_NEW.equals(aAFundingSummarySO.getCdEventStatus())) {
        // Delete the existing AA Funding Reason Eligible record
        deleteAllAaFundingRsnElig(idAaFundingEvent);
        // Save this reason
        createAaFundingReasonElig(idAaFundingEvent, FCC_IVE_ELIGIBLE_CHECK);
      }
      cdAaFundingReasonEligs.add(FCC_IVE_ELIGIBLE_CHECK);
    } 
    // See if the child was FCC Title IV-B and the only reason was Reasonable Efforts Language issue.
    // If that's the case, child is still AA IV-E
    else if ((eligibilityReasonsNotEligible != null && eligibilityReasonsNotEligible.size() == 1)
               && FCC_ELIGIBILITY_REASONABLE_EFFORTS.equals(eligibilityReasonsNotEligible.get(0))) {
      childIsFCCEligible = true;
      // Federal Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVE);
      // Only create the Reason Eligible records if the event status is not 'NEW'. 'NEW' statuses
      // would not have an AA_FUNDING record to reference as a Parent record
      if (!CodesTables.CEVTSTAT_NEW.equals(aAFundingSummarySO.getCdEventStatus())) {
        // Delete the existing AA Funding Reason Eligible record
        deleteAllAaFundingRsnElig(idAaFundingEvent);
        // Save this reason
        createAaFundingReasonElig(idAaFundingEvent, FCC_REASON_EFFORTS_LANG_CHECK);
      }
      cdAaFundingReasonEligs.add(FCC_REASON_EFFORTS_LANG_CHECK);
    } 
    // Child was FCC Title IV-B, set the list of reasons the child was not eligible for Title IV-E
    // in Foster Care(FCC)
    else if (eligibilityReasonsNotEligible != null && !eligibilityReasonsNotEligible.isEmpty()) {
      aAFundingSummarySO.setCdEligibilityReasonsNotEligible(eligibilityReasonsNotEligible);
    }

    aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);
    return childIsFCCEligible;
  }
  
  private boolean determineApplicableCriteriaMet (AAFundingSummarySO aAFundingSummarySO, boolean childHasHistory) {
    boolean childIsApplicable = false;
    // Do the Age check
    if (!childIsApplicable) {
      applicableAgeCheck(aAFundingSummarySO);
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcAgeMet())) {
        // Clear out what is in the remainder of the criteria
        aAFundingSummarySO.setIndAcTimeInFosterMet(null);
        aAFundingSummarySO.setIndAcSiblingMet(null);
        childIsApplicable = true;
      }
    }
    // Do Time In Foster Care check
    if (!childIsApplicable) {
      if (childHasHistory) {
        applicableTimeInFosterCareCheck(aAFundingSummarySO);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcTimeInFosterMet())) {
        // If the child has history, clear out what is in the remainder of the criteria
        if (childHasHistory) {
          aAFundingSummarySO.setIndAcSiblingMet(null);
        }
        childIsApplicable = true;
      }
    }
    // Do Sibling of an Applicable Child check
    if (!childIsApplicable) {
      if (childHasHistory) {
        applicableSiblingOfApplicableChildCheck(aAFundingSummarySO);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcSiblingMet())) {
        childIsApplicable = true;
      }
    }
    
    return childIsApplicable;
  }
  
  private boolean determineApplicableIVECriteriaMet (AAFundingSummarySO aAFundingSummarySO, boolean childHasHistory) {
    List<String> cdAaFundingReasonEligs = new ArrayList<String>();
    int idAaFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
    boolean childIsApplicableIVE = false;
    // Do Applicable IV-E TPR, Contrary to Welfare and Voluntary Surrender check
    if (!childIsApplicableIVE) {
      if (childHasHistory) {
        applicableIVERemovalCToWOrVPAOrVRCheck(aAFundingSummarySO);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcTprCtwVsMet())) {
        // If the child has history, clear out what is in the remainder of the criteria
        if (childHasHistory) {
          aAFundingSummarySO.setIndAcSsiEligMet(null);
          aAFundingSummarySO.setIndAcIvePriorAdoptMet(null);
        }
        childIsApplicableIVE = true;
      }
    }
    // Do Applicable IV-E SSI Eligible check. Pre-population is done under any circumstances
    if (!childIsApplicableIVE) {
      iVESSIEligibleCheck(aAFundingSummarySO, APPLICABLE);
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcSsiEligMet())) {
        // If the child has history, clear out what is in the remainder of the criteria
        if (childHasHistory) {
          aAFundingSummarySO.setIndAcIvePriorAdoptMet(null);
        }
        childIsApplicableIVE = true;
      }
    }
    // Do Applicable IV-E Child of Minor Parent check
    if (!childIsApplicableIVE) {
      // Child of Minor Parent criterion determination is always manually entered by the user
      // regardless if the child has Foster Care history or not. Therefore, we simply need to
      // to check if user indicated that the child has "Met" or "Not Met" this criterion
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcChildOfMinorMet())) {
        childIsApplicableIVE = true;
      }
    }
    if (!childIsApplicableIVE) {
      // Do Applicable IV-E Eligible for IV-E AA in Prior Adoption check. Pre-population is done under any circumstances
      // if no selection has been made
      if (!StringHelper.isValid(aAFundingSummarySO.getIndAcIvePriorAdoptMet())) {
        iVEPriorAdoptionCheck(aAFundingSummarySO, APPLICABLE);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndAcIvePriorAdoptMet())) {
        childIsApplicableIVE = true;
      }
    }
    // Determine the AA Funding Type
    if (childIsApplicableIVE) {
      // Federal Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVE);
      // Save this reason if the event status is not 'NEW'. Events in 'NEW' statuses
      // do not have an AA_FUNDING record as of yet and this will throw a constraint violation
      // as AA_FUNDING_REASON_ELIG records reference an AA_FUNDING record.  AA_FUNDING record 
      // will be created after the initial Save
      if (!CodesTables.CEVTSTAT_NEW.equals(aAFundingSummarySO.getCdEventStatus())) {
        // Delete the existing AA Funding Reason Eligible record
        deleteAllAaFundingRsnElig(idAaFundingEvent);
        createAaFundingReasonElig(idAaFundingEvent, APP_CHILD_IVE_CHECK);
      }
      cdAaFundingReasonEligs.add(APP_CHILD_IVE_CHECK);
    } else {
      // State Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVB);
      // Delete the existing AA Funding Reason Eligible record
      deleteAllAaFundingRsnElig(idAaFundingEvent);
    }
    aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);
    return childIsApplicableIVE;
  }
  
  private boolean determineNonApplicableIVECriteriaMet (AAFundingSummarySO aAFundingSummarySO, boolean childHasHistory) {
    List<String> cdAaFundingReasonEligs = new ArrayList<String>();
    int idAaFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
    boolean childIsNonApplicableIVE = false;
    // Do Non-Applicable AFDC check
    if (!childIsNonApplicableIVE) {
      // AFDC criterion determination is always manually entered by the user
      // regardless if the child has Foster Care history or not. Therefore, we simply need to
      // to check if user indicated that the child has "Met" or "Not Met" this criterion
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNacAfdcMet())) {
        
        childIsNonApplicableIVE = true;
      }
    }
    // Do Non-Applicable IV-E SSI Eligible check. Pre-population is done under any circumstances
    // if no selection has been made
    if (!childIsNonApplicableIVE) {
      // If user hasn't made this determination yet, pre-populate the indicator
      if (!StringHelper.isValid(aAFundingSummarySO.getIndNacSsiEligMet())) {
        iVESSIEligibleCheck(aAFundingSummarySO, NON_APPLICABLE);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNacSsiEligMet())) {
        childIsNonApplicableIVE = true;
      }
    }
    // Do Non-Applicable IV-E Child of Minor Parent check
    if (!childIsNonApplicableIVE) {
      // Child of Minor Parent criteria determination is always manually entered by the user
      // regardless if the child has Foster Care history or not. Therefore, we simply need to
      // to check if user indicated that the child has "Met" or "Not Met" this criterion
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNacChildOfMinorMet())) {
        childIsNonApplicableIVE = true;
      }
    }
    // Do Non-Applicable IV-E Eligible for IV-E AA in Prior Adoption check. Pre-population is done under any circumstances
    // if the nothing has been selected
    if (!childIsNonApplicableIVE) {
      if (!StringHelper.isValid(aAFundingSummarySO.getIndNacIvePriorAdoptMet())) {
        iVEPriorAdoptionCheck(aAFundingSummarySO, NON_APPLICABLE);
      }
      if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNacIvePriorAdoptMet())) {
        childIsNonApplicableIVE = true;
      }
    }
    // Determine the AA Funding Type
    if (childIsNonApplicableIVE) {
      // Federal Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVE);
      // Save this reason if the event status is not 'NEW'. Events in 'NEW' statuses
      // do not have an AA_FUNDING record as of yet and will be created after the initial Save
      if (!CodesTables.CEVTSTAT_NEW.equals(aAFundingSummarySO.getCdEventStatus())) {
        // Delete the existing AA Funding Reason Eligible record
        deleteAllAaFundingRsnElig(idAaFundingEvent);
        createAaFundingReasonElig(idAaFundingEvent, NON_APP_CHILD_IVE_CHECK);
      }
      cdAaFundingReasonEligs.add(NON_APP_CHILD_IVE_CHECK);
    }else {
      // State Funded Adoption Assistance
      aAFundingSummarySO.setCdAaFundingType(TITLE_IVB);
      // Delete the existing AA Funding Reason Eligible record
      deleteAllAaFundingRsnElig(idAaFundingEvent);
    }
    aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);
    return childIsNonApplicableIVE;
  }
  
  /**
   * Finds the most recently approved Eligibility Summary for a given stage and child's ID
   * 
   * @param idStage
   * @param idChild
   * @return
   */
  private Eligibility findMostRecentEligibilitySummaryEvent(int idStage, int idChild) {
    Eligibility eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idChild);
    return eligibility;
  }
  
  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  private int deleteAllAaFundingRsnElig(int idAaFundingEvent) {
    return aaFundingReasonEligDAO.deleteAllAaFundingRsnEligByIdEvent(idAaFundingEvent);
  }
  
  private void createAaFundingReasonElig(int idAaFundingEvent, String cdAaFundingRsn) {
    AaFundingReasonElig aaFundingReasonElig = new AaFundingReasonElig();
    aaFundingReasonElig.setCdAaFundingRsn(cdAaFundingRsn);
    AaFunding aaFunding = (AaFunding) getPersistentObject(AaFunding.class, idAaFundingEvent);
    aaFundingReasonElig.setAaFunding(aaFunding);
    aaFundingReasonEligDAO.saveAaFundingReasonElig(aaFundingReasonElig);
  }
  
  private List<AaFundingReasonElig> getAllAaFundingReasonElig(int idAaFundingEvent) {
    return aaFundingReasonEligDAO.findAaFundingReasonElig(idAaFundingEvent);
  }
}
