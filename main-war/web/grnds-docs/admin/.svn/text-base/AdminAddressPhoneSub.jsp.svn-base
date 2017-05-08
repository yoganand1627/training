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
//* adminPhonePhone
//* adminPhonePhoneExt
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
//
//  <%/* BEGIN Admin Address Phone Submodule */%>
//  <%
//    AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
//    adminAddressPhoneSubDB.setFormName( "frmDetailTemplate" );
//    adminAddressPhoneSubDB.setPageMode( pageMode );
//    adminAddressPhoneSubDB.setAddressPhoneSectionHeader( "Admin Address Phone Submodule" );
//    adminAddressPhoneSubDB.setAddressRequired( false );
//    adminAddressPhoneSubDB.setAddressDisabled( false );
//    adminAddressPhoneSubDB.setCommentsVisible( true );
//    adminAddressPhoneSubDB.setCommentsRequired( false );
//    adminAddressPhoneSubDB.setCommentsDisabled( false );
//    adminAddressPhoneSubDB.setPhoneRequired( false );
//    adminAddressPhoneSubDB.setPhoneDisabled( false );
//    adminAddressPhoneSubDB.setAddressSubmoduleName( "first" );
//    adminAddressPhoneSubDB.setTabIndex( tabIndex );
//    AdminAddressPhoneSubDB.setIntoRequest( adminAddressPhoneSubDB, request );
//  %>
//  <%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp" %>
//  <%
//    tabIndex = adminAddressPhoneSubDB.getTabIndex();
//    AdminAddressPhoneSubDB.removeFromRequest( request );
//  %>
//  <%/* END Admin Address Phone Submodule */%>
//
//  <%/* BEGIN Address Submodule */%>
//  <% addressSubmoduleName = "second"; %>
//  <%@ include file="/grnds-docs/common/AddressSub.jsp" %>
//  <%/* END Address Submodule */%>
//
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  02/23/11  Hai Nguyen        SMS#97850: MR-075 Updated Number field label to Phone.
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB"%>

<%
  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }
%>

<impact:ExpandableSectionTag name="<%= expandableSectionName %>" id='<%=AdminAddressPhoneBean.PHONE + "_Id" %>' label="<%= adminAddressPhoneSubAddressPhoneSectionHeader %>" tabIndex="<%= adminAddressPhoneSubTabIndex %>">
<table border="0" width="100%" cellSpacing="0" cellPadding="0" class="tableBorder">
   <tr class="subDetail">
     <td>
      <table border="0" width="100%" cellSpacing="0" cellPadding="3">
        <tr>
          <td width="10%">
              <impact:validateInput name="<%= aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) %>"
                                    value="<%= FormattingHelper.formatPhone( aapBean.getPhone() ) %>"
                                    disabled="<%= String.valueOf( adminAddressPhoneSubPhoneDisabled ) %>"
                                    type="text"
                                    required="<%= String.valueOf( adminAddressPhoneSubPhoneRequired )%>"
                                    label="Phone"
                                    tabIndex="<%= adminAddressPhoneSubTabIndex %>"
                                    cssClass="formInput"
                                    constraint="Phone"
                                    width="45%"
                                    size="14"
                                    maxLength="14"/>
          </td>
          <td width="15%">
             <impact:validateInput name="<%= aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) %>"
                                   value="<%= aapBean.getPhoneExt() %>"
                                   disabled="<%= String.valueOf( adminAddressPhoneSubPhoneDisabled ) %>"
                                   type="text"
                                   label="Extension"
                                   tabIndex="<%= adminAddressPhoneSubTabIndex %>"
                                   cssClass="formInput"
                                   constraint="PhoneExtension"
                                   width="30%"
                                   size="8"
                                   maxLength="8"/>
           </td>
        </tr>
      </table>
     </td>
   </tr>
   <tr class="subDetail">
     <td>
<%/* BEGIN Address Submodule */%>
<%
    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );
%>
        <%@ include file="/grnds-docs/common/AddressSub.jsp" %>
<%
    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );
%>
<%/* END Address Submodule */%>
     </td>
   </tr>
 </table>
</impact:ExpandableSectionTag>
<%
    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }
%>
