package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD33SO;

public interface SavePreservice {

  /**
   * Description: This service will first loop through all rows sent to the service looking for a "Pre-Service" type
   * row. If one is found, a DAO is called to determine if any preservice training sessions have been previously saved
   * to the database. If not, then PostEvent is called and a ToDo is created which will be associated with the newly
   * created event. Following this processing, any rows which were Added/Updated/Deleted on the window will be
   * Added/Updated/Deleted from the database. FA_INDIV_TRAINING rows.
   *
   * @param cfad33si
   * @return An empty {@link CFAD33SO} object.
   */
  public CFAD33SO savePreservice(CFAD33SI cfad33si);
}
