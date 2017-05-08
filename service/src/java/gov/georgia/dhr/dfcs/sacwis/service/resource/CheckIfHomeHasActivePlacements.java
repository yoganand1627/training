package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

/**
 * @author cwells
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  04/21/10    wcochran  SMS #49517 - Added final variable LGL_STAT_NOT_IN_DFCS_CSTDY_ADO_FINAL. 
 * </pre>
 *
 */
public interface CheckIfHomeHasActivePlacements {
  
  /**
   *  This method is used to determine if the person was 
   *  ever assigned to a specific stage before or currently
   * @param idCase
   * @param idStage
   * @param idPerson
   * @return boolean indicating if USER was ever assigned to case before
   */
  public boolean checkIfHomeHasActivePlacements(int idResource, String cdClosureRsn);
  
  public static final String ADOPTION_SUB_FINAL = "AFN";
  
  public static final String ADOPTION_SUB_NOT_FINAL = "AFS";
  
  public static final String LGL_STAT_NOT_IN_DFCS_CSTDY_ADO_FINAL = CodesTables.CLEGSTAT_NAF;
}