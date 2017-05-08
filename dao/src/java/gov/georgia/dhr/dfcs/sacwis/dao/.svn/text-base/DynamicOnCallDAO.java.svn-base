/**
 * Created on Apr 22, 2006 at 3:27:38 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicOnCallDAO {
  /**
   * The purpose of this dam (ccmn16dQUERYdam) is to retrieve a full row of the ON_CALL table (that is:
   * CD_ON_CALL_COUNTY, CD_ON_CALL_PROGRAM, CD_ON_CALL_TYPE, DT_ON_CALL_START, DT_ON_CALL_END, ID_ON_CALL,
   * IND_ON_CALL_FILLED, DT_LAST_UPDATE) based on dynamic input.
   * <p/>
   * The input must contain CD_ON_CALL_COUNTY and CD_ON_CALL_PROGRAM and may contain CD_ON_CALL_TYPE, DT_ON_CALL_START
   * or DT_ON_CALL_END.
   * <p/>
   * The output will be object arrays containing:
   * <pre>
   * String cdOnCallRegion = szCdOnCallRegion = row[0];
   * String cdOnCallProgram = szCdOnCallProgram = row[1];
   * String cdOnCallType = szCdOnCallType = row[2];
   * Date dtOnCallStart = dtDtOnCallStart = row[3];
   * Date dtOnCallEnd = dtDtOnCallEnd = row[4];
   * int idOnCall = ulIdOnCall = row[5];
   * String indOnCallFilled = bIndOnCallFilled = row[6];
   * Date dtLastUpdate = dtDtLastUpdate = row[7];
   * long countOfCounty = countOfCounty = row[8];
   * </pre>
   *
   * @param cdOnCallCounty
   * @param cdOnCallProgram
   * @param cdOnCallType
   * @param dtOnCallStart
   * @param dtOnCallEnd
   * @return See description above.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  PaginatedHibernateList<Object[]> findOnCall(String[] cdOnCallCounty, String cdOnCallProgram, String cdOnCallType,
                                              Date dtOnCallStart, Date dtOnCallEnd,
                                              int pageNbr, int pageSize) throws ServiceException;
  
  PaginatedHibernateList<Object[]> findOnCallwDate(String[] cdOnCallCounty, String cdOnCallProgram, String cdOnCallType,
                                              Date dtOnCallStart, Date dtOnCallEnd, Date currentDate,
                                              int pageNbr, int pageSize) throws ServiceException;
  
  
}

