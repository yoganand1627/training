package gov.georgia.dhr.dfcs.sacwis.dao;

public interface HomeStudNarrDAO {
  /**
   * Retreive the idDocumentTemplate from the HomeStudNarr table.
   *
   * @param idStage
   * @return Integer;
   */
  Integer retrieveHomeStudNarr(int idStage); 
  /**
   * Delete record from the HomeStudNarr table.
   *
   * @param idStage
   * @return int;
   */
  int deleteHomeStudNarr(int idStage);
}
