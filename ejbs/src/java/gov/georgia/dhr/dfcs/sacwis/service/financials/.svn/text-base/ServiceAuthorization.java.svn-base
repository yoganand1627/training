package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.ServiceAuthValueBean;

public interface ServiceAuthorization {
  /**
   * Query the data for the PRN selected.
   *
   * @param serviceAuthBean
   * @return String The Legal Status with the max DT_LEGAL_STAT_STATUS_DT for the selected PRN.
   */
  public String findLegalStatusForChild(ServiceAuthValueBean serviceAuthBean);

  /**
   * Query the data for the PRN  and Resource selected.
   *
   * @param serviceAuthBean
   * @return String The placement with the max start date for the selected PRN and Resource.
   */
  public String findPlacementWithGreatestStartDate(ServiceAuthValueBean serviceAuthBean);
}