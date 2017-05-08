package gov.georgia.dhr.dfcs.sacwis.conversion;
/**************************************************************************
**                                    
** File: 
**  ARCCBT.H
** 
** Facility: 
**  Batch Architecture Modules 
** 
** Description:
**  Prototypes and literals for the CAPS Batch Architecture
**
** Environment:
**  HP UX 9.04
**  HP C Compiler A.09.61
**  ORACLE Pro*C 1.5
**
** Date Created:
**  5/30/95
** 
** Change History:
**
** Date     User      Description
** -------- --------- ----------------------------------------------------------
** 01/04/96 GUGLIEBS  Added ARC_CBT_FILE_TRUNCATE_ERROR error message and
**                    cleaned-up file.
**
** 01/16/96 GUGLIEBS  Changed database user/password impactconfig.xml entry
**                    names from Name, Password to BatchDBUser and
**                    BatchDBPassword.
**
** 03/18/96 GUGLIEBS  Added new ARC_CBT_FILE_CORRUPT_ERROR error message
**                    for file length integrity check on RSAM-OPEN.
**
** 
** OLD CHANGE HISTORY:
** --------------------------------------------------------------------------
**    Rev 1.5   Oct 26 1995 19:59:54   hendercr
** Development fix.
** Req:  maheshi
** Revision 1.53  95/10/26  18:57:39  18:57:39  maheshi (Indu Maheshwari)
** Added MAX_ATTACHMENTS
** 
** Revision 1.52  95/10/23  13:59:27  13:59:27  maheshi (Indu Maheshwari)
** Added return code UNLINK failed for reprt.
** 
** Revision 1.51  95/10/22  18:30:20  18:30:20  maheshi (Indu Maheshwari)
** Updated for LONG RAW field
** 
** Revision 1.49  95/10/20  14:55:43  14:55:43  maheshi (Indu Maheshwari)
** Modified RsamEnd paramaeter
** 
** Revision 1.48  95/10/19  14:21:03  14:21:03  maheshi (Indu Maheshwari)
** Added return codes and environment variable constants
** 
**    Rev 1.2   Sep 27 1995 15:51:26   hendercr
** Fixed to add attach option.
** Req:  maheshi
** Revision 1.46  95/08/30  15:50:44  15:50:44  maheshi (Indu Maheshwari)
** Added ARC_CBESendMail parameters
** 
** Revision 1.2  95/08/30  15:49:10  15:49:10  maheshi (Indu Maheshwari)
** Added encode/attach email option
** 
** Revision 1.45  95/08/29  21:09:42  21:09:42  maheshi (Indu Maheshwari)
** Modified RPT parms
** 
** Revision 1.1  95/08/29  21:07:53  21:07:53  maheshi (Indu Maheshwari)
** Initial revision
** 
** Revision 1.44  95/07/10  10:21:08  10:21:08  maheshi (Indu Maheshwari)
** Added database return codes.
** 
** Revision 1.43  95/07/06  15:52:32  15:52:32  maheshi (Indu Maheshwari)
** Fixed return codes.
** 
** Revision 1.42  95/07/06  13:10:48  13:10:48  maheshi (Indu Maheshwari)
** Added SQL_NULL_VALUES
** 
** Revision 1.41  95/07/05  18:49:21  18:49:21  maheshi (Indu Maheshwari)
** Added exit return codes.
** 
** Revision 1.40  95/06/30  12:18:07  12:18:07  maheshi (Indu Maheshwari)
** Added E-MAIL constants - return codes
** 
** Revision 1.39  95/06/30  09:55:09  09:55:09  maheshi (Indu Maheshwari)
** Added RSAM_FILE_NAME_LEN
** 
** Revision 1.38  95/06/30  09:06:56  09:06:56  maheshi (Indu Maheshwari)
** Fixed paramters of CBTLogMessage
** 
** Revision 1.37  95/06/29  11:27:53  11:27:53  maheshi (Indu Maheshwari)
** Added RSAM database return values.
** 
** Revision 1.36  95/06/28  21:45:58  21:45:58  maheshi (Indu Maheshwari)
** Added config file parameter.
** 
** Revision 1.35  95/06/28  08:16:24  08:16:24  maheshi (Indu Maheshwari)
** Added COBOL interface log messages
** 
** Revision 1.34  95/06/27  18:43:33  18:43:33  maheshi (Indu Maheshwari)
** Added Foundation COBOL interface return codes.
** 
** Revision 1.33  95/06/27  16:07:45  16:07:45  maheshi (Indu Maheshwari)
** Changed RSAM COBOL interface return codes in 20000-21000 range
** 
** Revision 1.32  95/06/27  14:05:12  14:05:12  maheshi (Indu Maheshwari)
** Added CBT_TRC_CFG
** 
** Revision 1.31  95/06/27  14:03:33  14:03:33  maheshi (Indu Maheshwari)
** Added trace mode CBT_TRC_CBL
** 
** Revision 1.30  95/06/27  13:51:23  13:51:23  maheshi (Indu Maheshwari)
** ARemoved COBOL interface related constants
** 
** Revision 1.29  95/06/26  20:11:07  20:11:07  maheshi (Indu Maheshwari)
** Added Foundation constants
** 
** Revision 1.28  95/06/26  16:28:29  16:28:29  zitzsk (Stephan Zitz)
** Updated to reflect ncftp ftp architecture
** 
** Revision 1.27  95/06/26  13:37:49  13:37:49  maheshi (Indu Maheshwari)
** Added constants for RSAM
** 
** Revision 1.26  95/06/26  11:08:14  11:08:14  zitzsk (Stephan Zitz)
** Updated for use by cbtsmtp as standalone.
** 
** Revision 1.25  95/06/26  08:59:53  08:59:53  zitzsk (Stephan Zitz)
** added email header (cbtsmtp)
** 
** Revision 1.24  95/06/23  11:55:03  11:55:03  maheshi (Indu Maheshwari)
** Added parameter BatchSvcTimeout in the for configuration file.
** 
** Revision 1.23  95/06/22  18:07:27  18:07:27  maheshi (Indu Maheshwari)
** Added config parameter for file path.
** 
** Revision 1.22  95/06/22  11:02:35  11:02:35  zitzsk (Stephan Zitz)
** added ARC_CBTAben() prototype
** 
** Revision 1.21  95/06/22  10:24:23  10:24:23  maheshi (Indu Maheshwari)
** Changed macro CBT_TRACE
** 
** Revision 1.20  95/06/22  08:48:10  08:48:10  maheshi (Indu Maheshwari)
** Added RSAM parameters
** 
** Revision 1.19  95/06/21  15:57:26  15:57:26  zitzsk (Stephan Zitz)
** updated for logging daemon/facility
** 
** Revision 1.18  95/06/20  15:27:04  15:27:04  maheshi (Indu Maheshwari)
** Added parameters and constants tofor RSAM
** 
** Revision 1.16  95/06/19  15:39:47  15:39:47  maheshi (Indu Maheshwari)
** Added RSAM variables
** 
** Revision 1.15  95/06/19  11:26:14  11:26:14  maheshi (Indu Maheshwari)
** Added return codes - CONFIG_FILE
** 
** Revision 1.14  95/06/19  11:08:59  11:08:59  maheshi (Indu Maheshwari)
** Added config file parameters
** 
** Revision 1.13  95/06/19  10:41:00  10:41:00  zitzsk (Stephan Zitz)
** added config parsing functionality
** 
** Revision 1.11  95/06/16  12:09:28  12:09:28  zitzsk (Stephan Zitz)
** Added MEssaging Daemon prototypes
** 
** Revision 1.10  95/06/13  14:49:09  14:49:09  maheshi (Indu Maheshwari)
** Added prototypes for common database modules
** 
** Revision 1.9  95/06/13  14:24:44  14:24:44  zitzsk (Stephan Zitz)
** fixed _CBT_LOGGING_BLOCK, mod'ed the function prototypes
** 
** Revision 1.8  95/06/12  18:28:30  18:28:30  maheshi (Indu Maheshwari)
** Commented pid_t ipid from arccbt.h
** 
** Revision 1.7  95/06/12  18:09:03  18:09:03  maheshi (Indu Maheshwari)
** Updated the CBT_LOGGING_STRUCTURE
** 
** Revision 1.6  95/06/09  13:14:45  13:14:45  maheshi (Indu Maheshwari)
** Added constants for errorhandler
** 
** Revision 1.5  95/06/08  17:39:22  17:39:22  maheshi (Indu Maheshwari)
** Added CBT_ERROR_BLOCK
** 
** Revision 1.4  95/06/06  18:17:06  18:17:06  maheshi (Indu Maheshwari)
** Added function prototypes for CBTTrace functions
** 
** Revision 1.3  95/06/06  17:48:11  17:48:11  maheshi (Indu Maheshwari)
** Added CBT Trace return codes, constants and variables
** 
** Revision 1.2  95/06/06  16:24:15  16:24:15  maheshi (Indu Maheshwari)
** Added typedef CBTReturnCode
** 
** Revision 1.1  95/06/06  13:53:25  13:53:25  maheshi (Indu Maheshwari)
** Initial revision
** 
**
**************************************************************************/
public class Arccbt {
    
    
    /**************************************************************************
    ** Constants 
    **************************************************************************/
    /* 
    *  Environment variables & constants 
    */
    /* Trace functionality */
    public static final int CBT_TRACE_BUFFER_SIZE = 4096;
    
