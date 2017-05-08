
package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PsaPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.service.external.PhoneticSearchService;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonSearch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;


/*Change History:
 **  Date        User              Description
 **  --------    ----------------  ---------------------------------------------                                
 *   04/01/2008  Charden           STGAP00006396: Wrote code in the partial name search section to compare      
 *                                 returned records, get rid of duplicates and set SzNmPersonFull
 *                                 to SzNmIncmgPersFull in outRec                                   
 *   04/02/2008  Charden           STGAP00006325: Passed extra parameter to filterPersonSearchOutRecByGenderAge
 *                                 and added extra filters to filter records by age. Also wrote additional code
 *                                 in if statements in filterPersonSearchOutRecByGenderAge and filterPersonSearchOutRecByGenderDob
 *                                 to get rid of null pointer exceptions                                                
 *   10/28/2008  SSUBRAM           STGAP00010705: If a child has been marked as adoption finalized, 
 *                                 their pre-adoptive record will not show up for general users.  
 *                                 Only users with the SAU Sealed attribute will be able to search, 
 *                                 and receive results, for a child pre-adoptive name. 
 *   12/19/08    charden           STGAP00009174: calling constructor on prsnSearchOutRec_ARRAY before assigning a value so that null pointer 
 *                                 exception will not be thrown during phonetic search 
 *   12/31/08    charden           STGAP00009110:     
 *   05/06/09    hjbaptiste        STGAP00013423 - Modified populatePersonSearchOutRec(). Removed hard-coded for loop by reverting to previous version                                                       
 *   10/25/09    mxpatel           38626: Added searchAddress method to retrieve address from address_person_link table when a person does not have an 
 *                                 address in the person_enc table. Added null checks where necessary.
 */



public class RetrievePersonSearchImpl extends BaseServiceImpl implements RetrievePersonSearch {

  public static final int ADULT_AGE_RANGE_START = 18;

  public static final int ADULT_AGE_RANGE_VALUE = 10;

  public static final int CHILD_AGE_RANGE_VALUE = 3;

  public static final String CD_STATUS_MERGED = "M";

  public static final String EMPLOYEE_CATEGORY = "EMP";

  public static final int FULL_NAME_LEN = 26;

  public static final int WW_RANGE_RETURNED = 5;

  public static final int WI_RANGE_RETURNED = 4;

  public static final int W_RANGE_RETURNED = 3;

  public static final char OPTION_CHECKED = 'Y';

  public static final long NAME_TOO_COMMON_THRESHOLD = 1000;

  public static final double AGE_TOLERANCE = (double) (60 * 24 * 365 * 3); // 3 yrs

  private NameDAO nameDAO = null;

  private ComplexNameDAO complexNameDAO = null;

  private DynamicPersonAddressDAO dynamicPersonAddressDAO = null;

  private PersonDAO personDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonMergeDAO personMergeDAO = null;

  private PhoneticSearchService phoneticSearchService = null;

