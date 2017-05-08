package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFosterCareParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

/*
 * @author Steven Thrasher
 * class: RetrieveWtlp
 */
public class RetrieveFosterCareParticipantImpl extends BaseServiceImpl implements RetrieveFosterCareParticipant {

  // declare local variables
  private EventDAO eventDAO = null;

  private PlanParticipantDAO planParticipantDAO = null;

  public void setEventDAO(EventDAO eventDAO) throws ServiceException {
    this.eventDAO = eventDAO;
  }

  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) throws ServiceException {
    this.planParticipantDAO = planParticipantDAO;
  }

  /*
   * (non-Javadoc)
   * 
   */
  public FosterCareParticipantRetrieveSO retrieveFosterCareParticipant(FosterCareParticipantRetrieveSI fosterCareParticipantRetrieve) {
    FosterCareParticipantRetrieveSO fcpRetrieve = new FosterCareParticipantRetrieveSO();
    List<PlanParticipant> FCPartList = planParticipantDAO.findPlanParticipantByIdEvent(fosterCareParticipantRetrieve.getUlIdEvent());
    fcpRetrieve.setUlIdEvent(fosterCareParticipantRetrieve.getUlIdEvent());
    List<FosterCarePartBean> FCBeanList = new ArrayList<FosterCarePartBean>();
    if (FCPartList != null && !(FCPartList.isEmpty())) {
      for (Iterator<PlanParticipant> it = FCPartList.iterator(); it.hasNext();) {
        FosterCarePartBean FCBean = new FosterCarePartBean();
        PlanParticipant FCParticipant = it.next();
        FCBean.setIdPlanPart(FCParticipant.getIdPlanParticipant());
        FCBean.setDtLastUpdate(FCParticipant.getDtLastUpdate());
        FCBean.setSzCdPartType(FCParticipant.getCdPartTyp());
        if (!(CodesTables.CPARTYPE_OTH.equals(FCBean.getSzCdPartType()))) {
          FCBean.setIdPerson(FCParticipant.getPerson().getIdPerson());
        }

        FCBean.setSzNmPart(FCParticipant.getNmPart());
        if ((CodesTables.CPARTYPE_PIC.equals(FCBean.getSzCdPartType())) && Lookup.isValidCode(CodesTables.CRPTRINT, FCParticipant.getCdRel())){
          String relationshipInterest = Lookup.simpleDecodeSafe(CodesTables.CRPTRINT, FCParticipant.getCdRel());
          FCBean.setSzCdRelInt(relationshipInterest);
        }else{
          FCBean.setSzCdRelInt(FCParticipant.getCdRel());
        }
        FCBean.setDtPart(FCParticipant.getDtPart());
        FCBean.setDtSigned(FCParticipant.getDtSign());
        FCBean.setIndApproval(FCParticipant.getIndAppv());
        FCBean.setDtApprv(FCParticipant.getDtAppv());
        FCBean.setTxtNoApprv(FCParticipant.getTxtNoAppv());
        FCBeanList.add(FCBean);
      }
    }
    fcpRetrieve.setFosterCarePartList(FCBeanList);
    return fcpRetrieve;
  }
}