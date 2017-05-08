/**
 * Create a separate service for delete legal status for 2 reasons: (this was created for AFCARS cleanup, MR-074/SMS#81140)
 * 1) There may be much more validation later on before a LS can be deleted, or more clean up after one is deleted
 * having all those logic in one service is cleaner than scattered in the Save service
 * 2) If later decided to remove this functionality, it will be easier
 */
package gov.georgia.dhr.dfcs.sacwis.service.courtprocess;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;

/**
 * @author hong-van.t.vo
 * 11/13/2020
 *
 */
public interface DeleteLegalService {
	
	public static final String SEC_DEL_NAF_LS = "97"; 
	public static final String PERMANENCY_UNIT_PROFILE = "PERMANENCY_UNIT";
	void deleteLegalService(CCMN01UI ccmn01ui);

}
