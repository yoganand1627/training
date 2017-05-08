/**
 * Created on Mar 25, 2006 at 3:35:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;

public interface RiskAssessmentDAO {
  /**
   * Returns a count of the Risk Factor records that have CdRiskFactor = host and idStage = host. <p/>
   *
   * @param cdRiskAssmtRiskFind
   * @param idStage
   * @return See description.
   */
  long countRiskAssessment(String cdRiskAssmtRiskFind, int idStage);

  /**
   * This will retrieve RiskAssessment given idStage and cdTask.
   *
   * @param idStage
   * @param cdTask
   * @return A Map with keys idEvent, cdEventStatus, indRiskAssmtIntranet
   */
  Map findRiskAssessmentByIdStageCdTask(int idStage, String cdTask);

  /**
   * This will retrieve a row from RISK ASSESSMENT table given idEvent.
   *
   * @param idEvent
   * @return RiskAssessment by idEvent
   */
  RiskAssessment findRiskAssessmentByIdEvent(int idEvent);

  /**
   * Retrieves a row by querying RiskAssessment and RiskFactors tables for a given idStage. (retrieves allegation
   * information as well as cdRiskFactorCateg from the RiskFactor table)
   *
   * @param idStage
   * @return Object[]
   */
  Object[] findRiskAssessmentRiskFactorByIdStage(int idStage);

  /**
   * This will retrieve a row from RISK ASSESSMENT table given idStage.
   *
   * @param idStage
   * @return RiskAssessment by idStage
   */
  String findIndRiskAssmtIntranetByIdStage(int idStage);

  /**
   * This will retrieve the latest Risk Assessment for the  RISK ASSESSMENT table given idStage.
   *
   * @param idStaged
   * @return RiskAssessment by idStage
   */
  RiskAssessment findRiskAssessmentLatestByIdStage(int idStage);
  
  
  /**
   *  This will retrieve the latest Risk Assessment for the  RISK ASSESSMENT table given idCase.
   * @param idCase
   * @return RiskAssessment by idCase
   */
  public RiskAssessment findCompRiskAssessmentLatestByIdCase(int idCase);

 /**
 * 
 * @param idStage
 * @return
 */
  public RiskAssessment findCompRiskAssessmentLatestByIdStage(int idStage) ;
}
