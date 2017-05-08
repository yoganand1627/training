package gov.georgia.dhr.dfcs.sacwis.dao.workload;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

public class CFMgmntValueBean extends BaseValueBean {

  private static final String TRACE_TAG = "CFMgmntValueBean";
  private static final long serialVersionUID = 5318727280029640019L;

  private int caseId = 0;
  private String locatingInformation = null;
  private List locatingInfo;

  /**
   * Constructor that build the bean from caseId
   *
   * @param caseId
   */
  public CFMgmntValueBean(int caseId) {
    this.setCaseId(caseId);
  }

  public void setLocatingInformation(String locatingInformation) {
    this.locatingInformation = locatingInformation;
  }

  public String getLocatingInformation() {
    return locatingInformation;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getCaseId() {
    return caseId;
  }

  public List getLocatingInfo() {
    return locatingInfo;
  }

  public void setLocatingInfo(List locatingInfo) {
    this.locatingInfo = locatingInfo;
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the database
   *
   * @param results ResultSet object
   * @throws DaoException
   */
  public CFMgmntValueBean(ResultSet results) throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");
    try {
      // Set the following bean properties to the corresponding values retrieved
      // from the database only if the values from the database are not null.
      if (results.getString(CFMgmntListDao.ID_CASE_FILE_CASE_COLUMN) != null) {
        int caseId = Integer.parseInt(results.getString(CFMgmntListDao.ID_CASE_FILE_CASE_COLUMN));
        this.setCaseId(caseId);
      }
      if (results.getString(CFMgmntListDao.TXT_CASE_FILE_LOCATE_INFO_COLUMN) != null) {
        this.setLocatingInformation(results.getString(CFMgmntListDao.TXT_CASE_FILE_LOCATE_INFO_COLUMN));
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception while setting results from DAO to CFMgmntValueBean.");
      GrndsTrace.msg(TRACE_TAG, 7, "SQLException message 1 " + e.getMessage());
      GrndsTrace.msg(TRACE_TAG, 7, "SQLException code " + e.getErrorCode());
      throw new DaoException("Exception translating ResultSet to CFMgmntValueBean", e, 7);
    }
    GrndsTrace.exitScope();
  }
}