  private PsaPersonLinkDAO psaPersonLinkDAO;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setDynamicPersonAddressDAO(DynamicPersonAddressDAO dynamicPersonAddressDAO) {
    this.dynamicPersonAddressDAO = dynamicPersonAddressDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setComplexNameDAO(ComplexNameDAO complexNameDAO) {
    this.complexNameDAO = complexNameDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public void setPsaPersonLinkDAO(PsaPersonLinkDAO psaPersonLinkDAO) {
    this.psaPersonLinkDAO = psaPersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPhoneticSearchService(PhoneticSearchService phoneticSearchService) {
    this.phoneticSearchService = phoneticSearchService;
  }

  public PersonSearchOutRec retrievePersonSearch(PersonSearchInRec personSearchInRec) throws ServiceException {
    ArchInputStruct archInputStruct = personSearchInRec.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    // retrievePrsnSearch replaces CallCINT23D();
    PersonSearchOutRec personSearchOutRec = retrievePrsnSearch(personSearchInRec, pageNbr, pageSize);

    // retrievePersonMergeIndicator replacing CallCMSC49D
    //retrievePersonMergeIndicator(personSearchOutRec);
    retrievePersonMergeIndicatorByPersonList(personSearchOutRec);

    //retrievePsaIndicator(personSearchOutRec);
    retrievePsaIndicatorByPersonList(personSearchOutRec);

    retrieveAdoptedIndicator(personSearchOutRec);

    //callCINT72D(personSearchOutRec);
    callCINT72DByPersonList(personSearchOutRec);

    // setPersonActiveStatusByCategory replacing CallCINV29D
    //setPersonActiveStatusByCategory(personSearchOutRec, pageNbr, pageSize);
    setPersonActiveStatusByCategoryByPersonList(personSearchOutRec);

    if (personSearchOutRec.getPrsnSearchOutRec_ARRAY() == null) {
      PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
      personSearchOutRec.setPrsnSearchOutRec_ARRAY(prsnSearchOutRec_ARRAY);
    }

    return personSearchOutRec;
  }

  @SuppressWarnings("unchecked")
  private PersonSearchOutRec retrievePrsnSearch(PersonSearchInRec personSearchInRec, int pageNbr, int pageSize) {

    PrsnSearchInRec prsnSearchInRec = personSearchInRec.getPrsnSearchInRec();
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();
    boolean bPhoneticOnly;
    //STGAP00010705: Get the Sealed Indicator
    String indSealed = prsnSearchInRec.getBIndSealed();
    // If the phonetic box is checked, then set bPhoneticOnly = TRUE
    if ((OPTION_CHECKED == prsnSearchInRec.getBScrPhoneticChk().charAt(0))
        && (OPTION_CHECKED != prsnSearchInRec.getBScrAddressChk().charAt(0))
        && (OPTION_CHECKED != prsnSearchInRec.getBScrAdditParametersChk().charAt(0))) {
      bPhoneticOnly = true;
    }
    // Additional Parameters is checked and no premptive additional parameters were actually
    // entered. Still set bPhoneticOnly = TRUE since it is actually Phonetic selected
    else if ((OPTION_CHECKED == prsnSearchInRec.getBScrPhoneticChk().charAt(0))
             && (OPTION_CHECKED != prsnSearchInRec.getBScrAddressChk().charAt(0))
             && (OPTION_CHECKED == prsnSearchInRec.getBScrAdditParametersChk().charAt(0))
             && (0 == prsnSearchInRec.getSzNbrPersonIdSsn().length()) && (0 == prsnSearchInRec.getUlIdPerson())
             && (0 == prsnSearchInRec.getNbrMedicaidNo().length()) 
             && (0 == prsnSearchInRec.getUlIdStage())) {
      bPhoneticOnly = true;
    }
    // Other search options or Phonetic plus additional options
    else {
      bPhoneticOnly = false;
    }

    // Phonetic search only
    if (bPhoneticOnly) {
      // NameSearch
      personSearchOutRec = searchPhonetic(personSearchInRec, pageNbr, pageSize);
    }
    // Other search options or Phonetic plus additional options
    else {
      // Retrieving input data
      int personAge = prsnSearchInRec.getLNbrPersonAge();
      String personSex = prsnSearchInRec.getCCdPersonSex();
      String nmLast = prsnSearchInRec.getSzNmNameLast();
      String nmMiddle = prsnSearchInRec.getSzNmNameMiddle();
      String nmFirst = prsnSearchInRec.getSzNmNameFirst();
      Date personBirth = DateHelper.toJavaDate(prsnSearchInRec.getDtDtPersonBirth());

      // set up indicator for Person Information fields' status
      boolean bGenderEntered = false;
      boolean bAgeEntered = false;
      boolean bDobEntered = false;
      boolean done = false; // data found, ready to populate the output rec
      boolean bSearch = false; // a search was already carried out, to prevent another search called
      Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      Date birthDate = new Date();

      if (personSex != null && personSex.length() != 0) {
        bGenderEntered = true;
      }
      if (personAge != 0) {
        bAgeEntered = true;
      }
      // (DateHelper.isNull(personBirth)) is equal to false when personBirth is not null, be careful
      // age entered but not birthdate, calculate approx. birthdate
      boolean b = DateHelper.isNull(personBirth);  
      if (DateHelper.isNull(personBirth) && personAge > 0) {
        personBirth = currentDate;
        int yearsToAdd = 0 - personAge;
        birthDate = DateHelper.addToDate(currentDate, yearsToAdd, 0, 0);
        bAgeEntered = true;
      }
      // birthdate was entered
      else if (!DateHelper.isNull(personBirth)) {
        bDobEntered = true;
        birthDate = personBirth;
      }

      // Phonetic checked
      if (OPTION_CHECKED == prsnSearchInRec.getBScrPhoneticChk().charAt(0)) {
        personSearchOutRec = searchPhonetic(personSearchInRec, pageNbr, pageSize);
        done = true;
        bSearch = true;
      }
      // Addtitonal Parameters checked
      else if (OPTION_CHECKED == prsnSearchInRec.getBScrAdditParametersChk().charAt(0)) {
        // bSearch = true;
        int idPerson = prsnSearchInRec.getUlIdPerson();
        String idSsnStr = prsnSearchInRec.getSzNbrPersonIdSsn();
        int idIntakeReport = prsnSearchInRec.getUlIdStage();
        String nbrMedicaid = prsnSearchInRec.getNbrMedicaidNo();
        done = false;

        // Id person entered, highest priority in search
        if (idPerson != 0) {
          Person personByIdPerson = personDAO.findPersonByIdPerson(idPerson);
          if (personByIdPerson != null) {
            personSearchOutRec = populatePersonSearchOutRec(personByIdPerson, "PARA");
            done = true;
            searchAddress(personSearchOutRec);
            bSearch = true;
          }
        }
        // SSN search
        //STGAP00009110 - created and called new method createPersonList() to convert list of objects into list of 
        //persons
        else if (idSsnStr != null && idSsnStr.length() != 0) {
          List<Object[]> objectList = personDAO.findPersonBySsn(idSsnStr);
          List<Person> personBySsn = createPersonList(objectList);
          if (personBySsn != null) {
            personSearchOutRec = populatePersonSearchOutRec(personBySsn, "PARA");
            done = true;
            searchAddress(personSearchOutRec);
            bSearch = true;
          }
        }
        // Medicaid number search
        //STGAP00009110 - created and called new methods paginatedList() and createPersonMapFromQuery() to set query 
        //attributes and convert the list of objects[] into a PaginatedHibernateList of maps
        else if (nbrMedicaid != null && nbrMedicaid.length() != 0) {
          PaginatedHibernateList<Map> personList;
          List mapList;
          List<String> idTypes = new ArrayList<String>();
          idTypes.add(CodesTables.CNUMTYPE_CRS_IDNUMBER);
          idTypes.add(CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER);
          
          Query query = personDAO.findPersonsByPersonIdByNbrAndType(nbrMedicaid, idTypes, 
                                                                                               pageNbr, pageSize);
          mapList = (List<Object[]>) paginatedList(pageNbr, pageSize, query);
          personList = createPersonMapFromQuery(mapList, pageNbr, pageSize);
          if (personList != null && personList.size() != 0) {
            personSearchOutRec = populatePersonSearchOutRec(personList, null);
            done = true;
            searchAddress(personSearchOutRec);
            bSearch = true;
          }
        }
        // Intake report number search
        else if (idIntakeReport != 0) {
          PaginatedHibernateList<Map> personList = personDAO.findPersonsByStagePersonLinkByIdStage(idIntakeReport,
                                                                                                   pageNbr, pageSize);
          if (personList != null && personList.size() != 0) {
            personSearchOutRec = populatePersonSearchOutRec(personList, null);
            done = true;
            searchAddress(personSearchOutRec);
            bSearch = true;
          }
        }
      }
      // Fullname search option selected
      else if (OPTION_CHECKED == prsnSearchInRec.getBScrFullNameChk().charAt(0)) {
        bSearch = true;
        done = false;
        PaginatedHibernateList<Map> personList;
        //STGAP00010705: Filter Adopted person based on the sealed Indicator.
        List<Integer> idPersonLists = complexNameDAO.findPrimaryIdPersonsByFirstLastMiddle(nmFirst, nmLast, nmMiddle, indSealed);
        if (idPersonLists != null && !idPersonLists.isEmpty()) {
          personList = personDAO.findPersonsByIdPersons(pageNbr, pageSize, idPersonLists);
          if (personList == null || personList.isEmpty() || personList.size() == 0) {
            throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND); // very unlikely
          }
          personSearchOutRec = populatePersonSearchOutRec(personList, null);
          done = true;
          searchAddress(personSearchOutRec);
        }
      }
   // Partial name search option selected
      else if ((ArchitectureConstants.Y).equals(prsnSearchInRec.getScrPartlNameChk())) {
        bSearch = true;
        int subLenFirst = (nmFirst.length() > 3) ? 3 : nmFirst.length();
        int subLenLast = (nmLast.length() > 3) ? 3 : nmLast.length();
        String nmLast3 = nmLast.substring(0, subLenLast);
        String nmFirst3 = nmFirst.substring(0, subLenFirst);
        done = false;
        PaginatedHibernateList<Map> personList;
        //STGAP00010705: Filter Adopted person based on the sealed Indicator.
        List<Integer> idPersonLists = complexNameDAO.findPersonsByNmLastNmFirst3(nmLast3, nmFirst3, indSealed);
        if (idPersonLists != null && !idPersonLists.isEmpty()) {
          if (idPersonLists.size() >= NAME_TOO_COMMON_THRESHOLD) {
            throw new ServiceException(Messages.MSG_CMN_TOO_MANY_RECORDS);
          }
          personList = personDAO.findPersonsByIdPersons(pageNbr, pageSize, idPersonLists);
          if (personList == null || personList.isEmpty() || personList.size() == 0) {
            throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND); // very unlikely
          }
          personSearchOutRec = populatePersonSearchOutRec(personList, null);
          PrsnSearchOutRec_ARRAY tempPersonArray = new PrsnSearchOutRec_ARRAY();

          if (personList != null && personList.size() != 0) {
          }
          searchAddress(personSearchOutRec);
          PrsnSearchOutRec_ARRAY personArray = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
          if (personArray != null) {

            Enumeration e = personArray.enumeratePrsnSearchOutRec();
            int array[] = new int[66];

            // this code compares the personId's in each record and if a duplicate exists, it
            //removes the duplicate and sets SzNmPersonFull to SzNmIncmgPersFull to display the
            //proper name

            for (int i = 0; e.hasMoreElements() && i < 65; i++) {
              PrsnSearchOutRec personSearchList = (PrsnSearchOutRec) e.nextElement();
              // int idPerson = personSearchList.getUlIdPerson();
              int toArray = personSearchList.getUlIdPerson();
              array[i] = toArray;
              if (i == 0){
                tempPersonArray.addPrsnSearchOutRec(personSearchList);
              }
              else if (i > 0 && array[i] != array[i - 1]){
                tempPersonArray.addPrsnSearchOutRec(personSearchList);
              }
              //it should never go through this else
              else if (i > 0 && array[i] == array[i - 1]) {
                personSearchList.setSzNmPersonFull(personSearchList.getSzNmIncmgPersFull());
                tempPersonArray.addPrsnSearchOutRec(personSearchList);
                tempPersonArray.setPrsnSearchOutRec(i - 1, tempPersonArray.getPrsnSearchOutRec(i));
                tempPersonArray.removePrsnSearchOutRecAt(i);
                i--;
              }
            }
            personSearchOutRec.setPrsnSearchOutRec_ARRAY(tempPersonArray);
            done = true;

          }
        }
      }
      // DOB search option selected - this is exact DOB search
      else if (ArchitectureConstants.Y.equals(prsnSearchInRec.getBUNKNOWNDOBSEARCH())) {
        bSearch = true;
        done = false;
        PaginatedHibernateList<Map> personList = personDAO.findPersonsByDob(personBirth, pageNbr, pageSize);
        if (personList != null && personList.size() != 0) {
          personSearchOutRec = populatePersonSearchOutRec(personList, null);
          done = true;
          searchAddress(personSearchOutRec);
        }
      }
      // if search carried out (bSearch = true) and there exists match (done is true)
      // then filter result if needed
      if (done && (ArchitectureConstants.N).equals(prsnSearchInRec.getBUNKNOWNDOBSEARCH())) {
        if (bAgeEntered && bGenderEntered) {
          personSearchOutRec = filterPersonSearchOutRecByGenderAge(personSearchOutRec, personSex, birthDate, personAge);
        } else if (bAgeEntered) {
          personSearchOutRec = filterPersonSearchOutRecByGenderAge(personSearchOutRec, null, birthDate, personAge);
        }
        // gender entered as search parameter
        else {
          // filter by exact birth date (disregard age info if exists)
          if (bDobEntered) {
            personSearchOutRec = filterPersonSearchOutRecByGenderDob(personSearchOutRec, personSex, birthDate);
          }
          // filter by gender only
          else if (bGenderEntered) {
            personSearchOutRec = filterPersonSearchOutRecByGenderAge(personSearchOutRec, personSex, null, personAge);
          }
        }
      }

      // Address search selected
      // Address search is not combined with other search selection (only search when no other search
      // has been run (bSearch = false)
      if (OPTION_CHECKED == prsnSearchInRec.getBScrAddressChk().charAt(0) && !bSearch) {
        String addrStLn1 = prsnSearchInRec.getSzAddrPersAddrStLn1();
        String addrStLn2 = prsnSearchInRec.getSzAddrPersAddrStLn2();
        String city = prsnSearchInRec.getSzAddrCity();
        String county = prsnSearchInRec.getSzCdAddrCounty();
        String state = prsnSearchInRec.getSzCdAddrState();
        String zip = prsnSearchInRec.getLAddrZip();

        PaginatedHibernateList<Map> personList = dynamicPersonAddressDAO.findPersonsByAddr(addrStLn1, addrStLn2, city,
                                                                                           county, state, zip, pageNbr,
                                                                                           pageSize);

        if (personList != null && personList.size() != 0) {
          personSearchOutRec = populatePersonSearchOutRec(personList, null);
          bSearch = true;
        }
      }
      String nbrPhone = prsnSearchInRec.getLNbrPhone();
      // Separate case for phone since it has the lowest priority when others entered
      // Only run if none of the searches has been run (done = false)
      if (!bSearch && OPTION_CHECKED == prsnSearchInRec.getBScrAdditParametersChk().charAt(0)
          && (nbrPhone != null && nbrPhone.length() != 0)) {
        PaginatedHibernateList<Map> personList = personDAO.findPersonsByPhoneNum(nbrPhone, pageNbr, pageSize);
        if (personList != null && personList.size() != 0) {
          personSearchOutRec = populatePersonSearchOutRec(personList, null);
          searchAddress(personSearchOutRec);
          bSearch = true;
        }
      }
      /**
       * an else clause for when bSearch = true and phone entered is a good future enhancement when phone is used to
       * filter, then call filter function on existing match set instead of retrieving to produce a new match set
       */
    }

    return personSearchOutRec;
  }

  private boolean searchAddress(PersonSearchOutRec personSearchOutRec) {
    PrsnSearchOutRec_ARRAY personArray = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    boolean done = false;
    if (personArray != null) {

      Enumeration e1 = personArray.enumeratePrsnSearchOutRec();
      for (int i = 0; e1.hasMoreElements() && i < 65; i++) {
        PrsnSearchOutRec personSearchList = (PrsnSearchOutRec) e1.nextElement();
        if (personSearchList.getSzAddrPersAddrStLn1() == null && personSearchList.getSzAddrCity() == null
            && personSearchList.getSzCdCounty() == null) {
          int toArray = personSearchList.getUlIdPerson();
          Integer idPersonAddress = personDAO.findIdPersonAddressByIdPerson(toArray);
          if (idPersonAddress != null) {
            PersonAddress personAddress = personAddressDAO.findPersonAddressByIdPersonAddress(idPersonAddress);
            if (personAddress != null) {
              personSearchList.setSzAddrCity(personAddress.getAddrPersonAddrCity());
              personSearchList.setSzCdCounty(personAddress.getCdPersonAddrCounty());
              personSearchList.setSzAddrPersAddrStLn1(personAddress.getAddrPersAddrStLn1());
            }
          }
        }
      }
      done = true;
    }
    return done;
  }

  private PersonSearchOutRec searchPhonetic(PersonSearchInRec personSearchInRec, int pageNbr, int pageSize) {

    PrsnSearchInRec prsnSearchInRec = personSearchInRec.getPrsnSearchInRec();
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();

    boolean bAgeDobEntered = false; // 
    boolean bGenderEntered = false;
    boolean bDobEntered = false;
    List<Integer> idNameList = new ArrayList<Integer>();

    /*
     * If age is entered calculate birthdate. This is done because age and birthdate are mutually exclusive. If age is
     * entered, determine an approximate DOB to pass into the new MATCH service of SSA-NAME3 for scoring. After DOB is
     * determined or when DOB is entered on window, then determine DOB range to be used in finding matches and scoring
     */
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    Date personBirthDate = DateHelper.toJavaDate(prsnSearchInRec.getDtDtPersonBirth());
    Date personCalculatedBirthDate;
    Date birthDate = new Date();
    int personAge = prsnSearchInRec.getLNbrPersonAge();
    String personSex = prsnSearchInRec.getCCdPersonSex();

    String nmLast = prsnSearchInRec.getSzNmNameLast();
    String nmMiddle = prsnSearchInRec.getSzNmNameMiddle();
    String nmFirst = prsnSearchInRec.getSzNmNameFirst();
    //STGAP00010705: Get the Sealed Indicator
    String indSealed = prsnSearchInRec.getBIndSealed();
    long countName = nameDAO.countNameIdNameByNmFull(nmFirst, nmMiddle, nmLast);

    if (countName >= NAME_TOO_COMMON_THRESHOLD) {
      throw new ServiceException(Messages.MSG_NAME_TOO_COMMON);
    }

    if (personSex != null && personSex.length() > 0) {
      bGenderEntered = true;
    }

    // age is entered but not birthdate, calculate birth date
    if (DateHelper.isNull(personBirthDate) && personAge > 0) {
      int yearsToAdd = 0 - personAge;
      personCalculatedBirthDate = DateHelper.addToDate(currentDate, yearsToAdd, 0, 0);
      bAgeDobEntered = true;
      birthDate = personCalculatedBirthDate;
    } else if (!DateHelper.isNull(personBirthDate)) {
      bAgeDobEntered = true;
      bDobEntered = true;
      birthDate = personBirthDate;
    }

    NameSearchQuery nameSearchQuery = new NameSearchQuery();
    nameSearchQuery.setSearchScope(PhoneticSearchQuery.SEARCH_TYPICAL);
    nameSearchQuery.setMatchTolerance(PhoneticSearchQuery.MATCH_TYPICAL);
    nameSearchQuery.setFirstName(personSearchInRec.getPrsnSearchInRec().getSzNmNameFirst());
    nameSearchQuery.setLastName(personSearchInRec.getPrsnSearchInRec().getSzNmNameLast());
    nameSearchQuery.setMiddleName(personSearchInRec.getPrsnSearchInRec().getSzNmNameMiddle());
    try {
      if (StringHelper.isValid(nameSearchQuery.getFirstName()) || StringHelper.isValid(nameSearchQuery.getLastName())
          || StringHelper.isValid(nameSearchQuery.getMiddleName())) {
        PhoneticSearchResultSet searchResults = phoneticSearchService.executeSearch(nameSearchQuery);
        HashMap<Integer, Integer> scoreMap = searchResults.getScore();
        
        // First filter - using entered Person Information data if entered
        // add to list when a match is found
        while (searchResults.next()) {
          int idName = Integer.parseInt(searchResults.getField("ID_NAME"));
          String gender = searchResults.getField("CD_PERSON_SEX");
          String mergeStatus = searchResults.getField("CD_PERSON_STATUS");//mxpatel added this
          Date dob = DateHelper.toJavaDate(searchResults.getDate("DT_PERSON_BIRTH"));
          //STGAP00010705: Filter Adopted person based on the sealed Indicator.
          String indAdopted = searchResults.getField("IND_ADOPTED");
          if(ArchitectureConstants.N.equals(indSealed)&& StringHelper.isValid(indAdopted) &&
                          ArchitectureConstants.Y.equals(indAdopted)){
            continue;
          }
          if("M".equals(mergeStatus)){ //mxpatel added this
            continue;
          }
          // No Person Information data entered
          if (!bAgeDobEntered && !bGenderEntered) {
            idNameList.add(idName);
          }
          // Filter with age, DOB, and gender
          else if (bAgeDobEntered && bGenderEntered) {
            if (dob != null) {
              // if DOB entered, it has to be exact match to add to list
              if (bDobEntered) {
                if (gender.equals(personSex) && dob.compareTo(birthDate) == 0) {
                  idNameList.add(idName);
                }
              }
              // if only age entered then all persons whose birth date vary by AGE_TOLERANCE value
              // from calculated birthDate are accepted
              else {
                double ageDiff = DateHelper.minutesDifference(dob, birthDate);
                double ageDiff2 = ageDiff >= 0.0 ? ageDiff : -ageDiff;
                if (gender.equals(personSex) && ageDiff2 <= AGE_TOLERANCE) {
                  idNameList.add(idName);
                }
              }
            }
          }
          // Filter with Gender only
          else if (bGenderEntered) {
            if (gender.equals(personSex)) {
              idNameList.add(idName);
            }
          }
          // Filter with Age and/or DOB
          else { // only ageDobEntered
            if (dob != null) {
              // if DOB entered, disregard age info if exists
              if (bDobEntered) {
                if (dob.compareTo(birthDate) == 0) {
                  idNameList.add(idName);
                }
              }
              // DOB not entered, calculate birth date from age, compare with retrieved DOB
              // if difference within AGE_TOLERANCE, accept the person into filtered (idName) list
              else {
                double ageDiff = DateHelper.minutesDifference(dob, birthDate);
                double ageDiff2 = ageDiff >= 0.0 ? ageDiff : -ageDiff;
                if (ageDiff2 <= AGE_TOLERANCE) {
                  idNameList.add(idName);
                }
              }
            }
          }
        }
        
        // retrieve match's personal info (address, merge, etc.) through join tables to ensure data accuracy
        // and its up-to-date
        // Person Detail table does not contain the most up-to-date on several fields
        // Most use is to verify an id person exist in the system
        if (idNameList != null && !idNameList.isEmpty()) {
          //PaginatedHibernateList<Map> personList = personDAO.findPersonsByIdNames(pageNbr, pageSize, idNameList);
          List<Map> personList = personDAO.findPersonsByIdNames(idNameList);
          if (personList == null || personList.isEmpty()) {
            throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND); // very unlikely
          }
          List<Map> sortedPersonList = restoreSortOrder(idNameList, personList); 
          int fromIdex = (pageNbr - 1) * pageSize;
          int toIndex = fromIdex + pageSize + 1; // plus 1 row to set bMoreDataInd
          if (toIndex > sortedPersonList.size()) {
            toIndex = sortedPersonList.size();
          }
          List<Map> currentPageList = sortedPersonList.subList(fromIdex, toIndex);
          PaginatedHibernateList<Map> pagPersonList = new PaginatedHibernateList<Map>(currentPageList, pageSize, pageNbr);
          personSearchOutRec = populatePersonSearchOutRec(pagPersonList, scoreMap);
          searchAddress(personSearchOutRec);
        }
      }
    } catch (PhoneticSearchServiceException e) {
      throw new PhoneticSearchServiceException(Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED, e);
    }
    return personSearchOutRec;
  }

