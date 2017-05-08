/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CaseWatchFactorHelp;
import java.util.List;
import java.util.Map;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * @author Patrick Coogan
 *
 */
public interface CaseWatchFactorHelpDAO {
  /**
   * This selects a list of case warnings for a stage.
   *
   * @param idStage
   * @return List<CwCaseWarnings>
   */
  List<CaseWatchFactorHelp> findHelpText();
  
  /**
   * This helper method leverages oracle to find differences in dates
   * by actual and business days.
   *
   * @param String dtStart in date/time format
   * @param String dtEnd in date/time format
   * @return Map
   */
  Object[] findDateDifferences(String dtStart, String dtEnd);
  
}
