package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;

public class PersonUtilityDao extends BaseDao {
  public static final String TRACE_TAG = "PersonUtilityDao";

  /** @param connection The connection object. */
  public PersonUtilityDao(Connection connection) {
    super(connection);
  }

  /**
   * Returns true if given person exists in at least one given stage program
   *
   * @param personId id of the person
   * @param hashSet  set of programs to check for person in
   */
  public boolean isPersonInOneOfThesePrograms(int personId, Set<String> hashSet) throws SQLException {
    if (hashSet.isEmpty()) {
      return false;
    }
    String setString = SqlHelper.toSetString(hashSet);
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select link.id_person \n" +
                                                      "from   stage_person_link link, \n" +
                                                      "       stage\n" +
                                                      "where  stage.id_stage = link.id_stage \n" +
                                                      "and    link.id_person = ?\n" +
                                                      "and    stage.cd_stage_program in (" + setString + ") \n");
      preparedStatement.setInt(1, personId);
      SqlHelper.setCollection(preparedStatement, 2, hashSet);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    long outputPersonId = SqlHelper.selectLong(preparedStatement);
    return (outputPersonId != 0);
  }
}
