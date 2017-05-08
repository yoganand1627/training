package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCitizenshipIdentity;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentitySaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitySaveSO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveCitizenshipIdentityImpl extends BaseServiceImpl implements SaveCitizenshipIdentity {

  private PersonCitizenshipDAO personCitizenshipDAO = null;

  private PersonDAO personDAO = null;

  private PersonDtlDAO personDtlDAO = null;

  public void setPersonCitizenshipDAO(PersonCitizenshipDAO personCitizenshipDAO) {
    this.personCitizenshipDAO = personCitizenshipDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  @SuppressWarnings("unchecked")
  public PersonCitizenshipIdentitySaveSO saveCitizenshipIdentity(
                                                                 PersonCitizenshipIdentitySaveSI personCitizenshipIdentitySaveSI)
                                                                                                                                 throws ServiceException {

    PersonCitizenshipIdentitySaveSO personCitizenshipIdentitySaveSO = new PersonCitizenshipIdentitySaveSO();

    int idPerson = personCitizenshipIdentitySaveSI.getUlIdPerson();

    PersonCitizenshipIdentityList personCitizenshipIdentityBean = personCitizenshipIdentitySaveSI
                                                                                                 .getPersonCitizenshipIdentityBean();

    if (personCitizenshipIdentityBean != null) {

      // Birth Information
      String szCdPersonBirthState = personCitizenshipIdentityBean.getSzCdPersonBirthState();
      String szCdPersonBirthCounty = personCitizenshipIdentityBean.getSzCdBirthCounty();
      String szCdPersonBirthCity = personCitizenshipIdentityBean.getSzCdBirthCity();
      String szCdCountryOfOrigin = personCitizenshipIdentityBean.getSzCdCntryOfOrigin();
      String bIndNonUSBorn = personCitizenshipIdentityBean.getIndNonUSBorn();//debug error when trying to save
      String szCdCitizenshipStatus = personCitizenshipIdentityBean.getSzCdCitizenshipStatus();
      String szCdMotherMarried = personCitizenshipIdentityBean.getSzCdMotherMarried();
      String outOfStateCounty = personCitizenshipIdentityBean.getOutOfStateCounty();
      Date dtDtEntryUS = personCitizenshipIdentityBean.getDtEntryUS();

      Person person = (Person) getPersistentObject(Person.class, idPerson);     
      person.setCdPersonCountryOrigin(szCdCountryOfOrigin);//?
      personDAO.savePerson(person);

      int personDtlExist = personDtlDAO.findIdPersonDtlByIdPerson(idPerson);
      PersonDtl personDtl = new PersonDtl();
      if(personDtlExist != 0){
        personDtl = (PersonDtl) getPersistentObject(PersonDtl.class, idPerson);
      }else{
        personDtl.setPerson(person);
      }
            
      personDtl.setCdPersonBirthState(szCdPersonBirthState);

      // Birth County
      //comment out if condition for fixing defect STGAP00003743
      //if (!StringHelper.EMPTY_STRING.equals(szCdPersonBirthCounty) && szCdPersonBirthCounty != null) {
        personDtl.setCdPersonBirthCounty(szCdPersonBirthCounty);
     // }

      // Out of State County
      if (!StringHelper.EMPTY_STRING.equals(outOfStateCounty) && outOfStateCounty != null) {
        personDtl.setCdPersonBirthCounty(outOfStateCounty);
      }

      personDtl.setCdPersonBirthCountry(szCdCountryOfOrigin);
      personDtl.setCdPersonCitizenship(szCdCitizenshipStatus);
      personDtl.setCdPersonBirthCity(szCdPersonBirthCity);
      personDtl.setIndPersonNoUsBrn(bIndNonUSBorn);
      personDtl.setCdPersonMarriedAtBirth(szCdMotherMarried);
      personDtl.setDtEntryUs(dtDtEntryUS);
      personDtlDAO.savePersonDtl(personDtl);

      // Method of Age Verification section:

      // delete current check boxes for Method of Age Verification section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CAGEVERF);
      
      List<String> checkedMethodOfAgeVerificationList = new ArrayList();
      checkedMethodOfAgeVerificationList = Arrays.asList(personCitizenshipIdentityBean.getMethodAgeVerifications());      
      Iterator itCheckedMethodOfAgeVerifications = checkedMethodOfAgeVerificationList.iterator();

      // add newly selected check boxes for Method of Age Verification section
      while (itCheckedMethodOfAgeVerifications.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CAGEVERF);
        personCitizenship.setCdCbx(itCheckedMethodOfAgeVerifications.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : US Citizen

      // delete current check boxes for US Citizen section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CCERTVER);
      
      List<String> checkedUSCitizenList = new ArrayList();
      checkedUSCitizenList = checkedUSCitizenList = Arrays.asList(personCitizenshipIdentityBean.getUSCitizenVerifications());
      Iterator itCheckedUSCitizens = checkedUSCitizenList.iterator();

      // add newly selected check boxes for US Citizen section
      while (itCheckedUSCitizens.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CCERTVER);
        personCitizenship.setCdCbx(itCheckedUSCitizens.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : Identity Verification (Adult)

      // delete current check boxes for Identity Verification (Adult) section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CIDENTAD);
      
      List<String> checkedIdentityVerificationAdultList = new ArrayList();
      checkedIdentityVerificationAdultList = Arrays.asList(personCitizenshipIdentityBean.getIdentityAdultVerifications());
      Iterator itCheckedIdentityVerificationAdultList = checkedIdentityVerificationAdultList.iterator();

      // add newly selected check boxes for Identity Verification (Adult) section
      while (itCheckedIdentityVerificationAdultList.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CIDENTAD);
        personCitizenship.setCdCbx(itCheckedIdentityVerificationAdultList.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : Identity Verification (Under 16 Only):

      // delete current check boxes for Identity Verification (Under 16 Only) section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CIDENTUN);
     
      List<String> checkedIdentityVerificationUnder16OnlyList = new ArrayList();
      checkedIdentityVerificationUnder16OnlyList = Arrays.asList(personCitizenshipIdentityBean.getIdentityUnder16Verifications());
      Iterator itCheckedIdentityVerificationUnder16OnlyList = checkedIdentityVerificationUnder16OnlyList.iterator();

      // add newly selected check boxes for Identity Verification (Under 16 Only) section
      while (itCheckedIdentityVerificationUnder16OnlyList.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CIDENTUN);
        personCitizenship.setCdCbx(itCheckedIdentityVerificationUnder16OnlyList.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : Permanent Resident/Refugee:

      // delete current check boxes for Permanent Resident/Refugee section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CPERMRES);
      
      List<String> checkedPermanentResRefugeeList = new ArrayList();
      checkedPermanentResRefugeeList = Arrays.asList(personCitizenshipIdentityBean.getPermanentResidentRefugee());
      Iterator itCheckedPermanentResRefugeeList = checkedPermanentResRefugeeList.iterator();

      // add newly selected check boxes for Permanent Resident/Refugee section
      while (itCheckedPermanentResRefugeeList.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CPERMRES);
        personCitizenship.setCdCbx(itCheckedPermanentResRefugeeList.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : Other Qualified Alien:

      // delete current check boxes for Permanent Other Qualified Alien section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.COTHRQUA);
      
      List<String> checkedOtherQualifiedAlienList = new ArrayList();
      checkedOtherQualifiedAlienList = Arrays.asList(personCitizenshipIdentityBean.getOtherQualifiedAlien());
      Iterator itCheckedOtherQualifiedAlienList = checkedOtherQualifiedAlienList.iterator();

      // add newly selected check boxes for Other Qualified Alien section
      while (itCheckedOtherQualifiedAlienList.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.COTHRQUA);
        personCitizenship.setCdCbx(itCheckedOtherQualifiedAlienList.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

      // Method of Citizenship Verification : Undetermined/Other Status:

      // delete current check boxes for Undetermined/Other Status section
      personCitizenshipDAO.deletePersonCitizenshipChkBxByIdPerson(idPerson, CodesTables.CUDETALN);
      
      List<String> checkedUndeterminedList = new ArrayList();
      checkedUndeterminedList = Arrays.asList(personCitizenshipIdentityBean.getUndeterminedStatus());
      Iterator itCheckedUndeterminedList = checkedUndeterminedList.iterator();

      // add newly selected check boxes for Undetermined/Other Status section
      while (itCheckedUndeterminedList.hasNext()) {
        PersonCitizenship personCitizenship = new PersonCitizenship();
        personCitizenship.setCdCbxCodeType(CodesTables.CUDETALN);
        personCitizenship.setCdCbx(itCheckedUndeterminedList.next().toString());
        personCitizenship.setPerson(person);
        personCitizenshipDAO.savePersonCitizenship(personCitizenship);
      }

    }
    return personCitizenshipIdentitySaveSO;
  }

}
