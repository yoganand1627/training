package gov.georgia.dhr.dfcs.sacwis.core.validation.wtc;
/**************************************************************************
**
** Title:
**  ARCSRVR.H
**
** Facility:
**  CAPS Technical Architecture (ARC)
**
** Abstract:
**  Declarations and literals for CAPS server (Host) architecture.
**
** Environment:
**  HP Unix 9.0
**  FOUNDATION 2.0 for Unix (Construction, Production)
**  HP UX C/C++ 9.0
**
** Date Created:
**  10/19/94
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/01/94  kingwr    Changed REQ_FUNC_CD's to match macro names used in
**                      Client architecture file.  Also removed inclusion
**                      "arcmsgs.h" file.
**  02/01/94  kingwr    Added macros for calling common functions. Also
**                      added global success return code.
**  02/15/95  wallacbe  Added NULL_DATE define
**  03/29/95  wallacbe  Added LOG_AUDIT_RECORD macro.
**  04/17/95  wallacbe  Changed BAD_FUNC_CD and BAD_PAGE_NUMBER value to be
**                      out of SQL range.
**  04/26/95  wallacbe  Added ARC_GEN_MAX_DATE macro.
**  04/27/95  wallacbe  Added ARC_MAX_DATE_STRING define.
**  05/05/95  wallacbe  Added SQL rollback macros.
**  05/09/95  wallacbe  Changed value of error to be < 32K
**  05/14/95  wallacbe  Changed error values to 13550 + offset
**  09/06/95  wallacbe  Added SQL_PARENT and _CHILD_REF_INTEGRITY defines
**  09/21/95  bwallace  Added ARC_MIN_YEAR, _MONTH, _DAY define's and
**                      Added ARC_MAX_YEAR, _MONTH, _DAY define's
**  10/03/95  gugliebs  Added conditional check for Sybase include file
**                      defines to prevent typedef for BOOL when Sybase
**                      open client header files are included in a
**                      service program.
**  11/06/95  wallacbe  Modified SQL_PARENT and _CHILD_REF_INTEGRITY defines
**                      to be negative rather than positive.
**  08/20/96  odonnerj  SIR# 21795 - the minimum year is now 1850 not 0
**
**  02/04/05  Codreaa   SIR# 23384
**                      Added LOG_ULOG_RECORD macro. It writes the same info
**                      like LOG_AUDIT_RECORD, but in ulog. It is called by
**                      the DAMs with embedded dynamic sql,in case of error.
**                      It is needed in order to get more info on ORA error
**                      messages that show up on ulog.
**************************************************************************/
public class WtcHelperConstants {
    
    
    public static final int ARC_SUCCESS = 0;
    
    /*
    ** Add, update, delete indicator definitions
    */
    public static final char REQ_FUNC_CD_ADD = 'A';
    public static final char REQ_FUNC_CD_UPDATE = 'U';
    public static final char REQ_FUNC_CD_DELETE = 'D';
    public static final char REQ_FUNC_CD_SEARCH = 'S';
    public static final char REQ_FUNC_CD_PAGE_UP = 'P';
    public static final char REQ_FUNC_CD_PAGE_DOWN = 'N';
    public static final char REQ_FUNC_CD_LIST = 'L';
    
    public static final int RETRY_ATTEMPTS = 5;
    
    public static final String MAP_VERSION = "01";
    
    
    
    /*
    ** SQL return codes
    */
    public static final int SQL_SUCCESS = 0;
    public static final int SQL_NOT_FOUND = 1403;
    public static final int SQL_DUPLICATE_KEY = - 1;
    public static final int SQL_PARENT_REF_INTEGRITY = - 2291;
    public static final int SQL_CHILD_REF_INTEGRITY = - 2292;
    
    /*
    ** Macros for ORACLE rollback
    */
    public static final String LARGE_ROLLBACK_SEGMENT = "LRBS01";
    
    public static final String SQL_ROLLBACK_SEGMENT_STATEMENT = "SET TRANSACTION USE ROLLBACK SEGMENT %s";
}
