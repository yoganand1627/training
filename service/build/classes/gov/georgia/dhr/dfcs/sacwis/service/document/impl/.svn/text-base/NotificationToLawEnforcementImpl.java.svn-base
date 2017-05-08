/**
 * Created on Nov 30, 2006 at 12:18:33 PM by Kevin L. Dunaway
 */
package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   03/27/2009  arege             STGAP00010844 Modified code so Child victim's name is not displayed multiple
 *                                 times on the Law Enforcement form.    
 *   09/08/2009  bgehlot           STGAP00015366: Removed the Alleged Maltreator.                    
 *
 *                                 
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.document.NotificationToLawEnforcement;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationToLawEnforcementImpl extends BaseDocumentServiceImpl implements NotificationToLawEnforcement {

  private static final String CD_STAGE_CLOSED_00 = "00";

  private static final String CD_STAGE_CLOSED_01 = "01";

  private static final String CD_STAGE_CLOSED_02 = "02";

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
                                                                              { COL_AGE, "nbrPersonAge", null },
                                                                              { COL_DOB_APPROX, "indPersonDobApprox",
                                                                               null },
                                                                              { COL_SEX, "cdPersonSex",
                                                                               CodesTables.CSEX },
                                                                              { COL_DOB, "dtPersonBirth", null },
                                                                              { COL_DOD, "dtPersonDeath", null },
                                                                              { COL_NAME_SUFFIX, "cdPersonSuffix",
                                                                               CodesTables.CSUFFIX2 },
                                                                              { COL_RSN, "cdPersonDeath",
                                                                               CodesTables.CRSNFDTH },
                                                                              { COL_ETHNCTY, "cdPersonEthnicGroup",
                                                                               CodesTables.CETHNIC },
                                                                              { COL_RELTNSP, "cdStagePersRelInt",
                                                                               CodesTables.CSRCRPTR },
                                                                              { COL_LANG, "cdPersonLanguage",
                                                                               CodesTables.CLANG },
                                                                              { COL_MARITAL, "cdPersonMaritalStatus",
                                                                               CodesTables.CMARSTAT },
                                                                              { COL_SSN, "nbrPersonIdNumber", null },
                                                                              { COL_NAME_FIRST, "nmPersonFirst", null },
                                                                              { COL_NAME_LAST, "nmPersonLast", null },
                                                                              { COL_NAME_MIDDLE, "nmPersonMiddle", null },
                                                                              { COL_NOTES, "txtStagePersNotes", null }

  };

  private DynamicPersonDAO dynamicPersonDAO;

  private IncmgDetermFactorsDAO incmgDetermFactorsDAO;

  private IncomingDetailDAO incomingDetailDAO;

  private PersonAddressDAO personAddressDAO;

  private IntakeAllegationDAO intakeAllegationDAO;

  private NameDAO nameDAO;

  private PersonPhoneDAO personPhoneDAO;

  private OfficeDAO officeDAO;

  private ResourcePhoneDAO resourcePhoneDAO;

  private AddressPersonLinkDAO addressPersonLinkDAO;
  
  private EventDAO eventDAO;

  private PostEvent postEvent;
  
  private StagePersonLinkDAO stagePersonLinkDAO;
  
  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setDynamicPersonDAO(DynamicPersonDAO dynamicPersonDAO) {
    this.dynamicPersonDAO = dynamicPersonDAO;
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

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  } 
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  } 
  
  public CINT42SO retrieveNotificationToLawEnforcement(CINT42SI cint42si) {
    CINT42SO cint42so = new CINT42SO();
    int idStage = cint42si.getUlIdStage();
    Object[] incomingDetailInfo = incomingDetailDAO.findIncomingDetailAndDtEventOccurred(idStage);
    if (incomingDetailInfo == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    Event event = eventDAO.findEventByStageAndType(idStage, CodesTables.CEVNTTYP_NOT);
    if (event == null) {
      CCMN01UI ccmn01ui = new CCMN01UI();
      ccmn01ui.setArchInputStruct(new ArchInputStruct());
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ROWCCMN01UIG00 rowccmn01uig00Temp = new ROWCCMN01UIG00();
      String eventDesc = "Notification";
      Integer idPerson = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idStage);
      if (idPerson == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      rowccmn01uig00Temp.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      rowccmn01uig00Temp.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      rowccmn01uig00Temp.setSzCdEventType(CodesTables.CEVNTTYP_NOT);
      rowccmn01uig00Temp.setSzTxtEventDescr(eventDesc);
      rowccmn01uig00Temp.setUlIdEvent(0);
      rowccmn01uig00Temp.setUlIdStage(idStage);
      rowccmn01uig00Temp.setUlIdPerson(idPerson);
      ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00Temp);
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      postEvent.postEvent(ccmn01ui);
    }

    String dtEventOccurred = FormattingHelper.formatDate(DateHelper.getTodayCastorDate());
    PreFillData preFillData = getIncomingDetail(incomingDetailInfo);
    if (event != null) {
      dtEventOccurred = FormattingHelper.formatDate(event.getDtEventOccurred());
    }
    preFillData.addBookmark(createBookmark(SUM_LE_NOTIFY_DATE, dtEventOccurred));
    // Note that, in the original service, cint62d and cint63d was always
    // called after cint65d was called, but it is
    // easier in Java
    // to call it here, and failure of either caused the entire service to
    // fail.
    Map<Integer, Set<PersonPhone>> personPhoneMap = findPersonPhoneInformation(idStage);

    Map<Integer, Set<AddressPersonLink>> addressPersonLinkMap = findAddressPersonLinkInformation(idStage);
    Map<Integer, Set<Name>> nameMap = findNameInformation(idStage);
    addPersonInformation(idStage, DynamicPersonDAO.VICTIM_TYPE, VICTIM_INFO_META_INFORMATION, preFillData,
                         TMPLAT_VICTIM, CFIN0101, personPhoneMap, addressPersonLinkMap, nameMap);
    addPersonInformation(idStage, DynamicPersonDAO.PERPETRATOR_TYPE, AP_INFO_META_INFORMATION, preFillData,
                         TMPLAT_ALLEG_PERP, CFIN0102, personPhoneMap, addressPersonLinkMap, nameMap);
    addPersonInformation(idStage, DynamicPersonDAO.OTHER_PRN_TYPE, PRINC_INFO_META_INFORMATION, preFillData,
                         TMPLAT_PRINC_OTHER, CFIN0103, personPhoneMap, addressPersonLinkMap, nameMap);
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
    // Retrieve allegations
    List<Map> allegationsList = intakeAllegationDAO.findIntakeAllegationsByIdStage(idStage);
    if (allegationsList != null && !allegationsList.isEmpty()) {
      for (Iterator<Map> iter = allegationsList.iterator(); iter.hasNext();) {
        Map map1 = iter.next();
        FormDataGroup group = createFormDataGroup(TMPLAT_ALLEG_NOTIFY, CFZCO00);
        String allegDecodesafe = Lookup.simpleDecodeSafe(CodesTables.CMALCODE, (String) map1.get("cdAllegedMalCode"));
        group.addBookmark(createBookmark(ALLEGATION, allegDecodesafe));
        preFillData.addFormDataGroup(group);
      }
    }

    // Retrieve address information
    Object[] personAddressObj = findPersonAddress(idStage);
    if (personAddressObj != null) {

      String addrLn1 = (String) personAddressObj[0];
      String addrLn2 = (String) personAddressObj[1];
      String addrCity = (String) personAddressObj[2];
      String addrState = (String) personAddressObj[3];
      String addrZip = (String) personAddressObj[4];

      preFillData.addBookmark(createBookmark(CONF_ADDR_LN_1, addrLn1));
      preFillData.addBookmark(createBookmark(CONF_ADDR_LN_2, addrLn2));
      preFillData.addBookmark(createBookmark(CONF_ADDR_CITY, addrCity));
      preFillData.addBookmark(createBookmark(CONF_ADDR_STATE, addrState));
      preFillData.addBookmark(createBookmark(CONF_ADDR_ZIP, addrZip));
    }

    // Retrieve office information
    Object[] officeObj = findOffice(idStage);
    if (officeObj != null) {

      // officeName is available if needed
      // String officeName = (String) officeObj[0];
      String officePhone = (String) officeObj[1];
      String officePhoneExt = (String) officeObj[2];

      preFillData.addBookmark(createBookmark(NOTIFY_PHONE, FormattingHelper.formatPhone(officePhone)));
      preFillData.addBookmark(createBookmark(NOTIFY_EXTENSION, officePhoneExt));
    }

    // Retrieve fax information
    List<Object[]> faxInformationList = resourcePhoneDAO.findFaxInformation(idStage);

    if (faxInformationList != null && !faxInformationList.isEmpty()) {
      Object[] faxInformation = faxInformationList.get(0);
      preFillData.addBookmark(createBookmark(FAX_ID, faxInformation[1]));
      preFillData.addBookmark(createBookmark(FAX_RSRC_NAME, faxInformation[2]));
      preFillData.addBookmark(createBookmark(FAX_CASE_ID, faxInformation[3]));
      preFillData.addBookmark(createBookmark(FAX_CASE_NAME, faxInformation[4]));
      preFillData.addBookmark(createBookmark(FAX_NUM, faxInformation[6]));
    }

    cint42so.setPreFillData(preFillData);
    // do something.
    return cint42so;
  }

  // method retrieves address information
  private Object[] findPersonAddress(int idStage) {
    Object[] personAddress = personAddressDAO.findPersonAddressByIdStage(idStage);

    return personAddress;
  }

  // method retrieves office information
  private Object[] findOffice(int idStage) {
    Object[] officeInfo = officeDAO.findOfficeByIdStageAndPrimaryPhone(idStage);
    return officeInfo;
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
    //STGAP00010844 Created a tempPersonInfo to store filtered personInfo.
    // See if personInfo contains Persons with multiple records i.e records with SSN and other person identifiers
    // if yes add this person only once.
      HashMap<Object, Map> tempPersonInfo = new HashMap<Object, Map>();
      for (Iterator<Map> it = personInfo.iterator(); it.hasNext();) {
        Map map = it.next();

        Object keyIdPerson = map.get("idPerson");

        if (tempPersonInfo.containsKey(keyIdPerson)) { // Per STGAP00010844 Added this if statement
          if (CodesTables.CNUMTYPE_SSN.equals(map.get("cdPersonIdType"))) {
            tempPersonInfo.put(keyIdPerson, map);
          } else {
            continue;
          }
        } else {
          tempPersonInfo.put(keyIdPerson, map);
        }
      }

      for(Map map : tempPersonInfo.values()){ //Per STGAP00010844 Added this for loop
        
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
    if (incomingDetailInfo[3] != null) {
      preFillData.addBookmark(createBookmark(NOTIFY_ACTION_TAKEN_BY_CPS, (String) incomingDetailInfo[3]));
    }
    IncomingDetail incomingDetail = (IncomingDetail) incomingDetailInfo[0];
    preFillData.addBookmark(createBookmark(CALL_NARR_WORKER_SAFETY, incomingDetail.getTxtIncmgWorkerSafety()));
    preFillData.addBookmark(createBookmark(CALL_NARR_SENSITIVE_ISSUE, incomingDetail.getTxtIncmgSensitive()));
    preFillData.addBookmark(createBookmark(CALL_NARR_SUSP_METH_LAB, incomingDetail.getTxtIncmgSuspMeth()));
    preFillData.addBookmark(createBookmark(SUM_SENSITIVE_ISSUE, incomingDetail.getIndIncmgSensitive()));
    preFillData.addBookmark(createBookmark(SUM_SUSP_METH_LAB, incomingDetail.getIndIncmgSuspMeth()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_SAFETY_ISSUES, incomingDetail.getIndIncmgWorkerSafety()));
    String dtIncomingCall = FormattingHelper.formatDate(incomingDetail.getDtIncomingCall());
    preFillData.addBookmark(createBookmark(SUM_DATE_RPTED, dtIncomingCall));
    preFillData.addBookmark(createBookmark(CONF_DATE_OF_REPORT, dtIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_DATE, dtIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_EXT, incomingDetail.getNbrIncmgWorkerExt()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_EXTENSION, incomingDetail.getNbrIncmgWorkerExt()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_PHONE,
                                           FormattingHelper.formatPhone(incomingDetail.getNbrIncmgWorkerPhone())));
    preFillData.addBookmark(createBookmark(HEADER_PHONE,
                                           FormattingHelper.formatPhone(incomingDetail.getNbrIncmgWorkerPhone())));
    preFillData.addBookmark(createBookmark(HEADER_EXTENSION, incomingDetail.getNbrIncmgWorkerExt()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_PHONE,
                                           FormattingHelper.formatPhone(incomingDetail.getNbrIncmgWorkerPhone())));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_CITY, incomingDetail.getAddrIncmgWorkerCity()));
    preFillData.addBookmark(createBookmark(SUM_WORKER_CITY, incomingDetail.getAddrIncmgWorkerCity()));
    preFillData.addBookmark(createBookmark(NOTIFY_FROM, incomingDetail.getAddrIncmgWorkerCity()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_BJN, incomingDetail.getEmployee().getCdEmpBjnEmp()));
    preFillData.addBookmark(createBookmark(SUM_PRIM_ALLEG,
                                           Lookup.simpleDecodeSafe(CodesTables.CMALCODE,
                                                                   incomingDetail.getCdIncmgAllegType())));
    preFillData.addBookmark(createBookmark(SUM_SPCL_HANDLING,
                                           Lookup.simpleDecodeSafe(CodesTables.CSPECHND,
                                                                   incomingDetail.getCdIncmgSpecHandling())));
    // Stage stage = incomingDetail.getStage();
    Stage stage = new Stage();
    int idStage = incomingDetail.getIdStage();
    if (idStage != 0) {
      stage = getPersistentObject(Stage.class, idStage);
    }
    String stageCurrPriority = Lookup.simpleDecodeSafe(CodesTables.CPRIORTY, stage.getCdStageCurrPriority());
    preFillData.addBookmark(createBookmark(HIS_CURR_PRIORITY, stageCurrPriority));
    preFillData.addBookmark(createBookmark(SUM_PRIORITY_DETERM, stageCurrPriority));
    String stageInitialPriority = Lookup.simpleDecodeSafe(CodesTables.CPRIORTY, stage.getCdStageInitialPriority());
    preFillData.addBookmark(createBookmark(HIS_INITIAL_PRIORITY, stageInitialPriority));
    String cdStageReasonClosed = stage.getCdStageReasonClosed();
    if (CD_STAGE_CLOSED_00.equals(cdStageReasonClosed) || CD_STAGE_CLOSED_01.equals(cdStageReasonClosed)
        || CD_STAGE_CLOSED_02.equals(cdStageReasonClosed)) {
      // noinspection AssignmentToNull
      cdStageReasonClosed = null;
    }
    String SCREEN_OUT_NO_MALTREATMENT_CODE = "SNM"; 
    String stageReasonClosed = "";
    if(SCREEN_OUT_NO_MALTREATMENT_CODE.equals(cdStageReasonClosed)){
      stageReasonClosed = cdStageReasonClosed;
    }else{
      stageReasonClosed = Lookup.simpleDecodeSafe(CodesTables.CDISP, cdStageReasonClosed);
    }
    preFillData.addBookmark(createBookmark(HIS_RSN_FOR_CLOSURE, stageReasonClosed));
    preFillData.addBookmark(createBookmark(SUM_RSN_FOR_CLOSR, stageReasonClosed));
    preFillData.addBookmark(createBookmark(SUM_WORKER_TAKING_INTAKE, incomingDetail.getNmIncmgWorkerName()));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL, incomingDetail.getNmIncmgWorkerName()));
    preFillData.addBookmark(createBookmark(SUM_LE_JURIS, incomingDetail.getNmIncmgJurisdiction()));
    preFillData.addBookmark(createBookmark(NOTIFY_TO, incomingDetail.getNmIncmgJurisdiction()));
    preFillData
               .addBookmark(createBookmark(
                                           NOTIFY_DATE,
                                           FormattingHelper
                                                           .formatDate(DateHelper
                                                                                 .toJavaDate(DateHelper
                                                                                                       .getTodayCastorDate()))));
    preFillData.addBookmark(createBookmark(TITLE_CASE_NAME, stage.getNmStage()));
    preFillData.addBookmark(createBookmark(CONF_CASE_NAME, stage.getNmStage()));
    String tmIncomingCall = FormattingHelper.formatTime(incomingDetail.getDtIncomingCall());
    preFillData.addBookmark(createBookmark(SUM_TIME_RPTED, tmIncomingCall));
    preFillData.addBookmark(createBookmark(CONF_TIME_OF_REPORT, tmIncomingCall));
    preFillData.addBookmark(createBookmark(HIS_RECORDED_CALL_TIME, tmIncomingCall));
    preFillData.addBookmark(createBookmark(TITLE_CASE_NUMBER, stage.getCapsCase().getIdCase()));
    preFillData.addBookmark(createBookmark(CONF_CASE_NUMBER, stage.getCapsCase().getIdCase()));
    preFillData.addBookmark(createBookmark(SUM_INTAKE_NUM, stage.getIdStage()));
    preFillData.addBlobData(createBlobData(CALL_NARR_BLOB, INCOMING_NARRATIVE_VIEW, stage.getIdStage()));
    return preFillData;

  }

}
