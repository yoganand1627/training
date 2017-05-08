package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Code1InStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT01DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT45DO;
/**************************************************************************
**
** Module File:   cint15s.src
**
** Service Name:  CINT15S
**
** Description:   This service calls APIs that interface to a third
**                party software called Code1.  It will take the
**                addess information passed in from the client and
**                attempt to match it against a database of known
**                addresses.  If the address is not found, an error
**                code is sent back to the client, along with a
**                version of the address sent in, in standard United
**                States Postal Service format.  If the address is
**                found, a lookup is done on a database table to match
**                the county returned by Code1 to the county codes
**                that Texas uses.
**
**                There is also a fetch in place to retrieve multiple
**                counties that a partial address could belong to, to
**                maintain functionality of the old system.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/3/95
**
** Programmer:    Mark Dunnagan,
**                Brian Gugliemetti Andersen Consulting
**
** Change History:
** Date     Programmer  Description
** __________   ___________ __________________________________________
** 05/24/95 sooleyag    SIR #501 - Updated code to not attempt to
**              retrieve county codes for out of state
**              addresses.
**
** 06/07/95 sooleyag    SIR #579 - Added code to ensure that
**              county codes retrieved are for validated
**              Code-1 addresses (related to #501).
**
** 06/19/95 sooleyag    Added code to make sure that the out of
**              state check was made on the parsed address
**              if the address could not be validated.
**
** 05/31/96     HUSTONMJ        SIR 5284 Changed number of counties returned
**                              by cint01d to 20 instead of 10.  Some cities
**                              have more than 10 counties associated.
** 07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the line.
** 04/21/03   Srini	   Setting the rc =FND_SUCCESS so that exception is not thrown.
**					   The error is decoded from output object.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* begin webcaps */



public class Cint15s {
    /* end webcaps */
    /*
    ** Extern for version control table.
    */
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int CITY_COUNTY_ENTRIES = 20;
    
    
    
