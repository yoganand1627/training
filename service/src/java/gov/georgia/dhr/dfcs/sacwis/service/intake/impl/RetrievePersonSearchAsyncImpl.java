package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrievePersonSearchAsync;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY;

public class RetrievePersonSearchAsyncImpl extends BaseServiceImpl implements RetrievePersonSearchAsync {

  private PersonCategoryDAO personCategoryDAO = null;
  private PersonMergeDAO personMergeDAO = null;

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public HierSrchOutRec retrievePersonSearchAsync(HierSrchInRec hierSrchInRec) throws ServiceException {

    HierSrchOutRec hierSrchOutRec = new HierSrchOutRec();
    ArchInputStruct archInputStruct = hierSrchInRec.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    // CallCINT08D
    PrsnSrchListpInit_ARRAY prsnSrchListpInit_Array = initPersonSearch(hierSrchInRec, hierSrchOutRec, pageNbr,
                                                                       pageSize);

    if (prsnSrchListpInit_Array != null) {
      // CallCMSC49D
      countPersonMerge(prsnSrchListpInit_Array);
    }
    return hierSrchOutRec;
  }

  private PrsnSrchListpInit_ARRAY initPersonSearch(HierSrchInRec hierSrchInRec, HierSrchOutRec hierSrchOutRec,
                                                   int pageNbr, int pageSize)
          throws ServiceException {
    HierPersSrchRec hierPersSrchRec = hierSrchInRec.getHierPersSrchRec();
    // CallCINT08D
    String addrPersAddrStLn1 = hierPersSrchRec.getSzAddrPersAddrStLn1();
    String addrPersAddrStLn2 = hierPersSrchRec.getSzAddrPersAddrStLn2();
    String addrCity = hierPersSrchRec.getSzAddrCity();
    String cdAddrState = hierPersSrchRec.getSzCdAddrState();
    String addrZip = hierPersSrchRec.getLAddrZip();
    String cdAddrCounty = hierPersSrchRec.getSzCdAddrCounty();
    String nbrPersonIdSsn = hierPersSrchRec.getSzNbrPersonIdSsn();
    int sysNbrUniqueLBKey = hierPersSrchRec.getLSysNbrUniqueLBKey();
    String cdPersonSex = hierPersSrchRec.getCCdPersonSex();
    int bASearchFlag = 1;

    // retrieve the current system date
    Calendar cal = Calendar.getInstance();
    Date dtCurrentDate = cal.getTime();
    Date dtPersonBirth = null;
    Date dtPersonBirth2 = null;

    if (hierPersSrchRec.getDtDtPersonBirth() == null
        && hierPersSrchRec.getLNbrPersonAge() > 0) {

      int nbrPersonAge = hierPersSrchRec.getLNbrPersonAge();
      dtPersonBirth = DateHelper.getJavaDateFromAge(nbrPersonAge);
      hierPersSrchRec.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
    }
    if (hierPersSrchRec.getDtDtPersonBirth() != null) {
      dtPersonBirth = DateHelper.toJavaDate(hierPersSrchRec.getDtDtPersonBirth());

      // If age > 18, then the range of birth dates search on will be +/-10 years from the given birth date.
      // Else, the range will be +/-3 years from the given birth date.

      //cal.setTime(dtCurrentDate);
      int yrCurrentDate = cal.get(Calendar.YEAR);
      cal.setTime(dtPersonBirth);
      int yrPersonBirth = cal.get(Calendar.YEAR);

      if ((yrCurrentDate - yrPersonBirth) >= ADULT_AGE_RANGE_START) {
        dtPersonBirth = DateHelper.getJavaDateFromAge(yrPersonBirth - ADULT_AGE_RANGE_VALUE);
        dtPersonBirth2 = DateHelper.getJavaDateFromAge(yrPersonBirth + ADULT_AGE_RANGE_VALUE);
      } else {// Age is under 18 years old
        dtPersonBirth = DateHelper.getJavaDateFromAge(yrPersonBirth - CHILD_AGE_RANGE_VALUE);
        dtPersonBirth2 = DateHelper.getJavaDateFromAge(yrPersonBirth + CHILD_AGE_RANGE_VALUE);
      }
    }
    // Todo:
    // The following section is temporarily commented
    // pending the availability a Phonetic Name Search API 
    /**
     if (hierPersSrchRec.getSzNmNameFirst().length() != 0) {
     SSANameStruct.szNmNameFirst = hierPersSrchRec.getSzNmNameFirst();
     }
     else {
     }
     if (hierPersSrchRec.getSzNmNameLast().length() != 0) {
     SSANameStruct.szNmNameLast  = hierPersSrchRec.getSzNmNameLast();
     }
     else {
     }

     // Analyze error code
     if (hierPersSrchRec.getSzNmNameMiddle().length() != 0) {
     SSANameStruct.szNmNameMiddle  = hierPersSrchRec.getSzNmNameMiddle();
     }
     else {
     }
     rc = ARC_SSACreateKeys(SSANameStruct);

     // Analyze error code
     switch (SSANameStruct.usSysNbrSSANamePhkKeys) {

     case WW_RANGE_RETURNED:
     pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[1]);
     pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[1]);
     pCINT08DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
     pCINT08DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(1, SSANameStruct.szSysNmSSARngToPhk[0]);
     break;
     case WI_RANGE_RETURNED:
     case W_RANGE_RETURNED:

     pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
     pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[0]);
     break;

     default :
     break;
     }
     */

    String nmNameFirst = hierPersSrchRec.getSzNmNameFirst();
    String nmNameLast = hierPersSrchRec.getSzNmNameLast();
    String nmNameMiddle = hierPersSrchRec.getSzNmNameMiddle();
    // The following object is a temporary placeholder
    // pending the availability a Phonetic Name Search API
    // that will enable implementation of cint08d.
    // cint08d
    List<Person> personInfo = null;
    // Todo:
    // Need to call dynamic DAO
    // ??? Messages.MSG_NAME_TOO_COMMON:

    PrsnSrchListpInit_ARRAY prsnSrchListpInit_Array = new PrsnSrchListpInit_ARRAY();

    if (personInfo != null) {
      for (Iterator<Person> it = personInfo.iterator(); it.hasNext();) {
        Person person = it.next();
        PrsnSrchListpInit rowPrsnSrchListpInit = new PrsnSrchListpInit();
        if (CD_STATUS_MERGED.equals(Character.toString(person.getCdPersonStatus().charAt(0)))) {
          rowPrsnSrchListpInit.setSzNmNameFirst(person.getNmPersonFirst());
          rowPrsnSrchListpInit.setSzNmNameMiddle(person.getNmPersonMiddle());
          rowPrsnSrchListpInit.setSzNmNameLast(person.getNmPersonLast());
          String nmPersonFull = FormattingHelper.formatFullName(person.getNmPersonFirst(), person.getNmPersonMiddle(),
                                                                person.getNmPersonLast());
          rowPrsnSrchListpInit.setSzNmIncmgPersFull(nmPersonFull);

          if ((person.getDtPersonBirth() == null) && (person.getDtPersonDeath() == null)) {
            rowPrsnSrchListpInit.setLNbrPersonAge(0);
          } else if (person.getDtPersonDeath() != null) {

            cal.setTime(person.getDtPersonBirth());
            int yrPersonBirth = cal.get(Calendar.YEAR);
            int monthPersonBirth = cal.get(Calendar.MONTH);
            int dayPersonBirth = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(person.getDtPersonDeath());
            int yrPersonDeath = cal.get(Calendar.YEAR);
            int monthPersonDeath = cal.get(Calendar.MONTH);
            int dayPersonDeath = cal.get(Calendar.DAY_OF_MONTH);

            if ((monthPersonBirth > monthPersonDeath) ||
                (dayPersonBirth > dayPersonDeath) && (monthPersonBirth == monthPersonDeath)) {
              rowPrsnSrchListpInit.setLNbrPersonAge((yrPersonDeath - yrPersonBirth) - 1);
            } else {
              rowPrsnSrchListpInit.setLNbrPersonAge((yrPersonDeath - yrPersonBirth));
            }
          } else {
            cal.setTime(dtCurrentDate);
            int yrCurrentDate = cal.get(Calendar.YEAR);
            cal.setTime(person.getDtPersonBirth());
            int yrPersonBirth = cal.get(Calendar.YEAR);

            rowPrsnSrchListpInit.setLNbrPersonAge((yrCurrentDate - yrPersonBirth));
          }
          rowPrsnSrchListpInit.setDtDtPersonDeath(DateHelper.toCastorDate(person.getDtPersonDeath()));
          rowPrsnSrchListpInit.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
          rowPrsnSrchListpInit.setDtDtNameEndDate(DateHelper.toCastorDate(person.getDtLastUpdate()));
          rowPrsnSrchListpInit.setBIndPersonDobApprox(person.getIndPersonDobApprox());
          rowPrsnSrchListpInit.setSzAddrPersAddrStLn1(person.getAddrPersonStLn1());
          rowPrsnSrchListpInit.setCCdPersonSex(person.getCdPersonSex());
          rowPrsnSrchListpInit.setSzAddrCity(person.getAddrPersonCity());
          rowPrsnSrchListpInit.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
          rowPrsnSrchListpInit.setSzCdCounty(person.getCdPersonCounty());
          //Could not identify accessor Person method for SSN
          rowPrsnSrchListpInit.setSzNbrPersonIdSsn(person.getNbrPersonIdNumber());
          rowPrsnSrchListpInit.setUlIdPerson(person.getIdPerson() != null ? person.getIdPerson() : 0);
          if (rowPrsnSrchListpInit.getSzNmIncmgPersFull().equals(rowPrsnSrchListpInit.getSzNmPersonFull())) {
            rowPrsnSrchListpInit.setSzScrCdPersonSearchHit(ArchitectureConstants.N);
          } else {
            rowPrsnSrchListpInit.setSzScrCdPersonSearchHit(ArchitectureConstants.Y);
          }
          // Todo: 
          // Check with Mike on how to handle these values that are not in the return objec
          //pOutputMsg366.PrsnSrchListpInit[j].setUsScrIndScore(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getUsScrIndScore());
          //pOutputMsg366.PrsnSrchListpInit[i244].setBASearchFlag(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getBASearchFlag());
          //rowPrsnSrchListpInit.setUsScrIndScore(person.getUsScrIndScore());
          //rowPrsnSrchListpInit.setBASearchFlag(person.getBASearchFlag());
        }// end if (CD_STATUS_MERGED
        prsnSrchListpInit_Array.addPrsnSrchListpInit(rowPrsnSrchListpInit);
      }// end for loop
      hierSrchOutRec.setPrsnSrchListpInit_ARRAY(prsnSrchListpInit_Array);
    }
    hierSrchOutRec.setLSysNbrUniqueLBKey(hierPersSrchRec.getLSysNbrUniqueLBKey());

    if (personInfo != null) {
      // CallCINV29D
      findPersonCategory(hierSrchOutRec.getPrsnSrchListpInit_ARRAY(), pageNbr, pageSize);
    }
    return prsnSrchListpInit_Array;
  }

