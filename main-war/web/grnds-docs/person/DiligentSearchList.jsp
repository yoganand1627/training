<%/*
       * JSP Name:     Diligent Search List
       * Created by:   Anand Kundrapu
       * Date Created: 12/18/06
       *
       * Description:
       * Diligent Search List Page
       *  */
      /* Change History:
       Date      User              Description
       --------  ----------------  -----------------------------------------------
       12/18/06  Anand Kundrapu        Initial page creation
       */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>


<%

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int size = 0;
  List<DiligentSearchInfoList> dsilist = new ArrayList<DiligentSearchInfoList>();
  int personIdSearch = 0;
  int personIdDetail = 0;
  String pageMode = null;
  String personIdForPullback =null;
  

//***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
 BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
                                                        
                                                        
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************                                                           

 DiligentSearchInfoRetrieveSO dsiretso = (DiligentSearchInfoRetrieveSO) state.getAttribute("DiligentSearchInfoRetrieveSO", request);
 if(dsiretso != null && dsiretso.getDsiBeanList()!=null)
 {
    dsilist = dsiretso.getDsiBeanList();
    size = dsilist.size();
  }
   personIdSearch = GlobalData.getUlIdPerson(request);
   personIdForPullback = StringUtils.defaultString(dsiretso.getPersonIdForPullback());

   int loopCount = 0;
   String tabindexString = (String) request.getAttribute("tabIndex");
   int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
   

  //*********************
  //*** SET PAGE MODE ***
  //*********************
   pageMode = PageModeConstants.EDIT;
   if (PageMode.getPageMode(request) != null) {
     pageMode = PageMode.getPageMode(request);
   }

  %>


<%//******************
  //*** JAVASCRIPT ***
  //******************
 %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">


 //Message for when a user wants to delete a needs outcomes and gives the user an alert, the if the
  //radio button was not selected by the user.
  function Copy()
  {
    var cont;
    if( checkForSelection('document.frmDiligentSearchList.rbDiligentList'))
     {
        cont = true;
     }else{
         alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>');
         cont = false;
    }
    return cont;
  }

  
 //Allows for the needs outcomes to be selected out of the radio button
  function checkForSelection( objName )
  {
    var buttonChecked = false;
    var obj = eval(objName);

    if (obj != null)
    {
      if (obj.length == null)
      {
        if (obj.checked != false)
          buttonChecked = true;
      }
      else
      {
        for (var i = 0; i < obj.length; ++i)
        {
          buttonChecked = buttonChecked || obj[i].checked;
        }
      }
    }

  return (buttonChecked);
} 
    
  
    function submitDiligentSearch(idDiligentSearch)
    {
    document.frmDiligentSearchList.hdnIdDiligentSearch.value = idDiligentSearch;
    submitValidateForm( "frmDiligentSearchList", "/person/DiligentSearch/displayDiligentSearchInfo" );
  }
    
  </script>



<%  //**************************
    //**** FORM STARTS HERE ****
    //**************************

 %>
