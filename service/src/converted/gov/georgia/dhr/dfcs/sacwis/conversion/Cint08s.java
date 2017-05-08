package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc14s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonInfoStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT27DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT28DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT30DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDJ8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDJ8DO;
/**************************************************************************
**
** Module File:   cint08s.src
**
** Service Name:  Relate Person
**
** Description:   Relates a person from the Person Detail window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/01/1995
**
** Programmer:    Brian Gugliemetti, Andersen Consulting
**
** Archive Information: $Revision:   1.10  $
**                      $Date:   28 Nov 2000 14:41:46  $
**                      $Modtime:   28 Nov 2000 10:55:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  3/1/95    GUGLIEBS  Added stage id for processing
**  5/2/95    GUGLIEBS  Added person delete logic.
**  02/19/96  LASKEYRM  SIR #5006. Added code to determine if related person
**                      is an employee.
**                      NOTE: Please note that ArchOutputStruct.bMoreDataInd
**                      is being used to indicate if the person is an
**                      employee or not.
**  11Jun96  sladewmf   SIR #10046: Changed a COPYSZ from szNbrPersonIdSsn
**                      to szNbrPersonIdNumber.  Added 16 COPYSZ's.
**  07/24/96    KRD     SIR 10493 - IdRelatedPerson was removed from the
**                      input record for CINT31D.  Other changes necessary
**                      for readability/maintainability.
**  10/14/96    KRD     SIR 10808 - The insert into table INCOMING_PERSON
**                      occasionally returns a unique constraint error on
**                      PK_INCOMING_PERSON in the form of a data access
**                      error.  However, subsequent inserts with the same
**                      data return successfully (i.e., first we got a data
**                      access error and then immediately related again with
**                      no error).  There is no logical reason for this error
**                      and discussions with others have led me to the
**                      conclusion that the Oracle database became confused.
**                      As a stop-gap measure, the system will now trap for
**                      the constraint error and display a message to the
**                      user.  However, this problem should be re-examined.
**                      This required a change to CallCINT27D().
**  01/08/97    KRD     SIR 21973 - CINT60D no longer uses IdStage, so it
**                      has been removed from its input record.  Required a
**                      change to CallCINT60D().
**  03/11/98    KAW     SIR 14381 - During intake, a relate involving an
**                      inactive person should update their CD_PERSON_STATUS
**                      to 'A' for Active.  Added call to CAUD74D to update
**                      this field in the PERSON table.
**  10/26/00    EHC     SIR 15512 - This logic will support the realtion
**                      functionality for person detail.  Race and ethnicity
**                      information will need to be copied from the PERSON_RACE
**                      and PERSON_ETHNICITY tables when a person is being
**                      related.
**
**  04/02/2003  KRD     IMPACT - With the change to how intake works on the
**                      web, we need to specifically set the Search Indicator
**                      during the relate processing.  Required a change to
**                      CallCINT32D().
**  11/12/2003 JMC      IMPACT - SIR #22415 - Added the DAM call to CallCAUDJ8D
**                      to ensure the PERSON table was getting updated with the
**                      correct AGE.   In CAPS, the age was not saved to the 
**                      person table for a related person until the BigSave 
**                      was called.  Since we can no longer force the user's 
**                      to kick off the big save (due to IMPACTs open navigation),
**                      we must update the AGE here in the relate service.  
** 10/28/2004  OCHUMD   Sir 23212 - Added NmVictim and NmPerpetrator to be updated
**                      in the Allegation Detail table during relate. Added to 
**                      CINT33D.PC.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint08s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** SIR 14381
    */
    public static final char CD_ACTIVE = 'A';
    
    /* 15512 - Needed constants in order to loop through race and ethnicity
    **         record groups correctly.
    */
    public static final int MAX_RACE_ROWS = 6;
    public static final int MAX_ETHNIC_ROWS = 2;
    public static final int CODE_LEN = 3;
    
    public static final String NULL_STRING = "";
    public static final int NULL_DATE = - 1;
    /*
    ** IMPACT BEGIN - need related code
    */
    public static final char IND_RELATED = 'R';
    CINT08SO CINT08S(CINT08SI cint08si) {
        CINT08SO cint08so = new CINT08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cint08si.ArchInputStruct);
        rc = CallCINT27D(cint08si, cint08so, pServiceStatus);
        
        if (!(rc != 0)) {
            //  Retrieve the name of the person
            // who created the ToDo
            rc = CallCINT28D(cint08si, cint08so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            
            //  Retrieve the name of the person the ToDo
            // is assigned to.
            rc = CallCINT29D(cint08si, cint08so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            rc = CallCINT30D(cint08si, cint08so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            rc = CallCAUDD6D(cint08si, cint08so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = CallCAUDD7D(cint08si, cint08so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = CallCINT31D(cint08si, cint08so, pServiceStatus);
        }
        
        /*
        ** Analyze error code
        */
        if (!(rc != 0)) {
            rc = Ccfc14s.CallCAUD74D(cint08si, cint08so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = Cint10s.CallCINT32D(cint08si, cint08so, pServiceStatus);
        }
        if (!(rc != 0)) {
            
            //  Call DAM
            rc = Cint10s.CallCINT26D(cint08si, cint08so, pServiceStatus);
        }
        
        /*
        ** Analyze error code
        */
        if (!(rc != 0)) {
            rc = Cint10s.CallCINT33D(cint08si, cint08so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            rc = Cint10s.CallCINT60D(cint08si, cint08so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            rc = Ccmn02u.CallCCMN69D(cint08si, cint08so, pServiceStatus);
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint08si.ArchInputStruct, cint08so.ArchOutputStruct);
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
        return cint08so;
    }

    static int CallCINT26D(CINT08SI pInputMsg405, CINT08SO pOutputMsg371, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT26DI pCINT26DInputRec = null;
        CINT26DO pCINT26DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT26DInputRec = new CINT26DI();
        pCINT26DOutputRec = new CINT26DO();
        pCINT26DInputRec.setUlIdPerson(pInputMsg405.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT26DInputRec.setUlIdStage(pInputMsg405.RelatePersonInStruct.getUlIdStage());
        pCINT26DInputRec.setArchInputStruct(pInputMsg405.ArchInputStruct);
        rc = cint26dQUERYdam(sqlca, pCINT26DInputRec, pCINT26DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg371.PersonInfoStruct.setSzCdStagePersType(pCINT26DOutputRec.getSzCdStagePersType());
                pOutputMsg371.PersonInfoStruct.setUlIdName(pCINT26DOutputRec.getUlIdName());
                
                pOutputMsg371.PersonInfoStruct.setLdIdAddress(pCINT26DOutputRec.getLdIdAddress());
                pOutputMsg371.PersonInfoStruct.setUlIdPersonId(pCINT26DOutputRec.getUlIdPersonId());
                pOutputMsg371.PersonInfoStruct.setUlIdPhone(pCINT26DOutputRec.getUlIdPhone());
                pOutputMsg371.PersonInfoStruct.setUlIdAddrPersonLink(pCINT26DOutputRec.getUlIdAddrPersonLink());
                pOutputMsg371.PersonInfoStruct.setSzCdStagePersRole(pCINT26DOutputRec.getSzCdStagePersRole());
                pOutputMsg371.PersonInfoStruct.setSzNmNameFirst(pCINT26DOutputRec.getSzNmNameFirst());
                pOutputMsg371.PersonInfoStruct.setSzNmNameMiddle(pCINT26DOutputRec.getSzNmNameMiddle());
                pOutputMsg371.PersonInfoStruct.setSzNmNameLast(pCINT26DOutputRec.getSzNmNameLast());
                pOutputMsg371.PersonInfoStruct.setSzNmPersonFull(pCINT26DOutputRec.getSzNmPersonFull());
                pOutputMsg371.PersonInfoStruct.setDtDtPersonBirth(pCINT26DOutputRec.getDtDtPersonBirth());
                pOutputMsg371.PersonInfoStruct.setBIndPersonDobApprox(pCINT26DOutputRec.getBIndPersonDobApprox());
                pOutputMsg371.PersonInfoStruct.setLNbrPersonAge(pCINT26DOutputRec.getLNbrPersonAge());
                pOutputMsg371.PersonInfoStruct.setCCdPersonSex(pCINT26DOutputRec.getCCdPersonSex());
                pOutputMsg371.PersonInfoStruct.setSzCdStagePersRelInt(pCINT26DOutputRec.getSzCdStagePersRelInt());
                pOutputMsg371.PersonInfoStruct.setSzCdStagePersSearchInd(pCINT26DOutputRec.getSzCdStagePersSearchInd());
                
                // Return the return code to the calling routine
                pOutputMsg371.PersonInfoStruct.setBIndStagePersReporter(pCINT26DOutputRec.getBIndStagePersReporter());
                pOutputMsg371.PersonInfoStruct.setBIndStagePersInLaw(pCINT26DOutputRec.getBIndStagePersInLaw());
                pOutputMsg371.PersonInfoStruct.setSzCdNameSuffix(pCINT26DOutputRec.getSzCdNameSuffix());
                pOutputMsg371.PersonInfoStruct.setDtDtPersonDeath(pCINT26DOutputRec.getDtDtPersonDeath());
                pOutputMsg371.PersonInfoStruct.setSzNbrPersonIdNumber(pCINT26DOutputRec.getSzNbrPersonIdNumber());
                pOutputMsg371.PersonInfoStruct.setSzCdPersonMaritalStatus(pCINT26DOutputRec.getSzCdPersonMaritalStatus());
                pOutputMsg371.PersonInfoStruct.setSzCdPersonLanguage(pCINT26DOutputRec.getSzCdPersonLanguage());
                pOutputMsg371.PersonInfoStruct.setSzCdPersonEthnicGroup(pCINT26DOutputRec.getSzCdPersonEthnicGroup());
                pOutputMsg371.PersonInfoStruct.setSzTxtStagePersNotes(pCINT26DOutputRec.getSzTxtStagePersNotes());
                pOutputMsg371.PersonInfoStruct.setUlIdStage(pCINT26DOutputRec.getUlIdStage());
                pOutputMsg371.PersonInfoStruct.setUlIdPerson(pCINT26DOutputRec.getUlIdPerson());
                pOutputMsg371.PersonInfoStruct.setSzAddrPersAddrStLn1(pCINT26DOutputRec.getSzAddrPersAddrStLn1());
                pOutputMsg371.PersonInfoStruct.setSzAddrPersAddrStLn2(pCINT26DOutputRec.getSzAddrPersAddrStLn2());
                pOutputMsg371.PersonInfoStruct.setSzAddrCity(pCINT26DOutputRec.getSzAddrCity());
                pOutputMsg371.PersonInfoStruct.setSzCdAddrCounty(pCINT26DOutputRec.getSzCdAddrCounty());
                pOutputMsg371.PersonInfoStruct.setLAddrZip(pCINT26DOutputRec.getLAddrZip());
                pOutputMsg371.PersonInfoStruct.setSzCdAddrState(pCINT26DOutputRec.getSzCdAddrState());
                pOutputMsg371.PersonInfoStruct.setSzCdPersAddrLinkType(pCINT26DOutputRec.getSzCdPersAddrLinkType());
                pOutputMsg371.PersonInfoStruct.setLNbrPhone(pCINT26DOutputRec.getLNbrPhone());
                pOutputMsg371.PersonInfoStruct.setLNbrPhoneExtension(pCINT26DOutputRec.getLNbrPhoneExtension());
                pOutputMsg371.PersonInfoStruct.setSzCdPhoneType(pCINT26DOutputRec.getSzCdPhoneType());
                pOutputMsg371.PersonInfoStruct.setLScrNbrOfAddrs(pCINT26DOutputRec.getLScrNbrOfAddrs());
                pOutputMsg371.PersonInfoStruct.setLScrNbrPhoneNbrs(pCINT26DOutputRec.getLScrNbrPhoneNbrs());
                pOutputMsg371.PersonInfoStruct.setBScrIndAlias(pCINT26DOutputRec.getBScrIndAlias());
                pOutputMsg371.PersonInfoStruct.setLNbrPersonAge(pCINT26DOutputRec.getLNbrPersonAge());
                pOutputMsg371.PersonInfoStruct.setBScrIndPersIdentifiers(pCINT26DOutputRec.getBScrIndPersIdentifiers());
                pOutputMsg371.PersonInfoStruct.setSzCdPersonDeath(pCINT26DOutputRec.getSzCdPersonDeath());
                pOutputMsg371.PersonInfoStruct.setBIndPersonPhoneInvalid(pCINT26DOutputRec.getBIndPersonPhoneInvalid());
                pOutputMsg371.PersonInfoStruct.setBIndNameInvalid(pCINT26DOutputRec.getBIndNameInvalid());
                
                pOutputMsg371.PersonInfoStruct.setSzDescPersonID(pCINT26DOutputRec.getSzDescPersonID());
                pOutputMsg371.PersonInfoStruct.setDtDtNameEndDate(pCINT26DOutputRec.getDtDtNameEndDate());
                pOutputMsg371.PersonInfoStruct.setDtDtNameStartDate(pCINT26DOutputRec.getDtDtNameStartDate());
                pOutputMsg371.PersonInfoStruct.setDtDtPersAddrLinkEnd(pCINT26DOutputRec.getDtDtPersAddrLinkEnd());
                pOutputMsg371.PersonInfoStruct.setDtDtPersAddrLinkStart(pCINT26DOutputRec.getDtDtPersAddrLinkStart());
                pOutputMsg371.PersonInfoStruct.setDtPersonIDEnd(pCINT26DOutputRec.getDtPersonIDEnd());
                pOutputMsg371.PersonInfoStruct.setDtPersonIDStart(pCINT26DOutputRec.getDtPersonIDStart());
                pOutputMsg371.PersonInfoStruct.setDtDtPersonPhoneEnd(pCINT26DOutputRec.getDtDtPersonPhoneEnd());
                pOutputMsg371.PersonInfoStruct.setDtDtPersonPhoneStart(pCINT26DOutputRec.getDtDtPersonPhoneStart());
                pOutputMsg371.PersonInfoStruct.setBIndPersAddrLinkInvalid(pCINT26DOutputRec.getBIndPersAddrLinkInvalid());
                pOutputMsg371.PersonInfoStruct.setBIndPersonIDInvalid(pCINT26DOutputRec.getBIndPersonIDInvalid());
                pOutputMsg371.PersonInfoStruct.setSzTxtPersAddrCmnts(pCINT26DOutputRec.getSzTxtPersAddrCmnts());
                pOutputMsg371.PersonInfoStruct.setSzTxtPhoneComments(pCINT26DOutputRec.getSzTxtPhoneComments());
                if (pOutputMsg371.PersonInfoStruct.getDtDtPersonBirth().month != NULL_DATE) {
                    rc = CallCAUDJ8D(pInputMsg405, pOutputMsg371, pServiceStatus);
                }
                
                
                //  Call CINV43
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT27D(CINT08SI pInputMsg406, CINT08SO pOutputMsg372, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT27DI pCINT27DInputRec = null;
        CINT27DO pCINT27DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT27DInputRec = new CINT27DI();
        pCINT27DOutputRec = new CINT27DO();
        pCINT27DInputRec.setUlIdPerson(pInputMsg406.RelatePersonInStruct.getUlIdPerson());
        pCINT27DInputRec.setUlIdRelatedPerson(pInputMsg406.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT27DInputRec.setUlIdStage(pInputMsg406.RelatePersonInStruct.getUlIdStage());
        pCINT27DInputRec.setArchInputStruct(pInputMsg406.ArchInputStruct);
        
        
        /*
        ** Call CLSC11D
        */
        rc = cint27dAUDdam(sqlca, pCINT27DInputRec, pCINT27DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg372.PersonInfoStruct.setUlIdIncmgPerson(pCINT27DOutputRec.getUlIdIncmgPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INT_RELATE_ERROR;
                rc = Messages.MSG_INT_RELATE_ERROR;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT28D(CINT08SI pInputMsg407, CINT08SO pOutputMsg373, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT28DI pCINT28DInputRec = null;
        CINT28DO pCINT28DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT28DInputRec = new CINT28DI();
        pCINT28DOutputRec = new CINT28DO();
        pCINT28DInputRec.setUlIdPerson(pInputMsg407.RelatePersonInStruct.getUlIdPerson());
        pCINT28DInputRec.setUlIdRelatedPerson(pInputMsg407.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT28DInputRec.setUlIdIncmgPerson(pOutputMsg373.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT28DInputRec.setArchInputStruct(pInputMsg407.ArchInputStruct);
        
        
        /*
        ** Call CSES68D
        */
        rc = cint28dAUDdam(sqlca, pCINT28DInputRec, pCINT28DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT29D(CINT08SI pInputMsg408, CINT08SO pOutputMsg374, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT29DI pCINT29DInputRec = null;
        CINT29DO pCINT29DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT29DInputRec = new CINT29DI();
        pCINT29DOutputRec = new CINT29DO();
        pCINT29DInputRec.setUlIdPerson(pInputMsg408.RelatePersonInStruct.getUlIdPerson());
        pCINT29DInputRec.setUlIdRelatedPerson(pInputMsg408.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT29DInputRec.setUlIdIncmgPerson(pOutputMsg374.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT29DInputRec.setArchInputStruct(pInputMsg408.ArchInputStruct);
        rc = cint29dAUDdam(sqlca, pCINT29DInputRec, pCINT29DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT30D(CINT08SI pInputMsg409, CINT08SO pOutputMsg375, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT30DI pCINT30DInputRec = null;
        CINT30DO pCINT30DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT30DInputRec = new CINT30DI();
        pCINT30DOutputRec = new CINT30DO();
        pCINT30DInputRec.setUlIdPerson(pInputMsg409.RelatePersonInStruct.getUlIdPerson());
        pCINT30DInputRec.setUlIdRelatedPerson(pInputMsg409.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT30DInputRec.setUlIdIncmgPerson(pOutputMsg375.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT30DInputRec.setArchInputStruct(pInputMsg409.ArchInputStruct);
        rc = cint30dAUDdam(sqlca, pCINT30DInputRec, pCINT30DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT31D(CINT08SI pInputMsg410, CINT08SO pOutputMsg376, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT31DI pCINT31DInputRec = null;
        CINT31DO pCINT31DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT31DInputRec = new CINT31DI();
        pCINT31DOutputRec = new CINT31DO();
        pCINT31DInputRec.setUlIdPerson(pInputMsg410.RelatePersonInStruct.getUlIdPerson());
        pCINT31DInputRec.setUlIdIncmgPerson(pOutputMsg376.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT31DInputRec.setArchInputStruct(pInputMsg410.ArchInputStruct);
        rc = cint31dAUDdam(sqlca, pCINT31DInputRec, pCINT31DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CCMNA1D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT32D(CINT08SI pInputMsg411, CINT08SO * pOutputMsg377, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT32DI pCINT32DInputRec = null;
        CINT32DO pCINT32DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT32DInputRec = new CINT32DI();
        pCINT32DOutputRec = new CINT32DO();
        pCINT32DInputRec.setUlIdPerson(pInputMsg411.RelatePersonInStruct.getUlIdPerson());
        pCINT32DInputRec.setUlIdRelatedPerson(pInputMsg411.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT32DInputRec.setUlIdStage(pInputMsg411.RelatePersonInStruct.getUlIdStage());
        pCINT32DInputRec.setSzCdStagePersSearchInd(IND_RELATED);
        pCINT32DInputRec.setArchInputStruct(pInputMsg411.ArchInputStruct);
        pCINT32DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cint32dAUDdam(sqlca, pCINT32DInputRec, pCINT32DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT33D(CINT08SI pInputMsg412, CINT08SO pOutputMsg378, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT33DI pCINT33DInputRec = null;
        CINT33DO pCINT33DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT33DInputRec = new CINT33DI();
        pCINT33DOutputRec = new CINT33DO();
        pCINT33DInputRec.setUlIdPerson(pInputMsg412.RelatePersonInStruct.getUlIdPerson());
        pCINT33DInputRec.setUlIdRelatedPerson(pInputMsg412.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT33DInputRec.setUlIdStage(pInputMsg412.RelatePersonInStruct.getUlIdStage());
        pCINT33DInputRec.setSzNmPersonFull(pOutputMsg378.PersonInfoStruct.getSzNmPersonFull());
        pCINT33DInputRec.setArchInputStruct(pInputMsg412.ArchInputStruct);
        pCINT33DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cint33dAUDdam(sqlca, pCINT33DInputRec, pCINT33DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                //  If the dates and times are the same, they do not
                // need to be copied. Break out of the case statement.
                break;
        }
        return rc;
    }

    static int CallCINT60D(CINT08SI pInputMsg413, CINT08SO * pOutputMsg379, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT60DI pCINT60DInputRec = null;
        CINT60DO pCINT60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT60DInputRec = new CINT60DI();
        pCINT60DOutputRec = new CINT60DO();
        pCINT60DInputRec.setArchInputStruct(pInputMsg413.ArchInputStruct);
        pCINT60DInputRec.setUlIdPerson(pInputMsg413.RelatePersonInStruct.getUlIdPerson());
        
        
        /*
        ** Call CSEC63D
        */
        rc = cint60dQUERYdam(sqlca, pCINT60DInputRec, pCINT60DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN69D(CINT08SI pInputMsg414, CINT08SO pOutputMsg380, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN69DI pCCMN69DInputRec = null;
        CCMN69DO pCCMN69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN69DInputRec = new CCMN69DI();
        pCCMN69DOutputRec = new CCMN69DO();
        pCCMN69DInputRec.setUlIdPerson(pInputMsg414.RelatePersonInStruct.getUlIdRelatedPerson());
        pCCMN69DInputRec.setArchInputStruct(pInputMsg414.ArchInputStruct);
        rc = ccmn69dQUERYdam(sqlca, pCCMN69DInputRec, pCCMN69DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg380.ArchOutputStruct.setBMoreDataInd(1);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg380.ArchOutputStruct.setBMoreDataInd(0);
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                // End SIR# 15101
                
                // Send Notification to Worker
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCAUD74D(CINT08SI pInputMsg415, CINT08SO * pOutputMsg381, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUD74DI pCAUD74DInputRec = null;
        CAUD74DO pCAUD74DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD74DInputRec = new CAUD74DI();
        
        
        pCAUD74DOutputRec = new CAUD74DO();
        pCAUD74DInputRec.setArchInputStruct(pInputMsg415.ArchInputStruct);
        pCAUD74DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD74DInputRec.setUlIdPerson(pInputMsg415.RelatePersonInStruct.getUlIdRelatedPerson());
        pCAUD74DInputRec.getCdPersonStatus()[0] = CD_ACTIVE;
        /*
        ** Call CLSS68D:
        ** SELECT * FROM CONTRACT_COUNTY C WHERE C.ID_CONTRACT =
        ** AND C.NBR_CNCNTY_PERIOD  =        AND C.NBR_CNCNTY_VERSION =
        */
        rc = caud74dAUDdam(sqlca, pCAUD74DInputRec, pCAUD74DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCAUDD6D(CINT08SI pInputMsg416, CINT08SO pOutputMsg382, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i248 = 0;
        /*
        ** Declare local variables 
        */
        int rc = 0;
        int RetVal = SUCCESS;
        char bMoreRaces = 1;/*Flag for the race loop*/
        /* Return code */
        CAUDD6DI pCAUDD6DInputRec = null;
        CAUDD6DO pCAUDD6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD6DInputRec = new CAUDD6DI();
        pCAUDD6DOutputRec = new CAUDD6DO();
        pCAUDD6DInputRec.setArchInputStruct(pInputMsg416.ArchInputStruct);
        pCAUDD6DInputRec.setUlIdPerson(pInputMsg416.RelatePersonInStruct.getUlIdPerson());
        
        pCAUDD6DInputRec.setUlIdIncmgPerson(pOutputMsg382.PersonInfoStruct.getUlIdIncmgPerson());
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = caudd6dAUDdam(sqlca, pCAUDD6DInputRec, pCAUDD6DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                
                
                //  Call CINV74D
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                
                //  Call CSES68D
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                RetVal = SUCCESS;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUDD7D(CINT08SI pInputMsg417, CINT08SO pOutputMsg383, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i249 = 0;
        int rc = 0;/* Return code */
        int RetVal = SUCCESS;
        char bMoreEthnics = 1;/* Flag for the ethnicity loop */
        
        CAUDD7DI pCAUDD7DInputRec = null;
        CAUDD7DO pCAUDD7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD7DInputRec = new CAUDD7DI();
        pCAUDD7DOutputRec = new CAUDD7DO();
        pCAUDD7DInputRec.setArchInputStruct(pInputMsg417.ArchInputStruct);
        pCAUDD7DInputRec.setUlIdPerson(pInputMsg417.RelatePersonInStruct.getUlIdPerson());
        pCAUDD7DInputRec.setUlIdIncmgPerson(pOutputMsg383.PersonInfoStruct.getUlIdIncmgPerson());
        
        /*
        ** Set rc to SQL_SUCCESS
        */
        rc = caudd7dAUDdam(sqlca, pCAUDD7DInputRec, pCAUDD7DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                RetVal = SUCCESS;
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                // 
                // End Call to CCMN45D
                // 
                
                
                
                
                
                break;
        }
        return rc;
    }

    static int CallCAUDJ8D(CINT08SI pInputMsg418, CINT08SO pOutputMsg384, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i250 = 0;
        int rc = 0;
        int RetVal = SUCCESS;
        FndInt3date dtCurrentDate = null;/* used for CalcAge function */
        
        
        CAUDJ8DI pCAUDJ8DInputRec = null;
        CAUDJ8DO pCAUDJ8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDJ8DInputRec = new CAUDJ8DI();
        pCAUDJ8DOutputRec = new CAUDJ8DO();
        pCAUDJ8DInputRec.setArchInputStruct(pInputMsg418.ArchInputStruct);
        pCAUDJ8DInputRec.setUlIdPerson(pOutputMsg384.PersonInfoStruct.getUlIdPerson());
        rc = ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCAUDJ8DInputRec.setLNbrPersonAge(Cinv01s.CalcAge(pOutputMsg384.PersonInfoStruct.getDtDtPersonBirth() , dtCurrentDate));
        pCAUDJ8DInputRec.setArchInputStruct(pInputMsg418.ArchInputStruct);
        pCAUDJ8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = caudj8dAUDdam(sqlca, pCAUDJ8DInputRec, pCAUDJ8DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CalcAge(FndInt3date pDOB, FndInt3date pSystemDate) {
        int iAge = 0;
        if ((pDOB.month > pSystemDate.month) || (pDOB.day > pSystemDate.day) && (pDOB.month == pSystemDate.month)) {
            // birth date passed, age = current year - system year
            iAge = (pSystemDate.year - pDOB.year) - 1;
        }
        else {
            
            iAge = (pSystemDate.year - pDOB.year);
        }
        return iAge;
    }

}
