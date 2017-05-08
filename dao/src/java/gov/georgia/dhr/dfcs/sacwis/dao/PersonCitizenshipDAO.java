package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;

import java.util.List;


/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   06/16/2009   bgehlot          STGAP00014279: Added method findCheckboxByIdPerson
 *   
 */

public interface PersonCitizenshipDAO {


  /**
   * This selects the checkboxes for PersonCitizenship given idPerson and the checkbox type. <p/> 
   * 
   * @param idPerson
   * @param cdCbxType
   * @return List
   * 
   */
  List<PersonCitizenship> findCheckboxByIdPersonCbxCodeType(int idPerson, String cdCbxType);
  
  /**
   * Adds and updates row from the PersonCitizenship table
   * 
   * @param personCitizenship
   */
  void savePersonCitizenship(PersonCitizenship personCitizenship);
  
  
  
  /**
   * This Deletes the person citizenship Check Boxes
   *
   * @param idPerson Object.
   * @param cbxType type.
   */
  void deletePersonCitizenshipChkBxByIdPerson(int idPerson, String cbxType);
  
  /**
   * This finds PersonCitizenship by idPerson
   * @param idPerson
   * @return
   */
  Integer findPersonCitizenshipIdentityByIdPerson(int idPerson);

  /**
   * This will update row given idPerson, cdCbx, and cdCbxCodeType
   * @param idPerson
   * @param cdCbx
   * @param cdCbxCodeType
   * @return
   */
  int updatePersonCitizenship(int idPerson, String cdCbx, String cdCbxCodeType);
  
  /**
   * This will insert row given idPerson, cdCbx, and cdCbxCodeType
   * @param idPerson
   * @param cdCbx
   * @param cdCbxCodeType
   * @return
   */
  int insertPersonCitizenship(int idPerson, String cdCbx, String cdCbxCodeType);
  
  //STGAP00014279: Gets the person citizenship record for the person
  List<PersonCitizenship> findCheckboxByIdPerson(int idPerson);
  
 }
