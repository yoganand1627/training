/**
 * Created on Apr 27, 2007 at 4:03:18 PM by Kapil Aggarwal
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsAuditSI;

/**
 * Upon registering a Client in the CRS System, a new CRS ID is returned.
 * For tracking and audit purposes this ID along with other client information
 * is saved in the ClientAudit Table using this service
 * 
 */
public interface SaveCrsAuditRow {
  /**
   * Create a row in the CrsAudit Table with the newly created Crs ID created
   * in the CRS system using the Crs Registration Web Service
   * 
   * @param crsAuditSI return by the CrsRegistration Web Service upon
   * successful creation of a new Crs Id.
   */
  void saveCrsAuditRow(CrsAuditSI crsAuditSI);
}
