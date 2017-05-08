package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Person Race Ethinicty Dao</p> <p>Retrieve Race/Ethinicty from the Incoming Race and Ethinicity Tables. This
 * DAO was created for SIR's 22534 and 22693.</p> <p>Copyright: Copyright (c) 2004</p> <p>Company: Accenture</p>
 *
 * @author Rodrigo DeJuana
 * @version 1.0
 */

public class PersonRaceEthnicityDao extends BaseDao {
  private static final String TRACE_TAG = "PersonRaceEthnicityDao";

  public static final String ETHNICITY = "CD_ETHNICITY";
  public static final String ETHNIC_GROUP = "CD_PERSON_ETHNIC_GROUP";
  public static final String RACE = "CD_RACE";

  public PersonRaceEthnicityDao(Connection connection) {
    super(connection);
  }

  public String queryPersonEthnicity(int idPerson) throws NoDataReturnedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPersonEthnicity");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Integer> bindVariablesArrayList = new ArrayList<Integer>();
    try {
      Connection connection = super.getConnection();
      String sqlIncomingDetail = "SELECT CD_ETHNICITY FROM INCOMING_ETHNICITY WHERE ID_PERSON = ? ";
      bindVariablesArrayList.add(idPerson);
      preparedStatement = connection.prepareStatement(sqlIncomingDetail);
      addBindVariablesToStatement(preparedStatement, bindVariablesArrayList);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {

        return resultSet.getString(ETHNICITY);
      } else {
        return "";
      }
    }
    catch (SQLException ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }

  }

  public RaceEthnicityBean queryPersonRace(int idPerson, RaceEthnicityBean reb) throws NoDataReturnedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPersonEthnicity");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Integer> bindVariablesArrayList = new ArrayList<Integer>();
    RaceEthnicityBean.Races races = new RaceEthnicityBean.Races();
    try {
      //get the connection
      Connection connection = super.getConnection();
      String sqlIncomingDetail = "SELECT CD_RACE FROM INCOMING_RACE WHERE ID_PERSON = ? ";
      bindVariablesArrayList.add(idPerson);
      preparedStatement = connection.prepareStatement(sqlIncomingDetail);
      addBindVariablesToStatement(preparedStatement, bindVariablesArrayList);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        races.put(resultSet.getString(RACE), "A");
      }
      reb.setRaces(races);
    }
    catch (SQLException ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return reb;
  }

}