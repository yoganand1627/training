package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Relationship;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* Change History:
* Date        User              Description
* --------    ----------------  --------------------------------------------------
* 05/25/2010  mxpatel           SMS#50561: added method deleteRelationshipByIdPerson
* 09/27/2011  schoi             STGAP00017013: MR-095 Added method findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship
* 10/01/0211  schoi             STGAP00017013: MR-095 Added method findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship
* </pre>
*/


public interface RelationshipDAO {

  /**
   * Selects id_person_relate from the relationship table passing in the id_person and cdPersonRelationship as a
   * parameter. Ex: (cdPersonRelationship = 'SC') = Secondary Caregiver. (cdPersonRelationship = 'PF') = Putative
   * Father. (cdPersonRelationship = 'LF') = Legal Father. (cdPersonRelationship = 'BF') = Biological Father.
   *
   * @param idPerson
   * @param cdPersonRelationship
   * @return id_person_relate from the relationship table.
   */
  Integer findRelationshipIdRelatedPersonByIdPerson(int idPerson, String cdPersonRelationship);

  /**
   * Selects idRelationship from the relationship table passing in the id_person and cdPersonRelationship as a
   * parameter. Ex: (cdPersonRelationship = 'SC') = Secondary Caregiver. (cdPersonRelationship = 'PF') = Putative
   * Father. (cdPersonRelationship = 'LF') = Legal Father. (cdPersonRelationship = 'BF') = Biological Father.
   *
   * @param idPerson
   * @param cdPersonRelationship
   * @return idRelationship from the relationship table.
   */
  Integer findRelationshipIdRelationship(int idPerson, String cdPersonRelationship);

  /**
   * This will insert into the relationship table passing in the idPerson, idRelatePerson, and cdPersonRelationship as a
   * parameter.
   *
   * @param idRelationship
   * @param idPerson
   * @param idRelatePerson
   * @param cdPersonRelationship
   * @return int
   */
  int saveRelationship(int idRelationship, int idPerson, int idRelatePerson, String cdPersonRelationship);
  
  /**
   * This will delete from the relationship table the row selected by the primary key idRelationship
   * parameter.
   *
   * @param idRelationship
   */
  void deleteRelationship(int idRelationship); 
  
  /**
   * This selects multiple rows from Relationship given idPerson.
   * 
   * @param idPerson
   * @param dteffdate
   * @return
   */
  List<Relationship> findRelationshipByIdPerson(int idPerson, Date dteffdate);
  
  /**
   * This method returns the related to person for a child
   * @param idPerson
   * @return
   */
  List<Relationship> findRelationshipByIdChildPerson(int idPerson);
  
  /**
   * This method returns all the children related to the realted person
   * @param idRelatedToPerson
   * @return
   */
  List<Relationship> findRelationshipByIdRelatedToPerson(int idRelatedToPerson);
  
  /**
   * This method updates the RelatedPerson in a person merge.
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return 
   */
  int updateRelatedPersonforPersonMerge(int idPersMergeForward, int idPersMergeClosed);
  void deleteRelationshipByIdPerson(int idPerson);
  List<Integer> findIdRelationshipsByStage(int idStage, int idPerson);

  // STGAP00017013: MR-095
  /**
   * This method returns all the related person related to the children by idStage and by idPerson
   * 
   * @param idStage
   * @param idPerson
   * @param cdPersonRelationship
   * @return
   */
  List<Relationship> findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship(int idStage, int idPerson,
                                                                                 List<String> cdPersonRelationship);

  // STGAP00017013: MR-095
  /**
   * This method returns all the related person related to the children 
   * 
   * @param idPerson
   * @param idRelatedPerson
   * @param cdPersonRelationship
   * @return
   */
  List<Relationship> findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship(int idPerson,
                                                                                      int idRelatedPerson,
                                                                                      List<String> cdPersonRelationship);
}
