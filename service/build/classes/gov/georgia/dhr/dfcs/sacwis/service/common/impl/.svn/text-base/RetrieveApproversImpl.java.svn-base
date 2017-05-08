package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveApprovers;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Approver;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveApproversImpl extends BaseServiceImpl implements RetrieveApprovers {
  private ApproversDAO approversDAO;

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }
  
  public ApproversRetrieveSO retrieveApprovers(ApproversRetrieveSI si){
    boolean eventKey = false;
    boolean approvalKey = false;
    boolean todoKey = false;
    
    //-- first validate retrievalKey and key    
    boolean throwError = false;
    switch(si.getRetrievalKey()){
    case ApproversRetrieveSI.SUBMITTED_EVENT:
      eventKey = true;
      throwError = !si.hasIdEvent();
      break;
    case ApproversRetrieveSI.APPROVAL:
      approvalKey = true;
      throwError = !si.hasIdApproval();
      break;
    case ApproversRetrieveSI.TODO:
      todoKey = true;
      throwError = !si.hasIdTodo();
      break;
    }
    if(throwError){
      throw new RuntimeWrappedException(new PopulationException("The key specified by the retrievalKey was not given."));
    }
    
    //-- okay, we have a key to use; proceed with retrieval
    List<Approvers> approversList = new ArrayList<Approvers>();
    if(eventKey){
      approversList = approversDAO.findApproversByIdEventReverseChronology(si.getIdEvent());
    } else if(approvalKey){
      approversList = approversDAO.findApproversByIdApprovalReverseChronology(si.getIdApproval());
    } else if(todoKey){
      approversList = approversDAO.findApproversByIdTodoReverseChronology(si.getIdTodo());
    }
    return approvers(approversList);
  }
  
  private ApproversRetrieveSO approvers(List<Approvers> approversList){
    ApproversRetrieveSO so = new ApproversRetrieveSO();
    if(approversList != null && !approversList.isEmpty()){
      List<Approver> historicals = new ArrayList<Approver>();
      boolean first = true;
      for(Iterator<Approvers> it = approversList.iterator(); it.hasNext();){
        Approvers approvers = it.next();
        if(first){
          if(DateHelper.isNull(approvers.getDtApproversDetermination()) && "PEND".equals(approvers.getCdApproversStatus())){
            so.setCurrentActiveApprover(convertApproversToApprover(approvers, false));
          } else{
            historicals.add(convertApproversToApprover(approvers, true));
          }
          first = false;
          continue;
        }
        historicals.add(convertApproversToApprover(approvers, true));
      }
      so.setHistoricalApprovers(historicals);
    }
    return so;
  }
  
  private Approver convertApproversToApprover(Approvers approvers, boolean isHistorical){
    Approver a = new Approver(isHistorical);
    a.setCdStatus(approvers.getCdApproversStatus());
    a.setDtDetermination(approvers.getDtApproversDetermination());
    a.setDtLastUpdate(approvers.getDtLastUpdate());
    a.setDtRequested(approvers.getDtApproversRequested());
    if(approvers.getApproval() != null){
      a.setIdApproval(approvers.getApproval().getIdApproval().intValue());
    }
    a.setIdApprovers(approvers.getIdApprovers());
    if(approvers.getPerson() != null){
      Person person = approvers.getPerson();
      a.setIdPerson(person.getIdPerson().intValue());
      a.setNmPersonFull(person.getNmPersonFull());
      Employee employee = getPersistentObject(Employee.class, a.getIdPerson());
      if(employee != null && employee.getUnit() != null){
        a.setIdUnit(employee.getUnit().getIdUnit().intValue());
      }
    }
    if(approvers.getTodo() != null && approvers.getTodo().getIdTodo() != null){
      a.setIdTodo(approvers.getTodo().getIdTodo().intValue());
    }
    a.setIndHistorical(approvers.getIndApproversHistorical());
    a.setTxtComments(approvers.getTxtApproversCmnts());
    return a;
  }
}
