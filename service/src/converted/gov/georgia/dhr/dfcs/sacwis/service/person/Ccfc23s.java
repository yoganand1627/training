package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC27DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC61DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
/**************************************************************************
**
** Module File:   ccfc23s.src
**
** Service Name:  CCFC23S
**
** Description:   This runs a series of DAMs to verify that the 2 Person's
**                entered in the Person Merge Split can be merged.  The
**                service will return the Full Name of the Id Person
**                Entered on the window along with any validation errors
**                found.  The errors will be passed to the client via an
**                error list.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/12/96
**
** Programmer:    Timothy R. Overend
**
** Archive Information: $Revision:   1.10  $
**                      $Date:   10 Mar 1999 07:45:02  $
**                      $Modtime:   09 Mar 1999 15:18:52  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/11/96  dentonra  SIR #3678 - Changed processing to require both
**                      date of births of both people to be NOT NULL when
**                      checking to see if their ages are vaild.
**
**  03/28/96  ALIAM     SIR #4114 - Check to see if the stage Type is PAL,
**                      PAD, Subcare, Family Reunification, Family Subcare
**                      stage prior to checking if the stages appears in
**                      the Forward Person.
**  04/09/96  OMARAJJ   SIR#4249 - Corrected the comparison of the person
**                      forward and person closed birthdates. The earlier
**                      version used ARC_UTLCompare DateAndTime and a #define
**                      constant to see if the two date were more than ten
**                      years apart.  This method failed to address the
**                      effect of Leap Years and variablity in the number of
**                      days between two dates which change according the
**                      month in which you begin counting.
**  04/17/96  OMARAJJ   SIR#40425 - Changed the InputRec pointer variable in
**                      the call to CMSC28D.  It was mis-specified and
**                      referenced a wrong Input Record.
**  05/07/96  OMARAJJ   SIR#20700 - Added code after the call to CINV29d.pc
**                      to check if the id person closed is a former employee.
**                      In addition to a current employee.
**  05/15/96  OMARAJJ   SIR#21052 - Added a new DAM call to return a count of
**                      open stages in which the person closed is involved.
**                      If the count != 0 then a message is returned to the
**                      window CCFC22W and the message is displayed.
**  06/12/96  OVERENTR  SIR# 21595 - Remove FRE and FPR from the edit for
**                      checking whether the person is a primary child and
**                      add ADO to the edit criteria.
**  12/14/96  ODONNERJ  SIR# 12789 - Incorrect Error that person id's exist
**                      in open Intakes. CCMNF8D commented out because
**                      temp_stage_pers_link only holds the STF person id's
**                      for a partial intake.  All other person info is on
**                      the stage_person_link table. CSES76D commented out
**                      because incoming_person IS NOT A temporary table.
**                      Person Merge Design is based on this table being only
**                      a temporary place to keep Person id's while an Intake
**                      is still Open.  Since all person id information is
**                      maintained on the stage_person_link table, this dam
**                      call has been commented out.
**  12/16/96  ODONNERJ  SIR# 12293 - Added CSEC81D and processing to determine
**                      if the Merge will cause the victim and the perpetrator
**                      to have the same IdPerson in ANY Allegation in ANY
**                      OPEN Stage in CAPS. Both APS and CPS want this
**                      functionality since Merges can occur that affect people
**                      in both programs.
**  01/27/99 SOHNJJ     SIR 14737 - When the worker in a stage merges his/her
**                      staff id into a collateral on the person list, the
**                      stage will disappear from the workload and cannot be
**                      recovered.  This error occurs because the STAGE_
**                      PERSON_LINK table has a unique constraint that
**                      prevents the creation of rows with the same ID_PERSON
**                      and ID_STAGE.  To correct this error, the Person Merge
**                      will not be validated if the ID_FORWARD already
**                      exists as a STF in the stage.  ID_STAGE is now passed
**                      from ccfc22w.win to the Validation service.
**  03/09/99 SOHNJJ	SIR 15141 - Related to SIR 14737.  SIR 14737 did not
**			prevent the error-causing merges when the window was
**			accessed through the Person Search.  Modified the DAM
**			csesa1d.pc to perform a new select.  Rather than
**			sending in Id Stage and Id Person Forward, the DAM
**			takes the Id Person of both the Forward and Closed
**			indiviudal.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**						to PROCESS_TUX_RC_ERROR_NOFREE after the
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**						input and output objects before they are allocated
**
**  02/11/04 Demoma		Sir23259 - Added DOD warning and Address warning
**
**  02/18/05  Hadjimh   SIR# 23351. Invalid service authorization edit when attempting
**                      to merge persons. Error message "Both persons appear in
**                      the same Service Auth Detail record" is misleading and
**                      the cause of this error is invalid. Service auths are not
**                      considered to be duplicates unless they both have the same
**                      County, Service, Resource, and have any overlapping dates,
**                      otherwise the merge should be allowed.
**  03/10/05  Hadjimh   SIR#14032. Modify person merge to allow persons in two different stage
**                      be merged. if the person_closed is in closed stage AND stage is
**                      (PAL or PAD), check to see if person _forward is in PAL or PAD
**                      stage.  [if not] throw an error message (message referenced below).
**                      This edit is no longer needed (read the sir workbench for
**                      more explanation)
**  05/20/05  Demoma	Sir23466 added if statement so that a person with the name of
**  					'Unknown' could not be merged
**
**  08/31/05  Hadjimh   SIR#23707. Do not allow staff to switch PIDs in merge making the
**                      staff PID the closed PID. Couple of functions have been added to check
**                      if an employee is invloved in person merge, employee should be the
**                      person forward otherwise the merge does not happen. I also changed
**                      the value of cd_source field in message table from 710 to
**                      760 (fatal error) because the merge is not supposed to happen
**                      if the condition is not met.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Ccfc23s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char CD_ACTIVE = 'A';
    public static final char CD_MERGED = 'M';
    public static final String INTAKE_STAGE = "INT";
    
    /* #define NUM_OF_MIN_IN_10_YEARS  5259600 */
    /* SIR#4249 */
    public static final int AGE_MAX_DIFF = 10;
    
    public static final char CLOSED = '0';
    public static final char FORWARD = '1';
    public static final int PAGE_NUM_ONE = 1;
    public static final String EMPLOYEE_CATEGORY = "EMP";
    /* SIR#20700 */
    public static final String EMPLOYEE_CATEGORY_FORMER = "FEM";
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String SUBCARE = "SUB";
    public static final String POST_ADOPT = "PAD";
    public static final String ADOPT = "ADO";
    public static final String PREP_ADULT_LIVING = "PAL";
    
    /*
    ** SIR# 23466
    */
    public static final String UNKNOWN_NAME = "Unknown";
    public static final String NULL_STRING = "";
    CCFC23SO CCFC23S(CCFC23SI ccfc23si) {
        CCFC23SO ccfc23so = new CCFC23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CCFC23S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i46 = 0;
        int j = 0;
        int EditCounter = 0;/* Error/Warning counter */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /* SIR#4249 - Variables to determine age difference */
        int Year1 = 0;
        int Year2 = 0;
        int Month1 = 0;
        int Month2 = 0;
        int Day1 = 0;
        int Day2 = 0;
        boolean /* Local Flag to see if there is an open SUB, PAL, ADO, PAD */
        bIndOpenPCStage = false;
        boolean bIndPalPad = false;
        char bIndBothActive = 0;
        char bIndPersClosedActive = 0;
        char bStageFound = 0;
        
        
        
        //##  long  rc = FND_SUCCESS;         /* Return Code for DAM calls */
        
        
        CSEC47DI pCSEC47DInputRec = null;
        CSEC47DO pCSEC47DOutputRec = null;
        CLSS59DI pCLSS59DInputRec = null;
        CLSS59DO pCLSS59DOutputRec = null;
        CCMN40DI pCCMN40DInputRec = null;
        CCMN40DO pCCMN40DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        CCMN44DI pCall2CCMN44DInputRec = null;
        CCMN44DO pCall2CCMN44DOutputRec = null;
        /*_CSES76DI       *pCSES76DInputRec; ** SIR# 12789 **
        **_CSES76DO       *pCSES76DOutputRec;*/
        //  _CINV29DI       *pCINV29DInputRec;  sir#23707
        //  _CINV29DO       *pCINV29DOutputRec; sir#23707
        /*_CCMNF8DI       *pCCMNF8DInputRec; ** SIR# 12789 **
        **_CCMNF8DO       *pCCMNF8DOutputRec;*/
        CMSC22DI pCMSC22DInputRec = null;
        CMSC22DO pCMSC22DOutputRec = null;
        CMSC24DI pCMSC24DInputRec = null;
        CMSC24DO pCMSC24DOutputRec = null;
        CMSC25DI pCMSC25DInputRec = null;
        CMSC25DO pCMSC25DOutputRec = null;
        CMSC26DI pCMSC26DInputRec = null;
        CMSC26DO pCMSC26DOutputRec = null;
        CMSC27DI pCMSC27DInputRec = null;
        CMSC27DO pCMSC27DOutputRec = null;
        CMSC29DI pCMSC29DInputRec = null;
        CMSC29DO pCMSC29DOutputRec = null;
        CMSC31DI pCMSC31DInputRec = null;
        CMSC31DO pCMSC31DOutputRec = null;
        CMSC32DI pCMSC32DInputRec = null;
        CMSC32DO pCMSC32DOutputRec = null;
        CMSC33DI pCMSC33DInputRec = null;
        CMSC33DO pCMSC33DOutputRec = null;
        CMSC47DI pCMSC47DInputRec = null;
        CMSC47DO pCMSC47DOutputRec = null;
        CMSC51DI pCMSC51DInputRec = null;/* SIR#21052 */
        CMSC51DO pCMSC51DOutputRec = null;/* SIR#21052 */
        CMSC53DI pCMSC53DInputRec = null;/* SIR#14160 */
        CMSC53DO pCMSC53DOutputRec = null;/* SIR#14160 */
        CSEC81DI pCSEC81DInputRec = null;/* SIR 12293 */
        CSEC81DO pCSEC81DOutputRec = null;/* SIR 12293 */
        CSESA1DI pCSESA1DInputRec = null;/* SIR 14737 */
        CSESA1DO pCSESA1DOutputRec = null;/* SIR 14737 */
        CSEC61DI pCSEC61DInputRec = null;/* SIR 23259 */
        CSEC61DO pCSEC61DOutputRec = null;/* SIR 23259 */
        CSEC61DI pCAll2CSEC61DInputRec = null;/* SIR 23259 */
        CSEC61DO pCall2CSEC61DOutputRec = null;/* SIR 23259 */
        
        
        /* SIR# 23351 */
        Pchar bMatchFound = new Pchar();
        bMatchFound.value = 0;
        Pchar bPersonClosedIsEmp = new Pchar();// sir# 23707
        bPersonClosedIsEmp.value = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc23si.getArchInputStruct());
        ccfc23so.setCSysIndError(false);
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** First the sex, DOB, and person status will be checked
        ** by retrieve rows from the person table.  The first
        ** DAM call will be for the person forward.
        */
        
        /**************************************************************************
        ** Call the Person Retrieval Dam - CCMN44D
        **
        ** Description - This DAM will return one row from the person
        **               table based upon the id_person passed into it.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN44DInputRec = new CCMN44DI();
        
        pCCMN44DOutputRec = new CCMN44DO();
        pCCMN44DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
        pCCMN44DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeForward());
        
        
        /*
        ** Call CINV51D
        */
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Now call the person dam a second time, but this time
                // pass in the person closed.
                
                // 
                // Call the Person Retrieval Dam - CCMN44D2
                // Description - This DAM will return one row from the person
                // table based upon the id_person passed into it.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCall2CCMN44DInputRec = new CCMN44DI();
                
                pCall2CCMN44DOutputRec = new CCMN44DO();
                pCall2CCMN44DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCall2CCMN44DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                
                //  Set rc to ARC_SUCCESS
                rc = ccmn44dQUERYdam(sqlca, pCall2CCMN44DInputRec, pCall2CCMN44DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if ((CD_ACTIVE == pCCMN44DOutputRec.getCdPersonStatus()[0]) && (CD_ACTIVE == pCall2CCMN44DOutputRec.getCdPersonStatus()[0])) {
                            bIndBothActive// Local Flag to store if both are persons are active
                             = 1;
                        }
                        
                        if (CD_ACTIVE == pCall2CCMN44DOutputRec.getCdPersonStatus()[0]) {
                            bIndPersClosedActive// Local Flag to see if the person closed is still active
                             = 1;
                        }
                        if (CLOSED == ccfc23si.getCWcdPersonPassedIn()) {
                            ccfc23so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                        }
                        else {
                            ccfc23so.setSzNmPersonFull(pCall2CCMN44DOutputRec.getSzNmPersonFull());
                        }
                        
                        if (0 != NULL_STRING.compareTo(pCCMN44DOutputRec.getSzNmPersonFull())) {
                            //   No call to a dam is needed because you get the first and last name
                            // from the dam in the last name
                            // strstr() will find a sub-string within a string.
                            Object tmpPointer = CStringUtils.strstr(pCCMN44DOutputRec.getSzNmPersonFull() , UNKNOWN_NAME);
                            
                            if (tmpPointer != null) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_NO_MERGE_UNKNOWN_NAME);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
                            }
                        }
                        
                        if ((pCCMN44DOutputRec.getDtDtPersonDeath().year != pCall2CCMN44DOutputRec.getDtDtPersonDeath().year) || (pCCMN44DOutputRec.getDtDtPersonDeath().month != pCall2CCMN44DOutputRec.getDtDtPersonDeath().month) || (pCCMN44DOutputRec.getDtDtPersonDeath().day != pCall2CCMN44DOutputRec.getDtDtPersonDeath().day)) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_DOD);
                            
                            //## BEGIN TUX/XML: Declare XML variables
                            EditCounter++;
                        }
                        if ((pCCMN44DOutputRec.getCCdPersonSex() != pCall2CCMN44DOutputRec.getCCdPersonSex()) && (0 != pCCMN44DOutputRec.getCCdPersonSex()) && (0 != pCall2CCMN44DOutputRec.getCCdPersonSex())) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_CMN_MERGE_SEX);
                            EditCounter++;
                        }
                        
                        if ((CD_MERGED == pCCMN44DOutputRec.getCdPersonStatus()[0]) || (CD_MERGED == pCall2CCMN44DOutputRec.getCdPersonStatus()[0])) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_TO_MERGE);
                            ccfc23so.setCSysIndError(true);
                            EditCounter++;
                        }
                        
                        if (((DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().day) || (DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().month) || (DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().year)) && ((DateHelper.NULL_DATE != pCall2CCMN44DOutputRec.getDtDtPersonBirth().day) || (DateHelper.NULL_DATE != pCall2CCMN44DOutputRec.getDtDtPersonBirth().month) || (DateHelper.NULL_DATE != pCall2CCMN44DOutputRec.getDtDtPersonBirth().year))) {
                            
                            if (pCCMN44DOutputRec.getDtDtPersonBirth().year > pCall2CCMN44DOutputRec.getDtDtPersonBirth().year) {
                                Year1 = pCCMN44DOutputRec.getDtDtPersonBirth().year;
                                Month1 = pCCMN44DOutputRec.getDtDtPersonBirth().month;
                                Day1 = pCCMN44DOutputRec.getDtDtPersonBirth().day;
                                Year2 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().year;
                                Month2 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().month;
                                Day2 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().day;
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                
                                
                                
                            }
                            
                            else {
                                Year2 = pCCMN44DOutputRec.getDtDtPersonBirth().year;
                                Month2 = pCCMN44DOutputRec.getDtDtPersonBirth().month;
                                Day2 = pCCMN44DOutputRec.getDtDtPersonBirth().day;
                                Year1 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().year;
                                Month1 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().month;
                                Day1 = pCall2CCMN44DOutputRec.getDtDtPersonBirth().day;
                            }
                            
                            if ((Year1 - Year2 > AGE_MAX_DIFF) || ((Year1 - Year2 == AGE_MAX_DIFF) && (Month1 > Month2)) || ((Year1 - Year2 == AGE_MAX_DIFF) && (Month1 == Month2) && (Day1 > Day2))) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_AGE);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
                            }
                            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                            
                        }
                        rc = WtcHelperConstants.SQL_SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_ID_TO);
                        ccfc23so.setCSysIndError(true);
                        EditCounter++;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                rc = SUCCESS;
                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_ID_TO);
                ccfc23so.setCSysIndError(true);
                EditCounter++;
                break;
                
            default :
                
                // 
                // Function Prototypes
                // 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if ((SUCCESS == rc) && (ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO)) {
            
            //  Check Medicaid and SSN numbers for duplicity
            // 
            // Call the Person Id Retrieval Dam - CSEC47D
            // Description - This DAM will select a non end dated medicaid and non end
            // dated SSN for each of the 2 host Id?s.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC47DInputRec = new CSEC47DI();
            
            pCSEC47DOutputRec = new CSEC47DO();
            pCSEC47DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCSEC47DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
            
            pCSEC47DInputRec.setUlSysIdNewPerson(ccfc23si.getUlIdPersMergeForward());
            rc = csec47dQUERYdam(sqlca, pCSEC47DInputRec, pCSEC47DOutputRec);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (false == pCSEC47DOutputRec.getCSysIndSsnMatch()) {
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_SSN);
                        EditCounter++;
                    }
                    if (false == pCSEC47DOutputRec.getCSysIndMedMatch()) {
                        
                        //  SIR 2593 - Added prototypes for CallCCMNH4D() and CCMNH5D()
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_MEDICAID);
                        EditCounter++;
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
            if (SUCCESS == rc) {
                //  First retrieve the phone for the person closed
                // 
                // Call the Address Phone Retrieval Dam - CSEC61D
                // Description - Retrieve the Primary address and Phone for a Person.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCSEC61DInputRec = new CSEC61DI();
                
                pCSEC61DOutputRec = new CSEC61DO();
                
                pCAll2CSEC61DInputRec = new CSEC61DI();
                
                pCall2CSEC61DOutputRec = new CSEC61DO();
                pCSEC61DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCAll2CSEC61DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCSEC61DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                pCAll2CSEC61DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeForward());
                
                
                //  Call CINT40D
                rc = csec61dQUERYdam(sqlca, pCSEC61DInputRec, pCSEC61DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        //   If persons passed in in input message and 
                        // no rows returned from the dam, no matches were found,
                        // so do not use that record.
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                rc = csec61dQUERYdam(sqlca, pCAll2CSEC61DInputRec, pCall2CSEC61DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CMSC17D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                if (bIndBothActive != 0) {
                    
                    //  If F8 Returned some rows but there is still space in Output Msg
                    // This Dam must start at page 1, otherwise send in the Page Requested
                    // and DAM will use it to calculate where the page starts and ends.
                    // ISF 052495
                    if (!pCall2CSEC61DOutputRec.getSzAddrPersAddrStLn1().equals(pCSEC61DOutputRec.getSzAddrPersAddrStLn1()) ||!pCall2CSEC61DOutputRec.getSzAddrCity().equals(pCSEC61DOutputRec.getSzAddrCity()) ||!pCall2CSEC61DOutputRec.getSzCdAddrCounty().equals(pCSEC61DOutputRec.getSzCdAddrCounty()) ||!pCall2CSEC61DOutputRec.getLAddrZip().equals(pCSEC61DOutputRec.getLAddrZip())) {
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_ADDRESS);
                        EditCounter++;
                    }
                }
            }
            //  A No Rows Found message is only returned if neither this dam nor
            // ccmnf8d (retrieval from TEMP_STAGE_PERS_LINK table) returned any
            // rows. Checking the count variable allows us to see if any rows
            // were returned from the previous dam, as it is possible to
            // retrieve rows from one but not the other.
            if (SUCCESS == rc) {
                // 
                // Call the Income Resource Retrieval Dam - CMSC22D
                // Description -  Has three seperate count statements, each will
                // populate a count in the output message to determine
                // the number of rows on the income and resource table.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC22DInputRec = new CMSC22DI();
                
                pCMSC22DOutputRec = new CMSC22DO();
                pCMSC22DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCMSC22DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                pCMSC22DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                rc = cmsc22dQUERYdam(sqlca, pCMSC22DInputRec, pCMSC22DOutputRec);
                
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        if (((0 != pCMSC22DOutputRec.getUlSysNbrGenericCntr()) && (0 != pCMSC22DOutputRec.getUlSysNbrGenericCntr1())) && ((0 == pCMSC22DOutputRec.getUlSysNbrGenericCntr2()) || ((pCMSC22DOutputRec.getUlSysNbrGenericCntr() != pCMSC22DOutputRec.getUlSysNbrGenericCntr1()) && (pCMSC22DOutputRec.getUlSysNbrGenericCntr() != pCMSC22DOutputRec.getUlSysNbrGenericCntr2())))) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_INC_RSC);
                            EditCounter++;
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
            }
            
            if (SUCCESS == rc) {
                // 
                // Call the Financial Accounts Retrieval Dam - CMSC47D
                // Description -  Has two seperate count statements, each will
                // populate a count in the output message to determine
                // the number of rows on the Financial Accounts table.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC47DInputRec = new CMSC47DI();
                
                pCMSC47DOutputRec = new CMSC47DO();
                
                pCMSC47DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                
                // 
                // Service Macro Definitions
                // 
                
                // 
                // Function Prototypes
                // 
                pCMSC47DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                pCMSC47DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                
                
                //  Call CMSC18D
                rc = cmsc47dQUERYdam(sqlca, pCMSC47DInputRec, pCMSC47DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (0 != pCMSC47DOutputRec.getUlSysNbrGenericCntr()) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_FIN_ACCT);
                            EditCounter++;
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
            }
            
            if (SUCCESS == rc) {
                // 
                // Call the Eligibility Retrieval Dam - CMSC25D
                // Description -  Returns the count of duplicate eligibility records
                // for two host ID PERSONS.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC25DInputRec = new CMSC25DI();
                
                pCMSC25DOutputRec = new CMSC25DO();
                pCMSC25DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCMSC25DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                
                // 
                // Function Prototypes
                // PWO 1037: svcshell.src: in each statement below
                // replaced the lines:
                // _MSG_PARM_BLOCK *, 
                // _APPL_STATUS *, 
                // _ABHI *);
                // with:
                // TUX_DECL_STATUSPARMS);
                // 
                
                pCMSC25DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                rc = cmsc25dQUERYdam(sqlca, pCMSC25DInputRec, pCMSC25DOutputRec);
                
                
                
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (0 != pCMSC25DOutputRec.getUlSysNbrGenericCntr()) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_ELIG);
                            ccfc23so.setCSysIndError(true);
                            
                            EditCounter++;
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CAUD47D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            if (SUCCESS == rc) {
                rc = CheckBothPersonIds(ccfc23si, ccfc23so, bPersonClosedIsEmp, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                if (bPersonClosedIsEmp.value) {
                    
                    ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_EMP);
                    ccfc23so.setCSysIndError(true);
                    EditCounter++;
                }
            }
            
            if (SUCCESS == rc) {
                
                // 
                // Call the Stage Retrieval Dam - CMSC29D
                // Description - This Dam will return a full row from the stage table where
                // the given Id Person is a PC.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC29DInputRec = new CMSC29DI();
                
                pCMSC29DOutputRec = new CMSC29DO();
                
                pCMSC29DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCMSC29DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                pCMSC29DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                
                //  PWO 1080: added reference to CallCCMNG5D 
                pCMSC29DInputRec.getArchInputStruct().setUlPageSizeNbr(CMSC29DO._CMSC29DO__ROWCMSC29DO_SIZE);
                rc = cmsc29dQUERYdam(sqlca, pCMSC29DInputRec, pCMSC29DOutputRec);
                
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Check to see if any of the stages are open.
                        for (i46 = 0;i46 < pCMSC29DOutputRec.getArchOutputStruct().getUlRowQty();i46++) {
                            if ((DateHelper.NULL_DATE == pCMSC29DOutputRec.getROWCMSC29DO_ARRAY().getROWCMSC29DO(i46).getDtDtStageClose().day) || (DateHelper.NULL_DATE == pCMSC29DOutputRec.getROWCMSC29DO_ARRAY().getROWCMSC29DO(i46).getDtDtStageClose().month) || (DateHelper.NULL_DATE == pCMSC29DOutputRec.getROWCMSC29DO_ARRAY().getROWCMSC29DO(i46).getDtDtStageClose().year)) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_PC);
                                ccfc23so.setCSysIndError(true);
                                
                                //  PWO 1080: added reference to CallCCMN36D 
                                EditCounter++;
                                i46 = pCMSC29DOutputRec.getArchOutputStruct().getUlRowQty();
                                
                                //  Set local flag to true
                                bIndOpenPCStage = true;
                            }
                            
                            if ((pCMSC29DOutputRec.getROWCMSC29DO_ARRAY().getROWCMSC29DO(i46).getSzCdStage().equals(PREP_ADULT_LIVING)) || (pCMSC29DOutputRec.getROWCMSC29DO_ARRAY().getROWCMSC29DO(i46).getSzCdStage().equals(POST_ADOPT))) {
                                bIndPalPad// Local Flag to see if the person is a PC in PAL or PAD
                                 = true;
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CMSC15D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            if (SUCCESS == rc && bIndPersClosedActive != 0) {
                
                // 
                // Call the Stage Retrieval Dam - CLSS59D
                // Description -  Selects all open stages for a given id_stage type.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS59DInputRec = new CLSS59DI();
                
                pCLSS59DOutputRec = new CLSS59DO();
                pCLSS59DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCLSS59DInputRec.setSzCdStage(INTAKE_STAGE);
                
                //  PWO 1080: restored reference to CallCCMNF4D 
                pCLSS59DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                pCLSS59DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSS59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS59DO._CLSS59DO__ROWCLSS59DO_SIZE);
                rc = clss59dQUERYdam(sqlca, pCLSS59DInputRec, pCLSS59DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_INTAKE);
                        ccfc23so.setCSysIndError(true);
                        EditCounter++;
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
            
            if (SUCCESS == rc && bIndBothActive != 0) {
                
                //  Check Duplicate Events Person Link rows
                
                // 
                // Call the Event Count Retrieval Dam - CMSC24D
                // Description - This DAM will select a count of the events in an open stage
                // that both Host variables are associated.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC24DInputRec = new CMSC24DI();
                
                pCMSC24DOutputRec = new CMSC24DO();
                pCMSC24DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCMSC24DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                pCMSC24DInputRec.setUlSysIdNewPerson(ccfc23si.getUlIdPersMergeForward());
                
                
                //  Call CCMN39D
                rc = cmsc24dQUERYdam(sqlca, pCMSC24DInputRec, pCMSC24DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (0 != pCMSC24DOutputRec.getUlSysNbrGenericCntr()) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_DUP_EVENT);
                            ccfc23so.setCSysIndError(true);
                            EditCounter++;
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
                if (SUCCESS == rc) {
                    
                    // 
                    // Call the PPT Events Retrieval Dam - CMSC26D
                    // Description - Selects a count of the PPT events both people are associated
                    // with.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC26DInputRec = new CMSC26DI();
                    
                    pCMSC26DOutputRec = new CMSC26DO();
                    pCMSC26DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                    pCMSC26DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                    pCMSC26DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                    rc = cmsc26dQUERYdam(sqlca, pCMSC26DInputRec, pCMSC26DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            if (0 != pCMSC26DOutputRec.getUlSysNbrGenericCntr()) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_PPT);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Call CAUDA0D
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
                if (SUCCESS == rc) {
                    
                    // 
                    // Call the Child Plan Events Retrieval Dam - CMSC27D
                    // Description - This DAM will select a count of the Child Plan events both
                    // people are associated with.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC27DInputRec = new CMSC27DI();
                    
                    pCMSC27DOutputRec = new CMSC27DO();
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    pCMSC27DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                    pCMSC27DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                    pCMSC27DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                    //  SIR 22187 - Removed DAM CLSC18D
                    // free(pCLSC18DInputRec);
                    // free(pCLSC18DOutputRec);
                    rc = cmsc27dQUERYdam(sqlca, pCMSC27DInputRec, pCMSC27DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            if (0 != pCMSC27DOutputRec.getUlSysNbrGenericCntr()) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_CP_PART);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
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
                }
                if (SUCCESS == rc) {
                    
                    // 
                    // Call the Service Authorizations Retrieval Dam - CMSC31D
                    // Description - This DAM will select a count of the Open Service
                    // authorizations of the same type.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC31DInputRec = new CMSC31DI();
                    
                    pCMSC31DOutputRec = new CMSC31DO();
                    pCMSC31DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                    pCMSC31DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                    pCMSC31DInputRec.setUlSysIdNewPerson(ccfc23si.getUlIdPersMergeForward());
                    
                    //  Get the current date and time to update the database with
                    rc = cmsc31dQUERYdam(sqlca, pCMSC31DInputRec, pCMSC31DOutputRec);
                    
                    // Analyze error code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (0 != pCMSC31DOutputRec.getUlSysNbrGenericCntr()) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_RISK_ASSMT);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Call CCMND3D
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
                
                if (SUCCESS == rc) {
                    // 
                    // Call the Person Home Retrieval Dam - CMSC32D
                    // Description - This dam will count the Person Home Removal of the same
                    // type
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC32DInputRec = new CMSC32DI();
                    
                    pCMSC32DOutputRec = new CMSC32DO();
                    pCMSC32DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                    pCMSC32DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                    //  Anything but SQL_SUCCESS is an unacceptable error
                    pCMSC32DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                    rc = cmsc32dQUERYdam(sqlca, pCMSC32DInputRec, pCMSC32DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            if (0 != pCMSC32DOutputRec.getUlSysNbrGenericCntr()) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_PERS_HOME);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
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
                }
                
                if (SUCCESS == rc) {
                    // 
                    // Call the Training Retrieval Dam - CMSC33D
                    // Description - This DAM will select a count of the Training occurring on
                    // the same day for 2 ID PERSONS.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC33DInputRec = new CMSC33DI();
                    
                    pCMSC33DOutputRec = new CMSC33DO();
                    pCMSC33DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                    pCMSC33DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
                    //  Anything but SQL_SUCCESS is an unacceptable error
                    pCMSC33DInputRec.setUlSysIdNewPerson(ccfc23si.getUlIdPersMergeForward());
                    
                    
                    //  Get the current date and time to update the database with
                    rc = cmsc33dQUERYdam(sqlca, pCMSC33DInputRec, pCMSC33DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (0 != pCMSC33DOutputRec.getUlSysNbrGenericCntr()) {
                                ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_TRAIN);
                                ccfc23so.setCSysIndError(true);
                                EditCounter++;
                            }
                            break;
                            
                            //  Reset the return code and severity so that
                            // processing may continue.
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Call CCMN01U
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                
                if (SUCCESS == rc) {
                    rc = CompareServiceAuth(ccfc23si, ccfc23so, bMatchFound, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    if (bMatchFound.value != 0) {
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_SERV_AUTH);
                        ccfc23so.setCSysIndError(true);
                        EditCounter++;
                    }
                }
            }
            if ((SUCCESS == rc) && (ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO)) {
                // 
                // Call the  Dam - CSEC81D
                // Description -  Validates that Person Merge Forward is not the
                // victim and the perpetrator in the same allegation in any
                // open stage in CAPS.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCSEC81DInputRec = new CSEC81DI();
                
                pCSEC81DOutputRec = new CSEC81DO();
                pCSEC81DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
                pCSEC81DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
                pCSEC81DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
                rc = csec81dQUERYdam(sqlca, pCSEC81DInputRec, pCSEC81DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        if (pCSEC81DOutputRec.getUlSysNbrGenericCntr() > 0) {
                            ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_MERGE_PERS_VC_ALLEGED);
                            ccfc23so.setCSysIndError(true);
                            EditCounter++;
                        }
                        break;
                        //  If Dam is successful, set rc to Success and break out of switch
                        // statement
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CSES56D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        
        if ((SUCCESS == rc) && (ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO)) {
            // 
            // Call the Name Retrieval Dam - CCMN40D
            // Description -  Selects the active primary first,middle and last name for
            // the id person passed in.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN40DInputRec = new CCMN40DI();
            
            pCCMN40DOutputRec = new CCMN40DO();
            pCCMN40DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCCMN40DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeForward());
            
            rc = ccmn40dQUERYdam(sqlca, pCCMN40DInputRec, pCCMN40DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc23so.setSzNmNameFirst(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameFirst());
                    ccfc23so.setSzNmNameMiddle(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameMiddle());
                    ccfc23so.setSzNmNameLast(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameLast());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CSES56D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if ((SUCCESS == rc) && (ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO)) {
            // 
            // Call the Name Retrieval Dam - CCMN40D
            // Description -  Selects the active primary first,middle and last name for
            // the id person passed in.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN40DInputRec = new CCMN40DI();
            
            pCCMN40DOutputRec = new CCMN40DO();
            pCCMN40DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCCMN40DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
            rc = ccmn40dQUERYdam(sqlca, pCCMN40DInputRec, pCCMN40DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc23so.setSzScrNmNameFirst(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameFirst());
                    ccfc23so.setSzScrNmNameMiddle(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameMiddle());
                    
                    ccfc23so.setSzScrNmNameLast(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameLast());
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
        if (SUCCESS == rc) {
            // 
            // Call the OPEN STAGE RETRIEVAL Dam - CMSC51D
            // Description -  Returns a count of the OPEN stages in which the person
            // closed is involved.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC51DInputRec = new CMSC51DI();
            
            pCMSC51DOutputRec = new CMSC51DO();
            pCMSC51DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCMSC51DInputRec.setUlIdPerson(ccfc23si.getUlIdPersMergeClosed());
            
            
            //  Call CSES56D
            rc = cmsc51dQUERYdam(sqlca, pCMSC51DInputRec, pCMSC51DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    
                    if (0 != pCMSC51DOutputRec.getUlSysNbrGenericCntr()) {
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_PERS_CLD_OPN_STAGE);
                        pServiceStatus.explan_code = SUCCESS;
                        EditCounter++;
                    }
                    else {
                        pServiceStatus.explan_code = SUCCESS;
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
        }
        
        if (SUCCESS == rc) {
            // 
            // Call the OPEN EA RETRIEVAL Dam - CMSC53D
            // Description -  Returns a count of the OPEN stages in which the person
            // closed is involved.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC53DInputRec = new CMSC53DI();
            
            pCMSC53DOutputRec = new CMSC53DO();
            pCMSC53DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCMSC53DInputRec.setUlIdPersEligPerson(ccfc23si.getUlIdPersMergeClosed());
            pCMSC53DInputRec.setSzCdPersEligType("EA");
            rc = cmsc53dQUERYdam(sqlca, pCMSC53DInputRec, pCMSC53DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    if (0 != pCMSC53DOutputRec.getUlSysNbrGenericCntr()) {
                        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_PERS_CLD_OPN_ELIG);
                        pServiceStatus.explan_code = SUCCESS;
                        EditCounter++;
                    }
                    
                    else {
                        pServiceStatus.explan_code = SUCCESS;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CAUD75D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (SUCCESS == rc) {
            // 
            // Call the STAGE PERSON LINK Dam - CSESA1D
            // Description -  Checks to see if the ID_PERSON of the Person Forward
            // exists on the STAGE_PERSON_LINK table.  If the Person
            // Forward ID is already involved in a stage, then an
            // error message is returned.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSESA1DInputRec = new CSESA1DI();
            
            pCSESA1DOutputRec = new CSESA1DO();
            pCSESA1DInputRec.setArchInputStruct(ccfc23si.getArchInputStruct());
            pCSESA1DInputRec.setUlIdPersMergeForward(ccfc23si.getUlIdPersMergeForward());
            pCSESA1DInputRec.setUlIdPersMergeClosed(ccfc23si.getUlIdPersMergeClosed());
            
            //  Set rc to ARC_SUCCESS
            rc = csesa1dQUERYdam(sqlca, pCSESA1DInputRec, pCSESA1DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(EditCounter, Messages.MSG_CANT_MERGE_TO_WORKER);
                    ccfc23so.setCSysIndError(true);
                    EditCounter++;
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
        ccfc23so.getArchOutputStruct().setUlRowQty(EditCounter);
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc23si.getArchInputStruct() , ccfc23so.getArchOutputStruct());
        
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
        return ccfc23so;
    }

    static int CompareServiceAuth(CCFC23SI pInputMsg44, CCFC23SO pOutputMsg48, String pbMatchFound, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        Pchar bLocalMatchFound = new Pchar();
        bLocalMatchFound.value = 0;
        
        CLSCB8DI PersonClosedInput = null;
        CLSCB8DO PersonClosedOutput = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonClosedInput = new CLSCB8DI();
        PersonClosedOutput = new CLSCB8DO();
        
        /*
        ** Analyze error code
        */
        if ((PersonClosedInput == null) || (PersonClosedOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        PersonClosedInput.setUlIdPerson(pInputMsg44.getUlIdPersMergeClosed());
        rc = CallCLSCB8D(pInputMsg44, PersonClosedOutput, pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (PersonClosedOutput.getArchOutputStruct().getUlRowQty() > 0) {
            
            
            //  Call CAUDB9D
            rc = CallCSEC17D(pInputMsg44, pOutputMsg48, PersonClosedOutput, bLocalMatchFound, pServiceStatus);
            pbMatchFound = CStringUtils.setCharAt(pbMatchFound, 0, bLocalMatchFound.value);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        return rc;
    }

    static int CallCLSCB8D(CCFC23SI pInputMsg45, CLSCB8DO PersonClosedOutput, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* declare local variables */
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CLSCB8DI pCLSCB8DInputRec = null;
        CLSCB8DO pCLSCB8DOutputRec = null;
        int i47 = 0;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSCB8DInputRec = new CLSCB8DI();
        pCLSCB8DOutputRec = new CLSCB8DO();
        
        if (pCLSCB8DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (pCLSCB8DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCLSCB8DInputRec.setArchInputStruct(pInputMsg45.getArchInputStruct());
        pCLSCB8DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSCB8DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSCB8DO._CLSCB8DO__ROWCLSCB8DO_SIZE);
        
        
        /*
        ** Call CSEC58D
        */
        rc = SUCCESS;
        pCLSCB8DInputRec.setUlIdPerson(pInputMsg45.getUlIdPersMergeClosed());
        
        
        /*
        ** Call CSES31D
        */
        
        rc = clscb8dQUERYdam(sqlca, pCLSCB8DInputRec, pCLSCB8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Set rc to ARC_SUCCESS
                rc = SUCCESS;
                
                for (i47 = 0;i47 < pCLSCB8DOutputRec.getArchOutputStruct().getUlRowQty();i47++) {
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setUlIdResource(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getUlIdResource());
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setSzCdSvcAuthDtlSvc(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getSzCdSvcAuthDtlSvc());
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setDtDtSvcAuthDtlBegin(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getDtDtSvcAuthDtlBegin());
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setDtDtSvcAuthDtlTerm(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getDtDtSvcAuthDtlTerm());
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setUlIdPerson(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getUlIdPerson());
                    PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).setUlIdSvcAuthDtl(pCLSCB8DOutputRec.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i47).getUlIdSvcAuthDtl());
                }
                PersonClosedOutput.getArchOutputStruct().setUlRowQty(pCLSCB8DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSEC17D(CCFC23SI pInputMsg46, CCFC23SO * pOutputMsg49, CLSCB8DO PersonClosedOutput, String pbMatchFound, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC17DI pCSEC17DInputRec = null;
        CSEC17DO pCSEC17DOutputRec = null;
        int i48 = 0;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC17DInputRec = new CSEC17DI();
        pCSEC17DOutputRec = new CSEC17DO();
        if (pCSEC17DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /**************************************************************************
        ** End Call to Retrieve Primary Emplyoee Dam - CINV51D
        **************************************************************************/
        
        
        if (pCSEC17DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSEC17DInputRec.setArchInputStruct(pInputMsg46.getArchInputStruct());
        pCSEC17DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
        pCSEC17DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        
        /*
        ** Call CheckStageEventStatus
        */
        rc = SUCCESS;
        for (i48 = 0;i48 < PersonClosedOutput.getArchOutputStruct().getUlRowQty() && rc == SUCCESS;i48++) {
            pCSEC17DInputRec.setUlIdResource(PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i48).getUlIdResource());
            pCSEC17DInputRec.setSzCdSvcAuthDtlSvc(PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i48).getSzCdSvcAuthDtlSvc());
            pCSEC17DInputRec.setDtDtSvcAuthDtlBegin(PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i48).getDtDtSvcAuthDtlBegin());
            pCSEC17DInputRec.setDtDtSvcAuthDtlTerm(PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i48).getDtDtSvcAuthDtlTerm());
            pCSEC17DInputRec.setUlIdPerson(pInputMsg46.getUlIdPersMergeForward());
            pCSEC17DInputRec.setUlIdSvcAuthDtl(PersonClosedOutput.getROWCLSCB8DO_ARRAY().getROWCLSCB8DO(i48).getUlIdSvcAuthDtl());
            
            rc = csec17dQUERYdam(sqlca, pCSEC17DInputRec, pCSEC17DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pbMatchFound = CStringUtils.setCharAt(pbMatchFound, 0, true);
                    rc = SUCCESS;
                    
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            if (pbMatchFound.charAt(0) == true) {
                
                
                
                break;
            }
        }
        return rc;
    }

    static int CheckBothPersonIds(CCFC23SI pInputMsg47, CCFC23SO * pOutputMsg50, String pbPersonClosedIsEmp, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i49 = 0;
        boolean bLocalPersonForwardIsEmp = false;
        boolean bLocalPersonClosedIsEmp = false;
        
        CINV29DI pPersonInput = null;
        CINV29DO pPersonOutput = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pPersonInput = new CINV29DI();
        pPersonOutput = new CINV29DO();
        if ((pPersonInput == null) || (pPersonOutput == null)) {
            
            
            //  Call CLSC53D
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pPersonInput.setUlIdPerson(pInputMsg47.getUlIdPersMergeClosed());
        rc = Cint05s.CallCINV29D(pPersonInput, pPersonOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        for (i49 = 0;(i49 < pPersonOutput.getArchOutputStruct().getUlRowQty());i49++) {
            if ((pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) || (pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY_FORMER))) {
                bLocalPersonClosedIsEmp = true;
                
                break;
            }
        }
        if (bLocalPersonClosedIsEmp) {
            pPersonInput.setUlIdPerson(pInputMsg47.getUlIdPersMergeForward());
            rc = Cint05s.CallCINV29D(pPersonInput, pPersonOutput, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            for (i49 = 0;(i49 < pPersonOutput.getArchOutputStruct().getUlRowQty());i49++) {
                if ((pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) || (pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY_FORMER))) {
                    bLocalPersonForwardIsEmp = true;
                    
                    break;
                }
            }
        }
        
        if (bLocalPersonClosedIsEmp == true && bLocalPersonForwardIsEmp == false) {
            pbPersonClosedIsEmp = CStringUtils.setCharAt(pbPersonClosedIsEmp, 0, true);
        }
        return rc;
    }

    static int CallCINV29D(CINV29DI PersonInputRec, CINV29DO PersonOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV29DI pCINV29DInputRec = null;
        CINV29DO pCINV29DOutputRec = null;
        int i50 = 0;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV29DInputRec = new CINV29DI();
        pCINV29DOutputRec = new CINV29DO();
        if (pCINV29DInputRec == null) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (pCINV29DOutputRec == null) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCINV29DInputRec.setArchInputStruct(Csys08s.pInputMsg.getArchInputStruct());
        pCINV29DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCINV29DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV29DO._CINV29DO__ROWCINV29DO_SIZE);
        
        
        
        rc = SUCCESS;
        pCINV29DInputRec.setUlIdPerson(PersonInputRec.getUlIdPerson());
        
        rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Update the output error/warning array with the error/warning
                // that was returned from the DAM, Set the Ind Error flag to
                // true, and increment the error/warning counter if the person
                // category returned is employee.
                
                for (i50 = 0;(i50 < pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());i50++) {
                    PersonOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(i50).setSzCdCategoryCategory(pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(i50).getSzCdCategoryCategory());
                }
                PersonOutputRec.getArchOutputStruct().setUlRowQty(pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());
                PersonOutputRec.getArchOutputStruct().setBMoreDataInd(pCINV29DOutputRec.getArchOutputStruct().getBMoreDataInd());
                // In order to subtract one day, two days are subtracted, and one day is added.
                // Otherwise the function does not work
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                PersonOutputRec.getArchOutputStruct().setUlRowQty(0);
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