    public static final String szAddrPersAddrStLn1_STRING = "szAddrPersAddrStLn1";
    public static final String szAddrPersAddrStLn2_STRING = "szAddrPersAddrStLn2";
    public static final String szAddrCity_STRING = "szAddrCity";
    public static final String szCdAddrState_STRING = "szCdAddrState";
    public static final String lAddrZip_STRING = "lAddrZip";
    public static final int szAddrPersAddrStLn2_IND = 2;
    public static final int szAddrCity_IND = 3;
    public static final int szCdAddrState_IND = 4;
    public static final int lAddrZip_IND = 5;
    public static final int szCdAddrCounty_IND = 6;
    CINT15SO CINT15S(CINT15SI cint15si) {
        CINT15SO cint15so = new CINT15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Declare XML variables 
        
        int[] errMsg = new int[]{
            0};
        String tmp = null;
        int responseSize = 0;
        int i257 = 0;
        cint15so = new CINT15SO();
        CINT15SI.Code1InStruct Code1InStruct1 = null;
        CINT15SO.Code1OutStruct Code1OutStruct1 = null;
        char bOutOfState = 0;
        Code1InStruct1.setSzAddrPersAddrStLn1(cint15si.Code1InStruct.getSzAddrPersAddrStLn1());
        Code1InStruct1.setSzAddrPersAddrStLn2(cint15si.Code1InStruct.getSzAddrPersAddrStLn2());
        Code1InStruct1.setSzAddrCity(cint15si.Code1InStruct.getSzAddrCity());
        Code1InStruct1.setSzCdAddrState(cint15si.Code1InStruct.getSzCdAddrState());
        Code1InStruct1.setLAddrZip(cint15si.Code1InStruct.getLAddrZip());
        Code1InStruct1.setSzCdAddrCounty(cint15si.Code1InStruct.getSzCdAddrCounty());
        
        rc = ARC_CD1ParseAddress(Code1InStruct1, Code1OutStruct1);
        cint15so.Code1OutStruct[0].setSzAddrPersAddrStLn1(Code1OutStruct1.getSzAddrPersAddrStLn1());
        cint15so.Code1OutStruct[0].setSzAddrPersAddrStLn2(Code1OutStruct1.getSzAddrPersAddrStLn2());
        cint15so.Code1OutStruct[0].setSzAddrCity(Code1OutStruct1.getSzAddrCity());
        cint15so.Code1OutStruct[0].setSzCdAddrState(Code1OutStruct1.getSzCdAddrState());
        cint15so.Code1OutStruct[0].setLAddrZip(Code1OutStruct1.getLAddrZip());
        cint15so.Code1OutStruct[0].setSzSysCode1CntyCode(Code1OutStruct1.getSzSysCode1CntyCode());
        cint15so.Code1OutStruct[0].setUsSysNbrCode1ReturnCode(Code1OutStruct1.getUsSysNbrCode1ReturnCode());
        rc = ARC_CD1ValidateAddress(Code1InStruct1, Code1OutStruct1);
        if (rc == CODE1_ADDRESS_MATCHED || rc == CODE1_ADDRESS_CORRECTED) {
            bOutOfState = (!Code1OutStruct1.getSzCdAddrState().equals(CAPS_DEFAULT_STATE_CD));
        }
        else {
            bOutOfState = (!cint15so.Code1OutStruct[0].getSzCdAddrState().equals(CAPS_DEFAULT_STATE_CD));
        }
        cint15so.Code1OutStruct[1].setSzAddrPersAddrStLn1(Code1OutStruct1.getSzAddrPersAddrStLn1());
        cint15so.Code1OutStruct[1].setSzAddrPersAddrStLn2(Code1OutStruct1.getSzAddrPersAddrStLn2());
        cint15so.Code1OutStruct[1].setSzAddrCity(Code1OutStruct1.getSzAddrCity());
        cint15so.Code1OutStruct[1].setSzCdAddrState(Code1OutStruct1.getSzCdAddrState());
        cint15so.Code1OutStruct[1].setLAddrZip(Code1OutStruct1.getLAddrZip());
        cint15so.Code1OutStruct[1].setSzSysCode1CntyCode(Code1OutStruct1.getSzSysCode1CntyCode());
        cint15so.Code1OutStruct[1].setUsSysNbrCode1ReturnCode(Code1OutStruct1.getUsSysNbrCode1ReturnCode());
        
        if (rc != 0) {
            pServiceStatus.severity = FND_WARNING;
            pServiceStatus.explan_code = rc;
        }
        
        if (Code1OutStruct1.getLAddrZip()[0] != null &&!(bOutOfState != 0)) {
            Code1InStruct1.setLAddrZip(Code1OutStruct1.getLAddrZip());
            rc = ARC_CD1ZipToCounty(Code1InStruct1, Code1OutStruct1);
            if (CODE1_ADDRESS_MATCHED == rc) {
                
                cint15so.Code1OutStruct[1].setSzSysCode1CntyCode(Code1OutStruct1.getSzSysCode1CntyCode());
            }
        }
        
        if (!(bOutOfState != 0)) {
            
            if (rc != 0 && cint15so.Code1OutStruct[0].getSzAddrCity().length() != 0) {
                rc = CallCINT01D(cint15si, cint15so, pServiceStatus);
            }
            else {
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = CallCINT45D(cint15si, cint15so, pServiceStatus);
            }
        }
        else {
            Code1OutStruct1.setSzSysCode1CntyCode(COUNTY_CD_OUT_OF_STATE);
            cint15so.Code1OutStruct[1].setSzSysCode1CntyCode(Code1OutStruct1.getSzSysCode1CntyCode());
            cint15so.CityCountyStruct[0].setSzCdCityTexCnty(Code1OutStruct1.getSzSysCode1CntyCode());
            Code1OutStruct1.setSzAddrCode1County(COUNTY_DCD_OUT_OF_STATE);
            cint15so.Code1OutStruct[1].setSzAddrCode1County(Code1OutStruct1.getSzAddrCode1County());
            cint15so.CityCountyStruct[0].setSzNmCityCnty(Code1OutStruct1.getSzAddrCode1County());
            cint15so.ArchOutputStruct.setUlRowQty(1);
        }
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size
        */
        
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
        */
        
        /*********************************************************************
        ** Call DAMs to copy data from the incoming person tables to the
        ** person tables.
        *********************************************************************/
        
        /*
        ** Copies rows from PERSON table to the INCOMING_PERSON table
        */
        rc = SUCCESS;
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //  Copies rows from the INCOMING_ADDRESS table to the
                // PERSON_ADDRESS table
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // 
                // DON'T REALLY NEED TO POPULATE THIS DATA SINCE WE ARE REALLY 
                // ONLY INTERESTED IN THE PREVIOUS IF CHECK                    
                // pOutputMsg->ROWCINV27SOG01[i].ulIdApsCltFactor =
                // pCINV35DOutputRec->ROWCINV35DO[i].ulIdApsCltFactor;
                // pOutputMsg->ROWCINV27SOG01[i].ulIdEvent =
                // pCINV35DOutputRec->ROWCINV35DO[i].ulIdEvent;
                // pOutputMsg->ROWCINV27SOG01[i].ulIdSituation =
                // pCINV35DOutputRec->ROWCINV35DO[i].ulIdSituation;
                // COPYSZ(pOutputMsg->ROWCINV27SOG01[i].szCdApsClientFactor,
                // pCINV35DOutputRec->ROWCINV35DO[i].szCdApsClientFactor);
                // COPYSZ(pOutputMsg->ROWCINV27SOG01[i].szCdApsCltFactorAns,
                // pCINV35DOutputRec->ROWCINV35DO[i].szCdApsCltFactorAns);
                // pOutputMsg->ROWCINV27SOG01[i].cCdApsClientFactor =
                // pCINV35DOutputRec->ROWCINV35DO[i].cCdApsClientFactor;
                // COPYSZ(pOutputMsg->ROWCINV27SOG01[i].szTxtApsCltFactorCmnts,
                // pCINV35DOutputRec->ROWCINV35DO[i].szTxtApsCltFactorCmnts);
                // 
                
                //  If Answer for retrieved row is "YES", call DAM to scan Outcome
                // Matrix table for possible Actions and Outcomes.
                // if (!strncmp(pOutputMsg->ROWCINV27SOG01[i].szCdApsCltFactorAns,
                // FACTOR_ANSWER_YES, strlen(FACTOR_ANSWER_YES)))
                // {
                // rc = CallCINV42D(
                // pOutputMsg->ROWCINV27SOG01[i].ulIdApsCltFactor,
                // &pOutputMsg->ROWCINV27SOG01[i].bSysIndOutcome,
                // pReturnPB,
                // pServiceStatus,
                // pABHI);
                // switch(rc)
                // {
                // case FND_SUCCESS:
                // break;
                // case SQL_NOT_FOUND:
                // rc = 0;
                // break;
                // default:
                // PROCESS_TUX_RC_ERROR_TRANSACT;
                // }
                // }
                // else
                // {
                // pOutputMsg->ROWCINV27SOG01[i].bSysIndOutcome =
                // OUTCOME_IND_NONE;
                // }
                
                // 
                // memcpy(pOutputMsg->ROWCINV27SOG01[i].tsLastUpdate,
                // pCINV35DOutputRec->ROWCINV35DO[i].tsLastUpdate,
                // sizeof(pOutputMsg->ROWCINV27SOG01[i].tsLastUpdate));
                // 
                
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        };
        return cint15so;
    }

    static int CallCINT01D(CINT15SI * pInputMsg459, CINT15SO pOutputMsg419, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i258 = 0;
        
        /*
        ** Declare local variables
        */
        CINT01DI pCINT01DInputRec = null;
        CINT01DO pCINT01DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT01DInputRec = new CINT01DI();
        pCINT01DOutputRec = new CINT01DO();
        
        if ((pCINT01DInputRec == null) || (pCINT01DOutputRec == null)) {
            
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        pCINT01DInputRec.setSzNmCity(pOutputMsg419.Code1OutStruct[0].getSzAddrCity());
        pCINT01DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCINT01DInputRec.getArchInputStruct().setUlPageSizeNbr(CITY_COUNTY_ENTRIES);
        rc = cint01dQUERYdam(sqlca, pCINT01DInputRec, pCINT01DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i258 = 0;i258 < pCINT01DOutputRec.getArchOutputStruct().getUlRowQty();++i258) {
                    pOutputMsg419.CityCountyStruct[i258].setSzCdCityTexCnty(pCINT01DOutputRec.getROWCINT01DO_ARRAY().getROWCINT01DO(i258).getSzCdCityTexCnty());
                    pOutputMsg419.CityCountyStruct[i258].setSzNmCityCnty(pCINT01DOutputRec.getROWCINT01DO_ARRAY().getROWCINT01DO(i258).getSzNmCityCnty());
                }
                pOutputMsg419.ArchOutputStruct.setUlRowQty(pCINT01DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg419.ArchOutputStruct.setBMoreDataInd(pCINT01DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                break;
                
            case NO_DATA_FOUND:
                
                
                //  Call CMSC15D
                rc = 0;
                pOutputMsg419.ArchOutputStruct.setUlRowQty(0);
                pOutputMsg419.ArchOutputStruct.setBMoreDataInd(pCINT01DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT45D(CINT15SI * pInputMsg460, CINT15SO pOutputMsg420, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        int i259 = 0;
        
        /*
        ** Declare local variables
        */
        CINT45DI pCINT45DInputRec = null;
        CINT45DO pCINT45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT45DInputRec = new CINT45DI();
        pCINT45DOutputRec = new CINT45DO();
        
        if ((pCINT45DInputRec == null) || (pCINT45DOutputRec == null)) {
            
            
            //  If we only get one row back, then the current Investigation
            // stage is the last stage in the case
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        pCINT45DInputRec.setSzCdCityFedCnty(pOutputMsg420.Code1OutStruct[1].getSzSysCode1CntyCode());
        pCINT45DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCINT45DInputRec.getArchInputStruct().setUlPageSizeNbr(CITY_COUNTY_ENTRIES);
        
        /*
        ** Call DAM
        */
        rc = cint45dQUERYdam(sqlca, pCINT45DInputRec, pCINT45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg420.CityCountyStruct[0].setSzCdCityTexCnty(pCINT45DOutputRec.getSzCdCityTexCnty());
                pOutputMsg420.CityCountyStruct[0].setSzNmCityCnty(pCINT45DOutputRec.getSzNmCityCnty());
                pOutputMsg420.ArchOutputStruct.setUlRowQty(1);
                break;
            case NO_DATA_FOUND:
                pOutputMsg420.ArchOutputStruct.setUlRowQty(0);
                //  Do nothing, the output message just returns success or failure
                rc = 0;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
