package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChild;
/**
 * This is the DAO that contains the SQL to save and retrieve NonComplianceChild records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  06/19/08   ssubram   STGAP00006446: Initial code                
 * </pre>
 */
public class NonComplianceChildDAOImpl extends BaseDAOImpl implements NonComplianceChildDAO {

  public void deleteNonComplianceChildByIdNonCompliance(int idNonCompliance) {
    Query query = getSession()
                              .createQuery(
                                           " delete from NonComplianceChild child "
                                                           + " where child.nonCompliance.idNonCompliance = :idNonCompliance ");
    query.setInteger("idNonCompliance", idNonCompliance);
    query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public List<NonComplianceChild> findNonComplianceChildbyIdNonCompliance(int idNonCompliance) {
    Query query = getSession()
                              .createQuery(
                                           " from  NonComplianceChild child "
                                                           + " where child.nonCompliance.idNonCompliance = :idNonCompliance ");

    query.setInteger("idNonCompliance", idNonCompliance);
    return (List<NonComplianceChild>) query.list();
  }

  public void saveNonComplianceChild(NonComplianceChild nonComplianceChild) {
    getSession().saveOrUpdate(nonComplianceChild);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findChildrenInViolation(int idNonCompliance) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                           + " p.cdPersonSex as cdPersonSex, "
                                                           + " p.dtPersonBirth as dtPersonBirth, "
                                                           + " ncc.indAdoptiveProcess as indAdoptiveProcess) "
                                                           + " from NonComplianceChild ncc inner join ncc.person p "
                                                           + " where ncc.indHomeViolation = 'Y' "
                                                           + " and ncc.nonCompliance.idNonCompliance = :idNonCompliance");
    query.setInteger("idNonCompliance", idNonCompliance);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findChildrenInNonCompliance(int idNonCompliance) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                          + " p.idPerson as idPerson, "
                                                           + " p.cdPersonSex as cdPersonSex, "
                                                           + " p.dtPersonBirth as dtPersonBirth, "
                                                           + " ncc.indAdoptiveProcess as indAdoptiveProcess, "
                                                           + " ncc.indHomeViolation as indHomeViolation) "
                                                           + " from NonComplianceChild ncc inner join ncc.person p "
                                                           + " where ncc.nonCompliance.idNonCompliance = :idNonCompliance");
    query.setInteger("idNonCompliance", idNonCompliance);
    return (List<Map>) query.list();
  }  
  
  
}
