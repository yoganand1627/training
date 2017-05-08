package gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class MessageByNumberTableDefinition extends TableDefinitionAdapter {

  public static final String KEY_CODE = "NBR_MESSAGE";
  public static final String TABLE_ID = "MESSAGE_BY_NUMBER";
  public static final String TABLE_NAME = "MESSAGE";
  public static final String SQL_STATEMENT =
          "SELECT NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH FROM MESSAGE";
  public static final String TABLE_DEF_STRING = "NBR_MESSAGE:NBR_MESSAGE:I;" +
                                                "TXT_MESSAGE_NAME:TXT_MESSAGE_NAME:S;" +
                                                "TXT_MESSAGE:TXT_MESSAGE:S;" +
                                                "CD_SOURCE:CD_SOURCE:I;" +
                                                "CD_PRESENTATION:CD_PRESENTATION:I;" +
                                                "IND_BATCH:IND_BATCH:S;";

  public MessageByNumberTableDefinition() {
    super(TABLE_ID, TABLE_NAME, SQL_STATEMENT, KEY_CODE, TABLE_DEF_STRING);
  }
}

