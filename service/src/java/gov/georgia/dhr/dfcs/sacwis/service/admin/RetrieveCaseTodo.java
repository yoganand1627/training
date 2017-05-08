package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN12SO;

public interface RetrieveCaseTodo {

  /**
   * Retrieve all the Todo list for a certain case within a given time range. If the start date and end date for that
   * range is not specified, add 7 days to today's date and consider it as the end date
   *
   * @param ccmn12si
   * @return {@link CCMN12SO }
   */
  public CCMN12SO retrieveCaseTodo(CCMN12SI ccmn12si);
}
