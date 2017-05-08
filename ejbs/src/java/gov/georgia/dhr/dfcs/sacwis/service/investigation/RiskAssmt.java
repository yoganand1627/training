package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;

/**
 * This class is the interface for RiskAssmtEjb.
 *
 * @author Jason Rios, October 9, 2002
 */
public interface RiskAssmt {

  /**
   * Retrieve the Risk Assessment details and the data needed to build the Risk Assessment page.
   *
   * @param riskAssmtBean The RiskAssmtValueBean containing the search parameters for the risk assessment.
   * @return returnBean The RiskAssmtValueBean containing the risk assessment details.
   */
  public RiskAssmtValueBean queryRiskAssmt(RiskAssmtValueBean riskAssmtBean);

  /**
   * Retrieve the data needed to build the Risk Assessment page.
   *
   * @param riskAssmtBean The RiskAssmtValueBean to be populated with the data needed to build the RiskAssmt.jsp.
   * @return riskAssmtBean The RiskAssmtValueBean populated with the data needed to build the RiskAssmt.jsp.
   */
  public RiskAssmtValueBean queryPageData(RiskAssmtValueBean riskAssmtBean);

  /**
   * Saves the risk assessment data to the database.
   *
   * @param riskAssmtBeanFromState   The RiskAssmtValueBean containing the data when the page first loaded.
   * @param riskAssmtBeanFromRequest The RiskAssmtValueBean containing the updated data to be saved to the database.
   * @return eventId The event id of the risk assessment.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   */
  public Integer saveRiskAssmt(RiskAssmtValueBean riskAssmtBeanFromState, RiskAssmtValueBean riskAssmtBeanFromRequest)
          throws TimestampMismatchException;

  /**
   * Check the Risk Assessment to see if it is complete.
   *
   * @param beanToCheck The RiskAssmtValueBean containing the risk assessment detail to be checked for completion.
   * @return riskAssmtBeanToCheck The RiskAssmtValueBean passed to the method, but the "completion check" properties are
   *         set based upon the completion status of the risk assessment.
   */
  public RiskAssmtValueBean checkRiskAssmtForCompletion(RiskAssmtValueBean beanToCheck);

  /**
   * Check the Risk Assessment to see if it was created using IRA or IMPACT.
   *
   * @param riskAssmtBean The RiskAssmtValueBean containing the risk assessment search parameters.
   * @return riskAssmtBean The RiskAssmtValueBean populated with the information on whether or not the risk assessment
   *         was created using IRA or IMPACT.
   */
  public RiskAssmtValueBean checkIfRiskAssmtCreatedUsingIRA(RiskAssmtValueBean riskAssmtBean);

  /**
   * @param bean
   * @param categoryCode
   * @param areaCode
   * @param factorCode
   */
  public void setRiskFactorValueBean(RiskFactorValueBean bean, String categoryCode, String areaCode, String factorCode);
  
  /**
   * Retrieve event status code of Family Plan that creates this Risk ReAssessment 
   * @param idEventRra
   * @return
   */
  public String queryFamilyPlanPageMode(int idEventRra);
}