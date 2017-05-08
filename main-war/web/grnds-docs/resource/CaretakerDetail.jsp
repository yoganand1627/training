<%
  /**
   * JSP Name:     CaretakerDetail.jsp
   * Created by:   lingamnr
   * Date Created: 08/15/02
   *
   * Description:
   * This page is accessed from the CaretakerInformation Page.  It allows users to
   * users to view, delete or modify Caretaker Information.
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added flowerbox, description and Change log.
  10/28/03  CORLEYAN        SIR 19857 validation for this conversation is no
                              longer needed since the date constraint is available.
  02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
                              passed on to following pages.
  08/31/05  Linda Reed        SIR 23777 - splitting out Race from Ethnicity for
                              AFGARS and CLASS Agency Home web page.
  04/05/07  Lata Lokhande     Added End Date field, removed Race field. Changed code 
  							  for Ethnicity to CETHNIC. 
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO" %>

<%
  
  String pageMode = PageMode.getPageMode(request);

  //Initialize the display variables for the page
  String cReqFuncCd = "";
  String cdHomeMaritalStatus = "";
  String szNmCaretkrFname = "";
  String szNmCaretkrMname = "";
  String szNmCaretkrLname = "";
  String cdCaretkrEthnic = "";
  String cdCaretkrSex = "";
  String dateOfBirth = "";
  String idCaretaker = "";
  String originalMaritalStatus = "";
  String endDate = "";
  String caretakerCount = request.getParameter("caretakerCount");
  String caretakerIndex = request.getParameter("caretakerIndex");
  String txtChildResourceId = request.getParameter("txtChildResourceId");
  if (request.getParameter("cReqFuncCd") != null) {
    cReqFuncCd = request.getParameter("cReqFuncCd");
  }
  //Initialize the variables for the page if its in modify mode(a caretaker has
  //  been set on the request as an attribute)
  ROWCRES55DO caretakerDetail = (ROWCRES55DO) request.getAttribute("ROWCRES55DO");
  if (caretakerDetail != null) {
    cdHomeMaritalStatus = caretakerDetail.getCd_Home_Marital_Status();
    originalMaritalStatus = cdHomeMaritalStatus;
    szNmCaretkrFname = caretakerDetail.getSzNmCaretkrFname();
    szNmCaretkrMname = caretakerDetail.getSzNmCaretkrMname();
    szNmCaretkrLname = caretakerDetail.getSzNmCaretkrLname();
    cdCaretkrEthnic = caretakerDetail.getCdCaretkrEthnic();
    cdCaretkrSex = caretakerDetail.getCdCaretkrSex();
    dateOfBirth = FormattingHelper.formatDate(caretakerDetail.getDtCaretkrBirth());
    idCaretaker = Integer.toString(caretakerDetail.getIdCaretaker());
    endDate = FormattingHelper.formatDate(caretakerDetail.getDtEnd());
    
  } else {
    originalMaritalStatus = request.getParameter("originalMaritalStatus");
  }

  int tabIndex = 1;
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function ()
  {
    IsDirty();
  };

  function saveCaretaker()
  {
    if ( document.frmCaretakerDetail.selHomeMarital.value != <%=originalMaritalStatus%> &&
            frmCaretakerDetail.caretakerCount.value > 1 &&
            (frmCaretakerDetail.cReqFuncCd.value != 'A' ||
            frmCaretakerDetail.cReqFuncCd.value != 'a') ) {
            
       
        if (confirm('<%= MessageLookup.getMessageByName( "MSG_RSRC_UPD_HOME_MARITAL") %>')) {
        	window.onbeforeunload = null;
            return true;
        } else {
        	return false;
        }
    } else {
    	window.onbeforeunload = null;
        return true;
     }
  }

  function deleteCaretakerDetail()
  {
    if (confirm('<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>'))
    {
      window.onbeforeunload = null;
      document.frmCaretakerDetail.cReqFuncCd.value = 'D'
      return true;
    }
    else
    {
      return false;
    }
  }
</script>

<impact:validateErrors />
<impact:validateForm name="frmCaretakerDetail"
                     method="post"
                     action="/resource/Caretaker/saveCaretakerDetail"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.CaretakerValidation"
                     schema="/WEB-INF/Constraints.xsd"
                     pageMode="<%=pageMode%>">

  <input type="hidden" name="cReqFuncCd" value="<%=cReqFuncCd%>"/>
  <input type="hidden" name="txtChildResourceId" value="<%=txtChildResourceId%>"/>
  <input type="hidden" name="caretakerCount" value="<%=caretakerCount%>"/>
  <input type="hidden" name="caretakerIndex" value="<%=caretakerIndex%>"/>
  <input type="hidden" name="originalMaritalStatus" value="<%=originalMaritalStatus%>"/>
  <impact:validateInput type="hidden" name="idCaretaker" value="<%=idCaretaker%>"/>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" style="WIDTH: 760px; HEIGHT: 50px">
    <tr>
      <th class="formLabel" colspan="4">Home Family Structure</th>
    </tr>
    <tr>
      <td><impact:validateSelect name="selHomeMarital" label="Home Marital Status" required="true" codesTable="CFAMSTRC"
                                 value="<%=cdHomeMaritalStatus%>" tabIndex="<%=tabIndex++%>"/>
      </td>
    </tr>
  </table>
  
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" style="WIDTH: 760px; HEIGHT: 50px">
    <tr>
      <th class="formLabel" colspan="10">Caretaker Information</th>
    </tr>
    <!-- Added new field in R2 Release -->
    <tr>
    	<td colspan="2"><impact:validateDate type="text" 
    									 name="txtDateEnd" 
    									 label="End Date" 
    									 constraint="Date"
                                         required="false" 
                                         value="<%=endDate%>" 
                                         size="8"
                                         tabIndex="<%=tabIndex++%>"/>
    	</td>
      
    </tr>
    <tr>
      <td colspan="2"><impact:validateInput type="text" name="txtFirstName" label="First" required="true"
                                            constraint="Name12" value="<%=szNmCaretkrFname%>" size="12" maxLength="12"
                                            tabIndex="<%=tabIndex++%>"/></td>
      <td colspan="2"><impact:validateInput type="text" name="txtMiddleName" label="Middle" constraint="Name12"
                                            value="<%=szNmCaretkrMname%>" size="12" maxLength="12"
                                            tabIndex="<%=tabIndex++%>"/></td>
      <td colspan="2"><impact:validateInput type="text" name="txtLastName" label="Last" required="true"
                                            constraint="Name22" value="<%=szNmCaretkrLname%>" size="22" maxLength="22"
                                            tabIndex="<%=tabIndex++%>"/></td>
    </tr>
    <tr>
      <td colspan="2"><impact:validateDate type="text" name="txtDateBirth" label="Date of Birth" constraint="Date"
                                           required="true" value="<%=dateOfBirth%>" size="8"
                                           tabIndex="<%=tabIndex++%>"/></td>
      <td colspan="2"><impact:validateSelect name="selEthnicity" label="Ethnicity" required="true" codesTable="CETHNIC"
                                             value="<%=cdCaretkrEthnic%>" tabIndex="<%=tabIndex++%>"
                                             style="WIDTH: 160px"/></td>
       <td colspan="2"><impact:validateSelect name="selGender" label="Gender" required="true" codesTable="CSEX"
                                             value="<%=cdCaretkrSex%>" tabIndex="<%=tabIndex++%>"/></td>
    </tr>
  </table>
  
   <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>      
      <td align="right" colspan="5">
        <impact:ButtonTag name="btnSaveCaretaker"
                          img="btnSave"
                          align="right"
                          editableMode="<%= EditableMode.EDIT %>"
                          form="frmCaretakerDetail"
                          function="return saveCaretaker();"
                          action="/resource/Caretaker/saveCaretakerDetail"
                          tabIndex="<%=tabIndex++%>"
                          restrictRepost="true"/>
      </td> 
    </tr> 
  </table> 

  <input type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>" value="<%=pageMode%>">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
