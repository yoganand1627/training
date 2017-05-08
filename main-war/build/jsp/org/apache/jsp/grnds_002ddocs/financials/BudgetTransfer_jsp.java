package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class BudgetTransfer_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Budget Transfer
//*  Created by:   Paul Lang
//*  Date Created: 01/10/03
//*
//*  Description:
//*  This JSP is is used to tranfer funds between different expense catagories within a contract.
//*  This page is accessed through The Contract Header JSP. This JSP returns to the Contract Header upon Save
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/10/03  Paul Lang         Pasted the template into this JSP.
//**

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

String pageMode = PageMode.getPageMode( request );


      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmBudgetTransfer");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/saveBudgetTransfer");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.BudgetTransferCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n /*\r\n  *This function is called before the page unloads. It creates the\r\n  *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n  function confirmBudgetTrasfer()\r\n{\r\n  confirm(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_CONFIRM_AMENDMENT));
          out.write("\");\r\n}\r\n</script>\r\n\r\n");


BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
CCON09SO ccon09so = (CCON09SO) state.getAttribute("CCON09SO", request);
ROWCCON09SOG00_ARRAY budgetTransferArray = null;
ROWCCON09SOG00 budgetTransferRow = null;
if ( ccon09so == null )
{
  ccon09so = new CCON09SO();
}
if ( ccon09so.getROWCCON09SOG00_ARRAY() != null )
{
  budgetTransferArray = ccon09so.getROWCCON09SOG00_ARRAY();
}
else
{
  budgetTransferArray = new ROWCCON09SOG00_ARRAY();
}

double ulAmtCnsvcEquip = 0.0;
double ulAmtCnsvcEquipUsed = 0.0;
double ulAmtCnsvcFrgBenft = 0.0;
double ulAmtCnsvcFrgBenftUsed = 0.0;
double ulAmtCnsvcOther = 0.0;
double ulAmtCnsvcOtherUsed = 0.0;
double ulAmtCnsvcSalary = 0.0;
double ulAmtCnsvcSalaryUsed = 0.0;
double ulAmtCnsvcSupply = 0.0;
double ulAmtCnsvcSupplyUsed = 0.0;
double ulAmtCnsvcTravel = 0.0;
double ulAmtCnsvcTravelUsed = 0.0;
double ulAmtCnsvcUnitRate = 0.0;
double ulAmtCnsvcUnitRateUsed = 0.0;
double ulAmtCnsvcAdminAllUsed = 0.0;
double ulNbrCnsvcLineItem = 0.0;
String szCdCnsvcPaymentType = "";
String szCdCnsvcService = "";


int tabIndex = 1;
int loopCount = 0;

          out.write("\r\n\r\n");
 out.println("Version: " + GlobalData.getUlNbrCnverVersion(request)); 
          out.write("\r\n\r\n\r\n  <div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n                  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n                          <tr>\r\n                            <th class=\"thList\">From</th>\r\n                            <th class=\"thList\">To</th>\r\n                            <th class=\"thList\">CSLI</th>\r\n                            <th class=\"thList\">Service</th>\r\n                            <th class=\"thList\">Category</th>\r\n                            <th class=\"thList\">Total Amount</th>\r\n                            <th class=\"thList\">Budget Balance</th>\r\n                          </tr>\r\n ");


//IF the payment type (szCdCnsvcPaymentType) is equal to URT or VUR then the 6 categories below don't populate
//in the list and the category "Unit Rate" appears instead. Unit Rate is equal to ulAmtCnsvcUnitRate for the Total Amount column
//and Budget Balance is equal to ulAmtCnsvcUnitRate - ulAmtCnsvcUnitRateUsed. Else populate the 6 categories for the CRM payment type.

   Enumeration budgetTransferEnumeration = budgetTransferArray.enumerateROWCCON09SOG00();
if ( !budgetTransferEnumeration.hasMoreElements() )
{
 
          out.write("\r\n                       <tr class=\"odd\">\r\n                         <td colspan=\"7\">\r\n                            ");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("\r\n                         </td>\r\n                       </tr>\r\n ");

   }
   else
   {
     int rowCount = 0;
     while( budgetTransferEnumeration.hasMoreElements() )
     {
       budgetTransferRow = (ROWCCON09SOG00) budgetTransferEnumeration.nextElement();
       if ( !CodesTables.CCONPAY_URT.equals( budgetTransferRow.getSzCdCnsvcPaymentType() ) &&
            !CodesTables.CCONPAY_VUR.equals( budgetTransferRow.getSzCdCnsvcPaymentType() )
          )
       {
         String[][] category = {
         { "Salary" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSalary() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSalary()   - budgetTransferRow.getUlAmtCnsvcSalaryUsed() ) } ,
         { "Fringe" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcFrgBenft() ) , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcFrgBenft() - budgetTransferRow.getUlAmtCnsvcFrgBenftUsed() ) } ,
         { "Travel" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcTravel() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcTravel()   - budgetTransferRow.getUlAmtCnsvcTravelUsed() ) } ,
         { "Supply" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSupply() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSupply()   - budgetTransferRow.getUlAmtCnsvcSupplyUsed() ) } ,
         { "Equip" ,  FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcEquip() )    , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcEquip()    - budgetTransferRow.getUlAmtCnsvcEquipUsed() ) }  ,
         { "Other" ,  FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcOther() )    , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcOther()    - budgetTransferRow.getUlAmtCnsvcOtherUsed() - budgetTransferRow.getUlAmtCnsvcAdminAllUsed() ) } };

       for ( int i = 0 ; i < category.length ; i++)
       {
 
          out.write("\r\n                         <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n                           ");
 String radioId1 = category[i][0] + "_" + rowCount; String radioId2 = category[i][0] + "_" + rowCount; 
          out.write("\r\n                             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setId(radioId1);
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setName("rbBudgetTransferFrom");
          _jspx_th_impact_validateInput_0.setValue(radioId1);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setId(radioId2);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setName("rbBudgetTransferTo");
          _jspx_th_impact_validateInput_1.setValue(radioId2);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                             <td>");
          out.print( budgetTransferRow.getUlNbrCnsvcLineItem() );
          out.write("</td>\r\n                             <td>");
          out.print( budgetTransferRow.getSzCdCnsvcService() );
          out.write("</td>\r\n                             <td>");
          out.print( category[i][0] );
          out.write("</td>\r\n                             <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtTotalAmount" +  category[i][0] + rowCount );
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( category[i][1] );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                             <td>");
          out.print( category[i][2] );
          out.write("</td>\r\n                          </tr>\r\n ");

         loopCount++;
       }
     }
     else
     {
       double unitRateTotal = budgetTransferRow.getUlAmtCnsvcUnitRate();
       double unitRateBalance = budgetTransferRow.getUlAmtCnsvcUnitRate() - budgetTransferRow.getUlAmtCnsvcUnitRateUsed();
       String unitRateTotalString = FormattingHelper.formatMoney( unitRateTotal );
       String unitRateBalanceString = FormattingHelper.formatMoney( unitRateBalance );
 
          out.write("\r\n       <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n         ");
 String radioId1 = "UnitRate" + "_" + rowCount; String radioId2 = "UnitRate" + "_" + rowCount; 
          out.write("\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setId(radioId1);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setName("rbBudgetTransferFrom");
          _jspx_th_impact_validateInput_2.setValue(radioId1);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setId(radioId2);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setName("rbBudgetTransferTo");
          _jspx_th_impact_validateInput_3.setValue(radioId2);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n           <td>");
          out.print( budgetTransferRow.getUlNbrCnsvcLineItem() );
          out.write("</td>\r\n           <td>");
          out.print( budgetTransferRow.getSzCdCnsvcService() );
          out.write("</td>\r\n           <td>Unit Rate</td>\r\n           <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtTotalAmount" + rowCount );
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( unitRateTotalString );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n           <td>");
          out.print( unitRateBalanceString );
          out.write("</td>\r\n        </tr>\r\n  ");

  loopCount++;
     }
     rowCount++;
   } // end while
  } // end else
 
          out.write("\r\n\r\n                  </table>\r\n              </div>");
 /* this is where the "scrollBar" div tag ends */ 
          out.write('\r');
          out.write('\n');
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n <tr>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Amount");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setConstraint("Money");
          _jspx_th_impact_validateInput_4.setName("txtUlIdTransferAmount");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue("");
          _jspx_th_impact_validateInput_4.setSize("15");
          _jspx_th_impact_validateInput_4.setMaxLength("50");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnTransfer");
          _jspx_th_impact_ButtonTag_0.setImg("btnTransfer");
          _jspx_th_impact_ButtonTag_0.setForm("frmBudgetTransfer");
          _jspx_th_impact_ButtonTag_0.setFunction("javascript:confirmBudgetTrasfer()");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/saveBudgetTransfer");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
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
}
