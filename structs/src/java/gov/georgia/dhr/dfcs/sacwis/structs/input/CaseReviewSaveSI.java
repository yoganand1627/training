package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * POJO that sends the variables to the database to update Case Review Information
 *
 * @author  Bhavna Gehlot March 16 , 2009
 */
public class CaseReviewSaveSI implements Serializable {
  protected int idCaseReview = 0;
  protected int idCsrEvent = 0;
  protected int idCaseManager = 0;
  protected int idStage = 0;
  protected int idCase = 0;
  protected Date dtDtReview = null;
  protected Date dtLastUpdate = null;
  protected String szTxtSummaryComment = null;
  protected Date dtDtStaffedWithWorker = null;
  protected Date dtDtCorrectionDue = null;
  protected Date dtDtCorrectionComplete = null;
  protected String cdReqFuncCd = null;
  protected String cdReviewType = null;
  protected String cdStage = null;
  protected String indComplete = null;
  protected int idReviewer = 0;
  protected Boolean indTodoDelete = Boolean.FALSE;
  protected int idTodo = 0;
  protected boolean indCaseReviewComplete = false;
  protected int idCaseWorker = 0;
  protected ROWCCMN01UIG00 rowccmn01uig00 = null;
  protected ROWCCMN01UIG01_ARRAY rowccmn01uig00_array = null;
  protected List<CaseReviewQuestionsSO> caseReviewQuestionsList = null;
  protected String[] checkedCheckboxes = null;
  protected int cdVersion = 0;
  protected Date dtDtReviewComplete = null;

  public int getIdCaseReview() {
    return idCaseReview;
  }

  public void setIdCaseReview(int idCaseReview) {
    this.idCaseReview = idCaseReview;
  }
  
  public int getIdCsrEvent() {
    return idCsrEvent;
  }

  public void setIdCsrEvent(int idCsrEvent) {
    this.idCsrEvent = idCsrEvent;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }
  
  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public Date getDtDtReview() {
    return dtDtReview;
  }

  public void setDtDtReview(Date dtDtReview) {
    this.dtDtReview = dtDtReview;
  }

 
  public String getSzTxtSummaryComment() {
    return szTxtSummaryComment;
  }

  public void setSzTxtSummaryComment(String szTxtSummaryComment) {
    this.szTxtSummaryComment = szTxtSummaryComment;
  }
  
  public Date getDtDtStaffedWithWorker() {
    return dtDtStaffedWithWorker;
  }

  public void setDtDtStaffedWithWorker(Date dtDtStaffedWithWorker) {
    this.dtDtStaffedWithWorker = dtDtStaffedWithWorker;
  }
  
  public Date getDtDtCorrectionDue() {
    return dtDtCorrectionDue;
  }

  public void setDtDtCorrectionDue(Date dtDtCorrectionDue) {
    this.dtDtCorrectionDue = dtDtCorrectionDue;
  }
  
  public Date getDtDtCorrectionComplete() {
    return dtDtCorrectionComplete;
  }

  public void setDtDtCorrectionComplete(Date dtDtCorrectionComplete) {
    this.dtDtCorrectionComplete = dtDtCorrectionComplete;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  
  public String getCdReviewType() {
    return cdReviewType;
  }

  public void setCdReviewType(String cdReviewType) {
    this.cdReviewType = cdReviewType;
  }
  
  public String getCdStage() {
    return cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }
  
  public String getIndComplete() {
    return indComplete;
  }

  public void setIndComplete(String indComplete) {
    this.indComplete = indComplete;
  }
  
  public int getIdReviewer() {
    return idReviewer;
  }

  public void setIdReviewer(int idReviewer) {
    this.idReviewer = idReviewer;
  }
  
  public Boolean getIndTodoDelete() {
    return indTodoDelete;
  }

  public void setIndTodoDelete(Boolean indTodoDelete) {
    this.indTodoDelete = indTodoDelete;
  }
  
  public int getIdTodo() {
    return idTodo;
  }

  public void setIdTodo(int idTodo) {
    this.idTodo = idTodo;
  }
  
  public boolean getIndCaseReviewComplete() {
    return indCaseReviewComplete;
  }

  public void setIndCaseReviewComplete(boolean indCaseReviewComplete) {
    this.indCaseReviewComplete = indCaseReviewComplete;
  }
  
  public int getIdCaseWorker() {
    return idCaseWorker;
  }

  public void setIdCaseWorker(int idCaseWorker) {
    this.idCaseWorker = idCaseWorker;
  }

  public ROWCCMN01UIG00 getROWCCMN01UIG00() {
    return rowccmn01uig00;
  }

  public void setROWCCMN01UIG00(ROWCCMN01UIG00 rowccmn01uig00) {
    this.rowccmn01uig00 = rowccmn01uig00;
  }

  public ROWCCMN01UIG01_ARRAY getROWCCMN01UIG01_ARRAY() {
    return rowccmn01uig00_array;
  }

  public void setROWCCMN01UIG01_ARRAY(ROWCCMN01UIG01_ARRAY rowccmn01uig00_array) {
    this.rowccmn01uig00_array = rowccmn01uig00_array;
  }
  
  public List<CaseReviewQuestionsSO> getCaseReviewQuestionsList() {
    return caseReviewQuestionsList;
  }

  public void setCaseReviewQuestionsList(List<CaseReviewQuestionsSO> caseReviewQuestionsList) {
    this.caseReviewQuestionsList = caseReviewQuestionsList;
  }
  
  public String[] getCheckedCheckboxes() {
    return checkedCheckboxes;
  }

  public void setCheckedCheckboxes(String[] checkedCheckboxes) {
    this.checkedCheckboxes = checkedCheckboxes;
  }
  
  public int getCdVersion() {
    return cdVersion;
  }

  public void setCdVersion(int cdVersion) {
    this.cdVersion = cdVersion;
  }
  
  public Date getDtDtReviewComplete() {
    return dtDtReviewComplete;
  }

  public void setDtDtReviewComplete(Date dtDtReviewComplete) {
    this.dtDtReviewComplete = dtDtReviewComplete;
  }
}
