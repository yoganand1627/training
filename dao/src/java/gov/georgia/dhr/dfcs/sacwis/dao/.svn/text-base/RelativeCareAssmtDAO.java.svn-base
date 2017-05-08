package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;

import java.util.Collection;
import java.util.Map;

public interface RelativeCareAssmtDAO {

  /**
   * Returns RelativeCareAssmnt by primary key.
   * 
   * @param idEvent
   * @return
   */
  public RelativeCareAssmt findRelativeCareAssmtByIdEvent(int idEvent);

  /**
   * Inserts or updates a RelativeCareAssessment
   * 
   * @param rcaSI
   */
  public void saveOrUpdateRelativeCareAssmt(RelativeCareAssmt rcaSI);

  /**
   * Deletes RCA based on idEvent.
   * 
   * @param idEvent
   */
  public void deleteRelativeCareAssmtByIdEvent(int idEvent);

  /**
   * Returns a list of data from RelativeCareAssmt, StagePersonLink, RelativeCareAssmtPerson. If given a stage id and a
   * person id, it returns a relativeRiskAssmt if a person listed on the relativeRiskAssmtPerson matches the given
   * idPerson and if the relativeRiskAssmt is an approved one
   * 
   * @param idStage
   * @param idPerson
   * @return List<Map>
   */
  Map findRelativeCareAssmtByIdStageByIdPerson(int idStage, int idPerson);

  /**
   * Returns a list of data from RelativeCareAssmt, StagePersonLink, RelativeCareAssmtPerson. If given a stage id, it
   * returns a relativeRiskAssmt if the relativeRiskAssmt is an approved one and returns only the caregiver related
   * information
   * 
   * @param idStage
   * @return List<Map>
   */
  Map findRelativeCareAssmtByIdStage(int idStage);
  
  /**
   * Returns a list of data from RelativeCareAssmt, StagePersonLink, RelativeCareAssmtPerson. If given a stage id, 
   * and a list of relationships, it
   * returns a relativeRiskAssmt if the relativeRiskAssmt is an approved one and returns only the caregiver related
   * information
   * 
   * @param idStage
   * @return List<Map>
   */
  Map findRelativeCareAssmtByIdStageBycdPersonType(int idStage, Collection<String> relativeCodes);
  
  /**
   * Find approved relative care for primary child in subcare by care resource and stage id.
   * Returns a RelativeCareAssmt that is approved and has an idResource that matches the idPerson passed in
   * done in the stage passed in 
   * @param idPerson
   * @param idStage
   * @return
   */
  //STGAP00007630: Modified this method to retrieve the approved relative care assessment for the given stage 
  //which has the child listed as a 'Child to be placed'.
  RelativeCareAssmt findRelativeApprvByIdStage(int idPerson, int idStage, String personType);

  /**
   * Returns a RelativeCareAssmt that is approved and has an idResource that matches the idPerson passed in.
   * 
   * @param idPerson
   * @return
   */
  RelativeCareAssmt findRelativeApprv(int idPerson);
  
  //SMS#108265
  /**
   * 
   * @param idStage
   * @return
   */
  public RelativeCareAssmt findRelativeAssmtApprv( int idStage );

}
