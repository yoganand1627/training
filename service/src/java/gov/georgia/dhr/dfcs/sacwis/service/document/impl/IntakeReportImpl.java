package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.document.IntakeReport;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  6/12/08   cwells            STGAP00007985: If the plan is being copied then we want the dates to be  
                                                      enabled.
  07/30/08  cwells            STGAP00006201: Updating the Next Review date when the current review date is changed

  08/20/08  mxpatel           STGAP00007052: Created a temporary hash map to store and compare values in the existing map
                                             Created if loop to check if the id is already in the hash map, and wether it has SSN
                                             Created a for loop to iterate over the hash map in order to display the correct info.
*/

public class IntakeReportImpl extends BaseDocumentServiceImpl implements IntakeReport {

  private static final int MAX_PERSON_INFO_ROWS = 50;

  private static final String[][] VICTIM_INFO_META_INFORMATION = new String[][] {
                                                                                 { VICTIM_AGE, "nbrPersonAge", null },
                                                                                 { VICTIM_DOB_APPROX,
                                                                                  "indPersonDobApprox", null },
                                                                                 { VICTIM_SEX, "cdPersonSex",
                                                                                  CodesTables.CSEX },
                                                                                 { VICTIM_DOB, "dtPersonBirth", null },
                                                                                 { VICTIM_DOD, "dtPersonDeath", null },
                                                                                 { VICTIM_NAME_SUFFIX,
                                                                                  "cdPersonSuffix",
                                                                                  CodesTables.CSUFFIX2 },
                                                                                 { VICTIM_RSN, "cdPersonDeath",
                                                                                  CodesTables.CRSNFDTH },
                                                                                 { VICTIM_ETHNCTY,
                                                                                  "cdPersonEthnicGroup",
                                                                                  CodesTables.CETHNIC },
                                                                                 { VICTIM_LANG, "cdPersonLanguage",
                                                                                  CodesTables.CLANG },
                                                                                 { VICTIM_MARITAL,
                                                                                  "cdPersonMaritalStatus",
                                                                                  CodesTables.CMARSTAT },
                                                                                 { VICTIM_RELTNSP, "cdStagePersRelInt",
                                                                                  CodesTables.CRELVICT },
                                                                                 { VICTIM_SSN, "nbrPersonIdNumber",
                                                                                  null },
                                                                                 { VICTIM_NAME_FIRST, "nmPersonFirst",
                                                                                  null },
                                                                                 { VICTIM_NAME_LAST, "nmPersonLast",
                                                                                  null },
                                                                                 { VICTIM_NAME_MIDDLE,
                                                                                  "nmPersonMiddle", null },
                                                                                 { VICTIM_NOTES, "txtStagePersNotes",
                                                                                  null } };

  private static final String[][] AP_INFO_META_INFORMATION = new String[][] {
                                                                             { AP_AGE, "nbrPersonAge", null },
                                                                             { AP_DOB_APPROX, "indPersonDobApprox",
                                                                              null },
                                                                             { AP_SEX, "cdPersonSex", CodesTables.CSEX },
                                                                             { AP_DOB, "dtPersonBirth", null },
                                                                             { AP_DOD, "dtPersonDeath", null },
                                                                             { AP_NAME_SUFFIX, "cdPersonSuffix",
                                                                              CodesTables.CSUFFIX2 },
                                                                             { AP_RSN, "cdPersonDeath",
                                                                              CodesTables.CRSNFDTH },
                                                                             { AP_ETHNCTY, "cdPersonEthnicGroup",
                                                                              CodesTables.CETHNIC },
                                                                             { AP_LANG, "cdPersonLanguage",
                                                                              CodesTables.CLANG },
                                                                             { AP_MARITAL, "cdPersonMaritalStatus",
                                                                              CodesTables.CMARSTAT },
                                                                             { AP_RELTNSP, "cdStagePersRelInt",
                                                                              CodesTables.CRELVICT },
                                                                             { AP_SSN, "nbrPersonIdNumber", null },
                                                                             { AP_NAME_FIRST, "nmPersonFirst", null },
                                                                             { AP_NAME_LAST, "nmPersonLast", null },
                                                                             { AP_NAME_MIDDLE, "nmPersonMiddle", null },
                                                                             { AP_NOTES, "txtStagePersNotes", null } };

