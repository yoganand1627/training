package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;

public class ComplexApprovalDAOImpl extends BaseDAOImpl implements ComplexApprovalDAO {
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private ApproversDAO approversDAO = null;
  private ApprovalDAO approvalDAO = null;
  private TodoDAO todoDAO = null;
  private EventDAO eventDAO = null;

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public int approvalCascadeDelete(int idApproval, int idEvent) {
    int rowsDeleted = 0;
    int count1 = approvalEventLinkDAO.deleteApprovalEventLinkByIdApproval(idApproval);
    int count2 = approversDAO.deleteApproversByIdApproval(idApproval);
    int count3 = approvalDAO.deleteApprovalByIdApproval(idApproval);
    int count4 = todoDAO.deleteTodoByIdTodoEvent(idEvent);
    int count5 = eventDAO.deleteEventByIdEvent(idEvent);
    if (count1 == 0 || count2 == 0 || count3 == 0 || count4 == 0 || count5 == 0) {
      rowsDeleted = 0;
    } else {
      rowsDeleted = count1 + count2 + count3 + count4 + count5;
    }
    return rowsDeleted;
  }
}