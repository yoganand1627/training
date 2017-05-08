package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomesDetail;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveNeedsAndOutcomes;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveNeedsAndOutcomesImpl extends BaseServiceImpl implements RetrieveNeedsAndOutcomes {

  private EventDAO eventDAO = null;
  private NeedsOutcomesDAO needsOutcomesDAO = null;
  private NeedsOutcomesDetailDAO needsOutcomesDetailDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setNeedsOutcomesDAO(NeedsOutcomesDAO needsOutcomesDAO) {
    this.needsOutcomesDAO = needsOutcomesDAO;
  }

  public void setNeedsOutcomesDetailDAO(NeedsOutcomesDetailDAO needsOutcomesDetailDAO) {
    this.needsOutcomesDetailDAO = needsOutcomesDetailDAO;
  }

  @SuppressWarnings("unchecked")
  public NeedsAndOutcomesRetrieveSO retrieveNeedsAndOutcomes(NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSi) {
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = new NeedsAndOutcomesRetrieveSO();
    int idEvent = needsAndOutcomesRetrieveSi.getUlIdEvent();

    if (idEvent == 0) {
      return needsAndOutcomesRetrieveSO;
    } else {
      // retrieve needs and outcomes
      needsAndOutcomesRetrieveSO.setROWCCMN45DO(processEventDAO(idEvent));
      NeedsOutcomes needsOutcomes = needsOutcomesDAO.findNeedsAndOutcomes(idEvent);
      needsAndOutcomesRetrieveSO.setTxtAssessorName(needsOutcomes.getNmAssessor());
      needsAndOutcomesRetrieveSO.setTxtAssessorTitle(needsOutcomes.getTxtAssessorTitle());
      needsAndOutcomesRetrieveSO.setDtReferral(needsOutcomes.getDtReferral());
      needsAndOutcomesRetrieveSO.setDtAssessmentCompletion(needsOutcomes.getDtAsstCmplt());
      needsAndOutcomesRetrieveSO.setTxtGeneralRec(needsOutcomes.getTxtGenRec());
      needsAndOutcomesRetrieveSO.setTxtPlacementRec(needsOutcomes.getTxtPlcmtRec());
      needsAndOutcomesRetrieveSO.setTxtCCFARecNotUsed(needsOutcomes.getTxtCcfaRec());
      needsAndOutcomesRetrieveSO.setDtLastUpdate(needsOutcomes.getDtLastUpdate());
      needsAndOutcomesRetrieveSO.setNMResource(needsOutcomes.getNmAgency());
      needsAndOutcomesRetrieveSO.setIndCCFAAgency(needsOutcomes.getIndCcfaAgency());
      needsAndOutcomesRetrieveSO.setIndCCFAEduAssmt(needsOutcomes.getIndCcfaEduAssmt());
      needsAndOutcomesRetrieveSO.setTxtCCFAEduAssmt(needsOutcomes.getTxtCcfaEduAssmt());
      needsAndOutcomesRetrieveSO.setDtCCFAEduAssmt(needsOutcomes.getDtCcfaEduAssmt());
      needsAndOutcomesRetrieveSO.setTxtUnder4NoDevSrcCmnt(needsOutcomes.getTxtUnder4NoDevSrcCmnt());
      needsAndOutcomesRetrieveSO.setTxtUndSchoolageNoDevAss(needsOutcomes.getTxtUndSchoolageNoDevAss());
      
      // retrieves the needs and outcomes detail list for that event
      List<NeedsOutcomesDetail> needsOutcomesDetailList =
              needsOutcomesDetailDAO.findNeedsAndOutcomesDetailList(idEvent);
      List needsList = new ArrayList();

      if (needsOutcomesDetailList != null && !needsOutcomesDetailList.isEmpty()) {
        for (Iterator it = needsOutcomesDetailList.iterator(); it.hasNext();) {
          NeedsOutcomesDetail needsOutcomesDetail = (NeedsOutcomesDetail) it.next();
          NeedsAndOutcomesList needsAndOutcomes = new NeedsAndOutcomesList();
          needsAndOutcomes.setIdNeedsAndOutcomes(needsOutcomesDetail.getIdNeedsOutcomesDetail());
          needsAndOutcomes.setIndCCFANeed(needsOutcomesDetail.getIndCcfaNeed());
          needsAndOutcomes.setIndNeedMet(needsOutcomesDetail.getIndNeedMet());
          needsAndOutcomes.setIndServiceProvided(needsOutcomesDetail.getIndSvcProv());
          needsAndOutcomes.setTxtIdentifiedNeed(needsOutcomesDetail.getTxtIdenNeed());
          needsAndOutcomes.setTxtServiceRecommended(needsOutcomesDetail.getTxtSvcRec());
          needsAndOutcomes.setDtLastUpdateDetail(needsOutcomesDetail.getDtLastUpdate());
          needsList.add(needsAndOutcomes);
        }
      }
      needsAndOutcomesRetrieveSO.setNaoBeanList(needsList);
      return needsAndOutcomesRetrieveSO;
    }
  }

  private ROWCCMN45DO processEventDAO(int idEvent) throws ServiceException {

    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

}