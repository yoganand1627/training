package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class ShowDocumentTag extends TagSupport {

  private String document = null;
  private static String TRACE_TAG = "ShowDocumentTag";

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    GrndsTrace.exitScope();
    return super.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");

    JspWriter out = pageContext.getOut();

    try {
      out.println(this.writePopUpJavaScript());

    }
    catch (IOException e) {
      throw new JspException("Exception generating " + TRACE_TAG + ": \n" + e.getMessage());
    }
    catch (NullPointerException npe) {
      try {
        out.println("NullPointerException in " + TRACE_TAG);
      }
      catch (IOException e) {
      }
    }

    GrndsTrace.exitScope();
    return super.EVAL_BODY_INCLUDE;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getDocument() {
    return this.document;
  }

  private String writePopUpJavaScript() {
    StringBuffer buffer = new StringBuffer("");
    String documentName = this.getDocument();
    if (documentName != null && documentName != "") {

      buffer.append("<form name=\"frmShowDocument\" style=\"display:none\">");
      buffer.append("<input type=\"hidden\" name=\"hidDocument\" value=\"");
      buffer.append(documentName);
      buffer.append("\"></form>");

      buffer.append("<script>this.onload=showDocument;");
      //  buffer.append("this.onload=showDocument('");
      //   buffer.append(documentName);
      //   buffer.append("');");
      buffer.append("</script>");
    }
    return buffer.toString();
  }

}