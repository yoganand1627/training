<%
/**
 * JSP Name:     ClientCharacteristicDetail.jsp
 * Created by:   Donald Wilson
 * Date Created: 09/27/02
 *
 * Description:
 * This page allows a user to view, edit or delete the Client Charareristics
 * Detail information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added/modified flowerbox comments and Changelog.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ServicesByAreaConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="java.util.List"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String selectedServiceIndex = ContextHelper.getStringSafe(request, ServicesByAreaConversation.SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);
  String pageMode = GlobalData.getAppMode(request);

  String idResource = GlobalData.getUlIdResourceAsString( request );

  //mcclaim, 600 is a value which is guaranteed not to be valid (I guess)
  final int MAGIC_ROW_NUMBER = 600;
  int rownumber = MAGIC_ROW_NUMBER;
  String maleMaxYear = "";
  String maleMaxMonth = "";
  String maleMinYear = "";
  String maleMinMonth = "";
  String femaleMaxYear = "";
  String femaleMaxMonth = "";
  String femaleMinYear = "";
  String femaleMinMonth = "";
  String servicesList = ContextHelper.getStringSafe(request, "servicesList");
  String characteristicName = "";
  List<CodeAttributes> characteristicsOptions = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CLNCHAR2);


  if (StringHelper.isValid(ContextHelper.getStringSafe(request, ServicesByAreaConversation.SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME)))
  {
    rownumber = ContextHelper.getIntSafe(request, ServicesByAreaConversation.SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME);
  }
  String dataAction = ContextHelper.getStringSafe(request, "SzCdScrDataAction");

  CRES07SO cres07so = (CRES07SO)state.getAttribute(ServicesByAreaConversation.CRES07SO_ATTRIBUTE_NAME, request);
  ROWCRES07SOG_ARRAY characteristicArray = null;
  ROWCRES07SOG characteristicDetail = null;

  if (StringHelper.checkForEquality(dataAction, "U"))
  {
    if (cres07so != null)
    {
      characteristicArray = cres07so.getROWCRES07SOG_ARRAY();
    }
    if (characteristicArray != null)
    {
      characteristicDetail = characteristicArray.getROWCRES07SOG(rownumber);
      maleMaxYear = getYears(characteristicDetail.getUNbrRsrcCharMaxMAge());
      maleMaxMonth = getMonths(characteristicDetail.getUNbrRsrcCharMaxMAge());
      maleMinYear = getYears(characteristicDetail.getUNbrRsrcCharMinMAge());
      maleMinMonth = getMonths(characteristicDetail.getUNbrRsrcCharMinMAge());
      femaleMaxYear = getYears(characteristicDetail.getUNbrRsrcCharMaxFAge());
      femaleMaxMonth = getMonths(characteristicDetail.getUNbrRsrcCharMaxFAge());
      femaleMinYear = getYears(characteristicDetail.getUNbrRsrcCharMinFAge());
      femaleMinMonth = getMonths(characteristicDetail.getUNbrRsrcCharMinFAge());
      characteristicName = characteristicDetail.getSzCdRsrcCharChrctr();
    }
  }

  boolean hideDeleteButton = false;
  if ("A".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdScrDataAction")))
  {
    hideDeleteButton = true;
  }

  int currPage = 1;
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "page")))
  {
    currPage = ContextHelper.getIntSafe(request, "page");
  }

  int tabIndex = 1;
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  window.onload = function ()
  {
    document.clientChar.clientCharacteristics.Value = '<%= characteristicName %>';
    document.clientChar.clientCharacteristics.defaultValue = '<%= characteristicName %>';
  };

  window.onbeforeunload = function ()
  {
      IsDirty();
  };

  function deleteClientCharacteristicsDetail()
  {
    if (confirm("Are you sure you want to delete this record?"))
    {

      var rowNumber = <%= rownumber %>;
      if (rowNumber != <%= MAGIC_ROW_NUMBER %>)
      {
        document.clientChar.selectedCharacteristicIndex.value = "<%= rownumber %>";
      }
      window.onbeforeunload = null;
      document.clientChar.SzCdScrDataAction.value='D';
      disableValidation('clientChar');
      return true;
    }

    return false;
  }

 function saveClientCharacteristicsDetail()
 {
   window.onbeforeunload = null;
   var rowNumber = <%= rownumber %>;
   if (rowNumber != <%= MAGIC_ROW_NUMBER %>)
   {
     document.clientChar.selectedCharacteristicIndex.value = "<%= rownumber %>";
   }

   return true;
 }
</script>

<impact:validateForm name="clientChar"
        method="post"
        action="/resource/ServicesByArea/default"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ClientCharacteristicDetailValidation"
        schema="/WEB-INF/Constraints.xsd"
        pageMode="<%= pageMode %>"
        redisplayParameters="true">

<impact:validateErrors formName="clientChar"/>

<input type="hidden" name="<%= PageMode.PAGE_MODE_ATTRIBUTE_NAME %>" value="<%= pageMode %>"/>
<input type="hidden" name="txtUlIdResourceService" value='<%= ContextHelper.getStringSafe(request, "txtUlIdResourceService") %>'/>
<input type="hidden" name="SzCdScrDataAction" value="<%= dataAction %>"/>
<input type="hidden" name="selectedServiceIndex" value="<%= selectedServiceIndex %>"/>
<input type="hidden" name="selectedCharacteristicIndex" value=""/>
<input type="hidden" name="servicesList" value="<%= servicesList %>"/>
<impact:validateInput type="hidden" name="page" value="<%= Integer.toString(currPage) %>"/>
<impact:validateInput type="hidden" name="orderBy" />
<impact:validateInput type="hidden" name="orderByDirection" />
<impact:validateInput type="hidden" name="validationOverride"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" style="HEIGHT: 100px">
   <tr>
    <th colspan="6">Client Characteristics</th>
   </tr>
   <tr>
     <td colspan="2"><impact:validateSelect label="Characteristics"
                                            value="<%= characteristicName %>"
                                            name="clientCharacteristics"
                                            options="<%= characteristicsOptions %>"
                                            required="true"
                                            tabIndex="<%= tabIndex++ %>"
                                            style="WIDTH: 250px"/>
     </td>
   </tr>
   <tr>
    <th colspan="6"> Male Age Range</th>
   </tr>
   <tr>
     <td colspan="2"><impact:validateInput name="malMinYr"
                                            label="Male Min"
                                            size="3"
                                            type="text"
                                            constraint="AgeYear"
                                            cssClass="formInput"
                                            value="<%= maleMinYear %>"
                                            maxLength ="3"
                                            tabIndex="<%= tabIndex++ %>"/> Yr
     <impact:validateInput name="malMinMo" type="text"
                                            size="2"
                                            constraint="AgeMonth"
                                            cssClass="formInput"
                                            value="<%= maleMinMonth %>"
                                            maxLength ="2"
                                            tabIndex="<%= tabIndex++ %>"/> Mo</td>

     <td colspan="2"><impact:validateInput name="malMaxYr"
                                            label="Male Max"
                                            type="text"
                                            size="3"
                                            constraint="AgeYear"
                                            cssClass="formInput"
                                            value="<%= maleMaxYear %>"
                                            maxLength ="3"
                                            tabIndex="<%= tabIndex++ %>"/> Yr
     <impact:validateInput name="malMaxMo" type="text"
                                            size="2"
                                            constraint="AgeMonth"
                                            cssClass="formInput"
                                            value="<%= maleMaxMonth %>"
                                            maxLength ="2"
                                            tabIndex="<%= tabIndex++ %>"/> Mo</td>
   </tr>
   <tr>
    <th colspan="6">Female Age Range</th>
   </tr>
   <tr>
     <td colspan="2"><impact:validateInput name="femMinYr"
                                            label="Female Min"
                                            type="text"
                                            size="3"
                                            constraint="AgeYear"
                                            cssClass="formInput"
                                            value="<%= femaleMinYear %>"
                                            maxLength ="3"
                                            tabIndex="<%= tabIndex++ %>"/> Yr
     <impact:validateInput name="femMinMo"
                           type="text"
                                            size="2"
                                            constraint="AgeMonth"
                                            cssClass="formInput"
                                            value="<%= femaleMinMonth %>"
                                            maxLength ="2"
                                            tabIndex="<%= tabIndex++ %>"/> Mo</td>

     <td colspan="2"><impact:validateInput name="femMaxYr"
                                            label="Female Max"
                                            type="text"
                                            size="3"
                                            constraint="AgeYear"
                                            cssClass="formInput"
                                            value="<%= femaleMaxYear %>"
                                            maxLength ="3"
                                            tabIndex="<%= tabIndex++ %>"/> Yr
     <impact:validateInput name="femMaxMo"
                           type="text"
                                            size="2"
                                            constraint="AgeMonth"
                                            cssClass="formInput"
                                            value="<%= femaleMaxMonth %>"
                                            maxLength ="2"
                                            tabIndex="<%= tabIndex++ %>"/> Mo</td>
   </tr>
</table>
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">


<% if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {%>
<table border="0" cellspacing="0" cellpadding="3" width="100%"  >
  <tr>
    <%if (!hideDeleteButton) {%>
    <td>
     <impact:ButtonTag name="btnDelete"
                       img="btnDelete"
                       editableMode="<%= EditableMode.EDIT %>"
                       function="return deleteClientCharacteristicsDetail();"
                       form="clientChar"
                       action="/resource/ServicesByArea/deleteClientCharacteristicDetail"
                       tabIndex="<%= tabIndex++ %>"/>
    </td>
    <%}%>
    <td align="right" >
      <impact:ButtonTag name="btnSave"
                       img="btnSave"
                       align="right"
                       editableMode="<%= EditableMode.EDIT %>"
                       function="return saveClientCharacteristicsDetail();"
                       form="clientChar"
                       action="/resource/ServicesByArea/saveClientCharacteristicDetail"
                                           restrictRepost="true"
                       tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<%}%>
</impact:validateForm>
<%!
/**
 * GetFormattedAge  using the string parameters in order to get
 * age converted from months to years and months
 * @return String
 * @param months The number of months for the age
 */
  public String getMonths(int months)
  {
    if (months < 12)
    {
      return ("" + months);
    }
    else
    {
      months = months % 12;
      return ("" + months);
    }
  }

  public String getYears(int months)
  {
    int years = 0;
    if (months < 12)
    {
      return ("" + years);
    }
    else
    {
      years = months / 12;
      return ("" + years);
    }
  }
%>
