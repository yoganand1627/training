package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

public final class PersonDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/person/RaceEthnicitySub.jsp");
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

//*  JSP Name:     Person Detail
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

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n  \r\n\r\n  \r\n \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
String NO_NAME_STRING = "____________";

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

      
      out.write("\r\n\r\n");
// relate to STGAP00002756: the immediate fix for that defect is replacing simpleDecode with simpleDecodeSafe for DOD and RelInt
      if ("COL".equals(cinv04so.getSzCdStagePersType())) {
        codesTable = "CSRCRPTR";
      } else if ("PRN".equals(cinv04so.getSzCdStagePersType())) {
        codesTable = "CRELVICT";
      } else {
        // no change to whatever existing value; keep this else to make clear the intention that only set the codes table 
        // display for the 2 types collateral and principal
      }
      // end STGAP00002756
 
      out.write("\r\n\r\n\r\n");
// Start Javascript Section 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n //Start javascript funcitons here\r\n  //Create javascript functions here for each action on the page\r\n  //All form submits should use the submitValidateForm function to submit\r\n  \r\nwindow.attachEvent(\"onload\", initializePage);\r\n\r\nfunction initializePage(){\r\n updateRelInt();         \r\n checkForDuplicatePerson();\r\n enableSsiQuestions();\r\n enableRelDropdown();\r\n disableAddPerson();\r\n}\r\n\r\n/* \r\n** use CSRCRPTR for collaterals, CRELVICT for principals, no matter what the stage\r\n*/\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n\r\n// STGAP00017013: MR-095\r\n/* \r\n** use CPRSNTYP for Type dropdown on the Add Person to Active Stages section\r\n*/\r\n");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("\r\n// End STGAP00017013: MR-095\r\n\r\nfunction updateRelInt()\r\n{\r\n //Don't update the REL/INT (Relationship) if the calling page was\r\n //Person search and the mode is browse or maintain person\r\n");
 if(!(overallPageMode.equals(PageModeConstants.VIEW) ||
        Sets.isInSet(Sets.B, request) ||
        Sets.isInSet(Sets.E, request)))
  {

      out.write("\r\n   \tif (frmPersonDetail.hdnSzCdStageProgram.value == 'CPS')\r\n   \t{\r\n       if (frmPersonDetail.selSzCdStagePersType.options.value == 'COL')\r\n       {\r\n         populateDropdown( frmPersonDetail.selSzCdStagePersRelInt , frmPersonDetail.selSzCdStagePersRelInt.options.value, colOneCodes );\r\n         var relationship = \"");
      out.print( StringHelper.getNonNullString(szCdStagePersRelInt) );
      out.write("\";\r\n         document.frmPersonDetail.selSzCdStagePersRelInt.value = relationship;\r\n         //SMS 56827 MR-066\r\n         if(relationship == \"\"|| relationship == null){\r\n           frmPersonDetail.selSzCdStagePersRelInt.value = \"");
      out.print(  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  );
      out.write("\";\r\n         }\r\n         // STGAP00017013: MR-095\r\n         if (frmPersonDetail.selSzCdStagePersRelInt.options.value != null && frmPersonDetail.selSzCdStagePersRelInt.options.value != \"\")\r\n         {\r\n           for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n           {\r\n             var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n             var dropdownTypeAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n             var dropdownRelAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);\r\n           \r\n             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation\r\n             if ((checkboxName.checked == false) \r\n             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == \"\")\r\n             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == \"\"))\r\n             {\r\n               checkboxName.disabled = false;\r\n               checkboxName.checked = false;\r\n           \r\n               clearDropdown(dropdownTypeAddPerson);\r\n               dropdownTypeAddPerson.disabled = true; \r\n               clearDropdown(dropdownRelAddPerson);\r\n               dropdownRelAddPerson.disabled = true;\r\n");
      out.write("             }\r\n           } \r\n         }\r\n         // End STGAP00017013: MR-095  \r\n         \r\n       }\r\n       else if (frmPersonDetail.selSzCdStagePersType.options.value == 'PRN')\r\n       {\r\n         populateDropdown( frmPersonDetail.selSzCdStagePersRelInt , frmPersonDetail.selSzCdStagePersRelInt.options.value, prnOneCodes );\r\n         var relationship = \"");
      out.print( StringHelper.getNonNullString(szCdStagePersRelInt) );
      out.write("\";\r\n         document.frmPersonDetail.selSzCdStagePersRelInt.value = relationship;\r\n         //SMS 56827 MR-066\r\n         if(relationship == \"\"|| relationship == null){\r\n           frmPersonDetail.selSzCdStagePersRelInt.value = \"");
      out.print(  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  );
      out.write("\";\r\n         }\r\n         // STGAP00017013: MR-095\r\n         if (frmPersonDetail.selSzCdStagePersRelInt.options.value != null && frmPersonDetail.selSzCdStagePersRelInt.options.value != \"\")\r\n         {\r\n           for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n           {\r\n             var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n             var dropdownTypeAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n             var dropdownRelAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);\r\n           \r\n             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation\r\n             if ((checkboxName.checked == false) \r\n             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == \"\")\r\n             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == \"\"))\r\n             {\r\n               checkboxName.disabled = false;\r\n               checkboxName.checked = false;\r\n           \r\n               clearDropdown(dropdownTypeAddPerson);\r\n               dropdownTypeAddPerson.disabled = true; \r\n               clearDropdown(dropdownRelAddPerson);\r\n               dropdownRelAddPerson.disabled = true;\r\n");
      out.write("             }\r\n           } \r\n         }\r\n         else\r\n         {\r\n         for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n           {\r\n             var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n             var dropdownTypeAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n             var dropdownRelAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);\r\n           \r\n             // Do not clear the Type and Relationship dropdowns if the page hits the custom validation\r\n             if ((checkboxName.checked == false) \r\n             && (dropdownTypeAddPerson.options.value == null || dropdownTypeAddPerson.options.value == \"\")\r\n             && (dropdownRelAddPerson.options.value == null || dropdownRelAddPerson.options.value == \"\"))\r\n             {\r\n               checkboxName.disabled = true;\r\n               checkboxName.checked = false;\r\n           \r\n               clearDropdown(dropdownTypeAddPerson);\r\n               dropdownTypeAddPerson.disabled = true; \r\n               clearDropdown(dropdownRelAddPerson);\r\n               dropdownRelAddPerson.disabled = true;\r\n");
      out.write("             }\r\n           }\r\n         }\r\n         // End STGAP00017013: MR-095 \r\n         \r\n       }\r\n       else\r\n       {\r\n         clearDropdown( frmPersonDetail.selSzCdStagePersRelInt );\r\n         // STGAP00017013: MR-095\r\n         for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n         {\r\n           var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n           var dropdownTypeAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n           var dropdownRelAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);\r\n         \r\n           checkboxName.disabled = true;\r\n           checkboxName.checked = false;\r\n           \r\n           clearDropdown(dropdownTypeAddPerson);\r\n           dropdownTypeAddPerson.disabled = true; \r\n           clearDropdown(dropdownRelAddPerson);\r\n           dropdownRelAddPerson.disabled = true;       \r\n         } \r\n         // End STGAP00017013: MR-095    \r\n         \r\n       }\r\n    }\r\n    else\r\n    {\r\n       clearDropdown( frmPersonDetail.selSzCdStagePersRelInt );\r\n    }\r\n");

  }

      out.write(" \r\n}\r\n\r\n// STGAP00017013: MR-095\r\nfunction disableAddPerson()\r\n{\r\n  if (frmPersonDetail.selSzCdStagePersRelInt.options.value == null || frmPersonDetail.selSzCdStagePersRelInt.options.value == \"\")\r\n  {\r\n    for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n    {\r\n      var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n      var dropdownTypeAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n      var dropdownRelAddPerson = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);\r\n         \r\n      checkboxName.disabled = true;\r\n      checkboxName.checked = false;\r\n           \r\n      clearDropdown(dropdownTypeAddPerson);\r\n      dropdownTypeAddPerson.disabled = true; \r\n      clearDropdown(dropdownRelAddPerson);\r\n      dropdownRelAddPerson.disabled = true;       \r\n    }\r\n  }\r\n  else\r\n  {\r\n    for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n    {\r\n      var checkboxName = eval(\"document.frmPersonDetail.cbxName_\" + i); \r\n      checkboxName.disabled = false;\r\n    }\r\n  }\r\n}\r\n\r\nfunction enableDropdowns()\r\n{\r\n  for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n  {\r\n    var checkboxName1 = eval(\"document.frmPersonDetail.cbxName_\" + i);  \r\n    var dropdownTypeAddPerson1 = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);   \r\n    var dropdownRelAddPerson1 = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);   \r\n\r\n    var isChecked = checkboxName1.checked;\r\n    var cdType = frmPersonDetail.selSzCdStagePersType.options.value;\r\n    var cdRel = frmPersonDetail.selSzCdStagePersRelInt.options.value;\r\n                \r\n    if (isChecked) \r\n    {      \r\n      if (cdType == 'COL')\r\n      {\r\n        if ((dropdownTypeAddPerson1.options.value == null || dropdownTypeAddPerson1.options.value == \"\")\r\n           && (dropdownTypeAddPerson1.diabled == true || dropdownRelAddPerson1.disabled == true))\r\n        { \r\n          dropdownTypeAddPerson1.disabled = false;\r\n          dropdownRelAddPerson1.disabled = false;    \r\n          populateDropdown(dropdownTypeAddPerson1, cdType, typeCodes);\r\n          populateDropdown(dropdownRelAddPerson1 , cdRel, colOneCodes );\r\n");
      out.write("        }\r\n      }\r\n      else if (cdType == 'PRN')\r\n      {\r\n        if ((dropdownTypeAddPerson1.options.value == null || dropdownTypeAddPerson1.options.value == \"\")\r\n           && (dropdownTypeAddPerson1.diabled == true || dropdownRelAddPerson1.disabled == true))\r\n        { \r\n          dropdownTypeAddPerson1.disabled = false;\r\n          dropdownRelAddPerson1.disabled = false;\r\n          populateDropdown(dropdownTypeAddPerson1, cdType, typeCodes);     \r\n          populateDropdown(dropdownRelAddPerson1 , cdRel, prnOneCodes );\r\n        }  \r\n      }            \r\n    }       \r\n    else \r\n    {   \r\n      clearDropdown(dropdownTypeAddPerson1);\r\n      dropdownTypeAddPerson1.disabled = true; \r\n      clearDropdown(dropdownRelAddPerson1);\r\n      dropdownRelAddPerson1.disabled = true;          \r\n    }\r\n  } \r\n}\r\n\r\nfunction enableRelDropdown()\r\n{\r\n  for (i = 1; i <= ");
      out.print( addPersonToStagesArray.getUlRowQty() );
      out.write(" ; i++)    \r\n  {  \r\n    var dropdownTypeAddPerson1 = eval(\"document.frmPersonDetail.selSzCdStagePersTypeAddPerson_\" + i);  \r\n    var dropdownRelAddPerson1 = eval(\"document.frmPersonDetail.selSzCdStagePersRelIntHistory_\" + i);  \r\n    if ((dropdownTypeAddPerson1.options.value == 'COL') \r\n    && (dropdownRelAddPerson1.options.value == null || dropdownRelAddPerson1.options.value == \"\"))\r\n    {      \r\n      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, colOneCodes);\r\n    } \r\n    else if ((dropdownTypeAddPerson1.options.value == 'PRN')\r\n    && (dropdownRelAddPerson1.options.value == null || dropdownRelAddPerson1.options.value == \"\"))\r\n    {\r\n      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, prnOneCodes);\r\n    }\r\n    // This covers the dropdown change from PRN to COL\r\n    else if (dropdownTypeAddPerson1.options.value == 'COL') \r\n    {      \r\n      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, colOneCodes);\r\n    } \r\n    // This covers the dropdown change from COL to PRN\r\n");
      out.write("    else if (dropdownTypeAddPerson1.options.value == 'PRN')\r\n    {\r\n      populateDropdown(dropdownRelAddPerson1, dropdownRelAddPerson1.options.value, prnOneCodes);\r\n    }\r\n    else if (dropdownTypeAddPerson1.options.value != 'COL' && dropdownTypeAddPerson1.options.value != 'PRN')\r\n    {\r\n      clearDropdown(dropdownRelAddPerson1);\r\n    }  \r\n  } \r\n}\r\n// End STGAP00017013: MR-095\r\n\r\n// Check the value of DOD\r\n");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("\r\n\r\n// SIR 19068 onblur of the dob field calls this function to set the age field.\r\nfunction getAge()\r\n{\r\n  calculateAge( frmPersonDetail.txtDateDtPersonBirth, frmPersonDetail.txtLNbrPersonAge );\r\n}\r\n\r\nfunction valueDOD()\r\n{\r\n  if ( frmPersonDetail.txtDateDtPersonDeath.value == \"\")\r\n  {\r\n    clearDropdown( frmPersonDetail.selSzCdPersonDeath );\r\n  }\r\n  else if ( frmPersonDetail.txtDateDtPersonDeath.value != \"\")\r\n  {\r\n    populateDropdown( frmPersonDetail.selSzCdPersonDeath , \"\", reasonDeathCodes );\r\n  }\r\n}\r\n\r\nfunction setMergeParms( loopCount )\r\n{\r\n  frmPersonDetail.hdnMergeLoopCount.value = loopCount;\r\n}\r\n\r\nfunction setIncomeParms( tsIncomeLastUpdate, ulIdIncRsrc, loopCount )\r\n{\r\n  frmPersonDetail.hdnTsIncomeLastUpdate.value = tsIncomeLastUpdate;\r\n  frmPersonDetail.hdnUlIdIncRsrc.value = ulIdIncRsrc;\r\n  frmPersonDetail.hdnIncLoopCount.value = loopCount;\r\n}\r\n\r\nfunction setEduParms( tsEduLastUpdate, ulIdEdhist, loopCount )\r\n{\r\n  frmPersonDetail.hdnTsEduLastUpdate.value = tsEduLastUpdate;\r\n  frmPersonDetail.hdnUlIdEdhist.value = ulIdEdhist;\r\n");
      out.write("  frmPersonDetail.hdnEduLoopCount.value = loopCount;\r\n}\r\n\r\nfunction setFAParms( tsFALastUpdate, ulIdIndivTraining, loopCount )\r\n{\r\n  frmPersonDetail.hdnTsFALastUpdate.value = tsFALastUpdate;\r\n  frmPersonDetail.hdnUlIdIndivTraining.value = ulIdIndivTraining;\r\n  frmPersonDetail.hdnFALoopCount.value = loopCount;\r\n}\r\n\r\nfunction deletePersonDetail()\r\n{\r\n  var bRetPerson = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_PERS_STAGE_DEL ) );
      out.write("');\r\n  return bRetPerson;\r\n}\r\n\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmPersonDetail');\r\n}\r\n\r\nfunction mergeEmployee()\r\n{\r\n  if (frmPersonDetail.hdnBIndActiveStatus.value == \"Y\")\r\n  {\r\n    var bMergePerson = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_MERGE_EMP_IN ) );
      out.write("');\r\n    return bMergePerson;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\n//SIR 23372 - Will not allow a user to generate form cfiv0400.htm\r\n//if the case is merged.\r\nfunction mergeCase()\r\n{\r\n  var bLaunchcfiv0400 = ");
      out.print( merge );
      out.write(";\r\n\r\n  if ( bLaunchcfiv0400 == true )\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_MERGE_STAGE_INV ) );
      out.write("');\r\n    return false;\r\n  }\r\n}\r\n\r\nfunction deleteRow( rowCount, buttonGroupName)\r\n{\r\n  if (!isRadioChecked( rowCount, buttonGroupName) )\r\n  {\r\n    return false;\r\n  }\r\n  if (isPageChanged())\r\n  {\r\n    var bDelete = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEF_CONT ) );
      out.write("');\r\n    return bDelete;\r\n  }\r\n  else\r\n  {\r\n    var bRow = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n    return bRow;\r\n  }\r\n}\r\n\r\nfunction addEdu()\r\n{\r\n  if (frmPersonDetail.hdnWithdrawnDate.value == \"\")\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_PREV_SCHOOL_DATE_GRADE ) );
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\n//  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n// make sure that a radiobutton from button group is checked before delete.\r\nfunction isRadioChecked(arrayLength, buttonGroupName)\r\n{\r\n  var bRadio = false;\r\n  var listRb = document.getElementsByName(buttonGroupName);\r\n  for ( i = 0; i < arrayLength ; i++ )\r\n  {\r\n    bRadio = listRb[i].checked;\r\n    if ( bRadio )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  if ( !bRadio )\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n  }\r\n  return bRadio;\r\n}\r\n\r\nfunction verifyReport()\r\n{\r\n  var reportVal = document.Reports.report_CLEAN.value;\r\n  if ( reportVal.indexOf( \"civ15\" ) != -1 || reportVal.indexOf( \"civ33\" ) != -1)\r\n  {\r\n    if (isFormChanged(frmPersonDetail))\r\n    {\r\n      alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_DATA_CHANGED));
      out.write("');\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      return true;\r\n    }\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\n//-- SIR STGAP00000695\r\n//-- See Javascript call at bottom of page code for description.\r\nfunction cleanDynamicSelects()\r\n{\r\n  CleanSelect(document.frmPersonDetail.selSzCSeCarGiver);\r\n  CleanSelect(document.frmPersonDetail.selSzPutativeFather);\r\n  CleanSelect(document.frmPersonDetail.selSzLegalFather);\r\n  CleanSelect(document.frmPersonDetail.selSzBioFather);\r\n  CleanSelect(document.frmPersonDetail.selSzLegalMother);\r\n  CleanSelect(document.frmPersonDetail.selSzBioMother);\r\n}\r\n\r\n/*STGAP00015485: MR-056 Display the Caregiver/Parental Relationship Information for Child section for children under age 18 years*/\r\nfunction displayRelInfoSection()\r\n{\r\n    var dob = document.frmPersonDetail.txtDateDtPersonBirth.value;\r\n    age = getAgeFromDOB(dob);\r\n    if(age >= 0 && age < 18){\r\n       toggleVisibility('relInfoForChild', 'block');\r\n    }else{\r\n       toggleVisibility('relInfoForChild', 'none');\r\n");
      out.write("    }\r\n}\r\n\r\nfunction enableSsiQuestions()\r\n{\r\n    var bSsiAppSubmit = getSelectedRadioValue(document.frmPersonDetail.rbSsiAppSubmitted);\r\n\r\n    if(bSsiAppSubmit != null && bSsiAppSubmit != \"Y\"){\r\n      resetCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);\r\n      disableCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);\r\n    }else{\r\n      enableCheckboxRadio(document.frmPersonDetail.rbSsiMedDsbltyReqMet);\r\n    }\r\n\r\n    var bSsiMedDsbltyReqMet = getSelectedRadioValue(document.frmPersonDetail.rbSsiMedDsbltyReqMet);\r\n\r\n    if (bSsiMedDsbltyReqMet != null && bSsiMedDsbltyReqMet != \"Y\" ){\r\n      resetCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);\r\n      disableCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);\r\n    }else{\r\n      enableCheckboxRadio(document.frmPersonDetail.rbSsiRecipient);\r\n    }\r\n    \r\n    var bSsiRecipient = getSelectedRadioValue(document.frmPersonDetail.rbSsiRecipient);\r\n\r\n    if (bSsiRecipient != null && bSsiRecipient != \"Y\" ){\r\n      resetCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);\r\n");
      out.write("      disableCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);\r\n    }else{\r\n      enableCheckboxRadio(document.frmPersonDetail.rbSsiDfcsPayee);\r\n    }\r\n}\r\n\r\n/*STGAP00015485: MR-056 Calculate the age of the person*/\r\nfunction getAgeFromDOB(dobAsString){\r\n    dob = new Date(Date.parse(dobAsString));\r\n    today = new Date();\r\n\r\n    dobDay = dob.getDate();\r\n    dobMonth = dob.getMonth();\r\n    dobYear = dob.getFullYear();\r\n\r\n    todayDay = today.getDate();\r\n    todayMonth = today.getMonth();\r\n    todayYear = today.getFullYear();\r\n\r\n    age = todayYear - dobYear;\r\n    // If the child is not yet 1 year old\r\n    // or the user has entered an invalid (future) date\r\n    // return 0.\r\n    if (age == 0) {\r\n      if(( todayMonth < dobMonth ) ||\r\n             ( ( dobMonth == todayMonth ) && ( todayDay < dobDay ) )){\r\n       return -1;\r\n      }else{\r\n       return 0;\r\n      }\r\n    }else if(age < 0 ){\r\n      return -1\r\n    }\r\n    \r\n    // If the person has not had their bday yet, subtract a year.\r\n    if (( todayMonth < dobMonth ) ||\r\n");
      out.write("             ( ( dobMonth == todayMonth ) && ( todayDay < dobDay ) )) {\r\n      age = age - 1;\r\n    }\r\n    return age;\r\n}\r\n\r\n//SMS 56827 MR-066 check for Duplicate Person\r\nfunction checkForDuplicatePerson(){\r\n         var errorCode = '");
      out.print( (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") );
      out.write("';\r\n         if (errorCode == '");
      out.print( Messages.MSG_DUPLICATE_NOT_ALLOWED );
      out.write("')\r\n         {\r\n              if (confirm( '");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_NOT_ALLOWED));
      out.write("' )) {\r\n                   document.frmPersonDetail.hdnBIndSsnCheck.value = 'N';\r\n                   cancelValidation();\r\n                   submitValidateForm('frmPersonDetail', '/person/PersonDetail/savePersonDetail');\r\n              }else{\r\n                document.frmPersonDetail.hdnBIndSsnCheck.value = 'Y';\r\n              }\r\n         }\r\n}\r\n\r\n//End Java Script\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPersonDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonDetail/savePersonDetail");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
/* Begin Detail */
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n     <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAll()\">Expand All</a>&nbsp;\r\n     <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAll()\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"8\">Person Name</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("First");
          _jspx_th_impact_validateInput_0.setConstraint("Name12");
          _jspx_th_impact_validateInput_0.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(first));
          _jspx_th_impact_validateInput_0.setSize("12");
          _jspx_th_impact_validateInput_0.setMaxLength("12");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Middle");
          _jspx_th_impact_validateInput_1.setConstraint("Name12");
          _jspx_th_impact_validateInput_1.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_1.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(middle));
          _jspx_th_impact_validateInput_1.setSize("12");
          _jspx_th_impact_validateInput_1.setMaxLength("12");
          _jspx_th_impact_validateInput_1.setTabIndex(4);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Last");
          _jspx_th_impact_validateInput_2.setConstraint("Name22");
          _jspx_th_impact_validateInput_2.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(last));
          _jspx_th_impact_validateInput_2.setSize("22");
          _jspx_th_impact_validateInput_2.setMaxLength("22");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Suffix");
          _jspx_th_impact_validateSelect_0.setName("selSzCdNameSuffix");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSUFFIX2");
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(suffix));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n </table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"7\">Demographics</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Gender");
          _jspx_th_impact_validateSelect_1.setName("selCdPersonSex");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(gender));
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Marital");
          _jspx_th_impact_validateSelect_2.setName("selSzCdPersonMaritalStatus");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CMARSTAT");
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW  );
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(marital));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n    <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Title");
          _jspx_th_impact_validateSelect_3.setName("selSzCdTitle");
          _jspx_th_impact_validateSelect_3.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_3.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CTITLE");
          _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(title));
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Maiden Name");
          _jspx_th_impact_validateInput_3.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_3.setName("txtSzTxtMaidenName");
          _jspx_th_impact_validateInput_3.setSize("20");
          _jspx_th_impact_validateInput_3.setMaxLength("20");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(maidenName));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDateDtPersonBirth");
          _jspx_th_impact_validateDate_0.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'; displayRelInfoSection();");
          _jspx_th_impact_validateDate_0.setOnBlur("getAge( );");
          _jspx_th_impact_validateDate_0.setLabel("DOB");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate( birth ));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Age");
          _jspx_th_impact_validateInput_4.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_4.setName("txtLNbrPersonAge");
          _jspx_th_impact_validateInput_4.setSize("3");
          _jspx_th_impact_validateInput_4.setMaxLength("3");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.NEW + EditableMode.EDIT  );
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatInt(age));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setChecked(FormattingHelper.formatString(cinv04so.getBIndPersonDobApprox()));
          _jspx_th_impact_validateInput_5.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setName("cbxBIndPersonDobApprox");
          _jspx_th_impact_validateInput_5.setLabel("Approximate");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Language");
          _jspx_th_impact_validateSelect_4.setName("selSzCdPersonLanguage");
          _jspx_th_impact_validateSelect_4.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setCodesTable("CLANG");
          _jspx_th_impact_validateSelect_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(language));
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Living Arrangement");
          _jspx_th_impact_validateSelect_5.setName("selSzCdPersonLivArr");
          _jspx_th_impact_validateSelect_5.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_5.setOrderBy("decode");
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setCodesTable("CLIVARR");
          _jspx_th_impact_validateSelect_5.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(living));
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Occupation");
          _jspx_th_impact_validateInput_6.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_6.setName("txtSzTxtOccupation");
          _jspx_th_impact_validateInput_6.setSize("20");
          _jspx_th_impact_validateInput_6.setMaxLength("20");
          _jspx_th_impact_validateInput_6.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString(occupation));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setLabel("Religion");
          _jspx_th_impact_validateSelect_6.setName("selSzCdPersonReligion");
          _jspx_th_impact_validateSelect_6.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_6.setCodesTable("CRELIGNS");
          _jspx_th_impact_validateSelect_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_6.setValue( FormattingHelper.formatString(religion));
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDateDtPersonDeath");
          _jspx_th_impact_validateDate_1.setLabel("DOD");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setOnBlur("valueDOD()");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setValue( DOD );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
