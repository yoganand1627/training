package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
/**
 * Interface for Caretaker Information page.
 * @author lata.p.lokhande
 * Date: 04/05/2007
 */
public interface RetrieveCaretakerInformation {
  
  /**
   * Retrieve service for Caretaker Information page. It retrievs the data from Caps_resource and Caps_Carataker tables.
   * by resource Id and populates the output RetrieveSO object: CRES18SO.
   * 
   * @param cres18SI
   * @return
   */
  public CRES18SO retrieveCaretakerInformation(CRES18SI cres18SI);
   
}
