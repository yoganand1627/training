<%//*-----------------------------------------------------------------------------
      //*  JSP Name:     Diligent Search Info
      //*  Created by:   Anand Kundrapu
      //*  Date Created: 
      //*
      //*  Description:
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  12/08/08  alwilliams        STGAP00010603 - Changed the "Was the person successfully 
      //**                              contacted?" field to a required field. 

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.DiligentSearchCustomValidation"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>


<%

  //*********************
  //*** SET PAGE MODE ***
  //*********************   
   
  String pageMode = PageModeConstants.EDIT;
  if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
  }


 //*******************************
 //*** DECLARE LOCAL VARIABLES ***
 //*******************************
      
  int tabIndex = 1;
  List<DiligentSearchInfoList> dsilist = new ArrayList<DiligentSearchInfoList>();
  String EMPTY_STRING = "";
  String indIncludDilSrch = StringHelper.EMPTY_STRING;
  String indCaretakerPriorRemoval = StringHelper.EMPTY_STRING;
  String caretakerCmnts = EMPTY_STRING;
  String referralType = EMPTY_STRING;
  String otherDesc = EMPTY_STRING;
  String referrerName = EMPTY_STRING;
  String indSuccCont = EMPTY_STRING;
  String notContactedCmmnts = EMPTY_STRING;
  String currOutcomeContact = EMPTY_STRING;
  String indVisitationRsrc = EMPTY_STRING;
  String indPlcmtRsrc = EMPTY_STRING;
  String plcmtRsrcCmmnts = EMPTY_STRING;
  String dtRelCareSubDisc = EMPTY_STRING;
  String comments = EMPTY_STRING;
  String personName = EMPTY_STRING;
  String personId = EMPTY_STRING;
  String contactPerson = EMPTY_STRING;
  String succCont_No = "false";
  String succCont_Yes = "false";
  String plcmtRsrc_No = "false";
  String plcmtRsrc_Yes = "false";
  String visitationRsrc_No = "false";
  String visitationRsrc_Yes = "false";
  String isAdd = EMPTY_STRING;
  int arrayIndex = ContextHelper.getIntSafe(request, "diligentSearchIndex");
  
  
 //***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
 
 BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
 
                                                                     
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************   
  
       
   DiligentSearchInfoRetrieveSO dsiretso = (DiligentSearchInfoRetrieveSO) state.getAttribute("DiligentSearchInfoRetrieveSO", request);
   
 //personName = GlobalData.getSzNmPersonFull(request);
 //personName = (String)state.getAttribute("NM_CHILD", request);
 if(dsiretso!=null)
 {
    contactPerson = dsiretso.getNamePersonDetail();
    if(dsiretso.getNamePersonDetail() == null)
    {
      contactPerson = dsiretso.getPersonNameForPullback();
    }
 }
 personName = contactPerson;
 if(dsiretso.getDsiBeanList()!=null)
 {
   dsilist = dsiretso.getDsiBeanList();
    for (Iterator<DiligentSearchInfoList> it = dsilist.iterator(); it.hasNext();) {
           DiligentSearchInfoList dsiRow = (DiligentSearchInfoList) it.next();
           indIncludDilSrch = dsiRow.getIndIncludeDilSrch();
           indCaretakerPriorRemoval = dsiRow.getIndCaretakerPriorRemoval();
           caretakerCmnts = dsiRow.getTxtRemCmnts();
           referralType = dsiRow.getSelReferralType();
           otherDesc = dsiRow.getTxtOtherDesc();
           referrerName = dsiRow.getTxtReferrsNm();
           indSuccCont = dsiRow.getIndSuccContacted();
           if (indSuccCont != null)
             {
               if (indSuccCont.equals(ArchitectureConstants.N)) {
                succCont_No = "true";
                } else {
                succCont_Yes = "true";
              }
           }  
           notContactedCmmnts = dsiRow.getTxtNotContactedCmnts();
           currOutcomeContact = dsiRow.getSelCurrOutcomeContact();
           indVisitationRsrc = dsiRow.getIndVisitationRsrc();
           if (indVisitationRsrc != null)
             {
               if (indVisitationRsrc.equals(ArchitectureConstants.N)) {
                visitationRsrc_No = "true";
                } else {
                visitationRsrc_Yes = "true";
              }
           }  
           indPlcmtRsrc = dsiRow.getIndPlcmtRsrc();
           if (indPlcmtRsrc != null)
             {
               if (indPlcmtRsrc.equals(ArchitectureConstants.N)) {
                 plcmtRsrc_No = "true";
                } else {
                 plcmtRsrc_Yes = "true";
              }
           }  
           plcmtRsrcCmmnts = dsiRow.getTxtPlcmtRsrcCmnts();
           dtRelCareSubDisc = FormattingHelper.formatDate(dsiRow.getDtRelCareSubDisc());
           comments = dsiRow.getTxtCmnts();
          }
     }       
  
                 
%>

<%    //**************************
      //**** FORM STARTS HERE ****
      //**************************

 %>

