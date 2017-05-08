package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

public abstract class BaseDocListTag extends TagSupport implements DocListInterface {

  public static final String TRACE_TAG = "BaseDocListTag";
  public static final String BUTTON_IMG = "/grnds-docs/images/shared/btnLaunch.gif";
  public static final String PERSON_ID = "ulIdPerson";
  public static final String HIDDEN_PARAMETERS = "hiddenParameters";

  private int tabIndex;
  private List docList;
  private long personId;
  private String onClick = null;
  //private String confirm;

  public BaseDocListTag() {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    docList = new ArrayList();
    GrndsTrace.exitScope();
  }

  public void setTabIndex(int index) {
    this.tabIndex = index;
  }

  public int getTabIndex() {
    return this.tabIndex;
  }

  public void setPersonId(String id) throws JspException {
    try {
      setPersonId(Long.parseLong(id));
    } catch (NumberFormatException e) {
      throw new JspException("Invalid value entered for personId field: " + id, e);
    }
  }

  public void setPersonId(long id) {
    personId = id;
  }

  public void setOnClick(String onClick) {
    this.onClick = onClick;
  }

  public void setDocList(Collection list) {
    docList = new ArrayList(list);
  }

  public void addDoc(DocTagInterface dct) {
    GrndsTrace.enterScope(TRACE_TAG + ".addDoc(" + dct + ")");
    docList.add(dct);
    GrndsTrace.exitScope();
  }

  public long getPersonId() {
    return personId;
  }

  public String getOnClick() {
    return this.onClick;
  }

  public List getDocList() {
    return docList;
  }

  public String getDoc(int index) {
    return (String) docList.get(index);
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    GrndsTrace.exitScope();
    return Tag.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");

    JspWriter out = pageContext.getOut();

    try {
      out.println(this.startHTML());
      out.println(this.bodyHTML());
      out.println(this.endHTML());
    } catch (IOException e) {
      throw new JspException("Exception generating " + TRACE_TAG + ".", e);
    } catch (NullPointerException npe) {
      try {
        out.println("NullPointerException in " + TRACE_TAG);
      } catch (IOException e) {
      }
    }

    GrndsTrace.exitScope();
    return Tag.EVAL_PAGE;
  }

  public String startHTML() {
    GrndsTrace.enterScope(TRACE_TAG + ".startHTML");
    StringBuffer s = new StringBuffer("");
    Iterator i = docList.iterator();
    s.append(
            "<table border=\"0\"><tr><td valign=\"middle\"><label class=\"formLabel\">Reports:</label></td><td valign=\"middle\"><form name=\"");
    s.append(this.getFormName());
    s.append("\" class=\"nomargins\" action=\"");
    s.append(this.getDestination());
    s.append("\" method=\"post\">\n");
    if (!i.hasNext()) {
      s.append("<select name=\"");
      s.append(this.getSelectName());
      s.append("\"" + " tabindex=\"");
      s.append(getTabIndex());
      s.append("\" disabled>");
      s.append("<option selected value=\"\">No ");
      s.append(this.getTextUpper());
      s.append(" Available</option>\n");
    } else {
      s.append("<select name=\"");
      s.append(this.getSelectName());
      s.append("\"" + " tabindex=\"");
      s.append(getTabIndex());
      s.append("\" >\n");
      s.append("<option selected value=\"\"></option>\n");
    }
    GrndsTrace.exitScope();
    return s.toString();
  }