/* If the page is in View mode just display the value returned from the database */
      if (overallPageMode.equals(PageModeConstants.VIEW) || Sets.isInSet(Sets.E, request)) {
        /* if Reason For death is blank, print out a blank input field, otherwise, look up the decode */
        if (reasonDeath == null || StringHelper.EMPTY_STRING.equals(reasonDeath)) {

          
          out.write("\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Reason For Death");
          _jspx_th_impact_validateInput_7.setName("selSzCdPersonDeath");
          _jspx_th_impact_validateInput_7.setSize("20");
          _jspx_th_impact_validateInput_7.setMaxLength("20");
          _jspx_th_impact_validateInput_7.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setValue("");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    ");
} else {

          
          out.write("\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Reason For Death");
          _jspx_th_impact_validateInput_8.setName("selSzCdPersonDeath");
          _jspx_th_impact_validateInput_8.setSize("20");
          _jspx_th_impact_validateInput_8.setMaxLength("20");
          _jspx_th_impact_validateInput_8.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setValue(  Lookup.simpleDecodeSafe( "CRSNFDTH", reasonDeath  ) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    ");
}
      } else {

        
          out.write("\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setLabel("Reason For Death");
          _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_7.setName("selSzCdPersonDeath");
          _jspx_th_impact_validateSelect_7.setStyle("WIDTH: 150px");
          _jspx_th_impact_validateSelect_7.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
          _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_7.setCodesTable("");
          _jspx_th_impact_validateSelect_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_7.setValue(FormattingHelper.formatString(reasonDeath));
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
}

      
          out.write("\r\n  </tr>\r\n  \r\n  ");
// Display these Options dropdown only if we in ADD
      if ("A".equals(cReqFuncCd) || cReqFuncCd == null) {

          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("SSN");
          _jspx_th_impact_validateInput_9.setConstraint("SocialSecurityNumber");
          _jspx_th_impact_validateInput_9.setName("txtSzNbrPersonSSNNumber");
          _jspx_th_impact_validateInput_9.setSize("11");
          _jspx_th_impact_validateInput_9.setMaxLength("11");
          _jspx_th_impact_validateInput_9.setValue( SSN );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setEditableMode(EditableMode.NEW );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  \r\n   ");

   }

          out.write("\r\n  <tr>\r\n  \t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setLabel("Email");
          _jspx_th_impact_validateInput_10.setConstraint("Email");
          _jspx_th_impact_validateInput_10.setName("txtSzTxtEmail");
          _jspx_th_impact_validateInput_10.setSize("50");
          _jspx_th_impact_validateInput_10.setMaxLength("70");
          _jspx_th_impact_validateInput_10.setValue(szTxtEmail);
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.EDIT + EditableMode.NEW );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>Additional Comments:</td>    \r\n    <td colspan=\"3\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setStyle("WIDTH: 300px");
          _jspx_th_impact_validateTextArea_0.setName("szTxtAddlCmnts");
          _jspx_th_impact_validateTextArea_0.setDisabled("");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(szTxtAddlCmnts);
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>         \r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>    \r\n    <td>&nbsp;</td>\r\n  </tr>\r\n </table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n      <th colspan=\"8\">Current Stage</th>\r\n  </tr>\r\n  <tr valign=\"top\">\r\n");
/* If we are in maintain person mode, don't make the rel/int and type required */
      String isRequired = ArchitectureConstants.TRUE;
      if (Sets.isInSet(Sets.B, request)) {
        isRequired = ArchitectureConstants.FALSE;
      } else {
        isRequired = ArchitectureConstants.TRUE;
      }

          out.write("\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setLabel("Type");
          _jspx_th_impact_validateSelect_8.setName("selSzCdStagePersType");
          _jspx_th_impact_validateSelect_8.setRequired(isRequired);
          _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_8.setCodesTable("CPRSNTYP");
          _jspx_th_impact_validateSelect_8.setOnChange("updateRelInt();");
          _jspx_th_impact_validateSelect_8.setDisabled( Sets.isInSetStr( Sets.B , request ) );
          _jspx_th_impact_validateSelect_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_8.setValue(FormattingHelper.formatString(type));
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzCdStagePersRole");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Role");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(role));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    ");
if ("false".equals(uRel)) {
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

          
          out.write("\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Relationship");
          _jspx_th_impact_validateInput_11.setName("selSzCdStagePersRelInt");
          _jspx_th_impact_validateInput_11.setSize("20");
          _jspx_th_impact_validateInput_11.setMaxLength("20");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setValue("");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("                              \r\n          </td>\r\n    ");
} else {

          
          out.write("    \r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Relationship");
          _jspx_th_impact_validateInput_12.setName("selSzCdStagePersRelInt");
          _jspx_th_impact_validateInput_12.setSize("20");
          _jspx_th_impact_validateInput_12.setMaxLength("20");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_12.setValue(  Lookup.simpleDecodeSafe( codesTable, szCdStagePersRelInt  ) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("                          \r\n          </td>\r\n    ");
}
      } else {

        
          out.write("        \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setLabel("Relationship");
          _jspx_th_impact_validateSelect_9.setBlankValue("true");
          _jspx_th_impact_validateSelect_9.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_9.setOrderBy("decode");
          _jspx_th_impact_validateSelect_9.setCodesTable(codesTable);
          _jspx_th_impact_validateSelect_9.setOnChange("disableAddPerson();");
          _jspx_th_impact_validateSelect_9.setRequired(isRequired);
          _jspx_th_impact_validateSelect_9.setName("selSzCdStagePersRelInt");
          _jspx_th_impact_validateSelect_9.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_9.setDisabled( Sets.isInSetStr( Sets.B , request ) );
          _jspx_th_impact_validateSelect_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_9.setValue(szCdStagePersRelInt);
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
}
      
          out.write("\r\n     ");
if(CodesTables.CSTAGES_INT.equals(szCdStage) || CodesTables.CSTAGES_INV.equals(szCdStage)
          || CodesTables.CSTAGES_DIV.equals(szCdStage) || CodesTables.CSTAGES_FPR.equals(szCdStage)
          || CodesTables.CSTAGES_ARI.equals(szCdStage)){ 
          out.write("\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setLabel("Member of Primary Caretaker's Household");
          _jspx_th_impact_validateSelect_10.setName("selCdStagePersMbrPrimCareHhl");
          _jspx_th_impact_validateSelect_10.setRequired(isRequired);
          _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_10.setDisabled( Sets.isInSetStr( Sets.B , request ) );
          _jspx_th_impact_validateSelect_10.setCodesTable( CodesTables.CMBRPCHH );
          _jspx_th_impact_validateSelect_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_10.setValue( cdPKHouseholdMember );
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
}else if(CodesTables.CSTAGES_SUB.equals(szCdStage) || CodesTables.CSTAGES_FSU.equals(szCdStage)){
       String caseName = "Member of " + GlobalData.getSzNmCase(request) + "'s Household";
    
          out.write("\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setLabel(caseName);
          _jspx_th_impact_validateSelect_11.setName("selCdStagePersMbrPrimCareHhl");
          _jspx_th_impact_validateSelect_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_11.setDisabled( Sets.isInSetStr( Sets.B , request ) );
          _jspx_th_impact_validateSelect_11.setCodesTable( CodesTables.CMBRPCHH );
          _jspx_th_impact_validateSelect_11.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_11.setValue( cdPKHouseholdMember );
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
} 
          out.write("\r\n  </tr>\r\n  <tr>\r\n  <td colspan=\"8\">\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr valign=\"top\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setChecked(FormattingHelper.formatString(reporter));
          _jspx_th_impact_validateInput_13.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setName("cbxBIndStagePersReporter");
          _jspx_th_impact_validateInput_13.setLabel("Reporter");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>     \r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setChecked(FormattingHelper.formatString(indLegalCustodian));
          _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setName("cbxBIndLegalCustodian");
          _jspx_th_impact_validateInput_14.setLabel("Legal Custodian");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setChecked(FormattingHelper.formatString(safetyRsrc));
          _jspx_th_impact_validateInput_15.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setName("cbxBIndSafetyResource");
          _jspx_th_impact_validateInput_15.setLabel("Safety Resource");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_16.setChecked(FormattingHelper.formatString(indRsrcHouseholdMember));
          _jspx_th_impact_validateInput_16.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setName("cbxBIndRsrcHouseholdMember");
          _jspx_th_impact_validateInput_16.setLabel("Member of Resource's Household");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_17.setChecked(FormattingHelper.formatString(indPaternityEstablished));
          _jspx_th_impact_validateInput_17.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_17.setType("checkbox");
          _jspx_th_impact_validateInput_17.setName("cbxBIndPaternityEstablished");
          _jspx_th_impact_validateInput_17.setLabel("Paternity Established");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_18.setChecked(FormattingHelper.formatString(indVerified));
          _jspx_th_impact_validateInput_18.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_18.setType("checkbox");
          _jspx_th_impact_validateInput_18.setName("cbxBIndVerified");
          _jspx_th_impact_validateInput_18.setLabel("Verified");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n  </tr>\r\n  </table>\r\n  </td>     \r\n  </tr>\r\n  \r\n  ");
// Display these Options dropdown only if we are in FCC or ADO stage
      if ("SUB".equals(szCdStage) || "ADO".equals(szCdStage)) {

          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("txtDateDtLegRepAssigned");
          _jspx_th_impact_validateDate_2.setLabel("Date Representation Assigned");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate( dtAssigned ));
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("txtDateDtLegRepUnassigned");
          _jspx_th_impact_validateDate_3.setLabel("Date Unassigned");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_3.setValue(FormattingHelper.formatDate( dtUnassigned ));
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  ");
}

          out.write("\r\n  <tr>\r\n");
// Display the Options dropdown only if we are not in new mode
      if (!(overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F, request))) {

          out.write("\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setLabel("View Options");
          _jspx_th_impact_validateSelect_12.setColspan("6");
          _jspx_th_impact_validateSelect_12.setName("selOption_CLEAN");
          _jspx_th_impact_validateSelect_12.setStyle("WIDTH: 300px");
          _jspx_th_impact_validateSelect_12.setExcludeOptions(excludeViews);
          _jspx_th_impact_validateSelect_12.setDisabled( Sets.isInSetStr( Sets.E + Sets.F , request ) );
          _jspx_th_impact_validateSelect_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_12.setCodesTable("CPERVIEW");
          _jspx_th_impact_validateSelect_12.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_validateSelect_12.setValue("");
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setForm("frmPersonDetail");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setFunction("cancelValidation()");
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonDetail/displayEventCase");
          _jspx_th_impact_ButtonTag_0.setDisabled( Sets.isInSetStr( Sets.E + Sets.F , request ) );
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n");
}

          out.write("\r\n  </tr>\r\n </table>\r\n \r\n  <!-- STGAP00017013: MR-095 Add Person to Active Stages section  -->\r\n  ");
 
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
    
          out.write("\r\n \t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("AddPerson");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Add Person to Active Stages");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<span><font color=\"#FF0000\">(Before adding, carefully review the\r\n\t\t\trelationship for this person in each of the stages listed below.\r\n\t\t\tModify the relationship, as necessary, to ensure accuracy.)</font></span>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\">\r\n\t\t\t<tr>\r\n\t            <th class=\"thList\">&nbsp;</th>\r\n\t            <th class=\"thList\">Stage ID</th>\r\n\t            <th class=\"thList\">Stage Name</th>\r\n\t            <th class=\"thList\">Stage</th>\r\n\t            <th class=\"thList\">Type</th>\r\n\t            <th class=\"thList\">Relationship</th>\r\n\t            <th class=\"thList\">Date Added</th>\r\n            </tr>\t\t\t\r\n            ");

			  loopCount = 0;
			  while (addPersonToStagesHistoryArray2.hasMoreElements()) {
			    CINV04SO_ADD_PERSON_TO_STAGES_HISTORY addPersonToStagesHistory = (CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) addPersonToStagesHistoryArray2
			                                                                                                                                          .nextElement();
			
              out.write("\r\n\t\t\t  <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">        \t\t\t\t \r\n                <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setName("cbxHistoryDisabled");
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setType("checkbox");
              _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_19.setDisabled("true");
              _jspx_th_impact_validateInput_19.setChecked("true");
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    </td>\r\n                <td>");
              out.print(addPersonToStagesHistory.getUlIdStage());
              out.write("\r\n                </td>\r\n                <td>\r\n          \t\t<NOBR>");
              out.print(addPersonToStagesHistory.getSzNmStage());
              out.write("\r\n          \t\t</NOBR>\r\n        \t\t</td>\r\n            \t<td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, addPersonToStagesHistory.getSzCdStage()));
              out.write("\r\n        \t\t</td>\r\n        \t\t<td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPRSNTYP, addPersonToStagesHistory.getSzCdStagePersType()));
              out.write("\r\n        \t\t</td>        \t\t\t\t \r\n        \t\t");
 if ("PRN".equals(addPersonToStagesHistory.getSzCdStagePersType())) { 
              out.write("\r\n                   <td>");
              out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CRELVICT", addPersonToStagesHistory.getSzCdStagePersRelInt()) ) );
              out.write("</td>\r\n                ");
 } else if ("COL".equals(addPersonToStagesHistory.getSzCdStagePersType())) { 
              out.write("\r\n                   <td>");
              out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CSRCRPTR", addPersonToStagesHistory.getSzCdStagePersRelInt()) ) );
              out.write("</td>\r\n                ");
 } 
              out.write("\r\n        \t\t<td>");
              out.print(FormattingHelper.formatDate(addPersonToStagesHistory.getDtDtAdded()));
              out.write("\r\n            \t</td>\r\n\t\t\t  </tr>\r\n\t\t\t  ");

			    loopCount++;
			  }
			  
              out.write("\r\n                 \r\n              ");

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
              
              out.write("\r\n                <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">        \t\t\t\t \r\n                  <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_20.setChecked(szCheckedStage);
              _jspx_th_impact_validateInput_20.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_20.setType("checkbox");
              _jspx_th_impact_validateInput_20.setName(cbxName);
              _jspx_th_impact_validateInput_20.setOnClick("enableDropdowns();");
              _jspx_th_impact_validateInput_20.setDisabled( checkBoxDisabled );
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  </td>\r\n                  <td>");
              out.print(addPersonToStages.getUlIdStage());
              out.write("\r\n                  </td>\r\n                  <td>\r\n          \t\t  <NOBR>");
              out.print(addPersonToStages.getSzNmStage());
              out.write("\r\n          \t\t  </NOBR>\r\n        \t\t  </td>\r\n        \t\t  <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, addPersonToStages.getSzCdStage()));
              out.write("\r\n        \t\t  </td>\r\n        \t\t  <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_13.setName(cdStagePersTypeAddPerson);
              _jspx_th_impact_validateSelect_13.setRequired( ArchitectureConstants.FALSE );
              _jspx_th_impact_validateSelect_13.setOnChange("enableRelDropdown();");
              _jspx_th_impact_validateSelect_13.setStyle("WIDTH: 80px");
              _jspx_th_impact_validateSelect_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_13.setCodesTable("CPRSNTYP");
              _jspx_th_impact_validateSelect_13.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateSelect_13.setValue(FormattingHelper.formatString(typeHistory));
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  </td>\r\n                  ");
 
                  if ("COL".equals(typeHistory)) {
                    codesTable = "CSRCRPTR";
                  } else if ("PRN".equals(typeHistory)) {
                    codesTable = "CRELVICT";
                  } 
              out.write("\r\n                  <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_14.setBlankValue("true");
              _jspx_th_impact_validateSelect_14.setOverrideDisplayBadCodes(true);
              _jspx_th_impact_validateSelect_14.setOrderBy("decode");
              _jspx_th_impact_validateSelect_14.setCodesTable(codesTable);
              _jspx_th_impact_validateSelect_14.setRequired( ArchitectureConstants.FALSE );
              _jspx_th_impact_validateSelect_14.setName( cdStagePersRelIntHistory);
              _jspx_th_impact_validateSelect_14.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_14.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_14.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateSelect_14.setValue(FormattingHelper.formatString(szCdStagePersRelIntHistory));
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  </td>\r\n                  <td>\r\n                  </td>                       \t\t         \r\n\t\t\t    </tr>\r\n\t\t\t    ");

			    loopCount++;
			    i++;
			  }   
			  
              out.write("\r\n\t  </table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
 } 
	 }
	
          out.write("\r\n\t<!-- End STGAP00017013: MR-095 -->\r\n ");

  // MR:062 - Changed variable initialization so that it will always show the Relationship section.  
  //          business logic in case there is a desire to revert the change later.
  String relInfoForChild = "block";
  if (birth != null) {
    if(DateHelper.getAge(birth) >= 0 && DateHelper.getAge(birth) < 18){
      relInfoForChild = "block";
    }
  }
  
          out.write("\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" id=\"relInfoForChild\" style=\"display: ");
          out.print( relInfoForChild );
          out.write("\"> \r\n  <tr>\r\n  <th colspan=\"8\">Caregiver/Parental Relationship Information for Child</th>\r\n  </tr> \r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_15.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_15.setLabel("Secondary Caregiver");
          _jspx_th_impact_validateSelect_15.setName("selSzCSeCarGiver");
          _jspx_th_impact_validateSelect_15.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_15.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_15.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_15.setValue(FormattingHelper.formatString(ulIdSecondaryCareGiver));
          _jspx_th_impact_validateSelect_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_15.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_15.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_15.setOptions(relationshipList);
          int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
          if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_16.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_16.setLabel("Putative Father");
          _jspx_th_impact_validateSelect_16.setName("selSzPutativeFather");
          _jspx_th_impact_validateSelect_16.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_16.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_16.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_16.setValue(FormattingHelper.formatString(ulIdPutativeFather));
          _jspx_th_impact_validateSelect_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_16.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_16.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_16.setOptions(fatherRelationshipList);
          int _jspx_eval_impact_validateSelect_16 = _jspx_th_impact_validateSelect_16.doStartTag();
          if (_jspx_th_impact_validateSelect_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_17.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_17.setLabel("Legal Father");
          _jspx_th_impact_validateSelect_17.setName("selSzLegalFather");
          _jspx_th_impact_validateSelect_17.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_17.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_17.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_17.setValue(FormattingHelper.formatString(ulIdLegalFather));
          _jspx_th_impact_validateSelect_17.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_17.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_17.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_17.setOptions(fatherRelationshipList);
          int _jspx_eval_impact_validateSelect_17 = _jspx_th_impact_validateSelect_17.doStartTag();
          if (_jspx_th_impact_validateSelect_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_18.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_18.setLabel("Biological Father");
          _jspx_th_impact_validateSelect_18.setName("selSzBioFather");
          _jspx_th_impact_validateSelect_18.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_18.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_18.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_18.setValue(FormattingHelper.formatString(ulIdBioFather));
          _jspx_th_impact_validateSelect_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_18.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_18.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_18.setOptions(fatherRelationshipList);
          int _jspx_eval_impact_validateSelect_18 = _jspx_th_impact_validateSelect_18.doStartTag();
          if (_jspx_th_impact_validateSelect_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_19.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_19.setLabel("Legal Mother");
          _jspx_th_impact_validateSelect_19.setName("selSzLegalMother");
          _jspx_th_impact_validateSelect_19.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_19.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_19.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_19.setValue(FormattingHelper.formatString(ulIdLegalMother));
          _jspx_th_impact_validateSelect_19.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_19.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_19.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_19.setOptions(motherRelationshipList);
          int _jspx_eval_impact_validateSelect_19 = _jspx_th_impact_validateSelect_19.doStartTag();
          if (_jspx_th_impact_validateSelect_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_20.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_20.setLabel("Biological Mother");
          _jspx_th_impact_validateSelect_20.setName("selSzBioMother");
          _jspx_th_impact_validateSelect_20.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_20.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_20.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_20.setValue(FormattingHelper.formatString(ulIdBioMother));
          _jspx_th_impact_validateSelect_20.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_20.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_20.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_20.setOptions(motherRelationshipList);
          int _jspx_eval_impact_validateSelect_20 = _jspx_th_impact_validateSelect_20.doStartTag();
          if (_jspx_th_impact_validateSelect_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n </table>\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\"> \r\n  <tr>\r\n  <th colspan=\"8\">Other Relationship Information</th>\r\n  </tr> \r\n  <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_21.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_21.setLabel("Side of Family");
          _jspx_th_impact_validateSelect_21.setName("selSzSideOfFamily");
          _jspx_th_impact_validateSelect_21.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_21.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_21.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_21.setCodesTable("CSIDEFAM");
          _jspx_th_impact_validateSelect_21.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_21.setDisabled( disableOtherRel );
          _jspx_th_impact_validateSelect_21.setValue(FormattingHelper.formatString(szCdSideOfFamily));
          int _jspx_eval_impact_validateSelect_21 = _jspx_th_impact_validateSelect_21.doStartTag();
          if (_jspx_th_impact_validateSelect_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n  </tr>\r\n    <tr>\r\n    <td>Special Relationship:</td>    \r\n    <td colspan=\"3\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setStyle("WIDTH: 300px");
          _jspx_th_impact_validateTextArea_1.setName("szTxtOtherRelationshipsCmnts");
          _jspx_th_impact_validateTextArea_1.setDisabled("");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(szTxtOtherRelationshipsCmnts);
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>         \r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>    \r\n    <td>&nbsp;</td>\r\n  </tr>  \r\n </table>\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">    \r\n  <tr>\r\n  <th colspan=\"8\">Additional Information</th>\r\n  </tr>\r\n  <tr>\r\n  <td class=\"formInput\">Status:</td>\r\n");
if (Sets.isInSet(Sets.E, request)) {

      
          out.write("\r\n  <td></td>\r\n");
} else if (overallPageMode.equals(PageModeConstants.NEW)) {

      
          out.write("\r\n  <td>Active</td>\r\n");
} else {

          out.write("\r\n  <td>");
          out.print(Lookup.simpleDecodeSafe("CPERSTAT", cinv04so.getCdPersonStatus()));
          out.write("</td>\r\n");
}

      
          out.write("\r\n  </tr>\r\n  <tr>\r\n  <td class=\"formInput\">Category:</td>\r\n");
if (Sets.isInSet(Sets.E, request)) {

      
          out.write("\r\n  <td></td>\r\n");
} else {
        if (personCategoryString != null) {

          out.write("\r\n  <td>\r\n  ");
          out.print(personCategoryString);
          out.write("\r\n  </td>\r\n");
}

      
          out.write("\r\n\r\n");
}

          out.write("\r\n  </tr>\r\n");
/*SIR:24002*/
          out.write("\r\n</table>\r\n<!-- Release 2 only -->\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n    <tr>\r\n      <td>\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDeletePer");
          _jspx_th_impact_ButtonTag_1.setFunction("return deletePersonDetail()");
          _jspx_th_impact_ButtonTag_1.setDisabled( Sets.isInSetStr( Sets.A + Sets.B , request ) );
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setForm("frmPersonDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonDetail/deletePersonDetail");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n</table>\r\n");
/* If we are in Set E (employee mode), or in New mode, do not display Address List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW))) {
          out.write("\r\n        ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/AddressListSubmodule/displayAddressList");
          _jspx_th_impact_include_0.setCallingPage("/person/PersonDetail/displayPersonDetail");
          _jspx_th_impact_include_0.setIncludingForm("frmPersonDetail");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName( AddressListConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_0.setValue( overallPageMode );
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br>\r\n");
}

      
          out.write("\r\n\r\n");
// If we are in New mode, do not display Phone Submodule
      if (!overallPageMode.equals(PageModeConstants.NEW)) {

          out.write("\r\n        ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_1.setPage("/submodule/PhoneSubmoduleConversation/PhoneSub");
          _jspx_th_impact_include_1.setCallingPage("/person/PersonDetail/displayPersonDetail");
          _jspx_th_impact_include_1.setIncludingForm("frmPersonDetail");
          _jspx_th_impact_include_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_1 = _jspx_th_impact_include_1.doStartTag();
          if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_1);
              _jspx_th_impact_attribute_1.setName( PhoneSubmoduleConversation.PAGE_MODE );
              _jspx_th_impact_attribute_1.setValue( overallPageMode );
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_include_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br>\r\n");
}

      
          out.write("\r\n\r\n\r\n");
// If we are in Set E (employee mode), or we are in Set F (Mobile) do not display Race Eth
      if (!(Sets.isInSet(Sets.E, request) || Sets.isInSet(Sets.F, request))) {

        
          out.write('\r');
          out.write('\n');
RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);

        
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );

          out.write("\r\n\r\n<script language=\"javascript\">\r\n// make sure at least one race checkbox is checked\r\nfunction isRaceChecked()\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n  var cbxGroupName = \"");
          out.print(RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\";\r\n  var bRace = areAnyChecked( cbxGroupName, raceLen );\r\n  return bRace;\r\n}\r\n\r\n// make sure that a radiobutton from the ethnicity radio button group is checked\r\nfunction isEthnicityChecked()\r\n{\r\n  var ethLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() );
          out.write(";\r\n  var bEth = false;\r\n  var ethnicityRb = document.getElementsByName(\"");
          out.print( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          out.write("\");\r\n  for ( i = 0; i < ethLen ; i++ )\r\n  {\r\n    bEth = ethnicityRb[i].checked;\r\n    if ( bEth )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  return bEth;\r\n}\r\n\r\n// make sure at least one race checkbox is checked or\r\n// a radiobutton from the ethnicity radio button group is checked\r\nfunction isRaceOrEthnicityChecked()\r\n{\r\n  var bRaceOrEth = false;\r\n  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );\r\n  return bRaceOrEth;\r\n}\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx )\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
          out.print( CodesTables.CRACE_UD  );
          out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("RaceEthnicity");
          _jspx_th_impact_ExpandableSectionTag_1.setId( RaceEthnicityHelper.RACE_CB_NAME + "1_Id");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Race/Ethnicity Detail");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded(Boolean.valueOf(isExpanded).booleanValue());
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <span class=\"formInstruct\">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th>Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(raceValues);
              _jspx_th_impact_codesCheckbox_0.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this)");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( raceEthnicitySubDBTabIndex );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <th>Ethnicity</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table width=\"100%\">\r\n        <tr>\r\n");

    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();

              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_21.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_21.setTabIndex( raceEthnicitySubDBTabIndex );
              _jspx_th_impact_validateInput_21.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
              _jspx_th_impact_validateInput_21.setType("radio");
              _jspx_th_impact_validateInput_21.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( ethnicity.getValue() );
              out.write("\r\n          </td>\r\n");

    }

              out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_22.setType("hidden");
              _jspx_th_impact_validateInput_22.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
              _jspx_th_impact_validateInput_22.setValue( personEthnicity );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);

      
          out.write("\r\n<br/>\r\n");
}//End Display only if not in Set E 
          out.write("\r\n\r\n");
/* Begin Tribal */
          out.write('\r');
          out.write('\n');
/* If we are in Set E (employee mode), or in New mode, do not display Tribal Information */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW))) {
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("Tribal");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Tribal and Additional Information");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_2.setId("btnDetail_Id");
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n      <tr>\r\n          <th colspan=\"5\">Tribal Information</th>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_23.setType("text");
              _jspx_th_impact_validateInput_23.setLabel("Percentage Heritage");
              _jspx_th_impact_validateInput_23.setConstraint("Score");
              _jspx_th_impact_validateInput_23.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_23.setName("szTxtPercentHeritage");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatString(szTxtPercentHeritage));
              _jspx_th_impact_validateInput_23.setSize("3");
              _jspx_th_impact_validateInput_23.setMaxLength("3");
              _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n          <td>&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>Tribal Member?</td>\r\n              <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setLabel("No");
              _jspx_th_impact_validateInput_24.setId("Tribal_Member_No");
              _jspx_th_impact_validateInput_24.setName("rbScrIndTribalMember");
              _jspx_th_impact_validateInput_24.setValue("no");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setChecked( tribalMemberNo );
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setLabel("Yes");
              _jspx_th_impact_validateInput_25.setId("Tribal_Member_Yes");
              _jspx_th_impact_validateInput_25.setName("rbScrIndTribalMember");
              _jspx_th_impact_validateInput_25.setValue("yes");
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setChecked( tribalMemberYes );
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_26.setType("radio");
              _jspx_th_impact_validateInput_26.setLabel("Unknown");
              _jspx_th_impact_validateInput_26.setId("Tribal_Member_Unknown");
              _jspx_th_impact_validateInput_26.setName("rbScrIndTribalMember");
              _jspx_th_impact_validateInput_26.setValue("unknown");
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setChecked( tribalMemberUnknown );
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_27.setType("text");
              _jspx_th_impact_validateInput_27.setLabel("Tribe Name");
              _jspx_th_impact_validateInput_27.setConstraint("Paragraph");
              _jspx_th_impact_validateInput_27.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_27.setName("szTxtTribalName");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_27.setValue(FormattingHelper.formatString(szTxtTribalName));
              _jspx_th_impact_validateInput_27.setSize("20");
              _jspx_th_impact_validateInput_27.setMaxLength("20");
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>Registered with Tribe?</td>\r\n          <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_28.setType("radio");
              _jspx_th_impact_validateInput_28.setLabel("No");
              _jspx_th_impact_validateInput_28.setId("Registered_With_Tribe_No");
              _jspx_th_impact_validateInput_28.setName("rbScrIndRegisteredWithTribe");
              _jspx_th_impact_validateInput_28.setValue("no");
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setChecked( registeredWithTribeNo );
              _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_29.setType("radio");
              _jspx_th_impact_validateInput_29.setLabel("Yes");
              _jspx_th_impact_validateInput_29.setId("Registered_With_Tribe_Yes");
              _jspx_th_impact_validateInput_29.setName("rbScrIndRegisteredWithTribe");
              _jspx_th_impact_validateInput_29.setValue("yes");
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setChecked( registeredWithTribeYes );
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_30.setType("radio");
              _jspx_th_impact_validateInput_30.setLabel("Unknown");
              _jspx_th_impact_validateInput_30.setId("Registered_With_Tribe_No_Unknown");
              _jspx_th_impact_validateInput_30.setName("rbScrIndRegisteredWithTribe");
              _jspx_th_impact_validateInput_30.setValue("unknown");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setChecked( registeredWithTribeUnknown );
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_31.setType("text");
              _jspx_th_impact_validateInput_31.setLabel("Tribal Registry #");
              _jspx_th_impact_validateInput_31.setConstraint("AlphaNumeric");
              _jspx_th_impact_validateInput_31.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_31.setName("szTxtTribalRegistryNumber");
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_31.setValue(FormattingHelper.formatString(szTxtTribalRegistryNumber));
              _jspx_th_impact_validateInput_31.setSize("20");
              _jspx_th_impact_validateInput_31.setMaxLength("15");
              _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      </tr>\r\n      <tr>\r\n          <th colspan=\"5\">Physical Description</th>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setLabel("Weight");
              _jspx_th_impact_validateInput_32.setConstraint("Numeric");
              _jspx_th_impact_validateInput_32.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_32.setName("szTxtWeight");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_32.setValue(FormattingHelper.formatInt(lQtyPersonWeight));
              _jspx_th_impact_validateInput_32.setSize("3");
              _jspx_th_impact_validateInput_32.setMaxLength("3");
              _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_33.setType("text");
              _jspx_th_impact_validateInput_33.setLabel("Height");
              _jspx_th_impact_validateInput_33.setConstraint("Numeric");
              _jspx_th_impact_validateInput_33.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_33.setName("szTxtHeightFt");
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_33.setValue(FormattingHelper.formatInt(sQtyPersonHeightFeet));
              _jspx_th_impact_validateInput_33.setSize("2");
              _jspx_th_impact_validateInput_33.setMaxLength("2");
              _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("ft\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setLabel("");
              _jspx_th_impact_validateInput_34.setConstraint("Numeric");
              _jspx_th_impact_validateInput_34.setOnChange("frmPersonDetail.hdnBSysIndCreateToDo.value = 'True'");
              _jspx_th_impact_validateInput_34.setName("szTxtHeightIn");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_34.setValue(FormattingHelper.formatInt(sQtyPersonHeightInches));
              _jspx_th_impact_validateInput_34.setSize("2");
              _jspx_th_impact_validateInput_34.setMaxLength("2");
              _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("in</td>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_22.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_22.setLabel("Eye Color");
              _jspx_th_impact_validateSelect_22.setName("selSzCdPersonEyeColor");
              _jspx_th_impact_validateSelect_22.setOverrideDisplayBadCodes(true);
              _jspx_th_impact_validateSelect_22.setRequired( ArchitectureConstants.FALSE );
              _jspx_th_impact_validateSelect_22.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_22.setCodesTable("CEYECOLR");
              _jspx_th_impact_validateSelect_22.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
              _jspx_th_impact_validateSelect_22.setDisabled( disableOtherRel );
              _jspx_th_impact_validateSelect_22.setValue(FormattingHelper.formatString(szCdPersonEyeColor));
              int _jspx_eval_impact_validateSelect_22 = _jspx_th_impact_validateSelect_22.doStartTag();
              if (_jspx_th_impact_validateSelect_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_23.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_23.setLabel("Hair Color");
              _jspx_th_impact_validateSelect_23.setName("selSzCdPersonHairColor");
              _jspx_th_impact_validateSelect_23.setOverrideDisplayBadCodes(true);
              _jspx_th_impact_validateSelect_23.setRequired( ArchitectureConstants.FALSE );
              _jspx_th_impact_validateSelect_23.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_23.setCodesTable("CHAIRCLR");
              _jspx_th_impact_validateSelect_23.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
              _jspx_th_impact_validateSelect_23.setDisabled( disableOtherRel );
              _jspx_th_impact_validateSelect_23.setValue(FormattingHelper.formatString(szCdPersonHairColor));
              int _jspx_eval_impact_validateSelect_23 = _jspx_th_impact_validateSelect_23.doStartTag();
              if (_jspx_th_impact_validateSelect_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      </tr>\r\n      <tr class=\"odd\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_24.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_24.setLabel("Highest Education");
              _jspx_th_impact_validateSelect_24.setName("selSzCdPersonHighestEduc");
              _jspx_th_impact_validateSelect_24.setOverrideDisplayBadCodes(true);
              _jspx_th_impact_validateSelect_24.setRequired( ArchitectureConstants.FALSE );
              _jspx_th_impact_validateSelect_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_24.setCodesTable("CHIGHEDU");
              _jspx_th_impact_validateSelect_24.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
              _jspx_th_impact_validateSelect_24.setDisabled( disableOtherRel );
              _jspx_th_impact_validateSelect_24.setValue(FormattingHelper.formatString(szCdPersonHighestEduc));
              int _jspx_eval_impact_validateSelect_24 = _jspx_th_impact_validateSelect_24.doStartTag();
              if (_jspx_th_impact_validateSelect_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         <td>&nbsp;</td>                     \r\n         <td>&nbsp;</td>\r\n      </tr>\r\n    </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n");
}

      
          out.write('\r');
          out.write('\n');
/* End Tribal */
          out.write("\r\n\r\n");
/* Begin Person Char */
          out.write('\r');
          out.write('\n');
/* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display Person Char List */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {

        
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("PersonChar");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Person Characteristics");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_3.setId("btnAdd_Id");
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\">Category</th>\r\n                           <th class=\"thList\">Characteristic</th>\r\n                           <th class=\"thList\">&nbsp;</th>\r\n                        </tr>\r\n");
loopCount = 0;
        //If cinv04 is not null, then check to see if BCdPersonChar is equal to "2", if it is, then
        //No characteristics applicable is checked on the Person Char page, set hidden field equal to
        //"Y" for custom Validation
        //!!! which message should be displayed if all rows are filtered out?
        String persChar = cinv24so.getBCdPersonChar();
        if (cinv24so != null && cinv24so.getBCdPersonChar() != null && "2".equals(persChar)) {

        
              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">None Diagnosed\r\n                        ");
              if (_jspx_meth_impact_validateInput_35(_jspx_th_impact_ExpandableSectionTag_3, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
}

        else if ("3".equals(persChar)) {

        
              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">Not Yet Diagnosed \r\n                        ");
              if (_jspx_meth_impact_validateInput_36(_jspx_th_impact_ExpandableSectionTag_3, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr> \r\n");
}
        //If the Characteristics array has no elemnts, then no characteristics have been selected
        //set hidden field equal to "N" for custom Validation
        else if (characteristics.isEmpty()) {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                           ");
              if (_jspx_meth_impact_validateInput_37(_jspx_th_impact_ExpandableSectionTag_3, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
}
        //If Charactaristics have been selected, set the hidden field to "Y" for custom Validation
        else {
          Iterator iterator = characteristics.iterator();
          while (iterator.hasNext()) {
            ROWCINV24SOG charRow = (ROWCINV24SOG) iterator.next();

              out.write("\r\n                        <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\" valign=\"top\">\r\n                            <td>");
              out.print(Lookup.simpleDecodeSafe("CCHRTCAT", charRow.getSzCdCharCategory()));
              out.write("</td>\r\n                            <td>\r\n                                ");
              out.print(Lookup.simpleDecodeSafe(charRow.getSzCdCharCategory(), charRow.getCdCharacteristic()));
              out.write("\r\n                                ");
              if (_jspx_meth_impact_validateInput_38(_jspx_th_impact_ExpandableSectionTag_3, _jspx_page_context))
                return;
              out.write("\r\n                            <td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

              out.write("\r\n           </table>\r\n       </div>\r\n        \r\n       ");
//STGAP00014806: SEC_SAU_EXCHANGE should see the detail button
        if(user.hasRight(UserProfile.SEC_SAU_EXCHANGE)){ 
              out.write("\r\n       <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n          <tr>\r\n            <td class=\"tableBG\">\r\n            <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_ButtonTag_2.setName("btnDetail");
              _jspx_th_impact_ButtonTag_2.setImg("btnDetail");
              _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_2.setFunction("cancelValidation()");
              _jspx_th_impact_ButtonTag_2.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_2.setAction("/person/PersonDetail/displayPersonChar");
              _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW + EditableMode.VIEW);
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n            </td>\r\n          </tr>\r\n      </table>\r\n      ");
}else{ 
              out.write("\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n          <tr>\r\n            <td class=\"tableBG\">\r\n            <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_ButtonTag_3.setName("btnDetail");
              _jspx_th_impact_ButtonTag_3.setImg("btnDetail");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setFunction("cancelValidation()");
              _jspx_th_impact_ButtonTag_3.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_3.setAction("/person/PersonDetail/displayPersonChar");
              _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n            </td>\r\n          </tr>\r\n      </table>\r\n      ");
} 
              out.write('\r');
              out.write('\n');

  // MR:092 - Only display SSI related questions section if primary child
  String displayForPrimaryChild = "none";
  if (CodesTables.CROLEALL_PC.equals(role)) {
    displayForPrimaryChild = "block";
  }

              out.write("\r\n      <table id=\"personCharacteristicsSsi\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" style=\"display: ");
              out.print( displayForPrimaryChild );
              out.write("\">\r\n         <tr class=\"odd\">\r\n\t          <td colspan=\"2\"><span class=\"formRequiredText\">*</span>Has an application been submitted to the SSA for SSI?</td>\r\n\t          <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_39.setType("radio");
              _jspx_th_impact_validateInput_39.setName("rbSsiAppSubmitted");
              _jspx_th_impact_validateInput_39.setValue("Y");
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_39.setChecked( String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiAppSubmitted())) );
              _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("Yes\r\n\t                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_40.setType("radio");
              _jspx_th_impact_validateInput_40.setName("rbSsiAppSubmitted");
              _jspx_th_impact_validateInput_40.setValue("N");
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setChecked( String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiAppSubmitted()))  );
              _jspx_th_impact_validateInput_40.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_40.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("No\r\n\t                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_41.setType("radio");
              _jspx_th_impact_validateInput_41.setName("rbSsiAppSubmitted");
              _jspx_th_impact_validateInput_41.setValue("U");
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setChecked( String.valueOf(CodesTables.CYESNOUN_U.equals(cinv04so.getCIndSsiAppSubmitted())) );
              _jspx_th_impact_validateInput_41.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_41.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("Unknown\r\n\t          </td>\r\n          </tr>\r\n         <tr class=\"odd\">\r\n            <td colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>Did the SSA determine that the child has met the medical or disability requirements for SSI?</td>\r\n            <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_42.setType("radio");
              _jspx_th_impact_validateInput_42.setLabel("Yes");
              _jspx_th_impact_validateInput_42.setId("rbSsiMedDsbltyReqMet_Yes");
              _jspx_th_impact_validateInput_42.setName("rbSsiMedDsbltyReqMet");
              _jspx_th_impact_validateInput_42.setValue("Y");
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setChecked( String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiMedDsbltyReqMet())) );
              _jspx_th_impact_validateInput_42.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_42.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_43.setType("radio");
              _jspx_th_impact_validateInput_43.setLabel("No");
              _jspx_th_impact_validateInput_43.setId("rbSsiMedDsbltyReqMet_No");
              _jspx_th_impact_validateInput_43.setName("rbSsiMedDsbltyReqMet");
              _jspx_th_impact_validateInput_43.setValue("N");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setChecked( String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiMedDsbltyReqMet())) );
              _jspx_th_impact_validateInput_43.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_43.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n         <tr class=\"odd\">\r\n            <td colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>Are SSI payments being made for the child?</td>\r\n            <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_44.setType("radio");
              _jspx_th_impact_validateInput_44.setLabel("Yes");
              _jspx_th_impact_validateInput_44.setId("rbSsiRecipient_Yes");
              _jspx_th_impact_validateInput_44.setName("rbSsiRecipient");
              _jspx_th_impact_validateInput_44.setValue("Y");
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setChecked( String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiRecipient())) );
              _jspx_th_impact_validateInput_44.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_44.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_45.setType("radio");
              _jspx_th_impact_validateInput_45.setLabel("No");
              _jspx_th_impact_validateInput_45.setId("rbSsiRecipient_No");
              _jspx_th_impact_validateInput_45.setName("rbSsiRecipient");
              _jspx_th_impact_validateInput_45.setValue("N");
              _jspx_th_impact_validateInput_45.setCssClass("formInput");
              _jspx_th_impact_validateInput_45.setChecked( String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiRecipient())) );
              _jspx_th_impact_validateInput_45.setOnClick("enableSsiQuestions();");
              _jspx_th_impact_validateInput_45.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n         <tr class=\"odd\">\r\n            <td colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>Is DFCS the representative payee?</td>\r\n            <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_46.setType("radio");
              _jspx_th_impact_validateInput_46.setLabel("Yes");
              _jspx_th_impact_validateInput_46.setId("rbSsiDfcsPayee_Yes");
              _jspx_th_impact_validateInput_46.setName("rbSsiDfcsPayee");
              _jspx_th_impact_validateInput_46.setValue("Y");
              _jspx_th_impact_validateInput_46.setCssClass("formInput");
              _jspx_th_impact_validateInput_46.setChecked( String.valueOf(CodesTables.CYESNOUN_Y.equals(cinv04so.getCIndSsiDfcsPayee())) );
              _jspx_th_impact_validateInput_46.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_47.setType("radio");
              _jspx_th_impact_validateInput_47.setLabel("No");
              _jspx_th_impact_validateInput_47.setId("rbSsiDfcsPayee_No");
              _jspx_th_impact_validateInput_47.setName("rbSsiDfcsPayee");
              _jspx_th_impact_validateInput_47.setValue("N");
              _jspx_th_impact_validateInput_47.setCssClass("formInput");
              _jspx_th_impact_validateInput_47.setChecked( String.valueOf(CodesTables.CYESNOUN_N.equals(cinv04so.getCIndSsiDfcsPayee())) );
              _jspx_th_impact_validateInput_47.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n      </table>\r\n      \r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n");
} /*End if in Set E, or New mode don't display this information */
          out.write("\r\n\r\n");
/* Begin Medication */
          out.write('\r');
          out.write('\n');
// If we are in New mode do not display Medication Submodule
      //if ( !(overallPageMode.equals( PageModeConstants.NEW )))
      //{
      
          out.write("\r\n        ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_2.setPage("/submodule/MedicationSubmoduleConversation/displayMedication");
          _jspx_th_impact_include_2.setCallingPage("/person/PersonDetail/displayPersonDetail");
          _jspx_th_impact_include_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_2.setIncludingForm("frmPersonDetail");
          int _jspx_eval_impact_include_2 = _jspx_th_impact_include_2.doStartTag();
          if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_2.doInitBody();
            }
            do {
              out.write("\r\n          ");
              if (_jspx_meth_impact_attribute_2(_jspx_th_impact_include_2, _jspx_page_context))
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_2);
              _jspx_th_impact_attribute_3.setName( MedicationSubmoduleConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_3.setValue( overallPageMode );
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_include_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n");
//}

      
          out.write('\r');
          out.write('\n');
/* End Medication */
          out.write("\r\n\r\n");
// If we are in New mode or in Sets F (Mobile), do not display Name History Submodule
      if (!(overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F, request))) {

          out.write("\r\n        ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_3.setPage("/submodule/NameHistorySubmoduleConversation/displayNameHistory");
          _jspx_th_impact_include_3.setCallingPage("/person/PersonDetail/displayPersonDetail");
          _jspx_th_impact_include_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_3.setIncludingForm("frmPersonDetail");
          int _jspx_eval_impact_include_3 = _jspx_th_impact_include_3.doStartTag();
          if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_3.doInitBody();
            }
            do {
              out.write("\r\n          ");
              if (_jspx_meth_impact_attribute_4(_jspx_th_impact_include_3, _jspx_page_context))
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_3);
              _jspx_th_impact_attribute_5.setName( NameHistorySubmoduleConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_5.setValue( overallPageMode );
              int _jspx_eval_impact_attribute_5 = _jspx_th_impact_attribute_5.doStartTag();
              if (_jspx_th_impact_attribute_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_include_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br>\r\n");
}

      
          out.write("\r\n\r\n");
// If we are in New mode, or the person is an employee (Set E), or we are in Mobile (Set F),
      // do not display Person Identifiers Submodule
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {

          out.write("\r\n        ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_4.setPage("/submodule/PersonIdentifiersSubmodule/displayPersonIDsListSubmodule");
          _jspx_th_impact_include_4.setCallingPage("/person/PersonDetail/displayPersonDetail");
          _jspx_th_impact_include_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_4.setIncludingForm("frmPersonDetail");
          int _jspx_eval_impact_include_4 = _jspx_th_impact_include_4.doStartTag();
          if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_4.doInitBody();
            }
            do {
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_4);
              _jspx_th_impact_attribute_6.setName( PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_6.setValue( overallPageMode );
              int _jspx_eval_impact_attribute_6 = _jspx_th_impact_attribute_6.doStartTag();
              if (_jspx_th_impact_attribute_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_include_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br>\r\n");
}

      
          out.write("\r\n\r\n");
// Begin Person Merge/Split
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

          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("personMerge");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Person Merge/Split");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_4.setId(mergeTab);
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n        <div id=\"scrollBar2\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n                 <table width=\"1400\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\">Forward name</th>\r\n                           <th class=\"thList\">ID Person Forward</th>\r\n                           <th class=\"thList\">Closed Name</th>\r\n                           <th class=\"thList\">ID Person Closed</th>\r\n                           <th class=\"thList\">Merge Date</th>\r\n                           <th class=\"thList\">Staff Name - Merge</th>\r\n                           <th class=\"thList\">Staff ID - Merge</th>\r\n                           <th class=\"thList\">Split Date</th>\r\n                           <th class=\"thList\">Staff Name - Split</th>\r\n                           <th class=\"thList\">Staff ID - Split</th>\r\n                        </tr>\r\n");
if (!mergeEnumeration.hasMoreElements()) {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
} else {
          while (mergeEnumeration.hasMoreElements()) {
            mergeRow = (ROWCCFC13SOG00) mergeEnumeration.nextElement();

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                        ");
/*MergeOnClick used to submit the row's parameters to hidden fields*/
              out.write("\r\n                        ");
String MergeOnClick = "setMergeParms( '" + loopCount + "' )";

            
              out.write("\r\n                            <td><a id='");
              out.print("mergeLinks" + loopCount);
              out.write("' tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" href=\"javascript:");
              out.print(MergeOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayMergeSplit' )\">");
              out.print(mergeRow.getSzScrNmPersMergeForward());
              out.write("</a></td>\r\n                            <td>");
              out.print(FormattingHelper.formatInt(mergeRow.getUlIdPersMergeForward()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(mergeRow.getSzScrNmPersMergeClosed()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatInt(mergeRow.getUlIdPersMergeClosed()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(mergeRow.getDtDtPersMerge()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(mergeRow.getSzScrNmPersMergeWrkr()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatInt(mergeRow.getUlIdPersMergeWrkr()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(mergeRow.getDtDtPersMergeSplit()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(mergeRow.getSzScrNmPersMrgSpltWrkr()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatInt(mergeRow.getUlIdPersMergeSplitWrkr()));
              out.write("</td>\r\n                        </tr>\r\n");
loopCount++;
          } // end for
        }

              out.write("\r\n           </table>\r\n        </div>\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n          <tr>\r\n          <td class=\"tableBG\">\r\n               <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_ButtonTag_4.setName("btnAddMerge");
              _jspx_th_impact_ButtonTag_4.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_4.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_4.setFunction("cancelValidation();  return mergeEmployee()");
              _jspx_th_impact_ButtonTag_4.setAction("/person/PersonDetail/addMergeSplit");
              _jspx_th_impact_ButtonTag_4.setDisabled(hideMergeAdd );
              _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT + EditableMode.VIEW + EditableMode.NEW);
              _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n           </td>\r\n      </tr>\r\n     </table>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n");
// end Person Merge/Split
      } //End if in New Mode, don't display this information

      
          out.write("\r\n\r\n\r\n");
// Begin Income and Resources
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

        
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("income");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Income and Resources");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_5.setId(incomeTab);
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n        <div id=\"scrollBar2\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n                 <table width=\"1400\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\"></th>\r\n                           <th class=\"thList\">Inc/Res</th>\r\n                           <th class=\"thList\">Inc/Res Type</th>\r\n                           <th class=\"thListRight\">Amount/Value</th>\r\n                           <th class=\"thList\">Start Date</th>\r\n                           <th class=\"thList\">End Date</th>\r\n                           <th class=\"thList\">Source/Employer</th>\r\n                           <th class=\"thList\">Accessible</th>\r\n                           <th class=\"thList\">Staff Name</th>\r\n                           <th class=\"thList\">Last Saved</th>\r\n                           <th class=\"thList\">Description</th>\r\n                           <th class=\"thList\">Verif Method</th>\r\n");
              out.write("                           <th class=\"thList\">Emp Address</th>\r\n                           <th class=\"thList\">Emp Phone</th>\r\n                        </tr>\r\n");
if (!incomeEnumeration.hasMoreElements()) {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"14\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
} else {
          while (incomeEnumeration.hasMoreElements()) {
            incomeRow = (ROWCCFC29SOG00) incomeEnumeration.nextElement();

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                        ");
/*IncOnClick used to submit the row's parameters to hidden fields */
              out.write("\r\n                        ");
String IncOnClick = "setIncomeParms( '" + incomeRow.getTsLastUpdate() + "', '" + incomeRow.getUlIdIncRsrc()
                                + "', '" + loopCount + "' )";

            
              out.write("\r\n                            <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_48.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_48.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_48.setValue("loopCount");
              _jspx_th_impact_validateInput_48.setType("radio");
              _jspx_th_impact_validateInput_48.setName("incSelect_CLEAN");
              _jspx_th_impact_validateInput_48.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_48.setOnClick(IncOnClick);
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\r\n                            <td>");
              out.print(incomeRow.getSzCdIncRsrcIncome());
              out.write("</td>\r\n                            <td><a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" href=\"javascript: ");
              out.print(IncOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayIncRsrc' )\">\r\n\r\n\r\n");
String incomeCodesTableString = "CINC";
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

              
              out.write("\r\n            ");
String type1 = Lookup.simpleDecodeSafe(incomeCodesTableString, incomeRow.getSzCdIncRsrcType());

              
              out.write("\r\n                                ");
              out.print(Lookup.simpleDecodeSafe(incomeCodesTableString, incomeRow.getSzCdIncRsrcType()));
              out.write("\r\n                                ");
} else {

              
              out.write("\r\n                                ");
String type2 = Lookup.simpleDecodeSafe(resourceCodesTableString, incomeRow.getSzCdIncRsrcType());

              
              out.write("\r\n                                ");
              out.print(Lookup.simpleDecodeSafe(resourceCodesTableString, incomeRow.getSzCdIncRsrcType()));
              out.write("\r\n                                ");
}

            
              out.write("</a>\r\n                            </td> \r\n                            <td class=\"alignRight\">");
              out.print(FormattingHelper.formatMoney(incomeRow.getLAmtIncRsrc()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(incomeRow.getDtDtIncRsrcFrom()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(incomeRow.getDtDtIncRsrcTo()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzSdsIncRrcsSource()));
              out.write("</td>\r\n\t\t\t");
 // STGAP00004122 - change col label from Not Acsbl to Accessible (above) and modify display logic accordingly
			String notAccessibleDB = FormattingHelper.formatString(incomeRow.getCIndIncRsrcNotAccess());
			String accessibleDisplay = ArchitectureConstants.Y.equals(notAccessibleDB) ? ArchitectureConstants.N : ArchitectureConstants.Y;
			
              out.write("\r\n                            <td>");
              out.print(accessibleDisplay);
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzNmPersonFull()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(incomeRow.getTsLastUpdate()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcDesc()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzSdsIncRsrcVerfMethod()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcSrcAddrStLn1()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatString(incomeRow.getSzTxtIncRsrcSrcPhoneNum()));
              out.write("</td>\r\n                        </tr>\r\n");
loopCount++;
          } // end for
        }

        
              out.write("\r\n           </table>\r\n         </div>");
/* this is where the "collapsedIncome" div tag ends */

        
              out.write("\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n      <tr>\r\n      <td class=\"tableBG\">\r\n      <!-- Delete button is removed for R1.  Version 6298 has the delete code. -->\r\n      &nbsp;\r\n      </td>\r\n      <td>\r\n         <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_ButtonTag_5.setName("btnIncRsrcDtl");
              _jspx_th_impact_ButtonTag_5.setImg("btnRequestSUCCESSData");
              _jspx_th_impact_ButtonTag_5.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_5.setFunction("cancelValidation();");
              _jspx_th_impact_ButtonTag_5.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_5.setAction("/person/PersonDetail/getIncRsrcDtl");
              _jspx_th_impact_ButtonTag_5.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_ButtonTag_6.setName("btnAddIncome");
              _jspx_th_impact_ButtonTag_6.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_6.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_6.setFunction("cancelValidation();");
              _jspx_th_impact_ButtonTag_6.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_6.setAction("/person/PersonDetail/addIncRsrc");
              _jspx_th_impact_ButtonTag_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n      </td>\r\n      </tr>\r\n      </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n");
// end Income and Resources
      } /*End Display only if not in Set E, or if not in New mode */

      
          out.write("\r\n\r\n");
// Begin Education
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

          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_6.setName("education");
          _jspx_th_impact_ExpandableSectionTag_6.setLabel("Education");
          _jspx_th_impact_ExpandableSectionTag_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_6.setId(eduTab);
          int _jspx_eval_impact_ExpandableSectionTag_6 = _jspx_th_impact_ExpandableSectionTag_6.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n              <div id=\"scrollBar2\" style=\"height:155px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\"></th>\r\n                           <th class=\"thList\">School Name</th>\r\n                           <th class=\"thList\">Enrolled</th>\r\n                           <th class=\"thList\">Grade</th>\r\n                           <th class=\"thList\">Withdrawn</th>\r\n                           <th class=\"thList\">Grade</th>\r\n                        </tr>\r\n");
if (!educationEnumeration.hasMoreElements()) {
          withdrawnDate = "ssss";

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
} else {
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

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                        ");
/* EduOnClick used to submit the row's parameters to hidden fields */
              out.write("\r\n                        ");
String EduOnClick = "setEduParms( '" + educationRow.getTsLastUpdate() + "', '"
                                + educationRow.getUlIdEdhist() + "', '" + loopCount + "' )";

            
              out.write("\r\n                            <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_validateInput_49.setId("eduRadio" + loopCount);
              _jspx_th_impact_validateInput_49.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_49.setValue("loopCount");
              _jspx_th_impact_validateInput_49.setType("radio");
              _jspx_th_impact_validateInput_49.setName("eduSelect_CLEAN");
              _jspx_th_impact_validateInput_49.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_49.setOnClick(EduOnClick);
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n                            <td><a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                              href=\"javascript: ");
              out.print(EduOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayEducation' )\">");
              out.print(schoolName);
              out.write("</a></td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(educationRow.getDtDtEdhistEnrollDate()));
              out.write("</td>\r\n                            <td>");
              out.print(Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistEnrollGrade()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate()));
              out.write("</td>\r\n                            <td>");
              out.print(Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistWithdrawnGrade()));
              out.write("</td>\r\n                        </tr>\r\n");
loopCount++;
          } // end for
        }

        
              out.write("\r\n           </table>\r\n              </div>");
/* this is where the "collapsedEducation" div tag ends */

        
              out.write("\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n      <tr>\r\n      <td class=\"tableBG\">\r\n      <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_ButtonTag_7.setName("btnAddEdu");
              _jspx_th_impact_ButtonTag_7.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_7.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_7.setFunction("cancelValidation(); return addEdu()");
              _jspx_th_impact_ButtonTag_7.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_7.setAction("/person/PersonDetail/addEducation");
              _jspx_th_impact_ButtonTag_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW);
              _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
              if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n      </td>\r\n      </tr>\r\n      </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br/>\r\n");
} /*End Display only if not in Set E, or page mode is new */

      
          out.write("\r\n\r\n");
/* If we are in Set E (employee mode), or in New mode, or Set F (Mobile) do not display FA Home */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {
        if ("FAD".equals(szCdStage)) {
          loopCount = 0;
          CFAD32SOG00 FARow = null;
          Enumeration FAEnumeration = FAArray.enumerateCFAD32SOG00();

          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_7.setName("FAHome");
          _jspx_th_impact_ExpandableSectionTag_7.setLabel("F/A Home Member Training");
          _jspx_th_impact_ExpandableSectionTag_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_7.setId("faRadio0");
          int _jspx_eval_impact_ExpandableSectionTag_7 = _jspx_th_impact_ExpandableSectionTag_7.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"10\">Current Year Training</th>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td width=\"30%\">\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("displayHrsCompletedInCurrentYr");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Hours Completed In Current Year");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( String.valueOf(trngHrsCompleted) );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n    <tr class=\"odd\">\r\n    <td width=\"30%\">\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDisplayOnlyField_2.setName("displayHrsRemainInCurrentYr");
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Hours Remaining In Current Year");
              _jspx_th_impact_validateDisplayOnlyField_2.setValue( String.valueOf(trngHrsRemain) );
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n  </table>\r\n              <div id=\"scrollBar2\" style=\"height:155px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n              \r\n                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                         <tr>\r\n                           <th class=\"thList\"></th>\r\n                           <th class=\"thList\">Date</th>\r\n                           <th class=\"thList\">Title</th>\r\n                           <th class=\"thList\">Type</th>\r\n                           <th class=\"thList\">Session Number</th>\r\n                           <th class=\"thList\">Hours</th>\r\n                           <!-- <th class=\"thList\">EC Hours</th> -->\r\n                        </tr>\r\n");
if (!FAEnumeration.hasMoreElements()) {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
} else {
            while (FAEnumeration.hasMoreElements()) {
              FARow = (CFAD32SOG00) FAEnumeration.nextElement();

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                        ");
/*FAOnClick used to submit the row's parameters to hidden fields */
              out.write("\r\n                        ");
String FAOnClick = "setFAParms( '" + FARow.getTsLastUpdate() + "', '" + FARow.getUlIdIndivTraining()
                                 + "', '" + loopCount + "' )";

              
              out.write("\r\n                            <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_50.setId("faRadio" + loopCount);
              _jspx_th_impact_validateInput_50.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_50.setValue("loopCount");
              _jspx_th_impact_validateInput_50.setType("radio");
              _jspx_th_impact_validateInput_50.setName("faSelect_CLEAN");
              _jspx_th_impact_validateInput_50.setDisabled(hideFAFlag );
              _jspx_th_impact_validateInput_50.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_50.setOnClick(FAOnClick);
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatDate(FARow.getDtDtIndivTrn()));
              out.write("</td>\r\n                            <td><a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                              href=\"javascript: ");
              out.print(FAOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmPersonDetail', '/person/PersonDetail/displayFAHome' )\">");
              out.print(FARow.getSzTxtIndivTrnTitle());
              out.write("</a></td>\r\n                            <td>");
              out.print(Lookup.simpleDecodeSafe("CFATRAIN", FARow.getSzCdIndivTrnType()));
              out.write("</td>\r\n                            <td>");
              out.print(FormattingHelper.formatInt(FARow.getSNbrIndivTrnSession()));
              out.write("</td>\r\n                            <td>");
              out.print(FARow.getLdNbrIndivTrnHrs());
              out.write("</td>\r\n                            <!-- <td>");
              out.print( FormattingHelper.formatString(FARow.getCIndIndivTrnEc()) );
              out.write("</td> -->\r\n                            \r\n                        </tr>\r\n");
loopCount++;
            } // end for
          }

          
              out.write("\r\n           </table>\r\n              </div>");
/* this is where the "collapsedFA" div tag ends */

          
              out.write("\r\n      <table\r\n                              width=\"100%\"\r\n                              cellpadding=\"3\"\r\n                              cellspacing=\"0\">\r\n      <tr>\r\n      <td class=\"tableBG\">\r\n      ");
// Only display delete pushbutton if list has rows
          if (FAArray.getCFAD32SOG00Count() > 0) {

            
              out.write("\r\n         ");
String functionString = "cancelValidation(); return deleteRow( " + loopCount + ", 'faSelect_CLEAN' );";
              out.write("\r\n         ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_ButtonTag_8.setName("btnDeleteFA");
              _jspx_th_impact_ButtonTag_8.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_8.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_8.setNavAwayCk(false);
              _jspx_th_impact_ButtonTag_8.setFunction(functionString);
              _jspx_th_impact_ButtonTag_8.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_8.setDisabled(hideFAFlag );
              _jspx_th_impact_ButtonTag_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_ButtonTag_8.setAction("/person/PersonDetail/deleteFAHome");
              _jspx_th_impact_ButtonTag_8.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
              if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
}

          
              out.write("\r\n      </td>\r\n      <td class=\"tableBG\">\r\n         <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_ButtonTag_9.setName("btnAddFA");
              _jspx_th_impact_ButtonTag_9.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_9.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_9.setFunction("cancelValidation()");
              _jspx_th_impact_ButtonTag_9.setForm("frmPersonDetail");
              _jspx_th_impact_ButtonTag_9.setDisabled(hideFAFlag );
              _jspx_th_impact_ButtonTag_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_ButtonTag_9.setAction("/person/PersonDetail/addFAHome");
              _jspx_th_impact_ButtonTag_9.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_9 = _jspx_th_impact_ButtonTag_9.doStartTag();
              if (_jspx_th_impact_ButtonTag_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n      </td>\r\n      </tr>\r\n   </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* end FA */

        
          out.write('\r');
          out.write('\n');
} /* end FA display */
          out.write('\r');
          out.write('\n');
}/* End Display only if not in Set E, or mode is new */
          out.write("\r\n\r\n<hr>\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_10.setName("btnSave");
          _jspx_th_impact_ButtonTag_10.setImg("btnSave");
          _jspx_th_impact_ButtonTag_10.setAlign("right");
          _jspx_th_impact_ButtonTag_10.setForm("frmPersonDetail");
          _jspx_th_impact_ButtonTag_10.setAction("/person/PersonDetail/savePersonDetail");
          _jspx_th_impact_ButtonTag_10.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_10 = _jspx_th_impact_ButtonTag_10.doStartTag();
          if (_jspx_th_impact_ButtonTag_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table><br>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setType("hidden");
          _jspx_th_impact_validateInput_51.setName("hdnSzCdStage");
          _jspx_th_impact_validateInput_51.setValue( szCdStage );
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("hidden");
          _jspx_th_impact_validateInput_52.setName("hdnSzCdStageProgram");
          _jspx_th_impact_validateInput_52.setValue( szCdStageProgram );
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("hidden");
          _jspx_th_impact_validateInput_53.setName("hdnPageMode");
          _jspx_th_impact_validateInput_53.setValue( pageModePassed );
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("hidden");
          _jspx_th_impact_validateInput_54.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_54.setValue(cReqFuncCd);
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setType("hidden");
          _jspx_th_impact_validateInput_55.setName("hdnSzCdStagePersSearchInd");
          _jspx_th_impact_validateInput_55.setValue(FormattingHelper.formatString(cinv04so.getSzCdStagePersSearchInd()));
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_56.setType("hidden");
          _jspx_th_impact_validateInput_56.setName("hdnBCdPersonChar");
          _jspx_th_impact_validateInput_56.setValue(FormattingHelper.formatString(personChar));
          int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
          if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setType("hidden");
          _jspx_th_impact_validateInput_57.setName("hdnUlIdStagePerson");
          _jspx_th_impact_validateInput_57.setValue(FormattingHelper.formatInt(cinv04so.getUlIdStagePerson()));
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setType("hidden");
          _jspx_th_impact_validateInput_58.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_58.setValue(DateHelper.toISOStringSafe(cinv04so.getTsLastUpdate()));
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setType("hidden");
          _jspx_th_impact_validateInput_59.setName("hdnTsSysTsLastUpdate2");
          _jspx_th_impact_validateInput_59.setValue(DateHelper.toISOStringSafe(cinv04so.getTsSysTsLastUpdate2()));
          int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
          if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setType("hidden");
          _jspx_th_impact_validateInput_60.setName("hdnSzNmPersonFull");
          _jspx_th_impact_validateInput_60.setValue(FormattingHelper.formatString(cinv04so.getSzNmPersonFull()));
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
/*These hidden fields are used for information in Custom Validation */
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("hidden");
          _jspx_th_impact_validateInput_61.setName("hdnBIndActiveEvent");
          _jspx_th_impact_validateInput_61.setValue(FormattingHelper.formatString(bIndActiveEvent));
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_62.setType("hidden");
          _jspx_th_impact_validateInput_62.setName("hdnCScrIndDupAlleg");
          _jspx_th_impact_validateInput_62.setValue(FormattingHelper.formatString(cinv04so.getCScrIndDupAlleg()));
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setType("hidden");
          _jspx_th_impact_validateInput_63.setName("hdnSzCdStagePersType");
          _jspx_th_impact_validateInput_63.setValue(FormattingHelper.formatString(cinv04so.getSzCdStagePersType()));
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setType("hidden");
          _jspx_th_impact_validateInput_64.setName("hdnCSysIndHomeRemovePers");
          _jspx_th_impact_validateInput_64.setValue(FormattingHelper.formatString(cinv04so.getCSysIndHomeRemovePers()));
          int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
          if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_65.setType("hidden");
          _jspx_th_impact_validateInput_65.setName("hdnCSysIndPersReferPresent");
          _jspx_th_impact_validateInput_65.setValue(FormattingHelper.formatString(cinv04so.getCSysIndPersReferPresent()));
          int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
          if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_66.setType("hidden");
          _jspx_th_impact_validateInput_66.setName("hdnBIndActiveStatus");
          _jspx_th_impact_validateInput_66.setValue(FormattingHelper.formatString(bIndActiveStatus));
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_67.setType("hidden");
          _jspx_th_impact_validateInput_67.setName("hdnWithdrawnDate");
          _jspx_th_impact_validateInput_67.setValue(FormattingHelper.formatString(withdrawnDate));
          int _jspx_eval_impact_validateInput_67 = _jspx_th_impact_validateInput_67.doStartTag();
          if (_jspx_th_impact_validateInput_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_68.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_68.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_68.setType("hidden");
          _jspx_th_impact_validateInput_68.setName("hdnOverallPageMode");
          _jspx_th_impact_validateInput_68.setValue(overallPageMode);
          int _jspx_eval_impact_validateInput_68 = _jspx_th_impact_validateInput_68.doStartTag();
          if (_jspx_th_impact_validateInput_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
/* This hidden field is used for save of the Person Status */
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_69.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_69.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_69.setType("hidden");
          _jspx_th_impact_validateInput_69.setName("hdnCdPersonStatus");
          _jspx_th_impact_validateInput_69.setValue(status);
          int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
          if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        \r\n   ");
/* This hidden field is used track if this person is a safety resource anywhere in the case */
          out.write("                     \r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_70.setType("hidden");
          _jspx_th_impact_validateInput_70.setName("hdnBIndSafetyRsrcCase");
          _jspx_th_impact_validateInput_70.setValue(FormattingHelper.formatString(cinv04so.getBIndSafetyRsrcCase()));
          int _jspx_eval_impact_validateInput_70 = _jspx_th_impact_validateInput_70.doStartTag();
          if (_jspx_th_impact_validateInput_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        \r\n  ");
          if (_jspx_meth_impact_validateInput_71(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
/* This hidden field is used for navigation to Case List */
          out.write("\r\n  <!-- SIR 23936 Changed reference from CaseSearchConversation to PersonDetailBaseConversation\r\n       as part of the refactoring for Mobile server  -->\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_72 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_72.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_72.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_72.setType("hidden");
          _jspx_th_impact_validateInput_72.setName(PersonDetailConversation.PREVIOUS_URI_PARAM_NAME);
          _jspx_th_impact_validateInput_72.setValue(PersonDetailConversation.PREVIOUS_URI_PERSON_DETAIL);
          int _jspx_eval_impact_validateInput_72 = _jspx_th_impact_validateInput_72.doStartTag();
          if (_jspx_th_impact_validateInput_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
//Initialize the Todo Indicator Variable.  This Variable will be changed to "True"
      //With On Change of any Person Information other than case specific information

      
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_73(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
/* Set Merge Split hidden fields */
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_74(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
/* Set Income and Resources hidden fields */
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_75(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_76(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_77(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
/* Set Education hidden fields */
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_78(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_79(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_80(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
/* Set FA hidden fields */
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_81(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_82(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_83(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
//*****************
      //**** REPORTS ****
      //*****************

      
      out.write('\r');
      out.write('\n');
boolean letterReporterFrm = true;
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

      
      out.write("\r\n\r\n\r\n");
/* If we are in Set E (employee mode), or in New mode, do not forms or reports */
      if (!(Sets.isInSet(Sets.E, request) || overallPageMode.equals(PageModeConstants.NEW) || Sets.isInSet(Sets.F,
                                                                                                           request))) {

      
      out.write("\r\n<!-- Forms and Reports code goes here.  I have code saved in a text file for later use.  -->\r\n<br>\r\n");
} /* end if in new mode or employee mode, don't display forms or reports */

      
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n    window.onload = function ()\r\n    {\r\n        ");
  
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
        
      out.write("\r\n        if (");
      out.print(showSaveMsg);
      out.write(" == true){\r\n            var tmp = '");
      out.print((String)request.getAttribute("hdnCrsRegnSaveMsg"));
      out.write("';\r\n            alert(tmp);\r\n            ");
request.setAttribute("hdnCrsRegnSaveMsg", null);
      out.write("\r\n        }\r\n        if (");
      out.print(showErrMsg);
      out.write(" == true){\r\n            var errtmp = '");
      out.print((String)request.getAttribute("hdnWebServiceError"));
      out.write("';\r\n            alert(errtmp);\r\n            ");
request.setAttribute("hdnWebServiceError", null);
      out.write("\r\n        }\r\n    };\r\n\r\n//updateRelInt();\r\n// SIR 18745 call valueDOD on load of the page so that the dropdown will be populated\r\n// correctly onload of the page.\r\n");
 if ( !overallPageMode.equals( PageModeConstants.VIEW ) )
  {

      out.write("\r\nvalueDOD();\r\n");
 } 
      out.write("\r\n\r\n");
 if ( !overallPageMode.equals( PageModeConstants.NEW ) )
  {
  
      out.write("\r\n  frmPersonDetail.txtLNbrPersonAge.disabled = true\r\n  ");

  }
  
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
      //  impact:if
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
      _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_if_0.setParent(null);
      _jspx_th_impact_if_0.setTest( (ServerSideValidationUtility.getBRefreshWidgetsFromRequest(request)) );
      int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
      if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:then
          gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
          _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
          int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
          if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    frmPersonDetail.selSzCdStagePersRelInt.value='");
              out.print( ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt") );
              out.write("';\r\n    frmPersonDetail.selSzCdPersonDeath.value='");
              out.print( ContextHelper.getStringSafe(request, "selSzCdPersonDeath") );
              out.write("';\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:else
          gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
          _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
          int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
          if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_0);
              _jspx_th_impact_ifThen_0.setTest( (!(Sets.isInSet(Sets.E, request) || PageModeConstants.VIEW.equals(PageMode.getPageMode(request)))) );
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n     valueDOD();\r\n     frmPersonDetail.selSzCdPersonDeath.value='");
                  out.print( cinv04so.getSzCdPersonDeath() );
                  out.write("';\r\n     CleanSelect( frmPersonDetail.selSzCdPersonDeath );\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    frmPersonDetail.selSzCdStagePersRelInt.value='");
              out.print( szCdStagePersRelInt );
              out.write("';\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\nCleanSelect( frmPersonDetail.selSzCdStagePersRelInt );\r\n//-- SIR STGAP00000695\r\n//-- Call this method when page loads so that the dynamic select inputs under\r\n//-- the \"Other Relationship Information\" section start off \"clean.\"  This\r\n//-- allows the call to IsDirty() to operate correctly, displaying a pop-up\r\n//-- message only if the form inputs have changed.\r\ncleanDynamicSelects();\r\n\r\n</script>\r\n\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CSRCRPTR");
    _jspx_th_impact_codeArray_0.setArrayName("colOneCodes");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    _jspx_th_impact_codeArray_0.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CRELVICT");
    _jspx_th_impact_codeArray_1.setArrayName("prnOneCodes");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    _jspx_th_impact_codeArray_1.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CPRSNTYP");
    _jspx_th_impact_codeArray_2.setArrayName("typeCodes");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    _jspx_th_impact_codeArray_2.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CRSNFDTH");
    _jspx_th_impact_codeArray_3.setArrayName("reasonDeathCodes");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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

  private boolean _jspx_meth_impact_validateInput_35(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
    _jspx_th_impact_validateInput_35.setType("hidden");
    _jspx_th_impact_validateInput_35.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_35.setValue("N");
    int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
    if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_36(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
    _jspx_th_impact_validateInput_36.setType("hidden");
    _jspx_th_impact_validateInput_36.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_36.setValue("N");
    int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
    if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_37(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
    _jspx_th_impact_validateInput_37.setType("hidden");
    _jspx_th_impact_validateInput_37.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_37.setValue("N");
    int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
    if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_38(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
    _jspx_th_impact_validateInput_38.setType("hidden");
    _jspx_th_impact_validateInput_38.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_38.setValue("Y");
    int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
    if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_2);
    _jspx_th_impact_attribute_2.setName("intakeIndicator");
    _jspx_th_impact_attribute_2.setValue(new String("N"));
    int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
    if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_3);
    _jspx_th_impact_attribute_4.setName("intakeIndicator");
    _jspx_th_impact_attribute_4.setValue(new String("N"));
    int _jspx_eval_impact_attribute_4 = _jspx_th_impact_attribute_4.doStartTag();
    if (_jspx_th_impact_attribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_71(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_71 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_71.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_71.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_71.setType("hidden");
    _jspx_th_impact_validateInput_71.setName("hdnBIndSsnCheck");
    _jspx_th_impact_validateInput_71.setValue("Y");
    int _jspx_eval_impact_validateInput_71 = _jspx_th_impact_validateInput_71.doStartTag();
    if (_jspx_th_impact_validateInput_71.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_73(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_73.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_73.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_73.setType("hidden");
    _jspx_th_impact_validateInput_73.setName("hdnBSysIndCreateToDo");
    _jspx_th_impact_validateInput_73.setValue("");
    int _jspx_eval_impact_validateInput_73 = _jspx_th_impact_validateInput_73.doStartTag();
    if (_jspx_th_impact_validateInput_73.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_74(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_74 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_74.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_74.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_74.setType("hidden");
    _jspx_th_impact_validateInput_74.setName("hdnMergeLoopCount");
    _jspx_th_impact_validateInput_74.setValue("");
    int _jspx_eval_impact_validateInput_74 = _jspx_th_impact_validateInput_74.doStartTag();
    if (_jspx_th_impact_validateInput_74.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_75(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_75 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_75.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_75.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_75.setType("hidden");
    _jspx_th_impact_validateInput_75.setName("hdnTsIncomeLastUpdate");
    _jspx_th_impact_validateInput_75.setValue("");
    int _jspx_eval_impact_validateInput_75 = _jspx_th_impact_validateInput_75.doStartTag();
    if (_jspx_th_impact_validateInput_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_76(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_76.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_76.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_76.setType("hidden");
    _jspx_th_impact_validateInput_76.setName("hdnUlIdIncRsrc");
    _jspx_th_impact_validateInput_76.setValue("");
    int _jspx_eval_impact_validateInput_76 = _jspx_th_impact_validateInput_76.doStartTag();
    if (_jspx_th_impact_validateInput_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_77(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_77.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_77.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_77.setType("hidden");
    _jspx_th_impact_validateInput_77.setName("hdnIncLoopCount");
    _jspx_th_impact_validateInput_77.setValue("");
    int _jspx_eval_impact_validateInput_77 = _jspx_th_impact_validateInput_77.doStartTag();
    if (_jspx_th_impact_validateInput_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_78(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_78 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_78.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_78.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_78.setType("hidden");
    _jspx_th_impact_validateInput_78.setName("hdnTsEduLastUpdate");
    _jspx_th_impact_validateInput_78.setValue("");
    int _jspx_eval_impact_validateInput_78 = _jspx_th_impact_validateInput_78.doStartTag();
    if (_jspx_th_impact_validateInput_78.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_79(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_79 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_79.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_79.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_79.setType("hidden");
    _jspx_th_impact_validateInput_79.setName("hdnUlIdEdhist");
    _jspx_th_impact_validateInput_79.setValue("");
    int _jspx_eval_impact_validateInput_79 = _jspx_th_impact_validateInput_79.doStartTag();
    if (_jspx_th_impact_validateInput_79.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_80(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_80 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_80.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_80.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_80.setType("hidden");
    _jspx_th_impact_validateInput_80.setName("hdnEduLoopCount");
    _jspx_th_impact_validateInput_80.setValue("");
    int _jspx_eval_impact_validateInput_80 = _jspx_th_impact_validateInput_80.doStartTag();
    if (_jspx_th_impact_validateInput_80.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_81(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_81 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_81.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_81.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_81.setType("hidden");
    _jspx_th_impact_validateInput_81.setName("hdnTsFALastUpdate");
    _jspx_th_impact_validateInput_81.setValue("");
    int _jspx_eval_impact_validateInput_81 = _jspx_th_impact_validateInput_81.doStartTag();
    if (_jspx_th_impact_validateInput_81.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_82(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_82 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_82.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_82.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_82.setType("hidden");
    _jspx_th_impact_validateInput_82.setName("hdnUlIdIndivTraining");
    _jspx_th_impact_validateInput_82.setValue("");
    int _jspx_eval_impact_validateInput_82 = _jspx_th_impact_validateInput_82.doStartTag();
    if (_jspx_th_impact_validateInput_82.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_83(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_83 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_83.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_83.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_83.setType("hidden");
    _jspx_th_impact_validateInput_83.setName("hdnFALoopCount");
    _jspx_th_impact_validateInput_83.setValue("");
    int _jspx_eval_impact_validateInput_83 = _jspx_th_impact_validateInput_83.doStartTag();
    if (_jspx_th_impact_validateInput_83.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
