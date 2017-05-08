<%
//*  JSP Name:     Incoming Person Detail
//*  Created by:   Ochu Michael
//*  Date Created: 02/05/2003
//*
//*  Description:
//*  This JSP is used to display incoming person information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//** 04/07/2004 ochumd            sir 19775 - Added code to make sure that the address
//**                              is valid before display.  A blank object is now being
//**                              returned when primary address is not valid.
//** 05/09/2005  nallavs          SIR -23547 Removed System.out.println Statement.
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%

  String pageMode = PageModeConstants.VIEW;
  int loopCount = 0;
  int tabIndex = 1;
  String bIntakeIndicator = "Y";

  UserProfile user = UserProfileHelper.getUserProfile( request );

  CINT34SO cint34so = (CINT34SO) request.getAttribute("CINT34SO");
  if (cint34so == null)
  {
    cint34so = new CINT34SO();
  }


  ROWCINT51DO rowcint51do = cint34so.getROWCINT51DO();

  ROWCINT49DO_ARRAY rowcint49do_Array = null;
  ROWCINT48DO_ARRAY rowcint48do_Array = null;
  ROWCINT50DO_ARRAY rowcint50do_Array = null;
  ROWCINT52DO_ARRAY rowcint52do_Array = null;

  if (cint34so.getROWCINT48DO_ARRAY() == null)
  {
    rowcint48do_Array = new ROWCINT48DO_ARRAY();
  }
  else
  {
    rowcint48do_Array = cint34so.getROWCINT48DO_ARRAY();
  }

  ROWCINT48DO rowcint48doPrimary = new ROWCINT48DO();
  //ROWCINT48DO temp48doPrimary = new ROWCINT48DO();
  Enumeration e = rowcint48do_Array.enumerateROWCINT48DO();

 /* ochumd sir 19775 - Added code to make sure that the address is valid before
    display.  A blank object is now being returned when primary address is not
    valid.
*/
  while (e.hasMoreElements())
  {
    rowcint48doPrimary = (ROWCINT48DO)e.nextElement();

    if ("Y".equals(rowcint48doPrimary.getCIndIncmgAddrPrimary()))
    {
      if("Y".equals(rowcint48doPrimary.getCIndIncmgAddrInvalid()) )
      {
        rowcint48doPrimary = new ROWCINT48DO();
      }
      //else{
      //  rowcint48doPrimary = temp48doPrimary;
      //}
      break;
    }
  }
  e = rowcint48do_Array.enumerateROWCINT48DO();


  if (cint34so == null)
  {
    cint34so = new CINT34SO();
  }
  if (cint34so.getROWCINT51DO() == null)
  {
    rowcint51do = new ROWCINT51DO();
  }
  else
  {
    rowcint51do = cint34so.getROWCINT51DO();
  }

  if (cint34so.getROWCINT49DO_ARRAY() == null)
  {
    rowcint49do_Array = new ROWCINT49DO_ARRAY();
  }
  else
  {
    rowcint49do_Array = cint34so.getROWCINT49DO_ARRAY();
  }

  ROWCINT49DO rowcint49doPrimary = new ROWCINT49DO();
  Enumeration x = rowcint49do_Array.enumerateROWCINT49DO();
  while (x.hasMoreElements())
  {
    rowcint49doPrimary = (ROWCINT49DO)x.nextElement();
    if ("Y".equals(rowcint49doPrimary.getCIndIncmgNamePrimary()))
    {
      break;
    }
  }
  x = rowcint49do_Array.enumerateROWCINT49DO();


  //  process rowcint50do_Array
  if (cint34so.getROWCINT50DO_ARRAY() == null)
  {
    rowcint50do_Array = new ROWCINT50DO_ARRAY();
  }
  else
  {
    rowcint50do_Array = cint34so.getROWCINT50DO_ARRAY();
  }

  ROWCINT50DO rowcint50doPrimary = new ROWCINT50DO();
  Enumeration b = rowcint50do_Array.enumerateROWCINT50DO();
  while (b.hasMoreElements())
  {
    rowcint50doPrimary = (ROWCINT50DO)b.nextElement();
    if ("Y".equals(rowcint50doPrimary.getCIndIncmgPersonIDInv()))
    {
      break;
    }
  }
  b = rowcint50do_Array.enumerateROWCINT50DO();


  //  process rowcint52do_Array
  if (cint34so.getROWCINT52DO_ARRAY() == null)
  {
    rowcint52do_Array = new ROWCINT52DO_ARRAY();
  }
  else
  {
    rowcint52do_Array = cint34so.getROWCINT52DO_ARRAY();
  }


  ROWCINT52DO rowcint52doPrimary = new ROWCINT52DO();
  Enumeration c = rowcint52do_Array.enumerateROWCINT52DO();
  while (c.hasMoreElements())
  {
    rowcint52doPrimary = (ROWCINT52DO)c.nextElement();
    if ("Y".equals(rowcint52doPrimary.getCIndIncmgPhonePrimary()))
    {
      break;
    }
  }
  c = rowcint52do_Array.enumerateROWCINT52DO();
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
//!!! was onbeforeunload supposed to be here?
</script>


