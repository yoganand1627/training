/**
 * Created on Mar 25, 2006 at 1:54:25 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AllegationDAO {
  /**
   * Retrieves the number of allegations in the stage in which the person is named as victim, not including the current
   * allegation.
   *
   * @param idPerson
   * @param idStage
   * @param idAllegation
   * @return
   */
  long countAllegationPerpetratorByIdStageAndIdPerson(int idPerson, int idStage, int idAllegation);

  /**
   * Retrieves the number of allegations in the stage in which the person is named as victim, not including the current
   * allegation.
   *
   * @param idPerson
   * @param idStage
   * @return
   */
  long countAllegationVictimByIdPersonAndIdStage(int idPerson, int idStage, int idAllegation);
  
  /**
   * Counts the number of Allegations given the idAllegedPerpetrator and idAllegationsStage.
   * 
   * @param idAllegedPerpetrator
   * @param idAllegationStage
   * @return
   */
   //arege PerSTGAP00006539
  long countAllegationByIdAllegedPerpetratorAndidAllegationStage(int idAllegedPerpetrator, int idStage);
  
  /**
   * Counts the number of identical allegations on the ALLEGATION table
   *
   * @param idAllegedPerpetrator
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  Integer findAllegationByPersonByIdAllegedPerpetrator(int idAllegedPerpetrator, String cdAllegType, int idVictim,
                                                       int idStage);

  /**
   * Counts the number of identical allegations on the ALLEGATION table
   *
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  Integer findAllegation(String cdAllegType, int idVictim, int idStage);

  
  /**
   * Find all the allegations for a given Resource
   *
   * @param idResource
   * @param cdDisposition
   * @param idStage
   * @return
   */
  List<Allegation> findAllegationsForResource(int idResource, String cdDisposition);  
  
  /**
   * Counts the number of identical allegations on the ALLEGATION table
   *
   * @param idAllegedPerpetrator
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  long countAllegationByPersonByIdAllegedPerpetrator(int idAllegedPerpetrator, String cdAllegType, int idVictim,
                                                     int idStage);

  /**
   * Counts the number of identical allegations on the ALLEGATION table
   *
   * @param cdAllegType
   * @param idVictim
   * @param idStage
   * @return
   */
  long countAllegationByCdAllegType(String cdAllegType, int idVictim, int idStage);

  /**
   * Retrieves rows for the Allegation List
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllegationsByIdStageAndIdSituation(int idStage);

  /**
   * Selects the set of all unique dispositions assigned to the allegations in a stage.
   *
   * @param idStage
   * @return
   */

  List<String> findAllegDispositionfromIdStage(int idStage);

  /**
   * Return victim/perp ids along with their allegation dispositions
   *
   * @param idStage
   * @return
   */

  List<Object[]> findAllegationByIdVictimAndIdAllegedPerp(int idStage);

  /**
   * Return victim/perp ids along with their allegation dispositions
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllegationsByIdStage(int idStage);
  /**
   * Will return a single indicator indicating whether a there are any allegations for a given person and stage
   *
   * @param idStage
   * @return
   */
  Integer findIdStageByIdVictim(int idStage, int idPerson);

  /**
   * Retrieves the total count of the cases(rows) in which a victim has been merged with a perpetrator or a perpetrator
   * has been merged with a victim.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return CapsResource
   */
  long countCasesOfVictimPrepetratorMerge(
          int idPersMergeForward, int idPersMergeClosed);

  /**
   * Returns a count of allegations for an idPerson, cdPersonStatus, and cdPersonCategory and idAllegationStage
   *
   * @param idPerson
   * @param cdPersonStatus
   * @param cdPersonCategory
   * @param idAllegationStage
   * @return int
   */
  long countAllegationsByPersonStatusCategoryStage(int idPerson, String cdPersonStatus, String cdPersonCategory,
                                                   int idAllegationStage);

  /**
   * Retrieves duplicate allegations from the Allegation table based upon ID_PERSON. (Duplicate allegations are
   * sometimes created by Person Merge)
   *
   * @param idPersMergeForward
   * @return List<Object[]>
   */
  List<Object[]> findAllegationDuplicatesByIdPerson(int idPersMergeForward);

  /**
   * Return a row from Allegation by idPerson, idStage and status
   *
   * @param idPerson
   * @param idStage
   * @return Allegation
   */
  Allegation findAllegationByIdPersonAndIdStage(int idPerson, int idStage);

  /**
   * Retrieves Allegations where the date of alleged incident is after the passed in
   * removal date for the particular person
   * 
   * @param idPerson
   * @param dtRemoval
   * @return
   */
  List<Allegation> findAllegationAfterRemovalByIdPersonAndDtRemoval(int idPerson, Date dtRemoval);
  
  /**
   * This performs a full row retrieval for tables ALLEGATION, FACIL_ALLEG, and PERSON
   *
   * @param idStage
   * @return keys idAllegation, dtLastUpdate, idStage, personByIdVictim, personByIdAllegedPerpetrator,
   *         cdAllegIncidentStage, txtAllegDuration, cdAllegType, cdAllegDisposition, cdAllegSeverity,
   *         indAllegCancelHist, indAllegationCancelHist, cdAllegationEventLoc, cdAllegationClss, cdAllegationClssSupr,
   *         cdAllegationDispSupr, cdAllegationSrc, cdAllegationSrcSupr, dtAllegationSuprReply, dtAllegationInvstgtr,
   *         cdAllegationInjSer, cdAllegationNeglType, dtAllegationIncident, indAllegationAbOffGr, indAllegationSupvd,
   *         txtAllegationCmnts, nbrAllegationMhmr, idPerson, cdPersonSex, nmPersonFull, nbrPersonAge, dtPersonDeath,
   *         dtPersonBirth, cdPersonReligion, cdPersonChar, indPersonDobApprox, cdPersonLivArr, cdPersGuardCnsrv,
   *         cdPersonStatus, cdPersonDeath, cdPersonMaritalStatus, txtPersonOccupation, cdPersonLanguage,
   *         cdPersonEthnicGroup, indPersCancelHist, nmPersonFirst, nmPersonMiddle, nmPersonLast, cdPersonSuffix
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllegationAllegationPerson(int idStage);

  /**
   * This retrieves from the Allegation table, cdAllegType, cdAllegDisposition, cdAllegIncidentStage idAllegation,
   * dtLastUpdateAlleg, matched idVictim from the Person table.  nmPersonFull from the Person table as the Victim of the
   * allegation.  nmPersonFull from  the person table as the Allegation Perpetrator.
   *
   * @param idStage
   * @return Map of Objects
   */
  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<Map> findAllegationFacilAllegFullVictimFullAllegPerpetrator(int idStage, int pageNbr, int pageSize);

  /**
   * Returns unique peronByIdVictims by idStage for unknown AllegedPerpetrators
   *
   * @param idStage
   * @return List<Map>
   */

  List<Map<String, Object>> findIdPersonByVictimIdByIdStage(int idStage);

  /**
   * Returns idAllegation of any physical or sexual abuse for specified idStage
   *
   * @param idStage
   * @return Integer
   */
  Integer findPhSxAbIdAllegationByIdStage(int idStage);

  /**
   * Retrieves a single row from the Allegation table for the given idAlleagtion
   *
   * @param idAllegation
   * @return Allegation
   */
  Allegation findAllegationByIdAllegation(int idAllegation);

  /**
   * This selects all victim id's in a stage and a list of disinct dispositions per victim.  The list of victims does
   * not include anyone who is both a victim and an alleged perpetrator within the stage.
   *
   * @param idStage
   * @return keys idPerson, cdAllegDisposition
   */

  List<Map<String, Object>> findAllegationIdVictim(int idStage);

  /**
   * This selects all alleged perpetrator id's in a stage and a list of disinct dispositions per alleged perpetrator.
   * The list of alleged perpetrators does not include anyone who is both a victim and an alleged perpetrator within the
   * stage.
   *
   * @param idStage
   * @return keys idPerson, cdAllegDisposition
   */

  List<Map<String, Object>> findAllegationIdPerp(int idStage);

  /**
   * Updates table Allegation, field cdAllegDisposition given idAllegation and dtLastUpdate.<p/>
   *
   * @param idAllegation
   * @param dtLastUpdate
   */
  int updateCdAllegDispositionByIdAllegationAndDtLastUpdate(int idAllegation, Date dtLastUpdate);

  /**
   * Updates table Allegation, fields cdAllegDisposition and cdAllegSeverity given idAllegation and dtLastUpdate.<p/>
   *
   * @param idAllegation
   * @param dtLastUpdate
   * @param cdAllegDisposition
   * @param cdAllegSeverity
   */
  int updateCdAllegDispositionAndCdAllegSeverity(int idAllegation, Date dtLastUpdate, String cdAllegDisposition,
                                                 String cdAllegSeverity, String txtEvidenceSummary); 

  /**
   * This is an  update/insert for Allegation info.
   *
   * @param allegation
   */

  void saveAllegation(Allegation allegation);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Allegation} object.
   *
   * @param allegation
   */
  void deleteAllegation(Allegation allegation);

  /**
   * Delete an allegation row
   *
   * @param idAllegation
   * @param dtLastUpdate
   * @return
   */
  int deleteAllegation(int idAllegation, Date dtLastUpdate);

  /**
   * Updates table Allegation, field idAllegedPerpetrator given idPersMergeClosed and idStage.<p/>
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  int updateAllegationIdAllegedPerpetrator(int idPersMergeForward, int idPersMergeClosed, int idStage);

  int updateAllegationIdVictim(int idPersMergeForward, int idPersMergeClosed);//mxpatel added this for defect #10044

  List<Allegation> findAllegationByIdPersonClosedAsVictim(int idPersMergeClosed);//mxpatel added this for defect #10044
  
  
  /**
   *  STGAP00012833: This method returns Y if the child has been the victim of substantiated maltreatment  
   *  in the prior incident within the previous six months of the intake date from the current case.
   * @param idAllegedVictim
   * @param idCase
   * @return String
   */
  String findRecurrenceOfMaltreatment(int idAllegedVictim, int idCase);
  
  /**
   *  STGAP00012833: Retrieve the alleged victims for the stage
   * @param idStage
   * @return List<Integer>
   */
 List<Integer> findPersonByIdVictimByIdStage(int idStage);
 
 /**
  * STGAP00012833: Retrieve the alleged perpetrator for the stage
  * @param idStage
  * @param idVictim
  * @return List<Integer>
  */
 List<Integer> findpersonByIdAllegedPerpetratorByIdStage(int idStage, int idVictim);
 
 /**
  * STGAP00012833: Retrieve the alleged perpetrator for the victim
  * @param idVictim
  * @return List<Integer>
  */
 List<Integer> findpersonByIdAllegedPerpetratorByIdVictim(int idVictim);
 
 /**
  * Finds a list of Stages with allegation severity of Child Death, Near Fatality, or Serious Injury given a 
  * case id, type of stage and id of the victim 
  * @param idPerson
  * @param cdStageType
  * @param idCase
  * @return List<Map> 
  */
 public List<Map> findListOfCDNFSIAllgByIdPersonIdCaseCdStageTypeByCdStageType(int idPerson, Collection<Integer> idStages);
 
 
 /**
  *  STGAP00012833: Retrieve the alleged perpetrator for the stage and victim
  * @param idStage
  * @param idVictim
  * @return List<String>
  */

 List<String> findCdAllegTypeByIdStageIdVictim(int idStage, int idVictim); 
 
 /**
  *  STGAP00012833: Retrieve the cdAllegType for the victim
  * @param idVictim
  * @return List<String>
  */

 List<String> findCdAllegTypeByIdVictim(int idVictim);
 
 /** 
  * //STGAP00014667 : This method returns Y if the child has been the victim of substantiated maltreatment  in the prior incident
  * @param idStage
  * @return
  */
 // within the previous six months of the intake date from the current case.
 String findRecurrenceOfMaltreatmentFromMaterializedView(int idStage);
 /**
  * Get all the ID Victim for the given Stage from Allegation whose severity as Child Death
  * @param idStage
  * @return
  */
 List<Allegation> findIdVictimByIdStageWithSevAsChildDeath(int idStage);
 /**
  * Get count of Allegations in stage with Severity as Child Death/Near Fatality/Serious Injury
  * that does not have a Child Death/Near Fatality/Serious Injury reported event
  * @param idStage
  * @return long
  */
 BigDecimal countAllegationWithSevAsCDNFSIWithNoCNSEventByIdStage(int idStage);
 /**
  * Get count of Allegations with Severity of Near Fatality
  * @param idPerson
  * @return long
  */
 long countAllegationsWithSeverityNearFatalityByIdVictim(int idPerson);
 
 /**
  * MR-066 Find all allegations for the stage
  * @param idStage
  * @return
  */
 @SuppressWarnings({"unchecked"})
 List<Allegation> findAllegationsByIdStageForCPS(int idStage);
 
 /**
  * Find maltreatment types in a case given specific allegation disposition and maltreatment types
  * @param idCase
  * @param cdDisposition
  * @param cdMalTypeSet
  * @return maltreatment types
  */
 List<String> findByIdCaseCdDispositionCdMalType(int idCase, String cdDisposition, Collection<String> cdMalTypeSet);
 /**
  * STGAP00017987
  * Get count of Allegations in case with Severity as Child Death/Near Fatality/Serious Injury
  * that does not have a Child Death/Near Fatality/Serious Injury reported event
  * @param idCase
  * @return long
  */
 BigDecimal countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase(int idCase);
}
