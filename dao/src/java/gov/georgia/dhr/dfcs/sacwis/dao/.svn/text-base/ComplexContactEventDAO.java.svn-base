package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexContactEventDAO {
  /**
   * Description:
   * <p/>
   * DELETE FROM TODO if the functionCode = DELETE DELETE FROM EVENT_PERSON_LINK for ASG and CON events DELETE FROM
   * CONTACT DELETE FROM CONTACT_NARRATIVE DELETE FROM EVENT Clear the ID_EVENT on INCOMING_DETAIL
   * <p/>
   * NOTE - SQL_NOT_FOUND is allowable in all cases except the UPDATE on INCOMING_DETAIL.
   * <p/>
   *
   * @param deleteTodo
   * @param idStage
   */

  @SuppressWarnings({"unchecked"})
  public void deleteContractEvent(boolean deleteTodo, int idStage);
}
