<%//*  JSP Name:     Person Detail
      //*  Created by:   Anna N. Grimshaw
      //*  Date Created: 10/18/02
      //*
      //*   General:
      //*  ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
      //*  PersonDetail.jsp--Mobile FOR NECESSARY MOBILE CHANGES
      //*
      //*  Description:
      //*  This JSP will be used to maintain person information in the IMPACT system.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  4/17/03   GRIMSHAN          SIR 16839 Changed the condition for the hideMergeAdd
      //**                              boolean so that a person with the maintain person or merge
      //**                              person security attributes will see the add pushbutton
      //**                              whenever the page is in view mode.
      //**  04/28/03  GRIMSHAN          SIR 16995 Added Set D as an additional parameter for the
      //**                              disabled attribute of the reporter checkbox. This is so
      //**                              that when a user comes into the page and the stage is not
      //**                              INV the reporter checkbox will be disabled.
      //**  04/28/03  GRIMSHAN          SIR 16999 Added On Click event to Expand all and Collapse
      //**                              all so that Is Dirty will not be called when they are clicked
      //**  04/30/03  GRIMSHAN          SIR 17108 Changed the condition for hideMergeAdd boolean so that
      //**                              if a person had either maintain person or merge person security
      //**                              attributes they will see the add pushbutton at all times
      //**  04/30/03  GRIMSHAN          SIR 17247 removed erroneous debugging alert from add edu
      //**                              javascript function
      //**  05/22/03  GRIMSHAN          SIR 17607 If the person viewing is an employee (Sets.E) the options
      //**                              dropdown and search pushbutton will be disabled
      //**  06/02/03  GRIMSHAN          SIR 17937 Age is always disabled except in new mode, so make editable
      //**                              mode editable.new only
      //**  06/11/03  mcclaim           SIR 18082 - Rel/Int selector on validation error wasn't set properly
      //**  06/12/03  mcclaim           use hrefDirtyBypass=true instead of setIsDirtyCalled(true)
      //**                              as Jonathan instructed
      //**  07/09/03  GRIMSHAN          SIR 18762 - If the page is in view mode, use an input box to display
      //**                              the value of rel/int so the dyanmic population of a dropdown isn't affected
      //**  07/10/03  GRIMSHAN          SIR 18786 - Get the indicator for involvment in an event from state, as set
      //**                              by the convesation
      //**  07/24/03  GRIMSHAN          SIR 19068 - calculate the age based on dob when it is entered
      //**
      //**  08/12/03  Dickmanec         SIR 19420 Added the following reports; Child Death Committee
      //**                              Report and Initial Child Death Report.  The reports can only be
      //**                              viewed in IMPACT and the Report must have been created in CAPS.
      //**  08/13/03  GRIMSHAN          SIR 19451 switch .equals around so null pointer exceptions won't happen
      //**                              when checking for the child death docs.
      //**  08/13/03  GRIMSHAN          SIR 19420 display child death docs even if we are not in an inv stage
      //**                              or if the window is relate.
      //**  08/26/03  A.Corley          SIR 19522 If there is a validation error, set the value for reason for death
      //**                              after the page has finished loading
      //**  07/21/04  CORLEYAN          SIR 22890 - Moved Exclude views loop to the convesation since CINV04SOG02
      //**                              is now too long to be in state
      //**  02/28/05  Eric Dickman      SIR 23372 - Will not allow a user to generate form cfiv0400.htm
      //**                              if the case is merged.
      //**  07/21/05  CORLEYAN          SIR 23727 - New page set for Mobile, nothing should be modifiable, and only
      //**                              certain expandable sections will be displayed, this is Sets.F
      //**  07/25/05  floresrj          SIR 23727 Phase II implementation.  This module is the
      //**                              Mobile version of Impact's PersonDetail.jsp.  Created
      //**                              to support the expandable submodules DisplayAddresslist.jsp and PhoneSub.jsp.
      //**  08/02/05  pinkstba          SIR 23831 MPS Phase II.  Added check for "Sets.isInSet(Sets.F, request)" in the
      //**                              Additional Information section so that Category would show a value when appropriate.
      //**  08/17/05  mkw               SIR 23910 MPS Phase III. Added back Phone Submodule include as a prototype; this page
      //**                              is NOT done -- it sill needs to be made the same as the one in server IMPACT.
      //**  08/18/05  Todd Reser        SIR 23759 - Use new APS CINC2 and CRSRC2 Codes Tables when necessary
      //**  08/25/05  floresrj          SIR 23936 - Modified to reconcile both IMPACT and Mobile versions.
      //**                              The Mobile version of PhoneDetail.jsp  is scheduled to no longer be used
      //**                              in the future.  *** But until such notice, any changes to either
      //**                              version must be duplicated in the other PersonDetail.jsp file*****.
      //**
      //** 08/29/05   anandv            Added MOBILE-IMPACT comments at the General section.
      //**
      //** 09/26/05   malpans           SIR 24002 - Disaster Relief Indicator added on Person Detail Page.
      //** 03/08/07   nhegde            Changed label from 'Effective From' to 'Start Date' and 'Effective To'
      //**                              to 'End Date' in Income and resource Section.
      //** 09/11/08   arege             While testing for STGAP00004635 found that on Clicking
      //**                              multiple times on Save created duplicate Person records, Added 
      //**                              preventDoubleClick="true" to btnSave tag.
      //** 10/20/08   alwilliams        STAP00010495 - Changed training hours completed and training hours remaining to 
      //**                              a double. 
      //** 1/5/09	  charden		    STGAP00010157 - do not display add button for person merge/split if 
      //**                              the user does not have stage access
      //**06/24/2009  bgehlot           STGAP00014329: Added new checkbox Primary Caretaker Household Member
      //**07/30/2009  bgehlot           STGAP00014806: Show detail button to SAU Staff        
      //**09/02/2009  wjcochran         STGAP00015301: Update the label 'Resource Household Member'  to  
      //**                                             'Member of Resource's Household' and Update the label 
      //**                                             'Primary Caretaker Household Member' to 
      //**                                             'Member of Primary Caretaker's Household'
      //**09/30/2009  bgehlot           STGAP00015485: MR-056 added new section 'Caregiver/Parental Relationship Information for Child'
      //**02/08/2010  mxpatel           CAPTA: Added validations for CAPTA changes. Added new fields on the page
      //**06/04/2010  mxpatel           MR-066.1:  added code to capture and store SSN number when adding a new person. 
      //**06/10/2010  bgehlot           SMS 56827: Person Detail page saving now after getting Duplicate message 
      //**08/18/2010  bgehlot           SMS 66380 MR-072 Changes
      //**08/24/2011  schoi             STGAP00017013: MR-095 Added code for a new section 'Add Person to Active Stages'
      //**09/02/2011  hnguyen           STGAP00017011: MR-092 Added new Person Characteristics SSI related questions.
      //**09/13/2011  schoi             STGAP00017013: MR-095 Added code for a new section 'Add Person to Active Stages'
      //**                              to enable the pre-population and automation on the section                         
      //**09/15/2011  schoi             STGAP00017013: MR-095 Disabled the 'Add Person to Active Stages' section display  
      //**                              for person add mode when there is no other active stage where the person can be added
      //**09/23/2011  hnguyen           STGAP00017011: MR-092 Added logic to clear SSI related questions if person type is changed
      //**                              from PRN to COL and if DOB is changed making person 18 and over.
      //**10/18/2011  hnguyen           STGAP00017278: Update new SSI questions to be hardcoded in JSP due to issue with colon for impact tld.
      //**10/25/2011  hnguyen           STGAP00017375: Only display SSI questions for primary child only.
      //**

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES"%>  
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY"%>  
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY"%> 
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00_ARRAY"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation"%>
<%@ page import="java.util.List"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="java.util.Date"%>
<%String NO_NAME_STRING = "____________";

      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);

      //Get the output object from the request
      CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
      CCFC13SO ccfc13so = (CCFC13SO) state.getAttribute("CCFC13SO", request);
      CCFC29SO ccfc29so = (CCFC29SO) state.getAttribute("CCFC29SO", request);
      CCFC17SO ccfc17so = (CCFC17SO) state.getAttribute("CCFC17SO", request);
      CFAD32SO cfad32so = (CFAD32SO) state.getAttribute("CFAD32SO", request);
      CINV24SO cinv24so = (CINV24SO) state.getAttribute("CINV24SO", request);
      String uRel = (String) state.getAttribute("updateRelationship", request);

      List relationshipList = null;
      //STGAP00015485: Adding mothers and fathers list
      List motherRelationshipList = null;
      List fatherRelationshipList = null;
      
      CINV04SOGOO_ARRAY categoryArray = null;
      ROWCCFC13SOG00_ARRAY mergeArray = null;
      ROWCCFC29SOG00_ARRAY incomeArray = null;
      ROWCCFC17SOG00_ARRAY educationArray = null;
      CFAD32SOG00_ARRAY FAArray = null;

      Set excludeViews = (HashSet) request.getAttribute("excludeViews");
      List characteristics = (List) state.getAttribute(PersonDetailConversation.CHARACTERISTICS, request);
      if (characteristics == null) {
        characteristics = new ArrayList();
      }
      String bIndActiveStatus = StringHelper.EMPTY_STRING;
      String withdrawnDate = StringHelper.EMPTY_STRING;
      String bIndActiveEvent = (String) state.getAttribute("bIndActiveEvent", request);
      int loopCount = 0;
      
      // STGAP00010495 - Changed traning hours completed and training hours remaining to double
      double trngHrsCompleted = 0;
      double trngHrsRemain = 0;

      String szCdStage = GlobalData.getSzCdStage(request);
      String szCdStageProgram = GlobalData.getSzCdStageProgram(request);
      String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
      //SIR 22372
      Boolean mergeBoolean = CaseUtility.isStageMerged(GlobalData.getUlIdStage(request));
      boolean merge = mergeBoolean != null ? mergeBoolean : false;

      //Declare and initialize control variables for the page
      /* Assign tab-index */
      int tabIndex = 1;

      if (cinv04so == null) {
        cinv04so = new CINV04SO();
      }
      if (ccfc13so == null) {
        ccfc13so = new CCFC13SO();
      }
      if (ccfc29so == null) {
        ccfc29so = new CCFC29SO();
      }
      if (ccfc17so == null) {
        ccfc17so = new CCFC17SO();
      }
      if (cfad32so == null) {
        cfad32so = new CFAD32SO();
      }
      if (cinv24so == null) {
        cinv24so = new CINV24SO();
      }

      if (cinv04so.getCINV04SOGOO_ARRAY() == null) {
        categoryArray = new CINV04SOGOO_ARRAY();
      } else {
        categoryArray = cinv04so.getCINV04SOGOO_ARRAY();
      }
      
      // STGAP00017013: MR-095      
      // Get the Add Person to Active Stages object
  	  CINV04SO_ADD_PERSON_TO_STAGES_ARRAY addPersonToStagesArray;
      if (cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_ARRAY() != null) {
  		addPersonToStagesArray = cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
  	  } else {
  	    addPersonToStagesArray = new CINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
  	  }
  	  
  	  // Get the History recod of the Add Person to Active Stages object
  	  CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY addPersonToStagesHistoryArray;
  	  if (cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY() != null) {
  		addPersonToStagesHistoryArray = cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY();
  	  } else {
  		addPersonToStagesHistoryArray = new CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY();
  	  }
  	  // End STGAP00017013: MR-095  

      relationshipList = (List) state.getAttribute("relationshipList", request);
      
      //STGAP00015485: Added mothers and fathers list
      motherRelationshipList = (List) state.getAttribute("motherRelationshipList", request);
      fatherRelationshipList = (List) state.getAttribute("fatherRelationshipList", request);

      if (relationshipList == null) {
        relationshipList = new ArrayList();
      }
      
      if (motherRelationshipList == null) {
        motherRelationshipList = new ArrayList();
      }
      
      if (fatherRelationshipList == null) {
        fatherRelationshipList = new ArrayList();
      }
      if (ccfc13so.getROWCCFC13SOG00_ARRAY() == null) {
        mergeArray = new ROWCCFC13SOG00_ARRAY();
        bIndActiveStatus = StringHelper.EMPTY_STRING;
      } else {
        mergeArray = ccfc13so.getROWCCFC13SOG00_ARRAY();
        bIndActiveStatus = ccfc13so.getBIndActiveStatus();
      }
      if (ccfc29so.getROWCCFC29SOG00_ARRAY() == null) {
        incomeArray = new ROWCCFC29SOG00_ARRAY();
      } else {
        incomeArray = ccfc29so.getROWCCFC29SOG00_ARRAY();
      }
      if (ccfc17so.getROWCCFC17SOG00_ARRAY() == null) {
        educationArray = new ROWCCFC17SOG00_ARRAY();
      } else {
        educationArray = ccfc17so.getROWCCFC17SOG00_ARRAY();
      }
      if (cfad32so.getCFAD32SOG00_ARRAY() == null) {
        FAArray = new CFAD32SOG00_ARRAY();
      } else {
        FAArray = cfad32so.getCFAD32SOG00_ARRAY();
      }

      trngHrsCompleted = cfad32so.getTrngHrsCompleted();
      trngHrsRemain = cfad32so.getTrngHrsRemain();

      String personCategoryString = null;
      CINV04SOGOO categoryRow = null;
      Enumeration categoryEnumeration = categoryArray.enumerateCINV04SOGOO();

      if (categoryEnumeration.hasMoreElements()) {

        // Buffer the output from the loop through categoryEnumeration so that
        // we can strip the last ", " from it
        StringBuffer personCategorySB = new StringBuffer();
        while (categoryEnumeration.hasMoreElements()) {
          categoryRow = (CINV04SOGOO) categoryEnumeration.nextElement();
          String szCdCategoryCategoryCode = categoryRow.getSzCdCategoryCategory();
          String szCdCategoryCategoryDecode = Lookup.simpleDecodeSafe(CodesTables.CPSNDTCT, szCdCategoryCategoryCode);
          // If szCdCategoryCategory is null, then break from the loop; we're done
          if (szCdCategoryCategoryCode == null || StringHelper.EMPTY_STRING.equals(szCdCategoryCategoryDecode.trim())) {
            break;
          }
          if (szCdCategoryCategoryCode.equals(CodesTables.CPSNDTCT_CAS)
              && excludeViews.contains(CodesTables.CPERVIEW_VCL)) {
            excludeViews.remove(CodesTables.CPERVIEW_VCL);
          }
          // Append szCdCategoryCategory and a ", " to the StringBuffer
          personCategorySB.append(szCdCategoryCategoryDecode).append(", ");
          loopCount++;

        }

        personCategoryString = personCategorySB.substring(0,
                                                          personCategorySB.length() > 1 ? personCategorySB.length() - 2
                                                                                       : 0);

      }
      /**
       *  Page Mode Logic
       *
       *   This page will be passed one of six page modes:
       *   1.  RELATE
       *   2.  NEW
       *   3.  MAINTAIN PERSON
       *   4.  MODIFY
       *   5.  VIEW (WINDOW_MODE_BROWSE, WINDOW_MODE_INQUIRE
       *   6.  EMPLOYEE
       *
       *   We will treat the five above page modes as follows:
       *   1.  VIEW - Will have the following sets:
       *       e.  EMPLOYEE
       *   2.  EDIT -- Will have the following sets:
       *       a.  RELATE
       *       b.  MAINTAIN_PERSON
       *       c.  MODIFY
       *   3.  NEW
       *   Page Modes 3, 4, and 5 from above will be considered submodes of the EDIT mode
       *   and handled by the disabledXXXX indicators below.
       */

      String pageModePassed = StringHelper.EMPTY_STRING;
      String overallPageMode = PageModeConstants.EDIT;
      String disableOtherRel = "false";

      // Whenever we set overall page mode, we also need to set PageMode so that
      // the submodules will recieve the correct modes
      if (PersonHelper.getPersonDetailPageMode(request) != null) {
        pageModePassed = PersonHelper.getPersonDetailPageMode(request);
        if (pageModePassed.equals(PageModeConstants.VIEW)) {
          overallPageMode = PageModeConstants.VIEW;
          disableOtherRel = "true";
        } else if (pageModePassed.equals(PageModeConstants.NEW)) {
          overallPageMode = PageModeConstants.NEW;
        } else {
          overallPageMode = PageModeConstants.EDIT;
        }

        PageMode.setPageMode(overallPageMode, request);
      }

      // If the Mode is Employee (the set is "e") we would like to not display some of the
      // information.  If the Mode is New, we need to get information from the request
      // that was sent to us from person search.  Otherwise, get all of the information
      // from the database as normal.
      int age = 0;
      org.exolab.castor.types.Date birth = new org.exolab.castor.types.Date();
      org.exolab.castor.types.Date dtAssigned = new org.exolab.castor.types.Date();
      org.exolab.castor.types.Date dtUnassigned = new org.exolab.castor.types.Date();
      String gender = StringHelper.EMPTY_STRING;
      String title = StringHelper.EMPTY_STRING;
      String first = StringHelper.EMPTY_STRING;
      String middle = StringHelper.EMPTY_STRING;
      String last = StringHelper.EMPTY_STRING;
      String suffix = StringHelper.EMPTY_STRING;
      String personChar = StringHelper.EMPTY_STRING;
      String language = StringHelper.EMPTY_STRING;
      String status = StringHelper.EMPTY_STRING;
      String marital = StringHelper.EMPTY_STRING;
      String maidenName = StringHelper.EMPTY_STRING;
      String DOD = StringHelper.EMPTY_STRING;
      String SSN = StringHelper.EMPTY_STRING;
      String occupation = StringHelper.EMPTY_STRING;
      String reasonDeath = StringHelper.EMPTY_STRING;
      String religion = StringHelper.EMPTY_STRING;
      String living = StringHelper.EMPTY_STRING;
      String type = StringHelper.EMPTY_STRING;
      String szCdStagePersRelInt = StringHelper.EMPTY_STRING;
      // STGAP00017013: MR-095
      String typeHistory = StringHelper.EMPTY_STRING;
      String szCdStagePersRelIntHistory = StringHelper.EMPTY_STRING;
      String szCheckedStage = StringHelper.EMPTY_STRING;
      // End STGAP00017013: MR-095
      String ulIdSecondaryCareGiver = StringHelper.EMPTY_STRING;
      String ulIdPutativeFather = StringHelper.EMPTY_STRING;
      String ulIdLegalFather = StringHelper.EMPTY_STRING;
      String ulIdBioFather = StringHelper.EMPTY_STRING;
      //STGAP00015485: Adding legal mother and biological mother
      String ulIdLegalMother = StringHelper.EMPTY_STRING;
      String ulIdBioMother = StringHelper.EMPTY_STRING;
      String disasterRlf = StringHelper.EMPTY_STRING;
      String szTxtOtherRelationshipsCmnts = StringHelper.EMPTY_STRING;
      String szCdCntryOfOrigin = StringHelper.EMPTY_STRING;
      String szCdImmigrationStatus = StringHelper.EMPTY_STRING;
      String szCProofCitizenship = StringHelper.EMPTY_STRING;
      String szTxtPercentHeritage = StringHelper.EMPTY_STRING;
      String szTxtTribalName = StringHelper.EMPTY_STRING;
      String szTxtTribalRegistryNumber = StringHelper.EMPTY_STRING;
      String indNonUSBorn = StringHelper.EMPTY_STRING;
      String indTribalMember = StringHelper.EMPTY_STRING;
      String indRegisteredWithTribe = StringHelper.EMPTY_STRING;
      String codesTable = StringHelper.EMPTY_STRING;
      
      String indLegalCustodian = StringHelper.EMPTY_STRING;
      String safetyRsrc = StringHelper.EMPTY_STRING;
      String indRsrcHouseholdMember = StringHelper.EMPTY_STRING;
      String indPaternityEstablished = StringHelper.EMPTY_STRING;
      String birthCity = StringHelper.EMPTY_STRING;
      String birthCounty = StringHelper.EMPTY_STRING;
      String dtEntryUS = StringHelper.EMPTY_STRING;
      String szCdPersonBirthState = StringHelper.EMPTY_STRING;
      String indVerified = StringHelper.EMPTY_STRING;
      String szCdSideOfFamily = StringHelper.EMPTY_STRING;
      String szCdMotherMarried = StringHelper.EMPTY_STRING;
      int lQtyPersonWeight = 0;
      int sQtyPersonHeightFeet = 0;
      int sQtyPersonHeightInches = 0;
      String szCdPersonEyeColor = StringHelper.EMPTY_STRING;
      String szCdPersonHairColor = StringHelper.EMPTY_STRING;
      String szCdPersonHighestEduc = StringHelper.EMPTY_STRING;
      String szTxtAddlCmnts = StringHelper.EMPTY_STRING;
      //STGAP00014329: Added new checkbox Primary Caretaker Household Member
      // Changing it to the dropdown
      String cdPKHouseholdMember = StringHelper.EMPTY_STRING;
      dtUnassigned = cinv04so.getDtDtLegRepUnassigned();
      dtAssigned = cinv04so.getDtDtLegRepAssigned();
      //RelInt is set dynamically, so initialize it to the actual value
      if (request.getParameter("selSzCdStagePersRelInt") == null) {
        szCdStagePersRelInt = FormattingHelper.formatString(cinv04so.getSzCdStagePersRelInt());
      }else{
        szCdStagePersRelInt = request.getParameter("selSzCdStagePersRelInt");
      }
      String inLaw = StringHelper.EMPTY_STRING;
      String role = StringHelper.EMPTY_STRING;
      String reporter = StringHelper.EMPTY_STRING;
      // MR-067: new field as placeholder for CM/ILC to store youth contact when out of FC
      // Field displays for everyone so retrieve request data here for all sets
      String szTxtEmail = StringHelper.EMPTY_STRING; 
      if (cinv04so != null) {
      	szTxtEmail = FormattingHelper.formatString(cinv04so.getSzTxtEmail());
      }
      

      if (Sets.isInSet(Sets.E, request)) {
        age = cinv04so.getLNbrPersonAge();

        birth = cinv04so.getDtDtPersonBirth();
        gender = cinv04so.getCCdPersonSex();
        disasterRlf = cinv04so.getSzCdDisasterRlf(); //SIR 24002
        first = cinv04so.getSzNmNameFirst();
        title = cinv04so.getSzCdTitle();
        middle = cinv04so.getSzNmNameMiddle();
        last = cinv04so.getSzNmNameLast();
        suffix = cinv04so.getSzCdNameSuffix();
        personChar = cinv04so.getBCdPersonChar();
        language = StringHelper.EMPTY_STRING;
        marital = StringHelper.EMPTY_STRING;
        maidenName = StringHelper.EMPTY_STRING;
        DOD = StringHelper.EMPTY_STRING;
        SSN = StringHelper.EMPTY_STRING;
        occupation = StringHelper.EMPTY_STRING;
        reasonDeath = StringHelper.EMPTY_STRING;
        religion = StringHelper.EMPTY_STRING;
        living = StringHelper.EMPTY_STRING;
        szCdCntryOfOrigin = StringHelper.EMPTY_STRING;
        indNonUSBorn = StringHelper.EMPTY_STRING;
        type = StringHelper.EMPTY_STRING;
        szCdStagePersRelInt = StringHelper.EMPTY_STRING;
        
        // STGAP00017013: MR-095
        typeHistory = StringHelper.EMPTY_STRING;
        szCdStagePersRelIntHistory = StringHelper.EMPTY_STRING;
        szCheckedStage = StringHelper.EMPTY_STRING;
        // End STGAP00017013: MR-095
         
        ulIdSecondaryCareGiver = String.valueOf(cinv04so.getUlIdSecondaryCareGiver());
        ulIdPutativeFather = String.valueOf(cinv04so.getUlIdPutativeFather());
        ulIdLegalFather = String.valueOf(cinv04so.getUlIdLegalFather());
        ulIdBioFather = String.valueOf(cinv04so.getUlIdBioFather());
        //STGAP00015485
        ulIdLegalMother = String.valueOf(cinv04so.getUlIdLegalMother());
        ulIdBioMother = String.valueOf(cinv04so.getUlIdBioMother());
        szTxtOtherRelationshipsCmnts = cinv04so.getSzTxtOtherRelationshipsCmnts();
        szTxtPercentHeritage = cinv04so.getSzTxtPercentHeritage();
        szTxtTribalName = cinv04so.getSzTxtTribalName();
        szTxtTribalRegistryNumber = cinv04so.getSzTxtTribalRegistryNumber();
        indTribalMember = cinv04so.getBScrIndTribalMember();
        indRegisteredWithTribe = cinv04so.getBScrIndRegisteredWithTribe();
        inLaw = StringHelper.EMPTY_STRING;
        role = StringHelper.EMPTY_STRING;
        reporter = StringHelper.EMPTY_STRING;
        indLegalCustodian = StringHelper.EMPTY_STRING;
        safetyRsrc = StringHelper.EMPTY_STRING;
        indRsrcHouseholdMember = StringHelper.EMPTY_STRING;
        indPaternityEstablished = StringHelper.EMPTY_STRING;
        birthCity = StringHelper.EMPTY_STRING;
        birthCounty = StringHelper.EMPTY_STRING;
        dtEntryUS = StringHelper.EMPTY_STRING;
        szCdPersonBirthState = StringHelper.EMPTY_STRING;
        indVerified = StringHelper.EMPTY_STRING;
        szCdSideOfFamily = StringHelper.EMPTY_STRING;
        szCdMotherMarried = StringHelper.EMPTY_STRING;
        lQtyPersonWeight = 0;
        sQtyPersonHeightFeet = 0;
        sQtyPersonHeightInches = 0;
        szCdPersonEyeColor = StringHelper.EMPTY_STRING;
        szCdPersonHairColor = StringHelper.EMPTY_STRING;
        szCdPersonHighestEduc = StringHelper.EMPTY_STRING;
        szTxtAddlCmnts = cinv04so.getSzTxtAddlCmnts();
        //STGAP00014329
        cdPKHouseholdMember = StringHelper.EMPTY_STRING;

      } else if (overallPageMode.equals(PageModeConstants.NEW)) {
        if (request.getAttribute("txtlNbrPersonAge") != null) {
          age = Integer.parseInt(request.getParameter("txtlNbrPersonAge"));
        } else {
          age = 0;
        }
        birth = DateHelper.toCastorDateSafe(request.getParameter("txtDtDtPersonBirth"));
        gender = request.getParameter("cCdPersonSex");
        disasterRlf = request.getParameter("szCdDisasterRlf"); //SIR 24002
        title = request.getParameter("szCdTitle");
        first = request.getParameter("txtSzNmNameFirst");
        middle = request.getParameter("txtSzNmNameMiddle");
        last = request.getParameter("txtSzNmNameLast");
        suffix = request.getParameter("szCdNameSuffix");
        szTxtOtherRelationshipsCmnts = request.getParameter("szTxtOtherRelationshipsCmnts");
        szTxtPercentHeritage = request.getParameter("szTxtPercentHeritage");
        szTxtTribalName = request.getParameter("szTxtTribalName");
        szTxtTribalRegistryNumber = request.getParameter("szTxtTribalRegistryNumber");

        if (request.getAttribute("szTxtWeight") != null) {
          lQtyPersonWeight = Integer.parseInt(request.getParameter("szTxtWeight"));
        } else {
          lQtyPersonWeight = 0;
        }

        if (request.getAttribute("szTxtHeightFt") != null) {
          sQtyPersonHeightFeet = Integer.parseInt(request.getParameter("szTxtHeightFt"));
        } else {
          sQtyPersonHeightFeet = 0;
        }

        if (request.getAttribute("szTxtHeightIn") != null) {
          sQtyPersonHeightInches = Integer.parseInt(request.getParameter("szTxtHeightIn"));
        } else {
          sQtyPersonHeightInches = 0;
        }

        // Set Person Char to none selected, since none have been chosen yet
        personChar = "0";
        // Default Language to English
        language = "EN";
        // Status for a new person will be active
        status = "A";
        if (request.getParameter("selSzCdPersonMaritalStatus") != null) {
          marital = request.getParameter("selSzCdPersonMaritalStatus");
        }
        if (request.getParameter("txtSzTxtMaidenName") != null) {
          maidenName = request.getParameter("txtSzTxtMaidenName");
        }
        if (request.getParameter("txtDateDtPersonDeath") != null) {
          DOD = request.getParameter("txtDateDtPersonDeath");
        }
         if (request.getParameter("txtSzNbrPersonSSNNumber") != null) {
          SSN = request.getParameter("txtSzNbrPersonSSNNumber");
        }
        if (request.getParameter("txtSzTxtOccupation") != null) {
          occupation = request.getParameter("txtSzTxtOccupation");
        }
        if (request.getParameter("selSzCdPersonDeath") != null) {
          reasonDeath = request.getParameter("selSzCdPersonDeath");
        }
        if (request.getParameter("selSzCdPersonReligion") != null) {
          religion = request.getParameter("selSzCdPersonReligion");
        }
        if (request.getParameter("selSzCdPersonLivArr") != null) {
          living = request.getParameter("selSzCdPersonLivArr");
        }

        if (request.getParameter("selSzSideOfFamily") != null) {
          szCdSideOfFamily = request.getParameter("selSzSideOfFamily");
        }

        if (request.getParameter("selSzCdPersonEyeColor") != null) {
          szCdPersonEyeColor = request.getParameter("selSzCdPersonEyeColor");
        }
        if (request.getParameter("selSzCdPersonHairColor") != null) {
          szCdPersonHairColor = request.getParameter("selSzCdPersonHairColor");
        }
        if (request.getParameter("selSzCdPersonHighestEduc") != null) {
          szCdPersonHighestEduc = request.getParameter("selSzCdPersonHighestEduc");
        }
        if (request.getParameter("szTxtAddlCmnts") != null) {
          szTxtAddlCmnts = request.getParameter("szTxtAddlCmnts");
        }

        type = StringHelper.EMPTY_STRING;
        inLaw = StringHelper.EMPTY_STRING;
        
        // STGAP00017013: MR-095
        typeHistory = StringHelper.EMPTY_STRING;
        szCdStagePersRelIntHistory = StringHelper.EMPTY_STRING;
        szCheckedStage = StringHelper.EMPTY_STRING;
        // End STGAP00017013: MR-095
        
        // Default Role to no Role
        role = "NO";
        reporter = StringHelper.EMPTY_STRING;
        indLegalCustodian = StringHelper.EMPTY_STRING;
        safetyRsrc = StringHelper.EMPTY_STRING;
        indRsrcHouseholdMember = StringHelper.EMPTY_STRING;
        indPaternityEstablished = StringHelper.EMPTY_STRING;
        indVerified = StringHelper.EMPTY_STRING;
        //STGAP00014329
        cdPKHouseholdMember = StringHelper.EMPTY_STRING;

      } else if (Sets.isInSet(Sets.A, request)) {
        age = cinv04so.getLNbrPersonAge();
        birth = cinv04so.getDtDtPersonBirth();
        gender = cinv04so.getCCdPersonSex();
        disasterRlf = cinv04so.getSzCdDisasterRlf(); //SIR 24002
        title = cinv04so.getSzCdTitle();
        first = cinv04so.getSzNmNameFirst();
        middle = cinv04so.getSzNmNameMiddle();
        last = cinv04so.getSzNmNameLast();
        suffix = cinv04so.getSzCdNameSuffix();
        personChar = cinv04so.getBCdPersonChar();
        language = cinv04so.getSzCdPersonLanguage();
        status = cinv04so.getCdPersonStatus();
        marital = cinv04so.getSzCdPersonMaritalStatus();
        maidenName = cinv04so.getSzTxtMaidenName();
        DOD = FormattingHelper.formatDate(cinv04so.getDtDtPersonDeath());
        SSN = FormattingHelper.formatSSN(cinv04so.getSzNbrPersonSSN());
        occupation = cinv04so.getSzTxtOccupation();
        reasonDeath = cinv04so.getSzCdPersonDeath();
        religion = cinv04so.getSzCdPersonReligion();
        living = cinv04so.getSzCdPersonLivArr();
        ulIdSecondaryCareGiver = String.valueOf(cinv04so.getUlIdSecondaryCareGiver());
        ulIdPutativeFather = String.valueOf(cinv04so.getUlIdPutativeFather());
        ulIdLegalFather = String.valueOf(cinv04so.getUlIdLegalFather());
        ulIdBioFather = String.valueOf(cinv04so.getUlIdBioFather());
        //STGAP00015485
        ulIdLegalMother = String.valueOf(cinv04so.getUlIdLegalMother());
        ulIdBioMother = String.valueOf(cinv04so.getUlIdBioMother());
        szTxtOtherRelationshipsCmnts = cinv04so.getSzTxtOtherRelationshipsCmnts();
        szTxtPercentHeritage = cinv04so.getSzTxtPercentHeritage();
        szTxtTribalName = cinv04so.getSzTxtTribalName();
        szTxtTribalRegistryNumber = cinv04so.getSzTxtTribalRegistryNumber();
        type = cinv04so.getSzCdStagePersType();
        inLaw = cinv04so.getBIndStagePersInLaw();
        indTribalMember = cinv04so.getBScrIndTribalMember();
        role = "NO";
        reporter = cinv04so.getBIndStagePersReporter();
        indLegalCustodian = cinv04so.getBIndLegalCust();
        safetyRsrc = cinv04so.getBIndSafetyRsrc();
        indRsrcHouseholdMember = cinv04so.getBIndRsrcHouseholdMember();
        indPaternityEstablished = cinv04so.getBIndPaternityEst();
        indVerified = cinv04so.getBIndVerified();
        indRegisteredWithTribe = cinv04so.getBScrIndRegisteredWithTribe();
        szCdSideOfFamily = cinv04so.getSzCdSideOfFamily();
        szCdMotherMarried = cinv04so.getSzCdMotherMarried();
        lQtyPersonWeight = cinv04so.getLQtyPersonWeight();
        sQtyPersonHeightFeet = cinv04so.getSQtyPersonHeightFeet();
        sQtyPersonHeightInches = cinv04so.getSQtyPersonHeightInches();
        szCdPersonEyeColor = cinv04so.getSzCdPersonEyeColor();
        szCdPersonHairColor = cinv04so.getSzCdPersonHairColor();
        szCdPersonHighestEduc = cinv04so.getSzCdPersonHighestEduc();
        szTxtAddlCmnts = cinv04so.getSzTxtAddlCmnts();
        //STGAP00014329
        cdPKHouseholdMember = cinv04so.getCdPKHouseholdMember();
      } else {
        age = cinv04so.getLNbrPersonAge();
        birth = cinv04so.getDtDtPersonBirth();
        gender = cinv04so.getCCdPersonSex();
        disasterRlf = cinv04so.getSzCdDisasterRlf(); //SIR 24002
        title = cinv04so.getSzCdTitle();
        first = cinv04so.getSzNmNameFirst();
        middle = cinv04so.getSzNmNameMiddle();
        last = cinv04so.getSzNmNameLast();
        suffix = cinv04so.getSzCdNameSuffix();
        personChar = cinv04so.getBCdPersonChar();
        language = cinv04so.getSzCdPersonLanguage();
        status = cinv04so.getCdPersonStatus();
        marital = cinv04so.getSzCdPersonMaritalStatus();
        maidenName = cinv04so.getSzTxtMaidenName();
        DOD = FormattingHelper.formatDate(cinv04so.getDtDtPersonDeath());
        SSN = FormattingHelper.formatSSN(cinv04so.getSzNbrPersonSSN());
        occupation = cinv04so.getSzTxtOccupation();
        reasonDeath = cinv04so.getSzCdPersonDeath();
        religion = cinv04so.getSzCdPersonReligion();
        living = cinv04so.getSzCdPersonLivArr();
        ulIdSecondaryCareGiver = String.valueOf(cinv04so.getUlIdSecondaryCareGiver());
        ulIdPutativeFather = String.valueOf(cinv04so.getUlIdPutativeFather());
        ulIdLegalFather = String.valueOf(cinv04so.getUlIdLegalFather());
        ulIdBioFather = String.valueOf(cinv04so.getUlIdBioFather());
        //STGAP00015485
        ulIdLegalMother = String.valueOf(cinv04so.getUlIdLegalMother());
        ulIdBioMother = String.valueOf(cinv04so.getUlIdBioMother());
        szTxtOtherRelationshipsCmnts = cinv04so.getSzTxtOtherRelationshipsCmnts();
        szTxtPercentHeritage = cinv04so.getSzTxtPercentHeritage();
        szTxtTribalName = cinv04so.getSzTxtTribalName();
        szTxtTribalRegistryNumber = cinv04so.getSzTxtTribalRegistryNumber();
        type = cinv04so.getSzCdStagePersType();
        inLaw = cinv04so.getBIndStagePersInLaw();
        role = cinv04so.getSzCdStagePersRole();
        reporter = cinv04so.getBIndStagePersReporter();
        indLegalCustodian = cinv04so.getBIndLegalCust();
        safetyRsrc = cinv04so.getBIndSafetyRsrc();
        indRsrcHouseholdMember = cinv04so.getBIndRsrcHouseholdMember();
        indPaternityEstablished = cinv04so.getBIndPaternityEst();
        indTribalMember = cinv04so.getBScrIndTribalMember();
        indRegisteredWithTribe = cinv04so.getBScrIndRegisteredWithTribe();
        indVerified = cinv04so.getBIndVerified();
        szCdSideOfFamily = cinv04so.getSzCdSideOfFamily();
        szCdMotherMarried = cinv04so.getSzCdMotherMarried();
        lQtyPersonWeight = cinv04so.getLQtyPersonWeight();
        sQtyPersonHeightFeet = cinv04so.getSQtyPersonHeightFeet();
        sQtyPersonHeightInches = cinv04so.getSQtyPersonHeightInches();
        szCdPersonEyeColor = cinv04so.getSzCdPersonEyeColor();
        szCdPersonHairColor = cinv04so.getSzCdPersonHairColor();
        szCdPersonHighestEduc = cinv04so.getSzCdPersonHighestEduc();
        szTxtAddlCmnts = cinv04so.getSzTxtAddlCmnts();
         //STGAP00014329
        cdPKHouseholdMember = cinv04so.getCdPKHouseholdMember();
      }
	  
      // if birthdate is not null, get age from birthdate
      if (birth != null) {
        age = DateHelper.getAge(birth);
      }

      //**
      // * Add Person Merge Logic
      // *
      // * If The page was is in View mode and if the user has SEC_MERGE_PERSON
      // * or SEC_MNTN_PERSON security attributes, set a flag to display the
      // * Person Merge Add push button.
      // *
      // * If the page was accessed in Modify Mode and the person is a primary worker
      // * or in the Primary Hierarchy, Display the Person Merge Add Push Button
      // * otherwise, hide it.
      // *
      // * SIR 16839 GRIMSHAN -- changed the logic to check for view mode instead of person search
      // *           for persons with sec_merge_person or sec_mntn_person security attibute
      // * SIR 17108 GRIMSHAN -- removed view condition, if the person has Merge Person or mntn person
      // *           security attributes the add pushbutton will display for person merge at all times
      //**

      String hideMergeAdd = ArchitectureConstants.TRUE;
      String hideFAFlag = ArchitectureConstants.TRUE;

      //STGAP00010157 - add code to check if user has stage access so that user will not be able to add/modify  
      //person merge/split if they do not have access to the stage
      if ((user.hasRight(UserProfile.SEC_MERGE_PERSON) || user.hasRight(UserProfile.SEC_MNTN_PERSON)) && GlobalData.hasStageAccess(request)) {
        hideMergeAdd = ArchitectureConstants.FALSE;
      }

      else //Hide Merge Add button
      {
        hideMergeAdd = ArchitectureConstants.TRUE;
      }
      //Logic for FA Home Member Training submodule
      //if( !(user.hasRight(UserProfile.SEC_MNTN_RSRC)) || (overallPageMode.equals(PageModeConstants.VIEW)) ){
      //  hideFAFlag = ArchitectureConstants.TRUE;

      //}else if(user.hasRight(UserProfile.SEC_MNTN_RSRC) || overallPageMode.equals(PageModeConstants.NEW) ) {
      //  hideFAFlag = ArchitectureConstants.FALSE;

      //}

      // STGAP00002734 - Not having Maintain Resource should not prevent user from adding FA Home Member Training
      // Left the original code commented out since it might serve as reference for the Merge sub
      hideFAFlag = overallPageMode.equals(PageModeConstants.VIEW) ? ArchitectureConstants.TRUE
                                                                 : ArchitectureConstants.FALSE;
      // end STGAP00002734
      //radio buttons for Tribal section (Tribal Member)
      String tribalMemberNo = ArchitectureConstants.TRUE;
      String tribalMemberYes = ArchitectureConstants.FALSE;
      String tribalMemberUnknown = ArchitectureConstants.FALSE;

      if (indTribalMember != null) {
        if (ArchitectureConstants.Y.equals(indTribalMember)) {
          tribalMemberNo = ArchitectureConstants.FALSE;
          tribalMemberYes = ArchitectureConstants.TRUE;
          tribalMemberUnknown = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.N.equals(indTribalMember)) {
          tribalMemberNo = ArchitectureConstants.TRUE;
          tribalMemberYes = ArchitectureConstants.FALSE;
          tribalMemberUnknown = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.U.equals(indTribalMember)) {
          tribalMemberNo = ArchitectureConstants.FALSE;
          tribalMemberYes = ArchitectureConstants.FALSE;
          tribalMemberUnknown = ArchitectureConstants.TRUE;
        }
      }

      //radio buttons for Tribal section (Registered with Tribe)
      String registeredWithTribeNo = ArchitectureConstants.TRUE;
      String registeredWithTribeYes = ArchitectureConstants.FALSE;
      String registeredWithTribeUnknown = ArchitectureConstants.FALSE;

      if (indRegisteredWithTribe != null) {
        if (ArchitectureConstants.Y.equals(indRegisteredWithTribe)) {
          registeredWithTribeNo = ArchitectureConstants.FALSE;
          registeredWithTribeYes = ArchitectureConstants.TRUE;
          registeredWithTribeUnknown = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.N.equals(indRegisteredWithTribe)) {
          registeredWithTribeNo = ArchitectureConstants.TRUE;
          registeredWithTribeYes = ArchitectureConstants.FALSE;
          registeredWithTribeUnknown = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.U.equals(indRegisteredWithTribe)) {
          registeredWithTribeNo = ArchitectureConstants.FALSE;
          registeredWithTribeYes = ArchitectureConstants.FALSE;
          registeredWithTribeUnknown = ArchitectureConstants.TRUE;
        }
      }
      // Srividya - SIR 03249
      if (szTxtOtherRelationshipsCmnts == null)
        szTxtOtherRelationshipsCmnts = "";

      %>

