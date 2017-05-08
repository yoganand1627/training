package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.DomicileDeprivation;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class used display and save the Removal Household and Deprivation page.
 *
 * @author Rodrigo DeJuana, February 17, 2003
 */
/*
 Change History:
 Date      User              Description
 --------  ----------------  ----------------------------------------------
 02/17/03  Rodrigo DeJuana   Initial Revision.
 04/25/05  wadesa            SIR - 23141 Changed inline setters to reconcile
                             data inconsistencies on database.
 11/18/10  Hai Nguyen        SMS#81144: MR-053 Eligibility Updates. Added new fields
                             population. Removed edit button logic.  Updated page mode
                             logic. Added new save button branch. Added new fields in
                             clear method. Removed saveConfirmaiton and edit xa methods.
 12/14/10  Hai Nguyen        SMS#86169: updated save logic to do calculation after saving
                             changes on page. Also to enable Save button for user to save
                             system determination for NOC and navigate to next page.
*/

public class DomicileDeprivationConversation extends FceConversation {
  public static final String FCE_APPLICATION_PAGE_MODE = "fceApplicationPageMode";
  public static final String TRACE_TAG = "DomicileDeprivationConversation";
  public static final String DOMICILEDB = "domcileDB";

  public static final String YES = ArchitectureConstants.Y;
  public static final String NO = ArchitectureConstants.N;
  public static final String NA = "A";

  public static final String LIV_ARR_BOTH = CodesTables.CFCELIV_B;
  public static final String LIV_ARR_ONE = CodesTables.CFCELIV_O;
  public static final String LIV_ARR_OTHER = CodesTables.CFCELIV_R;
  public static final String LIV_ARR_NONE = CodesTables.CFCELIV_N;

  public static final char C_LIV_ARR_BOTH = 'B';
  public static final char C_LIV_ARR_ONE = 'O';
  public static final char C_LIV_ARR_OTHER = 'R';
  public static final char C_LIV_ARR_NONE = 'N';

  private DomicileDeprivation domicileDeprivation;

  public void setDomicileDeprivation(DomicileDeprivation domicileDeprivation) {
    this.domicileDeprivation = domicileDeprivation;
  }

  public DomicileDeprivationConversation() {
    super(TRACE_TAG);
  }

  /**
   * This method will collect the data display the Domcile and Dep page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayDomicile_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDomicile_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    clearState(context);
    FceUtility.setApplicationFceTabState(request);

    try {
      DomicileDeprivationDB domicileDeprivationDB = domicileDeprivation.read(GlobalData.getUlIdStage(request),
                                                                  GlobalData.getUlIdEvent(request), getUserID(request));

      request.setAttribute(DOMICILEDB, domicileDeprivationDB);

      setPageMode(request, domicileDeprivationDB);

      FceUtility.setCdEventStatus(domicileDeprivationDB, request);

      if ((EventHelper.PENDING_EVENT.equals(domicileDeprivationDB.getCdEventStatus())) &&
          (domicileDeprivationDB.getNbrCertifiedGroup() == 0) &&
          ((LIV_ARR_BOTH.equals(domicileDeprivationDB.getCdLivingMonthRemoval())) ||
           (LIV_ARR_BOTH.equals(domicileDeprivationDB.getCdNotaMostRecent())))) {
        setInformationalMessage(Messages.MSG_ASSIGN_CERTIFIED_GROUP, request);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will save the data in the main section.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveDomicile_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveDomicile_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      DomicileDeprivationDB domicileDeprivationDB = read(context);
      domicileDeprivation.save(domicileDeprivationDB);
      
      // fetch DB again after saving changes to do calculation and save system derived deprivation
      domicileDeprivationDB = domicileDeprivation.read(GlobalData.getUlIdStage(request),
                                                                           GlobalData.getUlIdEvent(request), getUserID(request));
      domicileDeprivation.save(domicileDeprivationDB);
      
      boolean bSave = ContextHelper.getString(request, "btnSave.x") != null;

      if (bSave 
                      && FceUtility.isEligibilitySpecialist(request)
                      && (EventHelper.PENDING_EVENT.equals(domicileDeprivationDB.getCdEventStatus())
                                      || EventHelper.COMPLETE_EVENT.equals(domicileDeprivationDB.getCdEventStatus()))
                      && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
        this.setPresentationBranch("stay", context);
      }
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  public DomicileDeprivationDB read(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    DomicileDeprivationDB domicileDeprivationDB = new DomicileDeprivationDB();

    //clear Other(s)
    domicileDeprivationDB.setIdOtherRelativePerson(0);
    domicileDeprivationDB.setIdMngngCvsPerson(0);

    clearLivingArrangementNota(domicileDeprivationDB);

    populateWithRequest(domicileDeprivationDB, request);

    String livingCondition = domicileDeprivationDB.getCdLivingMonthRemoval();
    if ((LIV_ARR_NONE.equals(livingCondition)) &&
        (domicileDeprivationDB.getIndChildLivingPrnt6Mnths())) {
      livingCondition = domicileDeprivationDB.getCdNotaMostRecent();
    }

    //conditionally clear One and Both sections
    FceEligibilityDB fceEligibilityDB = readFceEligibility(request, livingCondition);
    domicileDeprivationDB.setFceEligibility(fceEligibilityDB);

    //conditionally clear parts of NOTA
    if (LIV_ARR_NONE.equals(domicileDeprivationDB.getCdLivingMonthRemoval()) == false) {
      clearLivingArrangementNota(domicileDeprivationDB);
    } else if (domicileDeprivationDB.getIndChildLivingPrnt6Mnths() == false) {
      domicileDeprivationDB.setCdNotaMostRecent(null);
    }

    //conditionally clear OTHER Relative fields
    if (LIV_ARR_OTHER.equals(livingCondition)) {
      if (LIV_ARR_NONE.equals(domicileDeprivationDB.getCdLivingMonthRemoval())) {
        domicileDeprivationDB.setIdOtherRelativePerson(0);
      } else {
        domicileDeprivationDB.setIdMngngCvsPerson(0);
      }
    } else {
      domicileDeprivationDB.setIdOtherRelativePerson(0);
      domicileDeprivationDB.setIdMngngCvsPerson(0);
      domicileDeprivationDB.setIndSpecifiedRelative((Boolean)null);
    }

    return domicileDeprivationDB;
  }

  /** Reads FceEligibilityDB from request; clearing out state as appropriate for Deprivation */
  public static FceEligibilityDB readFceEligibility(HttpServletRequest request, String livingCondition) {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();

    clearLivingArrangementBoth(fceEligibilityDB);
    clearLivingArrangementOne(fceEligibilityDB);

    populateWithRequest(fceEligibilityDB, request);

    if (!LIV_ARR_BOTH.equals(livingCondition)) {
      clearLivingArrangementBoth(fceEligibilityDB);
    }
    if (!LIV_ARR_ONE.equals(livingCondition)) {
      clearLivingArrangementOne(fceEligibilityDB);
    }

    if (LIV_ARR_BOTH.equals(livingCondition)) {
      if (fceEligibilityDB.getIndMotherPwe()) {
        fceEligibilityDB.setIndFatherPwe(Boolean.FALSE);
        fceEligibilityDB.setIndMotherPwe(Boolean.TRUE);
      } else {
        fceEligibilityDB.setIndFatherPwe(Boolean.TRUE);
        fceEligibilityDB.setIndMotherPwe(Boolean.FALSE);
      }
    }

    if (LIV_ARR_ONE.equals(livingCondition)) {
      if (fceEligibilityDB.getIndAbsentMother()) {
        /*
        ** SIR.23141 - Changed the setter methods to save opposite of what the
        ** code was doing previously.  This reconciled data inconsistency on the
        ** database. Switched:
        **   - Boolean.TRUE --> Boolean.FALSE
        **   - Boolean.FALSE --> Boolean.TRUE
        */
        fceEligibilityDB.setIndAbsentFather(Boolean.TRUE);
        fceEligibilityDB.setIndAbsentMother(Boolean.FALSE);
      } else {
        /*
        ** SIR.23141 - Changed the setter methods to save opposite of what the
        ** code was doing previously.  This reconciled data inconsistency on the
        ** database. Switched:
        **   - Boolean.TRUE --> Boolean.FALSE
        **   - Boolean.FALSE --> Boolean.TRUE
        */
        fceEligibilityDB.setIndAbsentFather(Boolean.FALSE);
        fceEligibilityDB.setIndAbsentMother(Boolean.TRUE);
      }
    }

    return fceEligibilityDB;
  }

