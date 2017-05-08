package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChild;

import java.util.List;
import java.util.Map;

public interface NonComplianceChildDAO {
  /**
   * findNonComplianceChildbyIdNonCompliance selects a row from Non Compliance Child table given an
   * idNonCompliance
   * 
   * @param idNonCompliance
   * @return rowList.
   */
  List<NonComplianceChild> findNonComplianceChildbyIdNonCompliance(int idNonCompliance);

  /**
   * saveNonComplianceChild saves details into NonComplianceChild
   * 
   * @param nonComplianceChild
   */
  void saveNonComplianceChild(NonComplianceChild nonComplianceChild);
  
  /**
   * deleteNonComplianceChildByIdNonCompliance deletes Non Compliance Child on idNonCompliance.
   * 
   * @param idNonCompliance.
   */
  void deleteNonComplianceChildByIdNonCompliance(int idNonCompliance);
  
  /**
   * findChildrenInViolation returns the children in the violation.
   * 
   * @param idNonCompliance.
   * @return List<Map> children found from DAO call that includes Name, DOB, Gender
   */  
  List<Map> findChildrenInViolation (int idNonCompliance);
  
  
  /**
   * findChildrenInNonCompliance returns the children associated with the non-compliance.  These children
   * may or may not have been a part of the violation.
   * 
   * @param idNonCompliance.
   * @return List<Map> children found from DAO call that includes Name, DOB, Gender
   */  
  List<Map> findChildrenInNonCompliance(int idNonCompliance);
}
