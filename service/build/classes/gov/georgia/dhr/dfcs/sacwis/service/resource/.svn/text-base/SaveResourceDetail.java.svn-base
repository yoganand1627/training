package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04SO;

/**
 * Formats input record and updates the Phone, Address, CAPS Resource and Category tables. If the Resource is of type
 * hotline, then no address records are required. Therefore, the address input message is checked for records, and if
 * none exist and type is hotline, the Address Table DAM is not called
 * 
 * @author amitkumar.m.patel
 */
public interface SaveResourceDetail {

  static final int ZERO = 0;

  /**
   * @param cres04si
   *          {@link CRES04SI} object
   * @return {@link CRES04SO} obj
   */

  CRES04SO saveResourceDetail(CRES04SI cres04si);

}
