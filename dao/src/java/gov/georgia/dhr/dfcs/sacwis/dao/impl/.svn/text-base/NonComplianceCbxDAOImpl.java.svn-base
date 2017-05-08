package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;
/**
 * This is the DAO that contains the SQL to save and retrieve NonComplianceCbx records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  06/19/08   ssubram   STGAP00006446: Initial code                
 * </pre>
 */
public class NonComplianceCbxDAOImpl extends BaseDAOImpl implements NonComplianceCbxDAO {

  public void deleteNonComplianceCbxByIdNonComplianceCbxType(int idNonCompliance, String cbxtype) {
    Query query = getSession().createQuery(
                                           " delete from NonComplianceCbx cbx "
                                                           + "       where cbx.nonCompliance.idNonCompliance = :idNonCompliance "
                                                           + "       and cbx.cdNonComplianceCbxType = :cbxtype");
    query.setInteger("idNonCompliance", idNonCompliance);
    query.setString("cbxtype", cbxtype);
    query.executeUpdate();    
  }
  public void deleteNonComplianceCbxByIdNonCompliance(int idNonCompliance) {
    Query query = getSession().createQuery(
                                           " delete from NonComplianceCbx cbx "
                                                           + "       where cbx.nonCompliance.idNonCompliance = :idNonCompliance " );
    query.setInteger("idNonCompliance", idNonCompliance);
    query.executeUpdate();    
  }
  @SuppressWarnings( { "unchecked" })
  public List<NonComplianceCbx> findNonCompliancecheckboxbyIdNonComplianceandCbxCodeType(int idNonCompliance,
                                                                                         String cdCbxType) {
    Query query = getSession().createQuery(
                                           " from  NonComplianceCbx cbx " + " where cbx.nonCompliance.idNonCompliance = :idNonCompliance "
                                                           + " and cbx.cdNonComplianceCbxType = :cdCbxType");

    query.setInteger("idNonCompliance", idNonCompliance);
    query.setString("cdCbxType", cdCbxType);
    return (List<NonComplianceCbx>) query.list();
  }

  public void saveNonComplianceCbx(NonComplianceCbx nonComplianceCbx) {
    getSession().saveOrUpdate(nonComplianceCbx);
  }

}
