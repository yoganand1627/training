package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CannotDeleteCfpException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentGenerationMetaDataDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;

import java.util.List;
import java.util.Map;

import javax.ejb.EJBLocalObject;

public interface Cfp {
  public List<Map<String, Object>> getMedicalMentalEventPrincipalPairs(int caseId, int stageId);

  public List getFAHomeClosingSummaryEventIds(int caseId);

  public boolean hasReviewContact(int caseId);

  public int[] getAdoptionSubsidyIds(int caseId, int stageId);

  public void deleteCfpStatus(int cfpId, int userId) throws CannotDeleteCfpException;

  public CfpStatusDB getCfpStatus(int cfpId);

  public List getQueuedCfpStatusForUser(int userId);

  public List getQueuedCfpStatus();

  public List getCompletedCfpStatus();

  public PaginationResultBean getQueueCfpStatus(int userId, DatabaseResultDetails details);

  public CfpStatusDB createCfpStatus(CfpStatusDB cfpStatusDB);

  public void updateProgress(int cfpId, String progress);

  public void setError(int cfpId, String errorMessage);

  public StageDB getStageDB(int caseId, int stageId);

  //ReportDataDao
  public String[] getParameterNames(String sqrName, String sqrVersion);

  public Map getReportIds(int userId, String[] cfpStamps);

  //DocumentTypeDao
  public DocumentTypeDB[] getDocumentOrder(String program, String stage, String stageType);

  public DocumentGenerationMetaDataDB getDocumentGenerationMetaData(String outputCode);
}