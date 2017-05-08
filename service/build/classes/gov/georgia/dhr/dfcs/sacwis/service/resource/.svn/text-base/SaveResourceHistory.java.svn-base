package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;

public interface SaveResourceHistory {

  /**
   * This service will first create a non-navigational "Home history altered" event. It will then call a DAM to
   * add/update/delete a resource_history row.
   * <p/>
   * If the facility LOC for home has changed (was previously a basic group and now contain atleast one of the
   * following: habitative, therapeutic, or medical needs - or - previously contained one of the three aforementioned
   * types and is now only a basic or group), all facility loc rows will be deleted for this resource and the LOC
   * history will be rebuilt.
   * <p/>
   * If any foster home type has been added or deleted, the primary (or historical, if the child stage has been closed)
   * worker for each child placed in the home during this period will receive a ToDo alerting them of the change.
   * <p/>
   *
   * @param cfad14si {@link CFAD14SI} object
   * @return {@link CFAD14SO} object
   */
  public CFAD14SO audResourceHistory(CFAD14SI cfad14si);
}