  /**
   */
  private static void clearLivingArrangementBoth(FceEligibilityDB fceEligibilityDB) {
    fceEligibilityDB.setIndParentDisabled((Boolean) null);
    fceEligibilityDB.setTxtMonthsDepDisabled(null);
    fceEligibilityDB.setIndSsiVerification((Boolean) null);
    fceEligibilityDB.setIndRsdiVerification((Boolean) null);
    fceEligibilityDB.setIndOtherVerification((Boolean) null);
    fceEligibilityDB.setIndMotherPwe((Boolean) null);
    fceEligibilityDB.setIndFatherPwe((Boolean) null);
    fceEligibilityDB.setCdPweSteadyUnder100(null);
    fceEligibilityDB.setCdPweIrregularUnder100(null);
    fceEligibilityDB.setTxtMonthsDepUnemp(null);
    fceEligibilityDB.setTxtMonthsDepUnderEmpl(null);
    fceEligibilityDB.setAmtPweIncome((Long) null);
    fceEligibilityDB.setCdVerifMethod(null);
    fceEligibilityDB.setCdVerifDocType(null);
    fceEligibilityDB.setIndPeNotAcptEmpTrn((Boolean)null);
    fceEligibilityDB.setIndPeRecvUnemp((Boolean)null);
    fceEligibilityDB.setIndPeWrkEngEduTrn((Boolean)null);
    fceEligibilityDB.setIdPrnEarner(0);
    fceEligibilityDB.setIndRecv100PctVa((Boolean)null);
    fceEligibilityDB.setIndRecvRrRsdi((Boolean)null);
  }

  private static void clearLivingArrangementOne(FceEligibilityDB fceEligibilityDB) {
    fceEligibilityDB.setIndAbsentMother((Boolean) null);
    fceEligibilityDB.setIndAbsentFather((Boolean) null);
    fceEligibilityDB.setIndAbsentMilitaryWork((Boolean) null);
    fceEligibilityDB.setIndAbsentDeported((Boolean) null);
    fceEligibilityDB.setIndAbsentDeserted((Boolean) null);
    fceEligibilityDB.setIndAbsentDied((Boolean) null);
    fceEligibilityDB.setIndAbsentDivorced((Boolean) null);
    fceEligibilityDB.setIndAbsentHospitalized((Boolean) null);
    fceEligibilityDB.setIndAbsentIncarcerated((Boolean) null);
    fceEligibilityDB.setIndAbsentSeparated((Boolean) null);
    fceEligibilityDB.setIndAbsentAltrntCustody((Boolean) null);
    fceEligibilityDB.setIndAbsentWorkRelated((Boolean) null);
    fceEligibilityDB.setIndAbsentNeverCohabitated((Boolean) null);
    fceEligibilityDB.setIndAbsentTprVolRelinq((Boolean) null);
  }

  private static void clearLivingArrangementNota(DomicileDeprivationDB domicileDeprivationDB) {
    domicileDeprivationDB.setIndChildLivingPrnt6Mnths((Boolean) null);
    domicileDeprivationDB.setCdNotaMostRecent(null);
    domicileDeprivationDB.setTxtMonthsLivingRelCust(null);
  }

  /**
   * This method will set the page mode.
   *
   * @param request
   * @param domicileDeprivationDB
   */
  private void setPageMode(HttpServletRequest request, DomicileDeprivationDB domicileDeprivationDB) {
    String pageMode = FceUtility.getFceApplicationPageMode(request, domicileDeprivationDB);

    request.setAttribute(FCE_APPLICATION_PAGE_MODE, pageMode);

    String cdApplication = domicileDeprivationDB.getCdApplication();
    
    if (ApplicationAndBackgroundConversation.REAPPLICATION_TYPE.equals(cdApplication)) {
      pageMode = PageModeConstants.VIEW;
    }
                
    PageMode.setPageMode(pageMode, request);
  }

