
<%
      //*  JSP Name:     CPS Investigation Conclusion
      //*  Created by:   Narasimha Rao
      //*  Date Created: 11/15/02
      //*
      //*  Description:
      //*   This page allows the user to display and modify
      //*   for the CPS Investigation and EA Eligibility page.
      //*   The user must enter Date Investigation Completed, have a prefilled Overall Disposition,
      //*   a prefilled Risk Finding or the  selected Risk Assessment N/A checkbox, and a selected Recommended Action.
      //*
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  06/24/03  GRIMSHAN          SIR 18416 Set editable mode to all for approval
      //**                              status button
      //**  07/25/03  DOUGLACS          SIR 19053 - shouldn't be able to save & submit
      //**                              if there is no overall disposition unless case
      //**                              related special request.  Also, fixed if CRSR,
      //**                              recommended action should be enabled w/o disposition
      //**  08/18/03  CASDORJM          SIR 19506 - we were doing a .equals on a null string.
      //**                              modified the order of the comparison to reference the
      //**                              static constant first.
      //**  09/11/03  DEMOMA            SIR 19688 - Modified if statements for attaching
      //**                              codes table to Recommended Action drop down field
      //**                              Also add cpsRisk6 so that 97 Closed to Merge could
      //**                              excluded from the drop down box
      //**  01/13/04  CORLEYAN          SIR 22374 - If the case has been merged, then the reason
      //**                              to believe drop down will have no correct codes table
      //**                              associated with it.  If this is the case we want to make
      //**                              sure that the code in the db will not display so
      //**                              set overrideDisplayBadCodes = "true" in the dropdown.
      //**  04/15/04  dickmaec          SIR 22729 and SIR 22726 Added the MSG_RISK_FINDING_SUB if the user
      //**                              clicks the save and submit push button, there is event removing the
      //**                              child from the home, and if risk finding is equal to risk indicated and
      //**                              recommend action is not a -close field.  The recommend action
      //**                              checkbox will be hidden when the incidator is N and in browse
      //**                              mode displayed if the incidator is Y.
      //**  06/18/04  dejuanr           SIR 22936 - Added three fields.  The joint investigation question.
      //**                              A Why not question and comments.
      //**  06/21/04  corleyan          SIR 15956 Added code to display a popup message on save and submit if
      //**                              there are persons in the case that are PRNs with uknown gender and/or
      //**                              approximate DOB.
      //**  10/07/04  dejuanr           SIR 23105 - Added UTC codes table for recomend action.
      //**  01/13/04  dejuanr           SIR 22986 - Add victim taped fields
      //**  04/28/05  RANAS             SIR 23536 - Check PHAB/SXAB allegation indicator to display audio video questions
      //**  06/28/05  Hadjimh           SIR# 22665 Merged cases have blanked out dispositions on the
      //**                              allegation list/detail page but the investigation conclusion page
      //**                              has an overall disposition. Recommended Solution: 1)  If two
      //**                              cases are being merged and one of the cases has been saved and
      //**                              submitted for stage closure stop the merge. this pertains to all
      //**                              case merges.   If the event type is Conclusion and the status is
      //**                              PEND then the user should get a message telling them the merge
      //**                              will not occure because of a pending closure.  The message should
      //**                              say "The merge to (or from) case has been saved and submitted for
      //**                              closure. Please wait for approval of pending event or invalidate
      //**                              the approval and resubmit for case merge."
      //**                              2)  If two cases are pending a merge and one of the cases is saved
      //**                              and submitted, stop the save and submit by displaying an edit on
      //**                              the conclusion page.  The message should indicate that the user
      //**                              should cancel the merge or wait for the merge to process before
      //**                              saving and submitting. This pertains to CPS INV Conclusion Save
      //**                              and Submit only.
      //**  07/19/05  douglacs          SIR 23693 - Audio/Videotape questions now need to display for all
      //**                              INV cases except for admin close disposition. (SB6 section 1.21)
      //**                              Changed label for victim taped question from physical or
      //**                              sexual abuse victim to alleged victim
      //**  08/16/05  douglacs          SIR 23900 - Change text of audio/videotape section.
      //**
      //**  08/14/08  alwilliams        STGAP00009833 - Removed substantiated family violence checks that
      //**                              were setting Maltreatment Findings to substantiated or unsubstantied.
      //**                              Now Maltreatment Findings is only set based on Allegation disposition.
      //**  
      //**  09/12/08  htvo				STGAP00009662 - No default value for Maltreament; it is now reflecting 
      //**								the Overall Disposition database field only which still gets set by Allegation
      //**								disposition. This change adds to #9833; not reverting it.
      //**  11/12/08  arege             STGAP00010758 Modified code so that the SaveAndSubmit button is not displayed for the 
      //**                              Supervisor in approval mode.
      //**  12/23/08  arege             STGAP00010056 SaveAndSubmit button should not display in ARI stage.
      //**  04/13/09  bhgehlot          STGAP00012542 Disable Supervisor Level of Risk when the Superviosr Overall Risk 
      //**                              finding is not 01 or 05.
      //**  05/24/10  bgehlot           SMS#51977 MR-066 Changes
      //**  06/14/10  bgehlot           SMS#51977 New Requirements: Special Investigation Question is modifiable, should be blank if not defaulted,
      //**                              Never should default to No.
      //**  06/17/10  bgehlot           SMS 57784 Where did the maltreatment occur? List is now in alphabetical order.
      //**  06/22/10  bgehlot           SMS 59017 Changed the label to 'Special Investigation Placement/Non-Placement Provider/Facility'
      //**  06/23/10  bgehlot           SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
      //**  06/30/2010 bgehlot          SMS 60409 MR-066 Remove CPA from Provider Type list and change the PRovider Search label with new text
      //**  06/30/2010 bgehlot          SMS 60427 do not show Required fiels messages when Search button is clicked. 
      //**  06/22/2011 charden			Capta 4.3 - adding fields and modifying page display mode
      //**  01/26/12  habraham      	STGAP00017829 - MR-097 - Modified the code to add a hidden variable for UnsubstantiatedMICindicator
	  //**  03/09/12  vcollooru			STGAP00017941: Added a new comment field for foster parent notification.
	  //**  04/13/12  rminor			STGAP00017854: Changed 'Date Completed' label(for CPSInvDetail Date Completed) to 'Date Submitted' per request.
      //**                          
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.CPSInvCnclsnConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashSet"%> 
<%@ page import="java.util.Set"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>