<impact:validateErrors />
<impact:validateForm name="frmDiligentSearchInfo" method="post" action="/person/DiligentSearch/saveDiligentSearchInfo" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.DiligentSearchCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
  <impact:validateInput type="hidden" name="isAddDiligentSearch" value="<%= isAdd %>" />
  <impact:validateInput type="hidden" name="diligentSearchInfoIndex" value="<%= FormattingHelper.formatInt(arrayIndex) %>" />
  <input type="hidden" name="hdnPersonNm" value="<%=personName%>">
  <input type="hidden" name="hdnPersonIdForPullback" value="<%=personId%>">


  <table width="100%" class="tableborder" cellpadding="3" cellspacing="0">
    <tr>
      <th colspan="8">
        Diligent Search
      </th>
    </tr>
    <tr>
      <td colspan="0">
        <impact:validateDisplayOnlyField name="txtContactPerson" label="Contact Person" value="<%= contactPerson %>" cssClass="formInput" />

      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateInput tabIndex="<%= tabIndex++ %>" checked="<%=FormattingHelper.formatString(indIncludDilSrch)%>" value="Y" type="checkbox" name="cbIncludDilSrch" label="Include in Diligent Search Report" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateInput tabIndex="<%= tabIndex++ %>" checked="<%=FormattingHelper.formatString(indCaretakerPriorRemoval)%>" value="Y" type="checkbox" name="cbCaretakerPriorRemoval" label="Caretaker Prior to Removal" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>If previous caretaker, describe why removed:
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" cols="80" rows="4" maxLength="300" constraint="Paragraph300" label="" constraint="Comments" name="txtCaretakerCmnts">
          <%=FormattingHelper.formatString(caretakerCmnts)%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" label="Referral Type" id="szCdReferralType" name="selReferralType" width="20%" value="<%=referralType %>" required="true" codesTable="CDSIREFL" />
      </td>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>If other, describe:
      </td>
      <td colspan="2">
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" label="" id="szCdOtherDesc" name="txtOtherDesc" size="20" maxLength="50" constraint="Paragraph50" value="<%=otherDesc%>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" label="Referrer's Name" id="szCdReferrsNm" name="txtReferrsNm" size="20" maxLength="50" constraint="Paragraph50" value="<%=referrerName %>" cssClass="formInput" />
      </td>
    </tr>

    <tr>
      <td>
        <span class="formRequiredText">*</span> Was the person successfully contacted?
      </td>

      <td colspan="2">
        <impact:validateInput checked="<%=succCont_Yes%>" tabIndex="<%= tabIndex++ %>" value="Y" 
                              type="radio" name="rbSuccContacted" id="succCont_Yes" label="Yes" 
                              cssClass="formInput" />

        <impact:validateInput checked="<%=succCont_No%>" tabIndex="<%= tabIndex++ %>" value="N" 
                              type="radio" name="rbSuccContacted" id="succCont_No" label="No" 
                              cssClass="formInput" />
      </td>
    </tr>

    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>If not contacted, why?
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" cols="80" rows="4" maxLength="300" constraint="Comments" label="" name="txtNotContactedCmnts">
          <%=FormattingHelper.formatString(notContactedCmmnts)%>
        </impact:validateTextArea>
      </td>
    </tr>

    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>Current Outcome of Contact:
      </td>
      <td colspan="2">
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" label="" id="szCdCurrOutcomeContact" name="selCurrOutcomeContact" width="20%" value="<%=currOutcomeContact%>" codesTable="CDSICONT" />
      </td>
    </tr>

    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>Is person willing to be a visitation resource?
      </td>

      <td colspan="2">
        <impact:validateInput checked="<%=visitationRsrc_Yes %>" tabIndex="<%= tabIndex++ %>" value="Y" type="radio" name="rbVisitationRsrc" id="visitationRsrc_Yes" label="Yes" cssClass="formInput" />

        <impact:validateInput checked="<%=visitationRsrc_No %>" tabIndex="<%= tabIndex++ %>" value="N" type="radio" name="rbVisitationRsrc" id="visitationRsrc_No" label="No" cssClass="formInput" />
      </td>
    </tr>

    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>Is the person a potential placement resource?
      </td>


      <td colspan="2">
        <impact:validateInput checked="<%=plcmtRsrc_Yes%>" tabIndex="<%= tabIndex++ %>" value="Y" type="radio" name="rbPlcmtRsrc" id="plcmtRsrc_Yes" label="Yes" cssClass="formInput" />

        <impact:validateInput checked="<%= plcmtRsrc_No %>" tabIndex="<%= tabIndex++ %>" value="N" type="radio" name="rbPlcmtRsrc" id="plcmtRsrc_No" label="No" cssClass="formInput" />
      </td>
    </tr>

    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>If not, why?
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" cols="80" rows="4" maxLength="300" constraint="Paragraph300" label="" constraint="Comments" name="txtPlcmtRsrcCmnts">
          <%=FormattingHelper.formatString(plcmtRsrcCmmnts)%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>Date Relative Care Subsidies Discussed:
      </td>
      <td colspan="2">
        <impact:validateDate type="text" name="dtRelCareSubDisc" label="" constraint="Date" value="<%= dtRelCareSubDisc %>" size="10" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        Comments:
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" cols="80" rows="4" maxLength="300" label="" constraint="Comments" name="txtComments">
          <%=FormattingHelper.formatString(comments)%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <%//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save button unless the page mode is VIEW. 
      if (!pageMode.equals(PageModeConstants.VIEW)) {%>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>

      <td align="right">
        <impact:ButtonTag name="btnSave" img="btnSave" align="right" form="frmDiligentSearchInfo" action="/person/DiligentSearch/saveDiligentSearchInfo" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <%}%>
</impact:validateForm>

