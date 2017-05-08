package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicIncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.service.external.PhoneticSearchService;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveCallLog;
import gov.georgia.dhr.dfcs.sacwis.service.person.impl.NameSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveCallLogImpl extends BaseServiceImpl implements RetrieveCallLog {

  public static final String TIME_MINIMUM = "12:00 AM";
  public static final String TIME_MAXIMUM = "11:59 PM";

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;
  private DynamicIncomingDetailDAO dynamicIncomingDetailDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private PhoneticSearchService phoneticSearchService = null;

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setDynamicIncomingDetailDAO(DynamicIncomingDetailDAO dynamicIncomingDetailDAO) {
    this.dynamicIncomingDetailDAO = dynamicIncomingDetailDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setPhoneticSearchService(PhoneticSearchService phoneticSearchService) {
    this.phoneticSearchService = phoneticSearchService;
  }

  public CallListSrchOutRec retrieveCallLog(CallListSrchInRec callListSrchInRec) throws ServiceException {

    CallListInStruct callListInStruct = callListSrchInRec.getCallListInStruct();

    int pageNbr = callListSrchInRec.getArchInputStruct().getUsPageNbr();
    int pageSize = callListSrchInRec.getArchInputStruct().getUlPageSizeNbr();
    int idStage = callListInStruct.getUlIdStage();

    List<Integer> idStageList = new ArrayList<Integer>();
    PaginatedHibernateList<Map> incomingDetailList;
    if (idStage != 0) {
      incomingDetailList = findIncomingDetailByIdStage(pageNbr, pageSize, idStage);
    } else {
      if (StringHelper.isValid(callListInStruct.getNmIncomingCallerLast())) {

        String nmFirstName = callListInStruct.getNmIncomingCallerFirst();
        String nmMiddleName = callListInStruct.getNmIncomingCallerMiddle();
        String nmLastName = callListInStruct.getNmIncomingCallerLast();
        String cdStagePersType = callListInStruct.getSzCdStagePersType();

        idStageList = getPhoneticNameList(nmFirstName, nmMiddleName, nmLastName, cdStagePersType);
      }
      incomingDetailList = findIncomingDetail(pageNbr, pageSize, idStageList, callListInStruct);
    }

    return populateCallListSrchOutRec(incomingDetailList);
  }

  private PaginatedHibernateList<Map> findIncomingDetailByIdStage(int pageNbr, int pageSize, int idStage)
          throws ServiceException {

    // call cint11d
    PaginatedHibernateList<Map> incomingDetailList = incomingDetailDAO.findIncomingDetailByIdStage(pageNbr, pageSize,
                                                                                                   idStage);
    if (incomingDetailList == null || incomingDetailList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }

    return incomingDetailList;
  }

  private List<Integer> getPhoneticNameList(String nmFirstName, String nmMiddleName, String nmLastName,
                                            String cdStagePersType) {

    List<Integer> idPersonList = new ArrayList<Integer>();
    NameSearchQuery nameSearchQuery = new NameSearchQuery();
    nameSearchQuery.setSearchScope(PhoneticSearchQuery.SEARCH_TYPICAL);
    nameSearchQuery.setMatchTolerance(PhoneticSearchQuery.MATCH_TYPICAL);
    nameSearchQuery.setFirstName(nmFirstName);
    nameSearchQuery.setMiddleName(nmMiddleName);
    nameSearchQuery.setLastName(nmLastName);
    List<Integer> idStageList = null;
    List<Integer> idStageRepList;
    try {
      PhoneticSearchResultSet searchResults = phoneticSearchService.executeSearch(nameSearchQuery);
      while (searchResults.next()) {
        int idPerson = Integer.parseInt(searchResults.getField("ID_PERSON"));
        idPersonList.add(idPerson);
      }
      // STGAP00003979 
      if (idPersonList != null && !idPersonList.isEmpty()) {
        idStageList = complexStagePersonLinkDAO.findIdStageByIdPersonStagePersType(idPersonList, cdStagePersType);
      }
      // if Person Type is Reporter, then search Incoming_Detail table in addition to Phonetic Search
      // and add new result to the initial list
      // Note that the additional search on Incoming_Detail is exact name search
      
      // STGAP00004514 - this check is removed so when no person type is selected and intake has not made to INV, search returns
      // Note that in this case, only Incoming_Detail has the reporter info and Phonetic Search does not search on Incoming_Detail
      //if (CodesTables.CCALLLOG_REP.equals(cdStagePersType)) { // STGAP00004514 - this check is removed 
        idStageRepList = incomingDetailDAO.findIncomingDetailStageByNmFirstNmLast(nmFirstName, nmLastName);
        if (idStageList != null && !idStageList.isEmpty()) {
          Iterator<Integer> itrIdStageList = idStageList.iterator();
          Map<Integer, Integer> idStageMap = new HashMap<Integer, Integer>();
          while (itrIdStageList.hasNext()) {
            int idStage = (Integer)itrIdStageList.next();
            idStageMap.put(idStage, idStage);
          }
          Iterator<Integer> itrIdStageRepList = idStageRepList.iterator();
          while (itrIdStageRepList.hasNext()) {
            int idRep = (Integer)itrIdStageRepList.next();
            if (!idStageMap.containsKey(idRep)) {
              idStageList.add(idRep);
            }
          }
        } else {
          if (idStageRepList != null && !idStageRepList.isEmpty()) {
            idStageList = new ArrayList<Integer>();
            idStageList.addAll(idStageRepList); 
          }
        }
      //}
      if (idStageList == null || idStageList.isEmpty()) {
        throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
      } 
      // end STGAP00003979 
      
      /*if (idPersonList == null || idPersonList.isEmpty()) {
        throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
      }

      idStageList = complexStagePersonLinkDAO.findIdStageByIdPersonStagePersType(idPersonList, cdStagePersType);

      if (idStageList == null || idStageList.isEmpty()) {
        throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
      }*/

    } catch (PhoneticSearchServiceException e) {
      throw new PhoneticSearchServiceException(Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED, e);
    }
    return idStageList;
  }

  private PaginatedHibernateList<Map> findIncomingDetail(int pageNbr, int pageSize, List<Integer> idStageList,
                                                         CallListInStruct callListInStruct) throws ServiceException {
    Date dtIncomingCallFrom = DateHelper.toJavaDate(callListInStruct.getSzScrDtRangeFrom());
    Date dtIncomingCallTo = DateHelper.toJavaDate(callListInStruct.getSzScrDtRangeTo());
    if (!DateHelper.isNull(dtIncomingCallFrom)) {
      if (callListInStruct.getSzScrTimeFrom() == null) {
        callListInStruct.setSzScrTimeFrom(TIME_MINIMUM);
      }
      dtIncomingCallFrom = DateHelper.toJavaDateSafe(callListInStruct.getSzScrDtRangeFrom(),
                                                     callListInStruct.getSzScrTimeFrom());
    }
    if (!DateHelper.isNull(dtIncomingCallTo)) {
      if (callListInStruct.getSzScrTmTimeTo() == null) {
        callListInStruct.setSzScrTmTimeTo(TIME_MAXIMUM);
      }
      dtIncomingCallTo = DateHelper.toJavaDateSafe(callListInStruct.getSzScrDtRangeTo(),
                                                   callListInStruct.getSzScrTmTimeTo());
    }
    String cdStageClassification = callListInStruct.getSzCdStageClassification();
    String cdIncomingCallerCounty = callListInStruct.getSzCdIncomingCallerCounty();
    String cdIncmgRegion = callListInStruct.getSzCdStageRegion();
    String cdIncomingDisposition = callListInStruct.getSzCdIncomingDisposition();
    String cdStageCurrPriority = callListInStruct.getSzCdStageCurrPriority();
    String nbrIncmgUnit = callListInStruct.getSzNbrUnit();
    String cdIncmgAllegType = callListInStruct.getSzCdStageNonIncType();

    List<String> cdCityList = new ArrayList<String>();
    String addrIncomingCallerCity = callListInStruct.getSzAddrIncomingCallerCity();

    if (StringHelper.isValid(addrIncomingCallerCity)) {
      String cityFirstChar = addrIncomingCallerCity.substring(0, 1);
      String cityRemainder = addrIncomingCallerCity.substring(1);
      String callerCityFirstCharCap = cityFirstChar.toUpperCase() + cityRemainder.toLowerCase();
      String callerCityAllCap = addrIncomingCallerCity.toUpperCase();
      cdCityList.add(callerCityFirstCharCap);
      cdCityList.add(callerCityAllCap);
    }
    // call cint11d
    PaginatedHibernateList<Map> incomingDetailList =
            dynamicIncomingDetailDAO.findIncomingDetailByIdName(pageNbr, pageSize, cdStageClassification, cdCityList,
                                                                cdIncomingCallerCounty, cdIncmgRegion,
                                                                cdIncomingDisposition, cdStageCurrPriority,
                                                                nbrIncmgUnit, dtIncomingCallFrom, dtIncomingCallTo,
                                                                cdIncmgAllegType, idStageList);
    if (incomingDetailList == null || incomingDetailList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }
    return incomingDetailList;
  }

  private CallListSrchOutRec populateCallListSrchOutRec(PaginatedHibernateList<Map> incomingDetailList) {

    CallListSrchOutRec callListSrchOutRec = new CallListSrchOutRec();

    int rowQty = 0;

    CallListStruct_ARRAY callListArray = new CallListStruct_ARRAY();
    //setting the value of moreDataAvailable from the list object's isMoreDataAvailable()
    callListArray.setMoreDataAvailable(incomingDetailList.isMoreDataAvailable());
    for (Iterator<Map> it = incomingDetailList.iterator(); it.hasNext();) {
      Map incomingDetailMap = it.next();
      CallListStruct callSearchRow = new CallListStruct();

      callSearchRow.setSzScrNmIncmgCaller(getIncomingFullName((String) incomingDetailMap.get("nmIncomingCallerLast"),
                                                              (String) incomingDetailMap.get("nmIncomingCallerFirst"),
                                                              (String) incomingDetailMap.get(
                                                                      "nmIncomingCallerMiddle")));

      callSearchRow.setSzCdIncomingDisposition(incomingDetailMap.get("cdIncomingDisposition") != null ?
                                               (String) incomingDetailMap.get("cdIncomingDisposition") :
                                               StringHelper.EMPTY_STRING);

      String dtIncomingCallString = getIncomingDate((Date) incomingDetailMap.get("dtIncomingCall"));
      callSearchRow.setDtDtIncomingCall(DateHelper.toCastorDateSafe(dtIncomingCallString));
      callSearchRow.setTmTmIncmgCall(getIncomingTime((Date) incomingDetailMap.get("dtIncomingCall")));
      callSearchRow.setSzCdAddrCounty(incomingDetailMap.get("cdIncomingCallerCounty") != null ?
                                      (String) incomingDetailMap.get("cdIncomingCallerCounty") :
                                      StringHelper.EMPTY_STRING);
      callSearchRow.setSzAddrCity(incomingDetailMap.get("addrIncomingCallerCity") != null ?
                                  (String) incomingDetailMap.get("addrIncomingCallerCity") : StringHelper.EMPTY_STRING);
      callSearchRow.setSzScrPersonName((String) incomingDetailMap.get("nmIncmgWorkerName"));
      callSearchRow.setUlIdStage((Integer) incomingDetailMap.get("idStage"));
      callSearchRow.setUlIdIncomingWorker((Integer) incomingDetailMap.get("idIncomingWorker"));
      callSearchRow.setBIndIncmgSensitive((String) incomingDetailMap.get("indIncmgSensitive"));
      callSearchRow.setBIndIncmgIntInvClsReclss((String) incomingDetailMap.get("indIncmgIntInvClsReclass"));
      rowQty++;
      callListArray.addCallListStruct(callSearchRow);
    }
    callListArray.setUlRowQty(rowQty);

    callListSrchOutRec.setCallListStruct_ARRAY(callListArray);
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(incomingDetailList.getBMoreDataInd());
    archOutputStruct.setUlRowQty(rowQty);
    callListSrchOutRec.setArchOutputStruct(archOutputStruct);

    return callListSrchOutRec;
  }

  private String getIncomingFullName(String nmMameLast, String nmNameFirst, String nmNameMiddle) {

    nmNameMiddle = nmNameMiddle != null ? nmNameMiddle.substring(0, 1) : StringHelper.EMPTY_STRING;
    String nmIncomingCallerFull = nmMameLast + "," + nmNameFirst + " " + nmNameMiddle;

    return (nmMameLast != null ? nmIncomingCallerFull : StringHelper.EMPTY_STRING);
  }

  private String getIncomingDate(Date dtIncomingCall) {

    Calendar cal = Calendar.getInstance();
    cal.setTime(dtIncomingCall);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    month += 1;
    int day = cal.get(Calendar.DAY_OF_MONTH);

    return String.valueOf(year + "-" + month + "-" + day);
  }

  private String getIncomingTime(Date dtIncomingCall) {

    Calendar cal = Calendar.getInstance();
    cal.setTime(dtIncomingCall);
    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int AM_PM = cal.get(Calendar.AM_PM);
    String AM_PMString = "AM";
    if (AM_PM == 1) {
      AM_PMString = "PM";
    }
    String minuteLessThanTen = StringHelper.EMPTY_STRING;
    if (minute < 10) {
      minuteLessThanTen = "0";
    }
    return String.valueOf(hour + ":" + minuteLessThanTen + minute + " " + AM_PMString);
  }

}