<%
      BaseSessionStateManager state = CPSInvCnclsnConversation.getSessionStateManager(request);
      String unknownIfMmberHshldErrorMessage = (String) request.getAttribute("unknownIfMmberHshldErrorMessage");
      if (!StringHelper.isValid(unknownIfMmberHshldErrorMessage)) {
        unknownIfMmberHshldErrorMessage = "";
      }
      List<String> levelOfRisk = new ArrayList<String>(Lookup.getCategoryCodesCollection(CodesTables.CLVLRSK));
      List<Option> levelOfRiskDisplay = new ArrayList<Option>();
      //Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      // STGAP00003745  This is for an the Levels of Risk Drop down
      // The following code will sort this dropdown by the level of risk 
      // If new levels are added this code will need to be modified
      int i = 0;
   while(levelOfRisk.size() > 0){
   int j = 0;
    if(i == 0){
      for(j = 0; j < levelOfRisk.size(); j++){
        String level = levelOfRisk.get(j);
        if(CodesTables.CLVLRSK_EX.equals(level)){
          levelOfRiskDisplay.add(new Option(level, Lookup.simpleDecode(CodesTables.CLVLRSK, level)));
          break;
        }
      }
    } else if (i == 1){
     for(j = 0; j < levelOfRisk.size(); j++){
     String level = levelOfRisk.get(j);
      if(CodesTables.CLVLRSK_CN.equals(level)){
        levelOfRiskDisplay.add(new Option(level, Lookup.simpleDecode(CodesTables.CLVLRSK, level)));
        break;
      }
     }
    } else if (i == 2){
    for(j = 0; j < levelOfRisk.size(); j++){
    String level = levelOfRisk.get(j);
      if(CodesTables.CLVLRSK_SW.equals(level)){
        levelOfRiskDisplay.add(new Option(level, Lookup.simpleDecode(CodesTables.CLVLRSK, level)));
        break;
      }
     } 
    }else if (i == 3){
    for(j = 0; j < levelOfRisk.size(); j++){
    String level = levelOfRisk.get(j);
      if(CodesTables.CLVLRSK_VL.equals(level)){
        levelOfRiskDisplay.add(new Option(level, Lookup.simpleDecode(CodesTables.CLVLRSK, level)));
        break;
      }
     } 
    }else if (i == 4){
    for(j = 0; j < levelOfRisk.size(); j++){
    String level = levelOfRisk.get(j);
      if(CodesTables.CLVLRSK_NO.equals(level)){
        levelOfRiskDisplay.add(new Option(level, Lookup.simpleDecode(CodesTables.CLVLRSK, level)));
        break;
      }
    }
   }
   levelOfRisk.remove(j);
    i++;
   
    }
       
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
   
      }
      
      

      /*  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH  */
      CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
      //CINV11SO cinv11so = (CINV11SO) state.getAttribute("CINV11SO", request);

      ROWCINV10DOG00 cpsinvcncln = null;
      ROWCINV14SOG00 cpsinvcnclnso = null;
      ROWCINV14DOG00 cpsinvcnclndo = null;
      ROWCCMN45DO cpsinvcncln45do = null;
      //MR-066
      ROWCINV10DOG01 cpsinvcncln10dog01 = null;
      
      //Initialize the display variables for the page
      String IntReceived = "";
      String IntAssigned = "";
      String InvInitiated = "";
      String txtCdCpsOverallDisptn = "";
      String txtUlIdEvent = "";
      String txtUlIdStage = "";
      String txtUlIdCase = "";
      String dtStageInvStart = "";
      String txtSzCdRiskAssmtRiskFind = "";
      String txtSzCdStageLvlOfRisk = "";
      String txtSzCdStageRiskFinding = "";
      String txtDtOverride = "";
      String txtSzCdOverrideLvlOfRisk = "";
      String txtSzCdOverrideRiskFinding = "";
      String txtOverrideComment = "";
      String txtMaltreatmentDesc = "";
      String eventStatus = "";
      int tabIndex = 1;
      int ulRowQty = 0;
      String bIndChkd = "";
      String bIndPrnUk = "";
      String indUnSubMIC = "";
      //added new code for R2
      String cdFamviol01 = "";
      String cdFamviol02 = "";
      String cdFamviol03 = "";
      String cdFamviol04 = "";
      String cdFamviol05 = "";
      String cdAbuseStatus = "";
      String cdAbuseStatus_01 = CodesTables.CASBABST_01;
      String cdAbuseStatus_02 = CodesTables.CASBABST_02;
      String cdAbuseStatus_03 = CodesTables.CASBABST_03;
      String cdAbuseStatus_04 = CodesTables.CASBABST_04;
      String cdAbuseStatus01 = ArchitectureConstants.FALSE;
      String cdAbuseStatus02 = ArchitectureConstants.FALSE;
      String cdAbuseStatus03 = ArchitectureConstants.FALSE;
      String cdAbuseStatus04 = ArchitectureConstants.FALSE;
      String cdAbuseType01 = "";
      String cdAbuseType02 = "";
      String cdAbuseType03 = "";
      String cdAbuseType04 = "";
      String cdAbuseType05 = "";
      String cdAbuseType06 = "";
      String cdAbuseType07 = "";
      String cdMaltreatLoc = "";
      String disposion_sub = CodesTables.CDISPSTN_SUB;
      String disposion_Unsub = CodesTables.CDISPSTN_UNS;
      String yIsCheckedSpeInv = "false";
      String nIsCheckedSpeInv = "false";
      String yIsCheckedFostPrnt = "false";
      String nIsCheckedFostPrnt = "false";
      //MR-066 Maltreatment in care
      String naIsCheckedFostPrnt = "false";
      String yIsCheckedStOffNotified = "false";
      String nIsCheckedStOffNotified = "false"; 
      //MR-066
      String naIsCheckedStOffNotified = "false";
      String dtDtCpsInvstDtlComplt = "";   
      String dtDetermLetterSent = "";  
      String dtFostPrntNotified = "";
      String dtStOffNotified = "";
      String dtStOffAdvised = "";
      //SMS 51977 MR066 Maltreatment in care
      String yIsCheckedMaltreatment = "false";
      String nIsCheckedMaltreatment = "false";
      String yIsCheckedPolicyViolation = "false";
      String nIsCheckedPolicyViolation = "false";
      String spiModify = (String) request.getAttribute("spiModify");
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rsrcSearchRow = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01) request.getAttribute("rsrcSearchRow");

	  // STGAP00017941: Added a new comment field for foster parent notification
	  String txtFostPrntNotifyCmnts = "";
        
      boolean docExists = false;
      boolean protectNarrative = false;
      
      if(rsrcSearchRow == null){
      	rsrcSearchRow = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01();
      }
      
      if (pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.APPROVE)) {
        protectNarrative = true;
      }
      
    

      // SIR# 22665
      //Initialize the variables for the page if it's in modify mode
      if (cinv14so != null) {
        docExists = (ArchitectureConstants.TRUE).equals(cinv14so.getBIndBLOBExistsInDatabase());
        ulRowQty = cinv14so.getArchOutputStruct().getUlRowQty();
        cpsinvcncln = cinv14so.getROWCINV10DOG00();
        cpsinvcnclnso = cinv14so.getROWCINV14SOG00();
        cpsinvcnclndo = cinv14so.getROWCINV14DOG00();
        cpsinvcncln45do = cinv14so.getROWCCMN45DO();
        cpsinvcncln10dog01 = cinv14so.getROWCINV10DOG01();
        if ((cpsinvcncln != null) && (cpsinvcnclnso != null) && (cpsinvcnclndo != null) && (cpsinvcncln45do != null)) {
          IntReceived = FormattingHelper.formatDate(cpsinvcncln.getDtDtCPSInvstDtlIntake());
          IntAssigned = FormattingHelper.formatDate(cpsinvcncln.getDtDtCPSInvstDtlAssigned());
          InvInitiated = FormattingHelper.formatDate(cpsinvcncln.getDtDtCPSInvstDtlBegun());
          txtCdCpsOverallDisptn = cpsinvcncln.getCdCpsOverallDisptn();
          txtUlIdStage = Integer.toString(cpsinvcncln.getUlIdStage());
          txtUlIdEvent = Integer.toString(cpsinvcncln.getUlIdEvent());
          txtUlIdCase = Integer.toString(cpsinvcnclnso.getUlIdCase());
          dtStageInvStart = FormattingHelper.formatDate(cpsinvcnclnso.getDtDtStageStart());
          
          txtSzCdRiskAssmtRiskFind = cpsinvcnclndo.getSzCdRiskAssmtRiskFind();
          txtSzCdStageLvlOfRisk = cpsinvcncln.getSzCdStageLvlOfRisk();
          txtSzCdStageRiskFinding = cpsinvcncln.getSzCdStageRiskFinding();
          txtDtOverride = FormattingHelper.formatDate(cpsinvcncln.getDtDtOverride());
          txtSzCdOverrideLvlOfRisk = cpsinvcncln.getSzCdOverrideRiskLvl();
          txtSzCdOverrideRiskFinding = cpsinvcncln.getSzCdOverrideOverllFind();
          txtOverrideComment = cpsinvcncln.getSzTxtOverrideComments();
          //start new code added for R2
          cdFamviol01 = cpsinvcncln.getCdFamviol01();
          cdFamviol02 = cpsinvcncln.getCdFamviol02();
          cdFamviol03 = cpsinvcncln.getCdFamviol03();
          cdFamviol04 = cpsinvcncln.getCdFamviol04();
          cdFamviol05 = cpsinvcncln.getCdFamviol05();

          cdAbuseStatus = cpsinvcncln.getCdAbuseStatus();

          
          if (cdAbuseStatus_01.equals(cdAbuseStatus)) {
            cdAbuseStatus01 = ArchitectureConstants.TRUE;
          } else if (cdAbuseStatus_02.equals(cdAbuseStatus)) {
            cdAbuseStatus02 = ArchitectureConstants.TRUE;
          } else if (cdAbuseStatus_03.equals(cdAbuseStatus)) {
            cdAbuseStatus03 = ArchitectureConstants.TRUE;
          } else if (cdAbuseStatus_04.equals(cdAbuseStatus)) {
            cdAbuseStatus04 = ArchitectureConstants.TRUE;

          }
          
          // STGAP00009833 - Removed substantiated Family Violence checks that were setting the Maltreatment 
          // Findings to Substantiated or Unsubstantiated.
          //if((ArchitectureConstants.Y).equalsIgnoreCase(cinv14so.getBIndSubstantiatedAlleg())){
          //  txtMaltreatmentDesc = Lookup.simpleDecodeSafe("CDISPSTN", disposion_sub);
          //} else if ((ArchitectureConstants.N).equalsIgnoreCase(cinv14so.getBIndSubstantiatedAlleg())){
          //  txtMaltreatmentDesc = Lookup.simpleDecodeSafe("CDISPSTN", disposion_Unsub);
          //} else {
          //  txtMaltreatmentDesc = "";
          //}
          // STGAP00009662 - No default value for Maltreament; it is now reflecting the Overall Disposition database field only
          txtMaltreatmentDesc = Lookup.simpleDecodeSafe("CDISPSTN", txtCdCpsOverallDisptn);
          
          cdAbuseType01 = cpsinvcncln.getCdAbuseType01();
          cdAbuseType02 = cpsinvcncln.getCdAbuseType02();
          cdAbuseType03 = cpsinvcncln.getCdAbuseType03();
          cdAbuseType04 = cpsinvcncln.getCdAbuseType04();
          cdAbuseType05 = cpsinvcncln.getCdAbuseType05();
          cdAbuseType06 = cpsinvcncln.getCdAbuseType06();
          cdAbuseType07 = cpsinvcncln.getCdAbuseType07();
          cdMaltreatLoc = cpsinvcncln.getCdMaltreatLoc();
          //end new code finish

          // SIR 15956
          bIndPrnUk = cinv14so.getBIndPrnUk();
          //MR-097
          ROWCINV10DOG00 rowcinv10dogoo = cinv14so.getROWCINV10DOG00();
          indUnSubMIC =  rowcinv10dogoo.getCIndUnsubMIC();
          
          dtDtCpsInvstDtlComplt=FormattingHelper.formatDate(cpsinvcncln.getDtDtCpsInvstDtlComplt());
          dtFostPrntNotified=FormattingHelper.formatDate(cpsinvcncln.getDtDtFostPrntNotified());
          dtStOffNotified=FormattingHelper.formatDate(cpsinvcncln.getDtDtStOffNotifyRmvChild());
          dtStOffAdvised=FormattingHelper.formatDate(cpsinvcncln.getDtDtStOffAdviceRmvChild());
          dtDetermLetterSent = FormattingHelper.formatDate(cpsinvcncln.getDtDtDetermLetterSent());
         if(ArchitectureConstants.Y.equals(cpsinvcncln.getCIndSpeInvstPlaceProv()))
         {
           yIsCheckedSpeInv = "true";
             
         }else if(ArchitectureConstants.N.equals(cpsinvcncln.getCIndSpeInvstPlaceProv())){
          nIsCheckedSpeInv = "true";
         }         
         else
         {
           yIsCheckedSpeInv = "false";
           nIsCheckedSpeInv = "false";
         }
         
         //SMS 51977 Maltreatment in care 
         if(ArchitectureConstants.Y.equals(cpsinvcncln.getCIndInvMaltreatInCare())) {
          yIsCheckedMaltreatment = "true";          
         }else {
           nIsCheckedMaltreatment = "true";
         }
          
         if(ArchitectureConstants.Y.equals(cpsinvcncln.getCIndPolicyViolation()))
         {
          yIsCheckedPolicyViolation = "true";
             
         }else if(ArchitectureConstants.N.equals(cpsinvcncln.getCIndPolicyViolation()))
         {
           nIsCheckedPolicyViolation = "true";
         } 
         
         if(ArchitectureConstants.Y.equals(cpsinvcncln.getCIndFostPrntNotified()))
         {
          yIsCheckedFostPrnt = "true";
             
         }else if(ArchitectureConstants.N.equals(cpsinvcncln.getCIndFostPrntNotified()))
         {
           nIsCheckedFostPrnt = "true";
         }else if("A".equals(cpsinvcncln.getCIndFostPrntNotified())) //MR-066
         {
           naIsCheckedFostPrnt = "true";
         }
         
		// STGAP00017941: Set the text of the new comments field
		txtFostPrntNotifyCmnts = cpsinvcncln.getSzTxtFostPrntNotifyCmnts();
         
         if(ArchitectureConstants.Y.equals(cpsinvcncln.getCIndStOffNotifyRmvChild()))
         {
          yIsCheckedStOffNotified = "true";
             
         }else if(ArchitectureConstants.N.equals(cpsinvcncln.getCIndStOffNotifyRmvChild()))
         {
           nIsCheckedStOffNotified = "true";
         }else if("A".equals(cpsinvcncln.getCIndStOffNotifyRmvChild()))
         {
           naIsCheckedStOffNotified = "true";
          
         }
                
        }
        //MR-066
        if (cpsinvcncln10dog01 == null) {
          cpsinvcncln10dog01 = new ROWCINV10DOG01();
        }
      }

      String dsplyAudioVideo = ArchitectureConstants.FALSE;
     
      //SIR 23693
      if (!StringHelper.checkForEquality(cpsinvcncln.getCdCpsOverallDisptn(), CPSInvCnclsnConversation.ADMIN_CLOSURE)) {
        dsplyAudioVideo = ArchitectureConstants.TRUE;
      }

      /*
       eligibilityArray = cinv11so.getROWCINV11SOG00_ARRAY();
       eligibilityrow = cinv11so.getROWCINV11SOG01();
       if (eligibilityrow != null) {
       selSzCdCpsInvstDtlFamIncm = FormattingHelper.formatString(eligibilityrow.getSzCdCpsInvstDtlFamIncm());
       }
       */

      //Checking for Risk Assessment N/A Check Box
      String sDisableCnclsnDropDwn = ArchitectureConstants.TRUE;
      String sDisableOverrideDropDwn = ArchitectureConstants.TRUE;
      String disableCnclsnSection = (String) state.getAttribute(CPSInvCnclsnConversation.CONCLUSION_SECTION, request);
      String disableOverrideSection = (String) state.getAttribute(CPSInvCnclsnConversation.OVERRIDE_SECTION, request);

      if (!GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ARI)&&( pageMode.equals(PageModeConstants.EDIT) || pageMode.equals(PageModeConstants.MODIFY))) {
        sDisableCnclsnDropDwn = ArchitectureConstants.FALSE;
      } else if (pageMode.equals(PageModeConstants.VIEW)) {
        sDisableCnclsnDropDwn = ArchitectureConstants.TRUE;
      }

      if (disableCnclsnSection.equals(ArchitectureConstants.N))
    
      {
        sDisableCnclsnDropDwn = ArchitectureConstants.FALSE;
      }

      if (disableOverrideSection.equals(ArchitectureConstants.N)) {
        sDisableOverrideDropDwn = ArchitectureConstants.FALSE;
      }
     

      List<String> exOptionsCCRSKFND = new ArrayList<String>();
      exOptionsCCRSKFND.add(ArchitectureConstants.NO);

      eventStatus = CaseUtility.getEvent(GlobalData.getUlIdStage(request), GlobalData.getSzCdTask(request))
                               .getCdEventStatus();

      //====================================================================================
      //-- LOGIC FOR DISPLAYING BUTTONS
      boolean approvalStatus = true;
      boolean save = false;
      boolean saveAndSubmit = false;
      //String protectedApprovalStatus = "false";

      //commented out the original code for testing..uncomment it later if needed
      if (pageMode.equals(PageModeConstants.NEW) || (!"PEND".equals(eventStatus) && !"APRV".equals(eventStatus))) {
        approvalStatus = false;
      }

      if (ArchitectureConstants.FALSE.equals(sDisableCnclsnDropDwn)
          || ArchitectureConstants.FALSE.equals(sDisableOverrideDropDwn)) {
        save = true;
      }

      //hide the button for supervisor in approval mode
      if (GlobalData.isApprovalMode(request)){
       saveAndSubmit = false;
      }
      
     //STGAP00010056: SaveAndSubmit button should not display in ARI stage
     //if (ArchitectureConstants.FALSE.equals(sDisableCnclsnDropDwn) ||GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ARI)) {
       if (ArchitectureConstants.FALSE.equals(sDisableCnclsnDropDwn)) {
        saveAndSubmit = true;
      } else {
        saveAndSubmit = false;

      }
             
     //STGAP00010056: hide the button in  ARI stage
       if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ARI)) {
        saveAndSubmit = false;
       }
      
      //hide the button for supervisor or Admin reviewer
      if (ArchitectureConstants.FALSE.equals(sDisableOverrideDropDwn) && !GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ARI)) {
        saveAndSubmit = false;
      }
      
      // do not display save and submit button when page is open and modifiable only for special investigation
      if(ArchitectureConstants.Y.equals(spiModify)){
      	saveAndSubmit = false;
      	sDisableOverrideDropDwn = ArchitectureConstants.TRUE;
      }

      /*
       if ((txtCdCpsOverallDisptn == null || txtCdCpsOverallDisptn.length() == 0)
       && !GlobalData.getSzCdStageType(request).startsWith("C-")) {
       sDisableRASelect = ArchitectureConstants.TRUE;
       }
       */

      /*
       //Checking for Abbreviated Investigation
       String sDisableAbbrvCheckbox = ArchitectureConstants.TRUE;
       if ((StringHelper.checkForEquality(cpsinvcncln.getCdCpsOverallDisptn(), CPSInvCnclsnConversation.RULED_OUT))
       && (!StringHelper.checkForEquality(cpsinvcnclndo.getSzCdRiskAssmtRiskFind(),
       CPSInvCnclsnConversation.RISK_INDICATED))) {
       sDisableAbbrvCheckbox = ArchitectureConstants.FALSE;
       }
       if ((StringHelper.checkForEquality(cpsinvcncln.getCdCpsOverallDisptn(),
       CPSInvCnclsnConversation.UNABLE_TO_DETERMINE))
       && (!StringHelper.checkForEquality(cpsinvcnclndo.getSzCdRiskAssmtRiskFind(),
       CPSInvCnclsnConversation.RISK_INDICATED))
       && (!StringHelper.checkForEquality(cpsinvcnclndo.getSzCdRiskAssmtRiskFind(),
       CPSInvCnclsnConversation.FACTOR_CONTROLLED))) {
       sDisableAbbrvCheckbox = ArchitectureConstants.FALSE;
       }
       */

      /*
       List<String> exOptions = new ArrayList<String>();
       if (PageModeConstants.EDIT.equals(pageMode)) {
       exOptions.add("97");
       }
       */

      /*
       // this code is to generate reports
       UserProfile userProfile = UserProfileHelper.getUserProfile(request);
       int personID = 0;

       if (userProfile != null) {
       personID = userProfile.getUserID();
       }
       */
       
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// this function will enable/disable the conclusion risk level drop down based on the Overall Risk Finding drop 
// down selection. Enable risk level only if Risk finding selection is either "Risk Indicated/Open for Placement" or
// "Risk Indicated/Open for Services"
//-- Called onChange of Overall Risk Finding and each time the page loads
function enableCnclsnRiskLvl() {
  if ( document.frmCPSInvCnclsn.selSzCdStageRiskFinding.value != null) {
    var riskFindingCode = document.frmCPSInvCnclsn.selSzCdStageRiskFinding.value;
    if ( <%= ArchitectureConstants.FALSE.equals(sDisableCnclsnDropDwn) %>) {
      if (riskFindingCode ==  '05' ||  riskFindingCode == '01' ) {
        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.disabled = false;
      } else {
        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.disabled = true;
        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.value = "";
      }
    }
  }                  
}