<%// relate to STGAP00002756: the immediate fix for that defect is replacing simpleDecode with simpleDecodeSafe for DOD and RelInt
      if ("COL".equals(cinv04so.getSzCdStagePersType())) {
        codesTable = "CSRCRPTR";
      } else if ("PRN".equals(cinv04so.getSzCdStagePersType())) {
        codesTable = "CRELVICT";
      } else {
        // no change to whatever existing value; keep this else to make clear the intention that only set the codes table 
        // display for the 2 types collateral and principal
      }
      // end STGAP00002756
 %>


<%// Start Javascript Section %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

 //Start javascript funcitons here
  //Create javascript functions here for each action on the page
  //All form submits should use the submitValidateForm function to submit
  
window.attachEvent("onload", initializePage);

function initializePage(){
 updateRelInt();         
 checkForDuplicatePerson();
 enableSsiQuestions();
 enableRelDropdown();
 disableAddPerson();
}

/* 
** use CSRCRPTR for collaterals, CRELVICT for principals, no matter what the stage
*/
<impact:codeArray codeName="CSRCRPTR" arrayName="colOneCodes" blankValue="true" orderBy="decode"/>
<impact:codeArray codeName="CRELVICT" arrayName="prnOneCodes" blankValue="true" orderBy="decode"/>