    public static final String CBT_FILES = "CBT_FILE%d";
    
    public static final char ARC_BAT_DEVL_ENVIRONMENT = 'D';
    public static final int ARC_BAT_FILEPATH_MAX_LEN = 100;
    
    
    /*
    ** Database login format constants
    */
    public static final int ORACLE_MODE = 0;
    public static final int SQR_MODE = 1;
    public static final int MAX_LOGIN_FIELD_LEN = 25;
    
    /* 
    *  Configuration file parameters 
    */
    public static final int CBT_STR_LEN = 128;
    
    /* 
    *  config file parameters 
    */
    
    /* Parameter length */
    public static final int CBT_FILE_PATH_LEN = 128;
    public static final int CBT_ENVIRONMENT_LEN = 12;
    public static final int CBT_SVC_TIMEOUT_LEN = 10;
    public static final int CBT_DBCONFIG_LEN = 64;
    
    /* Error message block constants */
    public static final int CBT_MSG_AREA_LEN = 159;
    
    /* error message application type */
    public static final char CBT_APPL = 'P';
    public static final char CBT_ARCH = 'A';
    public static final char CBT_SQL = 'S';
    
    /* message types */
    public static final int CBT_SEVERITY_OK = 0;
    public static final int CBT_SEVERITY_WARNING = 4;
    public static final int CBT_SEVERITY_ERROR = 8;
    public static final int CBT_SEVERITY_FATAL = 16;
    public static final int CBT_SEVERITY_ACTION = 32;
    public static final int CBT_SEVERITY_INPROG = 64;
    public static final int CBT_SEVERITY_INFO = 132;
    
