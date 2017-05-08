package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;

//import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Data Access Object class used to manage Risk Assessment data.
 * 
 * @author Jason Rios, October 11, 2002
 */
public class RiskAssmtDAO extends BaseDao {
  // Database column names
  // Columns from the RISK_FACTORS database table
  public static final String CASE_ID_COLUMN = "ID_CASE";

  public static final String STAGE_ID_COLUMN = "ID_STAGE";

  public static final String EVENT_ID_COLUMN = "ID_EVENT";

  public static final String FACTOR_ID_COLUMN = "ID_RISK_FACTOR";

  public static final String FACTOR_CODE_COLUMN = "CD_RISK_FACTOR";

  public static final String FACTOR_RESPONSE_COLUMN = "CD_RISK_FACTOR_RESPONSE";

  public static final String FACTOR_COMMENT_COLUMN = "TXT_RISK_FACTOR_COMMENT";

  public static final String FACTOR_DATE_LAST_UPDATE_COLUMN = "FACTOR_DT_LAST_UPDATE";

  // Columns from the RISK_FACTORS_LOOKUP database table
  public static final String FACTOR_TEXT_COLUMN = "TXT_FACTOR";

  public static final String AREA_CONCERN_TEXT_COLUMN = "AREA_CONCERN_TXT";

  public static final String FACTOR_SORT_ORDER_INDEX_COLUMN = "NBR_FACTOR_ORDER";

  public static final String REF_FACTOR_CODE_COLUMN = "CD_FACTOR";

  // Columns from the RISK_CATEGORY database table
  public static final String CATEGORY_ID_COLUMN = "ID_RISK_CATEGORY";

  public static final String CATEGORY_CODE_COLUMN = "CD_RISK_CATEG";

  public static final String CATEGORY_SCALE_OF_CONCERN_COLUMN = "CD_RISK_CATEG_CONCERN_SCALE";

  public static final String CATEGORY_DATE_LAST_UPDATE_COLUMN = "CATEG_DT_LAST_UPDATE";

  public static final String CATEGORY_TXT_RISK_CATEG_JUSTIFICATION = "TXT_RISK_CATEG_JUSTIFICATION";

  // Columns from the RISK_CATEGORY_LOOKUP database table
  public static final String CATEGORY_TEXT_COLUMN = "TXT_CATEGORY";

  public static final String CATEGORY_SORT_ORDER_INDEX_COLUMN = "NBR_CATEGORY_ORDER";

  public static final String REF_CATEGORY_CODE_COLUMN = "CD_CATEGORY";

  // Columns from the RISK_AREA database table
  public static final String AREA_ID_COLUMN = "ID_RISK_AREA";

  public static final String AREA_CODE_COLUMN = "CD_RISK_AREA";

  public static final String AREA_SCALE_OF_CONCERN_COLUMN = "CD_RISK_AREA_CONCERN_SCALE";

  public static final String AREA_DATE_LAST_UPDATE_COLUMN = "AREA_DT_LAST_UPDATE";

  public static final String AREA_TXT_RISK_AREA_JUSTIFICATION_COLUMN = "TXT_RISK_AREA_JUSTIFICATION";

  // Columns from the RISK_AREA_LOOKUP database table
  public static final String AREA_TEXT_COLUMN = "TXT_AREA";

  public static final String AREA_SORT_ORDER_INDEX_COLUMN = "NBR_AREA_ORDER";

  public static final String REF_AREA_CODE_COLUMN = "CD_AREA";

  // Columns from the RISK_ASSESSMENT database table
  public static final String RISK_ASSESSMENT_PURPOSE_COLUMN = "CD_RISK_ASSMT_PURPOSE";

  public static final String RISK_ASSESSMENT_FINDING_COLUMN = "CD_RISK_ASSMT_RISK_FIND";

  public static final String RISK_ASSESSMENT_DATE_LAST_UPDATE_COLUMN = "ASSMT_DT_LAST_UPDATE";

  public static final String RISK_ASSESSMENT_DATE_RESPONSE_COLUMN = "DT_RESPONSE";

  public static final String RISK_ASSESSMENT_IND_RESPONSE_COLUMN = "IND_RISK_ASSMT_RESPONSE";
  
  public static final String RISK_ASSESSMENT_CD_CURRENT_LVL_RISK_COLUMN = "CD_CURRENT_LVL_RISK";

  // Columns from the RISK_HISTORY_REPORT database table

  public static final String RISK_HISTORY_REPORT_DATE_OF_REPORT_COLUMN = "DT_REPORT";

  public static final String RISK_HISTORY_REPORT_DATE_OF_CLOSURE_COLUMN = "DT_CLOSURE";

  public static final String RISK_HISTORY_REPORT_CHLD_DEATH_INJ_COLUMN = "CB_RISK_HR_CHILD";

  public static final String RISK_HISTORY_REPORT_SUMMARY_COLUMN = "TXT_RISK_HR_SUMM";

  public static final String RISK_HISTORY_REPORT_ID_HISTORY_REPORT = "ID_RISK_HISTORY_REPORT";

  public static final String RISK_HISTORY_REPORT_DT_LAST_UPDATE = "RHRDTLASTUPDATE";

  // Columns from the RISK_INV_ACTIONS database table

  public static final String RISK_INV_ACTIONS_IND_RISK_IA_PARENTSGUIDE_COLUMN = "IND_RISK_IA_PARENTSGUIDE";

  public static final String RISK_INV_ACTIONS_DT_PARENTSGUIDE_COLUMN = "DT_PARENTSGUIDE";

  public static final String RISK_INV_ACTIONS_IND_RISK_IA_PARENTSINTERV_COLUMN = "IND_RISK_IA_PARENTSINTERV";

  public static final String RISK_INV_ACTIONS_DT_PARENTSINTERV_COLUMN = "DT_PARENTSINTERV";

  public static final String RISK_INV_ACTIONS_IND_RISK_IA_HIPPAINFO_COLUMN = "IND_RISK_IA_HIPPAINFO";

  public static final String RISK_INV_ACTIONS_IND_RISK_IA_HIPPASIGN_COLUMN = "IND_RISK_IA_HIPPASIGN";

  public static final String RISK_INV_ACTIONS_DT_HIPPASIGN_COLUMN = "DT_HIPPASIGN";

  public static final String RISK_INV_ACTIONS_COMMENTS_COLUMN = "TXT_RISK_IA_COMMENTS";

  public static final String RISK_INV_ACTIONS_DT_LAST_UPDATE_COLUMN = "RIA_DT_LAST_UPDATE";

  // Columns from the EVENT database table
  public static final String EVENT_DATE_LAST_UPDATE_COLUMN = "EVENT_DT_LAST_UPDATE";

  public static final String EVENT_STATUS_COLUMN = "CD_EVENT_STATUS";

  // Columns from the DUAL database table
  public static final String NEXTVAL_COLUMN = "NEXTVAL";

  // Columns from the RISK_ASSMT_FMLY_STR database table
  public static final String RISK_ASSESSMENT_FMLY_STR_CHILDVUL_COLUMN = "IND_RISK_AFS_CHILDVUL";

  public static final String RISK_ASSESSMENT_FMLY_STR_CHILDPROCTN_COLUMN = "CB_RISK_AFS_CHILDPROCTN";

  public static final String RISK_ASSESSMENT_FMLY_STR_CHILDBHVR_COLUMN = "CB_RISK_AFS_CHILDBHVR";

  public static final String RISK_ASSESSMENT_FMLY_STR_IND_CAREGIVCAP_COLUMN = "IND_RISK_AFS_CAREGIVCAP";

  public static final String RISK_ASSESSMENT_FMLY_STR_KNOWLEDGE_COLUMN = "CB_RISK_AFS_KNOWLEDGE";

  public static final String RISK_ASSESSMENT_FMLY_STR_CONTROL_COLUMN = "CB_RISK_AFS_CONTROL";

  public static final String RISK_ASSESSMENT_FMLY_STR_FUNCTNG_COLUMN = "CB_RISK_AFS_FUNCTNG";

  public static final String RISK_ASSESSMENT_FMLY_STR_QUALOFCARE_COLUMN = "IND_RISK_AFS_QUALOFCARE";

  public static final String RISK_ASSESSMENT_FMLY_STR_EMOCARE_COLUMN = "CB_RISK_AFS_EMOCARE";

  public static final String RISK_ASSESSMENT_FMLY_STR_PHYCARE_COLUMN = "CB_RISK_AFS_PHYCARE";

  public static final String RISK_ASSESSMENT_FMLY_STR_MALPATRN_COLUMN = "IND_RISK_AFS_MALPATRN";

  public static final String RISK_ASSESSMENT_FMLY_STR_CURSEVRTY_COLUMN = "CB_RISK_AFS_CURSEVRTY";