// STGAP00017013: MR-095
/* 
** use CPRSNTYP for Type dropdown on the Add Person to Active Stages section
*/
<impact:codeArray codeName="CPRSNTYP" arrayName="typeCodes" blankValue="true" orderBy="decode"/>
// End STGAP00017013: MR-095

function updateRelInt()
{
 //Don't update the REL/INT (Relationship) if the calling page was
 //Person search and the mode is browse or maintain person
<% if(!(overallPageMode.equals(PageModeConstants.VIEW) ||
        Sets.isInSet(Sets.B, request) ||
        Sets.isInSet(Sets.E, request)))
  {
%>
   	if (frmPersonDetail.hdnSzCdStageProgram.value == 'CPS')
   	{
       if (frmPersonDetail.selSzCdStagePersType.options.value == 'COL')
       {
         populateDropdown( frmPersonDetail.selSzCdStagePersRelInt , frmPersonDetail.selSzCdStagePersRelInt.options.value, colOneCodes );
         var relationship = "<%= StringHelper.getNonNullString(szCdStagePersRelInt) %>";
         document.frmPersonDetail.selSzCdStagePersRelInt.value = relationship;
         //SMS 56827 MR-066
         if(relationship == ""|| relationship == null){
           frmPersonDetail.selSzCdStagePersRelInt.value = "<%=  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  %>";
         }
         // STGAP00017013: MR-095
         if (frmPersonDetail.selSzCdStagePersRelInt.options.value != null && frmPersonDetail.selSzCdStagePersRelInt.options.value != "")
         {
           for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
           {
             var checkboxName = eval("document.frmPersonDetail.cbxName_" + i);  
             var dropdownTypeAddPerson = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
             var dropdownRelAddPerson = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);
           
             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation
             if ((checkboxName.checked == false) 
             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == "")
             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == ""))
             {
               checkboxName.disabled = false;
               checkboxName.checked = false;
           
               clearDropdown(dropdownTypeAddPerson);
               dropdownTypeAddPerson.disabled = true; 
               clearDropdown(dropdownRelAddPerson);
               dropdownRelAddPerson.disabled = true;
             }
           } 
         }
         // End STGAP00017013: MR-095  
         
       }
       else if (frmPersonDetail.selSzCdStagePersType.options.value == 'PRN')
       {
         populateDropdown( frmPersonDetail.selSzCdStagePersRelInt , frmPersonDetail.selSzCdStagePersRelInt.options.value, prnOneCodes );
         var relationship = "<%= StringHelper.getNonNullString(szCdStagePersRelInt) %>";
         document.frmPersonDetail.selSzCdStagePersRelInt.value = relationship;
         //SMS 56827 MR-066
         if(relationship == ""|| relationship == null){
           frmPersonDetail.selSzCdStagePersRelInt.value = "<%=  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  %>";
         }
         // STGAP00017013: MR-095
         if (frmPersonDetail.selSzCdStagePersRelInt.options.value != null && frmPersonDetail.selSzCdStagePersRelInt.options.value != "")
         {
           for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
           {
             var checkboxName = eval("document.frmPersonDetail.cbxName_" + i);  
             var dropdownTypeAddPerson = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
             var dropdownRelAddPerson = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);
           
             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation
             if ((checkboxName.checked == false) 
             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == "")
             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == ""))
             {
               checkboxName.disabled = false;
               checkboxName.checked = false;
           
               clearDropdown(dropdownTypeAddPerson);
               dropdownTypeAddPerson.disabled = true; 
               clearDropdown(dropdownRelAddPerson);
               dropdownRelAddPerson.disabled = true;
             }
           } 
         }
         else
         {
         for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
           {
             var checkboxName = eval("document.frmPersonDetail.cbxName_" + i);  
             var dropdownTypeAddPerson = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
             var dropdownRelAddPerson = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);
           
             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation
             if ((checkboxName.checked == false) 
             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == "")
             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == ""))
             {
               checkboxName.disabled = true;
               checkboxName.checked = false;
           
               clearDropdown(dropdownTypeAddPerson);
               dropdownTypeAddPerson.disabled = true; 
               clearDropdown(dropdownRelAddPerson);
               dropdownRelAddPerson.disabled = true;
             }
           }
         }
         // End STGAP00017013: MR-095 
         
       }
       else
       {
         clearDropdown( frmPersonDetail.selSzCdStagePersRelInt );
         // STGAP00017013: MR-095
         for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
         {
           var checkboxName = eval("document.frmPersonDetail.cbxName_" + i);  
           var dropdownTypeAddPerson = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
           var dropdownRelAddPerson = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);
         
           checkboxName.disabled = true;
           checkboxName.checked = false;
           
           clearDropdown(dropdownTypeAddPerson);
           dropdownTypeAddPerson.disabled = true; 
           clearDropdown(dropdownRelAddPerson);
           dropdownRelAddPerson.disabled = true;       
         } 
         // End STGAP00017013: MR-095    
         
       }
    }
    else
    {
       clearDropdown( frmPersonDetail.selSzCdStagePersRelInt );
    }
<%
  }
%> 
}

