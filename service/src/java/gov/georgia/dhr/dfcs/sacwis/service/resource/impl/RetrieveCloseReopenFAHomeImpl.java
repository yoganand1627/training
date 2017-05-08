package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/**Change History:
Date          User              Description
----------    ----------------  --------------------------------------------------
03/22/2011    hjbaptiste        SMS#97850: MR-75 Foster Home Batch To Dos. Fixed an NPE (Null Pointer Exception)
                                event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0.
                                whenever the Person object was returned null. Removed the (.getIdPerson()) in the 
                                test for null. Did the same for event.getStage().getIdStage() and stage.getSituation().getIdSituation()
                                and stage.getCapsCase().getIdCase()

*/

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveCloseReopenFAHome;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

public class RetrieveCloseReopenFAHomeImpl extends BaseServiceImpl implements RetrieveCloseReopenFAHome {
  private static final String CLOSING_SUMMARY_DOC = "FAD_CLOS_SUM_NARR";

  private ResourceHistoryDAO resourceHistoryDAO = null;
  private CapsResourceDAO capsResourceDAO = null;
  private EventDAO eventDAO = null;
  private PlacementDAO placementDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private StageDAO stageDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public CFAD30SO retrieveNeccessaryInformation(CFAD30SI cfad30si) throws ServiceException {
    CFAD30SO cfad30so = new CFAD30SO();
    int idStage = cfad30si.getUlIdStage();
    int idEvent = cfad30si.getUlIdEvent();
    int narrative_idEvent;
    org.exolab.castor.types.Date todayCastorDate = DateHelper.getTodayCastorDate();
    cfad30so.setDtWCDDtSystemDate(todayCastorDate);
    TsLastUpdate_ARRAY tsLastUpdate_array = new TsLastUpdate_ARRAY();
    // IdEvent is not null when the user has navigated from the event list or the approval window.  In these situations,
    //   the window will be in browse mode and historical information should be retrieved
    if (idEvent > 0) {
      // cses02d
      ResourceHistory resourceHistory = resourceHistoryDAO.findResourceHistoryByIdEvent(idEvent);
      if (resourceHistory == null) {
        throw new ServiceException(Messages.MSG_FAD_HISTORY_DELETED);
      }
      cfad30so.setSzCdRsrcFaHomeStatus(resourceHistory.getCdRshsFaHomeStatus());
      cfad30so.setSzCdRsrcClosureRsn(resourceHistory.getCdRshsClosureRsn());
      cfad30so.setSzCdRsrcInvolClosure(resourceHistory.getCdRshsInvolClosure());
      cfad30so.setSzCdRsrcRecmndReopen(resourceHistory.getCdRshsRecmndReopen());
      cfad30so.setSzTxtStatusRsnComments(resourceHistory.getTxtClosureComm() );
      cfad30so.setSzCdRsrcStatus(resourceHistory.getCdRshsStatus());
      cfad30so.setBIndRsrcNonPrs(resourceHistory.getIndRsrcNondfcs());
      cfad30so.setUlIdResource(
              resourceHistory.getIdResourceHistory() != null ? resourceHistory.getIdResourceHistory() : 0);
      tsLastUpdate_array.addTsLastUpdate(resourceHistory.getDtLastUpdate());
      narrative_idEvent = resourceHistory.getEvent().getIdEvent();
    } else {
      // Calls DAO to retreive Resource row, Event row, and to determine if there are children currently placed in the
      //   home.  These DAMs are called only if the window is in Modify mode.
      // CSES41D
      CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
      if (capsResource == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      cfad30so.setSzCdRsrcFaHomeStatus(capsResource.getCdRsrcFaHomeStatus());
      cfad30so.setSzCdRsrcClosureRsn(capsResource.getCdRsrcClosureRsn());
      cfad30so.setSzCdRsrcInvolClosure(capsResource.getCdRsrcInvolClosure());
      cfad30so.setSzCdRsrcRecmndReopen(capsResource.getCdRsrcRecmndReopen());
      cfad30so.setSzTxtStatusRsnComments(capsResource.getTxtClosureComm() );
      cfad30so.setSzCdRsrcStatus(capsResource.getCdRsrcStatus());
      cfad30so.setBIndRsrcNonPrs(capsResource.getIndRsrcNonDfcs());
      cfad30so.setUlIdResource(capsResource.getIdResource() != null ? capsResource.getIdResource() : 0);
      tsLastUpdate_array.addTsLastUpdate(capsResource.getDtLastUpdate());
      cfad30so.setSzCdRsrcFacilType(capsResource.getCdRsrcFacilType());
      // Get Event associated with current CAPS_RESOURCE record
      ROWCCMN01UIG00 rowccmn01uig00 = findResourceEventDetail(capsResource.getEvent().getIdEvent());
      narrative_idEvent = rowccmn01uig00.getUlIdEvent();
      cfad30so.setROWCCMN01UIG00(rowccmn01uig00);
      // CMSC39D
      List<Map> placements =
              placementDAO.findPersonByIdPlcmtChildByCapsResourceByIdRsrcFacil(DateHelper.toJavaDate(todayCastorDate),
                                                                               cfad30so.getUlIdResource());
      cfad30so.setBSysIndGeneric(ArchitectureConstants.N);
      for (Iterator<Map> it = placements.iterator(); it.hasNext();) {
        Map placement = it.next();
        // If placements are returned by the DAO, then we need to call CLSS64D in order  to determine if any have the
        //   most recent legal status of Adoption Consumated.  If so, then they should not trigger a determination of
        //   placements still in the home.  Loop through each placement returned, and if it is of Type Adoptive or
        //   NonPrsAdoptive, then check it with the DAM to ensure that it should trigger a determination of placements
        //   still in the home.  If the  placement is of neither of these two types, then trigger placement still in
        //   the home right then.
        String cdPlcmtLivArr = (String) placement.get("cdPlcmtLivArr");
        if (CodesTables.CPLLAFRM_GT.equals(cdPlcmtLivArr) ||
            CodesTables.CPLLAFRM_71.equals(cdPlcmtLivArr)) {
          // Is Placement Adoption Consumated
          // clss64d
          Person plcmtChild = (Person) placement.get("personByIdPlcmtChild");
          LegalStatus legalStatus =
                  legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(plcmtChild.getIdPerson(),
                                                                                       CodesTables.CLEGSTAT_090);
          // If the Adoption Consumated legal status record was found, then the placement should not trigger the
          //   Indicator.  Do not  set SysIndGeneric
          if (legalStatus == null) {
            // The Adoptive or Non PRS placement does not have a legal status of Adoption  Consumated so we should
            //   trigger the indicator
            cfad30so.setBSysIndGeneric(ArchitectureConstants.Y);
          }
        } else {
          cfad30so.setBSysIndGeneric(ArchitectureConstants.Y);
        }
      }
    }
    // The following two DAMs will be called each time the service is called.
    // These DAMS retrieve Stage information and check for the existance of a BLOB
    // cses71d - Stage Retrieval
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cfad30so.setUlIdCase(stage.getCapsCase() != null ? stage.getCapsCase().getIdCase() : 0);
    cfad30so.setUlIdSituation(
            stage.getSituation() != null ? stage.getSituation().getIdSituation() : 0);
    tsLastUpdate_array.addTsLastUpdate(stage.getDtLastUpdate());
    cfad30so.setTsLastUpdate_ARRAY(tsLastUpdate_array);
    // Note that this is not fully implemented; only the dtLastUpdate is retreived, not the associated narrative blob.
    //   This is ok for non-forms services because they do not deal with the blob
    // csys06d
    Date dtLastUpdate = commonDAO.findDtLastUpdate(CLOSING_SUMMARY_DOC, narrative_idEvent);
    if (dtLastUpdate == null) {
      cfad30so.setBIndBLOBExistsInDatabase(ArchitectureConstants.Y);
    } else {
      cfad30so.setBIndBLOBExistsInDatabase(ArchitectureConstants.N);
    }
    return cfad30so;
  }

  private ROWCCMN01UIG00 findResourceEventDetail(Integer idEvent) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn01uig00.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    return rowccmn01uig00;
  }
}
