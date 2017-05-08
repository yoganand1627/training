package gov.georgia.dhr.dfcs.sacwis.dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

/**
 * DAO for gov.georgia.dhr.dfcs.sacwis.web.person.PersonConversation
 * <p/>
 * Change History: Date      User         Description --------  -----------  ----------------------------------------------
 * 12/01/03  dejuanr      SIR 19870 - Modifed results set to be type forward. 07/02/04  demoma       Sir22875 - add if
 * to create empty bean not a null
 */
public class AddressDao extends BaseDao {
  public static final String TRACE_TAG = "AddressDao";
  protected static final String SQL_MAX_DATE = " '12/31/4712' ";
  protected static final String INTAKE = "INT";
  //
  protected static final String TRUE = "Y";

  // Database column names
  public static final String NM_PERSON_FULL_COLUMN = "NM_PERSON_FULL";
  public static final String ID_PERSON_COLUMN = "ID_PERSON";
  public static final String ADDR_PERS_ADDR_ST_LN_1_COLUMN = "ADDR_PERS_ADDR_ST_LN_1";
  public static final String ADDR_PERS_ADDR_ST_LN_2_COLUMN = "ADDR_PERS_ADDR_ST_LN_2";
  public static final String ADDR_PERSON_ADDR_CITY_COLUMN = "ADDR_PERSON_ADDR_CITY";
  public static final String CD_PERSON_ADDR_STATE_COLUMN = "CD_PERSON_ADDR_STATE";
  public static final String CD_PERSON_ADDR_COUNTY_COLUMN = "CD_PERSON_ADDR_COUNTY";
  public static final String ADDR_PERSON_ADDR_ZIP_COLUMN = "ADDR_PERSON_ADDR_ZIP";
  public static final String IND_PERS_ADDR_LINK_PRIMARY_COLUMN = "IND_PERS_ADDR_LINK_PRIMARY";
  public static final String IND_PERS_ADDR_LINK_INVALID_COLUMN = "IND_PERS_ADDR_LINK_INVALID";
  public static final String CD_PERS_ADDR_LINK_TYPE_COLUMN = "CD_PERS_ADDR_LINK_TYPE";
  public static final String ADDR_PERSON_ADDR_ATTN_COLUMN = "ADDR_PERSON_ADDR_ATTN";
  public static final String DT_PERS_ADDR_LINK_START_COLUMN = "DT_PERS_ADDR_LINK_START";
  public static final String STAGE_ID_COLUMN = "ID_STAGE";
  public static final String STAGE_CODE_COLUMN = "STAGE_CODE";

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public AddressDao(Connection connection) {
    super(connection);
  }