// STGAP00017013: MR-095
function disableAddPerson()
{
  if (frmPersonDetail.selSzCdStagePersRelInt.options.value == null || frmPersonDetail.selSzCdStagePersRelInt.options.value == "")
  {
    for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
    {
      var checkboxName = eval("document.frmPersonDetail.cbxName_" + i);  
      var dropdownTypeAddPerson = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
      var dropdownRelAddPerson = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);
         
      checkboxName.disabled = true;
      checkboxName.checked = false;
           
      clearDropdown(dropdownTypeAddPerson);
      dropdownTypeAddPerson.disabled = true; 
      clearDropdown(dropdownRelAddPerson);
      dropdownRelAddPerson.disabled = true;       
    }
  }
  else
  {
    for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
    {
      var checkboxName = eval("document.frmPersonDetail.cbxName_" + i); 
      checkboxName.disabled = false;
    }
  }
}

function enableDropdowns()
{
  for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
  {
    var checkboxName1 = eval("document.frmPersonDetail.cbxName_" + i);  
    var dropdownTypeAddPerson1 = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);   
    var dropdownRelAddPerson1 = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);   

    var isChecked = checkboxName1.checked;
    var cdType = frmPersonDetail.selSzCdStagePersType.options.value;
    var cdRel = frmPersonDetail.selSzCdStagePersRelInt.options.value;
                
    if (isChecked) 
    {      
      if (cdType == 'COL')
      {
        if ((dropdownTypeAddPerson1.options.value == null || dropdownTypeAddPerson1.options.value == "")
           && (dropdownTypeAddPerson1.diabled == true || dropdownRelAddPerson1.disabled == true))
        { 
          dropdownTypeAddPerson1.disabled = false;
          dropdownRelAddPerson1.disabled = false;    
          populateDropdown(dropdownTypeAddPerson1, cdType, typeCodes);
          populateDropdown(dropdownRelAddPerson1 , cdRel, colOneCodes );
        }
      }
      else if (cdType == 'PRN')
      {
        if ((dropdownTypeAddPerson1.options.value == null || dropdownTypeAddPerson1.options.value == "")
           && (dropdownTypeAddPerson1.diabled == true || dropdownRelAddPerson1.disabled == true))
        { 
          dropdownTypeAddPerson1.disabled = false;
          dropdownRelAddPerson1.disabled = false;
          populateDropdown(dropdownTypeAddPerson1, cdType, typeCodes);     
          populateDropdown(dropdownRelAddPerson1 , cdRel, prnOneCodes );
        }  
      }            
    }       
    else 
    {   
      clearDropdown(dropdownTypeAddPerson1);
      dropdownTypeAddPerson1.disabled = true; 
      clearDropdown(dropdownRelAddPerson1);
      dropdownRelAddPerson1.disabled = true;          
    }
  } 
}

function enableRelDropdown()
{
  for (i = 1; i <= <%= addPersonToStagesArray.getUlRowQty() %> ; i++)    
  {  
    var dropdownTypeAddPerson1 = eval("document.frmPersonDetail.selSzCdStagePersTypeAddPerson_" + i);  
    var dropdownRelAddPerson1 = eval("document.frmPersonDetail.selSzCdStagePersRelIntHistory_" + i);  
    if ((dropdownTypeAddPerson1.options.value == 'COL') 
    && (dropdownRelAddPerson1.options.value == null || dropdownRelAddPerson1.options.value == ""))
    {      
      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, colOneCodes);
    } 
    else if ((dropdownTypeAddPerson1.options.value == 'PRN')
    && (dropdownRelAddPerson1.options.value == null || dropdownRelAddPerson1.options.value == ""))
    {
      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, prnOneCodes);
    }
    // This covers the dropdown change from PRN to COL
    else if (dropdownTypeAddPerson1.options.value == 'COL') 
    {      
      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, colOneCodes);
    } 
    // This covers the dropdown change from COL to PRN
    else if (dropdownTypeAddPerson1.options.value == 'PRN')
    {
      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, prnOneCodes);
    }
    else if (dropdownTypeAddPerson1.options.value != 'COL' && dropdownTypeAddPerson1.options.value != 'PRN')
    {
      clearDropdown(dropdownRelAddPerson1);
    }  
  } 
}
// End STGAP00017013: MR-095

// Check the value of DOD
<impact:codeArray codeName="CRSNFDTH" arrayName="reasonDeathCodes" blankValue="true"/>

// SIR 19068 onblur of the dob field calls this function to set the age field.
function getAge()
{
  calculateAge( frmPersonDetail.txtDateDtPersonBirth, frmPersonDetail.txtLNbrPersonAge );
}

function valueDOD()
{
  if ( frmPersonDetail.txtDateDtPersonDeath.value == "")
  {
    clearDropdown( frmPersonDetail.selSzCdPersonDeath );
  }
  else if ( frmPersonDetail.txtDateDtPersonDeath.value != "")
  {
    populateDropdown( frmPersonDetail.selSzCdPersonDeath , "", reasonDeathCodes );
  }
}

function setMergeParms( loopCount )
{
  frmPersonDetail.hdnMergeLoopCount.value = loopCount;
}

function setIncomeParms( tsIncomeLastUpdate, ulIdIncRsrc, loopCount )
{
  frmPersonDetail.hdnTsIncomeLastUpdate.value = tsIncomeLastUpdate;
  frmPersonDetail.hdnUlIdIncRsrc.value = ulIdIncRsrc;
  frmPersonDetail.hdnIncLoopCount.value = loopCount;
}

function setEduParms( tsEduLastUpdate, ulIdEdhist, loopCount )
{
  frmPersonDetail.hdnTsEduLastUpdate.value = tsEduLastUpdate;
  frmPersonDetail.hdnUlIdEdhist.value = ulIdEdhist;
  frmPersonDetail.hdnEduLoopCount.value = loopCount;
}

function setFAParms( tsFALastUpdate, ulIdIndivTraining, loopCount )
{
  frmPersonDetail.hdnTsFALastUpdate.value = tsFALastUpdate;
  frmPersonDetail.hdnUlIdIndivTraining.value = ulIdIndivTraining;
  frmPersonDetail.hdnFALoopCount.value = loopCount;
}

function deletePersonDetail()
{
  var bRetPerson = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_PERS_STAGE_DEL ) %>');
  return bRetPerson;
}

function cancelValidation ()
{
  disableValidation('frmPersonDetail');
}

function mergeEmployee()
{
  if (frmPersonDetail.hdnBIndActiveStatus.value == "Y")
  {
    var bMergePerson = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_MERGE_EMP_IN ) %>');
    return bMergePerson;
  }
  else
  {
    return true;
  }
}

//SIR 23372 - Will not allow a user to generate form cfiv0400.htm
//if the case is merged.
function mergeCase()
{
  var bLaunchcfiv0400 = <%= merge %>;

  if ( bLaunchcfiv0400 == true )
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_MERGE_STAGE_INV ) %>');
    return false;
  }
}

function deleteRow( rowCount, buttonGroupName)
{
  if (!isRadioChecked( rowCount, buttonGroupName) )
  {
    return false;
  }
  if (isPageChanged())
  {
    var bDelete = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEF_CONT ) %>');
    return bDelete;
  }
  else
  {
    var bRow = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
    return bRow;
  }
}

function addEdu()
{
  if (frmPersonDetail.hdnWithdrawnDate.value == "")
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_PREV_SCHOOL_DATE_GRADE ) %>');
    return false;
  }
  else
  {
    return true;
  }
}

//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}

// make sure that a radiobutton from button group is checked before delete.
function isRadioChecked(arrayLength, buttonGroupName)
{
  var bRadio = false;
  var listRb = document.getElementsByName(buttonGroupName);
  for ( i = 0; i < arrayLength ; i++ )
  {
    bRadio = listRb[i].checked;
    if ( bRadio )
    {
      break;
    }
  }
  if ( !bRadio )
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
  }
  return bRadio;
}

function verifyReport()
{
  var reportVal = document.Reports.report_CLEAN.value;
  if ( reportVal.indexOf( "civ15" ) != -1 || reportVal.indexOf( "civ33" ) != -1)
  {
    if (isFormChanged(frmPersonDetail))
    {
      alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_DATA_CHANGED)%>');
      return false;
    }
    else
    {
      return true;
    }
  }
  else
  {
    return true;
  }
}

//-- SIR STGAP00000695
//-- See Javascript call at bottom of page code for description.
function cleanDynamicSelects()
{
  CleanSelect(document.frmPersonDetail.selSzCSeCarGiver);
  CleanSelect(document.frmPersonDetail.selSzPutativeFather);
  CleanSelect(document.frmPersonDetail.selSzLegalFather);
  CleanSelect(document.frmPersonDetail.selSzBioFather);
  CleanSelect(document.frmPersonDetail.selSzLegalMother);
  CleanSelect(document.frmPersonDetail.selSzBioMother);
}

/*STGAP00015485: MR-056 Display the Caregiver/Parental Relationship Information for Child section for children under age 18 years*/
function displayRelInfoSection()
{
    var dob = document.frmPersonDetail.txtDateDtPersonBirth.value;
    age = getAgeFromDOB(dob);
    if(age >= 0 && age < 18){
       toggleVisibility('relInfoForChild', 'block');
    }else{
       toggleVisibility('relInfoForChild', 'none');
    }
}

function enableSsiQuestions()
{
    var bSsiAppSubmit = getSelectedRadioValue(document.frmPersonDetail.rbSsiAppSubmitted);

    if(bSsiAppSubmit != null && bSsiAppSubmit != "Y"){
      resetCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);
      disableCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);
    }else{
      enableCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);
    }

    var bSsiMedDsbltyReqMet = getSelectedRadioValue(document.frmPersonDetail.rbSsiMedDsbltyReqMet);

    if (bSsiMedDsbltyReqMet != null && bSsiMedDsbltyReqMet != "Y" ){
      resetCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);
      disableCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);
    }else{
      enableCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);
    }
    
    var bSsiRecipient = getSelectedRadioValue(document.frmPersonDetail.rbSsiRecipient);

    if (bSsiRecipient != null && bSsiRecipient != "Y" ){
      resetCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);
      disableCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);
    }else{
      enableCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);
    }
}

/*STGAP00015485: MR-056 Calculate the age of the person*/
function getAgeFromDOB(dobAsString){
    dob = new Date(Date.parse(dobAsString));
    today = new Date();

    dobDay = dob.getDate();
    dobMonth = dob.getMonth();
    dobYear = dob.getFullYear();

    todayDay = today.getDate();
    todayMonth = today.getMonth();
    todayYear = today.getFullYear();

    age = todayYear - dobYear;
    // If the child is not yet 1 year old
    // or the user has entered an invalid (future) date
    // return 0.
    if (age == 0) {
      if(( todayMonth < dobMonth ) ||
             ( ( dobMonth == todayMonth ) && ( todayDay < dobDay ) )){
       return -1;
      }else{
       return 0;
      }
    }else if(age < 0 ){
      return -1
    }
    
    // If the person has not had their bday yet, subtract a year.
    if (( todayMonth < dobMonth ) ||
             ( ( dobMonth == todayMonth ) && ( todayDay < dobDay ) )) {
      age = age - 1;
    }
    return age;
}

//SMS 56827 MR-066 check for Duplicate Person
function checkForDuplicatePerson(){
         var errorCode = '<%= (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") %>';
         if (errorCode == '<%= Messages.MSG_DUPLICATE_NOT_ALLOWED %>')
         {
              if (confirm( '<%=MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_NOT_ALLOWED)%>' )) {
                   document.frmPersonDetail.hdnBIndSsnCheck.value = 'N';
                   cancelValidation();
                   submitValidateForm('frmPersonDetail', '/person/PersonDetail/savePersonDetail');
              }else{
                document.frmPersonDetail.hdnBIndSsnCheck.value = 'Y';
              }
         }
}

//End Java Script
</script>

<impact:validateErrors />
<impact:validateForm name="frmPersonDetail" method="post"
  action="/person/PersonDetail/savePersonDetail"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
  <%/* Begin Detail */%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:expandAll()">Expand All</a>&nbsp;
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:collapseAll()">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="8">Person Name</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="First"
                              constraint="Name12"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              conditionallyRequired="true"
                              name="txtSzNmNameFirst"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(first)%>"
                              size="12"
                              maxLength="12"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text"
                              label="Middle"
                              constraint="Name12"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              name="txtSzNmNameMiddle"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(middle)%>"
                              size="12"
                              maxLength="12"
                              tabIndex="4"/></td>
    <td><impact:validateInput type="text"
                              label="Last"
                              constraint="Name22"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              conditionallyRequired="true"
                              name="txtSzNmNameLast"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(last)%>"
                              size="22"
                              maxLength="22"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateSelect label="Suffix"
                              name="selSzCdNameSuffix"
                              tabIndex="<%= tabIndex++ %>"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              codesTable="CSUFFIX2"
                              editableMode="<%= EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(suffix)%>"/></td>
  </tr>
 </table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="7">Demographics</th>
  </tr>
  <tr>
    <td><impact:validateSelect label="Gender"
                              name="selCdPersonSex"
                              required="true"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CSEX"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(gender)%>"/></td>
    <td><impact:validateSelect label="Marital"
                              name="selSzCdPersonMaritalStatus"
                              conditionallyRequired="true"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CMARSTAT"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW  %>"
                              value="<%=FormattingHelper.formatString(marital)%>"/></td>
  </tr>
    <tr>
    <td><impact:validateSelect label="Title"
                              name="selSzCdTitle"
                              required="<%= ArchitectureConstants.FALSE %>"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CTITLE"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(title)%>"/></td>
    <td><impact:validateInput type="text"
                              label="Maiden Name"
                              constraint="Paragraph"
                              name="txtSzTxtMaidenName"
                              size="20"
                              maxLength="20"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(maidenName)%>"/>
  </td>
  </tr>
  <tr>
    <td><impact:validateDate name="txtDateDtPersonBirth"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'; displayRelInfoSection();"
                              onBlur="getAge( );"
                              label="DOB"
                              constraint="Date"
                              conditionallyRequired="true"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatDate( birth )%>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:validateInput type="text"
                              label="Age"
                              constraint="Digit3Less"
                              name="txtLNbrPersonAge"
                              size="3"
                              maxLength="3"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.NEW + EditableMode.EDIT  %>"
                              value="<%=FormattingHelper.formatInt(age)%>"/>
        <impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(cinv04so.getBIndPersonDobApprox())%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndPersonDobApprox"
                              label="Approximate"
                              cssClass="formInput" />
    </td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Language"
                              name="selSzCdPersonLanguage"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CLANG"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(language)%>"/></td>
    <td><impact:validateSelect label="Living Arrangement"
                              name="selSzCdPersonLivArr"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              orderBy="decode"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CLIVARR"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(living)%>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="Occupation"
                              constraint="Paragraph"
                              name="txtSzTxtOccupation"
                              size="20"
                              maxLength="20"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(occupation)%>"/>
    </td>
    <td>
        <impact:validateSelect label="Religion"
                              name="selSzCdPersonReligion"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CRELIGNS"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%= FormattingHelper.formatString(religion)%>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateDate name="txtDateDtPersonDeath"
                              label="DOD"
                              constraint="Date"
                              onBlur="valueDOD()"
                              conditionallyRequired="true"
                              value="<%= DOD %>"
                              size="10"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" />
    </td>
    <%/* If the page is in View mode just display the value returned from the database */
      if (overallPageMode.equals(PageModeConstants.VIEW) || Sets.isInSet(Sets.E, request)) {
        /* if Reason For death is blank, print out a blank input field, otherwise, look up the decode */
        if (reasonDeath == null || StringHelper.EMPTY_STRING.equals(reasonDeath)) {

          %>
          <td><impact:validateInput type="text"
                              label="Reason For Death"
                              name="selSzCdPersonDeath"
                              size="20"
                              maxLength="20"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              value=""/>
          </td>
    <%} else {

          %>
          <td><impact:validateInput type="text"
                              label="Reason For Death"
                              name="selSzCdPersonDeath"
                              size="20"
                              maxLength="20"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              value='<%=  Lookup.simpleDecodeSafe( "CRSNFDTH", reasonDeath  ) %>'/>
          </td>
    <%}
      } else {

        %>
    <td><impact:validateSelect label="Reason For Death"
                              conditionallyRequired="true"
                              name="selSzCdPersonDeath"
                              style="WIDTH: 150px"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(reasonDeath)%>"/>
    </td>
    <%}

      %>
  </tr>
  
  <%// Display these Options dropdown only if we in ADD
      if ("A".equals(cReqFuncCd) || cReqFuncCd == null) {
%>
  <tr>
    <td><impact:validateInput type="text"
                              label="SSN"
                              constraint="SocialSecurityNumber"
                              name="txtSzNbrPersonSSNNumber"
                              size="11"
                              maxLength="11"
                              value="<%= SSN %>"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%=EditableMode.NEW %>"/>
    </td>
  </tr>
  
   <%
   }