  public static final String RISK_ASSESSMENT_FMLY_STR_CHRONCTY_COLUMN = "CB_RISK_AFS_CHRONCTY";

  public static final String RISK_ASSESSMENT_FMLY_STR_TREND_COLUMN = "CB_RISK_AFS_TREND";

  public static final String RISK_ASSESSMENT_FMLY_STR_HOMENV_COLUMN = "IND_RISK_AFS_HOMENV";

  public static final String RISK_ASSESSMENT_FMLY_STR_STRESS_COLUMN = "CB_RISK_AFS_STRESS";

  public static final String RISK_ASSESSMENT_FMLY_STR_DANEXP_COLUMN = "CB_RISK_AFS_DANEXP";

  public static final String RISK_ASSESSMENT_FMLY_STR_SOCENV_COLUMN = "IND_RISK_AFS_SOCENV";

  public static final String RISK_ASSESSMENT_FMLY_STR_SOCCLI_COLUMN = "CB_RISK_AFS_SOCCLI";

  public static final String RISK_ASSESSMENT_FMLY_STR_SOCVIOL_COLUMN = "CB_RISK_AFS_SOCVIOL";

  public static final String RISK_ASSESSMENT_FMLY_STR_RESPINT_COLUMN = "IND_RISK_AFS_RESPINT";

  public static final String RISK_ASSESSMENT_FMLY_STR_ATTITUDE_COLUMN = "CB_RISK_AFS_ATTITUDE";

  public static final String RISK_ASSESSMENT_FMLY_STR_DECEPTION_COLUMN = "CB_RISK_AFS_DECEPTION";

  public static final String RISK_ASSESSMENT_FMLY_STR_SUMMARY_COLUMN = "TXT_RISK_AFS_SUMMARY";

  public static final String RISK_ASSESSMENT_FMLY_STR_DT_LAST_UPDATE_COLUMN = "RFSDTLASTUPDATE";

  public static final String RISK_ASSESSMENT_TIME_RESPONSE = "TM_RESPONSE";

  private static final String TRACE_TAG = "RiskAssmtDAO";

  private static final String RISK_ASSMT_DETAILS_SQL = "  SELECT RF.ID_RISK_FACTOR, " + "         RF.ID_CASE, "
                                                       + "         RF.ID_STAGE, " + "         RF.ID_EVENT, "
                                                       + "         RF.CD_RISK_FACTOR, "
                                                       + "         RF.CD_RISK_FACTOR_RESPONSE, "
                                                       + "         RF.TXT_RISK_FACTOR_COMMENT, "
                                                       + "         RF.DT_LAST_UPDATE AS FACTOR_DT_LAST_UPDATE, "
                                                       + "         RC.ID_RISK_CATEGORY, "
                                                       + "         RC.CD_RISK_CATEG, "
                                                       + "         RC.CD_RISK_CATEG_CONCERN_SCALE, "
                                                       + "         RC.TXT_RISK_CATEG_JUSTIFICATION, "
                                                       + "         RC.DT_LAST_UPDATE AS CATEG_DT_LAST_UPDATE, "
                                                       + "         RAR.ID_RISK_AREA, " + "         RAR.CD_RISK_AREA, "
                                                       + "         RAR.CD_RISK_AREA_CONCERN_SCALE, "
                                                       + "         RAR.DT_LAST_UPDATE AS AREA_DT_LAST_UPDATE, "
                                                       + "         RAR.TXT_RISK_AREA_JUSTIFICATION, "
                                                       + "         RAR.ID_RISK_AREA, " + "         RAR.CD_RISK_AREA, "
                                                       + "         RAR.CD_RISK_AREA_CONCERN_SCALE, "
                                                       + "         RAR.DT_LAST_UPDATE AS AREA_DT_LAST_UPDATE, "
                                                       + "         RAS.CD_RISK_ASSMT_PURPOSE, "
                                                       + "         RAS.CD_RISK_ASSMT_RISK_FIND, "
                                                       + "         RAS.DT_RESPONSE, "
                                                       + "         TO_CHAR(RAS.DT_RESPONSE,'HH:MI AM') AS TM_RESPONSE,"
                                                       + "         RAS.IND_RISK_ASSMT_RESPONSE, "
                                                       + "         RAS.CD_CURRENT_LVL_RISK, " 
                                                       + "         RAS.DT_LAST_UPDATE AS ASSMT_DT_LAST_UPDATE, " +
                                                       // " RHR.DT_REPORT, " +
                                                       // " RHR.DT_CLOSURE, " +
                                                       // " RHR.CB_RISK_HR_CHILD, " +
                                                       // " RHR.TXT_RISK_HR_SUMM, " +
                                                       "         RIA.IND_RISK_IA_PARENTSGUIDE, "
                                                       + "         RIA.DT_PARENTSGUIDE, "
                                                       + "         RIA.IND_RISK_IA_PARENTSINTERV, "
                                                       + "         RIA.DT_PARENTSINTERV, "
                                                       + "         RIA.IND_RISK_IA_HIPPAINFO, "
                                                       + "         RIA.IND_RISK_IA_HIPPASIGN, "
                                                       + "         RIA.DT_HIPPASIGN, "
                                                       + "         RIA.TXT_RISK_IA_COMMENTS, "
                                                       + "         RIA.DT_LAST_UPDATE AS RIA_DT_LAST_UPDATE,"
                                                       + "         RFS.CB_RISK_AFS_CONTROL, "
                                                       + "         RFS.CB_RISK_AFS_KNOWLEDGE, "
                                                       + "         RFS.IND_RISK_AFS_CHILDVUL, "
                                                       + "         RFS.CB_RISK_AFS_CHILDPROCTN, "
                                                       + "         RFS.CB_RISK_AFS_CHILDBHVR, "
                                                       + "         RFS.CB_RISK_AFS_FUNCTNG, "
                                                       + "         RFS.IND_RISK_AFS_QUALOFCARE, "
                                                       + "         RFS.CB_RISK_AFS_EMOCARE, "
                                                       + "         RFS.CB_RISK_AFS_PHYCARE, "
                                                       + "         RFS.IND_RISK_AFS_MALPATRN, "
                                                       + "         RFS.CB_RISK_AFS_CURSEVRTY, "
                                                       + "         RFS.CB_RISK_AFS_CHRONCTY, "
                                                       + "         RFS.CB_RISK_AFS_TREND, "
                                                       + "         RFS.IND_RISK_AFS_HOMENV, "
                                                       + "         RFS.CB_RISK_AFS_STRESS, "
                                                       + "         RFS.CB_RISK_AFS_DANEXP, "
                                                       + "         RFS.IND_RISK_AFS_SOCENV, "
                                                       + "         RFS.CB_RISK_AFS_SOCCLI, "
                                                       + "         RFS.IND_RISK_AFS_CAREGIVCAP, "
                                                       + "         RFS.CB_RISK_AFS_SOCVIOL, "
                                                       + "         RFS.IND_RISK_AFS_RESPINT, "
                                                       + "         RFS.CB_RISK_AFS_ATTITUDE, "
                                                       + "         RFS.CB_RISK_AFS_DECEPTION, "
                                                       + "         RFS.TXT_RISK_AFS_SUMMARY, "
                                                       + "         RFS.DT_LAST_UPDATE AS RFSDTLASTUPDATE, "
                                                       + "         RFL.TXT_FACTOR, "
                                                       + "         RFL.AREA_CONCERN_TXT ,"
                                                       + "         RFL.NBR_FACTOR_ORDER, "
                                                       + "         RCL.TXT_CATEGORY, "
                                                       + "         RCL.NBR_CATEGORY_ORDER, "
                                                       + "         RAL.TXT_AREA, " + "         RAL.NBR_AREA_ORDER, "
                                                       + "         E.DT_LAST_UPDATE AS EVENT_DT_LAST_UPDATE, "
                                                       + "         E.CD_EVENT_STATUS " + "    FROM RISK_FACTORS RF, "
                                                       + "         RISK_CATEGORY RC, " + "         RISK_AREA RAR, "
                                                       + "         RISK_ASSESSMENT RAS, "
                                                       + "         RISK_FACTORS_LOOKUP RFL, "
                                                       + "         RISK_CATEGORY_LOOKUP RCL, "
                                                       + "         RISK_AREA_LOOKUP RAL, " +
                                                       // " RISK_HISTORY_REPORT RHR, " +
                                                       "         RISK_INV_ACTIONS RIA, "
                                                       + "         RISK_ASSMT_FMLY_STR RFS, " + "         EVENT E "
                                                       + "   WHERE RF.ID_RISK_FACTOR_CATEG = RC.ID_RISK_CATEGORY "
                                                       + "     AND RF.ID_RISK_FACTOR_AREA = RAR.ID_RISK_AREA "
                                                       + "     AND RF.ID_EVENT = RAS.ID_EVENT "
                                                       + "     AND RF.CD_RISK_FACTOR = RFL.CD_FACTOR "
                                                       + "     AND RC.CD_RISK_CATEG = RCL.CD_CATEGORY "
                                                       + "     AND RAR.CD_RISK_AREA = RAL.CD_AREA "
                                                       + "     AND RF.ID_EVENT = E.ID_EVENT " +
                                                       // " AND RHR.ID_EVENT = E.ID_EVENT " +
                                                       "     AND RIA.ID_EVENT(+) = E.ID_EVENT "
                                                       + "     AND RFS.ID_EVENT(+) = E.ID_EVENT "
                                                       + "     AND RF.ID_CASE = ? " + "     AND RF.ID_STAGE = ? "
                                                       + "     AND RF.ID_EVENT = ? " + "ORDER BY RAL.NBR_AREA_ORDER, "
                                                       + "         RCL.NBR_CATEGORY_ORDER, "
                                                       + "         RFL.NBR_FACTOR_ORDER";

