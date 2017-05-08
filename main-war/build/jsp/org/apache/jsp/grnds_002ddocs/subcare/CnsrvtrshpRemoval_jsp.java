package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.CnsrvtrshpRemovalConversation;
import gov.georgia.dhr.dfcs.sacwis.web.common.CodeAttributesComparator;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import org.exolab.castor.types.Date;

public final class CnsrvtrshpRemoval_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
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


  //*  JSP Name:     Conservatorship Removal JSP
//*  Created by:   Bryon Jacob
//*  Date Created: 1/8/2003
//*
//*  Description:
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  05/05/02  DEMOMA (mad)      Changed lookup table(line 548) from CRELVICT to CRPTRINT
//**                              appears to be error in DataDictionary wrong code table used
//**  10/26/04  gerryc      SIR 23063 - changed the setupPage function so that
//**                              it only calls the selectedNA function if the checkbox
//**                              fields are not already disabled.  Once they are
//**                              disabled, their name changes from cbxCareTakerChars1
//**                              to cbxCareTakerChars1_Disabled, which results in a
//**                              javascript null or not an object error on load of the
//**                              page.
//**  12/04/08  alwilliams        STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseInt
//** 							  The calendar date picker does not put a leading zero on single digit
//** 							  months. However the user is allowed to enter single digits months with a leading
//** 							  zero. parseInt processes number with leading zero as an octal number;
//**  05/26/2010  hjbaptiste      SMS#51977-MR66-Maltreatment In Care: Added function to have the user confirm that the removal
//**                              date is prior any of the child's allegation incident date
//**  12/03/2010  hnguyen         SMS#81144: MR53 Added confirmation message if removal year is not the same as current date year.
//**  12/03/2010  htvo            SMS#81140 MR-074 AFCARS 1: 
//**                              1. remap the removal reasons, make caretaker and child characteristics removal reasons
//**                                 child characteristics display only 
//**                              2. replace castorCheckbox with manual iteration so can customize individual checkbox, 
//**                              3. auto-select reason relinquish and disable it when removal type is voluntary surrender; 
//**                                 caretaker's inability when removal type is voluntary placement. 
//**                              4. enable help text to Neglect, Relinquishment, and Caretaker's Inability
//**  12/16/2010 hanguyen         SMS#87256: Corrected logic to not validate removal year if field is already disabled after 45 days.
//**  12/27/2010 hanguyen         SMS#87949: Corrected javascript to check removal year only if date is entered and valid.
//**  12/27/2010 htvo             SMS#87941: Used hidden field to tell whether at least a removal reason is selected (b/c it can be disabled thus the name is changed)            
//**  01/20/2011 schoi            SMS #92680: MR-074 Sort Child Characteristics section to display alphabetically 
//**                              by decode value using CodeAttributesComparator  
//**  09/20/2011 schoi            STGAP00017013: MR-095 Added new section Foster Care Principal List for FCC Stage
//**  10/02/2011 schoi            STGAP00017013: MR-095 Added additional logic for new section Foster Care Principal List for FCC Stage 
//**  10/08/2011 schoi            STGAP00017013: MR-095 Added validation for any update and pre-population logic
//**                              for the Caregiver/Parental Relationship for Child section on the Person Detail page
//**  10/10/2011 schoi            STGAP00017013: MR-095 Corrected the new section name to Foster Care Principal List for FCC Stage
//**  10/11/2011 schoi            STGAP00017169: MR-095 Updated the condition to display Foster Care Principal List for FCC Stage section
//**                              for copying existing Custody event in addition to adding new Custody event 
//**  11/01/2011 schoi            STGAP00017499: MR-095 Added onClick="hrefDirtyBypass=true to bypass unnecessary pop-up window
//**

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);

  String pageMode = PageMode.getPageMode(request);
