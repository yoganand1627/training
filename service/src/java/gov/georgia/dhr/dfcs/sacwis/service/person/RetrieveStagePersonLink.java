package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.StagePersonLinkRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO;

/**
 * 
 * <pre>
 *   Change History:
 *   Date        User      Description
 *   ----------  --------  --------------------------------------------------
 *   05/21/2011  hnguyen   SMS#109407: MR-087 Initial Creation
 *                       
 * 
 */

/**
 * Method to retrieve a list of stage person links for stage id specified in the SI.
 * 
 */
public interface RetrieveStagePersonLink {
  StagePersonLinkSO retrieveStagePersonLink(StagePersonLinkRetrieveSI si);
}