  public String bodyHTML() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".bodyHTML");
    DocTagInterface doc;
    StringBuffer s = new StringBuffer("");
    try {
      for (Iterator i = docList.iterator(); i.hasNext();) {
        doc = (DocTagInterface) i.next();
        GrndsTrace.msg(TRACE_TAG + ".bodyHTML", 7, "DocumentClass=" + doc.toString());
        s.append("<option value=\"");
        s.append(doc.getDataString());
        s.append("&ulIdPerson=");
        s.append(this.getPersonId());
        s.append("\">");
        s.append(doc.getFullName());
        s.append("</option>\n");
      }
    } catch (Exception e) {
      String st = gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException.getStackTrace(e);
      GrndsTrace.msg(TRACE_TAG + ".getQueryString", 7, st);
    }
    GrndsTrace.exitScope();
    return s.toString();
  }

  public String endHTML() {
    GrndsTrace.enterScope(TRACE_TAG + ".endHTML");
    StringBuffer s = new StringBuffer("");
    Iterator i = docList.iterator();

    s.append("</select>\n");
    s.append("<input type=\"hidden\" name=\"" + HIDDEN_PARAMETERS + "\" value=\"\">\n");
    s.append("</form>\n");

    //s.append("</td>\n<td>&nbsp;&nbsp;<a href=\"javascript:generate" + getTextUpper() + "()\""
    //         + " tabindex=\"" + getTabIndex() + "\" >");
    s.append("</td>\n<td>&nbsp;&nbsp;<a tabindex=\"").append(getTabIndex()).append("\"");
//    s.append(" onClick=\"javascript:");
    s.append(" href=\"javascript:var launch = true;");
    //if ( this.getConfirm() != null )
    //{
    // s.append( "launch = confirm( " + this.getConfirm() + " ); " );
    //}
    if (this.getOnClick() != null) {
      s.append("launch = ").append(this.getOnClick()).append("; ");
    }
    s.append("generate").append(getTextUpper()).append("( launch );\" >");
    s.append("<img onClick=\"setIsDirtyCalled(true);\"");
    s.append(" src=\"");
    s.append(BUTTON_IMG);
    s.append("\" alt=\"Launch\" class=\"md\" border=\"0\" ></a></td>\n</tr>\n</table>\n");
    s.append("<script language=\"JavaScript\">\n");
    s.append("  function generate").append(this.getTextUpper()).append("( launch )\n");
    s.append("  {\n");
    s.append("   if ( launch != false ) {\n");
    s.append("    var queryString = document.").append(this.getFormName()).append(".").append(getSelectName()).append(
            ".value;\n");
    s.append("    var hiddenParms = document.").append(this.getFormName()).append(
            "." + HIDDEN_PARAMETERS + ".value;\n");
    s.append("    if ( queryString == \"\" )\n");
    s.append("    {\n");
    s.append("      alert(\"Select a ").append(this.getTextLower()).append(
            " from the list before attempting to launch a ").append(getTextLower()).append(".\");\n");
    s.append("    }\n");
    s.append("    else if ( hiddenParms != \"\" ) \n");
    s.append("    {\n");
    s.append("      if ( queryString != \"\" ) \n");
    s.append("      {\n");
    s.append("        queryString += \"&\";\n");
    s.append("      }\n");
    s.append("      queryString += \"" + HIDDEN_PARAMETERS +
             "\" + \"=\" + hiddenParms;\n");
    s.append("    }\n");
    s.append("    if ( queryString != \"\" ) \n");
    s.append("    {\n");
    s.append("      var location = \"").append(this.getDestination()).append("\" + queryString;\n");
    // launchSubWindow is a custom javascript function found in impact.js
    s.append("      location = encodeURI( location );\n");
    s.append("      launchSubWindow( location );\n");
    s.append("     }\n");
    s.append("    }\n");
    s.append("   }\n");
    s.append("  function set").append(this.getTextUpper()).append("Parameters(name, val)\n");
    s.append("  {\n");
    s.append("    document.").append(this.getFormName()).append(
            "." + HIDDEN_PARAMETERS + ".value = name+\",\"+val;\n");
    s.append("  }\n");
    s.append("  function add").append(this.getTextUpper()).append("Parameter(name, val)\n");
    s.append("  {\n");
    s.append("    document.").append(this.getFormName()).append(
            "." + HIDDEN_PARAMETERS + ".value += \";\" + name+\",\"+val;\n");
    s.append("  }\n");
    s.append("</script>\n");
    GrndsTrace.exitScope();
    return s.toString();
  }
}
