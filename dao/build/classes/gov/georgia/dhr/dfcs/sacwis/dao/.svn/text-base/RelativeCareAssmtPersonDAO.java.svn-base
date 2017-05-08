package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmtPerson;

import java.util.List;

public interface RelativeCareAssmtPersonDAO {
  
  
  /**
   *  Returns persons by id event and person type
   * @param idRcaEvent
   * @param cdPersonType
   * @return
   */
  public List<RelativeCareAssmtPerson> findRelativeCareAssmtPersonByIdRcaEventCdPersonType(int idRcaEvent, String cdPersonType);
  
  /**
   * Returns persons by id event and person types
   * @param idRcaEvent
   * @param cdPersonType
   * @return
   */
  public List<Integer> findRelativeCareAssmtPersonByIdRcaEventCdPersonTypes(int idRcaEvent, List<String> cdPersonType);
  
  /**
   * Returns childern - RCAPerson(s) for parent RCA 
   * @param idRcaEvent
   * @return
   */
  public List<RelativeCareAssmtPerson> findRelativeCareAssmtPersonByIdRcaEvent(int idRcaEvent);
  
  /**
   * Inserts or updates RelativeCareAssessmentPersonInfo
   * @param person
   */
  public void saveOrUpdateRelativeCareAssmtPerson(RelativeCareAssmtPerson person);
  
  /**
   * Deletes RelativeCareAssmtPerson(s) based on event id.
   * @param idRcaEvent
   * @return
   */
  public int deleteRelativeCareAssmtPersons(int idRcaEvent);
  
  /**
   * Deletes RelativeCareAssmtPerson(s) based on event id.
   * @param idRcaEvent
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List findIdPersonByIdEvent(int idEvent);

}