  /** Returns all the active addresses for people attached to a stage. */
  public AddressValueBean getActiveAddressForStage(AddressValueBean searchBean) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getActiveAddressForStage");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();
    Integer id = (searchBean.getStageId());
    GrndsTrace.msg(TRACE_TAG, 10, "id_in_sql_is: \n" + id);
    try {
      StringBuffer sql = new StringBuffer();
      sql.append("select distinct * from ( ");
      sql.append("select ");
      sql.append(" person.NM_PERSON_FULL, ");
      sql.append(" person.ID_PERSON, ");
      sql.append(" person_address.ADDR_PERS_ADDR_ST_LN_1, ");
      sql.append(" person_address.ADDR_PERS_ADDR_ST_LN_2, ");
      sql.append(" person_address.ADDR_PERSON_ADDR_ATTN, ");
      sql.append(" person_address.ADDR_PERSON_ADDR_CITY, ");
      sql.append(" person_address.CD_PERSON_ADDR_STATE, ");
      sql.append(" person_address.CD_PERSON_ADDR_COUNTY, ");
      sql.append(" person_address.ADDR_PERSON_ADDR_ZIP, ");
      sql.append(" address_person_link.IND_PERS_ADDR_LINK_PRIMARY, ");
      sql.append(" address_person_link.IND_PERS_ADDR_LINK_INVALID, ");
      sql.append(" address_person_link.CD_PERS_ADDR_LINK_TYPE ");
      sql.append(" from stage_person_link, ");
      sql.append("      person_address, ");
      sql.append("      person, ");
      sql.append("      address_person_link ");
      sql.append("where stage_person_link.ID_STAGE = ? ");
      bindVariablesVector.add(id);
      sql.append(" and stage_person_link.ID_PERSON = person.ID_PERSON ");
      sql.append(" and stage_person_link.ID_PERSON = address_person_link.ID_PERSON ");
      sql.append(" and address_person_link.ID_PERSON_ADDR = person_address.ID_PERSON_ADDR ");
      sql.append(" and stage_person_link.IND_STAGE_PERS_PR_SEC_ASGN = 'N' ");
      sql.append(" and address_person_link.IND_PERS_ADDR_LINK_INVALID = 'N' ");
      sql.append(" and address_person_link.DT_PERS_ADDR_LINK_END > SYSDATE ");
      sql.append(")");
      GrndsTrace.msg(TRACE_TAG, 10, "The Address DAO SQL is " + sql);

      if (searchBean.getStageCode().compareToIgnoreCase(INTAKE) == 0) {
        sql.append("UNION ");
        sql.append("select ");
        sql.append(" incoming_person.NM_INCMG_PERS_FULL, ");
        sql.append(" stage_person_link.ID_PERSON, ");
        sql.append(" incoming_address.ADDR_INCMG_ADDR_ST_LN_1, ");
        sql.append(" incoming_address.ADDR_INCMG_ADDR_ST_LN_2, ");
        sql.append(" incoming_address.ADDR_INCMG_ADDR_ATTN, ");
        sql.append(" incoming_address.ADDR_INCMG_ADDR_CITY, ");
        sql.append(" incoming_address.CD_INCMG_ADDR_STATE, ");
        sql.append(" incoming_address.CD_INCMG_ADDR_COUNTY, ");
        sql.append(" incoming_address.ADDR_INCMG_ADDR_ZIP, ");
        sql.append(" incoming_address.IND_INCMG_ADDR_PRIMARY, ");
        sql.append(" incoming_address.IND_INCMG_ADDR_INVALID, ");
        sql.append(" incoming_address.CD_INCMG_ADDR_TYPE ");
        sql.append(" from stage_person_link, ");
        sql.append("      incoming_address, ");
        sql.append("      incoming_person ");
        sql.append("where stage_person_link.ID_STAGE = ?");
        bindVariablesVector.add(id);
        sql.append(" and stage_person_link.ID_PERSON = incoming_person.ID_PERSON ");
        sql.append(" and stage_person_link.ID_STAGE = incoming_person.ID_STAGE ");
        sql.append(" and incoming_person.ID_INCMG_PERSON = incoming_address.ID_INCMG_PERSON ");
        sql.append(" and stage_person_link.IND_STAGE_PERS_PR_SEC_ASGN = 'N' ");
        sql.append(" and incoming_address.IND_INCMG_ADDR_INVALID = 'N' ");
        sql.append(" and incoming_address.DT_INCMG_ADDR_END  > SYSDATE ");
      }

      sql.append(" order by 1, 10 desc, 12 ");

      GrndsTrace.msg(TRACE_TAG, 7,
                     "id_stage: " + searchBean.getStageId() + "\n" +
                     "cd_stage: " + searchBean.getStageCode() + "\n" +
                     "sql: \n" + sql);

      Connection connection = super.getConnection();
      GrndsTrace.msg(TRACE_TAG, 10, "bindVariablesVector_is:\n" + bindVariablesVector.toString());

      preparedStatement = connection.prepareStatement(sql.toString(),
                                                      ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      GrndsTrace.msg(TRACE_TAG, 10, "preparedStatement_is " + preparedStatement.toString());

      performanceTrace.getElapsedTime();

      ResultSet resultSet = preparedStatement.executeQuery();

      performanceTrace.getElapsedTime(" Time for SQL execution.");

      AddressValueBean returnBean = null;
      List<AddressValueBean> vector = new ArrayList<AddressValueBean>();
      int i = 0;

      // Sir22875  If result set is null create empty bean
      if (!resultSet.isBeforeFirst()) {
        returnBean = new AddressValueBean();
      }

      while (resultSet.next()) {
        returnBean = new AddressValueBean(resultSet);
        GrndsTrace.msg(TRACE_TAG, 10, "returnBean.getPrimary()_is " + returnBean.getPrimary());
        vector.add(returnBean);
        i++;
      }
      returnBean.setAddresses(vector);
      GrndsTrace.msg(TRACE_TAG, 7, "i_counter_is " + i);
      return returnBean;
    }
    finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }
}
