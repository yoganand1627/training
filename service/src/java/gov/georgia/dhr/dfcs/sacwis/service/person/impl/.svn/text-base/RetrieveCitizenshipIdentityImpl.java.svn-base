package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveCitizenshipIdentity;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RetrieveCitizenshipIdentityImpl extends BaseServiceImpl implements RetrieveCitizenshipIdentity {
  
  private PersonCitizenshipDAO personCitizenshipDAO = null;
  
  private PersonDAO personDAO = null;

  private PersonDtlDAO personDtlDAO = null; 

  public PersonCitizenshipDAO getPersonCitizenshipDAO() {
    return personCitizenshipDAO;
  }

  public void setPersonCitizenshipDAO(PersonCitizenshipDAO personCitizenshipDAO) {
    this.personCitizenshipDAO = personCitizenshipDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public PersonCitizenshipIdentitylRetrieveSO retrieveCitizenshipIdentity(
                                                                          PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI)
                                                                                                                                                  throws ServiceException {

    PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
    int idPerson = personCitizenshipIdentityRetrieveSI.getUlIdPerson();
    PersonCitizenshipIdentityList personCitizenshipIdentityBean = new PersonCitizenshipIdentityList();

    // ccmn44d
    Person person = personDAO.findPersonByIdPerson(idPerson);
    if (person == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    personCitizenshipIdentityBean.setBirthDate(person.getDtPersonBirth());
    personCitizenshipIdentityBean.setAge(person.getNbrPersonAge() != null ? person.getNbrPersonAge() : 0);            
    personCitizenshipIdentityBean.setSzCdCntryOfOrigin(person.getCdPersonCountryOrigin());//?    

    // PersonDtlDAO - 'Birth Information section'
    PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idPerson);
    boolean isValidCode = false;

    if (personDtl == null) {
      personCitizenshipIdentityBean.setSzCdPersonBirthState(StringHelper.EMPTY_STRING);      
      personCitizenshipIdentityBean.setSzCdBirthCounty(StringHelper.EMPTY_STRING);
      personCitizenshipIdentityBean.setSzCdBirthCity(StringHelper.EMPTY_STRING);
      personCitizenshipIdentityBean.setIndNonUSBorn(StringHelper.EMPTY_STRING);// 'Non-US born'
      personCitizenshipIdentityBean.setDtEntryUS(null);
      personCitizenshipIdentityBean.setSzCdMotherMarried(StringHelper.EMPTY_STRING);
      personCitizenshipIdentityBean.setOutOfStateCounty(StringHelper.EMPTY_STRING);
      personCitizenshipIdentityBean.setSzCdCitizenshipStatus(StringHelper.EMPTY_STRING);  
      personCitizenshipIdentityBean.setSzCdCntryOfOrigin(StringHelper.EMPTY_STRING);  
      
    } else {
      personCitizenshipIdentityBean.setSzCdPersonBirthState(personDtl.getCdPersonBirthState());      
      personCitizenshipIdentityBean.setSzCdBirthCounty(personDtl.getCdPersonBirthCounty());
            
      isValidCode = Lookup.isValidCode("CCOUNT", personDtl.getCdPersonBirthCounty());
      
      if(isValidCode){
        //Birth County - taken from codes table
        personCitizenshipIdentityBean.setSzCdBirthCounty(personDtl.getCdPersonBirthCounty());
        personCitizenshipIdentityBean.setOutOfStateCounty(StringHelper.EMPTY_STRING);
      }else if(!isValidCode){
        //Out of State County - free text
        personCitizenshipIdentityBean.setOutOfStateCounty(personDtl.getCdPersonBirthCounty());
        personCitizenshipIdentityBean.setSzCdBirthCounty(StringHelper.EMPTY_STRING);
      }
      
      
      personCitizenshipIdentityBean.setSzCdBirthCity(personDtl.getCdPersonBirthCity());
      personCitizenshipIdentityBean.setIndNonUSBorn(personDtl.getIndPersonNoUsBrn());
      personCitizenshipIdentityBean.setSzCdCitizenshipStatus(personDtl.getCdPersonCitizenship());
      personCitizenshipIdentityBean.setSzCdCntryOfOrigin(personDtl.getCdPersonBirthCountry());  

      if (personDtl.getDtEntryUs() != null) {
        personCitizenshipIdentityBean.setDtEntryUS(personDtl.getDtEntryUs());
      }
      
      //Method of Age Verification
      List<PersonCitizenship> checkedMethodOfAgeVerificationList = new ArrayList();
      checkedMethodOfAgeVerificationList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CAGEVERF);
      Iterator itCheckedMethodOfAgeVerificationList = checkedMethodOfAgeVerificationList.iterator();
      String[] checkedMethodOfAgeVerifications = new String[checkedMethodOfAgeVerificationList.size()];      
      
      if (checkedMethodOfAgeVerificationList != null && !checkedMethodOfAgeVerificationList.isEmpty()) {
        for (int i = 0; itCheckedMethodOfAgeVerificationList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedMethodOfAgeVerificationList.next();
          checkedMethodOfAgeVerifications[i] = (String) cb1.getCdCbx();          
        }
      }
      
      personCitizenshipIdentityBean.setMethodAgeVerifications(checkedMethodOfAgeVerifications);
      
      //Method of Citizenship Verification : US Citizen
      List<PersonCitizenship> checkedUSCitizenList = new ArrayList();
      checkedUSCitizenList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CCERTVER);
      Iterator itCheckedUSCitizenList = checkedUSCitizenList.iterator();
      String[] checkedUSCitizens = new String[checkedUSCitizenList.size()];
      
      if (checkedUSCitizenList != null && !checkedUSCitizenList.isEmpty()) {
        for (int i = 0; itCheckedUSCitizenList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedUSCitizenList.next();
          checkedUSCitizens[i] = (String) cb1.getCdCbx();          
        }
      }
      
      personCitizenshipIdentityBean.setUSCitizenVerifications(checkedUSCitizens);
      
      //Method of Citizenship Verification : Identity Verification (Adult)
      List<PersonCitizenship> checkedIdentityVerificationAdultList = new ArrayList();
      checkedIdentityVerificationAdultList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CIDENTAD);
      Iterator itCheckedIdentityVerificationAdultList = checkedIdentityVerificationAdultList.iterator();
      String[] checkedIdentityAdultVerifications = new String[checkedIdentityVerificationAdultList.size()];
      
      if (checkedIdentityVerificationAdultList != null && !checkedIdentityVerificationAdultList.isEmpty()) {
        for (int i = 0; itCheckedIdentityVerificationAdultList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedIdentityVerificationAdultList.next();
          checkedIdentityAdultVerifications[i] = (String) cb1.getCdCbx();          
        }
      }     
      
      personCitizenshipIdentityBean.setIdentityAdultVerifications(checkedIdentityAdultVerifications);
      
      //Method of Citizenship Verification : Identity Verification (Under 16 Only)
      List<PersonCitizenship> checkedIdentityVerificationUnder16OnlyList = new ArrayList();
      checkedIdentityVerificationUnder16OnlyList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CIDENTUN);
      Iterator itCheckedIdentityVerificationUnder16OnlyList = checkedIdentityVerificationUnder16OnlyList.iterator();
      String[] checkedIdentityUnder16Verifications = new String[checkedIdentityVerificationUnder16OnlyList.size()];
      
      if (checkedIdentityVerificationUnder16OnlyList != null && !checkedIdentityVerificationUnder16OnlyList.isEmpty()) {
        for (int i = 0; itCheckedIdentityVerificationUnder16OnlyList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedIdentityVerificationUnder16OnlyList.next();
          checkedIdentityUnder16Verifications[i] = (String) cb1.getCdCbx();          
        }
      }          
      
      personCitizenshipIdentityBean.setIdentityUnder16Verifications(checkedIdentityUnder16Verifications);
      
      //Method of Citizenship Verification : Permanent Resident/Refugee
      List<PersonCitizenship> checkedPermanentResRefugeeList = new ArrayList();
      checkedPermanentResRefugeeList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CPERMRES);
      Iterator itCheckedPermanentResRefugeeList = checkedPermanentResRefugeeList.iterator();
      String[] checkedPermanentResRefugees = new String[checkedPermanentResRefugeeList.size()];
      
      if (checkedPermanentResRefugeeList != null && !checkedPermanentResRefugeeList.isEmpty()) {
        for (int i = 0; itCheckedPermanentResRefugeeList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedPermanentResRefugeeList.next();
          checkedPermanentResRefugees[i] = (String) cb1.getCdCbx();          
        }
      }           
      
      personCitizenshipIdentityBean.setPermanentResidentRefugee(checkedPermanentResRefugees);
      
      //Method of Citizenship Verification : Other Qualified Alien
      List<PersonCitizenship> checkedOtherQualifiedAlienList = new ArrayList();
      checkedOtherQualifiedAlienList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.COTHRQUA);
      Iterator itCheckedOtherQualifiedAlienList = checkedOtherQualifiedAlienList.iterator();
      String[] checkedOtherQualifiedAliens = new String[checkedOtherQualifiedAlienList.size()];
      
      if (checkedOtherQualifiedAlienList != null && !checkedOtherQualifiedAlienList.isEmpty()) {
        for (int i = 0; itCheckedOtherQualifiedAlienList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedOtherQualifiedAlienList.next();
          checkedOtherQualifiedAliens[i] = (String) cb1.getCdCbx();          
        }
      }           
      
      personCitizenshipIdentityBean.setOtherQualifiedAlien(checkedOtherQualifiedAliens);
      
      //Method of Citizenship Verification : Undetermined/Other Staus
      List<PersonCitizenship> checkedUndeterminedList = new ArrayList();
      checkedUndeterminedList = personCitizenshipDAO.findCheckboxByIdPersonCbxCodeType(idPerson, CodesTables.CUDETALN);
      Iterator itCheckedUndeterminedList = checkedUndeterminedList.iterator();
      String[] checkedUndetermineds = new String[checkedUndeterminedList.size()];
      
      if (checkedUndeterminedList != null && !checkedUndeterminedList.isEmpty()) {
        for (int i = 0; itCheckedUndeterminedList.hasNext(); i++) {
          PersonCitizenship cb1 = (PersonCitizenship) itCheckedUndeterminedList.next();
          checkedUndetermineds[i] = (String) cb1.getCdCbx();          
        }
      }                 
      
      personCitizenshipIdentityBean.setUndeterminedStatus(checkedUndetermineds);
      personCitizenshipIdentityBean.setSzCdMotherMarried(personDtl.getCdPersonMarriedAtBirth());
    }
    
    personCitizenshipIdentitylRetrieveSO.setPersonCitizenshipIdentityBean(personCitizenshipIdentityBean);

    return personCitizenshipIdentitylRetrieveSO;

  }

}
