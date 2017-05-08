package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentListTag extends DocumentContainer {

  public static final String BUTTON_IMG = "/grnds-docs/images/shared/btnLaunch.gif";
  public static final String TRACE_TAG = "DocumentListTag";

  private List documents;
  private PageMode pageMode;
  private int tabIndex;
  private String label = null;

  public DocumentListTag() {
    super();
  }

  public void setTabIndex(int index) {
    this.tabIndex = index;
  }

  public int getTabIndex() {
    return this.tabIndex;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    this.initDocumentListTag();
    GrndsTrace.exitScope();
    return super.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");

    JspWriter out = pageContext.getOut();

    try {
      out.println(this.writeDisplayForm());

      Iterator docIterator = documents.iterator();

      while (docIterator.hasNext()) {
        DocumentTag dt = (DocumentTag) docIterator.next();
        if (!dt.getHideInWidget()) {
          out.println(super.writeDocumentForm(dt));
        }
      }

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
    return super.EVAL_PAGE;

  }

  private void initDocumentListTag() {
    this.documents = new ArrayList();
  }

  public void addDoc(DocumentTag documentTag) {
    documents.add(documentTag);
  }

  private String writeDisplayForm() {
    StringBuffer displayHtml = new StringBuffer("");

    displayHtml.append(
            "<form action=\"#\" method=\"post\" class=\"nomargins\" onsubmit=\"return submitDocumentListForm(this);\">");
    displayHtml.append("<table border=\"0\"><tr><td valign=\"middle\">");
    displayHtml.append("<label class=\"formLabel\" for=\"cboDocument_CLEAN\">");
    if (this.getLabel() != null) {
      displayHtml.append(this.getLabel());
    } else {
      displayHtml.append("Forms:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    }
    displayHtml.append("</label>");
    displayHtml.append("</td><td valign=\"top\">");
    displayHtml.append("<select class=\"nomargins\" name=\"cboDocument_CLEAN\" tabindex=\"").append(
            getTabIndex()).append("\" id=\"cboDocument\">");
    displayHtml.append(
            "<option selected value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>");
    Iterator iterator = documents.iterator();

    while (iterator.hasNext()) {
      DocumentTag docTag = (DocumentTag) iterator.next();
      if (!docTag.getHideInWidget()) {
        String docType = docTag.getDocType();
        String displayName = docTag.getDisplayName();
        displayHtml.append("<option value=\"");
        if (docTag.getName() != null) {
          displayHtml.append(docTag.getName());
        } else {
          displayHtml.append(docTag.getDocType());
        }
        displayHtml.append("\">");
        displayHtml.append(displayName);
        displayHtml.append("</option>");
      }
    }

    displayHtml.append("</select></td><td valign=\"bottom\">");

    displayHtml.append(
            "&nbsp;&nbsp;<input type=\"image\" alt=\"Launch\" onclick=\"window.onbeforeunload=null; \" tabindex=\"").append(
            getTabIndex()).append("\" border=\"0\" src=\"");
    displayHtml.append(BUTTON_IMG);
    displayHtml.append("\"></td></tr></table>");
    displayHtml.append("</form>");

    return displayHtml.toString();
  }

}