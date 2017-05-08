<%
  //*  JSP Name:     Domicile and Deprevation
  //*  Created by:   Rodrigo DeJuana
  //*  Date Created: 02/17/02
  //*
  //*  Description:
  //*  When we first started looking at this page, we thought the javascript was
  //*  going to be nightmare.  We tried to reuse the code for each section, but
  //*  that jsut became a pain, but we did like the secitoned off code.  So before
  //*  you start to tear you hair out trying to figure out what i did, let me tell
  //*  you.  The whole page is written as blocks with place holders.  Each section
  //*  is its own div tag.  The is javascript that control what gets displayed.
  //*  The javascript basically does a lot of innerHtml moves.  For exmaple there is a
  //*  table cell right below it the Both parents radio button that is empty but named.
  //*  And there is a div section named Both.  When i click on the Both parents radio button,
  //*  the javascript will move the html within the Both div section into the
  //*  empty placeholder.  If i select another radio button, the html is moved
  //*  back to the div section.  Here's the cool part, if i reselect the Both
  //*  radio button, it remebers what was selected in that session (ie, it will
  //*  only save what is visible).  Now go an play with it, it really is kind of cool. :)
  //*
  /* Change History:
   Date      User              Description
   --------  ----------------  --------------------------------------------------
   06/11/03  Todd Reser        SIR 18232 - Fixed mispelling of irregularly
   11/09/10  Hai Nguyen        SMS#81144: MR-053 Added new questions to determine deprivation.
                               Remove Confirmation section and associated fields and buttons.
                               Remove Date of Deprivation Change section and associated fields.
                               Remove Month and Year field and change to Removal Date.
                               Replace PE radio buttons to dropdown to select actual PE.
                               Removed Edit button and added Continue button.
   12/07/10                    SMS#81144: MR-053 Added logic to display old deprivation
                               determination that was overrided by ES.
   12/14/10                    SMS#86169: MR-053 Update button mode to display for CM to
                               save system determination and navigate to next page for NOC
   01/20/11                    SMS#81144: Added message to complete NOTA section when relative 
                               does not meet criteria for specified relative.
   */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
  String fceApplicationPageMode = (String) request
                                                  .getAttribute(DomicileDeprivationConversation.FCE_APPLICATION_PAGE_MODE);

  String pageMode = PageMode.getPageMode(request);

  int tabIndex = 1;
  String formName = "frmDomicile";

  DomicileDeprivationDB domicileDB = (DomicileDeprivationDB) request
                                                                    .getAttribute(DomicileDeprivationConversation.DOMICILEDB);

  // This sets the color of the subsections.
  String bgColor = "#F0FFFF";
%>


<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};


window.onload = function()
{
  <% if (pageMode.equals(PageModeConstants.EDIT)) { %>
  <%   if ("R".equals(domicileDB.getCdApplication())) { %>
    setupPageInquire();
  <%   }else{ %>
    setupPageEdit();
  <%   }
     } else { %>
    setupPageInquire();
  <%}%>
}


function resetTargets()
{
  var obBoth       = document.getElementById("both");
  var obBothEmpty  = document.getElementById("bothEmpty");
  var obOne        = document.getElementById("one");
  var obOneEmpty   = document.getElementById("oneEmpty");
  var obOther      = document.getElementById("other");
  var obOtherEmpty = document.getElementById("otherEmpty");
  var obNone       = document.getElementById("none");
  var obNoneEmpty  = document.getElementById("noneEmpty");
  if (obBoth.innerHTML.length == 0)
  {
    swap("bothEmpty", "both");
  }
  if (obOne.innerHTML.length == 0)
  {
    swap("oneEmpty", "one");
  }
  if (obOther.innerHTML.length == 0)
  {
    swap("otherEmpty", "other");
  }
  if (obNone.innerHTML.length == 0)
  {
    swap("noneEmpty", "none");
  }
}


