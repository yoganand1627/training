package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;

import java.util.Map;

public interface AdoNewNameDAO{
  
  /**
   * Gets the New Name record for the given stage
   */
  @SuppressWarnings( { "unchecked" })
  public Map findNameByStage(int idStage);
  
  /**
   * Inserts a temp new New Name record for that stage when the user saves a Close Adoption Stage page
   */
  public int insertAdoNewName(int idStage, String nmFirst, String nmLast, String nmMiddle);
  
  /**
   * Updates a new name record when the user modifies the Close Adoption Stage page
   */
  public int updateAdoNewName(int idStage, String nmFirst, String nmLast, String nmMiddle);
  
  /**
   * This method returns the AdoNewName for an stage
   * @param idStage
   * @return
   */
  AdoNewName findAdoNewNameByIdStage(int idStage);
  
  /**
   * This saves the info in AdoNewName Table
   * @param adoNewName
   */
  void saveOrUpdateAdoNewName(AdoNewName adoNewName);
  
  /** 
   * //STGAP00014341: Delete AdoNewName
   * @param idStage
   * @return
   */
  int deleteAdoNewNameByIdStage(int idStage);
}

