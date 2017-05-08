package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonInfoStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT61DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc14s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD8DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD9DO;
/**************************************************************************
**
** Module File:   cint10s.src
**
** Service Name:  Unrelate Person
**
** Description:   Unrelates a person from the Person Detail window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/01/1995
**
** Programmer:    Brian Gugliemetti, Andersen Consulting
**
** Archive Information: $Revision:   1.8  $
**                      $Date:   28 Nov 2000 14:41:50  $
**                      $Modtime:   28 Nov 2000 11:06:34  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/06/95  GUGLIEBS  ulIdRelatedPerson not passed to CINT33D
**  11Jun96   sladewmf  SIR #10046: Changed a COPYSZ from szNbrPersonIdSsn
**                      to szNbrPersonIdNumber. Added 16 COPYSZ's.
**  07/24/96    KRD     SIR 10493 - IdRelatedPerson was removed from the
**                      input record for CINT39D.  Other changes necessary
**                      for readability/maintainability.
**  01/06/97    KRD     SIR 21973 - A situation was found where, after
**                      Unrelate, a person may not be attached to any stages
**                      in the system.  To correct this problem, we now call
**                      DAM CINT60D which deletes people not linked to
**                      anything.
**  05/29/98  waltheka  SIR 14517 - During unrelate, person status is not
**                      being changed to Inactive when the person is not
**                      involved in any other open stages.  This sir will
**                      call CINV33D to check for open stages, and if there
**                      is not at least one stage open for the person being
**                      unrelated, that person's status will be set to
**                      Inactive by calling CAUD74D.
**  10/27/00     EHC    SIR 15512 - Logic is being added to support the unrelate
**                      functionality for person detail.  The race and ethnicity
**                      info will need to be copied from the PERSON_RACE and
**                      PERSON_ETHNICITY tables to the INCOMING_PERSON_RACE and
**                      INCOMING_PERSON_ETHNICITY tables when a person is being
**                      unrelated.
**
**  04/02/2003  KRD     IMPACT - With the change to how intake works on the
**                      web, we need to specifically set the Search Indicator
**                      during the unrelate processing.  Required a change to
**                      CallCINT32D().
**
** 10/28/2004  OCHUMD   Sir 23212 - Added NmVictim and NmPerpetrator to be updated
**                      in the Allegation Detail table during un-relate. Added to 
**                      CINT33D.PC.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint10s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** SIR 14517
    */
    public static final char CD_INACTIVE = 'I';
    
    /* 15512 - Needed constants in order to loop through race and ethnicity
    **         record groups correctly.
    */
    public static final int MAX_RACE_ROWS = 6;
    public static final int MAX_ETHNIC_ROWS = 2;
    public static final int CODE_LEN = 3;
    
    /*
    ** 15447
    */
    public static final String NULL_STRING = "";
    
    /*
    ** IMPACT BEGIN - need related code
    */
    public static final char IND_UNRELATED = 'U';
    CINT10SO CINT10S(CINT10SI cint10si) {
        CINT10SO cint10so = new CINT10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /*
        ** Call CINV81D
        */
        rc = ARC_PRFServiceStartTime_TUX(cint10si.ArchInputStruct);
        
        rc = CallCINT35D(cint10si, cint10so, pServiceStatus);
        if (!(rc != 0)) {
            rc = CallCINT36D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            
            //  SIR 2272 BSM and HJF -
            // Changed the todo text field.
            
            //  set the ToDo Description Text Field
            
            //  SIR 2915
            // Changed Description to name service for indexed
            // detail line item rather than service
            // from header
            // Get the decode value of the Service
            rc = CallCINT37D(cint10si, cint10so, pServiceStatus);
            
        }
        /********************************************************************
        ** END CAUD20D
        *********************************************************************/
        
        /* begin SIR #15787: Portion A is replaced by lines 5899 to #6091*/
        if (!(rc != 0)) {
            
            
            //  Call CSUB40U
            rc = CallCINT38D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = CallCAUDD8D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = CallCAUDD9D(cint10si, cint10so, pServiceStatus);
        }
        
        /**************************************************************
        ** END CAUD17D
        ***************************************************************/
        
        if (!(rc != 0)) {
            rc = CallCINT39D(cint10si, cint10so, pServiceStatus);
            
        }
        if (!(rc != 0)) {
            
            //  Call DAM
            rc = Cint08s.CallCINT32D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = Cint08s.CallCINT26D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            //  There is not a Law Enforcement Notification ToDo, so the
            // service can continue
            rc = Cint08s.CallCINT33D(cint10si, cint10so, pServiceStatus);
        }
        if (!(rc != 0)) {
            rc = CallCINT61D(cint10si, cint10so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            rc = Ccmn02u.CallCINV33D(cint10si, cint10so, pServiceStatus);
        }
        
        if (!(rc != 0)) {
            
            //  Call DAM
            rc = Cint08s.CallCINT60D(cint10si, cint10so, pServiceStatus);
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint10si.ArchInputStruct, cint10so.ArchOutputStruct);
        
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
                
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint10so;
    }

    static int CallCINT26D(CINT10SI pInputMsg423, CINT10SO pOutputMsg389, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        pCINT26DInputRec.setArchInputStruct(pInputMsg423.ArchInputStruct);
        pCINT26DInputRec.setUlIdPerson(pOutputMsg389.PersonInfoStruct.getUlIdPerson());
        
        pCINT26DInputRec.setUlIdStage(pInputMsg423.RelatePersonInStruct.getUlIdStage());
        
        /** 5/21/2003 mcclaim, don't want rc and RetVal to conflict */
        rc = cint26dQUERYdam(sqlca, pCINT26DInputRec, pCINT26DOutputRec);
        
        /*
        ** Now, based on the flags within the TodoFlags string
        ** set the CdTodoCf
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg389.PersonInfoStruct.setSzCdStagePersType(pCINT26DOutputRec.getSzCdStagePersType());
                pOutputMsg389.PersonInfoStruct.setUlIdName(pCINT26DOutputRec.getUlIdName());
                pOutputMsg389.PersonInfoStruct.setLdIdAddress(pCINT26DOutputRec.getLdIdAddress());
                pOutputMsg389.PersonInfoStruct.setUlIdPersonId(pCINT26DOutputRec.getUlIdPersonId());
                pOutputMsg389.PersonInfoStruct.setUlIdPhone(pCINT26DOutputRec.getUlIdPhone());
                pOutputMsg389.PersonInfoStruct.setUlIdAddrPersonLink(pCINT26DOutputRec.getUlIdAddrPersonLink());
                pOutputMsg389.PersonInfoStruct.setSzCdStagePersRole(pCINT26DOutputRec.getSzCdStagePersRole());
                pOutputMsg389.PersonInfoStruct.setSzNmNameFirst(pCINT26DOutputRec.getSzNmNameFirst());
                pOutputMsg389.PersonInfoStruct.setSzNmNameMiddle(pCINT26DOutputRec.getSzNmNameMiddle());
                pOutputMsg389.PersonInfoStruct.setSzNmNameLast(pCINT26DOutputRec.getSzNmNameLast());
                pOutputMsg389.PersonInfoStruct.setSzNmPersonFull(pCINT26DOutputRec.getSzNmPersonFull());
                pOutputMsg389.PersonInfoStruct.setDtDtPersonBirth(pCINT26DOutputRec.getDtDtPersonBirth());
                pOutputMsg389.PersonInfoStruct.setBIndPersonDobApprox(pCINT26DOutputRec.getBIndPersonDobApprox());
                
                pOutputMsg389.PersonInfoStruct.setLNbrPersonAge(pCINT26DOutputRec.getLNbrPersonAge());
                //  IMPACT END
                
                // 
                // Function Prototypes
                // 
                //  SIR 15512
                pOutputMsg389.PersonInfoStruct.setCCdPersonSex(pCINT26DOutputRec.getCCdPersonSex());
                pOutputMsg389.PersonInfoStruct.setSzCdStagePersRelInt(pCINT26DOutputRec.getSzCdStagePersRelInt());
                pOutputMsg389.PersonInfoStruct.setSzCdStagePersSearchInd(pCINT26DOutputRec.getSzCdStagePersSearchInd());
                
                //  SIR 15512
                pOutputMsg389.PersonInfoStruct.setBIndStagePersReporter(pCINT26DOutputRec.getBIndStagePersReporter());
                pOutputMsg389.PersonInfoStruct.setBIndStagePersInLaw(pCINT26DOutputRec.getBIndStagePersInLaw());
                pOutputMsg389.PersonInfoStruct.setSzCdNameSuffix(pCINT26DOutputRec.getSzCdNameSuffix());
                
                
                pOutputMsg389.PersonInfoStruct.setDtDtPersonDeath(pCINT26DOutputRec.getDtDtPersonDeath());
                pOutputMsg389.PersonInfoStruct.setSzNbrPersonIdNumber(pCINT26DOutputRec.getSzNbrPersonIdNumber());
                pOutputMsg389.PersonInfoStruct.setSzCdPersonMaritalStatus(pCINT26DOutputRec.getSzCdPersonMaritalStatus());
                
                pOutputMsg389.PersonInfoStruct.setSzCdPersonLanguage(pCINT26DOutputRec.getSzCdPersonLanguage());
                pOutputMsg389.PersonInfoStruct.setSzCdPersonEthnicGroup(pCINT26DOutputRec.getSzCdPersonEthnicGroup());
                pOutputMsg389.PersonInfoStruct.setSzTxtStagePersNotes(pCINT26DOutputRec.getSzTxtStagePersNotes());
                
                pOutputMsg389.PersonInfoStruct.setUlIdStage(pCINT26DOutputRec.getUlIdStage());
                pOutputMsg389.PersonInfoStruct.setUlIdPerson(pCINT26DOutputRec.getUlIdPerson());
                pOutputMsg389.PersonInfoStruct.setSzAddrPersAddrStLn1(pCINT26DOutputRec.getSzAddrPersAddrStLn1());
                
                pOutputMsg389.PersonInfoStruct.setSzAddrPersAddrStLn2(pCINT26DOutputRec.getSzAddrPersAddrStLn2());
                pOutputMsg389.PersonInfoStruct.setSzAddrCity(pCINT26DOutputRec.getSzAddrCity());
                pOutputMsg389.PersonInfoStruct.setSzCdAddrCounty(pCINT26DOutputRec.getSzCdAddrCounty());
                
                pOutputMsg389.PersonInfoStruct.setLAddrZip(pCINT26DOutputRec.getLAddrZip());
                pOutputMsg389.PersonInfoStruct.setSzCdAddrState(pCINT26DOutputRec.getSzCdAddrState());
                pOutputMsg389.PersonInfoStruct.setSzCdPersAddrLinkType(pCINT26DOutputRec.getSzCdPersAddrLinkType());
                
                pOutputMsg389.PersonInfoStruct.setLNbrPhone(pCINT26DOutputRec.getLNbrPhone());
                pOutputMsg389.PersonInfoStruct.setLNbrPhoneExtension(pCINT26DOutputRec.getLNbrPhoneExtension());
                pOutputMsg389.PersonInfoStruct.setSzCdPhoneType(pCINT26DOutputRec.getSzCdPhoneType());
                
                pOutputMsg389.PersonInfoStruct.setLScrNbrOfAddrs(pCINT26DOutputRec.getLScrNbrOfAddrs());
                pOutputMsg389.PersonInfoStruct.setLScrNbrPhoneNbrs(pCINT26DOutputRec.getLScrNbrPhoneNbrs());
                pOutputMsg389.PersonInfoStruct.setBScrIndAlias(pCINT26DOutputRec.getBScrIndAlias());
                
                pOutputMsg389.PersonInfoStruct.setBScrIndPersIdentifiers(pCINT26DOutputRec.getBScrIndPersIdentifiers());
                pOutputMsg389.PersonInfoStruct.setSzCdPersonDeath(pCINT26DOutputRec.getSzCdPersonDeath());
                pOutputMsg389.PersonInfoStruct.setBIndPersonPhoneInvalid(pCINT26DOutputRec.getBIndPersonPhoneInvalid());
                
                pOutputMsg389.PersonInfoStruct.setBIndNameInvalid(pCINT26DOutputRec.getBIndNameInvalid());
                pOutputMsg389.PersonInfoStruct.setSzDescPersonID(pCINT26DOutputRec.getSzDescPersonID());
                pOutputMsg389.PersonInfoStruct.setDtDtNameEndDate(pCINT26DOutputRec.getDtDtNameEndDate());
                
                pOutputMsg389.PersonInfoStruct.setDtDtNameStartDate(pCINT26DOutputRec.getDtDtNameStartDate());
                pOutputMsg389.PersonInfoStruct.setDtDtPersAddrLinkEnd(pCINT26DOutputRec.getDtDtPersAddrLinkEnd());
                pOutputMsg389.PersonInfoStruct.setDtDtPersAddrLinkStart(pCINT26DOutputRec.getDtDtPersAddrLinkStart());
                
                // SIR 14381
                pOutputMsg389.PersonInfoStruct.setDtPersonIDEnd(pCINT26DOutputRec.getDtPersonIDEnd());
                pOutputMsg389.PersonInfoStruct.setDtPersonIDStart(pCINT26DOutputRec.getDtPersonIDStart());
                pOutputMsg389.PersonInfoStruct.setDtDtPersonPhoneEnd(pCINT26DOutputRec.getDtDtPersonPhoneEnd());
                
                pOutputMsg389.PersonInfoStruct.setDtDtPersonPhoneStart(pCINT26DOutputRec.getDtDtPersonPhoneStart());
                pOutputMsg389.PersonInfoStruct.setBIndPersAddrLinkInvalid(pCINT26DOutputRec.getBIndPersAddrLinkInvalid());
                pOutputMsg389.PersonInfoStruct.setBIndPersonIDInvalid(pCINT26DOutputRec.getBIndPersonIDInvalid());
                
                //## BEGIN TUX/XML: Declare XML variables 
                pOutputMsg389.PersonInfoStruct.setSzTxtPersAddrCmnts(pCINT26DOutputRec.getSzTxtPersAddrCmnts());
                pOutputMsg389.PersonInfoStruct.setSzTxtPhoneComments(pCINT26DOutputRec.getSzTxtPhoneComments());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT35D(CINT10SI pInputMsg424, CINT10SO pOutputMsg390, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT35DI pCINT35DInputRec = null;
        CINT35DO pCINT35DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT35DInputRec = new CINT35DI();
        pCINT35DOutputRec = new CINT35DO();
        pCINT35DInputRec.setUlIdPerson(pInputMsg424.RelatePersonInStruct.getUlIdPerson());
        pCINT35DInputRec.setUlIdRelatedPerson(pInputMsg424.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT35DInputRec.setUlIdStage(pInputMsg424.RelatePersonInStruct.getUlIdStage());
        pCINT35DInputRec.setArchInputStruct(pInputMsg424.ArchInputStruct);
        /*
        ** IMPACT END
        */
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = cint35dAUDdam(sqlca, pCINT35DInputRec, pCINT35DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg390.PersonInfoStruct.setUlIdPerson(pCINT35DOutputRec.getUlIdPerson());
                pOutputMsg390.PersonInfoStruct.setUlIdIncmgPerson(pCINT35DOutputRec.getUlIdIncmgPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT36D(CINT10SI pInputMsg425, CINT10SO pOutputMsg391, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT36DI pCINT36DInputRec = null;
        CINT36DO pCINT36DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT36DInputRec = new CINT36DI();
        pCINT36DOutputRec = new CINT36DO();
        pCINT36DInputRec.setUlIdPerson(pOutputMsg391.PersonInfoStruct.getUlIdPerson());
        pCINT36DInputRec.setUlIdIncmgPerson(pOutputMsg391.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT36DInputRec.setUlIdRelatedPerson(pInputMsg425.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT36DInputRec.setArchInputStruct(pInputMsg425.ArchInputStruct);
        
        /*
        ** Call DAM
        */
        rc = cint36dAUDdam(sqlca, pCINT36DInputRec, pCINT36DOutputRec);
        
        
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

    static int CallCINT37D(CINT10SI pInputMsg426, CINT10SO pOutputMsg392, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT37DI pCINT37DInputRec = null;
        CINT37DO pCINT37DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT37DInputRec = new CINT37DI();
        
        pCINT37DOutputRec = new CINT37DO();
        pCINT37DInputRec.setUlIdPerson(pOutputMsg392.PersonInfoStruct.getUlIdPerson());
        pCINT37DInputRec.setUlIdIncmgPerson(pOutputMsg392.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT37DInputRec.setUlIdRelatedPerson(pInputMsg426.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT37DInputRec.setArchInputStruct(pInputMsg426.ArchInputStruct);
        rc = cint37dAUDdam(sqlca, pCINT37DInputRec, pCINT37DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call CSEC29D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT38D(CINT10SI pInputMsg427, CINT10SO pOutputMsg393, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT38DI pCINT38DInputRec = null;
        CINT38DO pCINT38DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT38DInputRec = new CINT38DI();
        
        pCINT38DOutputRec = new CINT38DO();
        pCINT38DInputRec.setUlIdPerson(pOutputMsg393.PersonInfoStruct.getUlIdPerson());
        pCINT38DInputRec.setUlIdIncmgPerson(pOutputMsg393.PersonInfoStruct.getUlIdIncmgPerson());
        pCINT38DInputRec.setUlIdRelatedPerson(pInputMsg427.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT38DInputRec.setArchInputStruct(pInputMsg427.ArchInputStruct);
        rc = cint38dAUDdam(sqlca, pCINT38DInputRec, pCINT38DOutputRec);
        
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

    static int CallCINT39D(CINT10SI pInputMsg428, CINT10SO pOutputMsg394, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT39DI pCINT39DInputRec = null;
        CINT39DO pCINT39DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT39DInputRec = new CINT39DI();
        
        pCINT39DOutputRec = new CINT39DO();
        pCINT39DInputRec.setUlIdPerson(pOutputMsg394.PersonInfoStruct.getUlIdPerson());
        pCINT39DInputRec.setUlIdIncmgPerson(pOutputMsg394.PersonInfoStruct.getUlIdIncmgPerson());
        
        pCINT39DInputRec.setArchInputStruct(pInputMsg428.ArchInputStruct);
        
        /*
        ** Call CRES04D
        */
        rc = cint39dAUDdam(sqlca, pCINT39DInputRec, pCINT39DOutputRec);
        
        
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

    static int CallCINT32D(CINT10SI pInputMsg429, CINT10SO pOutputMsg395, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINT32DInputRec.setUlIdPerson(pInputMsg429.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT32DInputRec.setUlIdRelatedPerson(pOutputMsg395.PersonInfoStruct.getUlIdPerson());
        pCINT32DInputRec.setUlIdStage(pInputMsg429.RelatePersonInStruct.getUlIdStage());
        pCINT32DInputRec.setSzCdStagePersSearchInd(IND_UNRELATED);
        
        pCINT32DInputRec.setArchInputStruct(pInputMsg429.ArchInputStruct);
        pCINT32DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        /* call DAM */
        rc = cint32dAUDdam(sqlca, pCINT32DInputRec, pCINT32DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
            case NO_DATA_FOUND:
                //  Do nothing, the output message just returns success or
                // failure.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
                
        }
        return rc;
    }

    static int CallCINT33D(CINT10SI pInputMsg430, CINT10SO pOutputMsg396, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        
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
        pCINT33DInputRec.setUlIdPerson(pInputMsg430.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT33DInputRec.setUlIdRelatedPerson(pOutputMsg396.PersonInfoStruct.getUlIdPerson());
        pCINT33DInputRec.setUlIdStage(pInputMsg430.RelatePersonInStruct.getUlIdStage());
        pCINT33DInputRec.setSzNmPersonFull(pOutputMsg396.PersonInfoStruct.getSzNmPersonFull());
        pCINT33DInputRec.setArchInputStruct(pInputMsg430.ArchInputStruct);
        pCINT33DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call Retrieve DAM
        */
        rc = cint33dAUDdam(sqlca, pCINT33DInputRec, pCINT33DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                //  Call Retrieve DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT61D(CINT10SI pInputMsg431, CINT10SO * pOutputMsg397, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code  */
        
        /*
        ** Declare local variables
        */
        CINT61DI pCINT61DInputRec = null;
        CINT61DO pCINT61DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT61DInputRec = new CINT61DI();
        
        pCINT61DOutputRec = new CINT61DO();
        pCINT61DInputRec.setUlIdPerson(pInputMsg431.RelatePersonInStruct.getUlIdRelatedPerson());
        pCINT61DInputRec.setUlIdStage(pInputMsg431.RelatePersonInStruct.getUlIdStage());
        
        
        /*
        ** Call CINV51D
        */
        rc = cint61dSPdam(sqlca, pCINT61DInputRec, pCINT61DOutputRec);
        
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSES68D
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        return rc;
    }

    static int CallCINT60D(CINT10SI pInputMsg432, CINT10SO * pOutputMsg398, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        
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
        pCINT60DInputRec.setArchInputStruct(pInputMsg432.ArchInputStruct);
        pCINT60DInputRec.setUlIdPerson(pInputMsg432.RelatePersonInStruct.getUlIdRelatedPerson());
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = cint60dQUERYdam(sqlca, pCINT60DInputRec, pCINT60DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Set rc to MSG_DETAIL_DELETED
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV33D(CINT10SI pInputMsg433, CINT10SO pOutputMsg399, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV33DI pCINV33DInputRec = null;
        CINV33DO pCINV33DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV33DInputRec = new CINV33DI();
        
        pCINV33DOutputRec = new CINV33DO();
        pCINV33DInputRec.setUlIdPerson(pInputMsg433.RelatePersonInStruct.getUlIdRelatedPerson());
        pInputMsg433.ArchInputStruct.setUsPageNbr(1);
        pCINV33DInputRec.setArchInputStruct(pInputMsg433.ArchInputStruct);
        rc = cinv33dQUERYdam(sqlca, pCINV33DInputRec, pCINV33DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = Ccfc14s.CallCAUD74D(pInputMsg433, pOutputMsg399, pServiceStatus);
                    rc = 0;
                    
                    
                    
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        return rc;
    }

    static int CallCAUD74D(CINT10SI pInputMsg434, CINT10SO * pOutputMsg400, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        
        pCAUD74DInputRec.setArchInputStruct(pInputMsg434.ArchInputStruct);
        pCAUD74DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD74DInputRec.setUlIdPerson(pInputMsg434.RelatePersonInStruct.getUlIdRelatedPerson());
        pCAUD74DInputRec.getCdPersonStatus()[0] = CD_INACTIVE;
        rc = caud74dAUDdam(sqlca, pCAUD74DInputRec, pCAUD74DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCAUDD8D(CINT10SI pInputMsg435, CINT10SO pOutputMsg401, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i254 = 0;
        int rc = 0;
        int RetVal = SUCCESS;
        char bMoreRaces = 1;/*Flag for the race loop*/
        /* Return code */
        CAUDD8DI pCAUDD8DInputRec = null;
        CAUDD8DO pCAUDD8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD8DInputRec = new CAUDD8DI();
        pCAUDD8DOutputRec = new CAUDD8DO();
        pCAUDD8DInputRec.setArchInputStruct(pInputMsg435.ArchInputStruct);
        
        /* Return the return code to the calling routine */
        pCAUDD8DInputRec.setUlIdPerson(pOutputMsg401.PersonInfoStruct.getUlIdPerson());
        pCAUDD8DInputRec.setUlIdIncmgPerson(pOutputMsg401.PersonInfoStruct.getUlIdIncmgPerson());
        rc = caudd8dAUDdam(sqlca, pCAUDD8DInputRec, pCAUDD8DOutputRec);
        
        /*
        ** Analyze return code
        */
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
                
                //  Call DAM
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                RetVal = SUCCESS;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUDD9D(CINT10SI pInputMsg436, CINT10SO pOutputMsg402, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i255 = 0;
        int rc = 0;/* Return code */
        int RetVal = SUCCESS;
        char bMoreEthnics = 1;/* Flag for the ethnicity loop */
        
        CAUDD9DI pCAUDD9DInputRec = null;
        CAUDD9DO pCAUDD9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD9DInputRec = new CAUDD9DI();
        pCAUDD9DOutputRec = new CAUDD9DO();
        pCAUDD9DInputRec.setArchInputStruct(pInputMsg436.ArchInputStruct);
        pCAUDD9DInputRec.setUlIdPerson(pOutputMsg402.PersonInfoStruct.getUlIdPerson());
        pCAUDD9DInputRec.setUlIdIncmgPerson(pOutputMsg402.PersonInfoStruct.getUlIdIncmgPerson());
        rc = caudd9dAUDdam(sqlca, pCAUDD9DInputRec, pCAUDD9DOutputRec);
        
        
        /*
        ** Analyze return code
        */
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
                break;
        }
        return rc;
    }

}
