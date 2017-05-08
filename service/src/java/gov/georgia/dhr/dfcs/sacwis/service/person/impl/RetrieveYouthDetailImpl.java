/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CollegeExamDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExamDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthReportDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CollegeExam;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.ExamDetail;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.YouthReportDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveYouthDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamSummary;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportSummary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author hong.van.t.vo
 * 
 */

/**
* <pre>
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 08/18/2010  schoi           SMS #66384: MR-067 Updated code to display the NYTD User Information section
*                             as the last expandable section only if the person is a NYTD User
* 09/29/2010  schoi           SMS #74114: MR-067 Updated code to check for Independent Living Coordinator (ILC) 
*                             by job title                      
* </pre>
*/

public class RetrieveYouthDetailImpl extends BaseServiceImpl implements RetrieveYouthDetail {
  
  private CollegeExamDAO collegeExamDAO = null;
  private EducationalHistoryDAO educationalHistoryDAO = null;
  private EmployeeDAO employeeDAO = null;
  private ExamDetailDAO examDetailDAO = null;
  private YouthDetailDAO youthDetailDAO = null;
  private YouthReportDtlDAO youthReportDtlDAO = null;
  // SMS 66384: MR-067 Added additional DAOs for NYTD User Information section
  private PortalUserDAO portalUserDAO = null;
  private PortalUserDtlDAO portalUserDtlDAO = null;
  
  public void setCollegeExamDAO(CollegeExamDAO collegeExamDAO) {
    this.collegeExamDAO = collegeExamDAO;
  }
  
  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setExamDetailDAO(ExamDetailDAO examDetailDAO) {
    this.examDetailDAO = examDetailDAO;
  }
  
  public void setYouthDetailDAO(YouthDetailDAO youthDetailDAO) {
    this.youthDetailDAO = youthDetailDAO;
  }
  
  public void setYouthReportDtlDAO(YouthReportDtlDAO youthReportDtlDAO) {
    this.youthReportDtlDAO = youthReportDtlDAO;
  }

