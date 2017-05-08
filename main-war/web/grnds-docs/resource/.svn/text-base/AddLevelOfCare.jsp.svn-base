<%
/**
 * JSP Name:     AddLevelOfCare.jsp
 * Created by:   Anna Corley
 * Date Created: 11/24/02
 *
 * Description:
 * This page allows a user to add new locs to determine what date the new locs will be for.
 *
 *
 *   Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
*  12/01/03  CORLEYAN           LOC Enhancement -- This page was written for the LOC
*                              enhancement and will be used to allow the user to
*                              enter an effective date and then continue to the LOC
*                              detail page.  It will call LOC validation to ensure
*                              that the date entered is appropriate.
*  09/19/05  berkime           SIR 23890 - changed the wording from level of care to
*                              service level.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>


<%
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );



  //get the page mode from the request
  String pageMode = PageMode.getPageMode(request);
  String facilityName = GlobalData.getSzNmResource( request );
  String facilityNumber = request.getParameter("txtLNbrRsrcFacilAcclaim");
  String contact = request.getParameter("txtNmRsrcContact");
  String resourceType = request.getParameter("cboCdRsrcType");
  String facilityType = request.getParameter("cboCdRsrcFacilType");

  //get the parameters from the request
  String effectiveDateS = request.getParameter("effectiveDate");
  org.exolab.castor.types.Date effectiveDate = DateHelper.toCastorDateSafe(effectiveDateS);
  org.exolab.castor.types.Date changeDate = DateHelper.toCastorDateSafe("09/01/2003");
  String endDate = request.getParameter("endDate");
  String activeLOC = request.getParameter("activeLOC");
  String holdLOC = request.getParameter("holdLOC");
  String rownum = request.getParameter("rownum");
  String ulIDResource = GlobalData.getUlIdResourceAsString( request );
  CRES09SO cres09so = null;

  cres09so = (CRES09SO) state.getAttribute("cres09so", request );
  String lateDate = null;
  if(cres09so != null)
  {
    //create new instance of the Level of Care array
    ROWCRES07DO_ARRAY latestLOCArray = null;
    ROWCRES07DO latestLOCRow = null;
    ROWCRES07DO LOCRow = null;
    if(cres09so.getROWCRES07DO_ARRAY() != null)
    {
      latestLOCArray = cres09so.getROWCRES07DO_ARRAY();
      //get the latest effective date to pass to the validation framework to check against the
      //effective date that the user will enter for a new Level of Care
      if(latestLOCArray.getROWCRES07DOCount() >0  )
      {
        latestLOCRow = latestLOCArray.getROWCRES07DO(0);
        lateDate = FormattingHelper.formatDate(latestLOCRow.getDtDtFlocEffect());
      }
    }
  }



  int tabIndex = 1;
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
<!--Insert Java Script here

function setDirty()
{
  IsDirty();
}

window.attachEvent('onbeforeunload', setDirty );


//End Java Script-->
</script>
<impact:validateErrors />
<%//SIR 23890 changed wording from level of care to service level %>
<impact:validateForm name="frmLOC"
  method="post"
  action="/resource/Facility/modifyLOC"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.LevelOfCareValidation"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>">
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="rownum" value="<%=rownum%>" />
<impact:validateInput type="hidden" name="txtLNbrRsrcFacilAcclaim" value="<%=facilityNumber%>"/>
<impact:validateInput type="hidden" name="txtNmRsrcContact" value="<%=contact%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcType" value="<%=resourceType%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcFacilType" value="<%=facilityType%>"/>
<impact:validateInput type="hidden" name="latestEffectiveDate" value="<%=lateDate%>"/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="3">Room, Board, and Watchful Oversight Detail</th>
  </tr>
  <tr>
    <td width="15%">
      <impact:validateDate name="effectiveDate"
                           label="Effective Date"
                           constraint="Date"
                           required="true"
                           value=""
                           size="10"
                           tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
 <tr>
  <td align="right">
     <impact:ButtonTag name="btnContinue"
                     img="btnContinue"
         align="right"
         form="frmLOC"
         action="/resource/Facility/modifyLOC"
         tabIndex="<%=tabIndex++%>"/>
  </td>
 </tr>
</table>

</impact:validateForm>

