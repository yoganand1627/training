<%--
  --  TestData.jsp
  --  Created by:  Michael K. Werle
  --  01/02/03
  --%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserRight" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.test.TestConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.SortedSet" %>
<%@ page import="java.util.TreeSet"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<script type="text/javascript" language="javascript">
function addRow( tableId, inputType )
{
  var table = document.getElementById(tableId);
  var rowCount = table.rows.length;
  var row = table.insertRow(rowCount - 1);

  var nameCell = row.insertCell();
  var nameInput = document.createElement("input");
  var nameName = "txtUser" + inputType + "Name_" + rowCount;
  nameInput.type = "text";
  nameInput.name = nameName;
  nameInput.size = "25";
  nameInput.className = "formInput";
  nameInput.id = "txtUser" + inputType + rowCount + "_Id";
  nameCell.appendChild(nameInput);

  var valueCell = row.insertCell();
  var valueInput = document.createElement("input");
  var valueName = "txtUser" + inputType + "Value_" + rowCount;
  valueInput.type = "text";
  valueInput.name = valueName;
  valueInput.size = "25";
  valueInput.className = "formInput";
  valueInput.id = "txtUser" + inputType + rowCount + "_Id";
  valueCell.appendChild(valueInput);
}

function encodeParameters( command, targetFieldId )
{
  var formElementArray = document.frmTestData.elements;
  var url = command + "?";
  for( var i = 0; i < formElementArray.length; i++ )
  {
    var formElement = formElementArray[i];
    var name = formElement.name;
    // exclude values with "_changed" in their name to shorted the effect of checkboxes on the URLs
    if( name != "selGlobalDataAppMode" && name != "selPageMode" && name.search("_changed") < 0
            && ( name.search("GlobalData") >= 0 || name.search("txtUser") >= 0
            || name == "<%=UserProfileHelper.LOGIN_NAME_KEY%>"
            || name == "<%=UserProfileHelper.PASSWORD_KEY%>"
            <impact:ifServerImpact>
            || name == "<%=UserProfileHelper.CLAIM_USER_ID_KEY%>"
            </impact:ifServerImpact>
            || name == "txtURI"
            <%--               || ( ( name == "txtAppModeOther" ) && document.frmTestData.txtAppModeOther.disabled == false )--%>
            || ( ( name == "txtPageModeOther" ) && document.frmTestData.txtPageModeOther.disabled == false ) ) )
    {
      var value = formElement.value;
      if( value != null && value != "" )
      {
        url = url + name + "=" + value + "&";
      }
    }
    if( name.search("cbx") == 0 && name.search("_changed") < 0 )
    {
      if( formElement.checked )
      {
        url = url + name + "=" + formElement.value + "&";
      }
    }
  }
  // add selAppMode
  var selGlobalDataAppModeValue = document.frmTestData.selGlobalDataAppMode.value;
  if( selGlobalDataAppModeValue != null )
  {
    url = url + "selGlobalDataAppMode" + "=" + selGlobalDataAppModeValue + "&";
  }

  // add PageMode.PageMode
  var selPageModeValue = document.frmTestData.selPageMode.value;
  if( selPageModeValue != null )
  {
    url = url + "selPageMode" + "=" + selPageModeValue + "&";
  }

  // add rbSecurityAction
  rbSecurityActionArray = document.frmTestData.rbSecurityAction;
  var rbSecurityActionValue = null;
  for( var i = 0; i < rbSecurityActionArray.length; i++ )
  {
    if( rbSecurityActionArray[i].checked == true )
    {
      rbSecurityActionValue = rbSecurityActionArray[i].value;
      break;
    }
  }
  if( rbSecurityActionValue != null )
  {
    url = url + "rbSecurityAction" + "=" + rbSecurityActionValue + "&";
  }

  // need to chop the last "&" character off if we have no page mode selected
  url = url.substring(0, url.length - 1);

  // need to encode the URL to make spaces and such chacters "safe"
  url = URLEncode(url);

  if( url.length >= 4095 )
  {
    alert("The URL that was created is longer than 4096 characters; this may result in unpredictable behavior.");
  }

  document.getElementById(targetFieldId).value = url;
}

