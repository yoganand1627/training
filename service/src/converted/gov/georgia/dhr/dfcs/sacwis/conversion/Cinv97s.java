package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV97SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA5DO;
/**************************************************************************
**
** Module File:   CINV97S.SRC
**
** Service Name:  CINV97S
**
** Description: This service is used in the Licensing Invst Conclusion
**              page to validate Facility ID's against the Class DB
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/4/04
**
** Programmer:    Carolyn Douglass
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/






public class Cinv97s {
    
    
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int NULL_DATE = - 1;
    CINV97SO CINV97S(CINV97SI cinv97si) {
        CINV97SO cinv97so = new CINV97SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLGetDateAndTime(cinv97so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCSESA5D(cinv97si, cinv97so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case NO_DATA_FOUND:
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv97si.getArchInputStruct() , cinv97so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv97so;
    }

    static int CallCSESA5D(CINV97SI pInputMsg801, CINV97SO pOutputMsg746, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code   */
        
        /*
        ** Declare local variables
        */
        CSESA5DI pCSESA5DInputRec = null;
        CSESA5DO pCSESA5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSESA5DInputRec = new CSESA5DI();
        pCSESA5DOutputRec = new CSESA5DO();
        pCSESA5DInputRec.setArchInputStruct(pInputMsg801.getArchInputStruct());
        pCSESA5DInputRec.setLNbrRsrcFacilAcclaim(pInputMsg801.getLNbrRsrcFacilAcclaim());
        
        /*
        ** Call DAM
        */
        rc = csesa5dQUERYdam(sqlca, pCSESA5DInputRec, pCSESA5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    pOutputMsg746.getROWCINV97SOG01().setSzNmResource(pCSESA5DOutputRec.getSzNmResource());
                    pOutputMsg746.getROWCINV97SOG01().setLNbrRsrcFacilAcclaim(pCSESA5DOutputRec.getLNbrRsrcFacilAcclaim());
                    
                    pOutputMsg746.getROWCINV97SOG01().setUlIdResource(pCSESA5DOutputRec.getUlIdResource());
                    pOutputMsg746.getROWCINV97SOG01().setSzCdRsrcFacilType(pCSESA5DOutputRec.getSzCdRsrcFacilType());
                    pOutputMsg746.getROWCINV97SOG01().setSzTxtRsrcComments(pCSESA5DOutputRec.getSzTxtRsrcComments());
                    pOutputMsg746.getROWCINV97SOG01().setLNbrFacilPhoneNumber(pCSESA5DOutputRec.getSzNbrRsrcPhn());
                    pOutputMsg746.getROWCINV97SOG01().setLNbrFacilPhoneExtension(pCSESA5DOutputRec.getLNbrFacilPhoneExtension());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrAttn(pCSESA5DOutputRec.getSzAddrRsrcAttn());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrStLn1(pCSESA5DOutputRec.getSzAddrRsrcStLn1());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrStLn2(pCSESA5DOutputRec.getSzAddrRsrcStLn2());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrCity(pCSESA5DOutputRec.getSzAddrRsrcCity());
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrCounty(pCSESA5DOutputRec.getSzCdRsrcCnty());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrState(pCSESA5DOutputRec.getSzCdRsrcState());
                    pOutputMsg746.getROWCINV97SOG01().setSzAddrRsrcAddrZip(pCSESA5DOutputRec.getLAddrRsrcZip());
                }
                break;
                
                //  SIR 3692 - Added error processing to include a msg no rows
                // returned.  If stage = "SVC" then a "graceful" exit will be
                // processed in the window, showing the user a message box, telling
                // them that no data exists for this situation.  If stage is NOT
                // SVC then the standard "non-graceful" Data Error message box
                // will show in the window.
            case NO_DATA_FOUND:
                
                rc = 0;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
