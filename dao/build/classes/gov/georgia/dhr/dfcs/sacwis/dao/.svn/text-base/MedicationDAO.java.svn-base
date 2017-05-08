/**
 * Created on September 13, 2006 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MedicationDAO {

  /**
   * Retrieves all medicationss from the Medication table given idPerson. <p/>
   *
   * @param idPerson
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  List<Medication> findMedicationByIdPerson(int idPerson);

  /**
   * Retrieves all medication names from the Medication table currently still being used by given idPerson. <p/>
   *
   * @param idPerson
   * @returnList<Map>
   */
  List<Map> findMedicationCurrentlyOnByIdPerson(int idPerson);
  
  /**
   * Retrieves all medicationss from the Medication table given idPerson. <p/>
   * 
   * @param idPerson
   * @param dteffdate
   * @return
   */
  List<Medication> findRelationshipByIdPerson(int idPerson, Date dteffdate);
  
  /**
   * Updates Medication table
   *
   * @param idMedication
   * @param idPerson
   * @param ldNmMedctn
   * @param ldCdMedctnDose
   * @param ldTxtMedctnReason
   * @param ldDtMedctnPresc
   * @param ldDtMedctnEndDate
   * @param ldIndMedctnAllergies
   * @param ldTxtMedctnDescrip
   * @param ldTxtMedctnCmnts
   * @return
   */
  int updateActiveMedication(String addLine1,String addLine2,String city,String phoneNumber,String state,
                             String zip,String nmPharmacy,int idMedication, int idPerson, String ldNmMedctn, String ldCdMedctnDose,
                             String ldTxtMedctnReason, Date ldDtMedctnPresc, Date ldDtMedctnEndDate,
                             String ldTxtMedctnAdminPerson, String ldIndMedctnAllergies, String ldTxtMedctnDescrip,
                             String ldTxtMedctnCmnts, Date dtLastUpdate, String szTxtPrescribingPerson);

  /**
   * Updates table Medication fields ldTxtMedctnDescrip,ldTxtMedctnCmnts given idPerson <p/>
   *
   * @param idMedication
   * @param idMedication
   * @param idPerson
   * @param ldTxtMedctnDescrip
   * @param ldTxtMedctnCmnts
   */
  int updateInActiveMedication(int idMedication, int idPerson, String ldTxtMedctnDescrip, String ldTxtMedctnCmnts,
                               Date dtLastUpdate);
  
  /**
   * This is an update/insert for medication info.
   * 
   * @param medication
   */
  void saveMedication(Medication medication);
}