<impact:validateForm name="frmIncomingPersonDetail"
     method="post"
     action="/intake/IncomingPersonDetail/displayIncomingPersonDetail"
     schema="/WEB-INF/Constraints.xsd"
     redisplayParameters="true"
     pageMode="<%=pageMode%>">

<impact:validateErrors/>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
       <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
       <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>

<table border="0" cellSpacing="0" cellPadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Person Information</th>
  </tr>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspSzNmFirst"
         label="Name"
         value="<%= FormattingHelper.formatString(rowcint51do.getSzNmIncmgPersFull()) %>" />
      <td><impact:validateDisplayOnlyField
         name="dspSzNbrRsrcVid"
         label="Suffix"
         value="<%= FormattingHelper.formatString(rowcint49doPrimary.getSzCdIncmgNameSuffix()) %>" />
     </td>
    </tr>
     <tr>
     <td><impact:validateDisplayOnlyField
         name="dspSzAddrRsrcAddrStLn1"
         label="Street"
         value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrStLn1()) %>" />
     </td>
     <td><impact:validateDisplayOnlyField
      name="dspcity"
       label="City"
      value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrCity()) %>" />
      </td>
     </tr>
     <tr>
     <td>&nbsp;</td>
     <td>
<impact:if test='<%= (StringHelper.isValid(rowcint48doPrimary.getSzAddrIncmgAddrStLn2())) %>'>
  <impact:then>
   <impact:validateDisplayOnlyField
         name="dspSzAddrRsrcAddrStLn2"
         value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrStLn2()) %>" />
  </impact:then>
  <impact:else>
   &nbsp;
  </impact:else>
