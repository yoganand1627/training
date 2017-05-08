package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthReportDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YrppLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
import gov.georgia.dhr.dfcs.sacwis.db.YouthReportDtl;
import gov.georgia.dhr.dfcs.sacwis.db.YrppLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveYouthReportDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailSaveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User          Description
 *   --------  --------      --------------------------------------------------
 *   06/17/09  wjcochran     Added code to save any incoming comments
 *   08/13/10  hnguyen       MR-067 Updated service to handle save for Portal survey
 *   09/02/10  hnguyen       MR-067 Updated saveOrUpdateYrppLink to check for existing
 *                           yrpplink by person
 *   09/09/10  hnguyen       MR-067 Updated yrpp_link save update logic
 *   09/10/10  hnguyen       SMS#70023 MR-067 Update isSurveyValid logic to remove current status condition
 *   09/11/10  hnguyen       SMS#66384 MR-067 Updated saveOrUpdateYrppLink to not populate yrpp_link baseline year
 *                           that is to be populated when NYTD portal user account is created
 *   09/13/10  hnguyen       SMS#70289 MR-067 Updated saveOrUpdateYrppLink to correct hibernate 
 *                           exception with yrpplink
 *   09/14/10  hnguyen       SMS#66384 MR-067 Moved survey status methods to NytdHelper and update saveOrUpdateYrppLink
 *                           to only update record not create 
 *   09/15/10  hjbaptiste    SMS#65420: MR-070: Changed nytdBaselineYear to reportingYear
 *   09/15/10  hnguyen       SMS#66384 MR-67 Update saveOrUpdateYrppLink to loop thru yrpp list
 *   09/27/10  hnguyen       SMS#73402 MR-67 Updated logic to fix issue with getting survey completion status
 *                           where sql query does not return correct result if used with hibernate query in same service.
 *                           Updated isResponseValid to exclude N/A as a valid response.
 *   09/28/10  hnguyen       SMS#73828 MR-67 Updated condition for person status when validating outcome FC status
 *                           Death and Runaway
 *   09/29/10  hnguyen       SMS#74128 MR-67 service to save youth si population type for portal update
 */
public class SaveYouthReportDetailImpl extends BaseServiceImpl implements SaveYouthReportDetail {

  private PlacementDAO placementDAO;

  private PortalUserDtlDAO portalUserDtlDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private YouthReportDtlDAO youthReportDtlDAO;

  private YrppLinkDAO yrppLinkDAO;

  private static final String YOUTH_REPORT_DETAIL = "YouthReportDetail";

  private static final String PORTAL_SURVEY_DETAIL = "PortalSurveyDetail";

  private static final String POPULATION_TYPE_BASELINE = "B";

  private static final String POPULATION_TYPE_FOLLOW_UP = "F";

