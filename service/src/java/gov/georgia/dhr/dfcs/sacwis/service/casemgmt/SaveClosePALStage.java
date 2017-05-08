package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO;

public interface SaveClosePALStage {

  /**
   * This service will retrieve the Event Status from the EVENT table given the specified ID EVENT.  A row must be
   * retrieved from the PAL and STAGE tables as well.  It will retrieve all the columns from the PAL table given the
   * specified ID STAGE.  If no row exists then an indicator will be set telling the winodw that an ILS Assessment
   * recored has not been completed.  It will also retrieve all the columns from the STAGE table given ID STAGE.  There
   * will only be one event retrieved from the CCMN45D DAO, one record retrieved from the PLA table and one stage
   * retrieved from the CINT21D DAO.  Additionally it will check if the person entering the window is the Primary Worker
   * and will set an indicator accordingly.  The service will also check to see if the yout is over 18 years of age.  If
   * he is then a flag will be set and sent back to the window.  A check will also be done to see if the primary child
   * has been discharged from subcare.  If they have a flag will be set and sent back to the window.  Finally the
   * service will check to see if the worker is a PAL Coordinator.  It will set a flag and sent it back to the window.
   *
   * @param ccfc03si
   * @return CCFC03SO
   */

  public CCFC03SO saveClosePALStage(CCFC03SI ccfc03si);

}