%>
  <tr>
  	<td><impact:validateInput type="text"
                              label="Email"
                              constraint="Email"
                              name="txtSzTxtEmail"
                              size="50"
                              maxLength="70"
                              value="<%=szTxtEmail%>"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%=EditableMode.EDIT + EditableMode.NEW %>"/>
    </td>
  </tr>
  <tr>
    <td>Additional Comments:</td>    
    <td colspan="3">
      <impact:validateTextArea
          cols="80"
          rows="3"
          style="WIDTH: 300px"
          name="szTxtAddlCmnts"
          disabled=""
          tabIndex="<%=tabIndex++%>"
          maxLength="300"
          constraint="Comments">
          <%=szTxtAddlCmnts%>
      </impact:validateTextArea>
    </td>         
    <td>&nbsp;</td>
    <td>&nbsp;</td>    
    <td>&nbsp;</td>
  </tr>
 </table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
      <th colspan="8">Current Stage</th>
  </tr>
  <tr valign="top">
<%/* If we are in maintain person mode, don't make the rel/int and type required */
      String isRequired = ArchitectureConstants.TRUE;
      if (Sets.isInSet(Sets.B, request)) {
        isRequired = ArchitectureConstants.FALSE;
      } else {
        isRequired = ArchitectureConstants.TRUE;
      }
%>
    <td><impact:validateSelect label="Type"
                              name="selSzCdStagePersType"
                              required="<%=isRequired%>"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CPRSNTYP"
                              onChange="updateRelInt();"
                              disabled="<%= Sets.isInSetStr( Sets.B , request ) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(type)%>"/>
    </td>
    <td><impact:validateDisplayOnlyField name="dspSzCdStagePersRole"
                              label="Role"
                              value="<%=FormattingHelper.formatString(role)%>" /></td>

    <%if ("false".equals(uRel)) {
        if ("COL".equals(cinv04so.getSzCdStagePersType())) {
          codesTable = "CSRCRPTR";
        } else if ("PRN".equals(cinv04so.getSzCdStagePersType())) {
          codesTable = "CRELVICT";
        } 
      }
      // SIR 18762 If the page is in View mode just display the value returned from the database
      if (overallPageMode.equals(PageModeConstants.VIEW) || Sets.isInSet(Sets.E, request)) {
        /* if Reason For death is blank, print out a blank input field, otherwise, look up the decode */
        if (szCdStagePersRelInt == null || StringHelper.EMPTY_STRING.equals(szCdStagePersRelInt)) {

          %>
          <td><impact:validateInput type="text"
                              label="Relationship"
                              name="selSzCdStagePersRelInt"
                              size="20"
                              maxLength="20"
                              tabIndex="<%= tabIndex++ %>"
                              value=""/>                              
          </td>
    <%} else {

          %>    
          <td><impact:validateInput type="text"
                              label="Relationship"
                              name="selSzCdStagePersRelInt"
                              size="20"
                              maxLength="20"
                              tabIndex="<%= tabIndex++ %>"
                              value='<%=  Lookup.simpleDecodeSafe( codesTable, szCdStagePersRelInt  ) %>'/>                          
          </td>
    <%}
      } else {

        %>        
    <td><impact:validateSelect label="Relationship"
                              blankValue="true"
                              overrideDisplayBadCodes="true"
                              orderBy="decode"
                              codesTable="<%=codesTable%>"
                              onChange="disableAddPerson();"
                              required="<%=isRequired%>"
                              name="selSzCdStagePersRelInt"  
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled="<%= Sets.isInSetStr( Sets.B , request ) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=szCdStagePersRelInt%>"/>
      </td>
      <%}
      %>
     <%if(CodesTables.CSTAGES_INT.equals(szCdStage) || CodesTables.CSTAGES_INV.equals(szCdStage)
          || CodesTables.CSTAGES_DIV.equals(szCdStage) || CodesTables.CSTAGES_FPR.equals(szCdStage)
          || CodesTables.CSTAGES_ARI.equals(szCdStage)){ %>
     <td><impact:validateSelect label="Member of Primary Caretaker's Household"
                               name="selCdStagePersMbrPrimCareHhl"
                               required="<%=isRequired%>"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= Sets.isInSetStr( Sets.B , request ) %>"
                               codesTable="<%= CodesTables.CMBRPCHH %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               value="<%= cdPKHouseholdMember %>"/>
    </td>
    <%}else if(CodesTables.CSTAGES_SUB.equals(szCdStage) || CodesTables.CSTAGES_FSU.equals(szCdStage)){
       String caseName = "Member of " + GlobalData.getSzNmCase(request) + "'s Household";
    %>
    <td><impact:validateSelect label="<%=caseName%>"
                               name="selCdStagePersMbrPrimCareHhl"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= Sets.isInSetStr( Sets.B , request ) %>"
                               codesTable="<%= CodesTables.CMBRPCHH %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               value="<%= cdPKHouseholdMember %>"/>
    </td>
    <%} %>
  </tr>
  <tr>
  <td colspan="8">
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr valign="top">
    <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(reporter)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndStagePersReporter"
                              label="Reporter"
                              cssClass="formInput" />
    </td>     
    <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(indLegalCustodian)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndLegalCustodian"
                              label="Legal Custodian"
                              cssClass="formInput" />
    </td>    
    <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(safetyRsrc)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndSafetyResource"
                              label="Safety Resource"
                              cssClass="formInput"  />
    </td>
    <td colspan="2"><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(indRsrcHouseholdMember)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndRsrcHouseholdMember"
                              label="Member of Resource's Household"
                              cssClass="formInput" />
    </td>
    <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(indPaternityEstablished)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndPaternityEstablished"
                              label="Paternity Established"
                              cssClass="formInput" />
   </td>
   <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(indVerified)%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndVerified"
                              label="Verified"
                              cssClass="formInput" />
   </td>
  </tr>
  </table>
  </td>     
  </tr>
  
  <%// Display these Options dropdown only if we are in FCC or ADO stage
      if ("SUB".equals(szCdStage) || "ADO".equals(szCdStage)) {
%>
  <tr>
    <td><impact:validateDate name="txtDateDtLegRepAssigned"
                              label="Date Representation Assigned"
                              constraint="Date"
                              conditionallyRequired="true"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatDate( dtAssigned )%>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateDate name="txtDateDtLegRepUnassigned"
                              label="Date Unassigned"
                              constraint="Date"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatDate( dtUnassigned )%>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <%}
%>
  <tr>
<%// Display the Options dropdown only if we are not in new mode
      if (!(overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F, request))) {
%>
  <td><impact:validateSelect label="View Options"
                              colspan="6"
                              name="selOption_CLEAN"
                              style="WIDTH: 300px"
                              excludeOptions="<%=excludeViews%>"
                              disabled="<%= Sets.isInSetStr( Sets.E + Sets.F , request ) %>"
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CPERVIEW"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              value=""/>
  <impact:ButtonTag name="btnSearch"
                              img="btnSearch"
                              form="frmPersonDetail"
                              navAwayCk="true"
                              function="cancelValidation()"
                              action="/person/PersonDetail/displayEventCase"
                              disabled="<%= Sets.isInSetStr( Sets.E + Sets.F , request ) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              tabIndex="<%= tabIndex++ %>"/>
  </td>
<%}
%>
  </tr>
 </table>
 
  <!-- STGAP00017013: MR-095 Add Person to Active Stages section  -->
  <% 
    Enumeration addPersonToStagesHistoryArray2 = addPersonToStagesHistoryArray.enumerateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY();
    Enumeration addPersonToStagesArray2 = addPersonToStagesArray.enumerateCINV04SO_ADD_PERSON_TO_STAGES();
    
    // For open stages, the section displays if any row(s) in both arrays below exist or the page is in the New mode
    // For closed stages, the section displays if any row(s) in addPersonToStagesHistoryArray2 array below exist
    if (!"INT".equals(szCdStage) && !"ARI".equals(szCdStage) && !"FAD".equals(szCdStage) && !"PAD".equals(szCdStage)) {
      if ((((addPersonToStagesHistoryArray2.hasMoreElements() || addPersonToStagesArray2.hasMoreElements())
        && overallPageMode.equals(PageModeConstants.MODIFY) && !overallPageMode.equals(PageModeConstants.VIEW)) 
        || (overallPageMode.equals(PageModeConstants.NEW) && !addPersonToStagesHistoryArray2.hasMoreElements() 
        && addPersonToStagesArray2.hasMoreElements()))
        || ((addPersonToStagesHistoryArray2.hasMoreElements() || addPersonToStagesArray2.hasMoreElements())
        && (cinv04so.getDtDtStageClose() != null && !DateHelper.MAX_JAVA_DATE.equals(cinv04so.getDtDtStageClose())))) {
    %>
 	<impact:ExpandableSectionTag name="AddPerson"
		label="Add Person to Active Stages" tabIndex="<%=tabIndex++%>">
		<span><font color="#FF0000">(Before adding, carefully review the
			relationship for this person in each of the stages listed below.
			Modify the relationship, as necessary, to ensure accuracy.)</font></span>
		<table border="0" cellspacing="0" cellpadding="3" width="100%"
			class="tableBorder">
			<tr>
	            <th class="thList">&nbsp;</th>
	            <th class="thList">Stage ID</th>
	            <th class="thList">Stage Name</th>
	            <th class="thList">Stage</th>
	            <th class="thList">Type</th>
	            <th class="thList">Relationship</th>
	            <th class="thList">Date Added</th>
            </tr>			
            <%
			  loopCount = 0;
			  while (addPersonToStagesHistoryArray2.hasMoreElements()) {
			    CINV04SO_ADD_PERSON_TO_STAGES_HISTORY addPersonToStagesHistory = (CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) addPersonToStagesHistoryArray2
			                                                                                                                                          .nextElement();
			%>
			  <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">        				 
                <td>
                <impact:validateInput name="cbxHistoryDisabled" cssClass="formInput" 
                  type="checkbox" tabIndex="<%=tabIndex++%>" disabled="true" checked="true" />
			    </td>
                <td><%=addPersonToStagesHistory.getUlIdStage()%>
                </td>
                <td>
          		<NOBR><%=addPersonToStagesHistory.getSzNmStage()%>
          		</NOBR>
        		</td>
            	<td><%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, addPersonToStagesHistory.getSzCdStage())%>
        		</td>
        		<td><%=Lookup.simpleDecodeSafe(CodesTables.CPRSNTYP, addPersonToStagesHistory.getSzCdStagePersType())%>
        		</td>        				 
        		<% if ("PRN".equals(addPersonToStagesHistory.getSzCdStagePersType())) { %>
                   <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CRELVICT", addPersonToStagesHistory.getSzCdStagePersRelInt()) ) %></td>
                <% } else if ("COL".equals(addPersonToStagesHistory.getSzCdStagePersType())) { %>
                   <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CSRCRPTR", addPersonToStagesHistory.getSzCdStagePersRelInt()) ) %></td>
                <% } %>
        		<td><%=FormattingHelper.formatDate(addPersonToStagesHistory.getDtDtAdded())%>
            	</td>
			  </tr>
			  <%
			    loopCount++;
			  }
			  %>
                 
              <%
              int i = 0;
              // Get the indicator to check the previous save form the conversation
              String isSaveSuccessful = "false";
              isSaveSuccessful = (String) request.getAttribute("isSaveSuccessful");
              while (addPersonToStagesArray2.hasMoreElements()) {
                CINV04SO_ADD_PERSON_TO_STAGES addPersonToStages = (CINV04SO_ADD_PERSON_TO_STAGES) addPersonToStagesArray2.nextElement();
                String cbxName = "cbxName_" + ( i + 1 );
                String cdStagePersTypeAddPerson = "selSzCdStagePersTypeAddPerson_" + ( i + 1 );
                String cdStagePersRelIntHistory = "selSzCdStagePersRelIntHistory_" + ( i + 1 );
                
                // Get the value from request.getAttribute after successful save to get the null value for new start
          		if (isSaveSuccessful != null && isSaveSuccessful == "true") {
          		  typeHistory = (String) request.getAttribute(cdStagePersTypeAddPerson);
                  szCdStagePersRelIntHistory = (String) request.getAttribute(cdStagePersRelIntHistory);                
          		  szCheckedStage = (String) request.getAttribute(cbxName);
          		}
          		else {          		
                // enableRelDropdown is set dynamically, so initialize it to the actual value
                // Get the Type and Relationship values from the request for setting the value 
                // to the dropdown when the page is re-loaded after error happens
                typeHistory = request.getParameter(cdStagePersTypeAddPerson);
                szCdStagePersRelIntHistory = request.getParameter(cdStagePersRelIntHistory);                
          		szCheckedStage = request.getParameter(cbxName);
          		}
          		
          		if (StringHelper.isEmptyOrNull(szCheckedStage)) 
          		{
          		  szCheckedStage = "false";
          		}
          		String checkBoxDisabled = "true";
          		if ((type != null && !StringHelper.EMPTY_STRING.equals(type) 
          		  && szCdStagePersRelInt != null && !StringHelper.EMPTY_STRING.equals(szCdStagePersRelInt))
          		  || !"A".equals(cReqFuncCd)) {
          		  checkBoxDisabled = "false";
          		  }
              %>
                <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">        				 
                  <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=szCheckedStage%>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name='<%=cbxName%>'
                              onClick="enableDropdowns();"
                              disabled="<%= checkBoxDisabled %>"
                              cssClass="formInput" />
                  </td>
                  <td><%=addPersonToStages.getUlIdStage()%>
                  </td>
                  <td>
          		  <NOBR><%=addPersonToStages.getSzNmStage()%>
          		  </NOBR>
        		  </td>
        		  <td><%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, addPersonToStages.getSzCdStage())%>
        		  </td>
        		  <td><impact:validateSelect 
                     name='<%=cdStagePersTypeAddPerson%>'
                     required="<%= ArchitectureConstants.FALSE %>" 
                     onChange="enableRelDropdown();"
                     style="WIDTH: 80px"
                     tabIndex="<%= tabIndex++ %>"
                     codesTable="CPRSNTYP"
                     editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                     value="<%=FormattingHelper.formatString(typeHistory)%>"/>
                  </td>
                  <% 
                  if ("COL".equals(typeHistory)) {
                    codesTable = "CSRCRPTR";
                  } else if ("PRN".equals(typeHistory)) {
                    codesTable = "CRELVICT";
                  } %>
                  <td><impact:validateSelect 
                              blankValue="true"
                              overrideDisplayBadCodes="true"
                              orderBy="decode"
                              codesTable="<%=codesTable%>"
                              required="<%= ArchitectureConstants.FALSE %>"
                              name='<%= cdStagePersRelIntHistory%>' 
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdStagePersRelIntHistory)%>"/>
                  </td>
                  <td>
                  </td>                       		         
			    </tr>
			    <%
			    loopCount++;
			    i++;
			  }   
			  %>
	  </table>
	</impact:ExpandableSectionTag>
	<% } 
	 }
	%>
	<!-- End STGAP00017013: MR-095 -->
 <%
  // MR:062 - Changed variable initialization so that it will always show the Relationship section.  
  //          business logic in case there is a desire to revert the change later.
  String relInfoForChild = "block";
  if (birth != null) {
    if(DateHelper.getAge(birth) >= 0 && DateHelper.getAge(birth) < 18){
      relInfoForChild = "block";
    }
  }
  %>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" id="relInfoForChild" style="display: <%= relInfoForChild %>"> 
  <tr>
  <th colspan="8">Caregiver/Parental Relationship Information for Child</th>
  </tr> 
  <tr>    
    <td><impact:validateSelect
                               style="WIDTH: 160px"
                               label="Secondary Caregiver"
                               name="selSzCSeCarGiver"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdSecondaryCareGiver)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=relationshipList%>"/>
    </td>    
  </tr>
  <tr>    
    <td><impact:validateSelect 
                               style="WIDTH: 160px"
                               label="Putative Father"
                               name="selSzPutativeFather"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdPutativeFather)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=fatherRelationshipList%>"/>
    </td>    
  </tr>
  <tr>    
    <td><impact:validateSelect 
                               style="WIDTH: 160px"
                               label="Legal Father"
                               name="selSzLegalFather"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdLegalFather)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=fatherRelationshipList%>"/>
    </td>    
  </tr>
  <tr>    
    <td><impact:validateSelect 
                               style="WIDTH: 160px"
                               label="Biological Father"
                               name="selSzBioFather"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdBioFather)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=fatherRelationshipList%>"/>
    </td>    
  </tr>
  <tr>    
    <td><impact:validateSelect 
                               style="WIDTH: 160px"
                               label="Legal Mother"
                               name="selSzLegalMother"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdLegalMother)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=motherRelationshipList%>"/>
    </td>    
  </tr>
  <tr>    
    <td><impact:validateSelect 
                               style="WIDTH: 160px"
                               label="Biological Mother"
                               name="selSzBioMother"
                               style="WIDTH: 240px"
                               overrideDisplayBadCodes="true"
                               required="<%= ArchitectureConstants.FALSE %>"
                               value="<%=FormattingHelper.formatString(ulIdBioMother)%>"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= disableOtherRel %>"
                               options="<%=motherRelationshipList%>"/>
    </td>    
  </tr>
 </table>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder"> 
  <tr>
  <th colspan="8">Other Relationship Information</th>
  </tr> 
  <tr>    
    <td><impact:validateSelect style="WIDTH: 160px" 
                  label="Side of Family"
                              name="selSzSideOfFamily"
                              overrideDisplayBadCodes="true"
                              required="<%= ArchitectureConstants.FALSE %>"                              
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CSIDEFAM"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= disableOtherRel %>"
                              value="<%=FormattingHelper.formatString(szCdSideOfFamily)%>"/>
    </td>    
  </tr>
    <tr>
    <td>Special Relationship:</td>    
    <td colspan="3">
      <impact:validateTextArea
          cols="80"
          rows="3"
          style="WIDTH: 300px"
          name="szTxtOtherRelationshipsCmnts"
          disabled=""
          tabIndex="<%=tabIndex++%>"
          maxLength="300"
          constraint="Comments">
          <%=szTxtOtherRelationshipsCmnts%>
      </impact:validateTextArea>
    </td>         
    <td>&nbsp;</td>
    <td>&nbsp;</td>    
    <td>&nbsp;</td>
  </tr>  
 </table>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">    
  <tr>
  <th colspan="8">Additional Information</th>
  </tr>
  <tr>
  <td class="formInput">Status:</td>
