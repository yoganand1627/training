package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexIntakeAllegationDAO {
  /**
   * Updates a person's full name whether they are a perpetrator or victim
   *
   * @param cdNamePersonFull
   * @param idPerson
   * @param idStage
   */
  void updateNameByIdStage(String cdNamePersonFull, int idPerson, int idStage);

  /**
   * Partial update of IntakeAllegation table with the supplied column values.
   *
   * @param idRelatedPerson
   * @param nmPersonFull
   * @param idPerson
   * @param idStage
   */
  int updateIntakeAllegation(int idRelatedPerson, String nmPersonFull, int idPerson, int idStage);

  /**
   * Adds a new IntakeAllegation row only if one is not already there. Updates the INCOMING_DETAIL
   * table if indIncmgMaltreatInCare is set to 'Y'
   *
   * @param cdAllegType
   * @param idStage
   * @param cdTxtAllegDuration
   * @param idVictim
   * @param idAllegedPerpetrator
   * @param indIncmgMaltreatInCare
   * @param cdNmVictim
   * @param cdNmPerpetrator
   * @param cdAllegedMalLocation
   * @param cdIntakeAllegMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return number of rows inserted
   */
  int addIntakeAllegationWithCheck(String cdAllegType, int idStage, String cdTxtAllegDuration,
                                   int idVictim, int idAllegedPerpetrator, String indIncmgMaltreatInCare,
                                   String cdNmVictim, String cdNmPerpetrator, String cdAllegedMalLocation,
                                   String cdIntakeAllegMalCode, Date dtAllegedIncident, String cdMaltreatorRel);

  /**
   * updates an IntakeAlegation row with various values
   *
   * @param cdIntakeAllegType
   * @param idStage
   * @param cdTxtAllegDuration
   * @param idVictim
   * @param idAllegedPerpetrator
   * @param indIncmgMaltreatInCare
   * @param cdNmVictim
   * @param cdNmPerpetrator
   * @param idAllegation
   * @param cdAllegedMalLocation
   * @param cdAllegedMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return
   */
  int updateIntakeAllegationDetails(String cdIntakeAllegType, int idStage, String cdTxtAllegDuration,
                                    int idVictim, int idAllegedPerpetrator, String indIncmgMaltreatInCare, 
                                    String cdNmVictim, String cdNmPerpetrator, int idAllegation, String cdAllegedMalLocation,
                                    String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel);
}