function enableOverrideRiskLvl() {
  var supervisorOverallFinding = document.frmCPSInvCnclsn.selSzCdOverrideOverllFind;
  var supervisorOverallFindingValue = supervisorOverallFinding.value;

  if ( supervisorOverallFindingValue != null) {
    if ( <%= ArchitectureConstants.FALSE.equals(sDisableOverrideDropDwn) %>) {
      var levelOfRisk = document.frmCPSInvCnclsn.selSzCdOverrideRiskLvl;
    
      if (supervisorOverallFindingValue ==  '05' ||  supervisorOverallFindingValue == '01' ) {
        levelOfRisk.disabled = false;
      } else {
        levelOfRisk.disabled = true; //STGAP00012542 Disable Supervisor Level of Risk when the Superviosr Overall Risk 
                                     //   finding is not 01 or 05
        levelOfRisk.value = "";
      }
    }
  }
}

//-- Called by Save and Submit button (function attribute)
function submitChecks()
{
  var result;
  //newIntake();
  // SIR 15956 If there are PRNs with unknown gender or
  // appx dob, display a message to the user, if they
  // choose to continue, display unknown role message.
  result = checkUknownGenDOB();
  if ( result == true)
  {
   result = checkUnknownRole();
  }
  if ( result == true)
  {
   result = checkUnknownIfMmbrPKHshld();
  }

  return result;
}