    /* trace types */
    public static final int CBT_TRC_APPL = 1;
    public static final int CBT_TRC_RSAM = 2;
    public static final int CBT_TRC_CBL = 4;
    public static final int CBT_TRC_EMAIL = 8;
    public static final int CBT_TRC_DBIO = 16;
    public static final int CBT_TRC_PROC = 32;
    public static final int CBT_TRC_FND = 64;
    public static final int CBT_TRC_LOG = 128;
    public static final int CBT_TRC_FTP = 256;
    public static final int CBT_TRC_CFG = 512;
    public static final int CBT_TRC_STEP = 1024;
    public static final int CBT_TRC_RPT = 2048;
    
    public static final int CBT_ALL = 4095;
    
    
    /* Logging constants */
    
    public static final String PIPEFILE = ".LINK";
    public static final String LOGFILEPAT = "cbt%d%d%d%d%d%d.log";
    
    public static final int CMDMSG = 0;
    public static final int CMDSTATUS = 1;
    public static final int CMDERRORS = 2;
    public static final int CMDRMERRS = 3;
    public static final int CMDOOPS = 4;
    public static final int CMDPAUSE = 5;
    public static final int CMDGO = 6;
    public static final int CMDBACKUP = 7;
    public static final int CMDCLEANUP = 8;
    public static final int CMDDEBUG = 254;
    public static final int CMDDIE = 255;
    
    /* Email constants */
    public static final char CARR_RTRN = '\r';
    