  /**
   * Filter search with gender and age info
   * 
   * @param personSearchOutRec
   * @param gender
   * @param dob
   * @return possible matches within age tolerance predifined
   */
  private PersonSearchOutRec filterPersonSearchOutRecByGenderAge(PersonSearchOutRec personSearchOutRec, String gender,
                                                                 Date dob, int personAge) {
    PersonSearchOutRec filteredPersonSearchOutRec = new PersonSearchOutRec();
    //STGAP00009174 - calling constructor on prsnSearchOutRec_ARRAY before assigning a value so that null pointer 
    // exception will not be thrown
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
    if (personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    }
    PrsnSearchOutRec_ARRAY filteredPrsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();

    filteredPersonSearchOutRec.setArchOutputStruct(personSearchOutRec.getArchOutputStruct());

    for (Enumeration e = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec(); e.hasMoreElements();) {
      PrsnSearchOutRec prsnSearchOutRec = (PrsnSearchOutRec) e.nextElement();
      String personSex = prsnSearchOutRec.getCCdPersonSex();
      Date personBirthdate = DateHelper.toJavaDate(prsnSearchOutRec.getDtDtPersonBirth());
      if (personBirthdate != null && StringHelper.isValid(gender) && !DateHelper.isNull(dob)) {
        if (gender.equals(personSex) && personBirthdateInRange(dob, personBirthdate, AGE_TOLERANCE)) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      }else if (personAge != 0 && StringHelper.isValid(gender) && gender.equals(personSex) && personAge == prsnSearchOutRec.getLNbrPersonAge()){
        filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
      }else if (personAge != 0 && personAge == prsnSearchOutRec.getLNbrPersonAge()){
        filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
      }else if (StringHelper.isValid(gender)) {
        if (gender.equals(personSex)) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      } else if (!DateHelper.isNull(dob)) {
        if (personBirthdate != null && personBirthdate.compareTo(dob) == 0) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      } //else { // no filter
        //filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
      //}
    }
    filteredPersonSearchOutRec.setPrsnSearchOutRec_ARRAY(filteredPrsnSearchOutRec_ARRAY);
    return filteredPersonSearchOutRec;
  }

