package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;


import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AgeAndCitizenshipCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AppAndBgCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveAgeCitizenshipVerification;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



//** Change History:
//**  Date      User              Description
//**  --------  ----------------  ------------------------------------------------------------------------
//**  1/2/08    charden           STGAP00010009 added extra null check because checkedMethodOfUSCitizenVerification 
//**                              was being returned with a null object in it's list. This was causing jsp to reload 
//**                              improperly and illegalArgumentException to be thrown when detail button is pressed 
//**                              age and citizenship view
//** 11/11/09   mxpatel           37462: removed changes made for defect STGAP00010009
//**



public class SaveAgeCitizenshipVerificationImpl extends BaseServiceImpl implements SaveAgeCitizenshipVerification {
  
  private EventDAO eventDAO = null;
  private RetrieveFceEligibility retrieveFceEligibility;
  private SaveFceEligibility saveFceEligibility;
  private SaveFceApplication saveFceApplication;
  private SaveFcePerson saveFcePerson;
  private AppAndBgCommonFunction appAndBgCommonFunction;
  private AgeAndCitizenshipCommonFunction ageAndCitizenshipCommonFunction;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setRetrieveFceEligibility(RetrieveFceEligibility retrieveFceEligibility) {
    this.retrieveFceEligibility = retrieveFceEligibility;
  }
  
  public void setAgeAndCitizenshipCommonFunction(AgeAndCitizenshipCommonFunction ageAndCitizenshipCommonFunction) {
    this.ageAndCitizenshipCommonFunction = ageAndCitizenshipCommonFunction;
  }

  public void setAppAndBgCommonFunction(AppAndBgCommonFunction appAndBgCommonFunction) {
    this.appAndBgCommonFunction = appAndBgCommonFunction;
  }

  public void setSaveFceApplication(SaveFceApplication saveFceApplication) {
    this.saveFceApplication = saveFceApplication;
  }

  public void setSaveFceEligibility(SaveFceEligibility saveFceEligibility) {
    this.saveFceEligibility = saveFceEligibility;
  }

  public void setSaveFcePerson(SaveFcePerson saveFcePerson) {
    this.saveFcePerson = saveFcePerson;
  }