  // SMS 66384: MR-067 Added additional DAOs for NYTD User Information section
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }
 
  public void setPortalUserDtlDAO(PortalUserDtlDAO portalUserDtlDAO) {
    this.portalUserDtlDAO = portalUserDtlDAO;
  }
  
  public YouthDetailRetrieveSO retrieveYouthDetail(YouthDetailRetrieveSI youthDetailRetrieveSI) {
    YouthDetailRetrieveSO youthDetailRetrieveSO = new YouthDetailRetrieveSO();
    
    int idUser = youthDetailRetrieveSI.getIdUser();
    Employee employee = employeeDAO.findEmployeeByIdPerson(idUser);
    if(employee != null) {
      String unitSpecialization = employee.getUnit() != null ? employee.getUnit().getCdUnitSpecialization() : null;
      youthDetailRetrieveSO.setCdUserUnitSpecialization(unitSpecialization);
      // SMS #74114: MR-067
      String cdEmpClass = employee.getCdEmployeeClass() != null ? employee.getCdEmployeeClass() : null;
      if (cdEmpClass != null && cdEmpClass.equals(CodesTables.CEMPJBCL_G1007)) {
        youthDetailRetrieveSO.setIsUserEmpClassILC(true);
      }
      else {
        youthDetailRetrieveSO.setIsUserEmpClassILC(false);
      }
    }
    
    int idPerson = youthDetailRetrieveSI.getIdPerson();
    YouthDetail youthDetail = youthDetailDAO.findYouthDetail(idPerson);
    // SMS 66384: MR-067 
    PortalUserDtl portalUserDtl = portalUserDtlDAO.findPortalUserbyIdPerson(idPerson);    
    
    // STGAP00004163 
    /*String schoolName = educationalHistoryDAO.findSchoolNameByIdPersonCdEnrollGrade(idPerson, ENROLL_GRADES);
    // Retrieve data for School Information
    if (StringHelper.isValid(schoolName)) {
      youthDetailRetrieveSO.setTxtHiSchoolName(schoolName);
    }*/
    EducationalHistory educationalHistory = educationalHistoryDAO.findEducationalHistory(idPerson);
    if (educationalHistory != null) {
      if ((StringHelper.isValid(educationalHistory.getCdCurrGrade()) || StringHelper.isValid(educationalHistory.getCdEdhistEnrollGrade()) || !DateHelper.isNull(educationalHistory.getDtEdhistEnrollDate())) && DateHelper.isNull(educationalHistory.getDtEdhistWithdrawnDate())) {
        youthDetailRetrieveSO.setTxtHiSchoolName(educationalHistory.getNmEdhistSchool());
      }
    }
    // end STGAP00004163
    if (youthDetail != null) {
      // Retrieve primary key
      youthDetailRetrieveSO.setIdPerson(youthDetail.getIdPerson());
      // Retrieve data for General Information
      youthDetailRetrieveSO.setCdParentalStatus(youthDetail.getCdParStat());
      youthDetailRetrieveSO.setDtEmancipationDiscussionDate(youthDetail.getDtEmncDisc());
      youthDetailRetrieveSO.setTxtEmancipationDiscussionCmnt(youthDetail.getTxtEmncDisc());
      youthDetailRetrieveSO.setIndLifeSkillsTrainingRecvd(youthDetail.getIndLifeSkills());
      youthDetailRetrieveSO.setTxtIndLifeSkillsTrainingRecvd(youthDetail.getTxtLifeSkills());
      youthDetailRetrieveSO.setIndEmploymentServiceRecvd(youthDetail.getIndEmpSvc());
      youthDetailRetrieveSO.setTxtIndEmploymntServiceRecvd(youthDetail.getTxtEmpSvc());
      youthDetailRetrieveSO.setIndHealthServiceRecvd(youthDetail.getIndHealthSvc());
      youthDetailRetrieveSO.setTxtIndHealthServiceRecvd(youthDetail.getTxtHlthSvc());

      youthDetailRetrieveSO.setDtExpectdHiSchoolGradtn(youthDetail.getDtSchGrad());
      youthDetailRetrieveSO.setCdAcademicTrack(youthDetail.getCdAcadTrack());
      youthDetailRetrieveSO
                           .setTxtCreditsRequired(youthDetail.getNbrSchCreditReqd() != null ? String
                                                                                                    .valueOf(youthDetail
                                                                                                                        .getNbrSchCreditReqd())
                                                                                           : "");
      youthDetailRetrieveSO
                           .setTxtCreditsEarned(youthDetail.getNbrSchCreditReqd() != null ? String
                                                                                                  .valueOf(youthDetail
                                                                                                                      .getNbrSchCreditEarned())
                                                                                         : "");
      youthDetailRetrieveSO
                           .setTxtHsCurrentGPA(youthDetail.getNbrSchCurrGpa() != null ? String
                                                                                              .valueOf(youthDetail
                                                                                                                  .getNbrSchCurrGpa())
                                                                                     : "");
      youthDetailRetrieveSO
                           .setTxtHsCumulativeGPA(youthDetail.getNbrSchCumGpa() != null ? String
                                                                                                .valueOf(youthDetail
                                                                                                                    .getNbrSchCumGpa())
                                                                                       : "");
      youthDetailRetrieveSO.setIndHsGraduate(youthDetail.getIndSchGrad());
      youthDetailRetrieveSO.setTxtIndHsGradteCmnt(youthDetail.getTxtSchCmnts());
      // Retrieve data for and GED Information
      youthDetailRetrieveSO.setTxtGEDProgramName(youthDetail.getNmGedProg());
      youthDetailRetrieveSO.setIndInGEDProgram(youthDetail.getIndGedProg());
      youthDetailRetrieveSO.setTxtGEDProgAddressLine1(youthDetail.getAddrGedAddr1());
      youthDetailRetrieveSO.setTxtGEDProgAddressLine2(youthDetail.getAddrGedAddr2());
      youthDetailRetrieveSO.setTxtGEDProgCity(youthDetail.getAddrGedAddrCity());
      youthDetailRetrieveSO.setCdGEDProgState(youthDetail.getAddrGedAddrState());
      youthDetailRetrieveSO.setTxtGEDProgZipCode(youthDetail.getAddrGedAddrZip());
      youthDetailRetrieveSO.setTxtGEDProgPhoneNum(youthDetail.getNbrGedPhone());
      youthDetailRetrieveSO.setTxtGEDProgFaxNum(youthDetail.getNbrGedFax());
      youthDetailRetrieveSO.setDtExpectdGEDProgramComp(youthDetail.getDtGedExpProgComp());
      youthDetailRetrieveSO.setDtActualGEDProgramComp(youthDetail.getDtGedProgComp());
      // Retrieve data for Post Secondary Education
      youthDetailRetrieveSO.setTxtPostInstitutionName(youthDetail.getNmInst());
      youthDetailRetrieveSO.setCdPostEduGoal(youthDetail.getCdEduGoal());
      youthDetailRetrieveSO.setCdPostClassification(youthDetail.getCdClassif());
      youthDetailRetrieveSO.setTxtPostAreaofStudy(youthDetail.getTxtAreaStudy());
      youthDetailRetrieveSO
                           .setTxtPostReqdCreditsforGradtn(youthDetail.getNbrPostReqCred() != null ? String
                                                                                                           .valueOf(youthDetail
                                                                                                                               .getNbrPostReqCred())
                                                                                                  : "");
      youthDetailRetrieveSO
                           .setTxtPostEarndCreditsforGradtn(youthDetail.getNbrPostReqEar() != null ? String
                                                                                                           .valueOf(youthDetail
                                                                                                                               .getNbrPostReqEar())
                                                                                                  : "");
      youthDetailRetrieveSO
                           .setTxtPostCurrentGPA(youthDetail.getNbrPostCurrGpa() != null ? String
                                                                                                 .valueOf(youthDetail
                                                                                                                     .getNbrPostCurrGpa())
                                                                                        : "");
      youthDetailRetrieveSO
                           .setTxtPostCumulativeGPA(youthDetail.getNbrPostCummGpa() != null ? String
                                                                                                    .valueOf(youthDetail
                                                                                                                        .getNbrPostCummGpa())
                                                                                           : "");
      youthDetailRetrieveSO.setDtPostExpectdGradtn(youthDetail.getDtPostExpGrad());
      youthDetailRetrieveSO.setDtPostActualGradtn(youthDetail.getDtPostGrad());
      // Retrieve timestamp for use when update detail record
      youthDetailRetrieveSO.setDtLastUpdate(youthDetail.getDtLastUpdate());
    }
    // SMS 66384: MR-067 Display NYTD User Information section only if the person is a NYTD User
    if (portalUserDtl != null) {
      // Set the flag for NYTD User to Yes
      youthDetailRetrieveSO.setIndNytdUser(ArchitectureConstants.Y);
      PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(portalUserDtl.getIdUser().intValue());
      youthDetailRetrieveSO.setTxtUserFirstName(portalUser.getNmUserFirst());
      youthDetailRetrieveSO.setTxtUserMiddleInitial(portalUser.getNmUserMiddle());
      youthDetailRetrieveSO.setTxtUserLastName(portalUser.getNmUserLast());
      youthDetailRetrieveSO.setTxtUserEml(portalUser.getTxtUserEmail());
      youthDetailRetrieveSO.setTxtUserFB(portalUserDtl.getTxtUserFacebook());
      youthDetailRetrieveSO.setTxtUserMS(portalUserDtl.getTxtUserMyspace());
      youthDetailRetrieveSO.setTxtUserTW(portalUserDtl.getTxtUserTwitter());
      youthDetailRetrieveSO.setTxtUserOthSite(portalUserDtl.getTxtOtherSite());
      youthDetailRetrieveSO.setTxtUserNameOthSite(portalUserDtl.getTxtUserOtherSite());
      youthDetailRetrieveSO.setTxtUserPhnBest(portalUserDtl.getNbrUserPhoneBest());
      youthDetailRetrieveSO.setTxtUserPhnBestExt(portalUserDtl.getNbrUserPhoneBestExtension());
      youthDetailRetrieveSO.setTxtUserPhnBestType(portalUserDtl.getCdUserPhoneBestType());
      youthDetailRetrieveSO.setTxtUserPhnAlt1(portalUserDtl.getNbrUserPhoneAlt1());
      youthDetailRetrieveSO.setTxtUserPhnAlt1Ext(portalUserDtl.getNbrUserPhoneAlt1Extension());
      youthDetailRetrieveSO.setTxtUserPhnAlt1Type(portalUserDtl.getCdUserPhoneAlt1Type());
      youthDetailRetrieveSO.setTxtUserPhnAlt2(portalUserDtl.getNbrUserPhoneAlt2());
      youthDetailRetrieveSO.setTxtUserPhnAlt2Ext(portalUserDtl.getNbrUserPhoneAlt2Extension());
      youthDetailRetrieveSO.setTxtUserPhnAlt2Type(portalUserDtl.getCdUserPhoneAlt2Type());
      youthDetailRetrieveSO.setTxtCntctByText(portalUserDtl.getIndContactByText());       
      youthDetailRetrieveSO.setTxtAddrUsrStLn1(portalUser.getAddrUserAddrStLn1());
      youthDetailRetrieveSO.setTxtAddrUsrStLn2(portalUser.getAddrUserAddrStLn2());
      youthDetailRetrieveSO.setTxtAddrUsrCity(portalUser.getAddrUserAddrCity());
      youthDetailRetrieveSO.setTxtAddrUsrSt(portalUser.getCdUserAddrState());
      youthDetailRetrieveSO.setTxtAddrUsrZip(portalUser.getAddrUserAddrZip());
      youthDetailRetrieveSO.setTxtAddrUsrCnty(portalUser.getCdUserAddrCounty());
      youthDetailRetrieveSO.setTxtEmerContact(portalUserDtl.getTxtEmerContact());      
    }   
    // End SMS 66384: MR-067
    List<ExamDetail> hsExamList = examDetailDAO.findExamsByIdPersonIndGed(idPerson, ArchitectureConstants.N);
    List<ExamDetail> gedExamList = examDetailDAO.findExamsByIdPersonIndGed(idPerson, ArchitectureConstants.Y);
    List<CollegeExam> ceExamList = collegeExamDAO.findAllCollegeExamsByIdPerson(idPerson);
    List<YouthReportDtl> youthReportList = youthReportDtlDAO.findAllYouthReportDtl(idPerson);
    List<ExamDetailList> hsExamListSO = null;
    List<ExamDetailList> gedExamListSO = null;
    List<CollegeEntranceExamSummary> ceExamListSO = null;
    List<YouthReportSummary> reportListSO = null;
    if (hsExamList != null && !hsExamList.isEmpty()) {
      hsExamListSO = new ArrayList<ExamDetailList>();
      Iterator examDetailItr = hsExamList.iterator();
      while (examDetailItr.hasNext()) {
        ExamDetail exam = (ExamDetail) examDetailItr.next();
        ExamDetailList examSO = new ExamDetailList();
        examSO.setCdExamType(exam.getCdExamTyp());
        examSO.setDtExam(exam.getDtExam());
        examSO.setIdExamDetail(exam.getIdExamDetail());
        examSO.setIndFirstAtmpt(exam.getIndFirstAtmpt());
        examSO.setIndPassed(exam.getIndPassed());
        examSO.setNbrScore(exam.getNbrScore());
        hsExamListSO.add(examSO);
      }
      youthDetailRetrieveSO.setHsExamList(hsExamListSO);
    }
    if (gedExamList != null && !gedExamList.isEmpty()) {
      gedExamListSO = new ArrayList<ExamDetailList>();
      Iterator examDetailItr = gedExamList.iterator();
      while (examDetailItr.hasNext()) {
        ExamDetail exam = (ExamDetail) examDetailItr.next();
        ExamDetailList examSO = new ExamDetailList();
        examSO.setCdExamType(exam.getCdExamTyp());
        examSO.setDtExam(exam.getDtExam());
        examSO.setIdExamDetail(exam.getIdExamDetail());
        examSO.setIndFirstAtmpt(exam.getIndFirstAtmpt());
        examSO.setIndPassed(exam.getIndPassed());
        examSO.setNbrScore(exam.getNbrScore());
        gedExamListSO.add(examSO);
      }
      youthDetailRetrieveSO.setGedExamList(gedExamListSO);
    }
    if (ceExamList != null && !ceExamList.isEmpty()) {
      ceExamListSO = new ArrayList<CollegeEntranceExamSummary>();
      Iterator ceExamItr = ceExamList.iterator();
      while (ceExamItr.hasNext()) {
        CollegeExam ceExam = (CollegeExam) ceExamItr.next();
        CollegeEntranceExamSummary ceExamSO = new CollegeEntranceExamSummary();
        ceExamSO.setDtExamTaken(ceExam.getDtExam());
        ceExamSO.setCdExamType(ceExam.getCdExamTyp());
        ceExamSO.setIdExam(ceExam.getIdCollegeExam());
        ceExamListSO.add(ceExamSO);
      }
      youthDetailRetrieveSO.setCeExamList(ceExamListSO);
    }
    if (youthReportList != null && !youthReportList.isEmpty()) {
      reportListSO = new ArrayList<YouthReportSummary>();
      Iterator reportListItr = youthReportList.iterator();
      while (reportListItr.hasNext()) {
        YouthReportDtl report = (YouthReportDtl) reportListItr.next();
        YouthReportSummary reportSO = new YouthReportSummary();
        reportSO.setCdAgeClass(report.getCdAgeClass());
        reportSO.setCdOutcomeStatus(report.getCdOutcomeRptStat());
        reportSO.setDtOutcomeDate(report.getDtOutcomeDate());
        reportSO.setDtReportingPeriod(report.getDtRptPeriodEnd());
        reportSO.setIdYouthReport(report.getIdYouthReportDtl());
        reportListSO.add(reportSO);
      }
      youthDetailRetrieveSO.setYouthReportList(reportListSO);
      // Report list is in desc order so the first one is the current/latest one
      youthDetailRetrieveSO.setDtCurrRptPeriod(reportListSO.get(0).getDtReportingPeriod());
    }
    return youthDetailRetrieveSO;
  }

  private static final String HEAD_START = CodesTables.CSCHGRAD_010;

  private static final String GRADE_PRE_K = CodesTables.CSCHGRAD_020;

  private static final String GRADE_K = CodesTables.CSCHGRAD_030;

  private static final String GRADE_TWO = CodesTables.CSCHGRAD_102;

  private static final String GRADE_THREE = CodesTables.CSCHGRAD_103;

  private static final String GRADE_FOUR = CodesTables.CSCHGRAD_104;

  private static final String GRADE_FIVE = CodesTables.CSCHGRAD_105;

  private static final String GRADE_SIX = CodesTables.CSCHGRAD_106;

  private static final String GRADE_SEVEN = CodesTables.CSCHGRAD_107;

  private static final String GRADE_EIGHT = CodesTables.CSCHGRAD_108;

  private static final String GRADE_NINE = CodesTables.CSCHGRAD_109;

  private static final String GRADE_TEN = CodesTables.CSCHGRAD_110;

  private static final String GRADE_ELEVEN = CodesTables.CSCHGRAD_111;

  private static final String GRADE_TWELVE = CodesTables.CSCHGRAD_112;

  private static final Set<String> ENROLL_GRADES = new HashSet<String>();

  // Statically initialize ENROLL_GRADES HashSet
  static {
    ENROLL_GRADES.add(HEAD_START);
    ENROLL_GRADES.add(GRADE_PRE_K);
    ENROLL_GRADES.add(GRADE_K);
    ENROLL_GRADES.add(GRADE_TWO);
    ENROLL_GRADES.add(GRADE_THREE);
    ENROLL_GRADES.add(GRADE_FOUR);
    ENROLL_GRADES.add(GRADE_FIVE);
    ENROLL_GRADES.add(GRADE_SIX);
    ENROLL_GRADES.add(GRADE_SEVEN);
    ENROLL_GRADES.add(GRADE_EIGHT);
    ENROLL_GRADES.add(GRADE_NINE);
    ENROLL_GRADES.add(GRADE_TEN);
    ENROLL_GRADES.add(GRADE_ELEVEN);
    ENROLL_GRADES.add(GRADE_TWELVE);
  }

}