    public static final int CBT_INI_LINE_LEN = 256;
    public static final int CBT_INI_ENTRY_LEN = 31;
    public static final char CBT_INI_SEPARATOR = '=';
    public static final int CBT_MAIL_SENDER_LEN = 257;
    public static final int CBT_MAIL_SENDER_NAME_LEN = 41;
    public static final int CBT_MAIL_REPORT_EXT_LEN = 4;
    public static final int CBT_DFLT_GATEWAY_SMTP_PORT = 25;
    public static final String CBT_DFLT_MAIL_SENDER = "none";
    public static final String CBT_DFLT_MAIL_SENDER_NAME = "CAPS BATCH";
    public static final String CBT_DFLT_MAIL_ATTACH_EXT = "CBT";
    public static final int ARC_CBT_HOST_LEN = 65;
    public static final int ARC_CBT_SOCKET_BUF_SIZE = 1024;
    
    public static final int SMTP_REPLY_LINE_LEN = 512;
    public static final int SMTP_REPLY_CODE_LEN = 3;
    public static final String SMTP_REPLY_CODE_READY = "220";
    public static final String SMTP_REPLY_CODE_OK = "250";
    public static final String SMTP_REPLY_CODE_START = "354";
    public static final String SMTP_REPLY_CODE_QUIT = "221";
    public static final String SMTP_COMMAND_HELO_MASK = "HELO %s\r\n";
    public static final String SMTP_COMMAND_MAIL_MASK = "MAIL FROM: <%s>\r\n";
    public static final String SMTP_COMMAND_RCPT_MASK = "RCPT TO:<%s.%s>\r\n";
    public static final String SMTP_COMMAND_DATA = "DATA\r\n";
    public static final String SMTP_COMMAND_QUIT = "QUIT\r\n";
    public static final String SMTP_COMMAND_END = ".\r\n";
    
    public static final int SMTP_NETWORK_LEN = 11;
    public static final int SMTP_POSTOFFICE_LEN = 11;
    public static final int SMTP_USERNAME_LEN = 33;
    public static final int SMTP_MAX_FILE_ATTACH = 8;
    
    
    public static final String ARC_CBT_DATA_HEADER_MASK = "To: \"%s\" <>\r\nFrom: \"%s\" <%s>\r\nSubject: %s.\r\n";
    public static final String ARC_ATTACHMENT_MASK = "X-Ms-Attachment: %s %d 01-01-1990 00:00\r\n";
    public static final String ARC_ATTACHMENT_FORMAT = "[[ REPORT.CBT : 4428 in REPORT.CBT ]]\r\n";
    public static final String ARC_REPORT_ATTACHMENT = "%s \r\n%s \r\n%s \r\n";
    
    /* RSAM constants */
    public static final int CBT_SCRIPT_NAME_SIZE = 8;
    public static final int RSAM_FILE_NAME_LEN = 12;
    
    public static final int RSAM_SAVE_AREA_SIZE = 1500;
    public static final int RSAM_SCRIPT_NAME_SIZE = 9;
    public static final int SQL_OK = 0;
    public static final int SQL_NO_ROWS_FOUND = 1403;
    public static final int SQL_NULL_VALUES = - 1405;
    
    
    /* Call FND service constants */
    public static final String CBT_FND_SERVICE_VER = "20";
    public static final String CBT_FND_ENVIRONMENT = "D1";
    public static final String CBT_FND_MAP_VERSION = "01";
    public static final int CBT_FND_SYST_SHUT_NOW = 115;
    
    /* Restart step constants */
    public static final int CBT_STEP_SELECT = 1;
    public static final int CBT_STEP_INSERT = 2;
    public static final int CBT_STEP_UPDATE = 3;
    public static final int CBT_STEP_DELETE = 4;
    
    
    /**************************************************************************
    ** Return Codes
    **************************************************************************/
    public static final int ARC_CBT_ERR_BASE = 20000;
    
    public static final int ARC_CBT_SUCCESS = 0;
    public static final int ARC_CBT_FAILURE = (ARC_CBT_ERR_BASE + 1);
    public static final int ARC_CBT_INTERNAL_ERROR = (ARC_CBT_ERR_BASE + 2);
    public static final int ARC_CBT_MALLOC_FAILED = (ARC_CBT_ERR_BASE + 3);
    public static final int ARC_CBT_ERROR_TRC_OPEN = (ARC_CBT_ERR_BASE + 4);
    public static final int ARC_CBT_ERROR_TRC_CLOSE = (ARC_CBT_ERR_BASE + 5);
    public static final int ARC_CBT_INVALID_PARMS = (ARC_CBT_ERR_BASE + 6);
    