function reset6MnthTargets()
{
  var obBoth       = document.getElementById("both");
  var obBothEmpty  = document.getElementById("6MnthBothEmpty");
  var obOne        = document.getElementById("one");
  var obOneEmpty   = document.getElementById("6MnthOneEmpty");
  var obOther      = document.getElementById("6MnthOther");
  var obOtherEmpty = document.getElementById("6MnthOtherEmpty");
  if (obBoth.innerHTML.length == 0)
  {
    swap("6MnthBothEmpty", "both");
  }
  if (obOne.innerHTML.length == 0)
  {
    swap("6MnthOneEmpty", "one");
  }
  if (obOther.innerHTML.length == 0)
  {
    swap("6MnthOtherEmpty", "6MnthOther");
  }
}


function setNoneOfTheAbove(value)
{
  if (value == 'yes')
  {
    swap("6Mnth", "6MnthEmpty");
  }
  else
  {
    var ob6MnthEmpty = document.getElementById("6MnthEmpty");
    if (ob6MnthEmpty.innerHTML.length != 0)
    {
      swap("6MnthEmpty", "6Mnth");
    }
  }
}


function set6MnthSubsection(source, target)
{
  reset6MnthTargets();
  swap(source, target);
}


function setSubsection(source, target)
{
  resetTargets();
  swap(source, target);
}


function clearNota()
{
  reset6MnthTargets();

  var form = document.<%=formName%>;
  setNoneOfTheAbove('no');
  form.indChildLivingPrnt6Mnths[0].checked = false;
  form.indChildLivingPrnt6Mnths[1].checked = false;
  form.txtMonthsLivingRelCust.value = "";
  form.cdNotaMostRecent[0].checked = false;
  form.cdNotaMostRecent[1].checked = false;
  form.cdNotaMostRecent[2].checked = false;
}


function swap(source, target)
{
  var obSource = document.getElementById(source);
  var obTarget = document.getElementById(target);
  obTarget.innerHTML = obSource.innerHTML;
  obSource.innerHTML = "";
}


function setupPageEdit()
{
  if (document.<%=formName%>.cdLivingMonthRemoval[0].checked)
  {
    setSubsection('both', 'bothEmpty');
  }
  if (document.<%=formName%>.cdLivingMonthRemoval[1].checked)
  {
    setSubsection('one', 'oneEmpty');
  }
  if (document.<%=formName%>.cdLivingMonthRemoval[2].checked)
  {
    setSubsection('other', 'otherEmpty');
  }
  if (document.<%=formName%>.cdLivingMonthRemoval[3].checked)
  {
    setSubsection('none', 'noneEmpty');
    if (document.<%=formName%>.indChildLivingPrnt6Mnths[0].checked)
    {
      setNoneOfTheAbove('yes');
      if (document.<%=formName%>.cdNotaMostRecent[0].checked)
      {
        set6MnthSubsection('both', '6MnthBothEmpty');
      }
      if (document.<%=formName%>.cdNotaMostRecent[1].checked)
      {
        set6MnthSubsection('one', '6MnthOneEmpty');
      }
      if (document.<%=formName%>.cdNotaMostRecent[2].checked)
      {
        set6MnthSubsection('6MnthOther', '6MnthOtherEmpty');
      }
    }
  }
}


function setupPageInquire()
{
  <impact:ifThen test='<%=CodesTables.CFCELIV_B.equals(domicileDB.getCdLivingMonthRemoval())%>'>
         setSubsection('both', 'bothEmpty');
  </impact:ifThen>
  <impact:ifThen test='<%=CodesTables.CFCELIV_O.equals(domicileDB.getCdLivingMonthRemoval())%>'>
         setSubsection('one', 'oneEmpty');
  </impact:ifThen>
  <impact:ifThen test='<%=CodesTables.CFCELIV_R.equals(domicileDB.getCdLivingMonthRemoval())%>'>
         setSubsection('other', 'otherEmpty');
  </impact:ifThen>
  <impact:ifThen test='<%=CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval())%>'>
         setSubsection('none', 'noneEmpty');

    <impact:ifThen test="<%=domicileDB.getIndChildLivingPrnt6Mnths()%>">
         setNoneOfTheAbove('yes');
      <impact:ifThen test='<%=CodesTables.CFCELIV6_B.equals(domicileDB.getCdNotaMostRecent())%>'>
         set6MnthSubsection('both', '6MnthBothEmpty');
      </impact:ifThen>
      <impact:ifThen test='<%=CodesTables.CFCELIV6_O.equals(domicileDB.getCdNotaMostRecent())%>'>
         set6MnthSubsection('one', '6MnthOneEmpty');
      </impact:ifThen>
      <impact:ifThen test='<%=CodesTables.CFCELIV6_R.equals(domicileDB.getCdNotaMostRecent())%>'>
         set6MnthSubsection('6MnthOther', '6MnthOtherEmpty');
      </impact:ifThen>
    </impact:ifThen>
  </impact:ifThen>
}


