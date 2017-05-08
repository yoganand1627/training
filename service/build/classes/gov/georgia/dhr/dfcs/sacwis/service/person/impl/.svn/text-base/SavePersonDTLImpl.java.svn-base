package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonDTL;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC38SO;

public class SavePersonDTLImpl extends BaseServiceImpl implements SavePersonDTL {

  private PersonDtlDAO personDtlDAO = null;

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public CCFC38SO updatePersonDTL(CCFC38SI ccfc38si) throws ServiceException {

    CCFC38SO ccfc38so = new CCFC38SO();
    PersonDtl personDtl = new PersonDtl();
    personDtl.setDtLastUpdate(ccfc38si.getTsLastUpdate());
    personDtl.setIdPerson(ccfc38si.getUlIdPerson());

    String reqFuncCd = ccfc38si.getArchInputStruct().getCReqFuncCd();

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      Person person = (Person) getPersistentObject(Person.class, ccfc38si.getUlIdPerson());
      personDtl.setPerson(person);
    }

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
      personDtl.setCdPersonBirthCity(ccfc38si.getSzCdPersonBirthCity());
      personDtl.setCdPersonBirthCountry(ccfc38si.getSzCdPersonBirthCountry());
      personDtl.setCdPersonBirthCounty(ccfc38si.getSzCdPersonBirthCounty());
      personDtl.setCdPersonBirthState(ccfc38si.getSzCdPersonBirthState());
      personDtl.setCdPersonCitizenship(ccfc38si.getSzCdPersonCitizenship());
      personDtl.setCdPersonEyeColor(ccfc38si.getSzCdPersonEyeColor());
      personDtl.setCdPersonFaHomeRole(ccfc38si.getSzCdPersonFaHomeRole());
      personDtl.setCdPersonHairColor(ccfc38si.getSzCdPersonHairColor());
      personDtl.setCdPersonHighestEduc(ccfc38si.getSzCdPersonHighestEduc());
      personDtl.setNmPersonLastEmployer(ccfc38si.getSzNmPersonLastEmployer());
      personDtl.setNmPersonMaidenName(ccfc38si.getSzNmPersonMaidenName());
      personDtl.setIndPersonNoUsBrn(ccfc38si.getCIndPersonNoUsBrn());
      personDtl.setQtyPersonHeightFeet(ccfc38si.getSQtyPersonHeightFeet());
      personDtl.setQtyPersonHeightInches(ccfc38si.getSQtyPersonHeightInches());
      personDtl.setQtyPersonWeight(ccfc38si.getLQtyPersonWeight());
      personDtl.setCdRemovalMothrMarrd(ccfc38si.getCCdRemovalMothrMarrd());
      // NOTE:
      // The input object's annualIncome get method returns type-double.
      // i.e
      // double income1 = ccfc38si.getLdAmtPersonAnnualIncome();
      // PersonDtl's annualIncome set method argument requires type-int.
      // The PERSON_DTL table value for AMT_PERSON_ANNUAL_IMCOME is type NUMBER(10).
      personDtl.setAmtPersonAnnualIncome((int) ccfc38si.getLdAmtPersonAnnualIncome());
      // caud90d
      personDtlDAO.savePersonDtl(personDtl);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
      // caud90d
      personDtlDAO.deletePersonDtl(personDtl);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return ccfc38so;
  }
}