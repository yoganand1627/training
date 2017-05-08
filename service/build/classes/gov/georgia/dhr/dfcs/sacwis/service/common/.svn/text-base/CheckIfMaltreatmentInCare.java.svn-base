package gov.georgia.dhr.dfcs.sacwis.service.common;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ---------------------------------------------------------
 * 05/10/10  hjbaptiste               Initial creation
 * 01/20/12  habraham                 STGAP00017829 - MR-097 : Unsubstantiated MIC - The method signature for the checkIfMaltreatmentInCare 
 *                         			  to the Common bean has changed
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste May 10, 2010
 */

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfMaltreatmentInCareSI;

public interface CheckIfMaltreatmentInCare {

  /**
   * <pre>
   * Checks to see if the date of alleged incident of an allegation falls within an 'In Custody' period for
   * the victim. The following Legal Statuses are being used to determine Maltreatment in Care:
   * 
   *  PCT - Permanent Court
   *  PVL - Permanent Voluntary
   *  TCT - Temporary Court
   *  JCP - Joint Commitment with DJJ - Permanent Court
   *  JCT - Joint Commitment with DJJ - Temporary Court
   *  NCS - Not in DFCS Custody - Custody with Other State 
   *  <br>
   * @param checkIfMaltreatmentInCareSI
   * @return Map<String,Boolean>
   * </pre>
   */
	Map<String,Boolean> checkIfMaltreatmentInCare (CheckIfMaltreatmentInCareSI checkIfMaltreatmentInCareSI);
}