  private static final String POPULATION_TYPE_SERVED = "S";

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPortalUserDtlDAO(PortalUserDtlDAO portalUserDtlDAO) {
    this.portalUserDtlDAO = portalUserDtlDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setYouthReportDtlDAO(YouthReportDtlDAO youthReportDtlDAO) {
    this.youthReportDtlDAO = youthReportDtlDAO;
  }

  public void setYrppLinkDAO(YrppLinkDAO yrppLinkDAO) {
    this.yrppLinkDAO = yrppLinkDAO;
  }

  public YouthReportDetailSaveSO saveYouthReportDetail(YouthReportDetailSaveSI si) {
    int idUser = si.getIdUser();
    int idPerson = si.getIdPerson();

    // this scenario occurs when coming from Portal
    if (idPerson < 1 && si.getIdYouthReportDtl() < 1) {
      // user id should always be set when coming from portal
      if (idUser > 0) {
        if (PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName())) {
          // retrieve SHINES person id associated with portal user
          PortalUserDtl portalUserDtl = portalUserDtlDAO.findPortalUserbyIdUser(idUser);

          if (portalUserDtl != null) {
            idPerson = portalUserDtl.getPerson().getIdPerson();
          } else {
            // this should never occur
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }
      } else {
        // this should never occur
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }
    }

    YouthReportDetailSaveSO so = new YouthReportDetailSaveSO();
    Person prsn = getPersistentObject(Person.class, idPerson);
    YouthReportDtl youthReportDtl = null;

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(si.getCReqFuncCd())) {
      // Update of existing YRD via Youth Report Detail page or Portal Survey Detail
      youthReportDtl = (YouthReportDtl) getPersistentObject(YouthReportDtl.class, si.getIdYouthReportDtl());

      if (youthReportDtl == null) {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      } else if (PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName())) {
        // Update from Portal
        youthReportDtl.setCdHighEdu(si.getCdHighEdu());
        youthReportDtl.setCdMarrAtBirth(si.getCdMarrAtBirth());
        youthReportDtl.setCdOthHlthInsTyp(si.getCdOthHlthInsTyp());
        youthReportDtl.setCdHlthInsMedical(si.getCdHlthInsMedical());
        youthReportDtl.setCdHlthInsMental(si.getCdHlthInsMental());
        youthReportDtl.setCdHlthInsPrescription(si.getCdHlthInsPrescription());
        youthReportDtl.setCdChildren(si.getCdChildren());
        youthReportDtl.setCdConnAdult(si.getCdConnAdult());
        youthReportDtl.setCdCurrAtdEnr(si.getCdCurrAtdEnr());
        youthReportDtl.setCdCurrFtEmp(si.getCdCurrFtEmp());
        youthReportDtl.setCdCurrPtEmp(si.getCdCurrPtEmp());
        youthReportDtl.setCdEducAid(si.getCdEducAid());
        youthReportDtl.setCdEmpSkills(si.getCdEmpSkills());
        youthReportDtl.setCdHomeless(si.getCdHomeless());
        youthReportDtl.setCdIncarceration(si.getCdIncarceration());
        youthReportDtl.setCdMedicaid(si.getCdMedicaid());
        youthReportDtl.setCdOthSupport(si.getCdOthSupport());
        youthReportDtl.setCdSocialSec(si.getCdSocialSec());
        youthReportDtl.setCdSubAbuseRef(si.getCdSubAbuseRef());

        youthReportDtl.setCdTanf(si.getCdTanf());
        youthReportDtl.setCdFoodStamps(si.getCdFoodStamps());
        youthReportDtl.setCdHousingAst(si.getCdHousingAst());

        youthReportDtl.setDtOutcomeDate(new Date());
        youthReportDtl.setCdPopulationType(si.getCdPopulationType());
        youthReportDtl.setIndFcStatus(si.getIndFcStatOutcome());

        youthReportDtl.setIndEnteredByYth(si.getIndEnteredByYth());
        youthReportDtl.setNmEnteredBy(prsn.getNmPersonFull());

        // if at least one survey question is answered with non-declined response
        // then survey is valid and youth had participated
        if (isSurveyValid(youthReportDtl)) {
          youthReportDtl.setCdOutcomeRptStat(CodesTables.COUTSTAT_YP);
        } else {
          youthReportDtl.setCdOutcomeRptStat(CodesTables.COUTSTAT_YD);
        }

        youthReportDtlDAO.saveYouthReportDtl(youthReportDtl);

        // return status of survey
        boolean isSurveyComp = isSurveyCompleted(youthReportDtl);
        so.setIndSurveyCompleted(isSurveyComp);

        // save status to YRPP_LINK table, to be used by batch alerts process
        saveOrUpdateYrppLink(youthReportDtl.getPerson().getIdPerson(), youthReportDtl.getDtRptPeriodEnd(),
                             isSurveyComp);

        return so;
      }

    } else {
      // New report creation from Youth Report Detail or Portal Survey Detail
      // -- create new object for insertion
      youthReportDtl = new YouthReportDtl();
      youthReportDtl.setIdYouthReportDtl(0);
      youthReportDtl.setPerson(prsn);
      youthReportDtl.setDtRptPeriodEnd(si.getDtRptPeriodEnd());
    }

    // The following logic applies to UPDATE from YRD page
    // and ADD from YRD or Portal Survey

    // -- set all columns except ID_PERSON, DT_RPT_PERIOD_END, and IND_FOLLOW_UP
    youthReportDtl.setCdAgeClass(si.getCdAgeClass());
    youthReportDtl.setCdSex(si.getCdSex());

    // -- set race indicators
    youthReportDtl.setIndRaceAa(si.getIndRaceAmerIndian());
    youthReportDtl.setIndRaceAn(si.getIndRaceAsian());
    youthReportDtl.setIndRaceBk(si.getIndRaceBlack());
    youthReportDtl.setIndRaceHp(si.getIndRacePacIslander());
    youthReportDtl.setIndRaceUd(si.getIndRaceUnknown());
    youthReportDtl.setIndRaceWt(si.getIndRaceWhite());
    youthReportDtl.setIndRaceDeclined(si.getIndRaceDeclined());

