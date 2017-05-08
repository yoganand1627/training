<%
//*  JSP Name:     CaseSearch
//*  Created by:   Jonathan Hardy
//*  Date Created: 01/06/03
//*
//*  Description:
//*  This JSP serves as the input form for the search parameters of a case search.  Once
//*  parameters are entered and the 'Search' button is pressed, the searchCase action is
//*  performed in the workload/CaseSearch conversation.  If city and county constraints
//*  are included, the city/county agreement is validated first.  If this validation fails,
//*  the user is returned to this page to correct the issue.  If validation succeeds, the
//*  user is sent to CaseList to find the results of the search, if any.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  --------------------------------------------------
//**  03/20/2003  Eric Dickman      QA Sweep
//**  06/05/2003  thompswa          SIR 17926 Added contentType attribute to
//**                                Program dropdown to display codes instead of
//**                                decodes. Required import of SelectTag.
//**  07/26/2006  Bhavna Gehlot     Made Modifications for GA.
//**  03/20/2008  Corey Harden      deleted onChange attribute of the city field
//**								 
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  //Set the page mode
  String pageMode = PageModeConstants.EDIT;
  //Initialize all the input fields such that search parameters are held on to - SIR 19115
  String txtCaseId = ContextHelper.getStringSafe( request, "txtUlIdCase" );
  String txtNmFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseFirst" );
  String txtNmMiddle = ContextHelper.getStringSafe( request, "txtSzNmCaseMiddle" );
  String txtNmLast = ContextHelper.getStringSafe( request, "txtSzNmCaseLast" );
  String txtNmFacility = ContextHelper.getStringSafe( request, "txtSzNmCase" );
  //String selProgram = ContextHelper.getStringSafe( request, "selSzCdCaseProgram" );
  String selRegion = ContextHelper.getStringSafe( request, "selSzCdCaseRegion" );
  String selCounty = ContextHelper.getStringSafe( request, "selSzCdCaseCounty" );
  String txtCity = ContextHelper.getStringSafe( request, "txtSzAddrCity" );
  //Adding new fields as per GA Modifications
  String txtCaseManagerId = ContextHelper.getStringSafe( request, "txtUlIdCaseManager");
  String txtNmCaseManagerFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerFirst");
  String txtNmCaseManagerLast = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerLast");
  String txtDtLastUpdate = ContextHelper.getStringSafe( request, "txtDtDtLastUpdate");
  String selCdCpsInvstDtlOvrllDisptn = ContextHelper.getStringSafe( request, "selSzCdCpsInvstDtlOvrllDisptn");
  String selCdStage = ContextHelper.getStringSafe( request, "selSzCdStage");
  String txtNbrUnit = ContextHelper.getStringSafe( request, "txtSzNbrUnit");
  String selRbOpenClose = ContextHelper.getStringSafe( request, "selRbOpenClose");
  String orderBy = "decode";



  boolean bSearchButtonHide = false;

  // Assign tabIndex
  int tabIndex = 1;
  String informationalMessage = null;

  UserProfile user = UserProfileHelper.getUserProfile( request );
  if ( user.hasRight( UserProfile.SEC_RESTRICT_CASE_SEARCH ) )
  {
    pageMode = PageModeConstants.VIEW;
    informationalMessage = new StringBuffer().append("<li>").append( MessageLookup.getMessageByNumber( Messages.MSG_NO_SEARCH_RIGHT ) ).append("</li>").toString();
  }
%>

<impact:validateForm name="frmCaseSearch"
  defaultButton="true"
  method="post"
  action="/workload/CaseSearch/searchCase"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSearchCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors/>
<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="tableBorder">
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
            <th colspan=6>Case ID Search</th>
         </tr>
       </table>
     </td>
  </tr>
  <tr>
  <td>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>

           <td><impact:validateInput type="text"
                                    editableMode="<%= EditableMode.EDIT %>"
                                    label="Case ID"
                                    conditionallyRequired="true"
                                    constraint="ID"
                                    name="txtUlIdCase"
                                    cssClass="formInput"
                                    value="<%= txtCaseId %>"
                                    size="10"
                                    maxLength="10"
                                    tabIndex="<%= tabIndex++ %>"/>
             </td>

  </tr>

 <% /* Adding the Case Manager Search */ %>
 <tr>
    <th colspan=6>Case Manager Search</th>
  </tr>

            <tr>
                <td><impact:validateInput   type="text"
                                    editableMode="<%= EditableMode.EDIT %>"
                                    label="Case Manager ID"
                                    conditionallyRequired="true"
                                    constraint="ID"
                                    name="txtUlIdCaseManager"
                                    cssClass="formInput"
                                    value="<%= txtCaseManagerId %>"
                                    size="10"
                                    maxLength="10"
                                    tabIndex="<%= tabIndex++ %>"/>
        </td>
        </tr>


