package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;

public interface RetrieveRelativeCareAssmt {

  /**
   * Retrieves RelativeCareAssessment based on idEvent
   * @param idEvent
   * @return
   */
  public RelativeCareAssessmentBean retrieveRelativeCareAssmt(int idEvent);
}
