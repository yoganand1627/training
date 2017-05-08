package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.sql.Connection;
import java.util.Set;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;

/**
 * PersonUtility EJB.
 *
 * @see PersonUtilityDao
 */
public class PersonUtilityBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "PersonUtilityBean";

  /** @see PersonUtilityDao */
  public boolean isPersonInOneOfThesePrograms(int personId, Set<String> hashSet) {
    GrndsTrace.enterScope(TRACE_TAG + ".isPersonInOneOfThesePrograms");
    Connection connection = null;
    try {
      connection = getConnection();
      PersonUtilityDao dao = new PersonUtilityDao(connection);
      return dao.isPersonInOneOfThesePrograms(personId, hashSet);
    }
    catch (Throwable e) {
      throw new RuntimeWrappedException(e);
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** @see PersonUtilityDao */
  public RaceEthnicityBean getPersonRaceEthnicity(int personId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPersonRaceEthnicity");
    Connection connection = null;
    RaceEthnicityBean reb = new RaceEthnicityBean();
    try {
      connection = getConnection();
      PersonRaceEthnicityDao dao = new PersonRaceEthnicityDao(connection);
      String ethnicity = dao.queryPersonEthnicity(personId);
      reb.setEthnicity(ethnicity);
      reb = dao.queryPersonRace(personId, reb);
    }
    catch (Throwable e) {
      throw new RuntimeWrappedException(e);
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
    return reb;
  }

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
