package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FosterCareSecGoalsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FosterCareSecGoalsSubConversation;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;

public final class FosterCareSecGoalsSub_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


 List<FosterCareSecGoalsList> fosterCareSecGoal = new ArrayList();
 String tabindexString = (String) request.getAttribute("tabIndex");
 int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
 int size = 0;
 int loopCount = 0;
 int idEvent = GlobalData.getUlIdEvent(request);
 
//*********************
//*** SET PAGE MODE ***
//*********************

   String pageMode = PageModeConstants.EDIT;
   if (PageMode.getPageMode(request) != null) {
   pageMode = PageMode.getPageMode(request);
  }
      
 
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************     
      
 BaseSessionStateManager state = (BaseSessionStateManager) request
        .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);

//**************************
//*** RETRIEVE PAGE DATA ***
//************************** 
   FosterCareSecGoalsRetrieveSO fosterCareSecGoals = (FosterCareSecGoalsRetrieveSO) state.getAttribute("FosterCareSecGoalsRetrieveSO", request);
   if(fosterCareSecGoals.getSecGoalsList() != null)
   {
     fosterCareSecGoal =fosterCareSecGoals.getSecGoalsList();
     size = fosterCareSecGoal.size();
   }


      out.write("\r\n\r\n<!--<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>-->\r\n<!--<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>-->\r\n<!--<script type=\"text/javascript\" language=\"JavaScript1.2\">-->\r\n\r\n<script language=\"Javascript\">\r\n\r\nfunction submitSecondaryGoals( idPlanSecGoals){\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnIdFosterCareSecGoals.value = idPlanSecGoals;\r\n  submitValidateForm( '");
      out.print( includingFormName );
      out.write("', '/serviceDelivery/FosterCareSecGoals/displayFosterCareSecGoals' );\r\n  }\r\n\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n<div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborderList\">\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        Secondary Goals\r\n      </th>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr>\r\n      <th class=\"thList\">\r\n        Status\r\n      </th>\r\n      <th class=\"thList\">\r\n        Goal Text\r\n      </th>\r\n    </tr>\r\n\r\n    ");

          if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0 && idEvent != 0) {
         
      out.write("\r\n    <tr class=\"");
      out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
      out.write("\">\r\n      <td colspan=\"10\">\r\n        ");
      out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
      out.write("\r\n      </td>\r\n    </tr>\r\n    ");
} else {
          for (Iterator<FosterCareSecGoalsList> it = fosterCareSecGoal.iterator(); it.hasNext();) {
          FosterCareSecGoalsList fosterGoals = (FosterCareSecGoalsList) it.next();
          String idPlanSecGoals = String.valueOf(fosterGoals.getIdPlanSecGoals());
              
       
      out.write("\r\n    <tr class=\"");
      out.print(FormattingHelper.getRowCss( loopCount + 1));
      out.write("\">\r\n      <td>\r\n        ");

                  String status = "";
                  status = FormattingHelper.formatString( fosterGoals.getSelStatus());
                 
      out.write("\r\n        <a href=\"javascript:submitSecondaryGoals('");
      out.print( idPlanSecGoals );
      out.write("')\">");
      out.print(status);
      out.write("</a>\r\n      </td>\r\n      <td>\r\n        ");
      out.print( FormattingHelper.formatString(fosterGoals.getTxtDesc()));
      out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    ");
loopCount++;
       }
           } //end big else
      } // end !FormValidation.pageHasErrorMessages

      
      out.write("\r\n  </table>\r\n</div>\r\n\r\n");
if (!pageMode.equals(PageModeConstants.VIEW)) {
// STGAP00010974 Displaying add button only after the page has been saved first.   
  String displayAddBtn; 
			  Boolean updateClicked = (Boolean) state.getAttribute("BTN_UPDATE_CLICKED", request);
			   Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
			   
			   //STGAP00013838: when we access "Foster Care Goal/Step Detail" page 
			        //through "WTLP" page or "Foster Care Case Plan Child" page  there is no update button, hence 
			        //we have to initialize "updateClicked" to false.
			        if (updateClicked == null) {
			          updateClicked = false;
			        }
			        if (copyClicked == null) {
			          copyClicked = false;
			        }
			        
         		 if(idEvent == 0 || updateClicked || copyClicked){
         				displayAddBtn = ArchitectureConstants.TRUE ;
          			}else{
          					displayAddBtn = ArchitectureConstants.FALSE;  
          				 }

      out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
      //  impact:ButtonTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
      _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ButtonTag_0.setParent(null);
      _jspx_th_impact_ButtonTag_0.setName("btnAddNewSecGoals");
      _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
      _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
      _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
      _jspx_th_impact_ButtonTag_0.setAlign("right");
      _jspx_th_impact_ButtonTag_0.setForm( includingFormName );
      _jspx_th_impact_ButtonTag_0.setAction("/serviceDelivery/FosterCareSecGoals/addFosterCareSecGoals");
      _jspx_th_impact_ButtonTag_0.setDisabled( displayAddBtn );
      _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
      int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
      if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
}

  
      out.write("\r\n\r\n\r\n\r\n\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnIdFosterCareSecGoals");
    _jspx_th_impact_validateInput_0.setValue("0");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