// SIR 15956 added this function to check and see if there are PRNs with
// Unknown gender and/or approx DOB.  If there are (indicator returned from
// the service) check to see if the user wants to continue.  If they
// click cancel the page will not continue, if they click OK it will.
//-- Called by submitChecks()
function checkUknownGenDOB()
{
  //the value of hdnBIndPrnUk tells us if there are any
  // PRNs with unknown gender or appx dob.  If there aren't, return true
  if ( document.frmCPSInvCnclsn.hdnBIndPrnUk.value == 'Y' )
  {
    //If there are PRNs with unknown gender or appx dob, ask the user if they want to continue
    bRetValue = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_PRN_UNK_DOB_GEN)%>')
    return bRetValue;
  }
  // No PRNs with unknown roles, return true.
  return true;
}

//-- Also called by submitChecks()
function checkUnknownRole()
{
  //the value of ulRowQty tells us if there are any
  // PRNs with unknown roles.  If there aren't, return true
  if ( document.frmCPSInvCnclsn.ulRowQty.value != 0 )
  {
    //If there are PRNs with unknown roles, ask the user if they want to continue, and warn them
    // that continuing will change the roles to 'NO'
    bRetValue = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_INV_ONE_OR_MORE_UK_EXIT)%>')
    // If the user says it is ok to continue and change the role, set an indicator in a field so that
    // the service will know to change the roles.
    if( bRetValue )
    {
      document.frmCPSInvCnclsn.bIndChkd.value = 'Y';
      return true;
    }
    // Otherwise set the field to 'N' so that if they save and don't save an submit at this
    // point, the roles will not get changed.
    document.frmCPSInvCnclsn.bIndChkd.value = 'N'
    return false;
  }
  // No PRNs with unknown roles, return true.
  return true;
}