  public static void populateWithRequest(FceEligibilityDB fceEligibilityDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(FceEligibilityDB.AMT_COUNTABLE_INCOME)) {
      fceEligibilityDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                         FceEligibilityDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(FceEligibilityDB.AMT_COUNTABLE_INCOME_MONEY)) {
      fceEligibilityDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                FceEligibilityDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                             FceEligibilityDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(FceEligibilityDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    FceEligibilityDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      fceEligibilityDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                               FceEligibilityDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(FceEligibilityDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      fceEligibilityDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      FceEligibilityDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_INCOME_LIMIT)) {
      fceEligibilityDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request, FceEligibilityDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(FceEligibilityDB.AMT_INCOME_LIMIT_MONEY)) {
      fceEligibilityDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                            FceEligibilityDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_PWE_INCOME)) {
      fceEligibilityDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, FceEligibilityDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(FceEligibilityDB.AMT_PWE_INCOME_MONEY)) {
      fceEligibilityDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                          FceEligibilityDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_SSI)) {
      fceEligibilityDB.setAmtSsi(ContextHelper.getDoubleSafe(request, FceEligibilityDB.AMT_SSI));
    }
    if (map.containsKey(FceEligibilityDB.AMT_SSI_MONEY)) {
      fceEligibilityDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, FceEligibilityDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_ALIMONY)) {
      fceEligibilityDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                           FceEligibilityDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      fceEligibilityDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                  FceEligibilityDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_ALLOWANCE)) {
      fceEligibilityDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                             FceEligibilityDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      fceEligibilityDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    FceEligibilityDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      fceEligibilityDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                 FceEligibilityDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      fceEligibilityDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        FceEligibilityDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      fceEligibilityDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                 FceEligibilityDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      fceEligibilityDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        FceEligibilityDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_GROSS_EARNED)) {
      fceEligibilityDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                               FceEligibilityDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      fceEligibilityDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      FceEligibilityDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      fceEligibilityDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                               FceEligibilityDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      fceEligibilityDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      FceEligibilityDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      fceEligibilityDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                              FceEligibilityDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      fceEligibilityDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     FceEligibilityDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      fceEligibilityDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                              FceEligibilityDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(FceEligibilityDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      fceEligibilityDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     FceEligibilityDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(FceEligibilityDB.CD_BLOC_CHILD)) {
      fceEligibilityDB.setCdBlocChild(ContextHelper.getStringSafe(request, FceEligibilityDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(FceEligibilityDB.CD_ELIGIBILITY_ACTUAL)) {
      fceEligibilityDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                          FceEligibilityDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(FceEligibilityDB.CD_ELIGIBILITY_SELECTED)) {
      fceEligibilityDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                            FceEligibilityDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(FceEligibilityDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      fceEligibilityDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                FceEligibilityDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(FceEligibilityDB.CD_PERSON_CITIZENSHIP)) {
      fceEligibilityDB.setCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                          FceEligibilityDB.CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(FceEligibilityDB.CD_PWE_IRREGULAR_UNDER100)) {
      fceEligibilityDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                             FceEligibilityDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(FceEligibilityDB.CD_PWE_STEADY_UNDER100)) {
      fceEligibilityDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                          FceEligibilityDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(FceEligibilityDB.CD_VERIF_METHOD)) {
      fceEligibilityDB.setCdVerifMethod(ContextHelper.getStringSafe(request,
                                                                          FceEligibilityDB.CD_VERIF_METHOD));
    }
    if (map.containsKey(FceEligibilityDB.CD_VERIF_DOC_TYPE)) {
      fceEligibilityDB.setCdVerifDocType(ContextHelper.getStringSafe(request,
                                                                          FceEligibilityDB.CD_VERIF_DOC_TYPE));
    }
    if (map.containsKey(FceEligibilityDB.DT_ELIGIBILITY_END_STRING)) {
      fceEligibilityDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                             FceEligibilityDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_ELIGIBILITY_END_TIME)) {
      fceEligibilityDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                         FceEligibilityDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(FceEligibilityDB.DT_ELIG_DTRMNTN_START_STRING)) {
      fceEligibilityDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                               FceEligibilityDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_ELIG_DTRMNTN_START_TIME)) {
      fceEligibilityDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                           FceEligibilityDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(FceEligibilityDB.DT_LAST_UPDATE_STRING)) {
      fceEligibilityDB.setDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                         FceEligibilityDB.DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_LAST_UPDATE_TIME)) {
      fceEligibilityDB.setDtLastUpdateTime(ContextHelper.getLongSafe(request, FceEligibilityDB.DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(FceEligibilityDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      fceEligibilityDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                  FceEligibilityDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      fceEligibilityDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                              FceEligibilityDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(FceEligibilityDB.DT_REVIEW_DATE_STRING)) {
      fceEligibilityDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                         FceEligibilityDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_REVIEW_DATE_TIME)) {
      fceEligibilityDB.setDtReviewDateTime(ContextHelper.getLongSafe(request, FceEligibilityDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(FceEligibilityDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      fceEligibilityDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                    FceEligibilityDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(FceEligibilityDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      fceEligibilityDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                FceEligibilityDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(FceEligibilityDB.ID_CASE)) {
      fceEligibilityDB.setIdCase(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_CASE));
    }
    if (map.containsKey(FceEligibilityDB.ID_ELIGIBILITY_EVENT)) {
      fceEligibilityDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(FceEligibilityDB.ID_FCE_APPLICATION)) {
      fceEligibilityDB.setIdFceApplication(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(FceEligibilityDB.ID_FCE_ELIGIBILITY)) {
      fceEligibilityDB.setIdFceEligibility(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(FceEligibilityDB.ID_FCE_PERSON)) {
      fceEligibilityDB.setIdFcePerson(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_FCE_PERSON));
    }
    if (map.containsKey(FceEligibilityDB.ID_FCE_REVIEW)) {
      fceEligibilityDB.setIdFceReview(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(FceEligibilityDB.ID_LAST_UPDATE_PERSON)) {
      fceEligibilityDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                       FceEligibilityDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(FceEligibilityDB.ID_PERSON)) {
      fceEligibilityDB.setIdPerson(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_PERSON));
    }
    if (map.containsKey(FceEligibilityDB.ID_PRN_EARNER)) {
      fceEligibilityDB.setIdPrnEarner(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_PRN_EARNER));
    }
    if (map.containsKey(FceEligibilityDB.ID_STAGE)) {
      fceEligibilityDB.setIdStage(ContextHelper.getLongSafe(request, FceEligibilityDB.ID_STAGE));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      fceEligibilityDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                              FceEligibilityDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_DEPORTED)) {
      fceEligibilityDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_DESERTED)) {
      fceEligibilityDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_DIED)) {
      fceEligibilityDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_DIVORCED)) {
      fceEligibilityDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_FATHER)) {
      fceEligibilityDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_HOSPITALIZED)) {
      fceEligibilityDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                             FceEligibilityDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_INCARCERATED)) {
      fceEligibilityDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                             FceEligibilityDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_MILITARY_WORK)) {
      fceEligibilityDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                             FceEligibilityDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_MOTHER)) {
      fceEligibilityDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_NEVER_COHABITATED)) {
      fceEligibilityDB.setIndAbsentNeverCohabitated(ContextHelper.getBooleanSafe(request,
                                                                                 FceEligibilityDB.IND_ABSENT_NEVER_COHABITATED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_SEPARATED)) {
      fceEligibilityDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                          FceEligibilityDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_WORK_RELATED)) {
      fceEligibilityDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                            FceEligibilityDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(FceEligibilityDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      fceEligibilityDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                FceEligibilityDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(FceEligibilityDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      fceEligibilityDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                FceEligibilityDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(FceEligibilityDB.IND_CHILD_SUPPORT_ORDERED)) {
      fceEligibilityDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                              FceEligibilityDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(FceEligibilityDB.IND_CHILD_UNDER18)) {
      fceEligibilityDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      fceEligibilityDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      fceEligibilityDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      fceEligibilityDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      fceEligibilityDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      fceEligibilityDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_CHLD_FOUND)) {
      fceEligibilityDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      fceEligibilityDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      fceEligibilityDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      fceEligibilityDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_EVALUATION)) {
      fceEligibilityDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      fceEligibilityDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      fceEligibilityDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      fceEligibilityDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      fceEligibilityDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      fceEligibilityDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      fceEligibilityDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      fceEligibilityDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_PASSPORT)) {
      fceEligibilityDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_REFUGEE)) {
      fceEligibilityDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,FceEligibilityDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(FceEligibilityDB.IND_CTZNSHP_RESIDENT_CARD)) {
      fceEligibilityDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      fceEligibilityDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      fceEligibilityDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD)) {
      fceEligibilityDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      fceEligibilityDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      fceEligibilityDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA)) {
      fceEligibilityDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      fceEligibilityDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(FceEligibilityDB.IND_ELIGIBILITY_COURT_MONTH)) {
      fceEligibilityDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                FceEligibilityDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(FceEligibilityDB.IND_ELIGIBLE)) {
      fceEligibilityDB.setIndEligible(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_ELIGIBLE));
    }
    if (map.containsKey(FceEligibilityDB.IND_EQUITY)) {
      fceEligibilityDB.setIndEquity(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_EQUITY));
    }
    if (map.containsKey(FceEligibilityDB.IND_FATHER_PWE)) {
      fceEligibilityDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_FATHER_PWE));
    }
    if (map.containsKey(FceEligibilityDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      fceEligibilityDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                FceEligibilityDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(FceEligibilityDB.IND_MEETS_DP_OR_NOT_ES)) {
      fceEligibilityDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(FceEligibilityDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      fceEligibilityDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                             FceEligibilityDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(FceEligibilityDB.IND_MOTHER_PWE)) {
      fceEligibilityDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request, FceEligibilityDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(FceEligibilityDB.IND_NARRATIVE_APPROVED)) {
      fceEligibilityDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                            FceEligibilityDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(FceEligibilityDB.IND_OTHER_VERIFICATION)) {
      fceEligibilityDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                            FceEligibilityDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_PARENTAL_DEPRIVATION)) {
      fceEligibilityDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                              FceEligibilityDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_PARENT_DISABLED)) {
      fceEligibilityDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(FceEligibilityDB.IND_PE_NOT_ACPT_EMP_TRN)) {
      fceEligibilityDB.setIndPeNotAcptEmpTrn(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_PE_NOT_ACPT_EMP_TRN));
    }
    if (map.containsKey(FceEligibilityDB.IND_PE_RECV_UNEMP)) {
      fceEligibilityDB.setIndPeRecvUnemp(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_PE_RECV_UNEMP));
    }
    if (map.containsKey(FceEligibilityDB.IND_PE_WRK_ENG_EDU_TRN)) {
      fceEligibilityDB.setIndPeWrkEngEduTrn(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_PE_WRK_ENG_EDU_TRN));
    }
    if (map.containsKey(FceEligibilityDB.IND_PRS_MANAGING_CVS)) {
      fceEligibilityDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(FceEligibilityDB.IND_RECV_100_PCT_VA)) {
      fceEligibilityDB.setIndRecv100PctVa(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_RECV_100_PCT_VA));
    }
    if (map.containsKey(FceEligibilityDB.IND_RECV_RR_RSDI)) {
      fceEligibilityDB.setIndRecvRrRsdi(ContextHelper.getBooleanSafe(request,
                                                                         FceEligibilityDB.IND_RECV_RR_RSDI));
    }
    if (map.containsKey(FceEligibilityDB.IND_REMOVAL_CHILD_ORDERED)) {
      fceEligibilityDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                              FceEligibilityDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(FceEligibilityDB.IND_RSDI_VERIFICATION)) {
      fceEligibilityDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                           FceEligibilityDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(FceEligibilityDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      fceEligibilityDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                 FceEligibilityDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(FceEligibilityDB.IND_SSI_VERIFICATION)) {
      fceEligibilityDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                          FceEligibilityDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(FceEligibilityDB.NBR_CERTIFIED_GROUP)) {
      fceEligibilityDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request, FceEligibilityDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(FceEligibilityDB.NBR_PARENTS_HOME)) {
      fceEligibilityDB.setNbrParentsHome(ContextHelper.getLongSafe(request, FceEligibilityDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(FceEligibilityDB.NBR_STEPPARENT_CHILDREN)) {
      fceEligibilityDB.setNbrStepparentChildren(ContextHelper.getLongSafe(request,
                                                                          FceEligibilityDB.NBR_STEPPARENT_CHILDREN));
    }
    if (map.containsKey(FceEligibilityDB.TXT_DETERMINATION_COMMENTS)) {
      fceEligibilityDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                               FceEligibilityDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(FceEligibilityDB.TXT_MONTHS_DEP_UNEMP)) {
      fceEligibilityDB.setTxtMonthsDepUnemp(ContextHelper.getStringSafe(request,
                                                                        FceEligibilityDB.TXT_MONTHS_DEP_UNEMP));
    }
    if (map.containsKey(FceEligibilityDB.IND_ABSENT_TPR_VOL_RELINQ)) {
      fceEligibilityDB.setIndAbsentTprVolRelinq(ContextHelper.getBooleanSafe(request,
                                                                             FceEligibilityDB.IND_ABSENT_TPR_VOL_RELINQ));
    }
    if (map.containsKey(FceEligibilityDB.TXT_MONTHS_DEP_DISABLED)) {
      fceEligibilityDB.setTxtMonthsDepDisabled(ContextHelper.getStringSafe(request,
                                                                           FceEligibilityDB.TXT_MONTHS_DEP_DISABLED));
    }
    if (map.containsKey(FceEligibilityDB.TXT_MONTHS_DEP_UNDER_EMPL)) {
      fceEligibilityDB.setTxtMonthsDepUnderEmpl(ContextHelper.getStringSafe(request,
                                                                            FceEligibilityDB.TXT_MONTHS_DEP_UNDER_EMPL));
    }
    if (map.containsKey(FceEligibilityDB.TXT_MONTHS_LIVING_REL_CUST)) {
      fceEligibilityDB.setTxtMonthsLivingRelCust(ContextHelper.getStringSafe(request,
                                                                             FceEligibilityDB.TXT_MONTHS_LIVING_REL_CUST));
    }
  }

  public static DomicileDeprivationDB readFromRequest(HttpServletRequest request) {
    DomicileDeprivationDB domicileDeprivationDB = new DomicileDeprivationDB();
    populateWithRequest(domicileDeprivationDB, request);
    return domicileDeprivationDB;
  }

  public static void populateWithRequest(DomicileDeprivationDB domicileDeprivationDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(DomicileDeprivationDB.ADDR_HEALTH_ADDR_CITY)) {
      domicileDeprivationDB.setAddrHealthAddrCity(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.ADDR_HEALTH_ADDR_CITY));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_HEALTH_ADDR_ST_LN1)) {
      domicileDeprivationDB.setAddrHealthAddrStLn1(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.ADDR_HEALTH_ADDR_ST_LN1));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_HEALTH_ADDR_ST_LN2)) {
      domicileDeprivationDB.setAddrHealthAddrStLn2(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.ADDR_HEALTH_ADDR_ST_LN2));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_HEALTH_ADDR_ZIP)) {
      domicileDeprivationDB.setAddrHealthAddrZip(ContextHelper.getStringSafe(request,
                                                                             DomicileDeprivationDB.ADDR_HEALTH_ADDR_ZIP));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_REMOVAL_ADDR_ZIP)) {
      domicileDeprivationDB.setAddrRemovalAddrZip(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.ADDR_REMOVAL_ADDR_ZIP));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_REMOVAL_CITY)) {
      domicileDeprivationDB.setAddrRemovalCity(ContextHelper.getStringSafe(request,
                                                                           DomicileDeprivationDB.ADDR_REMOVAL_CITY));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_REMOVAL_ST_LN1)) {
      domicileDeprivationDB.setAddrRemovalStLn1(ContextHelper.getStringSafe(request,
                                                                            DomicileDeprivationDB.ADDR_REMOVAL_ST_LN1));
    }
    if (map.containsKey(DomicileDeprivationDB.ADDR_REMOVAL_ST_LN2)) {
      domicileDeprivationDB.setAddrRemovalStLn2(ContextHelper.getStringSafe(request,
                                                                            DomicileDeprivationDB.ADDR_REMOVAL_ST_LN2));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_APPLICATION)) {
      domicileDeprivationDB.setCdApplication(ContextHelper.getStringSafe(request,
                                                                         DomicileDeprivationDB.CD_APPLICATION));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_COUNTY_HOSPITAL)) {
      domicileDeprivationDB.setCdCountyHospital(ContextHelper.getStringSafe(request,
                                                                            DomicileDeprivationDB.CD_COUNTY_HOSPITAL));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_HEALTH_ADDR_STATE)) {
      domicileDeprivationDB.setCdHealthAddrState(ContextHelper.getStringSafe(request,
                                                                             DomicileDeprivationDB.CD_HEALTH_ADDR_STATE));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_LIVING_MONTH_REMOVAL)) {
      domicileDeprivationDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request,
                                                                                DomicileDeprivationDB.CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_NOTA_MOST_RECENT)) {
      domicileDeprivationDB.setCdNotaMostRecent(ContextHelper.getStringSafe(request,
                                                                            DomicileDeprivationDB.CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_REMOVAL_ADDR_COUNTY)) {
      domicileDeprivationDB.setCdRemovalAddrCounty(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.CD_REMOVAL_ADDR_COUNTY));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_REMOVAL_ADDR_STATE)) {
      domicileDeprivationDB.setCdRemovalAddrState(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.CD_REMOVAL_ADDR_STATE));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_STATE)) {
      domicileDeprivationDB.setCdState(ContextHelper.getStringSafe(request, DomicileDeprivationDB.CD_STATE));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_APPLICATION_COMPLETE_STRING)) {
      domicileDeprivationDB.setDtApplicationCompleteString(ContextHelper.getStringSafe(request,
                                                                                       DomicileDeprivationDB.DT_APPLICATION_COMPLETE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_APPLICATION_COMPLETE_TIME)) {
      domicileDeprivationDB.setDtApplicationCompleteTime(ContextHelper.getLongSafe(request,
                                                                                   DomicileDeprivationDB.DT_APPLICATION_COMPLETE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HEALTH_BEGIN_DATE_STRING)) {
      domicileDeprivationDB.setDtHealthBeginDateString(ContextHelper.getStringSafe(request,
                                                                                   DomicileDeprivationDB.DT_HEALTH_BEGIN_DATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HEALTH_BEGIN_DATE_TIME)) {
      domicileDeprivationDB.setDtHealthBeginDateTime(ContextHelper.getLongSafe(request,
                                                                               DomicileDeprivationDB.DT_HEALTH_BEGIN_DATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HEALTH_END_DATE_STRING)) {
      domicileDeprivationDB.setDtHealthEndDateString(ContextHelper.getStringSafe(request,
                                                                                 DomicileDeprivationDB.DT_HEALTH_END_DATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HEALTH_END_DATE_TIME)) {
      domicileDeprivationDB.setDtHealthEndDateTime(ContextHelper.getLongSafe(request,
                                                                             DomicileDeprivationDB.DT_HEALTH_END_DATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HOSPITAL_ADMISSION_STRING)) {
      domicileDeprivationDB.setDtHospitalAdmissionString(ContextHelper.getStringSafe(request,
                                                                                     DomicileDeprivationDB.DT_HOSPITAL_ADMISSION_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HOSPITAL_ADMISSION_TIME)) {
      domicileDeprivationDB.setDtHospitalAdmissionTime(ContextHelper.getLongSafe(request,
                                                                                 DomicileDeprivationDB.DT_HOSPITAL_ADMISSION_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HOSPITAL_DISCHARGE_STRING)) {
      domicileDeprivationDB.setDtHospitalDischargeString(ContextHelper.getStringSafe(request,
                                                                                     DomicileDeprivationDB.DT_HOSPITAL_DISCHARGE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_HOSPITAL_DISCHARGE_TIME)) {
      domicileDeprivationDB.setDtHospitalDischargeTime(ContextHelper.getLongSafe(request,
                                                                                 DomicileDeprivationDB.DT_HOSPITAL_DISCHARGE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING)) {
      domicileDeprivationDB.setFceApplicationDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                            DomicileDeprivationDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME)) {
      domicileDeprivationDB.setFceApplicationDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                        DomicileDeprivationDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_NOTIFIED_WORKER_STRING)) {
      domicileDeprivationDB.setDtNotifiedWorkerString(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.DT_NOTIFIED_WORKER_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_NOTIFIED_WORKER_TIME)) {
      domicileDeprivationDB.setDtNotifiedWorkerTime(ContextHelper.getLongSafe(request,
                                                                              DomicileDeprivationDB.DT_NOTIFIED_WORKER_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_PROOF_AGE_SENT_ES_STRING)) {
      domicileDeprivationDB.setDtProofAgeSentEsString(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.DT_PROOF_AGE_SENT_ES_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_PROOF_AGE_SENT_ES_TIME)) {
      domicileDeprivationDB.setDtProofAgeSentEsTime(ContextHelper.getLongSafe(request,
                                                                              DomicileDeprivationDB.DT_PROOF_AGE_SENT_ES_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING)) {
      domicileDeprivationDB.setDtProofCitizenshipSentEsString(ContextHelper.getStringSafe(request,
                                                                                          DomicileDeprivationDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME)) {
      domicileDeprivationDB.setDtProofCitizenshipSentEsTime(ContextHelper.getLongSafe(request,
                                                                                      DomicileDeprivationDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REMOVAL_DATE_STRING)) {
      domicileDeprivationDB.setDtRemovalDateString(ContextHelper.getStringSafe(request,
                                                                                      DomicileDeprivationDB.DT_REMOVAL_DATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REMOVAL_DATE_TIME)) {
      domicileDeprivationDB.setDtRemovalDateTime(ContextHelper.getLongSafe(request,
                                                                                      DomicileDeprivationDB.DT_REMOVAL_DATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_CASE)) {
      domicileDeprivationDB.setIdCase(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_CASE));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_EVENT)) {
      domicileDeprivationDB.setIdEvent(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_EVENT));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_FCE_APPLICATION)) {
      domicileDeprivationDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                          DomicileDeprivationDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_FCE_ELIGIBILITY)) {
      domicileDeprivationDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                          DomicileDeprivationDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_LAST_UPDATE_PERSON)) {
      domicileDeprivationDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                            DomicileDeprivationDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_MNGNG_CVS_PERSON)) {
      domicileDeprivationDB.setIdMngngCvsPerson(ContextHelper.getLongSafe(request,
                                                                          DomicileDeprivationDB.ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_OTHER_RELATIVE_PERSON)) {
      domicileDeprivationDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                               DomicileDeprivationDB.ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_PERSON)) {
      domicileDeprivationDB.setIdPerson(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_STAGE)) {
      domicileDeprivationDB.setIdStage(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_STAGE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_JUSTIFIED_EVAL)) {
      domicileDeprivationDB.setIndAgeJustifiedEval(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB.IND_AGE_JUSTIFIED_EVAL));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_BAPTISM_CERT)) {
      domicileDeprivationDB.setIndAgeVrfdBaptismCert(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_AGE_VRFD_BAPTISM_CERT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_FOREIGN_CERT)) {
      domicileDeprivationDB.setIndAgeVrfdForeignCert(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_AGE_VRFD_FOREIGN_CERT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_HOSPITAL_CERT)) {
      domicileDeprivationDB.setIndAgeVrfdHospitalCert(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_AGE_VRFD_HOSPITAL_CERT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_NTRLZTN_CERT)) {
      domicileDeprivationDB.setIndAgeVrfdNtrlztnCert(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_AGE_VRFD_NTRLZTN_CERT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_PASSPORT)) {
      domicileDeprivationDB.setIndAgeVrfdPassport(ContextHelper.getBooleanSafe(request,
                                                                               DomicileDeprivationDB.IND_AGE_VRFD_PASSPORT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_RESIDENT_CARD)) {
      domicileDeprivationDB.setIndAgeVrfdResidentCard(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_AGE_VRFD_RESIDENT_CARD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AGE_VRFD_US_BIRTH_CERT)) {
      domicileDeprivationDB.setIndAgeVrfdUsBirthCert(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_AGE_VRFD_US_BIRTH_CERT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_AMENDED_APP)) {
      domicileDeprivationDB.setIndAmendedApp(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_AMENDED_APP));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CHILD_SUPPORT_ORDER)) {
      domicileDeprivationDB.setIndChildSupportOrder(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_CHILD_SUPPORT_ORDER));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_EVALUATION_CONCLUSION)) {
      domicileDeprivationDB.setIndEvaluationConclusion(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB.IND_EVALUATION_CONCLUSION));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_HOSPITAL)) {
      domicileDeprivationDB.setIndHospital(ContextHelper.getBooleanSafe(request, DomicileDeprivationDB.IND_HOSPITAL));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_INCOME_ASSISTANCE)) {
      domicileDeprivationDB.setIndIncomeAssistance(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB.IND_INCOME_ASSISTANCE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_LEGAL_DOCS_SENT_ES)) {
      domicileDeprivationDB.setIndLegalDocsSentEs(ContextHelper.getBooleanSafe(request,
                                                                               DomicileDeprivationDB.IND_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_LIVING_RELATIVE_SIX_MONTH)) {
      domicileDeprivationDB.setIndLivingRelativeSixMonth(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB.IND_LIVING_RELATIVE_SIX_MONTH));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_MANAGING_CVS)) {
      domicileDeprivationDB.setIndManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                           DomicileDeprivationDB.IND_MANAGING_CVS));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_MINOR_PARENT)) {
      domicileDeprivationDB.setIndMinorParent(ContextHelper.getBooleanSafe(request,
                                                                           DomicileDeprivationDB.IND_MINOR_PARENT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_NOTIFIED_DHS_WORKER)) {
      domicileDeprivationDB.setIndNotifiedDhsWorker(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_NOTIFIED_DHS_WORKER));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_OTHER_HEALTH_INSURANCE)) {
      domicileDeprivationDB.setIndOtherHealthInsurance(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB.IND_OTHER_HEALTH_INSURANCE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PROOF_AGE_SENT_ES)) {
      domicileDeprivationDB.setIndProofAgeSentEs(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PROOF_CITIZENSHIP_SENT_ES)) {
      domicileDeprivationDB.setIndProofCitizenshipSentEs(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB.IND_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_SPECIFIED_RELATIVE)) {
      domicileDeprivationDB.setIndSpecifiedRelative(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB.IND_SPECIFIED_RELATIVE));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_COURT_MONTH)) {
      domicileDeprivationDB.setNbrCourtMonth(ContextHelper.getLongSafe(request, DomicileDeprivationDB.NBR_COURT_MONTH));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_COURT_YEAR)) {
      domicileDeprivationDB.setNbrCourtYear(ContextHelper.getLongSafe(request, DomicileDeprivationDB.NBR_COURT_YEAR));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_HEALTH_GROUP)) {
      domicileDeprivationDB.setNbrHealthGroup(ContextHelper.getStringSafe(request,
                                                                          DomicileDeprivationDB.NBR_HEALTH_GROUP));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_HEALTH_POLICY)) {
      domicileDeprivationDB.setNbrHealthPolicy(ContextHelper.getStringSafe(request,
                                                                           DomicileDeprivationDB.NBR_HEALTH_POLICY));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_LIVING_AT_HOME)) {
      domicileDeprivationDB.setNbrLivingAtHome(ContextHelper.getLongSafe(request,
                                                                         DomicileDeprivationDB.NBR_LIVING_AT_HOME));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_NOTIFIED_DHS_WRKR_PHN)) {
      domicileDeprivationDB.setNbrNotifiedDhsWrkrPhn(ContextHelper.getStringSafe(request,
                                                                                 DomicileDeprivationDB.NBR_NOTIFIED_DHS_WRKR_PHN));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HEALTH_COMPANY)) {
      domicileDeprivationDB.setNmHealthCompany(ContextHelper.getStringSafe(request,
                                                                           DomicileDeprivationDB.NM_HEALTH_COMPANY));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HEALTH_EMPLOYEE_NM)) {
      domicileDeprivationDB.setNmHealthEmployeeNm(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.NM_HEALTH_EMPLOYEE_NM));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HEALTH_EMPLOYER_NM)) {
      domicileDeprivationDB.setNmHealthEmployerNm(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.NM_HEALTH_EMPLOYER_NM));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HEALTH_POLICY_HLDR_NM)) {
      domicileDeprivationDB.setNmHealthPolicyHldrNm(ContextHelper.getStringSafe(request,
                                                                                DomicileDeprivationDB.NM_HEALTH_POLICY_HLDR_NM));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HOSPITAL)) {
      domicileDeprivationDB.setNmHospital(ContextHelper.getStringSafe(request, DomicileDeprivationDB.NM_HOSPITAL));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_HOSPITAL_CITY)) {
      domicileDeprivationDB.setNmHospitalCity(ContextHelper.getStringSafe(request,
                                                                          DomicileDeprivationDB.NM_HOSPITAL_CITY));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_MOTHER_MAIDEN)) {
      domicileDeprivationDB.setNmMotherMaiden(ContextHelper.getStringSafe(request,
                                                                          DomicileDeprivationDB.NM_MOTHER_MAIDEN));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_FIRST)) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrFirst(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_FIRST));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_LAST)) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrLast(ContextHelper.getStringSafe(request,
                                                                                 DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_LAST));
    }
    if (map.containsKey(DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_MIDDLE)) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrMiddle(ContextHelper.getStringSafe(request,
                                                                                   DomicileDeprivationDB.NM_NOTIFIED_DHS_WRKR_MIDDLE));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_INCOME_DTRMNTN_COMMENTS)) {
      domicileDeprivationDB.setTxtIncomeDtrmntnComments(ContextHelper.getStringSafe(request,
                                                                                    DomicileDeprivationDB.TXT_INCOME_DTRMNTN_COMMENTS));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_LEGAL_DOCS_SENT_ES)) {
      domicileDeprivationDB.setTxtLegalDocsSentEs(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.TXT_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_MEETS_DD_OR_NOT_COMMENTS)) {
      domicileDeprivationDB.setTxtMeetsDdOrNotComments(ContextHelper.getStringSafe(request,
                                                                                   DomicileDeprivationDB.TXT_MEETS_DD_OR_NOT_COMMENTS));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_NO_INCOME_EXPLANATION)) {
      domicileDeprivationDB.setTxtNoIncomeExplanation(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.TXT_NO_INCOME_EXPLANATION));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_PROOF_AGE_SENT_ES)) {
      domicileDeprivationDB.setTxtProofAgeSentEs(ContextHelper.getStringSafe(request,
                                                                             DomicileDeprivationDB.TXT_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_PROOF_CITIZENSHIP_SENT_ES)) {
      domicileDeprivationDB.setTxtProofCitizenshipSentEs(ContextHelper.getStringSafe(request,
                                                                                     DomicileDeprivationDB.TXT_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_COUNTABLE_INCOME)) {
      domicileDeprivationDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                              DomicileDeprivationDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_COUNTABLE_INCOME_MONEY)) {
      domicileDeprivationDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     DomicileDeprivationDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      domicileDeprivationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                  DomicileDeprivationDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      domicileDeprivationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         DomicileDeprivationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      domicileDeprivationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                    DomicileDeprivationDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      domicileDeprivationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                           DomicileDeprivationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_INCOME_LIMIT)) {
      domicileDeprivationDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request,
                                                                          DomicileDeprivationDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_INCOME_LIMIT_MONEY)) {
      domicileDeprivationDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                 DomicileDeprivationDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_PWE_INCOME)) {
      domicileDeprivationDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, DomicileDeprivationDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_PWE_INCOME_MONEY)) {
      domicileDeprivationDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               DomicileDeprivationDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_SSI)) {
      domicileDeprivationDB.setAmtSsi(ContextHelper.getDoubleSafe(request, DomicileDeprivationDB.AMT_SSI));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_SSI_MONEY)) {
      domicileDeprivationDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, DomicileDeprivationDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_ALIMONY)) {
      domicileDeprivationDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                                DomicileDeprivationDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      domicileDeprivationDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                       DomicileDeprivationDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_ALLOWANCE)) {
      domicileDeprivationDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                                  DomicileDeprivationDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      domicileDeprivationDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         DomicileDeprivationDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      domicileDeprivationDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                      DomicileDeprivationDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      domicileDeprivationDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                             DomicileDeprivationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      domicileDeprivationDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                      DomicileDeprivationDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      domicileDeprivationDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                             DomicileDeprivationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_GROSS_EARNED)) {
      domicileDeprivationDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                                    DomicileDeprivationDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      domicileDeprivationDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                           DomicileDeprivationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      domicileDeprivationDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                                    DomicileDeprivationDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      domicileDeprivationDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                           DomicileDeprivationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      domicileDeprivationDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                                   DomicileDeprivationDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      domicileDeprivationDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          DomicileDeprivationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      domicileDeprivationDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                                   DomicileDeprivationDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(DomicileDeprivationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      domicileDeprivationDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          DomicileDeprivationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_BLOC_CHILD)) {
      domicileDeprivationDB.setCdBlocChild(ContextHelper.getStringSafe(request, DomicileDeprivationDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_ELIGIBILITY_ACTUAL)) {
      domicileDeprivationDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_ELIGIBILITY_SELECTED)) {
      domicileDeprivationDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                                 DomicileDeprivationDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      domicileDeprivationDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                     DomicileDeprivationDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(DomicileDeprivationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      domicileDeprivationDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                             DomicileDeprivationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_PWE_IRREGULAR_UNDER100)) {
      domicileDeprivationDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_PWE_STEADY_UNDER100)) {
      domicileDeprivationDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_VERIF_METHOD)) {
      domicileDeprivationDB.setCdVerifMethod(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.CD_VERIF_METHOD));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_VERIF_DOC_TYPE)) {
      domicileDeprivationDB.setCdVerifDocType(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.CD_VERIF_DOC_TYPE));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_DEPRIVATION_CHANGED_STRING)) {
      domicileDeprivationDB.setDtDeprivationChangedString(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.DT_DEPRIVATION_CHANGED_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_DEPRIVATION_CHANGED_TIME)) {
      domicileDeprivationDB.setDtDeprivationChangedTime(ContextHelper.getLongSafe(request,
                                                                              DomicileDeprivationDB.DT_DEPRIVATION_CHANGED_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_ELIGIBILITY_END_STRING)) {
      domicileDeprivationDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                                  DomicileDeprivationDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_ELIGIBILITY_END_TIME)) {
      domicileDeprivationDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                              DomicileDeprivationDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_ELIG_DTRMNTN_START_STRING)) {
      domicileDeprivationDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                                    DomicileDeprivationDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_ELIG_DTRMNTN_START_TIME)) {
      domicileDeprivationDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                                DomicileDeprivationDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      domicileDeprivationDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                            DomicileDeprivationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      domicileDeprivationDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                        DomicileDeprivationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      domicileDeprivationDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                       DomicileDeprivationDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      domicileDeprivationDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                                   DomicileDeprivationDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REVIEW_DATE_STRING)) {
      domicileDeprivationDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                              DomicileDeprivationDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_REVIEW_DATE_TIME)) {
      domicileDeprivationDB.setDtReviewDateTime(ContextHelper.getLongSafe(request,
                                                                          DomicileDeprivationDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      domicileDeprivationDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                         DomicileDeprivationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(DomicileDeprivationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      domicileDeprivationDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                     DomicileDeprivationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_ELIGIBILITY_EVENT)) {
      domicileDeprivationDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                            DomicileDeprivationDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_FCE_PERSON)) {
      domicileDeprivationDB.setIdFcePerson(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_FCE_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_FCE_REVIEW)) {
      domicileDeprivationDB.setIdFceReview(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(DomicileDeprivationDB.ID_PRN_EARNER)) {
      domicileDeprivationDB.setIdPrnEarner(ContextHelper.getLongSafe(request, DomicileDeprivationDB.ID_PRN_EARNER));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      domicileDeprivationDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_DEPORTED)) {
      domicileDeprivationDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_DESERTED)) {
      domicileDeprivationDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_DIED)) {
      domicileDeprivationDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request,
                                                                          DomicileDeprivationDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_DIVORCED)) {
      domicileDeprivationDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_FATHER)) {
      domicileDeprivationDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                            DomicileDeprivationDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_HOSPITALIZED)) {
      domicileDeprivationDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_INCARCERATED)) {
      domicileDeprivationDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_MILITARY_WORK)) {
      domicileDeprivationDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_MOTHER)) {
      domicileDeprivationDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                            DomicileDeprivationDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_SEPARATED)) {
      domicileDeprivationDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                               DomicileDeprivationDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_WORK_RELATED)) {
      domicileDeprivationDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      domicileDeprivationDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      domicileDeprivationDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CHILD_SUPPORT_ORDERED)) {
      domicileDeprivationDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CHILD_UNDER18)) {
      domicileDeprivationDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request,
                                                                            DomicileDeprivationDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      domicileDeprivationDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      domicileDeprivationDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      domicileDeprivationDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      domicileDeprivationDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      domicileDeprivationDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND)) {
      domicileDeprivationDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      domicileDeprivationDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      domicileDeprivationDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      domicileDeprivationDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_EVALUATION)) {
      domicileDeprivationDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      domicileDeprivationDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      domicileDeprivationDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      domicileDeprivationDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      domicileDeprivationDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      domicileDeprivationDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      domicileDeprivationDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      domicileDeprivationDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_PASSPORT)) {
      domicileDeprivationDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_REFUGEE)) {
      domicileDeprivationDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RESIDENT_CARD)) {
      domicileDeprivationDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      domicileDeprivationDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      domicileDeprivationDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_US_ID_CARD)) {
      domicileDeprivationDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      domicileDeprivationDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      domicileDeprivationDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_STUDENT_VISA)) {
      domicileDeprivationDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      domicileDeprivationDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,DomicileDeprivationDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ELIGIBILITY_COURT_MONTH)) {
      domicileDeprivationDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ELIGIBLE)) {
      domicileDeprivationDB.setIndEligible(ContextHelper.getBooleanSafe(request, DomicileDeprivationDB.IND_ELIGIBLE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_EQUITY)) {
      domicileDeprivationDB.setIndEquity(ContextHelper.getBooleanSafe(request, DomicileDeprivationDB.IND_EQUITY));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_FATHER_PWE)) {
      domicileDeprivationDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request,
                                                                         DomicileDeprivationDB.IND_FATHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      domicileDeprivationDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_MEETS_DP_OR_NOT_ES)) {
      domicileDeprivationDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      domicileDeprivationDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_MOTHER_PWE)) {
      domicileDeprivationDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request,
                                                                         DomicileDeprivationDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_NARRATIVE_APPROVED)) {
      domicileDeprivationDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_OTHER_VERIFICATION)) {
      domicileDeprivationDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                                 DomicileDeprivationDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PARENTAL_DEPRIVATION)) {
      domicileDeprivationDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PARENT_DISABLED)) {
      domicileDeprivationDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PE_NOT_ACPT_EMP_TRN)) {
      domicileDeprivationDB.setIndPeNotAcptEmpTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PE_NOT_ACPT_EMP_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PE_RECV_UNEMP)) {
      domicileDeprivationDB.setIndPeRecvUnemp(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PE_RECV_UNEMP));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PE_WRK_ENG_EDU_TRN)) {
      domicileDeprivationDB.setIndPeWrkEngEduTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PE_WRK_ENG_EDU_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_PRS_MANAGING_CVS)) {
      domicileDeprivationDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_RECV_100_PCT_VA)) {
      domicileDeprivationDB.setIndRecv100PctVa(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_RECV_100_PCT_VA));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_RECV_RR_RSDI)) {
      domicileDeprivationDB.setIndRecvRrRsdi(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB.IND_RECV_RR_RSDI));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_REMOVAL_CHILD_ORDERED)) {
      domicileDeprivationDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_RSDI_VERIFICATION)) {
      domicileDeprivationDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      domicileDeprivationDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_SSI_VERIFICATION)) {
      domicileDeprivationDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                               DomicileDeprivationDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_CERTIFIED_GROUP)) {
      domicileDeprivationDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request,
                                                                           DomicileDeprivationDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_PARENTS_HOME)) {
      domicileDeprivationDB.setNbrParentsHome(ContextHelper.getLongSafe(request,
                                                                        DomicileDeprivationDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_DETERMINATION_COMMENTS)) {
      domicileDeprivationDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                                    DomicileDeprivationDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_AMT_PWE_INCOME)) {
      domicileDeprivationDB.setBoth6M_amtPweIncome(ContextHelper.getDoubleSafe(request,
                                                                               DomicileDeprivationDB._BOTH6_M_AMT_PWE_INCOME));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_AMT_PWE_INCOME_MONEY)) {
      domicileDeprivationDB.setBoth6M_amtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      DomicileDeprivationDB._BOTH6_M_AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_CD_PWE_IRREGULAR_UNDER100)) {
      domicileDeprivationDB.setBoth6M_cdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                         DomicileDeprivationDB._BOTH6_M_CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_CD_PWE_STEADY_UNDER100)) {
      domicileDeprivationDB.setBoth6M_cdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                                      DomicileDeprivationDB._BOTH6_M_CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_CD_VERIF_METHOD)) {
      domicileDeprivationDB.setBoth6M_cdVerifMethod(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB._BOTH6_M_CD_VERIF_METHOD));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_CD_VERIF_DOC_TYPE)) {
      domicileDeprivationDB.setBoth6M_cdVerifDocType(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB._BOTH6_M_CD_VERIF_DOC_TYPE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_ID_PRN_EARNER)) {
      domicileDeprivationDB.setBoth6M_idPrnEarner(ContextHelper.getLongSafe(request, DomicileDeprivationDB._BOTH6_M_ID_PRN_EARNER));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_FATHER_PWE)) {
      domicileDeprivationDB.setBoth6M_indFatherPwe(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB._BOTH6_M_IND_FATHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_MOTHER_PWE)) {
      domicileDeprivationDB.setBoth6M_indMotherPwe(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB._BOTH6_M_IND_MOTHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_OTHER_VERIFICATION)) {
      domicileDeprivationDB.setBoth6M_indOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                                        DomicileDeprivationDB._BOTH6_M_IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_PARENT_DISABLED)) {
      domicileDeprivationDB.setBoth6M_indParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB._BOTH6_M_IND_PARENT_DISABLED));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_PE_NOT_ACPT_EMP_TRN)) {
      domicileDeprivationDB.setBoth6M_indPeNotAcptEmpTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH6_M_IND_PE_NOT_ACPT_EMP_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_PE_RECV_UNEMP)) {
      domicileDeprivationDB.setBoth6M_indPeRecvUnemp(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH6_M_IND_PE_RECV_UNEMP));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_PE_WRK_ENG_EDU_TRN)) {
      domicileDeprivationDB.setBoth6M_indPeWrkEngEduTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH6_M_IND_PE_WRK_ENG_EDU_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_RSDI_VERIFICATION)) {
      domicileDeprivationDB.setBoth6M_indRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                                       DomicileDeprivationDB._BOTH6_M_IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_SSI_VERIFICATION)) {
      domicileDeprivationDB.setBoth6M_indSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._BOTH6_M_IND_SSI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_RECV_100_PCT_VA)) {
      domicileDeprivationDB.setBoth6M_indRecv100PctVa(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH6_M_IND_RECV_100_PCT_VA));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH6_M_IND_RECV_RR_RSDI)) {
      domicileDeprivationDB.setBoth6M_indRecvRrRsdi(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH6_M_IND_RECV_RR_RSDI));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_AMT_PWE_INCOME)) {
      domicileDeprivationDB.setBoth_amtPweIncome(ContextHelper.getDoubleSafe(request,
                                                                             DomicileDeprivationDB._BOTH_AMT_PWE_INCOME));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_AMT_PWE_INCOME_MONEY)) {
      domicileDeprivationDB.setBoth_amtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    DomicileDeprivationDB._BOTH_AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_CD_PWE_IRREGULAR_UNDER100)) {
      domicileDeprivationDB.setBoth_cdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                       DomicileDeprivationDB._BOTH_CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_CD_PWE_STEADY_UNDER100)) {
      domicileDeprivationDB.setBoth_cdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                                    DomicileDeprivationDB._BOTH_CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_CD_VERIF_METHOD)) {
      domicileDeprivationDB.setBoth_cdVerifMethod(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB._BOTH_CD_VERIF_METHOD));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_CD_VERIF_DOC_TYPE)) {
      domicileDeprivationDB.setBoth_cdVerifDocType(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB._BOTH_CD_VERIF_DOC_TYPE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_ID_PRN_EARNER)) {
      domicileDeprivationDB.setBoth_idPrnEarner(ContextHelper.getLongSafe(request, DomicileDeprivationDB._BOTH_ID_PRN_EARNER));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_FATHER_PWE)) {
      domicileDeprivationDB.setBoth_indFatherPwe(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_FATHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_MOTHER_PWE)) {
      domicileDeprivationDB.setBoth_indMotherPwe(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_MOTHER_PWE));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_OTHER_VERIFICATION)) {
      domicileDeprivationDB.setBoth_indOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._BOTH_IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_PARENT_DISABLED)) {
      domicileDeprivationDB.setBoth_indParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB._BOTH_IND_PARENT_DISABLED));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_PE_NOT_ACPT_EMP_TRN)) {
      domicileDeprivationDB.setBoth_indPeNotAcptEmpTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_PE_NOT_ACPT_EMP_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_PE_RECV_UNEMP)) {
      domicileDeprivationDB.setBoth_indPeRecvUnemp(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_PE_RECV_UNEMP));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_PE_WRK_ENG_EDU_TRN)) {
      domicileDeprivationDB.setBoth_indPeWrkEngEduTrn(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_PE_WRK_ENG_EDU_TRN));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_RSDI_VERIFICATION)) {
      domicileDeprivationDB.setBoth_indRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB._BOTH_IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_SSI_VERIFICATION)) {
      domicileDeprivationDB.setBoth_indSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB._BOTH_IND_SSI_VERIFICATION));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_RECV_100_PCT_VA)) {
      domicileDeprivationDB.setBoth_indRecv100PctVa(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_RECV_100_PCT_VA));
    }
    if (map.containsKey(DomicileDeprivationDB._BOTH_IND_RECV_RR_RSDI)) {
      domicileDeprivationDB.setBoth_indRecvRrRsdi(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._BOTH_IND_RECV_RR_RSDI));
    }
    if (map.containsKey(DomicileDeprivationDB._NOTA_CD_NOTA_MOST_RECENT)) {
      domicileDeprivationDB.setNota_cdNotaMostRecent(ContextHelper.getStringSafe(request,
                                                                                 DomicileDeprivationDB._NOTA_CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(DomicileDeprivationDB._NOTA_IND_CHILD_LIVING_PRNT6_MNTHS)) {
      domicileDeprivationDB.setNota_indChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                          DomicileDeprivationDB._NOTA_IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_ALTRNT_CUSTODY)) {
      domicileDeprivationDB.setOne6M_indAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                         DomicileDeprivationDB._ONE6_M_IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_DEPORTED)) {
      domicileDeprivationDB.setOne6M_indAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB._ONE6_M_IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_DESERTED)) {
      domicileDeprivationDB.setOne6M_indAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB._ONE6_M_IND_ABSENT_DESERTED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_DIED)) {
      domicileDeprivationDB.setOne6M_indAbsentDied(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB._ONE6_M_IND_ABSENT_DIED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_DIVORCED)) {
      domicileDeprivationDB.setOne6M_indAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                                    DomicileDeprivationDB._ONE6_M_IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_FATHER)) {
      domicileDeprivationDB.setOne6M_indAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB._ONE6_M_IND_ABSENT_FATHER));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_HOSPITALIZED)) {
      domicileDeprivationDB.setOne6M_indAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                        DomicileDeprivationDB._ONE6_M_IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_INCARCERATED)) {
      domicileDeprivationDB.setOne6M_indAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                        DomicileDeprivationDB._ONE6_M_IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_MILITARY_WORK)) {
      domicileDeprivationDB.setOne6M_indAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                        DomicileDeprivationDB._ONE6_M_IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_MOTHER)) {
      domicileDeprivationDB.setOne6M_indAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB._ONE6_M_IND_ABSENT_MOTHER));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_SEPARATED)) {
      domicileDeprivationDB.setOne6M_indAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB._ONE6_M_IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_WORK_RELATED)) {
      domicileDeprivationDB.setOne6M_indAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                                       DomicileDeprivationDB._ONE6_M_IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_ALTRNT_CUSTODY)) {
      domicileDeprivationDB.setOne_indAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                       DomicileDeprivationDB._ONE_IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_DEPORTED)) {
      domicileDeprivationDB.setOne_indAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB._ONE_IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_DESERTED)) {
      domicileDeprivationDB.setOne_indAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB._ONE_IND_ABSENT_DESERTED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_DIED)) {
      domicileDeprivationDB.setOne_indAbsentDied(ContextHelper.getBooleanSafe(request,
                                                                              DomicileDeprivationDB._ONE_IND_ABSENT_DIED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_DIVORCED)) {
      domicileDeprivationDB.setOne_indAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                                  DomicileDeprivationDB._ONE_IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_FATHER)) {
      domicileDeprivationDB.setOne_indAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB._ONE_IND_ABSENT_FATHER));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_HOSPITALIZED)) {
      domicileDeprivationDB.setOne_indAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._ONE_IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_INCARCERATED)) {
      domicileDeprivationDB.setOne_indAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._ONE_IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_MILITARY_WORK)) {
      domicileDeprivationDB.setOne_indAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._ONE_IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_MOTHER)) {
      domicileDeprivationDB.setOne_indAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                                DomicileDeprivationDB._ONE_IND_ABSENT_MOTHER));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_SEPARATED)) {
      domicileDeprivationDB.setOne_indAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                                   DomicileDeprivationDB._ONE_IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_WORK_RELATED)) {
      domicileDeprivationDB.setOne_indAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                                     DomicileDeprivationDB._ONE_IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(DomicileDeprivationDB._OTHER_ID_MNGNG_CVS_PERSON)) {
      domicileDeprivationDB.setOther_idMngngCvsPerson(ContextHelper.getLongSafe(request,
                                                                                DomicileDeprivationDB._OTHER_ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB._OTHER_ID_OTHER_RELATIVE_PERSON)) {
      domicileDeprivationDB.setOther_idOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                                     DomicileDeprivationDB._OTHER_ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(DomicileDeprivationDB._OTHER6_M_IND_SPECIFIED_RELATIVE)) {
      domicileDeprivationDB.setOther6M_indSpecifiedRelative(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._OTHER6_M_IND_SPECIFIED_RELATIVE));
    }
    if (map.containsKey(DomicileDeprivationDB._OTHER_IND_SPECIFIED_RELATIVE)) {
      domicileDeprivationDB.setOther_indSpecifiedRelative(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB._OTHER_IND_SPECIFIED_RELATIVE));
    }
    if (map.containsKey(DomicileDeprivationDB.CD_EVENT_STATUS)) {
      domicileDeprivationDB.setCdEventStatus(ContextHelper.getStringSafe(request,
                                                                         DomicileDeprivationDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_NEVER_COHABITATED)) {
      domicileDeprivationDB.setIndAbsentNeverCohabitated(ContextHelper.getBooleanSafe(request,
                                                                                      DomicileDeprivationDB.IND_ABSENT_NEVER_COHABITATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE_IND_ABSENT_NEVER_COHABITATED)) {
      domicileDeprivationDB.setOne_indAbsentNeverCohabitated(ContextHelper.getBooleanSafe(request,
                                                                                          DomicileDeprivationDB._ONE_IND_ABSENT_NEVER_COHABITATED));
    }
    if (map.containsKey(DomicileDeprivationDB._ONE6_M_IND_ABSENT_NEVER_COHABITATED)) {
      domicileDeprivationDB.setOne6M_indAbsentNeverCohabitated(ContextHelper.getBooleanSafe(request,
                                                                                            DomicileDeprivationDB._ONE6_M_IND_ABSENT_NEVER_COHABITATED));
    }
    if (map.containsKey(DomicileDeprivationDB.NBR_STEPPARENT_CHILDREN)) {
      domicileDeprivationDB.setNbrStepparentChildren(ContextHelper.getLongSafe(request,
                                                                               DomicileDeprivationDB.NBR_STEPPARENT_CHILDREN));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_MONTHS_DEP_UNEMP)) {
      domicileDeprivationDB.setTxtMonthsDepUnemp(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.TXT_MONTHS_DEP_UNEMP));
    }
    if (map.containsKey(DomicileDeprivationDB.IND_ABSENT_TPR_VOL_RELINQ)) {
      domicileDeprivationDB.setIndAbsentTprVolRelinq(ContextHelper.getBooleanSafe(request,
                                                                               DomicileDeprivationDB.IND_ABSENT_TPR_VOL_RELINQ));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_MONTHS_DEP_DISABLED)) {
      domicileDeprivationDB.setTxtMonthsDepDisabled(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.TXT_MONTHS_DEP_DISABLED));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_MONTHS_DEP_UNDER_EMPL)) {
      domicileDeprivationDB.setTxtMonthsDepUnderEmpl(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.TXT_MONTHS_DEP_UNDER_EMPL));
    }
    if (map.containsKey(DomicileDeprivationDB.TXT_MONTHS_LIVING_REL_CUST)) {
      domicileDeprivationDB.setTxtMonthsLivingRelCust(ContextHelper.getStringSafe(request,
                                                                               DomicileDeprivationDB.TXT_MONTHS_LIVING_REL_CUST));
    }
  }
}