  /**
   * Filter search with gender and/or exact DOB info
   * 
   * @param personSearchOutRec
   * @param gender
   * @param dob
   * @return
   */
  private PersonSearchOutRec filterPersonSearchOutRecByGenderDob(PersonSearchOutRec personSearchOutRec, String gender,
                                                                 Date dob) {
    PersonSearchOutRec filteredPersonSearchOutRec = new PersonSearchOutRec();
    //STGAP00009174 - calling constructor on prsnSearchOutRec_ARRAY before assigning a value so that null pointer 
    // exception will not be thrown 
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
    if (personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    }
    PrsnSearchOutRec_ARRAY filteredPrsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();


    filteredPersonSearchOutRec.setArchOutputStruct(personSearchOutRec.getArchOutputStruct());

    for (Enumeration e = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec(); e.hasMoreElements();) {
      PrsnSearchOutRec prsnSearchOutRec = (PrsnSearchOutRec) e.nextElement();
      String personSex = prsnSearchOutRec.getCCdPersonSex();
      Date personBirthdate = DateHelper.toJavaDate(prsnSearchOutRec.getDtDtPersonBirth());
      if (StringHelper.isValid(gender) && !DateHelper.isNull(dob)) {
        if (personBirthdate != null && gender.equals(personSex) && personBirthdate.compareTo(dob) == 0) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      } else if (StringHelper.isValid(gender)) {
        if (gender.equals(personSex)) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      } else {
        if (personBirthdate != null && personBirthdate.compareTo(dob) == 0) {
          filteredPrsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
        }
      }
    }
    filteredPersonSearchOutRec.setPrsnSearchOutRec_ARRAY(filteredPrsnSearchOutRec_ARRAY);
    return filteredPersonSearchOutRec;
  }

  /**
   * Compare person birth date retrieving from database against the DOB calculated from age entered. If it is with
   * 'range' return true; otherwise return false; Return false if no birthdate recorded on Person record
   * 
   * @param dobApprox
   * @param personBirthdate
   * @param range
   * @return
   */
  private boolean personBirthdateInRange(Date dobApprox, Date personBirthdate, double range) {
    if (!DateHelper.isNull(personBirthdate)) {
      double ageDiff = DateHelper.minutesDifference(dobApprox, personBirthdate);
      double ageDiff2 = ageDiff >= 0.0 ? ageDiff : -ageDiff;
      return (ageDiff2 <= range);
    }
    return false;
  }
  