  private static final String[][] PRINC_INFO_META_INFORMATION = new String[][] {
                                                                                { PRINC_AGE, "nbrPersonAge", null },
                                                                                { PRINC_DOB_APPROX,
                                                                                 "indPersonDobApprox", null },
                                                                                { PRINC_SEX, "cdPersonSex",
                                                                                 CodesTables.CSEX },
                                                                                { PRINC_DOB, "dtPersonBirth", null },
                                                                                { PRINC_DOD, "dtPersonDeath", null },
                                                                                { PRINC_NAME_SUFFIX, "cdPersonSuffix",
                                                                                 CodesTables.CSUFFIX2 },
                                                                                { PRINC_RSN, "cdPersonDeath",
                                                                                 CodesTables.CRSNFDTH },
                                                                                { PRINC_ETHNCTY, "cdPersonEthnicGroup",
                                                                                 CodesTables.CETHNIC },
                                                                                { PRINC_LANG, "cdPersonLanguage",
                                                                                 CodesTables.CLANG },
                                                                                { PRINC_MARITAL,
                                                                                 "cdPersonMaritalStatus",
                                                                                 CodesTables.CMARSTAT },
                                                                                { PRINC_RELTNSP, "cdStagePersRelInt",
                                                                                 CodesTables.CRELVICT },
                                                                                { PRINC_ROLE, "cdStagePersRole",
                                                                                 CodesTables.CROLES },
                                                                                { PRINC_SSN, "nbrPersonIdNumber", null },
                                                                                { PRINC_NAME_FIRST, "nmPersonFirst",
                                                                                 null },
                                                                                { PRINC_NAME_LAST, "nmPersonLast", null },
                                                                                { PRINC_NAME_MIDDLE, "nmPersonMiddle",
                                                                                 null },
                                                                                { PRINC_NOTES, "txtStagePersNotes",
                                                                                 null } };

  private static final String[][] RPT_INFO_META_INFORMATION = new String[][] {
                                                                              { RPT_NAME_SUFFIX, "cdPersonSuffix",
                                                                               CodesTables.CSUFFIX2 },
                                                                              { RPT_RELTNSP, "cdStagePersRelInt",
                                                                               CodesTables.CRPTRINT },
                                                                              { RPT_NAME_FIRST, "nmPersonFirst", null },
                                                                              { RPT_NAME_LAST, "nmPersonLast", null },
                                                                              { RPT_NAME_MIDDLE, "nmPersonMiddle", null },
                                                                              { RPT_NOTES, "txtStagePersNotes", null } };

  private static final String[][] COL_INFO_META_INFORMATION = new String[][] {
                                                                              { COL_SEX, "cdPersonSex",
                                                                               CodesTables.CSEX },
                                                                              { COL_NAME_SUFFIX, "cdPersonSuffix",
                                                                               CodesTables.CSUFFIX2 },
                                                                              { COL_RELTNSP, "cdStagePersRelInt",
                                                                               CodesTables.CSRCRPTR },
                                                                              { COL_NAME_FIRST, "nmPersonFirst", null },
                                                                              { COL_NAME_LAST, "nmPersonLast", null },
                                                                              { COL_NAME_MIDDLE, "nmPersonMiddle", null },
                                                                              { COL_NOTES, "txtStagePersNotes", null } };

  private AddressPersonLinkDAO addressPersonLinkDAO;

  private ApproversDAO approversDAO;

  private DynamicPersonDAO dynamicPersonDAO;

  private EventDAO eventDAO;

  private IncmgDetermFactorsDAO incmgDetermFactorsDAO;

  private IncomingDetailDAO incomingDetailDAO;

  private IntakeAllegationDAO intakeAllegationDAO;

  private NameDAO nameDAO;

  private PersonPhoneDAO personPhoneDAO;