function enableIfSelectOther( selControl, txtControl )
{
  if( selControl.options.value == "O" )
  {
    txtControl.disabled = false;
    txtControl.focus();
  }
  else
  {
    txtControl.disabled = true;
  }
}

<%--  function enableIfSelectOtherAppMode()--%>
<%--  {--%>
<%--    enableIfSelectOther( document.frmTestData.selGlobalDataAppMode, document.frmTestData.txtAppModeOther );--%>
<%--  }--%>
<%----%>
function enableIfSelectOtherPageMode()
{
  enableIfSelectOther(document.frmTestData.selPageMode, document.frmTestData.txtPageModeOther);
}

function requestClassRefresh()
{
  disableValidation("frmTestData");
  submitValidateForm("frmTestData", "/test/Test/requestClassRefresh");
}

function validateXConf()
{
  disableValidation("frmTestData");
  submitValidateForm("frmTestData", "/test/Test/validateXConf");
}

function populateUserSecurity()
{
  if( document.frmTestData.<%=UserProfileHelper.LOGIN_NAME_KEY%>.value == "" )
  {
    alert("Login Name required!");
  }
  else
  {
    disableValidation("frmTestData");
    submitValidateForm("frmTestData", "/test/Test/populateUserSecurity");
  }
}

var hexVals = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F");
var unsafeString = "\"<>%\\^[]`";

function URLEncode( val )
{
  var state = 'urlenc';
  var len = val.length;
  var backlen = len;
  var i = 0;

  var newStr = "";
  var frag = "";
  var encval = "";

  for( i = 0; i < len; i++ )
  {
    if( isURLok(val.substring(i, i + 1)) )
    {
      newStr = newStr + val.substring(i, i + 1);
    }
    else
    {
      tval1 = val.substring(i, i + 1);
      newStr = newStr + "%" + decToHex(tval1.charCodeAt(0), 16);
    }
  }
  return newStr;
}

// part of URL Encode
function decToHex( num, radix )
{
  var hexString = "";
  while( num >= radix )
  {
    temp = num % radix;
    num = Math.floor(num / radix);
    hexString += hexVals[temp];
  }
  hexString += hexVals[num];
  return reversal(hexString);
}

// part of URL Encode
function reversal( s )
{
  var len = s.length;
  var trans = "";
  for( i = 0; i < len; i++ )
  {
    trans = trans + s.substring(len - i - 1, len - i);
  }
  s = trans;
  return s;
}

// part of URL Encode
function isURLok( compareChar )
{
  if( unsafeString.indexOf(compareChar) == -1 && compareChar.charCodeAt(0) > 32 && compareChar.charCodeAt(0) < 123 )
  {
    return true;
  }
  else
  {
    return false;
  }
}

function resetFrmTestData()
{
  document.frmTestData.reset();
  var parameterTable = document.getElementById("ParametersTable_Id");
  while( parameterTable.rows.length > 2 )
  {
    parameterTable.deleteRow(parameterTable.rows.length - 2);
  }
  var attributeTable = document.getElementById("AttributesTable_Id");
  while( attributeTable.rows.length > 2 )
  {
    attributeTable.deleteRow(attributeTable.rows.length - 2);
  }
}

function parseParamsAndSubmit()
{
<impact:ifServerImpact>
  if( frmTestData.<%=UserProfileHelper.LOGIN_NAME_KEY%>.value == 'eilersbe'
          && frmTestData.<%=UserProfileHelper.CLAIM_USER_ID_KEY%>.value != '' )
  {
    alert("Please do not change Brad's logon ID");
    return;
  }
</impact:ifServerImpact>

  var parameterTable = document.getElementById("ParametersTable_Id");
  for( var i = 1; i < parameterTable.rows.length - 1; i++ )
  {
    var row = parameterTable.rows[i];
    var userInputParamName = row.cells[0].childNodes.item(0).value;
    var userInputParamVal = row.cells[1].childNodes.item(0).value;
    if( userInputParamName != "" && userInputParamVal != "" )
    {
      var newField = document.createElement("input");
      newField.type = "hidden";
      newField.name = userInputParamName;
      newField.value = userInputParamVal;
      document.frmTestData.appendChild(newField);
    }
  }
  submitValidateForm("frmTestData", "/test/Test/executeTest");
}

