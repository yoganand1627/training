package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.SQL_NOT_FOUND;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePlacementDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPlcmtInfo_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
04/22/09     cwells            STGAP00009847: Removing references to AFCAR widgits.  Since those sections
                               Are being removed from the page.  
11/25/2009  bgehlot            41275 MR-057 Added new fields for APPLA
12/09/2010  schoi              SMS #81140: MR-074 Added code to check if child is in DFCS Custody 
                               at the time of Placement start date
12/12/2010  schoi              SMS #81140: MR-074 Removed code that was previously added on 12/09/2010;
                               new code is no longer needed per design change requested by the State team
09/17/2011  charden            STGAP00017058 - pulling placement log certification data
                               
*/

public class RetrievePlacementDetailImpl extends BaseServiceImpl implements RetrievePlacementDetail {
  private static final String PLCMT_ISSUES_NARR = "PLCMT_ISSUES_NARR";

  private static final String PLCMT_DISCHARGE_NARR = "PLCMT_DISCHG_NARR";

  private static final String PRIMARY_CHILD = CodesTables.CROLEALL_PC;

  private static final String AUTHORIZED = CodesTables.CPLOCELG_ALOC;

  private static final String STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  private static final int ISSUES = 0;

  private static final int DISCHARGE = 1;

  //private static final String FOST_ADOPT = CodesTables.CPLMNTYP_020;
  private static final String FOST_ADOPT = "020";

  /* SIR 21130 - define */
  private static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  private static final String CLOSURE_EVENT_TYPE = CodesTables.CEVNTTYP_CCL;

  /* Misc constants */
  private static final String FOUND = ArchitectureConstants.Y;

  private static final String NOT_FOUND = ArchitectureConstants.N;

