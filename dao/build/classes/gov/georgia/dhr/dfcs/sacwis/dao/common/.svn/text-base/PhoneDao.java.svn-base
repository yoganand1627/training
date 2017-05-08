package gov.georgia.dhr.dfcs.sacwis.dao.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

/**
 * DAO for gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation that performs database transactions.
 *
 * @author Matthew McClain, March 1, 2003
 */
public class PhoneDao extends BaseDao {
  public static final String TRACE_TAG = "PhoneDao";
  protected static final String SQL_MAX_DATE = "to_date('12/31/4712', 'mm/dd/yyyy')";
  protected static final String INTAKE = "INT";
  /** @todo remove unnecessary comment */
  //!!! dup'd
  protected static final String TRUE = "Y";

  /**
   * Constructor.
   *
   * @param connection The connection object.
   */
  public PhoneDao(Connection connection) {
    super(connection);
  }

  /**
   * Returns all the active phones for people attached to a stage.
   *
   * @param stageId   The id of the stage.
   * @param stageCode The code representing the stage.
   */
  public List<PhoneDB> getActivePhonesForStage(int stageId, String stageCode) throws SQLException {
    String query = "select distinct * from (\n" +
                   "select \n" +
                   "       person_phone.ID_PERSON as personId,\n" +
                   "       person_phone.NBR_PERSON_PHONE_EXTENSION as extension,\n" +
                   "       person_phone.NBR_PERSON_PHONE as phoneNumber,\n" +
                   "       trunc(person_phone.DT_PERSON_PHONE_START) as startDate,\n" +
                   "       person_phone.IND_PERSON_PHONE_PRIMARY as primary,\n" +
                   "       person_phone.CD_PERSON_PHONE_TYPE as phoneType,       \n" +
                   "       person.NM_PERSON_FULL as personFullName\n" +
                   "from stage_person_link,\n" +
                   "     person_phone,\n" +
                   "     person\n" +
                   "where stage_person_link.ID_STAGE = ?\n" +
                   "  and stage_person_link.ID_PERSON = person.ID_PERSON\n" +
                   "  and stage_person_link.ID_PERSON = person_phone.ID_PERSON\n" +
                   "  and (stage_person_link.IND_STAGE_PERS_PR_SEC_ASGN = 'N'\n" +
                   "  or stage_person_link.IND_STAGE_PERS_PR_SEC_ASGN is null)\n" +
                   "  and person_phone.IND_PERSON_PHONE_INVALID = 'N'\n" +
                   "  and person_phone.DT_PERSON_PHONE_END = " + SQL_MAX_DATE + "\n";

    if (stageCode.equals(INTAKE)) {
      query += "UNION\n" +
               "select \n" +
               "       stage_person_link.ID_PERSON as personId,\n" +
               "       incoming_phone.NBR_INCMG_PHONE_EXTENSION as extension,\n" +
               "       incoming_phone.NBR_INCMG_PHONE as phoneNumber,\n" +
               "       trunc(incoming_phone.DT_INCMG_PHONE_START) as startDate,\n" +
               "       incoming_phone.IND_INCMG_PHONE_PRIMARY as primary,\n" +
               "       incoming_phone.CD_INCMG_PHONE_TYPE as phoneType,\n" +
               "       incoming_person.NM_INCMG_PERS_FULL as personFullName\n" +
               "from stage_person_link,\n" +
               "     incoming_phone,\n" +
               "     incoming_person\n" +
               "where stage_person_link.ID_STAGE = ?\n" +
               "  and stage_person_link.ID_PERSON = incoming_person.ID_PERSON\n" +
               "  and stage_person_link.ID_STAGE = incoming_person.ID_STAGE\n" +
               "  and incoming_person.ID_INCMG_PERSON = incoming_phone.ID_INCMG_PERSON\n" +
               "  and stage_person_link.IND_STAGE_PERS_PR_SEC_ASGN = 'N'\n" +
               "  and incoming_phone.IND_INCMG_PHONE_INVALID = 'N'\n" +
               "  and incoming_phone.DT_INCMG_PHONE_END = " + SQL_MAX_DATE + "\n";
    }

    query += ")\n" +
             "order by personFullName, primary desc, phoneNumber, extension\n";

    GrndsTrace.msg(TRACE_TAG, 7, "id_stage: " + stageId + "\n" +
                                 "cd_stage: " + stageCode + "\n" +
                                 "query: \n" + query);

    Connection connection = super.getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      List<PhoneDB> results = new ArrayList<PhoneDB>();
      statement = connection.prepareStatement(query);
      int i = 0;
      statement.setInt(++i, stageId);
      if (stageCode.equals(INTAKE)) {
        statement.setInt(++i, stageId);
      }
      resultSet = statement.executeQuery();

      while (resultSet.next()) {
        i = 0;
        PhoneDB phoneDB = new PhoneDB();
        phoneDB.setPersonId(resultSet.getInt(++i));
        phoneDB.setExtension(resultSet.getString(++i));
        phoneDB.setNumber(resultSet.getString(++i));
        phoneDB.setStartDate(resultSet.getDate(++i));
        phoneDB.setPrimary(resultSet.getString(++i).equals(TRUE));
        phoneDB.setPhoneType(resultSet.getString(++i));
        phoneDB.setPersonFullName(resultSet.getString(++i));
        results.add(phoneDB);
      }
      return results;
    }
    finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
    }
  }
}