function edit()
{
  disableValidation('<%=formName%>');
}

function showNotSpecifiedRelative()
{
  var section = document.getElementById('notSpecifiedRelative');
  section.style.display = 'block';    
}

function hideNotSpecifiedRelative()
{
  var section = document.getElementById('notSpecifiedRelative');
  section.style.display = 'none';    
}
</script>

<impact:validateErrors />

<impact:validateForm name="<%=formName%>" method="post"
	action="/fcElig/DomicileDeprivation/saveDomicile"
	pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationCustomValidation"
	schema="/WEB-INF/Constraints.xsd">


	<!-- Hidden Fields -->
	<impact:validateInput type="hidden" name="idFceApplication"
		value="<%=domicileDB.getIdFceApplicationString()%>" />
	<impact:validateInput type="hidden" name="idFceEligibility"
		value="<%=domicileDB.getIdFceEligibilityString()%>" />
	<impact:validateInput type="hidden" name="idEvent"
		value="<%=domicileDB.getIdEventString()%>" />
	<impact:validateInput type="hidden" name="idStage"
		value="<%=domicileDB.getIdStageString()%>" />
	<impact:validateInput type="hidden"
		name="fceApplicationDtLastUpdateTime"
		value='<%="" + domicileDB.getFceApplicationDtLastUpdateTime()%>' />
	<impact:validateInput type="hidden"
		name="fceEligibilityDtLastUpdateTime"
		value='<%="" + domicileDB.getFceEligibilityDtLastUpdateTime()%>' />
	<impact:validateInput type="hidden" name="idLastUpdatePerson"
		value='<%="" + BasePrsConversation.getUserID(request)%>' />
	<impact:validateInput type="hidden" name="indMeetsDpOrNotSystem"
		value="<%=domicileDB.getIndMeetsDpOrNotSystemString()%>" />
	<impact:validateInput type="hidden" name="cdApplication"
		value="<%=domicileDB.getCdApplication()%>" />
	<impact:validateInput type="hidden" name="currentLivingArrangements"
		value="<%=domicileDB.getCdLivingMonthRemoval()%>" />
	<impact:validateInput type="hidden" name="currentNota"
		value="<%=domicileDB.getCdNotaMostRecent()%>" />
    <impact:validateInput type="hidden" name="cdEventStatus"
        value="<%=domicileDB.getCdEventStatus()%>" />

	<!--- Begin Detail Table --->
	<%
	  UserProfile user = UserProfileHelper.getUserProfile(request);

	    String bDisabled = "" + PageModeConstants.VIEW.equals(fceApplicationPageMode);
	    if ((pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.EDIT))
	        && ((EventHelper.APPROVED_EVENT.equals(domicileDB.getCdEventStatus())) || ((user
	                                                                                        .hasRight(UserProfile.SEC_ELIGIBILITY)) && ((EventHelper.PENDING_EVENT
	                                                                                                                                                              .equals(domicileDB
	                                                                                                                                                                                .getCdEventStatus())) || (EventHelper.COMPLETE_EVENT
	                                                                                                                                                                                                                                    .equals(domicileDB
	                                                                                                                                                                                                                                                      .getCdEventStatus())))))) {
	%>
	<br>
	<table border="0" width="100%" cellSpacing="0" cellPadding="0">
		<tr>
<%
    // MR-053 This is to handle old deprivation determination that were overriden by ES
    if( EventHelper.APPROVED_EVENT.equals(domicileDB.getCdEventStatus()) && domicileDB.getIndMeetsDpOrNotEsObject() != null ) {
%>
			<td colspan="2">
				Eligibility Specialist has determined that the child
				<b><%=domicileDB.getIndMeetsDpOrNotEs() ? "meets" : "does not meet"%></b>
				Title IV-E Requirements for Deprivation.
			</td>
<%
    } else {
%>
            <td colspan="2">
                The system has determined that the child
                <b><%=domicileDB.getIndMeetsDpOrNotSystem() ? "meets" : "does not meet"%></b>
                Title IV-E Requirements for Deprivation.
            </td>
<%
    }
%>
		</tr>
	</table>
    <br>
	<%
	  }
	%>

	<div id="main" style="display: block">
		<table border="0" width="100%" cellSpacing="0" cellPadding="3"
			class="tableBorder">
			<tr>
				<th>
					Determination of Removal Household and Deprivation of Parental
					Support
				</th>
			</tr>
			<tr>
				<td>Removal Date: <impact:validateDisplayOnlyField
				  name="dtRemovalDate"
				  value="<%=domicileDB.getDtRemovalDateString()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					Specify the child's living arrangement at the time of removal.
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateInput name="cdLivingMonthRemoval"
						label="Living with Both Legal or Biological Parents"
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_BOTH.equals(domicileDB.getCdLivingMonthRemoval()))%>'
						value="B" type="radio" id="1"
						onClick="clearNota(); setSubsection('both', 'bothEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td id="bothEmpty"></td>
			</tr>
			<tr>
				<td>
					<impact:validateInput name="cdLivingMonthRemoval"
						label="Living With One Legal or Biological Parent"
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_ONE.equals(domicileDB.getCdLivingMonthRemoval()))%>'
						value="O" type="radio" id="2"
						onClick="clearNota(); setSubsection('one', 'oneEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td id="oneEmpty"></td>
			</tr>
			<tr>
				<td>
					<impact:validateInput name="cdLivingMonthRemoval"
						label=""
						checked='<%=""
                  + (DomicileDeprivationConversation.LIV_ARR_OTHER.equals(domicileDB.getCdLivingMonthRemoval()))%>'
						value="R" type="radio" id="3"
						onClick="clearNota(); setSubsection('other', 'otherEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
						Living With <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">Specified Relative</a></span>
				</td>
			</tr>
			<tr>
				<td id="otherEmpty"></td>
			</tr>
			<tr>
				<td>
					<impact:validateInput name="cdLivingMonthRemoval"
						label="None of the Above"
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_NONE.equals(domicileDB.getCdLivingMonthRemoval()))%>'
						value="N" type="radio" id="4"
						onClick="setSubsection('none', 'noneEmpty')" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td id="noneEmpty"></td>
			</tr>
		</table>

	</div>



	<div id="both" style="display: none">
		<%
		  request.setAttribute("tabIndex", tabIndex);
		    request.setAttribute("disableDeprivation", false);
		    request.setAttribute("fceEligibilityDB", domicileDB.getFceEligibility());
		%>
		<%@ include file="/grnds-docs/fce/DeprivationBothSub.jsp"%>
		<%
		  tabIndex = (Integer) request.getAttribute("tabIndex");
		%>
	</div>


	<div id="one" style="display: none">
		<%
		  request.setAttribute("tabIndex", tabIndex);
		    request.setAttribute("disableDeprivation", false);
		    request.setAttribute("fceEligibilityDB", domicileDB.getFceEligibility());
		%>
		<%@ include file="/grnds-docs/fce/DeprivationOneSub.jsp"%>
		<%
		  tabIndex = (Integer) request.getAttribute("tabIndex");
		%>
	</div>


	<%
	  List<String> exOptions = new ArrayList<String>();
	    exOptions.add(domicileDB.getIdFcePersonString());
	%>
	<div id="other" style="display: none">
		<table border="0" width="100%" cellSpacing="0" cellPadding="0">
			<tr>
				<td width="25"></td>
				<td>
					<table border="0" width="100%" cellSpacing="0" cellPadding="3"
						class="tableBorder" bgcolor="<%=bgColor%>">
						<tr>
							<td width="80%">
								<impact:validateSelect name="idOtherRelativePerson"
									label="Name of Relative"
									value="<%= domicileDB.getIdOtherRelativePersonString()%>"
									conditionallyRequired="true"
									options="<%=FceUtility.getOptionsFromPrinciples(domicileDB.getPrinciples())%>"
									excludeOptions="<%=exOptions%>" 
									tabIndex="<%=tabIndex++%>"
									blankValue="true" 
									colspan="2"/></td>
						</tr>
                        <tr>
                          <td width="80%"><span class="formCondRequiredText">&#135;</span>Does the relative meet criteria as a <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">specified relative</a></span>?</td>
                          <td width="10%"><impact:validateInput
                            name="indSpecifiedRelative" 
                            label="Yes" 
                            checked='<%= Boolean.toString("true".equals(domicileDB.getIndSpecifiedRelativeString())) %>' 
                            value="true" 
                            type="radio" 
                            id="1" 
                            cssClass="formInput" 
                            onClick="hideNotSpecifiedRelative();" 
                            tabIndex="<%=tabIndex++%>" /></td>
                          <td width="10%"><impact:validateInput
                            name="indSpecifiedRelative" 
                            label="No" 
                            checked='<%= Boolean.toString("false".equals(domicileDB.getIndSpecifiedRelativeString())) %>' 
                            value="false" 
                            type="radio" 
                            id="2" 
                            cssClass="formInput"
                            onClick="showNotSpecifiedRelative();" 
                            tabIndex="<%=tabIndex++%>" /></td>
                        </tr>
                        <tr>
                            <td>
							    <div id="notSpecifiedRelative" style="display: none">
							        <table width="100%">
							            <tr>
							                <td>
							                    <b>In this situation, complete the section for None of the
							                        Above by selecting the radio button below.</b>
							                </td>
							            </tr>
							        </table>
							    </div>
                            </td>
                        </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>


	<div id="6MnthOther" style="display: none">
		<table border="0" width="100%" cellSpacing="0" cellPadding="0">
			<tr>
				<td width="25"></td>
				<td>
					<table border="0" width="100%" cellSpacing="0" cellPadding="3"
						class="tableBorder" bgcolor="<%=bgColor%>">
						<tr>
							<td width="80%">
								<impact:validateSelect name="idMngngCvsPerson"
									label="Name of Relative"
									value="<%=domicileDB.getIdMngngCvsPersonString()%>"
									conditionallyRequired="true"
									options="<%=FceUtility.getOptionsFromPrinciples(domicileDB.getPrinciples())%>"
									excludeOptions="<%=exOptions%>" 
									tabIndex="<%=tabIndex++%>"
									blankValue="true" 
									colspan="2"/>
							</td>
						</tr>
						<tr>
						  <td width="80%"><span class="formCondRequiredText">&#135;</span>Does the relative meet criteria as a <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">specified relative</a></span>?</td>
						  <td width="10%"><impact:validateInput
						    name="indSpecifiedRelative" 
						    label="Yes" 
						    checked='<%= Boolean.toString("true".equals(domicileDB.getIndSpecifiedRelativeString()) && CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval()) ) %>' 
						    value="true" 
						    type="radio" 
						    id="3" 
						    cssClass="formInput" 
						    tabIndex="<%=tabIndex++%>" /></td>
                          <td width="10%"><impact:validateInput
                            name="indSpecifiedRelative" 
                            label="No" 
                            checked='<%= Boolean.toString("false".equals(domicileDB.getIndSpecifiedRelativeString()) && CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval()) ) %>' 
                            value="false" 
                            type="radio" 
                            id="4" 
                            cssClass="formInput" 
                            tabIndex="<%=tabIndex++%>" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div id="none" style="display: none">
		<table border="0" width="100%" cellSpacing="0" cellPadding="0">
			<tr>
				<td width="25"></td>
				<td>
					<table border="0" width="100%" cellSpacing="0" cellPadding="3"
						class="tableBorder" bgcolor="<%=bgColor%>">
						<tr>
							<td width="80%">
								<span class="formCondRequiredText">&#135;</span>&nbsp;At any
								time during the six months before removal, did the child live
								with a parent or <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">specified relative</a></span>?
							</td>
							<td width="10%">
								<impact:validateInput name="indChildLivingPrnt6Mnths"
									label="Yes"
									checked='<%= Boolean.toString("true".equals(domicileDB.getIndChildLivingPrnt6MnthsString())) %>'
									value="true" type="radio" id="1"
									onClick="setNoneOfTheAbove('yes')" cssClass="formInput"
									tabIndex="<%=tabIndex++%>" />
							</td>
							<td width="10%">
								<impact:validateInput name="indChildLivingPrnt6Mnths" label="No"
									checked='<%= Boolean.toString("false".equals(domicileDB.getIndChildLivingPrnt6MnthsString()))%>'
									value="false" type="radio" id="2"
									onClick="setNoneOfTheAbove('no')" cssClass="formInput"
									tabIndex="<%=tabIndex++%>" />
							</td>
						</tr>
						<tr>
							<td id="6MnthEmpty" colspan="3"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>


	<div id="6Mnth" style="display: none">
		<table border="0" width="100%" cellSpacing="0" cellPadding="3"
			class="tableBorder" bgcolor="#FFFFFF">
			<tr>
				<td width="70%">
					<span class="formCondRequiredText">&#135;</span>&nbsp;List the
					months the child was living with a parent or <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">specified relative</a></span>.
				</td>
				<td width="30%">
					<impact:validateInput type="text" constraint="Paragraph80"
						name="txtMonthsLivingRelCust" cssClass="formInput"
						value="<%=domicileDB.getTxtMonthsLivingRelCust()%>" size="40"
						maxLength="80" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<span class="formCondRequiredText">&#135;</span>&nbsp;Select the
					most recent situation that applies:
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<impact:validateInput name="cdNotaMostRecent"
						label="Living with Both Parents"
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_BOTH.equals(domicileDB.getCdNotaMostRecent()))%>'
						value="B" type="radio" id="1"
						onClick="set6MnthSubsection('both', '6MnthBothEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td id="6MnthBothEmpty" colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">
					<impact:validateInput name="cdNotaMostRecent"
						label="Living With One Legal or Biological Parent"
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_ONE.equals(domicileDB.getCdNotaMostRecent()))%>'
						value="O" type="radio" id="2"
						onClick="set6MnthSubsection('one', '6MnthOneEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td id="6MnthOneEmpty" colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">
					<impact:validateInput name="cdNotaMostRecent"
						label=""
						checked='<%="" + (DomicileDeprivationConversation.LIV_ARR_OTHER.equals(domicileDB.getCdNotaMostRecent()))%>'
						value="R" type="radio" id="3"
						onClick="set6MnthSubsection('6MnthOther', '6MnthOtherEmpty')"
						cssClass="formInput" tabIndex="<%=tabIndex++%>" />
						Living With <span ><a href="javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')">Specified Relative</a></span>
				</td>
			</tr>
			<tr>
				<td id="6MnthOtherEmpty" colspan="2"></td>
			</tr>
		</table>
	</div>
	<br>
        <%
          boolean bSave = ((EventHelper.NEW_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.PROCESS_EVENT.equals(domicileDB.getCdEventStatus()))
                                    && CaseUtility.hasStageAccess(user.getUserID(), (int) domicileDB.getIdStage()))
                          || ((EventHelper.PENDING_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.COMPLETE_EVENT.equals(domicileDB.getCdEventStatus()))
                              && FceUtility.isEligibilitySpecialist(request));

          boolean bContinue = (EventHelper.PENDING_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.COMPLETE_EVENT.equals(domicileDB.getCdEventStatus()))
                              && FceUtility.isEligibilitySpecialist(request);
        %>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" img="btnSave" form="<%=formName%>"
					action="/fce/DomicileDeprivation/saveDomicile"
					restrictRepost="true"
					disabled="<%=String.valueOf(!bSave)%>"
					tabIndex="<%=tabIndex++%>"
					editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" />
				<impact:ButtonTag name="btnContinue" img="btnContinue"
					form="<%=formName%>" action="/fce/DomicileDeprivation/saveDomicile"
					restrictRepost="true" disabled="<%=String.valueOf(!bContinue)%>"
					tabIndex="<%=tabIndex++%>"
					editableMode="<%= EditableMode.EDIT %>" />
			</td>
		</tr>
	</table>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

</impact:validateForm>
