package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO;

public interface SaveEligibility {
  
  /**
   * Description: service will perform a validation to ensure that the stage is not closed or 
   * being changed by another user. Then it will add to or update the Event table and Event
   * Person link table using the post event function.  If the Event status is complete, all 
   * related To_Do's will have completed date updated.  It will also add to or update the
   * Eligibility table.  Upon a successful add or update, it will retrieve the Eligibility 
   * record and call the To-Do function.
   * 
   * @param csub19si {@link CSUB19SI} object
   * @return {@link CSUB19SO} object
   */
  public CSUB19SO saveEligibility(CSUB19SI csub19si);
}