window.onload = function()
{
<%
Map parameterMap = request.getParameterMap();
Iterator parameterIt = parameterMap.keySet().iterator();
while( parameterIt.hasNext() )
{
String name = ( String )parameterIt.next();
//noinspection ConstantConditions
if( name.equals( UserProfileHelper.LOGIN_NAME_KEY )
      || name.equals( UserProfileHelper.PASSWORD_KEY )
      || ( PlatformConstants.SERVER_IMPACT && name.equals( UserProfileHelper.CLAIM_USER_ID_KEY ) )
      || name.startsWith( "txt" ) || "txtURI".equals( name ) )
 {
String value = request.getParameter( name );
%>
  if( document.frmTestData.<%=name%> != null )
  {
    document.frmTestData.<%=name%>.value = "<%=value%>";
  }
<%
}
else if( name.startsWith( "cbx" ) && !name.endsWith( "_changed" ) )
{
%>
  if( document.frmTestData.<%=name%> != null )
  {
    document.frmTestData.<%=name%>.checked = true;
    setCbxChange('frmTestData', document.frmTestData.<%=name%>);
  }
<%
}
else if( name.startsWith( "rb" ) )
{
String value = request.getParameter( name );
%>
  var rbs = document.frmTestData.<%=name%>;
  if( rbs != null )
  {
    for( var i = 0; i < rbs.length; i++ )
    {
      if( rbs[i].value == "<%=value%>" )
      {
        rbs[i].checked = true;
      }
    }
  }
<%
}
else if( name.startsWith( "sel" ) )
{
String value = request.getParameter( name );
%>
  var sels = document.frmTestData.<%=name%>;
  if( sels != null )
  {
    for( var i = 0; i < sels.length; i++ )
    {
      if( sels[i].value == "<%=value%>" )
      {
        sels[i].selected = true;
      }
    }
  }
<%
      }
    }
%>
<%--    if( document.frmTestData.selGlobalDataAppMode.options.value != "O" )--%>
<%--    {--%>
<%--      document.frmTestData.txtAppModeOther.disabled = true;--%>
<%--    }--%>
  if( document.frmTestData.selPageMode.options.value != "O" )
  {
    document.frmTestData.txtPageModeOther.disabled = true;
  }
}
</script>
<%
  int tabIndex = 1;

  URL url = new URL( request.getRequestURL().toString() );
  String baseURL = url.getPort() >= 0 ?
                   url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() :
                   url.getProtocol() + "://" + url.getHost();

  // These are used for both app mode and page mode
  List<Option> appModeList = new ArrayList<Option>();
  appModeList.add( new Option( String.valueOf( PageModeConstants.EDIT ), "Edit" ) );
  appModeList.add( new Option( String.valueOf( PageModeConstants.VIEW ), "View" ) );

  List<Option> pageModeList = new ArrayList<Option>();
  pageModeList.add( new Option( String.valueOf( PageModeConstants.APPROVE ), "Approve" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.CREATE ), "Create" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.EDIT ), "Edit" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.INQUIRE ), "Inquire" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.MODIFY ), "Modify" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.NEW ), "New" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.NEW_USING ), "New Using" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.VIEW ), "View" ) );
  pageModeList.add( new Option( "O", "Other" ) );
%>

<impact:validateErrors/>
<impact:validateForm name="frmTestData"
                     method="post"
                     action="/test/Test/displayTestData"
                     schema="/WEB-INF/Constraints.xsd"
                     pageMode="<%= PageModeConstants.EDIT %>">
