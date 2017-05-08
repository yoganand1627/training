package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListMUpdOutRec;

public interface SaveCallPersonList {

  /**
   * Person List Multiple Update service Updates common information for rows selected on the Call Person List.
   *
   * @param cint35si
   * @return PersListMUpdOutRec
   */
  PersListMUpdOutRec saveCallPersonList(MUpdInRec cint35si);
}
