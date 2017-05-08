package gov.georgia.dhr.dfcs.sacwis.service.financials;

import java.sql.Connection;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.ServiceAuthDao;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.ServiceAuthValueBean;

/**
 * The session Bean class for the ServicAuthEjb.
 * <pre>
 * Change History: Date      User           Description
 * --------  ------------- ---------------------------------------------------
 * 08/11/05  thompswa       SIR 23662 - Data query for child's legal status and placement led to bean create for SIR.
 * </pre>
 *
 * @author Wes Thompson, 08/11/2005
 */
public class ServiceAuthorizationBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "ServiceAuthorizationBean";

  /**
   * Query the data for the PRN selected.
   *
   * @param serviceAuthBean has idPerson.
   * @return String The Legal Status with the max DT_LEGAL_STAT_STATUS_DT for the selected PRN.
   */
  public String findLegalStatusForChild(ServiceAuthValueBean serviceAuthBean) {
    Connection connection = null;
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".findLegalStatusForChild");
      connection = JdbcHelper.getConnection();
      int idPerson = serviceAuthBean.getPersonId();
      String legalStatusCode = "";
      ServiceAuthDao serviceAuthDao = new ServiceAuthDao(connection);
      Map legalStatusRow = serviceAuthDao.queryLegalStatusForChild(idPerson);
      if (legalStatusRow != null && legalStatusRow.get(ServiceAuthDao.STATUS_CODE_COLUMN) != null) {
        legalStatusCode = (String) legalStatusRow.get(ServiceAuthDao.STATUS_CODE_COLUMN);
      }
      return legalStatusCode;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }

  /**
   * Query the data for the PRN  and Resource selected.
   *
   * @param serviceAuthBean has idPerson.
   * @return String The placement with the max start date for the selected PRN and Resource.
   */
  public String findPlacementWithGreatestStartDate(ServiceAuthValueBean serviceAuthBean) {
    Connection connection = null;
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".findPlacementWithGreatestStartDate");
      connection = JdbcHelper.getConnection();
      int idPerson = serviceAuthBean.getPersonId();
      String livingArrangement = "";
      ServiceAuthDao serviceAuthDao = new ServiceAuthDao(connection);
      Map placementRow = serviceAuthDao.queryPlacementWithGreatestStartDate(idPerson);
      if (placementRow != null && placementRow.get(ServiceAuthDao.LIVING_ARRANGEMENT_COLUMN) != null) {
        livingArrangement = (String) placementRow.get(ServiceAuthDao.LIVING_ARRANGEMENT_COLUMN);
      }
      return livingArrangement;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
}