  // SIR 4441
  /*private static final String QUERY_EVENT_SQL = "SELECT ID_EVENT, " + "       DT_LAST_UPDATE, "
                                                + "       ID_EVENT_STAGE, " + "       CD_EVENT_TYPE, "
                                                + "       ID_CASE, " + "       ID_EVENT_PERSON, " + "       CD_TASK, "
                                                + "       TXT_EVENT_DESCR, " + "       DT_EVENT_OCCURRED, "
                                                + "       CD_EVENT_STATUS " + "  FROM EVENT " + " WHERE ID_EVENT = ?";*/
  private static final String QUERY_EVENT_SQL = "SELECT E.ID_EVENT, " + "       E.DT_LAST_UPDATE, "
  + "       E.ID_EVENT_STAGE, " + "       E.CD_EVENT_TYPE, " +
                " S.CD_STAGE, "
  + "       E.ID_CASE, " + "       E.ID_EVENT_PERSON, " + "       E.CD_TASK, "
  + "       E.TXT_EVENT_DESCR, " + "       E.DT_EVENT_OCCURRED, "
  + "       E.CD_EVENT_STATUS " + "  FROM EVENT E, STAGE S " + " WHERE E.ID_EVENT_STAGE = S.ID_STAGE AND " +
                "ID_EVENT = ?";
  
  // end SIR 4441

  private static final String QUERY_APPROVAL_SQL = "SELECT A.ID_APPROVAL, " + "       A.DT_LAST_UPDATE, "
                                                   + "       A.ID_APPROVAL_PERSON, " + "       A.TXT_APPROVAL_TOPIC, "
                                                   + "       A.DT_APPROVAL_DATE " + "  FROM APPROVAL A, "
                                                   + "       APPROVAL_EVENT_LINK AEL "
                                                   + " WHERE A.ID_APPROVAL = AEL.ID_APPROVAL "
                                                   + "   AND AEL.ID_CASE = ? " + "   AND AEL.ID_EVENT = ?";

  private static final String QUERY_EMPLOYEE_SQL = "SELECT NM_EMPLOYEE_FIRST, " + "       NM_EMPLOYEE_LAST "
                                                   + "  FROM EMPLOYEE " + " WHERE ID_PERSON = ?";

  private static final String QUERY_HISTORY_REPORT_SQL = " SELECT ID_RISK_HISTORY_REPORT, "
                                                         + " DT_REPORT, DT_CLOSURE , CB_RISK_HR_CHILD, "
                                                         + " TXT_RISK_HR_SUMM, DT_LAST_UPDATE AS RHRDTLASTUPDATE "
                                                         + " FROM RISK_HISTORY_REPORT " + " WHERE ID_EVENT = ? "
                                                         + " ORDER BY ID_RISK_HISTORY_REPORT DESC";

  private static final String IRA_DATA_SQL = "SELECT E.ID_EVENT, " + "       E.CD_TASK, "
                                             + "       RA.IND_RISK_ASSMT_INTRANET " + "  FROM EVENT E, "
                                             + "       RISK_ASSESSMENT RA " + " WHERE E.ID_EVENT = RA.ID_EVENT "
                                             + "   AND RA.ID_STAGE = ? " + "   AND RA.ID_CASE = ?";

  private static final String QUERY_PAGE_DATA_SQL = "  SELECT RAL.CD_AREA AS CD_RISK_AREA, "
                                                    + "         RAL.TXT_AREA, " + "         RAL.NBR_AREA_ORDER, "
                                                    + "         RCL.CD_CATEGORY AS CD_RISK_CATEG, "
                                                    + "         RCL.TXT_CATEGORY, "
                                                    + "         RCL.NBR_CATEGORY_ORDER, "
                                                    + "         RFL.CD_FACTOR AS CD_RISK_FACTOR, "
                                                    + "         RFL.TXT_FACTOR, RFL.AREA_CONCERN_TXT, "
                                                    + "         RFL.NBR_FACTOR_ORDER "
                                                    + "    FROM RISK_AREA_LOOKUP RAL, "
                                                    + "         RISK_CATEGORY_LOOKUP RCL, "
                                                    + "         RISK_FACTORS_LOOKUP RFL "
                                                    + "   WHERE RCL.CD_CATEGORY = RFL.CD_CATEGORY "
                                                    + "     AND RAL.CD_AREA = RCL.CD_AREA "
                                                    + "ORDER BY RAL.NBR_AREA_ORDER, "
                                                    + "         RCL.NBR_CATEGORY_ORDER, "
                                                    + "         RFL.NBR_FACTOR_ORDER";

  private static final String INSERT_RISK_ASSMT_DETAILS_SQL = "INSERT INTO RISK_ASSESSMENT "
                                                              + "           (ID_EVENT, "
                                                              + "            ID_STAGE, "
                                                              + "            ID_CASE, "
                                                              + "            CD_RISK_ASSMT_PURPOSE, "
                                                              + "            CD_RISK_ASSMT_RISK_FIND, "
                                                              + "            DT_RESPONSE, "
                                                              + "            IND_RISK_ASSMT_RESPONSE, "
                                                              + "            IND_RISK_ASSMT_INTRANET, "
                                                              + "            CD_CURRENT_LVL_RISK) "
                                                              + "     VALUES(?, ?, ?, ?, ?, TO_DATE(?,'mm/dd/yyyy HH24:mi:ss'), ?, ?, ?)";

  private static final String INSERT_PRIOR_HISTORY_DETAILS_SQL = "INSERT INTO RISK_HISTORY_REPORT "
                                                                 + "           (ID_RISK_HISTORY_REPORT, "
                                                                 + "            ID_EVENT, "
                                                                 + "            CB_RISK_HR_CHILD, "
                                                                 + "            DT_REPORT, "
                                                                 + "            DT_CLOSURE, "
                                                                 + "            TXT_RISK_HR_SUMM) "
                                                                 + "     VALUES(?, ?, ?, ?, ?, ?)";

  private static final String INSERT_INV_ACTIONS_DETAILS_SQL = "INSERT INTO RISK_INV_ACTIONS "
                                                               + "           (ID_EVENT, "
                                                               + "            IND_RISK_IA_PARENTSGUIDE, "
                                                               + "            DT_PARENTSGUIDE, "
                                                               + "            IND_RISK_IA_PARENTSINTERV, "
                                                               + "            DT_PARENTSINTERV, "
                                                               + "            IND_RISK_IA_HIPPAINFO, "
                                                               + "            IND_RISK_IA_HIPPASIGN, "
                                                               + "            DT_HIPPASIGN, "
                                                               + "            TXT_RISK_IA_COMMENTS) "
                                                               + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String INSERT_ASSMT_OF_FMLY_STR_SQL = "INSERT INTO RISK_ASSMT_FMLY_STR "
                                                             + "           (ID_EVENT, "
                                                             + "            IND_RISK_AFS_CHILDVUL, "
                                                             + "            CB_RISK_AFS_CHILDPROCTN, "
                                                             + "            CB_RISK_AFS_CHILDBHVR, "
                                                             + "            IND_RISK_AFS_CAREGIVCAP, "
                                                             + "            CB_RISK_AFS_KNOWLEDGE, "
                                                             + "            CB_RISK_AFS_CONTROL, "
                                                             + "            CB_RISK_AFS_FUNCTNG, "
                                                             + "            IND_RISK_AFS_QUALOFCARE, "
                                                             + "            CB_RISK_AFS_EMOCARE, "
                                                             + "            CB_RISK_AFS_PHYCARE, "
                                                             + "            IND_RISK_AFS_MALPATRN, "
                                                             + "            CB_RISK_AFS_CURSEVRTY, "
                                                             + "            CB_RISK_AFS_CHRONCTY, "
                                                             + "            CB_RISK_AFS_TREND, "
                                                             + "            IND_RISK_AFS_HOMENV, "
                                                             + "            CB_RISK_AFS_STRESS, "
                                                             + "            CB_RISK_AFS_DANEXP, "
                                                             + "            IND_RISK_AFS_SOCENV, "
                                                             + "            CB_RISK_AFS_SOCCLI, "
                                                             + "            CB_RISK_AFS_SOCVIOL, "
                                                             + "            IND_RISK_AFS_RESPINT, "
                                                             + "            CB_RISK_AFS_ATTITUDE, "
                                                             + "            CB_RISK_AFS_DECEPTION, "
                                                             + "            TXT_RISK_AFS_SUMMARY) "
                                                             + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String SEQ_RISK_AREA_SQL = "SELECT SEQ_RISK_AREA.NEXTVAL FROM DUAL";

