package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class TaskList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
 /* Import PageMode and other utilities used on the page - Should be on every page */ 
      out.write("\r\n\r\n\r\n\r\n\r\n");
/* Import needed for Messages */ 
      out.write("\r\n\r\n\r\n");
/* Import needed for Form Launch */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  /* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
     to see how the page functions, but it should always be initialized to view mode.
     String pageMode = PageMode.VIEW;  */
  String pageMode = PageModeConstants.EDIT;
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  }
  /* Everything above this point should be in EVERY PAGE. *****************************************************************/
  /* Assign tab-index */
  int tabIndex = 1;

      out.write("\r\n<script type=\"text/javascript\">\r\nfunction populateForm ( stageID, taskCD )\r\n{\r\n  frmTaskList.txtUlIdStage.value = stageID;\r\n  frmTaskList.txtSzCdTask.value = taskCD;\r\n}\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmTaskList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/template/DetailTemplate/save");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<div align=\"center\"><font size=\"1\" color=\"#800080\" ><blink>Stephan's Task List Placeholder Page\r\n- Soon to be known as the Navigational Metaphor</blink></font></div>\r\n\r\n <br><!--- GlobalData.getSzCdStage( request ) ====  --->\r\n");
 // GlobalData.getSzCdStage( request ) 
          out.write("\r\n<!--- ccmn45so ==== --->\r\n");

CCMN45SO ccmn45so = (CCMN45SO) request.getAttribute("CCMN45SO");
if ( ccmn45so != null )
{
  // out.println( ccmn45so );
}
else
{
        ccmn45so = new CCMN45SO();
  out.println( "ccmn45so == null" );
}

          out.write("<br>\r\n\r\n");


ROWCCMN45SOG00_ARRAY rowArray = null;

 if ( ccmn45so.getROWCCMN45SOG00_ARRAY() != null )
  {
    rowArray = ccmn45so.getROWCCMN45SOG00_ARRAY();
  }
 else
  {
    rowArray = new ROWCCMN45SOG00_ARRAY();
  }


          out.write("<br><br>\r\n<table align=\"center\" width=\"100%\" bgcolor=\"#808080\" >\r\n<tr>\r\n  <td width=\"50%\">\r\n<table align=\"center\" width=\"100%\" border=\"1\" bgcolor=\"#c0c0c0\" bordercolor=\"#808080\" cellpadding=\"5\">\r\n<tr>\r\n  <td bgcolor=\"#0000ff\"><font color=\"#FFFFFF\"><strong>Task Name</strong></font></td>\r\n</tr>\r\n");

//Declare the loop counter
 int loopCount = 1;
 ROWCCMN45SOG00 row = null;
//Declare the enumeration and call the enumerateXXX() method on the array object you initialized in Step 10.
 Enumeration taskEnumeration = rowArray.enumerateROWCCMN45SOG00();

                   if ( !taskEnumeration.hasMoreElements() )
                  {

          out.write("\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("</td>\r\n</tr>\r\n");

                  }
                    else
                  {
                  while ( taskEnumeration.hasMoreElements() )
                    {
                      row = (ROWCCMN45SOG00) taskEnumeration.nextElement();

          out.write("\r\n\r\n<tr>\r\n  <td bgcolor=\"#ffffff\"><a href=\"javascript: populateForm( '");
          out.print( GlobalData.getUlIdStage( request ) );
          out.write("', '");
          out.print( row.getSzCdTask() );
          out.write("' )\">");
          out.print( row.getSzTxtTaskDecode() );
          out.write("</a></td>\r\n</tr>\r\n");

                     loopCount++;
                    } // end while
                  }

          out.write("\r\n</table>\r\n</td>\r\n<td>\r\n<table border=\"1\" bordercolor=\"#c0c0c0\" bgcolor=\"#ffffff\" height=\"100%\" width=\"100%\" border=\"0\" cellpadding=\"7\" cellspacing=\"0\">\r\n  <tr>\r\n    <td >Task Code:&nbsp;</td>\r\n    <td><input type=\"text\" size=\"25\" name=\"txtSzCdTask\" value=\"\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td >Stage ID:&nbsp;</td>\r\n    <td><input type=\"text\" size=\"20\" name=\"txtUlIdStage\" value=\"\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\"><br><br><br><br><br><br><br><br><br><br>\r\n  <div align=\"right\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSubmit");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setImg("btnSubmit");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmTaskList");
          _jspx_th_impact_ButtonTag_0.setAction("/common/TaskList/navigateTask");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</div>\r\n  </td>\r\n  </tr>\r\n</table>\r\n\r\n</td>\r\n</table>\r\n<br><br>\r\n<table border=\"1\" bgcolor=\"#c0c0c0\" bordercolor=\"#808080\" cellpadding=\"5\">\r\n<tr>\r\n  <td colspan=\"2\"><strong>ccmn45so</strong></td>\r\n</tr>\r\n<tr>\r\n  <td bgcolor=\"#ffffff\">ccmn45so.getDtDtStageClose()</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( FormattingHelper.formatDate( ccmn45so.getDtDtStageClose() ) );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td bgcolor=\"#ffffff\">ccmn45so.getArchOutputStruct()</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( ccmn45so.getArchOutputStruct() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">ccmn45so.getROWCCMN45SOG00_ARRAY()</td>\r\n  <td bgcolor=\"#ffffff\">");
// ccmn45so.getROWCCMN45SOG00_ARRAY() 
          out.write("</td>\r\n</tr>\r\n");

                   taskEnumeration = rowArray.enumerateROWCCMN45SOG00();
                   if ( !taskEnumeration.hasMoreElements() )
                  {

          out.write("\r\n<tr>\r\n  <td colspan=\"2\" valign=\"top\" bgcolor=\"#ffffff\">");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("</td>\r\n</tr>\r\n");

                  }
                    else
                  {
                  while ( taskEnumeration.hasMoreElements() )
                    {
                      row = (ROWCCMN45SOG00) taskEnumeration.nextElement();

          out.write("\r\n\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"yellow\">row.getSzTxtTaskDecode()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"yellow\">");
          out.print( row.getSzTxtTaskDecode() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">row.getUlIdEvent()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( row.getUlIdEvent() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">row.getSzCdTask()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( row.getSzCdTask() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">row.getSzCdEventType()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( row.getSzCdEventType() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">row.getSzCdEventStatus()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( row.getSzCdEventStatus() );
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\" bgcolor=\"#ffffff\">row.getSzCdTaskPrior()");
          out.print( loopCount );
          out.write("</td>\r\n  <td bgcolor=\"#ffffff\">");
          out.print( row.getSzCdTaskPrior() );
          out.write("</td>\r\n</tr>\r\n");

                     loopCount++;
                    } // end for
                  }

          out.write("\r\n\r\n\r\n</table>\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
}