  private CapsResourceDAO capsResourceDAO = null;
  private DynamicEventDAO dynamicEventDAO = null;
  private EventDAO eventDAO = null;
  private PersonLocDAO personLocDAO = null;
  private PlacementDAO placementDAO = null;
  private ResourceHistoryDAO resourceHistoryDAO = null;
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDAO personDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public CSUB25SO retrievePlacementDetail(CSUB25SI csub25si) throws ServiceException {

    CSUB25SO csub25so = new CSUB25SO();
    CSUB25SOG00 csub25sog00 = new CSUB25SOG00();
    CSUB25SOG01 csub25sog01 = new CSUB25SOG01();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    BIndBLOBExistsInDatabase_ARRAY blob_array = new BIndBLOBExistsInDatabase_ARRAY();
    String find = FOUND;
    int idStageSI = csub25si.getUlIdStage();
    int idPersonSI = csub25si.getUlIdPerson();
    int idEventSI = csub25si.getUlIdEvent();

    // ccmn87d
    List<Object[]> dynamicEventList = dynamicEventDAO.findEvents(false, 0, idStageSI, 0, 0, 0,
                                                                 new String[] { CLOSURE_EVENT_TYPE }, null, null, null,
                                                                 null, null);
    if (dynamicEventList == null || dynamicEventList.isEmpty()) {
      csub25so.setSzCdEventStatus(EVENT_STATUS_NEW);
      // csub25so.setUlIdEvent(0);
      // throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      Object[] firstRow = dynamicEventList.get(0);
      // event status is the first element
      csub25so.setSzCdEventStatus((String) firstRow[0]);
      // event id is the seventh element
      csub25so.setUlIdEvent(firstRow[6] != null ? (Integer) firstRow[6] : 0);
    }
    // cint40d
    Stage stage = stageDAO.findStageByIdStage(csub25si.getUlIdStage());
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    csub25so.setUlIdCase(stage.getCapsCase() != null ? stage.getCapsCase().getIdCase() : 0);

    // String cdEventStatusSO_00 = csub25so.getROWCCMN01UIG00().getSzCdEventStatus();

    if (idEventSI > 0) {
      // ccmn45d
      Event event = eventDAO.findEventByIdEvent(idEventSI);
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // csub25so.setROWCCMN01UIG00(setEventToROWCCMN01UIG00(event));
      rowccmn01uig00 = setEventToROWCCMN01UIG00(event);
      // if (!(STATUS_NEW.equals(csub25so.getROWCCMN01UIG00().getSzCdEventStatus()))) {
      if (!(STATUS_NEW.equals(rowccmn01uig00.getSzCdEventStatus()))) {
        // cses37d
        CSUB25SO tempCsub25so = findPlacement(idEventSI);
        csub25sog00 = tempCsub25so.getCSUB25SOG00();
        csub25sog01 = tempCsub25so.getCSUB25SOG01();
        // csub25so.setCSUB25SOG00(tempCsub25so.getCSUB25SOG00());
        // csub25so.setCSUB25SOG01(tempCsub25so.getCSUB25SOG01());
        csub25so.setDtDtPlcmtPermEff(tempCsub25so.getDtDtPlcmtPermEff());
        // csys06d
        Date lastUpdate = commonDAO.findDtLastUpdate(PLCMT_ISSUES_NARR, idEventSI);
        if (lastUpdate == null) {
          blob_array.addBIndBLOBExistsInDatabase(ISSUES, ArchitectureConstants.FALSE);
        } else {
          blob_array.addBIndBLOBExistsInDatabase(ISSUES, ArchitectureConstants.TRUE);
        }
        // csys06d
        Date lastUpdate1 = commonDAO.findDtLastUpdate(PLCMT_DISCHARGE_NARR, idEventSI);
        if (lastUpdate1 == null) {
          blob_array.addBIndBLOBExistsInDatabase(DISCHARGE, ArchitectureConstants.FALSE);
        } else {
          blob_array.addBIndBLOBExistsInDatabase(DISCHARGE, ArchitectureConstants.TRUE);
        }
      }
    }

    // String cdPlcmtType = csub25so.getCSUB25SOG00().getSzCdPlcmtType();
    String cdPlcmtType = csub25sog00.getSzCdPlcmtType() != null ? csub25sog00.getSzCdPlcmtType() : "";
    int idRsrcFacil = csub25sog00.getUlIdRsrcFacil();
    int idRsrcAgency = csub25sog00.getUlIdRsrcAgency();
    int idContactedBy = csub25sog00.getUlIdContactedBy();
    // int idRsrcFacil = csub25so.getCSUB25SOG00().getUlIdRsrcFacil();
    // int idRsrcAgency = csub25so.getCSUB25SOG00().getUlIdRsrcAgency();

    if (idContactedBy != 0) {
      String contactedBy ;
      // cres04d
      contactedBy = personDAO.findNmFullByIdPerson(idContactedBy);
      
      if (contactedBy == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      else
      {
        csub25sog00.setSzCdPlcmtContactedBy(contactedBy);
      }
    }
    if (FOUND.equals(find) && !(FOST_ADOPT.equals(cdPlcmtType)) && ((idRsrcFacil != 0) || (idRsrcAgency != 0))) {
      CapsResource capsResource;
      // cres04d
      if (idRsrcAgency != 0) {
        capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcAgency);
      } else {
        capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcFacil);
      }
      if (capsResource == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      //STGAP00005989: If the placement type is DFCS Foster Home or CPA Foster Home
      //and if the facility type is DFCS FA Home or NON-DFCS FA home and the resource
      //status is pending temp approval or temp approval then set the indicator to Y
      if (idRsrcFacil!=0 && (CodesTables.CPLMNTYP_DFH.equals(cdPlcmtType)
                      || CodesTables.CPLMNTYP_CFH.equals(cdPlcmtType)) && DateHelper.isNull(csub25sog00.getDtDtPlcmtEnd())) {
                    if ((CodesTables.CFACTYP4_70.equals(capsResource.getCdRsrcFacilType()) || CodesTables.CFACTYP4_71
                                                                                                                   .equals(capsResource.getCdRsrcFacilType()))
                        && (CodesTables.CFAHMSTA_ATA.equals(capsResource.getCdRsrcFaHomeStatus()) || CodesTables.CFAHMSTA_PTA
                                                                                                                      .equals(capsResource.getCdRsrcFaHomeStatus()))) {
                      csub25so.setCIndRsrcStatus(ArchitectureConstants.Y);
                    }
                  }
    } else if (FOUND.equals(find) && FOST_ADOPT.equals(cdPlcmtType) && (idRsrcFacil != 0 || idRsrcAgency != 0)) {
      ResourceHistory resourceHistory;
      //Date dtPlcmtStart = DateHelper.toJavaDate(csub25so.getCSUB25SOG00().getDtDtPlcmtStart());
      Date dtPlcmtStart = csub25sog00.getDtDtPlcmtStart();
      // cres54d
      if (idRsrcAgency != 0) {
        resourceHistory = resourceHistoryDAO.findResourceHistoryByIdResourceDtDtPlcmtStart(idRsrcAgency, dtPlcmtStart);
      } else {
        resourceHistory = resourceHistoryDAO.findResourceHistoryByIdResourceDtDtPlcmtStart(idRsrcFacil, dtPlcmtStart);
      }
      if (resourceHistory == null) {
        find = NOT_FOUND;
      }
      csub25so.setCCdRsrcFaHomeType1(resourceHistory.getCdRshsFaHomeType1());
      csub25so.setCCdRsrcFaHomeType2(resourceHistory.getCdRshsFaHomeType2());
      csub25so.setCCdRsrcFaHomeType3(resourceHistory.getCdRshsFaHomeType3());
      csub25so.setCCdRsrcFaHomeType4(resourceHistory.getCdRshsFaHomeType4());
      csub25so.setCCdRsrcFaHomeType5(resourceHistory.getCdRshsFaHomeType5());
      csub25so.setCCdRsrcFaHomeType6(resourceHistory.getCdRshsFaHomeType6());
      csub25so.setCCdRsrcFaHomeType7(resourceHistory.getCdRshsFaHomeType7());
      csub25so.setSzCdRsrcCategory(resourceHistory.getCdRshsCategory());
      csub25so.setCIndRsrcEmergPlace(resourceHistory.getIndRshsEmergPlace());
    }

    // int idStageSO_00 = csub25so.getROWCCMN01UIG00().getUlIdStage();rowccmn01uig00
    int idStageSO_00 = rowccmn01uig00 != null ? rowccmn01uig00.getUlIdStage() : 0;
    // if (FOUND.equals(find) && STATUS_NEW.equals(csub25so.getROWCCMN01UIG00().getSzCdEventStatus()) ||
    // !StringHelper.isValid(csub25so.getROWCCMN01UIG00().getSzCdEventStatus())
    if (FOUND.equals(find) && STATUS_NEW.equals(rowccmn01uig00.getSzCdEventStatus())
        || !StringHelper.isValid(rowccmn01uig00.getSzCdEventStatus())
        || (idStageSO_00 != 0 && idStageSO_00 != idStageSI)) {
      // cinv51
      //Integer idWkldPerson = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStageSI, PRIMARY_CHILD);
      Integer idWkldPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStageSI, PRIMARY_CHILD);
      if (idWkldPerson == null || idWkldPerson == 0) {
        //-- how should we handle no PC role in stage?
        //throw new ServiceException(Messages.SQL_NOT_FOUND);
        throw new ServiceException() {
          @Override
          public int getErrorCode() {
            return Integer.MAX_VALUE;
          }
          
          @Override
          public String getErrorMessage() {
            return "No Primary Child found for this stage.";
          }
        };
      }

      // csub25so.getCSUB25SOG00().setUlIdPlcmtChild(idWkldPerson != null ? idWkldPerson : 0);
      csub25sog00.setUlIdPlcmtChild(idWkldPerson);
      // csec33d
      PersonLoc personLoc = personLocDAO.findPersonLocByIdPersonCurrentDate(csub25sog00.getUlIdPlcmtChild(),
                                                                            AUTHORIZED,
                                                                            DateHelper.toJavaDate(csub25so.getDtWCDDtSystemDate()));

      /*
       * PersonLoc personLoc = personLocDAO .findPersonLocByIdPersonCurrentDate( csub25so.getCSUB25SOG00()
       * .getUlIdPlcmtChild(), AUTHORIZED, DateHelper .toJavaDate(csub25so .getDtWCDDtSystemDate()));
       */
      if (personLoc != null) {
        csub25so.setSzCdPlocChild(personLoc.getCdPlocChild());
      }

      if (idPersonSI > 0) {
        // ccmn29d
        List<Map> stageMapList = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStageSI);
        if (stageMapList == null || stageMapList.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        csub25so.setBSysIndGeneric(ArchitectureConstants.FALSE);
        for (Iterator<Map> it = stageMapList.iterator(); it.hasNext()
                                                         && csub25so.getBSysIndGeneric()
                                                                    .equals(ArchitectureConstants.FALSE);) {
          Map map = it.next();
          if ((Integer) map.get("idPerson") == idPersonSI) {
            csub25so.setBSysIndGeneric(ArchitectureConstants.TRUE);
          }
        }
      }
    }

