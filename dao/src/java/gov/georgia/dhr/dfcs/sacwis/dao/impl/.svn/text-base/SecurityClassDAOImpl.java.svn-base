package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.SecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;
import org.hibernate.Query;

public class SecurityClassDAOImpl extends BaseDAOImpl implements SecurityClassDAO {
  @SuppressWarnings({"unchecked"})
  public List<SecurityClass> findListAllSecurityClasses() {
    Query query = getSession().createQuery(" from SecurityClass s" +
                                           " order by s.cdSecurityClassName");
    return (List<SecurityClass>) query.list();
  }

  public void saveSecurityClass(SecurityClass securityClass) {
    getSession().saveOrUpdate(securityClass);

  }

public int updateSecurityClass(String txtSecurityClassProfil, String cdSecurityClassName, String indRestrict,
                                 String cdEmpSecurityClassName, Date dtLastUpdate) {
    Query query = getSession().createQuery("update SecurityClass" +
                                           "    set txtSecurityClassProfil = :txtSecurityClassProfil," +
                                           "        cdSecurityClassName = :cdSecurityClassName," +
                                           "        indRestrict = :indRestrict" +
                                           "  where cdSecurityClassName = :cdEmpSecurityClassName" +
                                           "    and dtLastUpdate = :dtLastUpdate");
    query.setString("txtSecurityClassProfil", txtSecurityClassProfil);
    query.setString("cdSecurityClassName", cdSecurityClassName);
    query.setString("indRestrict", indRestrict);
    query.setString("cdSecurityClassName", cdSecurityClassName);
    query.setString("cdEmpSecurityClassName", cdEmpSecurityClassName);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
public int deleteSecurityClass(String cdSecurityClassName, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete from SecurityClass " +
                                           "  where cdSecurityClassName = :cdSecurityClassName" +
                                           "    and dtLastUpdate = :dtLastUpdate");
    query.setString("cdSecurityClassName", cdSecurityClassName);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public SecurityClass findSecurity(String cdSecurityClassName) {

    Query query = getSession().createQuery(" from SecurityClass " +
                                           "  where cdSecurityClassName = :cdSecurityClassName");
    query.setString("cdSecurityClassName", cdSecurityClassName);

    return (SecurityClass) firstResult(query);
  }
}
