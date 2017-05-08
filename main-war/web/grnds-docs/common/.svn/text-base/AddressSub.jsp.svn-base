<%--
//*  JSP Name:     Admin Address Phone Sub Module
//*  Created by:   Dann Webster
//*  Date Created: 11/14/2002
//*
//*  Description:
//*  This JSP is used to display the data from the address and phone
//*  data that is used on many pages.
//*  This data includes:
//*
//* addressAddress1
//* addressAddress2
//* addressCity
//* addressState
//* addressZip
//* addressZipSuff
//* addressCounty
//* addressComments
//*
//* To include this submodule you will need the lines
// (the meaning of the 4 boolean variables should be self-evident
//
// <% boolean addressRequired = false; %>
// <% boolean addressDisabled = false; %>
// <% boolean commentsRequired = false; %>
// <% boolean commentsDisabled = false; %>
// <%@ include file="/grnds-docs/common/AddressSub.jsp" %>
//
//** Change History:
//**  Date          User              Description
//**  --------  ----------------  --------------------------------------------------
//**  09/15/05     marallh        sir 23955 - removed import gov.georgia.dhr.dfcs.sacwis.web.common.AddressValidationConversation
//**  02/27/2009   bgehlot        STGAP00012734: Remove the -None- from the County DropDown Box on Address Detail Page.
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="java.util.ArrayList"%> 

<script type="text/JavaScript" src="/grnds-docs/js/shared/addressValidation.js"></script>
<%
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
%>

<table width="100%" border="0" cellpadding="3" cellspacing="0">
 <tr>
  <td width="10%">
    <impact:validateInput
    name="<%= addressBean.getAttributeName( AddressBean.ADDRESS1 ) %>"
    value="<%=FormattingHelper.formatString( addressBean.getAddress1() )%>"
    disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
    type="text"
    required="<%= String.valueOf( addressSubStreetRequired )%>"
    onChange="<%= changeAddress %>"
    label="Street"
    width="45%"
    tabIndex="<%= addressSubTabIndex %>"
    cssClass="formInput"
    constraint="Address"
    size="50"
    maxLength="30"/>
    </td>
    <td width="15%">&nbsp;</td>
    <td width="30%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><impact:validateInput
    name="<%= addressBean.getAttributeName( AddressBean.ADDRESS2 ) %>"
    value="<%=FormattingHelper.formatString( addressBean.getAddress2() )%>"
    disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
    type="text"
    tabIndex="<%= addressSubTabIndex %>"
    onChange="<%= changeAddress %>"
    cssClass="formInput"
    constraint="Address"
    size="50"
    maxLength="30"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><impact:validateInput
    name="<%= addressBean.getAttributeName( AddressBean.CITY ) %>"
    value="<%=FormattingHelper.formatString( addressBean.getCity() )%>"
    disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
    type="text"
    required="<%= String.valueOf( addressSubAddressRequired )%>"
    tabIndex="<%= addressSubTabIndex %>"
    onChange="<%= changeAddress %>"
    label="City"
    cssClass="formInput"
    constraint="City"
    maxLength="20"/>
    </td>
<%
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
%>
    <td><impact:validateSelect
    name="<%= addressBean.getAttributeName( AddressBean.STATE )%>"
    value="<%= FormattingHelper.formatString( stateDefault ) %>"
    disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
    required="<%= String.valueOf( addressSubAddressRequired )%>"
    codesTable="<%= CodesTables.CSTATE %>"
    tabIndex="<%= addressSubTabIndex %>"
    onChange="<%= onChange %>"
    label="State"/>
    </td>
  </tr>
  <tr>
        <td>
           <impact:validateInput name="<%= addressBean.getAttributeName( AddressBean.ZIP )%>"
                                 value="<%=FormattingHelper.formatString( addressBean.getZip() )%>"
                                 disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
                                 required="<%= String.valueOf( addressSubZipRequired  )%>"
                                 type="text"
                                 tabIndex="<%= addressSubTabIndex %>"
                                 onChange="<%= changeAddress %>"
                                 label="Zip"
                                 cssClass="formInput"
                                 constraint="Zip"
                                 maxLength="5"
                                 size="5"/>
      -
          <impact:validateInput name="<%= addressBean.getAttributeName( AddressBean.ZIP_SUFF )%>"
                                value="<%=FormattingHelper.formatString( addressBean.getZipSuff() )%>"
                                disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
                                type="text"
                                onChange="<%= changeAddress %>"
                                tabIndex="<%= addressSubTabIndex %>"
                                cssClass="formInput"
                                constraint="ZipSuff"
                                maxLength="4"
                                size="4"/>
        </td>
        <td>
            <impact:validateSelect name="<%= addressBean.getAttributeName( AddressBean.COUNTY ) %>"
                                   value="<%=FormattingHelper.formatString( addressBean.getCounty() ) %>"
                                   disabled="<%= String.valueOf( addressSubAddressDisabled ) %>"
                                   required="<%= String.valueOf( addressSubAddressRequired ) %>"
                                   tabIndex="<%= addressSubTabIndex %>"
                                   blankValue="true"
                                   label="County"
                                   codesTable="CCOUNT"
                                   conditionallyRequired="true"
                                   excludeOptions="<%=addressSubExcludeCounty%>"   
                                   onChange="<%= changeAddress %>" />
    <td>
  </tr>
<%
    if ( addressSubCommentsVisible )
    {
%>
  <tr>
   <td><impact:validateTextArea
               label="Comments"
               disabled="<%= String.valueOf( addressSubCommentsDisabled ) %>"
               required="<%= String.valueOf( addressSubCommentsRequired ) %>"
               name="<%= addressBean.getAttributeName( AddressBean.COMMENTS ) %>"
               cols="125" rows="4"
               colspan="3"
               tabIndex="<%= addressSubTabIndex %>"
               constraint="Comments"
               maxLength="300"><%= FormattingHelper.formatString(addressBean.getComments() )%></impact:validateTextArea>
    </td>
  </tr>
<%
    }
%>
</table>
<%
    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
<%
    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";
%>
    <td class="alignRight">
      <impact:ButtonTag name="btnvalidate" img="btnValidate" action="#" function="<%=onclick%>" form="<%=addressSubFormName%>" tabIndex="<%=addressSubTabIndex%>" onBlur="setIsDirtyCalled(false);"/>
    </td>
  </tr>
</table>
<%
    }
%>
<impact:validateInput type="hidden" name="hdnNbrRsrcAddrLat" value="0"/>
<impact:validateInput type="hidden" name="hdnNbrRsrcAddrLong" value="0"/>
<impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.IN_REQUEST )%>" value="true"/>
<impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.IS_VALID )%>" value="true"/>
<impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.FORM_ACTION )%>" value=""/>
<impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.MULT_COUNTY )%>" value=""/>

<script language="javascript">
//Run this script to protect the county on start up.
toggleCounty('<%= addressSubFormName %>', '<%= addressSubAddressSubmoduleName %>');
</script>
<%
    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }
%>
