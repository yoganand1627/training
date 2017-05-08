package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;

import java.util.List;

public interface LegalActionOutcomeDAO {
  /**
   * Calls Hibernate method Session.saveOrUpdate for the given {@link gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome} object.
   * 
   * @param lao
   */
  void saveOutcome(LegalActionOutcome lao);
  
  /**
   * Calls Hibernate method Session.delete for the given {@link gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome} object.
   * 
   * @param lao
   */
  void deleteOutcome(LegalActionOutcome lao);
  
  /**
   * Deletes all entries in LegalActionOutcome for the given idLegalActEvent-cdOutcome combination.
   * 
   * @param idLegalActEvent
   * @param cdOutcome
   * @return
   */
  int deleteOutcome(int idLegalActEvent, String cdOutcome);
  
  /**
   * Retrieves a list of all LegalActionOutcome entries for the given idLegalActEvent (key to LegalAction).
   * 
   * @param idLegalActEvent
   * @return
   */
  List<LegalActionOutcome> findLegalActionOutcomeList(int idLegalActEvent);
  
  /**
   * Retrieves the first result from LegalActionOutcome where the parent LegalAction record matches the
   * idPerson and has an outcome code of cdOutcome. This query is most likely
   * only useful for the RetrieveYouthReportDetail service to determine if the idPerson should be
   * considered an adjudicated delinquent.
   * 
   * @param idPerson
   * @param cdOutcome
   * @return
   */
  LegalActionOutcome findLegalActionOutcomeForYouthReport(int idPerson, String cdOutcome);

  /**
   * Retrieves a list of all cdOutcome entries for the given idLegalActEvent (key to LegalAction).
   * 
   * @param idLegalActEvent
   * @return List<String>
   */
  List<String> findCdOutcomeListByIdEvent(int idLegalActEvent);
}
