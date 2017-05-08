package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthReportDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;
import gov.georgia.dhr.dfcs.sacwis.db.YouthReportDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveYouthReportDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   06/17/09  wjcochran Added new code to retrieve method: get comments from
 *                       the report object and save them to the outgoing object
 *   08/22/10  hnguyen   Updated service to handle retrieval for Portal survey
 *   09/10/10  hnguyen   MR-067 Added more placement types that qualifies for baseline population
 *                       and populates foster care status outcome based on placement(s) active during survey
 *                       period not reporting period. Foster care status services based on placement(s)
 *                       active in reporting period.
 *   09/14/10  hnguyen   MR-067 Removed logic for fields that was to pre-populate survey and moved
 *                       survey status method to NytdHelper
 *   09/15/10  hnguyen   SMS#70350 MR-67 Added logic to retrieve tribal member
 *                       based on Yes or No from person detail otherwise set as empty string
 *                       SMS#66384 MR-67 Added logic on retrieve of saved or new data to include
 *                       outcome foster care status and population type and retrieve person active status
 *                       based on stage person link query
 *   09/20/10  hnguyen   SMS#70317, 70321 Updated logic to retrieve last grade completed and special ed received by yth
 *   09/22/10  hnguyen   SMS#66384 MR-067 Updated service to retrieve and create YRD via Portal for correct 
 *                       baseline/followup period if youth is still in the survey period but reporting 
 *                       period has already ended.
 *   09/23/10  hnguyen   SMS#72519 Removed pre-population of survey questions when not applicable
 *                       SMS#73860 Updated person status to be based on youth related in any open stages
 *                       SMS#73863 Added condition to not retrieve/display CM/ILC created survey responses on Portal
 *                       Survey.
 *   12/19/10  schoi     SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included                    
 *                       
 * 
 */
public class RetrieveYouthReportDetailImpl extends BaseServiceImpl implements RetrieveYouthReportDetail {

  private EducationalHistoryDAO educationalHistoryDAO;

  private LegalActionOutcomeDAO legalActionOutcomeDAO;

  private PersonEthnicityDAO personEthnicityDAO;
  
  private StagePersonLinkDAO stagePersonLinkDAO;

  private TribalDAO tribalDAO;

  private YouthReportDtlDAO youthReportDtlDAO;

  private PlacementDAO placementDAO;

  private PortalUserDtlDAO portalUserDtlDAO;
  
  private static final String POPULATION_TYPE_SERVED = "S";

  private static final String POPULATION_TYPE_BASELINE = "B";

  private static final String POPULATION_TYPE_FOLLOW_UP = "F";

  private static final String YOUTH_REPORT_DETAIL = "YouthReportDetail";

  private static final String PORTAL_SURVEY_DETAIL = "PortalSurveyDetail";

  // SMS #81140: MR-074
  // Group Home (CPLMNTYP_GRH condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
  // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
  // However, it is no harm to keep Group Home in the code below because it will not break the logic.
  // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.  
  private static final List<String> fostCarePlcmtTypes = new ArrayList<String>(){
    {
      add(CodesTables.CPLMNTYP_RFH);
      add(CodesTables.CPLMNTYP_DFH);
      add(CodesTables.CPLMNTYP_CFH);
      add(CodesTables.CPLMNTYP_IFH);
      add(CodesTables.CPLMNTYP_ADH);
      add(CodesTables.CPLMNTYP_CCI);
      add(CodesTables.CPLMNTYP_EMS);
      add(CodesTables.CPLMNTYP_GRH);
      add(CodesTables.CPLMNTYP_HOS);
      add(CodesTables.CPLMNTYP_NRP);
      add(CodesTables.CPLMNTYP_OTA);
      add(CodesTables.CPLMNTYP_OTP);
      add(CodesTables.CPLMNTYP_OTR);
      add(CodesTables.CPLMNTYP_REP);
      add(CodesTables.CPLMNTYP_REU);
      add(CodesTables.CPLMNTYP_RNA);
      add(CodesTables.CPLMNTYP_SFH);
    }
  };

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTribalDAO(TribalDAO tribalDAO) {
    this.tribalDAO = tribalDAO;
  }

