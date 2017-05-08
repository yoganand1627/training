/**
 *  This is the DAO class is used for the ICPC_ENCLOSED_DOC_CBX table
 */
 
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.IcpcEnclosedDocCbx;

import java.util.List;

/**
 * @author ashwini.rege
 *
 */
public interface IcpcEnclosedDocCbxDAO {
  
  public  List<String> findSavedCbxByIdIcpcDetailAndCdCbxCodeType(String cdCbxCodeType, int idIcpcDetail);

  public void saveOrUpdateEnclosedDocCbx(IcpcEnclosedDocCbx icpcEnclosedDocCbx);
    
  public int deleteEnclosedDocCbx (String cdEnclDoc, String cdCbxCodeType, int idIcpcDetail);

  public int deleteEnclosedDocCbxByIcpcDetailAndCdCbxCodeType(String cdCbxCodeType, int idIcpcDetail);

}
