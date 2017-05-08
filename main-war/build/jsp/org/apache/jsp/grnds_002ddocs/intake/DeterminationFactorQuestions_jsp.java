package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

public final class DeterminationFactorQuestions_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Determination Factor Questions
//*  Created by:   Vishala Devarakonda
//*  Date Created: 06/08/2008
//*
//*  Description:
//*  This JSP will be used to display Determination Factor questions
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  
//**                              

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>Determination Factor Questions</title>\r\n</head>\r\n\r\n<body bgcolor=\"#FFFFFF\" text=\"#000000\">\r\n\r\n");

  String hdnDetFaqType = request.getParameter("hdnDetFaqType");
  hdnDetFaqType = URLHelper.decode(hdnDetFaqType);
  String codeType = "";
  if(CodesTables.CABALTYP_PP.equals(hdnDetFaqType)){
    codeType = CodesTables.CPDETFAQ;
  }else if(CodesTables.CABALTYP_NN.equals(hdnDetFaqType)){
    codeType = CodesTables.CNDETFAQ;
  }else if(CodesTables.CABALTYP_EE.equals(hdnDetFaqType)){
    codeType = CodesTables.CEDETFAQ;
  }else if(CodesTables.CABALTYP_SS.equals(hdnDetFaqType)){
    codeType = CodesTables.CSDETFAQ;
  }
  if(!"".equals(codeType)){
       Iterator<CodeAttributes> codeAttributes = (Iterator<CodeAttributes>)Lookup.getCategoryListing(codeType);
            if(codeAttributes!=null){
            int loopCount = 1;
              while(codeAttributes.hasNext()){
                CodeAttributes codeAttr = codeAttributes.next();
                String decode = codeAttr.getDecode();
                  out.write(loopCount + "." + decode);
                  out.write("<br>");
                  loopCount++;
              }
            }
  }


      out.write("\r\n\r\n</body>\r\n\r\n</html>\r\n");
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
