package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

/** @todo add javadocs */

/**
 * Holds all data pertaining to a Risk Assessment Prior History Report/Screening.
 * 
 * @author Nandita Hegde, October 12th, 2006
 */
public class RiskAssmtPriorHistoryValueBean extends BaseValueBean {
  // instance variables

  private int eventId;

  private Date dateOfReport;

  private Date dateOfClosure;

  private String indChildHistoryReport;

  private String findingHistoryReport;

  private Date lastUpdateDate;

  private int riskHistoryReportId;
  
  public static final int RISK_ASSESSMENT_DATA = 1;

  // Tracing
  private static final String TRACE_TAG = "RiskAssmtPriorHistoryValueBean";

  /** Constructor */
  public RiskAssmtPriorHistoryValueBean() {
    eventId = 0;
    dateOfReport = null;
    dateOfClosure = null;
    indChildHistoryReport = null;
    lastUpdateDate = null;
    findingHistoryReport = null;
    riskHistoryReportId = 0;

  }

  public RiskAssmtPriorHistoryValueBean(int eventId) {
    this();
    this.setEventId(eventId);
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the database.
   * 
   * @param results
   *          The ResultSet object.
   * @throws DaoException
   */
  public RiskAssmtPriorHistoryValueBean(ResultSet results) throws DaoException {
    this();
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    try {
     
      //this.setEventId(results.getInt(RiskAssmtDAO.EVENT_ID_COLUMN));
       this.setRiskHistoryReportId(results.getInt(RiskAssmtDAO.RISK_HISTORY_REPORT_ID_HISTORY_REPORT));
        
      if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_CLOSURE_COLUMN) != null) {
        this.setDateOfClosure(results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_CLOSURE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_REPORT_COLUMN) != null) {
        this.setDateOfReport(results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_REPORT_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_CHLD_DEATH_INJ_COLUMN) != null) {
        this.setIndChildHistoryReport(results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_CHLD_DEATH_INJ_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_SUMMARY_COLUMN) != null) {
        this.setFindingHistoryReport(results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_SUMMARY_COLUMN));
      }
      if (results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DT_LAST_UPDATE) != null) {
        this.setLastUpdateDate(results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DT_LAST_UPDATE));
      } 
      
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to RiskAssmtPriorHistoryValueBean.");
      throw new DaoException("Exception translating ResultSet to RiskAssmtPriorHistoryValueBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  public int getEventId() {
    return eventId;
  }

  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  public Date getDateOfClosure() {
    return dateOfClosure;
  }

  public Date getDateOfReport() {
    return dateOfReport;
  }

  public String getIndChildHistoryReport() {
    return indChildHistoryReport;
  }

  public String getFindingHistoryReport() {
    return findingHistoryReport;
  }

  public int getRiskHistoryReportId() {
    return riskHistoryReportId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public void setDateOfReport(Date dateOfReport) {
    this.dateOfReport = dateOfReport;
  }

  public void setDateOfClosure(Date dateOfClosure) {
    this.dateOfClosure = dateOfClosure;
  }

  public void setIndChildHistoryReport(String indChildHistoryReport) {
    this.indChildHistoryReport = indChildHistoryReport;
  }

  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public void setFindingHistoryReport(String findingHistoryReport) {
    this.findingHistoryReport = findingHistoryReport;
  }

  public void setRiskHistoryReportId(int riskHistoryReportId) {
    this.riskHistoryReportId = riskHistoryReportId;
  }

}
