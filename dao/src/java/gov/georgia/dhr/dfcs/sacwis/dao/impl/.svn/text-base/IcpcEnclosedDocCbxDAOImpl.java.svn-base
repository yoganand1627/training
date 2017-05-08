/**
 * This DAO implementation is used for ICPC_ENCLOSED_DOC_CBX table
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IcpcEnclosedDocCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcEnclosedDocCbx;

import java.util.List;

import org.hibernate.Query;

/**
 * @author ashwini.rege
 * Change History:
 *  Date        User              Description
 * --------    ----------------  ----------------------------------------------------------------
 * 01/30/2012   arege             STGAP00017827: MR-085   
 * 02/09/2012   arege             STGAP00017827: MR-085 Added new method deleteEnclosedDocCbxByIcpcDetailAndCdCbxCodeType
 */
public class IcpcEnclosedDocCbxDAOImpl extends BaseDAOImpl implements IcpcEnclosedDocCbxDAO{

  @SuppressWarnings( { "unchecked" })
  /**
   * Retrieves list of all cdEnclDoc for a given idIcpcDetail and cdCbxCodeType
   */
  public  List<String> findSavedCbxByIdIcpcDetailAndCdCbxCodeType(String cdCbxCodeType, int idIcpcDetail) {
    Query query = getSession().createQuery(" select edc.cdEnclDoc " +
                                           " from IcpcEnclosedDocCbx edc" +
                                           " where edc.icpcDetail.idIcpcDetail = :idIcpcDetail  " +
                                           " and edc.cdCbxCodeType = :cdCbxCodeType "); 
    query.setInteger("idIcpcDetail", idIcpcDetail);
    query.setString("cdCbxCodeType", cdCbxCodeType);
    return  (List<String>) query.list();
  }

  public void saveOrUpdateEnclosedDocCbx(IcpcEnclosedDocCbx icpcEnclosedDocCbx){
    getSession().saveOrUpdate(icpcEnclosedDocCbx);
  }
  
  /**
   * Deletes ICPC_ENCLOSED_DOC_CBX records for a given idIcpcDetail, cdEnclDoc and cdCbxCodeType
   */
  public int deleteEnclosedDocCbx (String cdEnclDoc, String cdCbxCodeType, int idIcpcDetail) {
    Query query = getSession().createSQLQuery("delete from ICPC_ENCLOSED_DOC_CBX edc" +
                                           "       where edc.CD_ENCL_DOC = :cdEnclDoc and" +
                                           "       edc.CD_CBX_CODE_TYPE = :cdCbxCodeType and " +
                                           "       edc.ID_ICPC_DETAIL  = :idIcpcDetail ");
    query.setString("cdEnclDoc", cdEnclDoc);
    query.setString("cdCbxCodeType", cdCbxCodeType);
    query.setInteger("idIcpcDetail", idIcpcDetail);
    return query.executeUpdate();
  }
  
  /**
   * Deletes records for a given cdCbxCodeType and idIcpcDetail
   */
  public int deleteEnclosedDocCbxByIcpcDetailAndCdCbxCodeType( String cdCbxCodeType, int idIcpcDetail) {
    Query query = getSession().createSQLQuery("delete from ICPC_ENCLOSED_DOC_CBX edc" +
                                              "       where  edc.CD_CBX_CODE_TYPE = :cdCbxCodeType and " +
                                              "       edc.ID_ICPC_DETAIL  = :idIcpcDetail ");
       query.setString("cdCbxCodeType", cdCbxCodeType);
       query.setInteger("idIcpcDetail", idIcpcDetail);
       return query.executeUpdate();
     }
}
