package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexApprovalDAO {
  /**
   * Delete an approval by a cascading delete on the tables: ApprovalEventLink Approvers Approval ToDo Event Returns the
   * toatl number of rows deleted by the operation or 0 if any delete operation returned SQL_NOT_FOUND error.
   *
   * @param idApproval
   * @param idEvent
   * @return The number rows deleted or 0.
   */
  int approvalCascadeDelete(int idApproval, int idEvent);
}