    public static final int ARC_CBT_DBOPEN_FAILED = (ARC_CBT_ERR_BASE + 7);
    public static final int ARC_CBT_DBCLOSE_FAILED = (ARC_CBT_ERR_BASE + 8);
    
    public static final int ARC_CBT_SQL_ERROR = (ARC_CBT_ERR_BASE + 9);
    public static final int ARC_CBT_NO_PROC_RC = (ARC_CBT_ERR_BASE + 10);
    public static final int ARC_CBT_SCRIPT_NAME_NOT_FOUND = (ARC_CBT_ERR_BASE + 11);
    public static final int ARC_CBT_CONFIG_FILE_NOT_FOUND = (ARC_CBT_ERR_BASE + 12);
    public static final int ARC_CBT_CONFIG_ENTRY_NOT_FOUND = (ARC_CBT_ERR_BASE + 13);
    
    public static final int ARC_CBT_FILE_PATH_NOT_FOUND = (ARC_CBT_ERR_BASE + 15);
    public static final int ARC_CBT_DB_USER_NOT_FOUND = (ARC_CBT_ERR_BASE + 16);
    public static final int ARC_CBT_DB_PASSWORD_NOT_FOUND = (ARC_CBT_ERR_BASE + 17);
    public static final int ARC_CBT_ROLLBACK_SEGMENT_NOT_FOUND = (ARC_CBT_ERR_BASE + 18);
    public static final int ARC_CBT_COMMIT_INTERVAL_NOT_FOUND = (ARC_CBT_ERR_BASE + 19);
    public static final int ARC_CBT_CFG_DBUSER_NOT_FOUND = (ARC_CBT_ERR_BASE + 20);
    public static final int ARC_CBT_CFG_DBPASSWORD_NOT_FOUND = (ARC_CBT_ERR_BASE + 21);
    public static final int ARC_CBT_BATCH_ENVIRONMENT_NOT_FOUND = (ARC_CBT_ERR_BASE + 22);
    public static final int ARC_CBT_INVALID_BATCH_ENVIRONMENT = (ARC_CBT_ERR_BASE + 23);
    
    /* Rsam return codes */
    public static final int ARC_CBT_FILE_CORRUPT_ERROR = (ARC_CBT_ERR_BASE + 48);
    public static final int ARC_CBT_FILE_TRUNCATE_ERROR = (ARC_CBT_ERR_BASE + 49);
    public static final int ARC_CBT_TOO_MANY_FILES = (ARC_CBT_ERR_BASE + 50);
    public static final int ARC_CBT_FILE_OPEN_FAILED = (ARC_CBT_ERR_BASE + 51);
    public static final int ARC_CBT_FILE_READ_FAILED = (ARC_CBT_ERR_BASE + 52);
    public static final int ARC_CBT_FILE_WRITE_FAILED = (ARC_CBT_ERR_BASE + 53);
    public static final int ARC_CBT_FILE_CLOSE_FAILED = (ARC_CBT_ERR_BASE + 54);
    public static final int ARC_CBT_FILE_NOT_OPEN = (ARC_CBT_ERR_BASE + 55);
    public static final int ARC_CBT_FILE_NOT_CLOSED = (ARC_CBT_ERR_BASE + 56);
    public static final int ARC_CBT_INVALID_FILE = (ARC_CBT_ERR_BASE + 57);
    public static final int ARC_CBT_INVALID_FILE_OFFSET = (ARC_CBT_ERR_BASE + 58);
    public static final int ARC_CBT_RSAM_CALLOC_FAILED = (ARC_CBT_ERR_BASE + 59);
    public static final int ARC_CBT_PARM_NULL_BUFFER = (ARC_CBT_ERR_BASE + 60);
    public static final int ARC_CBT_PARM_ZERO_LENGTH = (ARC_CBT_ERR_BASE + 61);
    public static final int ARC_CBT_FILE_FLUSH_ERROR = (ARC_CBT_ERR_BASE + 62);
    public static final int ARC_CBT_FILE_SYNC_ERROR = (ARC_CBT_ERR_BASE + 63);
    public static final int ARC_CBT_FILE_FTELL_ERROR = (ARC_CBT_ERR_BASE + 64);
    public static final int ARC_CBT_FILE_FSEEK_ERROR = (ARC_CBT_ERR_BASE + 65);
    public static final int ARC_CBT_RESTART_FAILED = (ARC_CBT_ERR_BASE + 66);
    public static final int ARC_CBT_FILE_ALREADY_OPEN = (ARC_CBT_ERR_BASE + 67);
    public static final int ARC_CBT_TRUNCATE_FAILED = (ARC_CBT_ERR_BASE + 68);
    public static final int ARC_CBT_ROLLBACK_FAILED = (ARC_CBT_ERR_BASE + 69);
    public static final int ARC_CBT_SAVE_LENGTH_CHANGED = (ARC_CBT_ERR_BASE + 70);
    public static final int ARC_CBT_FILE_NOT_FOUND = (ARC_CBT_ERR_BASE + 71);
    public static final int ARC_CBT_FILE_FREAD_ERROR = (ARC_CBT_ERR_BASE + 72);
    
