package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   02/28/2011  htvo              SMS#97845 MR-074-2 AFCARS: added findIdPersonsByCdSecurityClassName to find all 
 *                                 person sharing the same security profile                                 
 */

public class EmpSecClassLinkDAOImpl extends BaseDAOImpl implements EmpSecClassLinkDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson) {
    Query query =
            getSession().createQuery("select new map (l.securityClass.cdSecurityClassName as cdSecurityClassName, " +
                                     "                s.txtSecurityClassProfil as txtSecurityClassProfil) " +
                                     "  from EmpSecClassLink l, " +
                                     "       SecurityClass s " +
                                     " where l.person.idPerson = :idPerson " +
                                     "   and l.securityClass.cdSecurityClassName = s.cdSecurityClassName");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<EmpSecClassLink> findEmpSecClassLinkSecurityClassbyIdPerson(int idPerson) {
    Query query = getSession().createQuery("      from EmpSecClassLink l " +
                                           "join fetch l.securityClass c " +
                                           "     where l.person.idPerson = :idPerson " +
                                           "  order by l.securityClass.cdSecurityClassName");
    query.setInteger("idPerson", idPerson);
    return (List<EmpSecClassLink>) query.list();
  }
  // this is your first attemt
  @SuppressWarnings({"unchecked"})
  public Long findEmpSecClassLink(String cdSecurityClassName) {
    Query query = getSession().createQuery("select count(*)" +
                                           "from EmpSecClassLink e " +
                                           "where e.securityClass.cdSecurityClassName = :cdSecurityClassName");
  query.setString("cdSecurityClassName", cdSecurityClassName);
    return (Long) query.uniqueResult();
  }
  
  public void saveEmpSecClassLink(EmpSecClassLink empSecClassLink) {
    getSession().saveOrUpdate(empSecClassLink);
  }

  public int deleteEmpSecClassLink(int idEmpSecLink, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete EmpSecClassLink " +
                                           " where idEmpSecLink = :idEmpSecLink " +
                                           "   and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idEmpSecLink", idEmpSecLink);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int deleteEmpSecClassLinkByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" delete from EmpSecClassLink " +
                                           "       where person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
  
  public List<Integer> findIdPersonsByCdSecurityClassName(String cdSecurityClassName) {
	  Query query = getSession().createQuery("select l.person.idPerson " +
	  		"from EmpSecClassLink l " +
	  		"where l.securityClass.cdSecurityClassName = :cdSecurityClassName ");
	  query.setString("cdSecurityClassName", cdSecurityClassName);
	  return (query.list() == null ? new ArrayList<Integer>() : (List<Integer>)query.list());
  }
}
