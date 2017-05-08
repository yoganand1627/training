package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Pal;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveClosePALStage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO;

public class SaveClosePALStageImpl extends BaseServiceImpl implements SaveClosePALStage {

  private ComplexStageDAO complexStageDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventDAO eventDAO = null;

  private PalDAO palDAO = null;

  private PersonDAO personDAO = null;

  private PlacementDAO placementDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private UnitDAO unitDAO = null;

  public static final String PAL_UNIT_SPECIALIZATION = "PAL";

  public static final String PRIMARY_CHILD_ROLE = CodesTables.CROLES_PC;

  public static final String MERGED_STATUS = "M";

  public static final int PAL_RETRIEVAL = 0;

  public static final int EVENT_RETRIEVAL = 1;

  public static final int AGE_EIGHTEEN = 9466560;

  public static final String SERVICE_AUTH_TASK_CODE = "3520";

  public static final String SERVICE_AUTH_EVENT_TYPE_CODE = CodesTables.CEVNTTYP_AUT;

  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalDAO(PalDAO palDAO) {
    this.palDAO = palDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public CCFC03SO saveClosePALStage(CCFC03SI ccfc03si) throws ServiceException {
    CCFC03SO ccfc03so = new CCFC03SO();

    // cses42dQUERYdam
    Pal csec42dPAL = palDAO.findPal(ccfc03si.getUlIdStage());

    if (csec42dPAL == null) {
      ccfc03so.setCSysIndPalIlsAssmt(ArchitectureConstants.N);
    } else {
      ccfc03so.setCSysIndPalIlsAssmt(ArchitectureConstants.Y);
    }

    ccfc03so.setSzCdPalCloseLivArr(csec42dPAL.getCdPalCloseLivArr());
    TsLastUpdate_ARRAY_CCFC03SO tsLastUpdateArrayCcfc03So = new TsLastUpdate_ARRAY_CCFC03SO();
    tsLastUpdateArrayCcfc03So.setTsLastUpdate(PAL_RETRIEVAL, csec42dPAL.getDtLastUpdate());
    ccfc03so.setTsLastUpdate_ARRAY_CCFC03SO(tsLastUpdateArrayCcfc03So);

    // Call the Primary Staff Simple DAO - CCMNG2D
    // Description - This dao will receive ID_STAGE from the service and
    // return the associated record from STAGE PERSON LINK
    // table where the staff person's role is primary (PR).

    // ccmng2dQUERYdam
    StagePersonLink ccmng2dStagePersonLink = stagePersonLinkDAO
            .findStagePersonLinkByIdStageCdStagePersRole(ccfc03si
                    .getUlIdStage());

    if (ccmng2dStagePersonLink.getPerson().getIdPerson() == ccfc03si.getUlIdPerson()) {
      ccfc03so.setCSysIndPrimaryWorker(ArchitectureConstants.Y);
    } else {
      ccfc03so.setCSysIndPrimaryWorker(ArchitectureConstants.N);
    }

    // Call the Check for Unit Approval DAO - CSES45D
    // Description - This DAM will retrieve a full row from the UNIT table
    // and will take as input ID_PERSON and CD UNIT
    // SPECIALIZATION. It will return one row.

    // cses45dQUERYdam
    Unit csec45dUnit = unitDAO.findUnit(ccfc03si.getUlIdPerson(), PAL_UNIT_SPECIALIZATION);

    if (csec45dUnit != null) {
      ccfc03so.setCSysIndPalLeadCoord(ArchitectureConstants.Y);
    } else {

      ccfc03so.setCSysIndPalLeadCoord(ArchitectureConstants.N);
    }

    // 
    // Call the Stage Person Link DAO - CINV51D
    // Description - This DAO will retrieve either the primary worker
    // or the historically primary worker and name stage
    // based upon the ID_STAGE that is passes in.

    // cinv51dQUERYdam
    int cinv51dIdPrimaryWorker = complexStageDAO.findPrimaryWorker(ccfc03si.getUlIdStage(), PRIMARY_CHILD_ROLE);

    if (cinv51dIdPrimaryWorker == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    // ccmn44dQUERYdam
    Person ccmn44dPerson = personDAO.findPersonByIdPerson(cinv51dIdPrimaryWorker);
    int Age = 0;

    if (ccmn44dPerson != null) {
      Age = DateHelper.getAge(ccmn44dPerson.getDtPersonBirth());

      if (Age >= AGE_EIGHTEEN) {
        ccfc03so.setCSysIndPalOverEighteen(ArchitectureConstants.Y);
      } else {
        ccfc03so.setCSysIndPalOverEighteen(ArchitectureConstants.N);
      }

      if (MERGED_STATUS.equals(ccmn44dPerson.getCdPersonStatus())) {
        ccfc03so.setCSysIndPalStageMerged(ArchitectureConstants.Y);
      } else {
        ccfc03so.setCSysIndPalStageMerged(ArchitectureConstants.N);
      }
    } else {
      ccfc03so.setCSysIndPalOverEighteen(ArchitectureConstants.N);
      ccfc03so.setCSysIndPalStageMerged(ArchitectureConstants.N);
    }

    // Call the Most Recent Acutal Discharge DAO - CSEC51D
    // Description - This will return the most recent row
    // off of the placement table for the id
    // person passed in. Also cd_plcmt_act_
    // planned = A and cd_plcmt_removal_rsn must
    // exist in cdischrg codes table.

    // csec51dQUERYdam
    Date csec51dDtMostRecentPlacement = placementDAO.findMostRecentPlacementByIdPerson(cinv51dIdPrimaryWorker);

    if (csec51dDtMostRecentPlacement != null) {
      ccfc03so.setCSysIndDischargeDate(ArchitectureConstants.Y);
    } else {
      ccfc03so.setCSysIndDischargeDate(ArchitectureConstants.N);
    }

    if (0 != ccfc03si.getUlIdEvent()) {

      // ccmn45dQUERYdam
      Event ccmn45dEvent = eventDAO.findEventByIdEvent(ccfc03si.getUlIdEvent());

      if (ccmn45dEvent == null) {
        throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      }

      ccfc03so.setSzCdEventStatus(ccmn45dEvent.getCdEventStatus());
      tsLastUpdateArrayCcfc03So.setTsLastUpdate(EVENT_RETRIEVAL, ccmn45dEvent.getDtLastUpdate());
      ccfc03so.setTsLastUpdate_ARRAY_CCFC03SO(tsLastUpdateArrayCcfc03So);
      ccfc03so.setSzCdTask(ccmn45dEvent.getCdTask());
    }

    // cint21dQUERYdam
    Stage cint21dStage = stageDAO.findStageByIdStage(ccfc03si.getUlIdStage());

    if (cint21dStage == null) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    ccfc03so.setSzCdStageReasonClosed(cint21dStage.getCdStageReasonClosed());
    ccfc03so.setDtDtStageClose(DateHelper.toCastorDate(cint21dStage.getDtStageClose()));

    String[] cdEventTypes = null;
    cdEventTypes[0] = SERVICE_AUTH_EVENT_TYPE_CODE;

    // ccmn87dQUERYdam
    List<Object[]> ccmn87dDynamicEvent = dynamicEventDAO.findEvents(false, 0, ccfc03si.getUlIdStage(), 0, 0, 0,
                                                                    cdEventTypes, null, SERVICE_AUTH_TASK_CODE,
                                                                    null, null, null);

    if (ccmn87dDynamicEvent != null && !ccmn87dDynamicEvent.isEmpty()) {
      Iterator itCcmn87dDynamicEventList = ccmn87dDynamicEvent.iterator();
      ccfc03so.setCSysIndPalSvcAuth(ArchitectureConstants.N);

      while (((itCcmn87dDynamicEventList.hasNext()) && (ccfc03so.getCSysIndPalSvcAuth().equals(
              ArchitectureConstants.N)))) {
        Object[] ccmn87DynamicEvent = (Object[]) itCcmn87dDynamicEventList.next();
        String ccmn87CdEventStatus = (String) ccmn87DynamicEvent[0];
        int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];

        if ((EVENT_STATUS_COMPLETE.equals(ccmn87CdEventStatus)) || (EVENT_STATUS_APPROVED.equals(ccmn87CdEventStatus))
            || (EVENT_STATUS_PEND.equals(ccmn87CdEventStatus))) {

          // cses24dQUERYdam
          ServiceAuthorization cses24dServiceAuthorization = serviceAuthorizationDAO
                  .findServiceAuthEventLink(ccmn87IdEvent);

          if (cses24dServiceAuthorization != null) {

            // clss24dQUERYdam
            List<SvcAuthDetail> clss24dSvcAuthDetailList = svcAuthDetailDAO
                    .findServiceAuthDetailPersonByIdSvcAuth(cses24dServiceAuthorization
                            .getIdSvcAuth());

            if (clss24dSvcAuthDetailList != null && !clss24dSvcAuthDetailList.isEmpty()) {
              Iterator itClss24dSvcAuthDetailList = clss24dSvcAuthDetailList.iterator();

              while (itClss24dSvcAuthDetailList.hasNext()) {
                SvcAuthDetail clss24dSvcAuthDetail = (SvcAuthDetail) itClss24dSvcAuthDetailList.next();

                if (DateHelper.isBefore(clss24dSvcAuthDetail.getDtSvcAuthDtlTerm(), new Date())) {
                  ccfc03so.setCSysIndPalSvcAuth(ArchitectureConstants.Y);
                }
              }
            }
          }
        }
      }
    }
    return ccfc03so;
  }
}
