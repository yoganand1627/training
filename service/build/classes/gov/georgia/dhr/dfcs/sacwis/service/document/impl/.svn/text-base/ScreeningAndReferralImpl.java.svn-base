package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.service.document.ScreeningAndReferral;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SCRNREFSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SCRNREFSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ScreeningAndReferralImpl extends BaseDocumentServiceImpl implements ScreeningAndReferral {
  private PlacementDAO placementDAO;
  private PersonDAO personDAO;
  private PersonEthnicityDAO personEthnicityDAO;
  private PersonIdDAO personIdDAO;
  private CpsInvstDetailDAO cpsInvstDetailDAO;
  private LegalStatusDAO legalStatusDAO;
  private RelationshipDAO relationshipDAO;
  private StageDAO stageDAO;
  private StagePersonLinkDAO stagePersonLinkDAO;
  private SafetyResourceChildDAO safetyResourceChildDAO;
  private PersonPhoneDAO personPhoneDAO;
  
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }
  
  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }
  
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  } 
  
  
  public SCRNREFSO retrieveScreeningAndReferral(SCRNREFSI scrnRefsi) {
    
    SCRNREFSO scrnRefso = new SCRNREFSO();
    PreFillData preFillData = new PreFillData();
    Stage stage = (Stage) getPersistentObject(Stage.class, scrnRefsi.getUlIdStage());
    Person caseManager = (Person) getPersistentObject(Person.class, scrnRefsi.getUlIdCaseManager());
    Person child = (Person) getPersistentObject(Person.class, scrnRefsi.getUlIdPerson());
    int idCase = stage.getCapsCase().getIdCase();
    
    populateSectionA(preFillData, child, stage, idCase);
    populateSectionD(preFillData, stage, caseManager);
    populateSectionG(preFillData, stage, child.getIdPerson(), idCase);
    scrnRefso.setPreFillData(preFillData);

    return scrnRefso;
  }

  private void populateSectionD(PreFillData preFillData, Stage stage, Person caseManager) {
    if (caseManager != null) {
      Date today = new Date();
      String caseManagerNm = getFullName(caseManager);
      preFillData.addBookmark(createBookmark(CASE_MANAGER, caseManagerNm));
      List<String> phoneTypes = new ArrayList<String>();
      phoneTypes.add(CodesTables.CPHNTYP_BS); // Business
      phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
      phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
      String managerPhone = getPersonOfficePhoneNbr(caseManager.getIdPerson(), phoneTypes);
      preFillData.addBookmark(createBookmark(MANAGER_PHONE, managerPhone));
      preFillData.addBookmark(createBookmark(TODAY, FormattingHelper.formatDate(today)));
      }
    }
  
  private void populateSectionG(PreFillData preFillData, Stage stage, int idChild, int idCase){

    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPersonIdCase(idChild, idCase);
    if (legalStatus != null) {
      String status = legalStatus.getCdLegalStatStatus();
      if (status != null) {
        preFillData.addBookmark(createBookmark(LEGAL_STATUS, Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT, status)));
      }
    }else{
      preFillData.addBookmark(createBookmark(LEGAL_STATUS, NONE)); 
    }
  }
  
  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {

      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          }
        } else {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          } // inner else
        } // end outer if indPersonPhonePrimary
      } // end if personPhone
    } // end for loop
    return primPersonPhone.toString();

  }
  
  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonLast());
      if (person.getNmPersonFirst() != null) {
        fullName.append(", " + person.getNmPersonFirst());
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" " + person.getNmPersonMiddle().charAt(0));
      }
      if (person.getCdPersonSuffix() != null) {
        fullName.append(" " + person.getCdPersonSuffix());
      }
    }
    return fullName.toString();
  }
  
  /**
   * 
   */
  private void populateSectionA(PreFillData preFillData, Person child, Stage stage, int idCase) {        
    preFillData.addBookmark(createBookmark(CHILD_NAME_LAST, child.getNmPersonLast()));
    preFillData.addBookmark(createBookmark(CHILD_NAME_FIRST, child.getNmPersonFirst()));
    if(child.getNmPersonMiddle()!=null){
    preFillData.addBookmark(createBookmark(CHILD_NAME_MIDDLE, child.getNmPersonMiddle().charAt(0)));
    }
    // For Section E Header
    preFillData.addBookmark(createBookmark(CHILD_NAME, child.getNmPersonFull()));
    int idMother = determineParent(stage, MOTHER, child);
    Person bioMother = getPerson(idMother);
    if(bioMother != null){
      preFillData.addBookmark(createBookmark(MOTHER_LAST_NAME, bioMother.getNmPersonLast()));
      preFillData.addBookmark(createBookmark(MOTHER_LAST_NAME2, bioMother.getNmPersonLast()));
      preFillData.addBookmark(createBookmark(MOTHER_FIRST_NAME, bioMother.getNmPersonFirst()));
      preFillData.addBookmark(createBookmark(MOTHER_FIRST_NAME2, bioMother.getNmPersonFirst()));
      if(bioMother.getNmPersonMiddle()!= null){
      preFillData.addBookmark(createBookmark(MOTHER_MIDDLE_NAME, bioMother.getNmPersonMiddle().charAt(0)));
      preFillData.addBookmark(createBookmark(MOTHER_MIDDLE_NAME2, bioMother.getNmPersonMiddle().charAt(0)));
      }
      preFillData.addBookmark(createBookmark(MOTHER_MADIEN, bioMother.getPersonDtl().getNmPersonMaidenName()));
      
      
      
      // Using different tags for the Section D information in case the manager
      // wants to change on and not the other for some reason 
      preFillData.addBookmark(createBookmark(MOM_NAME, bioMother.getNmPersonFull()));     
      preFillData.addBookmark(createBookmark(MOM_ADDR, bioMother.getAddrPersonStLn1()));
      String address = buildCityCountyStateLine(bioMother);
      preFillData.addBookmark(createBookmark(MOM_ZIP, address));
      preFillData.addBookmark(createBookmark(MOM_PHONE, FormattingHelper.formatPhone(bioMother.getNbrPersonPhone())));      
    }
    int idFather = determineParent(stage, FATHER, child);
    Person bioFather = getPerson(idFather);
    if(bioFather != null){
      preFillData.addBookmark(createBookmark(FATHER_LAST_NAME, bioFather.getNmPersonLast()));
      preFillData.addBookmark(createBookmark(FATHER_FIRST_NAME, bioFather.getNmPersonFirst()));
      if (bioFather.getNmPersonMiddle() != null){
      preFillData.addBookmark(createBookmark(FATHER_MIDDLE_NAME, bioFather.getNmPersonMiddle().charAt(0)));
      }
      // Using different tags for the Section D information in case the manager
      // wants to change on and not the other for some reason 
      preFillData.addBookmark(createBookmark(DAD_NAME, bioFather.getNmPersonFull()));     
      preFillData.addBookmark(createBookmark(DAD_ADDR, bioFather.getAddrPersonStLn1()));
      String address = buildCityCountyStateLine(bioFather);
      preFillData.addBookmark(createBookmark(DAD_ZIP, address));
      preFillData.addBookmark(createBookmark(DAD_PHONE, FormattingHelper.formatPhone(bioFather.getNbrPersonPhone())));
    }
    int idChild = child.getIdPerson();
    // 48644 As per SME if the child is not a safety resource child or placed then do not display 
    // the primary caretakers name for Safety Resource /Foster Parent/Facility Name:. 
    boolean isSrChild = false;
    Person careTaker = determineChildAddress(idChild, idCase, preFillData, stage, isSrChild);
    if(careTaker != null){
      preFillData.addBookmark(createBookmark(CHILD_ADDRESS , careTaker.getAddrPersonStLn1()));
      preFillData.addBookmark(createBookmark(CHILD_CITY , careTaker.getAddrPersonCity()));
      preFillData.addBookmark(createBookmark(CHILD_STATE ,careTaker.getCdPersonState()));
      preFillData.addBookmark(createBookmark(CHILD_ZIP , careTaker.getAddrPersonZip()));
      preFillData.addBookmark(createBookmark(CHILD_COUNTY , Lookup.simpleDecodeSafe(CodesTables.CCOUNT, careTaker.getCdPersonCounty())));
      String primaryPhone = retrievePrimaryPersonPhoneData(careTaker.getIdPerson());
      preFillData.addBookmark(createBookmark(CHILD_PHONE , FormattingHelper.formatPhone(primaryPhone)));
      String emerPhone = personPhoneDAO.findNbrPersonPhoneByIdPersonAndPhoneType(careTaker.getIdPerson(), CodesTables.CPHNTYP_EM);
      preFillData.addBookmark(createBookmark(CHILD_EMG_PHONE , FormattingHelper.formatPhone(emerPhone)));
      if(isSrChild){
      preFillData.addBookmark(createBookmark(GUARDIAN, careTaker.getNmPersonFull()));
      }
    }
      preFillData.addBookmark(createBookmark(CHILD_SEX, Lookup.simpleDecodeSafe(CodesTables.CSEX , child.getCdPersonSex())));
      preFillData.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(child.getDtPersonBirth())));
      preFillData.addBookmark(createBookmark(PRIM_LANGUAGE,Lookup.simpleDecodeSafe(CodesTables.CLANG , child.getCdPersonLanguage())));
      populateRace(child, preFillData);
      String childNbrMedicaid = personIdDAO.findNonEndDatePersonMedicaid(child.getIdPerson());
      if(childNbrMedicaid != null){
        preFillData.addBookmark(createBookmark(CHILD_MED_NUM , childNbrMedicaid)); 
        preFillData.addBookmark(createBookmark(MEDICAID_CHK, CHECKED));
      }
      
      List<PersonEthnicity> personEthnicities = personEthnicityDAO.findPersonEthnicityByIdPerson(idChild);
      if(personEthnicities != null && !personEthnicities.isEmpty()){
        Iterator<PersonEthnicity> it = personEthnicities.iterator();
      PersonEthnicity personEthnicity = it.next();
       String cdEthnicity = personEthnicity.getCdEthnicity();
        if (CodesTables.CINDETHN_HS.equals(cdEthnicity)) {
        preFillData.addBookmark(createBookmark(HIS_YES, CAPX));
        preFillData.addBookmark(createBookmark(HIS_NO, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(HIS_UNKNOWN, DOUBLEUNDERSCORE));
      } else if (CodesTables.CINDETHN_NH.equals(cdEthnicity)) {
        preFillData.addBookmark(createBookmark(HIS_NO, CAPX));
        preFillData.addBookmark(createBookmark(HIS_YES, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(HIS_UNKNOWN, DOUBLEUNDERSCORE));
      } else {
        // 49087 client want unable to determine to read unknown and display on form.
        preFillData.addBookmark(createBookmark(HIS_UNKNOWN, CAPX));
        preFillData.addBookmark(createBookmark(HIS_NO, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(HIS_YES, DOUBLEUNDERSCORE));
      }
      }
      
      if(bioMother!= null){
      preFillData.addBookmark(createBookmark(MOTHER_AGE , DateHelper.getAge(bioMother.getDtPersonBirth())));
      preFillData.addBookmark(createBookmark(MOTHER_DOB , FormattingHelper.formatDate(bioMother.getDtPersonBirth())));
      preFillData.addBookmark(createBookmark(MOTHER_EDU , Lookup.simpleDecodeSafe(CodesTables.CHIGHEDU, bioMother.getPersonDtl().getCdPersonHighestEduc())));
      preFillData.addBookmark(createBookmark(MARTIAL_STATUS , Lookup.simpleDecodeSafe(CodesTables.CMARSTAT, bioMother.getCdPersonMaritalStatus()))); 
      String nbrMedicaid = personIdDAO.findNonEndDatePersonMedicaid(bioMother.getIdPerson());
      preFillData.addBookmark(createBookmark(MOTHER_MED_NUM , nbrMedicaid));   
      
      
      } 
      
      
    }
    
  private String buildCityCountyStateLine(Person person) {
    StringBuffer addressBuffer = new StringBuffer();

    if (person != null) {
      String city = person.getAddrPersonCity();
      if (city == null) {
        city = SPACE;
      }
      String county = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, person.getCdPersonCounty());
      if (county == null) {
        county = SPACE;
      }
      String state = person.getCdPersonState();
      if (state == null) {
        state = "GA";
      }
      String zipCode = person.getAddrPersonZip();
      if (zipCode == null) {
        zipCode = SPACE;
      }
      if(!(SPACE.equals(city) && SPACE.equals(county)  && SPACE.equals(zipCode))){
      addressBuffer.append(city + ", " + county + ", " + state + SPACE + zipCode);
      }
    }

    return addressBuffer.toString();
  }

  private void populateRace(Person child, PreFillData preFillData){
    Collection<PersonRace> races = child.getPersonRaces();

    if (races != null && !races.isEmpty()) {
      
      if (races.size() < 2) {
      for (Iterator<PersonRace> it = races.iterator(); it.hasNext();) {

     

          PersonRace race = it.next();
          String cdRace = race.getCdRace();
          if (AMERICAN_INDIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_INDIAN, CHECKED));
          } else if (ASIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_ASIAN, CHECKED));
          } else if (BLACK.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_BLACK, CHECKED));
          } else if (HAWAIIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_HAWAIIAN, CHECKED));
          } else if (WHITE.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_WHITE, CHECKED));
          } else if (UNKNOWN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_UNKNOWN, CHECKED));
          }

        } 
      }else {
        preFillData.addBookmark(createBookmark(RACE_MULTI, CHECKED));
      }
    }
  }
  
  private String retrievePrimaryPersonPhoneData(int idPerson) {
    String phoneNbr = null;
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    PersonPhone personPhone = null;
    if (idPerson != 0) {
      personPhone = personPhoneDAO.findPersonPhoneByIdPersonAndMaxDate(idPerson, maxDate);
    }

    if (personPhone != null) {
      phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
    }
    return phoneNbr;
  }
  
  /* Method used to determine the child's address and phone by looking to see if there is a safety resource placement.
   * Then checking for a Foster Care Placement and if neither exist then checking for the PK Address 
   */
  private Person determineChildAddress(int idChild, int idCase, PreFillData preFillData, Stage stage, boolean isSrChild ) {
    Person careTaker = null;
   List<SafetyResourceChild> srChildern = safetyResourceChildDAO.findOpenSafetyResourcesForChild(idChild);
   Date today = new Date();
   List<String> excludeTypes = new ArrayList<String>();
   excludeTypes.add(CodesTables.CTMPLTYP_RED);
   excludeTypes.add(CodesTables.CTMPLTYP_REN);
   excludeTypes.add(CodesTables.CTMPLTYP_COR);
   Placement placement = placementDAO.findPlcmtByIdPlcmtChildByIdCaseNonRes(idCase, idChild,excludeTypes , today);
   String cdStage = stage.getCdStage();
   int idStage = stage.getIdStage();
   if(srChildern != null && !srChildern.isEmpty()){
     // Finding first open Safety Resource Placement that is not ended.
     SafetyResourceChild srChild = srChildern.get(0);
     int primarySR = srChild.getSafetyResource().getIdPrimary();
     careTaker = getPerson(primarySR);
     if(careTaker != null){
       isSrChild = true;
       return careTaker;
     }
   }else if(placement!= null){
     preFillData.addBookmark(createBookmark(CHILD_ADDRESS , placement.getAddrPlcmtLn1()));
     preFillData.addBookmark(createBookmark(CHILD_CITY , placement.getAddrPlcmtCity()));
     preFillData.addBookmark(createBookmark(CHILD_STATE , placement.getAddrPlcmtSt()));
     preFillData.addBookmark(createBookmark(CHILD_ZIP , placement.getAddrPlcmtZip()));
     preFillData.addBookmark(createBookmark(CHILD_COUNTY , Lookup.simpleDecodeSafe(CodesTables.CCOUNT, placement.getAddrPlcmtCnty())));
     String placementPhone = FormattingHelper.formatPhone(placement.getNbrPlcmtTelephone());
     preFillData.addBookmark(createBookmark(CHILD_PHONE , placementPhone));
     preFillData.addBookmark(createBookmark(GUARDIAN , placement.getNmPlcmtFacil())); 
     if(CHILD_PROTECT_AGENCY.equals(placement.getCdPlcmtType())){
       preFillData.addBookmark(createBookmark(AGENCY , placement.getNmPlcmtAgency()));
     }
     return null; // Address Bookmarks populated here and does not need to return a person object. 
   }else if(CodesTables.CSTAGES_INV.equals(cdStage) || CodesTables.CSTAGES_FPR.equals(cdStage) ){
    // if there is no placement with the safety resource or FCC placement then display caretakers address and phone information.  
     careTaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(idStage);
    // 48644 As per SME if the child is not a safety resource child or placed then do not display 
    // the primary caretakers name for Safety Resource /Foster Parent/Facility Name:. 
     isSrChild = false;
   }
    return careTaker;
  }

  private Person getPerson(int idPerson) {
   Person person = personDAO.findPersonByIdPerson(idPerson);
    return person;
  }

  /*
   * Method to Determines the proper parent.  When launched from the Investigation, Ongoing or FCF stage
   * Then information should be pulled from child's Person Detail page.  If launched from the FCC, Adoption,
   * or Post Foster Care then then information comes from stage person link
   */
  private int determineParent(Stage stage, String parentType, Person child) {
    int idParent = 0;
    String stageType = stage.getCdStage();
    int idChild = child.getIdPerson();
    int idStage = stage.getIdStage();
    
   

    HashMap<String, String> personRelationMap = new HashMap<String, String>();
    personRelationMap.put("INV", CodesTables.CSTAGES_INV);
    personRelationMap.put("FPR", CodesTables.CSTAGES_FPR); // CPS Ongoing
    personRelationMap.put("FSU", CodesTables.CSTAGES_FSU); // Foster Care Family

    if (personRelationMap.containsKey(stageType)) {
      if (MOTHER.equals(parentType)) { 
        Integer momInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, BIOLOGICAL_MOTHER);
        idParent = (momInteger!= null)? momInteger.intValue() : 0;  

      } else if (FATHER.equals(parentType)) {
        Integer dadInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, BIOLOGICAL_FATHER);
        idParent = (dadInteger!= null)? dadInteger.intValue() : 0; 
      }
    } else { // if stage is FCC, ADO, or PFC(current other stages)
      if (MOTHER.equals(parentType)) {
        StagePersonLink bioMotherStagePersonLink = stagePersonLinkDAO
                                                                     .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(
                                                                                                                          idStage,
                                                                                                                          BIOLOGICAL_MOTHER);
        if (bioMotherStagePersonLink != null) {
          idParent = bioMotherStagePersonLink.getPerson().getIdPerson();
        }
      } else if (FATHER.equals(parentType)) {
        StagePersonLink bioFatherStagePersonLink = stagePersonLinkDAO
                                                                     .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(
                                                                                                                          idStage,
                                                                                                                          BIOLOGICAL_FATHER);
        if (bioFatherStagePersonLink != null) {
          idParent = bioFatherStagePersonLink.getPerson().getIdPerson();
        } else {
          StagePersonLink bioLegFatherStagePersonLink = stagePersonLinkDAO
                                                                          .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(
                                                                                                                               idStage,
                                                                                                                               BIOLEGAL_FATHER);
          if (bioLegFatherStagePersonLink != null) {
            idParent = bioLegFatherStagePersonLink.getPerson().getIdPerson();
          }
        }
      }
    }
    return idParent;
  }
  
  
  
  
  
}