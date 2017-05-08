package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonDTL;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;

public class RetrievePersonDTLImpl extends BaseServiceImpl implements RetrievePersonDTL {

  private static String PRIMARY_CHILD = "PC";
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDtlDAO personDtlDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public CCFC37SO retrievePersonDTL(CCFC37SI ccfc37si) throws ServiceException {
    CCFC37SO ccfc37so = new CCFC37SO();
    int idPerson;
    if (ccfc37si.getUlIdStage() != 0) {
      idPerson = findStagePersonLinkByIdPerson(ccfc37si);
    } else {
      idPerson = ccfc37si.getUlIdPerson();
    }
    
    PersonDtl personDtlInfo = findServiceAuthByIdPerson(idPerson);
   
    if(personDtlInfo != null){
      ccfc37so.setSzCdPersonBirthCity(personDtlInfo.getCdPersonBirthCity());
      ccfc37so.setSzCdPersonBirthCountry(personDtlInfo.getCdPersonBirthCountry());
      ccfc37so.setSzCdPersonBirthCounty(personDtlInfo.getCdPersonBirthCounty());
      ccfc37so.setSzCdPersonBirthState(personDtlInfo.getCdPersonBirthState());
      ccfc37so.setSzCdPersonCitizenship(personDtlInfo.getCdPersonCitizenship());
      ccfc37so.setSzCdPersonEyeColor(personDtlInfo.getCdPersonEyeColor());
      ccfc37so.setSzCdPersonFaHomeRole(personDtlInfo.getCdPersonFaHomeRole());
      ccfc37so.setSzCdPersonHairColor(personDtlInfo.getCdPersonHairColor());
      ccfc37so.setSzCdPersonHighestEduc(personDtlInfo.getCdPersonHighestEduc());
      ccfc37so.setSzNmPersonLastEmployer(personDtlInfo.getNmPersonLastEmployer());
      ccfc37so.setSzNmPersonMaidenName(personDtlInfo.getNmPersonMaidenName());
      ccfc37so.setTsLastUpdate(personDtlInfo.getDtLastUpdate());
      ccfc37so.setUlIdPerson(personDtlInfo.getIdPerson() != null ? personDtlInfo.getIdPerson() : 0);
      ccfc37so.setLdAmtPersonAnnualIncome(personDtlInfo.getAmtPersonAnnualIncome() != null ? personDtlInfo.getAmtPersonAnnualIncome() : 0);
      ccfc37so.setCIndPersonNoUsBrn(personDtlInfo.getIndPersonNoUsBrn());
      ccfc37so.setSQtyPersonHeightFeet(
              personDtlInfo.getQtyPersonHeightFeet() != null ? personDtlInfo.getQtyPersonHeightFeet() : 0);
      ccfc37so.setSQtyPersonHeightInches(
              personDtlInfo.getQtyPersonHeightInches() != null ? personDtlInfo.getQtyPersonHeightInches() : 0);
      ccfc37so.setLQtyPersonWeight(personDtlInfo.getQtyPersonWeight() != null ? personDtlInfo.getQtyPersonWeight() : 0);
      ccfc37so.setCCdRemovalMothrMarrd(personDtlInfo.getCdPersonMarriedAtBirth());
      // SMS#111056: need to retrieve RC due dates for validation
      ccfc37so.setDtDtLastMed(personDtlInfo.getDtLastMed());
      ccfc37so.setDtDtMedDue(personDtlInfo.getDtMedDue());
      ccfc37so.setDtDtLastGcicRc(personDtlInfo.getDtLastGcicRc());
      ccfc37so.setDtDtLastNcicRc(personDtlInfo.getDtLastNcicRc());
      ccfc37so.setDtDtGcicRcDue(personDtlInfo.getDtGcicRcDue());
      ccfc37so.setDtDtNcicRcDue(personDtlInfo.getDtNcicRcDue());
      ccfc37so.setBIndAnnualMed(personDtlInfo.getIndAnnualMed());
      ccfc37so.setBIndRsrcHouseholdMember(personDtlInfo.getIndPersonRsrcHshdMember());
    }
    return ccfc37so;
  }

  private int findStagePersonLinkByIdPerson(CCFC37SI ccfc37si) throws ServiceException {
    // csec58d
    Map stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLinkByIdPerson(ccfc37si.getUlIdStage(),
                                                                               PRIMARY_CHILD);
    if (stagePersonLinkInfo == null || stagePersonLinkInfo.size() == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return (Integer) stagePersonLinkInfo.get("idPerson");
  }

  private PersonDtl findServiceAuthByIdPerson(int idPerson) throws ServiceException {
    // cses31d
    PersonDtl personDtlInfo = personDtlDAO.findServiceAuthByIdPerson(idPerson);
    if (personDtlInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return personDtlInfo;
  }
}