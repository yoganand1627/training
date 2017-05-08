package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveMedication;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveMedicationImpl extends BaseServiceImpl implements RetrieveMedication {

  private MedicationDAO medDAO = null;

  public void setMedicationDAO(MedicationDAO medDAO) {
    this.medDAO = medDAO;
  }

  @SuppressWarnings("unchecked")
  public MedicationRetrieveSO retrieveMedication(MedicationRetrieveSI medicationRetrieveSI) {
    MedicationRetrieveSO medicationRetrieveSO = new MedicationRetrieveSO();
    int idPerson = medicationRetrieveSI.getUlIdPerson();
    List<Medication> medicationsList = new ArrayList();

    medicationsList = medDAO.findMedicationByIdPerson(idPerson);
    List medrowList = new ArrayList();
    // It is possible for a person to be entered into the system with no
    // rows in the medication table.
    // Therefore we will not handle SQL_NOT_FOUND.
    medicationRetrieveSO.setUlIdPerson(idPerson);
    if (medicationsList != null && !medicationsList.isEmpty()) {
      for (Iterator it = medicationsList.iterator(); it.hasNext();) {
        Medication medication = (Medication) it.next();
        PersonMedicationList medicationRow = new PersonMedicationList();
        medicationRow.setLdNmMedctn(medication.getNmMedctn());
        medicationRow.setLdCdMedctnDose(medication.getCdMedctnDose());
        medicationRow.setLdTxtMedctnAdminPerson(medication.getTxtMedctnAdminPerson());
        medicationRow.setLdTxtMedctnReason(medication.getTxtMedctnReason());
        medicationRow.setLdDtMedctnEndDate(medication.getDtMedctnEndDate());
        medicationRow.setLdDtMedctnPresc(medication.getDtMedctnPresc());
        medicationRow.setLdIndMedctnAllergies(medication.getIndMedctnAllergies());
        medicationRow.setLdTxtMedctnDescrip(medication.getTxtMedctnDescrip());
        medicationRow.setLdTxtMedctnCmnts(medication.getTxtMedctnCmnts());
        medicationRow.setIdMedication(medication.getIdMedication());
        medicationRow.setSzTxtPrescribingPerson(medication.getTxtMedctnPrescPerson());
       
        medicationRow.setLdAddLine1(medication.getAddrPharmStLn1());
        medicationRow.setLdAddLine2(medication.getAddrPharmStLn2());
        medicationRow.setLdCity(medication.getAddrPharmCity());
        medicationRow.setLdPhoneNumber(medication.getNbrPharmPhone());
        medicationRow.setLdState1(medication.getCdAddrPharmState());
        medicationRow.setLdZip(medication.getAddrPharmZip());
        medicationRow.setLdPharmacy(medication.getNmPharmacy());
        
        medrowList.add(medicationRow);
      }
    }

    medicationRetrieveSO.setPmBeanList(medrowList);

    return medicationRetrieveSO;
  }
}
