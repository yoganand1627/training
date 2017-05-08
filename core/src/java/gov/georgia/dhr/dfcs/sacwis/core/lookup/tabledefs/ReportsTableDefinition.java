package gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs;

// java classes


/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class ReportsTableDefinition extends TableDefinitionAdapter {
  public ReportsTableDefinition() {
    super(ReportsTableDefinition.TABLE_ID,
          ReportsTableDefinition.TABLE_NAME,
          ReportsTableDefinition.SQL_STATEMENT,
          ReportsTableDefinition.KEY_CODE,
          ReportsTableDefinition.TABLE_DEF_STRING);
  }

  public static final String KEY_CODE = "RPT_NAME";
  public static final String TABLE_ID = "REPORTS";
  public static final String TABLE_NAME = "REPORTS";
  public static final String SQL_STATEMENT =
          "select concat(a.NM_RPT_SQR_NAME, a.NM_RPT_SQR_VER) as RPT_NAME, " +
          "a.NM_RPT_SQR_NAME, " +
          "a.NM_RPT_SQR_VER, a.TXT_RPT_FULL_NAME , " +
          "NVL(b.PARM_COUNT, 0) as PARM_COUNT " +
          "from REPORTS a, (select NM_RPT_SQR_NAME, NM_RPT_SQR_VER, " +
          "count(NM_RPT_PARM_NAME) as PARM_COUNT from " +
          "REPORT_PARAMETER group by NM_RPT_SQR_NAME, NM_RPT_SQR_VER) " +
          "b where a.NM_RPT_SQR_NAME=b.NM_RPT_SQR_NAME (+) and " +
          "a.NM_RPT_SQR_VER=b.NM_RPT_SQR_VER (+)";
  public static final String TABLE_DEF_STRING =
          "RPT_NAME:RPT_NAME:S;" +
          "NM_RPT_SQR_NAME:NM_RPT_SQR_NAME:S;" +
          "NM_RPT_SQR_VER:NM_RPT_SQR_VER:S;" +
          "TXT_RPT_FULL_NAME:TXT_RPT_FULL_NAME:S;" +
          "PARM_COUNT:PARM_COUNT:I;";
}
