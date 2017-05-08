/*
 * EmpTempAssignDAOImpl class
 * <p/>
 * <p/> 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   04/09/2008  amroberts         STGAP00006800 - Allows viewers to see records that expire from today on
 *   
 *   07/24/2008  alwilliams        STGAP00008071 - Added method countPersonByIdPersonDesigneeByPersonByIdPersonEmp
 *                                 to get the list of designees excluding any designees with expired date. 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import org.hibernate.Query;

public class EmpTempAssignDAOImpl extends BaseDAOImpl implements EmpTempAssignDAO {
  public long countPersonByIdPersonEmpByPersonByIdPersonDesignee(int idPerson, int idPersonDesignee) {
    Query query = getSession().createQuery("select count(personByIdPersonEmp.idPerson) " +
                                           "  from EmpTempAssign " +
                                           " where personByIdPersonDesignee.idPerson = :idPersonDesignee " +
                                           "   and personByIdPersonEmp.idPerson <> :idPerson");
    query.setInteger("idPersonDesignee", idPersonDesignee);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countPersonByIdPersonDesigneeByPersonByIdPersonEmp(int idPerson, int idPersonDesignee) {
    Query query = getSession().createQuery("select count(personByIdPersonDesignee.idPerson) " +
                                           "  from EmpTempAssign eta" +
                                           " where personByIdPersonEmp.idPerson = :idPerson " +
                                           "  and personByIdPersonDesignee.idPerson <> :idPersonDesignee " +
                                           "  and (eta.dtAssignExpiration >= sysdate - 1" +
                                           "  or eta.dtAssignExpiration is null)");
    query.setInteger("idPersonDesignee", idPersonDesignee);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<EmpTempAssign> findIdsTempAssignment(int idPerson) {
    Query query = getSession().createQuery(" from EmpTempAssign eta " +
                                           "where eta.personByIdPersonDesignee.idPerson = :idPerson " +
                                           "  and (eta.dtAssignExpiration >= sysdate - 1" +
                                           "  or eta.dtAssignExpiration is null)");

    query.setInteger("idPerson", idPerson);

    return (List<EmpTempAssign>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<EmpTempAssign> findIdsemp(int idPerson) {
    Query query = getSession().createQuery(" from EmpTempAssign eta " +
                                           "where eta.personByIdPersonEmp.idPerson = :idPerson " +
                                           "  and (eta.dtAssignExpiration >= sysdate - 1" +
                                           "  or eta.dtAssignExpiration is null)");
    
    query.setInteger("idPerson", idPerson);

    return (List<EmpTempAssign>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<EmpTempAssign> findIdsemp(int idPerson, String allEmpTempDesignees) {
    Query query = getSession().createQuery(" from EmpTempAssign eta " +
                                           "where eta.personByIdPersonEmp.idPerson = :idPerson ");
    
    query.setInteger("idPerson", idPerson);

    return (List<EmpTempAssign>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<EmpTempAssign> findEmpTempAssignmentDesignatorsByIdPerson(int idPerson) {
    Query query = getSession().createQuery("            from EmpTempAssign eta " +
                                           " join fetch eta.personByIdPersonEmp p " +
                                           "           where eta.personByIdPersonDesignee.idPerson = :idPerson " +
                                           "        order by p.nmPersonFull");

    query.setInteger("idPerson", idPerson);

    return (List<EmpTempAssign>) query.list();
  }

  public void saveEmpTempAssign(EmpTempAssign empTempAssign) {
    getSession().saveOrUpdate(empTempAssign);
  }
   
  public int deleteEmpTempAssignByIdPerson(int idPerson) {
    Query query = getSession().createQuery("delete EmpTempAssign " +
                                           " where personByIdPersonEmp.idPerson = :idPerson " +
                                           "    or personByIdPersonDesignee.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int deleteEmpTempAssign(int idEmpTempAssign, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete EmpTempAssign " +
                                           " where idEmpTempAssign = :idEmpTempAssign " +
                                           "   and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idEmpTempAssign", idEmpTempAssign);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
}