    if (ArchitectureConstants.FALSE.equals(csub25so.getBSysIndGeneric()) && (idPersonSI > 0)) {
      // ccmn29d
      List<Map> stageMapList2 = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStageSI);
      if (stageMapList2 == null || stageMapList2.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      csub25so.setBSysIndGeneric(ArchitectureConstants.FALSE);
      for (Iterator<Map> it = stageMapList2.iterator(); it.hasNext()
                                                        && csub25so.getBSysIndGeneric()
                                                                   .equals(ArchitectureConstants.FALSE);) {
        Map map = it.next();
        if ((Integer) map.get("idPerson") == idPersonSI) {
          csub25so.setBSysIndGeneric(ArchitectureConstants.TRUE);
        }
      }
    }
    csub25so.setCSUB25SOG00(csub25sog00);
    csub25so.setCSUB25SOG01(csub25sog01);
    csub25so.setROWCCMN01UIG00(rowccmn01uig00);
    csub25so.setBIndBLOBExistsInDatabase_ARRAY(blob_array);
    return csub25so;

  }

  private ROWCCMN01UIG00 setEventToROWCCMN01UIG00(Event event) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(event.getIdEvent());
    rowccmn01uig00.setUlIdStage(event.getStage().getIdStage());
    rowccmn01uig00.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    return rowccmn01uig00;
  }

  // cses37d
  private CSUB25SO findPlacement(int idEventSI) throws ServiceException {
    CSUB25SO csub25so = new CSUB25SO();
    CSUB25SOG00 csub25sog00 = new CSUB25SOG00();
    CSUB25SOG01 csub25sog01 = new CSUB25SOG01();
    // cses37d
    Placement placement = placementDAO.findPlacementByIdPlcmtEvent(idEventSI);
    if (placement == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    //STGAP00009260 - if placement start date is null in the database retrieve the dateEventOccured from the event table
    //in the database to display to page. When user saves the page, start date will be populated in placement table
    if (placement.getDtPlcmtStart() == null){
      Event event = eventDAO.findEventByIdEvent(placement.getIdPlcmtEvent());
      if (event == null){
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      placement.setDtPlcmtStart(event.getDtEventOccurred());
    }
    csub25sog00.setTsLastUpdate(placement.getDtLastUpdate());
    if (placement.getPersonByIdPlcmtAdult() != null) {
      csub25sog00.setUlIdPlcmtAdult(placement.getPersonByIdPlcmtAdult().getIdPerson());
    }
    
    csub25sog00.setUlIdPlcmtChild(placement.getPersonByIdPlcmtChild().getIdPerson());
    
    if (placement.getContract() != null) {
      csub25sog00.setUlIdContract(placement.getContract().getIdContract());
    }
    if (placement.getCapsResourceByIdRsrcAgency() != null) {
      csub25sog00.setUlIdRsrcAgency(placement.getCapsResourceByIdRsrcAgency().getIdResource());
    }
    if (placement.getCapsResourceByIdRsrcFacil() != null) {
      csub25sog00.setUlIdRsrcFacil(placement.getCapsResourceByIdRsrcFacil().getIdResource());
    }
    
    csub25sog00.setSzAddrPlcmtCity(placement.getAddrPlcmtCity());
    csub25sog00.setSzAddrPlcmtCnty(placement.getAddrPlcmtCnty());
    csub25sog00.setSzAddrPlcmtLn1(placement.getAddrPlcmtLn1());
    csub25sog00.setSzAddrPlcmtLn2(placement.getAddrPlcmtLn2());
    csub25sog00.setSzAddrPlcmtSt(placement.getAddrPlcmtSt());
    csub25sog00.setSzAddrPlcmtZip(placement.getAddrPlcmtZip());

    SzCdPlcmtInfo_ARRAY plcmtInfo_ARRAY = new SzCdPlcmtInfo_ARRAY();
    
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(0, placement.getCdPlcmtInfo1());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(1, placement.getCdPlcmtInfo2());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(2, placement.getCdPlcmtInfo3());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(3, placement.getCdPlcmtInfo4());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(4, placement.getCdPlcmtInfo5());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(5, placement.getCdPlcmtInfo6());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(6, placement.getCdPlcmtInfo7());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(7, placement.getCdPlcmtInfo8());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(8, null);
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(9, null);
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(10, null);
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(11, null);
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(12, placement.getCdPlcmtInfo13());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(13, placement.getCdPlcmtInfo14());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(14, placement.getCdPlcmtInfo15());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(15, placement.getCdPlcmtInfo16());
    plcmtInfo_ARRAY.addSzCdPlcmtInfo(16, placement.getCdPlcmtInfo17());
    csub25sog01.setSzCdPlcmtInfo_ARRAY(plcmtInfo_ARRAY);

    //csub25sog00.setSzCdPlcmtLivArr(placement.getCdPlcmtLivArr());
    csub25sog00.setSzCdPlcmtRemovalRsn(placement.getCdPlcmtRemovalRsn());
    csub25sog00.setSzCdPlcmtActPlanned(placement.getCdPlcmtActPlanned());
    csub25sog00.setSzCdPlcmtType(placement.getCdPlcmtType());
    csub25sog00.setSzCdPlcmtService(placement.getCdPlcmtService());
    csub25sog00.setDtDtPlcmtCaregvrDiscuss(DateHelper.toCastorDate(placement.getDtPlcmtCaregvrDiscuss()));
    csub25sog00.setDtDtPlcmtChildDiscuss(DateHelper.toCastorDate(placement.getDtPlcmtChildDiscuss()));
    csub25sog00.setDtDtPlcmtChildPlan(DateHelper.toCastorDate(placement.getDtPlcmtChildPlan()));
    csub25sog00.setDtDtPlcmtEducLog(DateHelper.toCastorDate(placement.getDtPlcmtEducLog()));
    //csub25sog00.setDtDtPlcmtEnd(DateHelper.toCastorDate(placement.getDtPlcmtEnd()));
    csub25sog00.setDtDtPlcmtEnd(placement.getDtPlcmtEnd());
    csub25sog00.setDtDtPlcmtMeddevHistory(DateHelper.toCastorDate(placement.getDtPlcmtMeddevHistory()));
    csub25sog00.setDtDtPlcmtParentsNotif(DateHelper.toCastorDate(placement.getDtPlcmtParentsNotif()));
    csub25sog00.setDtDtPlcmtPreplaceVisit(DateHelper.toCastorDate(placement.getDtPlcmtPreplaceVisit()));
    csub25sog00.setDtDtPlcmtSchoolRecords(DateHelper.toCastorDate(placement.getDtPlcmtSchoolRecords()));
    // Begin STGAP00017058
    csub25sog00.setDtLastViewPlcmtLog(DateHelper.toCastorDate(placement.getDtLastPlcmtLogView()));
    csub25sog00.setDtCaseMngrCert(DateHelper.toCastorDate(placement.getDtCaseMngrCert()));
    csub25sog00.setDtSupCert(DateHelper.toCastorDate(placement.getDtSupCert()));
    csub25sog00.setIndCaseMngrCert(placement.getIndCaseMngrCert());
    csub25sog00.setIndSupCert(placement.getIndSupCert());
    csub25sog00.setUlIdCaseMngrCert(placement.getIdCaseMngrCert() != null ? placement.getIdCaseMngrCert().getIdPerson() : 0);
    csub25sog00.setUlIdSupCert(placement.getIdSupCert() != null ? placement.getIdSupCert().getIdPerson() : 0);
    csub25sog00.setNmCaseMngrCertFullName(csub25sog00.getUlIdCaseMngrCert() != 0 ? placement.getIdCaseMngrCert().getNmPersonFull() : "");
    csub25sog00.setNmSupCertFullName(csub25sog00.getUlIdSupCert() != 0 ? placement.getIdSupCert().getNmPersonFull() : "");
    csub25sog00.setUlIdCaseMngrRsrc(placement.getIdCaseMngrRsrc() != null ? placement.getIdCaseMngrRsrc().getIdResource() : 0);
    csub25sog00.setUlIdSupRsrc(placement.getIdSupRsrc() != null ? placement.getIdSupRsrc().getIdResource() : 0);
    csub25sog00.setNmCaseMngrRsrc(csub25sog00.getUlIdCaseMngrRsrc() != 0 ? placement.getIdCaseMngrRsrc().getNmResource() : "");
    csub25sog00.setNmSupRsrc(csub25sog00.getUlIdSupRsrc() != 0 ? placement.getIdSupRsrc().getNmResource() : "");
    // End STGAP00017058
    // java.text.DateFormat df = DateHelper.TIMESTAMP_FORMAT;
    csub25sog00.setDtDtPlcmtStart(placement.getDtPlcmtStart());
    csub25so.setDtDtPlcmtPermEff(DateHelper.toCastorDate(placement.getDtPlcmtPermEff()));
    csub25sog00.setCIndPlcmtContCntct(placement.getIndPlcmtContCntct());
    csub25sog00.setCIndPlcmtEducLog(placement.getIndPlcmtEducLog());
    csub25sog00.setCIndPlcmetEmerg(placement.getIndPlcmtEmerg());
    csub25sog00.setCIndPlcmtNoneApply(placement.getIndPlcmtNotApplic());
    csub25sog00.setCIndPlcmtSchoolDoc(placement.getIndPlcmtSchoolDoc());
    csub25sog00.setCIndPlcmtWriteHistory(placement.getIndPlcmtWriteHistory());
    csub25sog00.setSzNbrPlcmtPhoneExt(placement.getNbrPlcmtPhoneExt());

    csub25sog00.setSzNbrPlcmtTelephone(placement.getNbrPlcmtTelephone());
    csub25sog00.setSzNmPlcmtAgency(placement.getNmPlcmtAgency());
    csub25sog00.setSzNmPlcmtContact(placement.getNmPlcmtContact());
    csub25sog00.setSzNmPlcmtFacil(placement.getNmPlcmtFacil());
    csub25sog00.setSzNmPlcmtPersonFull(placement.getNmPlcmtPersonFull());
    csub25sog00.setSzTxtPlcmtAddrComment(placement.getTxtPlcmtAddrComment());
    csub25sog00.setSzTxtPlcmtDiscussion(placement.getTxtPlcmtDiscussion());
    csub25sog00.setSzTxtPlcmtDocuments(placement.getTxtPlcmtDocuments());
    csub25sog00.setSzTxtPlcmtRemovalRsn(placement.getTxtPlcmtRemovalRsn());
//New Fields R2
    //csub25sog00.setSzCdPlcmtContactedBy(placement.getTxtPlcmtRemovalRsn());
    //csub25sog00.setUlIdContactedBy(placement.getTxtPlcmtRemovalRsn());
    
    csub25sog00.setUlIdContactedBy(placement.getPersonByIdContactWrkr().getIdPerson());
    csub25sog00.setSzCdPlcmtContMethod(placement.getCdContactMethod());
    csub25sog00.setSzCdPlcmtTempType(placement.getCdTempType());
    //STGAP00007457: need to populate the temporary type field with the 
    //IndPlcmtEmerg in the placement table.Hence commented out the code and 
    //added the next line.
    /*if (placement.getCdTempType()!= null){
      csub25sog00.setCIndPlcmtTempType("Y");
    }*/
    csub25sog00.setCIndPlcmtTempType(placement.getIndPlcmtEmerg());
    csub25sog00.setSzTxtPlcmtTempCmmnts(placement.getTxtTempCmnts());
    csub25sog00.setCIndWaiverReqd(placement.getIndWaiverReqd());
    csub25sog00.setSzCdWaivertype(placement.getCdWaiverType());
    
    if (placement.getPolicyWaiver() != null) {
      csub25sog00.setUlIdWaiver(placement.getPolicyWaiver().getIdWvrEvent());
    }
    //csub25sog00.setDtDtLastDischarged(placement.getdtgetTxtPlcmtRemovalRsn());
    csub25sog00.setSzCdMatch(placement.getTxtMatch());
    csub25sog00.setDtDtPlcmtPermDue(DateHelper.toCastorDate(placement.getDtPlcmtPermEff()));
    csub25sog00.setSzCdBrdngCnty(placement.getCdBoardingCnty());
    csub25sog00.setCIndTrialHomeVisit(placement.getIndTrialHome());
    csub25sog00.setDtDtCrtBegin(DateHelper.toCastorDate(placement.getDtTrialCoStart()));
    csub25sog00.setDtDtCrtEnd(DateHelper.toCastorDate(placement.getDtTrialCoEnd()));
    csub25sog00.setCIndPlcmtSafe(placement.getIndPlcmtSafe());
    csub25sog00.setCIndPlcmtRestr(placement.getIndPlcmtRestr());
    csub25sog00.setCIndPlcmtFamLike(placement.getIndPlcmtFam());
    csub25sog00.setCIndPlcmtAppr(placement.getIndPlcmtAppr());
    csub25sog00.setCIndPlcmtProx(placement.getIndPlcmtProx());
    csub25sog00.setCIndPlcmtSchDist(placement.getIndPlcmtSchDist());
    csub25sog00.setCIndPlcmtCasePlan(placement.getIndPlcmtCasePlan());
    csub25sog00.setSzTxtPlcmtChkList(placement.getTxtPlcmtChecklist());
    csub25sog00.setCIndPlcmtTrauma(placement.getIndPlcmtTrauma());
    csub25sog00.setSzTxtPlcmtTrauma(placement.getTxtPlcmtTrauma());
    csub25sog00.setCIndPlcmtSibling(placement.getIndPlcmtSibling());
    
    //-- must null check Integer to avoid NPE on unboxing
    csub25sog00.setNbrSibinCare(getIntSafe(placement.getNbrPlcmtSibCare()));
    csub25sog00.setNbrSibPlaced(getIntSafe(placement.getNbrPlcmtSibChild()));
    
    csub25sog00.setSzCdSibRsn(placement.getCdPlcmtSibling());
    csub25sog00.setSzCdPlcmtCCFA(placement.getCdPlcmtCcfa());
    csub25sog00.setSzTxtPlcmtSibling(placement.getTxtPlcmtSibling());
    csub25sog00.setCIndPlcmtCCFA(placement.getIndPlcmtCcfa());
    csub25sog00.setSzTxtPlcmtCCFA(placement.getTxtPlcmtCcfa());
    //to be added
    //csub25sog00.setSzTxtPlcmtCCFA(ContextHelper.getTxtPlcmtRemovalRsn());
    csub25sog00.setCIndPlcmtSpvsn(placement.getIndSpvsn());
    csub25sog00.setSzTxtPlcmtSpvsn(placement.getTxtSpvsn());
    csub25sog00.setDtDtPsychInfo(DateHelper.toCastorDate(placement.getDtPsyInfo()));
    csub25sog00.setSzTxtPsychInfoCont(placement.getTxtPsyInfoContact());
    csub25sog00.setDtDtPsychCPInfo(DateHelper.toCastorDate(placement.getDtPsyCp()));
    csub25sog00.setSzTxtPsychCPInfoCont(placement.getTxtPsyCpContact());
    csub25sog00.setDtDtMedInfo(DateHelper.toCastorDate(placement.getDtPlcmtMeddevHistory()));
    csub25sog00.setSzTxtMedInfoCont(placement.getTxtMedInfoContact());
    csub25sog00.setDtDtMedCPInfo(DateHelper.toCastorDate(placement.getDtMedCp()));
    csub25sog00.setSzTxtMedCPInfoCont(placement.getTxtMedCpContact());
    csub25sog00.setDtDtEduInfo(DateHelper.toCastorDate(placement.getDtPlcmtEducLog()));
    csub25sog00.setSzTxtEduInfoCont(placement.getTxtEduInfoContact());
    csub25sog00.setCIndEduInfoNA(placement.getIndPlcmtEducLog());
    csub25sog00.setDtDtEduCPInfo(DateHelper.toCastorDate(placement.getDtPlcmtSchoolRecords()));
    csub25sog00.setSzTxtEduCPInfoCont(placement.getTxtEduCpContact());
    csub25sog00.setCIndEduCPInfoNA(placement.getIndPlcmtSchoolDoc());
   //Exists csub25sog00.setSzTxtCareGvDoc(placement.gettxtgetTxtPlcmtRemovalRsn());
    csub25sog00.setCIndPlcmtChPlacedFr(placement.getCdAdoType());
    csub25sog00.setCIndPlcmtChPlacedBy(placement.getCdPlcmtAdptBy());
    csub25sog00.setSzCdChildTransitionCmnts(placement.getTxtAdoCmnts());
    csub25sog00.setSzCdAdoPlaceInfo1(placement.getCdPlcmtInfo9());
    csub25sog00.setSzCdAdoPlaceInfo2(placement.getCdPlcmtInfo10());
    csub25sog00.setSzCdAdoPlaceInfo3(placement.getCdPlcmtInfo11());
    csub25sog00.setSzCdAdoPlaceInfo4(placement.getCdPlcmtInfo12());
    
    
    csub25sog00.setSzTxtAddtnlDoc(placement.getTxtDocCmnts());
    //End new fields R2
    
    //MR-057 Added new fields for APPLA
    csub25sog00.setCIndLTFCPlacement(placement.getIndLTFCPlacement());
    csub25sog00.setDtDtAgreementSigned(DateHelper.toCastorDate(placement.getDtLTFCAgreementSigned()));
    csub25sog00.setCIndConnectedAdult(placement.getIndChildConnectAdult());
    csub25sog00.setUlIdPersonConnected(placement.getConnectedAdult() != null ? placement.getConnectedAdult().getIdPerson() : 0);
    
    csub25so.setCSUB25SOG00(csub25sog00);
    csub25so.setCSUB25SOG01(csub25sog01);

    return csub25so;
  }
  
  private int getIntSafe(Integer i) {
    if(i == null) {
      return 0;
    }
    return i;
  }

}