  public AgeCitizenshipSaveSO saveCheckedAgeCitizenshipVerification (AgeCitizenshipSaveSI ageCitizenshipSaveSI) throws IOException, LookupException {
    
    AgeCitizenshipSaveSO ageCitizenshipSaveSO = new AgeCitizenshipSaveSO();
    boolean isUpdateSuccessfull = false;
    ageCitizenshipSaveSO.setUpdateSuccessful(isUpdateSuccessfull);
    FceApplicationDB fceApplicationCitizenshipIdentity = null;
    FceReviewDB fceReviewDB = null;
    FceEligibilityDB fceEligibilityCitizenshipIdentity = null;
    String cdEventType = "";
    int idEvent = Integer.parseInt(String.valueOf(ageCitizenshipSaveSI.getUlIdEvent()));
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if(event != null){
      cdEventType = event.getCdEventType();
      if("FCA".equals(cdEventType)){
        fceApplicationCitizenshipIdentity = appAndBgCommonFunction.findApplicationByApplicationEvent(ageCitizenshipSaveSI.getUlIdEvent());
        fceEligibilityCitizenshipIdentity = retrieveFceEligibility.retrieveFceEligibility(fceApplicationCitizenshipIdentity.getIdFceEligibility());
      }else if("FCR".equals(cdEventType)){
        fceReviewDB = ageAndCitizenshipCommonFunction.findReviewByReviewEvent(ageCitizenshipSaveSI.getUlIdEvent());
        fceEligibilityCitizenshipIdentity = retrieveFceEligibility.retrieveFceEligibility(fceReviewDB.getIdFceEligibility());
      }
    }else {
      ageCitizenshipSaveSO.setUpdateSuccessful(isUpdateSuccessfull);
      return ageCitizenshipSaveSO;
    }
    
    // Get Age and Citizenship info from the PERSON_CITIZENSHIP table
    PersonCitizenshipIdentityList personCitizenshipIdentityBean = ageCitizenshipSaveSI.getPersonCitizenshipIdentityBean();                            
    
    String szCdCitizenshipStatus = StringHelper.EMPTY_STRING;  
  
    String dtBirth = StringHelper.EMPTY_STRING;
    int age = 0;
    // Update FCE_ELIGIBILITY and FCE_PERSON with data from the Citizenship and Indentity page
    if(personCitizenshipIdentityBean != null){
      FcePersonDB fcePersonCitizenshipIdentity = ageAndCitizenshipCommonFunction.findFcePersonByIdFceEligibilityAndIdPerson(fceEligibilityCitizenshipIdentity.getIdFceEligibility(),
                                                                                                       fceEligibilityCitizenshipIdentity.getIdPerson());
      szCdCitizenshipStatus = personCitizenshipIdentityBean.getSzCdCitizenshipStatus();
      fceEligibilityCitizenshipIdentity.setCdPersonCitizenship(szCdCitizenshipStatus);
      dtBirth = FormattingHelper.formatDate(personCitizenshipIdentityBean.getBirthDate());
      fcePersonCitizenshipIdentity.setDtBirthString(dtBirth);
      // if birthdate is not null, get age from birthdate
      if (personCitizenshipIdentityBean.getBirthDate() != null) {
        age = DateHelper.getAge(personCitizenshipIdentityBean.getBirthDate());
      }
      fcePersonCitizenshipIdentity.setNbrAge(age);
      
      Class fceEligibilityDBClass = fceEligibilityCitizenshipIdentity.getClass();
      Class fceApplicationDBClass = null;
      Class[] types = {String.class};
      //Method of Age Verification
      if("FCA".equals(cdEventType)){
        fceApplicationDBClass = fceApplicationCitizenshipIdentity.getClass();
        Map<String, String> methodAgeVerificationList = new HashMap<String, String>();
        List<CodeAttributes> ageVerificationList = Lookup.getCategoryCollection(CodesTables.CAGEVERF);
        Iterator<CodeAttributes> ageVerificationList_it = ageVerificationList.iterator();
        while (ageVerificationList_it.hasNext()){
          CodeAttributes attribute = ageVerificationList_it.next();
          String code = attribute.getCode();
          if ("ABC".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdUsBirthCert");
          } else if ("ABP".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdBaptismCert");
          } else if ("ACF".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdForeignCert");
          } else if ("AEC".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeJustifiedEval");
          } else if ("AHC".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdHospitalCert");
          } else if ("ANC".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdNtrlztnCert");
          } else if ("ARC".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdResidentCard");
          } else if ("AUS".equals(code)){
            methodAgeVerificationList.put(code, "setIndAgeVrfdPassport");
          }
        }
        
        if(personCitizenshipIdentityBean.getMethodAgeVerifications() != null)
        {
          String[] checkedMethodOfAgeVerification = personCitizenshipIdentityBean.getMethodAgeVerifications();
          for (int i = 0; i < checkedMethodOfAgeVerification.length; i++) {
            String code = checkedMethodOfAgeVerification[i];
            String dBMethod = methodAgeVerificationList.get(code);
            Object arglist[] = {"Y"};
            try {
              Method setMethod = fceApplicationDBClass.getMethod(dBMethod, types);
              setMethod.invoke(fceApplicationCitizenshipIdentity, arglist);
            } catch (Exception e) {
              throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                    "--------------- " + e.getMessage() + "--------------\n");
            }
            methodAgeVerificationList.remove(code);
          }
        }
        
        Collection<String> uncheckedMethodOfAgeVerification = methodAgeVerificationList.values();
        Iterator<String> uncheckedAgeVerificationMethods_it = uncheckedMethodOfAgeVerification.iterator();
        while (uncheckedAgeVerificationMethods_it.hasNext()){
          Object arglist[] = {StringHelper.EMPTY_STRING};
          String dBMethod = uncheckedAgeVerificationMethods_it.next();
          try {
            Method setMethod = fceApplicationDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceApplicationCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
        }
      }
      //Method of Citizenship Verification : US Citizen
      Map<String, String> methodUSCitizenVerificationList = new HashMap<String, String>();
      List<CodeAttributes> uSCitizenVerificationList = Lookup.getCategoryCollection(CodesTables.CCERTVER);
      Iterator<CodeAttributes> uSCitizenVerificationList_it = uSCitizenVerificationList.iterator();
      
      while (uSCitizenVerificationList_it.hasNext()){
        CodeAttributes attribute = uSCitizenVerificationList_it.next();
        String code = attribute.getCode();
        if ("CBC".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpBirthCrtfctUs");
        } else if ("RBH".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpHospitalCrtfct");
        } else if ("CID".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpUsIdCard");
        } else if ("FAD".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpFinalAdoptDecree");
        } else if ("RBA".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpBirthAbroad");
        } else if ("MRS".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpMiltryBirthRcrd");
        } else if ("EHR".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpUsHsptlBrthRcrd");
        } else if ("CBR".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpCensusBirthRcrd");
        } else if ("CRB".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpCertReportBirth");
        } else if ("NCF".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpNtrlztnCrtfct");
        } else if ("USP".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpPassport");
        } else if ("AIC".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpAmerIndianCrd");
        } else if ("CSE".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpCivilServiceEmp");
        } else if ("NMC".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpNorthMarianaId");
        } else if ("BVS".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpVitalBirthRcrd");
        } else if ("COB".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpConfrmBirth");
        } else if ("LHI".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpLifeInsBrthRcrd");
        } else if ("MRB".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpMedBirthRcrd");
        } else if ("ECN".equals(code)){
          methodUSCitizenVerificationList.put(code, "setIndCtznshpEvaluation");
        }
      }
      // it broke here
      if(personCitizenshipIdentityBean.getUSCitizenVerifications() != null)
      {
        String[] checkedMethodOfUSCitizenVerification = personCitizenshipIdentityBean.getUSCitizenVerifications();
        for (int i = 0; i < checkedMethodOfUSCitizenVerification.length; i++) {
          String code = checkedMethodOfUSCitizenVerification[i];
          String dBMethod = methodUSCitizenVerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodUSCitizenVerificationList.remove(code);
        }
      }   
      
      Collection<String> uncheckedMethodOfCitizenVerification = methodUSCitizenVerificationList.values();
      Iterator<String> uncheckedCitizenVerificationMethods_it = uncheckedMethodOfCitizenVerification.iterator();
      while (uncheckedCitizenVerificationMethods_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedCitizenVerificationMethods_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
        
        
      //Method of Citizenship Verification : Identity Verification (Adult)
      Map<String, String> methodIdentityAdultVerificationList = new HashMap<String, String>();
      List<CodeAttributes> identityAdultVerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTAD);
      Iterator<CodeAttributes> identityAdultVerificationList_it = identityAdultVerificationList.iterator();
      while (identityAdultVerificationList_it.hasNext()){
        CodeAttributes attribute = identityAdultVerificationList_it.next();
        String code = attribute.getCode();
        if ("CDL".equals(code)){
          methodIdentityAdultVerificationList.put(code, "setIndCtznshpDriverLicOrId");
        } else if ("IDD".equals(code)){
          methodIdentityAdultVerificationList.put(code, "setIndCtznshpDocImmigNatAct");
        } else if ("CIB".equals(code)){
          methodIdentityAdultVerificationList.put(code, "setIndCtznshpCertIndBlood");
        }
      }
      
      if(personCitizenshipIdentityBean.getIdentityAdultVerifications() != null)
      {
        String[] checkedMethodOfIdentityAdultVerification = personCitizenshipIdentityBean.getIdentityAdultVerifications();
        for (int i = 0; i < checkedMethodOfIdentityAdultVerification.length; i++) {
          String code = checkedMethodOfIdentityAdultVerification[i];
          String dBMethod = methodIdentityAdultVerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodIdentityAdultVerificationList.remove(code);
        }
      }           
      
      Collection<String> uncheckedMethodOfIdentityAdultVerification = methodIdentityAdultVerificationList.values();
      Iterator<String> uncheckedMethodOfIdentityAdultVerification_it = uncheckedMethodOfIdentityAdultVerification.iterator();
      while (uncheckedMethodOfIdentityAdultVerification_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedMethodOfIdentityAdultVerification_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
      
      //Method of Citizenship Verification : Identity Verification (Under 16 Only)
      Map<String, String> methodIdentityUnder16VerificationList = new HashMap<String, String>();
      List<CodeAttributes> identityUnder16VerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTUN);
      Iterator<CodeAttributes> identityUnder16VerificationList_it = identityUnder16VerificationList.iterator();
      while (identityUnder16VerificationList_it.hasNext()){
        CodeAttributes attribute = identityUnder16VerificationList_it.next();
        String code = attribute.getCode();
        if ("SIP".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpSchoolIdPhoto");
        } else if ("SRD".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpSchoolRec");
        } else if ("DNS".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpDaycareNurseRcrd");
        } else if ("MID".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpMilitaryDepdntId");
        } else if ("CDH".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpClinicDocHosDoc");
        } else if ("ACI".equals(code)){
          methodIdentityUnder16VerificationList.put(code, "setIndCtznshpAffidavitSigned");
        }
      }  
      
      if(personCitizenshipIdentityBean.getIdentityUnder16Verifications() != null)
      {
        String[] checkedMethodOfIdentityUnder16Verification = personCitizenshipIdentityBean.getIdentityUnder16Verifications();
        for (int i = 0; i < checkedMethodOfIdentityUnder16Verification.length; i++) {
          String code = checkedMethodOfIdentityUnder16Verification[i];
          String dBMethod = methodIdentityUnder16VerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodIdentityUnder16VerificationList.remove(code);
        }
      }             
    
      Collection<String> uncheckedMethodOfIdentityUnder16Verification = methodIdentityUnder16VerificationList.values();
      Iterator<String> uncheckedMethodOfIdentityUnder16Verification_it = uncheckedMethodOfIdentityUnder16Verification.iterator();
      while (uncheckedMethodOfIdentityUnder16Verification_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedMethodOfIdentityUnder16Verification_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
      
      //Method of Citizenship Verification : Permanent Resident/Refugee
      Map<String, String> methodPermResidentRefugeeVerificationList = new HashMap<String, String>();
      List<CodeAttributes> permResidentRefugeeVerificationList = Lookup.getCategoryCollection(CodesTables.CPERMRES);
      Iterator<CodeAttributes> permResidentRefugeeVerificationList_it = permResidentRefugeeVerificationList.iterator();
      while (permResidentRefugeeVerificationList_it.hasNext()){
        CodeAttributes attribute = permResidentRefugeeVerificationList_it.next();
        String code = attribute.getCode();
        if ("ARR".equals(code)){
          methodPermResidentRefugeeVerificationList.put(code, "setIndCtznshpResidentCard");
        } else if ("REF".equals(code)){
          methodPermResidentRefugeeVerificationList.put(code, "setIndCtznshpRefugee");
        } 
      }

      if(personCitizenshipIdentityBean.getPermanentResidentRefugee() != null)
      {
        String[] checkedMethodOfPermResidentRefugeeVerification = personCitizenshipIdentityBean.getPermanentResidentRefugee();
        for (int i = 0; i < checkedMethodOfPermResidentRefugeeVerification.length; i++) {
          String code = checkedMethodOfPermResidentRefugeeVerification[i];
          String dBMethod = methodPermResidentRefugeeVerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodPermResidentRefugeeVerificationList.remove(code);
        }
      }       
    
      Collection<String> uncheckedMethodOfPermResidentRefugeeVerification = methodPermResidentRefugeeVerificationList.values();
      Iterator<String> uncheckedMethodOfPermResidentRefugeeVerification_it = uncheckedMethodOfPermResidentRefugeeVerification.iterator();
      while (uncheckedMethodOfPermResidentRefugeeVerification_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedMethodOfPermResidentRefugeeVerification_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
      
      //Method of Citizenship Verification : Other Qualified Alien
      Map<String, String> methodOtherQualifiedAlienVerificationList = new HashMap<String, String>();
      List<CodeAttributes> otherQualifiedAlienVerificationList = Lookup.getCategoryCollection(CodesTables.COTHRQUA);
      Iterator<CodeAttributes> otherQualifiedAlienVerificationList_it = otherQualifiedAlienVerificationList.iterator();
      while (otherQualifiedAlienVerificationList_it.hasNext()){
        CodeAttributes attribute = otherQualifiedAlienVerificationList_it.next();
        String code = attribute.getCode();
        if ("DRA".equals(code)){
          methodOtherQualifiedAlienVerificationList.put(code, "setIndCtznshpAttorneyReview");
        } else if ("STV".equals(code)){
          methodOtherQualifiedAlienVerificationList.put(code, "setIndCtznshpStudentVisa");
        } 
      }

      if(personCitizenshipIdentityBean.getOtherQualifiedAlien() != null)
      {
        String[] checkedMethodOfOtherQualifiedAlienVerification = personCitizenshipIdentityBean.getOtherQualifiedAlien();
        for (int i = 0; i < checkedMethodOfOtherQualifiedAlienVerification.length; i++) {
          String code = checkedMethodOfOtherQualifiedAlienVerification[i];
          String dBMethod = methodOtherQualifiedAlienVerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodOtherQualifiedAlienVerificationList.remove(code);
        }
      }          
      
      Collection<String> uncheckedMethodOfOtherQualifiedAlienVerification = methodOtherQualifiedAlienVerificationList.values();
      Iterator<String> uncheckedMethodOfOtherQualifiedAlienVerification_it = uncheckedMethodOfOtherQualifiedAlienVerification.iterator();
      while (uncheckedMethodOfOtherQualifiedAlienVerification_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedMethodOfOtherQualifiedAlienVerification_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
      
      //Method of Citizenship Verification : Undetermined/Other Staus
      Map<String, String> methodUndeterminedOtherVerificationList = new HashMap<String, String>();
      List<CodeAttributes> undeterminedOtherVerificationList = Lookup.getCategoryCollection(CodesTables.CUDETALN);
      Iterator<CodeAttributes> undeterminedOtherVerificationList_it = undeterminedOtherVerificationList.iterator();
      while (undeterminedOtherVerificationList_it.hasNext()){
        CodeAttributes attribute = undeterminedOtherVerificationList_it.next();
        String code = attribute.getCode();
        if ("FBC".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpBirthCrtfctFor");
        } else if ("NDC".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpNoDocumentation");
        } else if ("CUS".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpChldFound");
        } else if ("UIM".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpUndocImmigrant");
        } else if ("FOS".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpForDocumentation");
        } else if ("LIS".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpLeglImmiStatExp");
        } else if ("UMC".equals(code)){
          methodUndeterminedOtherVerificationList.put(code, "setIndCtznshpUnaccMinorChild");
        }
      }   
      
      if(personCitizenshipIdentityBean.getUndeterminedStatus() != null)
      {
        String[] checkedMethodOfUndeterminedStatusVerification = personCitizenshipIdentityBean.getUndeterminedStatus();
        for (int i = 0; i < checkedMethodOfUndeterminedStatusVerification.length; i++) {
          String code = checkedMethodOfUndeterminedStatusVerification[i];
          String dBMethod = methodUndeterminedOtherVerificationList.get(code);
          Object arglist[] = {"Y"};
          try {
            Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
            setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
          } catch (Exception e) {
            throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                  "--------------- " + e.getMessage() + "--------------\n");
          }
          methodUndeterminedOtherVerificationList.remove(code);
        }
      }
      
      Collection<String> uncheckedMethodOfUndeterminedStatusVerification = methodUndeterminedOtherVerificationList.values();
      Iterator<String> uncheckedMethodOfUndeterminedStatusVerification_it = uncheckedMethodOfUndeterminedStatusVerification.iterator();
      while (uncheckedMethodOfUndeterminedStatusVerification_it.hasNext()){
        Object arglist[] = {StringHelper.EMPTY_STRING};
        String dBMethod = uncheckedMethodOfUndeterminedStatusVerification_it.next();
        try {
          Method setMethod = fceEligibilityDBClass.getMethod(dBMethod, types);
          setMethod.invoke(fceEligibilityCitizenshipIdentity, arglist);
        } catch (Exception e) {
          throw new IOException("No such method found, or wrong argument types: " + dBMethod + "\n" +
                                "--------------- " + e.getMessage() + "--------------\n");
        }
      }
      if("FCA".equals(cdEventType)){
        saveFceApplication.saveFceApplication(fceApplicationCitizenshipIdentity);
      }
      saveFceEligibility.saveFceEligibility(fceEligibilityCitizenshipIdentity);
      saveFcePerson.saveFcePerson(fcePersonCitizenshipIdentity);
      isUpdateSuccessfull = true;
      ageCitizenshipSaveSO.setUpdateSuccessful(isUpdateSuccessfull);
   } 
    return ageCitizenshipSaveSO;
    
  }
}