function checkUnknownIfMmbrPKHshld()
{
  if ( document.frmCPSInvCnclsn.hdnUnknownIfMmberErrorMessage.value != '') {
    //If it is unknown that any PRN is a member of the primary caretaker's household, ask the user if they want to continue
    bRetValue = confirm(document.frmCPSInvCnclsn.hdnUnknownIfMmberErrorMessage.value);
    return bRetValue;
  }
  return true;
}

function enableDisableSpecialInvSection(selected)
{

    //var value = eval("document.frmCPSInvCnclsn.rbSpeInv.value");
   
     
    if ('Y'== selected)
    {
      document.frmCPSInvCnclsn.rbFostPrnt.disabled = false;
      document.frmCPSInvCnclsn.dtDtFostPrntNotified.disabled = false;
      document.frmCPSInvCnclsn.rbStOffNotified.disabled = false;
      document.frmCPSInvCnclsn.dtDtStOffNotified.disabled = false;
      document.frmCPSInvCnclsn.dtDtStOffAdvised.disabled = false;
   } else  {
    document.frmCPSInvCnclsn.rbFostPrnt.value='';
      document.frmCPSInvCnclsn.rbFostPrnt.disabled = true;
      document.frmCPSInvCnclsn.dtDtFostPrntNotified.value = '';
      document.frmCPSInvCnclsn.dtDtFostPrntNotified.disabled = true;
      document.frmCPSInvCnclsn.rbStOffNotified.disabled = true;
      document.frmCPSInvCnclsn.dtDtStOffNotified.value='';
      document.frmCPSInvCnclsn.dtDtStOffNotified.disabled = true;
      document.frmCPSInvCnclsn.dtDtStOffAdvised.value='';
      document.frmCPSInvCnclsn.dtDtStOffAdvised.disabled = true;
   }
   
}

/**MR-066 Resource ID hyperlink submission */
function submitResourceID(idResource, idHomeStage)
  {
    disableValidation("frmCPSInvCnclsn");
    document.frmCPSInvCnclsn.idResource.value = idResource;
    document.frmCPSInvCnclsn.hdnUlIdHomeStage.value = idHomeStage;
    submitValidateForm( "frmCPSInvCnclsn", "/investigation/CPSInvCnclsn/displayResourceDetail" );
  }

window.onbeforeunload = function ()
{
  return IsDirty();
}

window.attachEvent('onload', emptyProviderSearch);

function emptyProviderSearch(){
   document.frmCPSInvCnclsn.txtNmResourceSearch.value = '';
   document.frmCPSInvCnclsn.selResourceFacilityTypeSearch.value = '';
   document.frmCPSInvCnclsn.txtResourceId.value = '';
}


function displayCPSHelp(helpTopic) {
var topic = helpTopic;
 var descriptor = "";
  descriptor += "width=450,";
  descriptor += "height=350,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=1,";
  descriptor += "fullscreen=0,";
  descriptor += "location=1,";
  descriptor += "menubar=0,";
  descriptor += "resizable=1,";
  descriptor += "scrollbars=1,";
  descriptor += "status=1,";
  descriptor += "toolbar=0";
  if(helpTopic != "")
   return window.open('/investigation/CPSInvCnclsn/displayCpsInvCnclsnHelp'+'#'+topic, "", descriptor);
}
</script>

<%
      //HD 5/30/2003 -- SIR 17670
      /*
       int eventID = CaseUtility.getEvent(GlobalData.getUlIdStage(request), GlobalData.getSzCdTask(request))
       .getIdEvent();

       boolean bHasBeenSubmitted = false;
       if (CaseUtility.hasBeenSubmittedForApproval(eventID)) {
       bHasBeenSubmitted = true;
       }

       String eventStatus = CaseUtility.getEvent(GlobalData.getUlIdStage(request), GlobalData.getSzCdTask(request))
       .getCdEventStatus();

       boolean disableApprovalStatus = true;

       if (CPSInvCnclsnConversation.EVENT_STATUS_PENDING.equals(eventStatus)
       || CPSInvCnclsnConversation.EVENT_STATUS_APPROVED.equals(eventStatus)
       || ("COMP".equals(eventStatus) && bHasBeenSubmitted)) {
       disableApprovalStatus = false;
       }

       //No matter what the status, if the approver flag is Y, then show the button.
       //String appMode = GlobalData.getAppMode( request ) ;
       if ("Y".equals(GlobalData.getApprovalFlag(request))) {
       disableApprovalStatus = false;
       }
       */