//  boolean modifyMode = PageMode.MODIFY.equals(pageMode);
  boolean birthDateNull = false;
  boolean ageMonsNull = false;
  boolean ageYrsNull = false;
  boolean bEventStatusComp = false;
  boolean bEventStatusAprv = false;
  String strAgeMons = "";
  String strAgeYrs = "";
  String removalType_DP;
  String removalType_VO;
  String removalType_VP;
  String removalType_ST;
  String commentsFactualDesc = "";
  // STGAP00017013: MR-095
  String szCdStagePersRelInt = StringHelper.EMPTY_STRING;
  
  int tabIndex = 1;

  Date todayDate = DateHelper.getTodayCastorDate();
  UserProfile user = UserProfileHelper.getUserProfile(request);

  String warnRemovalPriorAllegIncident = (String) state.getAttribute("warnRemovalPriorAllegIncident", request);
  CSUB14SO csub14so = (CSUB14SO) state.getAttribute("csub14so", request);
  CSUB48SO csub48so = (CSUB48SO) state.getAttribute("csub48so", request);
  // STGAP00017013: MR-095
  CSUB80SO csub80so = (CSUB80SO) state.getAttribute("csub80so", request); 
  
  //The birthday is not returned in csub14 when the Removal is existing
  Date birthDate = csub14so.getDtDtPersonBirth();
  // MR-074
  ROWCSUB14SOG00 rowcsub14sog00 = csub14so.getROWCSUB14SOG00();
  String personCharNA = rowcsub14sog00.getCIndRemovalNaChild();
  HashMap<String, String> removalReasonNameMap = new HashMap<String, String>();

  // STGAP00017013: MR-095
  // Filter Relationship dropdown to exclude Primary Caretaker, Self and Self/Minor Parent
  List excludeRel = new ArrayList();
  excludeRel.add(CodesTables.CRELVICT_PK);
  excludeRel.add(CodesTables.CRELVICT_SL);
  excludeRel.add(CodesTables.CRELVICT_SM);

  //Can not change anything if event has been approved
  if ("APRV".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {
    bEventStatusAprv = true;
  }
  if (birthDate == null) {
    birthDateNull = true;
  }
  if (Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo()) == null
      && Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo()) == null) {
    ageYrsNull = true;
    ageMonsNull = true;
  } else {
    strAgeYrs = Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeYr());
    strAgeMons = Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo());
  }

  String strRemovalDate = ContextHelper.getStringSafe(request, "dtDtRemoval");
  Date dtDtPersonRemoval = csub14so.getROWCSUB14SOG00().getDtDtRemoval();
  if ("".equals(strRemovalDate)) {
    if (dtDtPersonRemoval != null) {
      strRemovalDate = FormattingHelper.formatDate(dtDtPersonRemoval);
    }
  }

  // Can not change removal date if already saved "Comp" status
  if ("COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {
    bEventStatusComp = true;
  }
  // SPB - SIR 22484
  // If stage removal was recorded in is open and less than 45 days have passed
  // since the removal was recorded make date field editable.
  CaseUtility.Stage thisStage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
  String strIndClosed = thisStage.getIndStageClose();
  if ("N".equals(strIndClosed)) {
    Date currentDate = DateHelper.getTodayCastorDate();
    Date compDate = DateHelper.addToDate(currentDate, 0, 0, -46);

    if ((DateHelper.isNull(dtDtPersonRemoval) == false) &&
        (DateHelper.isBefore(compDate, dtDtPersonRemoval))) {
      bEventStatusComp = false;
    }
  }

  String labelRemovalAgeYears = ContextHelper.getStringSafe(request, "labelRemovalAgeYears");
  if ("".equals(labelRemovalAgeYears)) {
    labelRemovalAgeYears = String.valueOf(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeYr());
    if (labelRemovalAgeYears == null || "0".equals(labelRemovalAgeYears)) {
      labelRemovalAgeYears = " ";
    }
  }

  String labelRemovalAgeMonths = ContextHelper.getStringSafe(request, "labelRemovalAgeMonths");
  if ("".equals(labelRemovalAgeMonths)) {
    labelRemovalAgeMonths = String.valueOf(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo());
    if (labelRemovalAgeMonths == null || "0".equals(labelRemovalAgeMonths)) {
      labelRemovalAgeMonths = " ";
    }
  }
  // SMS#81140 MR-074: replaced castor tag with manual iterator so don't need this collection
  // And add child-related removal reasons
  //Collection<CodeAttributes> removalReasons = Lookup.getCategoryCollection(CodesTables.CREMFRHR);
  List checkedRemovalReasons = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_REMOVAL_REASONS);
  // SMS#81140 MR-074: add child-related removal reasons
  Collection<CodeAttributes> removalReasonsChild = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCREMRSN);
  //List checkedRemovalReasonsChild = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_REMOVAL_REASONS_CHILD);

  List checkedChildChars = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_CHILD_CHARS);
  List<CodeAttributes> childCharList = new ArrayList<CodeAttributes>();
  // SMS#81140 MR-074: only add N/A when it was selected in Person Characteristics page
  if (ArchitectureConstants.Y.equals(personCharNA)) {
    childCharList.add(new CodeAttributes(null, "NA", "N/A"));
  }

  if (csub14so.getROWCSUB14SOG02_ARRAY() != null) {
    Enumeration en = csub14so.getROWCSUB14SOG02_ARRAY().enumerateROWCSUB14SOG02();
    while (en.hasMoreElements()) {
      ROWCSUB14SOG02 row = (ROWCSUB14SOG02) en.nextElement();
      String childChar = row.getSzCdRemovChildChar();
      //int i = 0;
      //while (i < childChar.length() && childChar.charAt(i) != '0') {
        
      //String childChars = childChar.substring(i);
      try {
        childCharList.add(Lookup.decode(CodesTables.CPM, childChar));
      } catch (LookupException lookupException1) {
        try {
          childCharList.add(Lookup.decode(CodesTables.CHB, childChar));
        } catch (LookupException lookupException2) {
          try {
            childCharList.add(Lookup.decode(CodesTables.CME, childChar));
          } catch (LookupException lookupException3) {
            try {
              childCharList.add(Lookup.decode(CodesTables.OTH, childChar));
            } catch (LookupException lookupException4) {
              childCharList.add(Lookup.expiredDecode(CodesTables.CPM, row.getSzCdRemovChildChar()));
              }
            }
          }
          }
        //i++;
      //}
    }
  }
  // SMS#81140 MR-074: removed, caretaker factors are now part of removal reasons
  //List checkedCareTakerChars = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_CARE_TAKER_CHARS);
  Collection<CodeAttributes> careTakerChars = Lookup.getCategoryCollection(CodesTables.CREMCHCT);
  List<CodeAttributes> careTakerCharList = new ArrayList<CodeAttributes>(careTakerChars);
  //careTakerCharList.add(0, new CodeAttributes(null, "NA", "N/A"));

  int ulIdEvent = csub14so.getROWCSUB14SOG04().getUlIdEvent();

  boolean onReload = "true".equals(request.getParameter("hdnReloadingCnsrvtrshpRemoval"));

  // FIXME: Never used.
  String rbRemovalType;
  if (csub14so.getROWCSUB14SOG00().getRbRemovalType() != null) {
    rbRemovalType = csub14so.getROWCSUB14SOG00().getRbRemovalType();
  }

  String parentNotified = FormattingHelper.formatString(csub14so.getROWCSUB14SOG00().getCbParentNotified());

  if (csub14so.getROWCSUB14SOG00().getTxtFactualDesc() != null) {
    commentsFactualDesc = csub14so.getROWCSUB14SOG00().getTxtFactualDesc();
  }

      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nvar isPersonsAtHomeChanged = true;\r\n\r\n//called to make sure the persons at home have been completed, if the section PersonAt Home\r\n// has been touched do not ask user\r\nfunction CheckPersonsAtHome()\r\n{\r\n  // SIR#19196. if there are no  principals displayed in the Persons Living in Home at Removal\r\n  // section, show the error message\r\n  var x = document.frmCnsrvtrshpRemoval;\r\n  var txtPersonsDoneMessage = \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_PHR_REMINDER));
      out.write("\";\r\n  var cbxPersonAtHomeChecked = false;\r\n  x.hdnCbxPersonsAtHome.value = \"N\";\r\n  for (var i = 0; i < x.elements.length; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name);\r\n    if (x.elements[i].type == \"checkbox\" && sElementName.substring(0, 16) == \"cbxPersonsAtHome\")\r\n    {\r\n      if (x.elements[i].checked)\r\n      {\r\n        x.hdnCbxPersonsAtHome.value = \"Y\";\r\n        break;\r\n      }\r\n    }\r\n  }\r\n  \r\n  // MR-074 AFCARS: Set hidden value for removal reason b/c they can be disabled depend on removal type\r\n  // Y: at least one removal reason has been checked\r\n  x.hdnCbxReason.value = \"N\";\r\n  for (var i = 0; i < x.elements.length; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name);\r\n    if (x.elements[i].type == \"checkbox\" && sElementName.substring(0, 17) == \"cbxRemovalReasons\")\r\n    {\r\n      if (x.elements[i].checked)\r\n      {\r\n        x.hdnCbxReason.value = \"Y\";\r\n        break;\r\n      }\r\n    }\r\n  }\r\n  \r\n  return true;\r\n}\r\n\r\nfunction setRemovalConfirmed()\r\n{\r\n  document.frmCnsrvtrshpRemoval.hdnRemovalConfirmed.value = 'N';\r\n");
      out.write("}\r\n\r\nfunction updatePersonsAtHome()\r\n{\r\n  isPersonsAtHomeChanged = false;\r\n}\r\n//called to clear removal are information\r\nfunction clearAge(removalYears, removalMonths)\r\n{\r\n  removalYears.innerText = \"\";\r\n  removalMonths.innerText = \"\";\r\n  frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = \"\";\r\n  frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = \"\";\r\n}\r\n\r\n// called whenever Save button is clicked\r\nfunction confirmRemovalDate()\r\n{\r\n      var iTodayYear = ");
      out.print( (100 * todayDate.getCentury()) + todayDate.getYear());
      out.write(";\r\n\r\n      var sRemovalDate = validateDateString(frmCnsrvtrshpRemoval.dtDtRemoval.value);\r\n\r\n      var valid = validateDate(sRemovalDate);\r\n\r\n      if (valid)\r\n      {\r\n        frmCnsrvtrshpRemoval.dtDtRemoval.value = sRemovalDate;\r\n     \r\n        var pos = sRemovalDate.search('/');\r\n        \r\n        sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);\r\n        pos = sRemovalDate.search('/');\r\n        \r\n        // Specify the decimal number system (radix parameter = 10) when using parseIn\r\n        var iRYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length),10);\r\n\r\n        if( iTodayYear != iRYear && '");
      out.print(String.valueOf(bEventStatusComp));
      out.write("' == 'false')\r\n        {\r\n\t\t  if(confirm('");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_REMOVAL_YEAR_NOT_CURRENT ));
      out.write("' ) )\r\n\t\t  {\r\n\t\t      return true;\r\n\t\t  }\r\n\t\t  else\r\n\t\t  {\r\n\t\t      return false;\r\n\t\t  }\r\n        }\r\n      }\r\n      \r\n      return true;\r\n}\r\n\r\n// called whenever the removal date is changed\r\nfunction recomputeAge()\r\n{\r\n  if (( (frmCnsrvtrshpRemoval.dtDtRemoval.value).length > 0 ) || (frmCnsrvtrshpRemoval.dtDtRemoval.value == null))\r\n  {\r\n    var removalYears = document.getElementById(\"labelRemovalAgeYears_id\");\r\n    var removalMonths = document.getElementById(\"labelRemovalAgeMonths_id\");\r\n\r\n    ");

    if (birthDateNull)
    {
      if (ageYrsNull &&  ageMonsNull)
    {
    
      out.write("\r\n      removalYears.innerText = \"\";\r\n      removalMonths.innerText = \"\";\r\n    ");
  
    }
    else
    {
    
      out.write("\r\n      removalYears.innerText = ");
      out.print(strAgeYrs);
      out.write(";\r\n      removalMonths.innerText = ");
      out.print(strAgeMons);
      out.write(";\r\n      frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = ");
      out.print(strAgeYrs);
      out.write(";\r\n      frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = ");
      out.print(strAgeMons);
      out.write(";\r\n    ");
  
    }

    }
    else
    {
    
      out.write("\r\n      // initialize variables for the birthdate of the person being removed\r\n      var iTodayYear = ");
      out.print( (100 * todayDate.getCentury()) + todayDate.getYear());
      out.write(";\r\n      var iTodayMonth = ");
      out.print(todayDate.getMonth());
      out.write(";\r\n      var iTodayDay = ");
      out.print(todayDate.getDay());
      out.write(";\r\n\r\n      // initialize variables for the birthdate of the person being removed\r\n      var iBDYear = ");
      out.print( (100 * birthDate.getCentury()) + birthDate.getYear());
      out.write(";\r\n      var iBDMonth = ");
      out.print(birthDate.getMonth());
      out.write(";\r\n      var iBDDay = ");
      out.print(birthDate.getDay());
      out.write(";\r\n\r\n      // get the date from the date control, and parse it into M/D/Y parts\r\n      //  var sRemovalDate = frmCnsrvtrshpRemoval.dtDtRemoval.value;\r\n      var sRemovalDate = validateDateString(frmCnsrvtrshpRemoval.dtDtRemoval.value);\r\n\r\n      var valid = validateDate(sRemovalDate);\r\n      if (!valid)\r\n      {\r\n        alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_DATE));
      out.write("\");\r\n        frmCnsrvtrshpRemoval.dtDtRemoval.value = \"\";\r\n        clearAge(removalYears, removalMonths);\r\n      }\r\n      else\r\n      {\r\n        frmCnsrvtrshpRemoval.dtDtRemoval.value = sRemovalDate;\r\n     \r\n        var pos = sRemovalDate.search('/');\r\n        \r\n        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn\r\n        var iRMonth = parseInt(sRemovalDate.substring(0, pos),10);\r\n        \r\n        sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);\r\n        pos = sRemovalDate.search('/');\r\n        \r\n        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn\r\n        var iRDay = parseInt(sRemovalDate.substring(0, pos),10);\r\n        \r\n        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn\r\n        var iRYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length),10);\r\n\r\n        // compute the number of full months between the two dates\r\n        var months = (iRYear - iBDYear) * 12 + (iRMonth - iBDMonth);\r\n");
      out.write("        if (iRDay < iBDDay)\r\n        {\r\n          months--;\r\n        }\r\n\r\n        // years = trunc(months / 12)\r\n        var years = ((months - (months % 12)) / 12);\r\n\r\n        // months = months % 12\r\n        months = (months % 12);\r\n\r\n        // make sure the removal date isn't after today\r\n        if ((iRYear > iTodayYear) ||\r\n            (iRYear == iTodayYear &&\r\n             ( (iRMonth > iTodayMonth) ||\r\n               ( ( iRMonth == iTodayMonth ) && ( iRDay > iTodayDay ) ) ) ))\r\n        {\r\n          alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.SSM_DATE_BEFORE_SAME_CURR));
      out.write("\");\r\n          frmCnsrvtrshpRemoval.dtDtRemoval.value = \"\";\r\n          clearAge(removalYears, removalMonths);\r\n\r\n          /** @todo remove old commented out code */\r\n          //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = \"\";\r\n          //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = \"\";\r\n        }\r\n        else\r\n        {\r\n          // if the person is too old...\r\n          if (years >= 18)\r\n          {\r\n            // alert the user to the error, and clear both widgets (date and age)\r\n            alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_CHILD_OVER_18));
      out.write("\");\r\n            frmCnsrvtrshpRemoval.dtDtRemoval.value = \"\";\r\n            clearAge(removalYears, removalMonths);\r\n\r\n            /** @todo remove old commented out code */\r\n            //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = \"\";\r\n            //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = \"\";\r\n          }\r\n          // otherwise, if we calculated a valid (i.e. non-negative) age...\r\n          else if (years >= 0 && months >= 0)\r\n          {\r\n            // set the value of the widget\r\n\r\n            removalYears.innerText = years;\r\n            removalMonths.innerText = months;\r\n            frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = years;\r\n            frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = months;\r\n          }\r\n          // otherwise...\r\n          else\r\n          {\r\n            // alert the user to the error, and clear both widgets (date and age)\r\n            alert(\"The Removal Date cannot be before the Birthdate of the removed Child.\");\r\n            frmCnsrvtrshpRemoval.dtDtRemoval.value = \"\";\r\n");
      out.write("            clearAge(removalYears, removalMonths);\r\n            /** @todo remove old commented out code */\r\n            //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = \"\";\r\n            //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = \"\";\r\n          }\r\n        }\r\n      }\r\n    ");
}
      out.write("\r\n  }\r\n}\r\n\r\nfunction setupPage()\r\n{\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n  if (document.frmCnsrvtrshpRemoval.cbxChildChars1)\r\n  {\r\n    if (document.frmCnsrvtrshpRemoval.cbxChildChars1.checked)\r\n    {\r\n      selectedNA('cbxChildChars', ");
      out.print(String.valueOf(childCharList.size()));
      out.write(", true);\r\n    }\r\n  }\r\n");
      out.write("\r\n  if (document.frmCnsrvtrshpRemoval.cbxCareTakerChars1)\r\n  {\r\n    if (document.frmCnsrvtrshpRemoval.cbxCareTakerChars1.checked)\r\n    {\r\n      selectedNA('cbxCareTakerChars', ");
      out.print(String.valueOf(careTakerCharList.size()));
      out.write(", true);\r\n    }\r\n  }\r\n  recomputeAge();\r\n}\r\n\r\nwindow.attachEvent('onload', setupPage);\r\n\r\nfunction confirmRemovalPriorAllegIncident()\r\n{\r\n  if(confirm('");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_SUB_REM_DATE_WARN ));
      out.write("' ) )\r\n  {\r\n    document.frmCnsrvtrshpRemoval.hdnRemovalConfirmed.value = 'Y';\r\n    if ('true' == saveClicked) {\r\n      submitValidateForm('frmCnsrvtrshpRemoval', '/subcare/CnsrvtrshpRemoval/save');\r\n    }\r\n  }\r\n}\r\n\r\nfunction verifyReport()\r\n{\r\n  if (isFormChanged(frmCnsrvtrshpRemoval))\r\n  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_DATA_CHANGED));
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction selectedNA(controlName, numCbx, checked)\r\n{\r\n  for (i = 2; i <= numCbx; i++)\r\n  {\r\n    var cbx = document.getElementsByName(controlName + i);\r\n    if (checked)\r\n    {\r\n      if (cbx[0].checked)\r\n      {\r\n        cbx[0].click();\r\n      }\r\n      cbx[0].disabled = true;\r\n    }\r\n    else\r\n    {\r\n      cbx[0].disabled = false;\r\n    }\r\n  }\r\n}\r\n\r\nfunction clickNA(controlName, numCbx)\r\n{\r\n  var val = event.srcElement.value;\r\n\r\n  if (val == \"NA\")\r\n  {\r\n    var checked = event.srcElement.checked;\r\n    selectedNA(controlName, numCbx, checked);\r\n  }\r\n}\r\n// MR-074: 2 new functions to enable help text to Neglect, Relinquishment, and Caretaker's Inability  \r\nfunction stayHere() {\r\n\r\n  var vertScroll = document.body.scrollTop\r\n  document.body.scrollTop = vertScroll;\r\n}\r\n\r\nfunction displayReasonHelpText(txt) {\r\n\r\n  frmCnsrvtrshpRemovalHelp.HelpTxtName.value=txt;\r\n  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');\r\n");
      out.write("  frmCnsrvtrshpRemovalHelp.target = \"txtWin\";\r\n  if( window.focus ) {\r\n    errorList.focus();\r\n  }\r\n  frmCnsrvtrshpRemovalHelp.submit();\r\n  }\r\n\r\n// MR-074: set the current checkbox value before change\r\nfunction setCurrentReasonBeforeChange(value) {\r\n  var hdnCbxPrevReason = document.frmCnsrvtrshpRemoval.hdnCbxPrevReason;\r\n  hdnCbxPrevReason.value = value;\r\n  eval(hdnCbxPrevReason);\r\n}\r\n\r\n// STGAP00017013: MR-095 Check for the relationship of the person selected \r\n// in the Caregiver/Parental Relationship Information for Child section on the Person Detail page\r\n// has been updated in Foster Care Principal List for FCC Stage section on the Custody page \r\nfunction checkForCpPersonRelUpdate(){\r\n  var errorCode = '");
      out.print( (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") );
      out.write("';\r\n  if (errorCode == '");
      out.print( Messages.MSG_CONFIRM_CP_SECTION_MISMATCH );
      out.write("')\r\n    {\r\n      if (confirm( '");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CP_SECTION_MISMATCH));
      out.write("' )) {\r\n        document.frmCnsrvtrshpRemoval.hdnBIndCpValueCheck.value = 'N';\r\n        cancelValidation();\r\n        submitValidateForm('frmCnsrvtrshpRemoval', '/subcare/CnsrvtrshpRemoval/save');\r\n      } else {\r\n        document.frmCnsrvtrshpRemoval.hdnBIndCpValueCheck.value = 'Y';\r\n      }\r\n  }\r\n}\r\n\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmCnsrvtrshpRemoval');\r\n}\r\n\r\n// End STGAP00017013: MR-095\r\n\r\n</script>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n!- Form - frmCnsrvtrshpRemoval\r\n!-\r\n!- the main form for the page, containing all controls\r\n!------------------------------------------------------------------------------------------------>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

  removalType_DP = "false";
  removalType_VO = "false";
  removalType_VP = "false";
  removalType_ST = "false";
  String ind_removalType = csub14so.getROWCSUB14SOG00().getRbRemovalType();
  if (ind_removalType != null) {
    if ("DP".equals(ind_removalType)) {
      removalType_DP = "true";
    } else if ("VO".equals(ind_removalType)) {
      removalType_VO = "true";
    } else if ("VP".equals(ind_removalType)) {
      removalType_VP = "true";
    } else {
      removalType_ST = "true";
    }
  } else {
    ind_removalType = StringHelper.EMPTY_STRING;
  }

      out.write("\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCnsrvtrshpRemoval");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.CnsrvtrshpRemovalCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnCbxPrevReason");
          _jspx_th_impact_validateInput_5.setValue( ind_removalType );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<!-- STGAP00017013: MR-095 -->\r\n");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<!-- End STGAP00017013: MR-095 -->\r\n<input type=\"hidden\" name=\"HelpTxtName\" value=\"\" />\r\n\r\n<!-- STGAP00017013: MR-095 Informational message for Foster Care Principal List for FCC Stage section -->\r\n");
 if ((pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW)) 
   && !"COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {

          out.write("\r\n<table border=\"0\" cellspacing=\"3\" cellpadding=\"0\" width=\"100%\">\r\n  <tr>\r\n\t<td>\r\n\t  <hr>\r\n\t  <span class=\"formInfoText\">Attention:</span>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n\t<td><font color=#0000ff><li>\r\n\t\t<span class=\"formInfoText\">");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_COMPLT_FC_PRN_LIST_WARN ) );
          out.write("</span></font>\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <hr>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 }

          out.write("\r\n<!-- End STGAP00017013: MR-095 -->\r\n\t\t\t    \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Removal Date</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"0\">\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Removal Date");
          _jspx_th_impact_validateDate_0.setName("dtDtRemoval");
          _jspx_th_impact_validateDate_0.setValue(strRemovalDate);
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setDisabled(String.valueOf(bEventStatusComp));
          _jspx_th_impact_validateDate_0.setOnBlur("recomputeAge();");
          _jspx_th_impact_validateDate_0.setWidth("20%");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      Age at Removal:\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("labelRemovalAgeYears");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(labelRemovalAgeYears);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      Years\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("labelRemovalAgeMonths");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(labelRemovalAgeMonths);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      Months\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"0\">\r\n      <span class=\"formRequiredText\">*</span> Removal Type:\r\n    </td>\r\n    <td colspan=\"4\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel("Court Ordered");
          _jspx_th_impact_validateInput_8.setId("RemovalType_DP");
          _jspx_th_impact_validateInput_8.setName("rbRemovalType");
          _jspx_th_impact_validateInput_8.setValue(CodesTables.CREMT_DP);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setChecked( removalType_DP );
          _jspx_th_impact_validateInput_8.setOnClick("updateReason();");
          _jspx_th_impact_validateInput_8.setOnChange("setCurrentReasonBeforeChange(this.value);");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel("Voluntary Surrender");
          _jspx_th_impact_validateInput_9.setId("RemovalType_VO");
          _jspx_th_impact_validateInput_9.setName("rbRemovalType");
          _jspx_th_impact_validateInput_9.setValue(CodesTables.CREMT_VO);
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setChecked( removalType_VO );
          _jspx_th_impact_validateInput_9.setOnClick("updateReason();");
          _jspx_th_impact_validateInput_9.setOnChange("setCurrentReasonBeforeChange(this.value);");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel("Voluntary Placement");
          _jspx_th_impact_validateInput_10.setId("RemovalType_VP");
          _jspx_th_impact_validateInput_10.setName("rbRemovalType");
          _jspx_th_impact_validateInput_10.setValue(CodesTables.CREMT_VP);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setChecked( removalType_VP );
          _jspx_th_impact_validateInput_10.setOnClick("updateReason();");
          _jspx_th_impact_validateInput_10.setOnChange("setCurrentReasonBeforeChange(this.value);");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"0\"></td>\r\n    <td colspan=\"2\"> \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("Short Term Emergency Care (Care up to 7 days)");
          _jspx_th_impact_validateInput_11.setId("RemovalType_ST");
          _jspx_th_impact_validateInput_11.setName("rbRemovalType");
          _jspx_th_impact_validateInput_11.setValue(CodesTables.CREMT_ST);
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setChecked( removalType_ST );
          _jspx_th_impact_validateInput_11.setOnClick("updateReason(); disableAllRemovalReasons();");
          _jspx_th_impact_validateInput_11.setOnChange("setCurrentReasonBeforeChange(this.value);");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"1\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setLabel("Parent Notified of 72 Hour Hearing at Removal");
          _jspx_th_impact_validateInput_12.setChecked( (("".equals(parentNotified)) || ("N".equals(parentNotified))) ? "false" : "true" );
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_12.setValue("Y");
          _jspx_th_impact_validateInput_12.setName("cbxParentNotified");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"5\"><span class=\"formCondRequiredText\">&#135;</span> Removal Reason</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"5\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t    <tr>\r\n\t      <th>Caretaker-related</th>\r\n\t    </tr>\r\n \t\t<tr>\r\n\t\t  <td>\r\n\t\t    <table width=\"100%\">\r\n\t\t      <tr>\r\n\t\t        <td width=\"50%\">\r\n\t\t\t\t\t\t\t");

							  int i = 0;
							      Iterator<CodeAttributes> iterator = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CREMFRHR)
							                                                .iterator();
							      int size = Lookup.getCategoryCollection(CodesTables.CREMFRHR).size();
							      int half = size / 2 + 1; // this list is 11 elements
							      String helpText = "";
							
          out.write("\r\n\t\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t");

								  for (i = 0; i <= half - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String cbxRemovalReason = "cbxRemovalReasonsAdult" + (i + 1);
								          String szCheckedRemovalReason = "false";

								          if (checkedRemovalReasons != null) {
								            if (checkedRemovalReasons.contains(code)) {
								              szCheckedRemovalReason = "true";
								            }
								          }
								          removalReasonNameMap.put(code, cbxRemovalReason);
									
          out.write("\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setName(cbxRemovalReason);
          _jspx_th_impact_validateInput_13.setLabel(decode);
          _jspx_th_impact_validateInput_13.setTitle(title);
          _jspx_th_impact_validateInput_13.setChecked(szCheckedRemovalReason);
          _jspx_th_impact_validateInput_13.setValue(code);
          _jspx_th_impact_validateInput_13.setDisabled(String.valueOf(bEventStatusAprv));
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t");

									if (decode.startsWith("Neglect")) {
									  helpText = "Neglect: Includes Domestic Violence, Emotional Abuse, Inadequate Food/Clothing/Shelter, Lack of Supervision, Medical Neglect, and Refusal to Assume ParentalResponsibility.";
									} else if (decode.startsWith("Caretaker")) { // Unable to Cope reason
									  helpText = "Caretaker\\'s Inability to Cope due to Illness or Other Reason: Includes Emotionally Disturbed, Safe Place for Newborn Act, and Voluntary Placement.";
									} else if (decode.startsWith("Relinquishment")) { 
									  helpText = "Relinquishment: Includes Voluntary Surrender.";
									} 
									if (decode.startsWith("Neglect") || decode.startsWith("Caretaker") || decode.startsWith("Relinquishment")) {
									
          out.write("\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<td>\t<a href=\"#\" onClick=\"displayReasonHelpText('");
          out.print( helpText );
          out.write("')\">?</a>\r\n\t\t\t\t\t\t\t\t\t");
} 
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t\t\t</table> <!-- end reason col 1 -->\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"50%\">\r\n\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t");

								  for (i = half; i <= size - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String cbxRemovalReason = "cbxRemovalReasonsAdult" + (i + 1);
								          String szCheckedRemovalReason = "false";

								          if (checkedRemovalReasons != null) {
								            if (checkedRemovalReasons.contains(code)) {
								              szCheckedRemovalReason = "true";
								            }
								          }
								          removalReasonNameMap.put(code, cbxRemovalReason);
								   
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setName(cbxRemovalReason);
          _jspx_th_impact_validateInput_14.setLabel(decode);
          _jspx_th_impact_validateInput_14.setTitle(title);
          _jspx_th_impact_validateInput_14.setChecked(szCheckedRemovalReason);
          _jspx_th_impact_validateInput_14.setValue(code);
          _jspx_th_impact_validateInput_14.setDisabled(String.valueOf(bEventStatusAprv));
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t");

									if (decode.startsWith("Neglect")) {
									  helpText = "Neglect: Includes Domestic Violence, Emotional Abuse, Inadequate Food/Clothing/Shelter, Lack of Supervision, Medical Neglect, and Refusal to Assume Parental Responsibility.";
									} else if (decode.startsWith("Caretaker")) { // Unable to Cope reason
									  helpText = "Caretaker" + "'" + "s Inability to Cope due to Illness or Other Reason: Includes Emotionally Disturbed, Safe Place for Newborn Act, and Voluntary Placement.";
									} else if (decode.startsWith("Relinquishment")) { 
									  helpText = "Relinquishment: Includes Voluntary Surrender.";
									} 
									if (decode.startsWith("Neglect") || decode.startsWith("Caretaker") || decode.startsWith("Relinquishment")) {
									
          out.write("\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<td>\t<a href=\"#\" onClick=\"displayReasonHelpText('");
          out.print( helpText );
          out.write("')\">?</a>\r\n\t\t\t\t\t\t\t\t\t");
} 
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t</table><!-- end reason col 2 -->\r\n\r\n\t\t        </td>\r\n\t\t      </tr> <!-- end caretaker reasons -->\r\n\t\t    </table><!-- end caretaker reasons table-->\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <th>Child-related</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>\r\n\t\t    <table width=\"100%\">\r\n\t\t      <tr>\r\n\t\t        <td>\r\n\t\t            ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_0.setCastorEnum( Collections.enumeration(removalReasonsChild) );
          _jspx_th_impact_castorCheckbox_0.setCheckedValues( checkedRemovalReasons );
          _jspx_th_impact_castorCheckbox_0.setName("cbxRemovalReasonsChild");
          _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_0.setColumns(2);
          _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_castorCheckbox_0.setDisabled(String.valueOf(bEventStatusAprv));
          _jspx_th_impact_castorCheckbox_0.setOnClick("");
          int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
          if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t        </td>\r\n\t\t      </tr>\r\n\t\t    </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t  </table>\r\n\t</td>\r\n  </tr>\r\n  \r\n  <tr>\r\n    <td>\r\n      <span class=\"formRequiredText\">*</span> Factual Description of incident precipitating removal\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtFactualDesc");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
          _jspx_th_impact_validateTextArea_0.setMaxLength(500);
          _jspx_th_impact_validateTextArea_0.setColspan("2");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setRows("5");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print(commentsFactualDesc);
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
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>Child Characteristics</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t      <tr>\r\n\t\t        <td width=\"50%\">\r\n\t\t\t\t\t\t\t");
							
							CodeAttributesComparator attributesComparator = new CodeAttributesComparator();
							Collections.sort(childCharList, attributesComparator);
							  i = 0;
							      iterator = childCharList.iterator();
							      size = childCharList.size();
							      half = size / 2 + size % 2; 
							
          out.write("\r\n\t\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t");

								  for (i = 0; i <= half - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String txtChildChar = "txtChildChars" + (i + 1);
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName(txtChildChar);
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(decode);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t\t\t</table> <!-- end char col 1 -->\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"50%\">\r\n\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t");

								  for (i = half; i <= size - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String txtChildChar = "txtChildChars" + (i + 1);
								
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName(txtChildChar);
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(decode);
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t</table><!-- end char col 2 -->\r\n\r\n\t\t        </td>\r\n\t\t      </tr> <!-- end child characteristics reasons -->\r\n\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th><span class=\"formRequiredText\">*</span> Persons Living In Home at Removal</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <div id=\"scrollBar\" style=\"height:155px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table cellspacing=\"0\" border=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <th class=\"thList\">&nbsp;</th>\r\n            <th class=\"thList\">Name</th>\r\n            <th class=\"thList\">Relationship</th>\r\n            <th class=\"thList\">DOB</th>\r\n            <th class=\"thList\">Sex</th>\r\n          </tr>\r\n          ");

            ROWCSUB48SOG00_ARRAY rowcsub48SOG00_array = csub48so.getROWCSUB48SOG00_ARRAY();
            if (rowcsub48SOG00_array != null) {
              int loopCount = 0;
              Enumeration enumeration = rowcsub48SOG00_array.enumerateROWCSUB48SOG00();
              while (enumeration.hasMoreElements()) {
                ROWCSUB48SOG00 row = (ROWCSUB48SOG00) enumeration.nextElement();
                String cbxName = "cbxPersonsAtHome_" + row.getUlIdPerson();
                boolean checked = onReload ?
                                  request.getParameter(cbxName) != null :
                                  "Y".equalsIgnoreCase(row.getCScrIndRefChildMatch());
          
          out.write("\r\n          <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setName(cbxName);
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setValue(String.valueOf(row.getUlIdPerson()));
          _jspx_th_impact_validateInput_15.setDisabled(String.valueOf(bEventStatusAprv));
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setOnChange("updatePersonsAtHome()");
          _jspx_th_impact_validateInput_15.setChecked(String.valueOf(checked));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          out.print(row.getSzNmPersonFull());
          out.write("\r\n            </td>\r\n            <td>");
          out.print(Lookup.simpleDecode(CodesTables.CRPTRINT, row.getSzCdPersonRelationship()));
          out.write("\r\n            </td>\r\n            <td>");
          out.print(FormattingHelper.formatDate(row.getDtDtPersonBirth()));
          out.write("\r\n            </td>\r\n            <td>");
          out.print(Lookup.simpleDecode(CodesTables.CSEX, row.getCCdPersonSex()));
          out.write("\r\n            </td>\r\n          </tr>\r\n          ");

                loopCount++;
              }
            }
          
          out.write("\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!-- STGAP00017013: MR-095 Foster Care Principal List for FCC Stage section -->\r\n");
 if ((pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW)) 
   && !"COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus()))  {

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th><span class=\"formRequiredText\">*</span> Foster Care Principal List for FCC Stage&nbsp;&nbsp;&nbsp;&nbsp;  <a href=\"javascript:void window.open ('/subcare/CnsrvtrshpRemoval/displayFosterCarePrnListHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\" onClick=\"hrefDirtyBypass=true;\">  ?</a></span></th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <div id=\"scrollBar\" style=\"height:155px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table cellspacing=\"0\" border=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <th class=\"thList\" width=\"7%\"></th>\r\n            <th class=\"thList\" width=\"27%\">Name</th>\r\n            <th class=\"thList\" width=\"32%\">Person ID</th>\r\n            <th class=\"thList\" width=\"34%\">Relationship</th>\r\n          </tr>\r\n");
          out.write("          ");

            ROWCSUB80SOG00_ARRAY rowcsub80SOG00_array = csub80so.getROWCSUB80SOG00_ARRAY();
            if (rowcsub80SOG00_array != null) {
              int loopCount = 0;
              i = 0;
              Enumeration enumeration = rowcsub80SOG00_array.enumerateROWCSUB80SOG00();
              while (enumeration.hasMoreElements()) {
                ROWCSUB80SOG00 row = (ROWCSUB80SOG00) enumeration.nextElement();
                String cdStagePersRelInt = "selSzCdStagePersRelInt_" + ( i + 1 );
                
                // Initialize szCdStagePersRelInt to the actual value
                if (request.getParameter(cdStagePersRelInt) == null) {
                  szCdStagePersRelInt = FormattingHelper.formatString(row.getSzCdStagePersRelInt());
                } else{
                  szCdStagePersRelInt = request.getParameter(cdStagePersRelInt);
                }  
          
          out.write("\r\n          <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n            <td>            \r\n            </td>\r\n            <td>");
          out.print(row.getSzNmPersonFull());
          out.write("\r\n            </td>\r\n            <td>");
          out.print(row.getUlIdPersonPrincipal());
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setCodesTable("CRELVICT");
          _jspx_th_impact_validateSelect_0.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_0.setName( cdStagePersRelInt);
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludeRel );
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.NEW_USING + EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdStagePersRelInt));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("                              \r\n            </td>\r\n          </tr>\r\n          ");

                loopCount++;
                i++;
              }
            }
          
          out.write("\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 }

          out.write("\r\n<!-- End STGAP00017013: MR-095 -->\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setAction("/subcare/CnsrvtrshpRemoval/save");
          _jspx_th_impact_ButtonTag_0.setForm("frmCnsrvtrshpRemoval");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setFunction("return CheckPersonsAtHome() && confirmRemovalDate(); setRemovalConfirmed()");
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setDisabled(String.valueOf(bEventStatusAprv));
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nvar saveClicked;\r\nwindow.onload = function ()\r\n{\r\n  ");

  if ("Y".equals(warnRemovalPriorAllegIncident)) {
  
          out.write("\r\n    saveClicked = '");
          out.print( StringHelper.isValid(request.getParameter("btnSave" + ".x")));
          out.write("';\r\n    confirmRemovalPriorAllegIncident();\r\n  ");

  }
  
          out.write("\r\n  // MR-074: select and check Relinquish reason if removal type is Voluntary Surrender;\r\n  // Caretaker's Inability reason if removal type is Voluntary Placement\r\n  updateReason();\r\n  disableAllRemovalReasons();\r\n  \r\n  // STGAP00017013: MR-095\r\n  checkForCpPersonRelUpdate();\r\n}   \r\n\r\n// MR-074: put here so map can have values\r\nfunction updateReason() {\r\n   var removalType = document.frmCnsrvtrshpRemoval.rbRemovalType;\r\n   var val = getSelectedRadioValue(removalType);\r\n   var prev = document.frmCnsrvtrshpRemoval.hdnCbxPrevReason.value;\r\n  ");

  String cbxRLMid = "";
  String cbxUNAid = "";

  if (removalReasonNameMap.containsKey("RLM")) {
    cbxRLMid = removalReasonNameMap.get("RLM")+"_Id"; // id java string is best constructed here 
  }
  if (removalReasonNameMap.containsKey("UNA")) {
    cbxUNAid = removalReasonNameMap.get("UNA")+"_Id";
  }
  
          out.write("\r\n  var cbxRLM = document.getElementById(\"");
          out.print(cbxRLMid );
          out.write("\"); \r\n  var cbxUNA = document.getElementById(\"");
          out.print(cbxUNAid );
          out.write("\"); \r\n  \r\n  if (val == \"ST\") {\r\n    \r\n    disableAllRemovalReasons();  // disable and clear\r\n  }\r\n  // Voluntary Surrender, auto-select Relinquish reason RLM\r\n  else if (val == \"VO\") {\r\n    // enable all other reasons\r\n    enableAllRemovalReasons();\r\n    if (cbxRLM.checked == false) {\r\n      cbxRLM.click();\r\n    }\r\n    cbxRLM.disabled = true;\r\n  } \r\n  // Voluntary Placement, auto-select Caretaker's Inability to Cope UNA\r\n  else if (val == \"VP\") {\r\n    // enable all other reasons\r\n    enableAllRemovalReasons();\r\n    if (cbxUNA.checked == false) {\r\n      cbxUNA.click();\r\n    }\r\n    cbxUNA.disabled = true;\r\n  } \r\n  // Court Ordered removal type selected, enable all reasons\r\n  else if (val == \"DP\") {\r\n    enableAllRemovalReasons();\r\n  } \r\n  // if either Volunatarty Surrender or Voluntary Placement is deselected, clear the associated checkbox\r\n  // all checkbxes already enabled by DP logic above\r\n  if (prev == \"VO\") {\r\n    if (cbxRLM.checked == true) {\r\n      cbxRLM.click();\r\n    } \r\n    //cbxRLM.disabled = false;\r\n");
          out.write("  } else if (prev == \"VP\") {\r\n      if (cbxUNA.checked == true) {\r\n        cbxUNA.click();\r\n      }\r\n    //  cbxUNA.disabled = false;\r\n  }\r\n}\r\n\r\nfunction disableAllRemovalReasons() {\r\n  var x = document.frmCnsrvtrshpRemoval;\r\n  var removalType = document.frmCnsrvtrshpRemoval.rbRemovalType;\r\n  var val = getSelectedRadioValue(removalType);\r\n  // If this is Short Term Emergency Care removal, no removal reasons should be entered, disable and clear all removal reasons \r\n  if (val == \"ST\") {  \r\n  for (var i = 0; i < x.elements.length; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name); \r\n    if (x.elements[i].type == \"checkbox\" && sElementName.substring(0, 17) == \"cbxRemovalReasons\")\r\n    {\r\n        x.elements[i].disabled = false;  // enable to clear fields w/o calling the changed name\r\n        if (x.elements[i].checked) {\r\n          x.elements[i].click(); // clear value\r\n        }\r\n        x.elements[i].disabled = true; // disable\r\n    }\r\n  }\r\n  } \r\n}\r\n\r\nfunction enableAllRemovalReasons() {\r\n  var x = document.frmCnsrvtrshpRemoval;\r\n");
          out.write("  for (var i = 0; i < x.elements.length; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name); \r\n    if (x.elements[i].type == \"checkbox\" && sElementName.substring(0, 17) == \"cbxRemovalReasons\")\r\n    {\r\n        x.elements[i].disabled = false;\r\n    }\r\n  }\r\n}\r\n\r\n</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<form name=\"frmCnsrvtrshpRemovalHelp\" method=\"post\" action=\"/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemovalHelp\">\r\n  <input type=\"hidden\" name=\"HelpTxtName\" value=\"\" />\r\n</form>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setName("hdnReloadingCnsrvtrshpRemoval");
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setValue("true");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setName("hdnCbxPersonsAtHome");
    _jspx_th_impact_validateInput_1.setType("hidden");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnRemovalConfirmed");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnLocationAnchor");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnRLM_autoselect");
    _jspx_th_impact_validateInput_4.setValue("false");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnCbxReason");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnBIndCpValueCheck");
    _jspx_th_impact_validateInput_7.setValue("Y");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
