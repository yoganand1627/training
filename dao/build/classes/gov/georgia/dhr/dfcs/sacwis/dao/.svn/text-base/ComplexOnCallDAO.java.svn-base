package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexOnCallDAO {
  /**
   * Updates an OnCall row and returns the new dtLastUpdate
   *
   * @param cdOnCallProgram
   * @param cdOnCallType
   * @param dtOnCallStart
   * @param dtOnCallEnd
   * @param idOnCall
   * @param dtLastUpdate
   * @return Date
   */
  Date updateOnCall(String cdOnCallProgram, String cdOnCallType, Date dtOnCallStart, Date dtOnCallEnd, int idOnCall,
                    Date dtLastUpdate);

  /**
   * Updates table OnCall and sets a value to IndOnCallFilled field.
   *
   * @param indOnCallFilled
   * @param idOnCall
   * @param dtLastUpdate
   * @return Date The dtLastUpdate retirved using the idOnCall, after the update operation
   */
  Date updateOnCallByIdOnCallDtLastUpdate(String indOnCallFilled, int idOnCall, Date dtLastUpdate);
}