<impact:validateErrors />
<impact:validateForm name="frmDiligentSearchList" method="post" action="/person/DiligentSearch/displayDiligentSearchList" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">


  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
  <input type="hidden" name="hdnPersonIdForPullback" value="<%=personIdForPullback%>" />
  <input type="hidden" name="hdnPersonIdSearch" value="<%=personIdSearch%>" />
  <input type="hidden" name="hdnPersonIdDetail" value="<%=personIdDetail%>" />
  <input type="hidden" name="hdnIdDiligentSearch">


  <impact:pagination submitUrl="/person/DiligentSearch/displayDiligentSearchList" saveState="false">
    <table id="results1" border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">

      <tr>
        <td>
          <div id="scroll3" style="width:100%; height:220; overflow:auto" class="tableBorderList">
            <table id="results" border="0" cellspacing="0" cellpadding="3" width="100%">

              <tr>
                <% if(pageMode.equals(PageModeConstants.NEW_USING))
        { %>
                <th class="thList"></th>
                <% }%>

                <th class="thList">
                  Name
                </th>
                <th class="thList">
                  Child
                </th>
                <th class="thList">
                  Caretaker
                </th>
                <th class="thList">
                  Contacted
                </th>
                <th class="thList">
                  Visitation
                </th>
                <th class="thList">
                  Placement
                </th>
              </tr>
              <% if (size == 0) {
                          %>
              <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                <td colspan="10">
                  <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                </td>
              </tr>
              <%} else {

         for (Iterator<DiligentSearchInfoList> it = dsilist.iterator(); it.hasNext();) {
           DiligentSearchInfoList dsiRow = (DiligentSearchInfoList) it.next();
           String idDiligentSearch = String.valueOf( dsiRow.getIdDiligentSearchInfo());
           personIdDetail = dsiRow.getUlIdPersonDetail();  
           String nmPerson = dsiRow.getPersonName(); 
           String personSearchName = dsiRow.getPersonNameSearch();

      %>
              <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
                <% if(pageMode.equals(PageModeConstants.NEW_USING))
      { %>
                <td>
                  <impact:validateInput type="radio" name="rbDiligentList" value="<%= idDiligentSearch%>" editableMode="<%= EditableMode.ALL %>" tabIndex="<%= tabIndex++ %>" />
                </td>

                <td>
                  <%=FormattingHelper.formatString(nmPerson)%>
                </td>
                <% } else {%>
                <td>
                  <a href="javascript:submitDiligentSearch('<%= idDiligentSearch %>')"><%=nmPerson%></a>
                </td>
                <%}%>
                <td>
                  <%=FormattingHelper.formatString(personSearchName)%>
                </td>
                <td>
                  <%=FormattingHelper.formatString( dsiRow.getIndCaretakerPriorRemoval())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString( dsiRow.getIndSuccContacted())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString( dsiRow.getIndVisitationRsrc())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString( dsiRow.getIndPlcmtRsrc())%>
                </td>

              </tr>
              <%loopCount++;
          } // end while enumeration has more elements
        } //end big else
    

      %>
            </table>
          </div>
        </td>
      </tr>
    </table>

  </impact:pagination>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td width="70%">
        &nbsp;
      </td>
      <%  if ((!pageMode.equals(PageModeConstants.VIEW)) && (!pageMode.equals(PageModeConstants.NEW_USING))) { %>
      
        <%-- <% if (size == 0) { %>
         <td>&nbsp;</td>
        <%}%>  
        <% if (size > 0) { %> --%>
          <td>
            <impact:ButtonTag name="btnCopy" img="btnCopy" align="right" form="frmDiligentSearchList" action="/person/DiligentSearch/copyDiligentInfo" editableMode="<%= EditableMode.ALL %>" tabIndex="<%= tabIndex++ %>" />
          </td>
        <%-- <%}%> --%> 
      <td align="right">
        <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" form="frmDiligentSearchList" action="/person/DiligentSearch/retrievePerson" editableMode="<%= EditableMode.ALL %>" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%} else if(pageMode.equals(PageModeConstants.NEW_USING)) {
             if (size > 0) {
      %>
      <td>
        <impact:ButtonTag name="btnContinue" img="btnContinue" align="right" form="frmDiligentSearchList" action="/person/DiligentSearch/displayDiligentSearchInfo" function="return Copy()" editableMode="<%= EditableMode.ALL %>" tabIndex="<%= tabIndex++ %>" />

      </td>
      <%
             } 
      }
      %>
    </tr>
  </table>

  <br>
</impact:validateForm>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">
      Forms
    </th>
  </tr>
  <tr>
    <td>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
        <impact:document displayName="Diligent Search Report Form" protectDocument="true" checkForNewMode="false" docType="fcm03o00" docExists="true">
           <impact:documentParameter name="pCase"
                              value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
           <impact:documentParameter name="pStage"
                              value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
           <impact:documentParameter name="pPerson"
                               value="<%= String.valueOf(GlobalData.getUlIdPerson(request)) %>"/>
        </impact:document>
      </impact:documentList>
    </td>
  </tr>
</table>