<table width="100%">
  <tr>
    <td align="left" valign="top">
      <a href="javascript:resetFrmTestData();">
        <img src="/grnds-docs/images/shared/btnCancel.gif" class="md" border="0">
      </a>
    </td>
    <td align="center">
      <a href="javascript:requestClassRefresh();">Request Class Refresh</a>
    </td>
    <td align="center">
      <a href="javascript:validateXConf();">Validate grnds-web-app.xconf</a>
    </td>
    <td align="right" valign="top">
      <a href="javascript:parseParamsAndSubmit( 'ParametersTable_Id', 'Parameter' );">
        <img src="/grnds-docs/images/shared/btnSubmit.gif" class="md" border="0" tabIndex="<%=tabIndex++%>">
      </a>
    </td>
  </tr>
</table>
<table width="100%" cellspacing="0" cellpadding="3">
<tr>
  <td>
    <a href="javascript:encodeParameters( '<%=baseURL%>/test/Test/displayTestData', 'displayURL_id' )"
       tabIndex="<%=tabIndex++%>">
      Get display URL
    </a>
  </td>
  <td colspan="5">
    <input name="displayURL" id="displayURL_id" value="" size="95" maxLength="8192" tabIndex="<%=tabIndex++%>">
  </td>
</tr>
<tr>
  <td>
    <a href="javascript:encodeParameters( '<%=baseURL%>/test/Test/executeTest', 'executeURL_id' )"
       tabIndex="<%=tabIndex++%>">
      Get execute URL
    </a>
  </td>
  <td colspan="5">
    <input name="executeURL" id="executeURL_id" value="" size="95" maxLength="8192" tabIndex="<%=tabIndex++%>">
  </td>
</tr>
<tr>
  <td>
    <impact:validateInput type="text" name="<%=UserProfileHelper.LOGIN_NAME_KEY%>" label="Login Name"
                          size="15" required="true" tabIndex="<%=tabIndex++%>"/>
  </td>
  <td>
    <impact:validateInput type="password" name="<%=UserProfileHelper.PASSWORD_KEY%>" label="Password"
                          size="15" value="123456" required="true" tabIndex="<%=tabIndex++%>"/>
  </td>
  <td>
    <impact:ifServerImpact>
      <impact:validateInput type="text" name="<%=UserProfileHelper.CLAIM_USER_ID_KEY%>" label="UserID" size="15"
                            constraint="Digit16Less" required="false" tabIndex="<%=tabIndex++%>"/>
    </impact:ifServerImpact>
    <impact:ifMobileImpact>&nbsp;</impact:ifMobileImpact>
  </td>
</tr>
<tr>
  <td colspan="6">
    <impact:ExpandableSectionTag name="expSecurityAttributes" label="User Security Attributes" tabIndex="<%=tabIndex%>">
      <%
        SortedSet userRightSet = TestHelper.getUserRightSet();
      %>
      <table width="100%">
        <tr>
          <td colspan="3">
            <a href="javascript:populateUserSecurity();">Populate Security Attributes From User</a>
          </td>
        </tr>
        <tr>
          <td colspan="3">
            <impact:validateInput type="radio" name="rbSecurityAction" required="true" label="No Changes" checked="true"
                                  value="<%=TestConversation.SEC_ACTION_NO_CHANGE%>" tabIndex="<%=tabIndex++%>"/>
            <impact:validateInput type="radio" name="rbSecurityAction" required="true" label="Exactly As Checked"
                                  value="<%=TestConversation.SEC_ACTION_EXACT%>" tabIndex="<%=tabIndex++%>"/>
            <impact:validateInput type="radio" name="rbSecurityAction" required="true" label="Include Checked In Set"
                                  value="<%=TestConversation.SEC_ACTION_INCLUSIVE%>" tabIndex="<%=tabIndex++%>"/>
            <impact:validateInput type="radio" name="rbSecurityAction" required="true"
                                  label="Exclude Unchecked From Set"
                                  value="<%=TestConversation.SEC_ACTION_EXCLUSIVE%>" tabIndex="<%=tabIndex++%>"/>
          </td>
        </tr>
        <%
          int colIndex = 0;
          Iterator userRightIterator = userRightSet.iterator();
          UserProfile popUser = (UserProfile)request.getAttribute( TestConversation.SEC_ATTR_KEY );
          if( popUser == null )
          {
            popUser = new UserProfile();
            popUser.setRights( "" );
          }
          while( userRightIterator.hasNext() )
          {
            UserRight userRight = (UserRight)userRightIterator.next();
            String rightName = userRight.getRightName();
            int rightIndex = userRight.getRightIndex();
            String hasRight = String.valueOf( popUser.hasRight( rightIndex ) );
            if( colIndex % 3 == 0 )
            {
        %>
        <tr>
          <%
            }
          %>
          <td>
            <impact:validateInput type="checkbox" name='<%="cbxUserSecurityAttribute_" + rightIndex%>'
                                  checked="<%=hasRight%>"
                                  value="<%=String.valueOf( rightIndex )%>" label="<%=rightName%>"/>
          </td>
          <%
            if( colIndex % 3 == 2 )
            {
          %>
        </tr>
        <%
            }
            colIndex++;
          }
          // Clean up the end of the table, in case the number of security attributes is not divisible by 3;
          //   this is done with println instead of scriptlets in order to not screw up the HTML for indention.
          if( colIndex % 3 != 0 )
          {
            while( colIndex % 3 != 2 )
            {
              out.println( "<td>&nbsp;</td>" );
              colIndex++;
            }
            out.println( "</tr>" );
          }
        %>
      </table>
    </impact:ExpandableSectionTag>
  </td>
