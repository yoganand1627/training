package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildFamilyLinkBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingPlacementGroupSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.AdoptionInformationConversation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public final class AdoptionInformation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile user = UserProfileHelper.getUserProfile(request);
  int tabIndex = 1;
  int loopCount = 0;
  int loopCount1 = 0;
  int arrayIndex = 0;
  int beanSize = 0;
  String EMPTY_STRING = "";
  String fieldName = EMPTY_STRING;
  String fieldName1 = EMPTY_STRING;
  String fieldName2 = EMPTY_STRING;
  String cdEventStatus = EMPTY_STRING;
  String dtFostParNotAgTPR = EMPTY_STRING;
  String dtPermStaffFostPar = EMPTY_STRING;
  String dtFostParNotAgDecAdpt = EMPTY_STRING;
  String dtChildLifeHistPres = EMPTY_STRING;
  String dtSelectionLetterSent = EMPTY_STRING;
  String dtStaffAdptFam = EMPTY_STRING;
  String dtAdptPlacAgmtSigned = EMPTY_STRING;
  String dtDocSentAttor = EMPTY_STRING;
  String dtDisruption = EMPTY_STRING;
  String dtPermFileLetterComp = EMPTY_STRING;
  String indOtherSiblingsAdopted = EMPTY_STRING;
  String indOutofTown = EMPTY_STRING;
  int nmFamConsidered = 0;
  int hdnResourceId = 0;
  String szCdReasonsFamNotSel = EMPTY_STRING;
  String szCdTypeAdptRsrcNeeded = EMPTY_STRING;
  String szCdChildLinked = EMPTY_STRING;
  String szCdComntsPrepAct = EMPTY_STRING;
  String szCdComntsBarRec = EMPTY_STRING;
  String szCdComntsRecActsState = EMPTY_STRING;
  String szCdComntsRecActsCounty = EMPTY_STRING;
  String szCdComntsBarPla = EMPTY_STRING;
  String szCdComntsBarTpr = EMPTY_STRING;
  String szCdReasonChildNonAvail = EMPTY_STRING;
  String txtSzNmAdpRes = EMPTY_STRING;
  String txtSzCounty = EMPTY_STRING;
  String txtSzHomeType = EMPTY_STRING;
  String txtSzICPCState = EMPTY_STRING;
  String txtSzNmPrAgency = EMPTY_STRING;
  String indIdentifiedAdopRes = EMPTY_STRING;
  String indAdoptOutcome = EMPTY_STRING;
  String szCdExchConsidered = EMPTY_STRING;
  String szCdCountyConsideredComments = EMPTY_STRING;
  List checkedPreperationActivities = new ArrayList();
  List checkedBarriersRecruitment = new ArrayList();
  boolean hasSiblings = false;
  boolean hasSiblingExternal = false;

  // MR-083
  String szCdStateActivelyRecruiting = EMPTY_STRING;
  Map<String, List<AdoInfoCbxSentStruct>> savedRecActivitiesDatesCounty = new HashMap<String, List<AdoInfoCbxSentStruct>>();
  Map<String, List<Date>> savedRecActivitiesDatesState = new HashMap<String, List<Date>>();

  List checkedBarriersPlacement = new ArrayList();
  List checkedBarriersTPR = new ArrayList();
  List<AdoptionResourceBean> resBeanList = new ArrayList();
  List<ExchangeChildFamilyLinkBean> childFamilyLinkList = new ArrayList();
  List<SiblingSO> siblingList = null;
  List<SiblingExternalLinkStruct> siblingExternalLinkList = new ArrayList<SiblingExternalLinkStruct>();
  Map<Integer, Integer> prnChildrenUnder18WithAnotherAdoCase = new HashMap<Integer, Integer>();
  int numOfSiblings = 0;
  Map<SiblingSO, SiblingPlacementGroupSO> siblingGroupings = null;
  SiblingGroupInformationSO siblingGroupInformation = null;
  List<SiblingPlacementGroupSO> siblingPlacementGroupList = null;
  List<Option> siblingExtCaseOptionList = new ArrayList<Option>();
  int numOfNewSiblingGroups = 0;
  int totalAvailableForAdoption = 0;

  String editableMode = PageMode.getPageMode(request);

  //Populating the checkboxes with reference to codes tables.    
  //Preparation Activities
  Collection preparationacts = Lookup.getCategoryCollection(CodesTables.CADCPAC);
  List preparationactsList = new ArrayList(preparationacts);
  //Recruitment Activities - State
  Collection recactsstate = Lookup.getCategoryCollection(CodesTables.CADRACS);
  List recactsstateList = new ArrayList(recactsstate);
  // Recruitment Activities - County
  Collection recactscounty = Lookup.getCategoryCollection(CodesTables.CADRACC);
  List activityCodesList = new ArrayList(recactscounty);
  // Barriers to Recruitment
  Collection barrtorecrmnt = Lookup.getCategoryCollection(CodesTables.CADBREC);
  List barrtorecrmntList = new ArrayList(barrtorecrmnt);
  // Barriers to Placement
  Collection barrtoplacmnt = Lookup.getCategoryCollection(CodesTables.CADBPLA);
  List barrtoplacmntList = new ArrayList(barrtoplacmnt);

  Collection barrtotpr = Lookup.getCategoryCollection(CodesTables.CADBTPR);
  List barrtotprList = new ArrayList(barrtotpr);

  AdoptionInformationRetrieveSO adoptioninformationret = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO", request);
  siblingExtCaseOptionList = (List<Option>) state.getAttribute("siblingOptionList", request);
  
  if(adoptioninformationret.getCdEventStatus() != null) {
    cdEventStatus = adoptioninformationret.getCdEventStatus();
  }
  if(adoptioninformationret.getDtFostParNotAgTPR() != null) {
    dtFostParNotAgTPR = FormattingHelper.formatDate(adoptioninformationret.getDtFostParNotAgTPR());
  }
  if(adoptioninformationret.getDtPermStaffFostPar() != null) {
    dtPermStaffFostPar = FormattingHelper.formatDate(adoptioninformationret.getDtPermStaffFostPar());
  }
  if(adoptioninformationret.getDtLetterSent() != null) {
    dtSelectionLetterSent = FormattingHelper.formatDate(adoptioninformationret.getDtLetterSent());
  }
  if(adoptioninformationret.getDtFostParNotAgDecAdpt() != null) {
    dtFostParNotAgDecAdpt = FormattingHelper.formatDate(adoptioninformationret.getDtFostParNotAgDecAdpt());
  }
  if(adoptioninformationret.getIndAdoptOutcome() != null) {
    indAdoptOutcome = adoptioninformationret.getIndAdoptOutcome();
  }
  if(adoptioninformationret.getSzCdExchConsidered() != null) {
    szCdExchConsidered = adoptioninformationret.getSzCdExchConsidered();
  }
  if(adoptioninformationret.getDtChildLifeHistPres() != null) {
    dtChildLifeHistPres = FormattingHelper.formatDate(adoptioninformationret.getDtChildLifeHistPres());
  }
  if(adoptioninformationret.getDtStaffAdptFam() != null) {
    dtStaffAdptFam = FormattingHelper.formatDate(adoptioninformationret.getDtStaffAdptFam());
  }
  if(adoptioninformationret.getSzCdCountyConsidered() != null) {
    szCdCountyConsideredComments = adoptioninformationret.getSzCdCountyConsidered();
  }
  if(adoptioninformationret.getDtAdptPlacAgmtSigned() != null) {
    dtAdptPlacAgmtSigned = FormattingHelper.formatDate(adoptioninformationret.getDtAdptPlacAgmtSigned());
  }
  if(adoptioninformationret.getDtDocSentAttor() != null) {
    dtDocSentAttor = FormattingHelper.formatDate(adoptioninformationret.getDtDocSentAttor());
  }
  if(adoptioninformationret.getDtDisruption() != null) {
    dtDisruption = FormattingHelper.formatDate(adoptioninformationret.getDtDisruption());
  }
  if(adoptioninformationret.getDtPermFileLetterComp() != null) {
    dtPermFileLetterComp = FormattingHelper.formatDate(adoptioninformationret.getDtPermFileLetterComp());
  }
  if(adoptioninformationret.getIndOutofTown() != null) {
    indOutofTown = adoptioninformationret.getIndOutofTown();
  }
  if(adoptioninformationret.getIndOtherSiblingsAdopted() != null) {
    indOtherSiblingsAdopted = adoptioninformationret.getIndOtherSiblingsAdopted();
  }
  nmFamConsidered = adoptioninformationret.getNmFamConsidered();
  if(adoptioninformationret.getSzCdReasonsFamNotSel() != null) {
    szCdReasonsFamNotSel = adoptioninformationret.getSzCdReasonsFamNotSel();
  }
  if(adoptioninformationret.getSzCdTypeAdptRsrcNeeded() != null) {
    szCdTypeAdptRsrcNeeded = adoptioninformationret.getSzCdTypeAdptRsrcNeeded();
  }
  if(adoptioninformationret.getSzCdComntsPrepAct() != null) {
    szCdComntsPrepAct = adoptioninformationret.getSzCdComntsPrepAct();
  }
  if(adoptioninformationret.getSzCdComntsBarRec() != null) {
    szCdComntsBarRec = adoptioninformationret.getSzCdComntsBarRec();
  }
  if(adoptioninformationret.getSzCdComntsRecActsState() != null) {
    szCdComntsRecActsState = adoptioninformationret.getSzCdComntsRecActsState();
  }
  if(adoptioninformationret.getSzCdComntsRecActsCounty() != null) {
    szCdComntsRecActsCounty = adoptioninformationret.getSzCdComntsRecActsCounty();
  }
  if(adoptioninformationret.getSzCdComntsBarPla() != null) {
    szCdComntsBarPla = adoptioninformationret.getSzCdComntsBarPla();
  }
  if(adoptioninformationret.getSzCdComntsBarTpr() != null) {
    szCdComntsBarTpr = adoptioninformationret.getSzCdComntsBarTpr();
  }
  if(adoptioninformationret.getSzCdReasonChildNonAvail() != null) {
    szCdReasonChildNonAvail = adoptioninformationret.getSzCdReasonChildNonAvail();
  }
  hdnResourceId = adoptioninformationret.getResourceIdForPullback();
  if(adoptioninformationret.getNMResource() != null) {
    txtSzNmAdpRes = adoptioninformationret.getNMResource();
  }
  if(adoptioninformationret.getSzCdCounty() != null) {
    txtSzCounty = adoptioninformationret.getSzCdCounty();
  }
  if(adoptioninformationret.getSzCdCategory() != null) {
    txtSzHomeType = adoptioninformationret.getSzCdCategory();
  }
  if(adoptioninformationret.getSzCdState() != null) {
    txtSzICPCState = adoptioninformationret.getSzCdState();
  }
  if(adoptioninformationret.getNMAgency() != null) {
    txtSzNmPrAgency = adoptioninformationret.getNMAgency();
  }
  if(adoptioninformationret.getIndIdentifiedAdopRes() != null) {
    indIdentifiedAdopRes = adoptioninformationret.getIndIdentifiedAdopRes();
  }
  if(adoptioninformationret.getSzCdChildLinked() != null) {
    szCdChildLinked = adoptioninformationret.getSzCdChildLinked();
  }
  if(adoptioninformationret.getIdenResList() != null) {
    resBeanList = adoptioninformationret.getIdenResList();
    beanSize = resBeanList.size();
  }
  if(adoptioninformationret.getChildFamilyLinkList() != null) {
    childFamilyLinkList = adoptioninformationret.getChildFamilyLinkList();
  }
  if(adoptioninformationret.getChkPreperationActivities() != null) {
    String[] checkedPrepActs = null;
    checkedPrepActs = adoptioninformationret.getChkPreperationActivities();
    for (int i = 0; i < checkedPrepActs.length; i++) {
      checkedPreperationActivities.add(checkedPrepActs[i]);
    }
  }
  if(adoptioninformationret.getChkBarriersRecruitment() != null) {
    String[] checkedBarRec = null;
    checkedBarRec = adoptioninformationret.getChkBarriersRecruitment();
    for (int i = 0; i < checkedBarRec.length; i++) {
      checkedBarriersRecruitment.add(checkedBarRec[i]);
    }
  }

  if(adoptioninformationret != null) {
    szCdStateActivelyRecruiting = adoptioninformationret.getSzCdStateActivelyRecruiting();
  }

  if(adoptioninformationret.getSavedRecActivitiesDatesCounty() != null) {
    savedRecActivitiesDatesCounty = adoptioninformationret.getSavedRecActivitiesDatesCounty();
  }

  if(adoptioninformationret.getSavedRecActivitiesDatesState() != null) {
    savedRecActivitiesDatesState = adoptioninformationret.getSavedRecActivitiesDatesState();
  }

  if(adoptioninformationret.getChkBarriersPlacement() != null) {
    String[] checkedBarPla = null;
    checkedBarPla = adoptioninformationret.getChkBarriersPlacement();
    for (int i = 0; i < checkedBarPla.length; i++) {
      checkedBarriersPlacement.add(checkedBarPla[i]);
    }
  }

  if(adoptioninformationret.getChkBarriersTPR() != null) {
    String[] checkedBarTPR = null;
    checkedBarTPR = adoptioninformationret.getChkBarriersTPR();
    for (int i = 0; i < checkedBarTPR.length; i++) {
      checkedBarriersTPR.add(checkedBarTPR[i]);
    }
  }
  
  //populate sibling group structures 
  if(adoptioninformationret.getSiblingGroupInformation() != null) {
    siblingGroupInformation = adoptioninformationret.getSiblingGroupInformation();
    siblingList = siblingGroupInformation.getAllSiblingsRetrievedSOList();
    siblingExternalLinkList = siblingGroupInformation.getSiblingExternalLinkStructList();

    //MR-092 getting principal children under 18 with open ADO stage in another case
    prnChildrenUnder18WithAnotherAdoCase = adoptioninformationret.getPrnChildrenUnder18WithAnotherAdoCase();

    hasSiblings = siblingList != null && siblingList.size() > 1;

    // MR-092 if primary child sibling group has saved sibling from another case OR if there are at least one principal child under 18
    // with no open FCC or ADO stage in the current case but has an open ADO in another case whom may POTENTIALLY be a sibling.
    hasSiblingExternal = (siblingExternalLinkList != null && siblingExternalLinkList
        .size() > 0) || prnChildrenUnder18WithAnotherAdoCase.size() > 0;

    siblingGroupings = siblingGroupInformation.getGroupings();
    siblingPlacementGroupList = siblingGroupInformation.getSiblingPlacementGroups();
    numOfNewSiblingGroups = siblingGroupInformation.getNumOfNewSiblingGroups();
    
	  if(siblingList != null){
	    numOfSiblings = siblingList.size();
	  }
	  
    //initialize total # of siblings available for adoption
    for (int i = 0; i < siblingList.size(); ++i) {
      SiblingSO siblingSO = (SiblingSO) siblingList.get(i);

      if(siblingSO.getIndAvailableToAdopt() == true) {
        //update # available for adoption    	totalAvailableForAdoption = totalAvailableForAdoption + 1;
      }
    }
  }

  request.setAttribute("cdEventStatus", cdEventStatus);

      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"> </script>\r\n<script language=\"Javascript1.2\">\r\n\r\nwindow.attachEvent(\"onload\", toggleSiblingExternalQuestions);\r\n\r\nfunction submitAdoptionResourceDetail(idResource, nmResource ){\r\n  document.frmAdoptionInfo.hdnIdResource.value = idResource;\r\n  document.frmAdoptionInfo.hdnNmResource.value = nmResource;\r\n  document.frmAdoptionInfo.txtResourceName.value = nmResource;\r\n  submitValidateForm( \"frmAdoptionInfo\", \"/resource/ResourceSearch/results\" );\r\n  }\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction stepIndicator(idres,nmres)\r\n  {\r\n   var field1 =eval(\"document.getElementById(\\\"\"+idres+\"_Id\\\")\");\r\n   var field2 =eval(\"document.getElementById(\\\"\"+nmres+\"_Id\\\")\");\r\n   var value1 = field1.value;\r\n   var value2 = field2.value;\r\n   document.frmAdoptionInfo.hdnIdResourcetoDelete.value = value1;\r\n   document.frmAdoptionInfo.hdnNmResourcetoDelete.value = value2;\r\n   \r\n  }\r\n\r\n\t\r\n\t\r\nfunction DeleteResource()\r\n  {\r\n    var cont;\r\n");
      out.write("      \r\n    if( checkForSelection('document.frmAdoptionInfo.rbAdoptionIndex'))\r\n    {\r\n         cont = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("');\r\n    }\r\n    else\r\n    {\r\n         alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n         cont = false;\r\n    }\r\n    return cont;\r\n  }\r\n  function checkForSelection( objName )\r\n  {\r\n    var buttonChecked = false;\r\n    var obj = eval(objName);\r\n\r\n    if (obj != null)\r\n    {\r\n      if (obj.length == null)\r\n      {\r\n        if (obj.checked != false)\r\n          buttonChecked = true;\r\n      }\r\n      else\r\n      {\r\n        for (var i = 0; i < obj.length; ++i)\r\n        {\r\n          buttonChecked = buttonChecked || obj[i].checked;\r\n        }\r\n      }\r\n    }\r\n\r\n  return (buttonChecked);\r\n}   \r\n\r\nfunction checkSave()\r\n{\t\r\n  if (isPageChanged())  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEF_CONT ));
      out.write("');\r\n    return false;\r\n  }\r\n  disableValidation('frmAdoptionInfo');\r\n  return true;\r\n} \r\n\r\nfunction checkSaveBeforeAddingGroup()\r\n{\t\r\n  if (isPageChanged())  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SAVE_PAGE_B4_ADD_GROUP));
      out.write("');\r\n    return false;\r\n  }\r\n  disableValidation('frmAdoptionInfo');\r\n  return true;\r\n} \r\n\r\n// Per STGAP000102095 modified the following method to accept one more parameter - nameChildPerson\r\nfunction getExchChildPage(idChildEvent, idChildPerson, nameChildPerson)\r\n{ \r\n  document.frmAdoptionInfo.hdnIdChildEventFromAdoInfo.value = \"\";\r\n  document.frmAdoptionInfo.hdnIdChildPersonFromAdoInfo.value = \"\";\r\n  document.frmAdoptionInfo.hdnNameChildPersonFromAdoInfo.value = \"\";\r\n  \r\n  document.frmAdoptionInfo.hdnIdChildEventFromAdoInfo.value = idChildEvent;\r\n  document.frmAdoptionInfo.hdnIdChildPersonFromAdoInfo.value = idChildPerson;\r\n  document.frmAdoptionInfo.hdnNameChildPersonFromAdoInfo.value = nameChildPerson;\r\n  submitValidateForm( \"frmAdoptionInfo\", \"/subcare/AdoptionInformation/displayChildDetail\" );\r\n}\r\n\r\n//begin check all siblings\r\n\tfunction checkAllSiblingsPlaced(){\r\n\t\tvar numOfChildren = ");
      out.print(numOfSiblings);
      out.write(";\r\n\t\tvar numOfNewSiblingGroups = ");
      out.print(numOfNewSiblingGroups);
      out.write(";\r\n\t\tif(numOfChildren == 1){\r\n\t\t\treturn true;//only one child in sibling group no need to specify placement\r\n\t\t}\r\n\t\t//checkForMultipleSiblingGroups();\r\n\t\tfor(var s = 0; s < numOfChildren; ++s) {\r\n\t\t\tvar siblingCbxName = 'cbx_sibling_'+s;\r\n\t\t\tvar foundCheck = false;\r\n\t\t\tvar newSiblingCbxName = 'cbx_New_PG_'+s;\r\n\t\t\t\r\n  \t\t\tfor (i=0; i < document.frmAdoptionInfo.elements.length; i++)\r\n\t\t\t{\r\n\t\t\t\tvar formElement = document.frmAdoptionInfo.elements(i);\r\n\t\t\t\t\r\n\t\t\t\t//is existing check box checked???\r\n\t\t\t\tif( formElement.name.substring(0,13) == siblingCbxName && formElement.checked){\r\n\t\t\t\t\t//alert('found check for -->'+formElement.name);\r\n\t\t\t\t\tfoundCheck=true;\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\t\t\t\t//is new checkbox checked???\r\n\t\t\t\tif(numOfNewSiblingGroups > 0) {\r\n\t\t\t\t\tif( formElement.name.substring(0,12) == newSiblingCbxName && formElement.checked){\r\n\t\t\t\t\t\t//alert('***NEW****found check for -->'+formElement.name);\r\n\t\t\t\t\t\tfoundCheck=true;\r\n\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\tif(foundCheck == false) {\r\n\t\t\t\t//alert('no checks were found for '+siblingCbxName);\r\n");
      out.write("\t\t\t\tvar answer = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CHLD_NO_SUB_GROUP));
      out.write("');\r\n\t\t\t\tif(answer) {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t} else {\r\n\t\t\t\t\treturn false;\r\n\t\t\t\t}\t\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn true;\t\t\r\n\t}\r\n//end check all siblings\r\n\r\nfunction toggleSiblingExternalQuestions()\r\n{\r\n  if(document.frmAdoptionInfo.rbHasSiblingExtCase){\r\n    var bHasSiblingExtCase = getSelectedRadioValue(document.frmAdoptionInfo.rbHasSiblingExtCase);\r\n\r\n    if(bHasSiblingExtCase != null && bHasSiblingExtCase != \"Y\"){\r\n      resetCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);\r\n      disableCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);\r\n    }else{\r\n      enableCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);\r\n    }\r\n\r\n    var bSiblingGrpExtCase = getSelectedRadioValue(document.frmAdoptionInfo.rbSiblingGrpExtCase);\r\n    if(bSiblingGrpExtCase != null && bSiblingGrpExtCase != \"Y\"){\r\n        toggleVisibility(\"div_lblSiblingGrpExtCase\", \"none\");\r\n        toggleVisibility(\"div_selSiblingGrpExtCase\", \"none\");\r\n    }else{\r\n        toggleVisibility(\"div_lblSiblingGrpExtCase\", \"block\");\r\n        toggleVisibility(\"div_selSiblingGrpExtCase\", \"block\");\r\n");
      out.write("    }\r\n\r\n");

  int siblingOptionCtr = 0;
  for(Iterator<Option> optIter = siblingExtCaseOptionList.iterator(); optIter.hasNext();){
    Option option = optIter.next();
    if(option.getKey() != ""){

      out.write("\r\n    if(document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(" != undefined && document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".options != undefined){\r\n      if (bSiblingGrpExtCase != null && bSiblingGrpExtCase != \"Y\" ){\r\n        for(var i = 0; i < document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".options.length; i++){\r\n        //clear and disable sibling dropdowns\r\n          document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".options[i].selected = false;\r\n        }\r\n        document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".selectedIndex = 0;\r\n        document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".disabled = true;\r\n      }else{\r\n        //enable sibling dropdowns\r\n        document.frmAdoptionInfo.selSiblingsExtCase_");
      out.print( siblingOptionCtr );
      out.write(".disabled = false;\r\n      }\r\n    }    \r\n");

      siblingOptionCtr++;
    }
  }

      out.write("\r\n  }\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAdoptionInfo");
      _jspx_th_impact_validateForm_0.setAction("/subcare/AdoptionInformation/displayAdoption");
      _jspx_th_impact_validateForm_0.setPageMode(editableMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setClientValidation("true");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.AdoptionInformationCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\r\n\t");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnResourceId");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatInt(hdnResourceId));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a tabindex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand\tAll</a>&nbsp;\r\n\t\t\t\t<a tabindex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse\tAll</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t");

	  if((siblingList != null && siblingList.size() != 0) || hasSiblingExternal) {
	
          out.write("\r\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSibling Group Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"E2E1C3\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<div class=\"alignRight\">\r\n\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t# available for adoption: ");
          out.print(totalAvailableForAdoption);
          out.write("\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"alignRight\">\r\n\t\t\t\t\t\t\t\t<div class=\"formInstruct\">\r\n\t\t\t\t\t\t\t\t\tScroll for more information --&gt;\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t");

							  if(hasSiblings) {
							
          out.write("\r\n\t\t\t\t\t\t\t<div id=\"scrollBar2\"\r\n\t\t\t\t\t\t\t\tstyle=\"height: 210px; width: 763px; overflow: auto\"\r\n\t\t\t\t\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
          out.write("\r\n\t\t\t\t\t\t\t\t<div id=\"scrollBar2\"\r\n\t\t\t\t\t\t\t\t\tstyle=\"height: 100px; width: 763px; overflow: auto\"\r\n\t\t\t\t\t\t\t\t\tclass=\"tableborderList\">\r\n\r\n\t\t\t\t\t\t\t\t\t");

									  }
									
          out.write("\r\n\t\t\t\t\t\t\t\t\t<table width=\"1500\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t      <th class=\"locked\" width=\"200\">Name</th>\r\n\t\t\t\t\t\t\t\t      <th class=\"locked\" width=\"200\">Legal status</th>\r\n\t\t\t\t\t\t\t\t      <th class=\"locked\" width=\"100\">Non-Avail Status</th>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  for (int i = 0; i < siblingPlacementGroupList.size(); ++i) {
											        //create columns for sibling placementt groups
											        SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO) siblingPlacementGroupList.get(i);
											
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<th class=\"thList\">Placement Group:&nbsp;");
          out.print(FormattingHelper.formatInt(sg.getIdSiblingGroup()));
          out.write("</th>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  }
											      //create columns for new sibling groups if they exist.
											      //if(newSiblingPlacementGroupList != null){
											      for (int i = 0; i < numOfNewSiblingGroups; ++i) {
											        //create columns for sibling placementt groups
											        //SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO)newSiblingPlacementGroupList.get(i);
											
          out.write("\r\n\t\t                  <th class=\"thList\">Placement Group:&nbsp;");
          out.print("New ("+i+")");
          out.write("</th>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  }
											      //	}
											
          out.write("\r\n\r\n                      <th class=\"thList\">&nbsp;</th>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t");

										  loopCount = 1;
										      for (int i = 0; i < siblingList.size(); ++i) {
										        SiblingSO sibling = (SiblingSO) siblingList.get(i);
										        int idPerson = sibling.getIdPerson();

    	                      String legalActionList = (sibling.getLegalActionsList().length()==0) ? "&nbsp;": sibling.getLegalActionsList();
										
          out.write("\r\n                    <tr class=\"");
          out.print(FormattingHelper.getRowCss(loopCount++));
          out.write("\" valign=\"top\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t");

	  	                      if(sibling.getIdChildRegEvent() == 0 || user.hasRight(UserProfile.SEC_SAU_EXCHANGE) == false) {
											
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"locked\" width=\"200\">\r\n\t  \t\t                 ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("sibName_"+ idPerson);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(sibling.getChildName());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  } else {
											
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"locked\" width=\"200\">\r\n\t  \t\t\t              <a href=\"javascript:getExchChildPage('");
          out.print(sibling.getIdChildRegEvent());
          out.write("', '");
          out.print(sibling.getIdPerson());
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print(sibling.getChildName());
          out.write("' )\" \r\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n\t\t\t\t                  ");
          out.print(sibling.getChildName());
          out.write("\r\n\t\t                    </a>\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  }
											
          out.write("\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"locked\" width=\"200\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");

													  StringTokenizer st = new StringTokenizer(legalActionList, ";");
													        while (st.hasMoreTokens()) {
													
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          out.print(st.nextToken());
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");

													  }
													
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t                    <td class=\"locked\" width=\"100\">");
          out.print((sibling.getNonAvailStatus()!= null)? Lookup.simpleDecodeSafe("CANONAV", sibling.getNonAvailStatus()): "N/A");
          out.write("</td>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  for (int p = 0; p < siblingPlacementGroupList.size(); ++p) {
                          SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO)siblingPlacementGroupList.get(p);
											
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t");

												  boolean checked = false;
												          Integer personIdInteger = new Integer(idPerson);

												          if(siblingGroupings.get(sibling) != null) {
                      		SiblingPlacementGroupSO selectedPlacementGroup = (SiblingPlacementGroupSO)siblingGroupings.get(sibling);	
                      		if(sg.getIdSiblingGroup() == selectedPlacementGroup.getIdSiblingGroup()){
												              checked = true;
												            }
												          }
												
          out.write("\r\n                        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setLabel("");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setChecked((checked) ? "true" : "false");
          _jspx_th_impact_validateInput_10.setName("cbx_sibling_" + i + "_" + sg.getIdSiblingGroup());
          _jspx_th_impact_validateInput_10.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_10.setValue("_"+sg.getIdSiblingGroup() + "_"+sibling.getIdPerson());
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  }
											
          out.write("\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  for (int p = 0; p < numOfNewSiblingGroups; ++p) {
											
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t<td>\r\n                        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setLabel("");
          _jspx_th_impact_validateInput_11.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setName("cbx_New_PG_" + i + "_"+ p);
          _jspx_th_impact_validateInput_11.setValue("_"+ p + "_"+sibling.getIdPerson());
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t");

											  }
											
          out.write("\r\n\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t");

										  }
										
          out.write("\r\n\t\t\t\t\t\t\t\t\t</table>\r\n\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\t\t\t");

							  if(hasSiblings) {
							
          out.write("\r\n\t\t\t\t\t\t\t<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setForm("frmAdoptionInfo");
          _jspx_th_impact_ButtonTag_0.setImg("btnAddGroup");
          _jspx_th_impact_ButtonTag_0.setName("btnAddSiblingGroup");
          _jspx_th_impact_ButtonTag_0.setAction("/subcare/AdoptionInformation/addSiblingGroup");
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setFunction("return checkSaveBeforeAddingGroup();");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t");

							  }
							
          out.write("\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span>");
          if (_jspx_meth_impact_validateDisplayOnlyField_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Yes");
          _jspx_th_impact_validateInput_12.setId("rbHasSiblingExtCase_Yes");
          _jspx_th_impact_validateInput_12.setName("rbHasSiblingExtCase");
          _jspx_th_impact_validateInput_12.setValue("Y");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setOnClick("toggleSiblingExternalQuestions();");
          _jspx_th_impact_validateInput_12.setChecked( String.valueOf(ArchitectureConstants.Y.equals(adoptioninformationret.getIndHasSiblingExtCase())) );
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("No");
          _jspx_th_impact_validateInput_13.setId("rbHasSiblingExtCase_No");
          _jspx_th_impact_validateInput_13.setName("rbHasSiblingExtCase");
          _jspx_th_impact_validateInput_13.setValue("N");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setOnClick("toggleSiblingExternalQuestions();");
          _jspx_th_impact_validateInput_13.setChecked( String.valueOf(ArchitectureConstants.N.equals(adoptioninformationret.getIndHasSiblingExtCase())) );
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("Yes");
          _jspx_th_impact_validateInput_14.setId("rbSiblingGrpExtCase_Yes");
          _jspx_th_impact_validateInput_14.setName("rbSiblingGrpExtCase");
          _jspx_th_impact_validateInput_14.setValue("Y");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setOnClick("toggleSiblingExternalQuestions();");
          _jspx_th_impact_validateInput_14.setChecked( String.valueOf(ArchitectureConstants.Y.equals(adoptioninformationret.getIndSiblingGrpExtCase())) );
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setLabel("No");
          _jspx_th_impact_validateInput_15.setId("rbSiblingGrpExtCase_No");
          _jspx_th_impact_validateInput_15.setName("rbSiblingGrpExtCase");
          _jspx_th_impact_validateInput_15.setValue("N");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setOnClick("toggleSiblingExternalQuestions();");
          _jspx_th_impact_validateInput_15.setChecked( String.valueOf(ArchitectureConstants.N.equals(adoptioninformationret.getIndSiblingGrpExtCase())) );
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n                  <td colspan=\"2\">\r\n                  <div id=\"div_lblSiblingGrpExtCase\">\r\n                    ");
          if (_jspx_meth_impact_validateDisplayOnlyField_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n                  </div>\r\n                  </td>\r\n                </tr>\r\n                <tr class=\"odd\">\r\n                  <td colspan=\"2\">\r\n                  <div id=\"div_selSiblingGrpExtCase\">\r\n");

                // get list of the previously saved sibling with open ADO in another case
                List<String> siblingExtLnkPersonIdList = new ArrayList<String>();
                Iterator<SiblingExternalLinkStruct> selIter = siblingExternalLinkList.iterator();
                while(selIter.hasNext()){
                  SiblingExternalLinkStruct sel = selIter.next();
                  siblingExtLnkPersonIdList.add(String.valueOf(sel.getIdPerson()));
                }
                
                int i = 0;
                
                for(Iterator<Option> optIter = siblingExtCaseOptionList.iterator(); optIter.hasNext();){
                  String selName = "selSiblingsExtCase_" + i;
                  Option option = optIter.next();
                  if(StringHelper.isNotEmptyOrNull(option.getKey()) && option.getKey() != "0"){
                    String optRequest = ContextHelper.getStringSafe(request, selName);

                    // no value from request then set to value if one of the previously saved sibling
                    if(StringHelper.isEmptyOrNull(optRequest) && siblingExtLnkPersonIdList.contains(option.getKey())){

          out.write("\r\n                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_0.setName( selName );
          _jspx_th_impact_validateSelect_0.setBlankValue("false");
          _jspx_th_impact_validateSelect_0.setValue( option.getKey() );
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setOptions( siblingExtCaseOptionList );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    <br>\r\n");

                    }else{

          out.write("\r\n                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_1.setName( selName );
          _jspx_th_impact_validateSelect_1.setBlankValue("false");
          _jspx_th_impact_validateSelect_1.setValue( optRequest );
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setOptions( siblingExtCaseOptionList );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    <br>\r\n");

                    }
                    i++;
                  }
                }

          out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n                  </div>\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	  }
	
          out.write("\r\n\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("ResourceIdentificationSection");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Identified Resources");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setType("checkbox");
              _jspx_th_impact_validateInput_16.setLabel("Child Has An Identified Adoptive Resource");
              _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_16.setChecked((("".equals(indIdentifiedAdopRes)) || (ArchitectureConstants.N.equals(indIdentifiedAdopRes))) ? "false" : "true");
              _jspx_th_impact_validateInput_16.setValue("Y");
              _jspx_th_impact_validateInput_16.setName("indIdentifiedAdopRes");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tChild is linked:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setName("szCdChildLinked");
              _jspx_th_impact_validateTextArea_0.setCols("92");
              _jspx_th_impact_validateTextArea_0.setRows("3");
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdChildLinked);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_4.setName("txtSzNmAdpRes");
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Adoptive Resource Name");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue(txtSzNmAdpRes);
              _jspx_th_impact_validateDisplayOnlyField_4.setConditionallyRequired("false");
              _jspx_th_impact_validateDisplayOnlyField_4.setCssClass("formInput");
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t\t<span style=\"vertical-align: right;\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnSelectResourceIdResource");
              _jspx_th_impact_ButtonTag_1.setImg("btnSelectResource");
              _jspx_th_impact_ButtonTag_1.setForm("frmAdoptionInfo");
              _jspx_th_impact_ButtonTag_1.setFunction("return checkSave();");
              _jspx_th_impact_ButtonTag_1.setAction("/subcare/AdoptionInformation/retrieveAdoResource");
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" </span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_5.setName("txtSzHomeType");
              _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Home Type");
              _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.initCaps(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, txtSzHomeType)));
              _jspx_th_impact_validateDisplayOnlyField_5.setConditionallyRequired("false");
              _jspx_th_impact_validateDisplayOnlyField_5.setCssClass("formInput");
              int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_6.setName("txtSzCounty");
              _jspx_th_impact_validateDisplayOnlyField_6.setLabel("County");
              _jspx_th_impact_validateDisplayOnlyField_6.setCodesTable("CCOUNT");
              _jspx_th_impact_validateDisplayOnlyField_6.setValue(StringHelper.getNonNullString(txtSzCounty));
              _jspx_th_impact_validateDisplayOnlyField_6.setConditionallyRequired("false");
              _jspx_th_impact_validateDisplayOnlyField_6.setCssClass("formInput");
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_7.setName("txtSzNmPrAgency");
              _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Private Agency Name");
              _jspx_th_impact_validateDisplayOnlyField_7.setValue(txtSzNmPrAgency);
              _jspx_th_impact_validateDisplayOnlyField_7.setConditionallyRequired("false");
              _jspx_th_impact_validateDisplayOnlyField_7.setCssClass("formInput");
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_8.setName("txtSzICPCState");
              _jspx_th_impact_validateDisplayOnlyField_8.setLabel("ICPC State");
              _jspx_th_impact_validateDisplayOnlyField_8.setValue(txtSzICPCState);
              _jspx_th_impact_validateDisplayOnlyField_8.setConditionallyRequired("false");
              _jspx_th_impact_validateDisplayOnlyField_8.setCssClass("formInput");
              int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("FamiliesConsideredSection");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Families Considered - Adoption Exchange Referral");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<div style=\"width: 100%; height: 50px; overflow: auto;\">");
              out.print(szCdExchConsidered);
              out.write("</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate Considered\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tResource ID\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tName\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\" colspan=\"2\">\r\n\t\t\t\t\tNon-Selection Reason\r\n\t\t\t\t</th>\r\n\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t");

			  if(childFamilyLinkList == null || childFamilyLinkList.isEmpty()) {
			          //NO Rows rEturned.
			
              out.write("\r\n\t\t\t<tr class=\"odd\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              out.print(MessageLookup
                  .getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t");

			  } else {
			          loopCount = 1;
			          for (int i = 0; i < childFamilyLinkList.size(); ++i) {
			            ExchangeChildFamilyLinkBean childFamilyLink = (ExchangeChildFamilyLinkBean) childFamilyLinkList
			                .get(i);
			
              out.write("\r\n\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount++));
              out.write("\" valign=\"top\">\r\n\r\n\t\t\t\t<td>");
              out.print(childFamilyLink.getDtOut());
              out.write("&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>");
              out.print(childFamilyLink.getIdResource());
              out.write("&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>");
              out.print(childFamilyLink.getResourceName());
              out.write("</td>\r\n\r\n\t\t\t\t<td>");
              out.print((childFamilyLink.getCdNonSelectionReason() != null) ? Lookup
                    .simpleDecodeSafe("CADNSLCT",
                        childFamilyLink.getCdNonSelectionReason()) : "");
              out.write("</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t");

			  }
			        }
			
              out.write("\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("adoptivefam");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("County/Regional Considered Families");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setName("nmFamConsidered");
              _jspx_th_impact_validateInput_17.setLabel("Number of Families Considered");
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setSize("5");
              _jspx_th_impact_validateInput_17.setMaxLength("5");
              _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatInt(nmFamConsidered));
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setName("szCdCountyConsideredComments");
              _jspx_th_impact_validateTextArea_1.setCols("92");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setMaxLength(2000);
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph2000");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdCountyConsideredComments);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_18.setType("checkbox");
              _jspx_th_impact_validateInput_18.setLabel("An Out of Town Inquiry Home Study Has Been requested");
              _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_18.setChecked((("".equals(indOutofTown)) || (ArchitectureConstants.N.equals(indOutofTown))) ? "false" : "true");
              _jspx_th_impact_validateInput_18.setValue("Y");
              _jspx_th_impact_validateInput_18.setName("indOutofTown");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\t<br>\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("PreperationActivitiesSection");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Preparation Activities");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:castorCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
              _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_castorCheckbox_0.setCastorEnum(Collections.enumeration(preparationactsList));
              _jspx_th_impact_castorCheckbox_0.setName("chkPreperationActivities");
              _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
              _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
              _jspx_th_impact_castorCheckbox_0.setCheckedValues(checkedPreperationActivities);
              _jspx_th_impact_castorCheckbox_0.setColumns(2);
              _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
              _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
              _jspx_th_impact_castorCheckbox_0.setTabIndex(tabIndex++);
              _jspx_th_impact_castorCheckbox_0.setOnClick("");
              int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
              if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_2.setName("szCdComntsPrepAct");
              _jspx_th_impact_validateTextArea_2.setCols("92");
              _jspx_th_impact_validateTextArea_2.setRows("3");
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdComntsPrepAct);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("BarriersRecruitmentSection");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Barriers to Recruitment");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:castorCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
              _jspx_th_impact_castorCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_castorCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_castorCheckbox_1.setCastorEnum(Collections.enumeration(barrtorecrmntList));
              _jspx_th_impact_castorCheckbox_1.setName("chkBarriersRecruitment");
              _jspx_th_impact_castorCheckbox_1.setLabelPropertyName("Code");
              _jspx_th_impact_castorCheckbox_1.setValuePropertyName("Decode");
              _jspx_th_impact_castorCheckbox_1.setCheckedValues(checkedBarriersRecruitment);
              _jspx_th_impact_castorCheckbox_1.setColumns(2);
              _jspx_th_impact_castorCheckbox_1.setIsRuled(false);
              _jspx_th_impact_castorCheckbox_1.setIsHorizontal(false);
              _jspx_th_impact_castorCheckbox_1.setTabIndex(tabIndex++);
              _jspx_th_impact_castorCheckbox_1.setOnClick("");
              int _jspx_eval_impact_castorCheckbox_1 = _jspx_th_impact_castorCheckbox_1.doStartTag();
              if (_jspx_th_impact_castorCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_3.setName("szCdComntsBarRec");
              _jspx_th_impact_validateTextArea_3.setCols("92");
              _jspx_th_impact_validateTextArea_3.setRows("3");
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdComntsBarRec);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("RecruitmentActsSection");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Recruitment Activities");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tState\r\n\t\t\t\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"46%\" colspan=\"2\">\r\n\t\t\t\t\t\t\t\tActively Recruiting?\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_19.setType("radio");
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setId("rbStateActRecruiting_Yes");
              _jspx_th_impact_validateInput_19.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_19.setLabel("Yes");
              _jspx_th_impact_validateInput_19.setValue("Y");
              _jspx_th_impact_validateInput_19.setDisabled("true");
              _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_19.setChecked(String.valueOf(CodesTables.CYESNONA_Y.equals(szCdStateActivelyRecruiting)));
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_20.setType("radio");
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setId("rbStateActRecruiting_No");
              _jspx_th_impact_validateInput_20.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_20.setLabel("No");
              _jspx_th_impact_validateInput_20.setValue("N");
              _jspx_th_impact_validateInput_20.setDisabled("true");
              _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_20.setChecked(String.valueOf(CodesTables.CYESNONA_N.equals(szCdStateActivelyRecruiting)));
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_21.setType("radio");
              _jspx_th_impact_validateInput_21.setCssClass("formInput");
              _jspx_th_impact_validateInput_21.setId("rbStateActRecruiting_NA");
              _jspx_th_impact_validateInput_21.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_21.setLabel("N/A");
              _jspx_th_impact_validateInput_21.setValue("A");
              _jspx_th_impact_validateInput_21.setDisabled("true");
              _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_21.setChecked(String.valueOf(CodesTables.CYESNONA_A.equals(szCdStateActivelyRecruiting) || StringHelper.isEmptyOrNull(szCdStateActivelyRecruiting)));
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  int iLoopCounter = 0;

						        for (int i = 0; i < recactsstateList.size(); ++i) {
						          CodeAttributes att = (CodeAttributes) recactsstateList.get(i);

						          List<Date> datesToDisplay = savedRecActivitiesDatesState.get(att
						              .getCode());

						          int sizeOfDateList = 0;

						          if(datesToDisplay != null) {
						            sizeOfDateList = datesToDisplay.size();
						          }
						
              out.write("\r\n\r\n\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter));
              out.write("\">\r\n\t\t\t\t\t\t\t<td align=\"left\" width=\"46%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_9.setLabel(att.getDecode());
              _jspx_th_impact_validateDisplayOnlyField_9.setName(att.getDecode());
              int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_22.setType("text");
              _jspx_th_impact_validateInput_22.setName(att.getCode() + "Date0");
              _jspx_th_impact_validateInput_22.setCssClass("formInput");
              _jspx_th_impact_validateInput_22.setMaxLength("7");
              _jspx_th_impact_validateInput_22.setSize("8");
              _jspx_th_impact_validateInput_22.setDisabled("true");
              _jspx_th_impact_validateInput_22.setValue(((sizeOfDateList > 0) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(0)): "");
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_23.setType("text");
              _jspx_th_impact_validateInput_23.setName(att.getCode() + "Date1");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setMaxLength("7");
              _jspx_th_impact_validateInput_23.setSize("8");
              _jspx_th_impact_validateInput_23.setDisabled("true");
              _jspx_th_impact_validateInput_23.setValue(((sizeOfDateList > 1) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(1)): "");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_24.setType("text");
              _jspx_th_impact_validateInput_24.setName(att.getCode() + "Date2");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setMaxLength("7");
              _jspx_th_impact_validateInput_24.setSize("8");
              _jspx_th_impact_validateInput_24.setDisabled("true");
              _jspx_th_impact_validateInput_24.setValue(((sizeOfDateList > 2)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(2)): "");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_25.setType("text");
              _jspx_th_impact_validateInput_25.setName(att.getCode() + "Date3");
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setMaxLength("7");
              _jspx_th_impact_validateInput_25.setSize("8");
              _jspx_th_impact_validateInput_25.setDisabled("true");
              _jspx_th_impact_validateInput_25.setValue(((sizeOfDateList > 3)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(3)): "");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_26.setType("text");
              _jspx_th_impact_validateInput_26.setName(att.getCode() + "Date4");
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setMaxLength("7");
              _jspx_th_impact_validateInput_26.setSize("8");
              _jspx_th_impact_validateInput_26.setDisabled("true");
              _jspx_th_impact_validateInput_26.setValue(((sizeOfDateList > 4)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(4)): "");
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter++));
              out.write("\">\r\n\t\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_27.setType("text");
              _jspx_th_impact_validateInput_27.setName(att.getCode() + "Date5");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setMaxLength("7");
              _jspx_th_impact_validateInput_27.setSize("8");
              _jspx_th_impact_validateInput_27.setDisabled("true");
              _jspx_th_impact_validateInput_27.setValue(((sizeOfDateList > 5) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(5)): "");
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_28.setType("text");
              _jspx_th_impact_validateInput_28.setName(att.getCode() + "Date6");
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setMaxLength("7");
              _jspx_th_impact_validateInput_28.setSize("8");
              _jspx_th_impact_validateInput_28.setDisabled("true");
              _jspx_th_impact_validateInput_28.setValue(((sizeOfDateList > 6) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(6)): "");
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_29.setType("text");
              _jspx_th_impact_validateInput_29.setName(att.getCode() + "Date7");
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setMaxLength("7");
              _jspx_th_impact_validateInput_29.setSize("8");
              _jspx_th_impact_validateInput_29.setDisabled("true");
              _jspx_th_impact_validateInput_29.setValue(((sizeOfDateList > 7)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(7)): "");
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setName(att.getCode() + "Date8");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setMaxLength("7");
              _jspx_th_impact_validateInput_30.setSize("8");
              _jspx_th_impact_validateInput_30.setDisabled("true");
              _jspx_th_impact_validateInput_30.setValue(((sizeOfDateList > 8)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(8)): "");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_31.setType("text");
              _jspx_th_impact_validateInput_31.setName(att.getCode() + "Date9");
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setMaxLength("7");
              _jspx_th_impact_validateInput_31.setSize("8");
              _jspx_th_impact_validateInput_31.setDisabled("true");
              _jspx_th_impact_validateInput_31.setValue(((sizeOfDateList > 9)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(9)): "");
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  }
						
              out.write("\r\n\r\n\t\t\t\t\t</table>\r\n\r\n\t\t\t\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t\t\t\tComments:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t<div style=\"width: 100%; height: 50px; overflow: auto;\">");
              out.print(szCdComntsRecActsState);
              out.write("</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tCounty\r\n\t\t\t\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t\t\t");

						  iLoopCounter = 0;

						        for (int i = 0; i < activityCodesList.size(); ++i) {
						          CodeAttributes att = (CodeAttributes) activityCodesList.get(i);

						          List<AdoInfoCbxSentStruct> recActDatesToDisplay = null;

						          if(savedRecActivitiesDatesCounty != null) {
						            recActDatesToDisplay = savedRecActivitiesDatesCounty.get(att
						                .getCode());
						          }

						          int sizeOfDateList = 0;

						          if(recActDatesToDisplay != null) {
						            sizeOfDateList = recActDatesToDisplay.size();
						          }
						
              out.write("\r\n\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter));
              out.write("\">\r\n\t\t\t\t\t\t\t<td width=\"25%\" colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDate_0.setLabel(att.getDecode());
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setValue("");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setName("dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setCssClass("formInput");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_32.setConstraint("Date");
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setName("Date0_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setSize("8");
              _jspx_th_impact_validateInput_32.setValue(((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(0).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_33.setType("hidden");
              _jspx_th_impact_validateInput_33.setName("Date0_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_33.setValue( ((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(0).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_34.setConstraint("Date");
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setName("Date1_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setSize("8");
              _jspx_th_impact_validateInput_34.setValue(((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(1).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_35.setType("hidden");
              _jspx_th_impact_validateInput_35.setName("Date1_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_35.setValue( ((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(1).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_36.setConstraint("Date");
              _jspx_th_impact_validateInput_36.setType("text");
              _jspx_th_impact_validateInput_36.setName("Date2_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setSize("8");
              _jspx_th_impact_validateInput_36.setValue(((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(2).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_37.setType("hidden");
              _jspx_th_impact_validateInput_37.setName("Date2_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_37.setValue( ((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(2).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_38.setConstraint("Date");
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setName("Date3_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setSize("8");
              _jspx_th_impact_validateInput_38.setValue(((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(3).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_39.setType("hidden");
              _jspx_th_impact_validateInput_39.setName("Date3_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_39.setValue( ((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(3).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_40.setConstraint("Date");
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setName("Date4_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setSize("8");
              _jspx_th_impact_validateInput_40.setValue(((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(4).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_41.setType("hidden");
              _jspx_th_impact_validateInput_41.setName("Date4_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_41.setValue( ((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(4).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter++));
              out.write("\">\r\n\t\t\t\t\t\t\t<td colspan=\"3\"></td>\r\n\t\t\t\t\t\t\t<td>\r\n\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_42.setConstraint("Date");
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setName("Date5_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setSize("8");
              _jspx_th_impact_validateInput_42.setValue(((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(5).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_43.setType("hidden");
              _jspx_th_impact_validateInput_43.setName("Date5_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_43.setValue( ((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(5).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_44.setConstraint("Date");
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setName("Date6_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setSize("8");
              _jspx_th_impact_validateInput_44.setValue(((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(6).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_45.setType("hidden");
              _jspx_th_impact_validateInput_45.setName("Date6_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_45.setValue( ((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(6).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_46.setConstraint("Date");
              _jspx_th_impact_validateInput_46.setType("text");
              _jspx_th_impact_validateInput_46.setName("Date7_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_46.setCssClass("formInput");
              _jspx_th_impact_validateInput_46.setSize("8");
              _jspx_th_impact_validateInput_46.setValue(((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(7).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_47.setType("hidden");
              _jspx_th_impact_validateInput_47.setName("Date7_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_47.setValue( ((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(7).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_48.setConstraint("Date");
              _jspx_th_impact_validateInput_48.setType("text");
              _jspx_th_impact_validateInput_48.setName("Date8_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_48.setCssClass("formInput");
              _jspx_th_impact_validateInput_48.setSize("8");
              _jspx_th_impact_validateInput_48.setValue(((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(8).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_49.setType("hidden");
              _jspx_th_impact_validateInput_49.setName("Date8_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_49.setValue( ((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(8).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_50.setConstraint("Date");
              _jspx_th_impact_validateInput_50.setType("text");
              _jspx_th_impact_validateInput_50.setName("Date9_dtRecActCounty" + att.getCode());
              _jspx_th_impact_validateInput_50.setCssClass("formInput");
              _jspx_th_impact_validateInput_50.setSize("8");
              _jspx_th_impact_validateInput_50.setValue(((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(9).getDtAdoInfoCbxSent()) : "");
              _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_51.setType("hidden");
              _jspx_th_impact_validateInput_51.setName("Date9_idAdoInfoCbxSent" + att.getCode());
              _jspx_th_impact_validateInput_51.setValue( ((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(9).getIdAdoInfoCbxSent()) : "0");
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  }
						
              out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t\t\t\tComments:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateTextArea_4.setName("szCdComntsRecActsCounty");
              _jspx_th_impact_validateTextArea_4.setCols("92");
              _jspx_th_impact_validateTextArea_4.setRows("3");
              _jspx_th_impact_validateTextArea_4.setMaxLength(1000);
              _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph1000");
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t\t");
                  out.print(szCdComntsRecActsCounty);
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_6.setName("BarriersPlacementSection");
          _jspx_th_impact_ExpandableSectionTag_6.setLabel("Barriers to Placement");
          _jspx_th_impact_ExpandableSectionTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_6 = _jspx_th_impact_ExpandableSectionTag_6.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:castorCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
              _jspx_th_impact_castorCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_castorCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_castorCheckbox_2.setCastorEnum( Collections.enumeration(barrtoplacmntList) );
              _jspx_th_impact_castorCheckbox_2.setName("chkBarriersPlacement");
              _jspx_th_impact_castorCheckbox_2.setLabelPropertyName("Code");
              _jspx_th_impact_castorCheckbox_2.setValuePropertyName("Decode");
              _jspx_th_impact_castorCheckbox_2.setCheckedValues( checkedBarriersPlacement);
              _jspx_th_impact_castorCheckbox_2.setColumns(2);
              _jspx_th_impact_castorCheckbox_2.setIsRuled(false);
              _jspx_th_impact_castorCheckbox_2.setIsHorizontal(false);
              _jspx_th_impact_castorCheckbox_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_castorCheckbox_2.setOnClick("");
              int _jspx_eval_impact_castorCheckbox_2 = _jspx_th_impact_castorCheckbox_2.doStartTag();
              if (_jspx_th_impact_castorCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_validateTextArea_5.setName("szCdComntsBarPla");
              _jspx_th_impact_validateTextArea_5.setCols("92");
              _jspx_th_impact_validateTextArea_5.setRows("3");
              _jspx_th_impact_validateTextArea_5.setMaxLength(300);
              _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdComntsBarPla);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_7.setName("BarriersTPRSection");
          _jspx_th_impact_ExpandableSectionTag_7.setLabel("Barriers to TPR");
          _jspx_th_impact_ExpandableSectionTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_7 = _jspx_th_impact_ExpandableSectionTag_7.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:castorCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
              _jspx_th_impact_castorCheckbox_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_castorCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_castorCheckbox_3.setCastorEnum( Collections.enumeration(barrtotprList) );
              _jspx_th_impact_castorCheckbox_3.setName("chkBarriersTPR");
              _jspx_th_impact_castorCheckbox_3.setLabelPropertyName("Code");
              _jspx_th_impact_castorCheckbox_3.setValuePropertyName("Decode");
              _jspx_th_impact_castorCheckbox_3.setCheckedValues( checkedBarriersTPR);
              _jspx_th_impact_castorCheckbox_3.setColumns(2);
              _jspx_th_impact_castorCheckbox_3.setIsRuled(false);
              _jspx_th_impact_castorCheckbox_3.setIsHorizontal(false);
              _jspx_th_impact_castorCheckbox_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_castorCheckbox_3.setOnClick("");
              int _jspx_eval_impact_castorCheckbox_3 = _jspx_th_impact_castorCheckbox_3.doStartTag();
              if (_jspx_th_impact_castorCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateTextArea_6.setName("szCdComntsBarTpr");
              _jspx_th_impact_validateTextArea_6.setCols("92");
              _jspx_th_impact_validateTextArea_6.setRows("3");
              _jspx_th_impact_validateTextArea_6.setMaxLength(300);
              _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
              if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_6.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(szCdComntsBarTpr);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\r\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tAdoption Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Foster Parents Notified of Agency intent to TPR");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( dtFostParNotAgTPR);
          _jspx_th_impact_validateDate_1.setName("dtFostParNotAgTPR");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setCssClass("formInput");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Permanency Staffing with Foster Parents");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setValue( dtPermStaffFostPar);
          _jspx_th_impact_validateDate_2.setName("dtPermStaffFostPar");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setCssClass("formInput");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Foster Parents Notified Agency of Decision to Adopt");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setValue( dtFostParNotAgDecAdpt);
          _jspx_th_impact_validateDate_3.setName("dtFostParNotAgDecAdpt");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setCssClass("formInput");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\tDecision Outcome:\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("radio");
          _jspx_th_impact_validateInput_52.setId("rbAdoptYes");
          _jspx_th_impact_validateInput_52.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_52.setName("indAdoptOutcome");
          _jspx_th_impact_validateInput_52.setLabel("Yes");
          _jspx_th_impact_validateInput_52.setValue("Y");
          _jspx_th_impact_validateInput_52.setChecked( (("".equals(indAdoptOutcome)) || (ArchitectureConstants.N.equals(indAdoptOutcome))) ? "false" : "true" );
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("radio");
          _jspx_th_impact_validateInput_53.setId("rbAdoptNo");
          _jspx_th_impact_validateInput_53.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_53.setName("indAdoptOutcome");
          _jspx_th_impact_validateInput_53.setLabel("No");
          _jspx_th_impact_validateInput_53.setValue("N");
          _jspx_th_impact_validateInput_53.setChecked( (("".equals(indAdoptOutcome)) || (ArchitectureConstants.Y.equals(indAdoptOutcome))) ? "false" : "true" );
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setLabel("Selection Letter Sent");
          _jspx_th_impact_validateDate_4.setType("text");
          _jspx_th_impact_validateDate_4.setSize("10");
          _jspx_th_impact_validateDate_4.setValue( dtSelectionLetterSent );
          _jspx_th_impact_validateDate_4.setName("dtSelectionLetterSent");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_4.setCssClass("formInput");
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setLabel("Child Life History Presentation");
          _jspx_th_impact_validateDate_5.setType("text");
          _jspx_th_impact_validateDate_5.setSize("10");
          _jspx_th_impact_validateDate_5.setValue( dtChildLifeHistPres);
          _jspx_th_impact_validateDate_5.setName("dtChildLifeHistPres");
          _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_5.setCssClass("formInput");
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setLabel("Staffing with Adoptive Family");
          _jspx_th_impact_validateDate_6.setType("text");
          _jspx_th_impact_validateDate_6.setSize("10");
          _jspx_th_impact_validateDate_6.setValue( dtStaffAdptFam);
          _jspx_th_impact_validateDate_6.setName("dtStaffAdptFam");
          _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_6.setCssClass("formInput");
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_7.setLabel("Adoptive Placement Agreement Signed");
          _jspx_th_impact_validateDate_7.setType("text");
          _jspx_th_impact_validateDate_7.setSize("10");
          _jspx_th_impact_validateDate_7.setValue( dtAdptPlacAgmtSigned);
          _jspx_th_impact_validateDate_7.setName("dtAdptPlacAgmtSigned");
          _jspx_th_impact_validateDate_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_7.setCssClass("formInput");
          _jspx_th_impact_validateDate_7.setConstraint("Date");
          int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
          if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_8.setLabel("Permission to File");
          _jspx_th_impact_validateDate_8.setType("text");
          _jspx_th_impact_validateDate_8.setSize("10");
          _jspx_th_impact_validateDate_8.setValue( dtPermFileLetterComp);
          _jspx_th_impact_validateDate_8.setName("dtPermFileLetterComp");
          _jspx_th_impact_validateDate_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_8.setCssClass("formInput");
          _jspx_th_impact_validateDate_8.setConstraint("Date");
          int _jspx_eval_impact_validateDate_8 = _jspx_th_impact_validateDate_8.doStartTag();
          if (_jspx_th_impact_validateDate_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_9.setLabel("Documents Sent");
          _jspx_th_impact_validateDate_9.setType("text");
          _jspx_th_impact_validateDate_9.setSize("10");
          _jspx_th_impact_validateDate_9.setValue( dtDocSentAttor);
          _jspx_th_impact_validateDate_9.setName("dtDocSentAttor");
          _jspx_th_impact_validateDate_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_9.setCssClass("formInput");
          _jspx_th_impact_validateDate_9.setConstraint("Date");
          int _jspx_eval_impact_validateDate_9 = _jspx_th_impact_validateDate_9.doStartTag();
          if (_jspx_th_impact_validateDate_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Disruption Date");
          _jspx_th_impact_validateDisplayOnlyField_10.setName("dtDisruption");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(dtDisruption);
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</table>\r\n\r\n\t<br>\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnComplete");
          _jspx_th_impact_ButtonTag_2.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_2.setForm("frmAdoptionInfo");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/AdoptionInformation/saveAdoption");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setDisabled("false");
          _jspx_th_impact_ButtonTag_2.setFunction("return checkAllSiblingsPlaced();");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmAdoptionInfo");
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/AdoptionInformation/saveAdoption");
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setDisabled("false");
          _jspx_th_impact_ButtonTag_3.setFunction("return checkAllSiblingsPlaced();");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("hidden");
          _jspx_th_impact_validateInput_54.setName("numOfResources");
          _jspx_th_impact_validateInput_54.setValue( String.valueOf(beanSize) );
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setType("hidden");
          _jspx_th_impact_validateInput_55.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnIdResource");
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
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnNmResource");
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
    _jspx_th_impact_validateInput_2.setName("txtResourceName");
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
    _jspx_th_impact_validateInput_3.setName("hdnNmResourcetoDelete");
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
    _jspx_th_impact_validateInput_4.setName("hdnIdResourcetoDelete");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnReqPullBack");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_7.setName("hdnIdChildEventFromAdoInfo");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("hdnIdChildPersonFromAdoInfo");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnNameChildPersonFromAdoInfo");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_1.setName("lblHasSiblingExtCase");
    _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Does this child have any sibling(s) in a different case with an open ADO?");
    int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_2.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_2.setName("lblSiblingGrpExtCase");
    _jspx_th_impact_validateDisplayOnlyField_2.setLabel("If yes, is the plan for these siblings to be placed in the same adoptive home?");
    int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_3.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_3.setName("lblSiblingGrpExtCase");
    _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Select sibling(s) to be placed in same Placement Group as the Primary Child");
    int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
