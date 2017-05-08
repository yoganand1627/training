package gov.georgia.dhr.dfcs.sacwis.service.document;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.AbuseNeglectReportDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.AdoptionAssistanceEligibilityDocumentationDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CannotDeleteCfpException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentGenerationMetaDataDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.FAHomeClosingSummaryDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.MedicalMentalAssessmentDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ReportDataDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;

/**
 * Cfp SessionBean implementation. Wraps calls to CfpDao, DocumentTypeDao, and ReportDataDao For each method, gets the
 * connection calls the method closes the connection
 */
public class CfpBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "CfpBean";

  /** Delegates to MedicalMentalAssessmentDao */
  public List<Map<String, Object>> getMedicalMentalEventPrincipalPairs(int caseId, int stageId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getMedicalMentalEventPrincipalPairs");
    Connection connection = null;
    try {
      connection = getConnection();
      MedicalMentalAssessmentDao dao = new MedicalMentalAssessmentDao(connection);
      return dao.getMedicalMentalEventPrincipalPairs(caseId, stageId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to FAHomeClosingSummaryDao */
  public List getFAHomeClosingSummaryEventIds(int caseId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getFAHomeClosingSummaryEventIds");
    Connection connection = null;
    try {
      connection = getConnection();
      FAHomeClosingSummaryDao dao = new FAHomeClosingSummaryDao(connection);
      return dao.getFAHomeClosingSummaryEventIds(caseId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to AdoptionAssistanceEligibilityDocumentationDao */
  public int[] getAdoptionSubsidyIds(int caseId, int stageId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getAdoptionSubsidyIds");
    Connection connection = null;
    try {
      connection = getConnection();
      AdoptionAssistanceEligibilityDocumentationDao dao = new AdoptionAssistanceEligibilityDocumentationDao(connection);
      return dao.getAdoptionSubsidyIds(caseId, stageId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to AbuseNeglectReportDao */
  public boolean hasReviewContact(int caseId) {
    GrndsTrace.enterScope(TRACE_TAG + ".hasReviewContact");
    Connection connection = null;
    try {
      connection = getConnection();
      AbuseNeglectReportDao dao = new AbuseNeglectReportDao(connection);
      return dao.hasReviewContact(caseId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public void deleteCfpStatus(int cfpId, int userId) throws CannotDeleteCfpException {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      dao.deleteCfpStatus(cfpId, userId);
    } catch (CannotDeleteCfpException e) {
      throw e;
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public CfpStatusDB getCfpStatus(int cfpId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getCfpStatus(cfpId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public List getQueuedCfpStatusForUser(int userId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getQueuedCfpStatusForUser");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getQueuedCfpStatusForUser(userId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public List getQueuedCfpStatus() {
    GrndsTrace.enterScope(TRACE_TAG + ".getQueuedCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getQueuedCfpStatus();
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public List getCompletedCfpStatus() {
    GrndsTrace.enterScope(TRACE_TAG + ".getCompletedCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getCompletedCfpStatus();
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public PaginationResultBean getQueueCfpStatus(int userId, DatabaseResultDetails details) {
    GrndsTrace.enterScope(TRACE_TAG + ".createCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getQueueCfpStatus(userId, details);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public CfpStatusDB createCfpStatus(CfpStatusDB cfpStatusDB) {
    GrndsTrace.enterScope(TRACE_TAG + ".createCfpStatus");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.createCfpStatus(cfpStatusDB);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public void updateProgress(int cfpId, String progress) {
    GrndsTrace.enterScope(TRACE_TAG + ".updateProgress");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      dao.updateProgress(cfpId, progress);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public void setError(int cfpId, String errorMessage) {
    GrndsTrace.enterScope(TRACE_TAG + ".setError");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      dao.setError(cfpId, errorMessage);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to CfpDao */
  public StageDB getStageDB(int caseId, int stageId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getStageDB");
    Connection connection = null;
    try {
      connection = getConnection();
      CfpDao dao = new CfpDao(connection);
      return dao.getStageDB(caseId, stageId);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to ReportDataDao */
  public String[] getParameterNames(String sqrName, String sqrVersion) {
    GrndsTrace.enterScope(TRACE_TAG + ".getParameterNames");
    Connection connection = null;
    try {
      connection = getConnection();
      ReportDataDao dao = new ReportDataDao(connection);
      return dao.getParameterNames(sqrName, sqrVersion);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to ReportDataDao */
  public Map getReportIds(int userId, String[] cfpStamps) {
    GrndsTrace.enterScope(TRACE_TAG + ".getReportIds");
    Connection connection = null;
    try {
      connection = getConnection();
      ReportDataDao dao = new ReportDataDao(connection);
      return dao.getReportIds(userId, cfpStamps);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to DocumentTypeDao */
  public DocumentTypeDB[] getDocumentOrder(String program, String stage, String stageType) {
    GrndsTrace.enterScope(TRACE_TAG + ".getDocumentOrder");
    Connection connection = null;
    try {
      connection = getConnection();
      DocumentTypeDao dao = new DocumentTypeDao(connection);
      return dao.getDocumentOrder(program, stage, stageType);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Delegates to DocumentTypeDao */
  public DocumentGenerationMetaDataDB getDocumentGenerationMetaData(String outputCode) {
    GrndsTrace.enterScope(TRACE_TAG + ".getDocumentGenerationMetaData");
    Connection connection = null;
    try {
      connection = getConnection();
      DocumentTypeDao dao = new DocumentTypeDao(connection);
      return dao.getDocumentGenerationMetaData(outputCode);
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