<tr>
            <td><impact:validateInput type="text"
                                editableMode="<%= EditableMode.EDIT %>"
                                label="First Name"
                                constraint="Name12"
                                name="txtSzNmCaseManagerFirst"
                                cssClass="formInput"
                                value="<%= txtNmCaseManagerFirst %>"
                                size="12"
                                maxLength="12"
                                tabIndex="<%= tabIndex++ %>"/>
           </td>
           <td><impact:validateInput type="text"
                                editableMode="<%= EditableMode.EDIT %>"
                                label="Last Name"
                                conditionallyRequired="true"
                                constraint="Name22"
                                name="txtSzNmCaseManagerLast"
                                cssClass="formInput"
                                value="<%= txtNmCaseManagerLast %>"
                                size="22"
                                maxLength="22"
                                tabIndex="<%= tabIndex++ %>"/>
          </td>
         </tr>

  <tr>
    <th colspan=6>Case Name Search</th>
  </tr>

  <tr>
    <td><impact:validateInput type="text"
                              editableMode="<%= EditableMode.EDIT %>"
                              label="First"
                              constraint="Name12"
                              name="txtSzNmCaseFirst"
                              cssClass="formInput"
                              value="<%= txtNmFirst %>"
                              size="12"
                              maxLength="12"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:validateInput type="text"
                              editableMode="<%= EditableMode.EDIT %>"
                              label="Middle"
                              constraint="Name12"
                              name="txtSzNmCaseMiddle"
                              cssClass="formInput"
                              value="<%= txtNmMiddle %>"
                              size="12"
                              maxLength="12"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:validateInput type="text"
                              editableMode="<%= EditableMode.EDIT %>"
                              label="Last"
                              conditionallyRequired="true"
                              constraint="Name22"
                              name="txtSzNmCaseLast"
                              cssClass="formInput"
                              value="<%= txtNmLast %>"
                              size="22"
                              maxLength="22"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>

  <tr>
    <th colspan=6>Facility Case Name Search</th>
  </tr>

  <tr>
    <td><impact:validateInput type="text"
                              editableMode="<%= EditableMode.EDIT %>"
                              label="Name"
                              conditionallyRequired="true"
                              constraint="Name25"
                              name="txtSzNmCase"
                              cssClass="formInput"
                              value="<%= txtNmFacility %>"
                              size="25"
                              maxLength="25"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>

  <tr>
    <th colspan=6>Additional Criteria</th>
  </tr>

   <tr>

                  <td><impact:validateSelect label="Stage"
                                         name="selSzCdStage"
                                         tabIndex="<%= tabIndex++ %>"
                                         orderBy="<%= SelectTag.DECODE_ORDERBY %>"
                                         codesTable="<%= CodesTables.CTXTOGA %>"
                                         contentType="<%= SelectTag.DECODES %>"
                                         value="<%= selCdStage %>"/>
                                      
               </td>

              <td><impact:validateSelect label="Region"
                                         name="selSzCdCaseRegion"
                                         tabIndex="<%= tabIndex++ %>"
                                         codesTable="<%= CodesTables.CREGIONS %>"
                                         value="<%= selRegion %>"/>
              </td>
              <td><impact:validateInput type="text"
                                        editableMode="<%= EditableMode.EDIT %>"
                                        label="Unit"
                                        conditionallyRequired="false"
                                        constraint="Units"
                                        name="txtSzNbrUnit"
                                        cssClass="formInput"
                                        value="<%= txtNbrUnit %>"
                                        size="11"
                                        maxLength="11"
                                        tabIndex="<%= tabIndex++ %>"/>
              </td>
          </tr>

    <tr>

              <td><impact:validateSelect label="County"
                                         name="selSzCdCaseCounty"
                                         tabIndex="<%= tabIndex++ %>"
                                         codesTable="<%= CodesTables.CCOUNT %>"
                                         value="<%= selCounty %>"/>
              </td>
              
      <% /* 6-6-08 Corey Harden  Changed onChange attribute to lowerCase all letters in the city entered */ %>
      
              <td><impact:validateInput type="text"
                                        editableMode="<%= EditableMode.EDIT %>"
                                        label="City"
                                        constraint="City"
                                        name="txtSzAddrCity"
                                        cssClass="formInput"
                                        value="<%= txtCity %>"
                                        size="20"
                                        maxLength="20"
                                        tabIndex="<%= tabIndex++ %>"/>
                                        
              </td>
          </tr>
  </table>
  </td>
  </tr>
  <tr>
  <td>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
            <tr>
              <td width = "16%"><impact:validateInput type="text"
                editableMode="<%= EditableMode.EDIT %>"
                label="Assigned Date"
                  conditionallyRequired="false"
                  constraint="Date"
                  name="txtDtDtLastUpdate"
                cssClass="formInput"
                value="<%= txtDtLastUpdate %>"
                size="14"
                maxLength="14"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
              <td><impact:validateSelect label="Maltreatment Finding"
                                         name="selSzCdCpsInvstDtlOvrllDisptn"
                                         tabIndex="<%= tabIndex++ %>"
                                         codesTable="<%= CodesTables.CDISPSTN %>"
                                         value="<%= selCdCpsInvstDtlOvrllDisptn %>"/>
              </td>
         </tr>
   </table>
   </td>
   </tr>
   <tr>
   <td>
   <table border="0" cellspacing="0" cellpadding="0" width="100%">
              <tr>
            <td>
              <impact:validateInput type="radio" label="Open Cases"  tabIndex="<%=tabIndex++%>"
                          name="selRbOpenClose" cssClass="formInput"
                          value="Open"
                          checked='<%= "Open".equals(selRbOpenClose) ? "true" : "false" %>'/>
               <impact:validateInput type="radio" label="Closed Cases" tabIndex="<%=tabIndex++%>"
                           name="selRbOpenClose"  cssClass="formInput"
                           value="Closed"
                           checked='<%= "Closed".equals(selRbOpenClose) ? "true" : "false" %>'/>
           </td>
      </tr>
  </table>
  </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
<% if( !bSearchButtonHide ){%>
      <impact:ButtonTag name="btnSearch"
                        img="btnSearch"
                        align="right"
                        form="frmCaseSearch"
                        action="/workload/CaseSearch/searchCase"
                        tabIndex="<%= tabIndex++ %>"/>
    <%} else{%>
      &nbsp;
    <%}%>
    </td>
  </tr>
</table>

<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<% if ( informationalMessage != null ) { %>
<script type="text/javascript"  language="JavaScript1.2">
  displayInfoMsgs( '<%= informationalMessage %>' );
</script>
<% } %>