    /* RSAM Database calls return codes */
    public static final int ARC_CBT_GET_CKPT_INTVL_FAIL = (ARC_CBT_ERR_BASE + 73);
    public static final int ARC_CBT_UPD_DEL_RESTART_FAIL = (ARC_CBT_ERR_BASE + 74);
    public static final int ARC_CBT_UPD_INS_RESTART_FAIL = (ARC_CBT_ERR_BASE + 75);
    public static final int ARC_CBT_DEL_RESTART_ROW_FAIL = (ARC_CBT_ERR_BASE + 76);
    public static final int ARC_CBT_INS_RESTART_ROW_FAIL = (ARC_CBT_ERR_BASE + 77);
    public static final int ARC_CBT_OPEN_CRSR_SELECT_FAIL = (ARC_CBT_ERR_BASE + 78);
    public static final int ARC_CBT_SEL_RESTART_ROW_FAIL = (ARC_CBT_ERR_BASE + 79);
    public static final int ARC_CBT_CLOS_CRSR_SELECT_FAIL = (ARC_CBT_ERR_BASE + 80);
    
    /* Call FND services return codes */
    public static final int ARC_CBT_FND_INIT_FAILURE = (ARC_CBT_ERR_BASE + 100);
    public static final int ARC_CBT_FND_SEND_FAILURE = (ARC_CBT_ERR_BASE + 101);
    public static final int ARC_CBT_FND_SHUT_FAILURE = (ARC_CBT_ERR_BASE + 102);
    public static final int ARC_CBT_FND_SHUTDOWN_RECD = (ARC_CBT_ERR_BASE + 103);
    
    /* Log message return codes */
    public static final int ARC_CBT_FILE_STAT_FAILED = (ARC_CBT_ERR_BASE + 110);
    public static final int ARC_CBT_NOT_A_PIPE = (ARC_CBT_ERR_BASE + 111);
    public static final int ARC_CBT_NO_SERVER = (ARC_CBT_ERR_BASE + 112);
    public static final int ARC_CBT_CREATE_FAIL = (ARC_CBT_ERR_BASE + 113);
    public static final int ARC_CBT_FORK_FAIL = (ARC_CBT_ERR_BASE + 114);
    public static final int ARC_CBT_WRITE_FAIL = (ARC_CBT_ERR_BASE + 115);
    public static final int ARC_CBT_SHORT_WRITE = (ARC_CBT_ERR_BASE + 116);
    
    /* E-Mail interface return codes */
    public static final int ARC_CBT_OPEN_SOCKET_FAILED = (ARC_CBT_ERR_BASE + 120);
    public static final int ARC_CBT_SMTP_INITIAL_RESP_FAILED = (ARC_CBT_ERR_BASE + 121);
    public static final int ARC_CBT_SMTP_HELLO_FAILED = (ARC_CBT_ERR_BASE + 122);
    public static final int ARC_CBT_SEND_SMTP_MAIL_FAILED = (ARC_CBT_ERR_BASE + 123);
    public static final int ARC_CBT_SMTP_RCPT_FAILED = (ARC_CBT_ERR_BASE + 124);
    public static final int ARC_CBT_SEND_SMTP_DATA_FAILED = (ARC_CBT_ERR_BASE + 125);
    public static final int ARC_CBT_COMMON_HEADER_FAILED = (ARC_CBT_ERR_BASE + 126);
    public static final int ARC_CBT_ENCODING_FAILED = (ARC_CBT_ERR_BASE + 127);
    public static final int ARC_CBT_SEND_ATTACHMENT_FAILED = (ARC_CBT_ERR_BASE + 128);
    public static final int ARC_CBT_SEND_DATA_LINES_FAILED = (ARC_CBT_ERR_BASE + 129);
    public static final int ARC_CBT_SEND_SMTP_REPLY_FAILED = (ARC_CBT_ERR_BASE + 130);
    public static final int ARC_CBT_SEND_SMTP_QUIT_FAILED = (ARC_CBT_ERR_BASE + 131);
    public static final int ARC_CBT_SMTP_UNLINK_RPT_FAILED = (ARC_CBT_ERR_BASE + 132);
    
