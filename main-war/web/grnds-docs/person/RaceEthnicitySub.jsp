<%--
//*  JSP Name:     Race Ethnicity Submodule
//*  Created by:   Dann Webster
//*  Date Created: 12/04/2002
//*
//*****************************************************************************
USAGE EXAMPLE:

<%@ include file="/grnds-docs/person/RaceEthSub.jsp" %>

POPULATION EXAMPLE:
an example of how to make data show up in the submodule can be found in the
Detail template in the populateRaceEthnicitySubmodule( request ) method.

//*****************************************************************************
//*
//*  Description:
//*  Included submodule to display the race checkboxes and
//*  ethnicity radio buttons. Should be included using the following code:
//*
//*  <%@ include file="/grnds-docs/person/RaceEthSub.jsp" %>
//*
//*  Requires the following fields be passed in from the include page:
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  ---------------------------------------------
//**  05/05/03  DWW               SIRs 16675, 16868 added the fire onclick to
//**                              have the checkboxes correctly update when
//**                              the "unable to determine" cbx is checked
//**  08/11/10  hnguyen           MR-067 Modify Race Ethnicity instruction message
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper"%>

<%
  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );
%>

<script language="javascript">
// make sure at least one race checkbox is checked
function isRaceChecked()
{
  var raceLen = <%= Lookup.getCategoryCollection( CodesTables.CRACE ).size() %>;
  var cbxGroupName = "<%=RaceEthnicityHelper.RACE_CB_NAME %>";
  var bRace = areAnyChecked( cbxGroupName, raceLen );
  return bRace;
}

// make sure that a radiobutton from the ethnicity radio button group is checked
function isEthnicityChecked()
{
  var ethLen = <%= Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() %>;
  var bEth = false;
  var ethnicityRb = document.getElementsByName("<%= RaceEthnicityHelper.ETHNICITY_RB_NAME %>");
  for ( i = 0; i < ethLen ; i++ )
  {
    bEth = ethnicityRb[i].checked;
    if ( bEth )
    {
      break;
    }
  }
  return bEth;
}

// make sure at least one race checkbox is checked or
// a radiobutton from the ethnicity radio button group is checked
function isRaceOrEthnicityChecked()
{
  var bRaceOrEth = false;
  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );
  return bRaceOrEth;
}
// make sure that the race checkboxes are cleared if the undecided checkbox is checked
function clearRaces( paramCbx )
{
  var raceLen = <%= Lookup.getCategoryCollection( CodesTables.CRACE ).size() %>;

  if ( paramCbx.checked == true )
  {
    // if you checked the Unable to Determine checkbox, make sure that all the others
    // are unchecked
    if ( paramCbx.value == "<%= CodesTables.CRACE_UD  %>" )
    {
      for ( var i = 1; i <= raceLen; i++ )
      {
        var cbxId = "<%= RaceEthnicityHelper.RACE_CB_NAME %>" + i + "_id";
        var currentCbx = document.getElementById( cbxId );
        if ( currentCbx.value != "<%= CodesTables.CRACE_UD %>" )
        {
          currentCbx.checked = false;
          // DWW 05/05/2003
          // SIRs 16675, 16868
          // added the fire onclick to have the checkboxes correctly update when
          // the "unable to determine" cbx is checked
          currentCbx.fireEvent("onClick");
        }
      }
    }
    // else, if you checked any others, make sure Unable to Determine is unchecked
    else
    {
      for ( var i = 1; i <= raceLen; i++ )
      {
        var cbxId = "<%= RaceEthnicityHelper.RACE_CB_NAME %>" + i + "_id";
        var currentCbx = document.getElementById( cbxId );
        if ( currentCbx.value == "<%= CodesTables.CRACE_UD %>" )
        {
          // DWW 05/05/2003
          // SIRs 16675, 16868
          // added the fire onclick to have the checkboxes correctly update when
          // the "unable to determine" cbx is checked
          currentCbx.checked = false;
          currentCbx.fireEvent("onClick");
        }
      }
    }
  }
}
</script>

<impact:ExpandableSectionTag name="RaceEthnicity" id='<%= RaceEthnicityHelper.RACE_CB_NAME + "1_Id"%>' label="Race/Ethnicity Detail" 
tabIndex="<%= raceEthnicitySubDBTabIndex %>" isExpanded="<%=Boolean.valueOf(isExpanded).booleanValue()%>">
   <span class="formInstruct">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
   <th>Race</th>
  </tr>
  <tr class="subDetail">
    <td>
      <impact:codesCheckbox
      defaultCodes="<%=raceValues%>"
      name="<%= RaceEthnicityHelper.RACE_CB_NAME %>"
      codesTableName="<%= CodesTables.CRACE %>"
      onClick="clearRaces(this)"
      columns="3"
      isHorizontal="true"
      tabIndex="<%= raceEthnicitySubDBTabIndex %>"/>
    </td>
  </tr>
  <tr>
   <th>Ethnicity</th>
  </tr>
  <tr class="subDetail">
    <td>
      <table width="100%">
        <tr>
<%
    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();
%>
          <td>
            <impact:validateInput
              value="<%= ethnicity.getKey() %>"
              tabIndex="<%= raceEthnicitySubDBTabIndex %>"
              name="<%= RaceEthnicityHelper.ETHNICITY_RB_NAME %>"
              type="radio"
              checked="<%= String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) %>"
            />
              <%= ethnicity.getValue() %>
          </td>
<%
    }
%>
        </tr>
      </table>
    </td>
  </tr>
</table>
<impact:validateInput
  type="hidden"
  name="<%= RaceEthnicityHelper.OLD_ETHNICITY_NAME %>"
  value="<%= personEthnicity %>"
  />
</impact:ExpandableSectionTag>
<%
    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }
%>
