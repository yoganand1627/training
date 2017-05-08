package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN85SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA3DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNI0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNI0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC90DO;
/**************************************************************************
** 
** Module File:   CCMN85S.src
**
** Service Name:  CCMN85S
**
** Description:   Retrieves all principals related to the most recent 
**                stage of the case and the facility associated with
**                the case.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  Feb.28, 1995 
** 
** Programmer:    Matthew Fish        
**
** Change History:    
**
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  6/28/95    RMR       Final unit test clean up.
**
**  10/18/95   AGS       SIR #1820 - Added two additional DAMs (CCMNB5D and
**                       CINT09D).  The first to obtain the prior stage if
**                       exists and then the second to get the NM INCOMING
**                       FACIL NAME for the prior stage or current stage if
**                       there is no prior stage.        
**
**  02/21/96  BRUCKMK    SIR 3207: Retrieve the Name from the Database, rather 
**                       than simply getting it from the InitData.  Therefore, 
**                       populate the WCD and WesMap from the Output Message
**                       and don't populate them from the InitData.  
**
**  04/17/96  OVERENTR   SIR #20478 - Added the Adoption, PAL, and Post
**                       Adoption stages to the list of child specific stages
**                       that will have change in stage name functionality
**                       instead of change in case name functionality.  
**                       Sub Care was the only child specific stage before this
**                       SIR.
**
**  05/19/97  RIOSJA    MHMR Phase III Item 4 - If the case is AFC and two
**                      or more principals are retrieved that have ever had
**                      a role of VC or VP, the AppendEtAlToName function
**                      will append "et al" onto these names even if their
**                      role has changed. These names will serve as potential
**                      case names. Also, the AppendEtAlToName function was
**                      moved from the calling window (CCMN74W) into this
**                      service because "et al" will now be appended upon
**                      retrieving the names. Also, the function was slightly
**                      rewritten to match the same function found in the
**                      Call Decision window (CINT03W). The function in that
**                      window is working properly. Before appending "et al"
**                      to case names longer than 19 characters, the function
**                      AppendEtAlToName should truncate the name to 19
**                      characters. This is necessary because case names
**                      cannot exceed 25 characters, and a case name of 19
**                      characters plus the 6 characters necessary for adding
**                      "et al" will total 25.
**
**  07/15/03  Srini     SIR#18892 - Commented the comparision for CLASSIFICATION_CCL 
**						and CLASSIFICATION_RCL.
**
**  09/08/04 ochumd    Sir#22779 - If the facility name is changed, the user must change 
**                     the case name also.  Case name for CCL and RCL is the Facility 
**                     Name.  Currently,only individuals listed as principles in the person
**                     list display in the Change Case Name drop down box.  
**   
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn85s {
    
    /***************************************************************************
    ** Constants & Global Variables
    ***************************************************************************/
    public static final String CLASSIFICATION_LRC = "LRC";
    public static final String CLASSIFICATION_LCC = "LCC";
    public static final String CLASSIFICATION_RCL = "RCL";
    public static final String CLASSIFICATION_CCL = "CCL";
    public static final String SUBCARE_STAGE = "SUB";
    public static final String ADOPTION_STAGE = "ADO";
    public static final String PAL_STAGE = "PAL";
    public static final String POST_ADOPT_STAGE = "PAD";
    public static final int NM_PERSON_FULL_LEN = 26;
    public static final String CASE_NM_ET_AL = " et al";
    public static final int CASE_NM_ET_AL_LEN = 6;
    public static final String CLASSIFICATION_APS_FAC = "AFC";
    CCMN85SO CCMN85S(CCMN85SI ccmn85si) {
        CCMN85SO ccmn85so = new CCMN85SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i176 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        boolean bLicensingClassification = false;
        rc = ARC_PRFServiceStartTime_TUX(ccmn85si.getArchInputStruct());
        rc = CCMNA3D(ccmn85si, ccmn85so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Call CSEC24D
        */
        rc = CCMNI0D(ccmn85si, ccmn85so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = CCMND7D(ccmn85si, ccmn85so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (0 == ccmn85so.getSzCdStageProgram_ARRAY().getSzCdStageProgram(0).compareTo(CLASSIFICATION_APS_FAC)) {
            rc = CallCLSC90D(ccmn85si, ccmn85so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** SIR #1820 - Begin
        **
        ** Call DAM to get Prior ID Stage if the current case is an LCC,
        ** LRC, RCL or CCL Licensing case.                              
        */
        
        for (i176 = 0;i176 < ccmn85so.getArchOutputStruct().getUlRowQty();i176++) {
            
            if ((ccmn85so.getSzCdStageProgram_ARRAY().getSzCdStageProgram(i176).equals(CLASSIFICATION_LRC)) || (ccmn85so.getSzCdStageProgram_ARRAY().getSzCdStageProgram(i176).equals(CLASSIFICATION_LCC))) {
                rc = Ccmn50s.CallCCMNB5D(ccmn85si, ccmn85so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                bLicensingClassification = true;
                
                break;
            }
        }
        
        if (bLicensingClassification) {
            if (ccmn85so.getUlIdPriorStage() == 0) {
                ccmn85so.setUlIdPriorStage(ccmn85si.getUlIdStage());
            }
            
            //  Call CRES04D
            rc = Ccmn03u.CallCINT09D(ccmn85si, ccmn85so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if ((ccmn85si.getSzCdStage().equals(SUBCARE_STAGE)) || (ccmn85si.getSzCdStage().equals(PAL_STAGE)) || (ccmn85si.getSzCdStage().equals(ADOPTION_STAGE)) || (ccmn85si.getSzCdStage().equals(POST_ADOPT_STAGE))) {
            
            //  Set rc to ARC_SUCCESS
            rc = Ccmn80s.CallCINT40D(ccmn85si, ccmn85so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            //##  return RetVal;
        }
        else {
            rc = Ccmn03u.CallCCMND9D(ccmn85si, ccmn85so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn85si.getArchInputStruct() , ccmn85so.getArchOutputStruct());
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
        return ccmn85so;
    }

    static int CCMNA3D(CCMN85SI pInputMsg357, CCMN85SO pOutputMsg327, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMNA3DI pCCMNA3DInputRec = null;
        CCMNA3DO pCCMNA3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA3DInputRec = new CCMNA3DI();
        pCCMNA3DOutputRec = new CCMNA3DO();
        pCCMNA3DInputRec.setArchInputStruct(pInputMsg357.getArchInputStruct());
        pCCMNA3DInputRec.setUlIdStage(pInputMsg357.getUlIdStage());
        rc = ccmna3dQUERYdam(sqlca, pCCMNA3DInputRec, pCCMNA3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg327.setSzNmFacilInvstFacility(pCCMNA3DOutputRec.getSzNmFacilInvstFacility());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CCMNI0D(CCMN85SI pInputMsg358, CCMN85SO pOutputMsg328, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMNI0DI pCCMNI0DInputRec = null;
        CCMNI0DO pCCMNI0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNI0DInputRec = new CCMNI0DI();
        pCCMNI0DOutputRec = new CCMNI0DO();
        
        pCCMNI0DInputRec.setArchInputStruct(pInputMsg358.getArchInputStruct());
        
        pCCMNI0DInputRec.setUlIdStage(pInputMsg358.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = ccmni0dQUERYdam(sqlca, pCCMNI0DInputRec, pCCMNI0DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg328.setSzNmFacilInvstFacility(pCCMNI0DOutputRec.getSzNmResourceInvstFacility());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CCMND7D(CCMN85SI pInputMsg359, CCMN85SO pOutputMsg329, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i177 = 0;
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMND7DI pCCMND7DInputRec = null;
        CCMND7DO pCCMND7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND7DInputRec = new CCMND7DI();
        pCCMND7DOutputRec = new CCMND7DO();
        pCCMND7DInputRec.setArchInputStruct(pInputMsg359.getArchInputStruct());
        pCCMND7DInputRec.setUlIdCase(pInputMsg359.getUlIdCase());
        pCCMND7DInputRec.setUlIdStage(pInputMsg359.getUlIdStage());
        
        rc = ccmnd7dQUERYdam(sqlca, pCCMND7DInputRec, pCCMND7DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i177 = 0;i177 < pCCMND7DOutputRec.getArchOutputStruct().getUlRowQty();i177++) {
                    pOutputMsg329.getSzNmPersonFull_ARRAY().setSzNmPersonFull(i177, pCCMND7DOutputRec.getROWCCMND7DO_ARRAY().getROWCCMND7DO(i177).getSzNmPersonFull());
                    pOutputMsg329.getSzCdStageProgram_ARRAY().setSzCdStageProgram(i177, pCCMND7DOutputRec.getROWCCMND7DO_ARRAY().getROWCCMND7DO(i177).getSzCdStageProgram());
                    pOutputMsg329.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(i177, pCCMND7DOutputRec.getROWCCMND7DO_ARRAY().getROWCCMND7DO(i177).getSzCdStagePersRole());
                    pOutputMsg329.getUlIdNmPerson_ARRAY().setUlIdNmPerson(i177, pCCMND7DOutputRec.getROWCCMND7DO_ARRAY().getROWCCMND7DO(i177).getUlIdNmPerson());
                }
                pOutputMsg329.getArchOutputStruct().setUlRowQty(pCCMND7DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNB5D(CCMN85SI pInputMsg360, CCMN85SO pOutputMsg330, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMNB5DI pCCMNB5DInputRec = null;
        CCMNB5DO pCCMNB5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB5DInputRec = new CCMNB5DI();
        
        pCCMNB5DOutputRec = new CCMNB5DO();
        pCCMNB5DInputRec.setUlIdStage(pInputMsg360.getUlIdStage());
        
        /*  ** Start Performance Timer  */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ccmnb5dQUERYdam(sqlca, pCCMNB5DInputRec, pCCMNB5DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg330.setUlIdPriorStage(pCCMNB5DOutputRec.getUlIdPriorStage());
        }
        return rc;
    }

    static int CallCINT09D(CCMN85SI pInputMsg361, CCMN85SO pOutputMsg331, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT09DI pCINT09DInputRec = null;
        CINT09DO pCINT09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT09DInputRec = new CINT09DI();
        
        pCINT09DOutputRec = new CINT09DO();
        pCINT09DInputRec.setArchInputStruct(pInputMsg361.getArchInputStruct());
        pCINT09DInputRec.setUlIdStage(pOutputMsg331.getUlIdPriorStage());
        
        /*
        ** Call CMSC14D
        */
        rc = cint09dQUERYdam(sqlca, pCINT09DInputRec, pCINT09DOutputRec);
        
        /*
        ** Analyze error code
        */
        if (rc != 0) {
            //##             ARC_PRFServiceStopTime( pfpb, pRTAF );
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg331.setNmIncmgFacilName(pCINT09DOutputRec.getNmIncmgFacilName());
        }
        return rc;
    }

    static int CallCCMND9D(CCMN85SI pInputMsg362, CCMN85SO pOutputMsg332, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND9DInputRec = new CCMND9DI();
        pCCMND9DOutputRec = new CCMND9DO();
        pCCMND9DInputRec.setUlIdCase(pInputMsg362.getUlIdCase());
        pCCMND9DInputRec.setArchInputStruct(pInputMsg362.getArchInputStruct());
        rc = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg332.setNmPersonHistFull(pCCMND9DOutputRec.getSzNmCase());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT40D(CCMN85SI pInputMsg363, CCMN85SO pOutputMsg333, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(pInputMsg363.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg363.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg333.setNmPersonHistFull(pCINT40DOutputRec.getSzNmStage());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC90D(CCMN85SI pInputMsg364, CCMN85SO pOutputMsg334, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i178 = 0;
        int k = 0;/* SIR#3582 */
        /*
        ** Declare local variables
        */
        String szTempCaseName = new String();
        CLSC90DI pCLSC90DInputRec = null;
        CLSC90DO pCLSC90DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC90DInputRec = new CLSC90DI();
        
        pCLSC90DOutputRec = new CLSC90DO();
        pCLSC90DInputRec.setArchInputStruct(pInputMsg364.getArchInputStruct());
        pCLSC90DInputRec.setUlIdStage(pInputMsg364.getUlIdStage());
        
        rc = clsc90dQUERYdam(sqlca, pCLSC90DInputRec, pCLSC90DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCLSC90DOutputRec.getArchOutputStruct().getUlRowQty() > 1) {
                    
                    
                    
                    //  Loop through all the rows returned and determine
                    // if child has placement characteristics recorded
                    // CdCharCategory == CPL... True then continue if
                    // false (no placement characteristics) then return
                    // error and msg to user
                    // Also copy the placement characteristics so that
                    // they can be loaded as the default selections in
                    // the Child Removal Reason listbox
                    //  SIR#2556: 
                    // Add a counter that is specifically designated for
                    // the CPL characteristics, so that you do not increment
                    // 'i' every time that you loop through.  Only increment
                    // when char is CPL and there is a match.
                    
                    k = pOutputMsg334.getArchOutputStruct().getUlRowQty();
                    
                    for (i178 = 0;i178 < pCLSC90DOutputRec.getArchOutputStruct().getUlRowQty();i178++) {
                        szTempCaseName = pCLSC90DOutputRec.getROWCLSC90DO_ARRAY().getROWCLSC90DO(i178).getSzNmPersonFull();
                        rc = Ccmn20s.AppendEtAlToName(szTempCaseName);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        pOutputMsg334.getSzNmPersonFull_ARRAY().setSzNmPersonFull(k, szTempCaseName);
                        k++;
                        
                    }
                    pOutputMsg334.getArchOutputStruct().getUlRowQty() += pCLSC90DOutputRec.getArchOutputStruct().getUlRowQty();
                    
                }
                
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
        }
        return rc;
        
    }

    
    static int AppendEtAlToName(String szNameToAppend) {
        int sNullPosition = 0;
        String szTempString = new String();
        
        /*
        ** Loop until a NULL is found, indicating the end of the name.
        */
        for (sNullPosition = 0;((sNullPosition < NM_PERSON_FULL_LEN - 1) && (0 != (int) szNameToAppend.charAt(sNullPosition)));sNullPosition++) {
            ;
        }
        if (szNameToAppend.length() < NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN) {
            szNameToAppend += CASE_NM_ET_AL;
        }
        /*
        ** If there is not enough room, truncate the case name to 19 characters
        ** (including the comma). Then append the "et al".
        */
        else {
            szTempString = szNameToAppend;
            szTempString = CStringUtils.setCharAt(szTempString, NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1, null);
            szTempString += CASE_NM_ET_AL;
            szNameToAppend = (char) szTempString;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
