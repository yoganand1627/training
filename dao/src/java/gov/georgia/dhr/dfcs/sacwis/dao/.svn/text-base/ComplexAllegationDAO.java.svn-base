package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexAllegationDAO {

  /**
   * Counts the number of identical allegations on the ALLEGATION table
   *
   * @param idAllegedPerpetrator
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  long countAllegationForUpdateFunction(int idAllegedPerpetrator, String cdAllegType, int idVictim, int idStage);

  /**
   * Retrieves idAllegation from the ALLEGATION table
   *
   * @param idAllegedPerpetrator
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  int findAllegationForUpdateFunction(int idAllegedPerpetrator, String cdAllegType, int idVictim, int idStage);
}