</impact:if>
     </td>
     <td><impact:validateDisplayOnlyField
         name="dspSzAddrRsrcAddrState"
         label="State"
         value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzCdIncmgAddrState()) %>" />
     </td>
      </tr>
         <tr>
       <td><impact:validateDisplayOnlyField
         name="dspSzAddrRsrcAddrZip"
         label="Zipcode"
         value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrZip()) %>" />
     </td>
        <td><impact:validateDisplayOnlyField
         name="dspSzCdFacilityCounty"
         label="County"
         value='<%=Lookup.simpleDecodeSafe("CCOUNT",   rowcint48doPrimary.getSzCdIncmgAddrCounty())%>' />
     </td>
            </tr>
  <tr>
      <td><impact:validateDisplayOnlyField
         name="dspSzAddrRsrcAddrZip"
         label="Address Type"
         value="<%= FormattingHelper.formatString(rowcint48doPrimary.getSzCdIncmgAddrType()) %>" />
     </td>
          <td><impact:validateDisplayOnlyField
            name="txtPhone"
            label="Phone"
            value="<%= FormattingHelper.formatPhone(rowcint52doPrimary.getSzNbrIncmgPhone()) %>" />
            Ext:
             <impact:validateDisplayOnlyField
          name="Phoneex"
          value="<%= FormattingHelper.formatString(rowcint52doPrimary.getSzNbrIncmgPhoneExtension()) %>" />
    </td>
          </tr>
  <tr>
      <td><impact:validateDisplayOnlyField
         name="dspSzPhoneType"
         label="Phone Type"
         value="<%= FormattingHelper.formatString(rowcint52doPrimary.getSzCdIncmgPhoneType()) %>" />
     </td>
    </tr>
     <th colspan="8">Demographics</th>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspSzNmRes"
         label="Age"
         value="<%= FormattingHelper.formatInt(rowcint51do.getUsNbrIncmgPersAge()) %>" />
     </td>
     <td><impact:validateDisplayOnlyField
         name="dspSzNbrRsr"
         label="DOB"
         value="<%= FormattingHelper.formatDate(rowcint51do.getDtDtIncmgPersBirth()) %>" />
     </td>
    </tr>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspSzAddrRsr"
         label="DOD"
         value="<%= FormattingHelper.formatDate(rowcint51do.getDtDtIncmgPersDeath()) %>" />
     </td>

    <td><impact:validateDisplayOnlyField
      name="dspReason"
      label="Reason"
      value="<%= FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersDeath()) %>" />
      </td>
 </tr>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspSRes"
         label="Marital"
         value="<%= FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersMaritlStat()) %>" />
     </td>
     <td><impact:validateDisplayOnlyField
         name="dspSzRsr"
         label="Gender"
         value="<%= FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersSex()) %>" />
     </td>
     </tr>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspPersonSsn"
         label="SSN"
         value="<%= FormattingHelper.formatSSN(rowcint50doPrimary.getSzNbrIncmgPersIdNumber()) %>" />
     </td>

    <td><impact:validateDisplayOnlyField
      name="dspLanguage"
      label="Language"
      value="<%= FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersLanguage()) %>" />
      </td>
      </tr>
  <tr>
       <td><impact:validateDisplayOnlyField
         name="dspEthnicity"
         label="Ethnicity"
         value="<%= FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersEthnic()) %>" />
     </td>
     </table>

  <br>
<impact:ExpandableSectionTag name="PhoneExp" id="PhoneExp_id"  label="Phone Detail" tabIndex="<%= tabIndex++ %>">
  <div id="phoneSubScrollBar" style="height:165;width:100%;overflow:auto" class="tableBorderList">
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
  <th class="thList">Primary</th>
  <th class="thList">Invalid</th>
  <th class="thList">Type</th>
  <th class="thList">Number</th>
  <th class="thList">Extension</th>
  <th class="thList">Start Date</th>
  <th class="thList">End Date</th>
  </tr>
<%
  int i = -1;

  c = rowcint52do_Array.enumerateROWCINT52DO();

  if (c.hasMoreElements() == false)
  {
%>
  <tr>
  <td colspan="7" class="odd">
  <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
  </td>
  </tr>
<%
  }
  else
  {
    while (c.hasMoreElements())
    {
      ROWCINT52DO rowcint52do = (ROWCINT52DO) c.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img  alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";
%>
  <tr <%= trClass %>>
  <td><%= ArchitectureConstants.Y.equals(rowcint52do.getCIndIncmgPhonePrimary()) ? CHECKED : UNCHECKED %></td>
  <td><%= ArchitectureConstants.Y.equals(rowcint52do.getCIndIncmgPhoneInvalid()) ? CHECKED : UNCHECKED %></td>
  <td><%= Lookup.simpleDecodeSafe("CPHNTYP", rowcint52do.getSzCdIncmgPhoneType()) %></td>
  <td><%= FormattingHelper.formatPhone(rowcint52do.getSzNbrIncmgPhone()) %></td>
  <td><%= rowcint52do.getSzNbrIncmgPhoneExtension() %></td>
  <td><%= FormattingHelper.formatDate(rowcint52do.getDtDtIncmgPhoneStart()) %></td>
  <td><%= FormattingHelper.formatDate(rowcint52do.getDtDtIncmgPhoneEnd()) %></td>
  </tr>
<%
       }
    }
