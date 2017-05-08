package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CCFC17S.src
**
** Service Name:   CCFC17S
**
** Description:   This service will retrieve all rows from the Education 
**                History table for a given Id_Person.  It will also retrieve
**                the School Addresses from the Caps Resource table for a 
**                given Id_Resource for all Id_Edhist.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1-5-1996 
** 
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:37:28  $
**                      $Modtime:   29 Mar 1996 23:56:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc17s {
    
    
    public static final char IN_STATE = 'I';
    public static final int PAGE_SIZE_ONE = 1;
    CCFC17SO CCFC17S(CCFC17SI ccfc17si) {
        CCFC17SO ccfc17so = new CCFC17SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        /*
        ** Declare local variables
        */
        int rc = FND_SUCCESS;
        int i43 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC49DI pCLSC49DInputRec = null;
        CLSC49DO pCLSC49DOutputRec = null;
        CRES03DI pCRES03DInputRec = null;
        CRES03DO pCRES03DOutputRec = null;
        
        /* Declare FOUNDATION variables  */
        
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Start performance timer for service
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc17si.getArchInputStruct());
        /* If there are any IdStage's in the Input Message
        ** then CCMN52D dam needs to be called to update
        ** the IND_STAGE_PERS_EMP_NEW fields for those IdStage's passed.
        */
        rc = ARC_UTLGetDateAndTime(ccfc17so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC49DInputRec = new CLSC49DI();
        
        pCLSC49DOutputRec = new CLSC49DO();
        pCLSC49DInputRec.setArchInputStruct(ccfc17si.getArchInputStruct());
        pCLSC49DInputRec.setUlIdPerson(ccfc17si.getUlIdPerson());
        pCLSC49DInputRec.getArchInputStruct().setUsPageNbr(ccfc17si.getArchInputStruct().getUsPageNbr());
        pCLSC49DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc17si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc49dQUERYdam(sqlca, pCLSC49DInputRec, pCLSC49DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCFC17SO.ROWCCFC17SOG00 to fields in 
                // CLSC49DO.ROWCLSC49DO
                
                for (i43 = 0;i43 < pCLSC49DOutputRec.getArchOutputStruct().getUlRowQty();i43++) {
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNmEdhistSchDist(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzNmEdhistSchDist());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNmEdhistSchool(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzNmEdhistSchool());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds1(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds1());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds2(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds2());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds3(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds3());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds4(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds4());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds5(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds5());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds6(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds6());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds7(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds7());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistNeeds8(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistNeeds8());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistEnrollGrade(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistEnrollGrade());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzCdEdhistWithdrawnGrade(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzCdEdhistWithdrawnGrade());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistCity(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistCity());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistCnty(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistCnty());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistState(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistState());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistStreetLn1(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistStreetLn1());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistStreetLn2(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistStreetLn2());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistZip(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzAddrEdhistZip());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNbrEdhistPhone(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzNbrEdhistPhone());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNbrEdhistPhoneExt(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzNbrEdhistPhoneExt());
                    
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzTxtEdhistAddrCmnt(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getSzTxtEdhistAddrCmnt());
                    
                    
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setTsLastUpdate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getTsLastUpdate());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setDtDtEdhistEnrollDate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getDtDtEdhistEnrollDate());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setDtDtEdhistWithdrawnDate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getDtDtEdhistWithdrawnDate());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setCIndEdhistTeaSchool(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getCIndEdhistTeaSchool());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setUlIdEdhist(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getUlIdEdhist());
                    ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setUlIdResource(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i43).getUlIdResource());
                }
                ccfc17so.getArchOutputStruct().setBMoreDataInd(pCLSC49DOutputRec.getArchOutputStruct().getBMoreDataInd());
                ccfc17so.getArchOutputStruct().setUlRowQty(pCLSC49DOutputRec.getArchOutputStruct().getUlRowQty());
                
                
                // Retrieve Resource Address for In State/ TEA Certified Schools
                for (i43 = 0;i43 < ccfc17so.getArchOutputStruct().getUlRowQty();i43++) {
                    
                    if (IN_STATE == ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).getCIndEdhistTeaSchool()) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCRES03DInputRec = new CRES03DI();
                        
                        pCRES03DOutputRec = new CRES03DO();
                        pCRES03DInputRec.setArchInputStruct(ccfc17si.getArchInputStruct());
                        pCRES03DInputRec.setUlIdResource(ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).getUlIdResource());
                        
                        pCRES03DInputRec.getArchInputStruct().setUsPageNbr(PAGE_SIZE_ONE);
                        pCRES03DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc17si.getArchInputStruct().getUlPageSizeNbr());
                        //  ISF 052495 - Call following dam as long as Temp Assignments hasn't
                        // used up all of the available rows in output message.
                        rc = cres03dQUERYdam(sqlca, pCRES03DInputRec, pCRES03DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistCnty(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getSzAddrRsrcAddrCounty());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistCity(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getSzAddrRsrcAddrCity());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistState(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getSzAddrRsrcAddrState());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistStreetLn1(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getSzAddrRsrcAddrStLn1());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistStreetLn2(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getSzAddrRsrcAddrStLn2());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzAddrEdhistZip(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getLAddrRsrcZip());
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNbrEdhistPhone(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getLNbrFacilPhoneNumber());
                                
                                //## BEGIN TUX/XML: Declare XML variables 
                                ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(i43).setSzNbrEdhistPhoneExt(pCRES03DOutputRec.getROWCRES03DO_ARRAY().getROWCRES03DO(0).getLNbrFacilPhoneExtension());
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                break;
                        }
                    }
                }
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        /**************************************************************************
        ** OPTIONAL CODE NOTE (END): Calculate Output Message Size for either
        ** a single row retrieval or a Simple retrieval
        **************************************************************************/
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc17si.getArchInputStruct() , ccfc17so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc17so;
    }

}
