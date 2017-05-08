package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;

import java.util.Date;
import java.util.List;

public interface  ExcChildAdoInfoCbxDAO{
 /**
  * Inserts or updates the ExcChildAdoInfoCbx record
  * @param excChildAdoInfoCbx
  */
  void saveExcChildAdoInfoDetail(ExcChildAdoInfoCbx excChildAdoInfoCbx);
  
  /**
   * Gets the list of ExcChildAdoInfoCbx records for the given event Id.
   * @param idChildRegEvent
   * @return
   */
  List<ExcChildAdoInfoCbx> findExcChildAdoInfoByIdEventByCdInfoCbx(int idChildRegEvent, String cdAdoInfoCbxType);
  
  /**
   * retrieve the list of ExcChildAdoInfoCbx records for the given event Id.
   * @param idChildRegEvent
   * @return
   */
  List<ExcChildAdoInfoCbx> retrieveExcChildAdoInfoByIdEvent(int idChildRegEvent);
  
  /**
   * Deletes the record 
   * @param idEvent
   * @param cdAdoInfoCbx
   * @param dtPerformed
   */
  void deleteExcChildAdoinfoDetail(int idEvent, String cdAdoInfoCbx, Date dtPerformed);
  
  /**
   * Deletes the record by primary key
   * @param idInfoChar
   */
  void deleteExcChildAdoInfoCbx(int idInfoChar);
}