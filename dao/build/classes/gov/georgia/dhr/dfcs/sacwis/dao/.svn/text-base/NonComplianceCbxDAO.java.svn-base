package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;

import java.util.List;

public interface NonComplianceCbxDAO {
  /**
   * findNonCompliancecheckboxbyIdNonComplianceandCbxCodeType selects a row from Non Compliance Check box table given an
   * idNonCompliance, and Checkbox type
   * 
   * @param idNonCompliance
   * @param cdCbxType
   * @return rowList.
   */
  List<NonComplianceCbx> findNonCompliancecheckboxbyIdNonComplianceandCbxCodeType(int idNonCompliance, String cdCbxType);

  /**
   * saveNonComplianceCbx saves details into NonComplianceCbx table
   * 
   * @param adoinfocbx
   */
  void saveNonComplianceCbx(NonComplianceCbx nonComplianceCbx);
  
  /**
   * deleteNonComplianceCbxByIdNonCompliance deletes Non Compliance Check box based on idNonCompliance and CheckBox Type..
   * 
   * @param idNonCompliance.
   * @param String
   *          CheckBoxType.
   */
  void deleteNonComplianceCbxByIdNonComplianceCbxType(int idNonCompliance, String cbxtype);
  
  /**
   * deleteNonComplianceCbxByIdNonCompliance deletes Non Compliance Check box based on idNonCompliance and CheckBox Type..
   * 
   * @param idNonCompliance.
   * @param String
   *          CheckBoxType.
   */
  void deleteNonComplianceCbxByIdNonCompliance(int idNonCompliance);
}
