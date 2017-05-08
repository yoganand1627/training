package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PsaPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProtectiveServiceAlertDAO;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveProtectiveServiceAlert;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertRetrieveSO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class RetrieveProtectiveServiceAlertImpl extends BaseServiceImpl implements RetrieveProtectiveServiceAlert {
  
  private ProtectiveServiceAlertDAO protectiveServiceAlertDAO;
  private PsaPersonLinkDAO psaPersonLinkDAO;
  private StagePersonLinkDAO stagePersonLinkDAO;
  
  public void setProtectiveServiceAlertDAO(ProtectiveServiceAlertDAO protectiveServiceAlertDAO) {
    this.protectiveServiceAlertDAO = protectiveServiceAlertDAO;
  }
  
  public void setPsaPersonLinkDAO(PsaPersonLinkDAO psaPersonLinkDAO) {
    this.psaPersonLinkDAO = psaPersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public ProtectiveServiceAlertRetrieveSO retrieveProtectiveServiceAlert(
          ProtectiveServiceAlertRetrieveSI psaRetrieveSI) {
    ProtectiveServiceAlertRetrieveSO psaRetrieveSO = new ProtectiveServiceAlertRetrieveSO();

    int idStage = 0;
    if (psaRetrieveSI.getIdStage() > 0) {
      idStage = psaRetrieveSI.getIdStage();
    } else {
      //-- find stage id by person id
      boolean throwError = true;
      int idPerson = 0;
      if(psaRetrieveSI.getIdPerson() > 0){
        idPerson = psaRetrieveSI.getIdPerson();
        Integer earliestIdStage = psaPersonLinkDAO.findIdStageForEarliestPSAByIdPerson(idPerson);
        if(earliestIdStage != null && earliestIdStage.intValue() > 0){
          idStage = earliestIdStage.intValue();
          throwError = false;
        }
      }
      if(throwError){
        throw new RuntimeWrappedException(new PopulationException("The ProtectiveServiceAlertRetrieveSI object "+
                                                                  "was not populated with a valid idStage or "+
                                                                  "idPerson with an active protective service alert."));
      }
    }
    List<Object[]> psaDetail = protectiveServiceAlertDAO.findPSAByIdStage(idStage);
    if (psaDetail != null && !psaDetail.isEmpty()) {
      populatePSI(psaDetail.get(psaDetail.size() - 1), psaRetrieveSO);
    } else {
      psaRetrieveSO.setIdPSA(-1); //-- indicates no psa saved for this stage yet
    }

    psaRetrieveSO.setIdStage(idStage);
    populatePersons(psaRetrieveSO);

    return psaRetrieveSO;
  }

  private void populatePSI(Object[] array, ProtectiveServiceAlertRetrieveSO psaRetrieveSO) {
    Integer idPSA = (Integer) array[0];
    Integer idCaseManager = (Integer) array[1];
    String nmCaseManager = (String) array[2];
    String cdCaseMgrTitle = (String) array[3];
    String cdPsaStage = (String) array[4];
    Date dtPsaDate = (Date) array[5];
    Date dtPsaAbsconded = (Date) array[6];
    String cdPsaReasonalert = (String) array[7];
    String indPsaAllPersLocated = (String) array[8];
    String txtPsaComment = (String) array[9];
    Integer idCase = (Integer) array[10];
    String nmStage = (String) array[11];

    psaRetrieveSO.setIdPSA(idPSA != null ? idPSA.intValue() : 0);
    psaRetrieveSO.setIdUserCreatedBy(idCaseManager != null ? idCaseManager.intValue() : 0);
    psaRetrieveSO.setNmUserCreatedBy(nmCaseManager);
    psaRetrieveSO.setCdTitle(cdCaseMgrTitle);
    psaRetrieveSO.setCdStage(cdPsaStage);
    if(dtPsaDate != null) {
      psaRetrieveSO.setDate(dtPsaDate);
      String dateAndTime = DateHelper.DATE_TIME_FORMAT.format(dtPsaDate);
      psaRetrieveSO.setTime(dateAndTime.substring(11, 19));
    }
    psaRetrieveSO.setDateAbsconded(dtPsaAbsconded);
    psaRetrieveSO.setCdReasonForAlert(cdPsaReasonalert);
    psaRetrieveSO.setIndAllPersonsLocated(indPsaAllPersLocated);
    psaRetrieveSO.setComments(txtPsaComment);
    psaRetrieveSO.setIdCase(idCase != null ? idCase.intValue() : 0);
    psaRetrieveSO.setNmStage(nmStage);
  }

  private void populatePersons(ProtectiveServiceAlertRetrieveSO psaRetrieveSO) {
    List<PersonProtectiveServiceAlertList> persons = new ArrayList<PersonProtectiveServiceAlertList>();

    List<Object[]> personsAbsconded = psaPersonLinkDAO.findPersonsAbsconded(psaRetrieveSO.getIdStage());
    if (personsAbsconded != null && !personsAbsconded.isEmpty()) {
      //-- iterate thru personsAbsconded and add to persons
      Iterator<Object[]> it = personsAbsconded.iterator();
      while (it.hasNext()) {
        Object[] array = it.next();
        persons.add(convertObjectArrayToPerson(array, true));
      }
    }

    List<Object[]> personsNotAbsconded = stagePersonLinkDAO.findPersonsNotAbsconded(
            psaRetrieveSO.getIdStage());
    if (personsNotAbsconded != null && !personsNotAbsconded.isEmpty()) {
      //-- iterate thru personsNotAbsconded and add to persons
      Iterator<Object[]> it = personsNotAbsconded.iterator();
      while (it.hasNext()) {
        Object[] array = it.next();
        persons.add(convertObjectArrayToPerson(array, false));
      }
    }

    psaRetrieveSO.setPersons(persons);
  }

  private PersonProtectiveServiceAlertList convertObjectArrayToPerson(Object[] array, boolean active) {
    BigDecimal id = (BigDecimal) array[0];
    int idPerson = id != null ? id.intValue() : 0;
    String nmPersonFull = (String) array[1];
    Date dtPersonBirth = (Date) array[2];
    String nbrPersonIdNumber = (String) array[3];
    String cdPersonEthnicGroup = (String) array[4];
    String cdEthnicity = (String) array[5];
    String cdPersonSex = (String) array[6];
    String cdPersonStatus = (String) array[7];

    return new PersonProtectiveServiceAlertList(active, //currentlyActive
                                                active, //newlyActive
                                                idPerson, //idPerson
                                                nmPersonFull, //name
                                                dtPersonBirth, //dob
                                                nbrPersonIdNumber, //ssn
                                                cdPersonEthnicGroup, //race
                                                cdEthnicity, //ethnicity
                                                cdPersonSex, //gender
                                                cdPersonStatus); //legalStatus
  }
}
