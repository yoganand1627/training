package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveMedication;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationSaveSO;

import java.util.Date;

public class SaveMedicationImpl extends BaseServiceImpl implements SaveMedication {

  private MedicationDAO medicationDAO = null;

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  public MedicationSaveSO updateMedicationInformation(MedicationSaveSI medicationSaveSI) throws ServiceException {
    MedicationSaveSO medicationSaveSO = new MedicationSaveSO();
    saveMedication(medicationSaveSI);
    return medicationSaveSO;
  }

  private void saveMedication(MedicationSaveSI medicationSaveSI) throws ServiceException {

    PersonMedicationList row = medicationSaveSI.getPmBean();
    String ldNmMedctn = row.getLdNmMedctn();
    String ldCdMedctnDose = row.getLdCdMedctnDose();
    String ldTxtMedctnReason = row.getLdTxtMedctnReason();
    String ldTxtMedctnAdminPerson = row.getLdTxtMedctnAdminPerson();
    Date ldDtMedctnPresc = row.getLdDtMedctnPresc();
    Date ldDtMedctnEndDate = row.getLdDtMedctnEndDate();
    String ldIndMedctnAllergies = row.getLdIndMedctnAllergies();
    String ldTxtMedctnDescrip = row.getLdTxtMedctnDescrip();
    String ldTxtMedctnCmnts = row.getLdTxtMedctnCmnts();
    String szTxtPrescribingPerson = row.getSzTxtPrescribingPerson();
    Date tsLastUpdate = row.getDtLastUpdate();
    String cdScrDataAction = row.getCdScrDataAction();
    int idPerson = medicationSaveSI.getUlIdPerson();
    int idMedication = row.getIdMedication();
    Date endDate = medicationSaveSI.getEnddate();

    String addLine1 = row.getLdAddLine1();
    String addLine2 = row.getLdAddLine2();
    String city = row.getLdCity();
    String phoneNumber = row.getLdPhoneNumber();
    String state = row.getLdState1();
    String zip = row.getLdZip();
    String nmPharmacy = row.getLdPharmacy();

    int nbrRowsUpdated;

    if ((endDate == null) || !DateHelper.isBeforeToday(endDate) ||
        DateHelper.isNull(endDate) || cdScrDataAction.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      nbrRowsUpdated = medicationDAO.updateActiveMedication(addLine1, addLine2, city, phoneNumber, state, zip,
                                                            nmPharmacy,
                                                            idMedication, idPerson, ldNmMedctn, ldCdMedctnDose,
                                                            ldTxtMedctnReason, ldDtMedctnPresc, ldDtMedctnEndDate,
                                                            ldTxtMedctnAdminPerson, ldIndMedctnAllergies,
                                                            ldTxtMedctnDescrip, ldTxtMedctnCmnts, tsLastUpdate,
                                                            szTxtPrescribingPerson);
    } else {

      nbrRowsUpdated = medicationDAO.updateInActiveMedication(idMedication, idPerson, ldTxtMedctnDescrip,
                                                              ldTxtMedctnCmnts, tsLastUpdate);
    }

    if (nbrRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

  }
}