%>
<impact:validateErrors />
<impact:validateForm name="frmCPSInvCnclsn" method="post"
  action="/investigation/CPSInvCnclsn/displayCPSInvCnclsn"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.CPSInvCnclsnValidation"
  schema="/WEB-INF/Constraints.xsd" redisplayParameters="true"
  pageMode="<%=pageMode%>">
  <impact:validateInput type="hidden" name="dtStageInvStart" value="<%=dtStageInvStart%>" />
  <impact:validateInput type="hidden" name="spiModify" value="<%= spiModify %>" />
  <%
        String strFunction = "disableValidation('frmCPSInvCnclsn');return true;";
        String strAction = ApprovalStatusConversation.DISPLAY_URI;
        if ("Y".equals(GlobalData.getApprovalFlag(request))) {
          //if("N".equals(disableOverrideSection)){
          strAction = "/investigation/CPSInvCnclsn/validateApprv";
          strFunction = "return checkUnknownIfMmbrPKHshld();";
        }

        //if (!disableApprovalStatus) {
        if (approvalStatus) {
  %>
  <table width="100%" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td>
        <impact:ButtonTag name="btnApprovalStatus" img="btnApprovalStatus"
          form="frmCPSInvCnclsn" action="<%=strAction%>" 
          function="<%=strFunction%>" editableMode="<%=EditableMode.ALL%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  </table>
  <br>
  <%
  }
  %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%"
    class="tableborder">
    <tr>
      <th colspan="2">
        Dates
      </th>
    </tr>
    <tr>
      <td width="21%">
        <impact:validateDisplayOnlyField name="IntReceived"
          label="Intake Received" value="<%=IntReceived%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="IntAssigned"
          label="Date Assigned" value="<%=IntAssigned%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="InvInitiated"
          label="Date Response Met" value="<%=InvInitiated%>" />
      </td>
    </tr>
    <tr>
        <td>
          <span class="formRequiredText">*</span>
          <impact:validateDate  label="Date Determination Letter Sent" name="dtDetermLetterSent" value="<%= dtDetermLetterSent %>" type="text" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />
        </td>
     </tr>
    <tr>
        <td>
          <!-- STGAP00017854: Changed 'Date Completed' label(for CPSInvDetail Date Completed) to 'Date Submitted' per request. -->
          <span class="formRequiredText">*</span>
          <impact:validateDate  label="Date Submitted" name="dtDtCpsInvstDtlComplt" value="<%= dtDtCpsInvstDtlComplt %>" type="text" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />
        </td>
     </tr>
    
  </table>
  <br>
  <table width="100%" class="tableborder" cellspacing="0" cellpadding="3"
    border="0">
    <tr>
      <th colspan="2">
        Conclusion
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="OverallDisptn_DISPLAY_ONLY"
          label="Maltreatment Finding" value="<%=txtMaltreatmentDesc%>" />
      </td>
    </tr>
    <tr>
      <td>
      
        <impact:validateSelect name="selSzCdStageRiskFinding"
          label="Overall Risk Finding"
          codesTable="<%=CodesTables.CCRSKFND%>"
          value="<%=txtSzCdStageRiskFinding%>" tabIndex="<%=tabIndex++%>"
          disabled="<%=sDisableCnclsnDropDwn%>"
          onChange="enableCnclsnRiskLvl()" conditionallyRequired="true"
          blankValue="true" />
      </td>
    </tr>
    <tr>
   
      <td>
        <impact:validateSelect name="selSzCdStageLvlOfRisk"
          label="Level Of Risk" options="<%=levelOfRiskDisplay%>"
          value="<%=txtSzCdStageLvlOfRisk%>" tabIndex="<%=tabIndex++%>"
          disabled="<%=sDisableCnclsnDropDwn%>" blankValue="true"
          excludeOptions="<%=exOptionsCCRSKFND%>" />
      </td>
    </tr>
  
    <tr></tr>
    <tr></tr>
    <tr class="subdetail">
      <td class="formLabel">
        Family Violence:
      </td>
      <td>

        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          checked="<%=cdFamviol01%>" type="checkbox" name="cbxFamviol_01"
          value="cdFamviol01" label="Not Alleged"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>

        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdFamviol02%>" name="cbxFamviol_02"
          value="cdFamviol02" label="Alleged but unsubstantiated"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>

        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdFamviol03%>" name="cbxFamviol_03"
          value="cdFamviol03"
          label="Substantiated - Children Emotional Abuse"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>

        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdFamviol04%>" name="cbxFamviol_04"
          value="cdFamviol04" label="Substantiated - Children Physical Abuse"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>

        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdFamviol05%>" name="cbxFamviol_05"
          value="cdFamviol05"
          label="Substantiated - Children No Substantiated Maltreatment"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
      </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr>
      <td class="formLabel">
        Adult Substance Abuse Status:
      </td>
      <td>
        <impact:validateInput type="radio" label="Not Alleged"
          id="rbAbuseStatus_01" name="rbAbuseStatus"
          checked="<%=cdAbuseStatus01%>"
          value="<%=CodesTables.CASBABST_01%>" cssClass="formInput"
          disabled="<%=sDisableCnclsnDropDwn%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput type="radio" label="Alleged but not confirmed"
          id="rbAbuseStatus_02" name="rbAbuseStatus"
          checked="<%=cdAbuseStatus02%>"
          value="<%=CodesTables.CASBABST_02%>" cssClass="formInput"
          disabled="<%=sDisableCnclsnDropDwn%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput type="radio" label="Alleged and confirmed"
          id="rbAbuseStatus_03" name="rbAbuseStatus"
          checked="<%=cdAbuseStatus03%>"
          value="<%=CodesTables.CASBABST_03%>" cssClass="formInput"
          disabled="<%=sDisableCnclsnDropDwn%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput type="radio" label="Not Alleged but Confirmed"
          id="rbAbuseStatus_04" name="rbAbuseStatus"
          checked="<%=cdAbuseStatus04%>"
          value="<%=CodesTables.CASBABST_04%>" cssClass="formInput"
          disabled="<%=sDisableCnclsnDropDwn%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr>
      <td class="formLabel">
        Substance Abuse Type:
      </td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          checked="<%=cdAbuseType01%>" type="checkbox" name="cbxAbuseType_01"
          value="cdAbuseType01" label="Alcohol"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType02%>" name="cbxAbuseType_02"
          value="cdAbuseType02" label="Prescription Medicine"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType03%>" name="cbxAbuseType_03"
          value="cdAbuseType03" label="Controlled Substance"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType04%>" name="cbxAbuseType_04"
          value="cdAbuseType04" label="Alcohol and Prescribed Medicine"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType05%>" name="cbxAbuseType_05"
          value="cdAbuseType05" label="Alcohol and Controlled"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType06%>" name="cbxAbuseType_06"
          value="cdAbuseType06"
          label="Prescribed Medicine and Controlled Substance"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
          editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
          type="checkbox" checked="<%=cdAbuseType07%>" name="cbxAbuseType_07"
          value="cdAbuseType07" label="All Types"
          disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />

      </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzMaltreamentOccure"
          label="Where did the Maltreatment Occur?"
          orderBy="<%= SelectTag.DECODE_ORDERBY %>"
          codesTable="<%=CodesTables.CLOCMAL%>"
          value="<%=cdMaltreatLoc%>"
          disabled="<%=sDisableCnclsnDropDwn%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>

  </table>
  <br>
  
   <table width="100%" class="tableborder" cellspacing="0" cellpadding="3"
    border="0">
    <tr>
      <th colspan="5">
       Special Investigation Placement/Non-Placement Provider/Facility
      </th>
    </tr>
     <tr >
        <td colspan="2" class="formLabel">
          <span class="formRequiredText">*</span>Is this a Special Investigation?
          &nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayCPSHelp('specInv')">?</a></strong>
        </td>
        
        <td>
          <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedSpeInv%>" tabIndex="<%= tabIndex++ %>" value="Y" name="rbSpeInv" cssClass="formInput"   />
          
        </td>
        <td>
          <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedSpeInv%>" tabIndex="<%= tabIndex++ %>"  value="N" name="rbSpeInv" cssClass="formInput"  />
         
        </td>
 
    </tr>
    <tr>
        <td colspan="2" class="formLabel">
          Is this Maltreatment in Care?
          &nbsp; &nbsp; &nbsp; <strong><a href="#" onClick = "displayCPSHelp('malInCare')">?</a></strong>
        </td>
        
        <td>
          <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedMaltreatment%>" tabIndex="<%= tabIndex++ %>" disabled="true" value="Y" name="rbInvMaltreatInCare" cssClass="formInput"  />
          
        </td>
        <td>
          <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedMaltreatment%>" tabIndex="<%= tabIndex++ %>" disabled="true" value="N" name="rbInvMaltreatInCare" cssClass="formInput"  />
         
        </td>
 
    </tr>
    <tr>
        <td colspan="2" class="formLabel">
          Is this a Policy Violation?
          &nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayCPSHelp('policyViolation')">?</a></strong>
        </td>
        
        <td>
          <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedPolicyViolation%>" tabIndex="<%= tabIndex++ %>" value="Y" name="rbIndPolicyViolation" cssClass="formInput"  />
          
        </td>
        <td>
          <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedPolicyViolation%>" tabIndex="<%= tabIndex++ %>" value="N" name="rbIndPolicyViolation" cssClass="formInput"  />
         
        </td>
 
    </tr>
      <tr>
        <td>
          <impact:validateDisplayOnlyField   name="rbFostPrntLab" label="Was the foster parent notified of the right to have an advocate present?"  conditionallyRequired="true" /> 
        </td>
        <td>
          <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedFostPrnt%>" tabIndex="<%= tabIndex++ %>" value="Y" disabled="<%=sDisableCnclsnDropDwn%>" name="rbFostPrnt" cssClass="formInput" />
        
        </td>
        <td>
          <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedFostPrnt%>" tabIndex="<%= tabIndex++ %>" value="N" disabled="<%=sDisableCnclsnDropDwn%>" name="rbFostPrnt" cssClass="formInput" />
        
        </td>
        
        <td>
          <impact:validateInput type="radio" label="N/A" checked="<%=naIsCheckedFostPrnt%>" tabIndex="<%= tabIndex++ %>" value="A" disabled="<%=sDisableCnclsnDropDwn%>" name="rbFostPrnt" cssClass="formInput" />
        
        </td>
 
    </tr>
    <tr>
    	<td colspan="5"><span class="formCondRequiredText">&#135;</span>Comment [Required when foster parent is not notified]:</td>
    </tr>
	<tr>
		<td>
			<impact:validateTextArea name="txtSzTxtFostPrntNotifyCmnts"
				rows="3" cols="80" tabIndex="<%=tabIndex++%>"
				maxLength="1000" disabled="<%=sDisableCnclsnDropDwn%>"
				constraint="Comments" conditionallyRequired="false" colspan="5">
				<%=FormattingHelper.formatString(txtFostPrntNotifyCmnts)%>
			</impact:validateTextArea>
		</td>
	 </tr>
     <tr>
        <td>
          <impact:validateDate  colspan="7" label="Date the foster parent was notified of the right to have an advocate present" name="dtDtFostPrntNotified" disabled="<%=sDisableCnclsnDropDwn%>" value="<%= dtFostPrntNotified %>" type="text" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />
        </td>
     </tr>
         <tr>
         <td>
          <impact:validateDisplayOnlyField   name="rbStOffNotifiedLab" label="Has notification been given to the state office of the removal of child(ren) following initial investigative contact?"  conditionallyRequired="true" /> 
        </td>
        <td>
          <impact:validateInput  type="radio"  label="Yes" checked="<%=yIsCheckedStOffNotified%>" tabIndex="<%= tabIndex++ %>" value="Y" name="rbStOffNotified" disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput"   />
        
        </td>
        <td>
          <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedStOffNotified%>" tabIndex="<%= tabIndex++ %>" value="N" name="rbStOffNotified"  disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
        </td>
        <td>
          <impact:validateInput type="radio" label="N/A" checked="<%=naIsCheckedStOffNotified%>" tabIndex="<%= tabIndex++ %>" value="A" name="rbStOffNotified"  disabled="<%=sDisableCnclsnDropDwn%>" cssClass="formInput" />
        
        </td>
    </tr>
    <tr>
        <td>
          <impact:validateDate  colspan="7" label="Date the state office was notified of removal of child(ren)" name="dtDtStOffNotified" value="<%= dtStOffNotified %>" type="text" disabled="<%=sDisableCnclsnDropDwn%>" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />
        </td>
     </tr>
    <tr>
        <td>
          <impact:validateDate  colspan="7" label="Date state office advised all involved counties, providers, and agencies to remove children from the provider's care" name="dtDtStOffAdvised" disabled="<%=sDisableCnclsnDropDwn%>" value="<%= dtStOffAdvised %>" type="text"  constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />
        </td>
     </tr> 
    
    
    
   </table>
   <impact:ExpandableSectionTag name="Placement/Non-Placement Provider" id="txtNmIncmgFacilName" label="&#135; Placement/Non-Placement Provider" tabIndex="<%=tabIndex++%>" isExpanded="false" accessKey="F">
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		    <tr class="subDetail">
				<th colspan="5">
					Provider Search <i style="color:red">If maltreatment occurs in a non-DFCS F/A Home, the Provider name should never be the name of a Child Placing Agency, but the name of the F/A Home.</i>
				</th>
			</tr>
			<tr class="subDetail">
			    <%
			     %>
				<td>
					<impact:validateInput width="30%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(rsrcSearchRow.getSzNmResource())%>" type="text" name="txtNmResourceSearch" label="Provider Name" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
                <%//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderTypeS = new ArrayList<String>();
                   excludeOptionsProviderTypeS.add(CodesTables.CFACTYP4_CP);
                %>
				<td>
					<impact:validateSelect tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(rsrcSearchRow.getSzCdIncmgFacilType())%>" name="selResourceFacilityTypeSearch" codesTable="CFACTYP4" label="Provider Type"  blankValue="true" 
					excludeOptions="<%=excludeOptionsProviderTypeS%>" />

				</td>

	                 <%
					  /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
					                                       the retrieved resource info into the facility detail object in state before the page is loaded,
					                                       our save method did not register a change in facility.  In the save method we check to
					                                       see if the data has been changed since the page loaded OR if this indicator is true.  */
				    %>
					<%
					  String resourceSearch = (String) request.getAttribute("resourceSearch");
					%>
					<impact:validateInput type="hidden" name="hdnResourceSearch" value="<%=resourceSearch%>" />
				
				<td>
					<table cellspacing="0" cellpadding="3" width="100%" border="0">
  						<tr>
    						<td align="right">
      						<impact:ButtonTag name="btnFacilitySearch"
                        						img="btnSearch"
                       							 align="right"
                       							 form="frmCPSInvCnclsn"
                        						action="/investigation/CPSInvCnclsn/getFacilityResource"
                        						tabIndex="<%=tabIndex++%>"/>
    			             </td>
         				</tr>
					</table>
				</td>
			</tr>
			<tr class="subDetail" >
               <td>
					<impact:validateInput tabIndex="<%=tabIndex++%>"
                                value="<%=FormattingHelper.formatInt(rsrcSearchRow.getUlIdResource())%>"
                                type="text"
                                label="Resource ID"
                                name="txtResourceId"
                                constraint="Digit16Less"
                                maxLength="16"
                                size="16"/>
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<impact:validateInput type="hidden" name="idResource" value="<%=FormattingHelper.formatInt(cpsinvcncln10dog01.getUlIdResource())%>" />
           <impact:validateInput type="hidden" name="hdnUlIdHomeStage"/>
           <impact:validateInput type="hidden" name="hdnUlIdHomeCase"/>
           <impact:validateInput type="hidden" name="hdnCIndTrialHomeVisit" value="<%=FormattingHelper.formatString(cpsinvcncln.getCIndTrialHomeVisit())%>"/>
			
			<tr class="subDetail">
				<th colspan="5">
					General Information
				</th>
			</tr>
			<tr class="subDetail">
			    <td>
					<impact:validateInput width="30%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getNmIncmgFacilName())%>" type="text" name="txtNmResource" label="Provider Name"  conditionallyRequired="true" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
                <td>
				 <impact:validateDisplayOnlyField
                  name="dispResourceId"
                  label="Resource ID"
                  value=""
                />
                <a href="javascript:submitResourceID('<%=cpsinvcncln10dog01.getUlIdResource()%>', '<%=cpsinvcncln10dog01.getUlIdHomeStage()%>')" tabIndex='<%=tabIndex++%>'>
                <%=FormattingHelper.formatInt(cpsinvcncln10dog01.getUlIdResource())%>                 
                </a>
			   </td>
				
				<td></td>
			</tr>			

			<tr class="subDetail">
				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmIncmgFacilAffiliated())%>" type="text" name="txtSzNmIncmgFacilAffiliated" label="Affiliated" cssClass="formInput" size="40" maxLength="40"
						constraint="Paragraph40" />
				</td>

				<td>
					<impact:validateSelect colspan="2" label="Operated By" name="selSzCdIncFacilOperBy" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CERTIFBY%>" blankValue="true" value="<%=cpsinvcncln10dog01.getSzCdIncFacilOperBy()%>" />
				</td>
			</tr>
			<%//Set up the exclude array.
                   ArrayList<String> excludeOptions = new ArrayList<String>(); 
                   if(!CodesTables.CFACTYP4_CP.equals(cpsinvcncln10dog01.getSzCdIncmgFacilType())){
                     excludeOptions.add(CodesTables.CFACTYP4_CP);
                   }%>
			<tr class="subDetail">
				<td>
					<impact:validateSelect label="Provider Type" name="selSzCdIncmgFacilType" codesTable="CFACTYP4" tabIndex="<%=tabIndex++%>" blankValue="true" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzCdIncmgFacilType())%>" style="WIDTH: 200px" 
					excludeOptions="<%=excludeOptions%>"/>
				</td>

				<td>
					<impact:validateInput colspan="2" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmIncmgFacilSuprtdant())%>" type="text" name="txtSzNmIncmgFacilSuprtdant" label="Contact Person" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="5">
					Provider Address
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<%
					  /* BEGIN Address Submodule */
					%>
					<%
					  AddressSubDB facilityAddressSubDB = new AddressSubDB();
					          facilityAddressSubDB.setFormName("frmCPSInvCnclsn");
					          facilityAddressSubDB.setPageMode(pageMode);
					          facilityAddressSubDB.setAddressSubmoduleName("facilityAddress");
					          facilityAddressSubDB.setCommentsVisible(false);
					          facilityAddressSubDB.setCommentsRequired(false);
					          facilityAddressSubDB.setCommentsDisabled(true);
					          facilityAddressSubDB.setAddressRequired(false);
					          facilityAddressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.VIEW));
					          facilityAddressSubDB.setTabIndex(tabIndex);
					          AddressSubDB.setIntoRequest(facilityAddressSubDB, request);
					%>
					<%@ include file="/grnds-docs/common/AddressSub.jsp"%>
					<%
					  tabIndex = facilityAddressSubDB.getTabIndex();
					          AddressSubDB.removeFromRequest(request);
					%>
					<%
					  /* END Address Submodule */
					%>
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="5">
					Provider Phone
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatPhone(cpsinvcncln10dog01.getSzNbrIncmgFacilPhone())%>" type="text" name="txtSzNbrIncmgFacilPhone" label="Phone" cssClass="formInput" size="14" maxLength="14"
						constraint="Phone" />
				</td>

				<td>
					<impact:validateInput colspan="2" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzNbrIncmgFacilPhoneExt())%>" type="text" name="txtSzNbrIncmgFacilPhoneExt" label="Ext." cssClass="formInput" size="4"
						maxLength="4" constraint="PhoneExtension" />
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
			<tr class="subDetail">
				<th colspan="5">
					Additional Details
				</th>
			</tr>
			<tr class="subDetail">
				<td width="30%">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr class="subDetail">
							<%
							  String offGrounds = FormattingHelper.formatString(cpsinvcncln10dog01.getBIndIncmgOnGrnds());
							%>
							<td colspan="2">
								<impact:validateInput label="Abuse Off Grounds" type="checkbox" checked='<%=(("".equals(offGrounds)) || ("N".equals(offGrounds))) ? "false" : "true"%>' value="Y" name="cbxBIndIncmgOnGrnds" tabIndex="<%=tabIndex++%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<%
							  String unsupervised = FormattingHelper.formatString(cpsinvcncln10dog01.getBIndIncmgFacilAbSupvd());
							%>
							<td colspan="2">
								<impact:validateInput label="Unsupervised" type="checkbox" checked='<%=(("".equals(unsupervised)) || ("N".equals(unsupervised))) ? "false" : "true"%>' value="Y" name="cbxBIndIncmgFacilAbSupv" tabIndex="<%=tabIndex++%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<td>
								<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmUnitWard())%>" type="text" name="txtSzNmUnitWard" label="Unit/Ward" cssClass="formInput" size="15" maxLength="15" constraint="Any15" />
							</td>
						</tr>
					</table>
				</td>
				<td>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr class="subDetail">
							<td colspan="2">
								Special Instructions (Hrs. of Op., Pop. served, Etc.)
							</td>
						</tr>
						<tr class="subDetail">
							<td>
								<impact:validateTextArea name="txtSzTxtFacilCmnts" rows="4" cols="65" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
									<%=FormattingHelper.formatString(cpsinvcncln10dog01.getSzTxtFacilCmnts())%>
								</impact:validateTextArea>
							</td>
						</tr>
					</table>
				</td>
			</tr>			
		</table>
	</impact:ExpandableSectionTag>
   <br>
   <table width="100%" class="tableborder" cellspacing="0" cellpadding="3"
    border="0">
    <tr>
      <th colspan="2">
        Supervisor Override
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDate type="text" name="txtDtOverride" label="Date"
          constraint="Date" size="10"
          disabled="<%=sDisableOverrideDropDwn%>"
          value="<%=txtDtOverride%>" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdOverrideOverllFind"
          label="Supervisor Overall Finding"
          codesTable="<%=CodesTables.CCRSKFND%>"
          value="<%=txtSzCdOverrideRiskFinding == null ? "" : txtSzCdOverrideRiskFinding%>"
          tabIndex="<%=tabIndex++%>"
          disabled="<%=sDisableOverrideDropDwn%>"
          onChange="enableOverrideRiskLvl()" conditionallyRequired="false"
          blankValue="true" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdOverrideRiskLvl"
          label="Level Of Risk" options="<%=levelOfRiskDisplay%>"
          value="<%=txtSzCdOverrideLvlOfRisk%>"
          tabIndex="<%=tabIndex++%>"
          disabled="<%=sDisableOverrideDropDwn%>"
          conditionallyRequired="false" blankValue="true" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea name="txtSzTxtOverrideComments"
          label="Comments" rows="3" cols="80" tabIndex="<%=tabIndex++%>"
          maxLength="300" disabled="<%=sDisableOverrideDropDwn%>"
          constraint="Comments" conditionallyRequired="false">
          <%=FormattingHelper.formatString(txtOverrideComment)%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <impact:validateInput type="hidden" name="txtUlIdStage" value="<%=txtUlIdStage%>" />
  <impact:validateInput type="hidden" name="txtUlIdEvent" value="<%=txtUlIdEvent%>" />
  <impact:validateInput type="hidden" name="txtUlIdCase" value="<%=txtUlIdCase%>" />
  <impact:validateInput type="hidden" name="ulRowQty" value="<%=String.valueOf(ulRowQty)%>" />
  <impact:validateInput type="hidden" name="bIndChkd" value="<%=bIndChkd%>" />
  <impact:validateInput type="hidden" name="hdnBIndPrnUk" value="<%=bIndPrnUk%>" />
  <impact:validateInput type="hidden" name="hdnIndUnSubMIC" value="<%=indUnSubMIC%>" />  
  <impact:validateInput type="hidden" name="txtSzCdRiskAssmtRiskFind" value="<%=txtSzCdRiskAssmtRiskFind%>" />
  <impact:validateInput type="hidden" name="txtCdCpsOverallDisptn" value="<%=txtCdCpsOverallDisptn%>" />
  <impact:validateInput type="hidden" name="hdnUnknownIfMmberErrorMessage" value="<%=unknownIfMmberHshldErrorMessage%>" />
  <!--SIR - 23536 -->
  <impact:validateInput type="hidden" name="txtDsplyAudioVideo" value="<%=dsplyAudioVideo.toString()%>" />

  <table width="100%" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td align="right">
        <%
              if (saveAndSubmit) {
        %>
        <impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit"
          function="return submitChecks(); " form="frmCPSInvCnclsn"
          action="/investigation/CPSInvCnclsn/saveSubmitCPSInvCnclsn"
          restrictRepost="true" tabIndex="<%=tabIndex++%>" />
        <%
              }
              if (save) {
        %>
        <impact:ButtonTag name="btnSave" img="btnSave"
          form="frmCPSInvCnclsn"
          action="/investigation/CPSInvCnclsn/saveCPSInvCnclsn"
          restrictRepost="true" tabIndex="<%=tabIndex++%>" />
        <%
        }
        %>
      </td>
    </tr>
  </table>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:documentButton pageMode="<%= pageMode %>" buttonUrl="/grnds-docs/images/shared/btnNarrative.gif" tabIndex="<%= tabIndex++ %>" accessKey="W">

        <impact:document
          displayName="CpsConclusion"
          checkForNewMode="true"
          name="CpsConclusion"
          docType="cpscnlsn"
          docExists="<%= docExists%>"
          protectDocument="<%= protectNarrative%>">
          <impact:documentParameter name="sEvent" value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>" />
          <impact:documentParameter name="sCase" value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>" />
        </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table><script language="JavaScript" type="text/javascript">
   enableCnclsnRiskLvl();
   enableOverrideRiskLvl();
</script>
