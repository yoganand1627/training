package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES44DO;
/**************************************************************************
** 
** Module File:   cres03s.src
**
** Service Name:  CRES03S - Rsrc Dtl Retrieval
**
** Description:   Retrieval service called within predisplay of Rsrc Dtl 
**                window.  Tables hit: Caps Resource, Rsrc Categories,
**                Rsrc School District, Rsrc Address, Phone and Rsrc Link.
**                In only one instance is a DAM return code of no
**                rows found acceptable:  if the Resource Type is a Hotline
**                and no address records are found.  In this case, since
**                the code used to populate the School District DAM input
**                record is stored on the address table, the School District
**                DAM will not be called.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5 May 95 
** 
** Programmer:    Kymberly J. Maxham and Jason W. Gloor
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   16 Apr 1997 21:59:30  $
**                      $Modtime:   16 Apr 1997 17:30:52  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/20/95  JWG       Modified records,record groups and relevent code.    
**  11/7/95   KJM       SIR 1897: added back HUB field  
**  06/04/96  KJM       Resource Address overhaul:  Added call to cres44d
**                      which checks to see if a resource address ID is
**                      linked to the contract table.
**  04/02/97  CEG       SIR 13618/MHMR Enhancement:  copy MHMR component code
**                      from cres04d output rec to the service output msg.
**
**  02/10/03  Srini D   Populated the new field szCdIncFacilOperBy from the output
**			dam cres04dQuerydam
**
**  03/22/04  LReed     SIR 22639 - Populated the new field szNmLegal from the output
**			dam cres03d.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres03s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String TYPE_HOTLINE = "03";
    public static final String PRIMARY_ADDR_CODE = "01";
    
    public static final int PHONE_INDEX = 1;
    public static final int ADDR_INDEX = 0;
    CRES03SO CRES03S(CRES03SI cres03si) {
        CRES03SO cres03so = new CRES03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i399 = 0;
        int ulRowCounter = 0;/* Used as a row counter for address
        ** and phone loops
        */
        boolean bPrimaryAddress = false;/* Flag to determine if a primary address
        ** exists
        */
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(cres03si.getArchInputStruct());
        rc = Cfad08s.CallCRES04D(cres03si, cres03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCRES14D(cres03si, cres03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Call CSES81D
        */
        rc = CallCRES15D(cres03si, cres03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCRES38D(cres03si, cres03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCRES39D(cres03si, cres03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        rc = CallCRES13D(cres03si, cres03so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case SUCCESS:
                rc = CallCRES44D(cres03si, cres03so, cres03so.getUlRowQty_ARRAY().getUlRowQty(ADDR_INDEX) , pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  loop through the returned address records to find
                // the primary one, which has the school district code
                // used in the Sch Dist retrieval.  If the primary address
                // record has no sch dist code, then the sch dist DAM
                // is not called.
                
                for (ulRowCounter = 0;ulRowCounter < cres03so.getUlRowQty_ARRAY().getUlRowQty(ADDR_INDEX);ulRowCounter++) {
                    if (!(cres03so.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(ulRowCounter).getSzCdRsrcAddrType().compareTo(PRIMARY_ADDR_CODE) != 0)) {
                        bPrimaryAddress = true;
                        
                        break;
                    }
                }
                if (cres03so.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(ulRowCounter).getSzCdRsrcAddrSchDist()[0] != null) {
                    rc = CallCRES08D(cres03si, cres03so, cres03so.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(ulRowCounter).getSzCdRsrcAddrSchDist() , pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                break;
            case NO_DATA_FOUND:
                //  Call CLSS68D:
                // SELECT * FROM CONTRACT_COUNTY C WHERE C.ID_CONTRACT =
                // AND C.NBR_CNCNTY_PERIOD  =        AND C.NBR_CNCNTY_VERSION =
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cres03si.getArchInputStruct() , cres03so.getArchOutputStruct());
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
        return cres03so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = CRES03S_XLT_OUT;
        pOutputMsgTransMap.map_version = WtcHelperConstants.MAP_VERSION;
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCRES04D(CRES03SI pInputMsg804, CRES03SO pOutputMsg749, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        CRES04DI pCRES04DInputRec = null;/* input record */
        CRES04DO pCRES04DOutputRec = null;/* output record */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        
        
        pCRES04DOutputRec = new CRES04DO();
        pCRES04DInputRec.setArchInputStruct(pInputMsg804.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(pInputMsg804.getUlIdResource());
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        
        switch (rc) {
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg749.setUlIdResource(pInputMsg804.getUlIdResource());
                pOutputMsg749.setSzNmResource(pCRES04DOutputRec.getSzNmResource());
                pOutputMsg749.setSzTxtRsrcComments(pCRES04DOutputRec.getSzTxtRsrcComments());
                pOutputMsg749.setSzCdRsrcCampusType(pCRES04DOutputRec.getSzCdRsrcCampusType());
                pOutputMsg749.setLNbrSchCampusNbr(pCRES04DOutputRec.getLNbrSchCampusNbr());
                pOutputMsg749.setSzCdRsrcStatus(pCRES04DOutputRec.getSzCdRsrcStatus());
                pOutputMsg749.setLNbrRsrcFacilAcclaim(pCRES04DOutputRec.getLNbrRsrcFacilAcclaim());
                pOutputMsg749.setSzCdRsrcType(pCRES04DOutputRec.getSzCdRsrcType());
                pOutputMsg749.setSzCdRsrcOwnership(pCRES04DOutputRec.getSzCdRsrcOwnership());
                pOutputMsg749.setSzNmRsrcContact(pCRES04DOutputRec.getSzNmRsrcContact());
                pOutputMsg749.setSzCdRsrcFacilType(pCRES04DOutputRec.getSzCdRsrcFacilType());
                pOutputMsg749.setSzCdRsrcMaintainer(pCRES04DOutputRec.getSzCdRsrcMaintainer());
                
                //  SIR 22284 - added references for DAMs CINT74D, CCMN45D, CINT58D, CCMN43D
                pOutputMsg749.setCIndRsrcTransport(pCRES04DOutputRec.getCIndRsrcTransport());
                pOutputMsg749.setSzNmRsrcLastUpdate(pCRES04DOutputRec.getSzNmRsrcLastUpdate());
                pOutputMsg749.setSzCdRsrcHub(pCRES04DOutputRec.getSzCdRsrcHub());
                
                pOutputMsg749.setSzCdMhmrCompCode(pCRES04DOutputRec.getSzCdMhmrCompCode());
                pOutputMsg749.setSzCdIncFacilOperBy(pCRES04DOutputRec.getSzCdRsrcOperBy());
                pOutputMsg749.setSzNmLegal(pCRES04DOutputRec.getSzNmLegal());
                pOutputMsg749.setTsLastUpdate(pCRES04DOutputRec.getTsLastUpdate());
                
                pOutputMsg749.setDtScrDtRsrcLastUpdate(pCRES04DOutputRec.getDtScrDtRsrcLastUpdate());
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES08D(CRES03SI pInputMsg805, CRES03SO pOutputMsg750, String szSchDistCode, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        CRES08DI pCRES08DInputRec = null;/* input record */
        CRES08DO pCRES08DOutputRec = null;/* output record   */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES08DInputRec = new CRES08DI();
        
        
        pCRES08DOutputRec = new CRES08DO();
        pCRES08DInputRec.setArchInputStruct(pInputMsg805.getArchInputStruct());
        pCRES08DInputRec.setSzCdSchDist(szSchDistCode);
        
        /*
        ** Call DAM
        */
        rc = cres08dQUERYdam(sqlca, pCRES08DInputRec, pCRES08DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg750.setSzTxtSchDistName(pCRES08DOutputRec.getSzTxtSchDistName());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES13D(CRES03SI pInputMsg806, CRES03SO pOutputMsg751, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i400 = 0;
        
        /*
        ** Declare local variables
        */
        CRES13DI pCRES13DInputRec = null;
        CRES13DO pCRES13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES13DInputRec = new CRES13DI();
        pCRES13DOutputRec = new CRES13DO();
        pCRES13DInputRec.setUlIdResource(pInputMsg806.getUlIdResource());
        pCRES13DInputRec.setArchInputStruct(pInputMsg806.getArchInputStruct());
        
        pCRES13DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = cres13dQUERYdam(sqlca, pCRES13DInputRec, pCRES13DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i400 = 0;i400 < pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();++i400) {
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setUlIdRsrcAddress(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getUlIdRsrcAddress());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setUlIdResource(pCRES13DInputRec.getUlIdResource());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzNbrRsrcAddrVid(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzNbrRsrcAddrVid());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzCdRsrcAddrType(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzCdRsrcAddrType());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzCdRsrcAddrSchDist(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzCdRsrcAddrSchDist());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzAddrRsrcAddrStLn1(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzAddrRsrcAddrStLn1());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzAddrRsrcAddrStLn2(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzAddrRsrcAddrStLn2());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzAddrRsrcAddrAttn(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzAddrRsrcAddrAttn());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzAddrRsrcAddrCity(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzAddrRsrcAddrCity());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzCdFacilityState(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzCdFacilityState());
                    
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzAddrRsrcAddrZip(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzAddrRsrcAddrZip());
                    
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzCdFacilityCounty(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzCdFacilityCounty());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setSzTxtRsrcAddrComments(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getSzTxtRsrcAddrComments());
                    pOutputMsg751.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i400).setTsLastUpdate(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i400).getTsLastUpdate());
                }
                pOutputMsg751.getUlRowQty_ARRAY().setUlRowQty(ADDR_INDEX, pCRES13DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg751.getArchOutputStruct().setBMoreDataInd(pCRES13DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                
                //  Delete the person from the incoming tables if all the
                // previous DAMS were succesful
                if (!(pOutputMsg751.getSzCdRsrcType().compareTo(TYPE_HOTLINE) != 0)) {
                    rc = NO_DATA_FOUND;
                }
                
                else {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES14D(CRES03SI pInputMsg807, CRES03SO pOutputMsg752, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i401 = 0;
        
        /*
        ** Declare local variables
        */
        CRES14DI pCRES14DInputRec = null;
        CRES14DO pCRES14DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES14DInputRec = new CRES14DI();
        pCRES14DOutputRec = new CRES14DO();
        pCRES14DInputRec.setUlIdResource(pInputMsg807.getUlIdResource());
        pCRES14DInputRec.setArchInputStruct(pInputMsg807.getArchInputStruct());
        pCRES14DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCRES14DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES14DO._CRES14DO__ROWCRES14DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = cres14dQUERYdam(sqlca, pCRES14DInputRec, pCRES14DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i401 = 0;i401 < pCRES14DOutputRec.getArchOutputStruct().getUlRowQty();i401++) {
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setUlIdRsrcPhone(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getUlIdRsrcPhone());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setUlIdResource(pCRES14DInputRec.getUlIdResource());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setSzCdFacilPhoneType(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getSzCdFacilPhoneType());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setLNbrFacilPhoneNumber(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getLNbrFacilPhoneNumber());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setLNbrFacilPhoneExtension(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getLNbrFacilPhoneExtension());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setSzTxtRsrcPhoneComments(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getSzTxtRsrcPhoneComments());
                    pOutputMsg752.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(i401).setTsLastUpdate(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i401).getTsLastUpdate());
                }
                pOutputMsg752.getUlRowQty_ARRAY().setUlRowQty(PHONE_INDEX, pCRES14DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg752.getArchOutputStruct().setBMoreDataInd(pCRES14DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES15D(CRES03SI pInputMsg808, CRES03SO pOutputMsg753, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CRES15DI pCRES15DInputRec = null;/* input record  */
        CRES15DO pCRES15DOutputRec = null;/* output record  */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCRES15DInputRec = new CRES15DI();
        
        
        pCRES15DOutputRec = new CRES15DO();
        pCRES15DInputRec.setArchInputStruct(pInputMsg808.getArchInputStruct());
        pCRES15DInputRec.setUIdRsrcLinkChild(pInputMsg808.getUlIdResource());
        rc = cres15dQUERYdam(sqlca, pCRES15DInputRec, pCRES15DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg753.setCScrIndRsrcSub(FND_YES);
                break;
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
            case NO_DATA_FOUND:
                pOutputMsg753.setCScrIndRsrcSub(FND_NO);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES38D(CRES03SI pInputMsg809, CRES03SO pOutputMsg754, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CRES38DI pCRES38DInputRec = null;/* input record  */
        CRES38DO pCRES38DOutputRec = null;/* output record  */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES38DInputRec = new CRES38DI();
        
        
        pCRES38DOutputRec = new CRES38DO();
        pCRES38DInputRec.setArchInputStruct(pInputMsg809.getArchInputStruct());
        pCRES38DInputRec.setUIdRsrcLinkParent(pInputMsg809.getUlIdResource());
        
        /*
        ** Set rc to SQL_SUCCESS
        */
        rc = cres38dQUERYdam(sqlca, pCRES38DInputRec, pCRES38DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg754.setCScrIndRsrcPrime(FND_YES);
                
                // 
                // End call cinv81D
                // 
                
                
                
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg754.setCScrIndRsrcPrime(FND_NO);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES39D(CRES03SI pInputMsg810, CRES03SO pOutputMsg755, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        CRES39DI pCRES39DInputRec = null;/* input record  */
        CRES39DO pCRES39DOutputRec = null;/* output record  */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES39DInputRec = new CRES39DI();
        
        
        pCRES39DOutputRec = new CRES39DO();
        pCRES39DInputRec.setArchInputStruct(pInputMsg810.getArchInputStruct());
        pCRES39DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCRES39DInputRec.setUlIdResource(pInputMsg810.getUlIdResource());
        rc = cres39dQUERYdam(sqlca, pCRES39DInputRec, pCRES39DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCRES39DOutputRec.getUlIdCncnty() != 0) {
                    pOutputMsg755.setCScrIndRsrcContracted(INDICATOR_YES);
                }
                else {
                    pOutputMsg755.setCScrIndRsrcContracted(Cint14s.INDICATOR_NO);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCRES44D(CRES03SI pInputMsg811, CRES03SO pOutputMsg756, int RowQty, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CRES44DI pCRES44DInputRec = null;/* input record */
        CRES44DO pCRES44DOutputRec = null;/* output record   */
        int i402 = 0;
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES44DInputRec = new CRES44DI();
        
        
        pCRES44DOutputRec = new CRES44DO();
        pCRES44DInputRec.setArchInputStruct(pInputMsg811.getArchInputStruct());
        
        
        for (i402 = 0;i402 < RowQty;i402++) {
            pCRES44DInputRec.setUlIdRsrcAddress(pOutputMsg756.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i402).getUlIdRsrcAddress());
            
            rc = cres44dQUERYdam(sqlca, pCRES44DInputRec, pCRES44DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Calculate the date that the todo will be displayed on
                    // the worker's Staff To-Do List.
                    // RIOSJA, SIR 13418 - Child Plans and Adoption Plans do
                    // not function like other modules. Since the worker is
                    // now able to enter the 'Next Review Date', we need to
                    // create a todo for the next review that is due on the
                    // date entered by the worker. The todo should be displayed
                    // one month before the actual due date. The ARC_UTLAddToDate
                    // function cannot accept -1 as an "offset", however, so
                    // we cannot simply subtract one month from the due date
                    // to calculate the display date. We have to pass -2 to
                    // subtract two months (as a workaround), then pass +1
                    // to add one month, and that will give us a date one
                    // month before the actual due date.
                    if (0 != pCRES44DOutputRec.getUsSysNbrNumberOfRows()) {
                        pOutputMsg756.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i402).setCScrIndRsrcContracted(FND_YES);
                    }
                    else {
                        pOutputMsg756.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(i402).setCScrIndRsrcContracted(FND_NO);
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