%>

  </table>
  </div>


</impact:ExpandableSectionTag>
<br>
<impact:ExpandableSectionTag name="NameHistory" id="nameHistoryItem_0" label="Name History" tabIndex="<%= tabIndex++ %>" >

<div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">

<table width="100%" cellspacing="0" cellpadding="3" border="0">
<tr>
 <th class="thList">Primary</th>
 <th class="thList">Invalid</th>
 <th class="thList">Name</th>
 <th class="thList">Suffix</th>
 <th class="thList">Start Date</th>
 <th class="thList">End Date</th>
</tr>

<%
  int i = -1;

  x = rowcint49do_Array.enumerateROWCINT49DO();

  if (x.hasMoreElements() == false)
  {
%>
  <tr>
  <td colspan="7" class="odd">
  <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
  </td>
  </tr>
<%
  }
  else
  {
    while (x.hasMoreElements())
    {
      ROWCINT49DO rowcint49do = (ROWCINT49DO) x.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img  alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";
%>
      </td>

  <%

      String first = "";
      String middle = "";
      String last = "";
      if ( !"".equals(rowcint49do.getSzNmIncmgNameLast()) )
      {
        last = rowcint49do.getSzNmIncmgNameLast();
      }
      if ( !"".equals(rowcint49do.getSzNmIncmgNameFirst()) )
      {
        first = ", "+rowcint49do.getSzNmIncmgNameFirst();
      }
      if ( !"".equals(rowcint49do.getSzNmIncmgNameMiddle()) )
      {
        if ("".equals(first) )
        {
          middle = ", "+rowcint49do.getSzNmIncmgNameMiddle();
        }
        else
        {
          middle = " "+rowcint49do.getSzNmIncmgNameMiddle();
        }
      }

      String fullName = last + first + middle;
      String listItemId = "nameHistoryItem_" + loopCount; %>
<tr <%= trClass %>>
      <td><%= ArchitectureConstants.Y.equals(rowcint49do.getCIndIncmgNamePrimary()) ? CHECKED : UNCHECKED %></td>
    <td><%= ArchitectureConstants.Y.equals(rowcint49do.getCIndIncmgNameInvalid()) ? CHECKED : UNCHECKED %></td>
      <td><id="<%= listItemId %>"><%= fullName %>
      </td>
      <td><%= Lookup.simpleDecodeSafe( CodesTables.CSUFFIX, rowcint49do.getSzCdIncmgNameSuffix() ) %>
      </td>
       <td><%= FormattingHelper.formatDate( rowcint49do.getDtDtIncmgNameStart() ) %></td>
      <td><%= FormattingHelper.formatDate( rowcint49do.getDtDtIncmgNameEnd() ) %></td>
      </tr>
<%
      loopCount++;
    } // end while enumeration has more elements
  } //end big else

%>
  </table>
</div>

</impact:ExpandableSectionTag>

