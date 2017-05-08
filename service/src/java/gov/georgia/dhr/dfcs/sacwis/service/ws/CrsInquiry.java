/**
 * Created on Mar 28, 2007 by Kapil Aggarwal, SACWIS Project
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsInquirySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsInquirySO;

public interface CrsInquiry {
  
  CrsInquirySO performCrsInquiry(CrsInquirySI crsInquirySI);

}
