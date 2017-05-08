package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC43SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;

public interface RetrieveAdminReview {

  /**
   * If an ID_EVENT is passed into the service: This service will retrieve an entire row from the EVENT table given an
   * ID  EVENT(SSMN45D), retrieve an entire row from the ADMIN REVIEW table given ID EVENT(CSES65D) and check for the
   * presence of the Administrative Review and Appeal Narrative given ID EVENT (CSYS06D).  The service will also
   * retrieve the Admin Rview Program (CINT21D) and if an ID PERSON REQUESTOR exists for the Admin Review record, that
   * person's NmPersonFull will be retrieved (CINV81D).
   * <p/>
   * If no ID EVENT is passed into the service but an ID STAGE is passed in: This service will retrieve an entire row
   * from the ADMIN REVIEW table given ID STAGE (CSES69D), it will retrieve an entire row from the EVENT table given an
   * ID EVENT (CCMN45D), and check for the presence of the Administrative Review and Appeal Narrative given ID EVENT
   * (CSYS06D).  the service will also retrieve the Admin Review Program (CINT21D) and if an ID PERSON REQUESTOR exists
   * for the Admin Review record, that person's NmPersonFull will be retrieved (CINV81D).
   *
   * @param ccfc43si
   * @return {@link CCFC43SO}
   */
  public CCFC43SO retrieveAdminReview(CCFC43SI ccfc43si);
}