  private void findPersonCategory(PrsnSrchListpInit_ARRAY prsnSrchListpInit_Array, int pageNbr, int pageSize) {
    // CallCINV29D
    for (Enumeration rowPrsnSrchListpInitEnum = prsnSrchListpInit_Array.enumeratePrsnSrchListpInit();
         rowPrsnSrchListpInitEnum.hasMoreElements();) {
      PrsnSrchListpInit rowPrsnSrchListpInit = (PrsnSrchListpInit) rowPrsnSrchListpInitEnum.nextElement();
      int idPerson = rowPrsnSrchListpInit.getUlIdPerson();
      // cinv29d
      PaginatedHibernateList<PersonCategory> personCategoryInfo = personCategoryDAO.findPersonCategoryByIdPerson(
              idPerson, pageNbr, pageSize);
      if (personCategoryInfo == null || personCategoryInfo.isEmpty()) {
        rowPrsnSrchListpInit.setBIndActiveStatus(ArchitectureConstants.N);
      } else {
        for (Iterator<PersonCategory> it = personCategoryInfo.iterator(); it.hasNext();) {
          PersonCategory personCategory = it.next();
          if (EMPLOYEE_CATEGORY.equals(personCategory.getCdPersonCategory())) {
            rowPrsnSrchListpInit.setBIndActiveStatus(ArchitectureConstants.Y);
          }
        }
      }
    }
  }

  private void countPersonMerge(PrsnSrchListpInit_ARRAY prsnSrchListpInit_Array) {
    // CallCMSC49D
    for (Enumeration rowPrsnSrchListpInitEnum = prsnSrchListpInit_Array.enumeratePrsnSrchListpInit();
         rowPrsnSrchListpInitEnum.hasMoreElements();) {
      PrsnSrchListpInit rowPrsnSrchListpInit = (PrsnSrchListpInit) rowPrsnSrchListpInitEnum.nextElement();
      int idPerson = rowPrsnSrchListpInit.getUlIdPerson();
      // cmsc49d
      if (personMergeDAO.countPersonMergeForwardOrClosedByIdPerson(idPerson) <= 0) {
        rowPrsnSrchListpInit.setCWcdIndMerge(ArchitectureConstants.N);
      } else {
        rowPrsnSrchListpInit.setCWcdIndMerge(ArchitectureConstants.Y);
      }
    }
  }
}
