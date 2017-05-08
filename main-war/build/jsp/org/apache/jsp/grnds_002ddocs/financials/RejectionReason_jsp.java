package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.Enumeration;

public final class RejectionReason_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Rejection Reason
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/20/2002
//*
//*  Description:
//*  This JSP is used view Rejection Reasons
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------


      out.write('\n');
      out.write('\n');
      out.write('\n');

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\n\n\n\n\n\n\n\n\n\n\n\n");
// Import needed for Form Launch


//Get the output object from the request
CFIN09SO cfin09so = (CFIN09SO) request.getAttribute("CFIN09SO");
ROWCFIN09SOG00_ARRAY rejectionArray = null;

if (cfin09so == null) {
 cfin09so = new CFIN09SO();
}

if (cfin09so.getROWCFIN09SOG00_ARRAY() == null) {
  rejectionArray = new ROWCFIN09SOG00_ARRAY();
} else {
  rejectionArray = cfin09so.getROWCFIN09SOG00_ARRAY();
 }

      out.write('\n');
 // Start Javascript Section

      out.write("\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\n</script>\n");
 //End Javascript Section

      out.write('\n');
      out.write('\n');

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;


  //Initialize the variables that will specify the display rules for individual fields

  int loopCount=0;
  ROWCFIN09SOG00 rejectionRow = null;
  Enumeration rejectionEnumeration = rejectionArray.enumerateROWCFIN09SOG00();

      out.write("\n\n                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorderList\">\n                           <tr>\n                           <th class=\"thList\">RR</th>\n                           <th class=\"thList\">Rejection Reason</th>\n                        </tr>\n");

                  if ( !rejectionEnumeration.hasMoreElements() )
                  {

      out.write("\n                      <tr class=\"odd\">\n                        <td colspan=\"10\">\n                           ");
      out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
      out.write("\n                        </td>\n                      </tr>\n");

                  }
                    else
                  {
                    while ( rejectionEnumeration.hasMoreElements() )
                    {
                      rejectionRow = (ROWCFIN09SOG00) rejectionEnumeration.nextElement();


      out.write("\n                        <tr class=\"");
      out.print(FormattingHelper.getRowCss( loopCount + 1 ));
      out.write("\" valign=\"top\">\n                            <td>");
      out.print( rejectionRow.getSzCdRejRsn() );
      out.write("</td>\n                            <td>");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CRJCTRSN, rejectionRow.getSzCdRejRsn()));
      out.write("</td>\n                        </tr>\n");

                     loopCount++;
                    } // end for
                  }

      out.write("\n           </table>\n\n\n\n\n\n");
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