  private static final String INSERT_RISK_AREA_DETAILS_SQL = "INSERT INTO RISK_AREA " + "           (ID_RISK_AREA, "
                                                             + "            ID_EVENT, " + "            ID_STAGE, "
                                                             + "            ID_CASE, "
                                                             + "            CD_RISK_AREA_CONCERN_SCALE, "
                                                             + "            TXT_RISK_AREA_JUSTIFICATION, "
                                                             + "            CD_RISK_AREA) "
                                                             + "     VALUES(?, ?, ?, ?, ?, ?, ?)";

  private static final String SEQ_RISK_CATEGORY_SQL = "SELECT SEQ_RISK_CATEGORY.NEXTVAL FROM DUAL";

  private static final String INSERT_RISK_CATEGORY_SQL = "INSERT INTO RISK_CATEGORY "
                                                         + "           (ID_RISK_CATEGORY, "
                                                         + "            ID_RISK_CATEG_AREA, "
                                                         + "            ID_EVENT, " + "            ID_STAGE, "
                                                         + "            ID_CASE, "
                                                         + "            CD_RISK_CATEG_CONCERN_SCALE, "
                                                         + "            CD_RISK_CATEG) "
                                                         + "     VALUES(?, ?, ?, ?, ?, ?, ?)";

  private static final String INSERT_RISK_FACTORS_SQL = "INSERT INTO RISK_FACTORS " + "           (ID_RISK_FACTOR, "
                                                        + "            ID_PERSON, " + "            ID_EVENT, "
                                                        + "            ID_STAGE, " + "            CD_RISK_FACTOR, "
                                                        + "            ID_CASE, "
                                                        + "            CD_RISK_FACTOR_RESPONSE, "
                                                        + "            CD_RISK_FACTOR_CATEG, "
                                                        + "            ID_RISK_FACTOR_AREA, "
                                                        + "            ID_RISK_FACTOR_CATEG) "
                                                        + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String DELETE_EVENT_PERSON_LINK_SQL = "DELETE EVENT_PERSON_LINK WHERE ID_EVENT = ?";

  private static final String DELETE_RISK_ASSESSMENT_SQL = "DELETE FROM RISK_ASSESSMENT WHERE ID_EVENT =? ";

  private static final String DELETE_EVENT = "DELETE EVENT WHERE ID_EVENT = ?";

  private static final String UPDATE_CPS_INVST_DETAIL_SQL = "UPDATE CPS_INVST_DETAIL "
                                                            + "   SET IND_CPS_INVST_DTL_RA_NA = ? "
                                                            + " WHERE ID_CASE = ? " + "   AND ID_CPS_INVST_STAGE = ?";

  private static final String UPDATE_STAGE_SQL = "UPDATE STAGE " + "   SET CD_STAGE_REASON_CLOSED = ? "
                                                 + " WHERE ID_CASE = ? " + "   AND ID_STAGE = ?";

  private static final String UDPATE_EVENT_SQL = "UPDATE EVENT " + "   SET CD_EVENT_STATUS = ? "
                                                 + " WHERE ID_CASE = ? " + "   AND ID_EVENT_STAGE = ? "
                                                 + "   AND CD_EVENT_TYPE = ?";

  private static final String UPDATE_RISK_ASSMT_SQL = "UPDATE RISK_ASSESSMENT " + "   SET CD_RISK_ASSMT_PURPOSE = ?, "
                                                      + "       IND_RISK_ASSMT_RESPONSE = ?, "
                                                      + "       DT_RESPONSE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss'), "
                                                      + "       CD_RISK_ASSMT_RISK_FIND = ?, " 
                                                      + "       CD_CURRENT_LVL_RISK = ? "
                                                      + "   WHERE ID_CASE = ? "
                                                      + "   AND ID_STAGE = ? " + "   AND ID_EVENT = ? "
                                                      + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_AREA_SQL = "UPDATE RISK_AREA " + "   SET CD_RISK_AREA_CONCERN_SCALE = ?, "
                                                     + "       TXT_RISK_AREA_JUSTIFICATION = ? "
                                                     + " WHERE ID_CASE = ? " + "   AND ID_STAGE = ? "
                                                     + "   AND ID_EVENT = ? " + "   AND CD_RISK_AREA = ? "
                                                     + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_CATEGORY_SQL = "UPDATE RISK_CATEGORY "
                                                         + "   SET CD_RISK_CATEG_CONCERN_SCALE = ? "
                                                         + " WHERE ID_CASE = ? " + "   AND ID_STAGE = ? "
                                                         + "   AND ID_EVENT = ? " + "   AND CD_RISK_CATEG = ? "
                                                         + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_HISTORY_REPORT_SQL = "UPDATE RISK_HISTORY_REPORT "
                                                               + "   SET DT_CLOSURE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss'), "
                                                               + "       DT_REPORT = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss'), "
                                                               + "       CB_RISK_HR_CHILD = ?, "
                                                               + "       TXT_RISK_HR_SUMM = ? "
                                                               + " WHERE ID_RISK_HISTORY_REPORT = ? "
                                                               + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_INV_ACTIONS_SQL = "UPDATE RISK_INV_ACTIONS "
                                                            + "   SET DT_PARENTSGUIDE = ?, "
                                                            + "       IND_RISK_IA_PARENTSGUIDE = ?, "
                                                            + "       IND_RISK_IA_PARENTSINTERV = ?, "
                                                            + "       DT_PARENTSINTERV = ?, "
                                                            + "       IND_RISK_IA_HIPPAINFO = ?, "
                                                            + "       IND_RISK_IA_HIPPASIGN = ?, "
                                                            + "       DT_HIPPASIGN = ?, "
                                                            + "       TXT_RISK_IA_COMMENTS = ? "
                                                            + " WHERE ID_EVENT = ? "
                                                            + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_ASSMT_FMLY_STR_SQL = "UPDATE RISK_ASSMT_FMLY_STR "
                                                               + "   SET IND_RISK_AFS_CHILDVUL = ?, "
                                                               + "       CB_RISK_AFS_CHILDPROCTN = ?, "
                                                               + "       CB_RISK_AFS_CHILDBHVR = ?, "
                                                               + "       IND_RISK_AFS_CAREGIVCAP = ?, "
                                                               + "       CB_RISK_AFS_KNOWLEDGE = ?, "
                                                               + "       CB_RISK_AFS_CONTROL = ?, "
                                                               + "       CB_RISK_AFS_FUNCTNG = ?, "
                                                               + "       IND_RISK_AFS_QUALOFCARE = ?, "
                                                               + "       CB_RISK_AFS_EMOCARE = ?, "
                                                               + "       CB_RISK_AFS_PHYCARE = ?, "
                                                               + "       IND_RISK_AFS_MALPATRN = ?, "
                                                               + "       CB_RISK_AFS_CURSEVRTY = ?, "
                                                               + "       CB_RISK_AFS_CHRONCTY = ?, "
                                                               + "       CB_RISK_AFS_TREND = ?, "
                                                               + "       IND_RISK_AFS_HOMENV = ?, "
                                                               + "       CB_RISK_AFS_STRESS = ?, "
                                                               + "       CB_RISK_AFS_DANEXP = ?, "
                                                               + "       IND_RISK_AFS_SOCENV = ?, "
                                                               + "       CB_RISK_AFS_SOCCLI = ?, "
                                                               + "       CB_RISK_AFS_SOCVIOL = ?, "
                                                               + "       IND_RISK_AFS_RESPINT = ?, "
                                                               + "       CB_RISK_AFS_ATTITUDE = ?, "
                                                               + "       CB_RISK_AFS_DECEPTION = ?, "
                                                               + "       TXT_RISK_AFS_SUMMARY = ? "
                                                               + " WHERE ID_EVENT = ? "
                                                               + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String UPDATE_RISK_FACTORS_SQL = "UPDATE RISK_FACTORS " + "   SET CD_RISK_FACTOR_RESPONSE = ? "
                                                        + " WHERE ID_CASE = ? " + "   AND ID_STAGE = ? "
                                                        + "   AND ID_EVENT = ? " + "   AND CD_RISK_FACTOR = ? "
                                                        + "   AND DT_LAST_UPDATE = TO_DATE(?,'mm/dd/yyyy HH24:mi:ss')";