    youthReportDtl.setCdEthinicity(si.getCdEthinicity());
    youthReportDtl.setCdLastGradeComp(si.getCdLastGradeComp());
    youthReportDtl.setIndAdjDelinquent(si.getIndAdjDelinquent());
    youthReportDtl.setIndSpcEduStat(si.getIndSpcEduStat());
    youthReportDtl.setIndTribalMbr(si.getIndTribalMbr());
    youthReportDtl.setIndFcStatusServices(si.getIndFcStatSvcs());
    youthReportDtl.setIndIlNeedsAsm(si.getIndIlNeedsAsm());

    youthReportDtl.setCdPopulationType(si.getCdPopulationType());
    youthReportDtl.setIndFollowUp(si.getIndFollowUp());

    Date dob = si.getDtDob();
    if (!DateHelper.isNull(dob)) {
      youthReportDtl.setDtDob(dob);
    }

    // Do not save outcome section from YRD if population type changed to other than baseline or followup
    // otherwise it will erase previously entered responses if user made a change by accident
    // Only save the survey part if it is created and completed by CM or YDP Coordinator on behalf of child
    // OR survey was created or last updated by youth via Portal.
    if ((YOUTH_REPORT_DETAIL.equals(si.getSzScreenName()) 
                    && !ServiceConstants.FND_YES.equals(youthReportDtl.getIndEnteredByYth())
                    && (POPULATION_TYPE_BASELINE.equals(si.getCdPopulationType())
                                    || POPULATION_TYPE_FOLLOW_UP.equals(si.getCdPopulationType())))
        || PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName())) {

      // check to see if a runaway placement exists
      List<String> fostCarePlcmtTypes = new ArrayList<String>();
      fostCarePlcmtTypes.add(CodesTables.CPLMNTYP_RNA);

      Placement placement = placementDAO.findActivePlacementByIdPersonByDateByPlcmntTypes(idPerson, new Date(),
                                                                                          fostCarePlcmtTypes);

      List<String> prsnRoles = new ArrayList<String>();
      prsnRoles.add(CodesTables.CROLES_PC);

      List<String> cdStages = new ArrayList<String>();
      cdStages.add(CodesTables.CSTAGES_SUB);
      cdStages.add(CodesTables.CSTAGES_ADO);

      long numSPL = stagePersonLinkDAO.countOpenStagesByIdPersonAndPersRolesAndCdStages(idPerson, prsnRoles, cdStages);
      
      if (numSPL > 0) {
        if (CodesTables.COUTSTAT_DE.equals(si.getCdOutcomeRptStat()) && DateHelper.isNull(prsn.getDtPersonDeath())) {
          // if foster care status outcome is Death and no date of death recorded
          throw new ServiceException(Messages.MSG_CMN_YDP_DEATH);
        } else if (POPULATION_TYPE_BASELINE.equals(si.getCdPopulationType()) && CodesTables.COUTSTAT_RM.equals(si.getCdOutcomeRptStat()) && placement == null ) {
          // if foster care status outcome is Runaway and no active Runaway placement exists for baseline youth
          throw new ServiceException(Messages.MSG_CMN_YDP_RUNAWAY);
        }
      }

      youthReportDtl.setDtOutcomeDate(si.getDtOutcomeDate());
      youthReportDtl.setCdOutcomeRptStat(si.getCdOutcomeRptStat());
      youthReportDtl.setIndFcStatus(si.getIndFcStatOutcome());

      youthReportDtl.setCdHighEdu(si.getCdHighEdu());
      youthReportDtl.setCdMarrAtBirth(si.getCdMarrAtBirth());
      youthReportDtl.setCdOthHlthInsTyp(si.getCdOthHlthInsTyp());
      youthReportDtl.setCdHlthInsMedical(si.getCdHlthInsMedical());
      youthReportDtl.setCdHlthInsMental(si.getCdHlthInsMental());
      youthReportDtl.setCdHlthInsPrescription(si.getCdHlthInsPrescription());
      youthReportDtl.setCdTanf(si.getCdTanf());
      youthReportDtl.setCdFoodStamps(si.getCdFoodStamps());
      youthReportDtl.setCdHousingAst(si.getCdHousingAst());
      youthReportDtl.setCdChildren(si.getCdChildren());
      youthReportDtl.setCdConnAdult(si.getCdConnAdult());
      youthReportDtl.setCdCurrAtdEnr(si.getCdCurrAtdEnr());
      youthReportDtl.setCdCurrFtEmp(si.getCdCurrFtEmp());
      youthReportDtl.setCdCurrPtEmp(si.getCdCurrPtEmp());
      youthReportDtl.setCdEducAid(si.getCdEducAid());
      youthReportDtl.setCdEmpSkills(si.getCdEmpSkills());
      youthReportDtl.setCdHomeless(si.getCdHomeless());
      youthReportDtl.setCdIncarceration(si.getCdIncarceration());
      youthReportDtl.setCdMedicaid(si.getCdMedicaid());
      youthReportDtl.setCdOthSupport(si.getCdOthSupport());
      youthReportDtl.setCdSocialSec(si.getCdSocialSec());
      youthReportDtl.setCdSubAbuseRef(si.getCdSubAbuseRef());

      // Set who last updated the survey
      if (PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName()) && ServiceConstants.FND_YES.equals(si.getIndEnteredByYth())) {
        youthReportDtl.setIndEnteredByYth(ServiceConstants.FND_YES);
        youthReportDtl.setNmEnteredBy(prsn.getNmPersonFull());
      } else {
        youthReportDtl.setIndEnteredByYth(ServiceConstants.FND_NO);

        // if added by CM or ILC only populate creator on initial survey save
        if(ServiceConstants.REQ_FUNC_CD_ADD.equals(si.getCReqFuncCd()) ){
          youthReportDtl.setNmEnteredBy(si.getNmEnteredByName());
        }
      }
    }else{
      // Reset the outcome stat and date if population changed to other then baseline or followup
      // these should be null since YRD outcome section does not display
      youthReportDtl.setCdOutcomeRptStat(si.getCdOutcomeRptStat());
      youthReportDtl.setDtOutcomeDate(si.getDtOutcomeDate());
    }

    // On initial save, these indicators are to be defaulted to 'N' by calling conversation
    youthReportDtl.setIndAcadSupport(si.getIndAcadSupport());
    youthReportDtl.setIndBdgtFinMgt(si.getIndBdgtFinMgt());
    youthReportDtl.setIndCareerPrep(si.getIndCareerPrep());
    youthReportDtl.setIndEduFinance(si.getIndEduFinance());
    youthReportDtl.setIndEmpProgVoc(si.getIndEmpProgVoc());
    youthReportDtl.setIndFamMarrEdu(si.getIndFamMarrEdu());
    youthReportDtl.setIndHealthEdu(si.getIndHealthEdu());
    youthReportDtl.setIndHousingEdu(si.getIndHousingEdu());
    youthReportDtl.setIndMentoring(si.getIndMentoring());
    youthReportDtl.setIndOthFinance(si.getIndOthFinance());
    youthReportDtl.setIndPsEduSupport(si.getIndPsEduSupport());
    youthReportDtl.setIndRoomBrdFin(si.getIndRoomBrdFin());
    youthReportDtl.setIndSuperIl(si.getIndSuperIl());

    // save comments
    youthReportDtl.setTxtAcadSupport(si.getTxtAcadSupport());
    youthReportDtl.setTxtBdgtFinMgt(si.getTxtBdgtFinMgt());
    youthReportDtl.setTxtCareerPrep(si.getTxtCareerPrep());
    youthReportDtl.setTxtEduFinance(si.getTxtEduFinance());
    youthReportDtl.setTxtEmpProgVoc(si.getTxtEmpProgVoc());
    youthReportDtl.setTxtFamMarrEdu(si.getTxtFamMarrEdu());
    youthReportDtl.setTxtHealthEdu(si.getTxtHealthEdu());
    youthReportDtl.setTxtHousingEdu(si.getTxtHousingEdu());
    youthReportDtl.setTxtMentoring(si.getTxtMentoring());
    youthReportDtl.setTxtOthFinance(si.getTxtOthFinance());
    youthReportDtl.setTxtPsEduSupport(si.getTxtPsEduSupport());
    youthReportDtl.setTxtRmBrdFin(si.getTxtRmBrdFin());
    youthReportDtl.setTxtSuperIl(si.getTxtSuperIl());
    
    youthReportDtlDAO.saveYouthReportDtl(youthReportDtl);

    // check if survey was completed
    boolean isSurveyComp = isSurveyCompleted(youthReportDtl);

    // save or update yrpp_link only for baseline and followup population
    if (POPULATION_TYPE_BASELINE.equals(youthReportDtl.getCdPopulationType())
        || POPULATION_TYPE_FOLLOW_UP.equals(youthReportDtl.getCdPopulationType())) {
      // save status of survey to YRPP_LINK, to be used by batch alert process
      saveOrUpdateYrppLink(youthReportDtl.getPerson().getIdPerson(), youthReportDtl.getDtRptPeriodEnd(), isSurveyComp);
    }

    // return status of survey
    so.setIndSurveyCompleted(isSurveyComp);

    return so;
  }

  /*
   * Saves survey status to yrpp_link table for batch alerts
   */
  private void saveOrUpdateYrppLink(int idPerson, Date dtRptPeriodEnd, boolean isSurveyCompleted) {
    // Making sure youth report saved, this should return the previously saved YRD
    YouthReportDtl youthReportDtl = youthReportDtlDAO.findYouthReportDtl(idPerson, dtRptPeriodEnd);

    if (youthReportDtl != null) {
      // get year
      int year = DateHelper.getYear(youthReportDtl.getDtRptPeriodEnd());

      YrppLink yrppLink = yrppLinkDAO.findYrppLinkByIdYouthReportDtl(youthReportDtl.getIdYouthReportDtl());

      // if yrppLink does not exist based on ID_YRD, it's a manual created record by script
      if (yrppLink == null) {
        // search by ID_PERSON
        List<YrppLink> yrppList = yrppLinkDAO.findYrppLinkByIdPerson(idPerson);

        java.util.Iterator<YrppLink> iter = yrppList.iterator();

        while (iter.hasNext()) {
          // yrpplink exists based on id_person and no id_yrd,
          // yrppLink year should be populated with the correct reporting year
          yrppLink = iter.next();
          if( yrppLink.getReportingYear() == year ){
            break;
          }else{
            yrppLink = null;
          }
        }
      }

      // Only update yrppLink record, never create.  
      // Record should only be created on portal user account creation
      if( yrppLink != null ){
        if (yrppLink.getYouthReportDtl() == null) {
          yrppLink.setDtSurveyStart(new Date());
          yrppLink.setYouthReportDtl(youthReportDtl);
        }

        // set survey is completed when responses are provided for all questions
        if (isSurveyCompleted) {
          yrppLink.setIndNytdSurveyComplete(ServiceConstants.FND_YES);
        } else {
          yrppLink.setIndNytdSurveyComplete(ServiceConstants.FND_NO);
        }
  
        yrppLinkDAO.saveYrppLink(yrppLink);
      } // else do nothing since no record exist
    }
  }

  // Determines if survey has at least one valid response, meaning one answer provided that is not a Declined response.
  private boolean isSurveyValid(YouthReportDtl yrd) {
    boolean isValid = false;

    if (isResponseValid(yrd.getCdCurrFtEmp()) || isResponseValid(yrd.getCdCurrPtEmp())
        || isResponseValid(yrd.getCdConnAdult()) || isResponseValid(yrd.getCdCurrAtdEnr())
        || isResponseValid(yrd.getCdEducAid()) || isResponseValid(yrd.getCdEmpSkills())
        || isResponseValid(yrd.getCdHighEdu()) || isResponseValid(yrd.getCdHomeless())
        || isResponseValid(yrd.getCdIncarceration()) || isResponseValid(yrd.getCdMedicaid())
        || isResponseValid(yrd.getCdOthSupport()) || isResponseValid(yrd.getCdSocialSec())
        || isResponseValid(yrd.getCdSubAbuseRef()) || isResponseValid(yrd.getCdChildren())
        || isResponseValid(yrd.getCdMarrAtBirth()) || isResponseValid(yrd.getCdOthHlthInsTyp())
        || isResponseValid(yrd.getCdHlthInsMedical()) || isResponseValid(yrd.getCdHlthInsMental())
        || isResponseValid(yrd.getCdHlthInsPrescription())) {
      // at least one baseline question was answered
      isValid = true;
    }

    // if population is follow-up
    // check follow-up not in care questions
    if (POPULATION_TYPE_FOLLOW_UP.equals(yrd.getCdPopulationType())
        && ArchitectureConstants.N.equals(StringHelper.getNonNullString(yrd.getIndFcStatus()))) {
      if (isResponseValid(yrd.getCdHousingAst()) 
                      || isResponseValid(yrd.getCdFoodStamps())
                      || isResponseValid(yrd.getCdTanf())) {
        // at least one follow up not in care was answered
        isValid = true;
      }
    }
    return isValid;
  }

  // Determines if response is valid, meaning an answer was provided and is not a Declined or N/A response
  private boolean isResponseValid(String resp) {
    if (StringHelper.isNotEmptyOrNull(resp) 
                    && !CodesTables.CINVACAN_D.equals(resp) 
                    && !CodesTables.CINVACAN_A.equals(resp)
                    && !CodesTables.CHIGHEDU_DC.equals(resp)) {
      return true;
    }

    return false;
  }
  
  // Determines if survey is completed
  private boolean isSurveyCompleted(YouthReportDtl yrd) {
    boolean isComp = true;

    // Not complete if one of the conditions are true
    // 1) No reporting status or outcome date
    // 2) Youth Participated and at least one applicable question unanswered (implicitly declined a question)
    // 3) Youth Declined (declined by Youth by not answering any questions via Portal)
    if ((StringHelper.isEmptyOrNull(yrd.getCdOutcomeRptStat())
                        || yrd.getDtOutcomeDate() == null)
        || ((CodesTables.COUTSTAT_YP.equals(yrd.getCdOutcomeRptStat())
                        || (CodesTables.COUTSTAT_YD.equals(yrd.getCdOutcomeRptStat())
                                        && ArchitectureConstants.Y.equals(yrd.getIndEnteredByYth())))
                        && (StringHelper.isEmptyOrNull(yrd.getCdCurrFtEmp())
                                        || StringHelper.isEmptyOrNull(yrd.getCdCurrPtEmp())
                                        || StringHelper.isEmptyOrNull(yrd.getCdConnAdult())
                                        || StringHelper.isEmptyOrNull(yrd.getCdCurrAtdEnr())
                                        || StringHelper.isEmptyOrNull(yrd.getCdEducAid())
                                        || StringHelper.isEmptyOrNull(yrd.getCdEmpSkills())
                                        || StringHelper.isEmptyOrNull(yrd.getCdHighEdu())
                                        || StringHelper.isEmptyOrNull(yrd.getCdHomeless())
                                        || StringHelper.isEmptyOrNull(yrd.getCdIncarceration())
                                        || StringHelper.isEmptyOrNull(yrd.getCdMedicaid())
                                        || StringHelper.isEmptyOrNull(yrd.getCdOthSupport())
                                        || StringHelper.isEmptyOrNull(yrd.getCdSocialSec())
                                        || StringHelper.isEmptyOrNull(yrd.getCdSubAbuseRef())
                                        || StringHelper.isEmptyOrNull(yrd.getCdChildren())
                                        || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(yrd.getCdChildren())) 
                                                        && (StringHelper.isEmptyOrNull(yrd.getCdMarrAtBirth())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdMarrAtBirth())))
                                        || StringHelper.isEmptyOrNull(yrd.getCdOthHlthInsTyp())
                                        || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(yrd.getCdOthHlthInsTyp())) 
                                                        && (StringHelper.isEmptyOrNull(yrd.getCdHlthInsMedical())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdHlthInsMedical())))
                                        || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(yrd.getCdOthHlthInsTyp())) 
                                                        && ArchitectureConstants.Y.equals(StringHelper.getNonNullString(yrd.getCdHlthInsMedical())) 
                                                        && (StringHelper.isEmptyOrNull(yrd.getCdHlthInsMental())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdHlthInsMental())
                                                                        || StringHelper.isEmptyOrNull(yrd.getCdHlthInsPrescription())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdHlthInsPrescription())))
                                        // check follow-up not in care questions, if applicable
                                        || ((POPULATION_TYPE_FOLLOW_UP.equals(yrd.getCdPopulationType())
                                                        && ArchitectureConstants.N.equals(StringHelper.getNonNullString(yrd.getIndFcStatus())))
                                                        // at least one of the follow not in care question is empty or null, therefore not complete
                                                        && (StringHelper.isEmptyOrNull(yrd.getCdTanf()) 
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdTanf())
                                                                        || StringHelper.isEmptyOrNull(yrd.getCdFoodStamps())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdFoodStamps())
                                                                        || StringHelper.isEmptyOrNull(yrd.getCdHousingAst())
                                                                        || CodesTables.CINVACAN_A.equals(yrd.getCdHousingAst())))))) {
      isComp = false;
    }
    
    return isComp;
  }
}
