package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.DiligentSearchReport;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DILIGENTSEARCHREPORTSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DILIGENTSEARCHREPORTSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * Change History:
 * Date         User              Description
 * --------    ----------------  --------------------------------------------------
 * 01/02/2009   mxpatel          STGAP00010601 Added helper method to format the phone number on 
 *                                                    the report.
 * 10/30/2009   arege            SMS#38671 Modified method getDiligentSearchInformation to get correct name of the 
 *                               person who made the contact for diligent search.
 * 08/16/10     bgehlot          66380 MR072 Add new field Discussed/In Reference to
 */

public class DiligentSearchReportImpl extends BaseDocumentServiceImpl implements DiligentSearchReport {

  private ContactDAO contactDAO;

  private PersonDAO personDAO;

  private CapsCaseDAO capsCaseDAO;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO;

  private LegalActionDAO legalActionDAO;

  private DiligentSearchDAO diligentSearchDAO;

  private PersonAddressDAO personAddressDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private FccpChildDAO fccpChildDAO;
  
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO;

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setDiligentSearchDAO(DiligentSearchDAO diligentSearchDAO) {
    this.diligentSearchDAO = diligentSearchDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }

  public DILIGENTSEARCHREPORTSO retrieveDiligentSearchReport(DILIGENTSEARCHREPORTSI diligentSearchReportSI) {
    DILIGENTSEARCHREPORTSO diligentSearchReportso = new DILIGENTSEARCHREPORTSO();
    int idStage = diligentSearchReportSI.getUlIdStage();
    int idCase = diligentSearchReportSI.getUlIdCase();
    int idChild = diligentSearchReportSI.getUlIdPerson();
 

    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);

    if (capsCase == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    PreFillData preFillData = getPage1Detail(idCase, idChild, idStage);

    getPage2Headings(preFillData, capsCase, idChild, idStage);

    getCaseManagerDetails(preFillData, idStage);

    getDiligentSearchInformation(preFillData, idCase, idStage, idChild);

    diligentSearchReportso.setPreFillData(preFillData);

    return diligentSearchReportso;
  }

  private PreFillData getCaseManagerDetails(PreFillData preFillData, int idStage) {

    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CSTFROLS_PR);
    Person person = personDAO.findPersonByIdPerson(idPerson);

    preFillData.addBookmark(createBookmark(CASE_WORKER_NAME_LAST, person.getNmPersonLast()));
    preFillData.addBookmark(createBookmark(CASE_WORKER_NAME_FIRST, person.getNmPersonFirst()));

