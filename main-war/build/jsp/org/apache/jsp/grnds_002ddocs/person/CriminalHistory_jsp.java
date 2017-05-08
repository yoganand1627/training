package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class CriminalHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Criminal History
//*  Created by:   Katy Laura
//*  Date Created: 12/03/02
//*
//*  Description:
//*  This JSP called from the Records Check List page and the Records Check Detail
//*  using the Results hyperlink on the List page or the Results button on the Detail page
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//** 06/28/04  LAURAMC           When the status code of a DPS Criminal history is
//**                             paper only, it did not appear on the Records Check
//**                             or Criminal History pages.  SIR 22956 extends the
//**                             check on the status code to include paper only , I,
//**                             K and Q and to present a message on this JSP if found.
//**  10/13/04  CORLEYAN         SIR 23211 - If we are in set A, disable the Accept/Reject
//**                             Radio Button, comments box, and save button
//**  2/11/05   gerryc           SIR 23404 - changed the form action and pagination
//**                             to go to displayCriminalHistory instead of
//**                             resultsRecordsCheck.
//**  8/29/05  berkime           SIR 23636: added an if statment if front of the narrative tag
//**                             so that if no hit is returned then do not display the narrative
//**                             button
//**

      out.write("\r\n\r\n\r\n\r\n");
 /* Import xmlstructs used on the page.  */
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
    // define state
  BaseSessionStateManager state = ( BaseSessionStateManager ) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      // initialize page mode;
  String pageMode = PageModeConstants.VIEW;
  //get mode from state;  You can come to this page only in edit/modify mode
  pageMode = ( String ) state.getAttribute( "pageMode", request );
      // recreate the output object constructed in the resultsRecordsCheck method
   //QA CCFC31SO ccfc31so = ( CCFC31SO ) request.getAttribute( "CCFC31SO" );
  CCFC31SO ccfc31so = ( CCFC31SO ) state.getAttribute( "CCFC31SO", request );
      //initialize the array
  ROWCCFC31SOG00_ARRAY resultsArray = null;
      //null catch for the aray of rows
  if ( ccfc31so == null )
      {
       ccfc31so = new CCFC31SO() ;
       }
  int count = 0;
      //null catch for row objects, if not null, get rows
  if ( ccfc31so.getROWCCFC31SOG00_ARRAY() != null )
     {
       resultsArray = ccfc31so.getROWCCFC31SOG00_ARRAY();
       count = resultsArray.getUlRowQty();
     }  else
     {
       resultsArray = new ROWCCFC31SOG00_ARRAY();
      }
    // define a row within the array
  //ROWCCFC26SOG00 recordsCheckRow = ( ROWCCFC26SOG00 ) request.getAttribute( "recordsCheckRow" );
  int index = ContextHelper.getIntSafe( request, "hdnIndex" );
    // recreate object, array and row for records_check from the request
  CCFC26SO ccfc26so = ( CCFC26SO ) state.getAttribute( "CCFC26SO", request );
  if( ccfc26so == null )
  {
    ccfc26so = new CCFC26SO();
  }
  ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
  if( ccfc26so.getROWCCFC26SOG00_ARRAY() != null )
  {
    listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
  }
  ROWCCFC26SOG00 recordsCheckRow = listArray.getROWCCFC26SOG00( index );
  if ( recordsCheckRow == null )
  {
    recordsCheckRow = new ROWCCFC26SOG00();
  }
     // define string variables for ulIdRecCheck, status of the records check, and dates requested and completed
        // for use in displaying the page and passing in hidden fields

   String txtStatus = StringHelper.getNonNullString( recordsCheckRow.getSzCdRecCheckStatus() );
   String dtRequest = FormattingHelper.formatDate( recordsCheckRow.getDtDtRecCheckRequest() );

   String dtCompleted = FormattingHelper.formatDate( recordsCheckRow.getDtDtRecCheckCompleted() );
  //Declare and initialize display variables
  // Assign table index and loop Counter
   int tabIndex = 1;
   int loopCount = 0;

  try
  {


      out.write('\r');
      out.write('\n');
 /*java script with window.onbefore used to confirm data will be lost if user exits before saving */
      out.write("\r\n\r\n    <script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n    <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n//  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n// called by onClick of Save button - verify that the user knows there a rows which have not been accepted or rejected\r\nfunction checkForUnalteredRows( lpCount )\r\n{\r\n  var bUnchecked = \"false\";\r\n  var continueWithSave = \"true\";\r\n  var myForm = document.frmCriminalHistory;\r\n  for ( var i = 0; i < lpCount; i++ )\r\n  {\r\n    var rb = eval(\"myForm.rbAcpRej\" + i );\r\n\r\n    // checking for type = radio because disabled radio button values are\r\n    // stored in hidden fields\r\n    if  ( (rb.type == \"radio\") && (!rb[0].checked ) && ( !rb[1].checked ) )\r\n    {\r\n      bUnchecked = \"true\";\r\n      break;\r\n    }\r\n  }\r\n  if ( bUnchecked == \"true\" )\r\n  {\r\n    continueWithSave = confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SUB_CRIMHIS_DECISION ));
      out.write("\" );\r\n  }\r\n  return continueWithSave;\r\n} // end checkForUnalteredRows\r\n\r\n// prior to leaving the main form, by clicking the document button, the user selected radio button ( the ulIdCrimnal History row )is set in the document button\r\nfunction setNarrativeParams()\r\n{\r\n  if ( document.frmCriminalHistory.rbCHRow_CLEAN[0] )\r\n  {\r\n    for (var i = 0; i < document.frmCriminalHistory.rbCHRow_CLEAN.length; i++)\r\n    {\r\n      if ( document.frmCriminalHistory.rbCHRow_CLEAN[i].checked )\r\n      {\r\n      document.frmCriminalHistoryNarrative.pCrimHist.value = document.frmCriminalHistory.rbCHRow_CLEAN[i].value;\r\n      //alert( document.frmCriminalHistoryNarrative.pCrimHist.value );\r\n      break;\r\n    }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    document.frmCriminalHistoryNarrative.pCrimHist.value = document.frmCriminalHistory.rbCHRow_CLEAN.value;\r\n  }\r\n} //end setNarrativeParams\r\n\r\n// The user wants to view the documents from dps.  Verify that a row has been selected via the CH radio button\r\n   // NOTE: When a radio button is selected, the setNarrativeParams () is called to set a ulIdCrimHist value in pCrimHist.\r\n");
      out.write("         // So if it is still bland, no row was identified by rb.\r\n  function verifyPCrimHistValue()\r\n  {\r\n  if ( document.all.frmCriminalHistoryNarrative.pCrimHist.value == \"\" )\r\n   {\r\n    alert ( '");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_RADIO_BUTTON ));
      out.write("' );\r\n    return false;\r\n   }\r\n   return true;\r\n  }\r\n </script>\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCriminalHistory");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/RecordsCheck/displayCriminalHistory");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.CriminalHistoryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

  TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean)request.getAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
  if( tuxPagination != null )
  {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  }
  else
  {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(RecordsCheckConversation.PAGE_SIZE);
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination );
  }

          out.write("\r\n   ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/person/RecordsCheck/displayCriminalHistory");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n");
              out.write("\r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n     <tr>\r\n      <th class=\"thList\">&nbsp;</th>\r\n      <th class=\"thList\">Search Name</th>\r\n      <th class=\"thList\">Date of Request</th>\r\n      <th class=\"thList\">Date Completed</th>\r\n      <th class=\"thList\">Status</th>\r\n      <th class=\"thList\">Acp/Rej</th>\r\n      <th class=\"thList\"><font class=\"formCondRequiredText\">&#135;</font>Comments</th>\r\n     </tr>\r\n     <tr>\r\n         ");
 // within the table, display the data
            //Enumerate the records check rows
          Enumeration resultsEnum = resultsArray.enumerateROWCCFC31SOG00();
          String lineCount = String.valueOf( resultsArray.getROWCCFC31SOG00Count() );
          
              out.write("\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_0.setType("hidden");
              _jspx_th_impact_validateInput_0.setName("hdnLineCount");
              _jspx_th_impact_validateInput_0.setValue( String.valueOf(lineCount) );
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_1.setType("hidden");
              _jspx_th_impact_validateInput_1.setName("hdnCHArrayLength");
              _jspx_th_impact_validateInput_1.setValue( String.valueOf(count) );
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");

            //If the enumeration is empty return NO Rows returned message
      if ( !resultsEnum.hasMoreElements() )
             { 
              out.write("\r\n      <tr class=\"odd\">\r\n        <td>&nbsp;</td>\r\n        <td>\r\n        ");
 /* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History
              LAURAMC SIR 22956 - extend "O".equals (Overdue from DPS) to test for paper only, "I",
              "K" and "Q"  */ 
              out.write("\r\n          ");
 if ( "O".equals( request.getParameter ("hdnType") ) )
             {
           
              out.write("\r\n            ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_DPS_CHECK_OVERDUE ) );
              out.write("\r\n          ");
 }
             else if ( "I".equals( request.getParameter ("hdnType") )
                         ||
                       "K".equals( request.getParameter ("hdnType") )
                         ||
                       "Q".equals( request.getParameter ("hdnType") )    )
             {
           
              out.write("\r\n            ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_PAPER_ONLY ) );
              out.write("\r\n             ");
 }
             else if ( "E".equals( request.getParameter ("hdnType") ) )
             {
           
              out.write("\r\n            ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_DPS_RESPONSE_ERROR ) );
              out.write("\r\n             ");
 }   else {
              out.write("\r\n            ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_HIT_RETURNED ) );
              out.write("\r\n          ");
 } 
              out.write("\r\n          ");
  String dtReq2 = ContextHelper.getStringSafe( request, "hdnDtReq" );
              String dtComp2 = ContextHelper.getStringSafe( request, "hdnDtComp" );
              String dtReq = request.getParameter( "hdnDtReq" );
              String dtComp = request.getParameter( "hdnDtComp" ); 
              out.write("\r\n        </td>\r\n        <td>");
              out.print( dtReq );
              out.write("</td>\r\n        <td colspan=\"4\">");
              out.print( dtComp );
              out.write("</td>\r\n      </tr>\r\n     ");

             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( resultsEnum.hasMoreElements() )
                  {     // get the next element
                     ROWCCFC31SOG00 resultsRow = ( ROWCCFC31SOG00 ) resultsEnum.nextElement();
                        // create the cells and place the elements in them

     
              out.write("\r\n     <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"center\">\r\n         <td> ");
/* show a radio button*/
         boolean bCHDisabled = false;
           if ("REJ".equals(resultsRow.getSzCdCrimHistAction()) )
               {
                 bCHDisabled = true;
               }
              out.write("\r\n               ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_2.setTabIndex( tabIndex ++ );
              _jspx_th_impact_validateInput_2.setValue( String.valueOf( resultsRow.getUlIdCrimHist() ));
              _jspx_th_impact_validateInput_2.setChecked("false");
              _jspx_th_impact_validateInput_2.setDisabled( String.valueOf( bCHDisabled ));
              _jspx_th_impact_validateInput_2.setType("radio");
              _jspx_th_impact_validateInput_2.setName("rbCHRow_CLEAN");
              _jspx_th_impact_validateInput_2.setOnClick("setNarrativeParams()");
              _jspx_th_impact_validateInput_2.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
              if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n\r\n         <td>");
              out.print( FormattingHelper.formatString( resultsRow.getSzNmCrimHistReturned() ));
              out.write("\r\n         </td>\r\n         <td> ");
              out.print( String.valueOf( dtRequest ));
              out.write("\r\n         </td>\r\n         <td> ");
              out.print( String.valueOf( dtCompleted ));
              out.write("\r\n         </td>\r\n         <td>  ");
              out.print(Lookup.simpleDecodeSafe( "CCRIMSTA", txtStatus ) );
              out.write("\r\n         </td>\r\n");

    boolean bAcp = false;
    boolean bRej = false;
    boolean bDis = false; // 23211

    String rbName = "rbAcpRej" + loopCount;
    String rowCommentsName = "rowComments" + String.valueOf( loopCount );

          if ("ACP".equals(resultsRow.getSzCdCrimHistAction()) )
          {
           bAcp = true;
          }
          if ("REJ".equals(resultsRow.getSzCdCrimHistAction()))
          {
            bRej = true;
          }
          // If the row has been rejected, or we are in page set A,
          // disable the Accept/Reject radio button, and the comments box.
          if (bRej || Sets.isInSet( Sets.A, request ))
          {
            bDis = true;
          }


              out.write("\r\n        <td>\r\n          <table order=\"0\" cellspacing=\"0\" cellpadding=\"3\"  width=\"100%\" >\r\n               <tr>  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_3.setTabIndex( tabIndex ++ );
              _jspx_th_impact_validateInput_3.setChecked( String.valueOf( bAcp ));
              _jspx_th_impact_validateInput_3.setValue("ACP");
              _jspx_th_impact_validateInput_3.setLabel("Accept");
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setDisabled( String.valueOf( bDis ));
              _jspx_th_impact_validateInput_3.setName( rbName);
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n               </tr>\r\n\r\n               <tr>  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex ++ );
              _jspx_th_impact_validateInput_4.setChecked( String.valueOf( bRej ));
              _jspx_th_impact_validateInput_4.setValue("REJ");
              _jspx_th_impact_validateInput_4.setLabel("Reject");
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setDisabled( String.valueOf( bDis ));
              _jspx_th_impact_validateInput_4.setName( rbName );
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n               </tr>\r\n           </table>\r\n        </td>\r\n\r\n       <td valign=\"top\"><!--- Text Area Custom Tag --->\r\n            ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateTextArea_0.setName( rowCommentsName);
              _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( bDis ));
              _jspx_th_impact_validateTextArea_0.setColspan("2");
              _jspx_th_impact_validateTextArea_0.setRows("2");
              _jspx_th_impact_validateTextArea_0.setCols("20");
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString( resultsRow.getSzTxtCrimHistCmnts() ) );
                  out.write("\r\n            ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n   </tr>\r\n         ");
  loopCount++;
             } // end while
           } //end else
          
              out.write("\r\n  </table>\r\n     ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
  // place the save button within a table to control alignment
 
          out.write("\r\n   <table class=\"alignRight\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\"  width=\"100%\" >\r\n     <tr>\r\n        <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setFunction("return checkForUnalteredRows(" + loopCount + ")");
          _jspx_th_impact_ButtonTag_0.setForm("frmCriminalHistory");
          _jspx_th_impact_ButtonTag_0.setAction("/person/RecordsCheck/saveCriminalHistory");
          _jspx_th_impact_ButtonTag_0.setDisabled( Sets.isInSetStr( Sets.A , request ) );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n     </tr>\r\n   </table>\r\n\r\n     ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnIndex");
          _jspx_th_impact_validateInput_9.setValue( request.getParameter ("hdnIndex"));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnCrimHistArrayLength");
          _jspx_th_impact_validateInput_10.setValue( String.valueOf( loopCount ));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 // set up to display narrative
  String displayDoc = "";
if ( state.getAttribute( "docType", request ) != null )
{
   displayDoc = ( String ) state.getAttribute( "docType", request );
} 
      out.write("\r\n<table class=\"alignRight\" width=\"100%\">\r\n <tr>\r\n    <td>\r\n    ");
//SIR 23636 added the ifThen logic 
      out.write("\r\n    ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( !("N".equals(request.getParameter("hdnType"))) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    ");
          //  impact:documentButton
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
          _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_documentButton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_documentButton_0.setPageMode( pageMode );
          _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
          if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:document
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
              _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
              _jspx_th_impact_document_0.setName("frmCriminalHistoryNarrative");
              _jspx_th_impact_document_0.setOnClick("verifyPCrimHistValue();");
              _jspx_th_impact_document_0.setDisplayName("DPS");
              _jspx_th_impact_document_0.setProtectDocument(false);
              _jspx_th_impact_document_0.setCheckStage( GlobalData.getUlIdStage( request ) );
              _jspx_th_impact_document_0.setDocType("ccf12o00");
              _jspx_th_impact_document_0.setPostInSameWindow(false);
              _jspx_th_impact_document_0.setCheckForNewMode(false);
              _jspx_th_impact_document_0.setAction("/person/RecordsCheck/displayDocument");
              _jspx_th_impact_document_0.setDocExists(false);
              int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
              if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n             ");
                  if (_jspx_meth_impact_documentParameter_0(_jspx_th_impact_document_0, _jspx_page_context))
                    return;
                  out.write("\r\n             ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                  _jspx_th_impact_documentParameter_1.setName("pPerson");
                  _jspx_th_impact_documentParameter_1.setValue( String.valueOf( GlobalData.getUlIdPerson( request ) ) );
                  int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
                  if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n             ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                  _jspx_th_impact_documentParameter_2.setName("pCase");
                  _jspx_th_impact_documentParameter_2.setValue( String.valueOf( GlobalData.getUlIdCase( request ) ) );
                  int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
                  if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n       ");
                  int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n </tr>\r\n</table>\r\n");
      //  impact:showDocument
      gov.georgia.dhr.dfcs.sacwis.web.document.ShowDocumentTag _jspx_th_impact_showDocument_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.ShowDocumentTag();
      _jspx_th_impact_showDocument_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_showDocument_0.setParent(null);
      _jspx_th_impact_showDocument_0.setDocument( displayDoc );
      int _jspx_eval_impact_showDocument_0 = _jspx_th_impact_showDocument_0.doStartTag();
      if (_jspx_th_impact_showDocument_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

}  //end try
catch ( Exception e )
{
  e.printStackTrace();
  out.println( e.getMessage() );
}

      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("ulIdRecCheck");
    _jspx_th_impact_validateInput_5.setValue("recCheckId");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("szTxtStatus");
    _jspx_th_impact_validateInput_6.setValue("txtStatus");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("dtDtRecCheckRequest");
    _jspx_th_impact_validateInput_7.setValue("dtRequest");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("dtDtRecCheckCompleted");
    _jspx_th_impact_validateInput_8.setValue("dtCompleted");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
    _jspx_th_impact_documentParameter_0.setName("pCrimHist");
    _jspx_th_impact_documentParameter_0.setValue("");
    int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
    if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
