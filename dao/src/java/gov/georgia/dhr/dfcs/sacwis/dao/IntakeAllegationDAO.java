/**
 * Created on Mar 25, 2006 at 3:08:15 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.IntakeAllegation;

public interface IntakeAllegationDAO {
  /**
   * This retrieves all intake allegations for a given idStage <p/>
   * 
   * @param idStage
   * @return List map
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIntakeAllegationsByIdStage(int idStage);

  /**
   * Retrieves all allegations for a stage based on whether the incident took place in care or not
   * 
   * @param idStage
   * @param indMaltreatInCare
   * @return
   */
  List<IntakeAllegation> findAllegationsByMaltreatmentInCare (int idStage, String indMaltreatInCare);
  
  /**
   * Selects all allegations for a given ID_STAGE in which the stage of service is SVC, INT, or INV
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIntakeAllegationByPersonByIdVictimAndIdStage(int idStage);

  /**
   * Retrieves Allegations where the date of alleged incident is after the passed in
   * removal date for the particular person
   * 
   * @param idPerson
   * @param dtRemoval
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<IntakeAllegation> findAllegationAfterRemovalByIdPersonAndDtRemoval(int idPerson, Date dtRemoval);
  
/**
 * Returns A count of Intake Allegations
 * @param idVictimPerson
 * @param idAllegPerpPerson
 * @param idStage
 * @param cdAllegType
 * @param dtAllegedIncident
 * @param cdAllegedMalCode
 * @param cdAllegedMalLocation
 * @param cdMaltreatorRel
 * @return
 */
 
  long countIntakeAllegations(int idVictimPerson, int idAllegPerpPerson, int idStage, String cdAllegType, 
		                      Date dtAllegedIncident, String cdAllegedMalCode, 
                                      String cdAllegedMalLocation, String cdMaltreatorRel);

  /**
   * Inserts an IntakeAllegation row by values
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
   * @param cdAllegedMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return
   */
  int insertIntakeAllegation(String cdAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                             int idAllegedPerpetrator, String indIncmgMaltreatInCare, String cdNmVictim, 
                             String cdNmPerpetrator, String cdAllegedMalLocation, String cdAllegedMalCode, 
                             Date dtAllegedIncident, String cdMaltreatorRel);

  /**
   * Inserts an IntakeAllegation row by values
   * 
   * @param cdAllegType
   * @param idStage
   * @param cdTxtAllegDuration
   * @param idVictim
   * @param indIncmgMaltreatInCare
   * @param cdNmVictim
   * @param cdAllegedMalLocation
   * @param cdAllegedMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return
   */
  int insertIntakeAllegation(String cdAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                             String indIncmgMaltreatInCare, String cdNmVictim, String cdAllegedMalLocation,
                             String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel);

  /**
   * Updates table IntakeAllegation, fields idPerson and nmPersonFull given idRelatedPerson, nmVictim, idPerson and
   * idStage.<p/>
   * 
   * @param idRelatedPerson
   * @param nmPersonFull
   * @param idPerson
   * @param idStage
   */
  int updateIntakeAllegationIdVictimNmVictim(int idRelatedPerson, String nmPersonFull, int idPerson, int idStage);

  /**
   * Updates table IntakeAllegation, fields idPerson and nmPersonFull given idRelatedPerson, nmPerpetrator, idPerson and
   * idStage.<p/>
   * 
   * @param idRelatedPerson
   * @param nmPersonFull
   * @param idPerson
   * @param idStage
   */
  int updateIntakeAllegationIdAllegedPerpNmPerpetrator(int idRelatedPerson, String nmPersonFull, int idPerson,
                                                       int idStage);

  /**
   * Updates table IntakeAllegation, fields nmPersonFull given nmPerpetrator, personByIdAllegedPerpetrator and idStage.<p/>
   * 
   * @param nmPersonFull
   * @param personByIdAllegedPerpetrator
   * @param idStage
   */
  int updateIntakeAllegationByPersonByIdAllegedPerpetratorIdStage(String nmPersonFull,
                                                                  int personByIdAllegedPerpetrator, int idStage);

  /**
   * Updates table IntakeAllegation, fields nmPersonFull given nmPerpetrator, personByIdVictim and idStage.<p/>
   * 
   * @param nmPersonFull
   * @param personByIdVictim
   * @param idStage
   */
  int updateIntakeAllegationByPersonByIdVictimIdStage(String nmPersonFull, int personByIdVictim, int idStage);

  /**
   * updates an IntakeAlegation row with various values
   * 
   * @param cdIntakeAllegType
   * @param idStage
   * @param cdTxtAllegDuration
   * @param idVictim
   * @param idAllegedPerpetrator
   * @param cdNmVictim
   * @param cdNmPerpetrator
   * @param idAllegation
   * @param cdAllegedMalLocation
   * @param indIncmgMaltreatInCare
   * @param cdAllegedMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return
   */
  int updateIntakeAllegationDetails(String cdIntakeAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                                    int idAllegedPerpetrator, String cdNmVictim, String cdNmPerpetrator,
                                    int idAllegation, String cdAllegedMalLocation, String indIncmgMaltreatInCare, 
                                    String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel);

  /**
   * updates an IntakeAlegation row with various values
   * 
   * @param cdIntakeAllegType
   * @param idStage
   * @param cdTxtAllegDuration
   * @param idVictim
   * @param cdNmVictim
   * @param idAllegation
   * @param cdAllegedMalLocation
   * @param indIncmgMaltreatInCare
   * @param cdAllegedMalCode
   * @param dtAllegedIncident
   * @param cdMaltreatorRel
   * @return
   */

  public int updateIntakeAllegationDetails(String cdIntakeAllegType, int idStage, String cdTxtAllegDuration,
                                           int idVictim, String cdNmVictim, int idAllegation,
                                           String cdAllegedMalLocation, String indIncmgMaltreatInCare, 
                                           String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel);

  /**
   * Delete rows from IntakeAllegation based on idAllegation.
   * 
   * @param idStage
   */
  int deleteIntakeAllegation(int idAllegation);

  /**
   * Retrieves list of distinct allegation types given an ID stage
   * 
   * @param idStage
   */
  List<String> findDistinctAllegationTypesByIdStage(int idStage);
}