  private StageDAO stageDAO;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setDynamicPersonDAO(DynamicPersonDAO dynamicPersonDAO) {
    this.dynamicPersonDAO = dynamicPersonDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setIncmgDetermFactorsDAO(IncmgDetermFactorsDAO incmgDetermFactorsDAO) {
    this.incmgDetermFactorsDAO = incmgDetermFactorsDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CINT39SO retrieveIntakeReport(CINT39SI cint39si) {
    CINT39SO cint39so = new CINT39SO();
    int idStage = cint39si.getUlIdStage();
    Integer idEvent = 0;

    Object[] incomingDetailInfo = incomingDetailDAO.findIncomingDetailAndDtEventOccurred(idStage);
   
    if (incomingDetailInfo == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    PreFillData preFillData = getIncomingDetail(incomingDetailInfo);
    Event leEvent = eventDAO.findEventByStageAndType(idStage, CodesTables.CEVNTTYP_NOT);
    String dtEventOccurred = "";
    if (leEvent != null) {
      dtEventOccurred = FormattingHelper.formatDate(leEvent.getDtEventOccurred());
    }
    preFillData.addBookmark(createBookmark(SUM_LE_NOTIFY_DATE, dtEventOccurred));
    // Note that, in the original service, cint62d and cint63d was always
    // called after cint65d was called, but it is
    // easier in Java
    // to call it here, and failure of either caused the entire service to
    // fail.
   
    PaginatedHibernateList<Map> reporterCheck = dynamicPersonDAO.findPersonInfoByTypeAndIdStage(idStage, 4, 1,
                                                                                             MAX_PERSON_INFO_ROWS);
    
    Map<Integer, Set<PersonPhone>> personPhoneMap = findPersonPhoneInformation(idStage);
    Map<Integer, Set<AddressPersonLink>> addressPersonLinkMap = findAddressPersonLinkInformation(idStage);
    IncomingDetail incomingDetail = (IncomingDetail) incomingDetailInfo[0];
 
    Map<Integer, Set<Name>> nameMap = findNameInformation(idStage);

    addPersonInformation(idStage, DynamicPersonDAO.VICTIM_TYPE, VICTIM_INFO_META_INFORMATION, preFillData,
                         TMPLAT_VICTIM, CFIN0101, personPhoneMap, addressPersonLinkMap, nameMap);

    addPersonInformation(idStage, DynamicPersonDAO.PERPETRATOR_TYPE, AP_INFO_META_INFORMATION, preFillData,
                         TMPLAT_ALLEG_PERP, CFIN0102, personPhoneMap, addressPersonLinkMap, nameMap);
    
    addPersonInformation(idStage, DynamicPersonDAO.OTHER_PRN_TYPE, PRINC_INFO_META_INFORMATION, preFillData,
                         TMPLAT_PRINC_OTHER, CFIN0103, personPhoneMap, addressPersonLinkMap, nameMap);


    // STGAP00005861 Getting the Reporter Information from the Incoming detail instead of the Person Table

    if (reporterCheck.isEmpty() || reporterCheck == null ) {
      addReporterInformation(incomingDetail, preFillData, TMPLAT_REPORTER, CFIN0104);
    }
    addPersonInformation(idStage, DynamicPersonDAO.REPORTER_TYPE, RPT_INFO_META_INFORMATION, preFillData,
                           TMPLAT_REPORTER, CFIN0104, personPhoneMap, addressPersonLinkMap, nameMap);

    addPersonInformation(idStage, DynamicPersonDAO.COLLATERAL_TYPE, COL_INFO_META_INFORMATION, preFillData,
                         TMPLAT_COLLATERAL, CFIN0105, personPhoneMap, addressPersonLinkMap, nameMap);
    List<Map> allegationInfo = intakeAllegationDAO.findIntakeAllegationsByIdStage(idStage);
    // Retrieve Alleged Perpetrator information
    if (allegationInfo != null && !allegationInfo.isEmpty()) {
      for (Iterator<Map> it = allegationInfo.iterator(); it.hasNext();) {
        Map map = it.next();
        FormDataGroup group = createFormDataGroup(TMPLAT_ALLEGATION, CFIN0107);
        String allegDecode = Lookup.simpleDecodeSafe(CodesTables.CMALCODE, (String) map.get("cdAllegedMalCode"));
        group.addBookmark(createBookmark(ALLEG_DTL_ALLEG, allegDecode));
        group.addBookmark(createBookmark(ALLEG_DTL_AP, map.get("nmPersAllegPerp")));
        group.addBookmark(createBookmark(ALLEG_DTL_VICTIM, map.get("nmPersVictim")));
        preFillData.addFormDataGroup(group);
      }
    }
    List<Map> incmgDetermFactors = incmgDetermFactorsDAO.findIncmgDetermFactorsByIdStage(idStage);
    if (incmgDetermFactors != null && !incmgDetermFactors.isEmpty()) {
      for (Iterator<Map> it = incmgDetermFactors.iterator(); it.hasNext();) {
        Map map = it.next();
        FormDataGroup detGroup = createFormDataGroup(TMPLAT_DET_FACTR, CFIN0106);
        String detFactor = "";
        List<String> determFactors = new ArrayList<String>();
        determFactors.add(Lookup.simpleDecodeSafe(CodesTables.CPHYABSE, (String) map.get("cdIncmgDeterm")));
        determFactors.add(Lookup.simpleDecodeSafe(CodesTables.CNEGLECT, (String) map.get("cdIncmgDeterm")));
        determFactors.add(Lookup.simpleDecodeSafe(CodesTables.CEMLABSE, (String) map.get("cdIncmgDeterm")));
        determFactors.add(Lookup.simpleDecodeSafe(CodesTables.CSEXABSE, (String) map.get("cdIncmgDeterm")));
        determFactors.add(Lookup.simpleDecodeSafe(CodesTables.COTHER, (String) map.get("cdIncmgDeterm")));

        for (Iterator detFact = determFactors.iterator(); detFact.hasNext();) {
          String factor = (String) detFact.next();
          if (factor != null && !"".equals(factor)) {
            detFactor = factor;
            break;
          }
        }
        detGroup.addBookmark(createBookmark(DETERM_FACTR, detFactor));
        preFillData.addFormDataGroup(detGroup);
      }
    }

    if (((IncomingDetail) incomingDetailInfo[0]).getEvent() != null) {
      if (((IncomingDetail) incomingDetailInfo[0]).getEvent().getIdEvent() != null) {

        idEvent = ((IncomingDetail) incomingDetailInfo[0]).getEvent().getIdEvent();
      }
    }
    // STGAP00002135 This will remove the null pointers thrown by having an
    // empty event object
    Event event = eventDAO.findEventByIdEvent(idEvent) != null ? event = eventDAO.findEventByIdEvent(idEvent)
                                                              : new Event();

    if (CodesTables.CEVTSTAT_APRV.equals(event.getCdEventStatus())) {
      List<Object[]> approversInformationList = approversDAO.findAllApproversByIntakeIdEvent(idEvent);

      if (approversInformationList != null && !approversInformationList.isEmpty()) {
        Object[] approverInformation = approversInformationList.get(0);
        Date approvalDate = (Date) approverInformation[11];
        preFillData.addBookmark(createBookmark(HIS_APPROVED_DATE, FormattingHelper.formatDate(approvalDate)));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_PHONE, approverInformation[6]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_EXT, approverInformation[7]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_CITY, approverInformation[5]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_BJN, approverInformation[4]));
        String suffix = (String) approverInformation[3];
        preFillData.addBookmark(createBookmark(HIS_APPROVED_SUFFIX, Lookup.simpleDecodeSafe(CodesTables.CSUFFIX2,
                                                                                            suffix)));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_FIRST, approverInformation[0]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_LAST, approverInformation[2]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_MIDDLE, approverInformation[1]));
        preFillData.addBookmark(createBookmark(HIS_APPROVED_TIME, FormattingHelper.formatTime(approvalDate)));
        if (suffix != null) {
          preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA_2, CFZCO00));
        }
      }
    }
    // cint67d
    List<Object[]> eventHistoryList = eventDAO.findEventHistory(idStage, CodesTables.CEVNTTYP_STG);
    if (eventHistoryList != null && !eventHistoryList.isEmpty()) {
      Object[] eventHistory = eventHistoryList.get(0);
      Date changeDate = (Date) eventHistory[11];
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_DATE, FormattingHelper.formatDate(changeDate)));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_PHONE, eventHistory[6]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_EXT, eventHistory[7]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_CITY, eventHistory[5]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_BJN, eventHistory[4]));
      String suffix = (String) eventHistory[3];
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_SUFFIX, Lookup.simpleDecodeSafe(CodesTables.CSUFFIX2,
                                                                                              suffix)));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_FIRST, eventHistory[0]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_LAST, eventHistory[2]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_MIDDLE, eventHistory[1]));
      preFillData.addBookmark(createBookmark(HIS_STAGE_CHANGE_TIME, FormattingHelper.formatTime(changeDate)));
      if (suffix != null) {
        preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA_2, CFZCO00));
      }
    }
    // cint68d
    List<Object[]> eventDescriptionlist = eventDAO.findEventDescriptionInformationByIdStage(idStage);
    if (eventDescriptionlist != null && !eventDescriptionlist.isEmpty()) {
      for (Iterator<Object[]> it = eventDescriptionlist.iterator(); it.hasNext();) {
        Object[] eventDescription = it.next();
        FormDataGroup group = createFormDataGroup(TMPLAT_PRIORITY_CHANGES, CFIN0108);
        group.addBookmark(createBookmark(HIS_PRIORITY_CHANGE, eventDescription[0]));
        group.addBookmark(createBookmark(HIS_PRIORITY_REASON, Lookup.simpleDecodeSafe(CodesTables.CRSNPRIO,
                                                                                      (String) eventDescription[1])));
        group.addBookmark(createBookmark(HIS_PRIORITY_EXPL, eventDescription[2]));
        preFillData.addFormDataGroup(group);
      }
    }
    cint39so.setPreFillData(preFillData);
    // do something.
    return cint39so;
  }

  private void addReporterInformation(IncomingDetail incomingDetail, PreFillData preFillData,
                                      String formDataGroupBookmarkName, String subGroupTemplateName) {
    FormDataGroup group = createFormDataGroup(formDataGroupBookmarkName, subGroupTemplateName);
    group.addBookmark(createBookmark(RPT_NAME_FIRST, incomingDetail.getNmIncomingCallerFirst()));
    group.addBookmark(createBookmark(RPT_NAME_MIDDLE, incomingDetail.getNmIncomingCallerMiddle()));
    group.addBookmark(createBookmark(RPT_NAME_LAST, incomingDetail.getNmIncomingCallerLast()));
    group.addBookmark(createBookmark(RPT_NAME_SUFFIX,
                                     Lookup.simpleDecodeSafe(CodesTables.CSUFFIX2,
                                                             incomingDetail.getCdIncomingCallerSuffix())));
    group.addBookmark(createBookmark(RPT_RELTNSP, Lookup.simpleDecodeSafe(CodesTables.CSRCRPTR,
                                                                          incomingDetail.getCdIncmgCallerInt())));
    group.addFormDataGroup(createReporterAddress(incomingDetail));
    group.addFormDataGroup(createReporterPhone(incomingDetail));
    preFillData.addFormDataGroup(group);
  }

  private FormDataGroup createReporterAddress(IncomingDetail incomingDetail) {
    FormDataGroup group = createFormDataGroup(TMPLAT_ADDR_FULL, CFZZ0101);

    group
         .addBookmark(createBookmark(ADDR_TYPE, Lookup.simpleDecodeSafe(CodesTables.CADDRTYP,
                                                                            incomingDetail.getCdIncmgCallerAddrType())));
    group.addBookmark(createBookmark(ADDR_LN_1, incomingDetail.getAddrIncmgStreetLn1()));
    group.addBookmark(createBookmark(ADDR_LN_2, incomingDetail.getAddrIncmgStreetLn2()));
    group.addBookmark(createBookmark(ADDR_CITY, incomingDetail.getAddrIncomingCallerCity()));
    group.addBookmark(createBookmark(ADDR_STATE, incomingDetail.getCdIncomingCallerState()));
    group.addBookmark(createBookmark(ADDR_ZIP, incomingDetail.getAddrIncmgZip()));
    group.addBookmark(createBookmark(ADDR_COUNTY,
                                     Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                             incomingDetail.getCdIncomingCallerCounty())));

    return group;
  }

  
  private FormDataGroup createReporterPhone(IncomingDetail incomingDetail) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PHONE, CFZZ0201);

    group.addBookmark(createBookmark(PHONE_NUMBER,
                                     FormattingHelper.formatPhone(incomingDetail.getNbrIncomingCallerPhone())));
    group.addBookmark(createBookmark(PHONE_NUM_EXTENSION, incomingDetail.getNbrIncmgCallerPhonExt()));
    group
         .addBookmark(createBookmark(PHONE_TYPE, Lookup.simpleDecodeSafe(CodesTables.CPHNTYP,
                                                                             incomingDetail.getCdIncmgCallerPhonType())));
    return group;
  }

  private void addPersonInformation(int idStage, int type, String[][] metaInfo, PreFillData preFillData,
                                    String formDataGroupBookmarkName, String subGroupTemplateName,
                                    Map<Integer, Set<PersonPhone>> personPhoneMap,
                                    Map<Integer, Set<AddressPersonLink>> addressPersonLinkMap,
                                    Map<Integer, Set<Name>> nameMap) {
    // cint66d
    PaginatedHibernateList<Map> personInfo = dynamicPersonDAO.findPersonInfoByTypeAndIdStage(idStage, type, 1,
                                                                                             MAX_PERSON_INFO_ROWS);
    if (personInfo != null && !personInfo.isEmpty()) {
      
      HashMap<Object, Map > cache = new HashMap<Object, Map>();//mxpatel added this
      
      for (Iterator<Map> it = personInfo.iterator(); it.hasNext();) {
        Map map = it.next();
        
        Object object = map.get("idPerson");
        
        
        if(cache.containsKey(object)){ //mxpatel added this if statement
          if (CodesTables.CNUMTYPE_SSN.equals(map.get("cdPersonIdType"))) {
           cache.put(object, map);
          }else {
            continue;
          }
        }else {
          cache.put(object, map);
        }
      }

      for(Map map : cache.values()){ //mxpatel added this for loop
        
        if (!CodesTables.CNUMTYPE_SSN.equals(map.get("cdPersonIdType"))) {
             map.remove("nbrPersonIdNumber");
        }
         
        FormDataGroup group = createFormDataGroup(formDataGroupBookmarkName, subGroupTemplateName);
        for (int i = 0; i < metaInfo.length; i++) {
          String[] metaInfoRow = metaInfo[i];
                      
          group.addBookmark(createBookmarkFromMap(map, metaInfoRow[0], metaInfoRow[1], metaInfoRow[2]));
        }
        
        
        // If the suffix is non-null, create an empty group for a comma
        // placement.
        if (map.get("cdPersonSuffix") != null) {
          group.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA, CFZCO00));
        }
        // Add phone information.
        Integer idPerson = (Integer) map.get("idPerson");
        Set<PersonPhone> personPhoneSet = personPhoneMap.get(idPerson);
        if (personPhoneSet != null) {
          for (Iterator<PersonPhone> personPhoneIt = personPhoneSet.iterator(); personPhoneIt.hasNext();) {
              group.addFormDataGroup(createPersonPhoneInformation(personPhoneIt.next()));
            
          }
        }
        // Add Address Information.
        Set<AddressPersonLink> addressPersonLinkSet = addressPersonLinkMap.get(idPerson);
        if (addressPersonLinkSet != null) {
          for (Iterator<AddressPersonLink> addressPersonLinkIt = addressPersonLinkSet.iterator(); addressPersonLinkIt
                                                                                                                     .hasNext();) {              
              group.addFormDataGroup(createAddressPersonLinkInformation(addressPersonLinkIt.next()));

          }
        }
        // Add Name Information.
        Set<Name> nameSet = nameMap.get(idPerson);
        if (nameSet != null) {
          for (Iterator<Name> nameIt = nameSet.iterator(); nameIt.hasNext();) {
            group.addFormDataGroup(createNameInformation(nameIt.next()));
          }
        }
        preFillData.addFormDataGroup(group);
        
      }

    }
  }

  private Map<Integer, Set<PersonPhone>> findPersonPhoneInformation(int idStage) {
    // cint62
    List<PersonPhone> personPhoneList = personPhoneDAO.findPersonPhoneByIdStage(idStage);
    // Loop over the personPhoneList and build a map that can be used to
    // look up phone information for each person.
    Map<Integer, Set<PersonPhone>> personPhoneMap = new HashMap<Integer, Set<PersonPhone>>();
    for (Iterator<PersonPhone> it = personPhoneList.iterator(); it.hasNext();) {
      PersonPhone personPhone = it.next();
      Integer idPerson = personPhone.getPerson().getIdPerson();
      Set<PersonPhone> personPhoneSet = personPhoneMap.get(idPerson);
      if (personPhoneSet == null) {
        personPhoneSet = new HashSet<PersonPhone>();
        personPhoneMap.put(idPerson, personPhoneSet);
      }
      personPhoneSet.add(personPhone);
    }
    return personPhoneMap;
  }

  private FormDataGroup createPersonPhoneInformation(PersonPhone personPhone) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PHONE, CFZZ0201);
    group.addBookmark(createBookmark(PHONE_NUMBER, FormattingHelper.formatPhone(personPhone.getNbrPersonPhone())));
    group.addBookmark(createBookmark(PHONE_NUM_EXTENSION, personPhone.getNbrPersonPhoneExtension()));
    group.addBookmark(createBookmark(PHONE_TYPE, Lookup.simpleDecodeSafe(CodesTables.CPHNTYP,
                                                                         personPhone.getCdPersonPhoneType())));
    group.addBookmark(createBookmark(PHONE_NOTES, personPhone.getTxtPersonPhoneComments()));
    return group;
  }

  private Map<Integer, Set<AddressPersonLink>> findAddressPersonLinkInformation(int idStage) {
    // cint62
    List<AddressPersonLink> addressPersonLinkList = addressPersonLinkDAO
                                                                        .findAddressPersonLinkAndPersonAddressByIdStage(idStage);
    // Loop over the addressPersonLinkList and build a map that can be used
    // to look up address information for each
    // person.
    Map<Integer, Set<AddressPersonLink>> addressPersonLinkMap = new HashMap<Integer, Set<AddressPersonLink>>();
    for (Iterator<AddressPersonLink> it = addressPersonLinkList.iterator(); it.hasNext();) {
      AddressPersonLink addressPersonLink = it.next();
      Integer idPerson = addressPersonLink.getPerson().getIdPerson();
      Set<AddressPersonLink> addressPersonLinkSet = addressPersonLinkMap.get(idPerson);
      if (addressPersonLinkSet == null) {
        addressPersonLinkSet = new HashSet<AddressPersonLink>();
        addressPersonLinkMap.put(idPerson, addressPersonLinkSet);
      }
      addressPersonLinkSet.add(addressPersonLink);
    }
    return addressPersonLinkMap;
  }

  private FormDataGroup createAddressPersonLinkInformation(AddressPersonLink addressPersonLink) {
    FormDataGroup group = createFormDataGroup(TMPLAT_ADDR_FULL, CFZZ0101);
    PersonAddress personAddress = addressPersonLink.getPersonAddress();
    group.addBookmark(createBookmark(ADDR_ZIP, personAddress.getAddrPersonAddrZip()));
    group.addBookmark(createBookmark(ADDR_CITY, personAddress.getAddrPersonAddrCity()));
    group.addBookmark(createBookmark(ADDR_ATTN, personAddress.getAddrPersonAddrAttn()));
    group.addBookmark(createBookmark(ADDR_LN_1, personAddress.getAddrPersAddrStLn1()));
    group.addBookmark(createBookmark(ADDR_LN_2, personAddress.getAddrPersAddrStLn2()));
    group.addBookmark(createBookmark(ADDR_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                          personAddress.getCdPersonAddrCounty())));
    group.addBookmark(createBookmark(ADDR_STATE, personAddress.getCdPersonAddrState()));
    group.addBookmark(createBookmark(ADDR_TYPE, Lookup.simpleDecodeSafe(CodesTables.CADDRTYP,
                                                                        addressPersonLink.getCdPersAddrLinkType())));
    group.addBookmark(createBookmark(ADDR_NOTES, addressPersonLink.getTxtPersAddrCmnts()));
    return group;
  }
  
  private Map<Integer, Set<Name>> findNameInformation(int idStage) {
    // cint62

    List<Name> nameList = nameDAO.findNameByIdStage(idStage);

    // Loop over the personPhoneList and build a map that can be used to
    // look up name information for each person.
    Map<Integer, Set<Name>> nameMap = new HashMap<Integer, Set<Name>>();
    for (Iterator<Name> it = nameList.iterator(); it.hasNext();) {
      Name name = it.next();

      Integer idPerson = name.getPerson().getIdPerson();
      Set<Name> nameSet = nameMap.get(idPerson);
      if (nameSet == null) {
        nameSet = new HashSet<Name>();
        nameMap.put(idPerson, nameSet);
      }
      nameSet.add(name);
    }
    return nameMap;
  }

  private FormDataGroup createNameInformation(Name name) {
    FormDataGroup group = createFormDataGroup(TMPLAT_ALIAS, CFIN0109);
    group.addBookmark(createBookmark(ALIAS_NAME_FIRST, name.getNmNameFirst()));
    group.addBookmark(createBookmark(ALIAS_NAME_LAST, name.getNmNameLast()));
    group.addBookmark(createBookmark(ALIAS_NAME_MIDDLE, name.getNmNameMiddle()));
    return group;
  }

  private PreFillData getIncomingDetail(Object[] incomingDetailInfo) {
    // cint65d
    PreFillData preFillData = new PreFillData();
    IncomingDetail incomingDetail = (IncomingDetail) incomingDetailInfo[0];
    preFillData.addBookmark(createBookmark(CALL_NARR_WORKER_SAFETY, incomingDetail.getTxtIncmgWorkerSafety()));
    preFillData.addBookmark(createBookmark(CALL_NARR_SENSITIVE_ISSUE, incomingDetail.getTxtIncmgSensitive()));
    preFillData.addBookmark(createBookmark(SUM_SENSITIVE_ISSUE, incomingDetail.getIndIncmgSensitive()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_SAFETY_ISSUES, incomingDetail.getIndIncmgWorkerSafety()));
    String dtIncomingCall = FormattingHelper.formatDate(incomingDetail.getDtIncomingCall());
    preFillData.addBookmark(createBookmark(SUM_DATE_RPTED, dtIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_DATE, dtIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_EXT, incomingDetail.getNbrIncmgWorkerExt()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_EXTENSION, incomingDetail.getNbrIncmgWorkerExt()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_PHONE, incomingDetail.getNbrIncmgWorkerPhone()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_PHONE, incomingDetail.getNbrIncmgWorkerPhone()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_CITY, incomingDetail.getAddrIncmgWorkerCity()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_CITY, incomingDetail.getAddrIncmgWorkerCity()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_BJN, incomingDetailInfo[2]));
    preFillData.addBookmark(createBookmark(SUM_PRIM_ALLEG,
                                           Lookup.simpleDecodeSafe(CodesTables.CCLICALT,
                                                                   incomingDetail.getCdIncmgAllegType())));
    preFillData.addBookmark(createBookmark(SUM_SPCL_HANDLING,
                                           Lookup.simpleDecodeSafe(CodesTables.CSPECHND,
                                                                   incomingDetail.getCdIncmgSpecHandling())));
    Stage stage = incomingDetail.getStage();
    // Populate with defaults from Stage (simple way of avoiding NPE's).
    if (stage == null) {
      stage = new Stage();
    }

    String stageReasonClosed = Lookup.simpleDecodeSafe(CodesTables.CDISP, stage.getCdStageReasonClosed());
    preFillData.addBookmark(createBookmark(HIS_RSN_FOR_CLOSURE, stageReasonClosed));
    preFillData.addBookmark(createBookmark(SUM_DISPOSTION, stageReasonClosed));
    String stageCurrPriority = Lookup.simpleDecodeSafe(CodesTables.CPRIORTY, stage.getCdStageCurrPriority());
    preFillData.addBookmark(createBookmark(HIS_CURR_PRIORITY, stageCurrPriority));
    preFillData.addBookmark(createBookmark(SUM_PRIORITY_DETERM, stageCurrPriority));
    String stageInitialPriority = Lookup.simpleDecodeSafe(CodesTables.CPRIORTY, stage.getCdStageInitialPriority());
    preFillData.addBookmark(createBookmark(SUM_INIT_RESPON_TIME, stageInitialPriority));
    preFillData.addBookmark(createBookmark(HIS_INITIAL_PRIORITY, stageInitialPriority));

    String stageScreenOutReason = Lookup.simpleDecodeSafe(CodesTables.CSCNOTRN, stage.getCdStageScroutReason());
    preFillData.addBookmark(createBookmark(HIS_SCR_OUT_REASON, stageScreenOutReason));
    preFillData.addBookmark(createBookmark(SUM_SCREEN_OUT_REAS, stageScreenOutReason));

    String reasonPriorityChgd = Lookup.simpleDecodeSafe(CodesTables.CRSNPRIO, stage.getCdStageRsnPriorityChgd());
    preFillData.addBookmark(createBookmark(SUM_RES_TIME_CHANGE, reasonPriorityChgd));

    preFillData.addBookmark(createBookmark(SUM_WORKER_TAKING_INTAKE, incomingDetail.getNmIncmgWorkerName()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL, incomingDetail.getNmIncmgWorkerName()));
    preFillData.addBookmark(createBookmark(SUM_LE_JURIS, incomingDetail.getNmIncmgJurisdiction()));
    preFillData.addBookmark(createBookmark(TITLE_CASE_NAME, stage.getNmStage()));
    String tmIncomingCall = FormattingHelper.formatTime(incomingDetail.getDtIncomingCall());
    preFillData.addBookmark(createBookmark(SUM_TIME_RPTED, tmIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_TIME, tmIncomingCall));
    if (stage.getCapsCase() != null && stage.getCapsCase().getIdCase() != 0) {
      preFillData.addBookmark(createBookmark(TITLE_CASE_NUMBER, stage.getCapsCase().getIdCase()));
    }
    preFillData.addBookmark(createBookmark(SUM_INTAKE_NUM, stage.getIdStage()));
    if (stage.getIdStage() != null) {
      preFillData.addBlobData(createBlobData(CALL_NARR_BLOB, INCOMING_NARRATIVE_VIEW, stage.getIdStage()));
    }
    return preFillData;
  }
}
