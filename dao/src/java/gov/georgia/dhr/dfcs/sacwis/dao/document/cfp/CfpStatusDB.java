package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Value Object which encapsulates a row in cfp_status table */
public class CfpStatusDB implements Serializable {
  private static final long serialVersionUID = 7449135968863990718L;

  protected static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

  public static final String SUBMITTED = "0";
  public static final String IN_PROGRESS = "1";
  public static final String ERROR = "2";
  public static final String COMPLETE = "3";

  protected int statusId = 0;
  protected int caseId = 0;
  protected int stageId = 0;
  protected int personId = 0;
  protected Date lastUpdatedDate = null;
  protected Date submissionTimeDate = null;
  protected Date completionTimeDate = null;
  protected String status = null;
  protected String progress = null;
  protected String path = null;
  protected String errorDescription = null;

  protected String staffName = null;
  protected String caseName = null;
  protected String stageCode = null;

  /** "Decodes" status */
  public String getDescriptiveStatus() {
    if (status.equals(SUBMITTED)) {
      return "Submitted";
    }
    if (status.equals(IN_PROGRESS)) {
      return "In Progress";
    }
    if (status.equals(ERROR)) {
      return "Error";
    }
    if (status.equals(COMPLETE)) {
      return "Complete";
    }
    return "Bad";
  }

  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getLastUpdated() {
    return formatDate(lastUpdatedDate);
  }

  public Date getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  public void setLastUpdatedDate(Date lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public String getSubmissionTime() {
    return formatDate(submissionTimeDate);
  }

  public Date getSubmissionTimeDate() {
    return submissionTimeDate;
  }

  public void setSubmissionTimeDate(Date submissionTimeDate) {
    this.submissionTimeDate = submissionTimeDate;
  }

  public String getCompletionTime() {
    return formatDate(completionTimeDate);
  }

  public Date getCompletionTimeDate() {
    return completionTimeDate;
  }

  public void setCompletionTimeDate(Date completionTimeDate) {
    this.completionTimeDate = completionTimeDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getProgress() {
    return progress;
  }

  public void setProgress(String progress) {
    this.progress = progress;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public String getStageCode() {
    return stageCode;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }

  /** status is Submitted? */
  public boolean isSubmitted() {
    return (status.equals(SUBMITTED));
  }

  /** status is In Progress? */
  public boolean isInProgress() {
    return (status.equals(IN_PROGRESS));
  }

  /** status is Complete? */
  public boolean isComplete() {
    return (status.equals(COMPLETE));
  }

  /** status is Error? */
  public boolean isError() {
    return (status.equals(ERROR));
  }

  /** Format dates for display */
  protected static String formatDate(Date date) {
    if (date == null) {
      return "";
    }
    return dateFormat.format(date);
  }
}