    /* Database return codes */
    public static final int ARC_CBT_DB_CONNECT_FAILED = (ARC_CBT_ERR_BASE + 150);
    public static final int ARC_CBT_DB_DISCONNECT_FAILED = (ARC_CBT_ERR_BASE + 151);
    public static final int ARC_CBT_DB_COMMIT_FAILED = (ARC_CBT_ERR_BASE + 152);
    public static final int ARC_CBT_DB_COMMIT_RELEASE_FAILED = (ARC_CBT_ERR_BASE + 153);
    public static final int ARC_CBT_DB_ROLLBACK_FAILED = (ARC_CBT_ERR_BASE + 154);
    public static final int ARC_CBT_DB_ROLLBACK_REL_FAILED = (ARC_CBT_ERR_BASE + 155);
    
    public static final int ARC_CBT_CONNECT_SOCKET_FAILED = (ARC_CBT_ERR_BASE + 156);
    public static final int ARC_CBT_SEND_SOCKET_FAILURE = (ARC_CBT_ERR_BASE + 157);
    public static final int ARC_CBT_DB_ROLLBACK_SEGMENT_FAILED = (ARC_CBT_ERR_BASE + 158);
    
    /* COBOL Interface return codes */
    /* RSAM COBOL */
    public static final int CBT_RSAM_SUCCESSFUL = 0;
    public static final int CBT_RSAM_SEVERE_ERR = (ARC_CBT_ERR_BASE + 201);
    public static final int CBT_RSAM_FILE_NOT_FOUND = (ARC_CBT_ERR_BASE + 202);
    public static final int CBT_RSAM_INVALID_FILE_TYPE = (ARC_CBT_ERR_BASE + 203);
    public static final int CBT_RSAM_END_OF_FILE = (ARC_CBT_ERR_BASE + 204);
    public static final int CBT_RSAM_INVALID_FUNC_CODE = (ARC_CBT_ERR_BASE + 205);
    
    /* FND services COBOL */
    public static final int CBT_FND_SUCCESSFUL = 0;
    public static final int CBT_FND_MSGINIT_FAILED = (ARC_CBT_ERR_BASE + 210);
    public static final int CBT_FND_MSGSEND_FAILED = (ARC_CBT_ERR_BASE + 211);
    public static final int CBT_FND_MSGSHUT_FAILED = (ARC_CBT_ERR_BASE + 212);
    
    /* Log message COBOL */
    public static final int CBT_LOG_FAILURE = (ARC_CBT_ERR_BASE + 213);
    
    /* 
    ** Return codes - exit from program 
    ** Exit return codes can only be from 0 to 255.
    ** For batch, we will be using negative return codes.
    ** Return codes 1-20 are reserved for Batch Step Numbers
    */
    public static final int ARC_CBT_FAILURE_EXIT = 21;
    
    public static final int ARC_CBT_LOG_INVALID_PARMS = 25;
    public static final int ARC_CBT_LOG_STARTUP_FAILED = 26;
    public static final int ARC_CBT_LOG_MESSAGE_FAILED = 27;
    public static final int ARC_CBT_READ_CONFIG_FAILED = 28;
    public static final int ARC_CBT_LOG_DONE_FAILED = 29;
    
    public static final int ARC_CBT_STEP_INVALID_PARMS = 30;
    public static final int ARC_CBT_APPL_INIT_FAILED = 31;
    public static final int ARC_CBT_APPL_TERM_FAILED = 32;
    public static final int ARC_CBT_STEP_SELECT_FAILED = 33;
    public static final int ARC_CBT_STEP_INSERT_FAILED = 34;
    public static final int ARC_CBT_STEP_UPDATE_FAILED = 35;
    public static final int ARC_CBT_STEP_DELETE_FAILED = 36;
    public static final int ARC_CBT_STEP_ENV_NOT_SET = 37;
    
    int iControl;
}