  private static final String QUERY_RISK_AREA_TEXT = "SELECT TXT_AREA FROM RISK_AREA_LOOKUP" + " WHERE CD_AREA = ? ";

  private static final String QUERY_RISK_CATEGORY_TEXT = "SELECT TXT_CATEGORY FROM RISK_CATEGORY_LOOKUP"
                                                         + " WHERE CD_CATEGORY = ? ";

  private static final String QUERY_RISK_FACTORS_TEXT = "SELECT TXT_FACTOR FROM RISK_FACTORS_LOOKUP"
                                                        + " WHERE CD_FACTOR = ? ";

  /**
   * Public constructor.
   * 
   * @param connection
   *          Connection that the BaseDao will use.
   */
  public RiskAssmtDAO(Connection connection) {
    super(connection);
  }

  /**
   * Query the Risk Assessment details.
   * 
   * @param searchBean
   *          The RiskAssmtValueBean object containing the risk assessment search parameters.
   * @return returnBean The RiskAssmtValueBean object containing the risk assessment details.
   */
  public RiskAssmtValueBean queryRiskAssmtDetails(RiskAssmtValueBean searchBean) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRiskAssmtDetails");
    performanceTrace.enterScope();
    RiskAssmtValueBean returnBean = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(RISK_ASSMT_DETAILS_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Integer> bindVariablesVector = new ArrayList<Integer>();
      bindVariablesVector.add(searchBean.getCaseId());
      bindVariablesVector.add(searchBean.getStageId());
      bindVariablesVector.add(searchBean.getEventId());
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();

      // Create a Risk Assessment bean from the first row returned. Each row returned from the database will contain
      // information for a single Risk Assessment Factor, the Category in which the Factor belongs, and the Area to
      // which the Category belongs.
      // SIR 19870 - method not avialbe in type forward results set resultSet.first();
      boolean notEmpty = true;
      if (resultSet == null || resultSet.next() == false) {
        notEmpty = false;
      }
      if (notEmpty) {
        returnBean = new RiskAssmtValueBean(resultSet);
      }

      // Create a Factor bean for each rown returned from the database, and put each bean into a vector. Then assign
      // the vector to the corresponding property in the Risk Assessment bean.
      List<RiskFactorValueBean> factors = new ArrayList<RiskFactorValueBean>();
      if (notEmpty) {
        do {
          RiskFactorValueBean factorBean = new RiskFactorValueBean(RiskFactorValueBean.RISK_ASSESSMENT_DATA, resultSet);
          factors.add(factorBean);
        } while (resultSet.next());
        returnBean.setFactors(factors);
      }

    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return returnBean;
  }

  /**
   * Query the RISK_HISTORY_REPORT table to retrieve all the values for that event id.
   * 
   * @param searchBean
   *          The RiskAssmtValueBean containing the risk assessment search parameters.
   */

  public List<RiskAssmtPriorHistoryValueBean> queryRiskHistoryReport(RiskAssmtValueBean searchBean)
          throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRiskHistoryReport");
    performanceTrace.enterScope();
    List<RiskAssmtPriorHistoryValueBean> reports = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      // GrndsTrace.msg(TRACE_TAG, 7, "The Risk Assessment DAO queryCreatedUsingIRAData SQL is " + sql);
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(QUERY_HISTORY_REPORT_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Integer> bindVariablesVector = new ArrayList<Integer>();

      // Add bind variables (only applicable for prepared statements)
      bindVariablesVector.add(searchBean.getEventId());
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      // performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      boolean notEmpty = true;
      if (resultSet == null || resultSet.next() == false) {
        notEmpty = false;
      }
      reports = new ArrayList<RiskAssmtPriorHistoryValueBean>();
      if (notEmpty) {
        do {
          RiskAssmtPriorHistoryValueBean reportBean = new RiskAssmtPriorHistoryValueBean(resultSet);
          reportBean.setEventId(searchBean.getEventId());
          reports.add(reportBean);
        } while (resultSet.next());
      } else {
        RiskAssmtPriorHistoryValueBean reportBean = new RiskAssmtPriorHistoryValueBean();
        reports.add(reportBean);
      }
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return reports;
  }

