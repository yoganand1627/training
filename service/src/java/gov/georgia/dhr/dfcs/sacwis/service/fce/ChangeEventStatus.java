package gov.georgia.dhr.dfcs.sacwis.service.fce;

public interface ChangeEventStatus {
  
  /** Retrieves the event for a idEvent and change the event status from PROC to PEND
   * @param idEvent
   * @return boolean*/
  public boolean changeEventStatus(int idEvent);

}
