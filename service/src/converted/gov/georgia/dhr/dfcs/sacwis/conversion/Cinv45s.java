package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB7DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA5DO;
/**************************************************************************
**
** Module File:   CINV45S.src
**
** Service Name:  CINV45S
**
** Description:   This is the Overall Roles and Disposition Service.
**                It is run when all the allegations in a given stage
**                have been assigned a disposition but no overall disposition
**                has yet been assigned.
**                This service calculates each person's overall role
**                and the stage's overall disposition.
**                Overall roles are saved in STAGE_PERSON_LINK; overall
**                disposition is saved to the appropriate Investigation
**                Conclusion table, based on Program.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  08 JUN 95
**
** Programmer:    Belinda Muse
**
** Archive Information: $Revision:   1.13  $
**                      $Date:   23 Nov 1998 13:57:38  $
**                      $Modtime:   23 Nov 1998 10:59:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/18/95  HUSTONMJ  ERR 1365.  Change calculation of Roles.  Return new
**                      timestamp each time CINVA6D is called.
**
**  10/01/95  ELLITOSL  ERR 1422.  Overall disposition calculation changed.
**                                 Admin closure may only be selected if
**                                 no other dispositions have been selected.
**
**  10/06/95  VISHNUR   SIR 1711   Added a diposition OTHER_FAC with 'OTH'
**                                 which is used only for APS_FACILITY.
**                                 Every where OTHER is used in APS_FACILITY
**                                 it is changed to OTHER_FAC.
**  10/17/95  HUSTONMJ  ERR#1797   After Admin Closure error, skip remaining
**                                 calculations and return to window.
**  11/07/95  YANTISTK  SIR#1710   Add code for CheckStageEventStatus common
**                                 function.
**
**  02/01/96  GLOORJW   SIR #2141  When calculating the overall
**                                 disposition, on the Allegation List
**                                 window, it will be necessary to determine
**                                 if all dispositions are ZZZ (Merged in
**                                 Error).  This is necessary due to the
**                                 new functionality of the Case Merge/Split
**                                 window.  If all dispositions are ZZZ,
**                                 then the message MSG_INV_ALL_DISP_MERGED.
**                                 Otherwise, the service can continue
**                                 normally.  If the disposition is set to
**                                 ZZZ, the person role will be set to
**                                 UNABLE_TO_DETERMINE.
**
**   19Apr96  sladewmf  SIR #20486: Added a qsort of the pData structure
**                      prior to the call to CalcCurrentPersonRole function
**                      within the CalcOverallRoles function so that all of
**                      the roles for the same ulIdPerson are grouped together.
**
**  04/21/96  ODONNERJ  SIR 20541 - WCD_GenericStruct.ldIdTodo is  populated
**                      by the Admin Review window with the Id Stage of the
**                      Admin Review since the WCD_GenericStruct.ulIdStage
**                      sent to the allegation window is actually the
**                      IdStage of the INVESTIGATION STAGE. The ldIdTodo is
**                      passed to cinv45s and cinv47s to trigger
**                      the CheckEventStatus Common Function for the Admin
**                      Review IdStage instead of INVESTIGATION IdStage.
**
**    2May96  sladewmf  SIR #20798: Within the fix for SIR #20486,
**                      I had changed all three dams; for this fix (#20798),
**                      I restored the previous versions of cinva0d and a5d,
**                      and changed cinva9d to return both the ulIdVictim and
**                      the ulIdAllegedPerpetrator, and the dispositions for
**                      each.  I also re-wrote the CalcVictimPerpRole function,
**                      to properly handle CPS, CCL, and RCL VictimPerp's.
**
**   20May96  sladewmf  SIR #21096: Within CalcVictimPerpRole, corrected
**                      array index: was VICTIM_DISP, changed to PERP_DISP.
**
**   28May96  sladewmf  SIR #21444: Modified the CalcVictimPerpRole function
**                                  to handle AFC VictimPerp's.
**
**   30May96  sladewmf  SIR #21497: Added a new function: CalcVictimOnlyRole
**                                  to handle CPS diad's (no perpetrator).
**
**  07/16/96  DYARGR    SIR 21814: Free pPrsnRoleData pointer.
**
**   8/13/96  vanderm   SIR 21968: Database should be restored to its
**                      original state for all AUD sevices which return an
**                      error.  Error handling changed from
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
**  08/21/96  MAXHAMKJ  SIR 22076: moved free() to within the conditional
**                      where the orginal malloc() occurs
**
**  04/28/97  GONZALCE  SIR 13618: Populated cIndFacilSuperintNotif with
**                      CINV17D Output Rec. Changed two variable names to match
**                      C names in DAM files generated from Foundation.  The
**                      variables are:szAddrFacilInvstStr1 and
**                      szAddrFacilInvstStr2
**  07/24/97  GONZALCE  SIR 14170 - Populated the MHMR Component Code in
**                      CINV22DI because previously it was being updated
**                      to NULL.
**  06/09/98  RIOSJA    MHMR Phase III Item 6.4 - VICTIM_DISP array index
**                      was added to each reference to the CdAllegDisposition
**                      variable in an IF statement in the CalcVictimPerpRole
**                      function below. This was done to properly reference
**                      the variable and to alleviate compile errors related
**                      to the missing array index.
**  11/17/1998 PERIL    Added new code "Valid-No Fault" under allegation
**                      Disposition.The code "Valid-No Fault" finding will
**                      fit in the Role hierarchy after Valid and before the
**                      remaining disposition.for eg.,if an alleged perpetrator
**                      is involved in two allegations,one of which is "Valid-No Fault"
**                      and the other is Valid,the role would become DP.If one of the
**                      allegation is "Valid-No Fault" and the other is Invalid,the role
**                      would become NO.A single allegation for an AP which is given a
**                      disposition of "Valid-No Fault" would result in a role of NO.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  08/04/2003  KRD     SIR 18812 - When the Overall Disposition changes, we
**                      need to also clear out the Recommended Action (aka
**                      "the stage closure reason").  This requires us to:
**                          a) Retrieve the existing disposition
**                          b) Compare it to the newly calculated disposition
**                          c) Clear the recommended action, if different
**                      Added code to the main service section and a call to
**                      DAM CAUDA5D.
**
**  08/04/2003  KRD     SIR 18812 - The save service on the Allegation Detail
**                      page clears the overall disposition so, rather than
**                      retrieving the value from the database (the value that
**                      is now NULL), the page now passes the original
**                      value to this service.
**  06/03/2004  gerryc  SIR 16066 - added two new types of dispositions.  Valid
**                      - Reportable Conduct for APS and Confirmed - Reportable
**                      Conduct for AFC.  These will result in an overall
**                      disposition of Valid and Confirmed, respectively.  Roles
**                      for victims, perps, and victim/perps will act similarly
**                      to what happens when a disposition is saved as Valid
**                      or confirmed.
**  07/13/2004  douglacsSIR 22756 - add new fields to licensing_invst_dtl
**
**  07/14/2004  DEJUANR SIR 22983 - The FAMILY_MOVED - MOV dispostion was end dated and 
**                      replaced with UNABLE_TO_COMPLETE - UTC.  MOV has been left in the 
**                      code, but UTC has been added everywhere it is found and is replicating
**                      MOV's behaviour.
**  09/14/2004  DEJUANR SIR 23058 - Add New UTC Person roles UC for when overall dispostion 
**                      is UTC.  Follows the same logic as MOV.
**  02/15/2005  DEJUANR SIR 15495 - Modifed Overall Disposition calcuation
**                      to treat Admin Closure like all the rest of the dispostions.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv45s {
    public static final String CPS = "CPS";
    
    public static final String APS = "APS";
    public static final String APS_FACILITY = "AFC";
    public static final String COMMUNITY_LIC = "CCL";
    public static final String RESIDENTIAL_LIC = "RCL";
    
    /* Roles */
    public static final String ALLEGED_VICTIM = "AV";
    public static final String ALLEGED_PERP = "AP";
    public static final String CLIENT = "CL";
    public static final String DESIGNATED_VICTIM = "DV";
    public static final String DESIGNATED_PERP = "DP";
    public static final String DESIGNATED_BOTH = "DB";
    public static final String NO_ROLE = "NO";
    public static final String UNABLE_TO_DETRMN_ROLE = "UD";
    public static final String UNKNOWN = "UK";
    public static final String UNKNOWN_OR_MOVED = "UM";
    public // SIR 23058
    static final String UNKNOWN_OR_UTC = "UC";
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String VICTIM = "VC";
    public static final String VICTIM_PERP = "VP";
    public static final String PRINCIPAL = "PRN";
    
    /* Dispositions */
    public static final String REASON_TO_BELIEVE = "RTB";
    public static final String UNABLE_TO_DETRMN_DISP = "UTD";
    public static final String FAMILY_MOVED = "MOV";
    public static final String UNABLE_TO_COMPLETE = "UTC";
    public static final String RULED_OUT = "R/O";
    public static final String ADMIN_CLOSURE = "ADM";
    public static final String VALID = "VAL";
    public static final String VALID_NO_FAULT = "VNF";
    public static final String INVALID = "NVL";
    public static final String OTHER = "XXX";
    public static final String CONFIRMED = "CON";
    public static final String UNCONFIRMED = "COU";
    public static final String INCONCLUSIVE = "INC";
    public static final String UNFOUNDED = "UNF";
    public static final String OTHER_FAC = "OTH";
    public static final String CASE_MERGED_IN_ERROR = "ZZZ";
    public static final String VALID_REPORTABLE_CONDUCT = "VRC";
    public static final String CONFIRMED_REPORTABLE_CONDUCT = "CRC";
    
    public static final int VICTIM_DISP = 0;
    public static final int PERP_DISP = 1;
    
    
    /*
    ** SIR #20798: Create new #define's for switching purposes.
    **             Note that these six #define's contain the last
    **             letter of the regular 3-letter #define.
    **             For example, the regular 3-letter #define for RULED_OUT is R/O;
    **             #define for switching purposes is SW_RULED_OUT 'O'.
    */
    public static final char SW_CASE_MERGED_IN_ERROR = 'Z';
    public static final char SW_REASON_TO_BELIEVE = 'B';
    public static final char SW_UNABLE_TO_DETRMN_DISP = 'D';
    public static final char SW_FAMILY_MOVED = 'V';
    public static final char SW_UNABLE_TO_COMPLETE = 'C';
    public static final char SW_RULED_OUT = 'O';
    public static final char SW_ADMIN_CLOSURE = 'M';
    
    public static final int MAX_DISPOSITIONS = 6;
    public static final int MAX_ROLES = 10;
    public static final int MAX_PERSONS = 250;
    CINV45SO CINV45S(CINV45SI cinv45si) {
        boolean goto_END = false;
        CINV45SO cinv45so = new CINV45SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* SIR#1710 */
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 Check Stage/Event common function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        CINVA0DI pCINVA0DInputRec = null;
        CINVA0DO pCINVA0DOutputRec = null;
        CINVA5DI pCINVA5DInputRec = null;
        CINVA5DO pCINVA5DOutputRec = null;
        CINVA6DI pCINVA6DInputRec = null;
        CINVA6DO pCINVA6DOutputRec = null;/* DAM's output becomes input to the  */
        CINVA7DI pCINVA7DInputRec = null;/* next DAM.                          */
        CINVA7DO pCINVA7DOutputRec = null;
        CINVA9DI pCINVA9DInputRec = null;
        CINVA9DO pCINVA9DOutputRec = null;
        /*
        ** Declare local variables
        */
        CINVB1DI pCINVB1DInputRec = null;
        CINVB1DO pCINVB1DOutputRec = null;
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        /*
        ** Declare local variables
        */
        CINV44DI pCINV44DInputRec = null;
        CINV44DO pCINV44DOutputRec = null;
        
        
        /*
        ** T!!!!!!
        */
        CINV74DI pCINV74DInputRec = null;
        CINV74DO pCINV74DOutputRec = null;
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        CINV22DI pCINV22DInputRec = null;
        CINV22DO pCINV22DOutputRec = null;
        CINV24DI pCINV24DInputRec = null;
        CINV24DO pCINV24DOutputRec = null;
        
        CINV53DI pCINV53DInputRec = null;
        CINV53DO pCINV53DOutputRec = null;
        CINVA8DI pCINVA8DInputRec = null;
        CINVA8DO pCINVA8DOutputRec = null;
        CINVB7DI pCINVB7DInputRec = null;
        CINVB7DO pCINVB7DOutputRec = null;
        String[] pDisposition = new String[MAX_DISPOSITIONS];
        /*
        ** Store results in Person Role structure
        */
        for (int pDisposition1 = 0;pDisposition1 < pDisposition.length;pDisposition1++) {
            pDisposition[pDisposition1] = new String();
        }
        String szCdOverallRole1 = new String();
        String szOverallDisposition = new String();
        Prsnroledata pPrsnRoleData = null;
        Ovrlroleedata pOverallRoleData = null;
        
        String tsOverallDisposition = new String();
        
        Pint TotalPersons = new Pint();
        int i366 = 0;
        /*
        ** Update CPS_CHKLST_ITEM table
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv45si.getArchInputStruct());
        
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
        
        /**************************************************************************
        ** SIR#1710
        ** (BEGIN): Common Function: ccmn06u Check Stage/Event common function.
        ***************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv45si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv45si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv45si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv45si.getSzCdTask());
        
        if (cinv45si.getLdIdTodo() != 0) {
            pCCMN06UInputRec.setUlIdStage(cinv45si.getLdIdTodo());
        }
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        
        if (SUCCESS == RetVal) {
            if (!(cinv45si.getSzCdStageProgram().compareTo(CPS) != 0)) {
                // Allocate memory for Input and Output Structures
                pCINV95DInputRec = new CINV95DI();
                
                pCINV95DOutputRec = new CINV95DO();
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(1);
                rc = CallCINV95D(cinv45si, cinv45so, pCINV95DInputRec, pCINV95DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                tsOverallDisposition = pCINV95DOutputRec.getTsLastUpdate();
            }
            
            if (!(cinv45si.getSzCdStageProgram().compareTo(APS) != 0)) {
                // Allocate memory for Input and Output Structures
                pCINV44DInputRec = new CINV44DI();
                
                pCINV44DOutputRec = new CINV44DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(1);
                rc = CallCINV44D(cinv45si, cinv45so, pCINV44DInputRec, pCINV44DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                tsOverallDisposition = pCINV44DOutputRec.getROWCINV44DO().getTsLastUpdate();
            }
            if (!(cinv45si.getSzCdStageProgram().compareTo(APS_FACILITY) != 0)) {
                // Allocate memory for Input and Output Structures
                pCINV17DInputRec = new CINV17DI();
                
                pCINV17DOutputRec = new CINV17DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(1);
                
                //  Call CLSC97D
                rc = CallCINV17D(cinv45si, cinv45so, pCINV17DInputRec, pCINV17DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                tsOverallDisposition = pCINV17DOutputRec.getTsLastUpdate();
                
            }
            
            if (!(cinv45si.getSzCdStageProgram().compareTo(COMMUNITY_LIC) != 0) ||!(cinv45si.getSzCdStageProgram().compareTo(RESIDENTIAL_LIC) != 0)) {
                // Allocate memory for Input and Output Structures
                pCINV74DInputRec = new CINV74DI();
                
                pCINV74DOutputRec = new CINV74DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(1);
                
                rc = CallCINV74D(cinv45si, cinv45so, pCINV74DInputRec, pCINV74DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                tsOverallDisposition = pCINV74DOutputRec.getTsLastUpdate();
            }
            
            //  Retrieve overall roles' timestamps.
            
            // Allocate memory for Input and Output Structures
            pCINVB1DInputRec = new CINVB1DI();
            
            pCINVB1DOutputRec = new CINVB1DO();
            
            pPrsnRoleData = new Prsnroledata();
            
            pOverallRoleData = new Ovrlroleedata();
            cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            cinv45si.getArchInputStruct().setUlPageSizeNbr(CINVB1DO._CINVB1DO__ROWCINVB1DO_SIZE);
            
            rc = CallCINVB1D(cinv45si, cinv45so, pCINVB1DInputRec, pCINVB1DOutputRec, pServiceStatus);
            
            //  An entry exists if the query was successful and 
            // the DAM must update STAGE_PERSON and EMPLOYEE
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    //  Calculate the Overall Disposition using the output from CINVA7D.
                    // If this calculation fails, overall roles will not be calculated.
                    for (i366 = 0;i366 < pCINVB1DOutputRec.getArchOutputStruct().getUlRowQty();i366++) {
                        pPrsnRoleData.ROWPRSNROLEDATA[i366].ulIdPerson = pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i366).getUlIdPerson();
                        pPrsnRoleData.ROWPRSNROLEDATA[i366].tsLastUpdate = pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i366).getTsLastUpdate();
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            //  Retrieve list of unique dispositions for the given ID_STAGE.
            
            // Allocate memory for Input and Output Structures
            pCINVA7DInputRec = new CINVA7DI();
            
            pCINVA7DOutputRec = new CINVA7DO();
            cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            cinv45si.getArchInputStruct().setUlPageSizeNbr(MAX_DISPOSITIONS);
            rc = CallCINVA7D(cinv45si, cinv45so, pCINVA7DInputRec, pCINVA7DOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            for (i366 = 0;i366 < MAX_DISPOSITIONS;i366++) {
                pDisposition[i366] = pCINVA7DOutputRec.getROWCINVA7DO_ARRAY().getROWCINVA7DO(i366).getCdAllegDisposition();
            }
            rc = CalcOverallDisposition(cinv45so, cinv45si.getSzCdStageProgram() , pDisposition, szOverallDisposition, pServiceStatus);
            
            if (Arcxmlerrors.ARC_ERR_INTERNAL_ERROR == rc) {
                
                //  Load translation map with service name and version
                
                //  Stop performance timer for service
                ARC_PRFServiceStopTime_TUX(cinv45si.getArchInputStruct() , cinv45so.getArchOutputStruct());
                rc = SUCCESS;
                goto END;
            }
            
            // 
            // (BEGIN): SIR #2141 If all dispositions are ZZZ exit out of the
            // service and return MSG_INV_ALL_DISP_MERGED as the
            // explan code.
            // 
            else {
                
                if (Messages.MSG_INV_ALL_DISP_MERGED == rc) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_INV_ALL_DISP_MERGED;
                    
                    //  Stop performance timer for service
                    ARC_PRFServiceStopTime_TUX(cinv45si.getArchInputStruct() , cinv45so.getArchOutputStruct());
                    goto_END = true;
                    
                    if (!goto_END) {
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                // 
                // (END): SIR #2141 If all dispositions are ZZZ exit out of the
                // service and return MSG_INV_ALL_DISP_MERGED as the
                // explan code.
                // 
                
                else if (WtcHelperConstants.ARC_SUCCESS != rc) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                if (goto_END) {
                    break;
                }
            }
            
            if (!goto_END) {
                if (!(cinv45si.getSzCdStageProgram().compareTo(CPS) != 0)) {
                    //  Retrieve full row from CPS_INVST_DETAIL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV95DInputRec = new CINV95DI();
                    
                    pCINV95DOutputRec = new CINV95DO();
                    rc = CallCINV95D(cinv45si, cinv45so, pCINV95DInputRec, pCINV95DOutputRec, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Update Overall Disposition in CPS_INVST_DETAIL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINVA8DInputRec = new CINVA8DI();
                    
                    pCINVA8DOutputRec = new CINVA8DO();
                    pCINVA8DInputRec.setSzCdCpsInvstDtlFamIncm(pCINV95DOutputRec.getSzCdCpsInvstDtlFamIncm());
                    pCINVA8DInputRec.setCIndCpsInvstDtlRaNa(pCINV95DOutputRec.getCIndCpsInvstDtlRaNa());
                    pCINVA8DInputRec.setCdCpsOverallDisptn((char far * ) szOverallDisposition);
                    pCINVA8DInputRec.setDtDtCPSInvstDtlAssigned(pCINV95DOutputRec.getDtDtCPSInvstDtlAssigned());
                    pCINVA8DInputRec.setDtDtCPSInvstDtlBegun(pCINV95DOutputRec.getDtDtCPSInvstDtlBegun());
                    pCINVA8DInputRec.setDtDtCpsInvstDtlComplt(pCINV95DOutputRec.getDtDtCpsInvstDtlComplt());
                    pCINVA8DInputRec.setDtDtCPSInvstDtlIntake(pCINV95DOutputRec.getDtDtCPSInvstDtlIntake());
                    pCINVA8DInputRec.setTsLastUpdate(tsOverallDisposition);
                    pCINVA8DInputRec.setUlIdEvent(pCINV95DOutputRec.getUlIdEvent());
                    pCINVA8DInputRec.setUlIdStage(pCINV95DOutputRec.getUlIdStage());
                    pCINVA8DInputRec.setBIndCpsInvstEaConcl(pCINV95DOutputRec.getBIndCpsInvstEaConcl());
                    pCINVA8DInputRec.setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
                    cinv45si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = CallCINVA8D(cinv45si, cinv45so, pCINVA8DInputRec, pCINVA8DOutputRec, pServiceStatus);
                    if (rc != WtcHelperConstants.ARC_SUCCESS) {
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                if (!(cinv45si.getSzCdStageProgram().compareTo(APS) != 0)) {
                    //  Retrieve full row from APS_INVST_DETAIL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV44DInputRec = new CINV44DI();
                    
                    pCINV44DOutputRec = new CINV44DO();
                    rc = CallCINV44D(cinv45si, cinv45so, pCINV44DInputRec, pCINV44DOutputRec, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Update Overall Disposition in APS_INVST_DETAIL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV24DInputRec = new CINV24DI();
                    
                    pCINV24DOutputRec = new CINV24DO();
                    pCINV24DInputRec.setSzCdApsInvstFinalPrty(pCINV44DOutputRec.getROWCINV44DO().getSzCdApsInvstFinalPrty());
                    pCINV24DInputRec.setSzcdApsInvstOvrallDisp((char far * ) szOverallDisposition);
                    pCINV24DInputRec.setDtDtApsInvstBegun(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstBegun());
                    pCINV24DInputRec.setDtDtApsInvstCltAssmt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCltAssmt());
                    pCINV24DInputRec.setDtDtApsInvstCmplt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCmplt());
                    pCINV24DInputRec.setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
                    pCINV24DInputRec.setUlIdStage(pCINV44DOutputRec.getROWCINV44DO().getUlIdStage());
                    pCINV24DInputRec.setTsLastUpdate(tsOverallDisposition);
                    cinv45si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = CallCINV24D(cinv45si, cinv45so, pCINV24DInputRec, pCINV24DOutputRec, pServiceStatus);
                    if (rc != WtcHelperConstants.ARC_SUCCESS) {
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                if (!(cinv45si.getSzCdStageProgram().compareTo(APS_FACILITY) != 0)) {
                    //  Retrieve full row from FACILITY_INVST_DTL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV17DInputRec = new CINV17DI();
                    
                    pCINV17DOutputRec = new CINV17DO();
                    rc = CallCINV17D(cinv45si, cinv45so, pCINV17DInputRec, pCINV17DOutputRec, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Update Overall Disposition in FACILITY_INVST_DTL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV22DInputRec = new CINV22DI();
                    
                    pCINV22DOutputRec = new CINV22DO();
                    pCINV22DInputRec.setCIndFacilSuperintNotif(pCINV17DOutputRec.getCIndFacilSuperintNotif());
                    pCINV22DInputRec.setSzCdMhmrCompCode(pCINV17DOutputRec.getSzCdMhmrCompCode());
                    pCINV22DInputRec.setSzAddrFacilInvstAffAttn(pCINV17DOutputRec.getSzAddrFacilInvstAffAttn());
                    pCINV22DInputRec.setSzAddrFacilInvstAffCity(pCINV17DOutputRec.getSzAddrFacilInvstAffCity());
                    pCINV22DInputRec.setSzAddrFacilInvstAffCnty(pCINV17DOutputRec.getSzAddrFacilInvstAffCnty());
                    pCINV22DInputRec.setSzAddrFacilInvstAffStr1(pCINV17DOutputRec.getSzAddrFacilInvstAffStr1());
                    pCINV22DInputRec.setSzAddrFacilInvstAffStr2(pCINV17DOutputRec.getSzAddrFacilInvstAffStr2());
                    pCINV22DInputRec.setSzAddrFacilInvstAffZip(pCINV17DOutputRec.getSzAddrFacilInvstAffZip());
                    pCINV22DInputRec.setSzAddrFacilInvstAttn(pCINV17DOutputRec.getSzAddrFacilInvstAttn());
                    pCINV22DInputRec.setSzAddrFacilInvstCity(pCINV17DOutputRec.getSzAddrFacilInvstCity());
                    
                    pCINV22DInputRec.setSzAddrFacilInvstCnty(pCINV17DOutputRec.getSzAddrFacilInvstCnty());
                    
                    pCINV22DInputRec.setSzAddrFacilInvstState(pCINV17DOutputRec.getSzAddrFacilInvstState());
                    pCINV22DInputRec.setSzAddrFacilInvstStr1(pCINV17DOutputRec.getSzAddrFacilInvstStr1());
                    pCINV22DInputRec.setSzAddrFacilInvstStr2(pCINV17DOutputRec.getSzAddrFacilInvstStr2());
                    pCINV22DInputRec.setSsAddrFacilInvstZip(pCINV17DOutputRec.getSsAddrFacilInvstZip());
                    pCINV22DInputRec.setSzCdFacilInvstOvrallDis((char far * ) szOverallDisposition);
                    pCINV22DInputRec.setDtDtFacilInvstBegun(pCINV17DOutputRec.getDtDtFacilInvstBegun());
                    pCINV22DInputRec.setDtDtFacilInvstComplt(pCINV17DOutputRec.getDtDtFacilInvstComplt());
                    pCINV22DInputRec.setDtDtFacilInvstIncident(pCINV17DOutputRec.getDtDtFacilInvstIncident());
                    pCINV22DInputRec.setDtDtFacilInvstIntake(pCINV17DOutputRec.getDtDtFacilInvstIntake());
                    pCINV22DInputRec.setUlIdAffilResource(pCINV17DOutputRec.getUlIdAffilResource());
                    pCINV22DInputRec.setUlIdEvent(pCINV17DOutputRec.getUlIdEvent());
                    pCINV22DInputRec.setUlIdFacilResource(pCINV17DOutputRec.getUlIdFacilResource());
                    pCINV22DInputRec.setUlIdStage(pCINV17DOutputRec.getUlIdStage());
                    pCINV22DInputRec.setSzNbrFacilInvstAffilExt(pCINV17DOutputRec.getSzNbrFacilInvstAffilExt());
                    pCINV22DInputRec.setLNbrFacilInvstAffilPhn(pCINV17DOutputRec.getLNbrFacilInvstAffilPhn());
                    pCINV22DInputRec.setSzNbrFacilInvstExtension(pCINV17DOutputRec.getSzNbrFacilInvstExtension());
                    pCINV22DInputRec.setLNbrFacilInvstPhone(pCINV17DOutputRec.getLNbrFacilInvstPhone());
                    pCINV22DInputRec.setSzNmFacilInvstAff(pCINV17DOutputRec.getSzNmFacilInvstAff());
                    pCINV22DInputRec.setSzNmFacilInvstFacility(pCINV17DOutputRec.getSzNmFacilInvstFacility());
                    pCINV22DInputRec.setSzTxtFacilInvstAffilCmnt(pCINV17DOutputRec.getSzTxtFacilInvstAffilCmnt());
                    pCINV22DInputRec.setTsLastUpdate(tsOverallDisposition);
                    pCINV22DInputRec.setSzTxtFacilInvstComments(pCINV17DOutputRec.getSzTxtFacilInvstComments());
                    pCINV22DInputRec.setTmSysTmFacilInvstBeg(pCINV17DOutputRec.getTmSysTmFacilInvstBeg());
                    pCINV22DInputRec.setTmSysTmFacilInvstInc(pCINV17DOutputRec.getTmSysTmFacilInvstInc());
                    pCINV22DInputRec.setTmSysTmFacilInvstInt(pCINV17DOutputRec.getTmSysTmFacilInvstInt());
                    cinv45si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = CallCINV22D(cinv45si, cinv45so, pCINV22DInputRec, pCINV22DOutputRec, pServiceStatus);
                    if (rc != WtcHelperConstants.ARC_SUCCESS) {
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                if (!(cinv45si.getSzCdStageProgram().compareTo(COMMUNITY_LIC) != 0) ||!(cinv45si.getSzCdStageProgram().compareTo(RESIDENTIAL_LIC) != 0)) {
                    //  Retrieve full row from LICENSING_INVST_DTL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV74DInputRec = new CINV74DI();
                    
                    pCINV74DOutputRec = new CINV74DO();
                    
                    //  Start performance timer for service. All performance functions always
                    // return success so there is no need to check status.
                    rc = CallCINV74D(cinv45si, cinv45so, pCINV74DInputRec, pCINV74DOutputRec, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Update Overall Disposition in LICENSING_INVST_DTL.
                    
                    // Allocate memory for Input and Output Structures
                    pCINV53DInputRec = new CINV53DI();
                    
                    pCINV53DOutputRec = new CINV53DO();
                    pCINV53DInputRec.setUlIdEvent(pCINV74DOutputRec.getUlIdEvent());
                    pCINV53DInputRec.setUlIdStage(pCINV74DOutputRec.getUlIdStage());
                    pCINV53DInputRec.setSzCdLicngInvstOvrallDisp((char far * ) szOverallDisposition);
                    pCINV53DInputRec.setDtDtLicngInvstIntake(pCINV74DOutputRec.getDtDtLicngInvstIntake());
                    pCINV53DInputRec.setDtDtLicngInvstAssigned(pCINV74DOutputRec.getDtDtLicngInvstAssigned());
                    pCINV53DInputRec.setDtDtLicngInvstDtlBegun(pCINV74DOutputRec.getDtDtLicngInvstDtlBegun());
                    pCINV53DInputRec.setDtDtLicngInvstComplt(pCINV74DOutputRec.getDtDtLicngInvstComplt());
                    
                    pCINV53DInputRec.setTxtLicngInvstNoncomp(pCINV74DOutputRec.getTxtLicngInvstNoncomp());
                    
                    pCINV53DInputRec.setSzCdLicngInvstCoractn(pCINV74DOutputRec.getSzCdLicngInvstCoractn());
                    pCINV53DInputRec.setTsLastUpdate(tsOverallDisposition);
                    pCINV53DInputRec.setUlIdResource(pCINV74DOutputRec.getUlIdResource());
                    pCINV53DInputRec.setSzNmResource(pCINV74DOutputRec.getSzNmResource());
                    pCINV53DInputRec.setLNbrRsrcFacilAcclaim(pCINV74DOutputRec.getLNbrRsrcFacilAcclaim());
                    pCINV53DInputRec.setSzCdRsrcFacilType(pCINV74DOutputRec.getSzCdRsrcFacilType());
                    pCINV53DInputRec.setSzTxtRsrcComments(pCINV74DOutputRec.getSzTxtRsrcComments());
                    pCINV53DInputRec.setLNbrFacilPhoneNumber(pCINV74DOutputRec.getLNbrFacilPhoneNumber());
                    pCINV53DInputRec.setLNbrFacilPhoneExtension(pCINV74DOutputRec.getLNbrFacilPhoneExtension());
                    pCINV53DInputRec.setSzAddrRsrcAddrAttn(pCINV74DOutputRec.getSzAddrRsrcAddrAttn());
                    pCINV53DInputRec.setSzAddrRsrcAddrStLn1(pCINV74DOutputRec.getSzAddrRsrcAddrStLn1());
                    pCINV53DInputRec.setSzAddrRsrcAddrStLn2(pCINV74DOutputRec.getSzAddrRsrcAddrStLn2());
                    pCINV53DInputRec.setSzAddrRsrcAddrCity(pCINV74DOutputRec.getSzAddrRsrcAddrCity());
                    pCINV53DInputRec.setSzAddrRsrcAddrCounty(pCINV74DOutputRec.getSzAddrRsrcAddrCounty());
                    pCINV53DInputRec.setSzAddrRsrcAddrState(pCINV74DOutputRec.getSzAddrRsrcAddrState());
                    pCINV53DInputRec.setSzAddrRsrcAddrZip(pCINV74DOutputRec.getSzAddrRsrcAddrZip());
                    pCINV53DInputRec.setUlIdAffilResource(pCINV74DOutputRec.getUlIdAffilResource());
                    
                    pCINV53DInputRec.setSzNmAffilResource(pCINV74DOutputRec.getSzNmAffilResource());
                    pCINV53DInputRec.setSzTxtAffilComments(pCINV74DOutputRec.getSzTxtAffilComments());
                    pCINV53DInputRec.setLNbrAffilPhoneNumber(pCINV74DOutputRec.getLNbrAffilPhoneNumber());
                    pCINV53DInputRec.setLNbrAffilPhoneExtension(pCINV74DOutputRec.getLNbrAffilPhoneExtension());
                    pCINV53DInputRec.setSzAffilAddrAttn(pCINV74DOutputRec.getSzAffilAddrAttn());
                    pCINV53DInputRec.setSzAffilAddrStLn1(pCINV74DOutputRec.getSzAffilAddrStLn1());
                    pCINV53DInputRec.setSzAffilAddrStLn2(pCINV74DOutputRec.getSzAffilAddrStLn2());
                    pCINV53DInputRec.setSzAffilAddrCity(pCINV74DOutputRec.getSzAffilAddrCity());
                    pCINV53DInputRec.setSzAffilAddrCounty(pCINV74DOutputRec.getSzAffilAddrCounty());
                    pCINV53DInputRec.setSzAffilAddrState(pCINV74DOutputRec.getSzAffilAddrState());
                    pCINV53DInputRec.setSzAffilAddrZip(pCINV74DOutputRec.getSzAffilAddrZip());
                    pCINV53DInputRec.setUlIdClassFclty(pCINV74DOutputRec.getUlIdClassFclty());
                    pCINV53DInputRec.setUlIdClassAffilFclty(pCINV74DOutputRec.getUlIdClassAffilFclty());
                    pCINV53DInputRec.setLNbrAffilAcclaim(pCINV74DOutputRec.getLNbrAffilAcclaim());
                    pCINV53DInputRec.setLNbrAgency(pCINV74DOutputRec.getLNbrAgency());
                    pCINV53DInputRec.setLNbrBranch(pCINV74DOutputRec.getLNbrBranch());
                    pCINV53DInputRec.setLNbrAffilAgency(pCINV74DOutputRec.getLNbrAffilAgency());
                    pCINV53DInputRec.setLNbrAffilBranch(pCINV74DOutputRec.getLNbrAffilBranch());
                    pCINV53DInputRec.setSzCdAffilFacilType(pCINV74DOutputRec.getSzCdAffilFacilType());
                    cinv45si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = CallCINV53D(cinv45si, cinv45so, pCINV53DInputRec, pCINV53DOutputRec, pServiceStatus);
                    if (rc != WtcHelperConstants.ARC_SUCCESS) {
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                if (0 != cinv45si.getSzCdOverallDisp().compareTo(szOverallDisposition)) {
                    rc = CallCAUDA5D(cinv45si, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Retrieve and Calculate Victim Roles
                // SIR #21497: Added calls to CallCINVB7D and CalcVictimOnlyRole.
                // Allocate memory for Input and Output Structures
                pCINVB7DInputRec = new CINVB7DI();
                
                pCINVB7DOutputRec = new CINVB7DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(CINVB7DO._CINVB7DO__ROWCINVA0DO_SIZE);
                // End Sir 13618 added if condition
                
                //  Call CheckStageEventStatus
                rc = CallCINVB7D(cinv45si, cinv45so, pCINVB7DInputRec, pCINVB7DOutputRec, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        //  Call CCMNB6D to retreive the ID_CASE for the given stage
                        rc = CalcVictimOnlyRole(cinv45si.getSzCdStageProgram() , pCINVB7DOutputRec, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                // Allocate memory for Input and Output Structures
                pCINVA0DInputRec = new CINVA0DI();
                
                pCINVA0DOutputRec = new CINVA0DO();
                
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(CINVA0DO._CINVA0DO__ROWCINVA0DO_SIZE);
                
                //  Call CLSC68D to retreive the ID_CASE for the given stage
                rc = CallCINVA0D(cinv45si, cinv45so, pCINVA0DInputRec, pCINVA0DOutputRec, pServiceStatus);
                
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        // ERR 1421: The following has been added to blank out the disposition.
                        // There is no switch statement because there is no acceptable error.
                        rc = CalcVictimRole(cinv45si.getSzCdStageProgram() , pCINVA0DOutputRec, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Retrieve and Calculate Perp Roles
                
                // Allocate memory for Input and Output Structures
                pCINVA5DInputRec = new CINVA5DI();
                
                pCINVA5DOutputRec = new CINVA5DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(CINVA5DO._CINVA5DO__ROWCINVA5DO_SIZE);
                
                rc = CallCINVA5D(cinv45si, cinv45so, pCINVA5DInputRec, pCINVA5DOutputRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        // Demote the event status
                        rc = CalcPerpRole(cinv45si.getSzCdStageProgram() , pCINVA5DOutputRec, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Retrieve and Calculate Victim/Perp Roles
                
                // Allocate memory for Input and Output Structures
                pCINVA9DInputRec = new CINVA9DI();
                
                pCINVA9DOutputRec = new CINVA9DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(CINVA9DO._CINVA9DO__ROWCINVA9DO_SIZE);
                rc = CallCINVA9D(cinv45si, cinv45so, pCINVA9DInputRec, pCINVA9DOutputRec, pServiceStatus);
                
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        rc = CalcVictimPerpRole(cinv45si.getSzCdStageProgram() , pCINVA9DOutputRec, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Call the Invalidate function
                rc = CalcOverallRoles(cinv45si.getSzCdStageProgram() , pCINVB7DOutputRec, pCINVA0DOutputRec, pCINVA5DOutputRec, pCINVA9DOutputRec, pCINVA6DInputRec, pPrsnRoleData, pOverallRoleData, TotalPersons, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  Update STAGE_PERSON_LINK with Overall Roles.
                
                // Allocate memory for Input and Output Structures
                pCINVA6DInputRec = new CINVA6DI();
                
                pCINVA6DOutputRec = new CINVA6DO();
                cinv45si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cinv45si.getArchInputStruct().setUlPageSizeNbr(TotalPersons.value);
                cinv45si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                rc = CallCINVA6D(cinv45si, cinv45so, pOverallRoleData, pCINVA6DInputRec, pCINVA6DOutputRec, pServiceStatus);
                if (rc != WtcHelperConstants.ARC_SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        if (!(goto_END)) {
            
            //  Load translation map with service name and version
            
            //  Stop performance timer for service
            ARC_PRFServiceStopTime_TUX(cinv45si.getArchInputStruct() , cinv45so.getArchOutputStruct());
        }
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
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
                
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv45so;
    }

    
    static int CallCINVB1D(CINV45SI pInputMsg727, CINV45SO * pOutputMsg677, CINVB1DI pCINVB1DInputRec, CINVB1DO pCINVB1DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        pCINVB1DInputRec.setArchInputStruct(pInputMsg727.getArchInputStruct());
        
        pCINVB1DInputRec.setUlIdStage(pInputMsg727.getUlIdStage());
        pCINVB1DInputRec.setSzCdStagePersType(PRINCIPAL);
        rc = cinvb1dQUERYdam(sqlca, pCINVB1DInputRec, pCINVB1DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB7D(CINV45SI pInputMsg728, CINV45SO * pOutputMsg678, CINVB7DI pCINVB7DInputRec, CINVB7DO pCINVB7DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i367 = 0;
        pCINVB7DInputRec.setArchInputStruct(pInputMsg728.getArchInputStruct());
        pCINVB7DInputRec.setUlIdStage(pInputMsg728.getUlIdStage());
        rc = cinvb7dQUERYdam(sqlca, pCINVB7DInputRec, pCINVB7DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            case NO_DATA_FOUND:
                pCINVB7DOutputRec.getArchOutputStruct().setUlRowQty(0);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA0D(CINV45SI pInputMsg729, CINV45SO * pOutputMsg679, CINVA0DI pCINVA0DInputRec, CINVA0DO pCINVA0DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i368 = 0;
        pCINVA0DInputRec.setArchInputStruct(pInputMsg729.getArchInputStruct());
        
        pCINVA0DInputRec.setUlIdStage(pInputMsg729.getUlIdStage());
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
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
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = cinva0dQUERYdam(sqlca, pCINVA0DInputRec, pCINVA0DOutputRec);
        
        /* Analyze return code */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
            case NO_DATA_FOUND:
                pCINVA0DOutputRec.getArchOutputStruct().setUlRowQty(0);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA5D(CINV45SI pInputMsg730, CINV45SO * pOutputMsg680, CINVA5DI pCINVA5DInputRec, CINVA5DO pCINVA5DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i369 = 0;
        pCINVA5DInputRec.setArchInputStruct(pInputMsg730.getArchInputStruct());
        pCINVA5DInputRec.setUlIdStage(pInputMsg730.getUlIdStage());
        rc = cinva5dQUERYdam(sqlca, pCINVA5DInputRec, pCINVA5DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                pCINVA5DOutputRec.getArchOutputStruct().setUlRowQty(0);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA9D(CINV45SI pInputMsg731, CINV45SO * pOutputMsg681, CINVA9DI pCINVA9DInputRec, CINVA9DO pCINVA9DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i370 = 0;
        pCINVA9DInputRec.setArchInputStruct(pInputMsg731.getArchInputStruct());
        pCINVA9DInputRec.setUlIdStage(pInputMsg731.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cinva9dQUERYdam(sqlca, pCINVA9DInputRec, pCINVA9DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSEC63D (OPS)
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
                //  SQL Not Found Case for Dam CSES68D (OPS)
            case NO_DATA_FOUND:
                pCINVA9DOutputRec.getArchOutputStruct().setUlRowQty(0);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA6D(CINV45SI pInputMsg732, CINV45SO * pOutputMsg682, Ovrlroleedata pOverallRoleData, CINVA6DI pCINVA6DInputRec, CINVA6DO pCINVA6DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i371 = 0;
        pCINVA6DInputRec.setArchInputStruct(pInputMsg732.getArchInputStruct());
        pCINVA6DInputRec.setUlIdStage(pInputMsg732.getUlIdStage());
        
        for (i371 = 0;i371 < pInputMsg732.getArchInputStruct().getUlPageSizeNbr();i371++) {
            pCINVA6DInputRec.setUlIdPerson(pOverallRoleData.ROWOVRLROLEDATA[i371].ulIdPerson);
            pCINVA6DInputRec.setSzCdStagePersRole(pOverallRoleData.ROWOVRLROLEDATA[i371].szCdOverallRole);
            pCINVA6DInputRec.setTsLastUpdate(pOverallRoleData.ROWOVRLROLEDATA[i371].tsOverallRole);
            
            //  Perform Main Processing
            
            // SIR# 22665. if case-from or case-to are pending approval, then exit
            rc = cinva6dAUDdam(sqlca, pCINVA6DInputRec, pCINVA6DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pOverallRoleData.ROWOVRLROLEDATA[i371].tsOverallRole = pCINVA6DOutputRec.getTsLastUpdate();
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    // sir#14411. before anything we need to check to find out if we have to
                    // switch cases
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
            }
        }
        return rc;
    }

    static int CallCINVA7D(CINV45SI pInputMsg733, CINV45SO * pOutputMsg683, CINVA7DI pCINVA7DInputRec, CINVA7DO pCINVA7DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i372 = 0;
        pCINVA7DInputRec.setArchInputStruct(pInputMsg733.getArchInputStruct());
        pCINVA7DInputRec.setUlIdStage(pInputMsg733.getUlIdStage());
        rc = cinva7dQUERYdam(sqlca, pCINVA7DInputRec, pCINVA7DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV17D(CINV45SI pInputMsg734, CINV45SO * pOutputMsg684, CINV17DI pCINV17DInputRec, CINV17DO pCINV17DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        pCINV17DInputRec.setArchInputStruct(pInputMsg734.getArchInputStruct());
        pCINV17DInputRec.setUlIdStage(pInputMsg734.getUlIdStage());
        
        
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  SIR 1470 - Retrieve the current system date
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// break for success of cinv51d (VP)
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  ERR#1675 Retrieve cd_event_status for Inv Concl event
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// break for success of CCMN44
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV44D(CINV45SI pInputMsg735, CINV45SO * pOutputMsg685, CINV44DI pCINV44DInputRec, CINV44DO pCINV44DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        pCINV44DInputRec.setArchInputStruct(pInputMsg735.getArchInputStruct());
        pCINV44DInputRec.setUlIdStage(pInputMsg735.getUlIdStage());
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        
    }

    static int CallCINV74D(CINV45SI pInputMsg736, CINV45SO * pOutputMsg686, CINV74DI pCINV74DInputRec, CINV74DO pCINV74DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        pCINV74DInputRec.setArchInputStruct(pInputMsg736.getArchInputStruct());
        pCINV74DInputRec.setUlIdStage(pInputMsg736.getUlIdStage());
        
        rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        
    }

    static int CallCINV95D(CINV45SI pInputMsg737, CINV45SO * pOutputMsg687, CINV95DI pCINV95DInputRec, CINV95DO pCINV95DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        pCINV95DInputRec.setArchInputStruct(pInputMsg737.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg737.getUlIdStage());
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV22D(CINV45SI pInputMsg738, CINV45SO * pOutputMsg688, CINV22DI pCINV22DInputRec, CINV22DO pCINV22DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        pCINV22DInputRec.setArchInputStruct(pInputMsg738.getArchInputStruct());
        rc = cinv22dAUDdam(sqlca, pCINV22DInputRec, pCINV22DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call CSES80D - Retrieve Contract Period
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                //  Call architecture function to retreive the current date.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV24D(CINV45SI pInputMsg739, CINV45SO * pOutputMsg689, CINV24DI pCINV24DInputRec, CINV24DO pCINV24DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;/* Return code */
        
        pCINV24DInputRec.setArchInputStruct(pInputMsg739.getArchInputStruct());
        
        rc = cinv24dAUDdam(sqlca, pCINV24DInputRec, pCINV24DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV53D(CINV45SI pInputMsg740, CINV45SO * pOutputMsg690, CINV53DI pCINV53DInputRec, CINV53DO pCINV53DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        pCINV53DInputRec.setArchInputStruct(pInputMsg740.getArchInputStruct());
        rc = cinv53dAUDdam(sqlca, pCINV53DInputRec, pCINV53DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:// Svc Auth Retrieve
                break;
            case NO_DATA_FOUND:// Svc Auth Link
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA8D(CINV45SI pInputMsg741, CINV45SO * pOutputMsg691, CINVA8DI pCINVA8DInputRec, CINVA8DO pCINVA8DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        pCINVA8DInputRec.setArchInputStruct(pInputMsg741.getArchInputStruct());
        
        
        
        /*
        ** Start Performance Timer
        */
        rc = cinva8dAUDdam(sqlca, pCINVA8DInputRec, pCINVA8DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CalcVictimOnlyRole(String pProgram, CINVB7DO pVictimOnlyData, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        int j = 0;
        if (!(pProgram.compareTo(CPS) != 0)) {
            for (j = 0;j < pVictimOnlyData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(FAMILY_MOVED) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 Start
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_COMPLETE) != 0)) {
                    
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 End
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        /*
        ** SIR 11973 - Conditionals added to check the type of contract
        ** which is selected first above.  For system generated contracts
        ** the adoptive contract is always first.  However, for converted
        ** foster contracts the foster contract is selected fist.  The new
        ** conditionals check the service codes of the contracts to
        ** determine if it is a foster or adoptive contract.
        */
        
        
        if (!(pProgram.compareTo(COMMUNITY_LIC) != 0) ||!(pProgram.compareTo(RESIDENTIAL_LIC) != 0)) {
            for (j = 0;j < pVictimOnlyData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    
                    // 
                    // Service Macro Definitions
                    // 
                    
                    // 
                    // Function Prototypes
                    // 
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        
        
    }

    static int CalcVictimRole(String pProgram, CINVA0DO pVictimData, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        int j = 0;
        
        /*
        ** If the pointer has a value, free it.
        */
        if (!(pProgram.compareTo(CPS) != 0)) {
            for (j = 0;j < pVictimData.getArchOutputStruct().getUlRowQty();j++) 
            {
                
                if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                    
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(FAMILY_MOVED) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 Start
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_COMPLETE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 End
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        
        if (!(pProgram.compareTo(COMMUNITY_LIC) != 0) ||!(pProgram.compareTo(RESIDENTIAL_LIC) != 0)) {
            for (j = 0;j < pVictimData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                    
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        
        if (!(pProgram.compareTo(APS_FACILITY) != 0)) {
            for (j = 0;j < pVictimData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CONFIRMED) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if // SIR 16066
                (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CONFIRMED_REPORTABLE_CONDUCT) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(DESIGNATED_VICTIM);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNCONFIRMED) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(INCONCLUSIVE) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(UNKNOWN);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(UNFOUNDED) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(OTHER_FAC) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (!(pProgram.compareTo(APS) != 0)) {
            for (j = 0;j < pVictimData.getArchOutputStruct().getUlRowQty();j++) {
                // 
                // OPTIONAL CODE NOTE (END): System Date
                // 
                if (!(pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else {
                    pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(j).setSzCdStagePersRole(CLIENT);
                }
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CalcPerpRole(String pProgram, CINVA5DO pPerpData, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        int j = 0;
        if (!(pProgram.compareTo(CPS) != 0)) {
            for (j = 0;j < pPerpData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(FAMILY_MOVED) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 Start
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_COMPLETE) != 0)) {
                    
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                }
                // SIR 22983 End
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        if (!(pProgram.compareTo(APS) != 0)) {
            for (j = 0;j < pPerpData.getArchOutputStruct().getUlRowQty();j++) {
                if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(VALID) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if // SIR 16066
                (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(VALID_REPORTABLE_CONDUCT) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(VALID_NO_FAULT) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(INVALID) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNKNOWN);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(OTHER) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        if (!(pProgram.compareTo(COMMUNITY_LIC) != 0) ||!(pProgram.compareTo(RESIDENTIAL_LIC) != 0)) {
            for (j = 0;j < pPerpData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(REASON_TO_BELIEVE) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(RULED_OUT) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(ADMIN_CLOSURE) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        
        if (!(pProgram.compareTo(APS_FACILITY) != 0)) {
            for (j = 0;j < pPerpData.getArchOutputStruct().getUlRowQty();j++) {
                
                if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CONFIRMED) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if // SIR 16066
                (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CONFIRMED_REPORTABLE_CONDUCT) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(DESIGNATED_PERP);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNCONFIRMED) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(INCONCLUSIVE) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(UNKNOWN);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(UNFOUNDED) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(OTHER_FAC) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                // 
                // (BEGIN) SIR #2141: If the disposition is CASE_MERGED_IN_ERROR
                // (Merged in Error)  the Person should be set to
                // UNABLE_TO_DETERMINE.
                // 
                else if (!(pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).getCdAllegDisposition().compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CalcVictimPerpRole(String pProgram, CINVA9DO pVictimPerpData, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        int rc = SUCCESS;
        int j = 0;
        int k = 0;
        CINVA9DO pNewVictimPerpData = null;
        
        /*
        ** Set explan_data to usRow
        ** Note: Use sprintf
        */
        //##                              sprintf(pReturnPB->appl_status.explan_data,
        //##                                      "%u",
        //##                                      usVersionRow);
        
        
        /* Supply */
        if (!(pProgram.compareTo(APS) != 0)) {
            for (j = 0;j < pVictimPerpData.getArchOutputStruct().getUlRowQty();j++) {
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                              sprintf(pReturnPB->appl_status.explan_data,
                //##                                      "%u",
                //##                                      usVersionRow);
                
                
                // Travel
                if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(CLIENT);
                }
            }
        }
        
        /*
        ** Set explan_data to usRow
        ** Note: Use sprintf
        */
        //##                              sprintf(pReturnPB->appl_status.explan_data,
        //##                                      "%u",
        //##                                      usVersionRow);
        
        
        /* Unit Rate */
        /*
        ** TLC 09/20/96 We will not perform this check for CRM line items
        */
        if (!(pProgram.compareTo(APS_FACILITY) != 0)) {
            for (j = 0;j < pVictimPerpData.getArchOutputStruct().getUlRowQty();j++) {
                if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CONFIRMED) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(DESIGNATED_BOTH);
                }
                else if // SIR 16066
                (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CONFIRMED_REPORTABLE_CONDUCT) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(DESIGNATED_BOTH);
                }
                else if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNCONFIRMED) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(INCONCLUSIVE) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(UNKNOWN);
                }
                else if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNFOUNDED) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(OTHER_FAC) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else if (!(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).setSzCdStagePersRole(NO_ROLE);
                }
                else // BAD DISPOSITION CODE
                {
                    return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                }
            }
        }
        
        /*
        ** Set explan_data to usRow
        ** Note: Use sprintf
        */
        //##                                sprintf(pReturnPB->appl_status.explan_data,
        //##                                        "%u",
        //##                                        usVersionRow);
        
        
        /* Other */
        if (!(pProgram.compareTo(CPS) != 0) ||!(pProgram.compareTo(COMMUNITY_LIC) != 0) ||!(pProgram.compareTo(RESIDENTIAL_LIC) != 0)) {
            pNewVictimPerpData = new CINVA9DO();
            
            k = 0;
            for (j = 0;j < pVictimPerpData.getArchOutputStruct().getUlRowQty();j++) {
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                              sprintf(pReturnPB->appl_status.explan_data,
                //##                                      "%u",
                //##                                      usVersionRow);
                
                
                // 
                // End validation processing
                // 
                
                //  Update the version services with the
                // previous version amount used values only
                // if the validation process was successful
                if (j == 0) {
                    pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                    pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setUlIdVictim(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getUlIdVictim());
                    pNewVictimPerpData.getArchOutputStruct().setUlRowQty(1);
                }
                else // j > 0
                if (pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getUlIdVictim() != pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j - 1).getUlIdVictim()) {
                    k++;
                    
                    pNewVictimPerpData.getArchOutputStruct().getUlRowQty()++;
                    pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                    pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setUlIdVictim(pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getUlIdVictim());
                }
                else // ulIdVictim == previous row's ulIdVictim
                {
                    
                    
                    //  Analyze return code
                    switch (pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP)[2]) {
                        case SW_REASON_TO_BELIEVE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                            break;
                        case SW_UNABLE_TO_DETRMN_DISP:
                            if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(REASON_TO_BELIEVE) != 0) {
                                pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                            }
                            
                            break;
                        case SW_FAMILY_MOVED:
                            if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0) {
                                pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                
                                
                                
                            }
                            
                            
                            break;
                            
                        case SW_UNABLE_TO_COMPLETE:
                            
                            //  Populate the amount used fields from the
                            // previous version if there is a previous
                            // version else use the existing amount used
                            // values.
                            if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0) {
                                pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                            }
                            
                            break;
                        case SW_RULED_OUT:
                            if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(FAMILY_MOVED) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_COMPLETE) != 0) {
                                pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                            }
                            
                            break;
                        case SW_ADMIN_CLOSURE:
                            if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                                pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(VICTIM_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP));
                            }
                            break;
                    }
                }
            }
            
            for (k = 0;k < pNewVictimPerpData.getArchOutputStruct().getUlRowQty();k++) {
                for (j = 0;j < pVictimPerpData.getArchOutputStruct().getUlRowQty();j++) {
                    
                    
                    // 
                    // If the version end dates are modified for the
                    // row passed, the corresponding county dates are modified
                    // in order to reflect the new version end dates as well.
                    // 
                    if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getUlIdVictim() == pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getUlIdAllegedPerpetrator()) {
                        if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(Csys08s.NULL_STRING) != 0)) {
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                        }
                        else {
                            
                            // PROCESS_TUX_RC_ERROR_TRANSACT;
                            // that's all the error handling
                            // that ccmn03u.src does after it
                            // calls cinv41d
                            
                            switch (pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                                case SW_REASON_TO_BELIEVE:
                                    pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    break;
                                case SW_UNABLE_TO_DETRMN_DISP:
                                    if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(REASON_TO_BELIEVE) != 0) {
                                        pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    }
                                    break;// break for CLSS67D
                                case SW_FAMILY_MOVED:
                                    if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0) {
                                        pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    }
                                    break;
                                case SW_UNABLE_TO_COMPLETE:
                                    if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0) {
                                        pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    }
                                    break;
                                    
                                case SW_RULED_OUT:
                                    
                                    
                                    // 
                                    // For any Contract Version that has a data action of add,
                                    // the service will duplicate the previous Version's service
                                    // line items and corresponding contracted counties in a
                                    // mimicking a new using feature.  Thus, this only works
                                    // if the version is not the first version.
                                    // 
                                    if (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(REASON_TO_BELIEVE) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(FAMILY_MOVED) != 0 && pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(UNABLE_TO_COMPLETE) != 0) {
                                        pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    }
                                    
                                    break;
                                case SW_ADMIN_CLOSURE:
                                    if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP).compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                                        pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().setCdAllegDisposition(PERP_DISP, pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(j).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP));
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
            
            for (k = 0;k < pNewVictimPerpData.getArchOutputStruct().getUlRowQty();k++) {
                if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)) != 0)) {
                    
                    
                    //  Analyze return code
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                            
                        case SW_REASON_TO_BELIEVE:
                            
                            //## BEGIN TUX/XML: Declare XML variables
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_BOTH);
                            break;
                        case SW_UNABLE_TO_DETRMN_DISP:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            // 
                            // (END): CLSS68D - Retrieve contract service codes for
                            // the contract, period, and version passed to the DAM.
                            // 
                            
                            break;
                            
                        case SW_FAMILY_MOVED:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            break;
                        case SW_UNABLE_TO_COMPLETE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            break;
                            
                        case SW_RULED_OUT:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(NO_ROLE);
                            
                            break;
                        case SW_ADMIN_CLOSURE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(NO_ROLE);
                            
                            break;
                            
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(NO_ROLE);
                            break;
                    }
                    
                }
                else if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(REASON_TO_BELIEVE) != 0)) {
                    
                    //  Analyze return code
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                        case SW_UNABLE_TO_DETRMN_DISP:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_VICTIM);
                            break;
                        case SW_FAMILY_MOVED:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_VICTIM);
                            break;
                        case SW_UNABLE_TO_COMPLETE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_VICTIM);
                            break;
                        case SW_RULED_OUT:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_VICTIM);
                            
                            // 
                            // SIR #21922 - END CAUD08D CONTRACT COUNTY update
                            // 
                            
                            break;
                            
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_VICTIM);
                            break;
                    }
                    
                }
                else if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                    
                    //  Analyze return code
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                        case SW_REASON_TO_BELIEVE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_PERP);
                            break;
                            
                        case SW_FAMILY_MOVED:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            
                            // 
                            // END CAUD15D
                            // 
                            
                            
                            break;
                            
                        case SW_UNABLE_TO_COMPLETE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            break;
                            
                        case SW_RULED_OUT:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            break;
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            
                            break;
                    }
                }
                else if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(FAMILY_MOVED) != 0) ||!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(UNABLE_TO_COMPLETE) != 0)) {
                    
                    //  Analyze return code
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                        case SW_REASON_TO_BELIEVE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_PERP);
                            
                            break;
                        case SW_UNABLE_TO_DETRMN_DISP:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            
                            break;
                        case SW_RULED_OUT:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            break;
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            
                            break;
                    }
                }
                else if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(RULED_OUT) != 0)) {
                    
                    //  Finally, switch off of the converted cd task to call various function AUD
                    // dams dependent upon what cd task was returned.
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                        case SW_REASON_TO_BELIEVE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_PERP);
                            
                            
                            
                            break;
                        case SW_UNABLE_TO_DETRMN_DISP:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            
                            break;
                            //  NOTE: Multiple Instances will behave
                            // the same as the success case.  We are
                            // forcing Mulitple Instances to be
                            // successful for proper processing.
                        case SW_FAMILY_MOVED:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            
                            
                            break;
                        case SW_UNABLE_TO_COMPLETE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            
                            break;
                            
                            
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(NO_ROLE);
                            break;
                    }
                }
                else if (!(pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(VICTIM_DISP).compareTo(CASE_MERGED_IN_ERROR) != 0)) {
                    
                    //  Analyze return code
                    switch (pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).getCdAllegDisposition_ARRAY().getCdAllegDisposition(PERP_DISP)[2]) {
                            
                            
                        case SW_REASON_TO_BELIEVE:
                            
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(DESIGNATED_PERP);
                            break;
                        case SW_UNABLE_TO_DETRMN_DISP:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNABLE_TO_DETRMN_ROLE);
                            break;
                        case SW_FAMILY_MOVED:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            break;
                        case SW_UNABLE_TO_COMPLETE:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(UNKNOWN_OR_UTC);
                            break;
                        case SW_CASE_MERGED_IN_ERROR:
                            pNewVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(k).setSzCdStagePersRole(NO_ROLE);
                            break;
                    }
                }
            }
            pVictimPerpData = pNewVictimPerpData;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CalcOverallRoles(String pProgram, CINVB7DO pVictimOnlyData, CINVA0DO pVictimData, CINVA5DO pPerpData, CINVA9DO pVictimPerpData, CINVA6DI * pCINVA6DInputRec, Prsnroledata pPrsnRoleData, Ovrlroleedata pOverallRoleData, Pint pTotalPersons, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int ulCurrentIdPerson = 0;
        String pCurrentRole = null;
        String szCdOverallRole2 = new String();
        String tsOverallRole1 = new String();
        String[] pRoles = new String[MAX_ROLES];
        
        /*
        ** Concatenate input data
        **
        ** SIR #21497: Added pVictimOnlyData
        */
        for (int pRoles1 = 0;pRoles1 < pRoles.length;pRoles1++) {
            pRoles[pRoles1] = new String();
        }
        Pint TotRoles = new Pint();
        TotRoles.value = 0;
        int iPersonCtr = 0;
        int i373 = 0;
        int iRow = 0;
        int j = 0;
        int TotRows = 0;
        Prsnroledata pData = new Prsnroledata();
        TotRows = pVictimOnlyData.getArchOutputStruct().getUlRowQty() + pVictimData.getArchOutputStruct().getUlRowQty() + pPerpData.getArchOutputStruct().getUlRowQty() + pVictimPerpData.getArchOutputStruct().getUlRowQty();
        if (TotRows < 1) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /* ... continue adding to pData where pVictimOnly left off ...*/
        for (iRow = 0;iRow < pVictimOnlyData.getArchOutputStruct().getUlRowQty();iRow++) {
            pData.ROWPRSNROLEDATA[i373].ulIdPerson = pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(iRow).getUlIdPerson();
            pData.ROWPRSNROLEDATA[i373].szCdStagePersRole = pVictimOnlyData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(iRow).getSzCdStagePersRole();
            i373++;
        }
        /*
        ** loop thru MergeFromStageInfo
        */
        j = i373;
        for (iRow = 0;iRow < pVictimData.getArchOutputStruct().getUlRowQty();iRow++) {
            pData.ROWPRSNROLEDATA[j].ulIdPerson = pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(iRow).getUlIdPerson();
            pData.ROWPRSNROLEDATA[j].szCdStagePersRole = pVictimData.getROWCINVA0DO_ARRAY().getROWCINVA0DO(iRow).getSzCdStagePersRole();
            j++;
        }
        i373 = j;
        for (iRow = 0;iRow < pPerpData.getArchOutputStruct().getUlRowQty();iRow++) {
            pData.ROWPRSNROLEDATA[i373].ulIdPerson = pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(iRow).getUlIdPerson();
            pData.ROWPRSNROLEDATA[i373].szCdStagePersRole = pPerpData.getROWCINVA5DO_ARRAY().getROWCINVA5DO(iRow).getSzCdStagePersRole();
            i373++;
        }
        j = i373;
        
        for (iRow = 0;iRow < pVictimPerpData.getArchOutputStruct().getUlRowQty();iRow++) {
            pData.ROWPRSNROLEDATA[j].ulIdPerson = pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(iRow).getUlIdVictim();
            pData.ROWPRSNROLEDATA[j].szCdStagePersRole = pVictimPerpData.getROWCINVA9DO_ARRAY().getROWCINVA9DO(iRow).getSzCdStagePersRole();
            j++;
        }
        
        /*
        ** SIR #20486: pData is currently made up of pVictimOnlydata, pVictimData,
        **             pPerpData, and pVictimPerpData values.
        **             The if statement within the for loop below
        **             depends upon pData being sorted by ulIdPerson.
        **             Therefore, sort pData by ulIdPerson (using qsort),
        **             so that the CalcCurrentPersonRole function will
        **             be passed all of the Roles for a particular ulIdPerson.
        */
        qsort(pData, (int) (TotRows) , sizeof () , _Compare_ulIdPersons);
        
        /* First Current Person */
        ulCurrentIdPerson = pData.ROWPRSNROLEDATA[0].ulIdPerson;
        
        pCurrentRole = pData.ROWPRSNROLEDATA[0].szCdStagePersRole;
        
        /*
        ** Get timestamp corresponding to this person and
        ** stage from STAGE_PERSON_LINK that was retrieved at the
        ** beginning of this service.
        */
        for (iRow = 0;iRow < TotRows;iRow++) {
            if (pData.ROWPRSNROLEDATA[iRow].ulIdPerson == ulCurrentIdPerson) {
                pRoles[TotRoles.value++] = pData.ROWPRSNROLEDATA[iRow].szCdStagePersRole;
            }
            else // New Person - Calculate Overall Role for Current Person
            {
                rc = CalcCurrentPersonRole(pRoles, TotRoles, szCdOverallRole2, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].ulIdPerson = ulCurrentIdPerson;
                pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].szCdOverallRole = szCdOverallRole2;
                
                //  Get timestamp corresponding to this person and
                // stage from STAGE_PERSON_LINK that was retrieved at the
                // beginning of this service.
                for (j = 0;j < MAX_PERSONS;j++) {
                    if (pPrsnRoleData.ROWPRSNROLEDATA[j].ulIdPerson == ulCurrentIdPerson) {
                        tsOverallRole1 = pPrsnRoleData.ROWPRSNROLEDATA[j].tsLastUpdate;
                        break;
                    }
                }
                pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].tsOverallRole = tsOverallRole1;
                iPersonCtr++;
                TotRoles.value = 0;
                
                // Make new person the Current Person
                ulCurrentIdPerson = pData.ROWPRSNROLEDATA[iRow].ulIdPerson;
                pRoles[TotRoles.value++] = pData.ROWPRSNROLEDATA[iRow].szCdStagePersRole;
            }
        }
        
        /*
        ** Start performance timer for service
        */
        rc = CalcCurrentPersonRole(pRoles, TotRoles, szCdOverallRole2, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].ulIdPerson = ulCurrentIdPerson;
        pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].szCdOverallRole = szCdOverallRole2;
        for (j = 0;j < MAX_PERSONS;j++) {
            
            // SIR 19613 Change comparison of service returned
            // from 60A-E to 63A-D
            if (pPrsnRoleData.ROWPRSNROLEDATA[j].ulIdPerson == ulCurrentIdPerson) {
                tsOverallRole1 = pPrsnRoleData.ROWPRSNROLEDATA[j].tsLastUpdate;
                break;
            }
        }
        pOverallRoleData.ROWOVRLROLEDATA[iPersonCtr].tsOverallRole = tsOverallRole1;
        iPersonCtr++;
        pTotalPersons.value = iPersonCtr;
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CalcCurrentPersonRole(String[] pRole, Pint pTotRoles, String pOverallRole, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        boolean bRoleNotSet = true;
        int i374 = 0;
        
        
        
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(DESIGNATED_BOTH) != 0)) {
                    pOverallRole = DESIGNATED_BOTH;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                if (!(pRole[i374].compareTo(DESIGNATED_PERP) != 0)) {
                    pOverallRole = DESIGNATED_PERP;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                if (!(pRole[i374].compareTo(DESIGNATED_VICTIM) != 0)) {
                    pOverallRole = DESIGNATED_VICTIM;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(VICTIM_PERP) != 0)) {
                    pOverallRole = VICTIM_PERP;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        
        /*
        ** SIR 13618 - determine index based on tablename
        */
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                
                // 
                // SIR 1791 : Second Call to csys06d populates second document info
                // 
                
                // MHMR3 Item 8.5 Only call this section of code if it has not been called
                // before
                if (!(pRole[i374].compareTo(VICTIM) != 0)) {
                    pOverallRole = VICTIM;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(CLIENT) != 0)) {
                    pOverallRole = CLIENT;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                if (!(pRole[i374].compareTo(ALLEGED_PERP) != 0)) {
                    pOverallRole = ALLEGED_PERP;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                if (!(pRole[i374].compareTo(ALLEGED_VICTIM) != 0)) {
                    pOverallRole = ALLEGED_VICTIM;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                
                if (!(pRole[i374].compareTo(UNABLE_TO_DETRMN_ROLE) != 0)) {
                    pOverallRole = UNABLE_TO_DETRMN_ROLE;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(UNKNOWN_OR_MOVED) != 0)) {
                    pOverallRole = UNKNOWN_OR_UTC;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        
        
        /*
        ** SIR 2618:
        ** Move retrieved Event ID into input message so that it can be
        ** used to retrieve BLOBs later in the service call.
        */
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(UNKNOWN_OR_UTC) != 0)) {
                    pOverallRole = UNKNOWN_OR_UTC;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(UNKNOWN) != 0)) {
                    pOverallRole = UNKNOWN;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        
        /*
        ** Analyze error code
        */
        if (bRoleNotSet) {
            for (i374 = 0;i374 < pTotRoles.value;i374++) {
                if (!(pRole[i374].compareTo(NO_ROLE) != 0)) {
                    pOverallRole = NO_ROLE;
                    bRoleNotSet = false;
                    break;
                }
            }
        }
        if (bRoleNotSet) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        return else {
            return WtcHelperConstants.ARC_SUCCESS;
        }
    }

    static int CalcOverallDisposition(CINV45SO * pOutputMsg692, String pProgram, String[] pDisposition, String pOverallDisposition, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* Local Variables */
        boolean bDispositionNotSet = true;
        boolean bDispAllMrgErr = true;/* SIR #2141 Disposition
        ** of Merged in Error for
        ** all Allegations */
        int i375 = 0;
        
        /***********************************************************************
        ** (BEGIN): SIR #2141 Determine if all dispositions are ZZZ
        ***********************************************************************/
        /*
        ** Loop through all disposition rows
        */
        for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
            
            if (pDisposition[i375].compareTo(CASE_MERGED_IN_ERROR) != 0 && pDisposition[i375][0] != null) {
                bDispAllMrgErr = false;
                break;
            }
        }
        
        if (bDispAllMrgErr) {
            return Messages.MSG_INV_ALL_DISP_MERGED;
        }
        
        if (!(pProgram.compareTo(CPS) != 0)) {
            if (bDispositionNotSet) {
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(REASON_TO_BELIEVE) != 0)) {
                        pOverallDisposition = REASON_TO_BELIEVE;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                        pOverallDisposition = UNABLE_TO_DETRMN_DISP;
                        bDispositionNotSet = false;
                        //end SIR 22756
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(FAMILY_MOVED) != 0) ||!(pDisposition[i375].compareTo(UNABLE_TO_COMPLETE) != 0)) {
                        pOverallDisposition = UNABLE_TO_COMPLETE;
                        bDispositionNotSet = false;
                        
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(RULED_OUT) != 0)) {
                        pOverallDisposition = RULED_OUT;
                        bDispositionNotSet = false;
                        
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                // SIR 15495 Start
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(ADMIN_CLOSURE) != 0)) {
                        pOverallDisposition = ADMIN_CLOSURE;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
        }
        
        if (!(pProgram.compareTo(APS) != 0)) {
            
            if (bDispositionNotSet) {
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    if (!(pDisposition[i375].compareTo(VALID) != 0)) {
                        pOverallDisposition = VALID;
                        bDispositionNotSet = false;
                        break;
                        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                        
                        
                        
                    }
                }
            }
            
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(VALID_REPORTABLE_CONDUCT) != 0)) {
                        pOverallDisposition = VALID;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    if (!(pDisposition[i375].compareTo(VALID_NO_FAULT) != 0)) {
                        pOverallDisposition = VALID;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(INVALID) != 0)) {
                        pOverallDisposition = INVALID;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    if (!(pDisposition[i375].compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                        pOverallDisposition = UNABLE_TO_DETRMN_DISP;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(OTHER) != 0)) {
                        pOverallDisposition = OTHER;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
        }
        
        if (!(pProgram.compareTo(COMMUNITY_LIC) != 0) ||!(pProgram.compareTo(RESIDENTIAL_LIC) != 0)) {
            
            if (bDispositionNotSet) {
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(REASON_TO_BELIEVE) != 0)) {
                        pOverallDisposition = REASON_TO_BELIEVE;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if (!(pDisposition[i375].compareTo(UNABLE_TO_DETRMN_DISP) != 0)) {
                        pOverallDisposition = UNABLE_TO_DETRMN_DISP;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    if (!(pDisposition[i375].compareTo(RULED_OUT) != 0)) {
                        pOverallDisposition = RULED_OUT;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                // SIR 15495 Start
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(ADMIN_CLOSURE) != 0)) {
                        pOverallDisposition = ADMIN_CLOSURE;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
        }
        
        if (!(pProgram.compareTo(APS_FACILITY) != 0)) {
            
            if (bDispositionNotSet) {
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(CONFIRMED) != 0)) {
                        pOverallDisposition = CONFIRMED;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(CONFIRMED_REPORTABLE_CONDUCT) != 0)) {
                        pOverallDisposition = CONFIRMED;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(UNCONFIRMED) != 0)) {
                        pOverallDisposition = UNCONFIRMED;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    
                    if (!(pDisposition[i375].compareTo(INCONCLUSIVE) != 0)) {
                        pOverallDisposition = INCONCLUSIVE;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if (!(pDisposition[i375].compareTo(UNFOUNDED) != 0)) {
                        pOverallDisposition = UNFOUNDED;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
            if (bDispositionNotSet) {
                
                for (i375 = 0;i375 < MAX_DISPOSITIONS;i375++) {
                    if (!(pDisposition[i375].compareTo(OTHER_FAC) != 0)) {
                        pOverallDisposition = OTHER_FAC;
                        bDispositionNotSet = false;
                        break;
                    }
                }
            }
        }
        if (bDispositionNotSet) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        return else {
            return WtcHelperConstants.ARC_SUCCESS;
        }
    }

    int _Compare_ulIdPersons(Object first, Object second) {
        int /* Difference between 2 values passed in */
        lDifference = ((Rowprsnroledata) first).ulIdPerson - ((Rowprsnroledata) second).ulIdPerson;
        
        /*
        ** If test for number of rows returned..
        ** CSES87D will always return rc = 0
        ** because it returns count. If the number of rows
        ** returned is 0 and rc = sql_success then we
        ** have a subcare stage does not exist and we can
        ** continue; if the number of rows returned is 
        ** greater than 0, then a subcare stage exists
        ** and we should return the message to the user
        */
        if (0 > lDifference) {
            return - 1;
        }
        else if (0 == lDifference) {
            return 0;
        }
        return else if (0 < lDifference) {
            return 1;
        }
    }

    static int CallCAUDA5D(CINV45SI pInputMsg742, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CAUDA5DI pCAUDA5DInputRec = null;
        CAUDA5DO pCAUDA5DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUDA5DInputRec = new CAUDA5DI();
        
        pCAUDA5DOutputRec = new CAUDA5DO();
        pCAUDA5DInputRec.setArchInputStruct(pInputMsg742.getArchInputStruct());
        pCAUDA5DInputRec.setUlIdStage(pInputMsg742.getUlIdStage());
        
        
        /*
        ** Call CSEC10D
        */
        rc = cauda5dAUDdam(sqlca, pCAUDA5DInputRec, pCAUDA5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