</tr>
<tr>
  <td>
    <impact:validateInput type="text" size="70" name="txtURI" label="URI" colspan="4"
                          required="true" tabIndex="<%=tabIndex++%>"/>
  </td>
  <td>
    <impact:validateInput type="checkbox" name="cbxIsSubmodule" label="Is Submodule?"
                          value="true" tabIndex="<%=tabIndex++%>"/>
  </td>
</tr>
<tr>
  <td>
    <impact:validateSelect tabIndex="<%=tabIndex++%>" value="<%=String.valueOf( PageModeConstants.VIEW )%>" colspan="2"
                           name="selGlobalDataAppMode" label="AppMode" options="<%=appModeList%>" blankValue="false"/>
      <%--        &nbsp;Other:&nbsp;--%>
      <%--        <impact:validateInput type="text" name="txtAppModeOther" size="1" maxLength="1" tabIndex="<%=tabIndex++%>"/>--%>
  </td>
  <td>&nbsp;</td>
  <td colspan="2">
    <impact:validateInput type="checkbox" name="cbxHasStageAccess" label="Has Stage Access?"
                          value="true" tabIndex="<%=tabIndex++%>"/>
  </td>
</tr>
<%
  boolean newRow = true;
  Set exceptionNameSet = TestHelper.getExcptionNames();
  Iterator nameIt = TestHelper.getGlobalDataSetters().keySet().iterator();
  while( nameIt.hasNext() )
  {
    String name = (String)nameIt.next();
    if( !exceptionNameSet.contains( name ) )
    {
      if( newRow )
      {
%>
<tr>
  <%
    }
    if( name.startsWith( "Ul" ) )
    {
  %>
  <td>
    <impact:validateInput type="text" name='<%="txtGlobalData" + name%>' label="<%=name%>" size="30"
                          constraint="Digit16Less" tabIndex="<%=tabIndex++%>" colspan="2"/>
  </td>
  <%
  }
  else
  {
  %>
  <td>
    <impact:validateInput type="text" name='<%="txtGlobalData" + name%>' label="<%=name%>" size="30"
                          tabIndex="<%=tabIndex++%>" colspan="2"/>
  </td>
  <%
    }
    if( newRow )
    {
      newRow = false;
    }
    else
    {
      newRow = true;
  %>
</tr>
<%
      }
    }
  }
  if( newRow )
  {
    // This id done with println in order to not break the apparent HTML.
    out.println( "</tr>" );
  }

  Set parameterNameValueSet = new TreeSet( new Comparator()
  {
    public int compare( Object o1, Object o2 )
    {
      String s1 = ( (String[])o1 )[0];
      String s2 = ( (String[])o2 )[0];
      Integer i1 = Integer.valueOf( s1.substring( s1.lastIndexOf( "_" ) + 1, s1.length() ) );
      Integer i2 = Integer.valueOf( s2.substring( s2.lastIndexOf( "_" ) + 1, s2.length() ) );
      return i1.compareTo( i2 );
    }

  } );
  Set attributeNameValueSet = new TreeSet( new Comparator()
  {
    public int compare( Object o1, Object o2 )
    {
      String s1 = ( (String[])o1 )[0];
      String s2 = ( (String[])o2 )[0];
      Integer i1 = Integer.valueOf( s1.substring( s1.lastIndexOf( "_" ) + 1, s1.length() ) );
      Integer i2 = Integer.valueOf( s2.substring( s2.lastIndexOf( "_" ) + 1, s2.length() ) );
      return i1.compareTo( i2 );
    }

  } );
  parameterMap = request.getParameterMap();
  Set parameterMapKeySet = parameterMap.keySet();
  parameterIt = parameterMapKeySet.iterator();
  while( parameterIt.hasNext() )
  {
    String parameterNameName = (String)parameterIt.next();
    if( parameterNameName.startsWith( "txtUserParameterName" ) )
    {
      String parameterValueName = "txtUserParameterValue" +
                                  parameterNameName.substring( 20, parameterNameName.length() );
      parameterNameValueSet.add( new String[]{parameterNameName, parameterValueName} );
    }
    else if( parameterNameName.startsWith( "txtUserAttributeName" ) )
    {
      String parameterValueName = "txtUserAttributeValue" +
                                  parameterNameName.substring( 20, parameterNameName.length() );
      attributeNameValueSet.add( new String[]{parameterNameName, parameterValueName} );
    }
  }