    return preFillData;

  }

  private PreFillData getPage1Detail(int idCase, int idChild, int idStageSUB) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark(FOSTER_CARE_FULL_NAME, getPersonFullName(idChild)));
    preFillData
               .addBookmark(createBookmark(
                                           DT_REPORT_DATE,
                                           FormattingHelper
                                                           .formatDate(DateHelper
                                                                                 .toJavaDate(DateHelper
                                                                                                       .getTodayCastorDate()))));
    // get the latest removal date
    List<CnsrvtrshpRemoval> cnsrvtrshipRemovals = cnsrvtrshpRemovalDAO
                                                                      .findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(
                                                                                                                      idCase,
                                                                                                                      idChild
                                                                                                                      );
    if (cnsrvtrshipRemovals != null && !cnsrvtrshipRemovals.isEmpty()) {
      CnsrvtrshpRemoval cnsrvtrshipRemoval = cnsrvtrshipRemovals.iterator().next();
      preFillData.addBookmark(createBookmark(DT_CHILD_REMOVAL_DATE,
                                             FormattingHelper.formatDate(cnsrvtrshipRemoval.getDtRemoval())));
    }

    // Get the latest hearing date
    Map legalActionMap = legalActionDAO.findLegalActionLatestByIdCaseByIdPersonByCdOutcome(idCase, idChild,
                                                                                           CodesTables.CLEGLOUT_DSR);

    if (legalActionMap != null) {
      preFillData.addBookmark(createBookmark(DT_CRT_ACT_DATE,
                                             FormattingHelper.formatDate((Date) legalActionMap.get("dtCrtActDate"))));
    }

    FccpChild fccpChild = fccpChildDAO.findLatestChildPlanByIdStageByCdEventType(idStageSUB);
    if (fccpChild != null) {
      preFillData.addBookmark(createBookmark(DT_DILGNT_COMPLETED,
                                             FormattingHelper.formatDate(fccpChild.getDtDilgntComp())));
    }

    return preFillData;
  }

  private PreFillData getPage2Headings(PreFillData preFillData, CapsCase capscase, int idChild, int idStage) {
    int idCase = 0;
    Person person = personDAO.findPersonByIdPerson(idChild);
    if (person != null) {
      preFillData.addBookmark(createBookmark(TITLE_CHILD_FULLNAME, getPersonFullName(person)));
      preFillData.addBookmark(createBookmark(TITLE_CHILD_DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));
    
    if(capscase!= null){
       idCase = capscase.getIdCase(); 
    }
      preFillData.addBookmark(createBookmark(DFCS_CASE_NUMBER, idCase));
    }

    if (capscase != null) {
      preFillData.addBookmark(createBookmark(REPORT_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                    capscase.getCdCaseCounty())));
    }

    return preFillData;
  }

  private PreFillData getDiligentSearchInformation(PreFillData preFillData, int idCase, int idStage, int idChild) {

    /*
     * Get the list of Contact id based on the case id. Each contact id has the same value as the event id. For each
     * contact id get the list of persons that were contacted
     */
    List<DiligentSearch> diligentSearchList = diligentSearchDAO
                                                               .findDiligentSearchInfoBasedOnCaseIdByIdPersonDtl(
                                                                                                                 idCase,
                                                                                                                 idChild
                                                                                                                 );
   
    if (diligentSearchList != null && !diligentSearchList.isEmpty()) {
      for (Iterator<DiligentSearch> it = diligentSearchList.iterator(); it.hasNext();) {
        FormDataGroup group = createFormDataGroup(TMPLAT_PERSON_OF_INTEREST, FCM03O00);

        DiligentSearch diligentSearch = it.next();
        if (diligentSearch.getIndIncDlgnt() != null && "Y".equals(diligentSearch.getIndIncDlgnt()))
        // Diligent Search Person Info
        {
          int idPersonDiligent = diligentSearch.getPersonByIdPersonDetail().getIdPerson();
          Person person = getPerson(idPersonDiligent);
          StagePersonLink stagePersonLink = personDAO
                                                     .findStagePersonLinkByIdPersonAndIdStage(idPersonDiligent, idStage);
          if (stagePersonLink != null){
          group.addBookmark(createBookmark(RELATIVE_TYPE, getRelationshipType(stagePersonLink.getCdStagePersType(),
                                                                            stagePersonLink.getCdStagePersRelInt())));
          } 
          if (person != null) {
            group.addBookmark(createBookmark(RELATIVE_NAME_FIRST, person.getNmPersonFirst()));
            group.addBookmark(createBookmark(RELATIVE_NAME_LAST, person.getNmPersonLast()));
          }
          if (stagePersonLink != null){
          String relative_of_child = getIndRelChd(stagePersonLink.getCdStagePersType(),
                                                  stagePersonLink.getCdStagePersRelInt());
          
          group.addBookmark(createBookmark(RELATIVE_OF_CHILD, relative_of_child));
          group.addBookmark(createBookmark(SIDE_FAMILY,
                                           Lookup.simpleDecodeSafe(CodesTables.CSIDEFAM,
                                                                   stagePersonLink.getCdPersonSideOfFamily())));

          // address of diligent Search person
          }
          PersonAddress personAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPersonDiligent);

          if (personAddress != null) {
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_ST_LN_1, personAddress.getAddrPersAddrStLn1()));
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_ST_LN_2, personAddress.getAddrPersAddrStLn2()));
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_CITY, personAddress.getAddrPersonAddrCity()));
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_STATE, personAddress.getCdPersonAddrState()));
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_ZIP, personAddress.getAddrPersonAddrZip()));
            group.addBookmark(createBookmark(ADDR_PERS_ADDR_COUNTY,
                                             Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                     personAddress.getCdPersonAddrCounty())));
          }

          group.addBookmark(createBookmark(RELATIVE_PHONE, FormattingHelper.formatPhone(person.getNbrPersonPhone())));//mxpatel added the FormattingHelper.formatPhone for defect # 10601 

          group.addBookmark(createBookmark(IND_SUCC_CONT, diligentSearch.getIndSuccCont()));
          group.addBookmark(createBookmark(TXT_WHY_CONT, diligentSearch.getTxtWhyCont()));
          group
               .addBookmark(createBookmark(CD_CURR_OUTCOME, Lookup.simpleDecodeSafe(CodesTables.CDSICONT,
                                                                                    diligentSearch.getCdCurrOutcome())));
          group.addBookmark(createBookmark(IND_VISIT_RSRC, diligentSearch.getIndVisitRsrc()));
          group.addBookmark(createBookmark(DT_SUBSY_DISCSD,
                                           FormattingHelper.formatDate(diligentSearch.getDtSubsyDiscsd())));
          group.addBookmark(createBookmark(TXT_COMMENTS, diligentSearch.getTxtComments()));
          group.addBookmark(createBookmark(CD_REF_TYPE, Lookup.simpleDecodeSafe(CodesTables.CDSIREFL,
                                                                                diligentSearch.getCdRefType())));
          group.addBookmark(createBookmark(OTHER_DESC, diligentSearch.getTxtOtherDesc()));
          group.addBookmark(createBookmark(TXT_RSRC, diligentSearch.getTxtRsrc()));
          group.addBookmark(createBookmark(IND_PLCMT_RSRC, diligentSearch.getIndPlcmtRsrc()));
          group.addBookmark(createBookmark(REFERRAL_FULL_NAME, diligentSearch.getTxtRefName()));

          // Get the contact info

          String cdContactPurpose = CodesTables.CCNTPURP_DIL;
          
          List<Contact> contacts = contactDAO.findRecentContactByIdCaseAndContactPurpose(idCase, idPersonDiligent,
                                                                                         cdContactPurpose);
          //MR-072 
          Contact contact = null;
          boolean discussedChildFound = false;
          //MR-072 From the contacts returned from above query get the idEvent and find if that contact has child selected as Discussed/
          //In Reference to.
          if(contacts != null && !contacts.isEmpty()){
            Iterator<Contact> itContact = contacts.iterator();
            while (itContact.hasNext()) {
              Contact contactWithChildDiscussed = itContact.next();
              int idEvent = contactWithChildDiscussed.getEvent().getIdEvent();
              List<Integer> discussedPersons = contactDiscussedCbxDAO.findDiscussedMembersByIdEventIdPerson(idEvent, idChild);
              //If that contact has child selected as Discussed/In Reference to then that contact is the one to display on the form.
              if(discussedPersons != null && !discussedPersons.isEmpty()){
                contact = contactWithChildDiscussed;
                discussedChildFound = true;
                break;
              }
            }
            //If the child is not selected as Discussed/In Reference To then first contact returned from the query need to display
            if(!discussedChildFound){
              contact = contacts.iterator().next();
            }
            //SMS# 38671  Per to MR-24 the name of who made contact is stored in NmContactedBy field and this person 
            // could be DFCS staff with a valid idPerson or someone outside the system without a idPerson. 
            group.addBookmark(createBookmark(CONTACT_STAFF_NAME, contact.getNmContactedBy()));
            group.addBookmark(createBookmark(DT_CONTACT_DATE,
                                             FormattingHelper.formatDate(contact.getDtContactOccurred())));
            group.addBookmark(createBookmark(CONTACT_METHOD, Lookup.simpleDecodeSafe(CodesTables.CCNTMETH,
                                                                                     contact.getCdContactMethod())));
          }
          
          preFillData.addFormDataGroup(group);
        }
      } // end for loop
    } // end if diligentSearchList
    // preFillData.addFormDataGroup(group);
    return preFillData;
  }

  /*
   * get the first, middle, last name of a person
   */
  private String getPersonFullName(int idPerson) {
    String fullName = null;
    Person person = getPerson(idPerson);
    if (person != null) {
      fullName = getPersonFullName(person);
    }
    return fullName;
  }

  private Person getPerson(int idPerson) {
    Person person = personDAO.findPersonByIdPerson(idPerson);
    return person;
  }

  private String getPersonFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      if (person.getNmPersonFirst() != null) {
        fullName.append(person.getNmPersonFirst() + " ");
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(person.getNmPersonMiddle() + " ");
      }

      fullName.append(person.getNmPersonLast());

      if (person.getCdPersonSuffix() != null) {
        fullName.append(" " + person.getCdPersonSuffix());
      }
    }
    return fullName.toString();
  }

  private String getRelationshipType(String cdStagePersType, String cdStagePersonRelInt) {
    String relationship = null;
    if (cdStagePersType.equals(CodesTables.CPRSNALL_PRN)) {
      relationship = Lookup.simpleDecodeSafe(CodesTables.CRELVICT, cdStagePersonRelInt);
    } else if (cdStagePersType.equals(CodesTables.CPRSNALL_COL)) {
      relationship = Lookup.simpleDecodeSafe(CodesTables.CSRCRPTR, cdStagePersonRelInt);
    }
    return relationship;
  }

  /*
   * identify if relative of child
   */
  private String getIndRelChd(String cdStagePersType, String cdStagePersonRelInt) {
    String relative_of_child = "No";

    if (isRelativeToVictim(cdStagePersType, cdStagePersonRelInt)) {
      relative_of_child = "Yes";
    }
    return relative_of_child;
  }

  private boolean isRelativeToVictim(String cdStagePersType, String cdStagePersonRelInt) {
    boolean success = false;

    // relative codes for Principal Type from code_type = 'CRELVICT'
    final HashMap<String, String> relativesPRNCodes = new HashMap<String, String>();
    relativesPRNCodes.put("AB", "Absent Parent");
    relativesPRNCodes.put("AU", "Aunt/Uncle");
    relativesPRNCodes.put("BF", "Biological Father");
    relativesPRNCodes.put("BM", "Biological Mother");
    relativesPRNCodes.put("CO", "Cousin");
    relativesPRNCodes.put("DA", "Daughter");
    relativesPRNCodes.put("FM", "Other Family Member");
    relativesPRNCodes.put("GC", "Grand Child");
    relativesPRNCodes.put("GP", "Grand Parent");
    relativesPRNCodes.put("LF", "Legal Father");
    relativesPRNCodes.put("NN", "Niece/Nephew");
    relativesPRNCodes.put("PA", "Parent");
    relativesPRNCodes.put("PF", "Putative Father to Child");
    relativesPRNCodes.put("SB", "Sibling");
    relativesPRNCodes.put("SO", "Son");
    relativesPRNCodes.put("SP", "Spouse");
    relativesPRNCodes.put("SR", "Step Child");
    relativesPRNCodes.put("SS", "Step Sibling");
    relativesPRNCodes.put("ST", "Step Parent");

    // relative codes for Collateral type from code_type = 'CSRCRPTR'
    final HashMap<String, String> relativesCOLCodes = new HashMap<String, String>();
    relativesCOLCodes.put("AB", "Absent Parent");
    relativesCOLCodes.put("AF", "Adoptive/Foster Parent");
    relativesCOLCodes.put("AU", "Aunt/Uncle");
    relativesCOLCodes.put("BF", "Biological Father");
    relativesCOLCodes.put("BM", "Biological Mother");
    relativesCOLCodes.put("CO", "First Cousin");
    relativesCOLCodes.put("DA", "Daughter");
    relativesCOLCodes.put("FC", "First Cousin Once Removed");
    relativesCOLCodes.put("FM", "Other Family Member");
    relativesCOLCodes.put("G2", "Great Grandparent");
    relativesCOLCodes.put("G3", "Great Great Grandparent");
    relativesCOLCodes.put("G4", "Great Great Great Grandparent");
    relativesCOLCodes.put("GC", "Grand Child");
    relativesCOLCodes.put("GN", "Great Niece");
    relativesCOLCodes.put("GP", "Grand Parent");
    relativesCOLCodes.put("GS", "Step-grandparent");
    relativesCOLCodes.put("GW", "Great Nephew");
    relativesCOLCodes.put("HS", "Half Sibling");
    relativesCOLCodes.put("LF", "Legal Father");
    relativesCOLCodes.put("N2", "Great Great niece");
    relativesCOLCodes.put("NN", "Niece/Nephew");
    relativesCOLCodes.put("NS", "Non Parent Spouse");
    relativesCOLCodes.put("PA", "Parent");
    relativesCOLCodes.put("PF", "Putative Father");
    relativesCOLCodes.put("SB", "Sibling");
    relativesCOLCodes.put("S0", "Son");
    relativesCOLCodes.put("SP", "Spouse");
    relativesCOLCodes.put("SC", "Step Child");
    relativesCOLCodes.put("SS", "Step Sibling");
    relativesCOLCodes.put("ST", "Step Parent");
    relativesCOLCodes.put("W2", "Great Great Nephew");

    if (cdStagePersType.equals(CodesTables.CPRSNALL_PRN)) {
      if (relativesPRNCodes.get(cdStagePersonRelInt) != null) {
        success = true;
      }
    } else if (cdStagePersType.equals(CodesTables.CPRSNALL_COL)) {
      if (relativesCOLCodes.get(cdStagePersonRelInt) != null) {
        success = true;
      }
    }
    return success;
  }

}