<%if (Sets.isInSet(Sets.E, request)) {

      %>
  <td></td>
<%} else if (overallPageMode.equals(PageModeConstants.NEW)) {

      %>
  <td>Active</td>
<%} else {
%>
  <td><%=Lookup.simpleDecodeSafe("CPERSTAT", cinv04so.getCdPersonStatus())%></td>
<%}

      %>
  </tr>
  <tr>
  <td class="formInput">Category:</td>
<%if (Sets.isInSet(Sets.E, request)) {

      %>
  <td></td>
<%} else {
        if (personCategoryString != null) {
%>
  <td>
  <%=personCategoryString%>
  </td>
<%}

      %>

<%}
%>
  </tr>
<%/*SIR:24002*/%>
</table>
<!-- Release 2 only -->
<table width="100%" cellpadding="3" cellspacing="0">
    <tr>
      <td>
         <impact:ButtonTag name="btnDeletePer"
                              function="return deletePersonDetail()"
                              disabled="<%= Sets.isInSetStr( Sets.A + Sets.B , request ) %>"
                              img="btnDelete"
                              form="frmPersonDetail"
                              action="/person/PersonDetail/deletePersonDetail"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
</table>
<%/* If we are in Set E (employee mode), or in New mode, do not display Address List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW))) {%>
        <impact:include page="/submodule/AddressListSubmodule/displayAddressList"
                        callingPage="/person/PersonDetail/displayPersonDetail"
                        includingForm="frmPersonDetail"  tabIndex="<%=tabIndex++%>">
          <impact:attribute name="<%= AddressListConversation.PAGE_MODE_KEY %>" value="<%= overallPageMode %>"/>
        </impact:include>
        <br>
<%}

      %>

<%// If we are in New mode, do not display Phone Submodule
      if (!overallPageMode.equals(PageModeConstants.NEW)) {
%>
        <impact:include page="/submodule/PhoneSubmoduleConversation/PhoneSub"
                        callingPage="/person/PersonDetail/displayPersonDetail"
                        includingForm="frmPersonDetail" tabIndex="<%=tabIndex++%>" >
          <impact:attribute name="<%= PhoneSubmoduleConversation.PAGE_MODE %>" value="<%= overallPageMode %>"/>
        </impact:include>
        <br>
<%}

      %>


<%// If we are in Set E (employee mode), or we are in Set F (Mobile) do not display Race Eth
      if (!(Sets.isInSet(Sets.E, request) || Sets.isInSet(Sets.F, request))) {

        %>
<%RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);

        %>
<%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp" %>
<%tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);

      %>
<br/>
<%}//End Display only if not in Set E %>

<%/* Begin Tribal */%>
<%/* If we are in Set E (employee mode), or in New mode, do not display Tribal Information */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW))) {%>
<impact:ExpandableSectionTag name="Tribal" label="Tribal and Additional Information" tabIndex="<%= tabIndex++ %>" id="btnDetail_Id" >
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
      <tr>
          <th colspan="5">Tribal Information</th>
      </tr>
      <tr class="odd">
          <td><impact:validateInput type="text"
                              label="Percentage Heritage"
                              constraint="Score"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtPercentHeritage"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szTxtPercentHeritage)%>"
                              size="3"
                              maxLength="3"
                              tabIndex="<%= tabIndex++ %>"/></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
      </tr>
      <tr class="odd">
          <td>Tribal Member?</td>
              <td>
                <impact:validateInput type="radio" label="No" id="Tribal_Member_No" name="rbScrIndTribalMember" value="no" cssClass="formInput" checked="<%= tribalMemberNo %>" tabIndex="<%= tabIndex++ %>"/>
                <impact:validateInput type="radio" label="Yes" id="Tribal_Member_Yes" name="rbScrIndTribalMember" value="yes" cssClass="formInput" checked="<%= tribalMemberYes %>" tabIndex="<%= tabIndex++ %>"/>
                <impact:validateInput type="radio" label="Unknown" id="Tribal_Member_Unknown" name="rbScrIndTribalMember" value="unknown" cssClass="formInput" checked="<%= tribalMemberUnknown %>" tabIndex="<%= tabIndex++ %>"/>
          </td>
          <td><impact:validateInput type="text"
                              label="Tribe Name"
                              constraint="Paragraph"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtTribalName"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szTxtTribalName)%>"
                              size="20"
                              maxLength="20"
                              tabIndex="<%= tabIndex++ %>"/></td>
      </tr>
      <tr class="odd">
          <td>Registered with Tribe?</td>
          <td>
                <impact:validateInput type="radio" label="No" id="Registered_With_Tribe_No" name="rbScrIndRegisteredWithTribe" value="no" cssClass="formInput" checked="<%= registeredWithTribeNo %>" tabIndex="<%= tabIndex++ %>"/>
                <impact:validateInput type="radio" label="Yes" id="Registered_With_Tribe_Yes" name="rbScrIndRegisteredWithTribe" value="yes" cssClass="formInput" checked="<%= registeredWithTribeYes %>" tabIndex="<%= tabIndex++ %>"/>
                <impact:validateInput type="radio" label="Unknown" id="Registered_With_Tribe_No_Unknown" name="rbScrIndRegisteredWithTribe" value="unknown" cssClass="formInput" checked="<%= registeredWithTribeUnknown %>" tabIndex="<%= tabIndex++ %>"/>
          </td>
          <td><impact:validateInput type="text"
                              label="Tribal Registry #"
                              constraint="AlphaNumeric"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtTribalRegistryNumber"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szTxtTribalRegistryNumber)%>"
                              size="20"
                              maxLength="15"
                              tabIndex="<%= tabIndex++ %>"/></td>
      </tr>
      <tr>
          <th colspan="5">Physical Description</th>
      </tr>
      <tr class="odd">
          <td><impact:validateInput type="text"
                              label="Weight"
                              constraint="Numeric"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtWeight"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatInt(lQtyPersonWeight)%>"
                              size="3"
                              maxLength="3"
                              tabIndex="<%= tabIndex++ %>"/></td>
          <td><impact:validateInput type="text"
                              label="Height"
                              constraint="Numeric"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtHeightFt"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatInt(sQtyPersonHeightFeet)%>"
                              size="2"
                              maxLength="2"
                              tabIndex="<%= tabIndex++ %>"/>ft
              <impact:validateInput type="text"
                              label=""
                              constraint="Numeric"
                              onChange="frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'"                              
                              name="szTxtHeightIn"
                              cssClass="formInput"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatInt(sQtyPersonHeightInches)%>"
                              size="2"
                              maxLength="2"
                              tabIndex="<%= tabIndex++ %>"/>in</td>
      </tr>
      <tr class="odd">
          <td><impact:validateSelect style="WIDTH: 160px" 
                  label="Eye Color"
                              name="selSzCdPersonEyeColor"
                              overrideDisplayBadCodes="true"
                              required="<%= ArchitectureConstants.FALSE %>"                              
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CEYECOLR"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              disabled="<%= disableOtherRel %>"
                              value="<%=FormattingHelper.formatString(szCdPersonEyeColor)%>"/></td>
          <td><impact:validateSelect style="WIDTH: 160px" 
                  label="Hair Color"
                              name="selSzCdPersonHairColor"
                              overrideDisplayBadCodes="true"
                              required="<%= ArchitectureConstants.FALSE %>"                              
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CHAIRCLR"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              disabled="<%= disableOtherRel %>"
                              value="<%=FormattingHelper.formatString(szCdPersonHairColor)%>"/></td>
      </tr>
      <tr class="odd">
          <td><impact:validateSelect style="WIDTH: 160px" 
                  label="Highest Education"
                              name="selSzCdPersonHighestEduc"
                              overrideDisplayBadCodes="true"
                              required="<%= ArchitectureConstants.FALSE %>"                              
                              tabIndex="<%= tabIndex++ %>"
                              codesTable="CHIGHEDU"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>"
                              disabled="<%= disableOtherRel %>"
                              value="<%=FormattingHelper.formatString(szCdPersonHighestEduc)%>"/></td>
         <td>&nbsp;</td>                     
         <td>&nbsp;</td>
      </tr>
    </table>
</impact:ExpandableSectionTag>
<br/>
<%}

      %>
<%/* End Tribal */%>

<%/* Begin Person Char */%>
<%/* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display Person Char List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {

        %>
<impact:ExpandableSectionTag name="PersonChar" label="Person Characteristics" tabIndex="<%= tabIndex++ %>" id="btnAdd_Id" >
      <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
                 <table width="100%" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList">Category</th>
                           <th class="thList">Characteristic</th>
                           <th class="thList">&nbsp;</th>
                        </tr>
<%loopCount = 0;
        //If cinv04 is not null, then check to see if BCdPersonChar is equal to "2", if it is, then
        //No characteristics applicable is checked on the Person Char page, set hidden field equal to
        //"Y" for custom Validation
        //!!! which message should be displayed if all rows are filtered out?
        String persChar = cinv24so.getBCdPersonChar();
        if (cinv24so != null && cinv24so.getBCdPersonChar() != null && "2".equals(persChar)) {

        %>
                      <tr class="odd">
                        <td colspan="10">None Diagnosed
                        <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr>
<%}

        else if ("3".equals(persChar)) {

        %>
                      <tr class="odd">
                        <td colspan="10">Not Yet Diagnosed 
                        <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr> 
<%}
        //If the Characteristics array has no elemnts, then no characteristics have been selected
        //set hidden field equal to "N" for custom Validation
        else if (characteristics.isEmpty()) {
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                           <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr>
<%}
        //If Charactaristics have been selected, set the hidden field to "Y" for custom Validation
        else {
          Iterator iterator = characteristics.iterator();
          while (iterator.hasNext()) {
            ROWCINV24SOG charRow = (ROWCINV24SOG) iterator.next();
%>
                        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>" valign="top">
                            <td><%=Lookup.simpleDecodeSafe("CCHRTCAT", charRow.getSzCdCharCategory())%></td>
                            <td>
                                <%=Lookup.simpleDecodeSafe(charRow.getSzCdCharCategory(), charRow.getCdCharacteristic())%>
                                <impact:validateInput type="hidden" name="hdnBIndChar" value="Y"/>
                            <td>
                        </tr>
<%loopCount++;
          }
        }
%>
           </table>
       </div>
        
       <%//STGAP00014806: SEC_SAU_EXCHANGE should see the detail button
        if(user.hasRight(UserProfile.SEC_SAU_EXCHANGE)){ %>
       <table width="100%" cellpadding="3" cellspacing="0">
          <tr>
            <td class="tableBG">
            <div class="alignRight"><impact:ButtonTag name="btnDetail" img="btnDetail" navAwayCk="true" function="cancelValidation()" form="frmPersonDetail" action="/person/PersonDetail/displayPersonChar" editableMode="<%= EditableMode.EDIT + EditableMode.NEW + EditableMode.VIEW%>" tabIndex="<%= tabIndex++ %>"/></div>
            </td>
          </tr>
      </table>
      <%}else{ %>
      <table width="100%" cellpadding="3" cellspacing="0">
          <tr>
            <td class="tableBG">
            <div class="alignRight"><impact:ButtonTag name="btnDetail" img="btnDetail" navAwayCk="true" function="cancelValidation()" form="frmPersonDetail" action="/person/PersonDetail/displayPersonChar" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>"/></div>
            </td>
          </tr>
      </table>
      <%} %>
<%
  // MR:092 - Only display SSI related questions section if primary child
  String displayForPrimaryChild = "none";
  if (CodesTables.CROLEALL_PC.equals(role)) {
    displayForPrimaryChild = "block";
  }
%>
      <table id="personCharacteristicsSsi" width="100%" cellpadding="3" cellspacing="0" style="display: <%= displayForPrimaryChild %>">
         <tr class="odd">
	          <td colspan="2"><span class="formRequiredText">*</span>Has an application been submitted to the SSA for SSI?</td>
	          <td>
                  <impact:validateInput 
                    type="radio" 
                    name="rbSsiAppSubmitted" 
                    value="Y" 
                    cssClass="formInput" 
                    onClick="enableSsiQuestions();"
                    checked="<%= String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiAppSubmitted())) %>" 
                    tabIndex="<%= tabIndex++ %>"/>Yes
	                <impact:validateInput 
	                  type="radio" 
	                  name="rbSsiAppSubmitted" 
	                  value="N" 
	                  cssClass="formInput" 
	                  checked="<%= String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiAppSubmitted()))  %>" 
	                  onClick="enableSsiQuestions();" 
	                  tabIndex="<%= tabIndex++ %>"/>No
	                <impact:validateInput 
	                  type="radio" 
	                  name="rbSsiAppSubmitted" 
	                  value="U" 
	                  cssClass="formInput" 
	                  checked="<%= String.valueOf(CodesTables.CYESNOUN_U.equals(cinv04so.getCIndSsiAppSubmitted())) %>" 
	                  onClick="enableSsiQuestions();" 
	                  tabIndex="<%= tabIndex++ %>"/>Unknown
	          </td>
          </tr>
         <tr class="odd">
            <td colspan="2"><span class="formCondRequiredText">&#135;</span>Did the SSA determine that the child has met the medical or disability requirements for SSI?</td>
            <td>
                  <impact:validateInput type="radio" label="Yes" id="rbSsiMedDsbltyReqMet_Yes" name="rbSsiMedDsbltyReqMet" value="Y" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiMedDsbltyReqMet())) %>" onClick="enableSsiQuestions();" tabIndex="<%= tabIndex++ %>"/>
                  <impact:validateInput type="radio" label="No" id="rbSsiMedDsbltyReqMet_No" name="rbSsiMedDsbltyReqMet" value="N" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiMedDsbltyReqMet())) %>" onClick="enableSsiQuestions();" tabIndex="<%= tabIndex++ %>"/>
            </td>
          </tr>
         <tr class="odd">
            <td colspan="2"><span class="formCondRequiredText">&#135;</span>Are SSI payments being made for the child?</td>
            <td>
                  <impact:validateInput type="radio" label="Yes" id="rbSsiRecipient_Yes" name="rbSsiRecipient" value="Y" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiRecipient())) %>" onClick="enableSsiQuestions();" tabIndex="<%= tabIndex++ %>"/>
                  <impact:validateInput type="radio" label="No" id="rbSsiRecipient_No" name="rbSsiRecipient" value="N" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiRecipient())) %>" onClick="enableSsiQuestions();" tabIndex="<%= tabIndex++ %>"/>
            </td>
          </tr>
         <tr class="odd">
            <td colspan="2"><span class="formCondRequiredText">&#135;</span>Is DFCS the representative payee?</td>
            <td>
                  <impact:validateInput type="radio" label="Yes" id="rbSsiDfcsPayee_Yes" name="rbSsiDfcsPayee" value="Y" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiDfcsPayee())) %>" tabIndex="<%= tabIndex++ %>"/>
                  <impact:validateInput type="radio" label="No" id="rbSsiDfcsPayee_No" name="rbSsiDfcsPayee" value="N" cssClass="formInput" checked="<%= String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiDfcsPayee())) %>" tabIndex="<%= tabIndex++ %>"/>
            </td>
          </tr>
      </table>
      
</impact:ExpandableSectionTag>
<br/>
<%} /*End if in Set E, or New mode don't display this information */%>