  /**
   * Queries event information for the given event id.
   * 
   * @param eventId
   * @return EventValueBean The object containing the event details.
   */
  public EventValueBean queryEvent(int eventId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryEvent");
    performanceTrace.enterScope();
    PreparedStatement eventStmt = null;
    PreparedStatement approvalStmt = null;
    PreparedStatement employeeStmt = null;
    ResultSet eventRs = null;
    ResultSet approvalRs = null;
    ResultSet employeeRs = null;
    EventValueBean eventBean = null;
    try {
      List<Integer> bindVariablesVector = new ArrayList<Integer>();
      bindVariablesVector.add(eventId);
      Connection connection = super.getConnection();
      eventStmt = connection.prepareStatement(QUERY_EVENT_SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

      // Add bind variables (only applicable for prepared statements)
      eventStmt = addBindVariablesToStatement(eventStmt, bindVariablesVector);
      eventRs = eventStmt.executeQuery();
      if (eventRs.next()) {
        eventBean = new EventValueBean(eventRs);
      }

      // Query any approval information. Also query the full name of the person who created the event.
      if (eventBean != null) {
        approvalStmt = connection.prepareStatement(QUERY_APPROVAL_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                   ResultSet.CONCUR_READ_ONLY);
        bindVariablesVector.clear();
        bindVariablesVector.add(eventBean.getCaseId());
        bindVariablesVector.add(eventId);
        approvalStmt = addBindVariablesToStatement(approvalStmt, bindVariablesVector);
        approvalRs = approvalStmt.executeQuery();
        if (approvalRs.next()) {
          Timestamp dtApprovalDate = approvalRs.getTimestamp("DT_APPROVAL_DATE");
          if (dtApprovalDate != null) {
            eventBean.setApprovalDate(dtApprovalDate);
          }
          Timestamp dtLastUpdate = approvalRs.getTimestamp("DT_LAST_UPDATE");
          if (dtLastUpdate != null) {
            eventBean.setApprovalDateLastUpdate(dtLastUpdate);
          }
          int idApproval = approvalRs.getInt("ID_APPROVAL");
          if (idApproval > 0) {
            eventBean.setApprovalId(idApproval);
          }
          int idApprovalPerson = approvalRs.getInt("ID_APPROVAL_PERSON");
          if (idApprovalPerson > 0) {
            eventBean.setApprovalPersonId(idApprovalPerson);
          }
          String txtApprovalTopic = approvalRs.getString("TXT_APPROVAL_TOPIC");
          if (txtApprovalTopic != null) {
            eventBean.setApprovalTopic(txtApprovalTopic);
          }
        }

        employeeStmt = connection.prepareStatement(QUERY_EMPLOYEE_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                   ResultSet.CONCUR_READ_ONLY);
        bindVariablesVector.clear();
        bindVariablesVector.add(eventBean.getPersonId());
        employeeStmt = addBindVariablesToStatement(employeeStmt, bindVariablesVector);
        employeeRs = employeeStmt.executeQuery();
        if (employeeRs.next()) {
          String nmEmployeeFirst = employeeRs.getString("NM_EMPLOYEE_FIRST");
          if (nmEmployeeFirst != null) {
            eventBean.setCreatorsFirstName(nmEmployeeFirst);
          }
          String nmEmployeeLast = employeeRs.getString("NM_EMPLOYEE_LAST");
          if (nmEmployeeLast != null) {
            eventBean.setCreatorsLastName(nmEmployeeLast);
          }
        }
      }
    } finally {
      cleanup(eventRs);
      cleanup(approvalRs);
      cleanup(employeeRs);
      cleanup(eventStmt);
      cleanup(approvalStmt);
      cleanup(employeeStmt);
      performanceTrace.exitScope();
    }
    return eventBean;
  }

  /**
   * Query the IND_RISK_ASSMT_INTRANET column on the RISK_ASSESSMENT table to determine if the Risk Assessment was
   * created using IRA or IMPACT.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean containing the risk assessment search parameters.
   * @return boolean true if the risk assessment was created using IRA or IMPACT; false, otherwise.
   */
  public RiskAssmtValueBean queryCreatedUsingIRAData(RiskAssmtValueBean riskAssmtBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryCreatedUsingIRAData");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(IRA_DATA_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Integer> bindVariablesVector = new ArrayList<Integer>();
      bindVariablesVector.add(riskAssmtBean.getStageId());
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        if (resultSet.getString("CD_TASK") != null) {
          riskAssmtBean.setSzCdTask(resultSet.getString("CD_TASK"));
        }
        if ("Y".equals(resultSet.getString("IND_RISK_ASSMT_INTRANET"))
            || "M".equals(resultSet.getString("IND_RISK_ASSMT_INTRANET"))) {
          riskAssmtBean.setIsCreatedUsingIRAorIMPACT(true);
        }

        if (resultSet.getInt("ID_EVENT") > 0) {
          riskAssmtBean.setEventId(resultSet.getInt("ID_EVENT"));
        }
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return riskAssmtBean;
  }

  /**
   * Query the data needed to create the Risk Assessment page.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the case and stage unique id's.
   * @return returnBean The RiskAssmtValueBean object containing the risk assessment data needed to build the
   *         RiskAssmt.jsp.
   */
  public RiskAssmtValueBean queryPageData(RiskAssmtValueBean riskAssmtBean) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPageData");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    RiskAssmtValueBean returnBean = null;
    ResultSet resultSet = null;
    try {
      // Create the return bean and populate it with the case id and stage id that passed to this method
      if (riskAssmtBean.getEventId() > 0) {
        returnBean = new RiskAssmtValueBean(riskAssmtBean.getCaseId(), riskAssmtBean.getStageId(),
                                            riskAssmtBean.getEventId());
      } else {
        returnBean = new RiskAssmtValueBean(riskAssmtBean.getCaseId(), riskAssmtBean.getStageId(), 0);
      }
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(QUERY_PAGE_DATA_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      resultSet = preparedStatement.executeQuery();
      // Create a Factor bean for each rown returned from the database, and put each bean into a vector. Then assign
      // the vector to the corresponding property in the Risk Assessment bean that was passed to this method.
      List<RiskFactorValueBean> factors = new ArrayList<RiskFactorValueBean>();
      while (resultSet.next()) {
        RiskFactorValueBean factorBean = new RiskFactorValueBean(RiskFactorValueBean.PAGE_CREATION_DATA_ONLY, resultSet);
        factors.add(factorBean);
      }
      returnBean.setFactors(factors);
      List<RiskAssmtPriorHistoryValueBean> reports = new ArrayList<RiskAssmtPriorHistoryValueBean>();
      RiskAssmtPriorHistoryValueBean report = new RiskAssmtPriorHistoryValueBean();
      reports.add(report);
      returnBean.setReports(reports);
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return returnBean;
  }

  /**
   * Saves the new Risk Assessment Purpose and Risk Finding to the database
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the risk assessment details.
   */
  public void addRiskAssmtDetails(RiskAssmtValueBean riskAssmtBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addRiskAssmtDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;

    try {
      // Insert the new risk assessment details.
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_RISK_ASSMT_DETAILS_SQL);

      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(riskAssmtBean.getEventId());
      bindVariablesVector.add(riskAssmtBean.getStageId());
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      if (riskAssmtBean.getPurpose() != null) {
        bindVariablesVector.add(riskAssmtBean.getPurpose());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getFinding() != null) {
        bindVariablesVector.add(riskAssmtBean.getFinding());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      Date jd = DateHelper.toJavaDateSafe(DateHelper.toCastorDate(riskAssmtBean.getDateResponse()),
                                          riskAssmtBean.getTmResponse());
      String jdString = DateHelper.toSqlString(jd);
      bindVariablesVector.add(jdString);

      if (riskAssmtBean.getIndResponse() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndResponse());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add("M");
      
      if (riskAssmtBean.getCdCurrLvlRisk() != null) {
        bindVariablesVector.add(riskAssmtBean.getCdCurrLvlRisk());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the new Risk Assessment prior history details to the database
   * 
   * @param reportBean
   *          The RiskAssmtValueBean object containing the prior history details.
   */
  public void addPriorHistoryDetails(RiskAssmtPriorHistoryValueBean reportBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addRiskAssmtDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;

    try {
      // Insert the new risk assessment details.
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_PRIOR_HISTORY_DETAILS_SQL);

      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(0);
      // bindVariablesVector.add(riskAssmtBean.getEventId());
      // List<RiskAssmtPriorHistoryValueBean> numOfReports = riskAssmtBean.getReports();
      // for (int i = 0; i < numOfReports.size(); i++) {
      // RiskAssmtPriorHistoryValueBean reportBean = new RiskAssmtPriorHistoryValueBean();
      bindVariablesVector.add(reportBean.getEventId());
      if (reportBean.getIndChildHistoryReport() != null) {
        bindVariablesVector.add(reportBean.getIndChildHistoryReport());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (reportBean.getDateOfReport() != null) {
        bindVariablesVector.add(reportBean.getDateOfReport());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (reportBean.getDateOfClosure() != null) {
        bindVariablesVector.add(reportBean.getDateOfClosure());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (reportBean.getFindingHistoryReport() != null) {
        bindVariablesVector.add(reportBean.getFindingHistoryReport());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the new Risk Assessment prior history details to the database
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the prior history details.
   */
  public void addInvActionsDetails(RiskAssmtValueBean riskAssmtBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addRiskAssmtDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;

    try {
      // Insert the new risk assessment details.
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_INV_ACTIONS_DETAILS_SQL);

      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(riskAssmtBean.getEventId());
      if (riskAssmtBean.getIndParentsGuide() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndParentsGuide());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getDateParentsGuide() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateParentsGuide());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getIndParentsNotified() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndParentsNotified());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getDateParentsNotified() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateParentsNotified());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getIndHIPPAPolicyExp() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHIPPAPolicyExp());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndHIPPAPolicySigned() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHIPPAPolicySigned());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getDateHIPPASignedAndAck() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateHIPPASignedAndAck());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getCommentsHIPPA() != null) {
        bindVariablesVector.add(riskAssmtBean.getCommentsHIPPA());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      preparedStatement.executeUpdate();
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the new Assessment of Family Strength to the database
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the Assessment of Family Strength details.
   */
  public void addAssessmentOfFmlyStr(RiskAssmtValueBean riskAssmtBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addRiskAssmtDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(riskAssmtBean.getEventId());
      if (riskAssmtBean.getIndchildVulnerability() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndchildVulnerability());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChildFragilityProtection() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChildFragilityProtection());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChildBehaviour() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChildBehaviour());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndCaregiverCapability() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndCaregiverCapability());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndKnowledgeSkills() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndKnowledgeSkills());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndControl() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndControl());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndFunctioning() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndFunctioning());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndQualityOfCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndQualityOfCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndEmotionalCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndEmotionalCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndPhysicalCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndPhysicalCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndMaltreatmentPattern() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndMaltreatmentPattern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndCurrentSeverity() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndCurrentSeverity());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChronicity() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChronicity());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndTrend() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndTrend());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndHomeEnv() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHomeEnv());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndStressors() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndStressors());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndDangerousExposure() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndDangerousExposure());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialEnv() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialEnv());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialClimate() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialClimate());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialViolence() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialViolence());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndResponseToIntervention() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndResponseToIntervention());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndAttitude() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndAttitude());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndDeception() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndDeception());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getCommentsAssessmentOfFmlyStr() != null) {
        bindVariablesVector.add(riskAssmtBean.getCommentsAssessmentOfFmlyStr());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_ASSMT_OF_FMLY_STR_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the new Risk Assessment Area details to the database
   * 
   * @param newRiskAssmtEventId
   *          The risk assessment event id.
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   * @return newRiskAreaId The primary key of the new RISK_AREA row.
   */
  public int addAreaDetails(int newRiskAssmtEventId, RiskFactorValueBean riskFactorBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addAreaDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    int newRiskAreaId = 0;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      // Select the NEXTVAL from the sequence to be used as the primary key for the insert below.
      Connection connection = super.getConnection();
      try {
        preparedStatement = connection.prepareStatement(SEQ_RISK_AREA_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
        results = preparedStatement.executeQuery();

        if (results.next()) {
          newRiskAreaId = results.getInt(NEXTVAL_COLUMN);
        }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      // Insert the new risk area details.
      bindVariablesVector.add(newRiskAreaId);
      bindVariablesVector.add(newRiskAssmtEventId);
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getCaseId());
      if (riskFactorBean.getAreaScaleOfConcern() != null) {
        bindVariablesVector.add(riskFactorBean.getAreaScaleOfConcern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskFactorBean.getCategoryJustificationOfFindings() != null) {
        bindVariablesVector.add(riskFactorBean.getCategoryJustificationOfFindings());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskFactorBean.getAreaCode());

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_RISK_AREA_DETAILS_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(results);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return newRiskAreaId;
  }

  /**
   * Saves the new Risk Assessment Category details to the database
   * 
   * @param newRiskAssmtEventId
   *          The risk assessment event id.
   * @param newRiskAreaId
   *          The primary key of the new RISK_AREA row.
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   * @return newRiskCategoryId The primary key of the new RISK_CATEGORY row.
   */
  public int addCategoryDetails(int newRiskAssmtEventId, int newRiskAreaId, RiskFactorValueBean riskFactorBean)
                                                                                                               throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addCategoryDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    int newRiskCategoryId = 0;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      // Select the NEXTVAL from the sequence to be used as the primary key for the insert below.
      Connection connection = super.getConnection();
      try {
        preparedStatement = connection.prepareStatement(SEQ_RISK_CATEGORY_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
        results = preparedStatement.executeQuery();

        if (results.next()) {
          newRiskCategoryId = results.getInt(NEXTVAL_COLUMN);
        }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      // Insert the new risk category details.
      bindVariablesVector.add(newRiskCategoryId);
      bindVariablesVector.add(newRiskAreaId);
      bindVariablesVector.add(newRiskAssmtEventId);
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getCaseId());
      if (riskFactorBean.getCategoryScaleOfConcern() != null) {
        bindVariablesVector.add(riskFactorBean.getCategoryScaleOfConcern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskFactorBean.getCategoryCode());
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_RISK_CATEGORY_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(results);
      cleanup(preparedStatement);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return newRiskCategoryId;
  }

  /**
   * Saves the new Risk Assessment Factor details to the database
   * 
   * @param newRiskAssmtEventId
   *          The risk assessment event id.
   * @param newRiskAreaId
   *          The primary key of the new RISK_AREA row.
   * @param newRiskCategoryId
   *          The primary key of the new RISK_CATEGORY row.
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   */
  public void addFactorDetails(int newRiskAssmtEventId, int newRiskAreaId, int newRiskCategoryId,
                               RiskFactorValueBean riskFactorBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFactorDetails");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      // Insert the new risk factor details.
      bindVariablesVector.add(0);
      bindVariablesVector.add(0);
      bindVariablesVector.add(newRiskAssmtEventId);
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getFactorCode());
      bindVariablesVector.add(riskFactorBean.getCaseId());
      if (riskFactorBean.getFactorResponse() != null) {
        bindVariablesVector.add(riskFactorBean.getFactorResponse());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskFactorBean.getCategoryCode());
      bindVariablesVector.add(newRiskAreaId);
      bindVariablesVector.add(newRiskCategoryId);
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(INSERT_RISK_FACTORS_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      preparedStatement.executeUpdate();
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Deletes the given event from the database, including all rows from the EVENT_PERSON_LINK table.
   * 
   * @param eventId
   */
  public void deleteEvent(int eventId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteEvent");
    performanceTrace.enterScope();
    PreparedStatement delEVPStmt = null;
    PreparedStatement delRAStmt = null;
    PreparedStatement delEventStmt = null;
    try {
      List<Integer> bindVariablesVector = new ArrayList<Integer>();

      bindVariablesVector.add(eventId);
      Connection connection = super.getConnection();
      delEVPStmt = connection.prepareStatement(DELETE_EVENT_PERSON_LINK_SQL);
      delEVPStmt = addBindVariablesToStatement(delEVPStmt, bindVariablesVector);
      delEVPStmt.executeUpdate();

      bindVariablesVector.clear();
      bindVariablesVector.add(eventId);
      delRAStmt = connection.prepareStatement(DELETE_RISK_ASSESSMENT_SQL);
      delRAStmt = addBindVariablesToStatement(delRAStmt, bindVariablesVector);
      delRAStmt.executeUpdate();

      bindVariablesVector.clear();
      bindVariablesVector.add(eventId);
      connection = super.getConnection();
      delEventStmt = connection.prepareStatement(DELETE_EVENT);
      delEventStmt = addBindVariablesToStatement(delEventStmt, bindVariablesVector);
      delEventStmt.executeUpdate();
    } finally {
      cleanup(delEVPStmt);
      cleanup(delRAStmt);
      cleanup(delEventStmt);
      performanceTrace.exitScope();
    }
  }

  /**
   * Sets 'Recommended Action' and the 'Risk Assessment N/A' checkbox to null for the Investigation Conclusion for this
   * stage because the 'Recommended Action' is affected by the Risk Assessment 'Risk Finding'. Also sets the
   * Investigation Conclusion event (CCL) to PROC status since 'Recommended Action' is null.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the risk assessment details.
   */
  public void resetInvestigationConclusion(RiskAssmtValueBean riskAssmtBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "resetInvestigationConclusion");
    performanceTrace.enterScope();

    PreparedStatement updateCPSStmt = null;
    PreparedStatement updateStageStmt = null;
    PreparedStatement updateEventStmt = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      // Create the SQL statement.
      // NOTE: These SQLs do not use DT_LAST_UPDATE because the data was never
      // queried from the database. The update needs to happen regardless of
      // the timestamp.
      bindVariablesVector.add(new NullValue(Types.VARCHAR));
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      bindVariablesVector.add(riskAssmtBean.getStageId());
      Connection connection = super.getConnection();
      updateCPSStmt = connection.prepareStatement(UPDATE_CPS_INVST_DETAIL_SQL);
      updateCPSStmt = addBindVariablesToStatement(updateCPSStmt, bindVariablesVector);
      updateCPSStmt.executeUpdate();

      // Create the SQL statement.
      // NOTE: These SQLs do not use DT_LAST_UPDATE because the data was never queried from the database. The update
      // needs to happen regardless of the timestamp.
      bindVariablesVector.clear();
      bindVariablesVector.add(new NullValue(Types.VARCHAR));
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      bindVariablesVector.add(riskAssmtBean.getStageId());
      connection = super.getConnection();
      updateStageStmt = connection.prepareStatement(UPDATE_STAGE_SQL);
      updateStageStmt = addBindVariablesToStatement(updateStageStmt, bindVariablesVector);
      updateStageStmt.executeUpdate();

      // Create the SQL statement.
      // NOTE: These SQLs do not use DT_LAST_UPDATE because the data was never queried from the database. The update
      // needs to happen regardless of the timestamp.
      bindVariablesVector.clear();
      bindVariablesVector.add(CodesTables.CEVTSTAT_PROC);
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      bindVariablesVector.add(riskAssmtBean.getStageId());
      bindVariablesVector.add(CodesTables.CEVNTTYP_CCL);
      connection = super.getConnection();
      updateEventStmt = connection.prepareStatement(UDPATE_EVENT_SQL);
      updateEventStmt = addBindVariablesToStatement(updateEventStmt, bindVariablesVector);
      updateEventStmt.executeUpdate();
    } finally {
      cleanup(updateEventStmt);
      cleanup(updateStageStmt);
      cleanup(updateCPSStmt);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Purpose and Risk Finding to the database.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @throws TimestampMismatchException
   */
  public void updateRiskAssmtDetails(RiskAssmtValueBean riskAssmtBean) throws TimestampMismatchException, SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateRiskAssmtDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      if (riskAssmtBean.getPurpose() != null) {
        bindVariablesVector.add(riskAssmtBean.getPurpose());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndResponse() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndResponse());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }

      Date jd = DateHelper.toJavaDateSafe(DateHelper.toCastorDate(riskAssmtBean.getDateResponse()),
                                          riskAssmtBean.getTmResponse());
      String jdString = DateHelper.toSqlString(jd);
      bindVariablesVector.add(jdString);
      if (riskAssmtBean.getFinding() != null) {
        bindVariablesVector.add(riskAssmtBean.getFinding());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      
      if (riskAssmtBean.getCdCurrLvlRisk() != null) {
        bindVariablesVector.add(riskAssmtBean.getCdCurrLvlRisk());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskAssmtBean.getCaseId());
      bindVariablesVector.add(riskAssmtBean.getStageId());
      bindVariablesVector.add(riskAssmtBean.getEventId());
      bindVariablesVector.add(DateHelper.toSqlString(riskAssmtBean.getDateLastUpdate()));
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_ASSMT_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (preparedStatement.executeUpdate() < 1) {
        throw new TimestampMismatchException();
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Area details to the database.
   * 
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   * @throws TimestampMismatchException
   */
  public void updateAreaDetails(RiskFactorValueBean riskFactorBean) throws TimestampMismatchException, SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateAreaDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      if (riskFactorBean.getAreaScaleOfConcern() != null) {
        bindVariablesVector.add(riskFactorBean.getAreaScaleOfConcern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskFactorBean.getCategoryJustificationOfFindings() != null) {
        bindVariablesVector.add(riskFactorBean.getCategoryJustificationOfFindings());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskFactorBean.getCaseId());
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getEventId());
      if (riskFactorBean.getAreaCode() != null) {
        bindVariablesVector.add(riskFactorBean.getAreaCode());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskFactorBean.getAreaDateLastUpdate() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(riskFactorBean.getAreaDateLastUpdate()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_AREA_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (preparedStatement.executeUpdate() < 1) {
        throw new TimestampMismatchException();
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Category details to the database.
   * 
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   * @throws TimestampMismatchException
   */
  public void updateCategoryDetails(RiskFactorValueBean riskFactorBean) throws TimestampMismatchException, SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateCategoryDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      if (riskFactorBean.getCategoryScaleOfConcern() != null) {
        bindVariablesVector.add(riskFactorBean.getCategoryScaleOfConcern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskFactorBean.getCaseId());
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getEventId());
      if (riskFactorBean.getCategoryCode() != null) {
        bindVariablesVector.add(riskFactorBean.getCategoryCode());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskFactorBean.getCategoryDateLastUpdate() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(riskFactorBean.getCategoryDateLastUpdate()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_CATEGORY_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (preparedStatement.executeUpdate() < 1) {
        throw new TimestampMismatchException();
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment history report to the database.
   * 
   * @param reportBean
   *          The riskAssmtValueBean object containing the risk assessment details ,history report
   * @throws TimestampMismatchException
   */
  public void updateHistoryReport(RiskAssmtPriorHistoryValueBean reportBean) throws TimestampMismatchException,
                                                                            SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateRiskAssmtDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      // List<RiskAssmtPriorHistoryValueBean> numOfReports = riskAssmtBean.getReports();
      // for (int i = 0; i < numOfReports.size(); i++) {
      // RiskAssmtPriorHistoryValueBean reportBean = numOfReports.get(i);
      if (reportBean.getDateOfClosure() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(reportBean.getDateOfClosure()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (reportBean.getDateOfReport() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(reportBean.getDateOfReport()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (reportBean.getIndChildHistoryReport() != null) {
        bindVariablesVector.add(reportBean.getIndChildHistoryReport());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (reportBean.getFindingHistoryReport() != null) {
        bindVariablesVector.add(reportBean.getFindingHistoryReport());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(reportBean.getRiskHistoryReportId());
      bindVariablesVector.add(DateHelper.toSqlString(reportBean.getLastUpdateDate()));
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_HISTORY_REPORT_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      if (preparedStatement.executeUpdate() < 1) {
        throw new TimestampMismatchException();
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Investingation Actions to the database.
   * 
   * @param riskAssmtBean
   *          The riskAssmtValueBean object containing the risk assessment details ,history report
   * @throws TimestampMismatchException
   */
  public void updateInvActionDetails(RiskAssmtValueBean riskAssmtBean) throws TimestampMismatchException, SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateInvActionDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      if (riskAssmtBean.getDateParentsGuide() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateParentsGuide());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getIndParentsGuide() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndParentsGuide());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndParentsNotified() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndParentsNotified());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getDateParentsNotified() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateParentsNotified());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getIndHIPPAPolicyExp() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHIPPAPolicyExp());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndHIPPAPolicySigned() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHIPPAPolicySigned());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getDateHIPPASignedAndAck() != null) {
        bindVariablesVector.add(riskAssmtBean.getDateHIPPASignedAndAck());
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (riskAssmtBean.getCommentsHIPPA() != null) {
        bindVariablesVector.add(riskAssmtBean.getCommentsHIPPA());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskAssmtBean.getEventId());
      bindVariablesVector.add(DateHelper.toSqlString(riskAssmtBean.getDateLastUpdateInvActions()));
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_INV_ACTIONS_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (riskAssmtBean.getDateLastUpdateInvActions() != null) {
        if (preparedStatement.executeUpdate() < 1) {
          throw new TimestampMismatchException();
        }
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Family Strengths to the database.
   * 
   * @param riskAssmtBean
   *          The riskAssmtValueBean object containing the risk assessment details ,history report
   * @throws TimestampMismatchException
   */
  public void updateAssessmentOfFmlyStr(RiskAssmtValueBean riskAssmtBean) throws TimestampMismatchException,
                                                                         SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateAssessmentOfFmlyStr");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      if (riskAssmtBean.getIndchildVulnerability() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndchildVulnerability());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChildFragilityProtection() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChildFragilityProtection());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChildBehaviour() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChildBehaviour());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndCaregiverCapability() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndCaregiverCapability());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndKnowledgeSkills() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndKnowledgeSkills());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndControl() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndControl());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndFunctioning() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndFunctioning());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndQualityOfCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndQualityOfCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndEmotionalCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndEmotionalCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndPhysicalCare() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndPhysicalCare());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndMaltreatmentPattern() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndMaltreatmentPattern());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndCurrentSeverity() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndCurrentSeverity());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndChronicity() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndChronicity());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndTrend() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndTrend());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndHomeEnv() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndHomeEnv());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndStressors() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndStressors());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndDangerousExposure() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndDangerousExposure());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialEnv() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialEnv());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialClimate() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialClimate());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndSocialViolence() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndSocialViolence());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndResponseToIntervention() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndResponseToIntervention());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndAttitude() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndAttitude());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getIndDeception() != null) {
        bindVariablesVector.add(riskAssmtBean.getIndDeception());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (riskAssmtBean.getCommentsAssessmentOfFmlyStr() != null) {
        bindVariablesVector.add(riskAssmtBean.getCommentsAssessmentOfFmlyStr());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(riskAssmtBean.getEventId());
      bindVariablesVector.add(DateHelper.toSqlString(riskAssmtBean.getDateLastUpdateFmlyStr()));
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_ASSMT_FMLY_STR_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      // Make it compatible with existing data that do not have any FmlyStr rows
      if (riskAssmtBean.getDateLastUpdateFmlyStr() != null) {
        int rc = preparedStatement.executeUpdate();
        if (rc < 1) {
          throw new TimestampMismatchException();
        }
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Risk Assessment Factor details to the database.
   * 
   * @param riskFactorBean
   *          The RiskFactorValueBean object containing the risk assessment area, category and factor details.
   * @throws TimestampMismatchException
   */
  public void updateFactorDetails(RiskFactorValueBean riskFactorBean) throws TimestampMismatchException, SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFactorDetails");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    try {
      List<Serializable> bindVariablesVector = new ArrayList<Serializable>();
      bindVariablesVector.add(riskFactorBean.getFactorResponse());
      bindVariablesVector.add(riskFactorBean.getCaseId());
      bindVariablesVector.add(riskFactorBean.getStageId());
      bindVariablesVector.add(riskFactorBean.getEventId());
      bindVariablesVector.add(riskFactorBean.getFactorCode());
      bindVariablesVector.add(DateHelper.toSqlString(riskFactorBean.getFactorDateLastUpdate()));
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(UPDATE_RISK_FACTORS_SQL);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (preparedStatement.executeUpdate() < 1) {
        throw new TimestampMismatchException();
      }
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Query the Risk Assessment details.
   * 
   * @param areaCode
   *          The RiskAssmtValueBean object containing the risk assessment search parameters.
   * @return returnBean The RiskAssmtValueBean object containing the risk assessment details.
   */
  public String queryRiskAreaText(String areaCode) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRiskAreaText");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String result = "";
    try {
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(QUERY_RISK_AREA_TEXT, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Serializable> bindVariablesVector = new ArrayList<Serializable>();
      bindVariablesVector.add(areaCode);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = resultSet.getString(1);
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return result;
  }

  public String queryRiskCategoryText(String categoryCode) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRiskAreaText");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String result = "";
    try {
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(QUERY_RISK_CATEGORY_TEXT, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Serializable> bindVariablesVector = new ArrayList<Serializable>();
      bindVariablesVector.add(categoryCode);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = resultSet.getString(1);
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return result;
  }

  public String queryRiskFactorText(String factorCode) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRiskAreaText");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String result = "";
    try {
      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(QUERY_RISK_FACTORS_TEXT, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      List<Serializable> bindVariablesVector = new ArrayList<Serializable>();
      bindVariablesVector.add(factorCode);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = resultSet.getString(1);
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return result;
  }

  /*
   * Retrieve event status code of Family Plan that creates this Risk ReAssessment 
   */
  public String queryInitialFamilyPlanStatus(int idEventRra) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRelatedFamilyPlanStatus");
    performanceTrace.enterScope();

    String cdEventSatus = null;
    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      String sql = "SELECT E.CD_EVENT_STATUS " + "FROM EVENT E, FAMILY_PLAN FP "
                   + "WHERE E.ID_EVENT = FP.ID_EVENT " +
                                "AND E.CD_EVENT_STATUS = 'APRV' " + "AND FP.ID_EVENT_RISK_ASSMT = ?  ";
      bindVariablesVector.add(idEventRra);
      GrndsTrace.msg(TRACE_TAG, 7, "RiskAssmtDAO queryRelatedFamilyPlanStatus() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        cdEventSatus = resultSet.getString("CD_EVENT_STATUS");
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return cdEventSatus;
  }
}
