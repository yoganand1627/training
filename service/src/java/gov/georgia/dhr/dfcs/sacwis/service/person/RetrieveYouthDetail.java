/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;

/**
 * @author hong.van.t.vo
 *
 */
public interface RetrieveYouthDetail {
  public YouthDetailRetrieveSO retrieveYouthDetail(YouthDetailRetrieveSI youthDetailRetrieveSI);

}
