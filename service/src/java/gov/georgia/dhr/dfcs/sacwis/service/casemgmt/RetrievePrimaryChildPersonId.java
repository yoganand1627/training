package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;

public interface RetrievePrimaryChildPersonId {

 /**
   * This Service calls a DAO to retrieve associated Person Id.
   * 
   * @param Stage
   *          Id object
   * @return Person Id.
   */
  public int retrievePrimaryChildPersonId(int StageId);
}
