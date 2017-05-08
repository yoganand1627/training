package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;

import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;

import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import gov.georgia.dhr.dfcs.sacwis.service.document.ResponseToCaseReviewRequestForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ResponseToCaseReviewRequestFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ResponseToCaseReviewRequestFormSO;

/**
 * Response To Case Review Request service Implementation
 * 
 * <pre>
 * Change History:
 *  Date       User      Description
 *  --------   --------  --------------------------------------------------
 * 02/10/2010 hnguyen   Response to Case Review Request Form added 
 * </pre>
 * 
 */
public class ResponseToCaseReviewRequestFormImpl extends BaseDocumentServiceImpl implements
                                                                                ResponseToCaseReviewRequestForm {

  private PersonDAO personDAO;

  private StageDAO stageDAO;

  private StageLinkDAO stageLinkDAO;

  private PersonAddressDAO personAddressDAO;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public ResponseToCaseReviewRequestFormSO retrieveResponseToCaseReviewRequestForm(
                                                                                   ResponseToCaseReviewRequestFormSI responseToCaseReviewRequestFormSI) {
    ResponseToCaseReviewRequestFormSO responseToCaseReviewRequestFormSO = new ResponseToCaseReviewRequestFormSO();

    PreFillData preFillData = new PreFillData();

    int idARIStage = responseToCaseReviewRequestFormSI.getUlIdStage();
    int idINVStage = stageLinkDAO.findPreviousIdStagebyIdStage(idARIStage);
    int idPerson = responseToCaseReviewRequestFormSI.getUlIdPerson();

    Stage stage = stageDAO.findStageByIdStage(idINVStage);

    Person requestor = getPersistentObject(Person.class, idPerson);

    PersonAddress requestorAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);

    // Generate pre-fill data
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.DATE_GENERATED,
                                           FormattingHelper.formatDate(DateHelper.getTodayCastorDate())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_NAME,
                                           FormattingHelper.formatString(requestor.getNmPersonFull())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_ADDR_LN1,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersAddrStLn1())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_ADDR_LN2,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersAddrStLn2())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_ADDR_CITY,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersonAddrCity())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_ADDR_ST,
                                           FormattingHelper.formatString(requestorAddress.getCdPersonAddrState())));
    preFillData.addBookmark(createBookmark(ResponseToCaseReviewRequestForm.REQUESTOR_ADDR_ZIP,
                                           FormattingHelper.formatString(requestorAddress.getAddrPersonAddrZip())));
    preFillData.addBookmark(createBookmarkWithCodesTable(ResponseToCaseReviewRequestForm.COUNTY,
                                                         FormattingHelper.formatString(stage.getCdStageCnty()),
                                                         CodesTables.CCOUNT));

    responseToCaseReviewRequestFormSO.setPreFillData(preFillData);

    return responseToCaseReviewRequestFormSO;
  }
}
