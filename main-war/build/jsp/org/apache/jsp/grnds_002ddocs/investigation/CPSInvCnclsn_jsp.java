package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.CPSInvCnclsnConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class CPSInvCnclsn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n\r\n");

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
       

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// this function will enable/disable the conclusion risk level drop down based on the Overall Risk Finding drop \r\n// down selection. Enable risk level only if Risk finding selection is either \"Risk Indicated/Open for Placement\" or\r\n// \"Risk Indicated/Open for Services\"\r\n//-- Called onChange of Overall Risk Finding and each time the page loads\r\nfunction enableCnclsnRiskLvl() {\r\n  if ( document.frmCPSInvCnclsn.selSzCdStageRiskFinding.value != null) {\r\n    var riskFindingCode = document.frmCPSInvCnclsn.selSzCdStageRiskFinding.value;\r\n    if ( ");
      out.print( ArchitectureConstants.FALSE.equals(sDisableCnclsnDropDwn) );
      out.write(") {\r\n      if (riskFindingCode ==  '05' ||  riskFindingCode == '01' ) {\r\n        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.disabled = false;\r\n      } else {\r\n        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.disabled = true;\r\n        document.frmCPSInvCnclsn.selSzCdStageLvlOfRisk.value = \"\";\r\n      }\r\n    }\r\n  }                  \r\n}\r\n\r\nfunction enableOverrideRiskLvl() {\r\n  var supervisorOverallFinding = document.frmCPSInvCnclsn.selSzCdOverrideOverllFind;\r\n  var supervisorOverallFindingValue = supervisorOverallFinding.value;\r\n\r\n  if ( supervisorOverallFindingValue != null) {\r\n    if ( ");
      out.print( ArchitectureConstants.FALSE.equals(sDisableOverrideDropDwn) );
      out.write(") {\r\n      var levelOfRisk = document.frmCPSInvCnclsn.selSzCdOverrideRiskLvl;\r\n    \r\n      if (supervisorOverallFindingValue ==  '05' ||  supervisorOverallFindingValue == '01' ) {\r\n        levelOfRisk.disabled = false;\r\n      } else {\r\n        levelOfRisk.disabled = true; //STGAP00012542 Disable Supervisor Level of Risk when the Superviosr Overall Risk \r\n                                     //   finding is not 01 or 05\r\n        levelOfRisk.value = \"\";\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\n//-- Called by Save and Submit button (function attribute)\r\nfunction submitChecks()\r\n{\r\n  var result;\r\n  //newIntake();\r\n  // SIR 15956 If there are PRNs with unknown gender or\r\n  // appx dob, display a message to the user, if they\r\n  // choose to continue, display unknown role message.\r\n  result = checkUknownGenDOB();\r\n  if ( result == true)\r\n  {\r\n   result = checkUnknownRole();\r\n  }\r\n  if ( result == true)\r\n  {\r\n   result = checkUnknownIfMmbrPKHshld();\r\n  }\r\n\r\n  return result;\r\n}\r\n\r\n// SIR 15956 added this function to check and see if there are PRNs with\r\n");
      out.write("// Unknown gender and/or approx DOB.  If there are (indicator returned from\r\n// the service) check to see if the user wants to continue.  If they\r\n// click cancel the page will not continue, if they click OK it will.\r\n//-- Called by submitChecks()\r\nfunction checkUknownGenDOB()\r\n{\r\n  //the value of hdnBIndPrnUk tells us if there are any\r\n  // PRNs with unknown gender or appx dob.  If there aren't, return true\r\n  if ( document.frmCPSInvCnclsn.hdnBIndPrnUk.value == 'Y' )\r\n  {\r\n    //If there are PRNs with unknown gender or appx dob, ask the user if they want to continue\r\n    bRetValue = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_PRN_UNK_DOB_GEN));
      out.write("')\r\n    return bRetValue;\r\n  }\r\n  // No PRNs with unknown roles, return true.\r\n  return true;\r\n}\r\n\r\n//-- Also called by submitChecks()\r\nfunction checkUnknownRole()\r\n{\r\n  //the value of ulRowQty tells us if there are any\r\n  // PRNs with unknown roles.  If there aren't, return true\r\n  if ( document.frmCPSInvCnclsn.ulRowQty.value != 0 )\r\n  {\r\n    //If there are PRNs with unknown roles, ask the user if they want to continue, and warn them\r\n    // that continuing will change the roles to 'NO'\r\n    bRetValue = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INV_ONE_OR_MORE_UK_EXIT));
      out.write("')\r\n    // If the user says it is ok to continue and change the role, set an indicator in a field so that\r\n    // the service will know to change the roles.\r\n    if( bRetValue )\r\n    {\r\n      document.frmCPSInvCnclsn.bIndChkd.value = 'Y';\r\n      return true;\r\n    }\r\n    // Otherwise set the field to 'N' so that if they save and don't save an submit at this\r\n    // point, the roles will not get changed.\r\n    document.frmCPSInvCnclsn.bIndChkd.value = 'N'\r\n    return false;\r\n  }\r\n  // No PRNs with unknown roles, return true.\r\n  return true;\r\n}\r\n\r\nfunction checkUnknownIfMmbrPKHshld()\r\n{\r\n  if ( document.frmCPSInvCnclsn.hdnUnknownIfMmberErrorMessage.value != '') {\r\n    //If it is unknown that any PRN is a member of the primary caretaker's household, ask the user if they want to continue\r\n    bRetValue = confirm(document.frmCPSInvCnclsn.hdnUnknownIfMmberErrorMessage.value);\r\n    return bRetValue;\r\n  }\r\n  return true;\r\n}\r\n\r\nfunction enableDisableSpecialInvSection(selected)\r\n{\r\n\r\n    //var value = eval(\"document.frmCPSInvCnclsn.rbSpeInv.value\");\r\n");
      out.write("   \r\n     \r\n    if ('Y'== selected)\r\n    {\r\n      document.frmCPSInvCnclsn.rbFostPrnt.disabled = false;\r\n      document.frmCPSInvCnclsn.dtDtFostPrntNotified.disabled = false;\r\n      document.frmCPSInvCnclsn.rbStOffNotified.disabled = false;\r\n      document.frmCPSInvCnclsn.dtDtStOffNotified.disabled = false;\r\n      document.frmCPSInvCnclsn.dtDtStOffAdvised.disabled = false;\r\n   } else  {\r\n    document.frmCPSInvCnclsn.rbFostPrnt.value='';\r\n      document.frmCPSInvCnclsn.rbFostPrnt.disabled = true;\r\n      document.frmCPSInvCnclsn.dtDtFostPrntNotified.value = '';\r\n      document.frmCPSInvCnclsn.dtDtFostPrntNotified.disabled = true;\r\n      document.frmCPSInvCnclsn.rbStOffNotified.disabled = true;\r\n      document.frmCPSInvCnclsn.dtDtStOffNotified.value='';\r\n      document.frmCPSInvCnclsn.dtDtStOffNotified.disabled = true;\r\n      document.frmCPSInvCnclsn.dtDtStOffAdvised.value='';\r\n      document.frmCPSInvCnclsn.dtDtStOffAdvised.disabled = true;\r\n   }\r\n   \r\n}\r\n\r\n/**MR-066 Resource ID hyperlink submission */\r\nfunction submitResourceID(idResource, idHomeStage)\r\n");
      out.write("  {\r\n    disableValidation(\"frmCPSInvCnclsn\");\r\n    document.frmCPSInvCnclsn.idResource.value = idResource;\r\n    document.frmCPSInvCnclsn.hdnUlIdHomeStage.value = idHomeStage;\r\n    submitValidateForm( \"frmCPSInvCnclsn\", \"/investigation/CPSInvCnclsn/displayResourceDetail\" );\r\n  }\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  return IsDirty();\r\n}\r\n\r\nwindow.attachEvent('onload', emptyProviderSearch);\r\n\r\nfunction emptyProviderSearch(){\r\n   document.frmCPSInvCnclsn.txtNmResourceSearch.value = '';\r\n   document.frmCPSInvCnclsn.selResourceFacilityTypeSearch.value = '';\r\n   document.frmCPSInvCnclsn.txtResourceId.value = '';\r\n}\r\n\r\n\r\nfunction displayCPSHelp(helpTopic) {\r\nvar topic = helpTopic;\r\n var descriptor = \"\";\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n");
      out.write("  descriptor += \"status=1,\";\r\n  descriptor += \"toolbar=0\";\r\n  if(helpTopic != \"\")\r\n   return window.open('/investigation/CPSInvCnclsn/displayCpsInvCnclsnHelp'+'#'+topic, \"\", descriptor);\r\n}\r\n</script>\r\n\r\n");

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

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCPSInvCnclsn");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/CPSInvCnclsn/displayCPSInvCnclsn");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.CPSInvCnclsnValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("dtStageInvStart");
          _jspx_th_impact_validateInput_0.setValue(dtStageInvStart);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("spiModify");
          _jspx_th_impact_validateInput_1.setValue( spiModify );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

        String strFunction = "disableValidation('frmCPSInvCnclsn');return true;";
        String strAction = ApprovalStatusConversation.DISPLAY_URI;
        if ("Y".equals(GlobalData.getApprovalFlag(request))) {
          //if("N".equals(disableOverrideSection)){
          strAction = "/investigation/CPSInvCnclsn/validateApprv";
          strFunction = "return checkUnknownIfMmbrPKHshld();";
        }

        //if (!disableApprovalStatus) {
        if (approvalStatus) {
  
          out.write("\r\n  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmCPSInvCnclsn");
          _jspx_th_impact_ButtonTag_0.setAction(strAction);
          _jspx_th_impact_ButtonTag_0.setFunction(strFunction);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");

  }
  
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n    class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Dates\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"21%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("IntReceived");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Intake Received");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(IntReceived);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("IntAssigned");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Date Assigned");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(IntAssigned);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("InvInitiated");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Date Response Met");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(InvInitiated);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n          <span class=\"formRequiredText\">*</span>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Determination Letter Sent");
          _jspx_th_impact_validateDate_0.setName("dtDetermLetterSent");
          _jspx_th_impact_validateDate_0.setValue( dtDetermLetterSent );
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     </tr>\r\n    <tr>\r\n        <td>\r\n          <!-- STGAP00017854: Changed 'Date Completed' label(for CPSInvDetail Date Completed) to 'Date Submitted' per request. -->\r\n          <span class=\"formRequiredText\">*</span>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date Submitted");
          _jspx_th_impact_validateDate_1.setName("dtDtCpsInvstDtlComplt");
          _jspx_th_impact_validateDate_1.setValue( dtDtCpsInvstDtlComplt );
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     </tr>\r\n    \r\n  </table>\r\n  <br>\r\n  <table width=\"100%\" class=\"tableborder\" cellspacing=\"0\" cellpadding=\"3\"\r\n    border=\"0\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Conclusion\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("OverallDisptn_DISPLAY_ONLY");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Maltreatment Finding");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(txtMaltreatmentDesc);
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n      \r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdStageRiskFinding");
          _jspx_th_impact_validateSelect_0.setLabel("Overall Risk Finding");
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CCRSKFND);
          _jspx_th_impact_validateSelect_0.setValue(txtSzCdStageRiskFinding);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateSelect_0.setOnChange("enableCnclsnRiskLvl()");
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n   \r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdStageLvlOfRisk");
          _jspx_th_impact_validateSelect_1.setLabel("Level Of Risk");
          _jspx_th_impact_validateSelect_1.setOptions(levelOfRiskDisplay);
          _jspx_th_impact_validateSelect_1.setValue(txtSzCdStageLvlOfRisk);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setExcludeOptions(exOptionsCCRSKFND);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  \r\n    <tr></tr>\r\n    <tr></tr>\r\n    <tr class=\"subdetail\">\r\n      <td class=\"formLabel\">\r\n        Family Violence:\r\n      </td>\r\n      <td>\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_2.setChecked(cdFamviol01);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setName("cbxFamviol_01");
          _jspx_th_impact_validateInput_2.setValue("cdFamviol01");
          _jspx_th_impact_validateInput_2.setLabel("Not Alleged");
          _jspx_th_impact_validateInput_2.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setChecked(cdFamviol02);
          _jspx_th_impact_validateInput_3.setName("cbxFamviol_02");
          _jspx_th_impact_validateInput_3.setValue("cdFamviol02");
          _jspx_th_impact_validateInput_3.setLabel("Alleged but unsubstantiated");
          _jspx_th_impact_validateInput_3.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setChecked(cdFamviol03);
          _jspx_th_impact_validateInput_4.setName("cbxFamviol_03");
          _jspx_th_impact_validateInput_4.setValue("cdFamviol03");
          _jspx_th_impact_validateInput_4.setLabel("Substantiated - Children Emotional Abuse");
          _jspx_th_impact_validateInput_4.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setChecked(cdFamviol04);
          _jspx_th_impact_validateInput_5.setName("cbxFamviol_04");
          _jspx_th_impact_validateInput_5.setValue("cdFamviol04");
          _jspx_th_impact_validateInput_5.setLabel("Substantiated - Children Physical Abuse");
          _jspx_th_impact_validateInput_5.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setChecked(cdFamviol05);
          _jspx_th_impact_validateInput_6.setName("cbxFamviol_05");
          _jspx_th_impact_validateInput_6.setValue("cdFamviol05");
          _jspx_th_impact_validateInput_6.setLabel("Substantiated - Children No Substantiated Maltreatment");
          _jspx_th_impact_validateInput_6.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr></tr>\r\n    <tr>\r\n      <td class=\"formLabel\">\r\n        Adult Substance Abuse Status:\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel("Not Alleged");
          _jspx_th_impact_validateInput_7.setId("rbAbuseStatus_01");
          _jspx_th_impact_validateInput_7.setName("rbAbuseStatus");
          _jspx_th_impact_validateInput_7.setChecked(cdAbuseStatus01);
          _jspx_th_impact_validateInput_7.setValue(CodesTables.CASBABST_01);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel("Alleged but not confirmed");
          _jspx_th_impact_validateInput_8.setId("rbAbuseStatus_02");
          _jspx_th_impact_validateInput_8.setName("rbAbuseStatus");
          _jspx_th_impact_validateInput_8.setChecked(cdAbuseStatus02);
          _jspx_th_impact_validateInput_8.setValue(CodesTables.CASBABST_02);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel("Alleged and confirmed");
          _jspx_th_impact_validateInput_9.setId("rbAbuseStatus_03");
          _jspx_th_impact_validateInput_9.setName("rbAbuseStatus");
          _jspx_th_impact_validateInput_9.setChecked(cdAbuseStatus03);
          _jspx_th_impact_validateInput_9.setValue(CodesTables.CASBABST_03);
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel("Not Alleged but Confirmed");
          _jspx_th_impact_validateInput_10.setId("rbAbuseStatus_04");
          _jspx_th_impact_validateInput_10.setName("rbAbuseStatus");
          _jspx_th_impact_validateInput_10.setChecked(cdAbuseStatus04);
          _jspx_th_impact_validateInput_10.setValue(CodesTables.CASBABST_04);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr></tr>\r\n    <tr>\r\n      <td class=\"formLabel\">\r\n        Substance Abuse Type:\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_11.setChecked(cdAbuseType01);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setName("cbxAbuseType_01");
          _jspx_th_impact_validateInput_11.setValue("cdAbuseType01");
          _jspx_th_impact_validateInput_11.setLabel("Alcohol");
          _jspx_th_impact_validateInput_11.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setChecked(cdAbuseType02);
          _jspx_th_impact_validateInput_12.setName("cbxAbuseType_02");
          _jspx_th_impact_validateInput_12.setValue("cdAbuseType02");
          _jspx_th_impact_validateInput_12.setLabel("Prescription Medicine");
          _jspx_th_impact_validateInput_12.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setChecked(cdAbuseType03);
          _jspx_th_impact_validateInput_13.setName("cbxAbuseType_03");
          _jspx_th_impact_validateInput_13.setValue("cdAbuseType03");
          _jspx_th_impact_validateInput_13.setLabel("Controlled Substance");
          _jspx_th_impact_validateInput_13.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setChecked(cdAbuseType04);
          _jspx_th_impact_validateInput_14.setName("cbxAbuseType_04");
          _jspx_th_impact_validateInput_14.setValue("cdAbuseType04");
          _jspx_th_impact_validateInput_14.setLabel("Alcohol and Prescribed Medicine");
          _jspx_th_impact_validateInput_14.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setChecked(cdAbuseType05);
          _jspx_th_impact_validateInput_15.setName("cbxAbuseType_05");
          _jspx_th_impact_validateInput_15.setValue("cdAbuseType05");
          _jspx_th_impact_validateInput_15.setLabel("Alcohol and Controlled");
          _jspx_th_impact_validateInput_15.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setChecked(cdAbuseType06);
          _jspx_th_impact_validateInput_16.setName("cbxAbuseType_06");
          _jspx_th_impact_validateInput_16.setValue("cdAbuseType06");
          _jspx_th_impact_validateInput_16.setLabel("Prescribed Medicine and Controlled Substance");
          _jspx_th_impact_validateInput_16.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
          _jspx_th_impact_validateInput_17.setType("checkbox");
          _jspx_th_impact_validateInput_17.setChecked(cdAbuseType07);
          _jspx_th_impact_validateInput_17.setName("cbxAbuseType_07");
          _jspx_th_impact_validateInput_17.setValue("cdAbuseType07");
          _jspx_th_impact_validateInput_17.setLabel("All Types");
          _jspx_th_impact_validateInput_17.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr></tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selSzMaltreamentOccure");
          _jspx_th_impact_validateSelect_2.setLabel("Where did the Maltreatment Occur?");
          _jspx_th_impact_validateSelect_2.setOrderBy( SelectTag.DECODE_ORDERBY );
          _jspx_th_impact_validateSelect_2.setCodesTable(CodesTables.CLOCMAL);
          _jspx_th_impact_validateSelect_2.setValue(cdMaltreatLoc);
          _jspx_th_impact_validateSelect_2.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n  </table>\r\n  <br>\r\n  \r\n   <table width=\"100%\" class=\"tableborder\" cellspacing=\"0\" cellpadding=\"3\"\r\n    border=\"0\">\r\n    <tr>\r\n      <th colspan=\"5\">\r\n       Special Investigation Placement/Non-Placement Provider/Facility\r\n      </th>\r\n    </tr>\r\n     <tr >\r\n        <td colspan=\"2\" class=\"formLabel\">\r\n          <span class=\"formRequiredText\">*</span>Is this a Special Investigation?\r\n          &nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayCPSHelp('specInv')\">?</a></strong>\r\n        </td>\r\n        \r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setLabel("Yes");
          _jspx_th_impact_validateInput_18.setChecked(yIsCheckedSpeInv);
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_18.setValue("Y");
          _jspx_th_impact_validateInput_18.setName("rbSpeInv");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setLabel("No");
          _jspx_th_impact_validateInput_19.setChecked(nIsCheckedSpeInv);
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_19.setValue("N");
          _jspx_th_impact_validateInput_19.setName("rbSpeInv");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         \r\n        </td>\r\n \r\n    </tr>\r\n    <tr>\r\n        <td colspan=\"2\" class=\"formLabel\">\r\n          Is this Maltreatment in Care?\r\n          &nbsp; &nbsp; &nbsp; <strong><a href=\"#\" onClick = \"displayCPSHelp('malInCare')\">?</a></strong>\r\n        </td>\r\n        \r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setLabel("Yes");
          _jspx_th_impact_validateInput_20.setChecked(yIsCheckedMaltreatment);
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_20.setDisabled("true");
          _jspx_th_impact_validateInput_20.setValue("Y");
          _jspx_th_impact_validateInput_20.setName("rbInvMaltreatInCare");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setLabel("No");
          _jspx_th_impact_validateInput_21.setChecked(nIsCheckedMaltreatment);
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_21.setDisabled("true");
          _jspx_th_impact_validateInput_21.setValue("N");
          _jspx_th_impact_validateInput_21.setName("rbInvMaltreatInCare");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         \r\n        </td>\r\n \r\n    </tr>\r\n    <tr>\r\n        <td colspan=\"2\" class=\"formLabel\">\r\n          Is this a Policy Violation?\r\n          &nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayCPSHelp('policyViolation')\">?</a></strong>\r\n        </td>\r\n        \r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setLabel("Yes");
          _jspx_th_impact_validateInput_22.setChecked(yIsCheckedPolicyViolation);
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_22.setValue("Y");
          _jspx_th_impact_validateInput_22.setName("rbIndPolicyViolation");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setLabel("No");
          _jspx_th_impact_validateInput_23.setChecked(nIsCheckedPolicyViolation);
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_23.setValue("N");
          _jspx_th_impact_validateInput_23.setName("rbIndPolicyViolation");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         \r\n        </td>\r\n \r\n    </tr>\r\n      <tr>\r\n        <td>\r\n          ");
          if (_jspx_meth_impact_validateDisplayOnlyField_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(" \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setLabel("Yes");
          _jspx_th_impact_validateInput_24.setChecked(yIsCheckedFostPrnt);
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_24.setValue("Y");
          _jspx_th_impact_validateInput_24.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_24.setName("rbFostPrnt");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setLabel("No");
          _jspx_th_impact_validateInput_25.setChecked(nIsCheckedFostPrnt);
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_25.setValue("N");
          _jspx_th_impact_validateInput_25.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_25.setName("rbFostPrnt");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n        </td>\r\n        \r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setLabel("N/A");
          _jspx_th_impact_validateInput_26.setChecked(naIsCheckedFostPrnt);
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_26.setValue("A");
          _jspx_th_impact_validateInput_26.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_26.setName("rbFostPrnt");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n        </td>\r\n \r\n    </tr>\r\n    <tr>\r\n    \t<td colspan=\"5\"><span class=\"formCondRequiredText\">&#135;</span>Comment [Required when foster parent is not notified]:</td>\r\n    </tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtFostPrntNotifyCmnts");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("false");
          _jspx_th_impact_validateTextArea_0.setColspan("5");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t");
              out.print(FormattingHelper.formatString(txtFostPrntNotifyCmnts));
              out.write("\r\n\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t </tr>\r\n     <tr>\r\n        <td>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setColspan("7");
          _jspx_th_impact_validateDate_2.setLabel("Date the foster parent was notified of the right to have an advocate present");
          _jspx_th_impact_validateDate_2.setName("dtDtFostPrntNotified");
          _jspx_th_impact_validateDate_2.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateDate_2.setValue( dtFostPrntNotified );
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setSize("8");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     </tr>\r\n         <tr>\r\n         <td>\r\n          ");
          if (_jspx_meth_impact_validateDisplayOnlyField_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(" \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setLabel("Yes");
          _jspx_th_impact_validateInput_27.setChecked(yIsCheckedStOffNotified);
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_27.setValue("Y");
          _jspx_th_impact_validateInput_27.setName("rbStOffNotified");
          _jspx_th_impact_validateInput_27.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel("No");
          _jspx_th_impact_validateInput_28.setChecked(nIsCheckedStOffNotified);
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_28.setValue("N");
          _jspx_th_impact_validateInput_28.setName("rbStOffNotified");
          _jspx_th_impact_validateInput_28.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setLabel("N/A");
          _jspx_th_impact_validateInput_29.setChecked(naIsCheckedStOffNotified);
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setValue("A");
          _jspx_th_impact_validateInput_29.setName("rbStOffNotified");
          _jspx_th_impact_validateInput_29.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setColspan("7");
          _jspx_th_impact_validateDate_3.setLabel("Date the state office was notified of removal of child(ren)");
          _jspx_th_impact_validateDate_3.setName("dtDtStOffNotified");
          _jspx_th_impact_validateDate_3.setValue( dtStOffNotified );
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setSize("8");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     </tr>\r\n    <tr>\r\n        <td>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setColspan("7");
          _jspx_th_impact_validateDate_4.setLabel("Date state office advised all involved counties, providers, and agencies to remove children from the provider's care");
          _jspx_th_impact_validateDate_4.setName("dtDtStOffAdvised");
          _jspx_th_impact_validateDate_4.setDisabled(sDisableCnclsnDropDwn);
          _jspx_th_impact_validateDate_4.setValue( dtStOffAdvised );
          _jspx_th_impact_validateDate_4.setType("text");
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          _jspx_th_impact_validateDate_4.setSize("8");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     </tr> \r\n    \r\n    \r\n    \r\n   </table>\r\n   ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("Placement/Non-Placement Provider");
          _jspx_th_impact_ExpandableSectionTag_0.setId("txtNmIncmgFacilName");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("&#135; Placement/Non-Placement Provider");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(false);
          _jspx_th_impact_ExpandableSectionTag_0.setAccessKey("F");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Search <i style=\"color:red\">If maltreatment occurs in a non-DFCS F/A Home, the Provider name should never be the name of a Child Placing Agency, but the name of the F/A Home.</i>\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t    ");

			     
              out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_30.setWidth("30%");
              _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatString(rsrcSearchRow.getSzNmResource()));
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setName("txtNmResourceSearch");
              _jspx_th_impact_validateInput_30.setLabel("Provider Name");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setSize("40");
              _jspx_th_impact_validateInput_30.setMaxLength("40");
              _jspx_th_impact_validateInput_30.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n                ");
//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderTypeS = new ArrayList<String>();
                   excludeOptionsProviderTypeS.add(CodesTables.CFACTYP4_CP);
                
              out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(rsrcSearchRow.getSzCdIncmgFacilType()));
              _jspx_th_impact_validateSelect_3.setName("selResourceFacilityTypeSearch");
              _jspx_th_impact_validateSelect_3.setCodesTable("CFACTYP4");
              _jspx_th_impact_validateSelect_3.setLabel("Provider Type");
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setExcludeOptions(excludeOptionsProviderTypeS);
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\r\n\t                 ");

					  /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
					                                       the retrieved resource info into the facility detail object in state before the page is loaded,
					                                       our save method did not register a change in facility.  In the save method we check to
					                                       see if the data has been changed since the page loaded OR if this indicator is true.  */
				    
              out.write("\r\n\t\t\t\t\t");

					  String resourceSearch = (String) request.getAttribute("resourceSearch");
					
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_31.setType("hidden");
              _jspx_th_impact_validateInput_31.setName("hdnResourceSearch");
              _jspx_th_impact_validateInput_31.setValue(resourceSearch);
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n  \t\t\t\t\t\t<tr>\r\n    \t\t\t\t\t\t<td align=\"right\">\r\n      \t\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnFacilitySearch");
              _jspx_th_impact_ButtonTag_1.setImg("btnSearch");
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setForm("frmCPSInvCnclsn");
              _jspx_th_impact_ButtonTag_1.setAction("/investigation/CPSInvCnclsn/getFacilityResource");
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    \t\t\t             </td>\r\n         \t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\" >\r\n               <td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_32.setValue(FormattingHelper.formatInt(rsrcSearchRow.getUlIdResource()));
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setLabel("Resource ID");
              _jspx_th_impact_validateInput_32.setName("txtResourceId");
              _jspx_th_impact_validateInput_32.setConstraint("Digit16Less");
              _jspx_th_impact_validateInput_32.setMaxLength("16");
              _jspx_th_impact_validateInput_32.setSize("16");
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_33.setType("hidden");
              _jspx_th_impact_validateInput_33.setName("idResource");
              _jspx_th_impact_validateInput_33.setValue(FormattingHelper.formatInt(cpsinvcncln10dog01.getUlIdResource()));
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              if (_jspx_meth_impact_validateInput_34(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n           ");
              if (_jspx_meth_impact_validateInput_35(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_36.setType("hidden");
              _jspx_th_impact_validateInput_36.setName("hdnCIndTrialHomeVisit");
              _jspx_th_impact_validateInput_36.setValue(FormattingHelper.formatString(cpsinvcncln.getCIndTrialHomeVisit()));
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tGeneral Information\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t    <td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_37.setWidth("30%");
              _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_37.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getNmIncmgFacilName()));
              _jspx_th_impact_validateInput_37.setType("text");
              _jspx_th_impact_validateInput_37.setName("txtNmResource");
              _jspx_th_impact_validateInput_37.setLabel("Provider Name");
              _jspx_th_impact_validateInput_37.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_37.setCssClass("formInput");
              _jspx_th_impact_validateInput_37.setSize("40");
              _jspx_th_impact_validateInput_37.setMaxLength("40");
              _jspx_th_impact_validateInput_37.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n                <td>\r\n\t\t\t\t ");
              if (_jspx_meth_impact_validateDisplayOnlyField_6(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n                <a href=\"javascript:submitResourceID('");
              out.print(cpsinvcncln10dog01.getUlIdResource());
              out.write("', '");
              out.print(cpsinvcncln10dog01.getUlIdHomeStage());
              out.write("')\" tabIndex='");
              out.print(tabIndex++);
              out.write("'>\r\n                ");
              out.print(FormattingHelper.formatInt(cpsinvcncln10dog01.getUlIdResource()));
              out.write("                 \r\n                </a>\r\n\t\t\t   </td>\r\n\t\t\t\t\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\t\t\t\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_38.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmIncmgFacilAffiliated()));
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setName("txtSzNmIncmgFacilAffiliated");
              _jspx_th_impact_validateInput_38.setLabel("Affiliated");
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setSize("40");
              _jspx_th_impact_validateInput_38.setMaxLength("40");
              _jspx_th_impact_validateInput_38.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_4.setColspan("2");
              _jspx_th_impact_validateSelect_4.setLabel("Operated By");
              _jspx_th_impact_validateSelect_4.setName("selSzCdIncFacilOperBy");
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_4.setCodesTable(CodesTables.CERTIFBY);
              _jspx_th_impact_validateSelect_4.setBlankValue("true");
              _jspx_th_impact_validateSelect_4.setValue(cpsinvcncln10dog01.getSzCdIncFacilOperBy());
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
//Set up the exclude array.
                   ArrayList<String> excludeOptions = new ArrayList<String>(); 
                   if(!CodesTables.CFACTYP4_CP.equals(cpsinvcncln10dog01.getSzCdIncmgFacilType())){
                     excludeOptions.add(CodesTables.CFACTYP4_CP);
                   }
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setLabel("Provider Type");
              _jspx_th_impact_validateSelect_5.setName("selSzCdIncmgFacilType");
              _jspx_th_impact_validateSelect_5.setCodesTable("CFACTYP4");
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setBlankValue("true");
              _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getSzCdIncmgFacilType()));
              _jspx_th_impact_validateSelect_5.setStyle("WIDTH: 200px");
              _jspx_th_impact_validateSelect_5.setExcludeOptions(excludeOptions);
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_39.setColspan("2");
              _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_39.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmIncmgFacilSuprtdant()));
              _jspx_th_impact_validateInput_39.setType("text");
              _jspx_th_impact_validateInput_39.setName("txtSzNmIncmgFacilSuprtdant");
              _jspx_th_impact_validateInput_39.setLabel("Contact Person");
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setSize("40");
              _jspx_th_impact_validateInput_39.setMaxLength("40");
              _jspx_th_impact_validateInput_39.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Address\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");

					  /* BEGIN Address Submodule */
					
              out.write("\r\n\t\t\t\t\t");

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
					
              out.write("\r\n\t\t\t\t\t");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_40.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_40.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_40.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_40.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_40.setLabel("Street");
              _jspx_th_impact_validateInput_40.setWidth("45%");
              _jspx_th_impact_validateInput_40.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setConstraint("Address");
              _jspx_th_impact_validateInput_40.setSize("50");
              _jspx_th_impact_validateInput_40.setMaxLength("30");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_41.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_41.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_41.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_41.setType("text");
              _jspx_th_impact_validateInput_41.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_41.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setConstraint("Address");
              _jspx_th_impact_validateInput_41.setSize("50");
              _jspx_th_impact_validateInput_41.setMaxLength("30");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_42.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_42.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_42.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_42.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_42.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_42.setLabel("City");
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setConstraint("City");
              _jspx_th_impact_validateInput_42.setMaxLength("20");
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_6.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_6.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_6.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_6.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_6.setOnChange( onChange );
              _jspx_th_impact_validateSelect_6.setLabel("State");
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_43.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_43.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_43.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_43.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_43.setType("text");
              _jspx_th_impact_validateInput_43.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_43.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_43.setLabel("Zip");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setConstraint("Zip");
              _jspx_th_impact_validateInput_43.setMaxLength("5");
              _jspx_th_impact_validateInput_43.setSize("5");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_44.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_44.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_44.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_44.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_44.setMaxLength("4");
              _jspx_th_impact_validateInput_44.setSize("4");
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_7.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_7.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_7.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_7.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_7.setBlankValue("true");
              _jspx_th_impact_validateSelect_7.setLabel("County");
              _jspx_th_impact_validateSelect_7.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_7.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_7.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_1.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_1.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_1.setCols("125");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_2.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_2.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_2.setAction("#");
              _jspx_th_impact_ButtonTag_2.setFunction(onclick);
              _jspx_th_impact_ButtonTag_2.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_2.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_2.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_45(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_46(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_47.setType("hidden");
              _jspx_th_impact_validateInput_47.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_47.setValue("true");
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_48.setType("hidden");
              _jspx_th_impact_validateInput_48.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_48.setValue("true");
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_49.setType("hidden");
              _jspx_th_impact_validateInput_49.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_49.setValue("");
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_50.setType("hidden");
              _jspx_th_impact_validateInput_50.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_50.setValue("");
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write("\r\n\t\t\t\t\t");

					  tabIndex = facilityAddressSubDB.getTabIndex();
					          AddressSubDB.removeFromRequest(request);
					
              out.write("\r\n\t\t\t\t\t");

					  /* END Address Submodule */
					
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Phone\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_51.setValue(FormattingHelper.formatPhone(cpsinvcncln10dog01.getSzNbrIncmgFacilPhone()));
              _jspx_th_impact_validateInput_51.setType("text");
              _jspx_th_impact_validateInput_51.setName("txtSzNbrIncmgFacilPhone");
              _jspx_th_impact_validateInput_51.setLabel("Phone");
              _jspx_th_impact_validateInput_51.setCssClass("formInput");
              _jspx_th_impact_validateInput_51.setSize("14");
              _jspx_th_impact_validateInput_51.setMaxLength("14");
              _jspx_th_impact_validateInput_51.setConstraint("Phone");
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_52.setColspan("2");
              _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_52.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getSzNbrIncmgFacilPhoneExt()));
              _jspx_th_impact_validateInput_52.setType("text");
              _jspx_th_impact_validateInput_52.setName("txtSzNbrIncmgFacilPhoneExt");
              _jspx_th_impact_validateInput_52.setLabel("Ext.");
              _jspx_th_impact_validateInput_52.setCssClass("formInput");
              _jspx_th_impact_validateInput_52.setSize("4");
              _jspx_th_impact_validateInput_52.setMaxLength("4");
              _jspx_th_impact_validateInput_52.setConstraint("PhoneExtension");
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tAdditional Details\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t");

							  String offGrounds = FormattingHelper.formatString(cpsinvcncln10dog01.getBIndIncmgOnGrnds());
							
              out.write("\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_53.setLabel("Abuse Off Grounds");
              _jspx_th_impact_validateInput_53.setType("checkbox");
              _jspx_th_impact_validateInput_53.setChecked((("".equals(offGrounds)) || ("N".equals(offGrounds))) ? "false" : "true");
              _jspx_th_impact_validateInput_53.setValue("Y");
              _jspx_th_impact_validateInput_53.setName("cbxBIndIncmgOnGrnds");
              _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t");

							  String unsupervised = FormattingHelper.formatString(cpsinvcncln10dog01.getBIndIncmgFacilAbSupvd());
							
              out.write("\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_54.setLabel("Unsupervised");
              _jspx_th_impact_validateInput_54.setType("checkbox");
              _jspx_th_impact_validateInput_54.setChecked((("".equals(unsupervised)) || ("N".equals(unsupervised))) ? "false" : "true");
              _jspx_th_impact_validateInput_54.setValue("Y");
              _jspx_th_impact_validateInput_54.setName("cbxBIndIncmgFacilAbSupv");
              _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_55.setValue(FormattingHelper.formatString(cpsinvcncln10dog01.getSzNmUnitWard()));
              _jspx_th_impact_validateInput_55.setType("text");
              _jspx_th_impact_validateInput_55.setName("txtSzNmUnitWard");
              _jspx_th_impact_validateInput_55.setLabel("Unit/Ward");
              _jspx_th_impact_validateInput_55.setCssClass("formInput");
              _jspx_th_impact_validateInput_55.setSize("15");
              _jspx_th_impact_validateInput_55.setMaxLength("15");
              _jspx_th_impact_validateInput_55.setConstraint("Any15");
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\tSpecial Instructions (Hrs. of Op., Pop. served, Etc.)\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_2.setName("txtSzTxtFacilCmnts");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setCols("65");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(cpsinvcncln10dog01.getSzTxtFacilCmnts()));
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\t\t\t\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   <br>\r\n   <table width=\"100%\" class=\"tableborder\" cellspacing=\"0\" cellpadding=\"3\"\r\n    border=\"0\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Supervisor Override\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setType("text");
          _jspx_th_impact_validateDate_5.setName("txtDtOverride");
          _jspx_th_impact_validateDate_5.setLabel("Date");
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          _jspx_th_impact_validateDate_5.setSize("10");
          _jspx_th_impact_validateDate_5.setDisabled(sDisableOverrideDropDwn);
          _jspx_th_impact_validateDate_5.setValue(txtDtOverride);
          _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setName("selSzCdOverrideOverllFind");
          _jspx_th_impact_validateSelect_8.setLabel("Supervisor Overall Finding");
          _jspx_th_impact_validateSelect_8.setCodesTable(CodesTables.CCRSKFND);
          _jspx_th_impact_validateSelect_8.setValue(txtSzCdOverrideRiskFinding == null ? "" : txtSzCdOverrideRiskFinding);
          _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_8.setDisabled(sDisableOverrideDropDwn);
          _jspx_th_impact_validateSelect_8.setOnChange("enableOverrideRiskLvl()");
          _jspx_th_impact_validateSelect_8.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_8.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setName("selSzCdOverrideRiskLvl");
          _jspx_th_impact_validateSelect_9.setLabel("Level Of Risk");
          _jspx_th_impact_validateSelect_9.setOptions(levelOfRiskDisplay);
          _jspx_th_impact_validateSelect_9.setValue(txtSzCdOverrideLvlOfRisk);
          _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_9.setDisabled(sDisableOverrideDropDwn);
          _jspx_th_impact_validateSelect_9.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_9.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtSzTxtOverrideComments");
          _jspx_th_impact_validateTextArea_3.setLabel("Comments");
          _jspx_th_impact_validateTextArea_3.setRows("3");
          _jspx_th_impact_validateTextArea_3.setCols("80");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setMaxLength(300);
          _jspx_th_impact_validateTextArea_3.setDisabled(sDisableOverrideDropDwn);
          _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(txtOverrideComment));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_56.setType("hidden");
          _jspx_th_impact_validateInput_56.setName("txtUlIdStage");
          _jspx_th_impact_validateInput_56.setValue(txtUlIdStage);
          int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
          if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setType("hidden");
          _jspx_th_impact_validateInput_57.setName("txtUlIdEvent");
          _jspx_th_impact_validateInput_57.setValue(txtUlIdEvent);
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setType("hidden");
          _jspx_th_impact_validateInput_58.setName("txtUlIdCase");
          _jspx_th_impact_validateInput_58.setValue(txtUlIdCase);
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setType("hidden");
          _jspx_th_impact_validateInput_59.setName("ulRowQty");
          _jspx_th_impact_validateInput_59.setValue(String.valueOf(ulRowQty));
          int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
          if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setType("hidden");
          _jspx_th_impact_validateInput_60.setName("bIndChkd");
          _jspx_th_impact_validateInput_60.setValue(bIndChkd);
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("hidden");
          _jspx_th_impact_validateInput_61.setName("hdnBIndPrnUk");
          _jspx_th_impact_validateInput_61.setValue(bIndPrnUk);
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_62.setType("hidden");
          _jspx_th_impact_validateInput_62.setName("hdnIndUnSubMIC");
          _jspx_th_impact_validateInput_62.setValue(indUnSubMIC);
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setType("hidden");
          _jspx_th_impact_validateInput_63.setName("txtSzCdRiskAssmtRiskFind");
          _jspx_th_impact_validateInput_63.setValue(txtSzCdRiskAssmtRiskFind);
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setType("hidden");
          _jspx_th_impact_validateInput_64.setName("txtCdCpsOverallDisptn");
          _jspx_th_impact_validateInput_64.setValue(txtCdCpsOverallDisptn);
          int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
          if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_65.setType("hidden");
          _jspx_th_impact_validateInput_65.setName("hdnUnknownIfMmberErrorMessage");
          _jspx_th_impact_validateInput_65.setValue(unknownIfMmberHshldErrorMessage);
          int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
          if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <!--SIR - 23536 -->\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_66.setType("hidden");
          _jspx_th_impact_validateInput_66.setName("txtDsplyAudioVideo");
          _jspx_th_impact_validateInput_66.setValue(dsplyAudioVideo.toString());
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");

              if (saveAndSubmit) {
        
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setFunction("return submitChecks(); ");
          _jspx_th_impact_ButtonTag_3.setForm("frmCPSInvCnclsn");
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/CPSInvCnclsn/saveSubmitCPSInvCnclsn");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

              }
              if (save) {
        
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setForm("frmCPSInvCnclsn");
          _jspx_th_impact_ButtonTag_4.setAction("/investigation/CPSInvCnclsn/saveCPSInvCnclsn");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

        }
        
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnNarrative.gif");
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setAccessKey("W");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("CpsConclusion");
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setName("CpsConclusion");
          _jspx_th_impact_document_0.setDocType("cpscnlsn");
          _jspx_th_impact_document_0.setDocExists( docExists);
          _jspx_th_impact_document_0.setProtectDocument( protectNarrative);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sCase");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table><script language=\"JavaScript\" type=\"text/javascript\">\r\n   enableCnclsnRiskLvl();\r\n   enableOverrideRiskLvl();\r\n</script>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_4.setName("rbFostPrntLab");
    _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Was the foster parent notified of the right to have an advocate present?");
    _jspx_th_impact_validateDisplayOnlyField_4.setConditionallyRequired("true");
    int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_5.setName("rbStOffNotifiedLab");
    _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Has notification been given to the state office of the removal of child(ren) following initial investigative contact?");
    _jspx_th_impact_validateDisplayOnlyField_5.setConditionallyRequired("true");
    int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_34(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_34.setType("hidden");
    _jspx_th_impact_validateInput_34.setName("hdnUlIdHomeStage");
    int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
    if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_35(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_35.setType("hidden");
    _jspx_th_impact_validateInput_35.setName("hdnUlIdHomeCase");
    int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
    if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateDisplayOnlyField_6.setName("dispResourceId");
    _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Resource ID");
    _jspx_th_impact_validateDisplayOnlyField_6.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_45(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_45.setType("hidden");
    _jspx_th_impact_validateInput_45.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_45.setValue("0");
    int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
    if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_46(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_46.setType("hidden");
    _jspx_th_impact_validateInput_46.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_46.setValue("0");
    int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
    if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