  /*
   * This method is called from Phonetic Name Search and PARA search for Intake Report ID (stage ID) and possible phone
   */
  private PersonSearchOutRec populatePersonSearchOutRec(PaginatedHibernateList<Map> personList,
                                                          HashMap<Integer, Integer> scoreMap) {
    
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();
    List<PrsnSearchOutRec> sortedList = new ArrayList<PrsnSearchOutRec>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
    prsnSearchOutRec_ARRAY.setMoreDataAvailable(personList.isMoreDataAvailable());
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    List<Integer> idPersonList; 

    if (personList != null && !personList.isEmpty()) {
      idPersonList = new ArrayList<Integer>();
      Iterator<Integer> itr = idPersonList.iterator();
      while (itr.hasNext()) {
        int idPerson = itr.next();
        idPersonList.add(idPerson);
      }
    }
    
    // if (scoreMap != null && !scoreMap.isEmpty()) {
    if (personList != null && !personList.isEmpty()) {
    for (Iterator<Map> it = personList.iterator(); it.hasNext();) {
      Map personMap = it.next();
      PrsnSearchOutRec prsnSearchOutRec = new PrsnSearchOutRec();
      int idPerson = (Integer) personMap.get("idPerson");
      // STGAP00004764
      String nmIncmgPersonFirst = (String) personMap.get("nmIncmgPersonFirst");
      String nmIncmgPersonMiddle = (String) personMap.get("nmIncmgPersonMiddle");
      String nmIncmgPersonLast = (String) personMap.get("nmIncmgPersonLast");
      String pPersonFirst = (String) personMap.get("nmPersonFirst");
      String pPersonMiddle = (String) personMap.get("nmPersonMiddle");
      String pPersonLast = (String) personMap.get("nmPersonLast");
      prsnSearchOutRec.setSzNmIncmgPersFull(FormattingHelper.formatFullName(nmIncmgPersonFirst, nmIncmgPersonMiddle, nmIncmgPersonLast));
      prsnSearchOutRec.setUlIdPerson(idPerson);
      String pIncmgNameFull = personMap.get("nmIncmgPersonLast") + "," + personMap.get("nmIncmgPersonFirst");
      if (personMap.get("nmIncmgPersonMiddle") != null) {
        pIncmgNameFull = pIncmgNameFull + " " + personMap.get("nmIncmgPersonMiddle");
      }//String pIncmgNameFull = formatCompleteFullName(nmIncmgPersonFirst, nmIncmgPersonMiddle, nmIncmgPersonLast);
      String pPersonFull = formatCompleteFullName(pPersonFirst, pPersonMiddle, pPersonLast);
      prsnSearchOutRec.setSzNmPersonFull(FormattingHelper.formatFullName(pPersonFirst, nmIncmgPersonMiddle, pPersonLast));
      // end STGAP00004764
      prsnSearchOutRec.setSzAddrCity((String) personMap.get("addrPersonCity"));
      prsnSearchOutRec.setSzAddrPersAddrStLn1((String) personMap.get("addrPersonStLn1"));
      prsnSearchOutRec.setSzCdCounty((String) personMap.get("cdPersonAddrCounty"));
      Date birthDate = (Date) personMap.get("dtPersonBirth");
      Date deathDate = (Date) personMap.get("dtPersonDeath");
      // Always calculate age from DOB. * If Age is less than 1 then popluate * the List Box with 0
      // If Date of Death is populated the Age * is calculated at time of death.
      int pAge;
      if (birthDate != null) {
        prsnSearchOutRec.setDtDtPersonBirth(DateHelper.toCastorDate(birthDate));
        pAge = DateHelper.getAge(prsnSearchOutRec.getDtDtPersonBirth());
        if (deathDate != null && !DateHelper.MAX_JAVA_DATE.equals(deathDate)) {
          pAge = DateHelper.getAge(birthDate, deathDate);
          prsnSearchOutRec.setDtDtPersonDeath(DateHelper.toCastorDate(deathDate));
        }
        if (pAge < 1) {
          pAge = 0;
        }
        prsnSearchOutRec.setLNbrPersonAge(pAge);
      }
      prsnSearchOutRec.setBIndPersonDobApprox((String) personMap.get("indPersonDobApprox"));
      prsnSearchOutRec.setDtDtNameEndDate(DateHelper.toCastorDate((Date) personMap.get("dtNameEndDate")));
      prsnSearchOutRec.setCCdPersonSex((String) personMap.get("cdPersonSex"));
      prsnSearchOutRec.setSzNbrPersonIdSsn((String) personMap.get("ssn"));
      prsnSearchOutRec.setSzCdPersonEthnicGroup((String) personMap.get("cdPersonEthnicGroup"));
      // STGAP00004764 - compare on complete full name to determine AKA
      if (pIncmgNameFull.equals(pPersonFull)) {
        prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
      } else {
        prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.Y);
      }

      if (scoreMap != null) { // Phonetic search
        int idName = (Integer) personMap.get("idName");
        if (scoreMap.containsKey(idName)) {
          prsnSearchOutRec.setUsScrIndScore(scoreMap.get(idName));
        }
      } else { // EXACT, PARA or COMBO match type
        prsnSearchOutRec.setUsScrIndScore(100);
        prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
        prsnSearchOutRec.setSzNmIncmgPersFull((String) personMap.get("nmPersonFull"));
      }

      if (CD_STATUS_MERGED.equals(personMap.get("cdPersonStatus"))) {
        prsnSearchOutRec.setCWcdIndMerge(ArchitectureConstants.Y);
        Map prsnAddressMap = personAddressDAO.findPersonAddressByIdPersonAddr(idPerson);
        if (prsnAddressMap != null) {
          String firstName = (String) prsnAddressMap.get("nmNameFirst");
          String middleName = (String) prsnAddressMap.get("nmNameMiddle");
          String lastName = (String) prsnAddressMap.get("nmNameLast");
          prsnSearchOutRec.setSzNmIncmgPersFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
          prsnSearchOutRec.setSzNmPersonFull(null);
          prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
          prsnSearchOutRec.setCWcdIndMerge(ArchitectureConstants.Y);

          Date personAddBirthDate = (Date) prsnAddressMap.get("dtPersonBirth");
          Date personAddDeathDate = (Date) prsnAddressMap.get("dtPersonDeath");
          int birthAddMonth = getMonth(personAddBirthDate);
          int deathAddMonth = getMonth(personAddDeathDate);
          if (!DateHelper.isNull(personAddBirthDate) && DateHelper.isNull(personAddDeathDate)) {
            prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, currentDate));
          } else if (!DateHelper.isNull(personAddDeathDate)) { // there is a death date
            if ((birthAddMonth > deathAddMonth) || (getDay(personAddBirthDate) > getDay(personAddDeathDate))
                && (birthAddMonth == deathAddMonth)) {
              prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate) - 1);
            } else {
              prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate));
            }
          }
          prsnSearchOutRec.setCCdPersonSex((String) prsnAddressMap.get("cdPersonSex"));
          prsnSearchOutRec.setSzCdPersonEthnicGroup((String) prsnAddressMap.get("cdPersonEthnicGroup"));
          prsnSearchOutRec.setSzAddrCity((String) prsnAddressMap.get("addrPersonAddrCity"));
          prsnSearchOutRec.setSzCdCounty((String) prsnAddressMap.get("cdPersonAddrCounty"));
          prsnSearchOutRec.setSzAddrPersAddrStLn1((String) prsnAddressMap.get("addrPersAddrStLn1"));
          prsnSearchOutRec.setSzNbrPersonIdSsn((String) prsnAddressMap.get("nbrPersonIdNumber"));

        }// if (prsnAddressMap != null)
      } // end if (CD_STATUS_MERGED ==)
      sortedList.add(prsnSearchOutRec);
    }
  }
    // }
    // sort by score descending and name 
      Collections.sort(sortedList, new Comparator<PrsnSearchOutRec>() {
        public int compare(PrsnSearchOutRec first, PrsnSearchOutRec second) {
            int compare = second.getUsScrIndScore() - first.getUsScrIndScore();
            if (compare == 0) {
              String firstNmFull = StringHelper.isValid(first.getSzNmPersonFull()) ? first.getSzNmPersonFull() : first.getSzNmIncmgPersFull();
              String secondNmFull = StringHelper.isValid(second.getSzNmPersonFull()) ? second.getSzNmPersonFull() : second.getSzNmIncmgPersFull();
              compare = firstNmFull.compareToIgnoreCase(secondNmFull);
            }
            return compare;
        }
      });

    prsnSearchOutRec_ARRAY.setPrsnSearchOutRec(sortedList);
    personSearchOutRec.setPrsnSearchOutRec_ARRAY(prsnSearchOutRec_ARRAY);
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    if (personList != null && !personList.isEmpty()) {
    archOutputStruct.setBMoreDataInd(personList.getBMoreDataInd());
    }
    personSearchOutRec.setArchOutputStruct(archOutputStruct);

    return personSearchOutRec;
  }

  private PersonSearchOutRec populatePersonSearchOutRec(List<Person> personList, String matchType) {
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    
    for (Iterator<Person> personList_it = personList.iterator(); personList_it.hasNext();) {
      Person p = personList_it.next();
      if (p != null) {
        int idPerson = p.getIdPerson();
        Date birthDate = p.getDtPersonBirth();
        Date deathDate = p.getDtPersonDeath();
        PrsnSearchOutRec prsnSearchOutRec = new PrsnSearchOutRec();
        prsnSearchOutRec.setUlIdPerson(idPerson);
        prsnSearchOutRec.setSzNbrPersonIdSsn(p.getNbrPersonIdNumber());
        prsnSearchOutRec.setSzNbrPersonIdSsn(p.getNbrPersonIdNumber());
        prsnSearchOutRec.setSzAddrPersAddrStLn1(p.getAddrPersonStLn1());
        prsnSearchOutRec.setSzCdCounty(p.getCdPersonCounty());
        prsnSearchOutRec.setSzAddrCity(p.getAddrPersonCity());
        prsnSearchOutRec.setDtDtPersonBirth(DateHelper.toCastorDate(birthDate));
        prsnSearchOutRec.setDtDtPersonDeath(DateHelper.toCastorDate(deathDate));
        prsnSearchOutRec.setCCdPersonSex(p.getCdPersonSex());
        prsnSearchOutRec.setSzCdPersonEthnicGroup(p.getCdPersonEthnicGroup());
        prsnSearchOutRec.setSzNmPersonFull(p.getNmPersonFull());
        prsnSearchOutRec.setSzNmIncmgPersFull(p.getNmPersonFull());
        prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
        if ("PARA".equals(matchType)) {
          prsnSearchOutRec.setUsScrIndScore(100);
        }

        // Always calculate age from DOB. * If Age is less than 1 then popluate * the List Box with 0
        // If Date of Death is populated the Age * is calculated at time of death.
        int pAge;
        if (birthDate != null) {
          prsnSearchOutRec.setDtDtPersonBirth(DateHelper.toCastorDate(birthDate));
          pAge = DateHelper.getAge(prsnSearchOutRec.getDtDtPersonBirth());
          if (deathDate != null && !DateHelper.MAX_JAVA_DATE.equals(deathDate)) {
            pAge = DateHelper.getAge(birthDate, deathDate);
            prsnSearchOutRec.setDtDtPersonDeath(DateHelper.toCastorDate(deathDate));
          }
          if (pAge < 1) {
            pAge = 0;
          }
          prsnSearchOutRec.setLNbrPersonAge(pAge);
        }

        if (CD_STATUS_MERGED.equals(p.getCdPersonStatus())) {
          Map prsnAddressMap = personAddressDAO.findPersonAddressByIdPersonAddr(idPerson);
          if (prsnAddressMap != null) {
            String firstName = (String) prsnAddressMap.get("nmNameFirst");
            String middleName = (String) prsnAddressMap.get("nmNameMiddle");
            String lastName = (String) prsnAddressMap.get("nmNameLast");
            // prsnSearchOutRec.setSzNmIncmgPersFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
            // prsnSearchOutRec.setSzNmPersonFull(null);
            prsnSearchOutRec.setSzNmIncmgPersFull(null);
            prsnSearchOutRec.setSzNmPersonFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
            prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
            prsnSearchOutRec.setCWcdIndMerge(ArchitectureConstants.Y);

            // 22485 Find out the levels of care of the resource. There is one
            // service codes for Baisic and two service codes for Habil, Ther, and
            // Prim med

            Date personAddBirthDate = (Date) prsnAddressMap.get("dtPersonBirth");
            Date personAddDeathDate = (Date) prsnAddressMap.get("dtPersonDeath");
            boolean personAddBirthDateNull = DateHelper.isNull(personAddBirthDate);
            boolean personAddDeathDateNull = DateHelper.isNull(personAddDeathDate);
            int birthAddMonth = personAddBirthDateNull ? 0 : getMonth(personAddBirthDate);
            int deathAddMonth = personAddDeathDateNull ? 0 : getMonth(personAddDeathDate);
            if (!personAddBirthDateNull && personAddDeathDateNull) {
              prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, currentDate));
            } else if (!personAddDeathDateNull) { // there is a death date
              if ((birthAddMonth > deathAddMonth) || (getDay(personAddBirthDate) > getDay(personAddDeathDate))
                  && (birthAddMonth == deathAddMonth)) {
                prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate) - 1);
              } else {
                prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate));
              }
            }
            // Anything but success us unacceptable
            prsnSearchOutRec.setCCdPersonSex((String) prsnAddressMap.get("cdPersonSex"));

            prsnSearchOutRec.setSzCdPersonEthnicGroup((String) prsnAddressMap.get("cdPersonEthnicGroup"));
            prsnSearchOutRec.setUlIdPerson((Integer) prsnAddressMap.get("personByIdPersMergeForward"));
            prsnSearchOutRec.setSzAddrCity((String) prsnAddressMap.get("addrPersonAddrCity"));
            prsnSearchOutRec.setSzCdCounty((String) prsnAddressMap.get("cdPersonAddrCounty"));
            prsnSearchOutRec.setSzAddrPersAddrStLn1((String) prsnAddressMap.get("addrPersAddrStLn1"));

            // check where to get the SSN from
            prsnSearchOutRec.setSzNbrPersonIdSsn((String) prsnAddressMap.get("nbrPersonIdNumber"));

          }// if (prsnAddressMap != null)

        } // end if (CD_STATUS_MERGED ==)
        prsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
      }
    }
    personSearchOutRec.setPrsnSearchOutRec_ARRAY(prsnSearchOutRec_ARRAY);
    return personSearchOutRec;
  }

  private PersonSearchOutRec populatePersonSearchOutRec(Person p, String matchType) {
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = new PrsnSearchOutRec_ARRAY();
    PrsnSearchOutRec prsnSearchOutRec = new PrsnSearchOutRec();
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    if (p != null) {
      int idPerson = p.getIdPerson();
      Date birthDate = p.getDtPersonBirth();
      Date deathDate = p.getDtPersonDeath();
      prsnSearchOutRec.setUlIdPerson(idPerson);
      prsnSearchOutRec.setSzNbrPersonIdSsn(p.getNbrPersonIdNumber());
      prsnSearchOutRec.setSzNbrPersonIdSsn(p.getNbrPersonIdNumber());
      prsnSearchOutRec.setSzAddrPersAddrStLn1(p.getAddrPersonStLn1());
      prsnSearchOutRec.setSzCdCounty(p.getCdPersonCounty());
      prsnSearchOutRec.setSzAddrCity(p.getAddrPersonCity());
      prsnSearchOutRec.setDtDtPersonBirth(DateHelper.toCastorDate(birthDate));
      prsnSearchOutRec.setDtDtPersonDeath(DateHelper.toCastorDate(deathDate));
      prsnSearchOutRec.setCCdPersonSex(p.getCdPersonSex());
      prsnSearchOutRec.setSzCdPersonEthnicGroup(p.getCdPersonEthnicGroup());
      prsnSearchOutRec.setSzNmPersonFull(p.getNmPersonFull());
      prsnSearchOutRec.setSzNmIncmgPersFull(p.getNmPersonFull());
      prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
      if ("PARA".equals(matchType)) {
        prsnSearchOutRec.setUsScrIndScore(100);
      }

      // Always calculate age from DOB. * If Age is less than 1 then popluate * the List Box with 0
      // If Date of Death is populated the Age * is calculated at time of death.
      int pAge;
      if (birthDate != null) {
        prsnSearchOutRec.setDtDtPersonBirth(DateHelper.toCastorDate(birthDate));
        pAge = DateHelper.getAge(prsnSearchOutRec.getDtDtPersonBirth());
        if (deathDate != null && !DateHelper.MAX_JAVA_DATE.equals(deathDate)) {
          pAge = DateHelper.getAge(birthDate, deathDate);
          prsnSearchOutRec.setDtDtPersonDeath(DateHelper.toCastorDate(deathDate));
        }
        if (pAge < 1) {
          pAge = 0;
        }
        prsnSearchOutRec.setLNbrPersonAge(pAge);
      }

      if (CD_STATUS_MERGED.equals(p.getCdPersonStatus())) {
        Map prsnAddressMap = personAddressDAO.findPersonAddressByIdPersonAddr(idPerson);
        if (prsnAddressMap != null) {
          String firstName = (String) prsnAddressMap.get("nmNameFirst");
          String middleName = (String) prsnAddressMap.get("nmNameMiddle");
          String lastName = (String) prsnAddressMap.get("nmNameLast");
          //prsnSearchOutRec.setSzNmIncmgPersFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
          //prsnSearchOutRec.setSzNmPersonFull(null);
          prsnSearchOutRec.setSzNmIncmgPersFull(null);
          prsnSearchOutRec.setSzNmPersonFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
          prsnSearchOutRec.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
          prsnSearchOutRec.setCWcdIndMerge(ArchitectureConstants.Y);

          // 22485 Find out the levels of care of the resource. There is one
          // service codes for Baisic and two service codes for Habil, Ther, and
          // Prim med

          Date personAddBirthDate = (Date) prsnAddressMap.get("dtPersonBirth");
          Date personAddDeathDate = (Date) prsnAddressMap.get("dtPersonDeath");
          boolean personAddBirthDateNull = DateHelper.isNull(personAddBirthDate);
          boolean personAddDeathDateNull = DateHelper.isNull(personAddDeathDate);
          int birthAddMonth = personAddBirthDateNull ? 0 : getMonth(personAddBirthDate);
          int deathAddMonth = personAddDeathDateNull ? 0 : getMonth(personAddDeathDate);
          if (!personAddBirthDateNull && personAddDeathDateNull) {
            prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, currentDate));
          } else if (!personAddDeathDateNull) { // there is a death date
            if ((birthAddMonth > deathAddMonth) || (getDay(personAddBirthDate) > getDay(personAddDeathDate))
                && (birthAddMonth == deathAddMonth)) {
              prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate) - 1);
            } else {
              prsnSearchOutRec.setLNbrPersonAge(DateHelper.getAge(personAddBirthDate, personAddDeathDate));
            }
          }
          // Anything but success us unacceptable
          prsnSearchOutRec.setCCdPersonSex((String) prsnAddressMap.get("cdPersonSex"));

          prsnSearchOutRec.setSzCdPersonEthnicGroup((String) prsnAddressMap.get("cdPersonEthnicGroup"));
          prsnSearchOutRec.setUlIdPerson((Integer) prsnAddressMap.get("personByIdPersMergeForward"));
          prsnSearchOutRec.setSzAddrCity((String) prsnAddressMap.get("addrPersonAddrCity"));
          prsnSearchOutRec.setSzCdCounty((String) prsnAddressMap.get("cdPersonAddrCounty"));
          prsnSearchOutRec.setSzAddrPersAddrStLn1((String) prsnAddressMap.get("addrPersAddrStLn1"));

          // check where to get the SSN from
          prsnSearchOutRec.setSzNbrPersonIdSsn((String) prsnAddressMap.get("nbrPersonIdNumber"));

        }// if (prsnAddressMap != null)

      } // end if (CD_STATUS_MERGED ==)
    }
    prsnSearchOutRec_ARRAY.addPrsnSearchOutRec(prsnSearchOutRec);
    personSearchOutRec.setPrsnSearchOutRec_ARRAY(prsnSearchOutRec_ARRAY);
    return personSearchOutRec;
  }

  /**
   * retrieve indicator if a match is sealed record (adoption finalized)
   * 
   * @param personSearchOutRec
   */
  private void retrieveAdoptedIndicator(PersonSearchOutRec personSearchOutRec) {
    List<Integer> idPersonList = new ArrayList<Integer>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    if (prsnSearchOutRec_ARRAY != null) {
      Enumeration<PrsnSearchOutRec> enumPrsnSearchOutRec = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();

      while (enumPrsnSearchOutRec.hasMoreElements()) {
        PrsnSearchOutRec prsnSearchOutRec = enumPrsnSearchOutRec.nextElement();
        idPersonList.add(prsnSearchOutRec.getUlIdPerson());
      }
      if (idPersonList == null || idPersonList.isEmpty() || idPersonList.size() == 0) {
        return;
      }
      List<Integer> adoptedChildList = stagePersonLinkDAO.findIdPersonsByPersonAdopted(idPersonList);
      Map<Integer, Integer> adoptedChildMap = null;
      if (adoptedChildList != null && !adoptedChildList.isEmpty() && adoptedChildList.size() != 0) {
        adoptedChildMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = adoptedChildList.iterator();
        while (itr.hasNext()) {
          int idPerson = itr.next();
          adoptedChildMap.put(idPerson, idPerson);
        }
      }
      if (adoptedChildMap != null) {
        int searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
        int idPerson;
        for (int i = 0; i < searchCnt; i++) {
          idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
          if (adoptedChildMap.containsKey(idPerson)) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setIndAdopted(ArchitectureConstants.Y);
          } else {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setIndAdopted(ArchitectureConstants.N);
          }
        }
      }
    }
  }

  private void retrievePsaIndicatorByPersonList(PersonSearchOutRec personSearchOutRec) {
    List<Integer> idPersonList = new ArrayList<Integer>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    if (prsnSearchOutRec_ARRAY != null) {
      Enumeration<PrsnSearchOutRec> enumPrsnSearchOutRec = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();

      while (enumPrsnSearchOutRec.hasMoreElements()) {
        PrsnSearchOutRec prsnSearchOutRec = enumPrsnSearchOutRec.nextElement();
        idPersonList.add(prsnSearchOutRec.getUlIdPerson());
      }
      if (idPersonList == null || idPersonList.isEmpty() || idPersonList.size() == 0) {
        return;
      }
      List<Integer> psaChildList = psaPersonLinkDAO.findActivePsaByPersonList(idPersonList);
      Map<Integer, Integer> psaChildMap = null;
      if (psaChildList != null && !psaChildList.isEmpty()) {
        psaChildMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = psaChildList.iterator();
        while (itr.hasNext()) {
          int idPerson = itr.next();
          psaChildMap.put(idPerson, idPerson);
        }
      }
      if (psaChildMap != null) {
        int searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
        int idPerson;
        for (int i = 0; i < searchCnt; i++) {
          idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
          if (psaChildMap.containsKey(idPerson)) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setIndPsa(ArchitectureConstants.Y);
          } else {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setIndPsa(ArchitectureConstants.N);
          }
        }
      }
    }
  }
  
  private void callCINT72DByPersonList(PersonSearchOutRec personSearchOutRec) {
    List<Integer> idPersonList = new ArrayList<Integer>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    if (prsnSearchOutRec_ARRAY != null) {
      Enumeration<PrsnSearchOutRec> enumPrsnSearchOutRec = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();

      while (enumPrsnSearchOutRec.hasMoreElements()) {
        PrsnSearchOutRec prsnSearchOutRec = enumPrsnSearchOutRec.nextElement();
        idPersonList.add(prsnSearchOutRec.getUlIdPerson());
      }
      if (idPersonList == null || idPersonList.isEmpty() || idPersonList.size() == 0) {
        return;
      }
      List<Integer> categoryPersonList = personCategoryDAO.findcountPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPersonByPersonList(idPersonList);
      Map<Integer, Integer> categoryPersonMap = null;
      if (categoryPersonList != null && !categoryPersonList.isEmpty()) {
        categoryPersonMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = categoryPersonList.iterator();
        while (itr.hasNext()) {
          int idPerson = itr.next();
          categoryPersonMap.put(idPerson, idPerson);
        }
      }
      if (categoryPersonMap != null) {
        int searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
        int idPerson;
        for (int i = 0; i < searchCnt; i++) {
          idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
          if (categoryPersonMap.containsKey(idPerson)) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setBSysIndViewPersonInfo(ArchitectureConstants.N);
          } else {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setBSysIndViewPersonInfo(ArchitectureConstants.Y);
          }
        }
      }
    }
  }
  
  private void retrievePersonMergeIndicatorByPersonList(PersonSearchOutRec personSearchOutRec) {
    List<Integer> idPersonList = new ArrayList<Integer>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    if (prsnSearchOutRec_ARRAY != null) {
      Enumeration<PrsnSearchOutRec> enumPrsnSearchOutRec = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();

      while (enumPrsnSearchOutRec.hasMoreElements()) {
        PrsnSearchOutRec prsnSearchOutRec = enumPrsnSearchOutRec.nextElement();
        idPersonList.add(prsnSearchOutRec.getUlIdPerson());
      }
      if (idPersonList == null || idPersonList.isEmpty() || idPersonList.size() == 0) {
        return;
      }
      List<Integer> mergePersonList = personMergeDAO.findPersonMergeForwardOrClosedByPersonList(idPersonList);
      Map<Integer, Integer> mergePersonMap = null;
      if (mergePersonList != null && !mergePersonList.isEmpty()) {
        mergePersonMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = mergePersonList.iterator();
        while (itr.hasNext()) {
          int idPerson = itr.next();
          mergePersonMap.put(idPerson, idPerson);
        }
      }
      if (mergePersonMap != null) {
        int searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
        int idPerson;
        for (int i = 0; i < searchCnt; i++) {
          idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
          if (mergePersonMap.containsKey(idPerson)) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setCWcdIndMerge(ArchitectureConstants.Y);
          } else {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setCWcdIndMerge(ArchitectureConstants.N);
          }
        }
      }
    }
  }
  
  private void setPersonActiveStatusByCategoryByPersonList(PersonSearchOutRec personSearchOutRec) {
    List<Integer> idPersonList = new ArrayList<Integer>();
    PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
    if (prsnSearchOutRec_ARRAY != null) {
      Enumeration<PrsnSearchOutRec> enumPrsnSearchOutRec = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();

      while (enumPrsnSearchOutRec.hasMoreElements()) {
        PrsnSearchOutRec prsnSearchOutRec = enumPrsnSearchOutRec.nextElement();
        idPersonList.add(prsnSearchOutRec.getUlIdPerson());
      }
      if (idPersonList == null || idPersonList.isEmpty() || idPersonList.size() == 0) {
        return;
      }
      List<Integer> categoryPersonList = personDAO.findPersonByPersonCategoryByPersonList(idPersonList, EMPLOYEE_CATEGORY);
      Map<Integer, Integer> categoryPersonMap = null;
      if (categoryPersonList != null && !categoryPersonList.isEmpty()) {
        categoryPersonMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = categoryPersonList.iterator();
        while (itr.hasNext()) {
          int idPerson = itr.next();
          categoryPersonMap.put(idPerson, idPerson);
        }
      }
      if (categoryPersonMap != null) {
        int searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
        int idPerson;
        for (int i = 0; i < searchCnt; i++) {
          idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
          if (categoryPersonMap.containsKey(idPerson)) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setBIndActiveStatus(ArchitectureConstants.Y);
          } else {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i)
                              .setBIndActiveStatus(ArchitectureConstants.N);
          }
        }
      }
    }
  }
  
  private void retrievePersonMergeIndicator(PersonSearchOutRec personSearchOutRec) {
    // CallCMSC49D
    int rowCnt = 0;
    if (personSearchOutRec != null && personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      rowCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
    
    for (int i = 0; i < rowCnt; ++i) {
      PrsnSearchOutRec prsnSearchOutRec = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i);
      int personId = prsnSearchOutRec.getUlIdPerson();
      // cmsc49dQUERYdam();
      long mergeCntr = personMergeDAO.countPersonMergeForwardOrClosedByIdPerson(personId);

      if (mergeCntr > 0l) {
        personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).setCWcdIndMerge(ArchitectureConstants.Y);
      } else {
        personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).setCWcdIndMerge(ArchitectureConstants.N);
      }
    }
  }
  }
  
  private void retrievePsaIndicator(PersonSearchOutRec personSearchOutRec) {
    int searchCnt = 0;
    int idPerson;
    if (personSearchOutRec != null && personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
    
    for (int i = 0; i < searchCnt; i++) {
      idPerson = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).getUlIdPerson();
      long psaCnt = psaPersonLinkDAO.countActivePsa(idPerson);
      if (psaCnt > 0l) {
        personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).setIndPsa(ArchitectureConstants.Y);
      } else {
        personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i).setIndPsa(ArchitectureConstants.N);
      }
    }
    }
  }

  private int callCINT72D(PersonSearchOutRec personSearchOutRec) {
    int rc = 0;
    int searchCnt = 0;
    int personId;
    if (personSearchOutRec != null && personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      searchCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
    
    for (int i = 0; i < searchCnt; ++i) {
      PrsnSearchOutRec prsnSearchOutRec = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(i);
      personId = prsnSearchOutRec.getUlIdPerson();
      // Call CSES87D
      long categoryCnt = personCategoryDAO
                                          .countPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPerson(personId);
      if (categoryCnt == 0l) {
        prsnSearchOutRec.setBSysIndViewPersonInfo(ArchitectureConstants.Y);
      } else {
        prsnSearchOutRec.setBSysIndViewPersonInfo(ArchitectureConstants.N);
      }
    }
    }
    return rc;
  }

  private void setPersonActiveStatusByCategory(PersonSearchOutRec personSearchOutRec, int pageNbr, int pageSize) {
    // CallCINV29D
    int searchRowCnt = 0;
    if (personSearchOutRec != null && personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
      searchRowCnt = personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRecCount();
    
    for (int sPersonIndex = 0; sPersonIndex < searchRowCnt; ++sPersonIndex) {
      PrsnSearchOutRec prsnSearchOutRec = personSearchOutRec.getPrsnSearchOutRec_ARRAY()
                                                            .getPrsnSearchOutRec(sPersonIndex);
      int personId = prsnSearchOutRec.getUlIdPerson();
      // rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
      PaginatedHibernateList<PersonCategory> personCategoryList = personCategoryDAO
                                                                                   .findPersonCategoryByIdPerson(
                                                                                                                 personId,
                                                                                                                 pageNbr,
                                                                                                                 pageSize);

      // Analyze return code
      // Set the employee indicator to true if the
      // one of the rows returned has a category
      // of employee
      if (personCategoryList != null && !personCategoryList.isEmpty() && personCategoryList.size() > 0) {
        for (Iterator<PersonCategory> it = personCategoryList.iterator(); it.hasNext();) {
          PersonCategory row = it.next();
          if (EMPLOYEE_CATEGORY.equals(row.getCdPersonCategory())) {
            personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(sPersonIndex)
                              .setBIndActiveStatus(ArchitectureConstants.Y);
          }
        } // end inner for loop
      } else {
        personSearchOutRec.getPrsnSearchOutRec_ARRAY().getPrsnSearchOutRec(sPersonIndex)
                          .setBIndActiveStatus(ArchitectureConstants.N);
      } // end if/else personCategoryList != null
    } // end outer for loop
  }
  } // end CallCINV29D

  /*
   * given a date and a time value it returns the integer value of a day, month, or year
   */
  private int getGivenTimeFieldValue(Date date, int timeValue) {
    if (date == null) {
      return 0;
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(timeValue);
  }

  /*
   * returns the day of a date
   */
  private int getDay(Date date) {
    return getGivenTimeFieldValue(date, Calendar.DAY_OF_MONTH);
  }

  /*
   * returns the month of a date
   */
  private int getMonth(Date date) {
    return getGivenTimeFieldValue(date, Calendar.MONTH);
  }

  /*
   * returns the year of a date
   */
  private int getYear(Date date) {
    return getGivenTimeFieldValue(date, Calendar.YEAR);
  }
  
  /**
   * Use this instead of existing FormattingHelper.formatFullName() since it will truncate the result to total of 25 letters
   * @param last
   * @param first
   * @param middle
   * @return
   */
  private String formatCompleteFullName (String first, String middle, String last) {
    String pPersonFull = "";
    if (StringHelper.isValid(last) && StringHelper.isValid(first)) {
      pPersonFull = last + "," + first;
      if (StringHelper.isValid(middle)) {
        pPersonFull = pPersonFull + " " + middle;
      }
    }
    return  pPersonFull;
  }
  
  /**
   * 
   * @param idNameList (not null)
   * @param personInfoList (not null)
   * @return Person Info List sorted same order with id name list
   * Notes: Fine tune by looping through personInfoList, find position using binary search on idNameList and put(personInfoRec, position)
   */
  private List<Map> restoreSortOrder(List<Integer> idNameList, List<Map> personInfoList) {
    List<Map> personInfoListCopy = new ArrayList<Map>(personInfoList);
    List<Map> sortedPersonInfoList = new ArrayList<Map>();
    Iterator<Integer> nameItr = idNameList.iterator();
    
    while (nameItr.hasNext()) {
      Iterator<Map> personItr = personInfoListCopy.iterator();
      int idName = nameItr.next();
      while (personItr.hasNext()) {
        Map personInfo = personItr.next();
        int idNamePerson = (Integer)personInfo.get("idName");
        if (idName == idNamePerson) {
          sortedPersonInfoList.add(personInfo);
          personItr.remove();
          break;
        }
      }
    }
    
    return sortedPersonInfoList;
  }
  
  //STGAP00009110 - created method to retrieve objects from list and set them into a map. Returns a PaginatedHibernateList of maps
  @SuppressWarnings("unchecked")
  private PaginatedHibernateList createPersonMapFromQuery(List<Object[]> mapList, int pageNbr, int pageSize){
    List personList = new ArrayList();
    int i;
    int listLength = mapList.size() - 1;
    if(mapList != null && listLength != -1){
      for(i = 0; i <= listLength; i++){
        HashMap personMap = new HashMap();
        Object[] personArray =  mapList.get(i);
        personMap.put("idPerson", personArray[0]);
        personMap.put("nmPersonFull", personArray[1]);
        personMap.put("nmPersonFirst", personArray[2]);
        personMap.put("nmPersonLast", personArray[3]);
        personMap.put("nmPersonMiddle", personArray[4]);
        personMap.put("dtPersonDeath", personArray[5]);
        personMap.put("dtPersonBirth", personArray[6]);
        personMap.put("ssn",personArray[7]);
        personMap.put("cdPersonEthnicGroup", personArray[8]);
        personMap.put("cdPersonCounty", personArray[9]);
        personMap.put("cdPersonState", personArray[10]);
        personMap.put("addrPersonStLn1", personArray[11]);
        personMap.put("addrPersonCity", personArray[12]);
        personMap.put("addrPersonZip", personArray[13]);
        personMap.put("cdPersonSex", personArray[14]);
        personMap.put("cdPersonStatus", personArray[15]);
        personMap.put("indPersonDobApprox", personArray[16]);
        
        personList.add(personMap);
      }
    }

    return new PaginatedHibernateList(personList, pageSize, pageNbr);
  }
  
  //STGAP00009110 - created method to set query values
  @SuppressWarnings({"unchecked"})
  private List paginatedList(int pageNbr, int pageSize, Query query) {
    query.setFirstResult((pageNbr - 1) * pageSize);
    // Grab the full page at once, plus 1 row to set bMoreDataInd.
    query.setFetchSize(pageSize + 1);
    query.setMaxResults(pageSize + 1);
    // Execute the query.
    return (List<Object[]>) query.list();
  }
  
  //STGAP00009110 - created method to retrieve objects from list and populate a person object
  @SuppressWarnings("unchecked")
  private List<Person> createPersonList(List<Object[]> objectList){
    List<Person> personList = new ArrayList();
    int i;
    int listLength = objectList.size() - 1;
    if (objectList != null && listLength != -1) {
      for (i = 0; i <= listLength; i++) {
        Person person = new Person();
        Object[] personArray = objectList.get(i);
        Integer idPerson = (Integer) personArray[0];
        person.setIdPerson(idPerson != null ? idPerson.intValue() : 0);
        person.setDtPersonDeath((Date) personArray[2]);
        person.setDtPersonBirth((Date) personArray[3]);
        person.setAddrPersonStLn1((String) personArray[8]);
        person.setNbrPersonIdNumber((String) personArray[4]);
        person.setCdPersonCounty((String) personArray[6]);
        person.setAddrPersonCity((String) personArray[9]);
        person.setCdPersonSex((String) personArray[10]);
        person.setCdPersonEthnicGroup((String) personArray[5]);
        person.setNmPersonFull((String) personArray[1]);
        
        personList.add(person);
      }
    }

    return personList;
  }
}
