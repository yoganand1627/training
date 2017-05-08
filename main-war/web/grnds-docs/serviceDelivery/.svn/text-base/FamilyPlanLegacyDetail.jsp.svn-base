<%
//*--------------------------------------------------------------------------------
//*   JSP Name:     Family Plan Legacy Detail
//*  Created by:   Jason Rios
//*  Date Created: 02/05/03
//*
//*  Description:
//*  This JSP displays the Family Plan Details.
//*
//*   Change History:
//*   Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
Iterator iter = null;
boolean bLegacyData = false;
List legacyEventsVector = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
legacyEventsVector = ( List )state.getAttribute( "legacyEventsVector", request );

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.VIEW;
if ( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script src="/grnds-docs/js/document/document.js"></script>

<impact:validateErrors/>

<%
//***************
//**** FORMS ****
//***************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="3">Family Plan Detail</th></tr>
  <tr>
    <td>
      <%= MessageLookup.getMessageByNumber( Messages.MSG_FP_LEGACY_DATA ) %>
    </td>
  </tr>
</table>
<br>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr><th>Forms</th></tr>
  <tr>  
    <td>
      <impact:documentList pageMode="<%= PageModeConstants.EDIT %>" tabIndex="<%= tabIndex++ %>">
      <%
      // Display the documents associated with each of the legacy events
      // that were queried from the database.
      //
      // NOTE: The document architecture creates a separate form for each
      // document in the list. Since some documents in the list are of the
      // same docType, and since every form on the page should have a unique
      // name, the value for the "docType" attribute is created as a
      // concatenation of the actual docType of the document, then an
      // underscore (_), then the loopCounter.
      if ( legacyEventsVector != null )
      {
        iter = legacyEventsVector.iterator();
        while ( iter.hasNext() )
        {
          EventValueBean eventBean = ( EventValueBean )iter.next();
          String documentDisplayName = eventBean.getEventDescription() + " - " + FormattingHelper.formatDate( eventBean.getDateEventOccurred() );
          String documentType = null;
          String documentFormName = null;

          if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_FAMILY_ASSMT ) )
          {
            documentType = "cfsd0100";
            documentFormName = "cfsd0100_" + loopCounter++;
          }
          else if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_3_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_SPEC_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_3_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_SPEC_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_SPEC_MONTH_EVAL ) )
          {
            documentType = "cfsd0400";
            documentFormName = "cfsd0400_" + loopCounter++;
          }
          else if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN ) )
          {
            documentType = "cfsd0500";
            documentFormName = "cfsd0500_" + loopCounter++;
          }
          %>
          <impact:document
            displayName="<%= documentDisplayName %>"
            docType="<%= documentType %>"
            docExists="true"
            name="<%= documentFormName %>"
            protectDocument="true">

            <impact:documentParameter
              name="pEvent"
              value="<%= FormattingHelper.formatInt( eventBean.getEventId() ) %>"/>

            <impact:documentParameter
              name="pStage"
              value="<%= FormattingHelper.formatInt( eventBean.getStageId() ) %>"/>
          </impact:document>
          <%
          // The Family Assessment Analysis document is available only if the
          // task code is for a "Family Assessment".
          if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_FAMILY_ASSMT ) )
          {
            documentDisplayName = eventBean.getEventDescription() + " Analysis - " + FormattingHelper.formatDate( eventBean.getDateEventOccurred() );
            documentType = "analysis";
            documentFormName = "analysis_" + loopCounter++;
            %>
            <impact:document
              displayName="<%= documentDisplayName %>"
              docType="<%= documentType %>"
              docExists="true"
              protectDocument="true"
              name="<%= documentFormName %>">

              <impact:documentParameter
                name="sEvent"
                value="<%= FormattingHelper.formatInt( eventBean.getEventId() ) %>"/>

              <impact:documentParameter
                name="sCase"
                value="<%= FormattingHelper.formatInt( eventBean.getCaseId() ) %>"/>

              <impact:documentParameter
                name="sTimestamp"
                value=""/>
            </impact:document>
            <%
          } // end if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||...
        } // end while ( iter.hasNext() )
      } // end if ( legacyEventsVector != null )
      %>
      </impact:documentList>
    </td>
  </tr>
</table>
<br>