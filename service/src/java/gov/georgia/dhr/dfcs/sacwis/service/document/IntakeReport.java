/**
 * Created on Aug 8, 2006 at 10:47:36 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT39SO;

public interface IntakeReport extends DocumentService {
  public CINT39SO retrieveIntakeReport(CINT39SI cint39si);
}