%>
<tr>
  <td colspan="3" valign="top" width="50%">
    <table width="100%" id="ParametersTable_Id">
      <tr>
        <th width="50%">Parameter Name</th>
        <th width="50%">Parameter Value</th>
      </tr>
      <%
        parameterIt = parameterNameValueSet.iterator();
        while( parameterIt.hasNext() )
        {
          String[] nameValueArray = (String[])parameterIt.next();
      %>
      <tr>
        <td>
          <impact:validateInput name="<%=nameValueArray[0]%>" type="text" size="25"/>
        </td>
        <td>
          <impact:validateInput name="<%=nameValueArray[1]%>" type="text" size="25"/>
        </td>
      </tr>
      <%
        }
      %>
      <tr>
        <td colspan="2" align="center">
          <a href="javascript:addRow( 'ParametersTable_Id', 'Parameter' );">
            <img src="/grnds-docs/images/shared/btnAdd.gif" class="md" border="0">
          </a>
        </td>
      </tr>
    </table>
  </td>
  <td colspan="3" valign="top" width="50%">
    <table width="100%" id="AttributesTable_Id">
      <tr>
        <th width="50%">Attribute Name</th>
        <th width="50%">Attribute Value</th>
      </tr>
      <%
        parameterIt = attributeNameValueSet.iterator();
        while( parameterIt.hasNext() )
        {
          String[] nameValueArray = (String[])parameterIt.next();
      %>
      <tr>
        <td>
          <impact:validateInput name="<%=nameValueArray[0]%>" type="text" size="25"/>
        </td>
        <td>
          <impact:validateInput name="<%=nameValueArray[1]%>" type="text" size="25"/>
        </td>
      </tr>
      <%
        }
      %>
      <tr>
        <td colspan="2" align="center">
          <a href="javascript:addRow( 'AttributesTable_Id', 'Attribute' );">
            <img src="/grnds-docs/images/shared/btnAdd.gif" class="md" border="0">
          </a>
        </td>
      </tr>
    </table>
  </td>
</tr>
<tr>
  <td colspan="6" align="center">
    &nbsp;Page Mode:&nbsp;
    <impact:validateSelect tabIndex="<%=tabIndex++%>" name="selPageMode" options="<%=pageModeList%>" blankValue="true"
                           onChange="enableIfSelectOtherPageMode();"/>
    &nbsp;Other:&nbsp;
    <impact:validateInput type="text" name="txtPageModeOther" size="1" maxLength="1" tabIndex="<%=tabIndex++%>"/>
  </td>
</tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
