package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentButtonTag extends DocumentContainer {
  private static final String TRACE_TAG = "DocumentButtonTag";
  private static final String BUTTON_URL = "/grnds-docs/images/shared/btnNarrative.gif";
  private DocumentTag docTag = null;
  private String buttonUrl = null;
  private String buttonAltText = "Narrative";
  private int tabIndex;
  private String accessKey = "";

  public void addDoc(DocumentTag dt) {
    GrndsTrace.enterScope(TRACE_TAG + ".addDoc");
    this.docTag = dt;
    GrndsTrace.exitScope();
  }

  public DocumentTag getDoc() {
    return this.docTag;
  }

  public void setButtonUrl(String buttonUrl) {
    this.buttonUrl = buttonUrl;
    //Set the buttonAltText based on the name of the image.
    this.buttonAltText = buttonUrl.substring(buttonUrl.indexOf("btn") + 3, buttonUrl.length() - 4);
  }

  public String getButtonUrl() {
    return this.buttonUrl;
  }

  public void setTabIndex(int index) {
    this.tabIndex = index;
  }

  public int getTabIndex() {
    return this.tabIndex;
  }

  private String writeDisplayForm() {
    GrndsTrace.enterScope(TRACE_TAG + ".writeDisplayForm");
    GrndsTrace.msg(TRACE_TAG, 7, "Test buttonUrl");
    if (this.getButtonUrl() == null || this.getButtonUrl() == "") {
      // set it to the default
      this.setButtonUrl(BUTTON_URL);
    }

    GrndsTrace.msg(TRACE_TAG, 7, "start writing display form");
    StringBuffer displayHtml = new StringBuffer("");
    displayHtml.append("<form action=\"#\" method=\"post\" onsubmit=\"return submitDocumentButtonForm(this);\">");
    displayHtml.append("<input type=\"hidden\" name=\"hidDocType\" value=\"");
    if (docTag.getName() != null) {
      displayHtml.append(docTag.getName());
    } else {
      displayHtml.append(docTag.getDocType());
    }
    displayHtml.append("\">");
    String accessKeyAttribute = "";
    if ((this.accessKey != null) && !"".equals(this.accessKey)) {
      accessKeyAttribute = " accessKey=\"" + this.accessKey + "\" ";
    }
    displayHtml.append("<input type=\"image\" onclick=\"window.onbeforeunload=null;\" ").append(
            accessKeyAttribute).append(" tabindex=\"").append(this.getTabIndex()).append(
            "\" name=\"btnSubmit\" src=\"");
    displayHtml.append(this.getButtonUrl());
    //Add alt tag with substring of image name.
    displayHtml.append("\" alt=\"");
    displayHtml.append(this.buttonAltText);
    displayHtml.append("\">");

    if (this.getDoc().getDocExists()) {
      displayHtml.append(
              "&nbsp;&nbsp;&nbsp;<img src=\"/grnds-docs/images/shared/checkMark.gif\" alt=\"Checkmark\" border=\"0\">");
    }

    displayHtml.append("</form>");
    GrndsTrace.exitScope();
    return displayHtml.toString();
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    GrndsTrace.exitScope();
    return super.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");

    JspWriter out = pageContext.getOut();

    try {
      if (!this.getDoc().getHideInWidget()) {
        out.println(this.writeDisplayForm());
        GrndsTrace.msg(TRACE_TAG, 7, "Writing hidden document form");
        out.println(super.writeDocumentForm(this.getDoc()));
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

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getAccessKey() {
    return accessKey;
  }

}

