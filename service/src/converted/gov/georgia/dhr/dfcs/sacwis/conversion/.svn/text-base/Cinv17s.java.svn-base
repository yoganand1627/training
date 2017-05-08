package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV89DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV89DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC88DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC88DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS77DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS78DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES99DO;
/**************************************************************************
**
** Module File:   cinv17s.src
**
** Service Name:  cinv17s
**
** Description:   Performs retrieval for the Facilities Inv Conclusion
**                  window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/21/95
**
** Programmer:    SPR
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/29/95  VISHNUR   SIR 2072 County missing in the Address/phone detail.
**                      Added code to pass the code retrieved thru cint09d,
**                      from Incoming detail.
**  3/6/96    ODONNERJ  SIR 1700 Change APS Facil abuse/Neglect Form
**                      to document. Specifically, We added the csys06d dam
**                      to check if a Document BLOB exists in the database
**  5/13/96    ODONNERJ  SIR 1791 Change Notif to Law Enforcement to Document
**                      Add second call to CSYS06D.
**  04/02/97  GONZALCE  SIR 13618/MHMR Enhancement:  Added CRES04D to retrieve
**                      the MHMR component code.  Added MHMR component code
**                      variable to CINV17D output rec to pass it to the
**                      service output msg.
**  04/09/97  RIOSJA    SIR 13618 - MHMR Enhancement for "Investigation
**                      Rapid Closure". Added indicator for Superintendent
**                      Notification.
**  05/14/97  GONZALCE  SIR 13618 - MHMR Enhancement :  Request for Review
**                      Add CINVB8 to determine if any Request for Review
**                      contacts have been recorded.
**  8/20/97     klm     SIR# 14001 - Add a call to CINT09D to retrieve the
**                      Resource ID from the Incoming Facility table. The
**                      ID will be used to find the MHMR Code.
**  2/18/98   MATTESJM  SIR# 14201 - MHMR Enhancement. Add a new DAM
**                      function (clsc88d.pc) to retreive information from
**                      the allegation, facility_allegtation, and
**                      faility_injury table.  A new data element is added
**                      to the service output message to hold the
**                      appropriate code to indicate conditions have been
**                      met to close the investigation stage on the Facility
**                      Investigation Conclusion window.
**  4/30/98   KOMARA    MHMR3 - Item 8.5 MHMR Enhancement.  Add a brand new
**                      referral form.
** 05/28/98   RIOSJA    MHMR Phase III Item 6.1 - The Initial Face-to-Face
**                      Date and Time can now be changed until the stage is
**                      closed or until a Request for Review is generated.
**                      The Initial Face-to-Face Date and Time is changed by
**                      changing the date and time of the earliest
**                      Face-to-Face Assessment Contact. If this contact is
**                      deleted, the date and time on the Investigation
**                      Conclusion window will be cleared out.
** 05/28/98   RIOSJA    MHMR Phase III Item 6.2 - When the closure reason is
**                      "Reclassification", a new message will be displayed
**                      when the user Saves & Closes or Saves & Submits. The
**                      message box will remind the user that a new call
**                      must be created, and it will display the stage id of
**                      the Intake stage from which the Investigation stage
**                      was progressed.
** 06/02/98   RIOSJA    MHMR Phase III Item 6.3 - Two new message boxes are
**                      now available relating to the MHMR Client Number.
**                      The first message box will notify the user that a
**                      Client Number is required for all victims in the
**                      stage. The second message box will remind the user
**                      that it is necessary to verify that all
**                      merged/related victims have the correct Client
**                      Number.
** 08/21/98   RIOSJA    MHMR Phase III Item 6.3b - The new message box that
**                      notifies the user that an MHMR Client # is required
**                      for all victims in the case will now appear if any
**                      victim in the case (past or present) does not have
**                      an MHMR Client #.
** 03/02/1999 PAULS     SIR 14963 - Added a Contact Type of Initial face to
**                       face  for AFC Investigations. The date and time of
**                       this contact should also prefill onto the Facility
**                       Investigation Window and in the Abuse Neglect Report.
**                       Search on Sir # for comments.
** 03/27/2001 GRIMSHAN  SIR 13532 - Made code modifications to prevent MHMR
**                      client number missing edit from appearing while
**                      trying to close an investigation when the name is
**                      unknown.  Added new DAM CSES99D.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv17s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String NULL_STRING = "";
    
    
    /*
    ** Declare FOUNDATION variables
    */
    
    
    public static final int NULL_DATE = - 1;
    public static final String CONTACT_PURPOSE = "AAMT";
    public static final String INITIAL_FACE_TO_FACE = "EIFF";
    /* SIR 1700 */
    public static final String APS_FACILITY_NARRATIVE_VIEW = "aps_facil_narr_view";
    /* SIR 1791 */
    public static final int APS_INVEST_NOTIF_LE_INDEX = 1;
    public static final int FACILITIES_ABUSE_NEGLECT_INDEX = 0;
    public static final String APS_NOTIF_LE_NARR = "APS_NOTIF_NARR_VIEW";
    /* SIR 13618 - Request for Review*/
    public static final int REVIEW_CONTACT = 1;
    public static final String FACIL_CONCL_NARR_VIEW = "FACIL_CONCL_NARR_VIEW";
    public static final String FACIL_CONCL_REVIEW_NARR_VIEW = "FAC_CONCL_REV_NARR_VIEW";
    public static final String APS_FACIL_REVIEW_NARR_VIEW = "APS_FACIL_REV_NARR_VIEW";
    public static final int FACILITIES_INVST_CONCL_INDEX = 2;
    public static final int REVIEW_FACILITIES_ABUSE_NEGLECT_INDEX = 3;
    public static final int REVIEW_FACILITIES_INVST_CONCL_INDEX = 4;
    /* MHMR3 Item 8.5 begin */
    public static final String FAC_REFERRAL_NARR = "REFERRAL_NARR";
    public static final int FAC_REFERRAL_INDEX = 5;
    /* MHMR3 Item 8.5 end */
    /* SIR 14201 - MHMR enhancement: add new closure reason */
    public static final char FC_NO_DATE = 'D';
    public static final char FC_NO_INJ_LST_DETAIL = 'I';
    public static final char FC_NO_ALLEG_SER = 'A';
    public static final char FC_ALL_COND_MET = 'C';
    public static final String CD_SERIOUS_INJ = "CC1";
    /*
    ** Initial page setting
    */
    public static final int PAGE_NUM_ONE = 1;
    
    /*
    ** MHMR Phase III Item 6.3 (RIOSJA)
    */
    public static final char RELATED = 'R';
    public static final String MHMR_CLIENT_NUM_ID_TYPE = "MHMR Client #";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    
    
    /**************************************************************************
    ** Function Prototypes
    ***************************************************************************/
    
    
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    
    /**************************************************************************
    **
    ** Function Name:  CCFC32S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CINV17SI pInputMsg = null;
    static CINV17SO pOutputMsg = null;
    CINV17SO CINV17S(CINV17SI cinv17si) {
        CINV17SO cinv17so = new CINV17SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        Pint ulPriorStage = new Pint();
        String szTablename = new String();
        char bIndLeNotif = 0;/* MHMR3 Item 8.5 */
        rc = ARC_PRFServiceStartTime_TUX(cinv17si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cinv17so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (cinv17si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv17si, cinv17so, pServiceStatus);
            
            //## BEGIN TUX/XML: Declare XML variables 
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Cinv18s.CallCINV17D(cinv17si, cinv17so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (cinv17so.getROWCINV17SOG02().getUlIdFacilResource() == 0) {
            rc = Cinv56s.CallCINV86D(cinv17si, cinv17so, ulPriorStage, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = Cinv56s.CallCINT09D(cinv17si, cinv17so, ulPriorStage.value, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if ((cinv17so.getROWCINV17SOG02().getUlIdFacilResource() != 0) && (0 == cinv17so.getROWCINV17SOG02().getSzCdMhmrCompCode().compareTo(NULL_STRING))) {
            
            //  The DAM CLSS36D will retrieve all records from the ADMIN DTL table that
            // have a ID INVOICE equal to the one passed into the service
            
            //  Start Performance Timer
            rc = Cfad08s.CallCRES04D(cinv17si, cinv17so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccfc33s.CallCINVB8D(cinv17si, cinv17so, pServiceStatus);
        
        /*
        ** Analyze return code for CINV51D(VP)
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        szTablename = APS_FACILITY_NARRATIVE_VIEW;
        rc = CallCSYS06D(cinv17si, cinv17so, pServiceStatus, (char) szTablename, bIndLeNotif);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        szTablename = APS_FACIL_REVIEW_NARR_VIEW;
        
        
        /*
        ** Call CLSS36D
        */
        rc = CallCSYS06D(cinv17si, cinv17so, pServiceStatus, (char) szTablename, bIndLeNotif);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        szTablename = FACIL_CONCL_NARR_VIEW;
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = CallCSYS06D(cinv17si, cinv17so, pServiceStatus, (char) szTablename, bIndLeNotif);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        szTablename = FACIL_CONCL_REVIEW_NARR_VIEW;
        rc = CallCSYS06D(cinv17si, cinv17so, pServiceStatus, (char) szTablename, bIndLeNotif);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        szTablename = FAC_REFERRAL_NARR;
        rc = CallCSYS06D(cinv17si, cinv17so, pServiceStatus, (char) szTablename, bIndLeNotif);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (!(cinv17so.getROWCINV17SOG02().getSzNmFacilInvstFacility().compareTo(NULL_STRING) != 0)) {
            
            
            //  Call CLSS75D
            rc = Cinv56s.CallCINV86D(cinv17si, cinv17so, ulPriorStage, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            //  Set rc to ARC_SUCCESS
            rc = Cinv56s.CallCINT09D(cinv17si, cinv17so, ulPriorStage.value, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn80s.CallCINT40D(cinv17si, cinv17so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if ((cinv17so.getROWCINV17SOG03().getDtDtStageClose().year == NULL_DATE) && (cinv17so.getROWCINV17SOG02().getUlNbrReviewContact() != REVIEW_CONTACT)) {
            rc = CallCINVB6D(cinv17si, cinv17so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Call DAM
        */
        rc = CallCINV89D(cinv17si, cinv17so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        /* No rows found is acceptable.  Not an error */
        rc = CallCLSC88D(cinv17si, cinv17so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Cinv14s.CallCLSC84D(cinv17si, cinv17so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        cinv17so.getROWCINV17SOG01().setCIndMhmrClientNum(Cint14s.INDICATOR_NO);
        cinv17so.getROWCINV17SOG01().setCIndVerMhmrClientNum(Cint14s.INDICATOR_NO);
        rc = CallCLSS77D(cinv17si, cinv17so, pServiceStatus);
        
        /*
        ** Analyze return code for CINV51D(CL)
        */
        switch (rc) {
            case SUCCESS:
            case NO_DATA_FOUND:
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv17si.getArchInputStruct() , cinv17so.getArchOutputStruct());
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
        return cinv17so;
    }

    
    static int CallCCMN45D(CINV17SI pInputMsg618, CINV17SO pOutputMsg571, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter */
        int rc = 0;/* Return code  */
        
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg618.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg618.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg571.getROWCINV17SOG01().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
            pOutputMsg571.getROWCINV17SOG01().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
            pOutputMsg571.getROWCINV17SOG01().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
            pOutputMsg571.getROWCINV17SOG01().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
            pOutputMsg571.getROWCINV17SOG01().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
            pOutputMsg571.getROWCINV17SOG01().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
            pOutputMsg571.getROWCINV17SOG01().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
            pOutputMsg571.getROWCINV17SOG01().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
            pOutputMsg571.getROWCINV17SOG01().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
        }
        
        return rc;
    }

    static int CallCINV17D(CINV17SI pInputMsg619, CINV17SO pOutputMsg572, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV17DInputRec = new CINV17DI();
        
        pCINV17DOutputRec = new CINV17DO();
        pCINV17DInputRec.setArchInputStruct(pInputMsg619.getArchInputStruct());
        pCINV17DInputRec.setUlIdStage(pInputMsg619.getUlIdStage());
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        /*
        ** Start performance timer for service. All performance functions always
        ** return success so there is no need to check status.
        */
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg572.getROWCINV17SOG02().setSzCdMhmrCompCode(pCINV17DOutputRec.getSzCdMhmrCompCode());
            pOutputMsg572.getROWCINV17SOG02().setUlIdFacilResource(pCINV17DOutputRec.getUlIdFacilResource());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffAttn(pCINV17DOutputRec.getSzAddrFacilInvstAffAttn());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffCity(pCINV17DOutputRec.getSzAddrFacilInvstAffCity());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffCnty(pCINV17DOutputRec.getSzAddrFacilInvstAffCnty());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffilSt(pCINV17DOutputRec.getSzAddrFacilInvstAffilSt());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffStr1(pCINV17DOutputRec.getSzAddrFacilInvstAffStr1());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffStr2(pCINV17DOutputRec.getSzAddrFacilInvstAffStr2());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAffZip(pCINV17DOutputRec.getSzAddrFacilInvstAffZip());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstAttn(pCINV17DOutputRec.getSzAddrFacilInvstAttn());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstCity(pCINV17DOutputRec.getSzAddrFacilInvstCity());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstCnty(pCINV17DOutputRec.getSzAddrFacilInvstCnty());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstState(pCINV17DOutputRec.getSzAddrFacilInvstState());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstStr1(pCINV17DOutputRec.getSzAddrFacilInvstStr1());
            pOutputMsg572.getROWCINV17SOG02().setSzAddrFacilInvstStr2(pCINV17DOutputRec.getSzAddrFacilInvstStr2());
            pOutputMsg572.getROWCINV17SOG02().setSsAddrFacilInvstZip(pCINV17DOutputRec.getSsAddrFacilInvstZip());
            pOutputMsg572.getROWCINV17SOG02().setSzCdFacilInvstOvrallDis(pCINV17DOutputRec.getSzCdFacilInvstOvrallDis());
            pOutputMsg572.getROWCINV17SOG02().setDtDtFacilInvstBegun(pCINV17DOutputRec.getDtDtFacilInvstBegun());
            pOutputMsg572.getROWCINV17SOG02().setTmSysTmFacilInvstBeg(pCINV17DOutputRec.getTmSysTmFacilInvstBeg());
            pOutputMsg572.getROWCINV17SOG02().setDtDtFacilInvstComplt(pCINV17DOutputRec.getDtDtFacilInvstComplt());
            pOutputMsg572.getROWCINV17SOG02().setDtDtFacilInvstIncident(pCINV17DOutputRec.getDtDtFacilInvstIncident());
            
            pOutputMsg572.getROWCINV17SOG02().setTmSysTmFacilInvstInc(pCINV17DOutputRec.getTmSysTmFacilInvstInc());
            pOutputMsg572.getROWCINV17SOG02().setDtDtFacilInvstIntake(pCINV17DOutputRec.getDtDtFacilInvstIntake());
            pOutputMsg572.getROWCINV17SOG02().setTmSysTmFacilInvstInt(pCINV17DOutputRec.getTmSysTmFacilInvstInt());
            pOutputMsg572.getROWCINV17SOG02().setUlIdAffilResource(pCINV17DOutputRec.getUlIdAffilResource());
            pOutputMsg572.getROWCINV17SOG02().setUlIdEvent(pCINV17DOutputRec.getUlIdEvent());
            pOutputMsg572.getROWCINV17SOG02().setUlIdFacilResource(pCINV17DOutputRec.getUlIdFacilResource());
            pOutputMsg572.getROWCINV17SOG02().setUlIdStage(pCINV17DOutputRec.getUlIdStage());
            pOutputMsg572.getROWCINV17SOG02().setSzNbrFacilInvstAffilExt(pCINV17DOutputRec.getSzNbrFacilInvstAffilExt());
            pOutputMsg572.getROWCINV17SOG02().setLNbrFacilInvstAffilPhn(pCINV17DOutputRec.getLNbrFacilInvstAffilPhn());
            pOutputMsg572.getROWCINV17SOG02().setSzNbrFacilInvstExtension(pCINV17DOutputRec.getSzNbrFacilInvstExtension());
            
            pOutputMsg572.getROWCINV17SOG02().setLNbrFacilInvstPhone(pCINV17DOutputRec.getLNbrFacilInvstPhone());
            pOutputMsg572.getROWCINV17SOG02().setSzNmFacilInvstAff(pCINV17DOutputRec.getSzNmFacilInvstAff());
            pOutputMsg572.getROWCINV17SOG02().setSzNmFacilInvstFacility(pCINV17DOutputRec.getSzNmFacilInvstFacility());
            pOutputMsg572.getROWCINV17SOG02().setSzTxtFacilInvstAffilCmnt(pCINV17DOutputRec.getSzTxtFacilInvstAffilCmnt());
            pOutputMsg572.getROWCINV17SOG02().setSzTxtFacilInvstComments(pCINV17DOutputRec.getSzTxtFacilInvstComments());
            pOutputMsg572.getROWCINV17SOG02().setTsLastUpdate(pCINV17DOutputRec.getTsLastUpdate());
            pOutputMsg572.getROWCINV17SOG02().setCIndFacilSuperintNotif(pCINV17DOutputRec.getCIndFacilSuperintNotif());
        }
        return rc;
    }

    static int CallCINV86D(CINV17SI pInputMsg620, CINV17SO * pOutputMsg573, Pint pulPriorStage, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV86DI pCINV86DInputRec = null;
        CINV86DO pCINV86DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV86DInputRec = new CINV86DI();
        
        pCINV86DOutputRec = new CINV86DO();
        pCINV86DInputRec.setArchInputStruct(pInputMsg620.getArchInputStruct());
        pCINV86DInputRec.setUlIdStage(pInputMsg620.getUlIdStage());
        rc = cinv86dQUERYdam(sqlca, pCINV86DInputRec, pCINV86DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pulPriorStage.value = pCINV86DOutputRec.getUlIdPriorStage();
        }
        return rc;
    }

    static int CallCINT09D(CINV17SI pInputMsg621, CINV17SO pOutputMsg574, int ulPriorStage, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINT09DInputRec.setArchInputStruct(pInputMsg621.getArchInputStruct());
        pCINT09DInputRec.setUlIdStage(ulPriorStage);
        rc = cint09dQUERYdam(sqlca, pCINT09DInputRec, pCINT09DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg574.getROWCINV17SOG02().setUlIdFacilResource(pCINT09DOutputRec.getUlIdResource());
            pOutputMsg574.getROWCINV17SOG02().setSzAddrFacilInvstCity(pCINT09DOutputRec.getSzAddrIncmgFacilCity());
            pOutputMsg574.getROWCINV17SOG02().setSzAddrFacilInvstStr1(pCINT09DOutputRec.getSzAddrIncmgFacilStLn1());
            pOutputMsg574.getROWCINV17SOG02().setSzNmFacilInvstFacility(pCINT09DOutputRec.getNmIncmgFacilName());
            pOutputMsg574.getROWCINV17SOG02().setSzAddrFacilInvstStr2(pCINT09DOutputRec.getSzAddrIncmgFacilStLn2());
            pOutputMsg574.getROWCINV17SOG02().setSzAddrFacilInvstCnty(pCINT09DOutputRec.getSzCdIncmgFacilCnty());
            pOutputMsg574.getROWCINV17SOG02().setSzAddrFacilInvstState(pCINT09DOutputRec.getSzCdIncmgFacilState());
            pOutputMsg574.getROWCINV17SOG02().setSsAddrFacilInvstZip(pCINT09DOutputRec.getSzAddrIncmgFacilZip());
            pOutputMsg574.getROWCINV17SOG02().setLNbrFacilInvstPhone(pCINT09DOutputRec.getSzNbrIncmgFacilPhone());
            pOutputMsg574.getROWCINV17SOG02().setSzNbrFacilInvstExtension(pCINT09DOutputRec.getSzNbrIncmgFacilPhoneExt());
            pOutputMsg574.getROWCINV17SOG02().setSzNmFacilInvstAff(pCINT09DOutputRec.getSzNmIncmgFacilAffiliated());
        }
        return rc;
    }

    static int CallCINV89D(CINV17SI pInputMsg622, CINV17SO pOutputMsg575, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV89DI pCINV89DInputRec = null;
        CINV89DO pCINV89DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV89DInputRec = new CINV89DI();
        
        pCINV89DOutputRec = new CINV89DO();
        pCINV89DInputRec.setArchInputStruct(pInputMsg622.getArchInputStruct());
        pCINV89DInputRec.setUlIdStage(pInputMsg622.getUlIdStage());
        
        rc = cinv89dQUERYdam(sqlca, pCINV89DInputRec, pCINV89DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg575.getROWCINV17SOG02().setDtDtFacilInvstIncident(pCINV89DOutputRec.getDtDtFacilAllegIncident());
            pOutputMsg575.getROWCINV17SOG02().setTmSysTmFacilInvstInc(pCINV89DOutputRec.getTmSysTmFacilAlegInc());
        }
        return rc;
    }

    
    static int CallCINT40D(CINV17SI pInputMsg623, CINV17SO pOutputMsg576, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINT40DInputRec.setArchInputStruct(pInputMsg623.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg623.getUlIdStage());
        
        /* Declare FOUNDATION variables  */
        
        
        /*
        ** Declare local variables 
        */
        
        /*
        ** Start performance timer for service 
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg576.getROWCINV17SOG03().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageClassification(pCINT40DOutputRec.getSzCdStageClassification());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageCnty(pCINT40DOutputRec.getSzCdStageCnty());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageCurrPriority(pCINT40DOutputRec.getSzCdStageCurrPriority());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageInitialPriority(pCINT40DOutputRec.getSzCdStageInitialPriority());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
            
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageRegion(pCINT40DOutputRec.getSzCdStageRegion());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageRsnPriorityChgd(pCINT40DOutputRec.getSzCdStageRsnPriorityChgd());
            pOutputMsg576.getROWCINV17SOG03().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pOutputMsg576.getROWCINV17SOG03().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
            pOutputMsg576.getROWCINV17SOG03().setDtDtStageStart(pCINT40DOutputRec.getDtDtStageStart());
            pOutputMsg576.getROWCINV17SOG03().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
            pOutputMsg576.getROWCINV17SOG03().setUlIdSituation(pCINT40DOutputRec.getUlIdSituation());
            pOutputMsg576.getROWCINV17SOG03().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
            pOutputMsg576.getROWCINV17SOG03().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
            pOutputMsg576.getROWCINV17SOG03().setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
            pOutputMsg576.getROWCINV17SOG03().setSzTxtStagePriorityCmnts(pCINT40DOutputRec.getSzTxtStagePriorityCmnts());
            pOutputMsg576.getROWCINV17SOG03().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
            pOutputMsg576.getROWCINV17SOG03().setBIndStageClose(pCINT40DOutputRec.getBIndStageClose());
            pOutputMsg576.getROWCINV17SOG03().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
            pOutputMsg576.getROWCINV17SOG03().setTmSysTmStageStart(pCINT40DOutputRec.getTmSysTmStageStart());
            pOutputMsg576.getROWCINV17SOG03().setTmSysTmStageClose(pCINT40DOutputRec.getTmSysTmStageClose());
        }
        return rc;
    }

    static int CallCINVB6D(CINV17SI pInputMsg624, CINV17SO pOutputMsg577, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINVB6DI pCINVB6DInputRec = null;
        CINVB6DO pCINVB6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB6DInputRec = new CINVB6DI();
        pCINVB6DOutputRec = new CINVB6DO();
        pCINVB6DInputRec.setArchInputStruct(pInputMsg624.getArchInputStruct());
        pCINVB6DInputRec.setUlIdStage(pInputMsg624.getUlIdStage());
        pCINVB6DInputRec.setSzCdContactType(INITIAL_FACE_TO_FACE);
        
        pCINVB6DInputRec.setSzCdContactPurpose(CONTACT_PURPOSE);
        
        /*
        ** Call DAM
        */
        rc = cinvb6dQUERYdam(sqlca, pCINVB6DInputRec, pCINVB6DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun().year != NULL_DATE) {
                    if (0 != ARC_UTLCompareDateAndTime(pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun() , pOutputMsg577.getROWCINV17SOG02().getTmSysTmFacilInvstBeg() , pCINVB6DOutputRec.getDtDTContactOccurred() , pCINVB6DOutputRec.getTmScrTmGeneric1())) {
                        pOutputMsg577.setBWCDIndDataChange(true);
                    }
                    
                    
                    else {
                        
                        break;
                    }
                }
                
                
                else {
                    pOutputMsg577.setBWCDIndDataChange(true);
                }
                pOutputMsg577.getROWCINV17SOG02().setDtDtFacilInvstBegun(pCINVB6DOutputRec.getDtDTContactOccurred());
                pOutputMsg577.getROWCINV17SOG02().setTmSysTmFacilInvstBeg(pCINVB6DOutputRec.getTmScrTmGeneric1());
                
                break;
                
            case NO_DATA_FOUND:
                
                //  Check for allocation errors.
                if (pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun().year != NULL_DATE) {
                    pOutputMsg577.setBWCDIndDataChange(true);
                    pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun().day = NULL_DATE;
                    pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun().month = NULL_DATE;
                    pOutputMsg577.getROWCINV17SOG02().getDtDtFacilInvstBegun().year = NULL_DATE;
                    pOutputMsg577.getROWCINV17SOG02().setTmSysTmFacilInvstBeg(NULL_STRING);
                    
                }
                
                
                //  Call CRES25D
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS06D(CINV17SI pInputMsg625, CINV17SO pOutputMsg578, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szTablename, boolean bIndLeNotif) {
        int rc = 0;/* Return code                        */
        
        /*
        ** Declare local variables
        */
        /*
        ** SIR 13618 - Request for Review
        */
        int INDEX = 0;
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS06DInputRec = new CSYS06DI();
        pCSYS06DOutputRec = new CSYS06DO();
        pCSYS06DInputRec.setArchInputStruct(pInputMsg625.getArchInputStruct());
        pCSYS06DInputRec.setUlIdEvent(pInputMsg625.getUlIdStage());
        pCSYS06DInputRec.setSzSysTxtTablename(szTablename);
        
        if (0 == szTablename.compareTo(APS_FACILITY_NARRATIVE_VIEW)) {
            INDEX = FACILITIES_ABUSE_NEGLECT_INDEX;
        }
        
        else if (0 == szTablename.compareTo(APS_FACIL_REVIEW_NARR_VIEW)) {
            INDEX = REVIEW_FACILITIES_ABUSE_NEGLECT_INDEX;
        }
        
        else if (0 == szTablename.compareTo(FACIL_CONCL_NARR_VIEW)) {
            INDEX = FACILITIES_INVST_CONCL_INDEX;
        }
        
        else if (0 == szTablename.compareTo(FACIL_CONCL_REVIEW_NARR_VIEW)) {
            INDEX = REVIEW_FACILITIES_INVST_CONCL_INDEX;
        }
        else if (0 == szTablename.compareTo(FAC_REFERRAL_NARR) /* MHMR3 Item8.5 */
        ) {
            INDEX = FAC_REFERRAL_INDEX;// MHMR3 Item8.5
        }
        rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg578.getBIndBLOBExistsInDatabase()[INDEX] = true;
                pOutputMsg578.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(INDEX, pCSYS06DOutputRec.getTsLastUpdate());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Call CLSS16D
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg578.getBIndBLOBExistsInDatabase()[INDEX] = false;
                pOutputMsg578.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(INDEX, pCSYS06DOutputRec.getTsLastUpdate());
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if (!bIndLeNotif) {
            bIndLeNotif = true;
            pCSYS06DInputRec.setSzSysTxtTablename(APS_NOTIF_LE_NARR);
            
            
            //  Set rc to ARC_SUCCESS
            rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pOutputMsg578.getBIndBLOBExistsInDatabase()[APS_INVEST_NOTIF_LE_INDEX] = true;
                    pOutputMsg578.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(APS_INVEST_NOTIF_LE_INDEX, pCSYS06DOutputRec.getTsLastUpdate());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pOutputMsg578.getBIndBLOBExistsInDatabase()[APS_INVEST_NOTIF_LE_INDEX] = false;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
            
        }
        return rc;
    }

    
    static int CallCRES04D(CINV17SI pInputMsg626, CINV17SO pOutputMsg579, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        pCRES04DOutputRec = new CRES04DO();
        pCRES04DInputRec.setArchInputStruct(pInputMsg626.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(pOutputMsg579.getROWCINV17SOG02().getUlIdFacilResource());
        
        
        /*
        ** Call CCMN44D
        */
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        
        /* SIR 19613 */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    pOutputMsg579.getROWCINV17SOG02().setSzCdMhmrCompCode(pCRES04DOutputRec.getSzCdMhmrCompCode());
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINVB8D(CINV17SI pInputMsg627, CINV17SO pOutputMsg580, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINVB8DI pCINVB8DInputRec = null;
        CINVB8DO pCINVB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB8DInputRec = new CINVB8DI();
        
        pCINVB8DOutputRec = new CINVB8DO();
        pCINVB8DInputRec.setUlIdStage(pInputMsg627.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cinvb8dQUERYdam(sqlca, pCINVB8DInputRec, pCINVB8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCINVB8DOutputRec.getDtDTContactOccurred().year != NULL_DATE) {
                    pOutputMsg580.getROWCINV17SOG02().setUlNbrReviewContact(REVIEW_CONTACT);
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        
        return rc;
    }

    static int CallCLSC88D(CINV17SI pInputMsg628, CINV17SO pOutputMsg581, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CLSC88DI pCLSC88DInputRec = null;
        CLSC88DO pCLSC88DOutputRec = null;
        boolean bEverything = false;/* Indicates all requirements are meet */
        boolean bNoDateDtrm = false;/* The Date of Derterm. is required    */
        boolean bNoInjyryDtl = false;/* The Injury Detail record must exist */
        boolean bNoSeriousAlleg = false;/* Allegation and Injury detail record
        ** of type serious must exist          */
        int iLoopCtr = 0;/* Counter to loop thru 20 rows MAX */
        
        /*
        ** Declare Local Variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC88DInputRec = new CLSC88DI();
        
        pCLSC88DOutputRec = new CLSC88DO();
        pCLSC88DInputRec.setArchInputStruct(pInputMsg628.getArchInputStruct());
        pCLSC88DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        pCLSC88DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC88DO._CLSC88DO__ROWCLSC88DO_SIZE);
        pCLSC88DInputRec.setUlIdAllegationStage(pInputMsg628.getUlIdStage());
        
        /*
        ** Call CSES81D, Contract Version retrieve for an idContract
        */
        rc = clsc88dQUERYdam(sqlca, pCLSC88DInputRec, pCLSC88DOutputRec);
        switch (rc) {
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                for (iLoopCtr = 0;iLoopCtr < pCLSC88DOutputRec.getArchOutputStruct().getUlRowQty();iLoopCtr++) {
                    
                    //  Set Calculated Retention date to maximum date
                    if (!(pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getSzCdFacilAllegInjSer().compareTo(CD_SERIOUS_INJ) != 0) && NULL_DATE != pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().month && NULL_DATE != pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().day && NULL_DATE != pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().year) {
                        bEverything = true;
                        break;
                    }
                    //  If the Injury Allegation is of Type 'Serious' and the
                    // Date of Determination is NULL, set flag to indicate that
                    // a Date of Determination is required for this closure reason.
                    else if (!(pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getSzCdFacilAllegInjSer().compareTo(CD_SERIOUS_INJ) != 0) && pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getUlIdFacilityInjury() && NULL_DATE == pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().month && NULL_DATE == pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().day && NULL_DATE == pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getDtFacilInjuryDtrmntn().year) {
                        bNoDateDtrm = true;
                    }
                    //  If there is a Serious Allegation without an Injury Detail record
                    // set the flag to indicate that an Injury Detail Record is
                    // required for this closure reason
                    else if (!(pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getSzCdFacilAllegInjSer().compareTo(CD_SERIOUS_INJ) != 0) &&!pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getUlIdFacilityInjury()) {
                        bNoInjyryDtl = true;
                    }
                    //  If there is a Not a Serious Allegation
                    // set the flag to indicate that an allegation of type
                    // serious with a date of dertermination
                    // is required for this closure reason.
                    else if (pCLSC88DOutputRec.getROWCLSC88DO_ARRAY().getROWCLSC88DO(iLoopCtr).getSzCdFacilAllegInjSer().compareTo(CD_SERIOUS_INJ) != 0) {
                        bNoSeriousAlleg = true;
                    }
                    else {
                        //  Default to No Rows Found.
                        bNoSeriousAlleg = true;
                    }
                }
                break;
                
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                //  If NO DATA Found set flag to indicate that the
                // allegation of type serious with a date of dertermination
                // is required for this closure reason.
                bNoSeriousAlleg = true;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if (bEverything) {
            pOutputMsg581.getROWCINV17SOG01().setCWCDCdSerInjAlleg(FC_ALL_COND_MET);
        }
        else if (bNoDateDtrm) {
            pOutputMsg581.getROWCINV17SOG01().setCWCDCdSerInjAlleg(FC_NO_DATE);
        }
        else if (bNoInjyryDtl) {
            pOutputMsg581.getROWCINV17SOG01().setCWCDCdSerInjAlleg(FC_NO_INJ_LST_DETAIL);
        }
        else {
            pOutputMsg581.getROWCINV17SOG01().setCWCDCdSerInjAlleg(FC_NO_ALLEG_SER);
        }
        
        
        return rc;
    }

    static int CallCLSC84D(CINV17SI pInputMsg629, CINV17SO pOutputMsg582, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CLSC84DI pCLSC84DInputRec = null;
        CLSC84DO pCLSC84DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC84DInputRec = new CLSC84DI();
        
        pCLSC84DOutputRec = new CLSC84DO();
        pCLSC84DInputRec.setArchInputStruct(pInputMsg629.getArchInputStruct());
        pCLSC84DInputRec.setUlIdStage(pInputMsg629.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = clsc84dQUERYdam(sqlca, pCLSC84DInputRec, pCLSC84DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg582.setUlIdPriorStage(pCLSC84DOutputRec.getUlIdPriorStage());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS77D(CINV17SI pInputMsg630, CINV17SO pOutputMsg583, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CLSS77DI pCLSS77DInputRec = null;
        CLSS77DO pCLSS77DOutputRec = null;
        int i323 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS77DInputRec = new CLSS77DI();
        
        pCLSS77DOutputRec = new CLSS77DO();
        pCLSS77DInputRec.setArchInputStruct(pInputMsg630.getArchInputStruct());
        pCLSS77DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        pCLSS77DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS77DO._CLSS77DO__ROWCLSS77DO_SIZE);
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCLSS77DInputRec.setUlIdStage(pInputMsg630.getUlIdStage());
        
        rc = clss77dQUERYdam(sqlca, pCLSS77DInputRec, pCLSS77DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  The DAM has retrieved all victims for the stage. Each
                // person will be checked to see whether he/she has an MHMR
                // Client Number and whether or not he/she has been
                // merged/related.
                for (i323 = 0;i323 < pCLSS77DOutputRec.getArchOutputStruct().getUlRowQty();i323++) {
                    
                    // Set DAM Input Time Stamp if 
                    // the service input message IdEvent is not equal to NULL
                    if (pOutputMsg583.getROWCINV17SOG01().getCIndMhmrClientNum() != INDICATOR_YES) {
                        
                        //  Call DAM
                        rc = CallCLSS78D(pInputMsg630, pOutputMsg583, pCLSS77DOutputRec.getROWCLSS77DO_ARRAY().getROWCLSS77DO(i323).getUlIdPerson() , pServiceStatus);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                                //   If the CCMN01 ReqFuncCd is ADD, meaning that no IdEvent 
                                // exists for the record being saved, populate the CCMN01 Input
                                // Msg with the Primary Child's IdPerson for the Event-Person Link
                                if (RELATED == pCLSS77DOutputRec.getROWCLSS77DO_ARRAY().getROWCLSS77DO(i323).getSzCdStagePersSearchInd()) {
                                    pOutputMsg583.getROWCINV17SOG01().setCIndVerMhmrClientNum(INDICATOR_YES);
                                }
                                else if (pOutputMsg583.getROWCINV17SOG01().getCIndVerMhmrClientNum() != INDICATOR_YES) {
                                    //  Do nothing, the output message just returns success or failure
                                    rc = CallCMSC49D(pInputMsg630, pOutputMsg583, pCLSS77DOutputRec.getROWCLSS77DO_ARRAY().getROWCLSS77DO(i323).getUlIdPerson() , pServiceStatus);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                        case NO_DATA_FOUND:
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                }
                                
                                break;
                            case NO_DATA_FOUND:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                    }
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

    static int CallCLSS78D(CINV17SI pInputMsg631, CINV17SO pOutputMsg584, Pint ulIdPerson8, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CLSS78DI pCLSS78DInputRec = null;
        CLSS78DO pCLSS78DOutputRec = null;
        int i324 = 0;
        
        /*
        ** SIR 13532 - Declare unknown name flag
        */
        Pint bUnknownName = new Pint();
        bUnknownName.value = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS78DInputRec = new CLSS78DI();
        
        pCLSS78DOutputRec = new CLSS78DO();
        pCLSS78DInputRec.setArchInputStruct(pInputMsg631.getArchInputStruct());
        pCLSS78DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        
        pCLSS78DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS78DO._CLSS78DO__ROWCLSS78DO_SIZE);
        pCLSS78DInputRec.setUlIdPerson(ulIdPerson8.value);
        pCLSS78DInputRec.setSzCdPersonIdType(MHMR_CLIENT_NUM_ID_TYPE);
        /*
        ** DT STAGE START will be the current date.
        */
        /* Populate Input Structure for DAM */
        rc = clss78dQUERYdam(sqlca, pCLSS78DInputRec, pCLSS78DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;// break for success of CCMN44
            case NO_DATA_FOUND:
                // Populate Input Structure for DAM
                rc = CallCSES99D(pInputMsg631, pOutputMsg584, pCLSS78DInputRec.getUlIdPerson() , bUnknownName, pServiceStatus);
                if (WtcHelperConstants.ARC_SUCCESS == rc) {
                    if (!bUnknownName.value) {
                        pOutputMsg584.getROWCINV17SOG01().setCIndMhmrClientNum(INDICATOR_YES);
                    }
                    
                    rc == NO_DATA_FOUND;
                }
                else {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        return rc;
    }

    
    
    
    static int CallCMSC49D(CINV17SI pInputMsg632, CINV17SO pOutputMsg585, Pint ulIdPerson9, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CMSC49DI pCMSC49DInputRec = null;
        CMSC49DO pCMSC49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCMSC49DInputRec = new CMSC49DI();
        
        pCMSC49DOutputRec = new CMSC49DO();
        pCMSC49DInputRec.setArchInputStruct(pInputMsg632.getArchInputStruct());
        pCMSC49DInputRec.setUlIdPerson(ulIdPerson9.value);
        
        /*
        ** Call DAM
        */
        rc = cmsc49dQUERYdam(sqlca, pCMSC49DInputRec, pCMSC49DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCMSC49DOutputRec.getUlSysNbrGenericCntr() > 0) {
                    pOutputMsg585.getROWCINV17SOG01().setCIndVerMhmrClientNum(INDICATOR_YES);
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES99D(CINV17SI pInputMsg633, CINV17SO * pOutputMsg586, Pint ulIdPerson10, Pint bUnknownName, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSES99DI pCSES99DInputRec = null;
        CSES99DO pCSES99DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structers
        */
        pCSES99DInputRec = new CSES99DI();
        
        pCSES99DOutputRec = new CSES99DO();
        pCSES99DInputRec.setArchInputStruct(pInputMsg633.getArchInputStruct());
        
        pCSES99DInputRec.setUlIdPerson(ulIdPerson10.value);
        rc = cses99dQUERYdam(sqlca, pCSES99DInputRec, pCSES99DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (null == pCSES99DOutputRec.getSzNmPersonFirst()[0] && null == pCSES99DOutputRec.getSzNmPersonLast()[0]) //  the user is not the approver, check for access to the Unit
                {
                    bUnknownName.value = 1;
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
