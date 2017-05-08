/**
 * Created on Mar 25, 2006 at 3:03:46 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.OnCall;

public interface OnCallDAO {

  /**
   * Return the date OnCall was last updated for a specified idOnCall
   *
   * @param idOnCall
   * @return Date
   */
  Date findDtLastUpdate(int idOnCall);

  /**
   * Inserts a new OnCall row, returning the new idOnCall primary key
   *
   * @param cdOnCallProgram
   * @param cdOnCallType
   * @param cdOnCallRegion
   * @param cdOnCallCounty
   * @param dtOnCallStart
   * @param dtOnCallEnd
   * @param indOnCallFilled
   * @return int idOnCall
   */
  OnCall insertOnCall(String cdOnCallProgram, String cdOnCallType, String cdOnCallRegion,
                      String cdOnCallCounty, Date dtOnCallStart, Date dtOnCallEnd,
                      String indOnCallFilled);

  /**
   * Updates an OnCall row
   *
   * @param cdOnCallProgram
   * @param cdOnCallType
   * @param dtOnCallStart
   * @param dtOnCallEnd
   * @param idOnCall
   * @param dtLastUpdate
   * @return
   */
  int updateOnCall(String cdOnCallProgram, String cdOnCallType,
                   Date dtOnCallStart, Date dtOnCallEnd,
                   int idOnCall, Date dtLastUpdate);

  /**
   * Updates table OnCall
   * <p/>
   *
   * @param indOnCallFilled
   * @param idOnCall
   * @param dtLastUpdate
   */
  int updateOnCallByIdOnCallDtLastUpdate(String indOnCallFilled, int idOnCall, Date dtLastUpdate);

  /**
   * Deletes an OnCall row
   *
   * @param idOnCall
   * @param dtLastUpdate
   * @return
   */
  int deleteOnCall(int idOnCall, Date dtLastUpdate);
}
