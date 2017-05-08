package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexMedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import java.util.Date;

public class ComplexMedicationDAOImpl extends BaseDAOImpl implements ComplexMedicationDAO {
  
  
  private MedicationDAO medicationDAO = null;

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public int saveMedication(int idMedication, int idPerson, String ldNmMedctn, String ldCdMedctnDose,
                            String ldTxtMedctnReason, Date ldDtMedctnPresc, Date ldDtMedctnEndDate,
                            String ldTxtMedctnAdminPerson, String ldIndMedctnAllergies, String ldTxtMedctnDescrip,
                            String ldTxtMedctnCmnts) {

    Medication medication = new Medication();

    if (idMedication != 0) {
      medication = (Medication) getSession().load(Medication.class, idMedication);
    }

    if (!StringHelper.EMPTY_STRING.equals(ldNmMedctn)) {
      medication.setNmMedctn(ldNmMedctn);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldCdMedctnDose)) {
      medication.setCdMedctnDose(ldCdMedctnDose);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldTxtMedctnReason)) {
      medication.setTxtMedctnReason(ldTxtMedctnReason);
    }
    
    if (ldDtMedctnPresc != null) {
      medication.setDtMedctnPresc(ldDtMedctnPresc);
    }

    if (ldDtMedctnEndDate != null) {
      medication.setDtMedctnEndDate(ldDtMedctnEndDate);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldTxtMedctnAdminPerson)) {
      medication.setTxtMedctnAdminPerson(ldTxtMedctnAdminPerson);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldIndMedctnAllergies)) {
      medication.setIndMedctnAllergies(ldIndMedctnAllergies);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldTxtMedctnDescrip)) {
      medication.setTxtMedctnDescrip(ldTxtMedctnDescrip);
    }
    
    if (!StringHelper.EMPTY_STRING.equals(ldTxtMedctnCmnts)) {
      medication.setTxtMedctnCmnts(ldTxtMedctnCmnts);
    }    
       
    Person person = (Person) getSession().load(Person.class, idPerson);
    medication.setPerson(person);

    medicationDAO.saveMedication(medication);    
    
    return medication.getIdMedication();
  }
}