  public void setYouthReportDtlDAO(YouthReportDtlDAO youthReportDtlDAO) {
    this.youthReportDtlDAO = youthReportDtlDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPortalUserDtlDAO(PortalUserDtlDAO portalUserDtlDAO) {
    this.portalUserDtlDAO = portalUserDtlDAO;
  }

  public YouthReportDetailRetrieveSO retrieveYouthReportDetail(YouthReportDetailRetrieveSI si) {
    YouthReportDetailRetrieveSO so = new YouthReportDetailRetrieveSO();
    YouthReportDetailRetrieveSOPerson soPerson = new YouthReportDetailRetrieveSOPerson();
    YouthReportDetailRetrieveSOReport soReport = new YouthReportDetailRetrieveSOReport();
    YouthReportDtl report = new YouthReportDtl();

    // -- if id is given, retrieve report data
    int idYouthReportDtl = si.getIdYouthReportDtl();
    int idUser = si.getIdUser();
    int idPerson = si.getIdPerson();
    Date dtRptPeriodEnd = si.getDtRptPeriodEnd();
    
    if (idYouthReportDtl > 0) {
      report = (YouthReportDtl) getPersistentObject(YouthReportDtl.class, idYouthReportDtl);
      
      if (report == null) {
        // -- should never happen
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      
    } else{
      if( PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName()) && idUser > 0){
        PortalUserDtl portalUserDtl =  portalUserDtlDAO.findPortalUserbyIdUser(idUser);
        // retrieve id person from portal user detail, if one exists
        if( portalUserDtl != null ){
          idPerson = portalUserDtl.getPerson().getIdPerson();
          
          // check to see if first login and user click on Survey tab before completing
          // profile...throw error and redirect back to user profile page
          PortalUser pUser = portalUserDtl.getPortalUser();
          if(StringHelper.isEmptyOrNull(pUser.getCdQuestion1())
                          && StringHelper.isEmptyOrNull(pUser.getCdQuestion2())
                          && StringHelper.isEmptyOrNull(pUser.getCdQuestion3())){
            throw new ServiceException( Messages.MSG_PORTAL_USER_TMP_PASSWORD_RESET );
          }
        }
      }

      if( idPerson > 0 ){
        if (DateHelper.isNull(dtRptPeriodEnd)) {
          // set it based on current date
          dtRptPeriodEnd = NytdHelper.getDtRptPeriodEnd();
        }
        
        Person p = getPersistentObject( Person.class, idPerson );
        // current period does not have a survey period, but we calculated that we are in a survey period
        // therefore previous period MAY be the reporting period for youth's baseline or followup
        if( NytdHelper.getDtSurveyPeriodEndForRptPeriod(p.getDtPersonBirth(), dtRptPeriodEnd) == null
                        && NytdHelper.isDuringSurveyPeriod(p.getDtPersonBirth())
                        && PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName())){
          Calendar calCurrPeriodBegin = Calendar.getInstance();
          calCurrPeriodBegin.setTime(NytdHelper.getDtRptPeriodBegin(dtRptPeriodEnd));
          calCurrPeriodBegin.add(Calendar.DAY_OF_MONTH, -1);
          
          Date prevPeriodEnd = calCurrPeriodBegin.getTime();
          
          // double check that survey period calculated is for previous period
          if(NytdHelper.getDtSurveyPeriodEndForRptPeriod(p.getDtPersonBirth(), prevPeriodEnd) != null){
            String populationType = NytdHelper.getPopulationType(idPerson, p.getDtPersonBirth(), prevPeriodEnd);
            
            // set actual reporting period end for survey only if previous period 
            // was baseline or followup reporting period for youth
            // otherwise reporting period end stays as current date reporting period end
            if( POPULATION_TYPE_BASELINE.equals(populationType)
                            || POPULATION_TYPE_FOLLOW_UP.equals(populationType)){
              dtRptPeriodEnd = prevPeriodEnd;
            }
          }
        }

        report = youthReportDtlDAO.findYouthReportDtl(idPerson, dtRptPeriodEnd);
      }else{
        // -- should never happen
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // this branch is for Youth Report Detail retrieve
    if (report != null) {
      soReport.setIdYouthReportDetail(report.getIdYouthReportDtl());

      dtRptPeriodEnd = report.getDtRptPeriodEnd();
      if (!DateHelper.isNull(dtRptPeriodEnd)) {
        soReport.setDtRptPeriodEnd(dtRptPeriodEnd);
      }

      Person p = report.getPerson();
      soReport.setIdPerson(p.getIdPerson());
      soReport.setDtDob(report.getDtDob());
      soReport.setCdAgeClass(StringHelper.getNonNullString(report.getCdAgeClass()));
      soReport.setCdSex(StringHelper.getNonNullString(report.getCdSex()));
      soReport.setCdEthinicity(StringHelper.getNonNullString(report.getCdEthinicity()));
      soReport.setIndFcStatSvcs(StringHelper.getNonNullString(report.getIndFcStatusServices()));
      soReport.setCdLastGradeComp(StringHelper.getNonNullString(report.getCdLastGradeComp()));
      soReport.setIndAdjDelinquent(StringHelper.getNonNullString(report.getIndAdjDelinquent()));
      soReport.setIndTribalMbr(StringHelper.getNonNullString(report.getIndTribalMbr()));
      soReport.setIndSpecEdu(StringHelper.getNonNullString(report.getIndSpcEduStat()));
      soReport.setIndIlNeedsAsm(StringHelper.getNonNullString(report.getIndIlNeedsAsm()));

      soReport.setIndEnteredByYth(StringHelper.getNonNullString(report.getIndEnteredByYth()));
      soReport.setNmEnteredByName(StringHelper.getNonNullString(report.getNmEnteredBy()));
      soReport.setIndFollowUp(StringHelper.getNonNullString(report.getIndFollowUp()));
      soReport.setCdPopulationType(StringHelper.getNonNullString(report.getCdPopulationType()));

      ArrayList<String> races = new ArrayList<String>();
      
      if( ArchitectureConstants.Y.equals(report.getIndRaceAa())){
        races.add(CodesTables.CRACE_AA);
      }
      if( ArchitectureConstants.Y.equals(report.getIndRaceAn())){
        races.add(CodesTables.CRACE_AN);
      }
      if( ArchitectureConstants.Y.equals(report.getIndRaceBk())){
        races.add(CodesTables.CRACE_BK);
      }
      if( ArchitectureConstants.Y.equals(report.getIndRaceHp())){
        races.add(CodesTables.CRACE_HP);
      }
      if( ArchitectureConstants.Y.equals(report.getIndRaceWt())){
        races.add(CodesTables.CRACE_WT);
      }
      if( ArchitectureConstants.Y.equals(report.getIndRaceUd())){
        races.add(CodesTables.CRACE_UD);
      }
      
      soReport.setRaces(races);
      soReport.setIndRaceAmerIndnAkNative(!StringHelper.isEmptyOrNull(report.getIndRaceAa())? report.getIndRaceAa() : ArchitectureConstants.N);
      soReport.setIndRaceAsian(!StringHelper.isEmptyOrNull(report.getIndRaceAn()) ? report.getIndRaceAn() : ArchitectureConstants.N);
      soReport.setIndRaceBlackAfricanAmer(!StringHelper.isEmptyOrNull(report.getIndRaceBk()) ? report.getIndRaceBk() : ArchitectureConstants.N);
      soReport.setIndRaceNativeHiPacIslander(!StringHelper.isEmptyOrNull(report.getIndRaceHp()) ? report.getIndRaceHp() : ArchitectureConstants.N);
      soReport.setIndRaceWhite(!StringHelper.isEmptyOrNull(report.getIndRaceWt()) ? report.getIndRaceWt() : ArchitectureConstants.N);
      soReport.setIndRaceUnknown(!StringHelper.isEmptyOrNull(report.getIndRaceUd()) ? report.getIndRaceUd() : ArchitectureConstants.N);
      soReport.setIndRaceDeclined(!StringHelper.isEmptyOrNull(report.getIndRaceDeclined()) ? report.getIndRaceDeclined() : ArchitectureConstants.N);

      soReport.setIndAcadSupport(report.getIndAcadSupport());
      soReport.setIndBdgtFinMgt(report.getIndBdgtFinMgt());
      soReport.setIndCareerPrep(report.getIndCareerPrep());
      soReport.setIndEduFinance(report.getIndEduFinance());
      soReport.setIndEmpProgVoc(report.getIndEmpProgVoc());
      soReport.setIndFamMarrEdu(report.getIndFamMarrEdu());
      soReport.setIndHealthEdu(report.getIndHealthEdu());
      soReport.setIndHousingEdu(report.getIndHousingEdu());
      soReport.setIndMentoring(report.getIndMentoring());
      soReport.setIndOthFinance(report.getIndOthFinance());
      soReport.setIndPsEduSupport(report.getIndPsEduSupport());
      soReport.setIndRoomBrdFin(report.getIndRoomBrdFin());
      soReport.setIndSuperIl(report.getIndSuperIl());

      // Retrieve comments from the report
      soReport.setTxtAcadSupport(StringHelper.getNonNullString(report.getTxtAcadSupport()));
      soReport.setTxtBdgtFinMgt(StringHelper.getNonNullString(report.getTxtBdgtFinMgt()));
      soReport.setTxtCareerPrep(StringHelper.getNonNullString(report.getTxtCareerPrep()));
      soReport.setTxtEduFinance(StringHelper.getNonNullString(report.getTxtEduFinance()));
      soReport.setTxtEmpProgVoc(StringHelper.getNonNullString(report.getTxtEmpProgVoc()));
      soReport.setTxtFamMarrEdu(StringHelper.getNonNullString(report.getTxtFamMarrEdu()));
      soReport.setTxtHealthEdu(StringHelper.getNonNullString(report.getTxtHealthEdu()));
      soReport.setTxtHousingEdu(StringHelper.getNonNullString(report.getTxtHousingEdu()));
      soReport.setTxtMentoring(StringHelper.getNonNullString(report.getTxtMentoring()));
      soReport.setTxtOthFinance(StringHelper.getNonNullString(report.getTxtOthFinance()));
      soReport.setTxtPsEduSupport(StringHelper.getNonNullString(report.getTxtPsEduSupport()));
      soReport.setTxtRmBrdFin(StringHelper.getNonNullString(report.getTxtRmBrdFin()));
      soReport.setTxtSuperIl(StringHelper.getNonNullString(report.getTxtSuperIl()));
      
      // do not retrieve/display responses from CM/ILC created YRD on Portal survey
      if(!(PORTAL_SURVEY_DETAIL.equals(si.getSzScreenName())
                      && ArchitectureConstants.N.equals(report.getIndEnteredByYth()))){
        soReport.setCdOutcomeRptStat(report.getCdOutcomeRptStat());
  
        Date dtOutcomeDate = report.getDtOutcomeDate();
        if (!DateHelper.isNull(dtOutcomeDate)) {
          soReport.setDtOutcomeDate(dtOutcomeDate);
        }
  
        soReport.setIndFcStatOutcome(report.getIndFcStatus());
        
        soReport.setCdCurrFtEmp(report.getCdCurrFtEmp());
        soReport.setCdCurrPtEmp(report.getCdCurrPtEmp());
        soReport.setCdEducAid(report.getCdEducAid());
        soReport.setCdHighestEdu(report.getCdHighEdu());
        soReport.setCdCurrEnrAtt(report.getCdCurrAtdEnr());
        soReport.setCdSocialSec(report.getCdSocialSec());
        soReport.setCdMarrAtBirth(report.getCdMarrAtBirth());
        soReport.setCdChildren(report.getCdChildren());
        soReport.setCdConnAdult(report.getCdConnAdult());
        soReport.setCdEmpSkills(report.getCdEmpSkills());
        soReport.setCdHomeless(report.getCdHomeless());
        soReport.setCdIncarceration(report.getCdIncarceration());
        soReport.setCdMedicaid(report.getCdMedicaid());
        soReport.setCdOthHlthInsTyp(report.getCdOthHlthInsTyp());
        soReport.setCdMedicalSvc(report.getCdHlthInsMedical());
        soReport.setCdMentalHlthSvc(report.getCdHlthInsMental());
        soReport.setCdPrescription(report.getCdHlthInsPrescription());
        soReport.setCdOthSupport(report.getCdOthSupport());
        soReport.setCdSubAbuseRef(report.getCdSubAbuseRef());
        soReport.setCdPubFinAst(report.getCdTanf());
        soReport.setCdFoodAst(report.getCdFoodStamps());
        soReport.setCdHousingAst(report.getCdHousingAst());

        soReport.setIndSurveyCompleted(NytdHelper.isSurveyComplete(report.getIdYouthReportDtl()));

      }else{
        // set survey as not complete if CM/ILC created survey is viewed by youth for first time
        // since no survey response is displayed
        soReport.setIndSurveyCompleted(false);
      }
      //set soPerson to new data in case child is in care and Person details have been updated.
      setSoPerson(soPerson, p.getIdPerson(), dtRptPeriodEnd);
      
    }else{ // this branch is for new YRD
      setSoPerson(soPerson, idPerson, dtRptPeriodEnd);
      soReport.setIdPerson(idPerson);
      soReport.setDtDob(soPerson.getDtDob());
      soReport.setCdAgeClass(soPerson.getCdAgeClass());
      soReport.setCdSex(soPerson.getCdSex());
      soReport.setCdEthinicity(soPerson.getCdEthinicity());
      soReport.setIndFcStatSvcs(soPerson.getIndFcStatSvcs());
      soReport.setCdLastGradeComp(soPerson.getCdLastGradeComp());
      soReport.setIndAdjDelinquent(soPerson.getIndAdjDelinquent());
      soReport.setIndTribalMbr(soPerson.getIndTribalMbr());
      soReport.setIndSpecEdu(soPerson.getIndSpcEduStat());
      soReport.setIndFcStatOutcome(soPerson.getIndFcStatOutcome());

      soReport.setDtRptPeriodEnd(dtRptPeriodEnd);
            
      String cdPopulationType = NytdHelper.getPopulationType(idPerson, soPerson.getDtDob(), dtRptPeriodEnd);

      if( POPULATION_TYPE_BASELINE.equals(cdPopulationType)){
        if( ArchitectureConstants.Y.equals(soPerson.getIndFcStatOutcome())){
          soReport.setCdPopulationType(cdPopulationType);
        }else{
          soReport.setCdPopulationType(StringHelper.EMPTY_STRING);
        }
      }else{
        soReport.setCdPopulationType(cdPopulationType);
      }
            
      if (POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType)) {
        soReport.setIndFollowUp(ArchitectureConstants.Y);
      } else {
        soReport.setIndFollowUp(ArchitectureConstants.N);
      }
      
      // set races
      List<String> races = soPerson.getRaces();
      soReport.setRaces(races);
      if (races != null && !races.isEmpty() ) {
        soReport.setIndRaceAmerIndnAkNative(StringHelper.toYorN(races.contains(CodesTables.CRACE_AA)));
        soReport.setIndRaceAsian(StringHelper.toYorN(races.contains(CodesTables.CRACE_AN)));
        soReport.setIndRaceBlackAfricanAmer(StringHelper.toYorN(races.contains(CodesTables.CRACE_BK)));
        soReport.setIndRaceNativeHiPacIslander(StringHelper.toYorN(races.contains(CodesTables.CRACE_HP)));
        soReport.setIndRaceUnknown(StringHelper.toYorN(races.contains(CodesTables.CRACE_UD)));
        soReport.setIndRaceWhite(StringHelper.toYorN(races.contains(CodesTables.CRACE_WT)));
        // Based on MR-067 this should always be N, unless future changes are made to include Declined
        // as an option for person race on Person Detail page
        soReport.setIndRaceDeclined(StringHelper.toYorN(races.contains("DC"))); // this should always be N
      }
      
      // default services receive to 'N'
      soReport.setIndAcadSupport(ArchitectureConstants.N);
      soReport.setIndBdgtFinMgt(ArchitectureConstants.N);
      soReport.setIndCareerPrep(ArchitectureConstants.N);
      soReport.setIndEduFinance(ArchitectureConstants.N);
      soReport.setIndEmpProgVoc(ArchitectureConstants.N);
      soReport.setIndFamMarrEdu(ArchitectureConstants.N);
      soReport.setIndHealthEdu(ArchitectureConstants.N);
      soReport.setIndHousingEdu(ArchitectureConstants.N);
      soReport.setIndMentoring(ArchitectureConstants.N);
      soReport.setIndOthFinance(ArchitectureConstants.N);
      soReport.setIndPsEduSupport(ArchitectureConstants.N);
      soReport.setIndRoomBrdFin(ArchitectureConstants.N);
      soReport.setIndSuperIl(ArchitectureConstants.N);

    }

    // SO returned is never null
    so.setPerson(soPerson);
    so.setReport(soReport);
    return so;
  }
  
  private void setSoPerson(YouthReportDetailRetrieveSOPerson soPerson, int idPerson, Date dtRptPeriodEnd){
    /*
     * -- retrieve person data as follows: PERSON -active status : CD_PERSON_STATUS (CPERSTAT) -dob : DT_PERSON_BIRTH
     * -sex : CD_PERSON_SEX (CSEX)
     * 
     * PERSON_RACE -race : multiple CD_RACE (CRACE) values
     * 
     * PERSON_ETHNICITY -ethnicity : latest CD_ETHNICITY (CINDETHN) value
     * 
     * TRIBAL -tribal member : IND_TRBL_MEMBER (U = Unknown, Y = member, N = not member)
     * 
     * LEGAL_ACTION -adjudicated delinquent : record where LEGAL_ACTION_OUTCOME record of CD_OUTCOME = CLEGLOUT_ADJ
     * 
     * EDUCATIONAL_HISTORY -sp. ed. status : current IND_SPC_EDU_NEED -current attendance & enrollment : if current
     * record has CD_ATTENDANCE = CATNDNCE_REG
     * 
     */
    if (idPerson > 0) {
      Person person = (Person) getPersistentObject(Person.class, idPerson);
      if (person == null) {
        // -- should never happen
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      soPerson.setIdPerson(idPerson);
      
      long numSPL = stagePersonLinkDAO.countStagePersonLinkForOpenStagesByIdPerson(idPerson);
      
      if( numSPL > 0 ){
        soPerson.setCdPersonActiveStatus(CodesTables.CPERSTAT_A);        
      }else{
        soPerson.setCdPersonActiveStatus(CodesTables.CPERSTAT_I);        
      }
      
      soPerson.setDtDob(person.getDtPersonBirth());
      soPerson.setCdSex(person.getCdPersonSex());

      String cdAgeClass = null;
      int age = DateHelper.getAge(person.getDtPersonBirth(), dtRptPeriodEnd);
      if (age > 19) {
        cdAgeClass = CodesTables.CAGECLSS_20;
      } else if (age < 18) {
        cdAgeClass = CodesTables.CAGECLSS_17;
      } else {
        cdAgeClass = CodesTables.CAGECLSS_18;
      }
      soPerson.setCdAgeClass(cdAgeClass);

      List<String> races = new ArrayList<String>();
      Collection<PersonRace> personRaces = person.getPersonRaces();
      if (personRaces != null && !personRaces.isEmpty()) {
        for (PersonRace personRace : personRaces) {
          String cdRace = personRace.getCdRace();
          if (!races.contains(cdRace)) {
            races.add(cdRace);
          }
        }
      }
      soPerson.setRaces(races);

      String cdEthnicity = CodesTables.CINDETHN_UT;
      PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);
      if (personEthnicity != null) {
        cdEthnicity = personEthnicity.getCdEthnicity();
      }
      soPerson.setCdEthinicity(cdEthnicity);

      String indTribal = StringHelper.EMPTY_STRING;
      Tribal tribal = tribalDAO.findLatestTribal(idPerson);
      if (tribal != null && ArchitectureConstants.Y.equals(tribal.getIndTrblMember())) {
        indTribal = ArchitectureConstants.Y;
      }else if (tribal != null && ArchitectureConstants.N.equals(tribal.getIndTrblMember())){
        indTribal = ArchitectureConstants.N;
      }
      soPerson.setIndTribalMbr(indTribal);

      String indAdjDelinquent = ArchitectureConstants.N;
      LegalActionOutcome legalActionOutcome = legalActionOutcomeDAO
                                                                   .findLegalActionOutcomeForYouthReport(
                                                                                                         idPerson,
                                                                                                         CodesTables.CLEGLOUT_ADJ);
      if (legalActionOutcome != null) {
        indAdjDelinquent = ArchitectureConstants.Y;
      }
      soPerson.setIndAdjDelinquent(indAdjDelinquent);

      String cdLastGradeComp = StringHelper.EMPTY_STRING;

      String highestGrade = educationalHistoryDAO.findEducationalHistoryHighestGrade(idPerson);
      
      if( StringHelper.isNotEmptyOrNull(highestGrade) ){
        // Get previous grade from current grade
        if(CodesTables.CSCHGRAD_010.equals(highestGrade)
                        || CodesTables.CSCHGRAD_020.equals(highestGrade)
                        || CodesTables.CSCHGRAD_030.equals(highestGrade)
                        || CodesTables.CSCHGRAD_040.equals(highestGrade)
                        || CodesTables.CSCHGRAD_101.equals(highestGrade)
                        || CodesTables.CSCHGRAD_102.equals(highestGrade)
                        || CodesTables.CSCHGRAD_103.equals(highestGrade)
                        || CodesTables.CSCHGRAD_104.equals(highestGrade)
                        || CodesTables.CSCHGRAD_105.equals(highestGrade)
                        || CodesTables.CSCHGRAD_106.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_05;
        }else if(CodesTables.CSCHGRAD_107.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_06;
        }else if(CodesTables.CSCHGRAD_108.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_07;
        }else if(CodesTables.CSCHGRAD_109.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_08;
        }else if(CodesTables.CSCHGRAD_110.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_09;
        }else if(CodesTables.CSCHGRAD_111.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_10;
        }else if(CodesTables.CSCHGRAD_112.equals(highestGrade)
                        || CodesTables.CSCHGRAD_120.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_11;
        }else if(CodesTables.CSCHGRAD_140.equals(highestGrade)){
          cdLastGradeComp = CodesTables.CEDUCOMP_12;
        } // excluding CSCHGRAD_130 no definition as to what this could be
      }

      String indSpcEdStatus = ArchitectureConstants.N;
      List<EducationalHistory> eduHistList = educationalHistoryDAO.findEducationalHistoryByIdPerson(idPerson);
      EducationalHistory educationalHistory = null;
      
      for( Iterator<EducationalHistory> iter = eduHistList.iterator(); iter.hasNext();){
        educationalHistory = iter.next();
        
        if (educationalHistory != null) {
          if (DateHelper.isNull(educationalHistory.getDtEdhistWithdrawnDate())) {
            // Get special education status based on active enrollment Education Programs only
            if (CodesTables.CEDUCNED_BDR.equals(educationalHistory.getCdEdhistNeeds1())
                            || CodesTables.CEDUCNED_LDR.equals(educationalHistory.getCdEdhistNeeds7())
                            || CodesTables.CEDUCNED_SPE.equals(educationalHistory.getCdEdhistNeeds8())
                            || CodesTables.CEDUCNED_PED.equals(educationalHistory.getCdEdhistNeeds10())) {
              indSpcEdStatus = ArchitectureConstants.Y;
            }
          }
        }
      }

      soPerson.setIndSpcEduStat(indSpcEdStatus);
      soPerson.setCdLastGradeComp(cdLastGradeComp);

      String indFcStatSvcs = ArchitectureConstants.N;

      Date currRptPerBegin = NytdHelper.getDtRptPeriodBegin(dtRptPeriodEnd);
      Date currRptPerEnd = dtRptPeriodEnd;
      
      // foster care status for services is for entire reporting period
      Long numPlcmt = placementDAO.countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate(idPerson,
                                                                                          fostCarePlcmtTypes, 
                                                                                          currRptPerBegin,
                                                                                          currRptPerEnd);

      if (numPlcmt > 0) {
        indFcStatSvcs = ArchitectureConstants.Y;
      }

      soPerson.setIndFcStatSvcs(indFcStatSvcs);

      Date dob = person.getDtPersonBirth();
      Date dtSurveyPeriodEnd = NytdHelper.getDtSurveyPeriodEndForRptPeriod( dob, dtRptPeriodEnd);
      if( dob != null ){
        if(dtSurveyPeriodEnd != null ){
          Calendar calDtSurveyPeriodBegin = Calendar.getInstance();
          calDtSurveyPeriodBegin.setTime(dtSurveyPeriodEnd);
          calDtSurveyPeriodBegin.add(Calendar.DAY_OF_MONTH, -NytdHelper.SURVEY_PERIOD);
          
          Date dtSurveyPeriodBegin = calDtSurveyPeriodBegin.getTime();
          
          Date minEndDate = (Date) dtSurveyPeriodEnd.clone();
          
          if( dtSurveyPeriodEnd.compareTo(currRptPerEnd) > 0 ){
            minEndDate = currRptPerEnd;
          }
          
          // Foster Care Status Outcome is based on any active placement within the survey period of that rpt period, not reporting period
          Long cntPlcmt = placementDAO.countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate(idPerson, fostCarePlcmtTypes, dtSurveyPeriodBegin, minEndDate);
          
          soPerson.setIndFcStatOutcome(StringHelper.toYorN(cntPlcmt > 0));
        }else{
          // no survey period in reporting period
          soPerson.setIndFcStatOutcome(ArchitectureConstants.N);
        }
      }else{
        // no date of birth
        soPerson.setIndFcStatOutcome(ArchitectureConstants.N);
      }
      
      String cdPopulationType = NytdHelper.getPopulationType(idPerson, dob, currRptPerEnd);
      
      if( POPULATION_TYPE_BASELINE.equals(cdPopulationType)){
        if( ArchitectureConstants.Y.equals(soPerson.getIndFcStatOutcome())){
          // baseline has to be in care during survey period
          soPerson.setCdPopulationType(cdPopulationType);
        }else{
          soPerson.setCdPopulationType(StringHelper.EMPTY_STRING);
        }
      }else{
        soPerson.setCdPopulationType(cdPopulationType);
      }
      
    } else {
      // -- should never happen, person id need to be passed in to service
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }    
  }
}
