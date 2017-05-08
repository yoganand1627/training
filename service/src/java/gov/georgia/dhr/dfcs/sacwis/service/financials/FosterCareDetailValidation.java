package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;

public interface FosterCareDetailValidation {

  /**
   * This service will retrieve the name of a person from the PERSON table given the ID PERSON.  Additionally, the
   * service will retrieve the ACCLAIM NBR from the RESOURCE table given the ID RESOURCE.  Indicators will be passed in
   * to determine which DAO to call- one or both
   *
   * @param cfin08si
   * @return CFIN08SO
   */
  CFIN08SO retrieveFosterCareDetailValidation(CFIN08SI cfin08si);
}