<%/* Begin Medication */%>
<%// If we are in New mode do not display Medication Submodule
      //if ( !(overallPageMode.equals( PageModeConstants.NEW )))
      //{
      %>
        <impact:include page="/submodule/MedicationSubmoduleConversation/displayMedication"
                        callingPage="/person/PersonDetail/displayPersonDetail"
                        tabIndex="<%= tabIndex++ %>" includingForm="frmPersonDetail">
          <impact:attribute name="intakeIndicator" value="N"/>
          <impact:attribute name="<%= MedicationSubmoduleConversation.PAGE_MODE_KEY %>"
                            value="<%= overallPageMode %>" />
        </impact:include>
        <br/>
<%//}

      %>
<%/* End Medication */%>

<%// If we are in New mode or in Sets F (Mobile), do not display Name History Submodule
      if (!(overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F, request))) {
%>
        <impact:include page="/submodule/NameHistorySubmoduleConversation/displayNameHistory"
                        callingPage="/person/PersonDetail/displayPersonDetail"
                        tabIndex="<%= tabIndex++ %>" includingForm="frmPersonDetail">
          <impact:attribute name="intakeIndicator" value="N"/>
          <impact:attribute name="<%= NameHistorySubmoduleConversation.PAGE_MODE_KEY %>"
                            value="<%= overallPageMode %>" />
        </impact:include>
        <br>
<%}

      %>

<%// If we are in New mode, or the person is an employee (Set E), or we are in Mobile (Set F),
      // do not display Person Identifiers Submodule
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {
%>
        <impact:include page="/submodule/PersonIdentifiersSubmodule/displayPersonIDsListSubmodule"
                        callingPage="/person/PersonDetail/displayPersonDetail" tabIndex="<%= tabIndex++ %>"
                        includingForm="frmPersonDetail">
          <impact:attribute name="<%= PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY %>"
                            value="<%= overallPageMode %>" />
        </impact:include>
        <br>
<%}

      %>

<%// Begin Person Merge/Split
      // If we are in New mode, or Set F (Mobile), do not display Person Merge Split List
      if (!(overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F, request))) {
        String mergeTab = StringHelper.EMPTY_STRING;
        loopCount = 0;
        ROWCCFC13SOG00 mergeRow = null;
        Enumeration mergeEnumeration = mergeArray.enumerateROWCCFC13SOG00();
        if (!mergeEnumeration.hasMoreElements()) {
          mergeTab = "btnAddMerge_Id";
        } else {
          mergeTab = "mergeLinks0";
        }
%>
  <impact:ExpandableSectionTag name="personMerge" label="Person Merge/Split" tabIndex="<%= tabIndex++ %>" id="<%=mergeTab%>">
          <div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
        <div id="scrollBar2" style="height:165px;width:763px;overflow:auto" class="tableborderList">
                 <table width="1400" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList">Forward name</th>
                           <th class="thList">ID Person Forward</th>
                           <th class="thList">Closed Name</th>
                           <th class="thList">ID Person Closed</th>
                           <th class="thList">Merge Date</th>
                           <th class="thList">Staff Name - Merge</th>
                           <th class="thList">Staff ID - Merge</th>
                           <th class="thList">Split Date</th>
                           <th class="thList">Staff Name - Split</th>
                           <th class="thList">Staff ID - Split</th>
                        </tr>
<%if (!mergeEnumeration.hasMoreElements()) {
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                        </td>
                      </tr>
<%} else {
          while (mergeEnumeration.hasMoreElements()) {
            mergeRow = (ROWCCFC13SOG00) mergeEnumeration.nextElement();
%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                        <%/*MergeOnClick used to submit the row's parameters to hidden fields*/%>
                        <%String MergeOnClick = "setMergeParms( '" + loopCount + "' )";

            %>
                            <td><a id='<%="mergeLinks" + loopCount%>' tabIndex="<%= tabIndex++ %>" href="javascript:<%=MergeOnClick%>; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayMergeSplit' )"><%=mergeRow.getSzScrNmPersMergeForward()%></a></td>
                            <td><%=FormattingHelper.formatInt(mergeRow.getUlIdPersMergeForward())%></td>
                            <td><%=FormattingHelper.formatString(mergeRow.getSzScrNmPersMergeClosed())%></td>
                            <td><%=FormattingHelper.formatInt(mergeRow.getUlIdPersMergeClosed())%></td>
                            <td><%=FormattingHelper.formatDate(mergeRow.getDtDtPersMerge())%></td>
                            <td><%=FormattingHelper.formatString(mergeRow.getSzScrNmPersMergeWrkr())%></td>
                            <td><%=FormattingHelper.formatInt(mergeRow.getUlIdPersMergeWrkr())%></td>
                            <td><%=FormattingHelper.formatDate(mergeRow.getDtDtPersMergeSplit())%></td>
                            <td><%=FormattingHelper.formatString(mergeRow.getSzScrNmPersMrgSpltWrkr())%></td>
                            <td><%=FormattingHelper.formatInt(mergeRow.getUlIdPersMergeSplitWrkr())%></td>
                        </tr>
<%loopCount++;
          } // end for
        }
%>
           </table>
        </div>
      <table width="100%" cellpadding="3" cellspacing="0">
          <tr>
          <td class="tableBG">
               <div class="alignRight"><impact:ButtonTag
                              name="btnAddMerge"
                              img="btnAdd"
                              form="frmPersonDetail"
                              navAwayCk="true"
                              function="cancelValidation();  return mergeEmployee()"
                              action="/person/PersonDetail/addMergeSplit"
                              disabled="<%=hideMergeAdd %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.VIEW + EditableMode.NEW%>"
                              tabIndex="<%= tabIndex++ %>"/></div>
           </td>
      </tr>
     </table>

</impact:ExpandableSectionTag>
<br/>
<%// end Person Merge/Split
      } //End if in New Mode, don't display this information

      %>


<%// Begin Income and Resources
      /* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display Inc/Rsrc List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {
        String incomeTab = StringHelper.EMPTY_STRING;
        loopCount = 0;
        ROWCCFC29SOG00 incomeRow = null;
        Enumeration incomeEnumeration = incomeArray.enumerateROWCCFC29SOG00();
        if (!incomeEnumeration.hasMoreElements()) {
          incomeTab = "btnAddIncome_Id";
        } else {
          incomeTab = "incRadio0";
        }

        %>
  <impact:ExpandableSectionTag name="income" label="Income and Resources" tabIndex="<%= tabIndex++ %>" id="<%=incomeTab%>">
          <div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
        <div id="scrollBar2" style="height:165px;width:763px;overflow:auto" class="tableborderList">
                 <table width="1400" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList"></th>
                           <th class="thList">Inc/Res</th>
                           <th class="thList">Inc/Res Type</th>
                           <th class="thListRight">Amount/Value</th>
                           <th class="thList">Start Date</th>
                           <th class="thList">End Date</th>
                           <th class="thList">Source/Employer</th>
                           <th class="thList">Accessible</th>
                           <th class="thList">Staff Name</th>
                           <th class="thList">Last Saved</th>
                           <th class="thList">Description</th>
                           <th class="thList">Verif Method</th>
                           <th class="thList">Emp Address</th>
                           <th class="thList">Emp Phone</th>
                        </tr>
<%if (!incomeEnumeration.hasMoreElements()) {
%>
                      <tr class="odd">
                        <td colspan="14">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                        </td>
                      </tr>
<%} else {
          while (incomeEnumeration.hasMoreElements()) {
            incomeRow = (ROWCCFC29SOG00) incomeEnumeration.nextElement();
%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                        <%/*IncOnClick used to submit the row's parameters to hidden fields */%>
                        <%String IncOnClick = "setIncomeParms( '" + incomeRow.getTsLastUpdate() + "', '" + incomeRow.getUlIdIncRsrc()
                                + "', '" + loopCount + "' )";

            %>
                            <td><impact:validateInput id='<%="incRadio" + loopCount%>'
                                                      tabIndex="<%= tabIndex++ %>"
                                                      value="loopCount"
                                                      type="radio"
                                                      name="incSelect_CLEAN"
                                                      editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                                                      onClick="<%=IncOnClick%>"  /></td>

                            <td><%=incomeRow.getSzCdIncRsrcIncome()%></td>
                            <td><a tabIndex="<%= tabIndex++ %>" href="javascript: <%=IncOnClick%>; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayIncRsrc' )">


<%String incomeCodesTableString = "CINC";
            String resourceCodesTableString = "CRSRC";
            //SIR 23759 - In case we don't have a Stage Program default to CINCRSRC
            //String incomeCodesTableString = "CINCRSRC";
            //String resourceCodesTableString = "CINCRSRC";

            //SIR 23759 - Use new APS Income and Resources if the Stage Program is APS
            //if ("APS".equals(szCdStageProgram) || "AFC".equals(szCdStageProgram))
            //{
            //  incomeCodesTableString = "CINC2";
            //  resourceCodesTableString = "CRSRC2";
            //}
            //SIR 23759 - Use CPS Income and Resources if the Stage Program is CPS
            //if ("CCL".equals(szCdStageProgram) || "CPS".equals(szCdStageProgram) ||
            //    "RCL".equals(szCdStageProgram)) {
            //  incomeCodesTableString = "CINC";
            //  resourceCodesTableString = "CRSRC";
            //}

            if ("INC".equals(incomeRow.getSzCdIncRsrcIncome())) {

              %>
            <%String type1 = Lookup.simpleDecodeSafe(incomeCodesTableString, incomeRow.getSzCdIncRsrcType());

              %>
                                <%=Lookup.simpleDecodeSafe(incomeCodesTableString, incomeRow.getSzCdIncRsrcType())%>
                                <%} else {

              %>
                                <%String type2 = Lookup.simpleDecodeSafe(resourceCodesTableString, incomeRow.getSzCdIncRsrcType());

              %>
                                <%=Lookup.simpleDecodeSafe(resourceCodesTableString, incomeRow.getSzCdIncRsrcType())%>
                                <%}

            %></a>
                            </td> 
                            <td class="alignRight"><%=FormattingHelper.formatMoney(incomeRow.getLAmtIncRsrc())%></td>
                            <td><%=FormattingHelper.formatDate(incomeRow.getDtDtIncRsrcFrom())%></td>
                            <td><%=FormattingHelper.formatDate(incomeRow.getDtDtIncRsrcTo())%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzSdsIncRrcsSource())%></td>
			<% // STGAP00004122 - change col label from Not Acsbl to Accessible (above) and modify display logic accordingly
			String notAccessibleDB = FormattingHelper.formatString(incomeRow.getCIndIncRsrcNotAccess());
			String accessibleDisplay = ArchitectureConstants.Y.equals(notAccessibleDB) ? ArchitectureConstants.N : ArchitectureConstants.Y;
			%>
                            <td><%=accessibleDisplay%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzNmPersonFull())%></td>
                            <td><%=FormattingHelper.formatDate(incomeRow.getTsLastUpdate())%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcDesc())%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzSdsIncRsrcVerfMethod())%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcSrcAddrStLn1())%></td>
                            <td><%=FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcSrcPhoneNum())%></td>
                        </tr>
<%loopCount++;
          } // end for
        }

        %>
           </table>
         </div><%/* this is where the "collapsedIncome" div tag ends */

        %>
      <table width="100%" cellpadding="3" cellspacing="0">
      <tr>
      <td class="tableBG">
      <!-- Delete button is removed for R1.  Version 6298 has the delete code. -->
      &nbsp;
      </td>
      <td>
         <div class="alignRight"><impact:ButtonTag
                              name="btnIncRsrcDtl"
                              img="btnRequestSUCCESSData"
                              navAwayCk="true"                              
                              function="cancelValidation();"
                              form="frmPersonDetail"
                              action="/person/PersonDetail/getIncRsrcDtl"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              tabIndex="<%= tabIndex++ %>"/>
         <impact:ButtonTag
                              name="btnAddIncome"
                              img="btnAdd"
                              navAwayCk="true"
                              function="cancelValidation();"
                              form="frmPersonDetail"
                              action="/person/PersonDetail/addIncRsrc"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              tabIndex="<%= tabIndex++ %>"/></div>
      </td>
      </tr>
      </table>
</impact:ExpandableSectionTag>
<br/>
<%// end Income and Resources
      } /*End Display only if not in Set E, or if not in New mode */

      %>

<%// Begin Education
      /* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display Education List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {
        String eduTab = null;
        loopCount = 0;
        ROWCCFC17SOG00 educationRow = null;
        Enumeration educationEnumeration = educationArray.enumerateROWCCFC17SOG00();
        if (!educationEnumeration.hasMoreElements()) {
          eduTab = "btnAddEdu_Id";
        } else {
          eduTab = "eduRadio0";
        }
%>
  <impact:ExpandableSectionTag name="education" label="Education" tabIndex="<%= tabIndex++ %>" id="<%=eduTab%>">
              <div id="scrollBar2" style="height:155px;width:100%;overflow:auto" class="tableborderList">
                 <table width="100%" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList"></th>
                           <th class="thList">School Name</th>
                           <th class="thList">Enrolled</th>
                           <th class="thList">Grade</th>
                           <th class="thList">Withdrawn</th>
                           <th class="thList">Grade</th>
                        </tr>
<%if (!educationEnumeration.hasMoreElements()) {
          withdrawnDate = "ssss";
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                        </td>
                      </tr>
<%} else {
          String schoolName = NO_NAME_STRING;
          while (educationEnumeration.hasMoreElements()) {
            educationRow = (ROWCCFC17SOG00) educationEnumeration.nextElement();
            if (loopCount == 0) {
              withdrawnDate = FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate());
            }
            if (StringHelper.isValid(educationRow.getSzNmEdhistSchool())) {
              schoolName = educationRow.getSzNmEdhistSchool();
            } else {
              schoolName = NO_NAME_STRING;
            }
%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                        <%/* EduOnClick used to submit the row's parameters to hidden fields */%>
                        <%String EduOnClick = "setEduParms( '" + educationRow.getTsLastUpdate() + "', '"
                                + educationRow.getUlIdEdhist() + "', '" + loopCount + "' )";

            %>
                            <td><impact:validateInput id='<%="eduRadio" + loopCount%>'
                              tabIndex="<%= tabIndex++ %>"
                              value="loopCount"
                              type="radio"
                              name="eduSelect_CLEAN"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              onClick="<%=EduOnClick%>"  /></td>
                            <td><a tabIndex="<%= tabIndex++ %>"
                              href="javascript: <%=EduOnClick%>; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayEducation' )"><%=schoolName%></a></td>
                            <td><%=FormattingHelper.formatDate(educationRow.getDtDtEdhistEnrollDate())%></td>
                            <td><%=Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistEnrollGrade())%></td>
                            <td><%=FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate())%></td>
                            <td><%=Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistWithdrawnGrade())%></td>
                        </tr>
<%loopCount++;
          } // end for
        }

        %>
           </table>
              </div><%/* this is where the "collapsedEducation" div tag ends */

        %>
      <table width="100%" cellpadding="3" cellspacing="0">
      <tr>
      <td class="tableBG">
      <div class="alignRight"><impact:ButtonTag
                              name="btnAddEdu"
                              img="btnAdd"
                              navAwayCk="true"
                              function="cancelValidation(); return addEdu()"
                              form="frmPersonDetail"
                              action="/person/PersonDetail/addEducation"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW%>"
                              tabIndex="<%= tabIndex++ %>"/></div>
      </td>
      </tr>
      </table>
</impact:ExpandableSectionTag>
  <br/>
<%} /*End Display only if not in Set E, or page mode is new */

      %>

