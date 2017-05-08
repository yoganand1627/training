package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.structs.input.NonIncidentAFCARSInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO;

public interface SaveNonIncidentAFCARSInformation {
  /**
   * This service saves Non-Incident AFCARS Information
   * 
   * @param nonIncidentAFCARSInformationSI
   * @return void
   */
  public void saveNonIncidentAFCARSInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI);
}
