package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexMedicationDAO {

  /**
   * Save or Update Medication row
   * 
   * @param idMedication
   * @param idPerson
   * @param ldNmMedctn
   * @param ldCdMedctnDose
   * @param ldTxtMedctnReason
   * @param ldDtMedctnPresc
   * @param ldDtMedctnEndDate
   * @param ldTxtMedctnAdminPerson
   * @param ldIndMedctnAllergies
   * @param ldTxtMedctnDescrip
   * @param ldTxtMedctnCmnts
   * @return
   */
  int saveMedication(int idMedication, int idPerson, String ldNmMedctn, String ldCdMedctnDose,
                     String ldTxtMedctnReason, Date ldDtMedctnPresc, Date ldDtMedctnEndDate,
                     String ldTxtMedctnAdminPerson, String ldIndMedctnAllergies,
                     String ldTxtMedctnDescrip, String ldTxtMedctnCmnts);
}