<br>
<impact:ExpandableSectionTag name="personIdentifiersSubmodule"
                               label="Person Identifiers"
                               tabIndex="<%=tabIndex%>" >

   <div id="personIdentifiersScrollBar" style="height:100%; width:100%; overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">Invalid</th>
        <th class="thList">Type</th>
        <th class="thList">Number</th>
        <th class="thList">Start</th>
        <th class="thList">&nbsp;</th>
        </tr>
      <%
  int i = -1;

  b = rowcint50do_Array.enumerateROWCINT50DO();

  if (b.hasMoreElements() == false)
  {
%>
  <tr>
  <td colspan="6" class="odd">
  <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
  </td>
  </tr>
<%
  }
  else
  {
    while (b.hasMoreElements())
    {
      ROWCINT50DO rowcint50do = (ROWCINT50DO) b.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";
      String numberType = rowcint50do.getSzCdIncmgPersIdType();
   %>
           <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
             <td align="center">
               <%= rowcint50do.getCIndIncmgPersonIDInv().equals( ServiceConstants.FND_YES ) ? CHECKED : UNCHECKED %>
             </td>
             <td>
                     <%=rowcint50do.getUlIdIncmgPersonId()%>
                     <%=FormattingHelper.formatString( numberType )%>
             </td>
             <td>
               <%
                 if( numberType.equals( CodesTables.CNUMTYPE_SSN ) )
                 {
                   out.print(FormattingHelper.formatSSN(rowcint50do.getSzNbrIncmgPersIdNumber()));
                 }
                 else
                 {
                   out.print(FormattingHelper.formatString(rowcint50do.getSzNbrIncmgPersIdNumber()));
                 }
               %>
             </td>
             <td>
               <%=FormattingHelper.formatDate( rowcint50do.getDtDtIncmgPersIdStart() )%>
             </td>
              <td>
               <%=FormattingHelper.formatString( rowcint50do.getSzDescIncmgPersonID() )%>
             </td>
           </tr>
           <%
           loopCount++;
         }
       }
      %>
      </td>
    </table>
    </div>
</impact:ExpandableSectionTag>
<br>
<impact:ExpandableSectionTag name="AddressList"
                               id="lbAddressList_Id"
                               label="Address Detail"
                               tabIndex="<%= tabIndex++ %>">

<div id="idAddressListScrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">
<table border="0" cellspacing="0" cellpadding="3" width="100%">

      <tr>
      <th class="thList">Primary</th>
      <th class="thList">Invalid</th>
      <th class="thList">Type</th>
      <th class="thList">Street</th>
      <th class="thList">City</th>
      <th class="thList">State</th>
      <th class="thList">Start Date</th>
      <th class="thList">End Date</th>
      <th class="thList">Comments</th>
      </tr>
 <%
   int i = -1;

     e = rowcint48do_Array.enumerateROWCINT48DO();

     if (e.hasMoreElements() == false)
     {
   %>
     <tr>
     <td colspan="7" class="odd">
     <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
     </td>
     </tr>
   <%
     }
     else
     {
       while (e.hasMoreElements())
       {
         ROWCINT48DO rowcint48do = (ROWCINT48DO) e.nextElement();

         i++;
         String trClass = "class=\"odd\"";
         if (i % 2 == 1)
         {
           trClass = "class=\"even\"";
         }
         String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
         String UNCHECKED = "&nbsp;";
   %>
     <tr <%= trClass %>>
     <td><%= ArchitectureConstants.Y.equals(rowcint48do.getCIndIncmgAddrPrimary()) ? CHECKED : UNCHECKED %></td>
  <td><%= ArchitectureConstants.Y.equals(rowcint48do.getCIndIncmgAddrInvalid()) ? CHECKED : UNCHECKED %></td>
          <td><%=Lookup.simpleDecodeSafe("CADDRTYP", rowcint48do.getSzCdIncmgAddrType())%>
          <td><%=rowcint48do.getSzAddrIncmgAddrStLn1()%>
          <td><%=rowcint48do.getSzAddrIncmgAddrCity()%>
          <td><%=rowcint48do.getSzCdIncmgAddrState()%>
          <td><%=FormattingHelper.formatDate(rowcint48do.getDtDtIncmgAddrStart())%>
          <td><%=FormattingHelper.formatDate(rowcint48do.getDtDtIncmgAddrEnd())%>
          <td align="center"><%if( rowcint48do.getSzTxtIncmgAddrComments() != null && !"".equals(
             rowcint48do.getSzTxtIncmgAddrComments()) ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
          </tr>
  <%

        } // end for
      }// end if addressArray.getROWCCMN42SOG00Count() == 0

  %>

  </table>
</div>

 </impact:ExpandableSectionTag>
</table>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>
