package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;

import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;

import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import gov.georgia.dhr.dfcs.sacwis.service.document.CpsAdminReviewDecisionLetterForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CpsAdminReviewDecisionLetterFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CpsAdminReviewDecisionLetterFormSO;

/**
 * CPS Administrative Review Decision Letter Form service Implementation
 * 
 * <pre>
 * Change History:
 *  Date       User      Description
 *  --------   --------  --------------------------------------------------
 * 02/16/2010 hnguyen   Administrative Review Decision Letter Form added 
 * </pre>
 * 
 */

public class CpsAdminReviewDecisionLetterFormImpl extends BaseDocumentServiceImpl implements
                                                                                 CpsAdminReviewDecisionLetterForm {
  private StageDAO stageDAO;

  private StageLinkDAO stageLinkDAO;

  private PersonAddressDAO personAddressDAO;

  private AdminReviewDAO adminReviewDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CpsAdminReviewDecisionLetterFormSO retrieveCPSAdminReviewDecisionLetterForm(
                                                                                     CpsAdminReviewDecisionLetterFormSI cpsAdminReviewDecisionLetterFormSI) {
    CpsAdminReviewDecisionLetterFormSO cpsAdminReviewDecisionLetterFormSO = new CpsAdminReviewDecisionLetterFormSO();

    PreFillData preFillData = new PreFillData();

    int idCase = cpsAdminReviewDecisionLetterFormSI.getUlIdCase();
    int idARIStage = cpsAdminReviewDecisionLetterFormSI.getUlIdStage();
    int idINVStage = stageLinkDAO.findPreviousIdStagebyIdStage(idARIStage);
    int idEvent = cpsAdminReviewDecisionLetterFormSI.getUlIdEvent();
    int idPerson = cpsAdminReviewDecisionLetterFormSI.getUlIdPerson();
    String cdAdRevType = cpsAdminReviewDecisionLetterFormSI.getSzCdAdRevType();

    Stage ARIstage = stageDAO.findStageByIdStage(idARIStage);
    Stage INVstage = stageDAO.findStageByIdStage(idINVStage);

    Person requestor = getPersistentObject(Person.class, idPerson);

    Person reviewer = null;

    PersonAddress requestorAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);
    
    // Requester person may not have an address entered
    if (null == requestorAddress){
      requestorAddress = new PersonAddress();
    }

    AdminReview adminReview = adminReviewDAO.findAdminReviewByIdEvent(idEvent);

    // Generate pre-fill data
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DATE_GENERATED,
                                           FormattingHelper.formatDate(DateHelper.getTodayCastorDate())));
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REQUESTOR_NAME,
                                           FormattingHelper.formatString(requestor.getNmPersonFull())));
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REQUESTOR_ADDR_LN1,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersAddrStLn1())));
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REQUESTOR_ADDR_CITY,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersonAddrCity())));
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REQUESTOR_ADDR_ST,
                                           FormattingHelper.formatString(requestorAddress.getCdPersonAddrState())));
    preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REQUESTOR_ADDR_ZIP,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersonAddrZip())));
    preFillData
               .addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.CASE_ID, FormattingHelper.formatInt(idCase)));
    preFillData.addBookmark(createBookmarkWithCodesTable(CpsAdminReviewDecisionLetterForm.COUNTY,
                                                         FormattingHelper.formatString(INVstage.getCdStageCnty()),
                                                         CodesTables.CCOUNT));

    // First Level Review
    if (FIRST_LVL_REVIEW.equals(cdAdRevType)) {
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.ADM_REV_ONE,
                                             FormattingHelper.formatString("checked")));

      // Get 1st Level review disposition
      if (ArchitectureConstants.N.equals(adminReview.getCd1lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DO_NOT,
                                               FormattingHelper.formatString("checked")));
      } else if (ArchitectureConstants.Y.equals(adminReview.getCd1lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.CASE_DET,
                                               FormattingHelper.formatString("checked")));
      } else if ("A".equals(adminReview.getCd1lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DENIED,
                                               FormattingHelper.formatString("checked")));
      }

      if (ArchitectureConstants.N.equals(ARIstage.getIndStageClose())) {
        // Get assigned Subject Matter Expert for open ARI
        idPerson = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(idARIStage, CodesTables.CROLEALL_PR);
        reviewer = getPersistentObject(Person.class, idPerson);
      } else if (ArchitectureConstants.Y.equals(ARIstage.getIndStageClose())) {
        // Get SME who saved and closed ARI
        reviewer = getPersistentObject(Person.class, adminReview.getId1lSme());
      }
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REVIEWER_NAME,
                                             FormattingHelper.formatString(reviewer.getNmPersonFull())));

    } else if (SECOND_LVL_REVIEW.equals(cdAdRevType)) { // 2nd Level Review
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.ADM_REV_TWO,
                                             FormattingHelper.formatString("checked")));
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REVIEWER_NAME,
                                             FormattingHelper.formatString(adminReview.getTxt2lAarOff())));

      // Get 2nd Level review disposition
      if (ArchitectureConstants.N.equals(adminReview.getCd2lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DO_NOT,
                                               FormattingHelper.formatString("checked")));
      } else if (ArchitectureConstants.Y.equals(adminReview.getCd2lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.CASE_DET,
                                               FormattingHelper.formatString("checked")));
      } else if ("A".equals(adminReview.getCd2lDisp())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DENIED,
                                               FormattingHelper.formatString("checked")));
      }

    } else if (THIRD_LVL_REVIEW.equals(cdAdRevType)) { // 3rd Level review
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.ADM_REV_THREE,
                                             FormattingHelper.formatString("checked")));

      // Get DHS Commissioner/Designee
      if (null == adminReview.getId3lDhsCom() ){
        // User may not have selected a DHS Commissioner/Designee on page yet.
        reviewer = new Person();
      } else {
        reviewer = getPersistentObject(Person.class, adminReview.getId3lDhsCom());
      }
      preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.REVIEWER_NAME,
                                             FormattingHelper.formatString(reviewer.getNmPersonFull())));

      // Get 3rd Level review final decision
      if (ArchitectureConstants.N.equals(adminReview.getCd3lFinDec())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.DO_NOT,
                                               FormattingHelper.formatString("checked")));
      } else if (ArchitectureConstants.Y.equals(adminReview.getCd3lFinDec())) {
        preFillData.addBookmark(createBookmark(CpsAdminReviewDecisionLetterForm.CASE_DET,
                                               FormattingHelper.formatString("checked")));
      }

    }

    cpsAdminReviewDecisionLetterFormSO.setPreFillData(preFillData);

    return cpsAdminReviewDecisionLetterFormSO;
  }
}
