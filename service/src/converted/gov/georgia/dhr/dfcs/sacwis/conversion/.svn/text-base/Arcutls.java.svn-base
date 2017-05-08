package gov.georgia.dhr.dfcs.sacwis.conversion;
/**************************************************************************
**
** Title:
**  ARCUTLS.H
**
** Facility:
**  Utilities (UTL) - Server
**
** Abstract:
**  Prototypes and literals for the Utilities facility.
**
** Environment:
**  HP UX 9.04
**  ORCALE Pro*C 1.5
**
** Date Created:
**  10/26/93
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/28/94  kingwr    Added prototype for ARC_UTLGetDateAndTime.
**  12/12/94  wallaceb  Added indicator variable to prototypes
**  12/12/94  wallaceb  Added prototypes for ARC_UTLHostToNumber and
**                      ARC_UTLNumberToHost
**  12/22/94  wallaceb  Added prototypes for ARC_UTLHostToTimestamp and
**                      ARC_UTLTimestampToHost
**  12/27/94  wallaceb  Added prototypes for ARC_UTLHostToBLOB and
**                      ARC_UTLBLOBToHost
**  02/10/95  wallaceb  Added prototype for ARC_UTLCompareDateAndTime and
**                      define for ARC_UTL_MINUTES_IN_DAY
**  03/28/95  wallaceb  Added prototype for ARC_UTLWriteAuditRec and
**                      #define'd ARC_UTL_AUDIT_ERR.
**  05/09/95  wallacbe  Changed error base to 31500 from 35500
**  05/14/95  wallacbe  Changed error base to 13500 from 35500.
**                      Added defines for Form data types.
**                      Added ARC_UTLGetConfigEntry and
**                      ARC_UTLConnectToOracle prototypes and the associated
**                      error code defines for these functions.
**  07/21/95  wallacbe  Added ARC_UTLGetTimestampInOracleFormat prototype.
**  09/08/95  wallacbe  Added ARC_UTLAddToDate prototype.
**  12/27/95  wallacbe  Added ARC_UTLGetAge prototype.
**  03/25/96  wallacbe  Added ARC_UTLGetDecode prototype and ARC_UTL_DECODE
**                      _ERROR define.
**  08/14/96  odonnerj  Added ARC_UTL_DATE_TOO_SMALL Error Code SIR 21795
**          And #define for min year 1850
**  09/25/96  vencilja  Changed ARC_UTLWriteAuditRecord to take in
**                      szStatement instead of iMaxComponents
**  11/1/00   PCG       Added prototype for ARC_UTLCalcAgeFromDate.
**	03/25/03  Srini		Added sqlca.h to the includes to get rid of the warnings.
**
**  02/04/05  Codreaa   SIR#23384
**                      Added LOG_ULOG_RECORD macro. It writes the same info
**                      like LOG_AUDIT_RECORD, but in ulog. It is called by
**                      the DAMs with embedded dynamic sql,in case of error.
**                      It is needed in order to get more info on ORA error
**                      messages that show up on ulog.
**
**************************************************************************/
public class Arcutls {
    /**************************************************************************
    ** Constants
    **************************************************************************/
    public static final int ARC_UTL_MINUTES_IN_DAY = 1440;
    
    public static final int ARC_UTL_MAX_YEAR = 4712;
    public static final int ARC_UTL_MAX_MONTH = 12;
    public static final int ARC_UTL_MAX_DAY = 31;
    
    public static final int ARC_UTL_MIN_YEAR_IN_DATABASE = 1850;
    
    public static final int ARC_UTL_TIME_STRING_LEN = 9;
    
    /* The following data type defines are used in the auditing
    functions to specify the type of the data in a variable */
    
    /* Auditing Types */
    public static final int ARC_UTL_CHAR_TYPE = 0x01;
    public static final int ARC_UTL_STRING_TYPE = 0x02;
    public static final int ARC_UTL_INTEGER_TYPE = 0x04;
    public static final int ARC_UTL_HEX_TYPE = 0x08;
    public static final int ARC_UTL_DATE_TYPE = 0x10;
    
    public static final int ARC_UTL_ENTRY_LENGTH = 80;
    
    /**************************************************************************
    ** Return Codes
    **************************************************************************/
    public static final int ARC_UTL_SQL_SUCCESS = 0;
    public static final int ARC_UTL_ERR_BASE = 13500;
    
    public static final int ARC_UTL_SUCCESS = 0;
    public static final int ARC_UTL_ERR_NULL_PARMS = (ARC_UTL_ERR_BASE + 1);
    public static final int ARC_UTL_ERR_INVALID_TIME = (ARC_UTL_ERR_BASE + 2);
    public static final int ARC_UTL_AUDIT_ERR = (ARC_UTL_ERR_BASE + 3);
    public static final int ARC_UTL_GENERAL_FAILURE = (ARC_UTL_ERR_BASE + 4);
    public static final int ARC_UTL_ERR_ENTRY_NOT_FOUND = (ARC_UTL_ERR_BASE + 5);
    public static final int ARC_UTL_ERR_OPENING_CONFIG_FILE = (ARC_UTL_ERR_BASE + 6);
    public static final int ARC_UTL_ERR_ENTRY_IS_BLANK = (ARC_UTL_ERR_BASE + 7);
    public static final int ARC_UTL_ERR_ENTRY_TOO_LARGE = (ARC_UTL_ERR_BASE + 8);
    public static final int ARC_UTL_INVALID_BIRTHDATE = (ARC_UTL_ERR_BASE + 9);
    public static final int ARC_UTL_DECODE_ERROR = (ARC_UTL_ERR_BASE + 10);
    /*SIR# 21795*/
    public static final int ARC_UTL_DATE_TOO_SMALL = (ARC_UTL_ERR_BASE + 11);
}
