package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**                                    
** Title: 
**  arcxmlerrors.h
** 
** Facility: 
**  Server Side Error Handler Server (TUX)
** 
** Abstract:
**  Prototypes, macros, return codes, datetypes, and literals 
**  for the Error Handler facility.
**
** Environment:
**  HP UX 11.0
**  Tuxedo 8.0
**
** Date Created:
**  05/01/02
**
** Author:
**  Dann Webster
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/24/03   Srini    SIR#18496 - Changed the explan_code from short to int  
**						to take care of values greater than 32768 as we will  
**						get error values greater than 32768
**
**  07/10/03   Srini    SIR#18602 -Added new error handling macros 
**						PROCESS_TUX_RC_ERROR_TRANSACT & PROCESS_TUX_SQL_ERROR_TRANSACT 
**						to take care of the error handling in transaction aware services.
**						Also defined new functions ARC_TUXHandleSQLError_Transact & 
**						ARC_TUXHandleRCError_Transact to go with the above macros.
**************************************************************************/
public class Arcxmlerrors {
    
    public static void PROCESS_TUX_SQL_ERROR_TRANSACT() {
        
        
        
        //  SIR 21130
        // Add logic to determine which stage we are coming from and if
        // it is any stage other than Intake, then we need to see if there
        // is a Conclusion or Closure event and what the status is
        if (!rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC && (rc == Arcutls.ARC_UTL_GENERAL_FAILURE) || (rc == Messages.ARC_ERR_BAD_FUNC_CD) || (rc == Messages.ARC_ERR_BAD_PAGE_NUMBER) || (rc == Arcxmlerrors.ARC_UTL_INVALID_DATE) || (rc == Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL)) {
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , Csub59s.transactionflag);
        }
        else if (rc) {
            ARC_TUXHandleSQLError_Transact(sqlca, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , Csub59s.transactionflag);
        }
        return;
    }

    
    public static void PROCESS_TUX_RC_ERROR_TRANSACT() {
        if (rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC) {
            ARC_TUXHandleRCError_Transact(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , Csub59s.transactionflag);
        }
        else if (rc) {
            ARC_TUXHandleRCError_Transact(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , Csub59s.transactionflag);
        }
        return;
    }

    
    public static void PROCESS_TUX_SQL_ERROR_NOFREE() {
        
        if (!rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC && (rc == Arcutls.ARC_UTL_GENERAL_FAILURE) || (rc == Messages.ARC_ERR_BAD_FUNC_CD) || (rc == Messages.ARC_ERR_BAD_PAGE_NUMBER) || (rc == Arcxmlerrors.ARC_UTL_INVALID_DATE) || (rc == Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL)) {
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else if (rc) {
            ARC_TUXHandleSQLError(sqlca, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        return;
    }

    
    
    public static void PROCESS_TUX_SQL_ERROR() {
        if (!rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC && (rc == Arcutls.ARC_UTL_GENERAL_FAILURE) || (rc == Messages.ARC_ERR_BAD_FUNC_CD) || (rc == Messages.ARC_ERR_BAD_PAGE_NUMBER) || (rc == Arcxmlerrors.ARC_UTL_INVALID_DATE) || (rc == Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL)) {
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else if (rc) {
            ARC_TUXHandleSQLError(sqlca, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        return;
    }

    
    public static UNKNOWN_TYPE PROCESS_XML_PARSE_ERROR() {
        return ARC_TUXHandleXMLParseError(rc, pServiceStatus, XML_GetCurrentLineNumber(parser) , XML_ErrorString(XML_GetErrorCode(parser)) , CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
    }

    
    public static void PROCESS_TUX_RC_ERROR_NOFREE() {
        
        //  OCHUMD   Sir 23212 - the call to cint33d is moved to this location
        // because it now takes input from cint26d.
        if (rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC) {
            ARC_TUXHandleRCError(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else if (rc) {
            ARC_TUXHandleRCError(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        return;
    }

    
    public static void PROCESS_TUX_RC_ERROR() {
        //  Insert ToDo Processing if ToDoFlag[i] equals TRUE
        if (rc == Arcxmlerrors.ARC_ERR_NO_PROC_RC) {
            ARC_TUXHandleRCError(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else if (rc) {
            ARC_TUXHandleRCError(rc, pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
            
        }
        return;
    }

    public static final int TUX_SUCCESS = 0;
    
    public static final int ARC_UTL_INVALID_DATE = 8006;
    public static final int ARC_UTL_YEAR_TOO_SMALL = 13511;
    
    public static final int ARC_XML_SEVERITY_ERROR = 0;
    public static final int ARC_XML_ERR_BASE = 45000;
    public static final int ARC_XML_NO_PARSER_ERROR = 5 + ARC_XML_ERR_BASE;
    public static final int ARC_XML_PARSING_ERROR = 6 + ARC_XML_ERR_BASE;
    public static final int ARC_XML_SQL_EXPLAN_CODE = 7 + ARC_XML_ERR_BASE;
    public static final int ARC_ERR_TUX_BASE = 55000;
    public static final int ARC_ERR_TUX_TPBEGIN_FAILED = (ARC_ERR_TUX_BASE + 5);
    public static final int ARC_ERR_TUX_TPCOMMIT_FAILED = (ARC_ERR_TUX_BASE + 6);
    public static final int ARC_ERR_TUX_TPALLOC_FAILED = (ARC_ERR_TUX_BASE + 7);
    public static final int ARC_ERR_TUX_TPCALL_FAILED = (ARC_ERR_TUX_BASE + 8);
    public static final int ARC_ERR_ERR_BASE = 10000;
    public static final int ARC_ERR_NO_PROC_RC = (ARC_ERR_ERR_BASE + 1);
    public static final int ARC_ERR_INTERNAL_ERROR = (ARC_ERR_ERR_BASE + 3);
    public static final int ARC_ERR_MALLOC_FAILED = (ARC_ERR_ERR_BASE + 4);
    public static final int TUX_DECL_STATUSPARMS = ErrorStatus pServiceStatus;
}
