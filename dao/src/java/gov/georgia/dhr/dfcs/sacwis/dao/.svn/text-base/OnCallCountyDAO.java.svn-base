/**
 * Created on Mar 25, 2006 at 3:04:00 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty;

public interface OnCallCountyDAO {
  /**
   * The purpose of this is to retrieve a full row (except IND_ON_CALL_FILLED) of the ON_CALL table (that is:
   * CD_ON_CALL_COUNTY, CD_ON_CALL_PROGRAM, CD_ON_CALL_TYPE, DT_ON_CALL_START, DT_ON_CALL_END, ID_ON_CALL) based on a
   * given CD_ON_CALL_COUNTY, and a given CD_ON_CALL_PROGRAM, and the current date and time (thereby determining which
   * On-Call Shift/Block we are currently 'in' right now, for the County and Program given).
   * <p/>
   * The ID_ON_CALL retrieved from this will be passed into another method to retrieve all employees assigned to that
   * particular ID_ON_CALL, and those employees will be listed in the Available Staff ListBox on the Assign window.
   * <p/>
   * The other information retrieved from this (CD_ON_CALL_COUNTY, CD_ON_CALL_PROGRAM, CD_ON_CALL_TYPE,
   * DT_ON_CALL_START, DT_ON_CALL_END) will be stored in the WCD of the Assign window and would only be used if the user
   * chooses the Options->On-Call Detail... menu item.
   *
   * @param cdOnCallProgram
   * @param cdOnCallCounty
   * @param dtOnCallStart
   * @return return keys cdOnCallRegion, cdOnCallCounty, cdOnCallProgram, cdOnCallType, dtOnCallStart, dtOnCallEnd,
   *         idOnCall
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findOnCallCountyByCdOnCallProgramCdOnCallCountyDtOnCallStart(String cdOnCallProgram, String cdOnCallCounty,
                                                                   Date dtOnCallStart);

  /**
   * This retreives rows from on_call_county table.
   *
   * @param idOnCallCounty
   * @param cdOnCallRegion
   * @return keys cdOnCallCounty, dtLastUpdate
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findOnCallCountyByIdOnCallCountyCdOnCallRegion(int idOnCallCounty, String cdOnCallRegion);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty} object to the database.
   *
   * @param onCallCounty A populated {@link gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty} object.
   */
  void saveOnCallCounty(OnCallCounty onCallCounty);

  /**
   * Delete rows from OnCallCounty based on idOnCall.
   *
   * @param idOnCall
   * @return The number of rows deleted.
   */
  int deleteOnCallCounty(int idOnCall);

}