<%/* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display FA Home */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {
        if ("FAD".equals(szCdStage)) {
          loopCount = 0;
          CFAD32SOG00 FARow = null;
          Enumeration FAEnumeration = FAArray.enumerateCFAD32SOG00();
%>
  <impact:ExpandableSectionTag name="FAHome" label="F/A Home Member Training" tabIndex="<%= tabIndex++ %>" id="faRadio0">
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="10">Current Year Training</th>
  </tr>
  <tr class="odd">
    <td width="30%">
        <impact:validateDisplayOnlyField
            name="displayHrsCompletedInCurrentYr"
            label="Hours Completed In Current Year"
            value="<%= String.valueOf(trngHrsCompleted) %>" />
    </td>
    </tr>
    <tr class="odd">
    <td width="30%">
        <impact:validateDisplayOnlyField
            name="displayHrsRemainInCurrentYr"
            label="Hours Remaining In Current Year"
            value="<%= String.valueOf(trngHrsRemain) %>" />
    </td>
    </tr>
  </table>
              <div id="scrollBar2" style="height:155px;width:100%;overflow:auto" class="tableborderList">
              
                 <table width="100%" cellspacing="0" cellpadding="3">
                         <tr>
                           <th class="thList"></th>
                           <th class="thList">Date</th>
                           <th class="thList">Title</th>
                           <th class="thList">Type</th>
                           <th class="thList">Session Number</th>
                           <th class="thList">Hours</th>
                           <!-- <th class="thList">EC Hours</th> -->
                        </tr>
<%if (!FAEnumeration.hasMoreElements()) {
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                        </td>
                      </tr>
<%} else {
            while (FAEnumeration.hasMoreElements()) {
              FARow = (CFAD32SOG00) FAEnumeration.nextElement();
%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                        <%/*FAOnClick used to submit the row's parameters to hidden fields */%>
                        <%String FAOnClick = "setFAParms( '" + FARow.getTsLastUpdate() + "', '" + FARow.getUlIdIndivTraining()
                                 + "', '" + loopCount + "' )";

              %>
                            <td><impact:validateInput id='<%="faRadio" + loopCount%>'
                              tabIndex="<%= tabIndex++ %>"
                              value="loopCount"
                              type="radio"
                              name="faSelect_CLEAN"
                              disabled="<%=hideFAFlag %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              onClick="<%=FAOnClick%>"  /></td>
                            <td><%=FormattingHelper.formatDate(FARow.getDtDtIndivTrn())%></td>
                            <td><a tabIndex="<%= tabIndex++ %>"
                              href="javascript: <%=FAOnClick%>; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayFAHome' )"><%=FARow.getSzTxtIndivTrnTitle()%></a></td>
                            <td><%=Lookup.simpleDecodeSafe("CFATRAIN", FARow.getSzCdIndivTrnType())%></td>
                            <td><%=FormattingHelper.formatInt(FARow.getSNbrIndivTrnSession())%></td>
                            <td><%=FARow.getLdNbrIndivTrnHrs()%></td>
                            <!-- <td><%= FormattingHelper.formatString(FARow.getCIndIndivTrnEc()) %></td> -->
                            
                        </tr>
<%loopCount++;
            } // end for
          }

          %>
           </table>
              </div><%/* this is where the "collapsedFA" div tag ends */

          %>
      <table
                              width="100%"
                              cellpadding="3"
                              cellspacing="0">
      <tr>
      <td class="tableBG">
      <%// Only display delete pushbutton if list has rows
          if (FAArray.getCFAD32SOG00Count() > 0) {

            %>
         <%String functionString = "cancelValidation(); return deleteRow( " + loopCount + ", 'faSelect_CLEAN' );";%>
         <impact:ButtonTag name="btnDeleteFA"
                              img="btnDelete"
                              restrictRepost="true"
                              navAwayCk="false"
                              function="<%=functionString%>"
                              form="frmPersonDetail"
                              disabled="<%=hideFAFlag %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              action="/person/PersonDetail/deleteFAHome"
                              tabIndex="<%= tabIndex++ %>"/>
      <%}

          %>
      </td>
      <td class="tableBG">
         <div class="alignRight"><impact:ButtonTag
                              name="btnAddFA"
                              navAwayCk="true"
                              img="btnAdd"
                              function="cancelValidation()"
                              form="frmPersonDetail"
                              disabled="<%=hideFAFlag %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              action="/person/PersonDetail/addFAHome"
                              tabIndex="<%= tabIndex++ %>"/></div>
      </td>
      </tr>
   </table>
</impact:ExpandableSectionTag>
<%/* end FA */

        %>
<%} /* end FA display */%>
<%}/* End Display only if not in Set E, or mode is new */%>

<hr>
<table width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td>
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        align="right"
                        form="frmPersonDetail"
                        action="/person/PersonDetail/savePersonDetail"
                        preventDoubleClick="true"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table><br>
  <impact:validateInput type="hidden"
                        name="hdnSzCdStage"
                        value="<%= szCdStage %>"/>

  <impact:validateInput type="hidden"
                        name="hdnSzCdStageProgram"
                        value="<%= szCdStageProgram %>"/>

  <impact:validateInput type="hidden"
                        name="hdnPageMode"
                        value="<%= pageModePassed %>"/>

  <impact:validateInput type="hidden"
                        name="hdnCReqFuncCd"
                        value="<%=cReqFuncCd%>"/>

  <impact:validateInput type="hidden"
                        name="hdnSzCdStagePersSearchInd"
                        value="<%=FormattingHelper.formatString(cinv04so.getSzCdStagePersSearchInd())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnBCdPersonChar"
                        value="<%=FormattingHelper.formatString(personChar)%>"/>

  <impact:validateInput type="hidden"
                        name="hdnUlIdStagePerson"
                        value="<%=FormattingHelper.formatInt(cinv04so.getUlIdStagePerson())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnTsLastUpdate"
                        value="<%=DateHelper.toISOStringSafe(cinv04so.getTsLastUpdate())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnTsSysTsLastUpdate2"
                        value="<%=DateHelper.toISOStringSafe(cinv04so.getTsSysTsLastUpdate2())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnSzNmPersonFull"
                        value="<%=FormattingHelper.formatString(cinv04so.getSzNmPersonFull())%>"/>

  <%/*These hidden fields are used for information in Custom Validation */%>
  <impact:validateInput type="hidden"
                        name="hdnBIndActiveEvent"
                        value="<%=FormattingHelper.formatString(bIndActiveEvent)%>"/>

  <impact:validateInput type="hidden"
                        name="hdnCScrIndDupAlleg"
                        value="<%=FormattingHelper.formatString(cinv04so.getCScrIndDupAlleg())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnSzCdStagePersType"
                        value="<%=FormattingHelper.formatString(cinv04so.getSzCdStagePersType())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnCSysIndHomeRemovePers"
                        value="<%=FormattingHelper.formatString(cinv04so.getCSysIndHomeRemovePers())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnCSysIndPersReferPresent"
                        value="<%=FormattingHelper.formatString(cinv04so.getCSysIndPersReferPresent())%>"/>

  <impact:validateInput type="hidden"
                        name="hdnBIndActiveStatus"
                        value="<%=FormattingHelper.formatString(bIndActiveStatus)%>"/>

  <impact:validateInput type="hidden"
                        name="hdnWithdrawnDate"
                        value="<%=FormattingHelper.formatString(withdrawnDate)%>"/>

  <impact:validateInput type="hidden"
                        name="hdnOverallPageMode"
                        value="<%=overallPageMode%>"/>

  <%/* This hidden field is used for save of the Person Status */%>
  <impact:validateInput type="hidden"
                        name="hdnCdPersonStatus"
                        value="<%=status%>"/>
                        
   <%/* This hidden field is used track if this person is a safety resource anywhere in the case */%>                     
  <impact:validateInput type="hidden"
                        name="hdnBIndSafetyRsrcCase"
                        value="<%=FormattingHelper.formatString(cinv04so.getBIndSafetyRsrcCase())%>"/>
                        
  <impact:validateInput type="hidden"
                        name="hdnBIndSsnCheck"
                        value="Y"/>

  <%/* This hidden field is used for navigation to Case List */%>
  <!-- SIR 23936 Changed reference from CaseSearchConversation to PersonDetailBaseConversation
       as part of the refactoring for Mobile server  -->
  <impact:validateInput type="hidden"
                        name="<%=PersonDetailConversation.PREVIOUS_URI_PARAM_NAME%>"
                        value="<%=PersonDetailConversation.PREVIOUS_URI_PERSON_DETAIL%>"/>

  <%//Initialize the Todo Indicator Variable.  This Variable will be changed to "True"
      //With On Change of any Person Information other than case specific information

      %>
  <impact:validateInput type="hidden" name="hdnBSysIndCreateToDo" value=""/>

  <%/* Set Merge Split hidden fields */%>
  <impact:validateInput type="hidden" name="hdnMergeLoopCount" value=""/>
  <%/* Set Income and Resources hidden fields */%>
  <impact:validateInput type="hidden" name="hdnTsIncomeLastUpdate" value=""/>
  <impact:validateInput type="hidden" name="hdnUlIdIncRsrc" value=""/>
  <impact:validateInput type="hidden" name="hdnIncLoopCount" value=""/>
  <%/* Set Education hidden fields */%>
  <impact:validateInput type="hidden" name="hdnTsEduLastUpdate" value=""/>
  <impact:validateInput type="hidden" name="hdnUlIdEdhist" value=""/>
  <impact:validateInput type="hidden" name="hdnEduLoopCount" value=""/>
  <%/* Set FA hidden fields */%>
  <impact:validateInput type="hidden" name="hdnTsFALastUpdate" value=""/>
  <impact:validateInput type="hidden" name="hdnUlIdIndivTraining" value=""/>
  <impact:validateInput type="hidden" name="hdnFALoopCount" value=""/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

</impact:validateForm>

<%//*****************
      //**** REPORTS ****
      //*****************

      %>
<%boolean letterReporterFrm = true;
      boolean DPFrm = true;
      boolean ParentFrm = true;
      boolean APFrm = true;
      boolean noticeReporterFrm = true;
      boolean initChildDeathRpt = true;
      boolean childDeathCommitteeRpt = true;

      if ("INV".equals(szCdStage)) {
        // If the stage is investigation, the program is AFC, and the person is a reporter
        // then DO NOT hide letter to reporter
        if ("AFC".equals(szCdStageProgram) && ArchitectureConstants.Y.equals(reporter)) {
          letterReporterFrm = false;
        }
        // If the stage is investigation, the program is CPS, and the person is DP or DB
        // then DO NOT hide DP Form
        if (("DB".equals(role) || "DP".equals(role)) && "CPS".equals(szCdStageProgram)) {
          DPFrm = false;
        }
        // If the stage is investigation, the program is CPS, and the person has any of the following
        // roles, but is not the AP, SP, or DP DO NOT hide the parent form
        // Note that the Rel/Int codes tables are not used because there are 4 possible codestables
        // that can be attached for a person in the Rel/Int field.
        if (("PA".equals(szCdStagePersRelInt) || "GU".equals(szCdStagePersRelInt) || "AB".equals(szCdStagePersRelInt)
             || "FP".equals(szCdStagePersRelInt) || "AD".equals(szCdStagePersRelInt)
             || "AU".equals(szCdStagePersRelInt) || "CO".equals(szCdStagePersRelInt)
             || "FM".equals(szCdStagePersRelInt) || "FR".equals(szCdStagePersRelInt)
             || "GC".equals(szCdStagePersRelInt) || "GP".equals(szCdStagePersRelInt)
             || "NN".equals(szCdStagePersRelInt) || "PP".equals(szCdStagePersRelInt)
             || "SB".equals(szCdStagePersRelInt) || "SS".equals(szCdStagePersRelInt)
             || "ST".equals(szCdStagePersRelInt) || "UF".equals(szCdStagePersRelInt)
             || "UH".equals(szCdStagePersRelInt) || "XX".equals(szCdStagePersRelInt))
            && (!("AP".equals(role) || "SP".equals(role) || "DP".equals(role))) && "CPS".equals(szCdStageProgram)) {
          ParentFrm = false;
        }
        // If the stage is investigation, the program is CPS, and the person is a reporter
        // then DO NOT hide Notice to Reporter
        if ("CPS".equals(szCdStageProgram) && ArchitectureConstants.Y.equals(reporter)) {
          noticeReporterFrm = false;
        }
        // If the stage is investigation, the program is CPS, and the person has No role, or is a DV
        // then DO NOT hide letter to AP
        if (("NO".equals(role) || "DV".equals(role)) && "CPS".equals(szCdStageProgram)) {
          APFrm = false;
        }
      }

      //Get the indexs form the conversation
      String initChildDeathIndex = (String) request.getAttribute("initChildDeathIndex");
      String childDeathCommitteIndex = (String) request.getAttribute("childDeathCommitteIndex");
      String dateOfDeath = String.valueOf(cinv04so.getDtDtPersonDeath());
      // SIR 19420 - If the Date of Death is not null and the legacy reports of initChildDeath or childDeathCommitte
      //exist then the user access those report in only view mode.
      if (dateOfDeath != null || !StringHelper.EMPTY_STRING.equals(dateOfDeath)) {
        if (ArchitectureConstants.Y.equals(initChildDeathIndex)) {
          initChildDeathRpt = false;
        }
        if (ArchitectureConstants.Y.equals(childDeathCommitteIndex)) {
          childDeathCommitteeRpt = false;
        }
      }

      %>


<%/* If we are in Set E (employee mode), or in New mode, do not forms or reports */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {

      %>
<!-- Forms and Reports code goes here.  I have code saved in a text file for later use.  -->
<br>
<%} /* end if in new mode or employee mode, don't display forms or reports */

      %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

    window.onload = function ()
    {
        <%  
            boolean showSaveMsg = false;
            boolean showErrMsg = false;
            String msg = (String)request.getAttribute("hdnCrsRegnSaveMsg");
            String errMsg = (String)request.getAttribute("hdnWebServiceError");
            if(msg==null){
                showSaveMsg = false;
            }
            else{
                showSaveMsg = true;
            }
            if(errMsg==null){
                showErrMsg = false;
            }
            else{
                showErrMsg = true;
            }
        %>
        if (<%=showSaveMsg%> == true){
            var tmp = '<%=(String)request.getAttribute("hdnCrsRegnSaveMsg")%>';
            alert(tmp);
            <%request.setAttribute("hdnCrsRegnSaveMsg", null);%>
        }
        if (<%=showErrMsg%> == true){
            var errtmp = '<%=(String)request.getAttribute("hdnWebServiceError")%>';
            alert(errtmp);
            <%request.setAttribute("hdnWebServiceError", null);%>
        }
    };

//updateRelInt();
// SIR 18745 call valueDOD on load of the page so that the dropdown will be populated
// correctly onload of the page.
<% if ( !overallPageMode.equals( PageModeConstants.VIEW ) )
  {
%>
valueDOD();
<% } %>

<% if ( !overallPageMode.equals( PageModeConstants.NEW ) )
  {
  %>
  frmPersonDetail.txtLNbrPersonAge.disabled = true
  <%
  }
  %>

<%--
Sir 18082
MDM 06/11/2003, on validation error set selSzCdStagePersRelInt from request
                else set DOD and RelInt according to the pagestate
--%>
<impact:if test='<%= (ServerSideValidationUtility.getBRefreshWidgetsFromRequest(request)) %>'>
  <impact:then>
    frmPersonDetail.selSzCdStagePersRelInt.value='<%= ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt") %>';
    frmPersonDetail.selSzCdPersonDeath.value='<%= ContextHelper.getStringSafe(request, "selSzCdPersonDeath") %>';
  </impact:then>
  <impact:else>
    <impact:ifThen test='<%= (!(Sets.isInSet(Sets.E, request) || PageModeConstants.VIEW.equals(PageMode.getPageMode(request)))) %>'>
     valueDOD();
     frmPersonDetail.selSzCdPersonDeath.value='<%= cinv04so.getSzCdPersonDeath() %>';
     CleanSelect( frmPersonDetail.selSzCdPersonDeath );
    </impact:ifThen>

    frmPersonDetail.selSzCdStagePersRelInt.value='<%= szCdStagePersRelInt %>';
  </impact:else>
</impact:if>


CleanSelect( frmPersonDetail.selSzCdStagePersRelInt );
//-- SIR STGAP00000695
//-- Call this method when page loads so that the dynamic select inputs under
//-- the "Other Relationship Information" section start off "clean."  This
//-- allows the call to IsDirty() to operate correctly, displaying a pop-up
//-- message only if the form inputs have changed.
cleanDynamicSelects();

</script>

