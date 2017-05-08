package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;

public class ComplexSafetyResourceDAOImpl extends BaseDAOImpl implements ComplexSafetyResourceDAO {
  
  private SafetyResourceDAO safetyResourceDAO = null;
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;

  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }

  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }
  
  public int updateSafetyResource(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    int updatedRows = 0;
    
    updatedRows = updatedRows + safetyResourceDAO.updateSafetyResourcePrimary(idPersMergeForward, idPersMergeClosed, idEvent);
    updatedRows = updatedRows + safetyResourceDAO.updateSafetyResourceSecondary(idPersMergeForward, idPersMergeClosed, idEvent);
    
    long forwardCount = safetyResourceChildDAO.countSafetyResourceChildForEvent(idPersMergeForward, idEvent);
    if (forwardCount == 0) {
      updatedRows = updatedRows + safetyResourceChildDAO.mergeSafetyResourceChildren(idPersMergeForward, idPersMergeClosed, idEvent);
    }
    safetyResourceChildDAO.deleteSafetyResourceChildEvent(idPersMergeClosed, idEvent);
    forwardCount = srHouseholdMembersDAO.countSafetyHouseholdForEvent(idPersMergeForward, idEvent);
    if (forwardCount == 0) {
      updatedRows = updatedRows + srHouseholdMembersDAO.mergeSafetyResourceHshldMembers(idPersMergeForward, idPersMergeClosed, idEvent);
    }
    srHouseholdMembersDAO.deleteSrHouseholdMembersEvent(idPersMergeClosed, idEvent);
    
    return updatedRows;
  }
}