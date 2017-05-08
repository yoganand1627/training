package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   08/18/10  hnguyen   MR-067 Added flag to return to conversation
 *                       indicating whether survey is completed
 * 
 */

@SuppressWarnings("serial")
public class YouthReportDetailSaveSO implements Serializable {
  private Boolean indSurveyCompleted;

  public Boolean getIndSurveyCompleted() {
    return indSurveyCompleted;
  }

  public void setIndSurveyCompleted(Boolean indSurveyCompleted) {
    this.indSurveyCompleted = indSurveyCompleted;
  }

}
