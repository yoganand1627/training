package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;

public class SaveResourceHistoryImpl extends BaseServiceImpl implements SaveResourceHistory {
  private PostEvent postEvent = null;
  private ComplexResourceHistoryDAO complexResourceHistoryDAO = null;
  private FacilityLocDAO facilityLocDAO = null;
  private ResourceHistoryDAO resourceHistoryDAO = null;
  private ComplexFacilityLocDAO complexFacilityLocDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoCommonFunction todoCommonFunction = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setComplexResourceHistoryDAO(ComplexResourceHistoryDAO complexResourceHistoryDAO) {
    this.complexResourceHistoryDAO = complexResourceHistoryDAO;
  }

  public void setFacilityLocDAO(FacilityLocDAO facilityLocDAO) {
    this.facilityLocDAO = facilityLocDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setComplexFacilityLocDAO(ComplexFacilityLocDAO complexFacilityLocDAO) {
    this.complexFacilityLocDAO = complexFacilityLocDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public CFAD14SO audResourceHistory(CFAD14SI cfad14si) throws ServiceException {
    CFAD14SO cfad14so = new CFAD14SO();

    // Post the event
    ROWCCMN01UIG00 rowccmn01uig00_fad = postEvent(cfad14si);

    // update the resource History table.
    CFAD14SIG00 cfad14sig00 = cfad14si.getCFAD14SIG00();
    // Extract some variables from cfad14sig00 here because they are used later.
    char[] cdRshsFaHomeType = cfad14sig00.getCCdRshsFaHomeType1().toCharArray();
    String cdRshsFaHomeType1 = String.valueOf(cdRshsFaHomeType[0]);
    String cdRshsFaHomeType2 = String.valueOf(cdRshsFaHomeType[1]);
    String cdRshsFaHomeType3 = String.valueOf(cdRshsFaHomeType[2]);
    String cdRshsFaHomeType4 = String.valueOf(cdRshsFaHomeType[3]);
    String cdRshsFaHomeType5 = String.valueOf(cdRshsFaHomeType[4]);
    String cdRshsFaHomeType6 = String.valueOf(cdRshsFaHomeType[5]);
    String cdRshsFaHomeType7 = String.valueOf(cdRshsFaHomeType[6]);
    Date dtRshsEffective = DateHelper.toJavaDate(cfad14sig00.getDtDtRshsEffective());
    Date dtRshsEnd;
    // To do correct date validation inside caud77d dtRshsEnd needs to be set to max date if it is null here.  The
    //   table (RESOURCE_HISTORY) defaults this field to max date but the DAM needs it to be max date before that time.
    if (DateHelper.isNull(cfad14sig00.getDtDtRshsEnd())) {
      dtRshsEnd = DateHelper.MAX_JAVA_DATE;
    } else {
      // Date is not null so use it as normal input to DAO
      dtRshsEnd = DateHelper.toJavaDate(cfad14sig00.getDtDtRshsEnd());
    }
    int idResource = cfad14sig00.getUlIdResource();
    int idStage = cfad14sig00.getUlIdStage();
    String nmRshsResource = cfad14sig00.getSzNmRshsResource();
    // caud77d
    audResourceHistory(cfad14sig00, cfad14si.getArchInputStruct().getCReqFuncCd(), idResource, dtRshsEffective,
                       dtRshsEnd, cdRshsFaHomeType1, cdRshsFaHomeType2, cdRshsFaHomeType3, cdRshsFaHomeType4,
                       cdRshsFaHomeType5, cdRshsFaHomeType6, cdRshsFaHomeType7, idStage, nmRshsResource);

    // Rebuild Facility LOC table
    if (ArchitectureConstants.Y.equals(cfad14si.getCSysIndLocChange())) {
      rebuildFacilityLocTable(idResource, idStage, cdRshsFaHomeType1, cdRshsFaHomeType2, cdRshsFaHomeType3,
                              cdRshsFaHomeType4,
                              cdRshsFaHomeType5, cdRshsFaHomeType6, cdRshsFaHomeType7);
    }

    // Create todo's if bSysIndFosterTypeChange was set.
    if (ArchitectureConstants.Y.equals(cfad14si.getCSysIndFosterTypeChange())) {
      createTodos(rowccmn01uig00_fad, idResource, dtRshsEnd, dtRshsEffective, nmRshsResource);
    }
    return cfad14so;
  }

  private void createTodos(ROWCCMN01UIG00 rowccmn01uig00_fad, int idResource, Date dtRshsEnd, Date dtRshsEffective,
                           String nmRshsResource) throws ServiceException {
    // clsc51d
    List<Map> links = stagePersonLinkDAO.findStagePersonLinkByIdResource(idResource, dtRshsEnd, dtRshsEffective,
                                                                         CodesTables.CPLCMTAC_A);
    if (links != null && links.size() > 0) {
      // Send ToDo Alert to each worker
      for (Iterator<Map> rows = links.iterator(); rows.hasNext();) {
        Map row = rows.next();
        String nmPersonFull = (String) row.get("nmPersonFull");
        int linkIdStage = (Integer) row.get("idStage");
        int idPerson = (Integer) row.get("idPerson");
        CSUB40UI csub40ui = new CSUB40UI();
        CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
        csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
        csub40uig00.setUlSysIdTodoCfPersAssgn(idPerson);
        // Also set the Worker to the Output of CLSC51D.  The Primary/Historical
        // Worker is who the ToDo is assigned to.
        csub40uig00.setUlSysIdTodoCfPersWkr(idPerson);
        // Set IdTodoCfPersCreator - Logged in user
        csub40uig00.setUlSysIdTodoCfPersCrea(rowccmn01uig00_fad.getUlIdPerson());
        // Set IdTodoCfEvent to NULL
        csub40uig00.setUlSysIdTodoCfEvent(0);
        csub40uig00.setUlSysIdTodoCfStage(linkIdStage);
        String sysTxtTodoCfDesc = nmPersonFull + "'s foster home has had foster types added or deleted.";
        // Set TxtTodoCfLongDesc to "Foster Home Types were added or deleted for
        // the " CFAD14SI.G00 NmResource and "home from " CFAD14SI.G00 DtRshsEffective
        // "to " CFAD14SI.G00 DtRshsEnd ".".  CLSC51DO[i] NmPersonFull " was placed
        // in this home during this time.  This may affect the child's billing level
        // of care and/or placement. Contact the child's eligibility worker if appropriate."
        csub40uig00.setSzSysTxtTodoCfDesc(sysTxtTodoCfDesc);
        String sysTxtTodoCfLongDesc = "Foster Home Types were added or deleted for the ";
        sysTxtTodoCfLongDesc += nmRshsResource;
        sysTxtTodoCfLongDesc += " home from ";
        sysTxtTodoCfLongDesc += dtRshsEffective;
        sysTxtTodoCfLongDesc += " to ";
        sysTxtTodoCfLongDesc += dtRshsEnd;
        sysTxtTodoCfLongDesc += ".  ";
        sysTxtTodoCfLongDesc += nmPersonFull;
        sysTxtTodoCfLongDesc += " was placed in this home during this time.  This may ";
        sysTxtTodoCfLongDesc += "affect the child's billing service level and/or placement.  ";
        sysTxtTodoCfLongDesc += "Contact the child's eligibility worker if appropriate.";
        csub40uig00.setSzSysTxtTodoCfLongDesc(sysTxtTodoCfLongDesc);
        csub40ui.setCSUB40UIG00(csub40uig00);
        // CSUB40U
        todoCommonFunction.audTodo(csub40ui);
      }
    }
  }

  private ROWCCMN01UIG00 postEvent(CFAD14SI cfad14si) throws ServiceException {
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 rowccmn01uig00_fad = cfad14si.getROWCCMN01UIG00();
    ROWCCMN01UIG00 rowccmn01uig00_cmn = new ROWCCMN01UIG00();
    rowccmn01uig00_cmn.setSzCdTask(rowccmn01uig00_fad.getSzCdTask());
    rowccmn01uig00_cmn.setSzCdEventStatus(rowccmn01uig00_fad.getSzCdEventStatus());
    rowccmn01uig00_cmn.setSzCdEventType(rowccmn01uig00_fad.getSzCdEventType());
    // Get System Date and Time
    rowccmn01uig00_cmn.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uig00_cmn.setUlIdEvent(rowccmn01uig00_fad.getUlIdEvent());
    rowccmn01uig00_cmn.setUlIdStage(rowccmn01uig00_fad.getUlIdStage());
    rowccmn01uig00_cmn.setUlIdPerson(rowccmn01uig00_fad.getUlIdPerson());
    rowccmn01uig00_cmn.setSzTxtEventDescr(rowccmn01uig00_fad.getSzTxtEventDescr());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00_cmn);
    // Common Function: ccmn06u  Check Stage/Event common function.
    // This will handle it's own exceptions if they occur.
    postEvent.postEvent(ccmn01ui);
    return rowccmn01uig00_fad;
  }

  private void rebuildFacilityLocTable(int idResource, int idStage, String cdRshsFaHomeType1, String cdRshsFaHomeType2,
                                       String cdRshsFaHomeType3, String cdRshsFaHomeType4, String cdRshsFaHomeType5,
                                       String cdRshsFaHomeType6, String cdRshsFaHomeType7) throws ServiceException {
    // Because of the difficulty associated in properly maintaining effective dating on the LOC table when Resource
    //   History record is changed, the entire LOC history will be deleted and then rebuilt by the three DAMs being
    //   called here.
    // Dam CAUD80D first deletes the existing FLOC. Then retrieves the history rows by calling CLSS53D. Loops thru the
    //   list to add the FLOC record (if the Home status is not Inquiry or applicant or Recruit), by calling CAUD80D again.
    // caud80d -- Ignores SQL_NOT_FOUND
    facilityLocDAO.deleteFacilityLoc(idResource);
    // Rebuild FLOC Call CLSS53D to  retrieve Home History rows.
    String cdPrevLocStatus1 = null;
    String cdPrevLocStatus2 = null;
    String cdPrevLocStatus3 = null;
    String cdPrevLocStatus4 = null;
    String cdPrevLocStatus5 = null;
    String cdPrevLocStatus6 = null;
    // clss53d
    List<ResourceHistory> histories = resourceHistoryDAO.findResourceHistoryListByIdStage(idStage);
    if (histories != null) {
      Iterator it = histories.iterator();
      ResourceHistory prevResourceHistory = null;
      while (it.hasNext()) {
        ResourceHistory resourceHistory = (ResourceHistory) it.next();
        // Perform LOC determination processing & insert a Facility LOC record if necessary.
        // If home status is pending approval, approved active, approved inactive or pending
        // closure FLOC process is done using CAUD80D.
        String cdRshsFaHomeStatus = resourceHistory.getCdRshsFaHomeStatus();
        if (CodesTables.CFAHMSTA_060.equals(cdRshsFaHomeStatus) ||
            CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
            CodesTables.CFAHMSTA_050.equals(cdRshsFaHomeStatus) ||
            CodesTables.CFAHMSTA_080.equals(cdRshsFaHomeStatus)) {
          String cdCurrLocStatus1; // always set below
          String cdCurrLocStatus2; // always set below
          String cdCurrLocStatus3 = null;
          String cdCurrLocStatus4 = null;
          String cdCurrLocStatus5 = null;
          String cdCurrLocStatus6 = null;
          if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
              CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus1)) {
            cdCurrLocStatus1 = CodesTables.CFLOCSTA_A;
          } else {
            cdCurrLocStatus1 = CodesTables.CFLOCSTA_H;
          }
          if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
              CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus2)) {
            cdCurrLocStatus2 = CodesTables.CFLOCSTA_A;
          } else {
            cdCurrLocStatus2 = CodesTables.CFLOCSTA_H;
          }
          String bGroupHome = ArchitectureConstants.N;
          // Use a set of the home types to do comparisons below
          Set<String> cdRshsFaHomeTypes = new HashSet<String>();
          cdRshsFaHomeTypes.add(cdRshsFaHomeType1);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType2);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType3);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType4);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType5);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType6);
          cdRshsFaHomeTypes.add(cdRshsFaHomeType7);
          // If the home type is group, set an indicator
          if (cdRshsFaHomeTypes.contains(CodesTables.CFAHMTYP_U)) {
            bGroupHome = ArchitectureConstants.Y;
          }
          // If any of the seven types is H,P or R for the row and CdPrevLocStatus3, 4 or 5
          // is FLOC_ACTIVE then the CdCurrLocstatus will be set to FLOC_ACTIVE.
          if (cdRshsFaHomeTypes.contains(CodesTables.CFAHMTYP_H) ||
              cdRshsFaHomeTypes.contains(CodesTables.CFAHMTYP_P) ||
              cdRshsFaHomeTypes.contains(CodesTables.CFAHMTYP_R)) {
            if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
                CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus3)) {
              cdCurrLocStatus3 = CodesTables.CFLOCSTA_A;
            } else {
              cdCurrLocStatus3 = CodesTables.CFLOCSTA_H;
            }
            if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
                CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus4)) {
              cdCurrLocStatus4 = CodesTables.CFLOCSTA_A;
            } else {
              cdCurrLocStatus4 = CodesTables.CFLOCSTA_H;
            }
            if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
                CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus5)) {
              cdCurrLocStatus5 = CodesTables.CFLOCSTA_A;
            } else {
              cdCurrLocStatus5 = CodesTables.CFLOCSTA_H;
            }
            // If the home is designated as group, do not put the FLOC into the db,
            // or put it to active if it is already on hold

            if (ArchitectureConstants.N.equals(bGroupHome)) {
              if (CodesTables.CFAHMSTA_040.equals(cdRshsFaHomeStatus) ||
                  CodesTables.CFLOCSTA_A.equals(cdPrevLocStatus6)) {
                cdCurrLocStatus6 = CodesTables.CFLOCSTA_A;
              } else {
                cdCurrLocStatus6 = CodesTables.CFLOCSTA_H;
              }
            }
          }
          int nbrFlocLevelsOfCare;
          if (!(cdPrevLocStatus1 == null ? cdCurrLocStatus1 == null : cdPrevLocStatus1.equals(cdCurrLocStatus1)) ||
              !(cdPrevLocStatus2 == null ? cdCurrLocStatus2 == null : cdPrevLocStatus2.equals(cdCurrLocStatus2)) ||
              !(cdPrevLocStatus3 == null ? cdCurrLocStatus3 == null : cdPrevLocStatus3.equals(cdCurrLocStatus3)) ||
              !(cdPrevLocStatus4 == null ? cdCurrLocStatus4 == null : cdPrevLocStatus4.equals(cdCurrLocStatus4)) ||
              !(cdPrevLocStatus5 == null ? cdCurrLocStatus5 == null : cdPrevLocStatus5.equals(cdCurrLocStatus5)) ||
              !(cdPrevLocStatus6 == null ? cdCurrLocStatus6 == null : cdPrevLocStatus6.equals(cdCurrLocStatus6))) {

            // Set Floc Level of Care to 6 if CdCurrLocStatus6 not equals NULL. if this is a group home, there will
            //   only be 5 levels of care.
            if (ArchitectureConstants.Y.equals(bGroupHome)) {
              nbrFlocLevelsOfCare = 5;
            } else if (cdCurrLocStatus6 != null) {
              nbrFlocLevelsOfCare = 6;
            } else {
              nbrFlocLevelsOfCare = 2;
            }
            // Set ComplexFacilityLocDAO Floc Effective date to effective date of the resource row.
            // caud80d
            if (0 == complexFacilityLocDAO.insertFacilityLoc(resourceHistory.getDtRshsEffective(),
                                                             DateHelper.MAX_JAVA_DATE, idResource,
                                                             DateHelper.MAX_JAVA_DATE, nbrFlocLevelsOfCare,
                                                             cdCurrLocStatus1, cdCurrLocStatus2, cdCurrLocStatus3,
                                                             cdCurrLocStatus4, cdCurrLocStatus5, cdCurrLocStatus6,
                                                             null, null, null, null, null, null, null, null, null)) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            cdPrevLocStatus1 = cdCurrLocStatus1;
            cdPrevLocStatus2 = cdCurrLocStatus2;
            cdPrevLocStatus3 = cdCurrLocStatus3;
            cdPrevLocStatus4 = cdCurrLocStatus4;
            cdPrevLocStatus5 = cdCurrLocStatus5;
            cdPrevLocStatus6 = cdCurrLocStatus6;
          }
        }
        // In addition to the home being closed, the service will update the last  LOC History row.  The end date of
        //   the last row will be updated to the effective date of Resource History row. This will occur when the Home
        //   Status is Inquiry, Recruit, Applicant, or Closed and the Home Status of the last Resource History record
        //   is NOT Inquiry, Recruit, Applicant, or Closed. The current Resource History record may not be the first
        //   Resource History record in the loop.
        if (prevResourceHistory != null) {
          String prevCdRshsFaHomeStatus = prevResourceHistory.getCdRshsFaHomeStatus();
          if ((CodesTables.CFAHMSTA_070.equals(cdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_010.equals(cdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_020.equals(cdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_030.equals(cdRshsFaHomeStatus))
              && // This is here to prevent formatting engines from mangling this.
              (CodesTables.CFAHMSTA_060.equals(prevCdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_040.equals(prevCdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_050.equals(prevCdRshsFaHomeStatus) ||
               CodesTables.CFAHMSTA_080.equals(prevCdRshsFaHomeStatus))) {
            // If the status is closed, CAUDB4D will be called which end dated the latest floc row
            //   without inserting any rows.
            // caudb4d
            facilityLocDAO.updateFacilityLoc(resourceHistory.getDtRshsEffective(), idResource);
          }
        }
        prevResourceHistory = resourceHistory;
      }
    }
  }

  private void audResourceHistory(CFAD14SIG00 cfad14sig00, String reqFuncCd, int idResource, Date dtRshsEffective,
                                  Date dtRshsEnd, String cdRshsFaHomeType1, String cdRshsFaHomeType2,
                                  String cdRshsFaHomeType3, String cdRshsFaHomeType4, String cdRshsFaHomeType5,
                                  String cdRshsFaHomeType6, String cdRshsFaHomeType7, int idStage,
                                  String nmRshsResource) throws ServiceException {
    String cdRshsCategory = cfad14sig00.getSzCdRshsCategory();
    String cdRshsFaHomeStatus = cfad14sig00.getSzCdRshsFaHomeStatus();
    int nbrRshsFacilCapacity = cfad14sig00.getUNbrRshsFacilCapacity();
    int nbrRshsMaAgeMin = cfad14sig00.getUNbrRshsMaAgeMin();
    int nbrRshsMaAgeMax = cfad14sig00.getUNbrRshsMaAgeMax();
    int nbrRshsFMAgeMin = cfad14sig00.getUNbrRshsFMAgeMin();
    int nbrRshsFMAgeMax = cfad14sig00.getUNbrRshsFMAgeMax();
    String cdRshsClosureRsn = cfad14sig00.getSzCdRshsClosureRsn();
    String cdRshsRecmndReopen = cfad14sig00.getSzCdRshsRecmndReopen();
    String cdRshsInvolClosure = cfad14sig00.getSzCdRshsInvolClosure();
    String addrRshsAttn = cfad14sig00.getSzAddrRshsAttn();
    String addrRshsCity = cfad14sig00.getSzAddrRshsCity();
    String addrRshsStLn1 = cfad14sig00.getSzAddrRshsStLn1();
    String addrRshsStLn2 = cfad14sig00.getSzAddrRshsStLn2();
    String addrRshsZip = cfad14sig00.getLAddrRshsZip();
    String cdRshsCampusType = cfad14sig00.getSzCdRshsCampusType();
    String cdRshsCertBy = cfad14sig00.getSzCdRshsCertBy();
    String cdRshsCnty = cfad14sig00.getSzCdRshsCnty();
    String cdRshsEthnicity = cfad14sig00.getSzCdRshsEthnicity();
    String cdRshsFacilType = cfad14sig00.getSzCdRshsFacilType();
    String cdRshsHub = cfad14sig00.getSzCdRshsHub();
    String cdRshsLanguage = cfad14sig00.getSzCdRshsLanguage();
    String cdRshsMaintainer = cfad14sig00.getSzCdRshsMaintainer();
    String cdRshsMaritalStatus = cfad14sig00.getSzCdRshsMaritalStatus();
    String cdRshsOperBy = cfad14sig00.getSzCdRshsOperBy();
    String cdRshsOwnership = cfad14sig00.getSzCdRshsOwnership();
    String cdRshsPayment = cfad14sig00.getSzCdRshsPayment();
    String cdRshsRegion = cfad14sig00.getSzCdRshsRegion();
    String cdRshsReligion = cfad14sig00.getSzCdRshsReligion();
    String cdRshsRespite = cfad14sig00.getSzCdRshsRespite();
    String cdRshsSchDist = cfad14sig00.getSzCdRshsSchDist();
    String cdRshsSetting = cfad14sig00.getSzCdRshsSetting();
    String cdRshsSourceInquiry = cfad14sig00.getSzCdRshsSourceInquiry();
    String cdRshsState = cfad14sig00.getSzCdRshsState();
    String cdRshsStatus = cfad14sig00.getSzCdRshsStatus();
    String cdRshsType = cfad14sig00.getSzCdRshsType();
    Date dtRshsCert = DateHelper.toJavaDate(cfad14sig00.getDtDtRshsCert());
    Date dtRshsClose = DateHelper.toJavaDate(cfad14sig00.getDtDtRshsClose());
    Date dtRshsMarriage = DateHelper.toJavaDate(cfad14sig00.getDtDtRshsMarriage());
    int idResourceHistory = cfad14sig00.getUlIdResourceHistory();
    int idEvent = cfad14sig00.getUlIdEvent();
    String indRshsCareProv = cfad14sig00.getCIndRshsCareProv();
    String indRshsEmergPlace = cfad14sig00.getCIndRshsEmergPlace();
    String indRshsInactive = cfad14sig00.getCIndRshsInactive();
    String indRshsIndivStudy = cfad14sig00.getCIndCurrHomeStudyExists();
    String indRshsNonDFCSHome = cfad14sig00.getCIndRshsNonDFCSHome();
    String cdCertifyEntity = cfad14sig00.getSzTxtNdfcsCertEntity();
    String indRshsTransport = cfad14sig00.getCIndRshsTransport();
    int nbrRshsAnnualIncome = (int) cfad14sig00.getDNbrRshsAnnualIncome();
    int nbrRshsCampusNbr = cfad14sig00.getLNbrRshsCampusNbr();
    int nbrRshsFacilAcclaim = cfad14sig00.getLNbrRshsFacilAcclaim();
    int nbrRshsIntChildren = cfad14sig00.getUNbrRshsIntChildren();
    int nbrRshsIntFeAgeMax = cfad14sig00.getUNbrRshsIntFeAgeMax();
    int nbrRshsIntFeAgeMin = cfad14sig00.getUNbrRshsIntFeAgeMin();
    int nbrRshsIntMaAgeMax = cfad14sig00.getUNbrRshsIntMaAgeMax();
    int nbrRshsIntMaAgeMin = cfad14sig00.getUNbrRshsIntMaAgeMin();
    int nbrRshsOpenSlots = cfad14sig00.getSNbrRshsOpenSlots();
    String nbrRshsPhn = cfad14sig00.getSzNbrRshsPhn();
    String nbrRshsPhoneExtension = cfad14sig00.getLNbrRshsPhoneExtension();
    String nbrRshsVid = cfad14sig00.getSzNbrRshsVid();
    String nmRshsContact = cfad14sig00.getSzNmRshsContact();
    String nmRshsLastUpdate = cfad14sig00.getSzNmRshsLastUpdate();
    String txtRshsAddrCmnts = cfad14sig00.getSzTxtRshsAddrCmnts();
    String txtRshsComments = cfad14sig00.getSzTxtRshsComments();
    String indRshsWriteHist = cfad14sig00.getCIndRshsWriteHist();
    Date dtLastUpdate = cfad14sig00.getTsLastUpdate();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      // caud77d
      int nbrRowsInserted =
              complexResourceHistoryDAO.insertIfNoOverlap(idResourceHistory, idResource, dtLastUpdate, dtRshsEffective,
                                                          dtRshsClose, dtRshsCert, dtRshsMarriage, dtRshsEnd,
                                                          addrRshsStLn1, addrRshsStLn2, addrRshsCity, cdRshsState,
                                                          addrRshsZip, addrRshsAttn, cdRshsCnty, cdRshsInvolClosure,
                                                          cdRshsClosureRsn, cdRshsType, cdRshsHub, cdRshsCampusType,
                                                          cdRshsSourceInquiry, cdRshsMaintainer, cdRshsSchDist,
                                                          cdRshsOwnership, cdRshsStatus, cdRshsFacilType, cdRshsCertBy,
                                                          cdRshsOperBy, cdRshsSetting, cdRshsPayment, cdRshsCategory,
                                                          cdRshsEthnicity, cdRshsLanguage, cdRshsMaritalStatus,
                                                          cdRshsRecmndReopen, cdRshsRegion, cdRshsReligion,
                                                          cdRshsRespite, cdRshsFaHomeStatus, cdRshsFaHomeType1,
                                                          cdRshsFaHomeType2, cdRshsFaHomeType3, cdRshsFaHomeType4,
                                                          cdRshsFaHomeType5, cdRshsFaHomeType6, cdRshsFaHomeType7,
                                                          idStage, idEvent, indRshsCareProv, indRshsInactive,
                                                          indRshsTransport, indRshsIndivStudy, indRshsNonDFCSHome,
                                                          cdCertifyEntity, indRshsEmergPlace, nmRshsResource,
                                                          nmRshsContact, nmRshsLastUpdate, nbrRshsVid, nbrRshsPhn,
                                                          nbrRshsFacilCapacity, nbrRshsFacilAcclaim,
                                                          nbrRshsPhoneExtension, nbrRshsCampusNbr, nbrRshsAnnualIncome,
                                                          nbrRshsFMAgeMax, nbrRshsFMAgeMin, nbrRshsMaAgeMax,
                                                          nbrRshsMaAgeMin, nbrRshsIntChildren, nbrRshsIntFeAgeMax,
                                                          nbrRshsIntFeAgeMin, nbrRshsIntMaAgeMax, nbrRshsIntMaAgeMin,
                                                          txtRshsAddrCmnts, txtRshsComments, nbrRshsOpenSlots,
                                                          indRshsWriteHist);
      if (nbrRowsInserted == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
      // caud77d
      int nbrRowsUpadated =
              complexResourceHistoryDAO.updateIfNoOverlap(idResourceHistory, idResource, dtLastUpdate, dtRshsEffective,
                                                          dtRshsClose, dtRshsCert, dtRshsMarriage, dtRshsEnd,
                                                          addrRshsStLn1, addrRshsStLn2, addrRshsCity, cdRshsState,
                                                          addrRshsZip, addrRshsAttn, cdRshsCnty, cdRshsInvolClosure,
                                                          cdRshsClosureRsn, cdRshsType, cdRshsHub, cdRshsCampusType,
                                                          cdRshsSourceInquiry, cdRshsMaintainer, cdRshsSchDist,
                                                          cdRshsOwnership, cdRshsStatus, cdRshsFacilType, cdRshsCertBy,
                                                          cdRshsOperBy, cdRshsSetting, cdRshsPayment, cdRshsCategory,
                                                          cdRshsEthnicity, cdRshsLanguage, cdRshsMaritalStatus,
                                                          cdRshsRecmndReopen, cdRshsRegion, cdRshsReligion,
                                                          cdRshsRespite, cdRshsFaHomeStatus, cdRshsFaHomeType1,
                                                          cdRshsFaHomeType2, cdRshsFaHomeType3, cdRshsFaHomeType4,
                                                          cdRshsFaHomeType5, cdRshsFaHomeType6, cdRshsFaHomeType7,
                                                          idStage, idEvent, indRshsCareProv, indRshsInactive,
                                                          indRshsTransport, indRshsIndivStudy, indRshsNonDFCSHome,
                                                          cdCertifyEntity, indRshsEmergPlace, nmRshsResource,
                                                          nmRshsContact, nmRshsLastUpdate, nbrRshsVid, nbrRshsPhn,
                                                          nbrRshsFacilCapacity, nbrRshsFacilAcclaim,
                                                          nbrRshsPhoneExtension, nbrRshsCampusNbr, nbrRshsAnnualIncome,
                                                          nbrRshsFMAgeMax, nbrRshsFMAgeMin, nbrRshsMaAgeMax,
                                                          nbrRshsMaAgeMin, nbrRshsIntChildren, nbrRshsIntFeAgeMax,
                                                          nbrRshsIntFeAgeMin, nbrRshsIntMaAgeMax, nbrRshsIntMaAgeMin,
                                                          txtRshsAddrCmnts, txtRshsComments, nbrRshsOpenSlots,
                                                          indRshsWriteHist);
      if (nbrRowsUpadated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
      ResourceHistory resourceHistory = new ResourceHistory();
      resourceHistory.setIdResourceHistory(idResourceHistory);
      resourceHistory.setDtLastUpdate(dtLastUpdate);
      // caud77d
      resourceHistoryDAO.deleteResourceHistory(resourceHistory);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }
}
